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
 * @author shohreh.shiran Date 1397.12.18 Session:صورت جلسه و دعوتنامه
 */
public class Approved {

    public static String tableName = "hmis_approved";
    public static String _id = "id";
    public static String _sessionsId = "approved_sessionsId";//ایدی جلسه
//    public static String _commetteId = "approved_commettesId";//ایدی کمیته
    public static String _title = "approved_title";//عنوان مصوبه
    public static String _startDate = "approved_startDate";//تاریخ شروع 
    public static String _endDate = "approved_endDate";//تاریخ پایان
    public static String _responsibleForTrackId = "approved_responsibleForTrackId";//مسئول پیگیری
    public static String _responsibleForExecutionId = "approved_responsibleForExecutionId";//مسئول اجرا
    public static String _vaziat = "approved_vaziat";//وضعیت
    public static String _description = "approved_description";//توضیحات
    public static String _file = "approved_file";//مستندات

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
            DefaultTableModel dtm = db.Select(Approved.tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

//            html.append("        <div class=\"card-header bg-primary tx-white\">لیست جلسات</div>\n");
//            html.append(" <div class=\"card-body pd-sm-30\">\n"
//                    + "                                        <p class=\"mg-b-20 mg-sm-b-30\">\n"
//                    + "                                            <a style='color:#fff' class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" onclick=\"hmisCommettes.m_add_new();\" >کمیته جدید</a>\n"
//                    + "                                        </p>\n"
//                    + "                                    </div>");
            html.append("        <div class=\"table-wrapper\">\n");
            html.append("<table id='refreshSessions' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>عنوان مصوبه</th>");
            html.append("<th width='15%'>مسئول اجرا</th>");
            html.append("<th width='20%'>مسئول پیگیری</th>");
            html.append("<th width='15%'>تاریخ شروع </th>");
            html.append("<th width='15%'>تاریخ پایان </th>");
            html.append("<th width='15%'>وضعیت</th>");
            html.append("<th width='40%'>ویرایش</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
//            List<Map<String,Object>> commettedRow=jjDatabase.separateRow(db.Select(Commettes.tableName,Commettes._id+"="+row.get(i).get(_commetteId)));
                html.append("<tr onclick='hmisSessions.m_select(" + row.get(i).get(_id) + ")' class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_title) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_responsibleForTrackId) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_responsibleForExecutionId) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_startDate)) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_endDate)) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_vaziat) + "</td>");

                html.append("<td class='r'><i class='icon ion-gear-a' style='color:#a02311'></i></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
//            html.append("</div>");
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
     * creator shohre shiran 13971218
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
            String sessionsId = jjTools.getParameter(request, "hmis_sessions_id");
            StringBuilder html = new StringBuilder();
            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_endDate, jjTools.getParameter(request, _endDate).replaceAll("/", ""));
            map.put(_startDate, jjTools.getParameter(request, _startDate).replaceAll("/", ""));
            map.put(_file, jjTools.getParameter(request, _file));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_responsibleForExecutionId, jjTools.getParameter(request, _responsibleForExecutionId));
            map.put(_responsibleForTrackId, jjTools.getParameter(request, _responsibleForTrackId));
            map.put(_vaziat, jjTools.getParameter(request, _vaziat));
            map.put(_sessionsId, sessionsId);

            DefaultTableModel dtm = db.insert(tableName, map);
            if (dtm.getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }

            return Js.jjSessions.select(sessionsId);
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * creator shohre shiran 13971218
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
                html.append(Js.setHtml("#Approved_button", "<input type=\"button\" class=\"btn btn-outline-success active btn-block mg-b-10\" id=\"insert_Approved_new\" value=\"" + lbl_insert + "\" >"));
                html.append(Js.buttonMouseClick("#insert_Approved_new", Js.jjApproved.insert()));
            }
            return html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * creator shohre shiran 13971218
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
            System.out.println("id=" + id);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
//            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName,Commettes._id + "=" +row.get(0).get(_commetteId)));

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

            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#" + _vaziat, row.get(0).get(_vaziat)));
            html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
            html.append(Js.setVal("#" + _responsibleForTrackId, row.get(0).get(_responsibleForTrackId)));
            html.append(Js.setVal("#" + _responsibleForExecutionId, row.get(0).get(_responsibleForExecutionId)));
            html.append(Js.setVal("#" + _endDate, jjCalendar_IR.getViewFormat(row.get(0).get(_endDate))));
            html.append(Js.setVal("#" + _startDate, jjCalendar_IR.getViewFormat(row.get(0).get(_startDate))));
            boolean accEdt = Access_User.hasAccess2(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess2(request, db, rul_dlt);//
            html2.append("<div class='row'>");
            if (accEdt) {
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<input type='button' id='edit_Approved' value='" + lbl_edit + "' class='btn btn-success btn-block mg-b-10 tahoma10'>");
                html.append(Js.buttonMouseClick("#edit_Approved", Js.jjApproved.edit()));
                html2.append("</div>");
            }
            if (accDel) {
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<input type='button' id='delete_Approved' value='" + lbl_delete + "' class='btn btn-success btn-block mg-b-10 tahoma10'  />");
                html.append(Js.buttonMouseClick("#delete_Approved", Js.jjApproved.delete(id)));
                html2.append("</div>");
            }
            html2.append("</div>");
            String script = Js.setHtml("Approved_button", html2);
            script += html.toString();
            return script;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * creator shohre shiran 13971218
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String edit(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, "hmis_approved_id");
            String sessionsId = jjTools.getParameter(request, "hmis_sessions_id");

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }

            Map<String, Object> map = new HashMap<>();
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_endDate, jjTools.getParameter(request, _endDate).replaceAll("/", ""));
            map.put(_startDate, jjTools.getParameter(request, _startDate).replaceAll("/", ""));
            map.put(_file, jjTools.getParameter(request, _file));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_responsibleForExecutionId, jjTools.getParameter(request, _responsibleForExecutionId));
            map.put(_responsibleForTrackId, jjTools.getParameter(request, _responsibleForTrackId));
            map.put(_vaziat, jjTools.getParameter(request, _vaziat));

            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            String script=Js.jjSessions.select(sessionsId);
            script +="$('#insertMosavabeh2').slideUp();";
            return script;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String delete(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            String id = jjTools.getParameter(request, _id);
            System.out.println("id="+id);
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }
            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                return Js.dialog(errorMessage);
            }
            String script =Js.jjSessions.select(id);
            script +="$('#insertMosavabeh2').slideUp();";
            return script;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
}
