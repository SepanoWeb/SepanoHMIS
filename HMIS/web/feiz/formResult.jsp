<%-- 
    Document   : formResult
    Created on : May 17, 2019, 5:28:43 PM
    Author     : Mohammad
--%>

<%@page import="jj.jjTime"%>
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
    String where = Forms._id + "=" + formId + " AND " + Forms._isActive + "=1";
    List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(Forms.tableName, where));
    String answerSetId = jjTools.getParameter(request, FormAnswerSet._id);
    List<Map<String, Object>> questionsAndAnswerRows = new ArrayList();
    if ((formRow.get(0).get(Forms._showResultToQuestioner).equals("1") || formRow.get(0).get(Forms._showAllResultToQuestioner).equals("1"))) {
        if (jjNumber.isDigit(answerSetId)) {// یعنی فرمی برای ویرایش انتخاب شده است
            String sql = "SELECT hmis_formquestions.*,formanswers_answerSet_id,formanswers_answerSet_id,formanswers_answer FROM hmis_formquestions LEFT JOIN hmis_formanswers on"
                    + " hmis_formanswers.formanswers_questionId= hmis_formquestions.id "
                    + "WHERE "
                    + "formQuestions_formID=" + formId + " AND hmis_formanswers.formanswers_answerSet_id=" + answerSetId + " ;";
            questionsAndAnswerRows = jjDatabaseWeb.separateRow(db.otherSelect(sql));
        } else {
            return;
        }
    }
    List<Map<String, Object>> AnswerSetRow = jjDatabaseWeb.separateRow(db.Select(FormAnswerSet.tableName, "id=" + answerSetId));
    String userRole = "";
    if (AnswerSetRow.isEmpty()) {
        return;
    }
    if (jjNumber.isDigit(AnswerSetRow.get(0).get(FormAnswerSet._userRole).toString())) {
        List<Map<String, Object>> userRoleRow = jjDatabaseWeb.separateRow(db.Select(Role.tableName, Role._title, "id=" + AnswerSetRow.get(0).get(FormAnswerSet._userRole).toString()));
        userRole = userRoleRow.get(0).get(Role._title).toString();
    }
    float userTotalAnswerScore = 0;// ّبرای محاسبه ی امتیاز نهایی کاربر امتیاز رادیو های دارای عدد و تایپ نامبر
    float scoredQuestioNo = 0;// ّتعداد سوالات امتیاز دار برای محاسبه ی میانگین پاسخ ها
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=formRow.get(0).get(Forms._title)%></title>
        <link href="./Manager/font-awesome.css" rel="stylesheet">
        <link href="./Manager/ionicons.css" rel="stylesheet">
        <link href="./Manager/perfect-scrollbar.css" rel="stylesheet">
        <!--time picker-->
        <!--<link href="Manager/css/wickedpicker.min.css" rel="stylesheet" />-->
        <!--DataTable-->
        <link href="Manager/dataTable/jquery.dataTables.css" rel="stylesheet"/>
        <!--<link href="Manager/dataTable/select2.min.css" rel="stylesheet"/>-->

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
        <%= formRow.get(0).get(Forms._css)%>
    </head>
    <body>
        <div class="sh-pagebody">
            <h1>عنوان فرم:  <%=formRow.get(0).get(Forms._title)%> </h1>
            <p class="mg-b-20 mg-sm-b-30">
                تکمیل کننده  : <%=AnswerSetRow.get(0).get(FormAnswerSet._userName)%>
                <br/> <%=userRole%>
                <br/> تاریخ ثبت پاسخ ها  : <%=jjCalendar_IR.getViewFormat(AnswerSetRow.get(0).get(FormAnswerSet._date))%>
                <br/> ساعت : <%=jjTime.getTime5lenth(AnswerSetRow.get(0).get(FormAnswerSet._time).toString())%> 
                <br/> امتیاز نهایی شما : <%= AnswerSetRow.get(0).get(FormAnswerSet._sum).toString() %>
                <br/> میانگین  امتیاز پاسخ های شما : <%= AnswerSetRow.get(0).get(FormAnswerSet._avg).toString() %>
            </p>
            <% for (int i = 0; i < questionsAndAnswerRows.size(); i++) {//برای هرسوال 
                    if (questionsAndAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("text")                            
                            || questionsAndAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("email")
                            || questionsAndAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("date")) {

            %>
            <div class="card pd-20 pd-sm-30 bd-primary question-row <%= questionsAndAnswerRows.get(i).get(FormQuestions._answersType)%>" 
                 id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id)%>" >
                <div class="card-header bg-dark tx-white">
                    <%if (!questionsAndAnswerRows.get(i).get(FormQuestions._icon).toString().trim().isEmpty()) {//اگر آیکن دارد %>
                    <img src="upload/<%= questionsAndAnswerRows.get(i).get(FormQuestions._icon)%>" class="wd-40" alt="">
                    <% }%>
                    <%= (i + 1) + "-" + questionsAndAnswerRows.get(i).get(FormQuestions._title)%> (<%= questionsAndAnswerRows.get(i).get(FormQuestions._weight)%>)
                </div>
                <% if (!questionsAndAnswerRows.get(i).get(FormQuestions._trueAnswer).toString().trim().isEmpty()) {//اگر برای این فرم پاسخ صحیح تعیین شده بود
                %>
                <p class="mg-b-0">
                    پاسخ صحیحی : <%= questionsAndAnswerRows.get(i).get(FormQuestions._trueAnswer)%>
                </p>
                <p class="mg-b-0">
                    <%= questionsAndAnswerRows.get(i).get(FormQuestions._htmlDiscriptionInResult) /*نشان دادن توضیحات مربوط به روش رسیدن به پاسخ صحیح*/%>
                </p>
                <%
                    }
                %>

                <hr>
                <div class="media align-items-center">
                    <div class="media-body mg-l-15">
                        <div class="tx-inverse tx-14 mg-b-5">پاسخ شما</div>
                        <p class="tx-12 mg-b-0"><%= questionsAndAnswerRows.get(i).get(FormAnswers._answer)%></p>
                    </div><!-- media-body -->
                </div><!-- media -->
            </div>
            <%
            // اعداد را در ضریب انها ضرب می کند و در امتیاز نشان میدهد
            } else if (questionsAndAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("number")) {
            %>
            <div class="card pd-20 pd-sm-30 bd-primary question-row <%= questionsAndAnswerRows.get(i).get(FormQuestions._answersType)%>" 
                 id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id)%>" >
                <div class="card-header bg-dark tx-white">
                    <%if (!questionsAndAnswerRows.get(i).get(FormQuestions._icon).toString().trim().isEmpty()) {//اگر آیکن دارد %>
                    <img src="upload/<%= questionsAndAnswerRows.get(i).get(FormQuestions._icon)%>" class="wd-40" alt="">
                    <% }%>
                    <%= (i + 1) + "-" + questionsAndAnswerRows.get(i).get(FormQuestions._title)%> (<%= questionsAndAnswerRows.get(i).get(FormQuestions._weight)%>)
                </div>
                <% if (!questionsAndAnswerRows.get(i).get(FormQuestions._trueAnswer).toString().trim().isEmpty()) {//اگر برای این فرم پاسخ صحیح تعیین شده بود
                %>
                <p class="mg-b-0">
                    پاسخ صحیحی : <%= questionsAndAnswerRows.get(i).get(FormQuestions._trueAnswer)%>
                </p>
                <p class="mg-b-0">
                    <%= questionsAndAnswerRows.get(i).get(FormQuestions._htmlDiscriptionInResult) /*نشان دادن توضیحات مربوط به روش رسیدن به پاسخ صحیح*/%>
                </p>
                <%
                    }
                 String userAnswerText = "";
                    float userAnswerScore = 0;
                    if (!questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().trim().isEmpty()) {//اگر پر کننده ی فرم جواب این سوال را خالی نگذاشته بود
                        // پیدا کردن متن پاسخ کاربر
                        
                        
                        if (jjNumber.isFloat(questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString())) {
                            userAnswerScore += Float.valueOf(questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString());
                        }
                        if (jjNumber.isFloat(questionsAndAnswerRows.get(i).get(FormQuestions._weight).toString())) {
                            userAnswerScore *= Float.valueOf(questionsAndAnswerRows.get(i).get(FormQuestions._weight).toString());
                        }
                    }
                    userTotalAnswerScore+=userAnswerScore;
                    scoredQuestioNo++;
                %>

                <hr>
                <div class="media align-items-center">
                    <div class="media-body mg-l-15">
                        <div class="tx-inverse tx-14 mg-b-5">پاسخ شما</div>
                        <p class="tx-12 mg-b-0"><%= questionsAndAnswerRows.get(i).get(FormAnswers._answer)%></p>
                    </div><!-- media-body -->
                    <div class="media-body mg-l-15 yourScore">
                        <div class="tx-inverse tx-14 mg-b-5">امتیاز شما</div>
                        <p class="tx-12 mg-b-0"><%= userAnswerScore%></p>
                    </div><!-- media-body -->
                </div><!-- media -->
            </div>
            <%
            } else if (questionsAndAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("radio")
                    || questionsAndAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("select_option")) {
            %>
            <div class="card pd-20 pd-sm-30 bd-primary question-row <%= questionsAndAnswerRows.get(i).get(FormQuestions._answersType)%>" 
                 id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id)%>" >
                <div class="card-header bg-dark tx-white">
                    <%if (!questionsAndAnswerRows.get(i).get(FormQuestions._icon).toString().trim().isEmpty()) {//اگر آیکن دارد %>
                    <img src="upload/<%= questionsAndAnswerRows.get(i).get(FormQuestions._icon)%>" class="wd-40" alt="">
                    <% }%>
                    <%= (i + 1) + "-" + questionsAndAnswerRows.get(i).get(FormQuestions._title)%> (<%= questionsAndAnswerRows.get(i).get(FormQuestions._weight)%>)
                </div>
                <%
                    if (!questionsAndAnswerRows.get(i).get(FormQuestions._trueAnswer).toString().trim().isEmpty()) {//اگر برای این فرم پاسخ صحیح تعیین شده بود
                %>
                <p class="mg-b-0">
                    پاسخ صحیح <%= questionsAndAnswerRows.get(i).get(FormQuestions._trueAnswer)%>
                </p>
                <%
                    }
                    String userAnswerText = "";
                    float userAnswerScore = 0;
                    if (!questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().trim().isEmpty()) {//اگر پر کننده ی فرم جواب این سوال را خالی نگذاشته بود
                        // پیدا کردن متن پاسخ کاربر
                        List<Map<String, Object>> userAnswerOption = jjDatabaseWeb.separateRow(db.Select(FormQuestionOptions.tableName,
                                FormQuestionOptions._id + "=" + questionsAndAnswerRows.get(i).get(FormAnswers._answer)));
                        userAnswerText += userAnswerOption.get(0).get(FormQuestionOptions._lable).toString();
                        if (jjNumber.isFloat(userAnswerOption.get(0).get(FormQuestionOptions._value).toString())) {
                            userAnswerScore += Float.valueOf(userAnswerOption.get(0).get(FormQuestionOptions._value).toString());
                        }
                        if (jjNumber.isFloat(questionsAndAnswerRows.get(i).get(FormQuestions._weight).toString())) {
                            userAnswerScore *= Float.valueOf(questionsAndAnswerRows.get(i).get(FormQuestions._weight).toString());
                        }
                    }
                    userTotalAnswerScore+=userAnswerScore;
                    scoredQuestioNo++;
                %>
                <p class="mg-b-0">
                    <%= questionsAndAnswerRows.get(i).get(FormQuestions._htmlDiscriptionInResult) /*نشان دادن توضیحات مربوط به روش رسیدن به پاسخ صحیح*/%>
                </p>
                <hr>
                <div class="media align-items-center">
                    <div class="media-body mg-l-15 yourAnswer">
                        <div class="tx-inverse tx-14 mg-b-5">پاسخ شما</div>
                        <p class="tx-12 mg-b-0"><%= userAnswerText%></p>
                    </div><!-- media-body -->
                    <div class="media-body mg-l-15 yourScore">
                        <div class="tx-inverse tx-14 mg-b-5">امتیاز شما</div>
                        <p class="tx-12 mg-b-0"><%= userAnswerScore%></p>
                    </div><!-- media-body -->
                </div><!-- media -->
            </div>
            <%
            } else if (questionsAndAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("checkbox")) {
            %>
            <div class="card pd-20 pd-sm-30 bd-primary question-row <%= questionsAndAnswerRows.get(i).get(FormQuestions._answersType)%>" 
                 id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id)%>" >
                <div class="card-header bg-dark tx-white">
                    <%if (!questionsAndAnswerRows.get(i).get(FormQuestions._icon).toString().trim().isEmpty()) {//اگر آیکن دارد %>
                    <img src="upload/<%= questionsAndAnswerRows.get(i).get(FormQuestions._icon)%>" class="wd-40" alt="">
                    <% }%>
                    <%= (i + 1) + "-" + questionsAndAnswerRows.get(i).get(FormQuestions._title)%> (<%= questionsAndAnswerRows.get(i).get(FormQuestions._weight)%>)
                </div>
                <%
                    if (!questionsAndAnswerRows.get(i).get(FormQuestions._trueAnswer).toString().trim().isEmpty()) {//اگر برای این فرم پاسخ صحیح تعیین شده بود
%>
                <p class="mg-b-0">
                    پاسخ صحیح <%= questionsAndAnswerRows.get(i).get(FormQuestions._trueAnswer)%>
                </p>
                <%
                    }
                    String userAnswerText = "";
                    float userAnswerScore = 0;
                    String userCheckedAnswers[] = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().split("%23A%23");
                    for (int j = 0; j < userCheckedAnswers.length; j++) {//اگر پر کننده ی فرم جواب این سوال را خالی نگذاشته بود
                        List<Map<String, Object>> userAnswerOption = jjDatabaseWeb.separateRow(db.Select(FormQuestionOptions.tableName,// به دیتا بیس سلکت می زنیم که
                                FormQuestionOptions._id + "=" + userCheckedAnswers[j]));
                        // پیدا کردن متن پاسخ کاربر
                        userAnswerText += userAnswerOption.get(0).get(FormQuestionOptions._lable).toString() + "<br/>";
                        if (jjNumber.isFloat(userAnswerOption.get(0).get(FormQuestionOptions._value).toString())) {
                            userAnswerScore += Float.valueOf(userAnswerOption.get(0).get(FormQuestionOptions._value).toString());
                        }
                    }
                    if (jjNumber.isFloat(questionsAndAnswerRows.get(i).get(FormQuestions._weight).toString())) {
                        userAnswerScore *= Float.valueOf(questionsAndAnswerRows.get(i).get(FormQuestions._weight).toString());
                    }
                    userTotalAnswerScore+=userAnswerScore;
                    scoredQuestioNo++;
                %>
                <p class="mg-b-0">
                    <%= questionsAndAnswerRows.get(i).get(FormQuestions._htmlDiscriptionInResult) /*نشان دادن توضیحات مربوط به روش رسیدن به پاسخ صحیح*/%>
                </p>
                <hr>
                <div class="media align-items-center">
                    <div class="media-body mg-l-15 yourAnswer">
                        <div class="tx-inverse tx-14 mg-b-5">گزینه های انتخابی شما</div>
                        <p class="tx-12 mg-b-0"><%= userAnswerText%></p>
                    </div><!-- media-body -->
                    <div class="media-body mg-l-15 yourScore">
                        <div class="tx-inverse tx-14 mg-b-5">امتیاز شما</div>
                        <p class="tx-12 mg-b-0"><%= userAnswerScore%></p>
                    </div><!-- media-body -->
                </div><!-- media -->
            </div>
            <%
            } else if (questionsAndAnswerRows.get(i).get(FormQuestions._answersType).toString().equals("file")) {

            %>
            <div class="card pd-20 pd-sm-30 bd-primary question-row <%= questionsAndAnswerRows.get(i).get(FormQuestions._answersType)%>" 
                 id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id)%>" >
                <div class="card-header bg-dark tx-white">
                    <%if (!questionsAndAnswerRows.get(i).get(FormQuestions._icon).toString().trim().isEmpty()) {//اگر آیکن دارد %>
                    <img src="upload/<%= questionsAndAnswerRows.get(i).get(FormQuestions._icon)%>" class="wd-40" alt="">
                    <% }%>
                    <%= (i + 1) + "-" + questionsAndAnswerRows.get(i).get(FormQuestions._title)%> (<%= questionsAndAnswerRows.get(i).get(FormQuestions._weight)%>)
                </div>
                <hr>
                <div class="media align-items-center">
                    <div class="media-body mg-l-15">
                        <div class="tx-inverse tx-14 mg-b-5">فایل شما</div>
                        <a href="upload/<%= questionsAndAnswerRows.get(i).get(FormAnswers._answer)%>" >
                            <img class="" src="upload/<%= questionsAndAnswerRows.get(i).get(FormAnswers._answer)%>" style="max-height: 200px" />
                        </a>
                    </div><!-- media-body -->
                </div><!-- media -->
                <p class="mg-b-0">
                    <%= questionsAndAnswerRows.get(i).get(FormQuestions._trueAnswer) /*پاسخ صحیح*/%>
                </p>
                <p class="mg-b-0">
                    <%= questionsAndAnswerRows.get(i).get(FormQuestions._htmlDiscriptionInResult) /*نشان دادن توضیحات مربوط به روش رسیدن به پاسخ صحیح*/%>
                </p>
            </div>
            <%
                    }
                }
            %>
            <div class="card pd-20 pd-sm-30 bd-primary question-row " >
                <div class="tx-inverse tx-14 mg-b-5">
                امتیاز نهایی شما : <%= userTotalAnswerScore %>
                </div>
                <div class="tx-inverse tx-14 mg-b-5">
                تعداد سوالات امتیازی  : <%= scoredQuestioNo %>
                </div>
                <div class="tx-inverse tx-14 mg-b-5">
                میانگین  امتیاز پاسخ های شما : <%= userTotalAnswerScore/scoredQuestioNo %>
            </div>
            </div>            
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
        <script src="./Manager/js/ajaxfileupload.js" type="text/javascript"></script>
        <!--DataTable-->
        <!--<script src="Manager/dataTable/jquery.dataTables.js"></script>-->
        <!--<script src="Manager/dataTable/dataTables.responsive.js"></script>-->
        <!--<script src="Manager/dataTable/select2.min.js"></script>-->

        <!--textEditor-->
        <!--<script src="Manager/textEditor/medium-editor.js"></script>-->
        <!--<script src="Manager/textEditor/summernote-bs4.min.js"></script>-->

        <!--jj2-->
        <!--<script src="Manager/textEditor/summernote.js" type="text/javascript"></script>-->
        <script src="./Manager/js/js.cookie.js" type="text/javascript"></script>
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
        <!--<script src="Manager/chart/Chart.js"></script>-->

        <!--<script src="Manager/shamcey.js"></script>-->
        <!--<script src="Manager/dashboard.js"></script>-->

        <!--<script src="Manager/js/HMIS.js" type="text/javascript"></script>-->

    </body>
</html>
