/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import static HMIS.Department.lbl_insert;
import static HMIS.Department.rul_ins;
import cms.access.Access_User;
import cms.tools.Js;
import cms.tools.Server;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.swing.table.DefaultTableModel;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;
import static HMIS.DepartmentPosition._id;
import static HMIS.DepartmentPosition._level;
import static HMIS.DepartmentPosition.rul_ins;
import static HMIS.Forms._icon;
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
 * @author شیران1 تابع نوشته شده برای پیام ها
 */
public class Messenger {

    public static String tableName = "Messenger";
    public static String _id = "id";
    public static String _title = "messenger_title";///عنوان پیام
    public static String _textMessage = "messenger_textMessage";///متن پیام
    public static String _receiver = "messenger_receiver";//گیرنده پیام
    public static String _sender = "messenger_sender";//فرستنده پیام
    public static String _postageDate = "messenger_postageDate";///تاریخ ارسال
    public static String _dateOfCreation = "messenger_dateOfCreation";///تاریخ ایجاد
    public static String _displayed = "messenger_displayed";///دیده شده
    public static String _status = "messenger_status";///وضعیت پیام
    public static String _email = "messenger_email";///ایمیل
    public static String _sendingMethod = "messenger_sendingMethod";///روش ارسال
//    public static String _statusTrend = "messenger_statusTrend";///وضعیت پیام روند

    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";

    public static int rul_rfs_karshenas = 0;//برای اینکه تشخیص دهیم کاربر مجوز دیدن پیامهای کارشناس را دارد یا نه
    public static int rul_rfs = 0;
    public static int rul_dlt = 0;
    public static int rul_edt = 0;
    public static int rul_senEmail = 0;
    public static int rul_print = 0;
    public static int rul_ins = 0;

    public static String refresh(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        String id = jjTools.getParameter(request, _id);
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();
//            String where = _receiver + "=" + jjTools.getSessionAttribute(request, "#ID");
//            
//            //برای تشخیص دسترسی کارشناس
//            String hasAccessPayamhayeKarshenas = Access_User.getAccessDialog(request, db, rul_rfs_karshenas);
//            if (hasAccessPayamhayeKarshenas.equals("")) {
//                where += " OR " +  _receiver + "=0";
//            }
////                      + " OR " + _frestande + " =" + jjTools.getSessionAttribute(request, "#ID");
//            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, where));
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName));

            StringBuilder html3 = new StringBuilder();

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>پیام ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisMessenger.m_add_new();' > پیام جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshMessenger' dir='rtl'><thead>");

            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>ارسال در</th>");
//            html.append("<th width='10%'>نام </th>");
//            html.append("<th width='15%'>عنوان</th>");
            html.append("<th width='15%'>متن پیام</th>");
//            html.append("<th width='10%'>گیرنده</th>");
//            html.append("<th width='10%'>فرستنده</th>");
            html.append("<th width='5%'>عملیات</th>");
//       
            boolean accDel = Access_User.hasAccess2(request, db, rul_dlt);
            if (accDel) {
                html.append("<th width='5%'>حذف</th>");
            }
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                String dideshode = row.get(i).get(_displayed).toString().equals("10000000") ? "dideNashode" : "";
                //اگر دیده شده خالی بود سطر بلد شودکلاس دیده نشده صدا زده شود در پابلیک استایل سی اس اس در غیر این صورت نال شود
//                html.append("<tr " ) + "'>");    
//                List<Map<String, Object>> GirandeRow = jjDatabaseWeb.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + row.get(i).get(_receiver)));
//                List<Map<String, Object>> FrestandeRow = jjDatabaseWeb.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + row.get(i).get(_sender)));
                html.append("<tr class='mousePointer" + " " + dideshode + "'>");
                html.append("<td style='text-align:center' class='c'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td style='text-align:center' class='c'>" + row.get(i).get(_postageDate).toString() + "</td>");

//                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_textMessage).toString()) + "</td>");
//                html.append("<td style='text-align:center' class='r'>" + (GirandeRow.get(0).get(Access_User._name).toString()) + " " + (GirandeRow.get(0).get(Access_User._family).toString()) + "</td>");
//                html.append("<td style='text-align:center' class='r'>" + (FrestandeRow.get(0).get(Access_User._name).toString()) + " " + (FrestandeRow.get(0).get(Access_User._family).toString()) + "</td>");

                html.append("<td class='icon ion-ios-gear-outline' onclick='hmisMessenger.m_select(" + row.get(i).get(_id) + ");'></td>");
//                html.append("<td class='c mousePointer' onclick='printPayamha(" + row.get(i).get(_id) + ");'><img src='img/3.png' style='height:30px'/></td>");
                if (accDel) {
                    html.append("<td class='c mousePointer' onclick='hmisMessenger.m_delete(" + row.get(i).get(_id) + ");'><img src='img/3.png' style='height:30px'/></td>");
                }
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swMessengerTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshMessenger", height, 0, "", "لیست پیام ها");

//       
            return html2;
        } catch (Exception e) {
            return Server.ErrorHandler(e);
        }
    }

    public static String add_new(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        StringBuilder html = new StringBuilder();
        StringBuilder script = new StringBuilder();
        try {
//           script.append("hmisDepartment.selectOptionDepartment();");
            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Messenger_button", "<div class='row'><div class='col-lg-6'><input type='button' id='insert_Messenger_new'  value=\"" + lbl_insert + "\" class='tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget'></div></div>"));
                html.append(Js.buttonMouseClick("#insert_Messenger_new", Js.jjMessenger.insert()));
            }
            return html.toString() + script;
        } catch (Exception e) {
            return Server.ErrorHandler(e);
        }
    }

    /**
     * تابع درج date 1397/12/19 shiran1
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

            Map<String, Object> map = new HashMap<String, Object>();

            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_textMessage, jjTools.getParameter(request, _textMessage));
            map.put(_receiver, jjTools.getParameter(request, _receiver));
            map.put(_sender, jjTools.getParameter(request, _sender));
            map.put(_dateOfCreation, jjTools.getParameter(request, _dateOfCreation));
            map.put(_postageDate, jjTools.getParameter(request, _postageDate));
            map.put(_displayed, jjTools.getParameter(request, _displayed));

            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjMessenger.refresh();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * shiran1
     *
     * @param id
     */
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
            StringBuilder script = new StringBuilder();

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
//            if (row.isEmpty()) {
//                String errorMessage = "رکوردی با این کد وجود ندارد.";
//                if (jjTools.isLangEn(request)) {
//                    errorMessage = "Select Fail;";
//                }
//                return Js.dialog(errorMessage);
//            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            script.append(Js.setVal("#messenger_" + _id, row.get(0).get(_id)));

            script.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            script.append(Js.setVal("#" + _textMessage, row.get(0).get(_textMessage)));
            script.append(Js.setVal("#" + _receiver, row.get(0).get(_receiver)));
            script.append(Js.setVal("#" + _sender, row.get(0).get(_sender)));
            script.append(Js.setVal("#" + _dateOfCreation, row.get(0).get(_dateOfCreation)));
            script.append(Js.setVal("#" + _postageDate, row.get(0).get(_postageDate)));

            boolean accDel = Access_User.hasAccess2(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess2(request, db, rul_edt);

            if (accEdt) {
//                if (!id.equals("1")) {
                html2.append("<div class=\"row\"><div class=\"col-lg-6\"><input type=\"button\" id=\"edit_Messenger\" value=\"" + lbl_edit + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"/></div>");
                html.append(Js.buttonMouseClick("#edit_Messenger", Js.jjMessenger.edit()));
//                }
            }
            if (accDel) {
//                if (!id.equals("1")) {
                html2.append("<div class=\"col-lg-6\"><input type=\"button\" id=\"delete_Messenger\" value=\"" + lbl_delete + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"  /></div></div>");
                html.append(Js.buttonMouseClick("#delete_Messenger", Js.jjMessenger.delete(id)));
//                }
            }
            return (Js.setHtml("#Messenger_button", html2.toString())) + html.toString() + script;
        } catch (Exception e) {
            return Server.ErrorHandler(e);
        }
    }

    public static String edit(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            String id = jjTools.getParameter(request, _id);
//           
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_textMessage, jjTools.getParameter(request, _textMessage));
            map.put(_receiver, jjTools.getParameter(request, _receiver));
            map.put(_sender, jjTools.getParameter(request, _sender));
            map.put(_dateOfCreation, jjTools.getParameter(request, _dateOfCreation));
            map.put(_postageDate, jjTools.getParameter(request, _postageDate));

//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }
            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
//            return Js.jjDepartment.refresh();
            return "";
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String delete(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            Content.catchProductTitle = null;
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

            return Js.jjMessenger.refresh();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }

    }

    //     * 
    /**
     * ارسال پیام 
     *
     * @param db
     * @param receiver//گیرنده
     * @param sender //فرستنده که ای دی0 است
     * @param sendingMethod//روش ارسال پیام
     * @param postageDate//تاریخ ارسال
     * @param textMessage//متن پیام
     * @return
     */
    public static String sendMesseage(jjDatabaseWeb db, String receiver, String sender, String sendingMethod, String postageDate, String textMessage) {
        Map<String, Object> map = new HashMap<>();

     
        String receiverMessage = receiver;
        //این تابع برای دریافت گیرنده ها نوشته شده 
        ///شیران1
        String[] receiverMessageArray = receiverMessage.split("%23A%23");//آی دی نویسنده ها با این رشته از هم جدا می شود
        for (int j = 0; j < receiverMessageArray.length; j++) {

            List<Map<String, Object>> userRow = jjDatabaseWeb.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + receiverMessageArray[j]));//در ستون نویسندگان آی دی نویسنده ها قرار دارد                  
            for (int i = 0; i < userRow.size(); i++) {
                map.put(_receiver, receiverMessageArray[j]);
                map.put(_sender,sender );
                map.put(_sendingMethod,sendingMethod );
                map.put(_postageDate,postageDate );

                map.put(_textMessage, textMessage);
//        map.put(_postageDate, jjCalendar_IR.getDatabaseFormat_8length(null, true));
//                    html7.append(" " + userRow.get(0).get(_nam) + " " + userRow.get(0).get(_family) + "/");
            }
//                script7 = Js.setVal("#darkhastha_pishnahadkargroh", html7);
        }

        if (db.insert(tableName, map).getRowCount() > 0) {
            return "";
        }
        return "ارسال پیام با خطایی مواجه شده است";
    }

    public static String ersalPayamBaEmail(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {

            String email = jjTools.getParameter(request, _email);
//           Js.dialog(a)

            String Email = jjTools.getParameter(request, "email");

            List<Map<String, Object>> emailRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._email + "='" + Email + "'"));

            StringBuilder html = new StringBuilder();
            StringBuilder script = new StringBuilder();

            if (Server.sendEmail("sepanoweb@gmail.com", Email, "پیام های ارسال شده", "", true, request)) {

                return "alert('ایمیل ارسال شد');";
            }

            return "alert('ایمیل ارسال نشد');";

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

}
