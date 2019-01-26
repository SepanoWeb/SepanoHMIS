var cmsTags = {
    tableName: "tags",
    f_id: "id",
    f_title: "tags_title",
    loadForm: function () {
        if ($("#swTagsForm").html() == '') {
            $("#swTagsForm").load("tags.html", null, function () {
//                $("#sms_text").keyup(function () {
//                    cmsSMS.smsLeftChar('sms_text', 'dummyID_SendSMS1_MsgBox_lblLeft', 'dummyID_SendSMS1_MsgBox_lblSms', 'dummyID_SendSMS1_MsgBox_lblMax', null);
//                });
//                $("#cancel_SMS").button().click(function (e) {
//                    cmsTags.m_clean();
//                    cmsTags.m_show_tbl();
            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + cmsTags.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "refreshTag" : containerId);
        jj(param).jjAjax2(false);
//        cmsProduct.tabSizeTbl();
    },
    m_insert: function () {
        var param = "";
        param += "do=" + cmsTags.tableName + ".insert";
        param += "&" + new jj('#swTagsForm').jjSerial();
        jj(param).jjAjax2(false);
//        cmsProduct.m_show_tbl();
//        cmsProduct.m_clean();
    },
    m_edit: function () {
        var param = "";
        param += "do=" + cmsTags.tableName + ".edit";
        param += "&" + new jj('#swTagsForm').jjSerial();
        jj(param).jjAjax2(false);
//        cmsProduct.m_show_tbl();
//        cmsProduct.m_clean();
    },
    m_delete: function (id) {
//        alert("m_delete is running");
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('cmsTags.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
//        alert("m_delete_question is running");
        var param = "";
        param += "do=" + cmsTags.tableName + ".delete";
        param += "&" + cmsTags.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
//        cmsProduct.m_show_tbl();
//        cmsProduct.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + cmsTags.tableName + ".select";
        param += "&" + cmsTags.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
//        cmsProduct.m_show_form();
//        cmsProduct.m_getCategory(id); //By Md
    },
//    m_add_EN: function (id) {
//        var param = "";
//        param += "do=" + cmsProduct.tableName + ".add_EN";
//        param += "&" + cmsProduct.f_id + "=" + (id == null ? "" : id);
//        jj(param).jjAjax2(false);
//        new jj("#" + cmsProduct.f_parent).jjVal(id);
//        new jj("#" + cmsProduct.f_lang).jjVal("2");
//        cmsProduct.m_show_form();
//    },
//    m_add_Ar: function (id) {
//        var param = "";
//        param += "do=" + cmsProduct.tableName + ".add_ar";
//        param += "&" + cmsProduct.f_id + "=" + (id == null ? "" : id);
//        jj(param).jjAjax2(false);
//        new jj("#" + cmsProduct.f_parent).jjVal(id);
//        new jj("#" + cmsProduct.f_lang).jjVal("3");
//        cmsProduct.m_show_form();
//    },
}