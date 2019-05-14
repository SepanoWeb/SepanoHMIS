/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import cms.access.Access_User;
import HMIS.FormAnswers;
import cms.tools.Js;
import cms.tools.Server;
import cms.tools.jjTools;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;
import jj.jjCalendar_IR;
import jj.jjDatabaseWeb;
import jj.jjNumber;

/**
 *
 * @author Mohammad
 */
public class FormAnswerSet {

    public static final String tableName = "hmis_formAnswerSet";
    public static final String _id = "id";
    public static final String _formId = "formAnswers_formId";
    public static final String _userId = "formAnswers_userId";
    public static final String _userName = "formAnswers_userName";
    public static final String _userRole = "formAnswers_userRole";//نقش هایی که کاربر به واسطه ی انها به این فرم دسترسی داشته است
    public static final String _date = "formAnswers_date";
    public static final String _time = "formAnswers_time";//بخش یا بخش هایی که این فرم را باید ببینند
    public static final String _status = "formAnswers_status";//سمت هایی که به این فرم دسترسی 
    public static final String _statusLog = "formAnswers_statusLog";//سمت هایی که به این فرم دسترسی 
    public static final String _userMAC = "formAnswers_userMAC";// مک آدرس پر کننده ی فرم
    public static final String _userIPV4 = "formAnswers_userIPV4";// آی پی پر کننده ی فرم
    public static final String _userIPV6 = "formAnswers_userIPV6";// آی پی ورژن شش پر کننده ی فرم
//   
    public static final String lbl_insert = "ثبت و افزودن سوال";
    public static final String lbl_delete = "حذف فرم";
    public static final String lbl_edit = "ویرایش";
    public static final String lbl_add_en = "افزودن زبان انگلیسی";
    public static final String lbl_edit_en = "ویرایش بخش انگلیسی";
    public static final String lbl_add_ar = "افزودن زبان عربی";
    public static final String lbl_edit_ar = "ویرایش بخش عربی";

    public static int rul_rfs = 0;//60;
    public static int rul_rfs_own = 0;// 61;//فقط امکان دیدن فرم های ایجاد شده ی توسط خود ایجاد کننده را دارد // بر روی سمت
    public static int rul_ins = 0;// 62;
    public static int rul_edt = 0;// 63;
    public static int rul_dlt = 0;// 64;
    public static int rul_5 = 0;// 65;
    public static int rul_6 = 0;// 66;
    public static int rul_7 = 0;// 67;
    public static int rul_8 = 0;// 68;
    public static int rul_9 = 0;// 69;
    public static int rul_10 = 0;// 70;

//    public static int rul_lng5 = 68;
    public static final String lbl_add_ln2 = "برچسب";
    public static final String statues_sabteAvalie = "ثبت اولیه";
    public static final String statues_sabteNahei = "ثبت نهایی";

    public static final String lbl_add_ln3 = "افزودن زبان عربی";
    public static final String lbl_edit_ln3 = "ویرایش بخش عربی";
    public static final String lbl_add_ln4 = "افزودن زبان آلمانی";
    public static final String lbl_edit_ln4 = "ویرایش بخش آلمانی";
    public static final String lbl_add_ln5 = "افزودن زبان چینی";
    public static final String lbl_edit_ln5 = "ویرایش بخش چینی";

    /**
     * نمایش فرم های در اختیار نقش یا شخص جاری در سشن
     *
     * @param request
     * @param response
     * @param db
     * @param needString // اگر یک کلاس جاوایی یا یک فایل جی اس پی ین نتایج را
     * میخواهد لازم نیست به صفحه ی دیگری برویم و پاسخ را بصورت استرینگ پس می
     * دهیم
     * @return
     * @throws Exception
     */
    public static String showMyForms(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            int userId = jjTools.getSeassionUserId(request);
            String userRoleInsession = jjTools.getSeassionUserRole(request);
            System.out.println(">>>>>>>>UserRoles is:" + userRoleInsession);
            String where = " WHERE (";
            String userRoles[] = userRoleInsession.split("%23A%23");
            for (int i = 0; i < userRoles.length; i++) {
                where += Forms._accessessRoles + " like " + "'%" + userRoles[i] + "\\%23A\\%23%' OR ";// ممکن است کاربر چند تا تقش داشته باشد
            }
            if (!jjTools.getSeassionUserRole(request).isEmpty()) {// اگر کاربر جاری نقشی در سیستم دارد
                where += Forms._accessessRoles + " like " + "'%ALL%'" + " OR ";//فرم هایی که برای همه ی سمت ها دسترسی دارند را هم نشان بدهیم
            }
            where += Forms._accessessUsers + " like " + "'%" + userId + "\\%23A\\%23%'" + " OR ";
            where += Forms._accessessUsers + " like " + "'%ALL%'" + " OR ";
            where += Forms._accessessUsers + " = " + "''" + " OR ";
            where += Forms._accessessUsers + "='' ) AND  ";
            where += Forms._isActive + "=1 ; ";

            List<Map<String, Object>> formRows = jjDatabaseWeb.separateRow(db.otherSelect("SELECT * FROM " + Forms.tableName + where));
            StringBuilder html = new StringBuilder();
            html.append("<div class='card-header bg-primary tx-white'>لیست فرم ها و چک لیست های در اختیار شما</div>\n");
            html.append("<div class='card-body pd-sm-30'>");
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            html.append("<div class='table-wrapper'>");
            html.append("<table id='refreshMyForms' class='table display responsive' class='tahoma10' style='direction: rtl'><thead>");
            html.append("<th width='5%' class='r'>کد</th>");
            html.append("<th width='20%' class='r'>عنوان فرم</th>");
            html.append("<th width='20%' class='c'>تکمیل یک فرم</th>");
            html.append("<th width='20%' class='c'>آنالیز و آمار</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < formRows.size(); i++) {
                html.append("<tr>");
                html.append("<td class='r'>" + formRows.get(i).get(Forms._id) + formRows.get(i).get(Forms._code) + "</td>");
                html.append("<td class='r'>" + formRows.get(i).get(Forms._title) + "</td>");
                html.append("<td class='c'><i class='p icon ion-ios-gear-outline' onclick='" + Js.jjFormAnswerSet.refreshMyAnswers(formRows.get(i).get(_id).toString()) + "' style='color:#ffcd00!important'></i></td>");
                html.append("<td class='c'><i class='p fa fa-bar-chart' onclick='" + Js.jjFormAnswerSet.refreshMyAnswers(formRows.get(i).get(_id).toString()) + "'></i></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            html.append("</div>");
            html.append("</div>");
            String jj = jjTools.getParameter(request, "jj");
            if ("0".equals(jj)) {//برای ارجاع به فایل جی اس پی
                System.out.println("(((((((((((((((((((((((((((((((((((((((((((((");
                request.getRequestDispatcher("feiz/MyForms.jsp").forward(request, response);
            } else {// اگر این درخواست باید بصورت ایجکس پاسخ گفته شود
                StringBuilder script = new StringBuilder();
                script.append(Js.setHtml("#swMyFormsTbl", html));
                script.append(Js.table("#refreshMyForms", "", 0, "", "لیست اخبار"));
                Server.outPrinter(request, response, script);
            }
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String refreshMyAnswers(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            int userId = jjTools.getSeassionUserId(request);
            StringBuilder html = new StringBuilder();
            String formId = jjTools.getParameter(request, _formId);
            List<Map<String, Object>> FormTitleRow = jjDatabaseWeb.separateRow(db.Select(Forms.tableName, Forms._title + "," + Forms._uniqueComplete, Forms._id + "=" + formId));
            if (FormTitleRow.isEmpty()) {
                Server.outPrinter(request, response, "کد صحیح نیست");
                return "";
            }
            //ویژگی : اگر فردی در سمتی یک فرم را پر کند و فرد دیگری در آن سمت قرار گیرد نمیتواند فرم تکمیل شده ی فرم قبلی را ببیند ولی مدیران با دسترسی بالاتر میبینند
            //ویژگی : اگر فردی در سمتی یک فرم را پر کند و فرد دیگری در آن سمت قرار گیرد نمیتواند فرم تکمیل شده ی فرم قبلی را ببیند ولی مدیران با دسترسی بالاتر میبینند

            DefaultTableModel dtm = db.Select(tableName, _formId + "=" + formId + " AND " + _userId + "=" + userId);
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(dtm);
            html.append("<p class='mg-b-20 mg-sm-b-30'>");
            html.append("عنوان :" + FormTitleRow.get(0).get(Forms._title));
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            //ویژگی : اگر کاربر قبلا دسترسی داشته و اکنون دسترسی اش برای فرم خاصی برداشته شده یا نقشش عوض شده که به فرمی دسترسی ندارد دیگر دکمهی یجدید را نمی بیند
            //تشخیص دسترسی نقش یا شخص کاربر برای تکمیل این فرم---------------------------------------------------
            String userRoleInsession = jjTools.getSeassionUserRole(request);
            System.out.println(">>>>>>>>UserRoles is:" + userRoleInsession);
            String where = " WHERE (";
            String userRoles[] = userRoleInsession.split("%23A%23");
            for (int i = 0; i < userRoles.length; i++) {
                where += Forms._accessessRoles + " like " + "'%" + userRoles[i] + "\\%23A\\%23%' OR ";// ممکن است کاربر چند تا تقش داشته باشد
            }
            if (!jjTools.getSeassionUserRole(request).isEmpty()) {// اگر کاربر جاری نقشی در سیستم دارد
                where += Forms._accessessRoles + " like " + "'%ALL%'" + " OR ";//فرم هایی که برای همه ی سمت ها دسترسی دارند را هم نشان بدهیم
            }
            where += Forms._accessessUsers + " like " + "'%" + userId + "\\%23A\\%23%'" + " OR ";
            where += Forms._accessessUsers + " like " + "'%ALL%'" + " OR ";
            where += Forms._accessessUsers + " = " + "''" + " OR ";
            where += Forms._accessessUsers + "='' ) AND  ";
            where += Forms._id + "=" + jjTools.getParameter(request, FormAnswerSet._formId) + "  AND  ";
            where += Forms._isActive + "=1 ; ";
            //--------------------------------------------------------------------------------------------------------------------
            if (accIns && db.otherSelect("SELECT * FROM " + Forms.tableName + where).getRowCount() > 0) {//و اگر نقش یا شخص این کاربر موجود در سشن به این فرم دسترسی داشته باشد  دکمه جدید را نشان بدهد
                html.append("<br/>");
                html.append("<a style='color:#fff' class='btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white' href ='Server?do=FormAnswerSet.add_new&formAnswers_formId=" + formId + "' target='_blank' >تکمیل یک نمونه فرم جدید</a>");
            }
            html.append("</p>");
            html.append("<div class='table-wrapper'>");
            html.append("<table id='refreshAnswers' class='table display responsive' class='tahoma10' style='direction: rtl'><thead>");
            html.append("<th width='5%' class='r'>کد</th>");
            html.append("<th width='20%' class='c'>نام تکمیل کننده</th>");
            html.append("<th width='20%' class='c'>سمت</th>");
            html.append("<th width='20%' class='c'>تاریخ</th>");
            html.append("<th width='20%' class='c'>ساعت</th>");
            html.append("<th width='20%' class='c'>آنالیز و آمار</th>");
            html.append("<th width='20%' class='c'>آنالیز و آمار</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  class='mousePointer " + getClassByStatus(row.get(i).get(_status).toString()) + "' >");
                html.append("<td class='r'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_userName) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_userRole) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_date) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_time) + "</td>");
                html.append("<td class='c'><a href='Server?do=FormAnswerSet.selectToEdit&formAnswers_formId=13&id=" + row.get(i).get(_id).toString() + "' target='_blank'><i class='p icon ion-ios-gear-outline' style='color:#ffcd00!important'></i></td>");
                html.append("<td class='c'><i class='p fa fa-bar-chart' onclick='" + Js.jjFormAnswerSet.select(row.get(i).get(_id).toString()) + "'></i></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "";
            }
            if (panel.equals("")) {
                panel = "swOneFormToCompleteTable";
            }
            String script = Js.setHtml("#" + panel, html.toString());
            script += Js.table("#refreshAnswers", "", 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "2" : "", "لیست فرم ها پر شدهی در دسترس شما");
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, ex.getMessage());
            return ex.getMessage();
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            //بررسی دسترسی برای تکمیل یک فرم بر اساس نقش و شخص------------------------------------------------
            int userId = jjTools.getSeassionUserId(request);
            String userRoleInsession = jjTools.getSeassionUserRole(request);
            String where = " WHERE (";
            String userRoles[] = userRoleInsession.split("%23A%23");
            for (int i = 0; i < userRoles.length; i++) {
                where += Forms._accessessRoles + " like " + "'%" + userRoles[i] + "\\%23A\\%23%' OR ";// ممکن است کاربر چند تا تقش داشته باشد
            }
            if (!jjTools.getSeassionUserRole(request).isEmpty()) {// اگر کاربر جاری نقشی در سیستم دارد
                where += Forms._accessessRoles + " like " + "'%ALL%'" + " OR ";//فرم هایی که برای همه ی سمت ها دسترسی دارند را هم نشان بدهیم
            }
            where += Forms._accessessUsers + " like " + "'%" + userId + "\\%23A\\%23%'" + " OR ";
            where += Forms._accessessUsers + " like " + "'%ALL%'" + " OR ";
            where += Forms._accessessUsers + " = " + "''" + " OR ";
            where += Forms._accessessUsers + "='' ) AND  ";
            where += Forms._id + "=" + jjTools.getParameter(request, FormAnswerSet._formId) + "  AND  ";
            where += Forms._isActive + "=1 ; ";
            if (!accIns && db.otherSelect("SELECT * FROM " + Forms.tableName + where).getRowCount() == 0) {//و اگر نقش یا شخص این کاربر موجود در سشن به این فرم دسترسی داشته باشد این متد کار می کند
                Server.outPrinter(request, response, "شما اجازه ی ثبت این فرم را ندارید");
                return "";
            }
            //--------------------------------------------------------------------------------------------------------------------
            String formId = jjTools.getParameter(request, _formId);
            if (!jjNumber.isDigit(formId)) {
                Server.outPrinter(request, response, "کد فرم باید عدد باشد");
                return "";
            }
            System.out.println("********************************");
            for (int k = 0; k < request.getCookies().length; k++) {
                System.out.println("=========================COOKIES No " + k + ":");
                System.out.println(request.getCookies()[k].getName());
                System.out.println(request.getCookies()[k].getValue());
            }
            List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(Forms.tableName, Forms._id + "=" + formId + " AND " + Forms._isActive + "=1"));
            if (formRow.isEmpty()) {
                Server.outPrinter(request, response, "چنین فرمی وجود ندارد");
                return "چنین فرمی وجود ندارد";
            }
            System.out.println("********************************");
            String userMAC = jjTools.getCookie(request, "#USER_MAC");
            if (formRow.get(0).get(Forms._uniqueComplete).toString().equals("1")) {// اگر از نوع فرم های یکبار پر کردنی بود
                where = FormAnswerSet._formId + "=" + formId + " AND (" + FormAnswerSet._userId + "=" + jjTools.getSeassionUserId(request) + " OR "
                        + FormAnswerSet._userMAC + "=" + userMAC + ") ;";// جایی که پاسخ در حالت ثبت اولیه نباشد و با همین فرم آی دی و همین کاربر یا همین مک
                List<Map<String, Object>> uniqueForm = jjDatabaseWeb.separateRow(db.Select(FormAnswerSet.tableName, where));
                if (!uniqueForm.isEmpty()) {// اگر فرم باید توسط هر کاربر بصورت یونیک پر شود و اگر قبلا ثبت نهایی کرده است 
                    Server.outPrinter(request, response, "شما مجاز به تکمیل مجدد این فرم نیستید");
                    return "شما مجاز به تکمیل مجدد این فرم نیستید";
                }
            } else {//اگر قبلا فرمی ایجاد کرده و ثبت نهایی نکرده
                //@ToDo می توانیم اینجا چک کنیم اگر پاسخ ثبلی در وضعیت ثبت اولیه بود کاربر را بفرستیم به ویرایش 
            }
            //مهم : دز اینجا یک صفحه ی جی اس پی را در پاسخ می فرستیم
            request.setAttribute("db", db);
            System.out.println("------->>>>>feiz/newAnswer.jsp");
            request.getRequestDispatcher("feiz/newAnswer.jsp").forward(request, response);
            return "";
        } catch (IOException | ServletException ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * نشان داده یک فرمکه ثبت شده برای ویرایش توسط کاربر ممکن است بعد از ثبت
     * اولیه باشد و ممکن است بعد از انتخاب از جدول
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String selectToEdit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        request.setAttribute("db", db);
        System.out.println("------->>>>>feiz/newAnswerSelectToEdit.jsp");
        request.getRequestDispatcher("feiz/newAnswerSelectToEdit.jsp").forward(request, response);
        return "";
    }

    /**
     * درج در دیتابیس برای اولین بار ثبت موقت فرم و ثبت نهایی و آزمون توسط کاربر
     * این تابع اگر فرم یونیک باشد و قبلا توسط این مک یا این کاربر پر شده باشد
     * اجازه تکمیل نمیدهد
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                return Js.modal(hasAccess, "پیام سامانه");
            }
            String formId = jjTools.getParameter(request, _formId);
            String script = "";
            List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(Forms.tableName, Forms._id + "=" + formId));
            String userMAC = jjTools.getCookie(request, "#USER_MAC");
            if (formRow.isEmpty()) {
                Server.outPrinter(request, response, "این فرم وجود ندارد");
                return "این فرم وجود ندارد";
            } else if (formRow.get(0).get(Forms._uniqueComplete).toString().equals("1")) {// اگر فرم باید توسط هر کاربر بصورت یونیک پر شود
                //چک می کنیم که قبلا این کاربر یا این مک آدرس فرم را پر نکرده باشد
                String where = _formId + "=" + formId + " AND (" + _userId + "=" + jjTools.getSeassionUserId(request) + " OR "
                        + _userMAC + "=" + userMAC + ")";// جایی که پاسخ در حالت ثبت اولیه نباشد و با همین فرم آی دی و همین کاربر یا همین مک
                List<Map<String, Object>> uniqueForm = jjDatabaseWeb.separateRow(db.Select(tableName, where));
                if (!uniqueForm.isEmpty()) {
                    script = "alert('این فرم قبلا توسط شما تکمیل شده است و شما مجازهستید فقط یکبار این فرم را تکمیل کنید');\n";
                    script += Js.setHtml("#formAnserSetBtn", "این فرم قبلا توسط شما تکمیل شده است و شما مجازهستید فقط یکبار این فرم را تکمیل کنید");
                    Server.outPrinter(request, response, script);
                    return script;
                }
            }

            Map<String, Object> map = new HashMap();

            map.put(_formId, formId);
            map.put(_userId, jjTools.getSeassionUserId(request));
            if (jjTools.getSeassionUserRole(request).split("%23A%23").length > 1) {// اگر بیشتر از یک نقش در سشن داشت از ریکوئست نقش انتخابی کاربر را بخواند
                map.put(_userRole, jjTools.getParameter(request, _userRole));
            } else {// در غیر اینصورت نقش را  از سشن بخواند که ممکن است تهی باشدیعنی نقشی نداشته باشد
                map.put(_userRole, jjTools.getSeassionUserRole(request));
            }
            map.put(_userName, jjTools.getSeassionUserNameAndFamily(request));
            map.put(_userMAC, userMAC);
            map.put(_userIPV4, jjTools.getuserIP(request));
            map.put(_userIPV6, jjTools.getuserIP(request));
            jjCalendar_IR date = new jjCalendar_IR();
            map.put(_date, date.getDBFormat_8length());
            map.put(_time, date.getTimeFormat_4length());

            //درج یک ست پاسخ در دیتابیس برای اتصال پاسخ های تکی به هم
            List<Map<String, Object>> answerSetRow = jjDatabaseWeb.separateRow(db.insert(tableName, map));
            if (answerSetRow.isEmpty()) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت. 12-324";
                Server.outPrinter(request, response, "alert('" + errorMessage + "')");
                return Js.modal(errorMessage, "پیام سامانه");
            }
            String id = answerSetRow.get(0).get(_id).toString();// وقتی در جدول ردیف مخصوص پاسخ را درج کردیم آی دی را مقدار دهی می کنیم
            //به تعداد سوالات موجود در فرم اصلی باید پاسخ ایجاد کنیم
            List<Map<String, Object>> questionRows = jjDatabaseWeb.separateRow(db.Select(FormQuestions.tableName, FormQuestions._formID + "=" + formId));
            boolean flag = true;
            String qNo = "";
            for (int i = 0; i < questionRows.size(); i++) {// در پاسخ های فرم در ستون پاسخ ها
                Map<String, Object> answerMap = new HashMap();
                String answerI = jjTools.getParameter(request, "q" + questionRows.get(i).get(_id));
                if (questionRows.get(i).get(FormQuestions._isRequierd).equals("1") && answerI.isEmpty()) {//در ثبت نهایی اگر پاسخ سوالی ضروری بود و کاربر پاسخ نداده بودباید فرم را از حالت ثبت نهایی خارج کنیم
                    flag = false;
                    qNo += "سوال شماره ی" + (i + 1) + "،";//سوال هایی که ضروری هستند و پاسخ داده نشده اند
                }
                answerMap.put(FormAnswers._questionId, questionRows.get(i).get(_id));
                answerMap.put(FormAnswers._answer, answerI.replaceAll("#A#", "%23A%23"));
                answerMap.put(FormAnswers._answerSet_id, id);
                db.insert(FormAnswers.tableName, answerMap);// برای هر پاسخ یک سطر در جدول پاسخ ها داریم
            }
            String message = "";
            //تغییر وضعیت==================================================
            if (jjTools.getParameter(request, _status).equals(statues_sabteNahei) && flag) {//اگر درخواست ثبت نهایی بود و به همه ی سوالات اجباری پاسخ داده بود
                changeStatus(id, statues_sabteNahei, db);
                message = "پاسخ شما در سامانه ثبت نهایی شد";
                script += "addFormIdToCookie(" + formId + ");\n";//در کوکی ست کنیم که این فرم قبلا ثبت نهایی شده است
            } else {
                changeStatus(id, statues_sabteAvalie, db);
                if (!qNo.isEmpty()) {// اگر به سوالات اجباری پاسخ نداده بود
                    message = "شما به " + qNo + "پاسخ نداده اید ";
                }
                message += ". فرم شما موقتا ثبت شد";
                script += "removeFormIdFromCookie(" + formId + ");\n";//در کوکی پاک کنیم که این فرم قبلا ثبت نهایی شده است
            }
            //==========================================================
            script += Js.setVal("#" + tableName + "_id", id);// وقتی که آی دی را بگذاریم در فرم سمت جاوا اسکریپت کنترل می کنیم که کدام تابع صدا زده بشود
            script += Js.modal(message, "پیام سامانه");
            script += "$('#formAnserSetBtn').html('');\n";// برای اینکه کاربر نتواند دکمه درج را مجدد بزند
            script += "window.location.replace('Server?do=FormAnswerSet.selectToEdit&formAnswers_formId=" + formId + "&id=" + id + "');\n";// برای اینکه کاربر نتواند دکمه درج را مجدد بزند

//                    return "alert('" + message + "')";//@ToDo چون رکورد فرم ثبت شده باید دکمه ثبت را به ویرایش تغییر بدهیم
            //@ToDo فرم بعد از این فرم چه باید باشد و صدا زدن ان در ثبت نهایی
            Server.outPrinter(request, response, script);
            return Js.setVal("#" + tableName + "_id", id);
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String changeStatus(String id, String newStatus, jjDatabaseWeb db) throws Exception {
        try {
            if (!jjNumber.isDigit(id)) {
                return "خطا در تغییر وضعیت  12-375";
            }
            db.otherStatement("UPDATE " + tableName + " SET " + _statusLog
                    + "=concat(ifnull(" + _statusLog + ",''),'"
                    + newStatus
                    + ","
                    + jjCalendar_IR.getViewFormat(new jjCalendar_IR().getDBFormat_8length())
                    + ","
                    + new jjCalendar_IR().getTimeFormat_8length()
                    + "%23A%23"
                    + "') ,"
                    + _status + "='" + newStatus + "'  WHERE id=" + id + ";");
            return "";
        } catch (Exception ex) {
            System.out.println("err: عملیات تغییر وضعیت به درستی صورت نگرفت.12-390");
            Server.ErrorHandler(ex);
            return "عملیات تغییر وضعیت به درستی صورت نگرفت.12-390";
        }
    }

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
        if (!hasAccess.equals("")) {
            return Js.modal(hasAccess, "پیام سامانه");
        }
        String formId = jjTools.getParameter(request, _formId);
        String id = jjTools.getParameter(request, _id);
        //اگر پاسخ را ثبت نهایی کرده بود  امکان تغییر ندارد
        if (db.Select(tableName, _id + "=" + id + " AND " + _status + "='" + statues_sabteNahei + "'").getRowCount() == 1) {
            Server.outPrinter(request, response, Js.modal("امکان ویرایش فرمی که ثبت نهایی شده وجود ندارد", "فرم قبلا ثبت نهایی شده!"));
            return "امکان ویرایش فرمی که ثبت نهایی شده وجود ندارد";
        }
        //@ToDo هرکسی بتواند فقط فرم خودش را ویرایش کند
        String script = "";
        List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(Forms.tableName, Forms._id + "=" + formId));
        String userMAC = jjTools.getCookie(request, "#USER_MAC");
        if (formRow.isEmpty()) {
            Server.outPrinter(request, response, "این فرم وجود ندارد");
            return "این فرم وجود ندارد";
        } else if (formRow.get(0).get(Forms._uniqueComplete).toString().equals("1")) {// اگر فرم باید توسط هر کاربر بصورت یونیک پر شود
            //چک می کنیم که قبلا این کاربر یا این مک آدرس فرم را پر نکرده باشد
            String where = _formId + "=" + formId + " AND (" + _userId + "=" + jjTools.getSeassionUserId(request) + " OR "
                    + _userMAC + "=" + userMAC + ") AND " + _status + "=" + statues_sabteNahei;// جایی که پاسخ در حالت ثبت نهایی نباشد و با همین فرم آی دی و همین کاربر یا همین مک
            List<Map<String, Object>> uniqueForm = jjDatabaseWeb.separateRow(db.Select(tableName, where));
            if (!uniqueForm.isEmpty()) {
                script = "alert('این فرم قبلا توسط شما تکمیل شده است و شما مجازهستید فقط یکبار این فرم را تکمیل کنید');\n";
                script += Js.setHtml("#formAnserSetBtn", "این فرم قبلا توسط شما تکمیل شده است و شما مجازهستید فقط یکبار این فرم را تکمیل کنید");
                Server.outPrinter(request, response, script);
                return script;
            }
        }
        Map<String, Object> map = new HashMap();
        map.put(_formId, formId);
        map.put(_userId, jjTools.getSeassionUserId(request));
        if (jjTools.getSeassionUserRole(request).split("%23A%23").length > 1) {// اگر بیشتر از یک نقش در سشن داشت از ریکوئست نقش انتخابی کاربر را بخواند
            map.put(_userRole, jjTools.getParameter(request, _userRole));
        } else {// در غیر اینصورت نقش را  از سشن بخواند که ممکن است تهی باشدیعنی نقشی نداشته باشد
            map.put(_userRole, jjTools.getSeassionUserRole(request));
        }
        map.put(_userName, jjTools.getSeassionUserNameAndFamily(request));
        map.put(_userMAC, userMAC);
        map.put(_userIPV4, jjTools.getuserIP(request));
        map.put(_userIPV6, jjTools.getuserIP(request));
        jjCalendar_IR date = new jjCalendar_IR();
        map.put(_date, date.getDBFormat_8length());
        map.put(_time, date.getTimeFormat_4length());

        //آپدیت یک ست پاسخ در دیتابیس برای اتصال پاسخ های تکی به هم
        if (!db.update(tableName, map, _id + "=" + id)) {
            String errorMessage = "عملیات ویاریش به درستی صورت نگرفت. 12-324";
            Server.outPrinter(request, response, "alert('" + errorMessage + "')");
            return Js.modal(errorMessage, "پیام سامانه");
        }

        changeStatus(_id, statues_sabteAvalie, db);
        //ویژگی : اگر ادمین سوالات یک فرم را کم یا زیاد کند در ویرایش آم فرم اشکالی بوجود نمی آید
        List<Map<String, Object>> questions = jjDatabaseWeb.separateRow(db.Select(FormQuestions.tableName, FormQuestions._formID + "=" + formId));
        //ویژگی : سوالات اجباری را در هنگام ویرایش هشدار می دهد
        boolean flag = true;
        String qNo = "";
        for (int i = 0; i < questions.size(); i++) {//برای هر سوال
            map.clear();
            String answer = jjTools.getParameter(request, "q" + questions.get(i).get(FormQuestions._id));
            map.put(FormAnswers._answer, answer.replaceAll("#A#", "%23A%23"));// از ریکوئست بخوانیم مقدار پاسخ جدید را
            if (!db.update(FormAnswers.tableName, map, FormAnswers._answerSet_id + "=" + id + " AND " + FormAnswers._questionId + "=" + questions.get(i).get(FormQuestions._id))) {//اگر قبلا پاسخی وجود داشت که بروز رسانی بکن و اگر نداشت اینسرت کن
                map.put(FormAnswers._answerSet_id, id);//اینجا سوالی که قبلا نبوده اضافه شده و باید پاسخ داده شود
                map.put(FormAnswers._questionId, questions.get(i).get(FormQuestions._id));
                db.insert(FormAnswers.tableName, map);
            }
            if (questions.get(i).get(FormQuestions._isRequierd).equals("1") && answer.isEmpty()) {//در ثبت نهایی اگر پاسخ سوالی ضروری بود و کاربر پاسخ نداده بود باید فرم را از حالت ثبت نهایی خارج کنیم
                flag = false;
                qNo += "سوال شماره ی" + (i + 1) + "،";//سوال هایی که ضروری هستند و پاسخ داده نشده اند
            }
        }
        //ویژگی : تغییر وضعیت هنگام ویرایش یا ثبت نهایی فرم
        String message = "";
        if (jjTools.getParameter(request, _status).equals(statues_sabteNahei) && flag) {//اگر درخواست ثبت نهایی بود و به همه ی سوالات اجباری پاسخ داده بود
            changeStatus(id, statues_sabteNahei, db);
            message = "پاسخ شما در سامانه ثبت نهایی شد";
            if (formRow.get(0).get(Forms._uniqueComplete).equals("1")) {
                script += "addFormIdToCookie(" + formId + ");\n";//در کوکی ست کنیم که این فرم قبلا ثبت نهایی شده است                
            }else{
                script += "removeFormIdFromCookie(" + formId + ");\n";//در کوکی پاک کنیم که این فرم قبلا ثبت نهایی شده است
            }
        } else {
            changeStatus(id, statues_sabteAvalie, db);
            if (!qNo.isEmpty()) {// اگر به سوالات اجباری پاسخ نداده بود
                message = "شما به " + qNo + "پاسخ نداده اید ";
            }
            message += ". فرم شما موقتا ثبت شد";
            
//            script += "window.location.replace('Server?do=FormAnswerSet.selectToEdit&formAnswers_formId=" + formId + "&id=" + id + "');\n";// برای اینکه کاربر نتواند دکمه درج را مجدد بزند
        }
        //==========================================================
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        script += Js.setVal("#" + tableName + "_id", id);// وقتی که آی دی را بگذاریم در فرم سمت جاوا اسکریپت کنترل می کنیم که کدام تابع صدا زده بشود
        script += Js.modal(message, "پیام سامانه");
        //@ToDo فرم بعد از این فرم چه باید باشد و صدا زدن ان در ثبت نهایی
        Server.outPrinter(request, response, script);
        return script;

    }

    public static String getClassByStatus(String status) {
        if (status.equals(statues_sabteAvalie)) {
            return "yellow";
        } else if (status.equals(statues_sabteNahei)) {
            return "green";
        }
        return "";
    }

    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return Js.modal(hasAccess, "پیام سامانه");
            }

            request.getRequestDispatcher("feiz/newFormToComplete.jsp").forward(request, response);

            String id = jjTools.getParameter(request, _id);
            List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));
            if (formRow.isEmpty()) {
                String errorMessage = "فرم مورد نظر یافت نشد";
                return Js.modal(errorMessage, "پیام سامانه");
            }
            StringBuilder script = new StringBuilder();
            Map<String, Object> map = new HashMap<String, Object>();
            script.append(Js.setVal("#" + tableName + "_id", formRow.get(0).get(_id).toString()));
//            script.append(Js.setVal("#" + _title, formRow.get(0).get(_title).toString()));
//            script.append(Js.setVal("#" + _code, formRow.get(0).get(_code).toString()));
//            script.append(Js.setVal("#" + _departments, formRow.get(0).get(_departments).toString()));
//            script.append("$('#forms_departments').select2();\n");
//            script.append(Js.setVal("#" + _isActive, formRow.get(0).get(_isActive).toString()));
//            script.append(Js.setVal("#" + _icon, formRow.get(0).get(_icon).toString()));
//            if (!formRow.get(0).get(_icon).toString().isEmpty()) {//اگر عکس داشت نشان بدهد
//                script.append(Js.setAttr("#forms_icon_Preview", "src", "upload/" + formRow.get(0).get(_icon).toString()));
//            }
//            script.append(Js.setVal("#" + _ownerId, formRow.get(0).get(_ownerId).toString()));
//            script.append(Js.setVal("#" + _ownerRole, formRow.get(0).get(_ownerRole).toString()));
//            script.append(Js.setVal("#" + _accessessUsers, formRow.get(0).get(_accessessUsers).toString()));
//            script.append(Js.setVal("#" + _accessessRoles, formRow.get(0).get(_accessessRoles).toString()));
//
//            script.append(Js.setVal("#" + _creationDate, jjCalendar_IR.getViewFormat(formRow.get(0).get(_creationDate).toString())));
//            script.append(Js.setVal("#" + _expireDate, jjCalendar_IR.getViewFormat(formRow.get(0).get(_expireDate).toString())));
//            jjCalendar_IR date = new jjCalendar_IR();
//
//            script.append(Js.setVal("#" + _creationTime, jj.jjTime.getTime5lenth(formRow.get(0).get(_creationTime).toString())));
//            script.append(Js.setVal("#" + _expireTime, jj.jjTime.getTime5lenth(formRow.get(0).get(_expireTime).toString())));
//
//            script.append(Js.setVal("#" + _nextFormId, formRow.get(0).get(_nextFormId).toString()));
//            script.append(Js.setVal("#" + _isAutoWiki, formRow.get(0).get(_isAutoWiki).toString()));
//            script.append(Js.setVal("#" + _hasAutoWikiInContent, formRow.get(0).get(_hasAutoWikiInContent).toString()));
//            script.append(Js.setVal("#" + _css, formRow.get(0).get(_css).toString()));
//            script.append(Js.setVal("#" + _javaScript, formRow.get(0).get(_javaScript).toString()));
//            script.append(Js.setValSummerNote("#" + _htmlContent, formRow.get(0).get(_htmlContent).toString()));
//            script.append(Js.setVal("#" + _description, formRow.get(0).get(_description).toString()));
//            script.append(Js.setVal("#" + _description, formRow.get(0).get(_description).toString()));
            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjForms.edit(id) + "' id='edit_Forms_new'>" + lbl_edit + "</button></div>";
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjForms.delete(id) + "' id='edit_Forms_new'>" + lbl_delete + "</button></div>";
            }
            script.append(Js.setHtml("#forms_buttons", htmlBottons));
            //کاربر بعد از ثبت مشخصات فرم یاد سوالات فرم را یکی یکی یا دسته ای اضافه کند
            return script.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                return Js.modal(hasAccess, "پیام سامانه");
            } else {
                String id = jjTools.getParameter(request, _id);
                if (!jjNumber.isDigit(id)) {
                    return Js.modal("کد صحیح نیست", "پیام سامانه");
                }

//                db.Select(tableName)//در پاسخ ها اگر کسی پاسخ نداده است قابل حذف است@ToDo
                if (db.otherStatement("DELETE t0,t1,t2 FROM hmis_forms as t0 LEFT JOIN hmis_formquestions as t1 on t0.id=t1.formQuestions_formID LEFT JOIN hmis_formquestionoptions as t2 ON formQuestionOptions_question_id = t1.id WHERE t0.id=" + id)) {
                    return Js.jjForms.refresh() + Js.modal("همه سوال ها و گزینه ها حذف شدند", "پیام سامانه");
                } else {
                    return Js.modal("عدم موفقیت عملیات حذف!!!", "پیام سامانه");
                }
            }

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

}
