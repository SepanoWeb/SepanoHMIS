/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisFormAnswerSets = {
    tableName: "FormAnswerSet",
    f_id: "id",
    loadForm: function (id) {
//        if ($("#swMyFormsForm").html() == '') {
        if (true) {
            $("#swMyFormsForm").load("formHMIS/02newFormAnswer.html", null, function () {
                alert("hmisFormAnswerSets.loadForm();");
//                $('.summernote').summernote({ height: 150});///برای تبدیل شدن به textEditor
//                new jj("#forms_creationDate").jjCalendarWithYearSelector(1340, 1420);
//                $('#forms_creationTime').wickedpicker({
//                    twentyFour: true
//                });
//                new jj("#forms_expireDate").jjCalendarWithYearSelector(1340, 1420);
//                $('#forms_expireTime').wickedpicker({
//                    twentyFour: true
//                });
//                $("#formQuestions_answersType").val("select/option");//باید در فرم ست شود ولی عملا بعضی اوقات مقدار پیشفرض ست نمیشود
//                hmisDepartment.selectOptionDepartment("forms_departments");
//                new jj('#send_forms_icon').jjAjaxFileUpload2('forms_icon_file', '#forms_icon', '#forms_icon_Preview');
//                new jj('#send_formQuestions_icon').jjAjaxFileUpload2('formQuestions_icon_file', '#formQuestions_icon', '#formQuestions_icon_Preview');
//                new jj('#send_formQuestionOptions_icon').jjAjaxFileUpload2('formQuestionOptions_icon_file', '#formQuestionOptions_icon', '#formQuestionOptions_Preview');
//                new jj('#formQuestions_weight').jjDigitOnly(10,20);
//                $("#forms_category_id").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
//                $("#forms_departments").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
                hmisFormAnswerSets.refreshMyAnswers(id,"swOneFormToCompleteTable");// وقتی فرم لود می شود جدول سوابق پاسخ ها را هم بیاورد
            });
        }
    },
    /**
      * علاوه بر نمایش جدول پاسخ هایی که کاربر به این فرم داده است دکمه ی تکمیل فرم جدید را هم می آورد
     * @param {type} formId
     * @param {type} containerId
     * @returns {undefined}
     */
    refreshMyAnswers: function (formId, containerId) {
        if ($("#swMyFormsForm").html() == '') {// برای اینکه اگر فرم قبلش لود نشده باشد نمی شود جدول را نشان بدهیم و برای جلوگیری از تکرار اضافی رفرش انسر های من
            hmisFormAnswerSets.loadForm(formId);
            return ;
        }
        var param = "";
        param += "do=" + hmisFormAnswerSets.tableName + ".refreshMyAnswers";
        param += "&formAnswers_formId=" + formId;
        param += "&panel=" + (containerId == null ? "swOneFormToCompleteTable" : containerId);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisFormAnswerSets.m_show_form();
    },    
    /**
      * نمایش یک مودال برای رفرش کردن لیست پاسخ های کاربر به یک فرم خاص
      * برای اینکه تکمیل فرم در صفحه ی دیگری انجام میشود و بعد از تکمیل جدول فرم های تکمیل شده در صفحه ی قبل بدون تغییر باقی میماند
     * @param {type} formId
     * @param {type} containerId
     * @returns {undefined}
     */
    refreshMyAnswersAfterQuestion: function (formId) {
        new jj("لیست پاسخ های شما تازه سازی بشود ؟").jjModal_Yes_No("آیا فرم شما با موفقیت ثبت شد?" , 'hmisFormAnswerSets.refreshMyAnswers('+formId+');');
    },    
        /**
     * این تابع جدولی از فرم هایی که تا کنون پر شده را می آورد و میتوانیم جدید یکی پر کنیم 
     * @param {type} formId
     * @param {type} containerId
     * @returns {undefined}
     */
    showMyForms: function (containerId) {
        var param = "";
        param += "do=" + hmisFormAnswerSets.tableName + ".showMyForms";
        param += "&panel=" + (containerId == null ? "swMyFormsTbl" : containerId);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisFormAnswerSets.m_show_tbl();
    },
    m_show_form: function () {
        $('#swMyFormsTbl').slideUp('slow');
        $('#swMyFormsForm').slideDown('slow');
    },
    m_clean: function () {
        new jj("#swOneFormToCompleteForm").jjFormClean();
    },
    m_add_new: function (formId) {
         var param = "";
        param += "do=" + hmisFormAnswerSets.tableName + ".add_new&jj=1";
        param += "&formAnswers_formId=" + formId;
        new jj(param).jjAjax2(false);
        hmisFormAnswerSets.m_show_form();
        $('#swOneFormToCompleteForm').slideDown();
        hmisFormAnswerSets.m_clean();
    },
    m_show_tbl: function () {
        $('#swMyFormsTbl').show();
        $('#swMyFormsForm').hide();
        $('#formQuestions').hide();
    },
    m_insert: function () {
        var param = "";
        param += "do=" + this.tableName + ".insert";
        param += "&" + new jj('#swOneFormToCompleteForm').jjSerial();
        new jj(param).jjAjax2(false);

    },
    m_edit: function (id) {
        var param = "";
        param += "do=" + hmisFormAnswerSets.tableName + ".edit";
        param += "&" + new jj('#swOneFormToCompleteForm #newForm').jjSerial();
        new jj(param).jjAjax2(false);
        this.m_show_tbl();
        this.m_clean();
    },

    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟با حذف این فرم سوال ها و  گزینه های زیر مجموعه ی آن هم حذف می شود").jjDialog_YesNo(' hmisFormAnswerSets.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisFormAnswerSets.tableName + ".delete";
        param += "&" + hmisFormAnswerSets.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisFormAnswerSets.m_show_tbl();
        hmisFormAnswerSets.m_clean();
    },
    m_select: function (id) {     
        var param = "";
        param += "do=" + hmisFormAnswerSets.tableName + ".select";
        param += "&" + hmisFormAnswerSets.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisFormAnswerSets.m_show_form();
        $("#formQuestions").show();// در سلکت فرم افزودن سوالات را نسان میدهیم چون وقتی فرم نداریم نباید بتوانیم سوالی را ایجاد کنیم
        hmisFormQuestions.m_refresh(id);//ّبرای نشان دادن گزینه های این فرم
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swForms').css('height', "auto");
    },
    tabSizeForm: function () {
        $('#swCommettes').css('height', 378);
    }
};