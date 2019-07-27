/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisApproved = {
    tableName: "Approved",
    f_id: "id",

    loadForm: function () {
        if ($("#swApprovedForm").html() == '') {
            $("#swApprovedForm").load("formHMIS/05approved.html", null, function () {
                new jj('#sendExecutorFilesApproved').jjAjaxFileUploadTitleUploadFiles('#attachExecutorFilesApproved', '#approved_filesExecutor', 'approved_titleFileExecutor', '#approved_filesTitleExecutor', "#showFilesExecutorDiv");
                new jj('#sendTrackerFilesApproved').jjAjaxFileUploadTitleUploadFiles('#attachTrackerFilesApproved', '#approved_filesTracker', 'approved_titleFileTracker', '#approved_filesTitleTracker', "#showFilesTrackerDiv");

//                new jj('#sendFilesApproved1').jjAjaxFileUpload4('attachFileApproved1', '#approved_fileOfResponsible', '#inputFileApprovedDiv'); //در این تابع خودمان پنل اینپوت را می فرستیم که فایل ها در آنجا نمایش داده شود 
                $("#cancel_Approved").click(function (e) {
                    hmisApproved.m_clean();
                    hmisApproved.m_show_tbl();
                });


                hmisApproved.m_refresh();


            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swApprovedTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },
    m_show_form: function () {
        $('#swApprovedTbl').slideUp();
        $('#swApprovedForm').slideDown();
        hmisApproved.tabSizeForm();
    },
    m_clean: function () {

        new jj("#insertApproved2 input:radio").jjFormClean();
        new jj("#approved_trackerId").jjVal("");
        new jj("#approved_executorUserId").jjVal("");
        new jj("#approved_executorRoleId").jjVal("");
        $("#inputTextSelectorDiv").html("");
        $("#inputDownloadDiv").html("");

    },
    m_add_new: function () {
        var param = "";
        $("#approved_executorUserId").attr("disabled", "disabled");

        $("#sessions_titleFile1").val("");
        $("#user_pic").val("");
        $("#inputApprovedFileDiv").html("");
        $("#approved_description").summernote();
        new jj("#approved_startDate").jjCalendarWithYearSelector(1340, 1420);
        new jj("#approved_endDate").jjCalendarWithYearSelector(1340, 1420);
        param += "&hmis_sessions_id=" + new jj("#hmis_sessions_id").jjVal();
        param += "&do=" + hmisApproved.tableName + ".add_new&jj=1";
        new jj(param).jjAjax2(false);
        hmisApproved.m_clean();
    },
    m_show_tbl: function () {
        $('#swApprovedTbl').slideDown();
        $('#swApprovedForm').slideUp();
        if ($('#swApprovedTbl').html() == "") {
            hmisApproved.m_refresh();
        }
        hmisApproved.tabSizeTbl();
    },
    m_insert: function () {
        var temp1 = "";
        var temp2 = "";
        var execturesRoleId = $('#approved_executorRoleId').val();
        var execturesUserId = $('#approved_executorUserId').val();
        var flag = true;
        if ($("#approved_trackerId").val() == "") {
            $("#approved_trackerId").addClass("required");
            flag = false;
        } else {
            $("#approved_trackerId").removeClass('required');
        }
        if ($("#approved_startDate").val() == "") {
            $("#approved_startDate").addClass("required");
            flag = false;
        } else {
            $("#approved_startDate").removeClass('required');
        }
        if ($("#approved_endDate").val() == "") {
            $("#approved_endDate").addClass("required");
            flag = false;
        } else {
            $("#approved_endDate").removeClass('required');
        }
        if ($("#approved_executorUserId").val() == "" && $("#approved_executorRoleId").val() == "") {
            $("#approved_executorUserId").addClass("required");
            $("#approved_executorRoleId").addClass("required");
            flag = false;
        } else {
            $("#approved_executorUserId").removeClass('required');
            $("#approved_executorRoleId").removeClass('required');
        }

        if (flag == true) {

            var param = "";
            param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
            if ($("input:radio[name=responsibleExecutor]:checked").val() == "سمت") {
                for (var i = 0; i < execturesRoleId.length; i++) {
                    temp2 += execturesRoleId[i] + "%23A%23"; //انتخاب چندین نفر وارسال ای دی افراد با جداساز
                }
                param += "&approved_executorRoleId=" + temp2;
                param += "&approved_executorUserId=";

            } else if ($("input:radio[name=responsibleExecutor]:checked").val() == "کاربران") {
                for (var i = 0; i < execturesUserId.length; i++) {
                    temp1 += execturesUserId[i] + "%23A%23"; //انتخاب چندین نفر وارسال ای دی افراد با جداساز
                }
                param += "&approved_executorRoleId=";
                param += "&approved_executorUserId=" + temp1;
            }

            param += "&do=" + hmisApproved.tableName + ".insert";
            param += "&" + new jj('#insertApproved2').jjSerial();
            new jj(param).jjAjax2(false);
            hmisApproved.m_show_tbl();
        }
    },
    m_edit: function () {
        var param = "";
        param += "&do=" + hmisApproved.tableName + ".edit";
        param += "&" + new jj('#swApprovedForm').jjSerial();
        new jj(param).jjAjax2(false);
        hmisApproved.m_show_tbl();
        hmisApproved.m_clean();
    },
    editInSessions: function () {

        var temp2 = "";
        var temp1 = "";

        /////////////////////////////////////////////
        var execturesRoleId = $('#approved_executorRoleId').val();
        var execturesUserId = $('#approved_executorUserId').val();
        if ($("input:radio[name=responsibleExecutor]:checked").val() == "سمت") {
            for (var i = 0; i < execturesRoleId.length; i++) {
                temp2 += execturesRoleId[i] + "%23A%23"; //انتخاب چندین نفر وارسال ای دی افراد با جداساز
            }
            param += "&approved_executorRoleId=" + temp2;
//            param += "&approved_executorUserId=";

        } else if ($("input:radio[name=responsibleExecutor]:checked").val() == "کاربران") {
            for (var i = 0; i < execturesUserId.length; i++) {
                temp1 += execturesUserId[i] + "%23A%23"; //انتخاب چندین نفر وارسال ای دی افراد با جداساز
            }
//            param += "&approved_executorRoleId=";
            param += "&approved_executorUserId=" + temp1;
        }


        /////////////////////////////////////////////
        var param = "";
        param += "&do=" + hmisApproved.tableName + ".editInSessions";
        param += "&" + new jj('#insertApproved2').jjSerial();
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
//        param += "&approved_executorRoleId=" + temp2;
//        param += "&approved_executorUserId=" + temp1;

        new jj(param).jjAjax2(false);
        hmisApproved.m_show_tbl();
        hmisApproved.m_clean();

    },
    editApprovedPrevious: function () {
//        var valid = hmisPlan.m_validation();
//        if (valid == "") {
        var param = "";
        param += "&do=" + hmisApproved.tableName + ".editApprovedPrevious";
        param += "&" + new jj('#approvedPreviousDiv').jjSerial();
        param += "&approvedId=" + new jj('#approvedPrevious_id').jjVal();
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
        new jj(param).jjAjax2(false);
        hmisApproved.m_show_tbl();
        hmisApproved.m_clean();
        $("#inputFileApprovedPreviousDiv").html("");



//        } else {
//            new jj(valid).jjDialog();
//        }
    },
//    m_validation: function () {// mohamdad
//        if (new jj("#content_title").jjVal().length < 1) {
//            return "فیلد عنوان نباید کوچکتر از دو کاراکتر باشد";
//        }
//        return "";
//    },
    /**
     * ای دی مصوبات
     * @param {type} id
     * @returns {undefined}
     */

    m_delete: function (id) {
//        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo(' hmisApproved.m_delete_after_question(' + id + ');\n', true, "");
        if (confirm("آیا از حذف این رکورد اطمینان دارید؟")) {
            hmisApproved.confirmationFinalApproved_after_question(id);
        } else {
        }
    },
    confirmationFinalApproved_after_question: function (id) {
        var param = "";
//        alert(new jj('#hmis_sessions_id').jjVal());
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
        param += "&do=" + hmisApproved.tableName + ".delete";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisApproved.m_show_tbl();
        hmisApproved.m_clean();
    },
    m_select: function (id) {
        $('#showFilesExecutorDiv').html("");
        $('#showFilesTrackerDiv').html("");
        $('#inputFileApprovedDiv').html("");
        new jj("#startDate").jjCalendarWithYearSelector(1340, 1420);
        new jj("#endDate").jjCalendarWithYearSelector(1340, 1420);
        var param = "";
        param += "do=" + hmisApproved.tableName + ".select";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisApproved.m_show_form();
    },
    /**
     *  انتخاب مصوبات در قسمت جلسات برای بررسی مصوبات قبلی این کمیته
     * @param {type} id
     * ای دی مصوبه انتخاب شده
     * @returns {undefined}
     */
    selectApprovedPrevious: function (id) {
        $('#approvedPreviousDiv').slideDown();
        new jj("#approvedPrevious_startDate").jjCalendarWithYearSelector(1340, 1420);
        new jj("#approvedPrevious_endDate").jjCalendarWithYearSelector(1340, 1420);
        var param = "";
        param += "do=" + hmisApproved.tableName + ".selectApprovedPrevious";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        $("#inputFileApprovedPreviousDiv").html("");

//        hmisApproved.m_show_form();
    },
    selectInSessions: function (id) {
        $("#inputApprovedFileDiv").html('');
        new jj("#approved_startDate").jjCalendarWithYearSelector(1340, 1420);
        new jj("#approved_endDate").jjCalendarWithYearSelector(1340, 1420);
//        $('#insertApproved2').slideDown();
        $("html, body").delay(1000).animate({scrollTop: $('#insertApproved2').offset().top}, 800);
        var param = "";
        param += "do=" + hmisApproved.tableName + ".selectInSessions";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
        new jj(param).jjAjax2(false);
        $("#approved_description").summernote();
//        hmisApproved.m_show_form();
    },
    /**
     * سلکت در جلسات ابلاغ شده من
     * @param {type} id
     * @returns {undefined}
     */
    selectInCommunicatedSessions: function (id) {
       

        new jj("#communicatedApproved_startDate").jjCalendarWithYearSelector(1340, 1420);
        new jj("#communicatedApproved_endDate").jjCalendarWithYearSelector(1340, 1420);
        $("html, body").delay(1000).animate({scrollTop: $('#insertApprovedCommunicated').offset().top}, 800);
        var param = "";
        param += "&do=" + hmisApproved.tableName + ".selectInCommunicatedSessions";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
        new jj(param).jjAjax2(false);

        $("#communicatedApproved_description").summernote();
//        hmisApproved.m_show_form();
    },
    /**
     * ابلاغ مصوبات وایجاد رکورد به تعداد مسئولین اجرا
     * @param {type} id
     * @returns {undefined}
     */
    communicatedApproved: function (id) {
        var param = "";
//        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
        param += "do=" + hmisApproved.tableName + ".communicatedApproved";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
//        hmisApproved.m_show_form();
    },

    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".add_EN";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisApproved.f_parent).jjVal(id);
        new jj("#" + hmisApproved.f_lang).jjVal("2");
        hmisApproved.m_show_form();
    },
    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".add_Ar";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisApproved.f_parent).jjVal(id);
        new jj("#" + hmisApproved.f_lang).jjVal("3");
        hmisApproved.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".add_lang";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisApproved.f_parent).jjVal(id);
        new jj("#" + hmisApproved.f_lang).jjVal(langId);
//        alert(id+"&&&&&"+langId);
        hmisApproved.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".searchTags";
        param += "&" + new jj('#swApprovedForm').jjSerial();
//        param += "&panel=content_search_tags_result";
        new jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".insertTags";
        param += "&" + new jj('#swApprovedForm').jjSerial();
//        param += "&panel=content_tags_div";
        new jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swApproved').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swApproved').css('height', 378);
    },

    /////////////////////shiran////////////
    /**
     * حذف نام فایل
     * @param {type} idUpload
     * @param {type} id
     * @returns {undefined}
     */
    m_remove: function (idUpload, approvedId, nameFile) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisApproved.removeFile(" + idUpload + "," + approvedId + "," + nameFile + ");");
    },
    removeFile: function (idUpload, approvedId, nameFile) {

        var param = "";
        param += "do=" + hmisApproved.tableName + ".removeFile";
        param += "&upload_id=" + idUpload;
        param += "&hmis_approved_id=" + approvedId;
        param += "&nameFile=" + nameFile;
        new jj(param).jjAjax2(false);

    },
    /**
     * زمانی که پیشنهادی به دبیر کمیته داده می شود می تواند آن را رد کند یا اینکه آن را به عنوان مصوبه بپذیرد
     * @param {type} id
     * @param {type} sessionsId
     * @returns {undefined}
     */
    actionIconAdd: function (id, sessionsId) {

        var param = "";
        param += "do=" + hmisApproved.tableName + ".addApproved";
        param += "&hmis_approved_id=" + id;
        param += "&sessionsId=" + sessionsId;
        new jj(param).jjAjax2(false);

    },
    /**
     * رد پیشنهاد برنامه عملیاتی
     * @param {type} id
     * @returns {undefined}
     */
    actionIconReject: function (id, sessionsId) {

        var param = "";
        param += "do=" + hmisApproved.tableName + ".rejectApproved";
        param += "&hmis_approved_id=" + id;
        param += "&sessionsId=" + sessionsId;

        new jj(param).jjAjax2(false);

    },

};