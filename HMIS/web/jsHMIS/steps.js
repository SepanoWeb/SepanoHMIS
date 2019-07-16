/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisSteps = {
    tableName: "Steps",
    f_id: "id",

    loadForm: function () {
        if ($("#swStepsForm").html() == '') {
            $("#swStepsForm").load("formHMIS/04Steps.html", null, function () {
//                                new jj('#sendFilesSteps1').jjAjaxFileUpload4('attachFileSteps1', '#Steps_fileOfResponsible', '#inputFileStepsDiv'); //در این تابع خودمان پنل اینپوت را می فرستیم که فایل ها در آنجا نمایش داده شود 
                new jj("#startDate").jjCalendarWithYearSelector(1370, 1420);
                new jj("#endDate").jjCalendarWithYearSelector(1370, 1420);
                new jj('#sendFiles').jjAjaxFileUploadTitleUploadFiles('#attachFileDocumentary', '#documentary_attachFileDocumentary', 'documentary_titleFile1', '#documentary_attachFileTitle1',"#");

                $("#cancel_Steps").click(function (e) {
                    hmisSteps.m_clean();
                    hmisSteps.m_show_tbl();
                });


            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swStepsTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },
    m_show_form: function () {
        $('#swStepsTbl').hide();
        $('#swStepsForm').show();
        hmisSteps.tabSizeForm();
    },
    m_clean: function () {

        $("#showFilesDiv").html("");
        $("#filesDownloadStepsDiv").html("");
    },
    m_add_new: function () {
        new jj("&do=" + hmisSteps.tableName + ".add_new").jjAjax2(false);
        $('#stepsForm').slideDown();
        hmisSteps.m_show_form();
        hmisSteps.m_clean();

    },
    m_show_tbl: function () {
        $('#swStepsTbl').show();
        $('#swStepsForm').hide();
        if ($('#swStepsTbl').html() == "") {
            hmisSteps.m_refresh();
        }
        hmisSteps.tabSizeTbl();
    },
    m_insert: function () {

        var param = "";
        param += "do=" + hmisSteps.tableName + ".insert";
        param += "&" + new jj('#stepsForm').jjSerial();
        param += "&hmis_plans_id=" + new jj("#hmis_plans_id").jjVal();
        new jj(param).jjAjax2(false);
        hmisSteps.m_show_tbl();
        hmisSteps.m_clean();
//        $("html, body").delay(1000).animate({scrollTop: $('#tblSteps').offset().top}, 800);


    },
    m_edit: function () {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".edit";
        param += "&" + new jj('#swStepsForm').jjSerial();
        new jj(param).jjAjax2(false);
        hmisSteps.m_show_tbl();
        hmisSteps.m_clean();
    },
    /**
     * ای دی گام 
     * مرحله ابلاغ گام توسط مدیر
     * @param {type} id
     * @returns {undefined}
     */
    communicatedSteps: function (id) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".communicatedSteps";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
    },

    m_delete: function (id) {
    if (confirm("آیا از حذف این رکورد اطمینان دارید؟")) {
           hmisSteps.m_delete_after_question(id);
        } else {
        }
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".delete";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisSteps.m_show_tbl();
        hmisSteps.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".select";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisSteps.m_show_form();
    },
    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".add_EN";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisSteps.f_parent).jjVal(id);
        new jj("#" + hmisSteps.f_lang).jjVal("2");
        hmisSteps.m_show_form();
    },
    //////////////////////////////////


    ////////////////////////////////////////////////
    /**
     * حذف فایل آپلود شده
     * @param {type} idUpload
     * @param {type} id
     * @returns {undefined}
     */
 m_remove: function (idUpload, id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisSteps.removeFile(" + idUpload + "," + id + ");");
    },
    removeFile: function (idUpload, stepsId) {

        var param = "";
        param += "do=" + hmisSteps.tableName + ".removeFile";
        param += "&upload_id=" + idUpload;
        param += "&hmis_steps_id=" + stepsId;
        new jj(param).jjAjax2(false);
//        hmisSessions.m_show_tbl();
//        hmisSessions.m_clean();
    },













    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".add_Ar";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisSteps.f_parent).jjVal(id);
        new jj("#" + hmisSteps.f_lang).jjVal("3");
        hmisSteps.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".add_lang";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisSteps.f_parent).jjVal(id);
        new jj("#" + hmisSteps.f_lang).jjVal(langId);
//        alert(id+"&&&&&"+langId);
        hmisSteps.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".searchTags";
        param += "&" + new jj('#swStepsForm').jjSerial();
        param += "&panel=content_search_tags_result";
        new jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".insertTags";
        param += "&" + new jj('#swStepsForm').jjSerial();
//        param += "&panel=content_tags_div";
        new jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swSteps').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swSteps').css('height', 378);
    }

};

//============ BY RASHIDI ========> 
function selectSearchResult(selectedTagNo) {
    $("#tags_name").val($("#tagsResult_td" + selectedTagNo).html());
    $("#content_search_tags_result").hide();
}

