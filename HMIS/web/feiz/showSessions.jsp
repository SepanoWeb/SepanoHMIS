<%-- 
    Document   : showSessions
    Created on : Apr 22, 2019, 3:57:21 PM
    Author     : SHIRANSHO
--%>


<%@page import="cms.access.Access_User"%>
<%@page import="HMIS.Role"%>
<%@page import="jj.jjCalendar_IR"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="HMIS.Approved"%>
<%@page import="HMIS.Sessions"%>
<%@page import="cms.tools.jjTools"%>
<%@page import="jj.jjDatabaseWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>صورتجلسات من</title>

        <link href="./Manager/font-awesome.css" rel="stylesheet">
        <link href="./Manager/ionicons.css" rel="stylesheet">
        <link href="./Manager/perfect-scrollbar.css" rel="stylesheet">
        <!-- MedYar مدیار CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./Manager/shamcey.css">
        <link href="./Manager/css/HMIS.css" rel="stylesheet" type="text/css"/>

        <script src="js/jquery/jquery-1.10.2_1.js" type="text/javascript"></script>
        <script src="js/jquery/jquery-migrate-1.2.0.js" type="text/javascript"></script>
        <script src="./js/jquery/ui/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>
        <script src="./Manager/js/jj2.js" type="text/javascript"></script>

    </head>
    <body>
        <%
            jjDatabaseWeb db = (jjDatabaseWeb) request.getAttribute("db");
            String sessionId = jjTools.getParameter(request, Sessions._id);
            jjTools.getSeassionUserId(request);
            List<Map<String, Object>> sessionRow = jjDatabaseWeb.separateRow(db.Select(Sessions.tableName, Sessions._id + "=" + sessionId));
            List<Map<String, Object>> approvedRow = jjDatabaseWeb.separateRow(db.Select(Approved.tableName, Approved._sessionsId + "=" + sessionId));
        %>
        <div class="card bd-primary mg-t-20" >
            <div class="card-header bg-primary tx-white"></div>
            <div class="card-body pd-sm-30">
                <div id="" class="card bd-primary">
                    <div class="card-header bg-info tx-white">جدول مصوبات و امضای صورت جلسه</div>
                    <div class="row row-sm">
                        <div class="col-lg-12">
                            <div class="table-wrapper">
                                <table class='table display responsive tahoma10' style='direction: rtl'>
                                    <thead>
                                    <th width='5%'>کد</th>
                                    <th width='10%'>عنوان مصوبه</th>
                                    <th width='15%'>مسئول اجرا</th>
                                    <th width='20%'>مسئول پیگیری</th>
                                    <th width='15%'>تاریخ شروع </th>
                                    <th width='15%'>تاریخ پایان </th>
                                    <th width='15%'>وضعیت</th>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (int i = 0; i < approvedRow.size(); i++) {
                                                List<Map<String, Object>> RoleTrackerId = jjDatabaseWeb.separateRow(db.Select(Role.tableName, Role._id + "=" + approvedRow.get(i).get(Approved._trackerId)));
                                                List<Map<String, Object>> userTrackerId = jjDatabaseWeb.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + RoleTrackerId.get(0).get(Role._user_id)));

                                        %>
                                        <tr>
                                            <td><%=approvedRow.get(i).get(Approved._id)%></td>
                                            <td><%=approvedRow.get(i).get(Approved._title)%></td>
                                            <td ><%= userTrackerId.get(0).get(Access_User._name) + " " + userTrackerId.get(0).get(Access_User._family)%></td>
                                            <td ><%= approvedRow.get(i).get(Approved._executorRoleId)+""+approvedRow.get(i).get(Approved._executorUserId)%></td>
                                            <td><%= jjCalendar_IR.getViewFormat(approvedRow.get(i).get(Approved._startDate))%></td>
                                            <td><%= jjCalendar_IR.getViewFormat(approvedRow.get(i).get(Approved._endDate))%></td>
                                            <td ><%= approvedRow.get(i).get(Approved._status)%></td>
                                            <!--<td><i class='icon ion-gear-a' style='color:#a02311'></i></td>-->
                                        </tr>


                                        <%
                                            }
                                        %>
                                        <tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>


                    </div>
                </div>
                <div id="" class="card bd-primary">
                    <div class="card-header bg-info tx-white">نمایش صورتجلسه</div>
                </div>
                <div class="row row-sm">
                    <div class="col-lg-12">  
                        <div class="card-body pd-sm-30">

                            تاریخ:<p id='sessions_sessionsDate'><%=jjCalendar_IR.getViewFormat(sessionRow.get(0).get(Sessions._date))%></p>
                            <div class="row">
                                <div class="col-lg">
                                    عنوان  جلسه
                                    <input class="form-control"  value="<%=sessionRow.get(0).get(Sessions._title)%>" type="text">
                                </div>
                            </div><!-- row -->

                            <p><input  value="<%=jjCalendar_IR.getViewFormat(sessionRow.get(0).get(Sessions._invitationDate))%>"  type="text"  style="display: block;">: تاریخ ارسال دعوت نامه</p>

                            <div class="card-header btn-teal tx-white">
                                دستور جلسه:
                            </div>
                            <textarea rows="7" type='text' value='' class="form-control is-valid mg-t-20" ><%=sessionRow.get(0).get(Sessions._agenda)%>
                            </textarea> 
                            <div class="card-header bg-primary tx-white">
                                بررسی و تحلیل دستور جلسات
                            </div>
                            <div class="card-body pd-sm-30">
                                <div class="row">
                                    <div class="col-lg-3">
                                        دستور جلسه:
                                        <div class="form-group has-success mg-b-0">
                                            <input  value='<%=sessionRow.get(0).get(Sessions._checkingAgenda)%>' class="form-control is-valid"  type="text">
                                        </div><!-- form-group -->
                                    </div><!-- col -->   

                                    <div class="col-lg-3">
                                        عنوان مسئله
                                        <div class="form-group has-success mg-b-0">
                                            <input  value='<%=sessionRow.get(0).get(Sessions._titleIssue)%>'  class="form-control is-valid" placeholder="مسئله یا مشکل را وارد کنید" type="text">
                                        </div><!-- form-group -->
                                    </div><!-- col -->   
                                    <div class="col-lg-6">
                                        راهکار پیشنهادی
                                        <div class="form-group has-success mg-b-0">
                                            <input value='<%=sessionRow.get(0).get(Sessions._ProposedSolution)%>'  class="form-control is-valid"  type="text">
                                        </div><!-- form-group -->
                                    </div><!-- col -->   
                                    <div class="col-lg-12">
                                        نقاط قوت
                                        <div class="form-group has-success mg-b-0">
                                            <input value='<%=sessionRow.get(0).get(Sessions._strengths)%>'  class="form-control is-valid" placeholder="نقاط قوت" type="text">
                                        </div><!-- form-group -->
                                    </div><!-- col -->   
                                    <div class="col-lg-12">
                                        نقاط ضعف
                                        <div class="form-group has-success mg-b-0">
                                            <input value='<%=sessionRow.get(0).get(Sessions._weakPoint)%>' id="sessions_weakPoint" name="sessions_weakPoint" class="form-control is-valid"  type="text">
                                        </div><!-- form-group -->
                                    </div><!-- col -->
                                    <div class="col-lg-12">
                                        <p>
                                            شرح جلسه:
                                        </p>
                                        <textarea   rows="7" class="form-control is-valid mg-t-20"><%=sessionRow.get(0).get(Sessions._sessionDescription)%>
                                        </textarea>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">   
                    <button  class="btn btn-outline-success active btn-block mg-b-10" onclick="actionSigners('<%=sessionId%>', '<%=jjTools.getSeassionUserId(request)%>');">                    تایید وامضا
                    </button>
                                        <!--<input type="checkbox" id='sessions_signers'  name='sessions_signers' onchange="actionSigners('<%=sessionId%>', '<%=jjTools.getSeassionUserId(request)%>');"/>-->  
                </div>
            </div>
            <script>

                function actionSigners(sessionId, userId) {
                    if (confirm("آیا از تایید و امضا صورت جلسه اطمینان دارید؟")) {
                        actionSigners_after_question(sessionId, userId);
                    } else {
                    }

                }
                function actionSigners_after_question(sessionId, userId) {
                    var param = "";
                    param += "&do=Sessions.actionSigners";
                    param += "&userId=" + userId;
                    param += "&id=" + sessionId;
                    param += "&jj=1";
                    new jj(param).jjAjax2(false);
                }

            </script>
    </body>
</html>





