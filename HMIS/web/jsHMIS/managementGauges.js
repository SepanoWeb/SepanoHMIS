/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 *نوشته شده توسط شیران یک
 */

var hmisManagementGauges = {
    tableName: "ManagementGauges",
    f_id: "id",
    loadForm: function () {
        if ($("#swManagementGaugesForm").html() == '') {
            $("#swManagementGaugesForm").load("formHMIS/managementGauges.html", null, function () {
                new jj('#managementGauges_date').jjCalendarWithYearSelector(1310, 1410);
                $("#cancel_ManagementGauges").on('click', function (e) {

                    hmisManagementGauges.m_clean();
                    hmisManagementGauges.m_show_tbl();
                });

                hmisManagementGauges.selectOptionDepartment("managementGauges_department");
                hmisManagementGauges.getoptionAxis("managementGauges_axis");
                hmisManagementGauges.getoptionUnderAxis("managementGauges_underTheAxis");
                hmisManagementGauges.getoptionStandard("managementGauges_standard");
                hmisManagementGauges.getoptionGauge("managementGauges_gauge");
                hmisManagementGauges.getoptionStep("managementGauges_step");

                hmisManagementGauges.getoptionResponsibleLoading("managementGauges_responsibleLoading");
                hmisManagementGauges.getoptionUploadDate("managementGauges_uploadDate");
//                 $("#managementGauges_department").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
//                 $("#managementGauges_axis").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
//                 $("#managementGauges_underTheAxis").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
//                 $("#managementGauges_standard").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
//                 $("#managementGauges_gauge").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
////                 $("#managementGauges_step").select2({
////                    minimumResultsForSearch: '',
////                    width: '100%'
////                });
//                 $("#managementGauges_responsibleLoading").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
//                 $("#managementGauges_uploadDate").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
            });



        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisManagementGauges.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swManagementGaugesTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisManagementGauges.tabSizeTbl();
    },
    changeSelectToInputAxis: function () {
        if ($('#managementGauges_axis').css('display') == 'none') {
            $('#managementGauges_axis').show();
            $('#managementGauges_axis').attr('name', 'managementGauges_axis');
            $('#managementGauges_axis1').hide();
            $('#managementGauges_axis1').attr('name', 'managementGauges_axis1');
        } else {
            $('#managementGauges_axis').hide();
            $('#managementGauges_axis').attr('name', 'managementGauges_axis1');
            $('#managementGauges_axis1').show();
            $('#managementGauges_axis1').attr('name', 'managementGauges_axis');
        }




    },
    changeSelectToInputUnderTheAxis: function () {
        if ($('#managementGauges_underTheAxis').css('display') == 'none') {
            $('#managementGauges_underTheAxis').show();
            $('#managementGauges_underTheAxis').attr('name', 'managementGauges_underTheAxis');
            $('#managementGauges_underTheAxis1').hide();
            $('#managementGauges_underTheAxis1').attr('name', 'managementGauges_underTheAxis1');
        } else {
            $('#managementGauges_underTheAxis').hide();
            $('#managementGauges_underTheAxis').attr('name', 'managementGauges_underTheAxis1');
            $('#managementGauges_underTheAxis1').show();
            $('#managementGauges_underTheAxis1').attr('name', 'managementGauges_underTheAxis');
        }




    },
    changeSelectToInputStandard: function () {
        if ($('#managementGauges_standard').css('display') == 'none') {
            $('#managementGauges_standard').show();
            $('#managementGauges_standard').attr('name', 'managementGauges_standard');
            $('#managementGauges_standard1').hide();
            $('#managementGauges_standard1').attr('name', 'managementGauges_standard1');
        } else {
            $('#managementGauges_standard').hide();
            $('#managementGauges_standard').attr('name', 'managementGauges_standard1');
            $('#managementGauges_standard1').show();
            $('#managementGauges_standard1').attr('name', 'managementGauges_standard');
        }




    },
    changeSelectToInputGauge: function () {
        if ($('#managementGauges_gauge').css('display') == 'none') {
            $('#managementGauges_gauge').show();
            $('#managementGauges_gauge').attr('name', 'managementGauges_gauge');
            $('#managementGauges_gauge1').hide();
            $('#managementGauges_gauge1').attr('name', 'managementGauges_gauge1');
        } else {
            $('#managementGauges_gauge').hide();
            $('#managementGauges_gauge').attr('name', 'managementGauges_gauge1');
            $('#managementGauges_gauge1').show();
            $('#managementGauges_gauge1').attr('name', 'managementGauges_gauge');
        }




    },
    changeSelectToInputStep: function () {
        if ($('#managementGauges_step').css('display') == 'none') {
            $('#managementGauges_step').show();
            $('#managementGauges_step').attr('name', 'managementGauges_step');
            $('#managementGauges_step1').hide();
            $('#managementGauges_step1').attr('name', 'managementGauges_step1');
        } else {
            $('#managementGauges_step').hide();
            $('#managementGauges_step').attr('name', 'managementGauges_step1');
            $('#managementGauges_step1').show();
            $('#managementGauges_step1').attr('name', 'managementGauges_step');
        }




    },
    getoptionAxis: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisManagementGauges.tableName + ".getoptionAxis";

        new jj(param).jjAjax2(false);
    },
    getoptionUnderAxis: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisManagementGauges.tableName + ".getoptionUnderAxis";

        new jj(param).jjAjax2(false);
    },
    getoptionStandard: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisManagementGauges.tableName + ".getoptionStandard";

        new jj(param).jjAjax2(false);
    },
    getoptionGauge: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisManagementGauges.tableName + ".getoptionGauge";

        new jj(param).jjAjax2(false);
    },
    getoptionStep: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisManagementGauges.tableName + ".getoptionStep";

        new jj(param).jjAjax2(false);
    },
    getoptionResponsibleLoading: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisManagementGauges.tableName + ".getoptionResponsibleLoading";

        new jj(param).jjAjax2(false);
    },
    getoptionUploadDate: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisManagementGauges.tableName + ".getoptionUploadDate";

        new jj(param).jjAjax2(false);
    },
//    *
//    برای دراوردن بخش ها
//    */
    selectOptionDepartment: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisManagementGauges.tableName + ".selectOptionDepartment";

        new jj(param).jjAjax2(false);

    },
    m_add_new: function () {
        new jj("do=" + hmisManagementGauges.tableName + ".add_new").jjAjax2(false);

        hmisManagementGauges.m_show_form();
        hmisManagementGauges.m_clean();
    },
    m_show_form: function () {
        $('#swManagementGaugesTbl').hide();
        $('#swManagementGaugesForm').show();
        if ($('#swManagementGaugesTbl').html() == "") {
            hmisManagementGauges.m_refresh();
        }
        hmisManagementGauges.tabSizeForm();
    },
    m_clean: function () {
        new jj("#swManagementGaugesForm").jjFormClean();
        $("#managementGauges_axis").val('');
        $("#managementGauges_underTheAxis").val('');
        $("#managementGauges_standard").val('');
        $("#managementGauges_gauge").val('');
        $("#managementGauges_step").val('');
        $("#managementGauges_responsibleLoading").val('');
        $("#managementGauges_uploadDate").val('');
        $("#managementGauges_date").val('');
        $("#managementGauges_department").val('').trigger('change')
    },
    m_show_tbl: function () {
        $('#swManagementGaugesTbl').show();
        $('#swManagementGaugesForm').hide();
        if ($('#swManagementGaugesTbl').html() == "") {
            hmisManagementGauges.m_refresh();
        }
        hmisManagementGauges.m_refresh();
        hmisManagementGauges.tabSizeTbl();
    },
    m_insert: function () {
        var param = "";
        param += "do=" + hmisManagementGauges.tableName + ".insert";
        param += "&" + new jj("#swManagementGaugesForm").jjSerial();

        param += "&jj=1";

        new jj(param).jjAjax2(false);
        hmisManagementGauges.m_show_tbl();
        hmisManagementGauges.m_clean();
        hmisManagementGauges.getoptionAxis("managementGauges_axis");
        hmisManagementGauges.getoptionUnderAxis("managementGauges_underTheAxis");
        hmisManagementGauges.getoptionStandard("managementGauges_standard");
        hmisManagementGauges.getoptionGauge("managementGauges_gauge");
        hmisManagementGauges.getoptionStep("managementGauges_step");

        hmisManagementGauges.getoptionResponsibleLoading("managementGauges_responsibleLoading");
        hmisManagementGauges.getoptionUploadDate("managementGauges_uploadDate");
    },
    m_edit: function () {
        var param = "";
        param += "&do=" + hmisManagementGauges.tableName + ".edit";
        param += "&" + new jj("#swManagementGaugesForm").jjSerial();
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisManagementGauges.m_show_tbl();
        hmisManagementGauges.m_clean();
//        hmisManagementGauges.selectOptionDepartment("managementGauges_department");
        hmisManagementGauges.getoptionAxis("managementGauges_axis");
        hmisManagementGauges.getoptionUnderAxis("managementGauges_underTheAxis");
        hmisManagementGauges.getoptionStandard("managementGauges_standard");
        hmisManagementGauges.getoptionGauge("managementGauges_gauge");
        hmisManagementGauges.getoptionStep("managementGauges_step");

        hmisManagementGauges.getoptionResponsibleLoading("managementGauges_responsibleLoading");
        hmisManagementGauges.getoptionUploadDate("managementGauges_uploadDate");
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisManagementGauges.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisManagementGauges.tableName + ".delete";
        param += "&" + hmisManagementGauges.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisManagementGauges.m_show_tbl();
        hmisManagementGauges.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisManagementGauges.tableName + ".select";
        param += "&" + hmisManagementGauges.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisManagementGauges.m_show_form();

    },
    m_getMenu: function () {
        var param = "";
        param += "do=" + hmisManagementGauges.tableName + ".getMenu";
        new jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swManagementGauges').css('height', 515);
        hmisManagementGauges.heightTab = 515;
    },
    tabSizeForm: function () {
        $('#swManagementGauges').css('height', 270);
        hmisManagementGauges.heightTab = 270;
    },
    heightTab: "515",
    mainTabSetSize: function () {
        $('#swManagementGauges').css('height', hmisManagementGauges.heightTab);
    },
}


