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

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isFromClient) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            StringBuilder html = new StringBuilder();
            DefaultTableModel dtm = db.Select(Approved.tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);


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
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
             Server.outPrinter(request, response,Server.ErrorHandler(ex));
             return "";
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
    public static String insert(HttpServletRequest request,HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
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
                 Server.outPrinter(request, response, Js.dialog(errorMessage));
                 return "";
            }

            Server.outPrinter(request, response,Js.jjSessions.select(sessionsId));
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response,Server.ErrorHandler(ex));
            return "";
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
    public static String add_new(HttpServletRequest request,HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            StringBuffer html = new StringBuffer();

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Approved_button", "<button  class=\"btn btn-outline-success active btn-block mg-b-10\" id=\"insert_Approved_new\" onclick='"+Js.jjApproved.insert()+"'>"+lbl_insert+"</button>"));
//                html.append(Js.buttonMouseClick("#insert_Approved_new", Js.jjApproved.insert()));
            }
            Server.outPrinter(request, response,html.toString());
            return "";
        } catch (Exception ex) {
             Server.outPrinter(request, response,Server.ErrorHandler(ex));
             return "";
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
    public static String select(HttpServletRequest request,HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
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
            StringBuilder html3 = new StringBuilder();

            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));

            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#" + _vaziat, row.get(0).get(_vaziat)));
            html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
            html.append(Js.setVal("#" + _responsibleForTrackId, row.get(0).get(_responsibleForTrackId)));
            html.append(Js.setVal("#" + _responsibleForExecutionId, row.get(0).get(_responsibleForExecutionId)));
            html.append(Js.setVal("#" + _endDate, jjCalendar_IR.getViewFormat(row.get(0).get(_endDate))));
            html.append(Js.setVal("#" + _startDate, jjCalendar_IR.getViewFormat(row.get(0).get(_startDate))));
            if (!row.get(0).get(_file).toString().equals("")) {
                String[] File = (row.get(0).get(_file).toString()).split("%23A%23");
                for (int i = 0; i < File.length; i++) {
                    html3.append("<input class='col-xs-12' value='" + File[i] + "' >");
                }
            }
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            html2.append("<div class='row'>");
            if (accEdt) {
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button  id='edit_Approved' class='btn btn-outline-warning btn-block mg-b-10' onclick='"+Js.jjApproved.edit()+"' >"+lbl_edit+"</button>");
//                html.append(Js.buttonMouseClick("#edit_Approved", ));
                html2.append("</div>");
            }
            if (accDel) {
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button id='delete_Approved'  class='btn btn-outline-danger btn-block mg-b-10' onclick='"+Js.jjApproved.delete(id)+"'>"+lbl_delete+"</button>");
//                html.append(Js.buttonMouseClick("#delete_Approved", ));
                html2.append("</div>");
            }
            html2.append("</div>");
            String script = Js.setHtml("Approved_button", html2);
            script += html.toString();
            script += Js.setHtml("#inputTextSelectorDiv", html3);
            Server.outPrinter(request, response, script);
            return "";
            
        } catch (Exception ex) {
           Server.outPrinter(request, response,Server.ErrorHandler(ex));
           return "";
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
    public static String edit(HttpServletRequest request,HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, "hmis_approved_id");
            String sessionsId = jjTools.getParameter(request, "hmis_sessions_id");

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                  Server.outPrinter(request, response, hasAccess);
                  return "";
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
            script +="$('#insertApproved2').slideUp();";
              Server.outPrinter(request, response, script);
              return "";
        } catch (Exception ex) {
              Server.outPrinter(request, response,Server.ErrorHandler(ex));
              return "";
        }
    }

    public static String delete(HttpServletRequest request,HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                  Server.outPrinter(request, response, hasAccess);
                  return "";
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
                  Server.outPrinter(request, response, Js.dialog(errorMessage));
                  return "";
            }
            String script =Js.jjSessions.select(id);
            script +="$('#insertApproved2').slideUp();";
              Server.outPrinter(request, response, script);
              return "";
        } catch (Exception ex) {
              Server.outPrinter(request, response, Server.ErrorHandler(ex));
              return "";
        }
    }
}
