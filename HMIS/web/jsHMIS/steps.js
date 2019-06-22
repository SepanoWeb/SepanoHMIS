/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisSteps = {
    tableName: "Steps",
    f_id: "id",

    loadForm: function () {
        if ($("#swStepsForm").html() == '') {
            $("#swStepsForm").load("formHMIS/04Steps.html", null, function () {

            });
        }
    },
    m_refresh: function () {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".refresh";
//        param += "&panel=" + (containerId == null ? "swContentTbl" : containerId);
//        param += "&sort=" + (sortField == null ? "0" : sortField);
//        param += "&height=" + (tableHeight == null ? PanelHeight : tableHeight);
        new jj(param).jjAjax2(false);
//        himsPlansForAssess.tabSizeTbl();
    },
    m_show_form: function () {
        $('#swStepsTbl').hide();
        $('#swStepsForm').show();
        hmisSteps.tabSizeForm();
    },
    m_clean: function () {
        new jj("#" + hmisSteps.f_content_id).jjVal("");
        new jj("#" + hmisSteps.f_title).jjVal("");
        new jj("#" + hmisSteps.f_lang).jjVal("1");
        new jj("#" + hmisSteps.f_parent).jjVal("0");
        new jj("#tags_name").jjVal("");
//        new jj(content_content_editor).jjEditorVal("");
//        $("#Content_Language_button").hide();
    },
    m_add_new: function () {
       new  jj("do=" + hmisSteps.tableName + ".add_new").jjAjax2(false);
        $('#stepsForm').slideDown();
        new jj('#stepsForm').jjFormClean();
        hmisSteps.m_show_form();
        hmisSteps.m_clean();
        //        oEditor.execCommand( 'bold');

    },
    m_show_tbl: function () {
        $('#swStepsTbl').show();
        $('#swStepsForm').hide();
        if ($('#swStepsTbl').html() == "") {
            hmisSteps.m_refresh();
        }
        hmisSteps.tabSizeTbl();
    },
    m_insert: function () {
//        var valid = hmisSteps.m_validation();
//        if (valid == "") {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".insert";
        param += "&" + new jj('#stepsForm').jjSerial();
        param += "&hmis_plans_id=" + new jj("#hmis_plans_id").jjVal();
        new jj(param).jjAjax2(false);
        hmisSteps.m_show_tbl();
        hmisSteps.m_clean();
//        $("html, body").delay(1000).animate({scrollTop: $('#tblSteps').offset().top}, 800);

//        } else {
//            new jj(valid).jjDialog();
//        }

    },
    m_edit: function () {
//        var valid = hmisSteps.m_validation();
//        if (valid == "") {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".edit";
        param += "&" + new jj('#swStepsForm').jjSerial();
        new jj(param).jjAjax2(false);
        hmisSteps.m_show_tbl();
        hmisSteps.m_clean();
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
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisSteps.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".delete";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisSteps.m_show_tbl();
        hmisSteps.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".select";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisSteps.m_show_form();
    },
    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".add_EN";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisSteps.f_parent).jjVal(id);
        new jj("#" + hmisSteps.f_lang).jjVal("2");
        hmisSteps.m_show_form();
    },
    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".add_Ar";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisSteps.f_parent).jjVal(id);
        new jj("#" + hmisSteps.f_lang).jjVal("3");
        hmisSteps.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".add_lang";
        param += "&" + hmisSteps.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisSteps.f_parent).jjVal(id);
        new jj("#" + hmisSteps.f_lang).jjVal(langId);
//        alert(id+"&&&&&"+langId);
        hmisSteps.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".searchTags";
        param += "&" + new jj('#swStepsForm').jjSerial();
        param += "&panel=content_search_tags_result";
        new jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".insertTags";
        param += "&" + new jj('#swStepsForm').jjSerial();
//        param += "&panel=content_tags_div";
        new jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swSteps').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swSteps').css('height', 378);
    }

};
//============ BY RASHIDI ========> 
function selectSearchResult(selectedTagNo) {
    $("#tags_name").val($("#tagsResult_td" + selectedTagNo).html());
    $("#content_search_tags_result").hide();
}

