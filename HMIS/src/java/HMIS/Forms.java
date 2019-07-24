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
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;
import jj.jjCalendar_IR;
import jj.jjDatabaseWeb;
import jj.jjNumber;

/**
 *
 * @author Mohammad
 */
public class Forms {

    public static final String tableName = "hmis_forms";
    public static final String _id = "id";
    public static final String _code = "forms_code";
    public static final String _title = "forms_title";
    public static final String _category_id = "forms_category_id";
    public static final String _priority = "forms_priority";
//    دسترسی های یک فرم برای پر کردن فرم ها
    public static final String _departments = "forms_departments";//بخش یا بخش هایی که این فرم را باید ببینند
    public static final String _accessessRoles = "forms_accesseRoles";//سمت هایی که به این فرم دسترسی 
    public static final String _accessessUsers = "forms_accessesUsers";// اشخاصی که به این فرم دسترسی 
//    
    public static final String _tags = "forms_tags";//برچسب هایی که میتوان به این فرم داد و بر اساس برچسب ها در بخش های مختلف نشان داده شود
    public static final String _icon = "forms_icon";
    public static final String _description = "forms_discription";
    public static final String _htmlContent = "forms_htmlContent";
    public static final String _ownerId = "forms_ownerId";//آی دی ایجاد کننده ی فرم
    public static final String _ownerRole = "forms_ownerRole";//سمت ایجاد کننده ی فرم
    public static final String _resultAccessRole = "forms_resultAccessRole";//نتایج آماری را به چه نقش هایی نشان بدهیم
    public static final String _resultAccessUsers = "forms_resultAccessUsers";//شخص هایی که میتوانند نتایج آماری را ببینند
    public static final String _isActive = "forms_isActive";//سمت ایجاد کننده ی فرم
    public static final String _creationDate = "forms_creationDate";
    public static final String _creationTime = "forms_creationTime";
    public static final String _expireDate = "forms_expireDate";
    public static final String _expireTime = "forms_expireTime";
    public static final String _css = "forms_css";// برای قراردادن کد های سی اس اس
    public static final String _javaScript = "forms_javaScript";// برای قراردادن کد های جاوا اسکریپت
    public static final String _visit = "forms_visit";
    public static final String _nextFormId = "forms_nextFormId";// آی دی فرم بعدی که بعد از این فرم باید لود بشود
    public static final String _isAutoWiki = "forms_isAutoWiki";//برای این فرم لینک اتو ویکی در محتوا ساخته شود یا خیر
    public static final String _showResultToQuestioner = "forms_showResultToQuestioner";//کسی که فرم را پر می کند نتیجه ی آزمونش را همان موقع ببیند یا نه
    public static final String _showAllResultToQuestioner = "forms_showAllResultToQuestioner";//کسی که فرم را پر می کند نتیجه ی آمار را همان موقع ببیند یا نه
    public static final String _showCometePreAproveForm = "forms_showCometePreAproveForm";//کسی که فرم را پر می کند نتیجه ی آمار را همان موقع ببیند یا نه
    public static final String _uniqueComplete = "forms_uniqueComplete";//کسی که فرم را پر می کند نتیجه ی آمار را همان موقع ببیند یا نه
    public static final String _hasAutoWikiInContent = "forms_hasAutoWikiInContent";//در محتوای این فرم اتو ویکی فعال باشد یا نه

    public static final String lbl_insert = "ثبت و افزودن سوال";
    public static final String lbl_delete = "حذف فرم";
    public static final String lbl_edit = "ثبت ویرایش";
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
    public static final String lbl_edit_ln2 = "ویرایش بخش انگلیسی";
    public static final String lbl_add_ln3 = "افزودن زبان عربی";
    public static final String lbl_edit_ln3 = "ویرایش بخش عربی";
    public static final String lbl_add_ln4 = "افزودن زبان آلمانی";
    public static final String lbl_edit_ln4 = "ویرایش بخش آلمانی";
    public static final String lbl_add_ln5 = "افزودن زبان چینی";
    public static final String lbl_edit_ln5 = "ویرایش بخش چینی";

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            DefaultTableModel dtm = db.Select(tableName);//@ToDo فقط ستون هایی که لازم هست را بگیریم که در مصرف حاقظه رم سرفه جویی بشود
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(dtm);
            StringBuilder html = new StringBuilder();
            html.append("<div class='card-header bg-primary tx-white'>لیست فرم ها و چک لیست های تعریف شده</div>\n");
            html.append("<div class='card-body pd-sm-30'>");
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                html.append("<p class='mg-b-20 mg-sm-b-30'>");
                html.append("<a style='color:#fff' class='btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white' onclick='hmisForms.m_add_new();' >فرم یا چک لیست جدید</a>");
                html.append("</p>");
            }
            html.append("<div class='table-wrapper'>");
            html.append("<table id='refreshForms' class='table display responsive' class='tahoma10' style='direction: rtl'><thead>");
            html.append("<th width='5%' class='r'>کد</th>");
            html.append("<th width='20%' class='r'>عنوان فرم</th>");
            html.append("<th width='20%' class='c'>ویرایش و اصلاح</th>");
            html.append("<th width='20%' class='c'>آنالیز و آمار</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  class='mousePointer'>");
                html.append("<td class='r'>" + row.get(i).get(_code) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_title) + "</td>");
                html.append("<td class='c'><i class='p icon ion-ios-gear-outline' onclick='" + Js.jjForms.select(row.get(i).get(_id).toString()) + "' style='color:#ffcd00!important'></i></td>");
                html.append("<td class='c'><i class='p fa fa-bar-chart' onclick='" + Js.jjForms.select(row.get(i).get(_id).toString()) + "'></i></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            html.append("</div>");
            html.append("</div>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "";
            }
            if (panel.equals("")) {
                panel = "swNewsTbl";
            }
            String script = Js.setHtml("#" + panel, html.toString());
            script += Js.table("#refreshForms", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "2" : "", "لیست فرم ها");
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            StringBuilder script = new StringBuilder();
            if (!accIns) {
                script.append(Js.setHtml("#forms_buttons", ""));
                script.append(Js.modal("لطفا دوباره وارد شوید", "شما دسترسی به این قسمت ندارد"));
                Server.outPrinter(request, response, script);
                return "";
            }
            List<Map<String, Object>> userRow = jjDatabaseWeb.separateRow(db.Select(Access_User.tableName, _id + "=" + jjTools.getSeassionUserId(request)));//برای استخراج نام و نام خانوادگی کاربری که در سشن فعال است
            script.append(Js.setVal(_ownerId, jjTools.getSeassionUserId(request)));
            script.append(Js.setVal("#forms_ownerName", userRow.get(0).get(Access_User._name).toString() + " " + userRow.get(0).get(Access_User._family).toString()));
            String userRolesOptions = Role.getUeserRolesSelectOption(request, response, db, true);
            if (!userRolesOptions.isEmpty()) {// ممکن است کاربر جاری نقشی در سیستم نداشته باشد ولی دسترسی هایی داشته باشد
                script.append(Js.setHtml("#" + _ownerRole, userRolesOptions));
            } else {
                script.append(Js.setVal("#" + _ownerRole, "<option value=''></option>"));
            }
            script.append(Js.setVal("#" + _creationDate, jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length(null, true))));
            script.append(Js.setVal("#" + _creationTime, jj.jjTime.getTime5lenth("")));

            script.append(Js.select2("#" + _ownerRole, "width:'100%'"));
            script.append(Js.setHtml("#forms_buttons", "<div class='col-lg-6'><input type='button' id='insert_Forms_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success btn-block mg-b-10'></div>"));
            script.append(Js.click("#insert_Forms_new", Js.jjForms.insert()));
            Server.outPrinter(request, response, script.toString());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     *
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
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_code, jjTools.getParameter(request, _code));
            map.put(_departments, jjTools.getParameter(request, _departments));
            map.put(_isActive, jjTools.getParameter(request, _isActive));
            map.put(_icon, jjTools.getParameter(request, _icon));
            map.put(_ownerId, jjTools.getSeassionUserId(request));
            map.put(_ownerRole, jjTools.getParameter(request, _ownerRole));

            map.put(_accessessUsers, jjTools.getParameter(request, _accessessUsers).replaceAll(",", "%23A%23"));
            map.put(_accessessRoles, jjTools.getParameter(request, _accessessRoles).replaceAll(",", "%23A%23"));
            map.put(_resultAccessUsers, jjTools.getParameter(request, _resultAccessUsers).replaceAll(",", "%23A%23"));
            map.put(_resultAccessRole, jjTools.getParameter(request, _resultAccessRole).replaceAll(",", "%23A%23"));
            if ("".equals(jjTools.getParameter(request, _creationDate))) {// اگر تاریخ شروع اعتبار وارد نکرده بود
                map.put(_creationDate, jjCalendar_IR.getDatabaseFormat_8length(null, true));
            } else {
                map.put(_creationDate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _accessessRoles), true));
            }
            jjCalendar_IR date = new jjCalendar_IR();
            map.put(_creationTime, jj.jjTime.getTime4lenth(jjTools.getParameter(request, _creationTime)));
            map.put(_expireDate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _expireDate), false));
            map.put(_expireTime, jj.jjTime.getTime4lenth(jjTools.getParameter(request, _expireTime)));
            map.put(_nextFormId, jjNumber.isDigit(jjTools.getParameter(request, _nextFormId)));
            map.put(_isAutoWiki, jjTools.getParameter(request, _isAutoWiki));
            map.put(_uniqueComplete, jjTools.getParameter(request, _uniqueComplete));
            map.put(_showResultToQuestioner, jjTools.getParameter(request, _showResultToQuestioner));
            map.put(_showAllResultToQuestioner, jjTools.getParameter(request, _showAllResultToQuestioner));
            map.put(_showCometePreAproveForm, jjTools.getParameter(request, _showCometePreAproveForm));
            map.put(_hasAutoWikiInContent, jjTools.getParameter(request, _hasAutoWikiInContent));
            map.put(_css, jjTools.getParameter(request, _css));
            map.put(_javaScript, jjTools.getParameter(request, _javaScript));
            map.put(_htmlContent, jjTools.getParameter(request, _htmlContent));
            map.put(_description, jjTools.getParameter(request, _description));

            List<Map<String, Object>> insertedFormRow = jjDatabaseWeb.separateRow(db.insert(tableName, map));
            StringBuilder script = new StringBuilder();
            if (insertedFormRow.isEmpty()) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            script.append(Js.jjForms.refresh());
            //کاربر بعد از ثبت مشخصات فرم یاد سوالات فرم را یکی یکی یا دسته ای اضافه کند
            script.append(Js.jjForms.select(insertedFormRow.get(0).get(_id).toString()));// برای اینکه در واقع مثل موقعی بشود که یک فرم قبلا ثبت شده را انتخاب کرده سلکت جاوا اسکریپتی را بعد از اینسرت صدا میزنیم
            Server.outPrinter(request, response, script.toString());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            String id = jjTools.getParameter(request, _id);
            List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));
            if (formRow.isEmpty()) {
                String errorMessage = "فرم مورد نظر یافت نشد";
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            StringBuilder script = new StringBuilder();
            Map<String, Object> map = new HashMap<String, Object>();
            script.append(Js.setVal("#" + tableName + "_id", formRow.get(0).get(_id).toString()));
            script.append(Js.setVal("#" + _title, formRow.get(0).get(_title).toString()));
            script.append(Js.setVal("#" + _code, formRow.get(0).get(_code).toString()));
            script.append(Js.setVal("#" + _departments, formRow.get(0).get(_departments).toString()));
            script.append("$('#forms_departments').select2();\n");
            script.append(Js.setVal("#" + _isActive, formRow.get(0).get(_isActive)));
            script.append(Js.setVal("#" + _icon, formRow.get(0).get(_icon).toString()));
            if (!formRow.get(0).get(_icon).toString().isEmpty()) {//اگر عکس داشت نشان بدهد
                script.append(Js.setAttr("#forms_icon_Preview", "src", "upload/" + formRow.get(0).get(_icon).toString()));
            }
            script.append(Js.setVal("#" + _ownerId, formRow.get(0).get(_ownerId)));
            script.append(Js.setVal("#" + _ownerRole, formRow.get(0).get(_ownerRole).toString()));
            script.append(Js.setValSelectOption("#" + _accessessUsers, formRow.get(0).get(_accessessUsers).toString()));
            script.append(Js.select2("#" + _accessessUsers, ""));
            script.append(Js.setValSelectOption("#" + _accessessRoles, formRow.get(0).get(_accessessRoles).toString()));
            script.append(Js.select2("#" + _accessessRoles, ""));
            script.append(Js.setValSelectOption("#" + _resultAccessRole, formRow.get(0).get(_resultAccessRole).toString()));
            script.append(Js.select2("#" + _resultAccessRole, ""));
            script.append(Js.setValSelectOption("#" + _resultAccessUsers, formRow.get(0).get(_resultAccessUsers).toString()));
            script.append(Js.select2("#" + _resultAccessUsers, ""));

            script.append(Js.setVal("#" + _creationDate, jjCalendar_IR.getViewFormat(formRow.get(0).get(_creationDate).toString())));
            script.append(Js.setVal("#" + _expireDate, jjCalendar_IR.getViewFormat(formRow.get(0).get(_expireDate).toString())));
            jjCalendar_IR date = new jjCalendar_IR();

            script.append(Js.setVal("#" + _creationTime, jj.jjTime.getTime5lenth(formRow.get(0).get(_creationTime).toString())));
            script.append(Js.setVal("#" + _expireTime, jj.jjTime.getTime5lenth(formRow.get(0).get(_expireTime).toString())));

            script.append(Js.setVal("#" + _nextFormId, formRow.get(0).get(_nextFormId).toString()));
            script.append(Js.setVal("#" + _isAutoWiki, formRow.get(0).get(_isAutoWiki).toString()));
            script.append(Js.setVal("#" + _uniqueComplete, formRow.get(0).get(_uniqueComplete).toString()));
            script.append(Js.setVal("#" + _showAllResultToQuestioner, formRow.get(0).get(_showAllResultToQuestioner)));
            script.append(Js.setVal("#" + _showCometePreAproveForm, formRow.get(0).get(_showCometePreAproveForm)));
            script.append(Js.setVal("#" + _showResultToQuestioner, formRow.get(0).get(_showResultToQuestioner)));
            script.append(Js.setVal("#" + _hasAutoWikiInContent, formRow.get(0).get(_hasAutoWikiInContent)));
            script.append(Js.setVal("#" + _css, formRow.get(0).get(_css).toString()));
            script.append(Js.setVal("#" + _javaScript, formRow.get(0).get(_javaScript).toString()));
            script.append(Js.setValSummerNote("#" + _htmlContent, formRow.get(0).get(_htmlContent).toString()));
            script.append(Js.setVal("#" + _description, formRow.get(0).get(_description).toString()));
            script.append(Js.setVal("#" + _description, formRow.get(0).get(_description).toString()));
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
            Server.outPrinter(request, response, script.toString());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            String id = jjTools.getParameter(request, _id);
            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_code, jjTools.getParameter(request, _code));
            map.put(_departments, jjTools.getParameter(request, _departments));
            map.put(_isActive, jjTools.getParameter(request, _isActive));
            map.put(_icon, jjTools.getParameter(request, _icon));
            map.put(_ownerId, jjTools.getSeassionUserId(request));
            //تعیین نقش ایجاد کننده یا مالک فرم            
            // ممکن است ادمین بخواهد برای سایرین فرم ها را ایجاد کند و باید این امکان را داشته باشد
            if (!jjNumber.isDigit(jjTools.getParameter(request, _accessessUsers))) {//اگر در ریکوئست مشخص نکرده بود
                String userRolesInSession = jjTools.getSeassionUserRole(request);
                String userRols[] = userRolesInSession.split(",");
                if (userRols.length == 0) {// اگر نقشی در سیستم نداشت تهی می گذاریم
                    map.put(_ownerRole, "");
                } else {
                    // اگرچند نقش داشت و  مشخص نکرده بود نقش اولی اش را می گذاریم یا تهی می گذاریم
                    map.put(_ownerRole, userRols[0]);
                }
            } else {
                map.put(_ownerRole, jjTools.getSeassionUserRole(request));
            }
            map.put(_accessessUsers, jjTools.getParameter(request, _accessessUsers));
            map.put(_accessessRoles, jjTools.getParameter(request, _accessessRoles));
            map.put(_resultAccessUsers, jjTools.getParameter(request, _resultAccessUsers));
            map.put(_resultAccessRole, jjTools.getParameter(request, _resultAccessRole));
            if ("".equals(jjTools.getParameter(request, _creationDate))) {// اگر تاریخ شروع اعتبار وارد نکرده بود
                map.put(_creationDate, jjCalendar_IR.getDatabaseFormat_8length(null, true));
            } else {
                map.put(_creationDate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _creationDate), true));
            }
            jjCalendar_IR date = new jjCalendar_IR();
            map.put(_creationTime, jj.jjTime.getTime4lenth(jjTools.getParameter(request, _creationTime)));//ToDo تبدیل به عدد برای قرار گرفتن در دیتا بیس
            map.put(_expireDate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _expireDate), false));
            map.put(_expireTime, jj.jjTime.getTime4lenth(jjTools.getParameter(request, _expireTime)));
            map.put(_nextFormId, jjNumber.isDigit(jjTools.getParameter(request, _nextFormId)));
            map.put(_isAutoWiki, jjTools.getParameter(request, _isAutoWiki));
            map.put(_uniqueComplete, jjTools.getParameter(request, _uniqueComplete));
            map.put(_showResultToQuestioner, jjTools.getParameter(request, _showResultToQuestioner));
            map.put(_showAllResultToQuestioner, jjTools.getParameter(request, _showAllResultToQuestioner));
            map.put(_showCometePreAproveForm, jjTools.getParameter(request, _showCometePreAproveForm));
            map.put(_hasAutoWikiInContent, jjTools.getParameter(request, _hasAutoWikiInContent));
            map.put(_css, jjTools.getParameter(request, _css));
            map.put(_javaScript, jjTools.getParameter(request, _javaScript));
            map.put(_htmlContent, jjTools.getParameter(request, _htmlContent));
            map.put(_description, jjTools.getParameter(request, _description));
            if (db.update(tableName, map, _id + "=" + id)) {
                Server.outPrinter(request, response, Js.modal("ویرایش بدرستی انجام شد", "پیام سامانه"));
                return "";
            } else {
                Server.outPrinter(request, response, Js.modal("ویرایش انجام نشد", "پیام سامانه"));
                return "";
            }
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            } else {
                String id = jjTools.getParameter(request, _id);
                if (!jjNumber.isDigit(id)) {
                    Server.outPrinter(request, response, Js.modal("کد صحیح نیست", "پیام سامانه"));
                    return "";
                }

//                db.Select(tableName)//در پاسخ ها اگر کسی پاسخ نداده است قابل حذف است@ToDo
                if (db.otherStatement("DELETE t0,t1,t2 FROM hmis_forms as t0 LEFT JOIN hmis_formquestions as t1 on t0.id=t1.formQuestions_formID LEFT JOIN hmis_formquestionoptions as t2 ON formQuestionOptions_question_id = t1.id WHERE t0.id=" + id)) {
                    Server.outPrinter(request, response, Js.jjForms.refresh() + Js.modal("همه سوال ها و گزینه ها حذف شدند", "پیام سامانه"));
                    return "";
                } else {
                    Server.outPrinter(request, response, Js.modal("عدم موفقیت عملیات حذف!!!", "پیام سامانه"));
                    return "";
                }
            }

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * برای ایجاد نمودار آنالیزی فرم روی یک سوال یا تک تک سوالات
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String analysFromByQuestion(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
//            if (!hasAccess.equals("")) {
//                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
//                return "";
//            } else {
//                String id = jjTools.getParameter(request, _id);
//                if (!jjNumber.isDigit(id)) {
//                    Server.outPrinter(request, response, Js.modal("کد صحیح نیست", "پیام سامانه"));
//                    return "";
//                }
//            }
            String questionId = jjTools.getParameter(request, "hmis_formquestions_id");
            String labels = "";
            String data = "";

            String dateCondition = "";
            if (!jjTools.getParameter(request, "formAnswers_date_from").isEmpty()) {
                dateCondition += " AND " + FormAnswerSet._date + ">" + jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, "formAnswers_date_from"), false) + " ";//تاریخ را بصورت عددی در میآوریم که راحت مقایسه بشود
            }
            if (!jjTools.getParameter(request, "formAnswers_date_to").isEmpty()) {
                dateCondition += " AND " + FormAnswerSet._date + "<" + jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, "formAnswers_date_to"), false) + " ";//تاریخ را بصورت عددی در میآوریم که راحت مقایسه بشود
            }
            String roleCondition = "";
            if (!jjTools.getParameter(request, FormAnswerSet._userRole).isEmpty()) {// اگر فیلتر روی نقش خاصی میخواست
                String role[] = jjTools.getParameter(request, FormAnswerSet._userRole).split(",");
                if (jjNumber.isDigit(role[0])) {// اگر اولین نقش عدد بود مشکلی پیش نمی آید برای بقیه
                    roleCondition += " AND ( " + FormAnswerSet._userRole + "=" + role[0];// برای اولین نقش شرط پرانتز می خواهد
                    for (int i = 1; i < role.length; i++) {// برای نقش های انتخابی دیگر
                        if (jjNumber.isDigit(role[i])) {// اگر کد مورد نظر عددی باشد ، برای همه ی نقش ها ممکن است تهی بیاید
                            System.out.println(role[i]);
                            roleCondition += " OR " + FormAnswerSet._userRole + "=" + role[i];
                        }
                    }
                    roleCondition += ")";
                } else {// اگر اولین نقش عدد نبود احتمالا همه است و روی نقش ها حساسیت نمی گذاریم اگر چیزی نگذارید نال است
                    roleCondition += "";// برای اولین نقش شرط پرانتز می خواهد
                }
            }

            if (jjNumber.isDigit(questionId)) {// اگر درخواست نمودار روی فقط یک سوال بود
                //خط زیر برای اینکه فیلتر کنیم فرم هایی که مثلا  سوال یک را گزینه دو انتخاب کرده اند
                String ansertSetSQL = "";// برای اعمال فیلتر با توجه به یک جواب خاص
                if (!jjTools.getParameter(request, "hmis_filter_formquestion_id").isEmpty() && !jjTools.getParameter(request, "hmis_filter_formquestionOption_id").isEmpty()) {// اگر فیلتر بر اساس پاسخ های خاصی در ست پاسخ مد نظر بود
                    ansertSetSQL = "(SELECT "
                            + "formAnswers_date"
                            + ",formAnswers_status"
                            + ",formanswers_answerSet_id AS id "
                            + " FROM hmis_formanswers "
                            + " LEFT Join hmis_formAnswerSet ON formanswers_answerSet_id=hmis_formanswerset.id "
                            + " WHERE "
                            + " formanswers_questionId='" + jjTools.getParameter(request, "hmis_filter_formquestion_id") + "' AND formanswers_answer='" + jjTools.getParameter(request, "hmis_filter_formquestionOption_id") + "')";
                } else {
                    ansertSetSQL = FormAnswerSet.tableName;// اگر فیلتر خاصی مد نظر کاربر نبود همان جدول ست پاسخ ها را باید یگذاریم
                }
                List<Map<String, Object>> questionRow = jjDatabaseWeb.separateRow(db.Select(FormQuestions.tableName, FormQuestions._id + "=" + questionId));
                //ّبرای آپشن دار ها بر اساس آپشن ها نمودار می دهیم
                if (questionRow.get(0).get(FormQuestions._answersType).equals("radio") || questionRow.get(0).get(FormQuestions._answersType).equals("select_option") || questionRow.get(0).get(FormQuestions._answersType).equals("checkbox")) {
                    List<Map<String, Object>> optionRows = jjDatabaseWeb.separateRow(db.Select(FormQuestionOptions.tableName, FormQuestionOptions._question_id + "=" + questionId));
                    for (int i = 0; i < optionRows.size(); i++) {// برای هر آپشن موجود یک ستون با نام آن آپشن ایجاد می کنیم
                        labels += " '" + optionRows.get(i).get(FormQuestionOptions._lable).toString() + "(" + optionRows.get(i).get(FormQuestionOptions._value).toString() + ")',";// نام هر آپشن
                        // برای اینکه بفهمیم هر گزینه توسط همه کاربران چند بار انتخاب شده
                        //فقط تعداد سطرهایی که پاسخ ها دقیقا همین آپشن هستند و ست پاسخ هم در وضعیت ثبت نهایی باشد
                        List<Map<String, Object>> numbersOfThisOption = jjDatabaseWeb.separateRow(db.otherSelect(
                                "SELECT COUNT(*) AS no FROM " + ansertSetSQL + " ast left Join " + FormAnswers.tableName + " a on ast.id=a.formanswers_answerSet_id "
                                + "WHERE " + FormAnswers._questionId + "=" + questionId
                                + " AND " + FormAnswers._answer + "=" + optionRows.get(i).get(FormQuestionOptions._id)
                                + " AND " + FormAnswerSet._status + "= '" + FormAnswerSet.statues_sabteNahei + "'"
                                + roleCondition
                                + dateCondition
                        ));
                        String no = numbersOfThisOption.get(0).get("no").toString();// صفر یا بیشتر
                        data += "'" + no + "',";
                    }
                }
            }
            String script = "";
            script
                    += "var ctx1 = document.getElementById('chartBar1').getContext('2d');"
                    + "var myChart1 = new Chart(ctx1, {"
                    + "type: 'bar', data: {"
                    + "labels: ["
                    + labels
                    + "],"
                    + "datasets: [{"
                    + "label: '# of Votes',"
                    + "data: ["
                    + data
                    + "],"
                    + "backgroundColor: '#324463'"
                    + "}]"
                    + "},"
                    + "options: {"
                    + "legend: {"
                    + "display: true,"
                    + "labels: {"
                    + "display: true"
                    + "}"
                    + "},"
                    + "scales: {"
                    + "yAxes: [{"
                    + "ticks: {"
                    + "beginAtZero: true,"
                    + "fontSize: 10,"
                    + "}"
                    + "}],"
                    + "xAxes: [{"
                    + "ticks: {"
                    + "beginAtZero: true,"
                    + "fontSize: 11"
                    + "}"
                    + "}]"
                    + "}"
                    + "}"
                    + "});";
            script += Js.modal("http://kjhkk.com/Server?do=Forms.analysFromByQuestion", "لینک این گزارش را کپی کنید");
            Server.outPrinter(request, response, script);
            return script;
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * نمودار عملکرد پرسنل یا نقش ها روی یک فرم
     * <br/>
     * مثلا هر نفشی چند بار این فرم را پر کرده است
     * <br/>
     * یا هر فردی چند بار این فرم را پر کرده است
     * <br/>
     * یا در بازه های زمانی چطور این فرم را تکمیل کرده اند
     * <br/>
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String formCountResult_turnover(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
//            if (!hasAccess.equals("")) {
//                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
//                return "";
//            } else {
//                String id = jjTools.getParameter(request, _id);
//                if (!jjNumber.isDigit(id)) {
//                    Server.outPrinter(request, response, Js.modal("کد صحیح نیست", "پیام سامانه"));
//                    return "";
//                }
//            }
            String sql = "";
            String groupBy = "";
            String labels = "";//برای ایجاد آرایه در چارت جی اس
            String lableColumn = "";// برای اینکه در نتیجه  کوئری بدانیم بر چه اساسی نام ساتون ها را استحراج کنیم
            String axel_y = "";// آنچه کاربر می خواهد؛ مثلا تعداد فرم ها یا مجموع امتیازات هر کاربر یا میانگین
            String data = "";
            String dateCondition = " WHERE 1=1 ";// برای اینکه ممکن است تاریخ شروع یا تاریح پایان هر کدام را نداشته باشد
            if (!jjTools.getParameter(request, "formAnswers_date_from").isEmpty()) {
                dateCondition += " AND " + FormAnswerSet._date + ">" + jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, "formAnswers_date_from"), false) + " ";//تاریخ را بصورت عددی در میآوریم که راحت مقایسه بشود
            }
            if (!jjTools.getParameter(request, "formAnswers_date_to").isEmpty()) {
                dateCondition += " AND " + FormAnswerSet._date + "<" + jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, "formAnswers_date_to"), false) + " ";//تاریخ را بصورت عددی در میآوریم که راحت مقایسه بشود
            }
            // تعیین محور افقی----------------------------------------------------------------
            if (!jjTools.getParameter(request, "axel_x_roles").equals("")) {// اگر محور افقی را برا اساس نقش ها تعیین خواسته باشد
                lableColumn = Role._title;// چون با جدول نقش ها جوین می کنیم
                if (jjTools.getParameter(request, "axel_x_roles").equals("formAnswers_userRole")) {
                    groupBy = " GROUP BY " + FormAnswerSet._userRole;
                } else { // اگر یک یا چند عدد بود یعنی نمودار عملکرد آن نقش ها را می خواهد
                    String roles[] = jjTools.getParameter(request, "axel_x_roles").split(",");

                }
            } else if (jjTools.getParameter(request, "axel_x_users").equals("formAnswers_userName")) {// اگر کاربر انتخاب کرده بود که محور افقی بر اساس کاربران باشد کوئری اس کیو ال را بر این اساس گروه بندی می کنیم
                groupBy = " GROUP BY " + FormAnswerSet._userName;
                lableColumn = FormAnswerSet._userName;
            } else { // اگر یک یا چند عدد بود یعنی نمودار عملکرد آن افراد خاص را می خواهد
//                    jjTools.getParameter(request, "axel_x_users").st("formAnswers_userRole")) 

            }
            //------------------------------------------------------------------------------------
            String questionId = jjTools.getParameter(request, "axel_y");
            if (questionId.equals("COUNT(hmis_formanswerset.id)")) {
                axel_y = "COUNT(hmis_formanswerset.id)";
            } else if (questionId.equals("avg")) {
                axel_y = "avg(hmis_formanswerset_avg)";

            } else if (questionId.equals("sum")) {
                axel_y = "sum(hmis_formanswerset_sum)";
            }
            // تعریف معیار محور عمودی که مثلا تعداد فرم های پر شده باشد یا محموع یا میانگین یا غیره
            if (jjNumber.isDigit(questionId)) {// اگر یک سوال را انتخاب کرده بود ینابر این اینجا عدد داریم که آی دی سوال است
                // اگر سوال انتخاب شده یک سوال چند گزینه ای باشد و هدف جمع آوری مجموع ارزش های آن باشد
                List<Map<String, Object>> questionRow = jjDatabaseWeb.separateRow(db.Select(FormQuestions.tableName, FormQuestions._id + "=" + questionId));
                //ّبرای آپشن دار ها بر اساس آپشن ها نمودار می دهیم
                if (questionRow.get(0).get(FormQuestions._answersType).equals("radio")
                        || questionRow.get(0).get(FormQuestions._answersType).equals("select_option")
                        || questionRow.get(0).get(FormQuestions._answersType).equals("checkbox")) {
                    axel_y = "sum(formQuestionOptions_value)";
                    sql = "SELECT  " + axel_y + " as val," + lableColumn + "  FROM hmis_formanswerset "
                            + " LEFT JOIN hmis_role on hmis_role.id=formAnswers_userRole "
                            + " LEFT JOIN hmis_formanswers on hmis_formanswerset.id=formanswers_answerSet_id"
                            + " LEFT JOIN hmis_formquestionoptions on formanswers_answer=hmis_formquestionoptions.id"
                            + dateCondition
                            + " AND " + FormAnswers._questionId + "=" + questionId// ّرای محاسبه ی جاهایی که نوع فیلد عددی و جواب هم حتما عددی باشد
                            + groupBy + ";";

                } else if (questionRow.get(0).get(FormQuestions._answersType).equals("number")) {
                    axel_y = "sum(formanswers_answer)";
                    sql = "SELECT  " + axel_y + " as val," + lableColumn + "  FROM hmis_formanswerset "
                            + "LEFT JOIN hmis_role on hmis_role.id=formAnswers_userRole "
                            + "LEFT JOIN hmis_formanswers on hmis_formanswerset.id=formanswers_answerSet_id"
                            + dateCondition
                            + " AND " + FormAnswers._questionId + "=" + questionId// ّرای محاسبه ی جاهایی که نوع فیلد عددی و جواب هم حتما عددی باشد
                            + groupBy + ";";
                }
            } else {//اگر مورد بررسی پاسخ ها و در واقع  آی دی یک سوال نبود  و مجموع نتایج یا میانگین و یا تعداد فرم های پر شه بود
                sql = "SELECT  " + axel_y + " as val," + lableColumn + " FROM hmis_formanswerset "
                        + "LEFT JOIN hmis_role on hmis_role.id=formAnswers_userRole "
                        + dateCondition
                        + groupBy + ";";
            }

            //ّبرای آپشن دار ها بر اساس آپشن ها نمودار می دهیم
            List<Map<String, Object>> results = jjDatabaseWeb.separateRow(db.otherSelect(sql));

            for (int i = 0; i < results.size(); i++) {// برای هر سطر از جدول یک ستون در محور افق و مقدار آن را هم همان موقع اضافه می کنیم
                // برای اینکه بفهمیم هر گزینه توسط همه کاربران چند بار انتخاب شده
                //فقط تعداد سطرهایی که پاسخ ها دقیقا همین آپشن هستند و ست پاسخ هم در وضعیت ثبت نهایی باشد
                labels += " '" + (results.get(i).get(lableColumn) == null ? "نامشخص" : results.get(i).get(lableColumn).toString()) + "',";// نام هر آپشن
                String val = results.get(i).get("val").toString();// یک یا بیشتر
                data += "'" + val + "',";
            }

            String script = "";
            script
                    += "var ctx1 = document.getElementById('chartBar1').getContext('2d');"
                    + "var myChart1 = new Chart(ctx1, {"
                    + "type: 'bar', data: {"
                    + "labels: ["
                    + labels
                    + "],"
                    + "datasets: [{"
                    + "label: '# of Votes',"
                    + "data: ["
                    + data
                    + "],"
                    + "backgroundColor: '#324463'"
                    + "}]"
                    + "},"
                    + "options: {"
                    + "legend: {"
                    + "display: true,"
                    + "labels: {"
                    + "display: true"
                    + "}"
                    + "},"
                    + "scales: {"
                    + "yAxes: [{"
                    + "ticks: {"
                    + "beginAtZero: true,"
                    + "fontSize: 10,"
                    + "}"
                    + "}],"
                    + "xAxes: [{"
                    + "ticks: {"
                    + "beginAtZero: true,"
                    + "fontSize: 11"
                    + "}"
                    + "}]"
                    + "}"
                    + "}"
                    + "});";
            script += Js.modal("http://kjhkk.com/Server?do=Forms.analysFromByQuestion", "لینک این گزارش را کپی کنید");
            Server.outPrinter(request, response, script);
            return script;
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
}
