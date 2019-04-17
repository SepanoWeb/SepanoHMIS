/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import cms.access.Access_User;
import cms.tools.Js;
import cms.tools.Server;
import cms.tools.jjTools;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public static String _creatorId = "sessions_craetorId";//ای دی ایجاد کننده
    public static String _title = "sessions_title";//عنوان جلسه
    public static String _commetteId = "sessions_commettesId";//ایدی کمیته
    public static String _contextInvitation = "sessions_contextInvitation";//متن دعوتنامه  
    public static String _invitationDate = "sessions_invitationDate";//تاریخ ارسال دعوتنامه  
    public static String _agenda = "sessions_agenda";//دستور جلسه
    public static String _date = "sessions_date";//تاریخ جلسه
    public static String _time = "sessions_time";//تایم جلسه
    public static String _dateReminder = "sessions_dateReminder";//تاریخ یادآوری
    public static String _timeReminder = "sessions_timeReminder";//ساعت یادآوری 
    public static String _Invitees = "sessions_Invitees";//مدعوین داخل سازمان
    public static String _InviteesInSide = "sessions_InviteesInSide";//مهمانان داخل سازمان
    public static String _InviteesOutSide = "sessions_InviteesOutSide";//مدعوین خارج از سازمان
    public static String _vaziat = "sessions_vaziat";//وضعیت
    public static String _ravandeVaziat = "sessions_ravandeVaziat";//روند وضعیت
    public static String _nextDate = "sessions_nextSessionDate";//تاریخ جلسه بعد
    public static String _strengths = "sessions_strengths";//نقاط قوت 
    public static String _weakPoint = "sessions_weakPoint";//نقاط ضعف 
    public static String _titleIssue = "sessions_titleIssue";//عنوان مسئله
    public static String _ProposedSolution = "sessions_proposedSolution";//راهکار پیشنهادی   
    public static String _checkingAgenda = "sessions_checkingAgenda";//بررسی دستور جلسه 
    public static String _titleFile = "sessions_titleFile";//عنوان فایل برای بررسی
    public static String _sessionDescription = "sessions_sessionDescription";//شرح جلسه
    public static String _file = "sessions_file";// فایل های بارگذاری شده
    public static String _audience = "sessions_audience";// حضار در جلسه

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
    public static String lbl_edit = "ویرایش";

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();
            DefaultTableModel dtm = db.Select(tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

            html.append("        <div class=\"card-header bg-primary tx-white\">لیست جلسات</div>\n");
//            html.append(" <div class=\"card-body pd-sm-30\">\n"
//                    + "                                        <p class=\"mg-b-20 mg-sm-b-30\">\n"
//                    + "                                            <a style='color:#fff' class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" onclick=\"hmisCommettes.m_add_new();\" >کمیته جدید</a>\n"
//                    + "                                        </p>\n"
//                    + "                                    </div>");
            html.append("        <div class=\"table-wrapper\">\n");
            html.append("<table id='refreshSessions' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>عنوان جلسه</th>");
            html.append("<th width='15%'> کمیته</th>");
            html.append("<th width='20%'>دبیر کمیته</th>");
            html.append("<th width='20%'>تاریخ و ساعت شروع</th>");
            html.append("<th width='15%'>وضعیت</th>");
            html.append("<th width='40%'>انتقال به میز هوشمند</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                List<Map<String, Object>> commettedRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + row.get(i).get(_commetteId)));
                html.append("<tr onclick='hmisSessions.m_select(" + row.get(i).get(_id) + ")' class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_title) + "</td>");
                html.append("<td class='r'>" + commettedRow.get(0).get(Commettes._title) + "</td>");
                html.append("<td class='r'>" + commettedRow.get(0).get(Commettes._secretary) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_date) + "-" + row.get(i).get(_time) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_vaziat) + "</td>");
                html.append("<td class='r'><i class='icon ion-coffee' style='color:#a02311'></i></td>");
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
                panel = "swSessionsTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshSessions", "300", 0, "", "جلسات");

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
//    public static String insert(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
//        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
//            StringBuilder html = new StringBuilder();
//            jjCalendar_IR ir = new jjCalendar_IR();
//            Map<String, Object> map = new HashMap<String, Object>();
////            map.put(_creatorId, jjTools.getSessionAttribute(request, "#ID"));
////            map.put(_dateOfHoldingMeeting, jjTools.getParameter(request, _dateOfHoldingMeeting));
////            map.put(_description, jjTools.getParameter(request, _description));
////            map.put(_members, jjTools.getParameter(request, _members));
////            map.put(_secretary, jjTools.getParameter(request, _secretary));
////            map.put(_superwizar, jjTools.getParameter(request, _superwizar));
//////            map.put(_title, jjTools.getParameter(request, _title));
////            map.put(_regulationFile1, jjTools.getParameter(request, _regulationFile1));
////            map.put(_regulationFile2, jjTools.getParameter(request, _regulationFile2));
////            map.put(_regulationFile3, jjTools.getParameter(request, _regulationFile3));
//
//            DefaultTableModel dtm = db.insert(tableName, map);
//            if (dtm.getRowCount() == 0) {
//                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
//                if (jjTools.isLangEn(request)) {
//                    errorMessage = "Edit Fail;";
//                }
//                return Js.dialog(errorMessage);
//            }
//
//            return Js.jjSessions.refresh();
//        } catch (Exception ex) {
//            return Server.ErrorHandler(ex);
//        }
//    }
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
            String id = jjTools.getParameter(request, _id);

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + row.get(0).get(_commetteId)));

            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder html5 = new StringBuilder();
            String script = "";
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setHtml("#commettesTitle", commettesRow.get(0).get(Commettes._title) + "-جلسه" + row.get(0).get(_date)));
            html.append(Js.setHtml("#sessions_sessionsDate", row.get(0).get(_date)));
            html.append(Js.setVal("#sessions_agendaSessions", row.get(0).get(_agenda)));
            html.append(Js.setVal("#sessions_titleSessions", row.get(0).get(_title)));
            html.append(Js.setVal("#" + _checkingAgenda, row.get(0).get(_checkingAgenda)));
            html.append(Js.setVal("#" + _titleFile, row.get(0).get(_titleFile)));
            html.append(Js.setVal("#" + _titleIssue, row.get(0).get(_titleIssue)));
            html.append(Js.setVal("#" + _ProposedSolution, row.get(0).get(_ProposedSolution)));
            html.append(Js.setVal("#" + _weakPoint, row.get(0).get(_weakPoint)));
            html.append(Js.setVal("#" + _strengths, row.get(0).get(_strengths)));
            html.append(Js.setVal("#" + _sessionDescription, row.get(0).get(_sessionDescription)));
            html.append(Js.setVal("#" + _invitationDate, jjCalendar_IR.getViewFormat(row.get(0).get(_invitationDate))));
            html.append(Js.setVal("#" + _nextDate, row.get(0).get(_nextDate)));
            String InviteesInSideId = row.get(0).get(_InviteesInSide).toString();
            String[] InviteeInSideId = InviteesInSideId.split("#A#");
            String audiencesName = row.get(0).get(_audience).toString();
            String[] audienceName = audiencesName.split("#A#");
            if (InviteeInSideId.length > 1) {//اگر  فردی وجود داشته باشد
                System.out.println("InviteeInSideId=" + InviteeInSideId.length);
                for (int i = 0; i < InviteeInSideId.length; i++) {
                    List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + InviteeInSideId[i]));
                    html4.append("<div class=\"form-group has-danger mg-b-0\">\n"
                            + "                        <label class=\"ckbox\">\n"
                            + "                            <input class='checkboxAudience' id='InviteeInSideId" + i + "' value='" + userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString() + "' type=\"checkbox\"><span>"
                            + "مهمان داخل سازمان" + "-" + userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString()
                            + ""
                    );
                    html4.append("</span>");
                    html4.append("</label>");
                    html4.append("</div>");
                    for (int j = 0; j < audienceName.length; j++) {
                        if (audienceName[j].equals(userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString())) {
                            script += Js.setAttr("#InviteeInSideId" + i + "", "checked", "checked");
                        } else {
//                            script += Js.removeAttr("#InviteeInSideId" + i + "", "checked");
                        }
                    }
                }
            }
            String InviteesOutSideId = row.get(0).get(_InviteesOutSide).toString();
            String[] InviteeOutSideId = InviteesOutSideId.split("#A#");
            if (InviteeOutSideId.length >= 1) {
                System.out.println("InviteeOutSideId=" + InviteeOutSideId.length);
                for (int i = 0; i < InviteeOutSideId.length; i++) {
                    html4.append("<div class=\"form-group has-danger mg-b-0\">\n"
                            + "<label class=\"ckbox\">\n"
                            + " <input class='checkboxAudience' id='InviteeOutSideId" + i + "' value='" + InviteeOutSideId[i] + "' type=\"checkbox\"><span>"
                            + "مهمان خارج سازمان" + "-" + InviteeOutSideId[i]
                            + "");
                    html4.append("</span>");
                    html4.append("</label>");
                    html4.append("</div>");
                    for (int j = 0; j < audienceName.length; j++) {
                        if (audienceName[j].equals(InviteeOutSideId[i])) {
                            script += Js.setAttr("#InviteeOutSideId" + i + "", "checked", "checked");
                        } else {
                        }
                    }
                }
            }
            String InvitedsId = row.get(0).get(_Invitees).toString();
            String[] invitedId = InvitedsId.split("#A#");
            if (invitedId.length >= 1) {
                System.out.println("invitedId=" + invitedId.length);
                for (int i = 0; i < invitedId.length; i++) {
                    List<Map<String, Object>> roleRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + invitedId[i]));
                    List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + roleRow.get(0).get(Role._user_id)));
                    html4.append("<div class=\"form-group has-danger mg-b-0\">\n"
                            + "                        <label class=\"ckbox\">\n"
                            + "                            <input class='checkboxAudience' id='Invitee" + i + "' type=\"checkbox\" value='" + roleRow.get(0).get(Role._title).toString() + "-" + userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString() + "'><span>"
                            + roleRow.get(0).get(Role._title).toString() + "-" + userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString()
                            + "");
                    html4.append("</span>");
                    html4.append("</label>");
                    html4.append("</div>");
                    for (int j = 0; j < audienceName.length; j++) {
                        if (audienceName[j].equals(roleRow.get(0).get(Role._title).toString() + "-" + userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString())) {
                            script += Js.setAttr("#Invitee" + i + "", "checked", "checked");
                        } else {
                        }
                    }
                }
            }

            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            if (accEdt) {
                html2.append("<div class=\"col-lg-4\">");
                html2.append("<input type='button' id='edit_Sessions' value='ثبت موقت' class='btn btn-outline-warning active btn-block mg-b-10 tahoma10'>");
                html.append(Js.buttonMouseClick("#edit_Sessions", Js.jjSessions.edit()));
                html2.append("</div>");
            }
            html2.append("<div class=\"col-lg-8\">");
            html2.append("<input type='button' id='Confirmation_Sessions' value='تایید نهایی وارسال برای مسئولین اجرا' class='btn btn-outline-success active btn-block mg-b-10'>");
            html.append(Js.buttonMouseClick("#Confirmation_Sessions", Js.jjSessions.edit()));
            html2.append("</div>");
//            if (accDel) {
//                html2.append("<div class=\"col-lg-6\">");
//                html2.append("<input type='button' id='delete_Sessions' value='" + lbl_delete + "' class='btn btn-success btn-block mg-b-10 tahoma10'  />");
//                html.append(Js.buttonMouseClick("#delete_Sessions", Js.jjSessions.delete(id)));
//                html2.append("</div>");
//            }
//            html2.append("</div>");
            DefaultTableModel dtm = db.Select(Approved.tableName);
            List<Map<String, Object>> approvedRow = jjDatabase.separateRow(dtm);

//            html.append("        <div class=\"card-header bg-primary tx-white\">لیست جلسات</div>\n");
//            html.append(" <div class=\"card-body pd-sm-30\">\n"
//                    + "                                        <p class=\"mg-b-20 mg-sm-b-30\">\n"
//                    + "                                            <a style='color:#fff' class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" onclick=\"hmisCommettes.m_add_new();\" >کمیته جدید</a>\n"
//                    + "                                        </p>\n"
//                    + "                                    </div>");
            html3.append("        <div class=\"table-wrapper\">\n");
            html3.append("<table id='refreshApproved' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html3.append("<th width='5%'>کد</th>");
            html3.append("<th width='10%'>عنوان مصوبه</th>");
            html3.append("<th width='15%'>مسئول اجرا</th>");
            html3.append("<th width='20%'>مسئول پیگیری</th>");
            html3.append("<th width='15%'>تاریخ شروع </th>");
            html3.append("<th width='15%'>تاریخ پایان </th>");
            html3.append("<th width='15%'>وضعیت</th>");
            html3.append("<th width='40%'>ویرایش</th>");
            html3.append("</thead><tbody>");
            for (int i = 0; i < approvedRow.size(); i++) {
                html3.append("<tr onclick='hmisApproved.m_select(" + approvedRow.get(i).get(Approved._id) + ");' class='mousePointer'>");
                html3.append("<td class='c'>" + approvedRow.get(i).get(Approved._id) + "</td>");
                html3.append("<td class='r'>" + approvedRow.get(i).get(Approved._title) + "</td>");
                html3.append("<td class='r'>" + approvedRow.get(i).get(Approved._responsibleForTrackId) + "</td>");
                html3.append("<td class='r'>" + approvedRow.get(i).get(Approved._responsibleForExecutionId) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(approvedRow.get(i).get(Approved._startDate)) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(approvedRow.get(i).get(Approved._endDate)) + "</td>");
                html3.append("<td class='r'>" + approvedRow.get(i).get(Approved._vaziat) + "</td>");

                html3.append("<td class='r'><i class='icon ion-gear-a' style='color:#a02311'></i></td>");
                html3.append("</tr>");
            }
            html3.append("</tbody></table>");
            List<Map<String, Object>> RolesRow = jjDatabase.separateRow(db.Select(Role.tableName));
            html5.append("<option>انتخاب کنید</option>");
            for (int i = 0; i < RolesRow.size(); i++) {
                html5.append("<option id='" + RolesRow.get(i).get(Role._user_id) + "' value='" + RolesRow.get(i).get(Role._id) + "'>" + RolesRow.get(i).get(Role._title) + "</option>");
            }
            script += Js.setHtml("Sessions_button", html2);
            script += Js.table("#refreshApproved", "300", 0, "", "جلسات");
            script += Js.setHtml("#approvedTbl", html3);
            script += Js.setHtml("#audience", html4);
            script += html.toString();
            script += Js.setHtml("#approved_responsibleForExecutionId", html5);
            script += Js.setHtml("#approved_responsibleForTrackId", html5);
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

            Map<String, Object> map = new HashMap<String, Object>();

            map.put(_checkingAgenda, jjTools.getParameter(request, _checkingAgenda));
            map.put(_titleFile, jjTools.getParameter(request, _titleFile));
            map.put(_titleIssue, jjTools.getParameter(request, _titleIssue));
            map.put(_nextDate, jjTools.getParameter(request, _nextDate));
            map.put(_sessionDescription, jjTools.getParameter(request, _sessionDescription));
            map.put(_weakPoint, jjTools.getParameter(request, _weakPoint));
            map.put(_strengths, jjTools.getParameter(request, _strengths));
            map.put(_ProposedSolution, jjTools.getParameter(request, _ProposedSolution));
            map.put(_audience, jjTools.getParameter(request, _audience));
//            map.put(_file, jjTools.getParameter(request, _file));

            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            Server.outPrinter(request, response, Js.jjSessions.refresh());
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
            String commettesId = jjTools.getParameter(request, "commettesId");//شماره های مدعوین برای ارسال پیام
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _commetteId + "=" + commettesId));
            String text = jjTools.getParameter(request, _contextInvitation);
            String inviteesId = jjTools.getParameter(request, _Invitees);//ای دی مدعوین برای ارسال پیام
            String inviteesOutSideId = jjTools.getParameter(request, _InviteesOutSide);//شماره های مدعوین خارج از سازمان برای ارسال پیام
            String inviteesInSideId = jjTools.getParameter(request, _InviteesInSide);//شماره های مدعوین داخل سازمان برای ارسال پیام
            Map<String, Object> map = new HashMap<>();
            map.put(_creatorId, jjTools.getSeassionUserId(request));//ایدی مدعوین
            map.put(_Invitees, inviteesId);//ایدی مدعوین
            map.put(_InviteesOutSide, inviteesOutSideId);//ای دی های مدعوین
            map.put(_InviteesInSide, inviteesInSideId);// داخل سازمان ای دی های مدعوین
            map.put(_title, jjTools.getParameter(request, _title));//عنوان جلسه
            map.put(_date, jjTools.getParameter(request, _date));//تاریخ جلسه
            map.put(_time, jjTools.getParameter(request, _time));//ساعت جلسه
            map.put(_contextInvitation, jjTools.getParameter(request, _contextInvitation));//متن دعوتنامه
            map.put(_agenda, jjTools.getParameter(request, _agenda));//دستور جلسه
            map.put(_dateReminder, jjTools.getParameter(request, _dateReminder));//تاریخ یاد آوری
            map.put(_timeReminder, jjTools.getParameter(request, _timeReminder));//ساعت یاد اوری
            map.put(_audience, "");//ساعت یاد اوری
            map.put(_invitationDate, jjCalendar_IR.getDatabaseFormat_8length("", true));//تاریخ ارسال دعوتنامه
            map.put(_commetteId, commettesId);//ای دی کمیته
            if (row.size() == 1) {
                db.update(tableName, map, _commetteId + "=" + commettesId);
            } else if (row.size() == 0) {
                DefaultTableModel dtm = db.insert(tableName, map);
                if (dtm.getRowCount() == 0) {
                    String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                } else {
                }
            }
//            sendcomment(text,inviteesId,inviteesOutSideId);
            System.out.println("@To Do send Comment");
             String script="";
            script += "hmisSessions.m_refresh();";
            script += "sendcomment(" + text + "," + inviteesId + "," + inviteesOutSideId + "," + inviteesInSideId + ");";
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

//    /**
//     *
//     * @param request
//     * @param db
//     * @param isPost
//     * @return
//     * @throws Exception
//     */
//    public static String showInvitationForm(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
//        try {
//            StringBuilder html = new StringBuilder();
//            StringBuilder html2 = new StringBuilder();
//            String commettesId = jjTools.getParameter(request, "hmis_commettes_id");
//            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + commettesId));
//            html.append("<label class='ckbox'>");
//            String memberId = commettesRow.get(0).get(Commettes._members).toString();
//            String[] membersId = memberId.split("%23A%23");
//            for (int i = 0; i < membersId.length; i++) {
//
//                List<Map<String, Object>> roleRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + membersId[i]));
//                List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + roleRow.get(0).get(Role._user_id)));
//                html.append("<div class=\"form-group has-danger mg-b-0\">");
//                html.append("<label class=\"ckbox\">");
//                html.append("<input type = \"checkbox\" value ='" + roleRow.get(0).get(Role._user_id) + "' class=\"checkBoxInvitees\" name = \"sessions_Invitees\" id = \"sessions_Invitees" + roleRow.get(0).get(Role._user_id) + "\" > ");
//                html.append("<span>" + userRow.get(0).get(Access_User._name) + " " + userRow.get(0).get(Access_User._family) + "");
//                html.append("</span>");
//                html.append("</label>");
//                html.append("</div>");
//            }
//            /////////////////////////////////////////////////////////////////////////////////////////////
//            List<Map<String, Object>> usersRow = jjDatabase.separateRow(db.Select(Access_User.tableName));
//            html2.append("<table id='usersListTable' style=''>");
////            html2.append("<thead>");
////            html2.append("<th></th>");
////            html2.append("</thead>");
//            html2.append("<tbody>");
//            for (int i = 0; i < usersRow.size(); i++) {
//                html2.append("<tr>");
//                html2.append("<td  ><input id='" + usersRow.get(i).get(Access_User._id) + "' name='" + usersRow.get(i).get(Access_User._id) + "' value='" + usersRow.get(i).get(Access_User._name) + "" + usersRow.get(i).get(Access_User._family) + "' onclick=' var selectVal = $(this).val();\n"
//                        + "                                $(\"#sessions_InviteesInSide\").val(selectVal);\n"
//                        + "                                //        $(\".login-wrap\").css(\"height\",\"1808px\");\n"
//                        + "                                $(\"#usersListTable\").hide();'></td>");
//                html2.append("</tr>");
//            }
//            html2.append("</tbody>");
//            html2.append("</table>");
//            String script = Js.setHtml("#usersListDiv", html2);
//            script += Js.setHtml("#invitessDiv", html);
//
//            Server.outPrinter(request, response, script);
//            return "";
//        } catch (Exception ex) {
//            Server.outPrinter(request, response, Server.ErrorHandler(ex));
//            return "";
//        }
//    }
}
