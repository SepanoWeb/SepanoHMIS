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
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.swing.table.DefaultTableModel;
import jj.jjCalendar_IR;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;

/**
 *
 * @author Mohammad
 */
public class Forms {

    public static String tableName = "forms";
    public static String _id = "id";
    public static String _code = "forms_code";
    public static String _title = "forms_title";
    public static String _category_id = "forms_category_id";
    public static String _priority = "forms_priority";
//    دسترسی های یک فرم برای پر کردن فرم ها
    public static String _departments = "forms_departments";//بخش یا بخش هایی که این فرم را باید ببینند
    public static String _accessessPosts = "forms_accessesPosts";//سمت هایی که به این فرم دسترسی 
    public static String _accessessUsers = "forms_accessesUsers";// اشخاصی که به این فرم دسترسی 
//    
    public static String _accessessDepartments = "forms_accessessDepartments";//بخش هایی که به این فرم دسترسی 
    public static String _tags = "forms_tags";//برچسب هایی که میتوان به این فرم داد و بر اساس برچسب ها در بخش های مختلف نشان داده شود
    public static String _icon = "forms_icon";//v1.5.0
    public static String _description = "forms_discription";
    public static String _htmlContent = "forms_htmlContent";
    public static String _ownerId = "forms_ownerId";//آی دی ایجاد کننده ی فرم
    public static String _ownerPost = "forms_ownerPost";//سمت ایجاد کننده ی فرم
    public static String _isActive = "forms_isActive";//سمت ایجاد کننده ی فرم
    public static String _creationDate = "forms_creationDate";
    public static String _creationTime = "forms_creationDate";
    public static String _expireDate = "forms_expireDate";
    public static String _expireTime = "forms_expireTime";
    public static String _css = "forms_css";// برای قراردادن کد های سی اس اس
    public static String _javaScript = "forms_javaScript";// برای قراردادن کد های جاوا اسکریپت
    public static String _visit = "forms_visit";//v1.5.0
    public static String _autoWiki = "forms_autoWiki";//برای این فرم لینک اتو ویکی در محتوا ساخته شود یا خیر
    public static String _autoWikiInContent = "forms_autoWiki";//در محتوای این فرم اتو ویکی فعال باشد یا نه

    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";
    public static String lbl_add_en = "افزودن زبان انگلیسی";
    public static String lbl_edit_en = "ویرایش بخش انگلیسی";
    public static String lbl_add_ar = "افزودن زبان عربی";
    public static String lbl_edit_ar = "ویرایش بخش عربی";

    public static int rul_rfs = 60;
    public static int rul_rfs_own = 61;//فقط امکان دیدن فرم های ایجاد شده ی توسط خود ایجاد کننده را دارد // بر روی سمت
    public static int rul_ins = 62;
    public static int rul_edt = 63;
    public static int rul_dlt = 64;
    public static int rul_5 = 65;
    public static int rul_6 = 66;
    public static int rul_7 = 67;
    public static int rul_8 = 68;
    public static int rul_9 = 69;
    public static int rul_10 = 70;

//    public static int rul_lng5 = 68;
    public static String lbl_add_ln2 = "برچسب";
    public static String lbl_edit_ln2 = "ویرایش بخش انگلیسی";
    public static String lbl_add_ln3 = "افزودن زبان عربی";
    public static String lbl_edit_ln3 = "ویرایش بخش عربی";
    public static String lbl_add_ln4 = "افزودن زبان آلمانی";
    public static String lbl_edit_ln4 = "ویرایش بخش آلمانی";
    public static String lbl_add_ln5 = "افزودن زبان چینی";
    public static String lbl_edit_ln5 = "ویرایش بخش چینی";

    public static String refresh(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            StringBuilder html = new StringBuilder();
//            DefaultTableModel dtm = db.Select(tableName, _parent + "=0");
//            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append("<table id='refreshNews' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='15%'>تاریخ خبر</th>");
            html.append("<th width='70%'>عنوان خبر</th>");
            html.append("<th width='5%'>دسته</th>");
            html.append("<th width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < 10; i++) {
                html.append("<tr  onclick='cmsNews.m_select(" + 11 + ");' class='mousePointer'>");
                html.append("<td class='c'>" + 11 + "</td>");
                html.append("<td class='l'>" + 22 + "</td>");
                html.append("<td class='r'>" + 33 + "</td>");
                html.append("<td class='r'>/" + 44 + "/</td>");
                html.append("<td class='c'><img src='img/l.png' style='height:30px' /></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swNewsTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshNews", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "2" : "", "لیست اخبار");
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String add_new(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#News_button", "<input type=\"button\" id=\"insert_news_new\" value=\"" + lbl_insert + "\" class=\"tahoma10\">"));
//                html.append(Js.setHtml("#News_button", ""));
                html.append(Js.buttonMouseClick("#insert_news_new", Js.jjNews.insert()));
            }
            return html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

}
