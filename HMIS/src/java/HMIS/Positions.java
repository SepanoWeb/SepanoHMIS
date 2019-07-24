/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import cms.access.Access_User;
import static cms.access.Access_User.rul_ins;
import cms.tools.Js;
import cms.tools.Server;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.swing.table.DefaultTableModel;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;

//import static HMIS.Location._haspitalname;
//import static HMIS.Location._id;
//import static HMIS.Location._level;
//import static HMIS.Location._parent;
//import static HMIS.Location.tableName;
import cms.access.Access_User;
import cms.cms.Content;
import static cms.cms.Product.rul_ins;
import cms.tools.Js;
import cms.tools.Server;
import cms.tools.email;
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
 * @author shiran1 جایگاه ها
 */
public class Positions {

    public static String tableName = "hmis_positions";
    public static String _id = "id";
    public static String _parent = "positions_parent";
//    public static String _title = "DepartmentPosition_title";
    public static String _level = "positions_level";
//    public static String _subcategory = "positions_subcategory";//زیر شاخه بخش
    public static String _user_id = "positions_user_id";//
    public static String _title = "positions_title";//
    public static String _name = "positions_name";//
    public static String _family = "positions_family";//
    public static String _child = "positions_child";//
    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ثبت ویرایش";
    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Department.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            DefaultTableModel dtm = db.Select(Positions.tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>بخش ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisPositions.m_add_new();' >  جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshPositions' dir='rtl'><thead>");
            html.append("<th style='text-align: center;' width='5%'>کد</th>");
//            html.append("<th style='text-align: center;' width='30%'>نام بخش</th>");
            html.append("<th style='text-align: center;' width='20%'>موقعیت</th>");
//            html.append("<th style='text-align: center;' width='10%'></th>");
//            html.append("<th style='text-align: center;' width='30%'></th>");
            html.append("<th style='text-align: center;' width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='hmisPositions.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
                html.append("<td class='tahoma10' style='text-align: center;'>" + (row.get(i).get(_id).toString()) + "</td>");
//                html.append("<td class='tahoma10' style='text-align: left;'>" + (row.get(i).get(_title).toString()) + "</td>");
//              
                html.append("<td class='tahoma10' style='text-align: right;'>" + (row.get(i).get(_title).toString()) + "</td>");

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
                panel = "swPositionsTbl";
            }
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            html2 += Js.table("#refreshPositions", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست بخش ها");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
      public static String selectPositions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {

        try {
//            String id = jjTools.getSessionAttribute(request, "#ID");
//            int userID = jjTools.getSeassionUserId(request);
//            String where = _id + "=" + id ;
            

//        where += " AND " + ;
//            if (db.Select(tableName).getRowCount() != 1) {
//                String errorMessage = "شما اجازه ی دسترسی ندارید.";
//                if (jjTools.isLangEn(request)) {
//                    errorMessage = "Edit Fail;";
//                }
//                Server.outPrinter(request, response, Js.dialog(errorMessage));
//                return "";
//            }

            request.setAttribute("db", db);
            request.getRequestDispatcher("feiz/position.jsp").forward(request, response);

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
        return "";
    }
     /*
     getoptionPositions
     برای در اوردن  زیر شاخه با استفاده از سلکت دیستینگ
     که به ترتیب دخیره درجایگاه نشان داده میشود
     */
    public static String getoptionPositions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
//         StringBuilder optionHtml = new StringBuilder();
//        try {
//            List<Map<String, Object>> rowPosition = jjDatabase.separateRow(db.SelectDistinct(Positions.tableName, _id + "," + Positions._title,Positions. _title));// بر اساس حروف الفبا مرتب باشد بهتر است
//                optionHtml.append("<option  value=''>انتخاب زیر شاخه</option>");
//            for (int i = 0; i < rowPosition.size(); i++) {
//                optionHtml.append("<option  value='").append(rowPosition.get(i).get(_id)).append("'>").append(rowPosition.get(i).get(_title)).append("</option>");
//            }
//            String panel = jjTools.getParameter(request, "panel");
//            if (panel=="") {
//                panel = "positions_parent";
//            }
//            Server.outPrinter(request, response, Js.setVal(panel, optionHtml));
//            return "";
        StringBuilder html = new StringBuilder();
        try {
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            
            html.append("<option  style='color:black;' value=''>انتخاب  زیر شاخه</option>");
            List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectDistinct(Positions.tableName, _id + "," + Positions._title,Positions. _title));
            for (int i = row.size() - 1; i >= 0; i--) {
                html.append("<option value='" + row.get(i).get(_id).toString() + "'"
                        + (row.get(i).get(_title).toString().equals(_title) ? " selected='selected'>" : ">")
                        + row.get(i).get(_title).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            }
            if (panel == "") {
                panel = "positions_parent";
            }
            script += Js.setHtml("#" + panel, html.toString());

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            ///ایجاد جدول کاربران 
            ///توسط شیران1
            List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName));

            html1.append("<table class='table display responsive nowrap' id='RefreshlistKarbaranPositions'><thead>");
            html1.append("<th width='10%'>کد </th>");
            html1.append("<th width='10%'>نام</th>");
            html1.append("<th width='15%'>نام خانوادگی</th>");
            html1.append("<th width='10%'>ایمیل </th>");
            html1.append("<th width='10%'>مشاهده </th>");
            html1.append("</thead><tbody>");
            for (int i = 0; i < userRow.size(); i++) {
                html1.append("<tr>");
                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRow.get(i).get(Access_User._id)) + "</td>");
                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRow.get(i).get(Access_User._family)) + "</td>");
                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRow.get(i).get(Access_User._name)) + "</td>");
                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRow.get(i).get(Access_User._email)) + "</td>");
                html1.append("<td style='text-align: center;color:red;font-size: 26px;' class=''  onclick='hmisPositions.m_selectKarbar(" + userRow.get(i).get(Access_User._id) + ");' ><img src='imgfeyz/icons8-add-48.png' style='width:20%'></td>");
                html1.append("</tr>");
            }
            html1.append("</tbody></table>");
            String script2 = "$('#ListKarbaranPositions').html(\"" + html1.toString() + "\");\n";
            script2 += Js.table("#RefreshlistKarbaranPositions", "400", 0, "", "لیست کاربران");

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);

            if (accIns) {
                html.append(Js.setHtml("#Positions_button", "<div class='col-lg-6'><input type='button' id='insert_Positions_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success active btn-block mg-b-10'></div>"));
                html.append(Js.click("#insert_Positions_new", Js.jjPositions.insert()));
            } else {
                html.append(Js.setHtml("#Positions_button", ""));
            }
//            if (accIns) {
//                html.append(Js.setHtml("#Positions_button", "<div class='row'><div class='col-lg-6'><input type='button' id='insert_Positions_new'  value=\"" + lbl_insert + "\" class='tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget'></div></div>"));
//                html.append(Js.buttonMouseClick("#insert_Positions_new", Js.jjPositions.insert()));
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
            map.put(_family, jjTools.getParameter(request, _family));
            map.put(_name, jjTools.getParameter(request, _name));

            map.put(_title, jjTools.getParameter(request, _title));

            map.put(_user_id, jjTools.getParameter(request, _user_id));
            map.put(_level, jjTools.getParameter(request, _level));
           
//            map.put(_subcategory, jjTools.getParameter(request, _subcategory));
            map.put(_parent, jjTools.getParameter(request, _parent));
            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }

                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }

            Server.outPrinter(request, response, Js.jjPositions.refresh());
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


            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Positions.tableName, _id + "=" + id));
            List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, _id + "=" + row.get(0).get(_user_id)));
            ///ایجاد جدول کاربران 
            ///توسط شیران1
            ////
            List<Map<String, Object>> userRows = jjDatabase.separateRow(db.Select(Access_User.tableName));

            html1.append("<table class='table display responsive nowrap' id='RefreshlistKarbaranDarSelectPositions'><thead>");
            html1.append("<th class='c' width='10%'>کد </th>");

            html1.append("<th class='c' width='10%'>نام</th>");

            html1.append("<th class='c' width='15%'>نام خانوادگی</th>");
            html1.append("<th class='c' width='10%'>ایمیل </th>");
            html1.append("<th class='c' width='10%'>مشاهده </th>");
            html1.append("</thead><tbody>");
            for (int i = 0; i < userRows.size(); i++) {
//         
                html1.append("<tr>");

                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRows.get(i).get(Access_User._id)) + "</td>");

                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRows.get(i).get(Access_User._family)) + "</td>");
                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRows.get(i).get(Access_User._name)) + "</td>");
                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRows.get(i).get(Access_User._email)) + "</td>");

                html1.append("<td style='margin:auto;color:blue;font-size: 26px;text-align: center;'   onclick='hmisPositions.m_selectKarbar(" + userRows.get(i).get(Access_User._id) + ");' ><img src='imgfeyz/icons8-add-48.png' style='width:20%;margin:auto'></td>");
//             
                html1.append("</tr>");
            }
            html1.append("</tbody></table>");

            String script2 = "$('#ListKarbaranDarSelectPositions').html(\"" + html1.toString() + "\");\n";
            script2 += Js.table("#RefreshlistKarbaranDarSelectPositions", "400", 0, "", "لیست کاربران");
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

            html.append(Js.setVal("#positions_" + _id, row.get(0).get(_id)));
//            html.append(Js.setVal("#"+_subcategory , row.get(0).get(_subcategory)));
            html.append(Js.setVal("#"+_level , row.get(0).get(_level)));
//            html.append(Js.setVal("#positions_title" , row.get(0).get(_title)));

            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#" + _parent, row.get(0).get(_parent)));
           
            html.append(Js.setVal("#positions_family", userRow.get(0).get(Access_User._family)));
            html.append(Js.setVal("#positions_name", userRow.get(0).get(Access_User._name)));
            
            html.append(Js.setVal("#positions_user_id", row.get(0).get(_user_id)));


            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);
            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjPositions.edit() + "' id='edit_Positions'>" + lbl_edit + "</button></div>";
//               
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjPositions.delete(id) + "' id='delete_Positions'>" + lbl_delete + "</button></div>";
            }
            script1.append(Js.setHtml("#Positions_button", htmlBottons));
//            if (accEdt) {
////                if (!id.equals("1")) {
//                html2.append("<div class=\"row\"><div class=\"col-lg-6\"><input type=\"button\" id=\"edit_Positions\" value=\"" + lbl_edit + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"></div>");
//                html.append(Js.buttonMouseClick("#edit_Positions", Js.jjPositions.edit()));
////                }
//            }
//            if (accDel) {
////                if (!id.equals("1")) {
//                html2.append("<div class=\"col-lg-6\"><input type=\"button\" id=\"delete_Positions\" value=\"" + lbl_delete + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"  /></div></div>");
//                html.append(Js.buttonMouseClick("#delete_Positions", Js.jjPositions.delete(id)));
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
            html.append(Js.setVal("#positions_user_id", row.get(0).get(Access_User._id)));
            html.append(Js.setVal("#positions_name", row.get(0).get(Access_User._name)));
            html.append(Js.setVal("#positions_family", row.get(0).get(Access_User._family)));
//            html.append(Js.setVal("#role_email", row.get(0).get(Access_User._email)));

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
           

       
            map.put(_family, jjTools.getParameter(request, _family));
            map.put(_name, jjTools.getParameter(request, _name));

            map.put(_title, jjTools.getParameter(request, _title));

            map.put(_user_id, jjTools.getParameter(request, _user_id));
            map.put(_level, jjTools.getParameter(request, _level));
//            map.put(_subcategory, jjTools.getParameter(request, _subcategory));
            map.put(_parent, jjTools.getParameter(request, _parent));
            map.put(_level, jjTools.getParameter(request, _level));

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

            Server.outPrinter(request, response, Js.jjPositions.refresh());
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
            Server.outPrinter(request, response, Js.jjPositions.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

}
