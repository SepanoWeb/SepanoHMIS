/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisMyPlans = {
    tableName: "",
    f_id: "id",
    loadForm: function () {
        if ($("#swMyPlansForm").html() == '') {
            $("#swMyPlansForm").load("formHMIS/04MyPlan.html", null, function () {

                $("#cancel_MyPlans").click(function (e) {
                    hmisMyPlans.m_clean();
                    hmisMyPlans.m_show_tbl();
                });
                hmisMyPlans.m_refresh();
                $('#commettesSecretoryDiv').hide();
                new jj("#myPlans_startDate").jjCalendarWithYearSelector(1370, 1420);
                new jj("#myPlans_endDate").jjCalendarWithYearSelector(1370, 1420);

            });
        }
        hmisRole.getSelectOption("#swMyPlansForm #myPlans_supervisorRolId");
        hmisRole.getSelectOption("#swMyPlansForm #plans_improveQualityId");
        hmisDepartment.selectOptionDepartment("myPlans_department");
        hmisDepartment.selectOptionDepartment("myPlans_domain");
        $("#myPlans_supervisorRolId").select2({
            width: '100%'
        });
        $("#plans_improveQualityId").select2({
            width: '100%'
        });
        $("#myPlans_department").select2({
            width: '100%'
        });
        $("#myPlans_domain").select2({
            width: '100%'
        });
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".refreshMyPlans";
        param += "&panel=" + (containerId == null ? "swMyPlansTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },

    m_show_form: function () {
        $('#swMyPlansTbl').slideUp('slow');
        $('#swMyPlansForm').slideDown('slow');
        hmisMyPlans.tabSizeForm();
    },
    m_clean: function () {
        new jj("#" + hmisMyPlans.f_content_id).jjVal("");
        new jj("#" + hmisMyPlans.f_title).jjVal("");
        new jj("#" + hmisMyPlans.f_lang).jjVal("1");
        new jj("#" + hmisMyPlans.f_parent).jjVal("0");

    },

    m_show_tbl: function () {
        $('#swMyPlansTbl').show();
        $('#swMyPlansForm').hide();
        if ($('#swMyPlansTbl').html() == "") {
            hmisMyPlans.m_refresh();
        }
        hmisMyPlans.tabSizeTbl();
    },
    m_select: function (id) {
//        $("#addNewApproved").hide();
        var param = "";
        param += "do=" + hmisPlans.tableName + ".selectMyPlans";
        param += "&" + hmisPlans.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisMyPlans.m_show_form();
//        $("#insertApproved2").hide();
    },
    /**
     * تایید برنامه عملیاتی توسط مافوق
     * @param {type} id
     * @returns {undefined}
     */
    communicatedBySupervisor: function (id) {
        if (!$("#plans_improveQualityId option:selected").val() == "") {
            if (confirm("برنامه عملیاتی را تایید می کنید؟")) {
                hmisMyPlans.communicatedBySupervisor_after_question(id);
            } else {
            }
        } else {
            new jj("مسئول بهبود کیفیت را انتخاب کنید.").jjModal("پیام سامانه")
        }

    },
    /**
     * ای دی برنامه
     * @param {type} id
     * @returns {undefined}
     */
    communicatedBySupervisor_after_question: function (id) {
        var param = "";
        param += "&id=" + id;
        param += "&plans_improveQualityId=" + new jj("#plans_improveQualityId").jjVal();//ای دی بهبود کیفیت
        param += "&do=" + hmisPlans.tableName + ".communicatedBySupervisor";
        new jj(param).jjAjax2(false);
        hmisMyPlans.m_clean();
    },
    communicatedByImproveQuality: function (id) {
        if (!$("#plans_commettesId option:selected").val() == "") {
            if (confirm("برنامه عملیاتی را تایید می کنید؟")) {
                hmisMyPlans.communicatedByImproveQuality_after_question(id);
            } else {
            }
        } else {
            new jj(" کمیته را انتخاب کنید.").jjModal("پیام سامانه")
        }

    },
    /**
     * ای دی برنامه
     * @param {type} id
     * @returns {undefined}
     */
    communicatedByImproveQuality_after_question: function (id) {
        var param = "";
        param += "&id=" + id;
        param += "&plans_commettesId=" + new jj("#plans_commettesId").jjVal();//ای دی دبیر کمیته
        param += "&do=" + hmisPlans.tableName + ".communicatedByImproveQuality";
        new jj(param).jjAjax2(false);
        hmisMyPlans.m_clean();
    },

    /**
     * نمایش گامها وجزئیات گام ها  در برنامه عملیاتی من
     * @param {type} id
     * @returns {undefined}
     */
    selectStepsInMyPlans: function (stepsId, plansId) {
//         alert(id);
        var param = "";
        param += "do=" + hmisSteps.tableName + ".selectStepsInMyPlans";
        param += "&hmis_plans_id=" + plansId;
        param += "&hmis_steps_id=" + stepsId;
//        param += "&stepsId="+stepsId;
        new jj(param).jjAjax2(false);
        hmisPlans.m_show_form();
        $('#formQuestions').show(); //نمایش گام ها 
//        $('#newFormMyPlans').hide(); //نمایش گام ها 
//        $('#editPlansButton').show(); //نمایش دکمه تغییرات
        $('#myPlansStepsForm').show(); //
        $("html, body").delay(1000).animate({scrollTop: $('#myPlansStepsForm').offset().top}, 800);
    },
    /**
     * رد برنامه عملیاتی توسط مافوق
     * 
     */
    ignoreBySupervisor: function (id) {

        if (confirm("آیا  برنامه عملیاتی را رد می کنید؟")) {
            hmisMyPlans.ignoreBySupervisor_after_question(id);
        } else {
        }

    },
    /**
     * ای دی برنامه عملیاتی من
     * @param {type} id
     * @returns {undefined}
     */
    ignoreBySupervisor_after_question: function (id) {
        var param = "";
        param += "&id=" + id;
        param += "&do=" + hmisPlans.tableName + ".ignoreBySupervisor";
        new jj(param).jjAjax2(false);
        hmisMyPlans.m_clean();
    },
    ignoreByImproveQuality: function (id) {

        if (confirm("آیا  برنامه عملیاتی را رد می کنید؟")) {
            hmisMyPlans.ignoreByImproveQuality_after_question(id);
        } else {
        }

    },
    /**
     * ای دی برنامه عملیاتی من
     * @param {type} id
     * @returns {undefined}
     */
    ignoreByImproveQuality_after_question: function (id) {
        var param = "";
        param += "&id=" + id;
        param += "&do=" + hmisPlans.tableName + ".ignoreByImproveQuality";
        new jj(param).jjAjax2(false);
        hmisMyPlans.m_clean();
    },
    executorActionMyPlans: function (value) {
        if (value == "سمت") {
            $("#MyPlansSteps_executorUserId").attr("disabled", "disabled");
            $("#MyPlansSteps_executorRoleId").removeAttr("disabled");
            $("#MyPlansSteps_executorUserId").val("");
            $("#MyPlansSteps_executorUserId").select2();
        } else if (value == "کاربران") {
            $("#MyPlansSteps_executorRoleId").attr("disabled", "disabled");
            $("#MyPlansSteps_executorUserId").removeAttr("disabled");
            $("#MyPlansSteps_executorRoleId").select2();
            $("#MyPlansSteps_executorRoleId").val("");
        }

    },
    /**
     * ای دی جلسات 
     * ای دی فرد امضا کننده
     * امضای کردن صورتجلسه
     * @returns {undefined}
     */
//    actionSigners: function (sessionsId, userId) {
//alert(';;;;;;;;;;;;;;;;;;;;;;;;;;');
//        var param = "";
//        param += "do=" + hmisSessions.tableName + ".actionSigners";
//        param += "&" + hmisSessions.f_id + "=" + (id == null ? "" : id);
//        param += "&hmis_sessions_id="+sessionsId;
//        param += "&userId="+userId;
//        new jj(param).jjAjax2(false);
//        hmisSessions.m_show_form();
//    },

    tabSizeTbl: function () {
        $('#swMyPlans').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swMyPlans').css('height', 378);
    },

};
