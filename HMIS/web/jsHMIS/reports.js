/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisReports = {
    tableName: "Reports",
    f_id: "id",
   
    loadForm: function () {
        if ($("#swReportsForm").html() == '') {
            $("#swReportsForm").load("formHmis/04reports.html", null, function () {
             $("#cancel_Reports").button().click(function (e) {
                    hmisReports.m_clean();
                    hmisReports.m_show_tbl();
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
                //<============ BY RASHIDI ========
                hmisReports.m_show_form();
            });
        }
    },
//    m_refresh: function (containerId,sortField,tableHeight) {
//        var param = "";
//        param += "do=" + hmisReports.tableName + ".refresh";
//        param += "&panel=" + (containerId == null ? "swReportsTbl" : containerId);
//        param += "&sort=" + (sortField == null ? "0" : sortField);
//        param += "&height=" + (tableHeight == null ? 435 : tableHeight);
//        param += "&jj=1";
//        jj(param).jjAjax2(false);
////        himsPlansForAssess.tabSizeTbl();
//    },
    m_show_form: function () {
        $('#swReportsTbl').hide();
        $('#swReportsForm').show();
        hmisReports.tabSizeForm();
    },
    m_clean: function () {
        new jj("#" + hmisReports.f_content_id).jjVal("");
        new jj("#" + hmisReports.f_title).jjVal("");
        new jj("#" + hmisReports.f_lang).jjVal("1");
        new jj("#" + hmisReports.f_parent).jjVal("0");
        new jj("#tags_name").jjVal("");
//        new jj(content_content_editor).jjEditorVal("");
//        $("#Content_Language_button").hide();
    },
    m_add_new: function () {
        jj("do=" + hmisReports.tableName + ".add_new").jjAjax2(false);
        hmisReports.m_show_form();
        hmisReports.m_clean();
        //        oEditor.execCommand( 'bold');

    },
    m_show_tbl: function () {
        $('#swReportsTbl').show();
        $('#swReportsForm').hide();
        if ($('#swReportsTbl').html() == "") {
            hmisReports.m_refresh();
        }
        hmisReports.tabSizeTbl();
    },
    m_insert: function () {
        var valid = hmisReports.m_validation();
        if (valid == "") {
            var param = "";
            param += "do=" + hmisReports.tableName + ".insert";
            param += "&" + new jj('#swReportsForm').jjSerial();
            jj(param).jjAjax2(false);
            hmisReports.m_show_tbl();
            hmisReports.m_clean();
        } else {
            new jj(valid).jjDialog();
        }
    },
    m_edit: function () {
//        var valid = hmisReports.m_validation();
//        if (valid == "") {
            var param = "";
            param += "do=" + hmisReports.tableName + ".edit";
            param += "&" + new jj('#swReportsForm').jjSerial();
            jj(param).jjAjax2(false);
            hmisReports.m_show_tbl();
            hmisReports.m_clean();
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
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisReports.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisReports.tableName + ".delete";
        param += "&" + hmisReports.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        hmisReports.m_show_tbl();
        hmisReports.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisReports.tableName + ".select";
        param += "&" + hmisReports.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        hmisReports.m_show_form();
    },
    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisReports.tableName + ".add_EN";
        param += "&" + hmisReports.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        new jj("#" + hmisReports.f_parent).jjVal(id);
        new jj("#" + hmisReports.f_lang).jjVal("2");
        hmisReports.m_show_form();
    },
    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisReports.tableName + ".add_Ar";
        param += "&" + hmisReports.f_id + "=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
        new jj("#" + hmisReports.f_parent).jjVal(id);
        new jj("#" + hmisReports.f_lang).jjVal("3");
        hmisReports.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisReports.tableName + ".add_lang";
        param += "&" + hmisReports.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        jj(param).jjAjax2(false);
        new jj("#" + hmisReports.f_parent).jjVal(id);
        new jj("#" + hmisReports.f_lang).jjVal(langId);
//        alert(id+"&&&&&"+langId);
        hmisReports.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisReports.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisReports.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisReports.tableName + ".searchTags";
        param += "&" + new jj('#swReportsForm').jjSerial();
        param += "&panel=content_search_tags_result";
        jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisReports.tableName + ".insertTags";
        param += "&" + new jj('#swReportsForm').jjSerial();
//        param += "&panel=content_tags_div";
        jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swReports').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swReports').css('height', 378);
    }
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
function selectSearchResult(selectedTagNo) {
    $("#tags_name").val($("#tagsResult_td" + selectedTagNo).html());
    $("#content_search_tags_result").hide();
}

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
//    var str = $("#" + hmisReports.f_tags).val();
//    var tagName = $("#contetn_tag_span" + deletedTagNo).html().toString();
//    var reg = new RegExp(tagName, "g");
//    str = str.replace(reg, "");
//    $("#" + hmisReports.f_tags).val(str);
//    $("#contetn_tag_span" + deletedTagNo).remove();
//}
//<============ BY RASHIDI ========  