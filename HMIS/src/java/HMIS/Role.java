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
import javax.swing.table.DefaultTableModel;
import jj.jjCalendar_IR;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Shiran1
 * نقش ها
 */
public class Role {

    public static String tableName = "Role";
    public static String _id = "id";
   
    public static String _title = "role_title";
    public static String _date = "role_date";
    public static String _user_id = "role_user_id";//
    public static String _condition = "role_condition";//
    public static String _comment = "role_comment";//


    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";

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
    public static String refresh(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Role.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            DefaultTableModel dtm = db.Select(Role.tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>نقش ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisRole.m_add_new();' > نقش جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshParts' dir='rtl'><thead>");
            html.append("<th style='text-align: center;' width='5%'>کد</th>");
            html.append("<th style='text-align: center;' width='30%'>عنوان</th>");
            html.append("<th style='text-align: center;' width='20%'>وضعیت</th>");

            html.append("<th style='text-align: center;' width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='hmisRole.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
                html.append("<td class='tahoma10' style='text-align: center;'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td class='tahoma10' style='text-align: left;'>" + (row.get(i).get(_title).toString()) + "</td>");
//              
                html.append("<td class='tahoma10' style='text-align: right;'>" + (row.get(i).get(_condition).toString()) + "</td>");

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
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            html2 += Js.table("#refreshRole", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست نقش ها");
            return html2;
        } catch (Exception e) {
            return Server.ErrorHandler(e);
        }
    }

    
    public static String add_new(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
        StringBuilder html = new StringBuilder();
        StringBuilder html1 = new StringBuilder();
            ///ایجاد جدول کاربران 
            ///توسط شیران1
            List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName ));
       
            html1.append("<table class='table display responsive nowrap' id='RefreshlistKarbaran'><thead>");
            html1.append("<th width='10%'>کد </th>");

            html1.append("<th width='10%'>نام</th>");

            html1.append("<th width='15%'>نام خانوادگی</th>");  
            html1.append("<th width='10%'>ایمیل </th>");
            html1.append("<th width='10%'>مشاهده اطلاعات اثر</th>");
            html1.append("</thead><tbody>");
            for (int i = 0; i < userRow.size(); i++) {
//         
                html1.append("<tr>");
                
                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRow.get(i).get(Access_User._id)) + "</td>");

                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRow.get(i).get(Access_User._family)) + "</td>");
                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRow.get(i).get(Access_User._name)) + "</td>");
                html1.append("<td class='tahoma10' style='text-align: center;'>" + (userRow.get(i).get(Access_User._email)) + "</td>");


                html1.append("<td style='text-align: center;color:red;font-size: 26px;' class='icon ion-ios-gear-outline'  onclick='hmisRole.m_selectKarbar(" + userRow.get(i).get(Access_User._id) + ");' ></td>");
//             
                html1.append("</tr>");
            }
            html1.append("</tbody></table>");

            String script2 = "$('#ListKarbaran').html(\"" + html1.toString() + "\");\n";
            script2 += Js.table("#RefreshlistKarbaran", "400", 0, "", "لیست کاربران");
            
            
            
            
            
            
            
            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Role_button", "<div class='row'><div class='col-lg-6'><input type='button' id='insert_Role_new'  value=\"" + lbl_insert + "\" class='tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget'></div></div>"));
                html.append(Js.buttonMouseClick("#insert_Role_new", Js.jjRole.insert()));
            }
            return html.toString()+script2;
        } catch (Exception e) {
            return Server.ErrorHandler(e);
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
    public static String insert(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }

            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_condition, jjTools.getParameter(request, _condition));

            map.put(_title, jjTools.getParameter(request, _title));

            map.put(_user_id, jjTools.getParameter(request, _user_id));
            map.put(_comment, jjTools.getParameter(request, _comment));
            map.put(_date, jjTools.getParameter(request, _date));

            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjPlans.refresh();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
//
//    /**
//     *
//     * @param id
//     */
    public static String select(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }

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
            List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            html.append(Js.setVal("#role_" + _id, row.get(0).get(_id)));

            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#role_family"  , userRow.get(0).get(Access_User._family)));
            html.append(Js.setVal("#role_name"  , userRow.get(0).get(Access_User._name)));
            html.append(Js.setVal("#role_email"  , userRow.get(0).get(Access_User._email)));
            html.append(Js.setVal("#role_comment"  , row.get(0).get(_comment)));
            html.append(Js.setVal("#role_date"  , row.get(0).get(_date)));
          String condition=row.get(0).get(_condition).toString();
            html.append(Js.setRadio("#role_condition1" ,condition ));
            html.append(Js.setRadio("#role_condition2" ,condition ));

         


            boolean accDel = Access_User.hasAccess2(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess2(request, db, rul_edt);

            if (accEdt) {
//                if (!id.equals("1")) {
                html2.append("<div class=\"row\"><div class=\"col-lg-6\"><input type=\"button\" id=\"edit_Role\" value=\"" + lbl_edit + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"></div>");
                html.append(Js.buttonMouseClick("#edit_Role", Js.jjRole.edit()));
//                }
            }
            if (accDel) {
//                if (!id.equals("1")) {
                html2.append("<div class=\"col-lg-6\"><input type=\"button\" id=\"delete_Role\" value=\"" + lbl_delete + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"  /></div></div>");
                html.append(Js.buttonMouseClick("#delete_Role", Js.jjRole.delete(id)));
//                }
            }
            return (Js.setHtml("#Role_button", html2.toString())) + html.toString() ;
        } catch (Exception e) {
            return Server.ErrorHandler(e);
        }
    }
    public static String selectKarbar(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }


            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Access_User.tableName,Access_User._id+"="+id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

//            html.append(Js.setVal("#role_" + _id, row.get(0).get(_id)));
//            for (int i = 0; i < row.size(); i++) {
            html.append(Js.setVal("#role_user_id" , row.get(0).get(Access_User._id)));
            html.append(Js.setVal("#role_name" , row.get(0).get(Access_User._name)));
            html.append(Js.setVal("#role_family" , row.get(0).get(Access_User._family)));
            html.append(Js.setVal("#role_email" , row.get(0).get(Access_User._email)));


//            }
          
            return  html.toString();
        } catch (Exception e) {
            return Server.ErrorHandler(e);
        }
    }
//
    public static String edit(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }

            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_title, request.getParameter(_title));
            map.put(_condition, request.getParameter(_condition));
            map.put(_user_id, request.getParameter(_user_id));
            map.put(_comment, jjTools.getParameter(request, _comment));
//             map.put(_date, new jjCalendar_IR().getDBFormat_8length());
            map.put(_date, jjTools.getParameter(request, _date));


            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }
            if (!db.update(tableName, map, _id + "=" + jjTools.getParameter(request, _id))) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjRole.refresh();
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
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }

            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                return Js.dialog(errorMessage);
            }

            return Js.jjRole.refresh();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
}

