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
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




var hmisUnreadMessages = {
    tableName: "UnreadMessages",
    f_id: "id",
    loadForm: function () {
        if ($("#swUnreadMessagesForm").html() == '') {
            $("#swUnreadMessagesForm").load("formHMIS/unreadMessages.html", null, function () {
                new jj('#unreadMessages_postageDate').jjCalendarWithYearSelector(1310, 1410);
                $("#cancel_UnreadMessages").on('click', function (e) {
//                   alert(1);
                    hmisUnreadMessages.m_clean();
                    hmisUnreadMessages.m_show_tbl();
                });


                new jj('#SendUnreadMessages').jjAjaxFileUploadTitleUploadFiles('#UnreadMessagesAttachFile', '#unreadMessages_attachFile', 'unreadMessages_titleFile', '#unreadMessages_attachFileTitle','.inputSelectorDiv');


                hmisUnreadMessages.selectOptionUserUnreadMessages("unreadMessages_receiver");

            });


        }
    },
    selectOptionUserUnreadMessages: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisMessenger.tableName + ".selectOptionUserUnreadMessages";

        new jj(param).jjAjax2(false);
    },
    sendMesseageToSignatory: function (userId, IdDocumentary) {
        var param = "";
        param += "&userId=" + userId;
        param += "&IdDocumentary=" + IdDocumentary;

        param += "&titleSign=" + $("#payam").parent().parent().find(".c").val();
        param += "&do=" + hmisUnreadMessages.tableName + ".sendMesseageToSignatory";
        param += "&jj=1";
        new jj(param).jjAjax2(false);

    },
  
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".refreshUnreadMessages";
        param += "&panel=" + (containerId == null ? "swUnreadMessagesTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisUnreadMessages.tabSizeTbl();
    },
    bazgasht: function () {
        hmisUnreadMessages.m_clean();
        hmisUnreadMessages.m_show_tbl();
    },
    m_add_new: function () {
        new jj("do=" + hmisUnreadMessages.tableName + ".add_new").jjAjax2(false);
        $('#messenger_receiver').val("null").trigger('change');
         $("#messenger_attachFileTitle").val("");
        $("#messenger_attachFile").val("");
        $('#status').hide();
        $('#logStatus').hide();
        $(".inputAfterSelectManager").html("");
        $(".inputSelectorDiv").html("");
        hmisUnreadMessages.m_show_form();
        hmisUnreadMessages.m_clean();



        //
//        part_content_editor = new jj('#department_publicContent').jjEditor();
//        part_praivate_editor = new jj('#department_praivateContent').jjEditor();
//        cmsUser.m_getGroups();
    },
    m_show_form: function () {
        $('#swUnreadMessagesTbl').hide();
        $('#swUnreadMessagesForm').show();
        if ($('#swUnreadMessagesTbl').html() == "") {
            hmisUnreadMessages.m_refresh();
        }
        hmisUnreadMessages.tabSizeForm();
    },
    m_clean: function () {
        new jj("#swUnreadMessagesForm").jjFormClean();
        $("#messenger_receiver").val('').trigger('change');

    },
    m_show_tbl: function () {
        $('#swUnreadMessagesTbl').show();
        $('#swUnreadMessagesForm').hide();
        if ($('#swUnreadMessagesTbl').html() == "") {
            hmisUnreadMessages.m_refresh();
        }
        hmisUnreadMessages.m_refresh();
        hmisUnreadMessages.tabSizeTbl();
    },
    m_insert: function () {

        var param = "";
        param += "do=" + hmisUnreadMessages.tableName + ".insert";
        param += "&" + new jj("#swUnreadMessagesForm").jjSerial();

        param += "&jj=1";
        param += "&messenger_receiver=" + $("#unreadMessages_receiver option:selected").val();
        new jj(param).jjAjax2(false);

        hmisUnreadMessages.m_show_tbl();
        hmisUnreadMessages.m_clean();
    },
    m_edit: function () {
        var param = "";
        param += "&do=" + hmisMessenger.tableName + ".edit";

        param += "&" + new jj("#swUnreadMessagesForm").jjSerial();
        param += "&jj=1";
        param += "&messenger_receiver=" + $("#unreadMessages_receiver option:selected").val();
        new jj(param).jjAjax2(false);
        $(".inputSelectorDiv").html('');
        

        $(".inputAfterSelectManager").html("");
        hmisUnreadMessages.m_show_tbl();
        hmisUnreadMessages.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisUnreadMessages.m_delete_after_question(" + id + ");");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".delete";
        param += "&" + hmisMessenger.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisUnreadMessages.m_show_tbl();
        hmisUnreadMessages.m_clean();
    },
    m_remove: function (idUpload, id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisUnreadMessages.removeFile(" + idUpload + "," + id + ");");
    },
    removeFile: function (idUpload, id) {

        var param = "";
        param += "do=" + hmisUnreadMessages.tableName + ".removeFile";
        param += "&upload_id=" + idUpload;
        param += "&messenger_id=" + id;
        new jj(param).jjAjax2(false);
        hmisUnreadMessages.m_show_tbl();
        hmisUnreadMessages.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".selectUnreadMessages";
        param += "&" + hmisMessenger.f_id + "=" + (id == null ? "" : id);
        $('#status').show();
        $('#logStatus').show();
        $(".inputSelectorDiv").html("");
        $(".inputAfterSelectManager").html("");
       
//        $('#UserSelectOption').trigger('change');

        new jj(param).jjAjax2(false);



        hmisUnreadMessages.m_show_form();


    },
    m_getMenu: function () {
        var param = "";
        param += "do=" + hmisUnreadMessages.tableName + ".getMenu";
        new jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swUnreadMessages').css('height', 515);
        hmisUnreadMessages.heightTab = 515;
    },
    tabSizeForm: function () {
        $('#swUnreadMessages').css('height', 270);
        hmisUnreadMessages.heightTab = 270;
    },
    heightTab: "515",
    mainTabSetSize: function () {
        $('#swUnreadMessages').css('height', hmisUnreadMessages.heightTab);
    },
}




