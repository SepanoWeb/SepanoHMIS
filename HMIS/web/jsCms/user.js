var cmsUser = {
    tableName: "Access_User",
    f_id: "id",
    f_user_id: "user_id",
    f_pass: "user_pass",
    f_name: "user_name",
    f_family: "user_family",
    f_email: "user_email",
    f_isActive: "user_is_active",
    f_registDate: "user_createDate",
    f_birthdate: "user_birthdate",
    f_question: "user_question",
    f_answer: "user_answer",
    f_no1: "user_no1",
    f_no2: "user_no2",
    f_parent: "user_parent",
    loadForm: function () {
        if ($("#swUserForm").html() == '') {
            $("#swUserForm").load("formCms/user.html", null, function () {
                new jj('#user_birthdateUser').jjCalendarWithYearSelector(1310, 1410);
                $("#cancel_User").button().click(function (e) {
//                     goBack();
                    cmsUser.m_clean();
                    cmsUser.m_show_tbl();
                });
                $("#sendPic1").button().click(function () {
                });
                $("#user_file_personal").button().click(function () {
                });
                new jj('#sendPic1').jjAjaxFileUpload2('user_file_personal', '#user_attachPicPersonal', '#PicPreviewPersonal');
//                new jj('#sendPic1').jjAjaxFileUploadPersonal('#user_file_personal', '#user_attachAxPersonal', '#PicPreviewPersonal');
                $('#user_pic1').keyup(function () {
                    $('#PicPreviewPersonal').attr('src', 'upload/' + $('#user_pic1').val());
                    if ($('#user_pic1').val() == '') {
                        $('#PicPreviewPersonal').attr('src', 'img/preview.jpg');
                    }
                });
                //////برای عکس امضا 
                $("#sendPicSignature").button().click(function () {
                });
                $("#user_file_Signature").button().click(function () {
                });
//                new jj('#sendPicSignature').jjAjaxFileUploadAxSignature('#user_file_Signature', '#user_attachAxSignature', '#PicPreviewSignature');
                 new jj('#sendPicSignature').jjAjaxFileUpload2('user_file_Signature', '#user_attachPicSignature', '#PicPreviewSignature');
                $('#user_pic2').keyup(function () {
                    $('#PicPreviewSignature').attr('src', 'upload/' + $('#user_pic2').val());
                    if ($('#user_pic2').val() == '') {m_
                        $('#PicPreviewSignature').attr('src', 'img/preview.jpg');
                    }
                });
                /////برای تصویر


                $("#sendPicupload").button().click(function () {
                });
                $("#uploaded_file").button().click(function () {
                });
                 new jj('#sendPicupload').jjAjaxFileUpload2('uploaded_file', '#user_attachPicPersonnelCard', '#PicPreview');
//                new jj('#sendPicupload').jjAjaxFileUploadPersonnelCard('#uploaded_file', '#user_attachAxPersonnelCard', '#PicPreview');
                $('#user_pic3').keyup(function () {
                    $('#PicPreview').attr('src', 'upload/' + $('#user_pic3').val());
                    if ($('#user_pic3').val() == '') {
                        $('#PicPreview').attr('src', 'img/preview.jpg');
                    }
                });
                ///////فایل ها
                $("#sendPicFiles").button().click(function () {
//                        $('#AttachFileUpload').append($('#user_pic4').val());
                });

                $("#attachFile").button().click(function () {
                });
                
                new jj('#sendPicFiles').jjAjaxFileUpload3('#attachFile', '#user_attachFile');

//                $('#user_pic4').keyup(function () {
////                    $('#PicPreviewAttach').attr('src', 'upload/' + $('#user_pic4').val());
//
//                    if ($('#user_pic4').val() == '') {
//                        $('#PicPreviewAttach').attr('src', 'img/preview.jpg');
//
////                       
//                    }
//                });
//                $("#sendPicFiles").button().click(function () {
////                    var param="";
////                      param += "&AttachFileUpload=" + $("#user_pic4").val();
////                      param += "&jj=1" ;
//                    $('#AttachFileUpload').append($('#user_pic4').val());
//                     $('#AttachFileUploadAx').append('src', 'upload/' + $('#user_pic4').val());
////                     jj(param).jjAjax2(false);
//                });


            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + cmsUser.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swUserTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? innerPanelHeight : tableHeight);
        param += "&jj=1";
       new jj(param).jjAjax2(false);
        cmsUser.tabSizeTbl();
    },
    m_show_form: function () {
        $('#swUserTbl').hide();
        $('#swUserForm').show();
        cmsUser.tabSizeForm();
    },
    m_clean: function () {
        $('#user_emailUser').css("border-color", "unset");
        $('#user_passUser').css("border-color", "unset");
        ;
        $("#errorRegistMessagePanel1").html('');
        $("#errorRegistMessagePanel2").html('');
        new jj("#swUserForm").jjFormClean();
        new jj("#user_grade").jjVal('');
        $('#PicPreview').attr('src', '');
        $('#PicPreviewPersonal').attr('src', '');
        $('#PicPreviewSignature').attr('src', '');
        $("#inputTextSelectorDiv").html('');
        $("#user_pic1").html('');
        $("#user_pic2").html('');
        $("#user_pic3").html('');
        $("#user_pic4").html('');
        $("#inputAfterSelect").html('');
        
         new jj("#user_attachPicPersonal").jjVal('');
         new jj("#user_attachPicPersonnelCard").jjVal('');
         new jj("#user_attachPicSignature").jjVal('');


//         $("#usersPicPreview1").removeAttr("src");
//         $("#userPicPreview1").removeAttr("src");
        new jj("#" + cmsUser.f_user_id).jjVal('');
        new jj("#" + cmsUser.f_pass).jjVal('');
        new jj("#" + cmsUser.f_name).jjVal('');
        new jj("#" + cmsUser.f_family).jjVal('');
        new jj("#" + cmsUser.f_email).jjVal('');
        new jj("#" + cmsUser.f_isActive).jjVal('');
        new jj("#" + cmsUser.f_registDate).jjVal('');
        new jj("#" + cmsUser.f_birthdate).jjVal('');
        new jj("#" + cmsUser.f_question).jjVal('');
        new jj("#" + cmsUser.f_answer).jjVal('');
        new jj("#" + cmsUser.f_no1).jjVal('');
        new jj("#" + cmsUser.f_no2).jjVal('');
        new jj("#" + cmsUser.f_parent).jjVal('');
    },
    m_add_new: function () {
       new jj("do=" + cmsUser.tableName + ".add_new").jjAjax2(false);
       $("#DownloadPicPersonal").hide();
       $("#DownloadPicPersonnelCard").hide();
       $("#DownloadPicSignature").hide();
        cmsUser.m_show_form();
        cmsUser.m_clean();
        cmsUser.m_getGroups();
    },
    m_show_tbl: function () {
        $('#swUserTbl').show();
        $('#swUserForm').hide();

        if ($('#swUserTbl').html() == "") {
            cmsUser.m_refresh();
        }
        cmsUser.tabSizeTbl();
    },
    m_insert: function () {

        var param = "";
        param += "do=" + cmsUser.tableName + ".insert";
//        var email = $("#user_emailUser").val();
        
//        if (validateEmail(email) && new jj('#user_emailUser').jjVal() !== "") {
//            $("#user_emailUser").css("border-color", "blue");
////        validateflag = true;
//            $("#errorRegistMessagePanel1").html('');
//        } else {
//            $("#user_emailUser").css("border-color", "red");
//            $("#errorRegistMessagePanel1").html('');
//            $("#errorRegistMessagePanel1").append('لطفا ایمیل خود راوارد کنید');
//            flag = false;
//        }
//        var pass = $("#user_passUser").val();
//        if (validatePass(pass) && new jj('#user_pass').jjVal() != "") {
//            $('#user_passUser').css("border-color", "blue");
//            $("#errorRegistMessagePanel2").html('');
//
////        validateflag = true;
//        } else {
//            $("#user_passUser").css("border-color", "red");
//            $("#errorRegistMessagePanel2").html('');
//            $("#errorRegistMessagePanel2").append('برای رمز عبور لطفاحداقل 8کاراکتر وارد نمایید.');
//            flag = false;
//        }
//        if ((validatePass(pass) && new jj('#user_passUser').jjVal() != "") & (validateEmail(email) && new jj('#user_emailUser').jjVal() !== "")) {
            param += "&" +new jj('#AccessuserForm').jjSerial();
//            param += "&" + jj('#AccessuserForm').jjSerial();
            new jj(param).jjAjax2(false);

            cmsUser.m_show_tbl();
            cmsUser.m_clean();
//        }
    },

    m_edit: function () {
        var param = "";
        param += "do=" + cmsUser.tableName + ".edit";
//        param += "&pic=" + $('#user_file_personal').val();
        param += "&pic=" + $('#swUser').val();
        param += "&user_attachAxPersonal=" + $('#user_attachPicPersonal').val();
        param += "&user_attachAxPersonnelCard=" + $('#user_attachPicPersonnelCard').val();
        param += "&user_attachAxSignature=" + $('#user_attachPicSignature').val();
        param += "&user_attachFile=" + $('#user_attachFile').val();
        param += "&" +new jj('#swUser').jjSerial(param);


        new jj(param).jjAjax2(false);
        cmsUser.m_show_tbl();
        $("#inputTextSelectorDiv").html('');

    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('cmsUser.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + cmsUser.tableName + ".delete";
        param += "&" + cmsUser.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        cmsUser.m_show_tbl();
        cmsUser.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + cmsUser.tableName + ".select";
        param += "&" + cmsUser.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        cmsUser.m_show_form();
        cmsUser.m_getGroups(id);

    },

    m_getGroups: function (id) {
        var param = "";
        param += "do=" + cmsGroup.tableName + ".getCheckboxList";
        param += "&panel=group_checkbox_list";
        param += "&" + cmsUser.f_user_id + "=" + (id == null ? "" : id);
       new jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swAccessAll').css('height', 519);
        cmsUser.heightTab = 519;
    },
    tabSizeForm: function () {
        $('#swAccessAll').css('height', 353);
        cmsUser.heightTab = 353;
    },
    heightTab: "519",
    mainTabSetSize: function () {
        $('#swAccessAll').css('height', cmsUser.heightTab);
    }
}
function loginToCMS() {
    new jj("do=Access_User.login&" + (new jj("#swLoginForm").jjSerial())).jjAjax2();

}
