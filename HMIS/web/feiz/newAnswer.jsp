<%-- 
    Document   : newFormToComplete
    Created on : Apr 5, 2019, 4:33:44 PM
    Author     : Mohammad
--%>

<%@page import="HMIS.FormQuestionOptions"%>
<%@page import="HMIS.FormQuestions"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="HMIS.FormAnswers"%>
<%@page import="cms.tools.jjTools"%>
<%@page import="HMIS.Forms"%>
<%@page import="jj.jjDatabaseWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    jjDatabaseWeb db = (jjDatabaseWeb) request.getAttribute("db");
    String formId = jjTools.getParameter(request, FormAnswers._formId);
    String where = Forms._id + "=" + formId + " AND " + Forms._isActive + "=1";
    List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(Forms.tableName, where));
    List<Map<String, Object>> questionsRow = jjDatabaseWeb.separateRow(db.Select(FormQuestions.tableName, FormQuestions._formID + "=" + formId));
    if (formRow.isEmpty()) {
        return;
    }

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
        <!--<link href="Manager/dataTable/jquery.dataTables.css" rel="stylesheet"/>-->
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
        <%= formRow.get(0).get(Forms._css)%>
    </head>
    <body>
        <div id="swOneFormToCompleteForm">
            <div class="card bd-primary mg-t-20" id="newFormQuestion">
                <div class="card-header bg-primary tx-white"><%=formRow.get(0).get(Forms._title)%></div>
                <div class="card-body pd-sm-30">
                    <p class="mg-b-20 mg-sm-b-30">
                        <%=formRow.get(0).get(Forms._description)%></p>
                        <%=formRow.get(0).get(Forms._htmlContent)%>
                    <div id="swFormQuestionsForm" class="card bd-primary pd-10">
                        <div class="card-header bg-info tx-white">سوالات فرم : </div>
                        <%
                            for (int i = 0; i < questionsRow.size(); i++) {
                        %>
                        <div class="col-lg-12 card bd-primary mg-t-10">
                            <div class="card-body row">
                                <input id="hmis_formquestions_id" name="id" type="hidden" />
                                <div class="col-lg-3 col-sm-6">
                                    <img id="formQuestions_icon_Preview"  class="col-lg-12 img-thumbnail" 
                                         <%=/*اگرگزینه  آبکن نداشت*/ questionsRow.get(i).get(FormQuestions._icon).toString().isEmpty() ? "src='./upload/optionIcon.svg' style='width:40%;min-width: 50px;' " : ("src='./upload/"+questionsRow.get(i).get(FormQuestions._icon)+"'") %>  />
                                </div>
                                <div class="col-lg-9">
                                    <div class="col-lg-12">
                                        <%=questionsRow.get(i).get(FormQuestions._title).toString()%>
                                    </div>
                                    <%
                                        String questionType = questionsRow.get(i).get(FormQuestions._answersType).toString();
                                        if (questionType.equals("textarea")) {
                                    %>                                    
                                    <textarea class="clo-lg-12 form-control" placeholder="<%=questionsRow.get(i).get(FormQuestions._placeHolder).toString()%>"><%=questionsRow.get(i).get(FormQuestions._defaultValue).toString()%></textarea>
                                    <%
                                    } else if (questionType.equals("checkbox")) {//اگر چک باکس بود برای گزینه های هر سوال
                                        List<Map<String, Object>> optionsRow = jjDatabaseWeb.separateRow(db.Select(FormQuestionOptions.tableName, FormQuestionOptions._question_id + "=" + questionsRow.get(i).get(FormQuestions._id)));
                                        for (int j = 0; j < optionsRow.size(); j++) {
                                    %>
                                    <div class="col-lg-12 col-sm-6 row">
                                        <div class="col-lg-3 col-sm-6">
                                            <img class="col-lg img-thumbnail" <%=/*اگرگزینه  آبکن نداشت*/ optionsRow.get(j).get(FormQuestionOptions._icon).toString().isEmpty() ? "src='./upload/optionIcon.svg' style='width:40%;min-width: 50px;' " : ("src='./upload/"+optionsRow.get(j).get(FormQuestionOptions._icon)+"'") %>  />
                                        </div>
                                        <div class="col-lg-12 mg-b-20">
                                            <input type="checkbox" name="oio" checked="" value="<%= optionsRow.get(j).get(FormQuestionOptions._value)%>">
                                            <label>
                                                <%= optionsRow.get(j).get(FormQuestionOptions._lable)%>
                                            </label>
                                        </div>
                                    </div>
                                    <%
                                            }
                                        } else if (questionType.equals("radio")) {//اگر رادیو بود برای گزینه های هر سوال
                                        List<Map<String, Object>> optionsRow = jjDatabaseWeb.separateRow(db.Select(FormQuestionOptions.tableName, FormQuestionOptions._question_id + "=" + questionsRow.get(i).get(FormQuestions._id)));
                                        for (int j = 0; j < optionsRow.size(); j++) {
                                    %>
                                    <div class="col-lg-12 col-sm-6 row">
                                        <div class="col-lg-3 col-sm-6">
                                            <img class="col-lg img-thumbnail" <%=/*اگرگزینه  آبکن نداشت*/ optionsRow.get(j).get(FormQuestionOptions._icon).toString().isEmpty() ? "src='./upload/optionIcon.svg' style='width:40%;min-width: 50px;' " : ("src='./upload/"+optionsRow.get(j).get(FormQuestionOptions._icon)+"'") %>  />
                                        </div>
                                        <div class="col-lg-12 mg-b-20">
                                            <input type="radio" value="<%= optionsRow.get(j).get(FormQuestionOptions._value)%>" name="lll">
                                            <label>
                                                <%= optionsRow.get(j).get(FormQuestionOptions._lable)%>
                                            </label>
                                        </div>
                                    </div>
                                    <%
                                            }
                                        }
                                    %>                                
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>                        
                    </div>
                </div>
            </div>
        </div>


        <script src="js/jquery/jquery-1.10.2_1.js" type="text/javascript"></script>
        <script src="js/jquery/jquery-migrate-1.2.0.js" type="text/javascript"></script>

        <!--<script src="Manager/popper.js"></script>-->
        <!--<script src="Manager/bootstrap.js"></script>-->
        <!--<link href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css" />-->
        <!--<script src="js/jquery/ui/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>-->
        <!--        //عوض کردن 
        <!--calendar-->        

        <!--<script src="Manager/perfect-scrollbar.jquery.js"></script>-->
        <!--<script src="Manager/moment.js"></script>-->
        <!--<script src="Manager/jquery.flot.js"></script>-->
        <!--<script src="Manager/jquery.flot.resize.js"></script>-->
        <!--<script src="Manager/jquery.flot.spline.js"></script>-->


        <!--calendar-->
        <!--<script src="Manager/js/calendar/jquery.ui.datepicker-cc.js" type="text/javascript"></script>-->
        <!--<script src="Manager/js/calendar/jquery.ui.datepicker-cc-fa.js" type="text/javascript"></script>-->
        <!--<script src="Manager/js/calendar/calendar.all.js" type="text/javascript"></script>-->
        <!--<script src="Manager/js/calendar/calendar.js" type="text/javascript"></script>-->
        <!--<script src="Manager/js/calendar/wickedpicker.min.js" type="text/javascript"></script>-->
        <!--<script src="Manager/js/calendar/wickedpickerSpec.js" type="text/javascript"></script>-->


        <!--upload-->
        <!--<script src="Manager/js/ajaxfileupload.js" type="text/javascript"></script>-->
        <!--DataTable-->
        <!--<script src="Manager/dataTable/jquery.dataTables.js"></script>-->
        <!--<script src="Manager/dataTable/dataTables.responsive.js"></script>-->
        <!--<script src="Manager/dataTable/select2.min.js"></script>-->

        <!--textEditor-->
        <!--<script src="Manager/textEditor/medium-editor.js"></script>-->
        <!--<script src="Manager/textEditor/summernote-bs4.min.js"></script>-->

        <!--jj2-->
        <!--<script src="Manager/textEditor/summernote.js" type="text/javascript"></script>-->
        <!--<script src="Manager/js/jj2.js" type="text/javascript"></script>-->
        <!--<script src="Manager/js/index.js" type="text/javascript"></script>-->
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
        <%= formRow.get(0).get(Forms._javaScript)%>
    </body>
</html>
