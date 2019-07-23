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




var hmisMessages = {
    tableName: "Messages",
    f_id: "id",
    loadForm: function () {
        if ($("#swMessagesForm").html() == '') {
            $("#swMessagesForm").load("formHMIS/messages.html", null, function () {
                new jj('#messages_postageDate').jjCalendarWithYearSelector(1310, 1410);
                $("#cancel_Messages").on('click', function (e) {
//                   alert(1);
                    hmisMessages.m_clean();
                    hmisMessages.m_show_tbl();
                });


                new jj('#sendMessages').jjAjaxFileUploadTitleUploadFiles('#MessagesAttachFile', '#messagesSeen_attachFile', 'messagesSeen_titleFile', '#messagesSeen_attachFileTitle');


                hmisMessages.selectOptionUserMessages("messages_receiver");

            });


        }
    },
    selectOptionUserMessages: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisMessenger.tableName + ".selectOptionUserMessages";

        new jj(param).jjAjax2(false);
    },
    sendMesseageToSignatory: function (userId, IdDocumentary) {
        var param = "";
        param += "&userId=" + userId;
        param += "&IdDocumentary=" + IdDocumentary;

        param += "&titleSign=" + $("#payam").parent().parent().find(".c").val();
        param += "&do=" + hmisMessages.tableName + ".sendMesseageToSignatory";
        param += "&jj=1";
        new jj(param).jjAjax2(false);

    },
  
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".refreshMessages";
        param += "&panel=" + (containerId == null ? "swMessagesTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisMessages.tabSizeTbl();
    },
    m_refreshMessagesAll: function (containerId, sortField, tableHeight) {
//        $("#AllMessenger").slideDown();
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".refreshMessagesAll";
        param += "&panel=" + (containerId == null ? "swMessagesTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisMessages.tabSizeTbl();
    },
    bazgasht: function () {
        hmisMessages.m_clean();
        hmisMessages.m_show_tbl();
    },
    m_add_new: function () {
        new jj("do=" + hmisMessages.tableName + ".add_new").jjAjax2(false);
        $('#messenger_receiver').val("null").trigger('change');
         $("#messenger_attachFileTitle").val("");
        $("#messenger_attachFile").val("");
        $('#status').hide();
        $('#logStatus').hide();
        $(".inputAfterSelectManager").html("");
        $(".inputSelectorDiv").html("");
        hmisMessages.m_show_form();
        hmisMessages.m_clean();



        //
//        part_content_editor = new jj('#department_publicContent').jjEditor();
//        part_praivate_editor = new jj('#department_praivateContent').jjEditor();
//        cmsUser.m_getGroups();
    },
    m_show_form: function () {
        $('#swMessagesTbl').hide();
        $('#swMessagesForm').show();
        if ($('#swMessagesTbl').html() == "") {
            hmisMessages.m_refresh();
        }
        hmisMessages.tabSizeForm();
    },
    m_clean: function () {
        new jj("#swMessagesForm").jjFormClean();
        $("#messenger_receiver").val('').trigger('change');

    },
    m_show_tbl: function () {
        $('#swMessagesTbl').show();
        $('#swMessagesForm').hide();
        if ($('#swMessagesTbl').html() == "") {
            hmisMessages.m_refresh();
        }
        hmisMessages.m_refresh();
        hmisMessages.tabSizeTbl();
    },
    m_insert: function () {

        var param = "";
        param += "do=" + hmisMessages.tableName + ".insert";
        param += "&" + new jj("#swMessagesForm").jjSerial();

        param += "&jj=1";
        param += "&messenger_receiver=" + $("#messenger_receiver option:selected").val();
        new jj(param).jjAjax2(false);

        hmisMessages.m_show_tbl();
        hmisMessages.m_clean();
    },
    m_edit: function () {
        var param = "";
        param += "&do=" + hmisMessages.tableName + ".edit";

        param += "&" + new jj("#swMessagesForm").jjSerial();
        param += "&jj=1";
        param += "&messenger_receiver=" + $("#messages_receiver option:selected").val();
        new jj(param).jjAjax2(false);
        $(".inputSelectorDiv").html('');
        

        $(".inputAfterSelectManager").html("");
        hmisMessages.m_show_tbl();
        hmisMessages.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisMessages.m_delete_after_question(" + id + ");");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".delete";
        param += "&" + hmisMessenger.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisMessages.m_show_tbl();
        hmisMessages.m_clean();
    },
    m_remove: function (idUpload, id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisMessages.removeFile(" + idUpload + "," + id + ");");
    },
    removeFile: function (idUpload, id) {

        var param = "";
        param += "do=" + hmisMessages.tableName + ".removeFile";
        param += "&upload_id=" + idUpload;
        param += "&messenger_id=" + id;
        new jj(param).jjAjax2(false);
        hmisMessages.m_show_tbl();
        hmisMessages.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".selectMessages";
        param += "&" + hmisMessenger.f_id + "=" + (id == null ? "" : id);
        $('#status').show();
        $('#logStatus').show();
        $(".inputSelectorDiv").html("");
        $(".inputAfterSelectManager").html("");
       
//        $('#UserSelectOption').trigger('change');

        new jj(param).jjAjax2(false);



        hmisMessages.m_show_form();
//        hmisMessages.loadForm()();
//        hmisMessages.mainTabSetSize();


    },
    m_getMenu: function () {
        var param = "";
        param += "do=" + hmisMessages.tableName + ".getMenu";
        new jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swMessages').css('height', 515);
        hmisMessages.heightTab = 515;
    },
    tabSizeForm: function () {
        $('#swMessages').css('height', 270);
        hmisMessages.heightTab = 270;
    },
    heightTab: "515",
    mainTabSetSize: function () {
        $('#swMessages').css('height', hmisMessages.heightTab);
    },
}




