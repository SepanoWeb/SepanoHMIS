/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisSessions = {
    tableName: "Sessions",
    f_id: "id",
    loadForm: function () {
        if ($("#swSessionsForm").html() == '') {
            $("#swSessionsForm").load("formHMIS/05OneSession.html", null, function () {
                new jj("#sessions_nextSessionDate").jjCalendarWithYearSelector(1397, 1420);
                new jj('#sendFilesSessions').jjAjaxFileUploadTitleUploadFiles('#attachFileSessions', '#sessions_file', 'sessions_titleFile1', '#sessions_filesTitle', "#inputTextSelectorSessionsDiv");
                new jj('#sendFilesApproved').jjAjaxFileUploadTitleUploadFiles('#attachFileApproved', '#approved_file', 'approved_titleFile1', '#approved_filesTitle', "#inputApprovedFileDiv");
                new jj('#sendFilesApprovedPrevious').jjAjaxFileUploadTitleUploadFiles('#attachFileApprovedPrevious', '#approved_fileCheckOut', 'approvedPrevious_titleFile1', '#approvedPrevious_filesTitle', "#inputFileApprovedPreviousDiv");
                $('#sessions_agendaSessions').summernote();
                hmisSessions.m_refresh();
            });
        }
                hmisRole.getSelectOption("#swSessionsForm #sessions_communicatorRoleId");
                hmisRole.getSelectOption("#swSessionsForm #approved_executorRoleId");
                cmsUser.getSelectOption("#swSessionsForm  #approved_executorUserId");
                hmisRole.getSelectOption("#swSessionsForm #approved_trackerId");
               
                $("#approved_executorRoleId").select2({
                    minimumResultsForSearch: '',
                    width: '100%'
                });
                $("#approved_executorUserId").select2({
                    minimumResultsForSearch: '',
                    width: '100%'
                });
                $("#approved_trackerId").select2({
                    minimumResultsForSearch: '',
                    width: '100%'
                });
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swSessionsTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },
    /**
     * آرشیو صورت جلسه
     * @param {type} containerId
     * @param {type} sortField
     * @param {type} tableHeight
     * @returns {undefined}
     */
    archivesSessionsRefresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".archivesSessionsRefresh";
        param += "&panel=" + (containerId == null ? "swArchivesSessionsTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },
    m_show_form: function () {
        $('#swSessionsTbl').hide();
        $('#swSessionsForm').show();
        hmisSessions.tabSizeForm();
    },
    m_clean: function () {

        $('#inputTextSelectorSessionsDiv').html("");
        $('#inputApprovedFileDiv').html("");
        $('#filesDownloadDiv').html("");
    },
    m_add_new: function () {
        jj("do=" + hmisSessions.tableName + ".add_new&jj=1").jjAjax2(false);
        hmisSessions.m_show_form();
        hmisSessions.m_clean();
    },
    m_show_tbl: function () {
        $('#swSessionsForm').hide();
        $('#swSessionsTbl').show();
        if ($('#swSessionsTbl').html() == "") {
            hmisSessions.m_refresh();
        }
//        hmisSessions.tabSizeTbl();
    },
    m_insert: function () {

        var flag = true;
        if ($("#sessions_communicatorRoleId").val() == "") {
            $("#sessions_communicatorRoleId").addClass("required");
            flag = false;
        } else {
            $("#sessions_communicatorRoleId").removeClass('required');
        }
        if (flag == true) {
            var param = "";
            param += "do=" + hmisSessions.tableName + ".insert";
            param += "&" + new jj('#swSessionsForm').jjSerial();
            new jj(param).jjAjax2(false);
            hmisSessions.m_show_tbl();
            hmisSessions.m_clean();
        }

    },
    m_edit: function () {
        var temp = $('#audience input:checkbox[class=checkboxAudience]:checked'); //مدعوین سمت دار نقش ها 
        var temp3 = $('#audience input:checkbox[class=checkboxAudienceOutSide]:checked'); //مدعوین خارج از سازمان
        var temp5 = $('#audience input:checkbox[class=checkboxAudienceInSide]:checked'); //مدعوین داخل سازمان ای دی یوزر
        var temp2 = "";
        var temp4 = "";
        var temp6 = "";
        for (var i = 0; i < temp.length; i++) {
            temp2 += $(temp[i]).attr('name') + "%23A%23"; //id user audience
//            temp2 +=$(temp[i]).val()+"%23A%23";
        }
        for (var i = 0; i < temp3.length; i++) {
//ایمیل مهمانان خارج از سازمان
            temp4 += $(temp3[i]).val() + "%23A%23";
        }
        for (var i = 0; i < temp5.length; i++) {
// مهمانان داخل  سازمان
            temp6 += $(temp5[i]).attr('name') + "%23A%23";
        }

        var flag = true;
        if ($("#sessions_communicatorRoleId").val() == "") {
            $("#sessions_communicatorRoleId").addClass("required");
            flag = false;
        } else {
            $("#sessions_communicatorRoleId").removeClass('required');
        }
        if (flag == true) {
            var param = "";
            param += "do=" + hmisSessions.tableName + ".edit";
            param += "&" + new jj('#swSessionsForm').jjSerial();
            param += "&id=" + new jj('#hmis_Sessions_id').jjVal();
            param += "&sessions_audience=" + temp2;
            param += "&sessions_audienceOutSide=" + temp4;
            param += "&sessions_audienceInSide=" + temp6;
            new jj(param).jjAjax2(false);
            hmisSessions.m_show_tbl();
            hmisSessions.m_clean();
        }

    },
//    m_validation: function () {// mohamdad
//        if (new jj("#content_title").jjVal().length < 1) {
//            return "فیلد عنوان نباید کوچکتر از دو کاراکتر باشد";
//        }
//        return "";
//    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo(' hmisSessions.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".delete";
        param += "&" + hmisSessions.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisSessions.m_show_tbl();
        hmisSessions.m_clean();
    },
    m_select: function (id) {
//          $("#insertApproved2").show();
        $("#addNewApproved").slideDown();
        $('#newCommetteForm').slideDown();
        $('#formInvitation').slideUp();
        $('#approvedPreviousDiv').slideUp();
        var param = "";
        param += "do=" + hmisSessions.tableName + ".select";
        param += "&" + hmisSessions.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisSessions.m_show_form();
    },
    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".add_EN";
        param += "&" + hmisSessions.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisSessions.f_parent).jjVal(id);
        new jj("#" + hmisSessions.f_lang).jjVal("2");
        hmisSessions.m_show_form();
    },
    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".add_Ar";
        param += "&" + hmisSessions.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisSessions.f_parent).jjVal(id);
        new jj("#" + hmisSessions.f_lang).jjVal("3");
        hmisSessions.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".add_lang";
        param += "&" + hmisSessions.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisSessions.f_parent).jjVal(id);
        new jj("#" + hmisSessions.f_lang).jjVal(langId);
//        alert(id+"&&&&&"+langId);
        hmisSessions.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".searchTags";
        param += "&" + new jj('#swSessionsForm').jjSerial();
//        param += "&panel=content_search_tags_result";
        new jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".insertTags";
        param += "&" + new jj('#swSessionsForm').jjSerial();
//        param += "&panel=content_tags_div";
        new jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swSessions').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swSessions').css('height', 378);
    },
    /////////////////////shiran2////////////
    /**
     * 
     * @param {type} id sessions
     * @returns {undefined}
     */
    confirmationFinalSessions: function (id) {

        var flag = true;
        if ($("#sessions_communicatorRoleId").val() == "") {
            $("#sessions_communicatorRoleId").addClass("required");
            flag = false;
        } else {
            $("#sessions_communicatorRoleId").removeClass('required');
        }
        if (flag == true) {

            var temp = $('#audience input:checkbox[class=checkboxAudience]:checked'); //مدعوین سمت دار
            var temp3 = $('#audience input:checkbox[class=checkboxAudienceOutSide]:checked'); //مدعوین خارج از سازمان
            if (temp.size() == 0) {
                new jj("حضار در جلسه را مشخص نمایید").jjModal("پیام سامانه");
            } else {
                if (confirm("آیا از تایید و امضا صورت جلسه اطمینان دارید؟")) {
                    hmisSessions.confirmationFinalSessions_after_question(id);
                } else {
                }
            }
        }
    },
    confirmationFinalSessions_after_question: function (id) {
        var temp = $('#audience input:checkbox[class=checkboxAudience]:checked'); //مدعوین سمت دار
        var temp3 = $('#audience input:checkbox[class=checkboxAudienceOutSide]:checked'); //مدعوین خارج از سازمان
        var temp5 = $('#audience input:checkbox[class=checkboxAudienceInSide]:checked'); //مدعوین خارج از سازمان
        var temp2 = "";
        var temp4 = "";
        var temp6 = "";
        for (var i = 0; i < temp.length; i++) {
            temp2 += $(temp[i]).attr('name') + "%23A%23"; //id user audience
        }
        for (var i = 0; i < temp5.length; i++) {
            temp6 += $(temp5[i]).attr('name') + "%23A%23"; //id user audience
        }
        for (var i = 0; i < temp3.length; i++) {
//ایمیل مهمانان خارج از سازمان
            temp4 += $(temp3[i]).val() + "%23A%23";
        }

        var param = "";
        param += "&do=" + hmisSessions.tableName + ".confirmationFinalSessions";
        param += "&" + new jj('#swSessionsForm').jjSerial();
        param += "&id=" + id;
        param += "&sessions_audience=" + temp2;
        param += "&sessions_audienceOutSide=" + temp4;
        param += "&sessions_audienceInSide=" + temp6;
        new jj(param).jjAjax2(false);
        hmisSessions.m_clean();
    },
    /**
     * ای دی ُجلسات
     * دکمه ارسال به مسئولین اجرا
     * @param {type} id
     * @returns {undefined}
     */
//    sendToTrackerAndExecutor: function (id) {
//
//        if (confirm("آیا مصوبات صورتجلسه به مسئولین ابلاغ شود؟")) {
//            hmisSessions.sendToTrackerAndExecutor_after_question(id);
//        } else {
//        }
//
//    },
//    sendToTrackerAndExecutor_after_question: function (id) {
//        var param = "";
//        param += "&id=" + id;
//        param += "&do=" + hmisSessions.tableName + ".sendToTrackerAndExecutor";
//        new jj(param).jjAjax2(false);
//        hmisSessions.m_clean();
//    },
    /**
     * مسئول اجرا یا نقش های مسئول اجرا
     * @param {type} value
     * @returns {undefined}
     */
    executorAction: function (value) {
        if (value == "سمت") {
            $("#approved_executorUserId").attr("disabled", "disabled");
            $("#approved_executorRoleId").removeAttr("disabled");
            $("#approved_executorUserId").val("");
            $("#approved_executorUserId").select2();
        } else if (value == "کاربران") {
            $("#approved_executorRoleId").attr("disabled", "disabled");
            $("#approved_executorUserId").removeAttr("disabled");
            $("#approved_executorRoleId").select2();
            $("#approved_executorRoleId").val("");
        }

    },
    m_remove: function (idUpload, id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisSessions.removeFile(" + idUpload + "," + id + ");");
    },
    removeFile: function (idUpload, sessionsId) {

        var param = "";
        param += "do=" + hmisSessions.tableName + ".removeFile";
        param += "&upload_id=" + idUpload;
        param += "&hmis_sessions_id=" + sessionsId;
        new jj(param).jjAjax2(false);
//        hmisSessions.m_show_tbl();
//        hmisSessions.m_clean();
    },
};
