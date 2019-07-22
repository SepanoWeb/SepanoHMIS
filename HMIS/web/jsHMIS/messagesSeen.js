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




var hmisMessagesSeen = {
    tableName: "MessagesSeen",
    f_id: "id",
    loadForm: function () {
        if ($("#swMessagesSeenForm").html() == '') {
            $("#swMessagesSeenForm").load("formHMIS/messagesSeen.html", null, function () {
                new jj('#messagesSeen_postageDate').jjCalendarWithYearSelector(1310, 1410);
                $("#cancel_MessagesSeen").on('click', function (e) {
//                   alert(1);
                    hmisMessagesSeen.m_clean();
                    hmisMessagesSeen.m_show_tbl();
                });


                new jj('#sendMessagesSeen').jjAjaxFileUploadTitleUploadFiles('#MessagesSeenAttachFile', '#messagesSeen_attachFile', 'messagesSeen_titleFile', '#messagesSeen_attachFileTitle','.inputSelectorDiv');


                hmisMessagesSeen.selectOptionUserMessagesSeen("messagesSeen_receiver");
                hmisMessenger.send();

            });


        }
    },
    selectOptionUserMessagesSeen: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisMessenger.tableName + ".selectOptionUserMessagesSeen";

        new jj(param).jjAjax2(false);
    },
    sendMesseageToSignatory: function (userId, IdDocumentary) {
        var param = "";
        param += "&userId=" + userId;
        param += "&IdDocumentary=" + IdDocumentary;

        param += "&titleSign=" + $("#payam").parent().parent().find(".c").val();
        param += "&do=" + hmisMessagesSeen.tableName + ".sendMesseageToSignatory";
        param += "&jj=1";
        new jj(param).jjAjax2(false);

    },
  
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".refreshMessagesSeen";
        param += "&panel=" + (containerId == null ? "swMessagesSeenTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisMessagesSeen.tabSizeTbl();
    },
    bazgasht: function () {
        hmisMessagesSeen.m_clean();
        hmisMessagesSeen.m_show_tbl();
    },
    m_add_new: function () {
        new jj("do=" + hmisMessagesSeen.tableName + ".add_new").jjAjax2(false);
        $('#messenger_receiver').val("null").trigger('change');
         $("#messenger_attachFileTitle").val("");
        $("#messenger_attachFile").val("");
        $('#status').hide();
        $('#logStatus').hide();
        $(".inputAfterSelectManager").html("");
        $(".inputSelectorDiv").html("");
        hmisMessagesSeen.m_show_form();
        hmisMessagesSeen.m_clean();



        //
//        part_content_editor = new jj('#department_publicContent').jjEditor();
//        part_praivate_editor = new jj('#department_praivateContent').jjEditor();
//        cmsUser.m_getGroups();
    },
    m_show_form: function () {
        $('#swMessagesSeenTbl').hide();
        $('#swMessagesSeenForm').show();
        if ($('#swMessagesSeenTbl').html() == "") {
            hmisMessagesSeen.m_refresh();
        }
        hmisMessagesSeen.tabSizeForm();
    },
    m_clean: function () {
        new jj("#swMessagesSeenForm").jjFormClean();
        $("#messenger_receiver").val('').trigger('change');

    },
    m_show_tbl: function () {
        $('#swMessagesSeenTbl').show();
        $('#swMessagesSeenForm').hide();
        if ($('#swMessagesSeenTbl').html() == "") {
            hmisMessagesSeen.m_refresh();
        }
        hmisMessagesSeen.m_refresh();
        hmisMessagesSeen.tabSizeTbl();
    },
    m_insert: function () {

        var param = "";
        param += "do=" + hmisMessagesSeen.tableName + ".insert";
        param += "&" + new jj("#swMessagesSeenForm").jjSerial();

        param += "&jj=1";
        param += "&messenger_receiver=" + $("#messenger_receiver option:selected").val();
        new jj(param).jjAjax2(false);

        hmisMessagesSeen.m_show_tbl();
        hmisMessagesSeen.m_clean();
    },
    m_edit: function () {
        var param = "";
        param += "&do=" + hmisMessagesSeen.tableName + ".edit";

        param += "&" + new jj("#swMessagesSeenForm").jjSerial();
        param += "&jj=1";
        param += "&messenger_receiver=" + $("#messagesSeen_receiver option:selected").val();
        new jj(param).jjAjax2(false);
        $(".inputSelectorDiv").html('');
        

        $(".inputAfterSelectManager").html("");
        hmisMessagesSeen.m_show_tbl();
        hmisMessagesSeen.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisMessagesSeen.m_delete_after_question(" + id + ");");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".delete";
        param += "&" + hmisMessenger.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisMessagesSeen.m_show_tbl();
        hmisMessagesSeen.m_clean();
    },
    m_remove: function (idUpload, id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisMessagesSeen.removeFile(" + idUpload + "," + id + ");");
    },
    removeFile: function (idUpload, id) {

        var param = "";
        param += "do=" + hmisMessagesSeen.tableName + ".removeFile";
        param += "&upload_id=" + idUpload;
        param += "&messenger_id=" + id;
        new jj(param).jjAjax2(false);
        hmisMessagesSeen.m_show_tbl();
        hmisMessagesSeen.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisMessenger.tableName + ".selectMessagesSeen";
        param += "&" + hmisMessenger.f_id + "=" + (id == null ? "" : id);
        $('#status').show();
        $('#logStatus').show();
        $(".inputSelectorDiv").html("");
        $(".inputAfterSelectManager").html("");
       
//        $('#UserSelectOption').trigger('change');

        new jj(param).jjAjax2(false);



        hmisMessagesSeen.m_show_form();
//        hmisMessagesSeen.loadForm()();
//        hmisMessagesSeen.mainTabSetSize();


    },
    m_getMenu: function () {
        var param = "";
        param += "do=" + hmisMessagesSeen.tableName + ".getMenu";
        new jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swMessagesSeen').css('height', 515);
        hmisMessagesSeen.heightTab = 515;
    },
    tabSizeForm: function () {
        $('#swMessagesSeen').css('height', 270);
        hmisMessagesSeen.heightTab = 270;
    },
    heightTab: "515",
    mainTabSetSize: function () {
        $('#swMessagesSeen').css('height', hmisMessagesSeen.heightTab);
    },
}




