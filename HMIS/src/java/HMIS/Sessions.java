/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import static HMIS.Approved._endDate;
import static HMIS.Approved._id;
import static HMIS.Approved._responsibleForExecutionId;
import static HMIS.Approved._responsibleForTrackId;
import static HMIS.Approved._startDate;
import static HMIS.Approved._title;
import static HMIS.Approved._vaziat;
import cms.access.Access_User;
import cms.tools.Js;
import cms.tools.Server;
import cms.tools.jjTools;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
    public static String _agenda = "sessions_agenda";//دستور جلسه
    public static String _date = "sessions_date";//
    public static String _time = "sessions_time";//
    public static String _dateReminder = "sessions_dateReminder";//تاریخ یادآوری
    public static String _timeReminder = "sessions_timeReminder";//ساعت یادآوری 
    public static String _Invitees = "sessions_Invitees";//مدعوین داخل سازمان
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
    public static String _file1 = "sessions_file1";// 
    public static String _file2 = "sessions_file2";// 
    public static String _file3 = "sessions_file3";// 

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

    public static String refresh(HttpServletRequest request, jjDatabaseWeb db, boolean isFromClient) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
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
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
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
    public static String add_new(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuffer html = new StringBuffer();

            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Commette_button", "<input type=\"button\" id=\"insert_Commette_new\" value=\"" + lbl_insert + "\" class=\"btn btn-success btn-block mg-b-10 tahoma10\">"));
                html.append(Js.buttonMouseClick("#insert_Sessions_new", Js.jjSessions.insert()));
            }
            return html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
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
    public static String select(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + row.get(0).get(_commetteId)));

            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setHtml("#commettesTitle", commettesRow.get(0).get(Commettes._title) + "-جلسه" + row.get(0).get(_date)));
            html.append(Js.setHtml("#sessions_sessionsDate", row.get(0).get(_date)));
            html.append(Js.setVal("#sessions_agendaSessions", row.get(0).get(_agenda)));
            html.append(Js.setVal("#sessions_titleSessions", row.get(0).get(_title)));
            html.append(Js.setVal("#"+ _checkingAgenda, row.get(0).get(_checkingAgenda)));
            html.append(Js.setVal("#"+ _titleFile, row.get(0).get(_titleFile)));
            html.append(Js.setVal("#"+ _titleIssue, row.get(0).get(_titleIssue)));
            html.append(Js.setVal("#"+ _ProposedSolution, row.get(0).get(_ProposedSolution)));
            html.append(Js.setVal("#"+_weakPoint, row.get(0).get(_weakPoint)));
            html.append(Js.setVal("#"+_strengths, row.get(0).get(_strengths)));
            html.append(Js.setVal("#"+_sessionDescription, row.get(0).get(_sessionDescription)));
            html.append(Js.setVal("#"+_nextDate, row.get(0).get(_nextDate)));
            html.append(Js.setVal("#"+_file1, row.get(0).get(_file1)));
            html.append(Js.setVal("#"+_file2, row.get(0).get(_file2)));
            html.append(Js.setVal("#"+_file3, row.get(0).get(_file3)));
           String InvitedId=row.get(0).get(_Invitees).toString();
//           invi
//            html.append(Js.setVal("#" + _dateOfHoldingMeeting, row.get(0).get(_dateOfHoldingMeeting)));
//            html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
//            html.append(Js.setVal("#" + _members, row.get(0).get(_members)));
//            html.append(Js.setVal("#" + _secretary, row.get(0).get(_secretary)));
//            html.append(Js.setVal("#" + _superwizar, row.get(0).get(_superwizar)));
//            html.append(Js.setVal("#" + _regulationFile1, row.get(0).get(_regulationFile1)));
//            html.append(Js.setVal("#" + _regulationFile2, row.get(0).get(_regulationFile2)));
//            html.append(Js.setVal("#" + _regulationFile3, row.get(0).get(_regulationFile3)));
            boolean accEdt = Access_User.hasAccess2(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess2(request, db, rul_dlt);//
//            html2.append("<div class='row'>");
            if (accEdt) {
//                html2.append("<div class=\"col-lg-3\">");
                html2.append("<input type='button' id='edit_Sessions' value='ثبت موقت' class='btn btn-outline-warning active btn-block mg-b-10 tahoma10'>");
                html.append(Js.buttonMouseClick("#edit_Sessions", Js.jjSessions.edit()));
//                html2.append("</div>");
            }
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
//            List<Map<String,Object>> commettedRow=jjDatabase.separateRow(db.Select(Commettes.tableName,Commettes._id+"="+row.get(i).get(_commetteId)));
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
            String script = Js.setHtml("Sessions_button", html2);
            script += Js.table("#refreshApproved", "300", 0, "", "جلسات");
            script += Js.setHtml("#approvedTbl", html3);
            script += html.toString();
            return script;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
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
    public static String edit(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            System.out.println("proposedSulotion="+jjTools.getParameter(request, _ProposedSolution));
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
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
            map.put(_file1, jjTools.getParameter(request, _file1));
            map.put(_file2, jjTools.getParameter(request, _file2));
            map.put(_file3, jjTools.getParameter(request, _file3));

            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjSessions.refresh();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
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
    public static String requestSendComment(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String commettesId = jjTools.getParameter(request, "commettesId");//شماره های مدعوین برای ارسال پیام
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _commetteId + "=" + commettesId));
            String text = jjTools.getParameter(request, _contextInvitation);
            String inviteesId = jjTools.getParameter(request, _Invitees);//ای دی مدعوین برای ارسال پیام
            String inviteesOutSideId = jjTools.getParameter(request, _InviteesOutSide);//شماره های مدعوین برای ارسال پیام
            Map<String, Object> map = new HashMap<>();
            map.put(_creatorId, jjTools.getSessionAttribute(request, "#ID"));//ایدی مدعوین
            map.put(_Invitees, inviteesId);//ایدی مدعوین
            map.put(_InviteesOutSide, inviteesOutSideId);//ای دی های مدعوین
            map.put(_title, jjTools.getParameter(request, _title));//عنوان جلسه
            map.put(_date, jjTools.getParameter(request, _date));//تاریخ جلسه
            map.put(_time, jjTools.getParameter(request, _time));//ساعت جلسه
            map.put(_contextInvitation, jjTools.getParameter(request, _contextInvitation));//متن دعوتنامه
            map.put(_agenda, jjTools.getParameter(request, _agenda));//دستور جلسه
            map.put(_dateReminder, jjTools.getParameter(request, _dateReminder));//تاریخ یاد آوری
            map.put(_timeReminder, jjTools.getParameter(request, _timeReminder));//ساعت یاد اوری
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
                    return Js.dialog(errorMessage);
                } else {
                }
            }
//            sendcomment(text,inviteesId,inviteesOutSideId);
            System.out.println("@To Do send Comment");
            return "sendcomment(" + text + "," + inviteesId + "," + inviteesOutSideId + ");";
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
}
