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
    public static String _title = "sessions_title";//عنوان جلسه
    public static String _commetteId = "sessions_commettesId";//ایدی کمیته
    public static String _contextInvitation = "sessions_contextInvitation";//متن دعوتنامه  
    public static String _agenda = "sessions_agenda";//دستور جلسه
    public static String _date = "sessions_date";//
    public static String _time = "sessions_time";//
    public static String _dateReminder = "sessions_dateReminder";//
    public static String _timeReminder = "sessions_timeReminder";//
    public static String _Invitees = "sessions_Invitees";//مدعوین داخل سازمان
    public static String _InviteesOutSide = "sessions_InviteesOutSide";//مدعوین خارج از سازمان
    public static String _vaziat = "sessions_vaziat";//وضعیت
    public static String _ravandeVaziat = "sessions_ravandeVaziat";//روند وضعیت
    public static String _nextDate = "sessions_nextSessionDate";//تاریخ جلسه بعد
    public static String _strengths = "sessions_strengths";//نقاط قوت 
    public static String _weakPoint = "sessions_weakPoint";//نقاط ضعف 
    public static String _titleIssue = "sessions_titleIssue";//عنوان مسئله
    public static String _ProposedSolution = "sessions_ProposedSolution ";//راهکار پیشنهادی
    public static String _checkingAgenda = "sessions_checkingAgenda";//بررسی دستور جلسه 
    public static String _titleFile = "sessions_titleFile";//عنوان فایل برای بررسی
    public static String _file1 = "sessions_file1";//مدعوین خارج از سازمان
    public static String _file2 = "sessions_file2";//مدعوین خارج از سازمان
    public static String _file3 = "sessions_file3";//مدعوین خارج از سازمان

//    public static String _members = "commettes_members";//اعضای کمیته
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
            List<Map<String,Object>> commettedRow=jjDatabase.separateRow(db.Select(Commettes.tableName,Commettes._id+"="+row.get(i).get(_commetteId)));
                html.append("<tr onclick='hmisSessions.m_select("+row.get(i).get(_id)+")' class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_title) + "</td>");
                html.append("<td class='r'>" + commettedRow.get(0).get(Commettes._title) + "</td>");
                html.append("<td class='r'>" + commettedRow.get(0).get(Commettes._secretary) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_date) + "-"+ row.get(i).get(_time)+ "</td>");
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
    public static String insert(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            StringBuilder html = new StringBuilder();
            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
//            map.put(_creatorId, jjTools.getSessionAttribute(request, "#ID"));
//            map.put(_dateOfHoldingMeeting, jjTools.getParameter(request, _dateOfHoldingMeeting));
//            map.put(_description, jjTools.getParameter(request, _description));
//            map.put(_members, jjTools.getParameter(request, _members));
//            map.put(_secretary, jjTools.getParameter(request, _secretary));
//            map.put(_superwizar, jjTools.getParameter(request, _superwizar));
////            map.put(_title, jjTools.getParameter(request, _title));
//            map.put(_regulationFile1, jjTools.getParameter(request, _regulationFile1));
//            map.put(_regulationFile2, jjTools.getParameter(request, _regulationFile2));
//            map.put(_regulationFile3, jjTools.getParameter(request, _regulationFile3));

            DefaultTableModel dtm = db.insert(tableName, map);
            if (dtm.getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }

            return Js.jjCommettes.refresh();
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
    public static String add_new(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuffer html = new StringBuffer();

            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Commette_button", "<input type=\"button\" id=\"insert_Commette_new\" value=\"" + lbl_insert + "\" class=\"btn btn-success btn-block mg-b-10 tahoma10\">"));
                html.append(Js.buttonMouseClick("#insert_Commette_new", Js.jjCommettes.insert()));
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
            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName,Commettes._id + "=" +row.get(0).get(_commetteId)));
            
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setHtml("#commettesTitle",commettesRow.get(0).get(Commettes._title)+"-جلسه"+row.get(0).get(_date)));
            html.append(Js.setHtml("#sessions_sessionsDate",row.get(0).get(_date)));
            html.append(Js.setVal("#sessions_agendaSessions",row.get(0).get(_agenda)));
            html.append(Js.setVal("#sessions_titleSessions",row.get(0).get(_title)));
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
            html2.append("<div class='row'>");
            if (accEdt) {
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<input type='button' id='edit_Sessions' value='" + lbl_edit + "' class='btn btn-success btn-block mg-b-10 tahoma10'>");
                html.append(Js.buttonMouseClick("#edit_Sessions", Js.jjCommettes.edit()));
                html2.append("</div>");
            }
            if (accDel) {
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<input type='button' id='delete_Sessions' value='" + lbl_delete + "' class='btn btn-success btn-block mg-b-10 tahoma10'  />");
                html.append(Js.buttonMouseClick("#delete_Sessions", Js.jjCommettes.delete(id)));
                html2.append("</div>");
            }
            html2.append("</div>");
            String script = Js.setHtml("Sessions_button", html2);
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
//            map.put(_dateOfHoldingMeeting, jjTools.getParameter(request, _dateOfHoldingMeeting));
//            map.put(_description, jjTools.getParameter(request, _description));
//            map.put(_members, jjTools.getParameter(request, _members));
//            map.put(_secretary, jjTools.getParameter(request, _secretary));
//            map.put(_superwizar, jjTools.getParameter(request, _superwizar));
//            map.put(_title, jjTools.getParameter(request, _title));
//            map.put(_regulationFile1, jjTools.getParameter(request, _regulationFile1));
//            map.put(_regulationFile2, jjTools.getParameter(request, _regulationFile2));
//            map.put(_regulationFile3, jjTools.getParameter(request, _regulationFile3));
            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjCommettes.refresh();
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
