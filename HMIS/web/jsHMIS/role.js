/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
////shiran1
////جدول نقش ها
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var hmisRole = {
    tableName: "Role",
    f_id: "id",

    loadForm: function () {
        if ($("#swRoleForm").html() == '') {
            $("#swRoleForm").load("formHMIS/role.html", null, function () {
                new jj('#role_date').jjCalendarWithYearSelector(1310, 1410);
//                hmisRole.m_refresh();

                $("#cancel_Role").button().click(function (e) {
//                   alert(1);
                    hmisRole.m_clean();
                    hmisRole.m_show_tbl();
                });


            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisRole.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swRoleTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        jj(param).jjAjax2(false);
        hmisRole.tabSizeTbl();
    },
    bazgasht: function () {
        hmisRole.m_clean();
        hmisRole.m_show_tbl();
    },
    m_add_new: function () {
        jj("do=" + hmisRole.tableName + ".add_new").jjAjax2(false);
        hmisRole.m_show_form();
//        $('.summernote').summernote();///برای تبدیل شدن به textEditor

        $("#ListKarbaran").show();
        $("#role_name").val('');
        $("#role_family").val('');
        $("#role_email").val('');
//        $("#role_condition").val('');
//        hmisRole.m_clean();

//        part_content_editor = new jj('#department_publicContent').jjEditor();
//        part_praivate_editor = new jj('#department_praivateContent').jjEditor();
//        cmsUser.m_getGroups();
    },
    m_show_form: function () {
        $('#swRoleTbl').hide();
        $('#swRoleForm').show();
        new jj("#swRoleForm").jjFormClean();
        hmisRole.tabSizeForm();
    },
    m_clean: function () {
//        new jj("#swRoleForm").jjFormClean();

    },
    m_show_tbl: function () {
        $('#swRoleTbl').show();
        $('#swRoleForm').hide();
        if ($('#swRoleTbl').html() == "") {
            cmsUser.m_refresh();
        }
        hmisRole.m_refresh();
        hmisRole.tabSizeTbl();
    },
    m_insert: function () {
        var param = "";
        param += "do=" + hmisRole.tableName + ".insert";
        param += "&" + new jj("#swRoleForm").jjSerial();
                param += "&role_condition=" + $('#AccessuserForm input:radio[name=role_condition]:checked').val();

        jj(param).jjAjax2(false);
        hmisRole.m_show_tbl();
        hmisRole.m_clean();
    },
    m_edit: function () {
        var param = "";
        param += "do=" + hmisRole.tableName + ".edit";
        param += "&" + new jj("#swRoleForm").jjSerial();
        param += "&role_condition=" + $('#AccessuserForm input:radio[name=role_condition]:checked').val();
        jj(param).jjAjax2(false);
        hmisRole.m_show_tbl();
        hmisRole.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisRole.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisRole.tableName + ".delete";
        param += "&" + hmisRole.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        hmisRole.m_show_tbl();
        hmisRole.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisRole.tableName + ".select";
        param += "&" + hmisRole.f_id + "=" + (id == null ? "" : id);
//        $('.summernote').summernote();
        jj(param).jjAjax2(false);
        $("#ListKarbaran").hide();


        hmisRole.m_show_form();


    },
    m_selectKarbar: function (id) {

        var param = "";
        param += "do=" + hmisRole.tableName + ".selectKarbar";
        param += "&" + hmisRole.f_id + "=" + (id == null ? "" : id);
        hmisRole.m_show_form();
//       $("#role_email").val('');
        jj(param).jjAjax2(false);

    },

    m_getMenu: function () {
        var param = "";
        param += "do=" + hmisRole.tableName + ".getMenu";
        jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swRole').css('height', 515);
        hmisRole.heightTab = 515;
    },
    tabSizeForm: function () {
        $('#swRole').css('height', 270);
        hmisRole.heightTab = 270;
    },
    heightTab: "515",
    mainTabSetSize: function () {
        $('#swRole').css('height', hmisRole.heightTab);
    },

}



