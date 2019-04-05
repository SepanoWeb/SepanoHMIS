<%-- 
    Document   : newFormToComplete
    Created on : Apr 5, 2019, 4:33:44 PM
    Author     : Mohammad
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="HMIS.FormAnswers"%>
<%@page import="cms.tools.jjTools"%>
<%@page import="HMIS.Forms"%>
<%@page import="jj.jjDatabaseWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    jjDatabaseWeb db = (jjDatabaseWeb) request.getAttribute("db");
    String FormId = jjTools.getParameter(request, FormAnswers._formId);
    String where =Forms._id + "=" + FormId +" AND " + Forms._isActive + "=1";
    List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(Forms.tableName, where));
    if(formRow.isEmpty()){
        return ;
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=formRow.get(0).get(Forms._title) %></title>
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
        <%= formRow.get(0).get(Forms._css) %>
    </head>
    <body>
        <div id="swOneFormToCompleteForm">
            <div class="card bd-primary mg-t-20" id="newFormQuestion">
                <div class="card-header bg-primary tx-white"><%=formRow.get(0).get(Forms._title) %></div>
                <div class="card-body pd-sm-30">
                    <p class="mg-b-20 mg-sm-b-30"><%=formRow.get(0).get(Forms._description) %></p>
                    <%=formRow.get(0).get(Forms._htmlContent) %>
                    <div id="swFormQuestionsForm" class="card bd-primary">
                        <div class="card-header bg-info tx-white">افزودن یا ویرایش یکی از سوالات فرم</div>
                        <div   class="col-lg-12">
                            <div class="row mg-t-20 card-body">
                                <div class="row mg-t-20 card-body">
                                    <div class="col-lg-3" style="margin-bottom: 20px">
                                        <input id="hmis_formquestions_id" name="id" type="hidden" />
                                        <input id="formQuestions_icon" name="formQuestions_icon" type="hidden" />
                                        آیکن مخصوص این سوال
                                        <img id="formQuestions_icon_Preview"  class="img-thumbnail"  src="img/preview.jpg"/>
                                        <div class="row">
                                            <input  class="btn btn-primary" id="send_formQuestions_icon" type="submit"  value="ارسال" >
                                            <span class="btn btn-primary" onclick="$(this).parent().find('input[type=file]').click();" >انتخاب فایل</span>
                                            <input id="formQuestions_icon_file" name="formQuestions_icon_file"  onchange="$(this).parent().find('span.form-control').html($(this).val().split(/[\\|/]/).pop());" style="display: none;" type="file">
                                            <span class="form-control col-lg"></span>
                                        </div>
                                    </div>  
                                </div> <!-- row -->
                                <div class="row mg-t-20">
                                    <div class="col-lg-10">
                                        <div class="form-group has-success mg-b-0">
                                            متن سوال:
                                            <input id="formQuestions_title" name="formQuestions_title"  class="form-control" placeholder="متن سوال را حداکثر در 1000 کارامتر وارد کنید :" type="text">                            
                                        </div><!-- form-group -->
                                    </div><!-- col -->
                                    <div class="col-lg-10">
                                        <div class="form-group has-success mg-b-0">
                                            مقدار پیشفرض:
                                            <input id="formQuestions_defaultValue" name="formQuestions_defaultValue"  class="form-control" placeholder="وقتی کاربر فرم را باز می کند مقدار پیشفرض در پاسخ قرار دارد" type="text">                            
                                        </div><!-- form-group -->
                                    </div><!-- col -->
                                    <div class="col-lg-10">
                                        <div class="form-group has-success mg-b-0">
                                            راهنمای درون فیلد های متنی(place holder):
                                            <input id="formQuestions_placeHolder" name="formQuestions_placeHolder"  class="form-control" placeholder="وقتی کاربر فرم را باز می کند مقدار پیشفرض در پاسخ قرار دارد" type="text">                            
                                        </div><!-- form-group -->
                                    </div><!-- col -->
                                    <div class="col-lg-2">
                                        <div class="form-group has-warning mg-b-0">
                                            ضریب وزنی سوال:
                                            <input id="formQuestions_weight" name="formQuestions_weight" class="form-control" placeholder="فقط عدد" type="number" value="1">                            
                                        </div><!-- form-group -->
                                    </div><!-- col -->
                                    <div class="col-lg-2">
                                        <label class="ckbox">
                                            <input id="formQuestions_isRequierd" name="formQuestions_isRequierd" type="checkbox"><span>پاسخ اجباری باشد</span>
                                        </label>
                                    </div><!-- col -->
                                    <div class="col-lg-12">
                                        متن تکمیلی و پیشرفته 
                                        <textarea id="formQuestions_htmlDiscription" name="formQuestions_htmlDiscription" rows="4" class="form-control summernote" placeholder="توضیحات فرم"></textarea>
                                    </div><!-- col -->
                                </div><!-- row -->
                                <input id="formQuestions_answersType" name="formQuestions_answersType"  type="hidden" value="select_option">                            
                                <div class="row col-lg-12">
                                    <div class="formTypeSelector">
                                        نوع فیلد:
                                        <ul class="choose_type list-group" style="display: inline-flex;flex-direction: row;">
                                            <li id="field_texte" class="list-group-item pull-left text-center pointer" title="متن" onclick="$('.list-group-item.active').removeClass('active');
                                            $('#formQuestions_answersType').val('text');
                                            $(this).toggleClass('active');
                                            $('#swFormQuestionOptionsForm').hide();
                                            $('#swFormQuestionOptionsTbl').hide();">

                                                <p>
                                                    <i class="fa fa-file-text-o"></i></p>
                                            </li>
                                            <li id="field_textarea" class="list-group-item pull-left text-center pointer" title="متن چند خطی" onclick="$('.list-group-item.active').removeClass('active');
                                            $('#formQuestions_answersType').val('textarea');
                                            $(this).toggleClass('active');
                                            $('#swFormQuestionOptionsForm').hide();
                                            $('#swFormQuestionOptionsTbl').hide();">
                                                <p>
                                                    <i class="fa fa-file-text"></i></p>
                                            </li>
                                            <li id="field_email" class="list-group-item pull-left text-center pointer" title="ایمیل" onclick="$('.list-group-item.active').removeClass('active');
                                            $('#formQuestions_answersType').val('email');
                                            $(this).toggleClass('active');
                                            $('#swFormQuestionOptionsForm').hide();
                                            $('#swFormQuestionOptionsTbl').hide();">
                                                <p>
                                                    @                                    </p>
                                            </li>
                                            <li id="field_number" class="list-group-item pull-left text-center pointer" title="عدد" onclick="$('.list-group-item.active').removeClass('active');
                                            $('#formQuestions_answersType').val('number');
                                            $(this).toggleClass('active');
                                            $('#swFormQuestionOptionsForm').hide();
                                            $('#swFormQuestionOptionsTbl').hide();">
                                                <p>
                                                    123                                    </p>
                                            </li>
                                            <li id="field_date" class="list-group-item pull-left text-center pointer" title="تاریخ" onclick="$('.list-group-item.active').removeClass('active');
                                            $('#formQuestions_answersType').val('date');
                                            $(this).toggleClass('active');
                                            $('#swFormQuestionOptionsForm').hide();
                                            $('#swFormQuestionOptionsTbl').hide();">
                                                <p>
                                                    <i class="fa fa-clock-o"></i></p>
                                            </li>
                                            <!--                                    <li id="field_geoloc" class="list-group-item pull-left text-center pointer" title="موقعیت جغرافیایی" onclick="$('.list-group-item.active').removeClass('active');
                                                                                    
                                                                                        $(this).toggleClass('active');
                                                                                       $('#swFormQuestionOptionsForm').hide();$('#swFormQuestionOptionsTbl').hide();">
                                                                                    <p>
                                                                                        <i class="fa fa-map"></i></p>
                                                                                </li>-->
                                            <li id="field_checkbox" class="list-group-item pull-left text-center pointer active" title="چک باکس" onclick="$('.list-group-item.active').removeClass('active');
                                            $('#formQuestions_answersType').val('checkbox');
                                            $(this).toggleClass('active');
                                            hmisFormQuestionOptions.m_show_tbl();
                                            hmisFormQuestionOptions.m_refresh($('#hmis_formquestions_id').val());
                                                ">
                                                <p>
                                                    <i class="fa fa-check-square-o"></i></p>
                                            </li>
                                            <li id="field_radio" class="list-group-item pull-left text-center pointer" title="رادیو" onclick="$('.list-group-item.active').removeClass('active');
                                            $('#formQuestions_answersType').val('radio');
                                            $(this).toggleClass('active');
                                            hmisFormQuestionOptions.m_show_tbl()
                                            hmisFormQuestionOptions.m_refresh($('#hmis_formquestions_id').val());
                                                ">
                                                <p>
                                                    <i class="fa fa-circle-o"></i></p>
                                            </li>
                                            <li id="field_select_option" class="list-group-item pull-left text-center pointer" title="کشویی" onclick="$('.list-group-item.active').removeClass('active');
                                            $('#formQuestions_answersType').val('select_option');
                                            $(this).toggleClass('active');
                                            hmisFormQuestionOptions.m_show_tbl();
                                            hmisFormQuestionOptions.m_refresh($('#hmis_formquestions_id').val());
                                                ">
                                                <p>
                                                    <i class="fa fa-caret-square-o-down"></i></p>
                                            </li>
                                            <li id="field_image" class="list-group-item pull-left text-center pointer" title="تصویر" onclick="$('.list-group-item.active').removeClass('active');
                                            $('#formQuestions_answersType').val('file');
                                            $(this).toggleClass('active');
                                            $('#swFormQuestionOptionsForm').hide();
                                            $('#swFormQuestionOptionsTbl').hide();">
                                                <p>
                                                    <i class="fa fa-file-picture-o"></i></p>
                                            </li>
                                        </ul>
                                    </div><!-- col-1 -->                
                                </div><!-- row -->
                                <div class="row col-sm-12 mg-t-20">
                                    <div class="col-lg-3">
                                        <button class="btn btn-outline-secondary btn-block mg-b-10" onclick="hmisFormQuestions.m_show_tbl();
                                        $('#refreshFormQuestions').dataTable({destroy: true});">انصراف</button>
                                    </div><!-- col-1 --> 
                                    <div id="form_Question_buttons" class="col-lg row" >
                                    </div>
                                </div><!-- row -->
                                <div id="swFormQuestionOptionsTbl" class="col-lg-12" >
                                </div>
                                <div id="swFormQuestionOptionsForm" class="col-lg-12 row" style="text-align: right;">
                                    <input type="hidden" id="hmis_formquestionOptions_id" name="id">
                                    <div class="col-xs-3 col-sm-3 col-lg-3">
                                        <input id="formQuestionOptions_icon" name="formQuestionOptions_icon" type="hidden">
                                        تصویر برای نمایش این گزینه
                                        <div>
                                            <img id="formQuestionOptions_Preview" class="img-thumbnail" src="img/preview.jpg" style="max-width:80;height: 36px ;">
                                            <input class="btn btn-primary" id="send_formQuestionOptions_icon" type="submit" value="ارسال">
                                            <span class="btn btn-primary" onclick="$(this).parent().find('input[type=file]').click();">انتخاب فایل</span>
                                            <input id="formQuestionOptions_icon_file" name="formQuestionOptions_icon_file" onchange="$(this).parent().parent().find('.form-control').html($(this).val().split(/[\\|/]/).pop());" style="display: none;" type="file">
                                            <!--<span class="form-control"></span>-->
                                        </div>
                                    </div>
                                    <div class="col-xs-4 col-sm-4 col-lg-4">
                                        عنوان گزینه
                                        <input id="formQuestionOptions_lable" name="formQuestionOptions_lable" class="form-control is-valid" placeholder="متن حداکثر 1000 کاراکتر" type="text">
                                    </div>
                                    <div class="col-lg">
                                        مقدار عددی
                                        <input id="formQuestionOptions_value" name="formQuestionOptions_value" class="form-control is-valid jjdigit" placeholder="برای محاسبات" type="text">
                                    </div>
                                    <div class="mg-t-20  col-lg">
                                        <button class="btn btn-outline-secondary btn-block text-center" onclick="hmisFormQuestionOptions.m_show_tbl();" title="انصراف">انصراف</button>
                                    </div>
                                    <div id="formQuestionOption_buttons" class="mg-t-20  col-lg text-center">
                                    </div>
                                </div>
                            </div><!-- row -->
                        </div><!-- card-body -->
                    </div><!-- card-body -->


                    <div id="swFormQuestionsTbl" class="col-lg-12" >
                    </div>
                </div><!-- formquestion-->
            </div><!-- sh-pagebody -->    
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
        <%= formRow.get(0).get(Forms._javaScript) %>
    </body>
</html>
