/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var hmisMessenger = {
    tableName: "Messenger",
    f_id: "id",

    loadForm: function () {
        if ($("#swMessengerForm").html() == '') {
            $("#swMessengerForm").load("formHMIS/messenger.html", null, function () {
                new jj('#messenger_postageDate').jjCalendarWithYearSelector(1310, 1410);
                $("#cancel_Messenger").on('click', function (e) {
//                   alert(1);
                    hmisMessenger.m_clean();
                    hmisMessenger.m_show_tbl();
                });





            });



        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swMessengerTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        jj(param).jjAjax2(false);
        hmisMessenger.tabSizeTbl();
    },
    bazgasht: function () {
        hmisMessenger.m_clean();
        hmisMessenger.m_show_tbl();
    },
    m_add_new: function () {
        jj("do=" + hmisMessenger.tableName + ".add_new").jjAjax2(false);

        hmisMessenger.m_show_form();
        hmisMessenger.m_clean();



        //
//        part_content_editor = new jj('#department_publicContent').jjEditor();
//        part_praivate_editor = new jj('#department_praivateContent').jjEditor();
//        cmsUser.m_getGroups();
    },
    m_show_form: function () {
        $('#swMessengerTbl').hide();
        $('#swMessengerForm').show();
        if ($('#swMessengerTbl').html() == "") {
            hmisMessenger.m_refresh();
        }
        hmisMessenger.tabSizeForm();
    },
    m_clean: function () {
        new jj("#swMessengerForm").jjFormClean();

    },
    m_show_tbl: function () {
        $('#swMessengerTbl').show();
        $('#swMessengerForm').hide();
        if ($('#swMessengerTbl').html() == "") {
            hmisMessenger.m_refresh();
        }
        hmisMessenger.m_refresh();
        hmisMessenger.tabSizeTbl();
    },
    m_insert: function () {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".insert";
        param += "&" + new jj("#swMessengerForm").jjSerial();

        param += "&jj=1";

        jj(param).jjAjax2(false);
        hmisMessenger.m_show_tbl();
        hmisMessenger.m_clean();
    },
    m_edit: function () {
        var param = "";
        param += "&do=" + hmisMessenger.tableName + ".edit";

        param += "&" + new jj("#swMessengerForm").jjSerial();
        param += "&jj=1";

        jj(param).jjAjax2(false);
        hmisMessenger.m_show_tbl();
        hmisMessenger.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisMessenger.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".delete";
        param += "&" + hmisMessenger.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        hmisMessenger.m_show_tbl();
        hmisMessenger.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".select";
        param += "&" + hmisMessenger.f_id + "=" + (id == null ? "" : id);



        jj(param).jjAjax2(false);



        hmisMessenger.m_show_form();


    },

    m_getMenu: function () {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".getMenu";
        jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swMessenger').css('height', 515);
        hmisMessenger.heightTab = 515;
    },
    tabSizeForm: function () {
        $('#swMessenger').css('height', 270);
        hmisMessenger.heightTab = 270;
    },
    heightTab: "515",
    mainTabSetSize: function () {
        $('#swMessenger').css('height', hmisMessenger.heightTab);
    },

}


