/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import cms.access.Access_User;
import cms.tools.Js;
import cms.tools.Server;
import cms.tools.UploadServlet;
import cms.tools.jjTools;
import cms.tools.jjValidation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;
import jj.jjCalendar_IR;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;

/**
 *
 * @author shohreh.shiran Date 1397.12.11 Session:صورت جلسه و دعوتنامه
 */
public class Sessions {

    public static String tableName = "hmis_sessions";
    public static String _id = "id";
    public static String _creatorId = "sessions_creatorId";//ای دی ایجاد کننده
    public static String _title = "sessions_title";//عنوان جلسه
    public static String _commetteId = "sessions_commettesId";//ایدی کمیته
    public static String _communicatorRoleId = "sessions_communicatorRoleId";//ابلاغ کننده
    public static String _contextInvitation = "sessions_contextInvitation";//متن دعوتنامه
    public static String _invitationDate = "sessions_invitationDate";//تاریخ ارسال دعوتنامه
    public static String _agenda = "sessions_agenda";//دستور جلسه
    public static String _date = "sessions_date";//تاریخ جلسه
    public static String _time = "sessions_time";//تایم جلسه
    public static String _dateReminder = "sessions_dateReminder";//تاریخ یادآوری
    public static String _timeReminder = "sessions_timeReminder";//ساعت یادآوری
    public static String _Invitees = "sessions_Invitees";//مدعوین داخل سازمان نقش ها//ای دی نقش ها
    public static String _InviteesInSide = "sessions_InviteesInSide";//مهمانان داخل سازمان یوزرها
    public static String _InviteesOutSide = "sessions_InviteesOutSide";//مدعوین خارج از سازمان
    public static String _status = "sessions_status";//وضعیت
    public static String _statusLog = "sessions_statusLog";//روند وضعیت
    public static String _nextDate = "sessions_nextSessionDate";//تاریخ جلسه بعد
    public static String _strengths = "sessions_strengths";//نقاط قوت
    public static String _weakPoint = "sessions_weakPoint";//نقاط ضعف
    public static String _titleIssue = "sessions_titleIssue";//عنوان مسئله
    public static String _ProposedSolution = "sessions_proposedSolution";//راهکار پیشنهادی
    public static String _checkingAgenda = "sessions_checkingAgenda";//بررسی دستور جلسه
    public static String _file = "sessions_file";// فایل های بارگذاری شده
    public static String _InviteesFile = "sessions_InviteesFile";//فایل برای مدعوین
    public static String _sessionDescription = "sessions_sessionDescription";//شرح جلسه
    public static String _audience = "sessions_audience";// حضار در جلسه 
    public static String _audienceInSide = "sessions_audienceInSide";// داخل  سازمان حضار در جلسه
    public static String _audienceOutSide = "sessions_audienceOutSide";// خارج از سازمان حضار در جلسه
    public static String _signers = "sessions_signers";// امضا کنندگان

    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;
    public static int rul_lng2 = 0;
    public static int rul_lng3 = 0;
    public static int rul_lng4 = 0;
    public static int rul_lng5 = 0;
    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ثبت ویرایش";
    public static String status_confirmationFinal = "تایید نهایی";
    public static String status_sendComment = "ارسال دعوتنامه";
    public static String status_created = "ایجاد شده";
    public static String status_communicated = "ابلاغ شده";
    public static String status_ignore = "رد شده";

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();
//            StringBuilder html1 = new StringBuilder();

            DefaultTableModel dtm = db.Select(tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.otherSelect("SELECT S.sessions_time,S.sessions_title,S.sessions_audience,S.sessions_signers,S.sessions_date,S.sessions_status,S.id,C.commettes_title,A.user_name,A.user_family "
                    + "FROM hmis_sessions S"
                    + " LEFT JOIN hmis_commettes C ON S.sessions_commettesId=C.id"
                    + " LEFT JOIN hmis_role R ON C.commettes_secretary=R.id"
                    + " LEFT JOIN access_user A ON R.role_user_id=A.id"
            //                    + " INNER JOIN hmis_approved  AP ON S.id=AP.approved_sessionsId"
            //                    + " WHERE S.id having sum(AP.approved_status='" + status_communicated + "')=0 "
            ));

            html.append(" <div class=\"card-header bg-primary tx-white\">لیست جلسات</div>\n");
            html.append("<div class=\"table-wrapper\">\n");
            html.append("<table id='refreshSessions' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>عنوان جلسه</th>");
            html.append("<th width='10%'> کمیته</th>");
            html.append("<th width='10%'>دبیر کمیته</th>");
            html.append("<th width='20%'>تاریخ و ساعت شروع</th>");
            html.append("<th width='15%'>وضعیت</th>");
            html.append("<th width='15%'>امضا</th>");
            html.append("<th width='15%'>انتقال به میز هوشمند</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {

                html.append("<tr onclick='hmisSessions.m_select(" + row.get(i).get(_id) + ")' class='mousePointer " + getClassCssForVaziat(row.get(i).get(_status).toString()) + "'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_title) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Commettes._title) + "</td>");
                html.append("<td class='r'>" + row.get(0).get(Access_User._name) + " " + row.get(0).get(Access_User._family) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_date) + "-" + row.get(i).get(_time) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_status) + "</td>");
                String signers = row.get(i).get(_signers).toString();
                String[] signerId = (signers.replaceAll("#A#", "%23A%23")).split("%23A%23");

                html.append("<td class='r'>");

                String audiences = row.get(i).get(_audience).toString();
                if (!audiences.equals("")) {
                    String[] audienceId = ((row.get(i).get(_audience).toString()).replaceAll("#A#", "%23A%23")).split("%23A%23");
                    for (int j = 0; j < signerId.length; j++) {
                        for (int k = 0; k < audienceId.length; k++) {
                            if (signerId[j].equals(audienceId[k])) {

                                html.append("<i class='icon ion-checkmark-circled' style='color:green'></i>");
                            } else {

                                html.append("<i class='icon ion-checkmark-circled' style='color:#eee'></i>");
                            }
                        }
                    }
                }
                html.append("</td>");
                html.append("<td class='r'><i class='icon ion-coffee' style='color:#a02311'></i></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            html.append("</div>");
//            List<Map<String, Object>> RolesRow = jjDatabase.separateRow(db.Select(Role.tableName));
//            html1.append("<option value=''>انتخاب کنید</option>");
//            for (int i = 0; i < RolesRow.size(); i++) {
//                html1.append("<option id='" + RolesRow.get(i).get(Role._user_id) + "' value='" + RolesRow.get(i).get(Role._id) + "'>" + RolesRow.get(i).get(Role._title) + "</option>");
//            }
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swSessionsTbl";
            }
            String script = Js.setHtml("#" + panel, html.toString());
            script += Js.table("#refreshSessions", "300", 0, "", "جلسات");

//            script += Js.setHtml("#sessions_communicatorRoleId", html1);
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));

            return "";
        }
    }

    /**
     * آرشیو صورت جلسات
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String archivesSessionsRefresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();
            DefaultTableModel dtm = db.Select(tableName, _status + "='" + status_communicated + "'");
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

            html.append(" <div class=\"card-header bg-primary tx-white\">لیست جلسات</div>\n");
            html.append("<div class=\"table-wrapper\">\n");
            html.append("<table id='archivesSessionsRefresh' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>عنوان جلسه</th>");
            html.append("<th width='15%'> کمیته</th>");
            html.append("<th width='20%'>دبیر کمیته</th>");
            html.append("<th width='15%'>وضعیت</th>");
            html.append("<th width='40%'>دریافت صورتجلسه</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                List<Map<String, Object>> commettedRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + row.get(i).get(_commetteId)));
                List<Map<String, Object>> RoleRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + commettedRow.get(0).get(Commettes._secretary)));
                List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + RoleRow.get(0).get(Role._user_id)));

                html.append("<tr class='mousePointer " + getClassCssForVaziat(row.get(i).get(_status).toString()) + "'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_title) + "</td>");
                html.append("<td class='r'>" + commettedRow.get(0).get(Commettes._title) + "</td>");
                html.append("<td class='r'>" + UserRow.get(0).get(Access_User._name) + " " + UserRow.get(0).get(Access_User._family) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_status) + "</td>");

                html.append("<td class='r'><a href=\"Server?do=Sessions.downloadSessions&id=" + row.get(i).get(_id) + "\" target=\"_blank\" ><i class='icon ion-code-download' style='color='#000'></i></a></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            html.append("</div>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swArchivesSessionsTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#archivesSessionsRefresh", "300", 0, "", "جلسات");

            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));

            return "";
        }
    }

    /**
     * creator shohre shiran 13971211
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            StringBuilder html = new StringBuilder();

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Commette_button", "<input type=\"button\" id=\"insert_Commette_new\" value=\"" + lbl_insert + "\" class=\"btn btn-success btn-block mg-b-10 tahoma10\">"));
                html.append(Js.buttonMouseClick("#insert_Sessions_new", Js.jjSessions.insert()));
            }
            Server.outPrinter(request, response, html.toString());
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * creator shohre shiran 13971211
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);// ای دی جلسه

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + row.get(0).get(_commetteId)));
            String commetteId = row.get(0).get(_commetteId).toString();// ای دی کمیته
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }

            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder html5 = new StringBuilder();
            StringBuilder html6 = new StringBuilder();
            StringBuilder html7 = new StringBuilder();
            StringBuilder html8 = new StringBuilder();
            String script = "";
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setHtml("#commettesTitle", commettesRow.get(0).get(Commettes._title) + "-جلسه" + row.get(0).get(_date)));
            html.append(Js.setHtml("#sessions_sessionsDate", jjCalendar_IR.getViewFormat(row.get(0).get(_date))));
            html.append(Js.setVal("#sessions_agendaSessions", row.get(0).get(_agenda)));
            html.append(Js.setVal("#sessions_titleSessions", row.get(0).get(_title)));
            html.append(Js.setVal("#" + _checkingAgenda, row.get(0).get(_checkingAgenda)));
            html.append("$('#sessions_communicatorRoleId').val([" + row.get(0).get(_communicatorRoleId) + "]);$('#sessions_communicatorRoleId').select2({ minimumResultsForSearch: '', width: '100%'});");

            html.append(Js.setVal("#" + _titleIssue, row.get(0).get(_titleIssue)));
            html.append(Js.setVal("#" + _ProposedSolution, row.get(0).get(_ProposedSolution)));
            html.append(Js.setVal("#" + _weakPoint, row.get(0).get(_weakPoint)));
            html.append(Js.setVal("#" + _strengths, row.get(0).get(_strengths)));
            html.append(Js.setVal("#" + _sessionDescription, row.get(0).get(_sessionDescription)));
            html.append(Js.setVal("#" + _invitationDate, jjCalendar_IR.getViewFormat(row.get(0).get(_invitationDate))));
            html.append(Js.setVal("#" + _nextDate, jjCalendar_IR.getViewFormat(row.get(0).get(_nextDate))));
            html.append(Js.setVal("#" + _file, row.get(0).get(_file)));
            if (!row.get(0).get(_file).toString().equals("")) {
                String[] File = (row.get(0).get(_file).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html8.append("<div class='col-lg-12'> "
                        + "فایل های دبیر کمیته"
                        + "</div>"
                        + "");
                for (int i = 0; i < File.length; i++) {
                    html8.append("<div class='col-lg-3'>");
                    if (row.get(0).get(_status).equals(status_created)) {//اگر وضعیت ایجاد شده باشد دکمه حذف فایل نمایش داده می شود
                        List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + File[i] + "'"));

                        html8.append("<span  class='col-xs-1' onclick='hmisSessions.m_remove(" + fileRow.get(0).get(UploadServlet._id) + "," + id + ");'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
                    }
                    html8.append("<a id='downloadFile_Sessions' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                    html8.append("</div>");
                }
            }
            String InviteesInSideId = row.get(0).get(_InviteesInSide).toString();
            String[] InviteeInSideId = (InviteesInSideId.replaceAll("#A#", "%23A%23")).split("%23A%23");
            String audiences = row.get(0).get(_audience).toString();
            String audiencesInSide = row.get(0).get(_audienceInSide).toString();
            String audiencesOutSide = row.get(0).get(_audienceOutSide).toString();
            String[] audienceName = (audiences.replaceAll("#A#", "%23A%23")).split("%23A%23");
            String[] audiencesInSideName = (audiencesInSide.replaceAll("#A#", "%23A%23")).split("%23A%23");
            String[] audiencesOutSideName = (audiencesOutSide.replaceAll("#A#", "%23A%23")).split("%23A%23");
            if (InviteeInSideId.length > 1) {//اگر  فردی وجود داشته باشد
                //دعوت شدگان مهمان داخل سازمان
                System.out.println("InviteeInSideId=" + InviteeInSideId.length);
                for (int i = 0; i < InviteeInSideId.length; i++) {
                    boolean flag = false;
                    for (int j = 0; j < audiencesInSideName.length; j++) {

                        Pattern pj = Pattern.compile("^" + InviteeInSideId[i] + "%23A%23");
                        Matcher mj = pj.matcher(audiencesInSide);
                        if (mj.find()) {
                            flag = true;
                        } else {
                        }
                    }
                    String attrChecked = "";
                    if (flag == true) {
                        attrChecked = "checked='checked'";
                    } else {
                        attrChecked = "";
                    }
                    List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + InviteeInSideId[i]));
                    html4.append("<div class=\"form-group has-danger mg-b-0\">\n"
                            + "                        <label class=\"ckbox\">\n"
                            + "                            <input class='checkboxAudienceInSide' " + attrChecked + " id='InviteeInSideId" + i + "' name='" + InviteeInSideId[i] + "' value='" + userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString() + "' type=\"checkbox\"><span>"
                            + "مهمان داخل سازمان" + "-" + userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString()
                            + ""
                    );
                    html4.append("</span>");
                    html4.append("</label>");
                    html4.append("</div>");

                }
            }
            //دعوتشدگان مهمان خارج از سازمان
            String InviteesOutSideId = row.get(0).get(_InviteesOutSide).toString();
            if (!InviteesOutSideId.equals("")) {
                String[] InviteeOutSideId = (InviteesOutSideId.replaceAll("#A#", "%23A%23")).split("%23A%23");
                System.out.println("InviteeOutSideId.length=" + InviteeOutSideId.length);

                System.out.println("InviteeOutSideId=" + InviteeOutSideId.length);
                for (int i = 0; i < InviteeOutSideId.length; i++) {
                    String temp = InviteeOutSideId[i];
                    String Email = "";
                    String[] InviteeOutSideDetail = InviteeOutSideId[i].split(",");
                    Email = InviteeOutSideDetail[2];//در آوردن ایمیل فرد
                    //در این قسمت اگر مهمانانو واعضای سازمان حضور داشته باشند  در سلک تیک میخورد
                    boolean flag = false;
                    for (int j = 0; j < audiencesOutSideName.length; j++) {
                        Pattern pj = Pattern.compile("^" + InviteeOutSideId[i] + "%23A%23");
                        Matcher mj = pj.matcher(audiencesOutSide);
                        if (mj.find()) {
                            flag = true;
                        } else {
                        }
                    }
                    String attrChecked = "";
                    if (flag == true) {
                        attrChecked = "checked='checked'";
                    } else {
                        attrChecked = "";
                    }
                    html4.append("<div class=\"form-group has-danger mg-b-0\">\n"
                            + "<label class=\"ckbox\">\n"
                            + " <input class='checkboxAudienceOutSide' " + attrChecked + " id='InviteeOutSideId" + i + "'  value='" + Email + "' type=\"checkbox\"><span>"
                            + "مهمان خارج سازمان" + "-" + InviteeOutSideId[i]
                            + "");
                    html4.append("</span>");
                    html4.append("</label>");
                    html4.append("</div>");
                }
            } else {
            }
            //دعوتشدگان مسئول در سازمان
            String InvitedsId = row.get(0).get(_Invitees).toString().replaceAll("#A#", "%23A%23");
            String[] invitedId = (InvitedsId).split("%23A%23");
            if (invitedId.length >= 1) {
                System.out.println("invitedId=" + invitedId.length);
                for (int i = 0; i < invitedId.length; i++) {
                    List<Map<String, Object>> roleRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + invitedId[i]));
                    List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + roleRow.get(0).get(Role._user_id)));
                    boolean flag = false;
                    for (int j = 0; j < audienceName.length; j++) {

                        Pattern pj = Pattern.compile("" + invitedId[i] + "%23A%23");
                        Matcher mj = pj.matcher(audiences);
                        if (mj.find()) {
                            flag = true;
                        } else {
                        }
                    }
                    String attrChecked = "";
                    if (flag == true) {
                        attrChecked = "checked='checked'";
                    } else {
                        attrChecked = "";
                    }
                    html4.append("<div class=\"form-group has-danger mg-b-0\">\n"
                            + "                        <label class=\"ckbox\">\n"
                            + "                            <input class='checkboxAudience' " + attrChecked + "  id='Invitee" + i + "' name='" + invitedId[i] + "' type=\"checkbox\" value='" + roleRow.get(0).get(Role._title).toString() + "-" + userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString() + "'><span>"
                            + roleRow.get(0).get(Role._title).toString() + "-" + userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString()
                            + "");
                    html4.append("</span>");
                    html4.append("</label>");
                    html4.append("</div>");

                }
            }

            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            if (row.get(0).get(_status).equals(status_created)) {
                if (accEdt) {
                    html2.append("<div class=\"col-lg-6\">");
                    html2.append("<button onclick='hmisSessions.m_edit();' id='edit_Sessions'  class='btn btn-outline-warning btn-block mg-b-10'>ثبت موقت</button>");
                    html2.append("</div>");
                }
                if (accEdt) {
                    html2.append("<div class=\"col-lg-6\">");
                    html2.append("<button onclick='hmisSessions.confirmationFinalSessions(" + id + ");' id='Confirmation_Sessions'  class='btn btn-outline-success  btn-block mg-b-10'>تایید نهایی وارسال به مسئول ابلاغ</button>");
                    html2.append("</div>");
                }
            }
            html2.append("<div class=\"col-lg-6\">");
            html2.append("<div class='sh-pagetitle-icon'>");
            html2.append("<a href='Server?do=Sessions.downloadSessions&id=" + id + "' title='چاپ صورتجلسه' target='_blank'  class='active btn-block mg-l-10'><i class='fa fa-print mg-t-3'></i></a>");
            html2.append("</div>");
            html2.append("</div>");

            DefaultTableModel dtm = db.Select(Approved.tableName, Approved._sessionsId + "=" + id);
            DefaultTableModel dtm1 = db.Select(Approved.tableName, Approved._commettesId + "=" + row.get(0).get(_commetteId) + " AND " + Approved._status + "='" + Approved.status_offer + "'");

            List<Map<String, Object>> approvedRow = jjDatabase.separateRow(dtm);
            List<Map<String, Object>> approveOffererRow = jjDatabase.separateRow(dtm1);//نمایش جدول پیشنهاد ها
///////////////////////////////////////////////////مصوبات مربوط به آن جلسه
            html3.append("<div class=\"table-wrapper\">\n");
            html3.append("<table id='refreshApprovedInSession' class='table display responsive' class='tahoma10' style='direction: rtl;'><thead>");
            html3.append("<th width='5%'>کد</th>");
            html3.append("<th width='10%'>عنوان مصوبه</th>");
            html3.append("<th width='15%'>مسئول اجرا</th>");
            html3.append("<th width='20%'>مسئول پیگیری</th>");
            html3.append("<th width='15%'>تاریخ شروع </th>");
            html3.append("<th width='15%'>تاریخ پایان </th>");
            html3.append("<th width='15%'>وضعیت</th>");
            html3.append("<th width='40%'>ویرایش</th>");
            html3.append("</thead><tbody>");

            for (int i = 0; i < approveOffererRow.size(); i++) {//پیشنهادات  برنامه عملیاتی  در جدول مصوبات که کمیته می تواند ان را رد کند یا بپذیرد
                html3.append("<tr style='background-color:#eee' class='mousePointer " + getClassCssForVaziat(approveOffererRow.get(i).get(Approved._status).toString()) + "'>");
                html3.append("<td class='c'>" + approveOffererRow.get(i).get(Approved._id) + "</td>");
                html3.append("<td class='r'>" + approveOffererRow.get(i).get(Approved._title) + "</td>");
                html3.append("<td class='r'><div></div></td>");
                html3.append("<td class='r'><div></div></td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(approveOffererRow.get(i).get(Approved._startDate)) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(approveOffererRow.get(i).get(Approved._endDate)) + "</td>");
                html3.append("<td class='r' >" + approveOffererRow.get(i).get(Approved._status) + "</td>");
                html3.append("<td class='r'><span><i class=\"ion-android-add actionIconAdd\" style=\"color:green;margin:2px 2px;cursor: pointer\" onclick=\"hmisApproved.actionIconAdd(" + approveOffererRow.get(i).get(Approved._id) + "," + id + ");\"></i><i class=\"ion-android-remove actionIconRemove\" style=\"margin:2px 2px;cursor: pointer\" onclick=\"hmisApproved.actionIconReject(" + approveOffererRow.get(i).get(Approved._id) + "," + id + " );\"></i></span></td>");
                html3.append("</tr>");
            }
            for (int j = 0; j < approvedRow.size(); j++) {
                List<Map<String, Object>> RolesTrackerIdRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + approvedRow.get(j).get(Approved._trackerId)));

                html3.append("<tr onclick='hmisApproved.selectInSessions(" + approvedRow.get(j).get(Approved._id) + ");' class='mousePointer " + getClassCssForVaziat(approvedRow.get(j).get(Approved._status).toString()) + "'>");
                html3.append("<td class='c'>" + approvedRow.get(j).get(Approved._id) + "</td>");
                html3.append("<td class='r'>" + approvedRow.get(j).get(Approved._title) + "</td>");
                html3.append("<td class='r'>" + (approvedRow.get(j).get(Approved._executorRoleId).toString()) + "" + (approvedRow.get(j).get(Approved._executorUserId).toString()) + "</td>");
                if (RolesTrackerIdRow.size() > 0) {
                    List<Map<String, Object>> UserTrackerIdRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + RolesTrackerIdRow.get(0).get(Role._user_id)));
                    html3.append("<td class='r'>" + RolesTrackerIdRow.get(0).get(Role._title) + "-" + UserTrackerIdRow.get(0).get(Access_User._name) + " " + UserTrackerIdRow.get(0).get(Access_User._family) + "</td>");
                } else {
                    html3.append("<td class='r'><div></div></td>");
                }
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(approvedRow.get(j).get(Approved._startDate)) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(approvedRow.get(j).get(Approved._endDate)) + "</td>");
                html3.append("<td class='r'>" + approvedRow.get(j).get(Approved._status) + "</td>");
                html3.append("<td class='r'><i class='icon ion-gear-a' style='color:#a02311'></i></td>");
                html3.append("</tr>");
            }

            html3.append("</tbody></table>");

            //////////////////////نمایش جدول مصوبات در جلسات قبلی
            List<Map<String, Object>> sessionsRow = jjDatabase.separateRow(db.otherSelect("SELECT id,sessions_commettesId FROM hmis_sessions WHERE sessions_commettesId=" + commetteId + " AND id!=" + id + " "));//نمایش جلساتی که این کمیته تشکیل داده به غیر جلسه ای که داخلش هستیم
            html1.append("        <div class=\"table-wrapper\">\n");
            html1.append("<table id='refreshApprovedPreviousInSession' class='table display responsive' class='tahoma10' style='direction: rtl;'><thead>");
            html1.append("<th width='5%'>کد</th>");
            html1.append("<th width='10%'>عنوان مصوبه</th>");
            html1.append("<th width='15%'>مسئول اجرا</th>");
            html1.append("<th width='20%'>مسئول پیگیری</th>");
            html1.append("<th width='15%'>تاریخ شروع </th>");
            html1.append("<th width='15%'>تاریخ پایان </th>");
            html1.append("<th width='15%'>وضعیت</th>");
            html1.append("<th width='40%'>ویرایش</th>");
            html1.append("</thead><tbody>");
            for (int j = 0; j < sessionsRow.size(); j++) {
                List<Map<String, Object>> ApprovedPrevoiusRow = jjDatabase.separateRow(db.otherSelect("SELECT * FROM hmis_approved WHERE hmis_approved.approved_sessionsid=" + sessionsRow.get(j).get(_id) + " AND " + Approved._status + "!='" + Approved.status_reject + "' AND " + Approved._sessionsId + "=" + sessionsRow.get(j).get(_id) + " AND " + Approved._status + "!='" + Approved.status_offer + "' "));//نمایش جلساتی که این کمیته تشکیل داده به غیر جلسه ای که داخلش هستیم
                for (int i = 0; i < ApprovedPrevoiusRow.size(); i++) {
                    html1.append("<tr onclick='hmisApproved.selectApprovedPrevious(" + ApprovedPrevoiusRow.get(i).get(Approved._id) + ")' class='mousePointer " + getClassCssForVaziat(ApprovedPrevoiusRow.get(i).get(Approved._status).toString()) + "'>");
                    List<Map<String, Object>> RolesTrackerIdRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + ApprovedPrevoiusRow.get(i).get(Approved._trackerId)));
                    List<Map<String, Object>> UserTrackerIdRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + RolesTrackerIdRow.get(0).get(Role._user_id)));
                    html1.append("<td class='c'>" + ApprovedPrevoiusRow.get(i).get(Approved._id) + "</td>");
                    html1.append("<td class='r'>" + ApprovedPrevoiusRow.get(i).get(Approved._title) + "</td>");
                    html1.append("<td class='r'>" + ApprovedPrevoiusRow.get(i).get(Approved._executorRoleId) + " " + ApprovedPrevoiusRow.get(i).get(Approved._executorUserId) + "</td>");
                    html1.append("<td class='r'>" + RolesTrackerIdRow.get(0).get(Role._title) + "-" + UserTrackerIdRow.get(0).get(Access_User._name) + " " + UserTrackerIdRow.get(0).get(Access_User._family) + "</td>");
                    html1.append("<td class='r'>" + jjCalendar_IR.getViewFormat(ApprovedPrevoiusRow.get(i).get(Approved._startDate)) + "</td>");
                    html1.append("<td class='r'>" + jjCalendar_IR.getViewFormat(ApprovedPrevoiusRow.get(i).get(Approved._endDate)) + "</td>");
                    html1.append("<td class='r'>" + ApprovedPrevoiusRow.get(i).get(Approved._status) + "</td>");
                    html1.append("<td class='r'><i class='icon ion-gear-a' style='color:#a02311'></i></td>");
                    html1.append("</tr>");
                }
            }
            html1.append("</tbody></table>");

            //////////////////////////////////////////////////////////////
            script += Js.setHtml("#approvedPreviousTbl", html1);//جدول مصوبات قبلی
            script += Js.setHtml("#Sessions_button", html2);
            script += Js.table("#refreshApprovedInSession", "300", 0, "", "جلسات");
            script += Js.setHtml("#approvedTbl", html3);//جدول مصوبه ها
            script += Js.setHtml("#audience", html4);//مدعوین
            script += html.toString();
            script += Js.setHtml("#filesDownloadDiv", html8);//فایل های بارگذاری شده
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * creator shohre shiran 13971211
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            System.out.println("proposedSulotion=" + jjTools.getParameter(request, _ProposedSolution));
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            List<Map<String, Object>> Row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            String script = "";
            Map<String, Object> map = new HashMap<String, Object>();
            if (jjTools.getParameter(request, _communicatorRoleId).equals("null")) {
                Server.outPrinter(request, response, Js.modal("لطفا ابلاغ کننده را انتخاب نمایید", "پیام سامانه"));
                return "";
            } else {

                map.put(_checkingAgenda, jjTools.getParameter(request, _checkingAgenda));
                map.put(_titleIssue, jjTools.getParameter(request, _titleIssue));
                map.put(_nextDate, jjTools.getParameter(request, _nextDate).replaceAll("/", ""));
                map.put(_sessionDescription, jjTools.getParameter(request, _sessionDescription));
                map.put(_weakPoint, jjTools.getParameter(request, _weakPoint));
                map.put(_strengths, jjTools.getParameter(request, _strengths));
                map.put(_communicatorRoleId, jjTools.getParameter(request, _communicatorRoleId));
                map.put(_ProposedSolution, jjTools.getParameter(request, _ProposedSolution));
                map.put(_audienceInSide, jjTools.getParameter(request, _audienceInSide).replaceAll("#A#", "%23A%23"));
                map.put(_audience, jjTools.getParameter(request, _audience).replaceAll("#A#", "%23A%23"));
                map.put(_audienceOutSide, jjTools.getParameter(request, _audienceOutSide).replaceAll("#A#", "%23A%23"));
                map.put(_file, jjTools.getParameter(request, _file).replaceAll("#A#", "%23A%23"));

                if (!db.update(tableName, map, _id + "=" + id)) {
                    String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                    return "";
                } else {
                    script += Js.jjSessions.refresh();
                    script += Js.jjSessions.select(id);
                    script += Js.modal("تغییرات انجام شد", "پیام سامانه");
                }
                Server.outPrinter(request, response, script);
                return "";
            }
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     *
     * تایید نهایی و ارسال به مسئولین اجرا ارسال ایمیل به مهمانان خارج از سازمان
     * توسط دبیر کمیته
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String confirmationFinalSessions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//ای دی جلسات
            String script = "";
//            System.out.println("proposedSulotion=" + jjTools.getParameter(request, _ProposedSolution));
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            List<Map<String, Object>> Row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put(_checkingAgenda, jjTools.getParameter(request, _checkingAgenda));
            map.put(_titleIssue, jjTools.getParameter(request, _titleIssue));
            map.put(_communicatorRoleId, jjTools.getParameter(request, _communicatorRoleId));
            map.put(_nextDate, jjTools.getParameter(request, _nextDate).replaceAll("/", ""));
            map.put(_sessionDescription, jjTools.getParameter(request, _sessionDescription));
            map.put(_weakPoint, jjTools.getParameter(request, _weakPoint));
            map.put(_strengths, jjTools.getParameter(request, _strengths));
            map.put(_ProposedSolution, jjTools.getParameter(request, _ProposedSolution));
            map.put(_audience, jjTools.getParameter(request, _audience).replaceAll("#A#", "%23A%23"));
            map.put(_audienceInSide, jjTools.getParameter(request, _audienceInSide).replaceAll("#A#", "%23A%23"));
            map.put(_audienceOutSide, jjTools.getParameter(request, _audienceOutSide).replaceAll("#A#", "%23A%23"));
            String audienceOutSides = jjTools.getParameter(request, _audienceOutSide).toString();
            String[] audienceOutSide = (audienceOutSides.replaceAll("#A#", "%23A%23")).split("%23A%23");//ایمیل افراد خارج از سازمان
            for (int i = 0; i < audienceOutSide.length; i++) {
                System.out.println("@To Do send Email");//ارسال ایمیل به ایمیل های موجوددر دیتا بیس
            }
            if (!jjTools.getParameter(request, _audience).equals("")) {

                if (!db.update(tableName, map, _id + "=" + id)) {
                    String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");
                }
                String result = changeStatus(db, id, status_confirmationFinal);
                if (result.isEmpty()) {
                    script += Js.modal("ابلاغ انجام شد", "پیام سامانه");
                    script += Js.jjSessions.select(id);
                    script += Js.jjSessions.refresh();

                } else {
                    script += Js.modal(".ابلاغ انجام نشد", "پیام سامانه");
                }

            } else {//در این خط کد اگر حضار را انتخاب نکرده باشد نمیتوان تایید نهایی انجام شود
//                String errorMessage = "حضار در جلسه انتخاب نمایید.";
//                script += Js.modal(errorMessage, "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ارسال پیام برای مدعوین انتخاب شده13971212 درج اطلاعات
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String requestSendComment(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String script = "";
            String commettesId = jjTools.getParameter(request, "commettesId");//شماره های مدعوین برای ارسال پیام
            List<Map<String, Object>> ComemttesRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + commettesId));

            String text = jjTools.getParameter(request, _contextInvitation);
            String inviteesId = jjTools.getParameter(request, _Invitees).replaceAll("#A#", "%23A%23");//ای دی مدعوین برای ارسال پیام
            String inviteesOutSideId = jjTools.getParameter(request, _InviteesOutSide).replaceAll("#A#", "%23A%23");//شماره های مدعوین خارج از سازمان برای ارسال پیام
            String inviteesInSideId = jjTools.getParameter(request, _InviteesInSide).replaceAll("#A#", "%23A%23");//شماره های مدعوین داخل سازمان برای ارسال پیام
            Map<String, Object> map = new HashMap<>();
            map.put(_creatorId, jjTools.getSeassionUserId(request));//ایدی مدعوین
            map.put(_Invitees, inviteesId);//ایدی مدعوین
            map.put(_InviteesFile, jjTools.getParameter(request, _InviteesFile).replaceAll("#A#", "%23A%23"));//ای دی های مدعوین
            map.put(_InviteesOutSide, inviteesOutSideId);//ای دی های مدعوین
            map.put(_InviteesInSide, inviteesInSideId);// داخل سازمان ای دی های مدعوین
            map.put(_title, jjTools.getParameter(request, _title));//عنوان جلسه
            map.put(_date, jjTools.getParameter(request, _date).replaceAll("/", ""));//تاریخ جلسه
            map.put(_time, jjTools.getParameter(request, _time));//ساعت جلسه
            map.put(_contextInvitation, jjTools.getParameter(request, _contextInvitation));//متن دعوتنامه
            map.put(_agenda, jjTools.getParameter(request, _agenda));//دستور جلسه
            map.put(_dateReminder, jjTools.getParameter(request, _dateReminder));//تاریخ یاد آوری
            map.put(_timeReminder, jjTools.getParameter(request, _timeReminder));//ساعت یاد اوری
            map.put(_invitationDate, jjCalendar_IR.getDatabaseFormat_8length("", true));//تاریخ ارسال دعوتنامه
            map.put(_commetteId, commettesId);//ای دی کمیته
            map.put(_status, status_created);//
            map.put(_statusLog,
                    status_created
                    + "-"
                    + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                    + " "
                    + new jjCalendar_IR().getTimeFormat_8length()
                    + "%23A%23"
            );

            if (ComemttesRow.get(0).get(Commettes._isActive).equals("1")) {//وضعیت کمیته چک می شود

                DefaultTableModel dtm = db.insert(tableName, map);
                if (dtm.getRowCount() == 0) {
                    String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");
                }
                System.out.println("@To Do send Comment");
                script += Js.modal("پیام ارسال شد", "پیام سامانه");
                script += "hmisSessions.m_refresh();";
//                script += "hmisCommettes.sendComment('" + text + "','" + inviteesId + "','" + inviteesOutSideId + "','" + inviteesInSideId + "');";

            } else if (ComemttesRow.get(0).get(Commettes._isActive).equals("0")) {
                String errorMessage = "کمیته مورد نظر فعال نمی باشد .";
                script += Js.modal(errorMessage, "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String changeStatus(jjDatabaseWeb db, String id, String newSatus) {
        try {
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                return Js.dialog(errorMessageId);
            }
            String oldStatus = jjDatabaseWeb.separateRow(db.Select(tableName, _status, _id + "=" + id)).get(0).get(_status).toString();

            if (!oldStatus.equals(newSatus)) {
                db.otherStatement("UPDATE " + tableName + " SET " + _statusLog
                        + "=concat(ifnull(" + _statusLog + ",''),'"
                        + newSatus
                        + "-"
                        + jjCalendar_IR.getViewFormat(new jjCalendar_IR().getDBFormat_8length())
                        + " "
                        + new jjCalendar_IR().getTimeFormat_8length()
                        + "%23A%23"
                        + "') ,"
                        + _status + "='" + newSatus + "'  WHERE id=" + id + ";");
            }
            return "";
        } catch (Exception ex) {
            Server.ErrorHandler(ex);
            return "عملیات تغییر وضعیت بدرستی صورت نگرفت. Err166";
        }
    }

    /**
     * جدول جلسات من در این جدول جلساتی که برگزار شده است برای امضا وتایید سمت
     * حضار می اید وحضار آن را تایید می کنند ویژگی تابع این است که برای دعوت
     * شدگان نمایش داده می شود
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String refreshMySessions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();
            int sessionUserId = jjTools.getSeassionUserId(request);// ای دی فرد وارد شونده
            html.append("        <div class=\"card-header bg-primary tx-white\"> لیست جلسات من</div>\n");
            html.append("        <div class=\"table-wrapper\">\n");
            html.append("<table id='refreshMySessions' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>عنوان جلسه</th>");
            html.append("<th width='15%'> کمیته</th>");
            html.append("<th width='20%'>دبیر کمیته</th>");
            html.append("<th width='20%'>تاریخ و ساعت شروع</th>");
            html.append("<th width='15%'>وضعیت</th>");
            html.append("<th width='40%'>انتقال به میز هوشمند</th>");
            html.append("</thead><tbody>");
            List<Map<String, Object>> sessionsRow = jjDatabase.separateRow(db.otherSelect("SELECT * FROM hmis_sessions WHERE "
                    + "sessions_audience LIKE '%" + sessionUserId + "\\%23A\\%23%' "
                    + " AND sessions_status='" + Sessions.status_confirmationFinal + "' OR sessions_creatorId=" + sessionUserId + " AND sessions_status='" + Sessions.status_communicated + "'"));
            //در جدول جلسات  در فیلد حضار داخل سازمان ای دی فردی که وارد شد شبیه یکی از این فیلد ها بود پیدا کن اگر جز ایجاد کننده ها بود  نمایش داده شود اگر وضعیت تایید نهایی هم بود نمایش داده شود
            for (int i = 0; i < sessionsRow.size(); i++) {
                List<Map<String, Object>> commettedRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + sessionsRow.get(i).get(Sessions._commetteId)));
                html.append("<tr>");
                html.append("<td class='c'>" + sessionsRow.get(i).get(Sessions._id) + "</td>");
                html.append("<td class='r'>" + sessionsRow.get(i).get(Sessions._title) + "</td>");
                html.append("<td class='r'>" + commettedRow.get(0).get(Commettes._title) + "</td>");
                List<Map<String, Object>> RoleRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + commettedRow.get(0).get(Commettes._secretary)));
                List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + RoleRow.get(0).get(Role._user_id)));
                html.append("<td class='r'>" + userRow.get(0).get(Access_User._name) + " " + userRow.get(0).get(Access_User._family) + "</td>");
                html.append("<td class='r'>" + sessionsRow.get(i).get(Sessions._date) + "-" + sessionsRow.get(i).get(Sessions._time) + "</td>");
                html.append("<td class='r'>" + sessionsRow.get(i).get(Sessions._status) + "</td>");
                html.append("<td class='r'><a href=\"Server?do=Sessions.selectMySessions&id=" + sessionsRow.get(i).get(Sessions._id) + "\" target=\"_blank\"><i class='icon ion-coffee' style='color:#a02311'></i></a></td>");
                html.append("</tr>");

            }

            html.append("</tbody></table>");
            html.append("</div>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swMySessionsTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshMySessions", "300", 0, "", "جلسات");

            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));

            return "";
        }
    }

    /**
     * جلسات ابلاغ شده جلساتی که وضعیت آنها تایید نهایی هسند برای ابلاغ مصوبات
     * توسط ابلاغ کننده در این جدول می آیند
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String refreshCommunicatedSessions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            int sessionUserId = jjTools.getSeassionUserId(request);// ای دی فرد وارد شونده
            html.append("<div class=\"card-header bg-primary tx-white\"> لیست جلسات من</div>\n");
            html.append("<div class=\"table-wrapper\">\n");
            html.append("<table id='refreshCommunicatedSessions' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>عنوان جلسه</th>");
            html.append("<th width='15%'> کمیته</th>");
            html.append("<th width='20%'>دبیر کمیته</th>");
            html.append("<th width='20%'>تاریخ و ساعت شروع</th>");
            html.append("<th width='15%'>وضعیت</th>");
            html.append("<th width='40%'>انتقال به میز هوشمند</th>");
            html.append("</thead><tbody>");
            List<Map<String, Object>> row = jjDatabase.separateRow(db.otherSelect("SELECT"
                    + " S.id,S.sessions_title "
                    + ",C.commettes_title,A.user_name,A.user_family"
                    + ",S.sessions_date,S.sessions_time"
                    + ",S.sessions_status"
                    + " FROM hmis_sessions S"
                    + " LEFT JOIN  hmis_commettes C      ON   S.sessions_commettesId=C.id"
                    + " LEFT JOIN  hmis_role      R      ON   C.commettes_secretary=R.id"
                    + " LEFT JOIN  access_user    A      ON   R.role_user_id=A.id"
                    + " WHERE  S.sessions_status!='" + status_created + "'"
            //                    + " WHERE S.sessions_communicatorRoleId LIKE '%" + jjTools.getSessionAttribute(request, "#ROLE_ID") +"%'"
            //                    + "  AND "
            //                    + " S.sessions_status='" + status_confirmationFinal + "'"
            //                    + " OR"
            //                    + " S.sessions_communicatorRoleId LIKE '%" + jjTools.getSessionAttribute(request, "#ROLE_ID") +"%'"
            //                    + " AND S.sessions_status='" + status_communicated + "'"
            ));
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr>");
                html.append("<td class='c'>" + row.get(i).get(Sessions._id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Sessions._title) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Commettes._title) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Access_User._name) + " " + row.get(i).get(Access_User._family) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Sessions._date) + "-" + row.get(i).get(Sessions._time) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Sessions._status) + "</td>");
                html.append("<td class='r' onclick='hmisCommunicatedSessions.m_select(" + row.get(i).get(Sessions._id) + ")'>"
                        + "<i class='icon ion-coffee' style='color:#a02311'></i>"
                        + "</td>");
                html.append("</tr>");

            }
//            List<Map<String, Object>> RolesRow = jjDatabase.separateRow(db.Select(Role.tableName));
//            html1.append("<option>انتخاب کنید</option>");
//            for (int i = 0; i < RolesRow.size(); i++) {
//                html1.append("<option id='" + RolesRow.get(i).get(Role._user_id) + "' value='" + RolesRow.get(i).get(Role._id) + "'>" + RolesRow.get(i).get(Role._title) + "</option>");
//            }
            html.append("</tbody></table>");
            html.append("</div>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swCommunicatedSessionsTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshCommunicatedSessions", "300", 0, "", "جلسات");
//            html2 += Js.setHtml("#communicatedSessions_communicatorId", html1);

            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));

            return "";
        }
    }

    /**
     * نمایش صورت جلسه وپرینت
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String downloadSessions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, Sessions._id);// ای دی جلسه

            request.setAttribute("db", db);
            request.getRequestDispatcher("feiz/sessionPrint.jsp").forward(request, response);

            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String selectMySessions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, Sessions._id);// ای دی جلسه

            request.setAttribute("db", db);
            request.getRequestDispatcher("feiz/showSessions.jsp").forward(request, response);

            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * صورت جلسات ابلاغ شده
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String selectCommunicatedSessions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);// ای دی جلسه

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + row.get(0).get(_commetteId)));
            String commetteId = row.get(0).get(_commetteId).toString();// ای دی کمیته
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder html5 = new StringBuilder();
            StringBuilder html6 = new StringBuilder();
            StringBuilder html8 = new StringBuilder();
            String script = "";
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setHtml("#commettesTitleCommunicatedSessions", commettesRow.get(0).get(Commettes._title) + "-جلسه" + row.get(0).get(_date)));
            html.append(Js.setHtml("#communicatedSessions_sessionsDate", jjCalendar_IR.getViewFormat(row.get(0).get(_date))));
            html.append(Js.setVal("#communicatedSessions_agendaSessions", row.get(0).get(_agenda)));
            html.append(Js.setVal("#communicatedSessions_titleSessions", row.get(0).get(_title)));
            html.append(Js.setVal("#communicatedSessions_checkingAgenda", row.get(0).get(_checkingAgenda)));
            html.append(Js.setVal("#communicatedSessions_communicatorId", row.get(0).get(_communicatorRoleId)));
            html.append(Js.setVal("#communicatedSessions_titleIssue", row.get(0).get(_titleIssue)));
            html.append(Js.setVal("#communicatedSessions_ProposedSolution", row.get(0).get(_ProposedSolution)));
            html.append(Js.setVal("#communicatedSessions_weakPoint", row.get(0).get(_weakPoint)));
            html.append(Js.setVal("#communicatedSessions_strengths", row.get(0).get(_strengths)));
            html.append(Js.setVal("#communicatedSessions_sessionDescription", row.get(0).get(_sessionDescription)));
            html.append(Js.setVal("#communicatedSessions_invitationDate", jjCalendar_IR.getViewFormat(row.get(0).get(_invitationDate))));
            html.append(Js.setVal("#communicatedSessions_nextDate", jjCalendar_IR.getViewFormat(row.get(0).get(_nextDate))));
            html.append(Js.setVal("#" + _file, row.get(0).get(_file)));
            if (!row.get(0).get(_file).toString().equals("")) {
                String[] File = (row.get(0).get(_file).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html8.append("<div class='col-lg-12'> "
                        + "فایل های دبیر کمیته"
                        + "</div>"
                        + "");
                for (int i = 0; i < File.length; i++) {
                    html8.append(" <div class='col-lg-3'><a id='downloadFile_communicatedSessions' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a><span  class='col-xs-1' onclick='hmisSessions.m_remove(" + File[i] + "," + id + ")'>" + "<img  src='imgfeyz/delet.png' style='width:56%' /></span></div>");
                }
            }
            //دکمه ابلاغ برای مسئول ابلاغ
            if (row.get(0).get(_status).equals(status_confirmationFinal) //                    && Integer.valueOf(jjTools.getSessionAttribute(request, "#ROLE_ID")) == Integer.valueOf(row.get(0).get(_communicatorId).toString())
                    ) {

                System.out.println("jjTools.getSeassionUserId(request)=" + jjTools.getSeassionUserId(request) + "row.get(0).get(_communicatorId)" + row.get(0).get(_communicatorRoleId));
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button  id='sendToCommunicator_communicatedSessions' class='btn btn-outline-success  btn-block mg-b-10'  onclick='hmisCommunicatedSessions.sendToCommunicator(" + id + ");' >ابلاغ صورتجلسه</button>");
                html2.append("</div>");

                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button id='ignore_communicatedSessions' class='btn btn-outline-warning btn-block mg-b-10'  onclick='\"hmisCommunicatedSessions.ignore(" + id + ");' >رد صورتجلسه</button>");
                html2.append("</div>");
            }

//          دکمه ارسال جهت امضا
//            html2.append("<div class=\"col-lg-6\">");
//            html2.append("<input type='button' id='Confirmation_Sessions' value='تایید نهایی و ارسال جهت امضا' class='btn btn-outline-success active btn-block mg-b-10'>");
//            html.append(Js.buttonMouseClick("#Confirmation_Sessions", "hmisSessions.confirmationFinalSessions(" + id + ");"));
//            html2.append("</div>");
//            if (accDel) {
//                html2.append("<div class=\"col-lg-6\">");
//                html2.append("<input type='button' id='delete_Sessions' value='" + lbl_delete + "' class='btn btn-success btn-block mg-b-10 tahoma10'  />");
//                html.append(Js.buttonMouseClick("#delete_Sessions", Js.jjSessions.delete(id)));
//                html2.append("</div>");
//            }
//            html2.append("</div>");
//دراین سلکت گفته شده که دو وضعیت ردپیشنهااد و پیشنهاد نمایش داده نشود
            DefaultTableModel dtm = db.otherSelect("SELECT * FROM hmis_approved WHERE " + Approved._sessionsId + "=" + id + " AND " + Approved._status + "!='" + Approved.status_reject + "'  AND " + Approved._status + "!='" + Approved.status_offer + "'");

            List<Map<String, Object>> approvedRow = jjDatabase.separateRow(dtm);

            html3.append("<div class=\"table-wrapper\">\n");
            html3.append("<table id='refreshApprovedIncommunicatedSessions' class='table display responsive' class='tahoma10' style='direction: rtl;'><thead>");
            html3.append("<th width='5%'>کد</th>");
            html3.append("<th width='10%'>عنوان مصوبه</th>");
            html3.append("<th width='15%'>مسئول اجرا</th>");
            html3.append("<th width='15%'>مسئولین اجرا</th>");
            html3.append("<th width='20%'>مسئول پیگیری</th>");
            html3.append("<th width='15%'>تاریخ شروع </th>");
            html3.append("<th width='15%'>تاریخ پایان </th>");
            html3.append("<th width='15%'>وضعیت</th>");
            html3.append("<th width='15%'>عملیات</th>");
            html3.append("<th width='40%'>ویرایش</th>");
            html3.append("</thead><tbody>");

            for (int i = 0; i < approvedRow.size(); i++) {
                html3.append("<tr class='mousePointer'>");
                List<Map<String, Object>> RolesTrackerIdRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + approvedRow.get(i).get(Approved._trackerId)));
                List<Map<String, Object>> UserTrackerIdRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + RolesTrackerIdRow.get(0).get(Role._user_id)));
                html3.append("<td class='c'>" + approvedRow.get(i).get(Approved._id) + "</td>");
                html3.append("<td class='r'>" + approvedRow.get(i).get(Approved._title) + "</td>");
                html3.append("<td class='r'>" + (approvedRow.get(i).get(Approved._executorRoleId).toString()) + "</td>");
                html3.append("<td class='r'>" + (approvedRow.get(i).get(Approved._executorUserId).toString()) + "</td>");
                html3.append("<td class='r'>" + RolesTrackerIdRow.get(0).get(Role._title) + "-" + UserTrackerIdRow.get(0).get(Access_User._name) + " " + UserTrackerIdRow.get(0).get(Access_User._family) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(approvedRow.get(i).get(Approved._startDate)) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(approvedRow.get(i).get(Approved._endDate)) + "</td>");
                html3.append("<td class='r'>" + approvedRow.get(i).get(Approved._status) + "</td>");
                if (row.get(0).get(_status).equals(status_communicated) && approvedRow.get(i).get(Approved._status).equals(Approved.status_initialRegistration)) {//دکمه ابلغ مصوبه زمانی فعال می شود که خود صورت جلسه ابلاغ شده باشد
                    html3.append("<td class='r'><button class='btn btn-outline-success  btn-block mg-b-10' onclick='hmisApproved.communicatedApproved(" + approvedRow.get(i).get(Approved._id) + ");'> ابلاغ مصوبه</button></td>");
                } else {
                    html3.append("<td class='r'><div></div></td>");
                }
                html3.append("<td class='r' onclick='hmisApproved.selectInCommunicatedSessions(" + approvedRow.get(i).get(Approved._id) + ");' ><i class='icon ion-gear-a' style='color:#a02311'></i></td>");
                html3.append("</tr>");
            }
            html3.append("</tbody></table>");
//            html5.append("<option>انتخاب کنید</option>");
//            List<Map<String, Object>> RolesRow = jjDatabase.separateRow(db.Select(Role.tableName));
//            for (int i = 0; i < RolesRow.size(); i++) {
//                html5.append("<option id='" + RolesRow.get(i).get(Role._user_id) + "' value='" + RolesRow.get(i).get(Role._id) + "'>" + RolesRow.get(i).get(Role._title) + "</option>");
//            }
//            html6.append("<option>انتخاب کنید</option>");
//            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));
//            for (int i = 0; i < UserRow.size(); i++) {
//                html6.append("<option id='" + UserRow.get(i).get(Access_User._id) + "' value='" + UserRow.get(i).get(Access_User._id) + "'>" + UserRow.get(i).get(Access_User._name) + "-" + UserRow.get(i).get(Access_User._family) + "</option>");
//            }
            //////////////////////////////////////////////////////////////
            script += Js.setHtml("#communicatedSessions_button", html2);
            script += Js.table("#refreshApprovedIncommunicatedSessions", "300", 0, "", "مصوبات");
            script += Js.setHtml("#communicatedApprovedTbl", html3);
            script += html.toString();
            script += Js.setHtml("#communicatedApproved_executorRoleId", html5);
//            script += Js.setHtml("#communicatedApproved_executorUserId", html6);
//            script += Js.setHtml("#communicatedApproved_trackerId", html5);
            script += Js.setHtml("#filesDownloadDivCommunicated", html8);
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }

    }

    /**
     * عملیات امضای فرد برای صورتجلسه مربوطه
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String actionSigners(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, Sessions._id);// ای دی جلسه
            String SignerId = jjTools.getParameter(request, "userId");// ایدی یوزر

            List<Map<String, Object>> sessionsRow = jjDatabaseWeb.separateRow(db.otherSelect("SELECT  *  FROM hmis_sessions WHERE sessions_signers  Like '%" + SignerId + "\\%23A\\%23%' AND id=" + id + ""));
            String script = "";
            if (sessionsRow.isEmpty()) {
                db.otherStatement("UPDATE " + tableName + " SET " + _signers
                        + "=concat(ifnull(" + _signers + ",''),'"
                        + SignerId
                        + "%23A%23"
                        + "')"
                        + " WHERE id=" + id + ";");
                script += "confirm('کاربر گرامی امضای شما ثبت گردید');";
            } else {
                script += "confirm('امضای شما قبلا ثبت شده است');";

            }

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * تغییر وضعیت جلسات به ابلاغ شده ونمایش اطلاعات مصوبه در جدول مصوبات به
     * مسئولین اجرا و پیگیری
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String sendToTrackerAndExecutor(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//  ای دی جلسات
            String script = "";
            String result = changeStatus(db, id, status_communicated);
            if (result.isEmpty()) {//اگر خطایی نبود
                String errorMessageing = "ابلاغ انجام شد";
                script += Js.modal(errorMessageing, "پیام سامانه");
                script += Js.jjSessions.select(id);
            } else {
                String errorMessageing = "ابلاغ انجام نشد";
                script += Js.modal(errorMessageing, "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ابلاغ صورتجلسه توسط ابلاغ کننده یا مدیر
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String sendToCommunicator(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//  ای دی جلسات
            String script = "";
            String result = changeStatus(db, id, status_communicated);//ابلاغ
            if (result.isEmpty()) {//اگر خطایی نبود
                String errorMessageing = "ابلاغ انجام شد";
                script += Js.modal(errorMessageing, "پیام سامانه");
                script += "hmisCommunicatedSessions.m_select(" + id + ");";
            } else {
                String errorMessageing = "ابلاغ انجام نشد";
                script += Js.modal(errorMessageing, "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * رد کردن صورتجلسه
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String ignore(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//  ای دی جلسات
            String script = "";
            String result = changeStatus(db, id, status_ignore);//رد
            if (result.isEmpty()) {//اگر خطایی نبود
                String errorMessageing = "صورتجلسه رد شد";
                script += Js.modal(errorMessageing, "پیام سامانه");
                script += "hmisCommunicatedSessions.m_select(" + id + ")";
            } else {
                String errorMessageing = "رد نشد";
                script += Js.modal(errorMessageing, "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * حذف نام فایل وای دی فایل از اپلود سرولت و از فایل موجود
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String removeFile(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {

            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            String idUpload = jjTools.getParameter(request, "upload_id");///
            String id = jjTools.getParameter(request, "hmis_sessions_id");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            List<Map<String, Object>> rowupload = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._id + "=" + idUpload));////برای دراوردن اسم فایل
            String filename = rowupload.get(0).get(UploadServlet._file_name).toString() + "%23A%23";
            String attacheFiles = row.get(0).get(_file).toString();
            System.out.println(filename);
            System.out.println("____________________________________");
            System.out.println(attacheFiles);
            attacheFiles = attacheFiles.replace(filename, "");
            System.out.println(attacheFiles);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_file, attacheFiles);
            System.out.println("____________________________________");

            db.update(tableName, map, _id + "=" + id);
            Access_User.changeStatus(request, response, db, idUpload, UploadServlet.status_deleted + " " + jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY"));

            Server.outPrinter(request, response, Js.jjSessions.select(id));
            return "";
//

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }

    public static String getClassCssForVaziat(String status) {
        if (status.equals(status_communicated)) {
            return "status_communicated";
        } else if (status.equals(status_confirmationFinal)) {
            return "status_confirmationFinal";
        } else if (status.equals(status_created)) {
            return "status_created";// این کلاس در فایل های سی اس اس تعریف میشود و در قسمت های مختلف جدول نشان داده می شود
        } else if (status.equals(status_ignore)) {
            return "status_ignore";// این کلاس در فایل های سی اس اس تعریف میشود و در قسمت های مختلف جدول نشان داده می شود
        } else if (status.equals(Approved.status_done)) {
            return "status_done";// این کلاس در فایل های سی اس اس تعریف میشود و در قسمت های مختلف جدول نشان داده می شود
        } else if (status.equals(Approved.status_inDoing)) {
            return "status_inDoing";
        } else if (status.equals(Approved.status_initialRegistration)) {
            return "status_initialRegistration";
        } else if (status.equals(Approved.status_unDone)) {
            return "status_unDone";
        } else if (status.equals(Approved.status_reject)) {
            return "status_reject";
        } else if (status.equals(Approved.status_offer)) {
            return "status_offer";

        } else if (status.equals(Steps.status_done)) {
            return "status_done";
        } else if (status.equals(Steps.status_inDoing)) {
            return "status_inDoing";
        } else if (status.equals(Steps.status_initialRegistration)) {
            return "status_initialRegistration";
        } else if (status.equals(Steps.status_unDone)) {
            return "status_unDone";
        }
        return "";
    }
}
