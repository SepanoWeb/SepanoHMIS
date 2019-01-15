/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.cms;

import cms.tools.Js;
import cms.tools.Server;
import cms.tools.jjTools;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.swing.table.DefaultTableModel;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;

/**
 *
 * @author A S U S
 */
public class tags {

    public static String tableName = "tags";
    public static String _id = "id";
    public static String _name = "tags_name";

    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";

    public static int rul_rfs = 100;
    public static int rul_ins = 101;
    public static int rul_dlt = 102;
    public static int rul_edt = 103;
//    public static int rul_lng = 104;

    public static String refresh(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();
            DefaultTableModel dtm = db.Select(tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append("<table id='refreshTagTbl' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th style='border:1px solid;' width='5%'>ردیف</th>");
            html.append("<th style='border:1px solid;' width='20%'>id</th>");
            html.append("<th style='border:1px solid;' width='60%'>نام</th>");
            html.append("<th style='border:1px solid;' width='60%'>حذف</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='cmsTags.m_select(" + row.get(i).get(_id) + ");' class='mousePointer'>");/////////////////////////////////////////////////////////////////////////////////////
                html.append("<td style='border:1px solid;' class='c'>" + i + "</td>");
                html.append("<td style='border:1px solid;' class='c'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td style='border:1px solid;' class='r'>" + (row.get(i).get(_name).toString()) + "</td>");
                html.append("<td style='border:1px solid;' class='c' onclick='cmsTags.m_delete(" + (row.get(i).get(_id).toString()) + ")'><img src='img/l.png' style='height:30px' /></td>");/////////////////////////////////////////////////////////////////////////////////////
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "refreshTag";////////////////////////////////////////////////////////////////////////////////
            }

            String html2 = Js.setHtml(panel, html.toString());
//            html2 += Js.table("#refreshTag", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست محصولات");
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String insert(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            //============ BY RASHIDI ========>
            String tagName = jjTools.getParameter(request, _name);
            if (tagName.equals("")) {//اگر از کلاس دیگری بخواهیم تگ را اضافه کنیم
                jjTools.ShowAllAttribute(request);
                tagName = request.getAttribute(_name).toString();
            }
            //<============ BY RASHIDI ========
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_name, tagName);

            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                return Js.dialog(errorMessage);
            }
            return "";
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String edit(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            String id = jjTools.getParameter(request, _id);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_id, jjTools.getParameter(request, _id));
            map.put(_name, jjTools.getParameter(request, _name));

            if (!db.update(tableName, map, _id + "=" + jjTools.getParameter(request, _id))) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                return Js.dialog(errorMessage);
            }
            return "";
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String delete(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            String id = jjTools.getParameter(request, _id);
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));

            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                return Js.dialog(errorMessage);
            }
            return "";
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String select(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
//                if (jjTools.isLangEn(request)) {
//                    errorMessage = "Select Fail;";
//                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            html.append(Js.setVal(_id, row.get(0).get(_id)));
            html.append(Js.setVal(_name, row.get(0).get(_name)));

//            boolean accDel = Access_User.hasAccess2(request, db, rul_dlt);
//            boolean accEdt = Access_User.hasAccess2(request, db, rul_edt);
//            if (accEdt) {
//                html2.append("<input type=\"button\" id=\"edit_Tag\" value=\"" + lbl_edit + "\" class=\"tahoma10\">");
//                html.append(Js.buttonMouseClick("#edit_Product", Js.jjProduct.edit()));
//            }
//            if (accDel) {
//                html2.append("<input type=\"button\" id=\"delete_Tag\" value=\"" + lbl_delete + "\" class=\"tahoma10\"  />");
//                html.append(Js.buttonMouseClick("#delete_Product", Js.jjProduct.delete(id)));
//            }
            return (Js.setHtml("#Tag_button", html2.toString())) + html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
}
