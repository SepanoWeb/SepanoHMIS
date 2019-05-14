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
                new jj('#sendFilesApproved').jjAjaxFileUpload4('attachFileApproved', '#approved_fileOfResponsible', '#inputFileApprovedDiv'); //در این تابع خودمان پنل اینپوت را می فرستیم که فایل ها در آنجا نمایش داده شود 

                $("#cancel_Approved").button().click(function (e) {
                    hmisApproved.m_clean();
                    hmisApproved.m_show_tbl();
                });



//                $("#upload_Content_file").button().click(function () {
//                });
                //============ BY RASHIDI ========>
//                $("#content_insert_tags").button().click(function (e) {
//                    $("#" + cmsContent.f_tags).val($("#" + cmsContent.f_tags).val() + $("#tags_name").val() + ',');//تگ نوشته شده را به یک اینپوت مخفی اضافه می کند
//                   cmsContent.m_insertTags();
//
//                });
//               $('#tags_name').keyup(function () {
//                    if ($("#tags_name").val() === "") {
//                       $("#content_search_tags_result").hide();
//                   }
//                   cmsContent.m_searchTags();
//               });
                hmisApproved.m_refresh();
//                $('#newCommetteForm').show();
//                $('#formInvitation').hide();


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
        $('#swApprovedTbl').hide();
        $('#swApprovedForm').show();
        hmisApproved.tabSizeForm();
    },
    m_clean: function () {
        new jj("#" + hmisApproved.f_content_id).jjVal("");
        new jj("#" + hmisApproved.f_title).jjVal("");
        new jj("#" + hmisApproved.f_lang).jjVal("1");
        new jj("#" + hmisApproved.f_parent).jjVal("0");
        new jj("#insertApproved2").jjFormClean();
        new jj("#approved_trackerId").jjVal("");
        new jj("#approved_executorId").jjVal("");
        $("#inputTextSelectorDiv").html("");

    },
    m_add_new: function () {
        var param = "";
        $("#approved_status").val("در حال انجام");
        $("#approved_status").attr("disabled", "disabled");
        new jj("#approved_startDate").jjCalendarWithYearSelector(1340, 1420);
        new jj("#approved_endDate").jjCalendarWithYearSelector(1340, 1420);
        param += "&hmis_sessions_id=" + new jj("#hmis_sessions_id").jjVal();
        param += "&do=" + hmisApproved.tableName + ".add_new&jj=1";
        new jj(param).jjAjax2(false);
        hmisApproved.m_clean();
//        hmisApproved.m_show_form();
//                $('#newCommetteForm').show();
//                $('#formInvitation').hide();

        //        oEditor.execCommand( 'bold');

    },
    m_show_tbl: function () {
        $('#swApprovedTbl').show();
        $('#swApprovedForm').hide();
        if ($('#swApprovedTbl').html() == "") {
            hmisApproved.m_refresh();
        }
        hmisApproved.tabSizeTbl();
    },
    m_insert: function () {
//        var valid =  hmisApproved.m_validation();
//        if (valid == "") {
        $("#inputTextSelectorDiv").html("");
        var param = "";
        param += "&do=" + hmisApproved.tableName + ".insert";
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
//        var temp = $("#inputTextSelectorDiv input");
//        var attachedFile = "";
//        for (var i = 0; i < temp.length; i++) {
//            attachedFile += $(temp[i]).val() + "%23A%23";
//        }
//        param += "&approved_file=" + attachedFile;
        param += "&" + new jj('#insertApproved2').jjSerial();
        new jj(param).jjAjax2(false);
        hmisApproved.m_show_tbl();
        hmisApproved.m_clean();
//        } else {
//            new jj(valid).jjDialog();
//        }
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
//        var valid = hmisPlan.m_validation();
//        if (valid == "") {
        var param = "";
        param += "&do=" + hmisApproved.tableName + ".editInSessions";
        param += "&" + new jj('#insertApproved2').jjSerial();
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
        new jj(param).jjAjax2(false);
        hmisApproved.m_show_tbl();
        hmisApproved.m_clean();
//        } else {
//            new jj(valid).jjDialog();
//        }
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
        new jj("#approved_startDate").jjCalendarWithYearSelector(1340, 1420);
        new jj("#approved_endDate").jjCalendarWithYearSelector(1340, 1420);
        $('#insertApproved2').slideDown();
        $("html, body").delay(1000).animate({scrollTop: $('#insertApproved2').offset().top}, 800);
        var param = "";
        param += "do=" + hmisApproved.tableName + ".selectInSessions";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
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
    };