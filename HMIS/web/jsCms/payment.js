var cmsPayment = {
    tableName: "Payment",
    f_id: "id",
    loadForm: function () {
        if ($("#swProduct9Form").html() == '') {
            $("#swProduct9Form").load("formCms/payment.html", null, function () {
                $("#cancel_payment").button().click(function (e) {
                    cmsPayment.m_clean();
                    cmsPayment.m_show_tbl();
                });
            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + cmsPayment.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swProduct9Tbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=400";
        jj(param).jjAjax2(false);
        cmsPayment.tabSizeTbl();
    },
    m_show_form: function () {
        $('#swProduct9Tbl').hide();
        $('#swProduct9Form').show();
        cmsPayment.tabSizeForm();
    },
    m_clean: function () {
        new jj("#Payment_form_in_cms").jjFormClean();
        //        new jj("#"+cmsPayment.f_title).jjVal("");
        //        new jj("#"+cmsPayment.f_lang).jjVal("1");
        //        new jj("#"+cmsPayment.f_parent).jjVal("0");
        //        new jj(content_content_editor).jjEditorVal("");
    },
    m_show_tbl: function () {
        $('#swProduct9Tbl').show();
        $('#swProduct9Form').hide();
        if ($('#swProduct9Tbl').html() == "") {
            cmsPayment.m_refresh();
        }
        cmsPayment.tabSizeTbl();
    },
    m_insert: function () {
            var param = "";
            param += "do=" + cmsPayment.tableName + ".insert";
            param += "&" + new jj('#swProduct9Form').jjSerial();
            jj(param).jjAjax2(false);
            cmsPayment.m_show_tbl();
            cmsPayment.m_clean();
    },
    m_edit: function () {
            var param = "";
            param += "do=" + cmsPayment.tableName + ".edit";
            param += "&" + new jj('#swProduct9Form').jjSerial();
            jj(param).jjAjax2(false);
            cmsPayment.m_show_tbl();
            cmsPayment.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('cmsPayment.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + cmsPayment.tableName + ".delete";
        param += "&" + cmsPayment.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        cmsPayment.m_show_tbl();
        cmsPayment.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + cmsPayment.tableName + ".select";
        param += "&" + cmsPayment.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        cmsPayment.m_show_form();
        $('#swProduct9').css('height', 580);
        cmsPayment.heightTab = 580;
//        $("#swProductAll").tabs({selected: 16});

    },
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + cmsPayment.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + cmsPayment.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swProduct9').css('height', 470);
        cmsPayment.heightTab = 470;
    },
    tabSizeForm: function () {
        $('#swProduct9').css('height', 375);
        cmsPayment.heightTab = 375;
    },
    heightTab: "470",
    mainTabSetSize: function () {
        $('#swProduct9').css('height', cmsPayment.heightTab);
    }
}
////////////////////////////////////
var cmsPaymentSetting = {
    tableName: "PaymentSetting",
    f_id: "id",
    loadForm: function () {
        if ($("#swProduct10Form").html() == '') {
//            $("#swProduct10Form").load("formCms/payment_setting.html", null, function () {
//                
//            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + cmsPaymentSetting.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swProduct10Tbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=400";
        jj(param).jjAjax2(false);
        cmsPaymentSetting.tabSizeTbl();
//        cmsPaymentSetting.m_show_tbl();
    },
    m_show_form: function () {
        $('#swProduct10Tbl').hide();
        $('#swProduct10Form').show();
        cmsPaymentSetting.tabSizeForm();
    },
    m_clean: function () {
        new jj("#paymentSetting_form_in_cms").jjFormClean();
        //        new jj("#"+cmsPayment.f_title).jjVal("");
        //        new jj("#"+cmsPayment.f_lang).jjVal("1");
        //        new jj("#"+cmsPayment.f_parent).jjVal("0");
        //        new jj(content_content_editor).jjEditorVal("");
    },
    m_show_tbl: function () {
        $('#swProduct10Tbl').show();
        $('#swProduct10Form').hide();
        if ($('#swProduct10Tbl').html() == "") {
            cmsPaymentSetting.m_refresh();
        }
        cmsPaymentSetting.tabSizeTbl();
    },
    m_insert: function () {
            var param = "";
            param += "do=" + cmsPaymentSetting.tableName + ".insert";
            param += "&" + new jj('#swProduct10Form').jjSerial();
            jj(param).jjAjax2(false);
            cmsPaymentSetting.m_show_tbl();
            cmsPaymentSetting.m_clean();
    },
    m_edit: function () {
            var param = "";
            param += "do=" + cmsPaymentSetting.tableName + ".edit";
            param += "&" + new jj('#swProduct10Form').jjSerial();
            jj(param).jjAjax2(false);
            cmsPaymentSetting.m_show_tbl();
            cmsPaymentSetting.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('cmsPaymentSetting.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + cmsPaymentSetting.tableName + ".delete";
        param += "&" + cmsPaymentSetting.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        cmsPaymentSetting.m_show_tbl();
        cmsPaymentSetting.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + cmsPaymentSetting.tableName + ".select";
        param += "&" + cmsPaymentSetting.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        cmsPaymentSetting.m_show_form();
        $('#swProduct10').css('height', 580);
        cmsPaymentSetting.heightTab = 580;
        $("#swProductAll").tabs({selected: 0});

    },
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + cmsPaymentSetting.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + cmsPaymentSetting.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swProduct10').css('height', 470);
        cmsPaymentSetting.heightTab = 470;
    },
    tabSizeForm: function () {
        $('#swProduct10').css('height', 375);
        cmsPaymentSetting.heightTab = 375;
    },
    heightTab: "470",
    mainTabSetSize: function () {
        $('#swProduct10').css('height', cmsPaymentSetting.heightTab);
    }
};