/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

/**
 *
 * @author PadidarNB
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Shiran1 نقش ها
 */
public class Role {

    public static String tableName = "hmis_role";// قبل از اسم جداول دیتا بیس hmis_ بگذارید
    public static String _id = "id";

    public static String _title = "role_title";
    public static String _user_id = "role_user_id";//
    public static String _condition = "role_condition";//sh1: فعال یاغیر فعال بودن نقش
//    public static String _condition2 = "role_condition2";//
    public static String _comment = "role_comment";//
    public static String _discription = "role_discription";//
    public static String _name = "role_name";//

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
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws java.lang.Exception
     */
    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Role.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();

            DefaultTableModel dtm = db.Select(Role.tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>نقش ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisRole.m_add_new();' > نقش جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshParts' dir='rtl'><thead>");
            html.append("<th  class='c' width='5%'>کد</th>");
            html.append("<th  class='c' width='30%'>عنوان</th>");
            html.append("<th  class='c' width='20%'>وضعیت</th>");

            html.append("<th style='text-align: center;' width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='hmisRole.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
                html.append("<td  class='c'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td  class='c'>" + (row.get(i).get(_title).toString()) + "</td>");
                if ((row.get(i).get(_condition).toString()).equals("active")) {
                    html.append("<td  class='c'>فعال</td>");
                } else {
                    html.append("<td  class='c'>غیر فعال</td>");
                }
//                html.append("<td class='tahoma10' style='text-align: right;'>" + (row.get(i).get(_condition2).toString()) + "</td>");

                html.append("<td style='text-align: center;color:red;font-size: 26px;' class='icon ion-ios-gear-outline'><a src='img/l.png' style='cursor: pointer;height:30px' onclick='hmisRole.m_select(" + row.get(i).get(_id) + ");' ></a></td>");
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
                panel = "swRoleTbl";
            }
            String script = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            script += Js.table("#refreshRole", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست نقش ها");
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    /**
     * آی دی نقش را می گیرد و نقش کاربر را بر می گرداند برای توابع سمت جاوا
     * مواقعی که میخواهیم عنوان نقش کاربر را بدست بیاوریم اگر نقشی نداشت تهی بر
     * میگرداند این متد به کلاینت چیزی نمیفرستد
     *
     * @param roleId
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String getRoleName(String roleId, jjDatabaseWeb db) throws Exception {
        try {
            if (jjNumber.isDigit(roleId)) {
                List<Map<String, Object>> UserRowRole = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + roleId));
                if (!UserRowRole.isEmpty()) {
                    return UserRowRole.get(0).get(_title).toString();
                }
            }
            return "";

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * آی دی کاربر را می گیرد و نقش کاربر را بر می گرداند اگر آی دی کاربر را
     * نداشت آی دی را از سشن می خواند
     *
     * @param request panel,id
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String getRoleName(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            StringBuilder script = new StringBuilder();
//            String script = "";

            String panel = jjTools.getParameter(request, "panel");
            String userId = jjTools.getParameter(request, "userId");

            List<Map<String, Object>> UserRowRole = jjDatabase.separateRow(db.Select(Role.tableName, Role._user_id + "=" + userId));
            if (!UserRowRole.isEmpty()) {
                script.append(Js.setVal("#" + panel, UserRowRole.get(0).get(_title)));
            }

            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }

    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            ///ایجاد جدول کاربران 
            ///توسط شیران1
            List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, _id + ">5"));

            html1.append("<table class='table display responsive nowrap' id='RefreshlistKarbaran'><thead>");
            html1.append("<th width='10%'>کد </th>");
            html1.append("<th width='10%'>نام</th>");
            html1.append("<th width='15%'>نام خانوادگی</th>");
            html1.append("<th width='10%'>ایمیل </th>");
            html1.append("<th width='10%'>مشاهده </th>");
            html1.append("</thead><tbody>");
            for (int i = 0; i < userRow.size(); i++) {
                html1.append("<tr>");
                html1.append("<td  class='c'>" + (userRow.get(i).get(Access_User._id)) + "</td>");
                html1.append("<td class='c'>" + (userRow.get(i).get(Access_User._family)) + "</td>");
                html1.append("<td class='c'>" + (userRow.get(i).get(Access_User._name)) + "</td>");
                html1.append("<td class='c'>" + (userRow.get(i).get(Access_User._email)) + "</td>");
                html1.append("<td style='text-align: center;color:red;font-size: 26px;' class='icon ion-ios-gear-outline'  onclick='hmisRole.m_selectKarbar(" + userRow.get(i).get(Access_User._id) + ");' ></td>");
                html1.append("</tr>");
            }
            html1.append("</tbody></table>");
            String script2 = "$('#ListKarbaran').html(\"" + html1.toString() + "\");\n";
            script2 += Js.table("#RefreshlistKarbaran", "400", 0, "", "لیست کاربران");

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);

            if (accIns) {
                html.append(Js.setHtml("#Role_button", "<div class='col-lg-6'><input type='button' id='insert_Role_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success active btn-block mg-b-10'></div>"));
                html.append(Js.click("#insert_Role_new", Js.jjRole.insert()));
            } else {
                html.append(Js.setHtml("#Role_button", ""));
            }
//            if (accIns) {
//                html.append(Js.setHtml("#Role_button", "<div class='row'><div class='col-lg-6'><input type='button' id='insert_Role_new'  value=\"" + lbl_insert + "\" class='tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget'></div></div>"));
//                html.append(Js.buttonMouseClick("#insert_Role_new", Js.jjRole.insert()));
//            }
            Server.outPrinter(request, response, html.toString() + script2);
            return "";

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
//
//    /**
//     * تابع درج date 1397/11/7
//     *
//     * @param request
//     * @param db
//     * @param isPost
//     * @return
//     * @throws Exception
//     */

    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_condition, jjTools.getParameter(request, _condition));

            map.put(_title, jjTools.getParameter(request, _title));

            map.put(_user_id, jjTools.getParameter(request, _user_id));
            map.put(_discription, jjTools.getParameter(request, _discription));
//            map.put(_date, jjTools.getParameter(request, _date));
            map.put(_comment, request.getParameter("role_comment"));
            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }

                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }

            Server.outPrinter(request, response, Js.jjRole.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
//
//    /**
//     *
//     * @param id
//     */

    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }

                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";
            }
            StringBuilder html1 = new StringBuilder();
            StringBuilder script1 = new StringBuilder();
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }
//            if (id.equals("1")) {
//                String errorMessage = "شما اجازه مشاهده اطلاعات این شخص را ندارید";
//                return Js.dialog(errorMessage) + Js.jjUser.showTbl();
//            }

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, _id + "=" + row.get(0).get(_user_id)));
            ///ایجاد جدول کاربران 
            ///توسط شیران1
            ////
            List<Map<String, Object>> userRows = jjDatabase.separateRow(db.Select(Access_User.tableName, _id + ">5"));

            html1.append("<table class='table display responsive nowrap' id='RefreshlistKarbaranDarSelect'><thead>");
            html1.append("<th width='10%'>کد </th>");

            html1.append("<th width='10%'>نام</th>");

            html1.append("<th width='15%'>نام خانوادگی</th>");
            html1.append("<th width='10%'>ایمیل </th>");
            html1.append("<th width='10%'>مشاهده </th>");
            html1.append("</thead><tbody>");
            for (int i = 0; i < userRows.size(); i++) {
//         
                html1.append("<tr>");

                html1.append("<td class='c'>" + (userRows.get(i).get(Access_User._id)) + "</td>");

                html1.append("<td class='c'>" + (userRows.get(i).get(Access_User._family)) + "</td>");
                html1.append("<td class='c'>" + (userRows.get(i).get(Access_User._name)) + "</td>");
                html1.append("<td class='c'>" + (userRows.get(i).get(Access_User._email)) + "</td>");

                html1.append("<td style='margin:auto;color:blue;font-size: 26px;' class='fa fa-user'  onclick='hmisRole.m_selectKarbar(" + userRows.get(i).get(Access_User._id) + ");' ></td>");
//             
                html1.append("</tr>");
            }
            html1.append("</tbody></table>");

            String script2 = "$('#ListKarbaranDarSelect').html(\"" + html1.toString() + "\");\n";
            script2 += Js.table("#RefreshlistKarbaranDarSelect", "400", 0, "", "لیست کاربران");
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }

                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            html.append(Js.setVal("#role_" + _id, row.get(0).get(_id)));

            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#role_discription", row.get(0).get(_discription)));
            html.append(Js.setVal("#role_family", userRow.get(0).get(Access_User._family)));
            html.append(Js.setVal("#role_name", userRow.get(0).get(Access_User._name)));
            html.append(Js.setVal("#role_email", userRow.get(0).get(Access_User._email)));
            html.append(Js.setValSummerNote("#role_comment", row.get(0).get(_comment)));
//            html.append(Js.setVal("#role_date", row.get(0).get(_date)));
            html.append(Js.setVal("#role_user_id", row.get(0).get(_user_id)));
            html.append(Js.setVal("#role_condition1", "active"));
            html.append(Js.setVal("#role_condition2", "noActive"));
//            html.append(Js.setVal("#role_condition"  , ));
            if (row.get(0).get(_condition).equals("active")) {
//                html.append(Js.setVal("#active", row.get(0).get(_condition)));
                html.append(Js.setAttr("#active", "checked", "checked"));
//                html.append(Js.removeAttr("#noActive", "checked"));
            } else {
//                html.append(Js.setVal("#noActive", row.get(0).get(_condition)));
                html.append(Js.setAttr("#noActive", "checked", "checked"));
            }
//          String condition=row.get(0).get(_condition).toString();
//          String condition2=row.get(0).get(_condition2).toString();
//            html.append(Js.setRadio("#role_condition1" ,condition1 ));
//            html.append(Js.setRadio("#role_condition2" ,condition2 ));

            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);
            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjRole.edit() + "' id='edit_Role'>" + lbl_edit + "</button></div>";
//               
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjRole.delete(id) + "' id='delete_Role'>" + lbl_delete + "</button></div>";
            }
            script1.append(Js.setHtml("#Role_button", htmlBottons));
//            if (accEdt) {
////                if (!id.equals("1")) {
//                html2.append("<div class=\"row\"><div class=\"col-lg-6\"><input type=\"button\" id=\"edit_Role\" value=\"" + lbl_edit + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"></div>");
//                html.append(Js.buttonMouseClick("#edit_Role", Js.jjRole.edit()));
////                }
//            }
//            if (accDel) {
////                if (!id.equals("1")) {
//                html2.append("<div class=\"col-lg-6\"><input type=\"button\" id=\"delete_Role\" value=\"" + lbl_delete + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"  /></div></div>");
//                html.append(Js.buttonMouseClick("#delete_Role", Js.jjRole.delete(id)));
////                }
//            }
            Server.outPrinter(request, response, script1 + html.toString() + script2);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String selectKarbar(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }

                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";
            }

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";

            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

//            html.append(Js.setVal("#role_" + _id, row.get(0).get(_id)));
//            for (int i = 0; i < row.size(); i++) {
            html.append(Js.setVal("#role_user_id", row.get(0).get(Access_User._id)));
            html.append(Js.setVal("#role_name", row.get(0).get(Access_User._name)));
            html.append(Js.setVal("#role_family", row.get(0).get(Access_User._family)));
            html.append(Js.setVal("#role_email", row.get(0).get(Access_User._email)));

//            }
            Server.outPrinter(request, response, html.toString());
            return "";

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }
//

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            System.out.println("jjTools.getParameter(request, _id)=" + jjTools.getParameter(request, _id));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_title, request.getParameter(_title));
            map.put(_condition, jjTools.getParameter(request, _condition));
            map.put(_user_id, request.getParameter(_user_id));
            map.put(_discription, request.getParameter(_discription));
            map.put(_name, request.getParameter(_name));

            map.put(_comment, request.getParameter("role_comment"));

            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.dialog(errorMessageId));
                return "";

            }
            if (!db.update(tableName, map, _id + "=" + jjTools.getParameter(request, _id))) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }

            Server.outPrinter(request, response, Js.jjRole.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";

        }
    }

    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {

            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
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
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";

            }
            Server.outPrinter(request, response, Js.jjRole.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String getUeserRolesSelectOption(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            int userId = jjTools.getSeassionUserId(request);
            StringBuilder optionHtml = new StringBuilder();
            List<Map<String, Object>> userRolesRows = jjDatabase.separateRow(db.Select(tableName, _id + "," + _title, _user_id + "=" + userId, _title));// بر اساس حروف الفبا مرتب باشد بهتر است
            for (int i = 0; i < userRolesRows.size(); i++) {
                if (i == 0) {
                    optionHtml.append("<option  value='").append(userRolesRows.get(i).get(_id)).append("' selected='selected'>").append(userRolesRows.get(i).get(_title)).append("</option>");
                } else {
                    optionHtml.append("<option  value='").append(userRolesRows.get(i).get(_id)).append("'>").append(userRolesRows.get(i).get(_title)).append("</option>");
                }
            }
            String panel = jjTools.getParameter(request, "panel");
            if (panel.isEmpty()) {
                panel = "#forms_ownerRole";
            }
            if (needString) {
                return optionHtml.toString();
            } else {
                Server.outPrinter(request, response, Js.setHtml(panel, optionHtml));
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * این متد نقش ها را بصورت آپشن برای قرار گرفتن در سلکت بر می گرداند
     *
     * @param request panel سلکتور پنل است دقت شود ممکن است نامبر ساین نداشته
     * باشد یا نخواهد
     * @param response
     * @param db
     * @param needString
     * @return بصورت کد جی کوئری و یک سری آپشن برای قرار گرفتن در سلکتی که در
     * پنل معرفی شده
     * @throws Exception
     */
    public static String getSelectOption(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder optionHtml = new StringBuilder();
        try {
            List<Map<String, Object>> rowAllActiveRols = jjDatabase.separateRow(db.Select(tableName, _id + "," + _title, "id>=0", _title));// بر اساس حروف الفبا مرتب باشد بهتر است
            optionHtml.append("<option  value='ALL'>همه مسئولین سازمانی</option>");
            for (int i = 0; i < rowAllActiveRols.size(); i++) {
                optionHtml.append("<option  value='").append(rowAllActiveRols.get(i).get(_id)).append("'>").append(rowAllActiveRols.get(i).get(_title)).append("</option>");
            }
            String panel = jjTools.getParameter(request, "panel");
            if (panel.isEmpty()) {
                panel = ".roleSelectOption";
            }
            Server.outPrinter(request, response, Js.setHtml(panel, optionHtml));
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    /**
     * این متد نقش ها را بصورت آپشن برای قرار گرفتن در سلکت بر می گرداند
     *
     * @param request panel سلکتور پنل است دقت شود ممکن است نامبر ساین نداشته
     * باشد یا نخواهد
     * @param response
     * @param db
     * @param needString
     * @return بصورت کد جی کوئری و یک سری آپشن برای قرار گرفتن در سلکتی که در
     * پنل معرفی شده
     * @throws Exception
     */
    public static String getSelectOptionRequierd(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder optionHtml = new StringBuilder();
        try {
            List<Map<String, Object>> rowAllActiveRols = jjDatabase.separateRow(db.Select(tableName, _id + "," + _title, "id>=0", _title));// بر اساس حروف الفبا مرتب باشد بهتر است
            for (int i = 0; i < rowAllActiveRols.size(); i++) {
                optionHtml.append("<option  value='").append(rowAllActiveRols.get(i).get(_id)).append("'>").append(rowAllActiveRols.get(i).get(_title)).append("</option>");
            }
            String panel = jjTools.getParameter(request, "panel");
            if (panel.isEmpty()) {
                panel = ".roleSelectOption";
            }
            Server.outPrinter(request, response, Js.setHtml(panel, optionHtml));
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
}
