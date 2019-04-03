/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisApproved = {
    tableName: "Approved",
    f_id: "id",

    loadForm: function () {
        if ($("#swApprovedForm").html() == '') {
            $("#swApprovedForm").load("formHMIS/05newCommette.html", null, function () {
//                $('#sessions_time').wickedpicker();
//                $('#sessions_timeReminder').wickedpicker();
//                new jj("#sessions_date").jjCalendarWithYearSelector(1397, 1420);
//                new jj("#sessions_dateReminder").jjCalendarWithYearSelector(1397, 1420);

                $("#cancel_Approved").button().click(function (e) {
                    hmisApproved.m_clean();
                    hmisApproved.m_show_tbl();
                });



//                new jj("#upload_Content").jjAjaxFileUploadEditor('#upload_Content_file', content_content_editor);
//                $("#upload_Content_file").button().click(function () {
//                });
                //============ BY RASHIDI ========>
//                $("#content_insert_tags").button().click(function (e) {
//                    $("#" + cmsContent.f_tags).val($("#" + cmsContent.f_tags).val() + $("#tags_name").val() + ',');//تگ نوشته شده را به یک اینپوت مخفی اضافه می کند
//                   cmsContent.m_insertTags();
//
//                });
//               $('#tags_name').keyup(function () {
//                    if ($("#tags_name").val() === "") {
//                       $("#content_search_tags_result").hide();
//                   }
//                   cmsContent.m_searchTags();
//               });
                hmisApproved.m_refresh();
//                $('#newCommetteForm').show();
//                $('#formInvitation').hide();


            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swApprovedTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },
    m_show_form: function () {
        $('#swApprovedTbl').hide();
        $('#swApprovedForm').show();
        hmisApproved.tabSizeForm();
    },
    m_clean: function () {
        new jj("#" + hmisApproved.f_content_id).jjVal("");
        new jj("#" + hmisApproved.f_title).jjVal("");
        new jj("#" + hmisApproved.f_lang).jjVal("1");
        new jj("#" + hmisApproved.f_parent).jjVal("0");
        new jj("#insertMosavabeh2").jjFormClean();
        new jj("#approved_responsibleForTrackId").jjVal("");
        new jj("#approved_responsibleForExecutionId").jjVal("");

    },
    m_add_new: function () {

        new jj("#approved_startDate").jjCalendarWithYearSelector(1340, 1420);
        new jj("#approved_endDate").jjCalendarWithYearSelector(1340, 1420);
        jj("do=" + hmisApproved.tableName + ".add_new&jj=1").jjAjax2(false);
        hmisApproved.m_clean();
//        hmisApproved.m_show_form();
//                $('#newCommetteForm').show();
//                $('#formInvitation').hide();

        //        oEditor.execCommand( 'bold');

    },
    m_show_tbl: function () {
        $('#swApprovedTbl').show();
        $('#swApprovedForm').hide();
        if ($('#swApprovedTbl').html() == "") {
            hmisApproved.m_refresh();
        }
        hmisApproved.tabSizeTbl();
    },
    m_insert: function () {
//        var valid =  hmisApproved.m_validation();
//        if (valid == "") {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".insert";
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();
        param += "&" + new jj('#insertMosavabeh2').jjSerial();
        new jj(param).jjAjax2(false);
        hmisApproved.m_show_tbl();
        hmisApproved.m_clean();
//        } else {
//            new jj(valid).jjDialog();
//        }
    },
    m_edit: function () {
//        var valid = hmisPlan.m_validation();
//        if (valid == "") {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".edit";
        param += "&" + new jj('#insertMosavabeh2').jjSerial();
        param += "&hmis_sessions_id=" + new jj('#hmis_sessions_id').jjVal();

        new jj(param).jjAjax2(false);
        hmisApproved.m_show_tbl();
        hmisApproved.m_clean();
//        } else {
//            new jj(valid).jjDialog();
//        }
    },
//    m_validation: function () {// mohamdad
//        if (new jj("#content_title").jjVal().length < 1) {
//            return "فیلد عنوان نباید کوچکتر از دو کاراکتر باشد";
//        }
//        return "";
//    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo(' hmisApproved.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".delete";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisApproved.m_show_tbl();
        hmisApproved.m_clean();
    },
    m_select: function (id) {
        $('#insertMosavabeh2').slideDown();
        $("html, body").delay(1000).animate({scrollTop: $('#insertMosavabeh2').offset().top}, 800);

        var param = "";
        param += "do=" + hmisApproved.tableName + ".select";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        param += "&hmis_sessions_id=" +new jj('#hmis_sessions_id').jjVal();
        new jj(param).jjAjax2(false);
        hmisApproved.m_show_form();
    },
    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".add_EN";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisApproved.f_parent).jjVal(id);
        new jj("#" + hmisApproved.f_lang).jjVal("2");
        hmisApproved.m_show_form();
    },
    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".add_Ar";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisApproved.f_parent).jjVal(id);
        new jj("#" + hmisApproved.f_lang).jjVal("3");
        hmisApproved.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".add_lang";
        param += "&" + hmisApproved.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisApproved.f_parent).jjVal(id);
        new jj("#" + hmisApproved.f_lang).jjVal(langId);
//        alert(id+"&&&&&"+langId);
        hmisApproved.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".searchTags";
        param += "&" + new jj('#swApprovedForm').jjSerial();
//        param += "&panel=content_search_tags_result";
        new jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisApproved.tableName + ".insertTags";
        param += "&" + new jj('#swApprovedForm').jjSerial();
//        param += "&panel=content_tags_div";
        new jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swApproved').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swApproved').css('height', 378);
    },

    /////////////////////shiran////////////
//    showInvitationForm: function (commeteId) {
//        hmisApproved.m_show_form();
////        $('#hmis_commettes_id').val(commeteId);
////        $('#newCommetteForm').hide();
////        $('#formInvitation').show();
//    },
//    Invitees: function () {//مدعوین
//
//        var param = "";
//        var temp = $('#InviteesDiv input:checkbox[class=checkBoxInvitees]:checked');
//        var InviteesOutSide = $('#InviteesDiv input:text[class=InviteesOutSide]');
//
//        if (temp.size() == 0 && InviteesOutSide.size() == 0) {//اگر تیک عضوی را نزده بود
//            alert("لطفا افراد را انتخاب کنید");
//            return;
//        }
//        var temp1 = "";
//        var temp2 = "";
//        for (var i = 0; i < temp.size(); i++) {
//            temp1 += $(temp[i]).attr('value') + "%23A%23"; //نام چک باکس عدد مورد نظر
//        }
//        for (var i = 0; i < InviteesOutSide.size(); i++) {
//            if ($(InviteesOutSide[i]).val() !== "") {
//                temp2 += $(InviteesOutSide[i]).val() + "%23A%23"; //نام چک باکس عدد مورد نظر
//            }
//        }
//        alert(temp2);
//        alert(temp1);
//        param += "&sessions_Invitees=" + temp1;
//        param += "&sessions_InviteesOutSide=" + temp2;
//        param += "&commettesId=" + new jj("#hmis_commettes_id").jjVal();//ای دی کمیته
//        param += "&" + new jj('#formInvitation').jjSerial();
//        param += "&do=Sessions.requestSendComment&jj=1";
//        new jj(param).jjAjax2(false);
//    },

//    mainTabSetSize: function () {
////        var aa = $("#swContent").children();
////        var bb = 0;
////        for(i=0; i < aa.length; i++){  
////            if($(aa[i]).css("display")!='none'){
////                bb+= new jj($(aa[i]).css("height")).jjConvertToInt() ;
////            }
////        }
////        if(bb==0){
////            $('#tabs').css('height',572);
////        }else{
////            $('#tabs').css('height',bb+44);
////        }
//    }

};
//============ BY RASHIDI ========> 
//function selectSearchResult(selectedTagNo) {
//    $("#tags_name").val($("#tagsResult_td" + selectedTagNo).html());
//    $("#content_search_tags_result").hide();
//}

//function deleteContentTag(deletedTagNo) {
//    new jj("آیا از حذف این برچسب اطمینان دارید؟").jjDialog_YesNo('afterDeleteContentTag(' + deletedTagNo + ');\n', true, "");
//}
//function afterDeleteContentTag(deletedTagNo) {
//
////    var myString = $("#" + cmsContent.f_tags).val();
////    var oldWord = $("#contetn_tag_span" + deletedTagNo).html().toString();
////    var reg = new RegExp(oldWord, "g");
////    myString = myString.replace(reg, "");
////    alert(myString);
//
//    var str = $("#" + cmsContent.f_tags).val();
//    var tagName = $("#contetn_tag_span" + deletedTagNo).html().toString();
//    var reg = new RegExp(tagName, "g");
//    str = str.replace(reg, "");
//    $("#" + cmsContent.f_tags).val(str);
//    $("#contetn_tag_span" + deletedTagNo).remove();
//}
//<============ BY RASHIDI ========  