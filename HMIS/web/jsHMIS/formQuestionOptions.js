/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisFormQuestionOptions = {
    tableName: "FormQuestionOptions",
    f_id: "id",
    /**
     * 
     * @param {type} formId آی دی فرم حتما باید باشد
     * @param {type} containerId
     * @returns {undefined}
     */
    m_refresh: function (questionId, containerId) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swFormQuestionOptionsTbl" : containerId);
        param += "&formQuestionOptions_question_id=" + questionId;
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisFormQuestionOptions.m_show_tbl();
    },
    m_show_form: function () {
        $('#swFormQuestionOptionsTbl').slideUp('slow');
        $('#swFormQuestionOptionsForm').slideDown('slow');
        hmisFormQuestionOptions.tabSizeForm();
        hmisFormQuestionOptions.m_clean();
    },
    m_clean: function () {
        new jj("#swFormQuestionOptionsForm").jjFormClean();
    },
    m_add_new: function () {
//        $('#fromDetail').slideUp('slow');
        new jj("do=" + hmisFormQuestionOptions.tableName + ".add_new&jj=1").jjAjax2(false);
        hmisFormQuestionOptions.m_show_form();
        hmisFormQuestionOptions.m_clean();
        //        oEditor.execCommand( 'bold');

    },
    m_show_tbl: function () {
        $('#swFormQuestionOptionsTbl').slideDown('slow');
        $('#swFormQuestionOptionsForm').slideUp('slow');
    },
    m_insert: function () {
//        var valid =  hmisFormQuestionOptions.m_validation();
//        if (valid == "") {        
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".insert";
        param += "&" + new jj('#swFormQuestionOptionsForm').jjSerial();
        param += "&formQuestionOptions_question_id=" + $("#hmis_formquestions_id").val();
        new jj(param).jjAjax2(false);
//        this.m_show_tbl();
//        this.m_clean();
//        } else {
//            new jj(valid).jjDialog();
//        }
    },
    m_edit: function (id) {
//        var valid = hmisPlan.m_validation();
//        if (valid == "") {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".edit";
        param += "&" + new jj('#swFormQuestionOptionsForm').jjSerial();
//        param += "&id=" + new jj('#hmis_commettes_id').jjVal();
        new jj(param).jjAjax2(false);
//        hmisFormQuestionOptions.m_show_tbl();
//        hmisFormQuestionOptions.m_clean();
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
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisFormQuestionOptions.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".delete";
        param += "&" + hmisFormQuestionOptions.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisFormQuestionOptions.m_show_tbl();
        hmisFormQuestionOptions.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".select";
        param += "&" + hmisForms.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisFormQuestionOptions.m_show_form();
    },
    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".add_EN";
        param += "&" + hmisFormQuestionOptions.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisFormQuestionOptions.f_parent).jjVal(id);
        new jj("#" + hmisFormQuestionOptions.f_lang).jjVal("2");
        hmisFormQuestionOptions.m_show_form();
    },
    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".add_Ar";
        param += "&" + hmisFormQuestionOptions.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisFormQuestionOptions.f_parent).jjVal(id);
        new jj("#" + hmisFormQuestionOptions.f_lang).jjVal("3");
        hmisFormQuestionOptions.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".add_lang";
        param += "&" + hmisFormQuestionOptions.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisFormQuestionOptions.f_parent).jjVal(id);
        new jj("#" + hmisFormQuestionOptions.f_lang).jjVal(langId);
//        alert(id+"&&&&&"+langId);
        hmisFormQuestionOptions.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".searchTags";
        param += "&" + new jj('#swCommettesForm').jjSerial();
//        param += "&panel=content_search_tags_result";
        new jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".insertTags";
        param += "&" + new jj('#swCommettesForm').jjSerial();
//        param += "&panel=content_tags_div";
        new jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swForms').css('height', "auto");
    },
    tabSizeForm: function () {
        $('#swCommettes').css('height', 378);
    },
    /////////////////////shiran////////////
    showInvitationForm: function (commeteId) {
        hmisFormQuestionOptions.m_show_form();
        $('#hmis_commettes_id').val(commeteId);
        $('#newCommetteForm').hide();
        $('#formInvitation').show();
    },
    Invitees: function () {//مدعوین

        var param = "";
        var temp = $('#InviteesDiv input:checkbox[class=checkBoxInvitees]:checked');
        var InviteesOutSide = $('#InviteesDiv input:text[class=InviteesOutSide]');

        if (temp.size() == 0 && InviteesOutSide.size() == 0) {//اگر تیک عضوی را نزده بود
            alert("لطفا افراد را انتخاب کنید");
            return;
        }
        var temp1 = "";
        var temp2 = "";
        for (var i = 0; i < temp.size(); i++) {
            temp1 += $(temp[i]).attr('value') + "%23A%23"; //نام چک باکس عدد مورد نظر
        }
        for (var i = 0; i < InviteesOutSide.size(); i++) {
            if ($(InviteesOutSide[i]).val() !== "") {
                temp2 += $(InviteesOutSide[i]).val() + "%23A%23"; //نام چک باکس عدد مورد نظر
            }
        }
        alert(temp2);
        alert(temp1);
        param += "&sessions_Invitees=" + temp1;
        param += "&sessions_InviteesOutSide=" + temp2;
        param += "&commettesId=" + new jj("#hmis_commettes_id").jjVal();//ای دی کمیته
        param += "&" + new jj('#formInvitation').jjSerial();
        param += "&do=Sessions.requestSendComment&jj=1";
        new jj(param).jjAjax2(false);
    },
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