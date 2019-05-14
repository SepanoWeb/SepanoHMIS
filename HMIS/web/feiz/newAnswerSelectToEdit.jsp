<%-- 
    Document   : newFormToComplete
    Created on : Apr 5, 2019, 4:33:44 PM
    Author     : Mohammad
--%>

<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="jdk.nashorn.internal.runtime.regexp.JdkRegExp"%>
<%@page import="jdk.nashorn.internal.runtime.regexp.RegExp"%>
<%@page import="jj.jjCalendar_IR"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.AbstractList"%>
<%@page import="jj.jjNumber"%>
<%@page import="HMIS.FormAnswerSet"%>
<%@page import="HMIS.Role"%>
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
    if (request.getAttribute("db") == null) {
        return;
    }
    jjDatabaseWeb db = (jjDatabaseWeb) request.getAttribute("db");
    String answerSetId = jjTools.getParameter(request, FormAnswerSet._id);
    List<Map<String, Object>> questionsAndAnswerRows = new ArrayList();
    String formId = jjTools.getParameter(request, FormAnswerSet._formId);
    String where = Forms._id + "=" + formId + " AND " + Forms._isActive + "=1";
    List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(Forms.tableName, where));
    if (jjNumber.isDigit(answerSetId)) {// یعنی فرمی برای ویرایش انتخاب شده است
        String sql = "SELECT hmis_formquestions.*,formanswers_answerSet_id,formanswers_answerSet_id,formanswers_answer FROM hmis_formquestions LEFT JOIN hmis_formanswers on"
                + " hmis_formanswers.formanswers_questionId= hmis_formquestions.id "
                + "WHERE "
                + "formQuestions_formID=" + formId + " AND hmis_formanswers.formanswers_answerSet_id=" + answerSetId + " ;";
        questionsAndAnswerRows = jjDatabaseWeb.separateRow(db.otherSelect(sql));
    } else {
        return;//
    }
    //@ToDo چک کنیم اگر فرم یونیک بودو توسط آی دی این کاربر یا مک آدرس این کاربر  قبلا پر شده بود دیگر  فرم را نشان ندهیم
    if (formRow.isEmpty()) {
        return;//@ToDo نشان دادن صفحه ی خطای عدم دسترسی برای موبایل و ...
    }
    StringBuilder jjfileUplaodScripts = new StringBuilder();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=formRow.get(0).get(Forms._title)%></title>
        <link href="Manager/font-awesome.css" rel="stylesheet">
        <link href="Manager/ionicons.css" rel="stylesheet">
        <link href="Manager/perfect-scrollbar.css" rel="stylesheet">
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
        <div id="swOneFormToCompleteForm">

            <div class="card bd-primary mg-t-20 mg-b-25" id="newFormQuestion">
                <div class="card-header bg-primary tx-white"><%=formRow.get(0).get(Forms._title)%></div>
                <div class="card-body pd-sm-30 mg-b-25">
                    <input id="hmis_formAnswerSet_id" name="id" type="hidden" value="<%=answerSetId%>" /><!-- این قسمت در حالت ویرایش مقدار دارد -->
                    <input id="formAnswers_formId" name="formAnswers_formId" type="hidden" value="<%=formRow.get(0).get(Forms._id)%>" />
                    <p class="mg-b-20 mg-sm-b-30">
                        <%=formRow.get(0).get(Forms._description)%></p>
                        <%=formRow.get(0).get(Forms._htmlContent)%>
                    <div id="swFormQuestionsForm" class="card bd-primary pd-10">
                        <div class="card-header bg-info tx-white">سوالات فرم : </div>
                        <%
                            for (int i = 0; i < questionsAndAnswerRows.size(); i++) {
                        %>
                        <div class="question col-lg-12 card bd-primary mg-t-10 <%= "q" + i + 1%>" id="<%= "q" + i + 1%>"><!-- قرار دادن کلاس برای سوال-->
                            <div class="card-body row">
                                <div class="col-lg-3 col-sm-6">
                                    <img id="formQuestions_icon_Preview"  class="col-lg-12 img-thumbnail" 
                                         <%=/*اگرگزینه  آبکن نداشت*/questionsAndAnswerRows.get(i).get(FormQuestions._icon).toString().isEmpty() ? "src='upload/optionIcon.svg' style='width:40%;min-width: 50px;' " : ("src='upload/" + questionsAndAnswerRows.get(i).get(FormQuestions._icon) + "'")%>  />
                                </div>
                                <div class="col-lg-9">
                                    <div class="col-lg-12 ">
                                        <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "<span class='requierd star'>*</span>" : ""%> <!--  برای سوالات ضروری ستاره-->
                                        <%= i + 1 + "-" + questionsAndAnswerRows.get(i).get(FormQuestions._title).toString()%> <!-- عنوان سوال-->

                                        <%= questionsAndAnswerRows.get(i).get(FormQuestions._htmlDiscription).toString()%> <!--  توضیحات فرم-->
                                    </div>
                                    <%
                                        //اگر نوع پاسخ ها تکست اریا بود
                                        String questionType = questionsAndAnswerRows.get(i).get(FormQuestions._answersType).toString();
                                        if (questionType.equals("textarea")) {
                                    %>                                    
                                    <textarea class="clo-lg-12 form-control" 
                                              id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                              name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                              placeholder="<%=questionsAndAnswerRows.get(i).get(FormQuestions._placeHolder).toString()%>"
                                              <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : ""%>
                                              ><%
                                                  String defaultVal = "";
                                                  if (questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().isEmpty()) {//اگر در حال ویرایش جواب های قبلی بودیم و این فیلد را خالی گذاشته بودیم
                                                      defaultVal = questionsAndAnswerRows.get(i).get(FormQuestions._defaultValue).toString();//مقدار پیش فرض
                                                  } else {
                                                      defaultVal = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString();//پاسخ قبلی
                                                  }
                                        %><%=defaultVal%></textarea>
                                        <%
                                            //اگر تکست  بود 
                                        } else if (questionType.equals("text")) {
                                            String defaultVal = "";
                                            if (questionsAndAnswerRows.get(i).get(FormAnswers._answer) == null || questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().isEmpty()) {//اگر در حال ویرایش جواب های قبلی نبودیم یا این فیلد را خالی گذاشته بودیم
                                                defaultVal = questionsAndAnswerRows.get(i).get(FormQuestions._defaultValue).toString();//مقدار پیش فرض
                                            } else {
                                                defaultVal = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString();//پاسخ قبلی
                                            }
                                        %>
                                    <input class="clo-lg-12 form-control" type="text" 
                                           id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                           name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                           placeholder="<%= questionsAndAnswerRows.get(i).get(FormQuestions._placeHolder)%>" 
                                           value="<%= defaultVal%>"
                                           <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : ""%>
                                           >                                    
                                    <%
                                    } else if (questionType.equals("email")) {
                                        String defaultVal = "";
                                        if (questionsAndAnswerRows.get(i).get(FormAnswers._answer) == null || questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().isEmpty()) {//اگر در حال ویرایش جواب های قبلی نبودیم یا این فیلد را خالی گذاشته بودیم
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormQuestions._defaultValue).toString();//مقدار پیش فرض
                                        } else {
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString();//پاسخ قبلی
                                        }
                                    %>
                                    <input class="clo-lg-12 form-control" type="text" 
                                           id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                           name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                           placeholder="<%= questionsAndAnswerRows.get(i).get(FormQuestions._placeHolder)%>" 
                                           value="<%= defaultVal%>"
                                           <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : ""%>
                                           >                                    
                                    <%
                                        //اگر تاریخ بود کلاس دیت پیکر می گذاریم و در پایین جاوااسکریپ تبدیلش را گذاشته ایم
                                    } else if (questionType.equals("date")) {
                                        String defaultVal = "";
                                        if (questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().isEmpty()) {//اگر  این فیلد را خالی گذاشته بودیم
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormQuestions._defaultValue).toString();//مقدار پیش فرض
                                        } else {
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString();//پاسخ قبلی
                                        }
                                    %>
                                    <input  class="clo-lg-12 form-control datepicker" type="text" 
                                            id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                            name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                            placeholder="<%=questionsAndAnswerRows.get(i).get(FormQuestions._placeHolder)%>" 
                                            value="<%= defaultVal%>"
                                            <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : ""%>
                                            >                                    
                                    <%
                                        //اگر تاریخ بود کلاس دیت پیکر می گذاریم و در پایین جاوااسکریپ تبدیلش را گذاشته ایم
                                    } else if (questionType.equals("number")) {
                                        String defaultVal = "";
                                        if (questionsAndAnswerRows.get(i).get(FormAnswers._answer) == null || questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().isEmpty()) {//اگر در حال ویرایش جواب های قبلی نبودیم یا این فیلد را خالی گذاشته بودیم
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormQuestions._defaultValue).toString();//مقدار پیش فرض
                                        } else {
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString();//پاسخ قبلی
                                        }
                                    %>
                                    <input  class="clo-lg-12 form-control" type="number" 
                                            id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                            name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                            placeholder="<%=questionsAndAnswerRows.get(i).get(FormQuestions._placeHolder)%>" 
                                            value="<%= defaultVal%>"
                                            <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : ""%>
                                            >                                    
                                    <%
                                        //اگر چک باکس بود یک اینپوت مخفی می گذاریم و گزینه های تیک زده شده در آن میروند
                                    } else if (questionType.equals("checkbox")) {
                                        String defaultVal = "";
                                        if (questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().isEmpty()) {//اگر در حال ویرایش جواب های قبلی این فیلد را خالی گذاشته بودیم
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormQuestions._defaultValue).toString();//مقدار پیش فرض
                                        } else {
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString();//پاسخ قبلی
                                        }
                                        List<Map<String, Object>> optionsRow = jjDatabaseWeb.separateRow(db.Select(FormQuestionOptions.tableName, FormQuestionOptions._question_id + "=" + questionsAndAnswerRows.get(i).get(FormQuestions._id)));
                                    %>
                                    <!--برای ذخیره ی رشته ی انتخاب شده ها-->
                                    <input  type="hidden" 
                                            id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>"
                                            name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                            value="<%= defaultVal%>"
                                            <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : ""%>
                                            >                                    
                                    <%
                                        System.out.println("------->>>>>");
                                        for (int j = 0; j < optionsRow.size(); j++) {
                                            String checkBoxValue = optionsRow.get(j).get(FormQuestionOptions._id).toString();
                                            String checked = "";
                                            if (defaultVal.startsWith(checkBoxValue + "%23A%23") || defaultVal.matches(".*%23A%23" + checkBoxValue + "%23A%23.*")) {
                                                System.out.println("------->>>>>" + j);
                                                checked = " checked='checked' ";
                                            } else {
                                                System.out.println("-------<<<<<" + j);
                                                checked = "";
                                            }
                                    %>
                                    <div class="col-lg-12 col-sm-6 row">
                                        <div class="col-lg-3 col-sm-6">
                                            <img class="col-lg img-thumbnail" <%=/*اگرگزینه  آیکن نداشت*/optionsRow.get(j).get(FormQuestionOptions._icon).toString().isEmpty() ? "src='upload/optionIcon.svg' style='width:40%;min-width: 50px;' " : ("src='upload/" + optionsRow.get(j).get(FormQuestionOptions._icon) + "'")%>  />
                                        </div>
                                        <div class="col-lg-12 mg-b-20">
                                            <input type="checkbox"  
                                                   value="<%= checkBoxValue%>"
                                                   <%= (questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : "") + checked%>
                                                   >
                                            <label>
                                                <%= optionsRow.get(j).get(FormQuestionOptions._lable)%>
                                            </label>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    } else if (questionType.equals("radio")) {//اگر رادیو بود برای گزینه های هر سوال
                                        String defaultVal = "";
                                        if (questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().isEmpty()) {//اگر در حال ویرایش جواب های قبلی این فیلد را خالی گذاشته بودیم
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormQuestions._defaultValue).toString();//مقدار پیش فرض
                                        } else {
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString();//پاسخ قبلی
                                        }
                                        List<Map<String, Object>> optionsRow = jjDatabaseWeb.separateRow(db.Select(FormQuestionOptions.tableName, FormQuestionOptions._question_id + "=" + questionsAndAnswerRows.get(i).get(FormQuestions._id)));
                                    %>
                                    <input  type="hidden" 
                                            id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                            name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                            value="<%= defaultVal%>"
                                            <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : ""%>
                                            >                                    
                                    <%
                                        for (int j = 0; j < optionsRow.size(); j++) {
                                            String radioValue = optionsRow.get(j).get(FormQuestionOptions._id).toString();
                                            String checked = "";
                                            if (defaultVal.equals(radioValue)) {// در رادوی ها آی دی یکی از آپشن ها میتواند در مقدار ذخیره شده باشد
                                                System.out.println("------->>>>>" + j);
                                                checked = " checked='checked' ";
                                            } else {
                                                System.out.println("-------<<<<<" + j);
                                                checked = "";
                                            }
                                    %>
                                    <div class="col-lg-12 col-sm-6 row">
                                        <div class="col-lg-3 col-sm-6">
                                            <img class="col-lg img-thumbnail" <%=/*اگرگزینه  آبکن نداشت*/optionsRow.get(j).get(FormQuestionOptions._icon).toString().isEmpty() ? "src='upload/optionIcon.svg' style='width:40%;min-width: 50px;' " : ("src='upload/" + optionsRow.get(j).get(FormQuestionOptions._icon) + "'")%>  />
                                        </div>
                                        <div class="col-lg-12 mg-b-20">
                                            <input type="radio" 
                                                   value="<%= optionsRow.get(j).get(FormQuestionOptions._id) /*در رادیو ها برای جلوگیری از اینسپکتور مرورگر آی دی گزینه را میگذاریم   */%>" 
                                                   name="<%=questionsAndAnswerRows.get(i).get(FormQuestions._id)%>"
                                                   <%= checked%> 
                                                   <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : ""%>
                                                   >
                                            <label>
                                                <%= optionsRow.get(j).get(FormQuestionOptions._lable)%>
                                            </label>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    } else if (questionType.equals("select_option")) {//اگر رادیو بود برای گزینه های هر سوال
                                        String defaultVal = "";
                                        if (questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().isEmpty()) {//اگر در حال ویرایش جواب های قبلی این فیلد را خالی گذاشته بودیم
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormQuestions._defaultValue).toString();//مقدار پیش فرض
                                        } else {
                                            defaultVal = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString();//پاسخ قبلی
                                        }
                                        List<Map<String, Object>> optionsRow = jjDatabaseWeb.separateRow(db.Select(FormQuestionOptions.tableName, FormQuestionOptions._question_id + "=" + questionsAndAnswerRows.get(i).get(FormQuestions._id)));
                                    %>
                                    <div class="col-lg-12">
                                        <select class="" 
                                                id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                            name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                                <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? "required" : ""%> >
                                            <%
                                                for (int j = 0; j < optionsRow.size(); j++) {
                                                    String optionsValue = optionsRow.get(j).get(FormQuestionOptions._id).toString();
                                                    String selected = "";
                                                    if (defaultVal.equals(optionsValue)) {// در رادوی ها آی دی یکی از آپشن ها میتواند در مقدار ذخیره شده باشد
                                                        System.out.println("------->>>>>" + j);
                                                        selected = " selected='selected' ";
                                                    } else {
                                                        System.out.println("-------<<<<<" + j);
                                                        selected = "";
                                                    }
                                            %>
                                            <option
                                                value="<%= optionsRow.get(j).get(FormQuestionOptions._id)%>"                                                
                                                <%= selected%>
                                                >
                                                <%= optionsRow.get(j).get(FormQuestionOptions._lable)%>
                                            </option>
                                            <%
                                                }
                                            %>                                        
                                        </select>
                                    </div>
                                </div>

                                <%
                                } else if (questionType.equals("file")) {//اگر فایل بود باید از فایل آپلود استفاده کنیم
                                    String defaultVal = "";
                                    if (questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString().isEmpty()) {//اگر در حال ویرایش جواب های قبلی این فیلد را خالی گذاشته بودیم
                                        defaultVal = questionsAndAnswerRows.get(i).get(FormQuestions._defaultValue).toString();//مقدار پیش فرض
                                    } else {
                                        defaultVal = questionsAndAnswerRows.get(i).get(FormAnswers._answer).toString();//پاسخ قبلی
                                    }
                                    //اسکریپت هایی که برای هر فایل آپلود باید بسازیم
                                    jjfileUplaodScripts.append(
                                            "new jj('#send_q" + questionsAndAnswerRows.get(i).get(FormQuestions._id).toString() + "_icon').jjAjaxFileUpload2("
                                            + "'q" + questionsAndAnswerRows.get(i).get(FormQuestions._id).toString() + "_file'"
                                            + ", '#q" + questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()+"'"
                                            + ", '#q" + questionsAndAnswerRows.get(i).get(FormQuestions._id).toString() + "_Preview');\n");
                                %>
                                <div class="col-lg-3" style="margin-bottom: 20px">
                                    <input id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>" 
                                           name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>"
                                           value="<%=defaultVal%>"
                                           <%= questionsAndAnswerRows.get(i).get(FormQuestions._isRequierd).toString().equals("1") ? " required" : ""%>
                                           type="hidden" />
                                    <img id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>_Preview" class="img-thumbnail"  src="<%=defaultVal.isEmpty() ? "img/preview.jpg" : ("upload/" + defaultVal)%>"/>
                                    <div class="row">
                                        <input  class="btn btn-primary" id="send_q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>_icon" type="submit"  value="ارسال">
                                        <span class="btn btn-primary" onclick="$(this).parent().find('input[type=file]').click();" >انتخاب فایل</span>
                                        <input  type="file" id="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>_file" name="q<%= questionsAndAnswerRows.get(i).get(FormQuestions._id).toString()%>_file"  onchange="$(this).parent().find('span.form-control').html($(this).val().split(/[\\|/]/).pop());" style="display: none;">
                                        <span class="form-control col-lg"></span>
                                    </div>
                                </div>

                                <%
                                    }

                                %>                                
                            </div>
                        </div>
                    </div>
                    <%                            }
                    %>                        
                </div>

            </div>
            <div class="row" style="margin-bottom: 100px" >
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
            </div>
            <div  id ="newFormToCompleteBottons" class="row col-lg-12 formAnswerBtn" >
                <%
                    String userRoles[] = jjTools.getSeassionUserRole(request).split("%23A%23");
                    if (userRoles.length
                            > 1) {// اگر بیشتر از یک نقش داشت سلکت اپشن نقش هایش را نشانش می دهیم  که هر کدام را خواست انتخاب کند
%>

                <div class="col-lg-3">
                    <select id="formAnswers_userRole" name="formAnswers_userRole" class="form-control" style="width: 100%">
                        <%=Role.getUeserRolesSelectOption(jjTools.getSeassionUserId(request), db)%>
                    </select>
                </div>
                <%
                    }
                %>
                <div class="col-lg-3">
                    <button class="btn btn-outline-secondary mg-b-10  btn-block" onclick="window.close();">بازگشت </button>
                </div>
                <%
                    //@ToDo درست کار نداد این قسمت باید مجدد چک کنیم
                    System.out.println(
                            "********************************");
                    for (int k = 0; k < request.getCookies().length; k++) {
                        System.out.println("=========================" + k);
                        System.out.println(request.getCookies()[k].getName());
                        System.out.println(request.getCookies()[k].getValue());

                    }

                    System.out.println(
                            "********************************");
                    String userMAC = jjTools.getCookie(request, "#USER_MAC");
                    where = FormAnswerSet._formId + "=" + formId + " AND (" + FormAnswerSet._userId + "=" + jjTools.getSeassionUserId(request) + " OR "
                            + FormAnswerSet._userMAC + "=" + userMAC + ") AND " + FormAnswerSet._status + "!='" + FormAnswerSet.statues_sabteAvalie + "'";// جایی که پاسخ در حالت ثبت اولیه نباشد و با همین فرم آی دی و همین کاربر یا همین مک
                    List<Map<String, Object>> uniqueForm = jjDatabaseWeb.separateRow(db.Select(FormAnswerSet.tableName, where));

                    if (formRow.get(
                            0).get(Forms._uniqueComplete).toString().equals("1") && uniqueForm.isEmpty()) {// اگر فرم باید توسط هر کاربر بصورت یونیک پر شود و اگر قبلا ثبت نهایی کرده است 
                        //دکمه های زیر را نشان نمیدهیم
                %>
                <div id="formAnserSetBtn" class="col-lg-8">
                    شما این فرم را قبلا تکمیل کرده اید
                </div>
                <%
                } else {
                    //اگر فرم در حالت ثبت نهایی بود نمی توانیم آنرا ویرایش کنیم و دکمه هار باید حذف کنیم
                    if (db.Select(FormAnswerSet.tableName, FormAnswerSet._id + "=" + answerSetId + " AND " + FormAnswerSet._status + "='" + FormAnswerSet.statues_sabteAvalie + "'").getRowCount() == 1) {

                %>
                <div id="formAnserSetBtn" class="col-lg-8">
                    <div class="col-lg-6">
                        <button class="btn btn-outline-warning mg-b-10  btn-block" onclick="formAnswerSet_edit();">ثبت موقت </button>                
                    </div>
                    <div class="col-lg-6">
                        <button class="btn btn-outline-success mg-b-10  btn-block" onclick="formAnswerSet_editAndFinalForm();">ثبت نهایی </button>                
                    </div>
                </div>
                <%                    } else {
                %>
                <div id="formAnserSetBtn" class="col-lg-8">
                    شما این فرم را قبلا ثبت نهایی کرده اید
                </div>
                <%
                        }
                    }
                %>

            </div>
        </div><!-- card -->        


        <script src="Manager/js/jquery/jquery-1.10.2.js"></script>        
        <script src="Manager/js/jquery/jquery-migrate-1.2.0.js" type="text/javascript"></script>
        <script src="Manager/popper.js"></script>
        <script src="Manager/bootstrap.js"></script>


        <script src="Manager/js/jquery/bootstrap.js"></script>
        <link href="Manager/js/jquery/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css" />
        <script src="Manager/js/jquery/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>
        <!--        //عوض کردن 
        <!--calendar-->        

        <!--<script src="Manager/perfect-scrollbar.jquery.js"></script>-->
        <!--<script src="Manager/moment.js"></script>-->
        <!--<script src="Manager/jquery.flot.js"></script>-->
        <!--<script src="Manager/jquery.flot.resize.js"></script>-->
        <!--<script src="Manager/jquery.flot.spline.js"></script>-->


        <!--calendar-->
        <script src="Manager/js/calendar/jquery.ui.datepicker-cc.js" type="text/javascript"></script>
        <script src="Manager/js/calendar/jquery.ui.datepicker-cc-fa.js" type="text/javascript"></script>
        <script src="Manager/js/calendar/calendar.all.js" type="text/javascript"></script>
        <!--<script src="Manager/js/calendar/calendar.js" type="text/javascript"></script>-->
        <!--        <script src="Manager/js/calendar/wickedpicker.min.js" type="text/javascript"></script>
                <script src="Manager/js/calendar/wickedpickerSpec.js" type="text/javascript"></script>-->


        <!--upload-->
        <script src="Manager/js/ajaxfileupload.js" type="text/javascript"></script>
        <!--DataTable-->
        <!--<script src="Manager/dataTable/jquery.dataTables.js"></script>-->
        <!--<script src="Manager/dataTable/dataTables.responsive.js"></script>-->
        <!--<script src="Manager/dataTable/select2.min.js"></script>-->

        <!--textEditor-->
        <!--<script src="Manager/textEditor/medium-editor.js"></script>-->
        <!--<script src="Manager/textEditor/summernote-bs4.min.js"></script>-->

        <!--jj2-->
        <!--<script src="Manager/textEditor/summernote.js" type="text/javascript"></script>-->
        <script src="Manager/js/js.cookie.js" type="text/javascript"></script>
        <script src="Manager/js/jj2.js" type="text/javascript"></script>
        <script src="Manager/js/index.js" type="text/javascript"></script>
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


        <script type="text/javascript">

                                (function () {
            <%
                // وقتی فرم با موفقیت ثبت نهایی شد باید در کوکی های مرورگر و اپ کاربر کوکی فرم های یونیک را ذخیره کنیم
                // البته در موقع نشان دادن هم میتوانیم با جاوا در دیتا بیش چک کنیم که دیگر این فرم را نشان کاربر ندهیم
                // سمت کلاینت فرم های یونیک را در کوکی ست کنیم که موقع پر کردن بهشان اجازه ندهد
                if (formRow.get(
                        0).get(Forms._uniqueComplete).toString().equals("1")) {// اگر فرم باید یونیک پر شود چک کنیم ببینیم در یونیک فرم های پر شده ی این مرورگر وجود دارد یا نه
%>
                                    var formid = <%=formId%>;
                                    var uniqueForms = Cookies.get('#UNIQUE_FORMS_Compleited');// فرم های که باید توسط هر کاربر یکبار تکمیل شوند بعد از تکمیل نهایی در این کوکی ذخیره میشوند
                                    if (uniqueForms) {
                                        var uniqueFormsId = uniqueForms.split(",");
                                        for (var i = 0; i < uniqueFormsId.length; i++) {
                                            alert("checkUniqueFormInCookies...");
                                            if (uniqueFormsId[i] == formid) {// یعنی این فرم قبلا توسط این کاربر با موفقیت ثبت شده است
                                                $("#newFormToCompleteBottons .btn-outline-warning ,#newFormToCompleteBottons .btn-outline-success").remove();
                                                alert("شما قبلا به این فرم پاسخ گفته اید!!!");
                                            }
                                            ;
                                        }
                                    }

            <%
            } else {//برای حذف فرم هایی که قبلا یکتا بوده اند و الان دیگر یکتا نیستند ازکوکی باید اقدام کنیم
%>
                                    var formid = <%=formId%>;
                                    var uniqueForms = Cookies.get('#UNIQUE_FORMS_Compleited');// فرم های که باید توسط هر کاربر یکبار تکمیل شوندبعد از تکمیل نهایی در این کوکی ذخیره میشوند
                                    removeFormIdFromCookie(formid);

            <%
                }

            %>
//            Math.floor(""Math.random() * 10);
                                    if (Cookies.get('#USER_MAC')) {
                                        alert(Cookies.get('#USER_MAC'));
                                    } else {
                                        Cookies.set('#USER_MAC', Math.random() * 50000000000000000000);
                                    }
                                    new jj("body .datepicker").jjCalendar();
                                    new jj("body input[type='number']").jjSetTextFieldOnlyGetNumber(1000000, 0);// حداکثر طول رشته داخل نامبر
                                    $(".question input:checkbox").click(function () {
                                        var checked = $(this).parent().parent().parent().find("input:checkbox:checked");
                                        var newVal = "";
                                        for (var i = 0; i < checked.length; i++) {
                                            newVal += $(checked[i]).val() + "#A#";
                                        }
                                        $(this).parent().parent().parent().find("input:hidden").val(newVal);
                                    });
                                    $(".question input:radio").click(function () {
                                        $(this).parent().parent().parent().find("input:hidden").val($(this).val());
                                    });

                                })();
            <%=jjfileUplaodScripts%>
        </script>
        <%= formRow.get(0).get(Forms._javaScript)%>

    </body>
</html>
