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
 * @author shohreh.shiran Date 1397.11.1
 */
public class Commettes {

    public static String tableName = "hmis_commettes";
    public static String _id = "id";
    public static String _creatorId = "commettes_creatorId";//عنوان کمیته
    public static String _title = "commettes_title";//عنوان کمیته
    public static String _superwizar = "commettes_superwizar";//رئیس کمیته
    public static String _secretary = "commettes_secretary";// دبیر کمیته
    public static String _dateOfHoldingMeeting = "commettes_dateOfHoldingMeeting";//برگزاری جلسات
    public static String _members = "commettes_members";//اعضای کمیته  همان نقش میشود از جدول نقش ها می اید 
    public static String _regulationFile1 = "commettes_regulationFile1";//آئین نامه
    public static String _regulationFile2 = "commettes_regulationFile2";//آئین نامه
    public static String _regulationFile3 = "commettes_regulationFile3";//آئین نامه
    public static String _description = "commettes_description";//توضیحات
   
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

            html.append("        <div class=\"card-header bg-primary tx-white\">لیست کمیته ها و کارگروه ها</div>\n");
            html.append(" <div class=\"card-body pd-sm-30\">\n"
                    + "                                        <p class=\"mg-b-20 mg-sm-b-30\">\n"
                    + "                                            <a style='color:#fff' class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" onclick=\"hmisCommettes.m_add_new();\" >کمیته جدید</a>\n"
                    + "                                        </p>\n"
                    + "                                    </div>");
            html.append("        <div class=\"table-wrapper\">\n");
            html.append("<table id='refreshCommettes' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='20%'>نام کمیته</th>");
            html.append("<th width='20%'>دبیر کمیته</th>");
            html.append("<th width='20%'>رئیس کمیته</th>");
            html.append("<th width='20%'>دعوتنامه</th>");
            html.append("<th width='20%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_title) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_secretary) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_superwizar) + "</td>");
                html.append("<td class='r'><i class='icon ion-email' onclick='hmisCommettes.showInvitationForm(" +row.get(i).get(_id)+");' style='color:#ffcd00!important'></i></td>");
                html.append("<td class='r'><i class='icon ion-ios-gear-outline' onclick='hmisCommettes.m_select(" + row.get(i).get(_id) + ")'></i></td>");
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
                panel = "swCommettesTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshCommettes", "300", 0, "", "برنامه های عملیاتی");
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
            map.put(_creatorId, jjTools.getSessionAttribute(request, "#ID"));
            map.put(_dateOfHoldingMeeting, jjTools.getParameter(request, _dateOfHoldingMeeting));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_members, jjTools.getParameter(request, _members));
            map.put(_secretary, jjTools.getParameter(request, _secretary));
            map.put(_superwizar, jjTools.getParameter(request, _superwizar));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_regulationFile1, jjTools.getParameter(request, _regulationFile1));
            map.put(_regulationFile2, jjTools.getParameter(request, _regulationFile2));
            map.put(_regulationFile3, jjTools.getParameter(request, _regulationFile3));

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

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
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
            html.append(Js.setVal("#" + _dateOfHoldingMeeting, row.get(0).get(_dateOfHoldingMeeting)));
            html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
            html.append(Js.setVal("#" + _members, row.get(0).get(_members)));
            html.append(Js.setVal("#" + _secretary, row.get(0).get(_secretary)));
            html.append(Js.setVal("#" + _superwizar, row.get(0).get(_superwizar)));
            html.append(Js.setVal("#" + _regulationFile1, row.get(0).get(_regulationFile1)));
            html.append(Js.setVal("#" + _regulationFile2, row.get(0).get(_regulationFile2)));
            html.append(Js.setVal("#" + _regulationFile3, row.get(0).get(_regulationFile3)));
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
                html2.append("<div class='row'>");
            if (accEdt) {
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<input type='button' id='edit_Commettes' value='" + lbl_edit + "' class='btn btn-success btn-block mg-b-10 tahoma10'>");
                html.append(Js.buttonMouseClick("#edit_Commettes", Js.jjCommettes.edit()));
                html2.append("</div>");
            }
            if (accDel) {
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<input type='button' id='delete_Commettes' value='" + lbl_delete + "' class='btn btn-success btn-block mg-b-10 tahoma10'  />");
                html.append(Js.buttonMouseClick("#delete_Commettes", Js.jjCommettes.delete(id)));
                html2.append("</div>");
            }
                html2.append("</div>");
            String script = Js.setHtml("Commette_button", html2);
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
            map.put(_dateOfHoldingMeeting, jjTools.getParameter(request, _dateOfHoldingMeeting));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_members, jjTools.getParameter(request, _members));
            map.put(_secretary, jjTools.getParameter(request, _secretary));
            map.put(_superwizar, jjTools.getParameter(request, _superwizar));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_regulationFile1, jjTools.getParameter(request, _regulationFile1));
            map.put(_regulationFile2, jjTools.getParameter(request, _regulationFile2));
            map.put(_regulationFile3, jjTools.getParameter(request, _regulationFile3));
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
            return Js.jjCommettes.refresh();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
}
