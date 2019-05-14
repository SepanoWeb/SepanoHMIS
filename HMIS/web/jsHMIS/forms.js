/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisForms = {
    tableName: "Forms",
    f_id: "id",
    loadForm: function () {
        if ($("#swFormsForm").html() == '') {
//        if (true) {
            $("#swFormsForm").load("formHMIS/02newForm.html", null, function () {

                $('.summernote').summernote({height: 150});///برای تبدیل شدن به textEditor
                new jj("#forms_creationDate").jjCalendarWithYearSelector(1340, 1420);
                $('#forms_creationTime').wickedpicker({
                    twentyFour: true
                });
                alert("hmisForms.loadForm();");
                new jj("#forms_expireDate").jjCalendarWithYearSelector(1340, 1420);
                $('#forms_expireTime').wickedpicker({
                    twentyFour: true
                });
                $("#formQuestions_answersType").val("select/option");//باید در فرم ست شود ولی عملا بعضی اوقات مقدار پیشفرض ست نمیشود
                hmisDepartment.selectOptionDepartment("forms_departments");
                new jj('#send_forms_icon').jjAjaxFileUpload2('forms_icon_file', '#forms_icon', '#forms_icon_Preview');
                new jj('#send_formQuestions_icon').jjAjaxFileUpload2('formQuestions_icon_file', '#formQuestions_icon', '#formQuestions_icon_Preview');
                new jj('#send_formQuestionOptions_icon').jjAjaxFileUpload2('formQuestionOptions_icon_file', '#formQuestionOptions_icon', '#formQuestionOptions_Preview');
                new jj('#formQuestions_weight').jjDigitOnly(10, 20);
                hmisRole.getSelectOption("#swFormsForm .roleSelectOption");// برای قرار گرفتن سلکت آپشن نقش ها در قسمت های مربوطه
                $(".roleSelectOption").select2({
                    width: '100%' 
                });
                cmsUser.getSelectOption("#swFormsForm .userSelectOption");// برای قرار گرفتن سلکت آپشن نقش ها در قسمت های مربوطه
                $(".userSelectOption").select2({
                    width: '100%' 
                });
                $("#forms_category_id").select2({
                    minimumResultsForSearch: '',
                    width: '100%'
                });
                $("#forms_departments").select2({
                    minimumResultsForSearch: '',
                    width: '100%'
                });
                $("#forms_accesseRoles").select2({
                    minimumResultsForSearch: '',
                    width: '100%'
                });
                hmisForms.m_refresh();
            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisForms.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swFormsTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += (tableHeight == null ? "" : "&height=" + tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisForms.m_show_tbl();
    },
    m_show_form: function () {
        $('#formQuestions').hide();//در حالت عادی فرم افزودن سوالات را نشان نمیدهیم
        $('#swFormsTbl').hide();
        $('#swFormsForm').show();
        hmisForms.tabSizeForm();
        hmisForms.m_clean();
    },
    m_clean: function () {
        new jj("#swFormsForm").jjFormClean();
        $("#swFormsForm .img-thumbnail").attr("src","img/preview.jpg");
        $("#swFormsForm select").val("");
        $("#swFormsForm select").select2({with:'100%'});
        
    },
    m_add_new: function () {
        new jj("do=" + hmisForms.tableName + ".add_new&jj=1").jjAjax2(false);
        hmisForms.m_show_form();
        $('#newCommetteForm').show();
        $('#formInvitation').hide();
        hmisForms.m_clean();
    },
    m_show_tbl: function () {
        $('#swFormsTbl').show();
         $('#swFormsTbl table').dataTable({//برای اینکه بعضی مواقع جدول در حالت رسپانسیو نمایش داده میشود
            destroy: true
        });
        $('#swFormsForm').hide();
        $('#formQuestions').hide();
    },
    m_insert: function () {
        var param = "";
        param += "do=" + this.tableName + ".insert";
        param += "&" + new jj('#swFormsForm').jjSerial();
        new jj(param).jjAjax2(false);

    },
    m_edit: function (id) {
        var param = "";
        param += "do=" + hmisForms.tableName + ".edit";
        param += "&" + new jj('#swFormsForm #newForm').jjSerial();
        new jj(param).jjAjax2(false);
        hmisForms.m_refresh();
        hmisForms.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟با حذف این فرم سوال ها و  گزینه های زیر مجموعه ی آن هم حذف می شود").jjDialog_YesNo(' hmisForms.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisForms.tableName + ".delete";
        param += "&" + hmisForms.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisForms.m_show_tbl();
        hmisForms.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisForms.tableName + ".select";
        param += "&" + hmisForms.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisForms.m_show_form();
        hmisForms.m_clean();
        $("#formQuestions").show();// در سلکت فرم افزودن سوالات را نسان میدهیم چون وقتی فرم نداریم نباید بتوانیم سوالی را ایجاد کنیم
        hmisFormQuestions.m_refresh(id);//ّبرای نشان دادن گزینه های این فرم
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swForms').css('height', "auto");
    },
    tabSizeForm: function () {
        $('#swCommettes').css('height', 378);
    },
    showMyForms: function (isAjax) {//مدعوین
        $("swMyFormsTbl").show();
        var param = "";
        param += "&do=" + hmisForms.tableName + ".showMyForms&jj=" + isAjax;
        new jj(param).jjAjax2(false);
    }
};