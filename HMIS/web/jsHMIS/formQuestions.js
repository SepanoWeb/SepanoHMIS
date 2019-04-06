/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisFormQuestions = {
    tableName: "FormQuestions",
    f_id: "id",
    /**
     * 
     * @param {type} formId آی دی فرم حتما باید باشد
     * @param {type} containerId
     * @returns {undefined}
     */
    m_refresh: function (formId, containerId) {
        var param = "";
        param += "do=" + hmisFormQuestions.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swFormQuestionsTbl" : containerId);
        param += "&formQuestions_formID=" + formId;
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisFormQuestions.m_show_tbl();
    },
    m_show_form: function () {
        $('#swFormQuestionsTbl').slideUp('slow');
        $('#swFormQuestionsForm').slideDown('slow');
        hmisFormQuestions.tabSizeForm();
        hmisFormQuestions.m_clean();
    },
    m_clean: function () {
        new jj("#swFormQuestionsForm").jjFormClean();
    },
    m_add_new: function () {
        new jj("do=" + hmisFormQuestions.tableName + ".add_new&jj=1").jjAjax2(false);
        hmisFormQuestions.m_show_form();
        hmisFormQuestions.m_clean();
        $('#swFormQuestionOptionsTbl').hide();
    },
    m_show_tbl: function () {
        $('#swFormQuestionsTbl').slideDown('slow');
        $('#swFormQuestionsForm').slideUp('slow');
//        $('#refreshForms').dataTable({//
        $('#swFormQuestionsTbl table').dataTable({//برای اینکه بعضی مواقع جدول در حالت رسپانسیو نمایش داده میشود
            destroy: true
        });
    },
    m_insert: function () {
        var param = "";
        param += "do=" + hmisFormQuestions.tableName + ".insert";
        param += "&" + new jj('#swFormQuestionsForm').jjSerial();
        param += "&formQuestions_formID=" + $("#hmis_forms_id").val();
        new jj(param).jjAjax2(false);

    },
    m_edit: function () {
        var param = "";
        param += "do=" + hmisFormQuestions.tableName + ".edit";
        param += "&" + new jj('#swFormQuestionsForm').jjSerial();
        new jj(param).jjAjax2(false);
    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo(' hmisFormQuestions.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisFormQuestions.tableName + ".delete";
        param += "&" + hmisFormQuestions.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
//        hmisFormQuestions.m_show_tbl();
//        hmisFormQuestions.m_clean();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisFormQuestions.tableName + ".select";
        param += "&" + hmisForms.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisFormQuestions.m_show_form();
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swForms').css('height', "auto");
    },
    tabSizeForm: function () {
        $('#swCommettes').css('height', 378);
    }
};