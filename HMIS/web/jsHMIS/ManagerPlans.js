/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisManagerPlans = {
    tableName: "",
    f_id: "id",
    loadForm: function () {
        if ($("#swManagerPlansForm").html() == '') {
            $("#swManagerPlansForm").load("formHMIS/04MyPlan.html", null, function () {

                $("#cancel_MyPlans").click(function (e) {
                    hmisManagerPlans.m_clean();
                    hmisManagerPlans.m_show_tbl();
                });
                hmisManagerPlans.m_refresh();
                $('#commettesSecretoryDiv').hide();
                new jj("#myPlans_startDate").jjCalendarWithYearSelector(1370, 1420);
                new jj("#myPlans_endDate").jjCalendarWithYearSelector(1370, 1420);

            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".refreshManagerPlans";
        param += "&panel=" + (containerId == null ? "swManagerPlansTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },

    m_show_form: function () {
        $('#swManagerPlansTbl').slideUp('slow');
        $('#swManagerPlansForm').slideDown('slow');
        hmisManagerPlans.tabSizeForm();
    },
    m_clean: function () {
        new jj("#" + hmisManagerPlans.f_content_id).jjVal("");
        new jj("#" + hmisManagerPlans.f_title).jjVal("");
        new jj("#" + hmisManagerPlans.f_lang).jjVal("1");
        new jj("#" + hmisManagerPlans.f_parent).jjVal("0");

    },

    m_show_tbl: function () {
        $('#swManagerPlansTbl').show();
        $('#swManagerPlansForm').hide();
        if ($('#swManagerPlansTbl').html() == "") {
            hmisManagerPlans.m_refresh();
        }
        hmisManagerPlans.tabSizeTbl();
    },
    m_select: function (id) {
//        $("#addNewApproved").hide();
        var param = "";
        param += "do=" + hmisPlans.tableName + ".selectManagerPlans";
        param += "&" + hmisPlans.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisManagerPlans.m_show_form();
//        $("#insertApproved2").hide();
    },
    /**
     * تایید برنامه عملیاتی توسط مدیر
     * @param {type} id
     * @returns {undefined}
     */
    confirmByManager: function (id) {
            if (confirm("برنامه عملیاتی را تایید می کنید؟")) {
                hmisManagerPlans.confirmByManager_after_question(id);
            } else {
            }
       

    },
    /**
     * ای دی برنامه
     * @param {type} id
     * @returns {undefined}
     */
    confirmByManager_after_question: function (id) {
        var param = "";
        param += "&id=" + id;
        param += "&do=" + hmisPlans.tableName + ".confirmByManager";
        new jj(param).jjAjax2(false);
        hmisManagerPlans.m_clean();
    },
   
  
    /**
     * نمایش گامها وجزئیات گام ها  در برنامه عملیاتی من
     * @param {type} id
     * @returns {undefined}
     */
    selectStepsInManagerPlans: function (stepsId, plansId) {
        var param = "";
        param += "do=" + hmisSteps.tableName + ".selectStepsInManagerPlans";
        param += "&hmis_plans_id=" + plansId;
        param += "&hmis_steps_id=" + stepsId;
//        param += "&stepsId="+stepsId;
        new jj(param).jjAjax2(false);
        hmisPlans.m_show_form();
        $('#formQuestions').show(); //نمایش گام ها 
//        $('#newFormManagerPlans').hide(); //نمایش گام ها 
//        $('#editPlansButton').show(); //نمایش دکمه تغییرات
        $('#myPlansStepsForm').show(); //
        $("html, body").delay(1000).animate({scrollTop: $('#myPlansStepsForm').offset().top}, 800);
    },
    /**
     * رد برنامه عملیاتی توسط مافوق
     * 
     */
    ignoreByManager: function (id) {

        if (confirm("آیا  برنامه عملیاتی را رد می کنید؟")) {
            hmisManagerPlans.ignoreByManager_after_question(id);
        } else {
        }

    },
    /**
     * ای دی برنامه عملیاتی من
     * @param {type} id
     * @returns {undefined}
     */
    ignoreByManager_after_question: function (id) {
        var param = "";
        param += "&id=" + id;
        param += "&do=" + hmisPlans.tableName + ".ignoreByManager";
        new jj(param).jjAjax2(false);
        hmisManagerPlans.m_clean();
    },
   

    tabSizeTbl: function () {
        $('#swManagerPlans').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swManagerPlans').css('height', 378);
    },

};
