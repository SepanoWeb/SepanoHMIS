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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;
import jj.jjCalendar_IR;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;

public class Setting {

    public static String tableName = "hmis_setting";
    public static String _id = "id";
    public static String _name = "setting_name";
    public static String _value = "setting_value";

    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ثبت ویرایش";
    public static String lbl_add_en = "افزودن زبان انگلیسی";
    public static String lbl_edit_en = "ویرایش بخش انگلیسی";
    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_dlt = 0;
    public static int rul_edt = 0;

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isFromClient) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
//            boolean accRefAll = Access_User.hasAccess(request, db, rul_rfsAll);
//            boolean accRef = Access_User.hasAccess(request, db, rul_rfs);

            StringBuilder html = new StringBuilder();
            html.append("<div class=\"card-header bg-primary tx-white\">لیست  تنظیمات</div>\n");
            html.append(" <div class=\"card-body pd-sm-30\">\n"
                    + "                                        <p class=\"mg-b-20 mg-sm-b-30\">\n"
                    + "                                            <a style='color:#fff' class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" onclick=\"hmisSetting.m_add_new();\" >تنظیمات جدید</a>\n"
                    + "                                        </p>\n"
                    + "                                    </div>");
            html.append("        <div class=\"table-wrapper\">\n");
            html.append("<div class=\"table-wrapper\">\n");
            html.append("<table id='refreshSetting' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='40%'>نام</th>");
            html.append("<th width='40%'>تعداد روز</th>");
            html.append("<th width='40%'>ویرایش</th>");
            html.append("</thead><tbody>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName));

            for (int i = 0; i < row.size(); i++) {
                html.append("<tr onclick='hmisSetting.m_select(" + row.get(i).get(_id) + ")' class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='c'>" + row.get(i).get(_name) + "</td>");
                html.append("<td class='c'>" + row.get(i).get(_value) + "</td>");
//                System.out.println("" + row.get(i).get(_id));

                html.append("<td class='r'><i class='icon ion-gear-a' style='color:#a02311'></i></td>");
                html.append("</tr>");
            }
//            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swSettingTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshSetting", "300", 0, "", "جلسات");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Setting_button", "<button  id=\"insert_Setting_new\"  class=\"btn btn-outline-success active btn-block mg-b-10\" onclick='" + Js.jjSetting.insert() + "'>" + lbl_insert + "</button>"));
            }
            String script = html.toString();
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
/**
 * اگر در ویرایش فرد نام ستینگ را عوض کرد که در دیتا بیس وجود داشت بگوید امکان ویرایش با این نام وجود ندارد
 * @param request
 * @param response
 * @param db
 * @param needString
 * @return
 * @throws Exception 
 */
    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
            }
            
            
            
            String script = "";
            String id = jjTools.getParameter(request, _id);
            List<Map<String, Object>> SettingRow = jjDatabaseWeb.separateRow(db.Select(tableName, _name + "='" + jjTools.getParameter(request, _name) + "'"));
            if (SettingRow.size() >= 1) {
                script += Js.modal("امکان ویرایش با این نام وجود ندارد", "پیام سامانه");
            } else {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(_name, jjTools.getParameter(request, _name));
                map.put(_value, Integer.valueOf(jjTools.getParameter(request, _value)));
                System.out.println("id=" + jjTools.getParameter(request, _id));
                String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
                if (!errorMessageId.equals("")) {
                    if (jjTools.isLangEn(request)) {
                        errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                    }
                    script += Js.modal(errorMessageId, "پیام سامانه");
                }
                if (!db.update(tableName, map, _id + "=" + id)) {
                    String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");
                }
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
/**
 * زمانی که فردی یک تنظیمات جدیدی بجواهد ایجاد کند اکر نام مورد نطر وجود داشته باشد تنظیمات قبلی با ان نام تغییر می کند
 * @param request
 * @param response
 * @param db
 * @param needString
 * @return
 * @throws Exception 
 */
    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String script = "";
            List<Map<String, Object>> settingRow = jjDatabase.separateRow(db.Select(tableName, _name + "='" + jjTools.getParameter(request, _name) + "'"));
            System.out.println("name=" + jjTools.getParameter(request, _name));

            Map<String, Object> mapEdit = new HashMap<String, Object>();
            Map<String, Object> mapInsert = new HashMap<String, Object>();
            if (settingRow.size() > 0) {
                String id = settingRow.get(0).get(_id).toString();
                mapEdit.put(_value, Integer.valueOf(jjTools.getParameter(request, _value)));
                if (!db.update(tableName, mapEdit, _id + "=" + id)) {
                    String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");
                }
                script += Js.modal("ویرایش انجام شد", "پیام سامانه");
                script += Js.jjSetting.refresh();

            } else {
                mapInsert.put(_name, jjTools.getParameter(request, _name));
                mapInsert.put(_value, Integer.valueOf(jjTools.getParameter(request, _value)));

                if (db.insert(tableName, mapInsert).getRowCount() < 1) {
                    String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Insert Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");

                }
                script += Js.jjSetting.refresh();
            }

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            String script = "";
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                script += Js.modal(errorMessageId, "پیام سامانه");
            }
            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                script += Js.modal(errorMessage, "پیام سامانه");
            }
            script += Js.jjSetting.refresh();
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String script = "";
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                script += Js.modal(errorMessageId, "پیام سامانه");
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                script += Js.modal(errorMessage, "پیام سامانه");
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#" + _name, row.get(0).get(_name)));
            html.append(Js.setVal("#" + _value, row.get(0).get(_value)));

            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);

            if (accEdt) {
                html2.append("<div class=\"col-lg-3\">");
                html2.append("<button class='btn btn-outline-warning btn-block mg-b-10 tahoma10' id=\"edit_Setting\" onclick='" + Js.jjSetting.edit() + "'> " + lbl_edit + "</button>");
                html2.append("</div>");
            }
            if (accDel) {
                html2.append("<div class=\"col-lg-3\">");
                html2.append("<button  id=\"delete_Setting\"  class='tahoma10 btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjSetting.delete(id) + "'  >" + lbl_delete + "</button>");
                html2.append("</div>");
            }
            script += Js.setHtml("#Setting_button", html2.toString()) + html.toString();
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
}
