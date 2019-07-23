/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var hmisDepartment = {
    tableName: "Department",
    f_id: "id",
    loadForm: function () {
        if ($("#swDepartmentForm").html() == '') {
            $("#swDepartmentForm").load("formHMIS/department.html", null, function () {

                $("#cancel_Department").on('click', function (e) {
//                   alert(1);
                    hmisDepartment.m_clean();
                    hmisDepartment.m_show_tbl();
                });

//                $("#sendPicIcon").button().click(function () {
//                });
//                $("#upload_fileIcon").button().click(function () {
//                });
//                new jj('#sendPicIcon').jjAjaxFileUploadIcon('#upload_fileIcon', '#department_icon', '#PicPreviewIcon');
                new jj('#sendPicIcon').jjAjaxFileUpload2('upload_fileIcon', '#department_icon', '#PicPreviewIcon');
                $('#departmentIcon').keyup(function () {
                    $('#PicPreviewIcon').attr('src', 'upload/' + $('#departmentIcon').val());
                    if ($('#departmentIcon').val() == '') {
                        $('#PicPreviewIcon').attr('src', 'img/preview.jpg');
                    }
                });
                hmisDepartment.selectOptionDepartment("department_location");
//                $("#department_location").select2({
//                    minimumResultsForSearch: '',
//                    width: '100%'
//                });
            });



        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisDepartment.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swDepartmentTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisDepartment.tabSizeTbl();
    },
    bazgasht: function () {
        hmisDepartment.m_clean();
        hmisDepartment.m_show_tbl();
    },
    m_add_new: function () {
        new jj("do=" + hmisDepartment.tableName + ".add_new").jjAjax2(false);
        $('.summernote').summernote();///برای تبدیل شدن به textEditor
        $('#department_location').val("null").trigger('change');
        $("#IconDownload").hide();
        hmisDepartment.m_show_form();
        hmisDepartment.m_clean();



        //
//        part_content_editor = new jj('#department_publicContent').jjEditor();
//        part_praivate_editor = new jj('#department_praivateContent').jjEditor();
//        cmsUser.m_getGroups();
    },
    m_show_form: function () {
        $('#swDepartmentTbl').hide();
        $('#swDepartmentForm').show();
        if ($('#swDepartmentTbl').html() == "") {
            hmisDepartment.m_refresh();
        }
        hmisDepartment.tabSizeForm();
    },
    m_clean: function () {
        new jj("#swDepartmentForm").jjFormClean();
        $("#departmentIcon").html('');
        $('#PicPreviewIcon').attr('src', '');
        $("#selectHospital").val('');
//         $("#departmentIcon").html('');
//        $('#PicPreviewIcon').attr('src', '');
        $('#department_publicContent').summernote('code', '');
        $('#department_praivateContent').summernote('code', '');
    },
    m_show_tbl: function () {
        $('#swDepartmentTbl').show();
        $('#swDepartmentForm').hide();
        if ($('#swDepartmentTbl').html() == "") {
            hmisDepartment.m_refresh();
        }
        hmisDepartment.m_refresh();
        hmisDepartment.tabSizeTbl();
    },
    m_insert: function () {
        var param = "";
        param += "do=" + hmisDepartment.tableName + ".insert";
        param += "&" + new jj("#swDepartmentForm").jjSerial();
        param += "&department_praivateContent=" + $('#department_praivateContent').summernote('code');
        param += "&department_publicContent=" + $('#department_publicContent').summernote('code');
        param += "&jj=1";
//        param += "&selectOptionDepartement=" + $("#locationSelectOption option:selected").val();
        new jj(param).jjAjax2(false);
        hmisDepartment.m_show_tbl();
        hmisDepartment.m_clean();
    },
    m_edit: function () {
        var param = "";
        param += "&do=" + hmisDepartment.tableName + ".edit";
//         param += $('#department_publicContent').summernote('code');
        param += "&department_praivateContent=" + $('#department_praivateContent').summernote('code');
        param += "&department_publicContent=" + $('#department_publicContent').summernote('code');
        param += "&" + new jj("#swDepartmentForm").jjSerial();
        param += "&jj=1";
//        param += "&selectOptionDepartement=" + $("#locationSelectOption option:selected").val();
        new jj(param).jjAjax2(false);
        hmisDepartment.m_show_tbl();
        hmisDepartment.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisDepartment.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisDepartment.tableName + ".delete";
        param += "&" + hmisDepartment.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisDepartment.m_show_tbl();
        hmisDepartment.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisDepartment.tableName + ".select";
        param += "&" + hmisDepartment.f_id + "=" + (id == null ? "" : id);
        $('.summernote').summernote();
        new jj(param).jjAjax2(false);
        hmisDepartment.m_show_form();
//        part_content_editor = new jj('#department_publicContent').jjEditor();
//         part_praivate_editor = new jj('#department_praivateContent').jjEditor();

    },
    selectOptionDepartment: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisDepartment.tableName + ".selectOptionDepartment";
//        param += "&" + hmisDepartment.f_id + "=" + (id == null ? "" : id);
//        $('.summernote').summernote();
        new jj(param).jjAjax2(false);



//        hmisDepartment.m_show_form();
//        part_content_editor = new jj('#department_publicContent').jjEditor();
//         part_praivate_editor = new jj('#department_praivateContent').jjEditor();

    },
    m_getMenu: function () {
        var param = "";
        param += "do=" + hmisDepartment.tableName + ".getMenu";
        new jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swDepartment').css('height', 515);
        hmisDepartment.heightTab = 515;
    },
    tabSizeForm: function () {
        $('#swDepartment').css('height', 270);
        hmisDepartment.heightTab = 270;
    },
    heightTab: "515",
    mainTabSetSize: function () {
        $('#swDepartment').css('height', hmisDepartment.heightTab);
    },
    ////این تابع برای دانلود آیکون در قسمت دپارتمان طراحی شده
    downloadIcon: function () {
        $('#downloadIcon').attr('href', 'upload/' + $('#uploaded_file').val());
    },
}


