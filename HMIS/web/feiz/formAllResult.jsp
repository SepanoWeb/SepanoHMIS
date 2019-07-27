<%--
    Document   : formResult
    Created on : May 17, 2019, 5:28:43 PM
    Author     : Mohammad
--%>

<%@page import="sun.security.util.Length"%>
<%@page import="HMIS.Role"%>
<%@page import="jj.jjCalendar_IR"%>
<%@page import="HMIS.FormQuestionOptions"%>
<%@page import="HMIS.FormAnswers"%>
<%@page import="HMIS.FormQuestions"%>
<%@page import="jj.jjNumber"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cms.access.Access_User"%>
<%@page import="jj.jjDatabaseWeb"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="HMIS.Forms"%>
<%@page import="HMIS.FormAnswerSet"%>
<%@page import="cms.tools.jjTools"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getAttribute("db") == null) {
        return;
    }
    jjDatabaseWeb db = (jjDatabaseWeb) request.getAttribute("db");
    String formId = jjTools.getParameter(request, FormAnswerSet._formId);
//    String where = Forms._id + "=" + formId + " AND " + Forms._isActive + "=1";
    List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(Forms.tableName, Forms._id + "=" + formId));
    //انتخاب همه ی پاسخ های داده شده به فرم
    String sql = " SELECT hmis_formquestions.*,hmis_formAnswerSet.*,role_title,formQuestionOptions_value,formQuestionOptions_lable,formanswers_answerSet_id,formanswers_answer,formanswers_questionId "
            + " FROM hmis_formanswers LEFT JOIN hmis_formquestions on"
            + " hmis_formanswers.formanswers_questionId= hmis_formquestions.id "
            + " LEFT JOIN hmis_formAnswerSet  on hmis_formanswers.formanswers_answerSet_id= hmis_formAnswerSet.id"
            + " LEFT JOIN hmis_role  on hmis_formanswerset.formAnswers_userRole= hmis_role.id"
            + " LEFT JOIN hmis_formquestionoptions  on hmis_formanswers.formanswers_answer= hmis_formquestionoptions.id"
            + " WHERE "
            + " formQuestions_formID=" + formId + " AND formAnswers_status='" + FormAnswerSet.statues_sabteNahei + "' group by formanswers_answerSet_id,formanswers_questionId ;";
    List<Map<String, Object>> questionsAnswerRows = jjDatabaseWeb.separateRow(db.otherSelect(sql));
    List<Map<String, Object>> questionsRow = jjDatabaseWeb.separateRow(db.Select(FormQuestions.tableName, FormQuestions._formID + "=" + formId));

    List<Map<String, Object>> roleRows = jjDatabaseWeb.separateRow(db.otherSelect("SELECT hmis_role.id,role_title from hmis_formanswerset LEFT JOIN hmis_role on formAnswers_userRole=hmis_role.id group by formAnswers_userRole;"));
    StringBuilder roleOptionsHtml = new StringBuilder();// برای انتخاب نقش هایی که این فرم را پر کرده اند در گزارش های مختلف یکبار ایجاد می کنیم و چند بار استفاده می کنیم
    for (int i = 0; i < roleRows.size(); i++) {
        if (!roleRows.get(i).get(Role._id).toString().isEmpty()) {//اگر نقش مورد نظر تهی نباشد چون ممکن است نقش یک ست پاسخ تهی باشد
            roleOptionsHtml.append("<option value=" + roleRows.get(i).get(Role._id) + ">" + roleRows.get(i).get(Role._title) + "</option>");
        }
    }
    List<Map<String, Object>> userRows = jjDatabaseWeb.separateRow(db.otherSelect("SELECT access_user.id,user_name,user_family from hmis_formanswerset LEFT JOIN access_user on formAnswers_userId=access_user.id group by formAnswers_userId;"));
    StringBuilder userOptionsHtml = new StringBuilder();// برای انتخاب نقش هایی که این فرم را پر کرده اند در گزارش های مختلف یکبار ایجاد می کنیم و چند بار استفاده می کنیم
    for (int i = 0; i < userRows.size(); i++) {
        if (!userRows.get(i).get(Access_User._id).toString().isEmpty()) {//اگر نقش مورد نظر تهی نباشد چون ممکن است نقش یک ست پاسخ تهی باشد
            System.out.println("<option value=" + userRows.get(i).get(Access_User._id) + ">" + userRows.get(i).get(Access_User._name + " " + Access_User._family) + "</option>");
            userOptionsHtml.append("<option value=" + userRows.get(i).get(Access_User._id) + ">" + userRows.get(i).get(Access_User._name) + " " + userRows.get(i).get(Access_User._family) + "</option>");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>آمار  و نتایج کلی  <%=formRow.get(0).get(Forms._title)%></title>
        <link href="./Manager/font-awesome.css" rel="stylesheet" />
        <link href="./Manager/ionicons.css" rel="stylesheet" />
        <link href="./Manager/perfect-scrollbar.css" rel="stylesheet" />
        <!--time picker-->
        <!--<link href="Manager/css/wickedpicker.min.css" rel="stylesheet" />-->
        <!--DataTable-->
        <link href="Manager/dataTable/jquery.dataTables.css" rel="stylesheet"/>
        <link href="Manager/dataTable/select2.min.css" rel="stylesheet"/>

        <!--TextEditor-->
        <!--<link href="Manager/textEditor/medium-editor.css" rel="stylesheet">-->
        <!--<link href="Manager/textEditor/default.css" rel="stylesheet">-->
        <!--<link href="Manager/textEditor/summernote-bs4.css" rel="stylesheet">-->
        <!--<link href="Manager/textEditor/summernote.css" rel="stylesheet">-->

        <!--forms-->
        <!--<link href="Manager/forms/select2.min.css" rel="stylesheet">-->
        <!--<link href="Manager/forms/spectrum.css" rel="stylesheet">-->

        <!-- MedYar مدیار CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="Manager/shamcey.css">
        <!--<link href="css/bootstap.min.css" rel="stylesheet" type="text/css"/>-->
        <!--<link href="Manager/cssw.css" rel="stylesheet" type="text/css"/>-->
        <link href="Manager/css/HMIS.css" rel="stylesheet" type="text/css"/>
        <link href="Manager/css/endUserStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="sh-pagebody">
            <div class="row row-sm">
                <div class="col-xl-12">
                    <div class="card bd-primary">
                        <div class="sh-pagebody">
                            <div class="row row-sm">
                                <div class="col-xl-12">
                                    <div id='formCountResult_period' class="card bd-primary">
                                        <div class="card-header bg-purple tx-white">آنالیز عملکرد دوره ای  یک نقش و یا یک  فرد برای این فرم :</div>
                                        <div class="card bd-primary sh-pagebody">
                                            <div class="row">
                                                <div class="col-lg-9">
                                                    نمودار برای
                                                    <select id="axel_y" name="axel_y" class="form-control" style="width: 100%">
                                                        <option value='COUNT(hmis_formanswerset.id)'>تعداد فرم ثبت نهایی شده</option>
                                                        <option value='sum'>مجموع امتیازات</option>
                                                        <option value='avg'>میانگین امتیازات</option>
                                                        <%
                                                            for (int i = 0; i < questionsRow.size(); i++) {//فقط چند گزینه ای ها را نشان میدهیم
                                                                if (questionsRow.get(i).get(FormQuestions._answersType).toString().equals("radio")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("select_option")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("number")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("checkbox")) {
                                                                    System.out.println("----------------------------------------------");
                                                                    System.out.println(questionsRow.get(i).get(FormQuestions._answersType).toString());
                                                                    System.out.println("----------------------------------------------");

                                                        %>
                                                        <option value="<%=questionsRow.get(i).get(FormQuestions._id)%>">مجموع عددی سوال<%=questionsRow.get(i).get(FormQuestions._title)%></option>
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                </div>                                                
                                                <div class="col-lg-3">
                                                    محور افقی دوره های زمانی :
                                                    <select id="div" name="div" class="form-control" style="width: 100%">
                                                        <option value="">انتخاب کنید</option>
                                                        <option value="1">روزانه</option>
                                                        <option value="7">7 روزه</option>
                                                        <option value="30">30 روزه</option>
                                                        <option value="60">60 روزه</option>
                                                        <option value="90">90 روزه</option>
                                                        <option value="180">180 روزه</option>
                                                        <option value="365">365 روزه</option>
                                                    </select>
                                                </div>                                                
                                                <div class="col-lg-3">
                                                    از تاریخ
                                                    <input id="formAnswers_date_from3" name="formAnswers_date_from" style="direction: ltr;text-align: center;" class="myDateFarsi form-control" placeholder="فرم هایی که از این تاریخ به بعد تکمیل شده اند" type="text">
                                                </div>
                                                <div class="col-lg-3">
                                                    تا تاریخ
                                                    <input id="formAnswers_date_to3" name="formAnswers_date_to" style="direction: ltr;text-align: center;" class="myDateFarsi form-control" placeholder="فرم هایی که قبل از این تاریخ تکمیل شده اند" type="text">
                                                </div>
                                                <div class="col-lg-3">
                                                    <div id="forms_buttons" class="col-lg-9 mg-t-20 row">
                                                        <div class="col-lg">
                                                            <button   title="رسم نمودار" class="btn btn-outline-warning btn-block mg-b-10" onclick="
                                                                    $('#chartBar1').remove();
                                                                    $('#chartBarDiv1').append('<canvas id=\'chartBar1\'></canvas>');
                                                                    formCountResult_period(<%= formId%>);" id="edit_Forms_new">رسم نمودار</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id='formCountResult_turnover' class="card bd-primary">
                                        <div class="card-header bg-orange tx-white">آنالیز عملکرد پرسنل و افراد برای این فرم:</div>
                                        <div class="card bd-primary sh-pagebody">
                                            <div class="row">
                                                <div class="col-lg-6">
                                                    نمودار برای
                                                    <select id="axel_y" name="axel_y" class="form-control" style="width: 100%">
                                                        <option value='COUNT(hmis_formanswerset.id)'>تعداد فرم ثبت نهایی شده</option>
                                                        <option value='sum'>مجموع امتیازات</option>
                                                        <option value='avg'>میانگین امتیازات</option>
                                                        <%
                                                            for (int i = 0; i < questionsRow.size(); i++) {//فقط چند گزینه ای ها را نشان میدهیم
                                                                if (questionsRow.get(i).get(FormQuestions._answersType).toString().equals("radio")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("select_option")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("number")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("checkbox")) {
                                                                    System.out.println("----------------------------------------------");
                                                                    System.out.println(questionsRow.get(i).get(FormQuestions._answersType).toString());
                                                                    System.out.println("----------------------------------------------");

                                                        %>
                                                        <option value="<%=questionsRow.get(i).get(FormQuestions._id)%>">مجموع امتیاز سوال  :
                                                            <%=questionsRow.get(i).get(FormQuestions._title)%></option>
                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                    </select>
                                                </div>                                                                                                
                                                <div class="col-lg-3">
                                                    محور افقی  به تفکیک کاربران زیر :
                                                    <select id="userFilter" name="axel_x_users" class="form-control roleSelectOption" style="width: 100%" multiple >
                                                        <option value="formAnswers_userName">همه ی کاربران</option>
                                                        <%=userOptionsHtml%> 
                                                    </select>
                                                </div>
                                                <div class="col-lg-3">
                                                    محور افقی  به تفکیک نقش های زیر :
                                                    <select id="rolesFilter" name="axel_x_roles" class="form-control roleSelectOption" style="width: 100%" multiple >
                                                        <option value="formAnswers_userRole">همه ی نقش های سیستم</option>
                                                        <%=roleOptionsHtml%> 
                                                    </select>
                                                </div>
                                                <div class="col-lg-3">
                                                    از تاریخ
                                                    <input id="formAnswers_date_from2" name="formAnswers_date_from" style="direction: ltr;text-align: center;" class="myDateFarsi form-control" placeholder="فرم هایی که از این تاریخ به بعد تکمیل شده اند" type="text">
                                                </div>
                                                <div class="col-lg-3">
                                                    تا تاریخ
                                                    <input id="formAnswers_date_to2" name="formAnswers_date_to" style="direction: ltr;text-align: center;" class="myDateFarsi form-control" placeholder="فرم هایی که قبل از این تاریخ تکمیل شده اند" type="text">
                                                </div>
                                                <div class="col-lg-3">
                                                    <div id="forms_buttons" class="col-lg-9 mg-t-20 row">
                                                        <div class="col-lg">
                                                            <button   title="رسم نمودار" class="btn btn-outline-warning btn-block mg-b-10" onclick="
                                                                    $('#chartBar1').remove();
                                                                    $('#chartBarDiv1').append('<canvas id=\'chartBar1\'></canvas>');
                                                                    formCountResult_turnover(<%= formId%>);" id="edit_Forms_new">رسم نمودار</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card bd-primary" id="analyzeFormByQuestion">
                                        <div class="card-header bg-primary tx-white">آنالیز سوال های چند گزینه ای  فرم بر اساس تاریخ و گزینه های سوال</div>
                                        <div class="card bd-primary sh-pagebody">
                                            <p>
                                                دکمه های رادیویی ( radio)
                                                <br/>
                                                و منو های کشویی (select/option)
                                                <br/>
                                                و چک باکس ها  (checkBox)
                                            </p>
                                            <p>
                                                نکته: محور افقی این  نمودار  براساس گزینه ها است مثلا سوالی که 5
                                                گزینه ی ممکن داشته در این نمودار پنج ستون نمایش داده میشود
                                            </p>
                                            <div class="row">
                                                <div class="col-lg-3">
                                                    نمودار برای پاسخ های:
                                                    <select id="hmis_formquestions_id" name="hmis_formquestions_id" class="form-control" style="width: 100%" >
                                                        <%                                                            for (int i = 0; i < questionsRow.size(); i++) {//فقط چند گزینه ای ها را نشان میدهیم
                                                                if (questionsRow.get(i).get(FormQuestions._answersType).toString().equals("radio")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("select_option")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("checkbox")) {
                                                                    System.out.println("----------------------------------------------");
                                                                    System.out.println(questionsRow.get(i).get(FormQuestions._answersType).toString());
                                                                    System.out.println("----------------------------------------------");

                                                        %>

                                                        <option value="<%=questionsRow.get(i).get(FormQuestions._id)%>"><%=questionsRow.get(i).get(FormQuestions._title)%></option>
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                <div class="col-lg-6">
                                                    فیلتر کن آنهایی که  سوال  زیر را :
                                                    <select id="hmis_filter_formquestion_id" name="hmis_filter_formquestion_id" class="form-control" style="width: 100%"
                                                            onchange="getOptionForFilter($(this).val(), '#hmis_filter_formquestionOption_id');">
                                                        <option value="" selected="selected">یک سوال را انتخاب کنید</option>
                                                        <%
                                                            //با تغییر این سوال گزینه های مربوط به این سوال در سلکت آپشن بعدی باید بیاید
                                                            for (int i = 0; i < questionsRow.size(); i++) {//فقط چند گزینه ای ها را نشان میدهیم
                                                                if (questionsRow.get(i).get(FormQuestions._answersType).toString().equals("radio")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("select_option")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("checkbox")) {
                                                                    System.out.println("----------------------------------------------");
                                                                    System.out.println(questionsRow.get(i).get(FormQuestions._answersType).toString());
                                                                    System.out.println("----------------------------------------------");

                                                        %>
                                                        <option value="<%=questionsRow.get(i).get(FormQuestions._id)%>"><%=questionsRow.get(i).get(FormQuestions._title)%></option>
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                <div class="col-lg-3">
                                                    بصورت زیر انتخاب کرده اند :
                                                    <select id="hmis_filter_formquestionOption_id" name="hmis_filter_formquestionOption_id" class="form-control" style="width: 100%">
                                                        <%
                                                            for (int i = 0; i < questionsRow.size(); i++) {//فقط چند گزینه ای ها را نشان میدهیم
                                                                if (questionsRow.get(i).get(FormQuestions._answersType).toString().equals("radio")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("select_option")
                                                                        || questionsRow.get(i).get(FormQuestions._answersType).toString().equals("checkbox")) {
                                                                    System.out.println("----------------------------------------------");
                                                                    System.out.println(questionsRow.get(i).get(FormQuestions._answersType).toString());
                                                                    System.out.println("----------------------------------------------");

                                                        %>
                                                        <option value="<%=questionsRow.get(i).get(FormQuestions._id)%>"><%=questionsRow.get(i).get(FormQuestions._title)%></option>
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                <div class="col-lg-3">
                                                    فیلتر براساس نقش هایی که این فرم را تکمیل کرده اند
                                                    <select id="formAnswers_userRole" name="formAnswers_userRole" class="form-control roleSelectOption" style="width: 100%" multiple="">
                                                        <%=roleOptionsHtml%>
                                                    </select>
                                                </div>
                                                <div class="col-lg-3">
                                                    از تاریخ
                                                    <input id="formAnswers_date_from1" name="formAnswers_date_from" style="direction: ltr;text-align: center;" class="myDateFarsi form-control" placeholder="فرم هایی که از این تاریخ به بعد تکمیل شده اند" type="text">
                                                </div>
                                                <div class="col-lg-3">
                                                    تا تاریخ
                                                    <input id="formAnswers_date_to1" name="formAnswers_date_to" style="direction: ltr;text-align: center;" class="myDateFarsi form-control" placeholder="فرم هایی که قبل از این تاریخ تکمیل شده اند" type="text">
                                                </div>
                                                <div class="col-lg-3">
                                                    <div id="forms_buttons" class="col-lg-9 mg-t-20 row">
                                                        <div class="col-lg">
                                                            <button   title="رسم نمودار" class="btn btn-outline-warning btn-block mg-b-10" onclick="
                                                                    $('#chartBar1').remove();
                                                                    $('#chartBarDiv1').append('<canvas id=\'chartBar1\'></canvas>');
                                                                    formAllResult_byQuestion(<%= formId%>);" id="edit_Forms_new">رسم نمودار</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="chartBarDiv1"  class="card-body pd-sm-30"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                            <p class="mg-b-20 mg-sm-b-30">نمودار نتایج داده های سیستمی</p>
                            <canvas id="chartBar1"></canvas>
                        </div>
                        <div class="card-header bg-primary tx-white">جدول کلی تمام پاسخ های فرم</div>
                        <div class="card bd-primary sh-pagebody">
                            <table id='allAnswersTable' >
                                <thead>
                                    <tr>
                                        <th>
                                            شناسه ی پاسخ
                                        </th>
                                        <th>
                                            سوال
                                        </th>
                                        <th>
                                            کاربر
                                        </th>
                                        <th>
                                            پاسخ کاربر
                                        </th>
                                        <th class="c" style="direction: ltr">
                                            وزن سوال
                                        </th>
                                        <th class="c" style="direction: ltr">
                                            امتیاز کاربر
                                        </th>
                                        <th>
                                            تاریخ ثبت نهایی
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (int i = 0; i < questionsAnswerRows.size(); i++) {
                                    %>
                                    <tr>
                                        <td>
                                            <%= questionsAnswerRows.get(i).get(FormAnswerSet._id)%>
                                        </td>
                                        <td>
                                            <%= questionsAnswerRows.get(i).get(FormQuestions._title)%>
                                        </td>
                                        <td>
                                            <%= questionsAnswerRows.get(i).get(FormAnswerSet._userName)%>
                                            <br/>
                                            <%= questionsAnswerRows.get(i).get(Role._title)%>
                                        </td>
                                        <%
                                            //برای سلکت آپشن هایی که بیش از چند گزینه را انتخاب کرده اند بتوانیم اپشن ها را نمایش دهیم
                                            String userAnswer = "";
                                            double optoinValue = 0;
                                            if (questionsAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("checkbox")) {
                                                List<Map<String, Object>> optionRow = jjDatabaseWeb.separateRow(
                                                        db.otherSelect("SELECT * FROM hmis_formanswers left join hmis_formquestionoptions on hmis_formquestionoptions.id=formanswers_answer"
                                                                + " WHERE "
                                                                + FormAnswers._answerSet_id + "=" + questionsAnswerRows.get(i).get(FormAnswers._answerSet_id) + " AND " + FormAnswers._questionId + "=" + questionsAnswerRows.get(i).get(FormAnswers._questionId)));
                                                for (int j = 0; j < optionRow.size(); j++) {
                                                    if (!optionRow.isEmpty()) {
                                                        userAnswer += "(" + optionRow.get(j).get(FormQuestionOptions._id) + ")" + optionRow.get(j).get(FormQuestionOptions._lable) + "=" + optionRow.get(j).get(FormQuestionOptions._value) + "<br/>";
                                                        float weight = 1;
                                                        if (jjNumber.isFloat(optionRow.get(j).get(FormQuestionOptions._value).toString())) {//اگر وزن برای سوال داده شده بود
                                                            weight = Float.valueOf(questionsAnswerRows.get(i).get(FormQuestions._weight).toString());
                                                        }
                                                        if (jjNumber.isFloat(optionRow.get(j).get(FormQuestionOptions._value).toString())) {// مجموع امتیازاتی که عددی هستند را حساب کند
                                                            optoinValue += Float.valueOf(optionRow.get(j).get(FormQuestionOptions._value).toString()) * weight;
                                                        }
                                                    }
                                                }
                                            } else if (questionsAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("radio")
                                                    || questionsAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("select_option")) {
                                                userAnswer = "(" + questionsAnswerRows.get(i).get(FormAnswers._answer) + ")" + questionsAnswerRows.get(i).get(FormQuestionOptions._lable).toString() + "=" + questionsAnswerRows.get(i).get(FormQuestionOptions._value);
                                                double weight = 1;
                                                if (jjNumber.isFloat(questionsAnswerRows.get(i).get(FormQuestionOptions._value).toString())) {//اگر وزن برای سوال داده شده بود
                                                    weight = Float.valueOf(questionsAnswerRows.get(i).get(FormQuestions._weight).toString());
                                                }
                                                if (jjNumber.isFloat(questionsAnswerRows.get(i).get(FormQuestionOptions._value).toString())) {// مجموع امتیازاتی که عددی هستند را حساب کند
                                                    optoinValue += Float.valueOf(questionsAnswerRows.get(i).get(FormQuestionOptions._value).toString()) * weight;
                                                }
                                            } else if (questionsAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("number")) {
                                                userAnswer = questionsAnswerRows.get(i).get(FormAnswers._answer).toString();
                                                double weight = 1;
                                                if (jjNumber.isFloat(userAnswer)) {//اگر وزن برای سوال داده شده بود
                                                    weight = Float.valueOf(questionsAnswerRows.get(i).get(FormQuestions._weight).toString());
                                                }
                                                if (jjNumber.isFloat(userAnswer)) {// مجموع امتیازاتی که عددی هستند را حساب کند
                                                    optoinValue += Float.valueOf(userAnswer) * weight;
                                                }
                                            } else if (questionsAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("textarea")) {//
                                                userAnswer = questionsAnswerRows.get(i).get(FormAnswers._answer).toString();
                                                if (userAnswer.length() > 100) {
                                                    userAnswer = userAnswer.substring(0, 100) + "...";
                                                }
                                            } else {//برای سایر گزینه ها
                                                userAnswer = questionsAnswerRows.get(i).get(FormAnswers._answer).toString();
                                            }
                                        %>
                                        <td>
                                            <%=userAnswer%>
                                        </td>
                                        <td>
                                            <%= questionsAnswerRows.get(i).get(FormQuestions._weight)%>
                                        </td>
                                        <td class="c" style="direction: ltr">
                                            <%=optoinValue%>
                                        </td>
                                        <td>
                                            <%= jjCalendar_IR.getViewFormat(questionsAnswerRows.get(i).get(FormAnswerSet._date))%>
                                            <br/>
                                            <%=  jj.jjTime.getTime5lenth(questionsAnswerRows.get(i).get(FormAnswerSet._time).toString())%>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>

                                </tbody>
                            </table>
                        </div>
                        <!-- card-body -->
                    </div><!-- card -->
                </div><!-- col-6 -->
                <!--                <div class="col-xl-12 mg-t-25 mg-xl-t-0">
                                    <div class="card bd-primary">
                                        <div class="card-header bg-primary tx-white">Multiple Color نمودار</div>
                                        <div class="card-body pd-sm-30"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                                            <p class="mg-b-20 mg-sm-b-30">نمودار نتایج داده های سیستمی</p>
                                            <canvas id="chartBar2" class="chartjs-render-monitor" style="display: block; width: 100%; height: 308px;"></canvas>
                                        </div> card-body
                                    </div> card
                                </div> col-6 -->
            </div><!-- row -->

        </div>
        <script src="js/jquery/jquery-1.10.2_1.js" type="text/javascript"></script>
        <script src="js/jquery/jquery-migrate-1.2.0.js" type="text/javascript"></script>
        <script src="Manager/popper.js"></script>
        <script src="Manager/bootstrap.js"></script>


        <link href="css/jquery/orang/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css" />
        <script src="js/jquery/ui/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>
        <!--        //عوض کردن
        <!--calendar-->

        <!--<script src="Manager/perfect-scrollbar.jquery.js"></script>-->
        <!--<script src="Manager/moment.js"></script>-->
        <!--<script src="Manager/jquery.flot.js"></script>-->
        <!--<script src="Manager/jquery.flot.resize.js"></script>-->
        <!--<script src="Manager/jquery.flot.spline.js"></script>-->


        <!--calendar-->
        <script src="./Manager/js/calendar/jquery.ui.datepicker-cc.js" type="text/javascript"></script>
        <script src="./Manager/js/calendar/jquery.ui.datepicker-cc-fa.js" type="text/javascript"></script>
        <script src="./Manager/js/calendar/calendar.all.js" type="text/javascript"></script>
        <!--<script src="Manager/js/calendar/calendar.js" type="text/javascript"></script>-->
        <!--        <script src="Manager/js/calendar/wickedpicker.min.js" type="text/javascript"></script>
                <script src="Manager/js/calendar/wickedpickerSpec.js" type="text/javascript"></script>-->


        <!--upload برای سوالاتی که آپلود فایل نیاز دارند-->
        <!--<script src="./Manager/js/ajaxfileupload.js" type="text/javascript"></script>-->
        <!--DataTable-->
        <script src="Manager/dataTable/jquery.dataTables.js"></script>
        <script src="Manager/dataTable/dataTables.responsive.js"></script>
        <script src="Manager/dataTable/select2.min.js"></script>

        <!--textEditor-->
        <!--<script src="Manager/textEditor/medium-editor.js"></script>-->
        <!--<script src="Manager/textEditor/summernote-bs4.min.js"></script>-->

        <!--jj2-->
        <!--<script src="Manager/textEditor/summernote.js" type="text/javascript"></script>-->
        <!--<script src="./Manager/js/js.cookie.js" type="text/javascript"></script>-->
        <script src="./Manager/js/jj2.js" type="text/javascript"></script>
        <script src="./Manager/js/index.js" type="text/javascript"></script>
        <!--jsHMIS-->
        <!--<script src="jsHMIS/HmisManager.js" type="text/javascript"></script>-->
        <!--<script src="jsCms/cmsManager.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/forms.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/formQuestions.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/formQuestionOptions.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/plansForAssess.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/plans.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/steps.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/sessions.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/approved.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/reports.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/commettes.js" type="text/javascript"></script>-->

        <!--<script src="jsCms/user.js" type="text/javascript"></script>-->
        <!--<script src="jsCms/group.js" type="text/javascript"></script>-->
        <!--<script src="jsHMIS/department.js" type="text/javascript"></script>-->
        <!--////پیام ها-->
        <!--<script src="jsHMIS/messenger.js" type="text/javascript"></script>-->
        <!--///نقش  ها-->
        <!--<script src="jsHMIS/role.js" type="text/javascript"></script>-->
        <!--<script src="js/jquery/ajaxfileupload.js" type="text/javascript"></script>-->
        <!--<script src="Manager/bootstrap-filestyle.js" type="text/javascript"></script>-->
        <!--<script src="Manager/bootstrap-filestyle.min.js" type="text/javascript"></script>-->
        <!--forms-->
        <!--<script src="Manager/forms/spectrum.js"></script>-->
        <!--charts.js-->
        <script src="Manager/chart/Chart.js"></script>

        <!--<script src="Manager/shamcey.js"></script>-->
        <!--<script src="Manager/dashboard.js"></script>-->

        <!--<script src="Manager/js/HMIS.js" type="text/javascript"></script>-->
        <script src="Manager/dataTable/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="Manager/dataTable/jszip.min.js" type="text/javascript"></script>
        <script src="Manager/dataTable/buttons.html5.min.js" type="text/javascript"></script>
        <script type='text/javascript'>
                                                                $("#rolesFilter").on('select2:select', function (e) {// برای اینکه در یک زمان فقط یکی از بین نقش و کاربر را بتواند انتخاب کند
                                                                    $("#userFilter").val("");
                                                                    $("#userFilter").trigger("change");
                                                                    if ($('#rolesFilter').val().indexOf("formAnswers_userRole") >= 0) {
                                                                        $("#rolesFilter").select2("val", ["formAnswers_userRole"]);
                                                                    }
                                                                });
                                                                $("#userFilter").on('select2:select', function (e) {
                                                                    $("#rolesFilter").val("");
                                                                    $("#rolesFilter").trigger("change");
                                                                    if ($('#userFilter').val().indexOf("formAnswers_userName") >= 0) {
                                                                        $("#userFilter").select2("val", ["formAnswers_userName"]);
                                                                    }
                                                                });
                                                                /**
                                                                 *برای نمایش نتیج در دوره های زمانی مختلف بصورت های مختلف
                                                                 * @returns {undefined}
                                                                 */
                                                                function formCountResult_period(formId) {
                                                                    var param = "";
                                                                    param += "do=Forms.formCountResult_period";
                                                                    param += "&id=" + formId;
                                                                    param += "&" + new jj('#formCountResult_period').jjSerial();
                                                                    new jj(param).jjAjax2(false);
                                                                }
                                                                ;
                                                                /**
                                                                 *برای نمایش عملکرد پرسنل بصورت نمودار هایی که محور افقی نشان دهنده زمان است و محور عمودی عدد
                                                                 * @returns {undefined}
                                                                 */
                                                                function formCountResult_turnover(formId) {
                                                                    var param = "";
                                                                    param += "do=Forms.formCountResult_turnover";
                                                                    param += "&id=" + formId;
                                                                    param += "&" + new jj('#formCountResult_turnover').jjSerial();
                                                                    new jj(param).jjAjax2(false);
                                                                    $("formAnserSetBtn").html("");
                                                                }
                                                                ;
                                                                /**
                                                                 *برای نمایش نمودار های آنالیز سوال به سووال که پاسخ باید در یک صفحه ی دیگر با متد
                                                                 *get باز شود تا قابل لینگ دهی باشد
                                                                 * @returns {undefined}
                                                                 */
                                                                function formAllResult_byQuestion(formId) {
                                                                    var param = "";
                                                                    param += "do=Forms.analysFromByQuestion";
                                                                    param += "&id=" + formId;
                                                                    param += "&" + new jj('#analyzeFormByQuestion').jjSerial();
                                                                    new jj(param).jjAjax2(false);
                                                                    $("formAnserSetBtn").html("");
                                                                }
                                                                ;
                                                                var getOptionForFilter = function (id, panel) {
                                                                    panel = (panel == null ? "hmis_filter_formquestionOption_id" : panel);
                                                                    if (!new jj(id).jjIsDigit()) {
                                                                        $(panel).html("<option value=''></option>");
                                                                        return;
                                                                    }
                                                                    var param = "";
                                                                    param += "do=FormQuestionOptions.getOptionForFilter";
                                                                    param += "&panel=" + (panel == null ? "hmis_filter_formquestionOption_id" : panel);
                                                                    param += "&formQuestionOptions_question_id=" + id;
                                                                    param += "&jj=1";
                                                                    new jj(param).jjAjax2(false);
                                                                };
                                                                $(document).ready(function () {
                                                                    $("#allAnswersTable").DataTable({
                                                                        dom: 'Bfrtip',
                                                                        buttons: [{
                                                                                extend: 'excelHtml5',
                                                                                customize: function (xlsx) {
                                                                                    var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                                                                    // Loop over the cells in column `C`
                                                                                    $('row c[r^="C"]', sheet).each(function () {
                                                                                        // Get the value
                                                                                        if ($('is t', this).text() == 'New York') {
                                                                                            $(this).attr('s', '20');
                                                                                        }
                                                                                    });
                                                                                }
                                                                            }]
                                                                    });
                                                                });
                                                                $(".roleSelectOption").select2({
                                                                    width: '100%'
                                                                });
                                                                new jj(".myDateFarsi").jjCalendarWithYearSelector(1395, 1420);

        </script>
    </body>
</html>
