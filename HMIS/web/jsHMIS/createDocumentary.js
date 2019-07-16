/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
///ایجاد مستند

var hmisCreateDocumentary = {
    tableName: "CreateDocumentary",
    f_id: "id",
    loadForm: function () {
//        if ($("#swCreateDocumentaryForm").html() == '') {
        if (true) {
            $("#swCreateDocumentaryForm").load("formHMIS/createDocumentary.html", null, function () {
                new jj('#createDocumentary_date').jjCalendarWithYearSelector(1310, 1410);
                $("#cancel_CreateDocumentary").button().click(function (e) {

                    hmisCreateDocumentary.m_clean();
                    hmisCreateDocumentary.m_show_tbl();

                });
                new jj('#sendFile1').jjAjaxFileUploadTitle('createDocumentary_file1', '#createDocumentary_attachmentfile1', 'createDocumentary_titleFile1', '#createDocumentary_attachmentfileTitle1', '#PicPreviewFile1');
//               
                $('#user_file1').keyup(function () {
                    $('#PicPreviewFile1').attr('src', 'upload/' + $('#user_file1').val());
                    if ($('#user_file1').val() == '') {
                        $('#PicPreviewFile1').attr('src', 'img/preview.jpg');
                    }
                });

                new jj('#sendFile2').jjAjaxFileUploadTitle('createDocumentary_file2', '#createDocumentary_attachmentfile2', 'createDocumentary_titleFile2', '#createDocumentary_attachmentfileTitle2', '#PicPreviewFile2');
                $('#user_file2').keyup(function () {
                    $('#PicPreviewFile2').attr('src', 'upload/' + $('#user_file2').val());
                    if ($('#user_file2').val() == '') {

                        $('#PicPreviewFile2').attr('src', 'img/preview.jpg');
                    }
                });

                new jj('#sendFile3').jjAjaxFileUploadTitle('createDocumentary_file3', '#createDocumentary_attachmentfile3', 'createDocumentary_titleFile3', '#createDocumentary_attachmentfileTitle3', '#PicPreviewFile3');

                $('#user_file3').keyup(function () {
                    $('#PicPreviewFile3').attr('src', 'upload/' + $('#user_file3').val());
                    if ($('#user_file3').val() == '') {
                        $('#PicPreviewFile3').attr('src', 'img/preview.jpg');
                    }
                });
                hmisCreateDocumentary.selectOptionUserSignture(".form-group");
                $('.summernote').summernote();


            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisCreateDocumentary.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swCreateDocumentaryTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisCreateDocumentary.tabSizeTbl();
    },
    m_refreshSignatureMyDocumentation: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisCreateDocumentary.tableName + ".refreshSignatureMyDocumentation";
        param += "&panel=" + (containerId == null ? "swCreateDocumentaryTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisCreateDocumentary.tabSizeTbl();

    },
    selectOptionUserSignture: function (panel) {
        var param = "";
        param += "panel=" + panel;
        param += "&do=" + hmisCreateDocumentary.tableName + ".selectOptionUserSignture";

        new jj(param).jjAjax2(false);

    },
    selectOneDocuementToSign: function (id) {
        var param = "";
        param += "id=" + id;

        param += "&do=" + hmisCreateDocumentary.tableName + ".selectOneDocuementToSign";

        new jj(param).jjAjax2(false);
        hmisCreateDocumentary.m_show_form();




        hmisCreateDocumentary.m_clean();


//        hmisSignDocumentary.m_clean();
    },
    m_add_new: function () {
        new jj("do=" + hmisCreateDocumentary.tableName + ".add_new").jjAjax2(false);
        hmisCreateDocumentary.m_show_form();

        $('.form-group').val("null").trigger('change');
        


        $("#Downloadfile2").hide();
        $("#Downloadfile3").hide();
        $("#Downloadfile1").hide();



        hmisCreateDocumentary.m_clean();
        $(".note-editable").load("entekhabePeymankar.html", null, function () {});


    },
    m_show_form: function () {
        $('#swCreateDocumentaryTbl').hide();
        $('#swCreateDocumentaryForm').show();
        new jj("#swCreateDocumentaryForm").jjFormClean();

        hmisCreateDocumentary.tabSizeForm();
    },
    m_show_formCopy: function () {
        $('#swCreateDocumentaryTbl').hide();
        $('#swCreateDocumentaryForm').show();


        hmisCreateDocumentary.tabSizeForm();
    },
    m_clean: function () {

        new jj("#swCreateDocumentaryForm").jjFormClean();
        $('#createDocumentary_htmlContent').summernote('code', '');
        $("#signatorysAdd").html('');
        $("#signatorys").html('');
        $('#PicPreviewFile3').attr('src', '');
        $('#PicPreviewFile2').attr('src', '');
        $('#PicPreviewFile1').attr('src', '');
        $("#user_file2").html('');
        $("#user_file1").html('');
        $("#user_file3").html('');
        new jj("#createDocumentary_attachmentfile2").jjVal('');
        new jj("#createDocumentary_attachmentfile3").jjVal('');
        new jj("#createDocumentary_attachmentfile1").jjVal('');
    },
    m_show_tbl: function () {
        $('#swCreateDocumentaryTbl').show();
        $('#swCreateDocumentaryForm').hide();
        if ($('#swCreateDocumentaryTbl').html() == "") {
            hmisCreateDocumentary.m_refresh();
        }
        hmisCreateDocumentary.m_refresh();
        hmisCreateDocumentary.tabSizeTbl();

    },
    m_insert: function () {
        var param = "";
        param += "do=" + hmisCreateDocumentary.tableName + ".insert";
        param += "&" + new jj("#swCreateDocumentaryForm").jjSerial();
        param += "&form-group=" + $(".form-group option:selected").val();

        param += "&createDocumentary_htmlContent=" + $('#createDocumentary_htmlContent').summernote('code');
        new jj(param).jjAjax2(false);
        hmisCreateDocumentary.m_show_tbl();
        hmisCreateDocumentary.m_clean();
    },
    m_edit: function () {
        var param = "";
        param += "do=" + hmisCreateDocumentary.tableName + ".edit";

        param += "&createDocumentary_htmlContent=" + $('#createDocumentary_htmlContent').summernote('code');
        param += "&" + new jj("#swCreateDocumentaryForm").jjSerial();
        param += "&" + new jj("#signatorys").jjSerial();
        param += "&" + new jj("#signatorysAdd").jjSerial();
        new jj(param).jjAjax2(false);
        hmisCreateDocumentary.m_show_tbl();
        hmisCreateDocumentary.m_clean();
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisCreateDocumentary.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisCreateDocumentary.tableName + ".delete";
        param += "&" + hmisCreateDocumentary.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisCreateDocumentary.m_show_tbl();
        hmisCreateDocumentary.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisCreateDocumentary.tableName + ".select";
        param += "&" + hmisCreateDocumentary.f_id + "=" + (id == null ? "" : id);
        $('.summernote').summernote();
        new jj(param).jjAjax2(false);



        hmisCreateDocumentary.m_show_form();
        hmisCreateDocumentary.m_clean();

    },
    copyDocumentary: function () {
        alert("مستند مورد نظر کپی شد");
        new jj("do=" + hmisCreateDocumentary.tableName + ".copyDocumentary").jjAjax2(false);
        hmisCreateDocumentary.m_show_formCopy();
        $("#signatorys").html('');
        $("#signatorysAdd").html('');
    },
    m_getMenu: function () {
        var param = "";
        param += "do=" + hmisCreateDocumentary.tableName + ".getMenu";
        new jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swCreateDocumentary').css('height', 515);
        hmisCreateDocumentary.heightTab = 515;
    },
    tabSizeForm: function () {
        $('#swCreateDocumentary').css('height', 270);
        hmisCreateDocumentary.heightTab = 270;
    },
    heightTab: "515",
    mainTabSetSize: function () {
        $('#swCreateDocumentary').css('height', hmisCreateDocumentary.heightTab);
    },
}





