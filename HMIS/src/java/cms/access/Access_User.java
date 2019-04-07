package cms.access;

import HMIS.Role;
import cms.cms.*;
import cms.tools.*;
import java.io.IOException;
import jj.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;

public class Access_User {

    public static String tableName = "access_user";
    public static String _id = "id";
    public static String _pass = "user_pass";
    public static String _name = "user_name";
    public static String _family = "user_family";
    public static String _email = "user_email";
    public static String _passHint = "user_password_hint";//====== BY RASHIDI ======
    public static String _mobile = "user_mobile";
    public static String _phone = "user_phone";
    public static String _AccountInformation = "user_AccountInformation";
    public static String _jensiat = "user_jensiat";
    public static String _codeMeli = "user_codeMeli";
    public static String _shomareShenasname = "user_shomareShenasname";
    public static String _passwordReminder = "user_passwordReminder";
    public static String _grade = "user_grade";
    ////برای عکس پرسنلی  
    ///توسط شیران1
    public static String _attachAxPersonal = "user_attachAxPersonal";
    ////برای عکس کارت پرسنلی  
    ///توسط شیران1
    public static String _attachAxPersonnelCard = "user_attachAxPersonnelCard";
    ////برای عکس امضا  
    ///توسط شیران1
    public static String _attachAxSignature = "user_attachAxSignature";

    public static String _address = "user_address";
    public static String _isActive = "user_is_active";
    public static String _registDate = "user_createDate";
    public static String _question = "user_question";
    public static String _answer = "user_answer";
    public static String _birthdate = "user_birthdate";
    public static String _no1 = "user_no1";
    public static String _no2 = "user_no2";
    public static String _parent = "user_parent";
    public static String _weblog = "user_weblog";
    public static String _address2 = "user_address2";
    public static String _postalCode = "user_postalCode";
    public static String _file_personal = "user_file_personal";
    public static String _file_Signature = "user_file_Signature";
    public static String _upload_file = "user_upload_file";
    public static String _attachFile = "user_attachFile";
    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";
    public static String lbl_add_en = "افزودن زبان انگلیسی";
    public static String lbl_edit_en = "ویرایش بخش انگلیسی";
    public static String noAccessFa = "شما اجازه دسترسی ندارید.";
    public static String noAccessEn = "You don't have access.";
    public static String _char1 = "user_char1";//ذخیره سازی آدرس
    public static String _char2 = "user_char2";
    public static String _char3 = "user_char3";
    public static String _int1 = "user_int1";
    public static String _int2 = "user_int2";
    public static String _int3 = "user_int3";
//    public static int rul_rfs = 15;
//    public static int rul_ins = 16;
//    public static int rul_edt = 17;
//    public static int rul_dlt = 18;

//   public static int rul_show_acc = 281;//نمایش تب دسترسی
////    public static int rul_show_acc _reserved= 282 --- 300;// RESERVED : 282 -- 300//نمایش تب دسترسی
    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;
////    public static int rul_reserved = 305 --- 320;// RESERVED : 305 -- 320
    public static String wikiLinkColor = "blue";

    /**
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            DefaultTableModel dtm = db.Select(tableName, _id + "<>1");
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>کاربران</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='cmsUser.m_add_new();' > کاربر جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshAccessUser' dir='rtl'><thead>");
            html.append("<th style='text-align: center;' width='5%'>کد</th>");
            html.append("<th style='text-align: center;' width='30%'>ایمیل</th>");
            html.append("<th style='text-align: center;' width='20%'>تاریخ تولد</th>");
            html.append("<th style='text-align: center;' width='10%'>نام کاربری</th>");
            html.append("<th style='text-align: center;' width='30%'>نام و نام خانوادگی</th>");
            html.append("<th style='text-align: center;' width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='cmsUser.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
                html.append("<td class='tahoma10' style='text-align: center;'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td class='tahoma10' style='text-align: left;'>" + (row.get(i).get(_email).toString()) + "</td>");
                html.append("<td class='tahoma10' style='text-align: center;'>" + (jjCalendar_IR.getViewFormat(row.get(i).get(_birthdate))) + "</td>");
                html.append("<td class='tahoma10' style='text-align: right;'>" + (row.get(i).get(_name).toString()) + "</td>");
                html.append("<td class='tahoma10' style='text-align: right;'>" + (row.get(i).get(_family).toString()) + "</td>");
                html.append("<td style='text-align: center;color:red;font-size: 26px;' class='icon ion-ios-gear-outline'><a src='img/l.png' style='cursor: pointer;height:30px' onclick='cmsUser.m_select(" + row.get(i).get(_id) + ");' ></a></td>");
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
                panel = "swUserTbl";
            }
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            html2 += Js.table("#refreshAccessUser", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "15" : "", "لیست کاربران");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#User_button", "<div class='row'><div class='col-lg-6'><input type=\"button\" id=\"insert_User_new\" value=\"" + lbl_insert + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"></div></div>"));
                html.append(Js.buttonMouseClick("#insert_User_new", Js.jjUser.insert()));
            }
            Server.outPrinter(request, response, html.toString());
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {

            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            String email = jjTools.getParameter(request, _email);
//            String message = isValidMessageForRegist(request, db, isPost);
//            if (!message.equals("")) {
//                Server.outPrinter(request, response, Js.dialog(message);
//            }
//            int size = jjDatabase.separateRow(db.Select(tableName, _email + "='" + jjTools.getParameter(request, _email).toLowerCase() + "'")).size();
//            if (size > 0) {
//                String errorMessage = "کاربری با این ایمیل در دیتابیس وجود دارد.";
//                if (jjTools.getParameter(request, "myLang").equals("2")) {
//                    errorMessage = "This email is being in database.";
//                }
//                Server.outPrinter(request, response, Js.dialog(errorMessage);
//            }
            Map<String, Object> map = new HashMap<String, Object>();

           
            map.put(_attachAxPersonal, jjTools.getParameter(request, _attachAxPersonal));
            map.put(_attachAxPersonnelCard, jjTools.getParameter(request, _attachAxPersonnelCard));
            map.put(_attachAxSignature, jjTools.getParameter(request, _attachAxSignature));
            map.put(_email, email.toLowerCase());
            map.put(_family, jjTools.getParameter(request, _family));
            map.put(_AccountInformation, jjTools.getParameter(request, _AccountInformation));

            map.put(_passwordReminder, jjTools.getParameter(request, _passwordReminder));
            map.put(_grade, jjTools.getParameter(request, _grade));
            map.put(_jensiat, jjTools.getParameter(request, _jensiat));
            map.put(_codeMeli, jjTools.getParameter(request, _codeMeli));
            map.put(_shomareShenasname, jjTools.getParameter(request, _shomareShenasname));

            map.put(_name, jjTools.getParameter(request, _name));

            map.put(_pass, jjTools.getParameter(request, _pass));

            map.put(_address, jjTools.getParameter(request, _address));
//           
            map.put(_birthdate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _birthdate), false));
            List<Map<String, Object>> row = jjDatabase.separateRow(db.insert(tableName, map));
            if (row.isEmpty()) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.getParameter(request, "myLang").equals("2")) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }

            // =========================
//            Map<String, Object> map2 = new HashMap<>();
//            map2.put(Access_Group_User._user_id, Integer.parseInt(row.get(0).get(_id).toString()));
//            for (int i = 1; i < Access_Group.chkNumber; i++) {
//                String chk = jjTools.getParameter(request, "chk" + i);
//                if (chk.equals("1")) {
//                    map2.put(Access_Group_User._group_id, i);
//                    db.insert(Access_Group_User.tableName, map2);
//                }
//            }
            // =========================
            Server.outPrinter(request, response, Js.jjUser.refresh());
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String isValidMessageForRegist(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
//        String doAct = jjTools.getParameter(request, "do").toLowerCase();
        try {

            String email = jjTools.getParameter(request, _email).toLowerCase();
            String pass = jjTools.getParameter(request, _pass).toLowerCase();
            String mobile = jjTools.getParameter(request, _mobile).toLowerCase();

            //============ BY RASHIDI ========>
            // ------------- check email or mobile are not empty -------------------
            if (email.equals("") && mobile.equals("")) {
                String errorMsg = "وارد کردن ایمیل و یا شماره موبایل الزامیست";
                if (jjTools.isLangEn(request)) {
                    errorMsg = "Enter phone number or email address";
                }
                Server.outPrinter(request, response, errorMsg);
                return "";
            }
            //<============ BY RASHIDI ========
            // ------------- check valid email -------------------
            if ((!email.equals("") && mobile.equals("")) || (!email.equals("") && !mobile.equals(""))) {//====== BY RASHIDI ======
                String lengthMinMessageEmail = jjValidation.isEmailMessageFa(email, "ایمیل");
                if (!lengthMinMessageEmail.equals("")) {
                    if (jjTools.isLangEn(request)) {
                        lengthMinMessageEmail = jjValidation.isEmailMessageEn(email, "Email");
                    }
                    Server.outPrinter(request, response, (lengthMinMessageEmail));
                    return "";
                }
            }
            // ------------- check name is not empty -------------------
            String reqName = jjValidation.isFillMessageFa(jjTools.getParameter(request, _name), "نام");
            if (!reqName.equals("")) {
                if (jjTools.isLangEn(request)) {
                    reqName = jjValidation.isFillMessageEn(jjTools.getParameter(request, _name), "name");
                }
                Server.outPrinter(request, response, reqName);
                return "";
            }

            // ------------- check family is not empty -------------------
            String reqfamily = jjValidation.isFillMessageFa(jjTools.getParameter(request, _family), "نام خانوادگی");
            if (!reqfamily.equals("")) {
                if (jjTools.isLangEn(request)) {
                    reqfamily = jjValidation.isFillMessageEn(jjTools.getParameter(request, _name), "family");
                }
                Server.outPrinter(request, response, reqfamily);
                return "";
            }
            // ------------- check password is not empty -------------------

            String lengthMinMessagePassword = jjValidation.isLengthMinMessageFa(pass, 1, "رمز عبور");
            if (!lengthMinMessagePassword.equals("")) {
                if (jjTools.isLangEn(request)) {
                    lengthMinMessagePassword = jjValidation.isLengthMinMessageEn(pass, 1, "Password");
                }
                Server.outPrinter(request, response, (lengthMinMessagePassword));
                return "";
            }

            // ------------- check passwordHint is not empty -------------------
            String reqAnswer = jjValidation.isFillMessageFa(jjTools.getParameter(request, _passHint), "یادآور گذرواژه");
            if (!reqAnswer.equals("")) {
                if (jjTools.isLangEn(request)) {
                    reqAnswer = jjValidation.isFillMessageEn(jjTools.getParameter(request, _passHint), "password hint");
                }
                Server.outPrinter(request, response, reqAnswer);
                return "";
            }
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
        Server.outPrinter(request, response, "");
        return "";
    }

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
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
                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";
            }

            String email = jjTools.getParameter(request, _email);

            Map<String, Object> map = new HashMap<String, Object>();

            map.put(_email, email.toLowerCase());
            map.put(_family, jjTools.getParameter(request, _family));
            map.put(_isActive, jjTools.getParameter(request, _isActive).equals("1"));
            map.put(_name, jjTools.getParameter(request, _name));
            map.put(_attachFile, jjTools.getParameter(request, _attachFile));
            map.put(_attachAxPersonal, jjTools.getParameter(request, _attachAxPersonal));
            map.put(_attachAxPersonnelCard, jjTools.getParameter(request, _attachAxPersonnelCard));
            map.put(_attachAxSignature, jjTools.getParameter(request, _attachAxSignature));
            map.put(_AccountInformation, jjTools.getParameter(request, _AccountInformation));
            map.put(_grade, jjTools.getParameter(request, _grade));
            map.put(_passwordReminder, jjTools.getParameter(request, _passwordReminder));
            map.put(_jensiat, jjTools.getParameter(request, _jensiat));
            map.put(_codeMeli, jjTools.getParameter(request, _codeMeli));
            map.put(_shomareShenasname, jjTools.getParameter(request, _shomareShenasname));
            map.put(_address, jjTools.getParameter(request, _address));
//             map.put(_file_personal, jjTools.getParameter(request, _file_personal));
//            map.put(_file_Signature, jjTools.getParameter(request, _file_Signature));
//            map.put(_upload_file, jjTools.getParameter(request, _upload_file));

//            map.put(_file_personal, jjTools.getParameter(request, _));
//            String parent = jjTools.getParameter(request, _parent);
//            map.put(_parent, jjNumber.isDigit(parent) ? Integer.parseInt(parent) : 0);
            map.put(_pass, jjTools.getParameter(request, _pass).toLowerCase());
//            map.put(_question, jjTools.getParameter(request, _question));
            map.put(_birthdate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _birthdate), false));

            if (id.equals("1")) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            if (!db.update(tableName, map, _id + "=" + jjTools.getParameter(request, _id))) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }

            // =========================
            db.delete(Access_Group_User.tableName, Access_Group_User._user_id + "=" + id);

            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put(Access_Group_User._user_id, Integer.parseInt(id));

            for (int i = 1; i < Access_Group.chkNumber; i++) {
                String chk = jjTools.getParameter(request, "chk" + i);
                if (chk.equals("1")) {
                    map2.put(Access_Group_User._group_id, i);
                    db.insert(Access_Group_User.tableName, map2);
                }
            }
            // =========================
            Server.outPrinter(request, response, Js.jjUser.refresh());
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    /**
     *
     * @param id
     */
    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {

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
            if (id.equals("1")) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            Server.outPrinter(request, response, Js.jjUser.refresh());
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
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

            if (id.equals("1")) {
                String errorMessage = "شما اجازه مشاهده اطلاعات این شخص را ندارید";
                Server.outPrinter(request, response, Js.dialog(errorMessage) + Js.jjUser.showTbl());
                return "";
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            html.append(Js.setVal("#access_user_id", row.get(0).get(_id)));
//            html.append(Js.setVal("#" + _answer, row.get(0).get(_answer)));
            html.append(Js.setVal("#user_emailUser", row.get(0).get(_email)));
            html.append(Js.setVal("#user_familyUser", row.get(0).get(_family)));
//            html.append(Js.setVal("#" + _isActive, row.get(0).get(_isActive)));
            html.append(Js.setVal("#user_nameUser", row.get(0).get(_name)));
            html.append(Js.setVal("#user_AccountInformationUser", row.get(0).get(_AccountInformation)));

            html.append(Js.setVal("#user_birthdateUser", row.get(0).get(_birthdate)));
            html.append(Js.setVal("#user_gradeUser", row.get(0).get(_grade)));
            html.append(Js.setVal("#user_jensiatUser", row.get(0).get(_jensiat)));
            html.append(Js.setVal("#user_codeMeliUser", row.get(0).get(_codeMeli)));
            html.append(Js.setVal("#user_shomareShenasnameUser", row.get(0).get(_shomareShenasname)));
            html.append(Js.setVal("#user_passUser", row.get(0).get(_pass)));
            html.append(Js.setVal("#user_passwordReminderUser", row.get(0).get(_passwordReminder)));
            html.append(Js.setVal("#user_attachAxPersonnelCard", row.get(0).get(_attachAxPersonnelCard)));
            html.append(Js.setVal("#user_attachAxPersonal", row.get(0).get(_attachAxPersonal)));
            html.append(Js.setVal("#user_attachAxSignature", row.get(0).get(_attachAxSignature)));


//            html.append(Js.setHtml("#user_pic1", row.get(0).get(_attachAxPersonal)));
//            html.append(Js.setHtml("#user_pic3", row.get(0).get(_attachAxPersonnelCard)));
//            html.append(Js.setHtml("#user_pic2", row.get(0).get(_attachAxSignature)));
            html.append(Js.setVal("#user_attachFile", row.get(0).get(_attachFile)));
            String attachFiles = row.get(0).get(_attachFile).toString();

            String[] attachFilesArray = attachFiles.split("#A#");
            String script1 = "";
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder script = new StringBuilder();

//      if (row.get(0).get(Access_User._attachFile).equals("")) {
//      html4.append("$('#inputAfterSelect').hide()");}
//      else{
//           html4.append("$('#inputAfterSelect').show()");
            for (int l = 0; l < attachFilesArray.length; l++) {
                List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + attachFilesArray[l] + "'"));
                if (!fileRow.isEmpty()) {
                    String idUpload = fileRow.get(0).get(UploadServlet._id).toString();
                    html3.append("<div >" + "<input class='col-xs-12' disabled='disabled'  value='" + attachFilesArray[l] + "'/>"  + "</div>");
//                    html3.append("<div class='col-xs-12'>" + "<input  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<div  onclick='cmsUser.removeFile(" + idUpload + "," + id + ")'>" + "<img  src='imgfeyz/images.png' style='width:2%' />" + "</div>" + "</div>");
                }
            }

            script1 = Js.setHtml("#inputAfterSelect", html3);

            if (row.get(0).get(Access_User._attachAxPersonal).equals("")) {
                script.append(Js.setAttr("#PicPreviewPersonal", "src", "img/preview.jpg"));
            } else {
                script.append(Js.setAttr("#PicPreviewPersonal", "src", "upload/" + row.get(0).get(Access_User._attachAxPersonal).toString() + ""));
            }
            if (row.get(0).get(Access_User._attachAxPersonnelCard).equals("")) {
                script.append(Js.setAttr("#PicPreview", "src", "img/preview.jpg"));
            } else {
                script.append(Js.setAttr("#PicPreview", "src", "upload/" + row.get(0).get(Access_User._attachAxPersonnelCard).toString() + ""));
            }
            if (row.get(0).get(Access_User._attachAxSignature).equals("")) {
                script.append(Js.setAttr("#PicPreviewSignature", "src", "img/preview.jpg"));
            } else {
                script.append(Js.setAttr("#PicPreviewSignature", "src", "upload/" + row.get(0).get(Access_User._attachAxSignature).toString() + ""));
            }

            html.append(Js.setVal("#user_addressUser", row.get(0).get(_address)));
            html.append(Js.setValDate("#user_birthdateUserUser", row.get(0).get(_birthdate)));
///////////////////////////
            /////این تابع برای نمایش فایل های اپلود شده توسط فردی که واردشده نوشته شده است
            /////شیران1

//            List<Map<String, Object>> rowUpload = jjDatabase.separateRow(db.Select(UploadServlet.tableName,UploadServlet. _loader_id + "=" + id));
//            html.append(Js.setVal("#uploaded_file", rowUpload.get(0).get(UploadServlet._file_name)));
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);

            if (accEdt) {
                if (!id.equals("1")) {
                    html2.append("<div class=\"row\"><div class=\"col-lg-6\"><input type=\"button\" id=\"edit_User\" value=\"" + lbl_edit + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"></div>");
                    html.append(Js.buttonMouseClick("#edit_User", Js.jjUser.edit()));
                }
            }
            if (accDel) {
                if (!id.equals("1")) {
                    html2.append("<div class=\"col-lg-6\"><input type=\"button\" id=\"delete_User\" value=\"" + lbl_delete + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"  /></div></div>");
                    html.append(Js.buttonMouseClick("#delete_User", Js.jjUser.delete(id)));
                }
            }
            Server.outPrinter(request, response, (Js.setHtml("#User_button", html2.toString())) + html.toString() + script1 + script.toString());
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String selectUserProfile(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = String.valueOf(jjTools.getSeassionUserId(request));
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.dialog(errorMessageId));
                return "";
            }

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            html.append(Js.setVal("#user_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#" + _answer, row.get(0).get(_answer)));
            html.append(Js.setVal("#" + _email, row.get(0).get(_email)));
            html.append(Js.setVal("#" + _address, row.get(0).get(_address)));
            html.append(Js.setVal("#" + _address2, row.get(0).get(_address2)));
            html.append(Js.setVal("#" + _mobile, row.get(0).get(_mobile)));
            html.append(Js.setVal("#" + _phone, row.get(0).get(_phone)));
            html.append(Js.setVal("#" + _postalCode, row.get(0).get(_postalCode)));
            html.append(Js.setVal("#" + _family, row.get(0).get(_family)));
            html.append(Js.setVal("#" + _name, row.get(0).get(_name)));
            html.append(Js.setVal("#" + _no1, row.get(0).get(_no1)));
            html.append(Js.setVal("#" + _no2, row.get(0).get(_no2)));
            html.append(Js.setVal("#" + _question, row.get(0).get(_question)));
            html.append(Js.setValDate("#" + _registDate, row.get(0).get(_registDate)));
            html.append(Js.setValDate("#" + _birthdate, row.get(0).get(_birthdate)));

            Server.outPrinter(request, response, html.toString());
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

//    public static String getCheckboxList(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
//        StringBuffer html = new StringBuffer();
//        List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectAll(tableName));
//        String userId = jjTools.getParameter(request, Access_User._id);
//        if (row.size() > 0) {
//            html.append("<div align='center'><table border='1' style='width: 100%;height: 100' cellpadding='1'><tr>");
//            html.append("<td height='100' align='center' width='100%' bgcolor='white' valign='top'>");
//            html.append("<div style='padding: 0px;background-color: white;color: black ;border:0px solid black;width:100%;height:100px;overflow:auto;text-align: right'>");
//            String selected = "";
//            String groups = "";
//            List<Map<String, Object>> gr = jjDatabase.separateRow(db.Select(Access_Group_User.tableName, Access_Group_User._user_id + "=" + userId));
//            for (int i = 0; i < gr.size(); i++) {
//                groups += "$" + gr.get(i).get(Access_Group_User._group_id) + "$";
//
//            }
//            if (jjNumber.isDigit(userId)) {
//                for (int i = 0; i < row.size(); i++) {
////                    int rowCount = db.Select(Access_Group_User.tableName, Access_Group_User._user_id + "=" + userId
////                            + " AND " + Access_Group_User._group_id + "=" + row.get(i).get(_id)).getRowCount();
//                    selected = groups.contains("$" + row.get(i).get(_id).toString() + "$") ? "checked" : "";
//                    html.append("<li style='width: 250px;font-size: 10pt;cursor: pointer;text-align: right;padding: 0px;'>");
//                    html.append("<input  type='checkbox' style='width: 30px;' "
//                            + "id='chk" + row.get(i).get(_id) + "' name='chk" + row.get(i).get(_id) + "' " + selected + "/>");
//                    html.append(row.get(i).get(_email));
//                    html.append("</li>");
//                }
//            }
//            html.append("</div></td></table></div>");
//        }
//        Server.outPrinter(request, response, html.toString();
//    }
    public static String login(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String email = jjTools.getParameter(request, _email).toLowerCase().replace(" or ", "").toLowerCase();
            String passRequest = jjTools.getParameter(request, Access_User._pass).toLowerCase().replace(" or ", "").toLowerCase();
            // --------------------------------------------------------------- //
            StringBuilder html = new StringBuilder();
            if (email.equals("") || passRequest.equals("")) {
                Server.outPrinter(request, response, "new jj(\"\").jjGo();");
                return "";
            }
            List<Map<String, Object>> user = jjDatabase.separateRow(db.Select(
                    Access_User.tableName, Access_User._email + "='" + email
                    + "' AND " + Access_User._pass + "='" + passRequest + "'"));
            if (user.isEmpty()) {
                Server.outPrinter(request, response, "alert(111);new jj(\"\").jjGo();");
                return "";
            }
            List<Map<String, Object>> groups = jjDatabase.separateRow(
                    db.Select(Access_Group_User.tableName, Access_Group_User._user_id + "=" + user.get(0).get(Access_User._id)));
            StringBuilder validInSeassion = new StringBuilder();
            StringBuilder noValidInSeassion = new StringBuilder();
            jjTools.setSessionAttribute(request, "#" + Access_User._id.toUpperCase(), user.get(0).get(Access_User._id).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._name.toUpperCase(), user.get(0).get(Access_User._name).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._family.toUpperCase(), user.get(0).get(Access_User._family).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._pass.toUpperCase(), user.get(0).get(Access_User._pass).toString());
            List<Map<String, Object>> roleRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._user_id + "=" + user.get(0).get(Access_User._id)));
            if (roleRow.size() > 0) {// نقش هایی که این کاربر دارد
                String rolesStr = "";
                for (int i = 0; i < roleRow.size(); i++) {
                    rolesStr += roleRow.get(i).get(Role._id).toString() + "%23A%23";
                }
                jjTools.setSessionAttribute(request, "#ROLE_ID", rolesStr);// آی دی نقش میرود درسشن
            }
            if (user.get(0).get(Access_User._id).toString().equals("1") || user.get(0).get(Access_User._id).toString().equals("2")) {
                html.append("$('#TrIdInUserForm').show();\n");
            } else {
                html.append("$('#TrIdInUserForm').hide();\n");
            }
            for (int i = 0; i < groups.size(); i++) {
                List<Map<String, Object>> group = jjDatabase.separateRow(
                        db.Select(Access_Group.tableName, Access_Group._id + "=" + groups.get(i).get(Access_Group_User._group_id)));
                if (group.size() > 0) {
                    for (int j = 1; j < Access_Group.chkNumber; j++) {
                        String rulId = "0";//defult value,to privent null pointer exeption in group_c
                        try {
                            rulId = group.get(0).get("group_c" + (j < 10 ? "0" + j : j)).toString();
                        } catch (Exception ex) {
                            ServerLog.Print(
                                    "خطایی در پایگاه داده: ردیف "
                                    + "group_c" + (j < 10 ? "0" + j : j)
                                    + "وجود ندارد، این خطا از طریق استثنا ها مدیریت شد");
                            rulId = "0";
                        }
                        if (rulId.equals("1")) {
                            if (!validInSeassion.toString().contains("$" + j + "$")) {
                                validInSeassion.append("$" + j + "$");
                            }
                        } else {
                            noValidInSeassion.append("$" + j + "$");
                            html.append("$('#C" + (j < 10 ? "0" + j : j) + "').attr('disabled','disabled');\n");
                        }
                    }
                }
            }
            jjTools.setSessionAttribute(request, "#ACCESS", validInSeassion.toString());
            jjTools.setSessionAttribute(request, "#NOACCESS", noValidInSeassion.toString());

            boolean show = true;

            if (Access_User.getAccessDialog(request, db, Comment.rul_rfs).equals("")) {
                html.append("$( '#CommentTab' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:0});\n");
                    html.append("cmsComment.m_refresh();\n");
                    html.append("cmsComment.loadForm();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Content.rul_rfs).equals("")) {
                html.append("$( '#ContentTab' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:1});\n");
                    html.append("cmsContent.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Enrolment.rul_rfs).equals("")) {
                html.append("$( '#EnrolmentTab' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:4});\n");
                    html.append("cmsEnrolment.m_refresh();\n");
                }
            }
            if (Access_User.getAccessDialog(request, db, Enrolment3.rul_rfs).equals("")) {
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:5});\n");
                    html.append("cmsEnrolment3.m_refresh();\n");
                }
            }
            if (Access_User.getAccessDialog(request, db, News.rul_rfs).equals("")) {
                html.append("$( '#NewsTab' ).show();\n");
                html.append("$( '#newsTab1' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:2});\n");
                    html.append("cmsNews.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Category_News.rul_rfs).equals("")) {
                html.append("$( '#NewsTab' ).show();\n");
                html.append("$( '#newsTab2' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:2});\n");
                    html.append("cmsCategoryNews.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Pic.rul_rfs).equals("")) {
                html.append("$( '#PicTab' ).show();\n");
                html.append("$( '#PicTab1' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:3});\n");
                    html.append("cmsPic.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Category_Gallery.rul_rfs).equals("")) {
                html.append("$( '#PicTab' ).show();\n");
                html.append("$( '#PicTab2' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:3});\n");
                    html.append("cmsCategoryGallery.m_refresh();\n");
                }
                show = false;
            }

            if (Access_User.getAccessDialog(request, db, Product.rul_rfs).equals("")) {
                html.append("$( '#ProductTab' ).show();\n");
                html.append("$( '#ProductTab1' ).show();\n");
                html.append("$( '#ProductTab2' ).show();\n");
                html.append("$( '#ProductTab3' ).show();\n");
                html.append("$( '#ProductTab8' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:6});\n");
                    html.append("cmsProduct.m_refresh();\n");
                }
                show = false;
            }
//        if (Access_User.getAccessDialog(request,response,db, Category_Product.rul_rfs).equals("")) {
//            html.append("$( '#ProductTab' ).show();\n");
//            html.append("$( '#ProductTab2' ).show();\n");
//            show = false;
//            if (show) {
//                html.append("$( '#tabs' ).tabs({selected:6});\n");
//                html.append("cmsCategoryProduct.m_refresh();\n");
//            }
//        }

            if (Access_User.getAccessDialog(request, db, Poll.rul_rfs).equals("")) {
                html.append("$( '#PollTab' ).show();\n");
                html.append("$( '#PollTab1' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:7});\n");
                    html.append("cmsPoll.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, sms.rul_rfs).equals("")) {
                html.append("$( '#SMSTab' ).show();\n");
                html.append("$( '#SMSTab1' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:7});\n");
                    html.append("cmsSMS.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, cms.tools.email.rul_rfs).equals("")) {
                html.append("$( '#SMSTab' ).show();\n");
                html.append("$( '#emailtab' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:7});\n");
                    html.append("cmsEmail.m_refresh();\n");
                }
                show = false;
            }

            if (Access_User.getAccessDialog(request, db, smsSetting.rul_edt).equals("")) {
                html.append("$( '#SMSTab' ).show();\n");
                html.append("$( '#SMSTab2' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:7});\n");
                    html.append("cmsCategorySMS.m_refresh();\n");
                }
                show = false;
            }

            if (Access_User.getAccessDialog(request, db, Forum.rul_rfs).equals("")) {
                html.append("$( '#CategoryForumTab' ).show();\n");
                html.append("$( '#CategoryForumTab1' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:8});\n");
                    html.append("cmsForum.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Category_Forum.rul_rfs).equals("")) {
                html.append("$( '#CategoryForumTab' ).show();\n");
                html.append("$( '#CategoryForumTab2' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:8});\n");
                    html.append("cmsCategoryForum.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Access_User.rul_rfs).equals("")) {
                html.append("$( '#UserTab' ).show();\n");
                html.append("$( '#UserTab1' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:9});\n");
                    html.append("cmsUser.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Access_Group.rul_rfs).equals("")) {
                html.append("$( '#UserTab' ).show();\n");
                html.append("$( '#UserTab2' ).show();\n");
                html.append("$( '#UserTab3' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:9});\n");
                    html.append("cmsGroup.m_refresh();\n");
                }
                show = false;
            }
//            if (Access_User.getAccessDialog(request,response,db, Backup.rul_rfs).equals("")) {
//                html.append("$( '#UserTab' ).show();\n");
//                html.append("$( '#UserTab2' ).show();\n");
//                html.append("$( '#UserTab3' ).show();\n");
//                if (show) {
//                    html.append("$( '#tabs' ).tabs({selected:10});\n");
//                    html.append("cmsGroup.m_refresh();\n");
//                }
//                show = false;
//            }
            if (Access_User.getAccessDialog(request, db, Portal.rul_rfs).equals("")) {
                html.append("$( '#PortalTab' ).show();\n");
                html.append("$( '#PortalTab1' ).show();\n");
//                show = true;
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:11});\n");
                    html.append("cmsPortal.m_refresh();\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Portal.rul_rfs).equals("")) {
                html.append("$( '#PortalTab' ).show();\n");
                html.append("$( '#PortalTab2' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:11});\n");
                    html.append("alert(22222);\n");
                }
                show = false;
            }
            if (Access_User.getAccessDialog(request, db, Language.rul_rfs).equals("")) {
                html.append("$( '#SettingTab' ).show();\n");
                html.append("$( '#LangSettingTab1' ).show();\n");
                if (show) {
                    html.append("$( '#tabs' ).tabs({selected:12});\n");
                    html.append("cmsLangSetting.loadForm();\n");
                }
                show = false;
            }
            html.append("$( '#LoginTab' ).hide();\n");

            Server.outPrinter(request, response, html.toString());
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String loginUser(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String email = jjTools.getParameter(request, _email).toLowerCase().replace(" or ", "").toLowerCase();
            String passRequest = jjTools.getParameter(request, Access_User._pass).toLowerCase().replace(" or ", "").toLowerCase();
            // --------------------------------------------------------------- //
            if (!email.equals("") && !passRequest.equals("")) {
                List<Map<String, Object>> user = jjDatabase.separateRow(db.Select(
                        Access_User.tableName, Access_User._email + "='" + email
                        //                        + "' OR " + Access_User._mobile + " ='" + email //====== BY RASHIDI ======
                        + "' AND " + Access_User._pass + "='" + passRequest + "'"));
//                List<Map<String, Object>> user = jjDatabase.separateRow(db.Select(
//                        Access_User.tableName, Access_User._email + "='" + email
//                        + "' AND " + Access_User._pass + "='" + passRequest + "'"));
                if (user.size() == 1) {
                    Server.outPrinter(request, response, afterUserLoginOrRegist(request, db, needString, user.get(0)));
                    return "";
                } else {
                    String comment = "ایمیل و یا رمز عبور صحیح نمی باشد.";
                    if (jjTools.isLangEn(request)) {
                        comment = "Email or Password is not currect.";
                    }
                    Server.outPrinter(request, response, Js.setHtml("#loginMessagePanel", comment));
                    return "";
                }
            } else {
                String comment = "ایمیل و رمز عبور نباید تهی باشد.";
                if (jjTools.isLangEn(request)) {
                    comment = "Email and Password don't must be empty.";
                }
                Server.outPrinter(request, response, Js.setHtml("#loginMessagePanel", comment));
                return "";
            }
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String afterUserLoginOrRegist(HttpServletRequest request, jjDatabaseWeb db, boolean isPost, Map<String, Object> user) throws IOException {
        StringBuilder html = new StringBuilder();
        try {
            jjTools.setSessionAttribute(request, "#" + Access_User._id.toUpperCase(), user.get(Access_User._id).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._name.toUpperCase(), user.get(Access_User._name).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._family.toUpperCase(), user.get(Access_User._family).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._pass.toUpperCase(), user.get(Access_User._pass).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._email.toUpperCase(), user.get(Access_User._email).toString());

            html.append("USER_NAME = \"" + user.get(Access_User._name).toString().replace("\"", "'") + "\";\n");
            html.append("USER_ID = \"" + user.get(Access_User._id).toString().replace("\"", "'") + "\";\n");
            html.append("USER_FAMILY = \"" + user.get(Access_User._family).toString().replace("\"", "'") + "\";\n");
            html.append("USER_EMAIL = \"" + user.get(Access_User._email).toString().replace("\"", "'") + "\";\n");
            html.append("USER_PASS = \"" + user.get(Access_User._pass).toString().replace("\"", "'") + "\";\n");
            String panel = jjTools.getParameter(request, "panel");
            if (!panel.equals("")) {
                html.append(Js.setHtml("#" + panel, user.get(Access_User._name).toString() + "&nbsp;" + user.get(Access_User._family).toString() + "&nbsp;("
                        + (jjTools.isLangFa(request) ? "خروج" : "SignOut") + ")") + ";\n");
            }

            html.append("window.location ='index.html';");
            html.append("$('#loginForm').hide();\n");
            html.append("new jj('#loginForm').jjFormClean();\n");

            html.append("new jj('#registForm').jjFormClean();\n");
            html.append("refreshLastSwParameter();\n");
//            html.append("showShoppingCart();");//???????????? //======EDITED BY RASHIDI ======

            Server.outPrinter(request, null, html.toString());
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, null, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String signOut(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws IOException {
        jjTools.setSessionAttribute(request, "#" + Access_User._id.toUpperCase(), "");
        jjTools.setSessionAttribute(request, "#" + Access_User._name.toUpperCase(), "");
        jjTools.setSessionAttribute(request, "#" + Access_User._family.toUpperCase(), "");
        jjTools.setSessionAttribute(request, "#" + Access_User._pass.toUpperCase(), "");
        jjTools.setSessionAttribute(request, "#" + Access_User._email.toUpperCase(), "");
        request.getSession().invalidate();
        Server.outPrinter(request, response, "");
        return "";
    }

    public static String registUser(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String email = jjTools.getParameter(request, _email);
//            String mobile = jjTools.getParameter(request, _email);

            //============ BY RASHIDI ========>
            // ------------- check email or mobile are not empty -------------------
            if (email.equals("")) {
                String errorMsg = "وارد کردن ایمیل و یا شماره موبایل الزامیست";
                if (jjTools.isLangEn(request)) {
                    errorMsg = "Enter phone number or email address";
                }
                Server.outPrinter(request, response, Js.setHtml("#registMessagePanel", errorMsg));
                return "";
            }
            //<============ BY RASHIDI ========

            String message = isValidMessageForRegist(request, response, db, needString);
            if (!message.equals("")) {
                Server.outPrinter(request, response, Js.setHtml("#registMessagePanel", message));
                return "";
            }

            // ------------- check equal pass and repeat pass -------------------
            boolean eqPass = jjTools.getParameter(request, _pass).toLowerCase().equals(jjTools.getParameter(request, _pass + "_2").toLowerCase());
            if (!eqPass) {
                String mes = "رمز عبور با تکرار آن باید یکی باشند.";
                if (jjTools.isLangEn(request)) {
                    mes = "Password1 and Password2 must be equal.";
                }
                Server.outPrinter(request, response, Js.setHtml("#registMessagePanel", mes));
                return "";
            }

            // ------------- check family is not empty -------------------
            String reqAnswer = jjValidation.isFillMessageFa(jjTools.getParameter(request, _family), "نام خانوادگی");
            if (!reqAnswer.equals("")) {
                if (jjTools.isLangEn(request)) {
                    reqAnswer = jjValidation.isFillMessageEn(jjTools.getParameter(request, _family), "family");
                }
                Server.outPrinter(request, response, Js.setHtml("#registMessagePanel", reqAnswer));
                return "";
            }

            // --------------------------- data is valid ------------------------------
            //============ BY RASHIDI ========>
            //ایمیل یا شماره موبایل تکراری نباشد
            List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(tableName, _email + "='" + email + "'"));
            if (userRow.isEmpty()) {
                //<============ BY RASHIDI ========
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(_email, email);
//                map.put(_mobile, mobile);
                map.put(_name, jjTools.getParameter(request, _name).toLowerCase());
                map.put(_family, jjTools.getParameter(request, _family).toLowerCase());
                map.put(_isActive, true);
//            map.put(_no1, jjTools.getParameter(request, _no1));
//            map.put(_no2, jjTools.getParameter(request, _no2));
//            String parent = jjTools.getParameter(request, _parent);
//            map.put(_parent, jjNumber.isDigit(parent) ? Integer.parseInt(parent) : 0);
                map.put(_pass, jjTools.getParameter(request, _pass));
//            map.put(_question, jjTools.getParameter(request, _question));
                map.put(_passHint, jjTools.getParameter(request, _passHint));
//            map.put(_registDate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _registDate), true));
//            map.put(_birthdate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _birthdate), false));
                List<Map<String, Object>> row = jjDatabase.separateRow(db.insert(tableName, map));
                if (row.isEmpty()) {
                    String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                    if (jjTools.getParameter(request, "myLang").equals("2")) {
                        errorMessage = "registUser Fail;";
                    }
                    Server.outPrinter(request, response, Js.setHtml("#registMessagePanel", errorMessage));
                    return "";
                } else {
                    String body = "";
                    body += "<p dir='rtl'>کاربر گرامی  "
                            + row.get(0).get(_name) + "&nbsp;" + row.get(0).get(_family) + "</p>\n"
                            + "<p dir='rtl'>از ثبت نام شما در سایت  "
                            + "  متشکریم</p>\n"
                            + "<p dir='rtl'>UserName/Email: " + row.get(0).get(_email) + "</p>\n"
                            + "<p dir='rtl'>And Password:" + row.get(0).get(_pass) + "</p>\n";
                    Server.sendEmail("", row.get(0).get(_email).toString(), "ثبت نام در سایت ", body, true, request);
                    Server.outPrinter(request, response, afterUserLoginOrRegist(request, db, needString, row.get(0)));
                    return "";
                }
                //============ BY RASHIDI ========>
            } else {
                String mes = "ایمیل تکراری است.";
                if (jjTools.isLangEn(request)) {
                    mes = "Email or phone number is reapeted";
                }
                Server.outPrinter(request, response, Js.setHtml("#registMessagePanel", mes));
                return "";
            }
            //<============ BY RASHIDI ========
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    /**
     * این متد فقط سمت جاوا فراخوانی می شود و پاسخی به کلاینت مستقیما نمی فرستد
     *
     * @param request
     * @param db
     * @param ruleId
     * @Server.outPrinter(request, response, Not Access Dialog if no access and
     * reurn "" if has access
     */
    public static String getAccessDialog(HttpServletRequest request, jjDatabaseWeb db, int ruleId) throws IOException {
        if (ruleId == 0) {
            return "";
        }
        if (jjTools.getSessionAttribute(request, "#ACCESS").toLowerCase().contains("$" + String.valueOf(ruleId) + "$")) {
            return "";
        } else {
            if (jjTools.isLangFa(request)) {
                return "";
            } else {
                return "";
            }
        }
    }

    public static String getAccessDialog(HttpServletRequest request, HttpServletResponse response, jjDatabase db, int ruleId) throws IOException {
        if (ruleId == 0) {
            Server.outPrinter(request, response, "");
            return "";
        }
        if (jjTools.getSessionAttribute(request, "#ACCESS").toLowerCase().contains("$" + String.valueOf(ruleId) + "$")) {
            Server.outPrinter(request, response, "");
            return "";
        } else {
            if (jjTools.isLangFa(request)) {
                Server.outPrinter(request, response, Js.dialog(noAccessFa));
                return "";
            } else {
                Server.outPrinter(request, response, Js.dialog(noAccessEn));
                return "";
            }
        }
    }

    public static boolean hasAccess(HttpServletRequest request, jjDatabaseWeb db, int ruleId) {
        if (ruleId == 0) {
            return true;
        }
        return jjTools.getSessionAttribute(request, "#ACCESS").toLowerCase().contains("$" + String.valueOf(ruleId) + "$");
    }

    public static String loginPortalUser(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        //نام کاربری و رمز عبور بهتر است در پایگاه داده با قسمت کاربران سینک شود
        try {
            String email = jjTools.getParameter(request, PortalUser._UserName).toLowerCase().replace(" or ", "").toLowerCase();
            String passRequest = jjTools.getParameter(request, PortalUser._pass).toLowerCase().replace(" or ", "").toLowerCase();
            String portalId = jjTools.getParameter(request, PortalUser._id);
            // --------------------------------------------------------------- //
            StringBuilder html = new StringBuilder();
            if (!email.equals("") || !passRequest.equals("")) {
                List<Map<String, Object>> user = jjDatabase.separateRow(db.Select(
                        PortalUser.tableName, PortalUser._UserName + "='" + email
                        + "' AND " + PortalUser._pass + "='" + passRequest + "'"
                        + " AND " + PortalUser._id + "='" + portalId + "'"));
                if (user.size() == 1) {
                    Server.outPrinter(request, response, afterUserPortalLoginOrRegist(request, response, db, needString, user.get(0), portalId));
                    return "";
//                    Server.outPrinter(request, response, Js.dialog("کاربر گرامی خوش آمدید");
                } else {
                    String comment = "ایمیل و یا رمز عبور صحیح نمی باشد.";
                    if (jjTools.isLangEn(request)) {
                        comment = "Email or Password is not currect.";
                    }
                    Server.outPrinter(request, response, Js.setHtml("#loginMessagePanel", comment));
                    return "";
                }
            } else {
                String comment = "ایمیل و رمز عبور نباید تهی باشد.";
                if (jjTools.isLangEn(request)) {
                    comment = "Email and Password don't must be empty.";
                }
                Server.outPrinter(request, response, Js.dialog(comment));
                return "";
            }
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    /**
     * برای ویرایش پروفایل کاربر هنوز کمی کار دارد
     *
     * برای فلوریت درست شد که قسمت سفارش آپدیت بشه
     *
     * @param request
     * @param db
     * @param isPost
     * @Server.outPrinter(request, response,
     * @throws Exception
     */
    public static String updateUserProfile(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {

            String id = String.valueOf(jjTools.getSeassionUserId(request));
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.dialog(errorMessageId));
                return "";
            }

            Map<String, Object> map = new HashMap<String, Object>();
            if (!jjTools.getParameter(request, _answer).isEmpty()) {
                map.put(_answer, jjTools.getParameter(request, _answer));
            }
            if (!jjTools.getParameter(request, _question).isEmpty()) {
                map.put(_question, jjTools.getParameter(request, _question));
            }
            if (!jjTools.getParameter(request, _answer).isEmpty()) {
                map.put(_family, jjTools.getParameter(request, _family));
            }
            if (!jjTools.getParameter(request, _name).isEmpty()) {
                map.put(_name, jjTools.getParameter(request, _name));
            }
            if (!jjTools.getParameter(request, _name).isEmpty()) {
                map.put(_no1, jjTools.getParameter(request, _no1));
            }
            if (!jjTools.getParameter(request, _no1).isEmpty()) {
                map.put(_no2, jjTools.getParameter(request, _no2));
            }
            if (!jjTools.getParameter(request, _no2).isEmpty()) {
                map.put(_address, jjTools.getParameter(request, _address));
            }
            map.put(_address2, jjTools.getParameter(request, _address2));//اگر آدرس 2 خالی باشد پاک کنیم برای اینکه اشتباها از قبل وارد نشده باشد
            if (!jjTools.getParameter(request, _address2).isEmpty()) {
                map.put(_postalCode, jjTools.getParameter(request, _postalCode));
            }
            if (!jjTools.getParameter(request, _mobile).isEmpty()) {
                map.put(_mobile, jjTools.getParameter(request, _mobile));
            }
            if (!jjTools.getParameter(request, _phone).isEmpty()) {
                map.put(_phone, jjTools.getParameter(request, _phone));
            }
            if (!jjTools.getParameter(request, _birthdate).isEmpty()) {
                map.put(_birthdate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _birthdate), false));
            }

            if (id.equals("1")) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            if (!db.update(tableName, map, _id + "=" + jjTools.getParameter(request, _id))) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            // =========================
            Server.outPrinter(request, response, "");
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String afterUserPortalLoginOrRegist(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString, Map<String, Object> user, String portalId) throws IOException {
        StringBuilder html = new StringBuilder();
        try {
            request.getSession().invalidate();
            jjTools.setSessionAttribute(request, "#" + Portal._ownerId.toUpperCase(), portalId);//use in edit Portal.portalPostLoadforEdit()
            jjTools.setSessionAttribute(request, "#" + Access_User._id.toUpperCase(), user.get(PortalUser._UserId).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._name.toUpperCase(), user.get(PortalUser._firstName).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._family.toUpperCase(), user.get(PortalUser._lastName).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._pass.toUpperCase(), user.get(PortalUser._pass).toString());
            jjTools.setSessionAttribute(request, "#" + Access_User._email.toUpperCase(), user.get(PortalUser._UserName).toString());

//            html.append("USER_ID = \"" + user.get(PortalUser._UserId).toString().replace("\"", "'") + "\";\n");
//            html.append("USER_NAME = \"" + user.get(PortalUser._firstName).toString().replace("\"", "'") + "\";\n");
//            html.append("USER_FAMILY = \"" + user.get(PortalUser._lastName).toString().replace("\"", "'") + "\";\n");
//            html.append("USER_EMAIL = \"" + user.get(PortalUser._UserName).toString().replace("\"", "'") + "\";\n");
//            html.append("USER_PASS = \"" + user.get(PortalUser._pass).toString().replace("\"", "'") + "\";\n");
            String panel = jjTools.getParameter(request, "panel");
            panel = panel.equals("") ? "sw" : panel;

            html.append(Js.setHtml("#" + panel, user.get(PortalUser._firstName).toString() + "&nbsp;" + user.get(PortalUser._lastName).toString() + "&nbsp;("
                    + (jjTools.isLangFa(request) ? "خروج" : "SignOut") + ")") + ";\n");

            html.append(Js.setHtml("#jjLoginExitPanel", " <div>"
                    + user.get(PortalUser._firstName).toString().replace("\"", "'")
                    + "خوش آمدید"
                    + "<br/>"
                    + "<br/>"
                    + "<a onclick='portalUserLoadForm();'>"
                    + "ویرایش مشخصات"
                    + "</a>"
                    + "<br/>"
                    + "<a onclick='addNewPortalPost(" + portalId + ");'>"
                    + "افزودن مطلب جدید"
                    + "</a>"
                    + "<br/>"
                    + "<a onclick='loadPortalPostforEdit(" + portalId + ");'>"
                    + "ویرایش مطالب"
                    + "</a>"
                    + "<br/>"
                    + "</div>"));
            Server.outPrinter(request, response, html.toString());
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
}
