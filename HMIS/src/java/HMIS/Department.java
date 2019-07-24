/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import static HMIS.DepartmentPosition._level;
import cms.access.Access_User;
import cms.tools.Js;
import cms.tools.Server;
import cms.tools.jjTools;
import cms.tools.jjValidation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Shiran1 بخش ها
 */
public class Department {

    public static String tableName = "Department";
    public static String _id = "id";

    public static String _title = "department_title";

    public static String _publicContent = "department_publicContent";
    public static String _praivateContent = "department_praivateContent";
    public static String _organizationalCode = "department_organizationalCode";
    public static String _description = "department_description";
    public static String _location = "department_location";
    public static String _pic = "department_pic";
    public static String _icon = "department_icon";

    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ثبت ویرایش";

    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;

    /**
     * این جدول مخصوص بخش ها ست
     *
     * @param height is int height of table
     * @param sort is number of default sort column number
     * @param panel is container id
     */
    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
//            String hasAccess = Department.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                Server.outPrinter(request, response,hasAccess;
//            }
            StringBuilder html = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            DefaultTableModel dtm = db.Select(Department.tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>بخش ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisDepartment.m_add_new();' > بخش جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshParts' dir='rtl'><thead>");
            html.append("<th style='text-align: center;' width='5%'>کد</th>");
            html.append("<th style='text-align: center;' width='30%'>نام بخش</th>");
            html.append("<th style='text-align: center;' width='20%'>موقعیت</th>");
//            html.append("<th style='text-align: center;' width='10%'></th>");
//            html.append("<th style='text-align: center;' width='30%'></th>");
            html.append("<th style='text-align: center;' width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='hmisDepartment.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
                html.append("<td class='tahoma10' style='text-align: center;'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td class='tahoma10' style='text-align: left;'>" + (row.get(i).get(_title).toString()) + "</td>");
                List<Map<String, Object>> depatementRow = jjDatabase.separateRow(db.Select(DepartmentPosition.tableName, DepartmentPosition._id + "=" + row.get(i).get(_location).toString()));
                html.append("<td class='tahoma10' style='text-align: right;'>" + (row.get(0).get(_location).toString()) + "</td>");
                html.append("<td style='text-align: center;color:red;font-size: 26px;' class='icon ion-ios-gear-outline'><a src='img/l.png' style='cursor: pointer;height:30px' onclick='hmisDepartment.m_select(" + row.get(i).get(_id) + ");' ></a></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            html.append("</div></div>");

            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swDepartmentTbl";
            }
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            html2 += Js.table("#refreshParts", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست بخش ها");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    /**
     * این متد بخش ها و زیر بخش ها را نشان میدهد توجه داشته باشید سلکت باید در
     * قسمت اچ تی ام ال سمت کلاینت موجود باشد و اینجا فقط آپشن ها بصورت سلسله
     * مراتبی ایجاد می شوند
     *
     * @param request panel درون ریکوئست
     * @param response
     * @param db
     * @param needString
     * @Server.outPrinter(request, response,بصورت کد جی کوئری و یک سری آپشن برای
     * قرار گرفتن در سلکتی که در پنل معرفی شده
     * @throws Exception
     */
    public static String selectOptionDepartment(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option value=''>یخش را انتخاب کنید</option>");
            List<Map<String, Object>> rowDepartments = jjDatabase.separateRow(db.Select(tableName));
            for (int i = 0; i < rowDepartments.size(); i++) {
                html.append("<option value='" + rowDepartments.get(i).get(_id) + "'>" + rowDepartments.get(i).get(_title) + "</option>");
            }
            if (panel == "") {
                panel = "department_location";
            }
            Server.outPrinter(request, response, Js.setHtml("#" + panel, html));
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        StringBuilder script = new StringBuilder();
        try {
            script.append("$('#department_location').select2();\n");
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
//            if (accIns) {
//                html.append(Js.setHtml("#Department_button", "<div class='row'><div class='col-lg-6'><input type='button' id='insert_Department_new'  value=\"" + lbl_insert + "\" class='tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget'></div></div>"));
//                html.append(Js.buttonMouseClick("#insert_Department_new", Js.jjDepartment.insert()));
//            }
            if (accIns) {
                script.append(Js.setHtml("#Department_button", "<div class='col-lg-6'><input type='button' id='insert_Department_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success active btn-block mg-b-10'></div>"));
                script.append(Js.click("#insert_Department_new", Js.jjDepartment.insert()));
            }
            Server.outPrinter(request, response, html.toString() + script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    /**
     * تابع درج date 1397/11/7
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
//            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
//            map.put(_subcategory, jjTools.getParameter(request, _subcategory));

            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_organizationalCode, jjTools.getParameter(request, _organizationalCode));
            map.put(_icon, jjTools.getParameter(request, _icon));
            map.put(_publicContent, request.getParameter(_publicContent));
            map.put(_praivateContent, request.getParameter(_praivateContent));
//             List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(DepartmentPosition.tableName, "*", "id>=0", DepartmentPosition._parent));

            map.put(_location, jjTools.getParameter(request, _location));

            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            Server.outPrinter(request, response, Js.jjDepartment.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     *
     * @param id
     */
    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.dialog(errorMessageId));
                return "";
            }
            StringBuilder script = new StringBuilder();
            StringBuilder script1 = new StringBuilder();

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
//            if (row.isEmpty()) {
//                String errorMessage = "رکوردی با این کد وجود ندارد.";
//                if (jjTools.isLangEn(request)) {
//                    errorMessage = "Select Fail;";
//                }
//                Server.outPrinter(request, response,Js.dialog(errorMessage);
//            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            script.append(Js.setVal("#department_" + _id, row.get(0).get(_id)));

            script.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            script.append(Js.setAttr("#IconDownload", "href", "upload/" + row.get(0).get(_icon)));
            script.append(Js.setVal("#" + _organizationalCode, row.get(0).get(_organizationalCode)));
            script.append(Js.setVal("#department_icon", row.get(0).get(_icon)));
            html.append(Js.setAttr("#IconDownload", "href", "upload/" + row.get(0).get(_icon)));
            if (row.get(0).get(_icon).equals("")) {
                script.append(Js.setAttr("#PicPreviewIcon", "src", "img/preview.jpg"));
                script.append(Js.hide("#IconDownload"));
            } else {
                script.append(Js.setAttr("#PicPreviewIcon", "src", "upload/" + row.get(0).get(_icon).toString() + ""));
                script.append(Js.show("#IconDownload"));
            }

            script.append(Js.setVal("#" + _location, row.get(0).get(_location).toString()));
            script.append("$('#department_location').select2();\n");
            script.append(Js.setValSummerNote("#department_publicContent", row.get(0).get(_publicContent)));
            script.append(Js.setValSummerNote("#department_praivateContent", row.get(0).get(_praivateContent)));

            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjDepartment.edit() + "' id='edit_Department'>" + lbl_edit + "</button></div>";
//               
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjDepartment.delete(id) + "' id='delete_Department'>" + lbl_delete + "</button></div>";
            }
            script1.append(Js.setHtml("#Department_button", htmlBottons));
//            if (accEdt) {
////                if (!id.equals("1")) {
//                html2.append("<div class=\"row\"><div class=\"col-lg-6\"><input type=\"button\" id=\"edit_Department\" value=\"" + lbl_edit + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"/></div>");
//                html.append(Js.buttonMouseClick("#edit_Department", Js.jjDepartment.edit()));
////                }
//            }
//            if (accDel) {
////                if (!id.equals("1")) {
//                html2.append("<div class=\"col-lg-6\"><input type=\"button\" id=\"delete_Department\" value=\"" + lbl_delete + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"  /></div></div>");
//                html.append(Js.buttonMouseClick("#delete_Department", Js.jjDepartment.delete(id)));
////                }
//            }
            Server.outPrinter(request, response, html.toString() + script + script1);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            String id = jjTools.getParameter(request, _id);
//           
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_title, request.getParameter(_title));
            map.put(_organizationalCode, request.getParameter(_organizationalCode));
            map.put(_icon, jjTools.getParameter(request, _icon));
            map.put(_publicContent, request.getParameter("department_publicContent"));
            map.put(_praivateContent, request.getParameter("department_praivateContent"));
            ////برای نمایش موقعیت بخش
            map.put(_location, jjTools.getParameter(request, _location));
            System.out.println("id=" + id);
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                Server.outPrinter(request, response,Js.dialog(errorMessageId);
//            }
            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            Server.outPrinter(request, response, Js.jjDepartment.refresh());
            return "";
//            Server.outPrinter(request, response,"";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
//            Content.catchProductTitle = null;
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.dialog(errorMessageId));
                return "";
            }

            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }

            Server.outPrinter(request, response, Js.jjDepartment.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
}
