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
        if (new jj(questionId).jjIsDigit()) {// اگر آی دی سوال موجود نبود گزینه ها را نشان نمی دهیم
            var param = "";
            param += "do=" + hmisFormQuestionOptions.tableName + ".refresh";
            param += "&panel=" + (containerId == null ? "swFormQuestionOptionsTbl" : containerId);
            param += "&formQuestionOptions_question_id=" + questionId;
            param += "&jj=1";
            new jj(param).jjAjax2(false);
            hmisFormQuestionOptions.m_show_tbl();
        } else {
            return;
        }
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
        new jj("do=" + hmisFormQuestionOptions.tableName + ".add_new&jj=1").jjAjax2(false);
        hmisFormQuestionOptions.m_show_form();
        hmisFormQuestionOptions.m_clean();

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

    },
    m_edit: function (id) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".edit";
        param += "&" + new jj('#swFormQuestionOptionsForm').jjSerial();
        new jj(param).jjAjax2(false);

    },
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
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisFormQuestionOptions.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swForms').css('height', "auto");
    },
    tabSizeForm: function () {
        $('#swCommettes').css('height', 378);
    }
};