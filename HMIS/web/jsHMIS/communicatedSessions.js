/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisCommunicatedSessions = {
    tableName: "",
    f_id: "id",
    loadForm: function () {
        if ($("#swCommunicatedSessionsForm").html() == '') {
            $("#swCommunicatedSessionsForm").load("formHMIS/05SessionCommunicated.html", null, function () {

                $("#cancel_CommunicatedSessions").click(function (e) {
                    hmisCommunicatedSessions.m_clean();
                    hmisCommunicatedSessions.m_show_tbl();
                });
                hmisCommunicatedSessions.m_refresh();

            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisSessions.tableName + ".refreshCommunicatedSessions";
        param += "&panel=" + (containerId == null ? "swCommunicatedSessionsTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },

    m_show_form: function () {
        $('#swCommunicatedSessionsTbl').slideUp('slow');
        $('#swCommunicatedSessionsForm').slideDown('slow');
        hmisCommunicatedSessions.tabSizeForm();
    },
    m_clean: function () {
        new jj("#" + hmisCommunicatedSessions.f_content_id).jjVal("");
        new jj("#" + hmisCommunicatedSessions.f_title).jjVal("");
        new jj("#" + hmisCommunicatedSessions.f_lang).jjVal("1");
        new jj("#" + hmisCommunicatedSessions.f_parent).jjVal("0");

    },

    m_show_tbl: function () {
        $('#swCommunicatedSessionsTbl').show();
        $('#swCommunicatedSessionsForm').hide();
        if ($('#swCommunicatedSessionsTbl').html() == "") {
            hmisCommunicatedSessions.m_refresh();
        }
        hmisCommunicatedSessions.tabSizeTbl();
    },
    m_select: function (id) {
        $("#addNewApproved").hide();
        var param = "";
        param += "do=" + hmisSessions.tableName + ".selectCommunicatedSessions";
        param += "&" + hmisSessions.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisCommunicatedSessions.m_show_form();
//        $("#insertApproved2").hide();
    },
    /**
     * ای دی ُجلسات
     * دکمه ارسال به مسئولین اجرا
     * @param {type} id
     * @returns {undefined}
     */
    sendToCommunicator: function (id) {
        if (confirm("آیا  صورتجلسه به ابلاغ کننده موردنظر ابلاغ شود؟")) {
            hmisCommunicatedSessions.sendToCommunicator_after_question(id);
        } else {
        }

    },
     /**
     * ای دی جلسه
     * @param {type} id
     * @returns {undefined}
     */
    sendToCommunicator_after_question: function (id) {
        var param = "";
        param += "&id=" + id;
        param += "&do=" + hmisSessions.tableName + ".sendToCommunicator";
        new jj(param).jjAjax2(false);
        hmisCommunicatedSessions.m_clean();
    },
    /**
     * رد کردن صورت جلسه
     * ای دی جلسه
     * @param {type} id
     * @returns {undefined}
     */
    ignore: function (id) {

        if (confirm("آیا  صورتجلسه رد شود؟")) {
            hmisCommunicatedSessions.ignore_after_question(id);
        } else {
        }

    },
    ignore_after_question: function (id) {
        var param = "";
        param += "&id=" + id;
        param += "&do=" + hmisSessions.tableName + ".ignore";
        new jj(param).jjAjax2(false);
        hmisCommunicatedSessions.m_clean();
    },
    /**
     * ای دی جلسات 
     * ای دی فرد امضا کننده
     * امضای کردن صورتجلسه
     * @returns {undefined}
     */
//    actionSigners: function (sessionsId, userId) {
//alert(';;;;;;;;;;;;;;;;;;;;;;;;;;');
//        var param = "";
//        param += "do=" + hmisSessions.tableName + ".actionSigners";
//        param += "&" + hmisSessions.f_id + "=" + (id == null ? "" : id);
//        param += "&hmis_sessions_id="+sessionsId;
//        param += "&userId="+userId;
//        new jj(param).jjAjax2(false);
//        hmisSessions.m_show_form();
//    },

    tabSizeTbl: function () {
        $('#swCommunicatedSessions').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swCommunicatedSessions').css('height', 378);
    },

};
