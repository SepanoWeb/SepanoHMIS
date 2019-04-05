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
import jj.jjDatabaseWeb;
import jj.jjNumber;

/**
 *
 * @author Mohammad
 */
public class FormQuestions {

    public static final String tableName = "hmis_formquestions";
    public static final String _id = "id";
    public static final String _formID = "formQuestions_formID";
    public static final String _title = "formQuestions_title";
    public static final String _defaultValue = "formQuestions_defaultValue";
    public static final String _placeHolder = "formQuestions_placeHolder";
    public static final String _isRequierd = "formQuestions_isRequierd";
    public static final String _icon = "formQuestions_icon";
    public static final String _weight = "formQuestions_weight";
    public static final String _answersType = "formQuestions_answersType";
    public static final String _htmlDiscription = "formQuestions_htmlDiscription";

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

    public static final String lbl_insert = "ثبت و افزودن سوال به فرم";
    public static final String lbl_delete = "حذف سوال";
    public static final String lbl_edit = "ویرایش سوال";
    public static final String lbl_add_en = "افزودن زبان انگلیسی";
    public static final String lbl_edit_en = "ویرایش بخش انگلیسی";
    public static final String lbl_add_ar = "افزودن زبان عربی";
    public static final String lbl_edit_ar = "ویرایش بخش عربی";

//    public static int rul_lng5 = 68;
    public static final String lbl_add_ln2 = "برچسب";
    public static final String lbl_edit_ln2 = "ویرایش بخش انگلیسی";
    public static final String lbl_add_ln3 = "افزودن زبان عربی";
    public static final String lbl_edit_ln3 = "ویرایش بخش عربی";
    public static final String lbl_add_ln4 = "افزودن زبان آلمانی";
    public static final String lbl_edit_ln4 = "ویرایش بخش آلمانی";
    public static final String lbl_add_ln5 = "افزودن زبان چینی";
    public static final String lbl_edit_ln5 = "ویرایش بخش چینی";

    /**
     * این متد موقع سلکت یک فرم برای ویرایش سوالات یک فرم فراخوانی می شود یعنی
     * در hmisForms.m_selet();
     *
     * @param request آی دی فرم در پارامتر ها باید باشد
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db,boolean needString)  throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response,hasAccess);
                    return "";
            }
            StringBuilder html = new StringBuilder();

            String formId = jjTools.getParameter(request, _formID);
            if (formId.isEmpty()) {
                Server.outPrinter(request, response,"اطلاعات فرم صحیح نیست");
                    return ""; //ToDo بعدا به صورت آلرت مناسب در بیاید 
            }
            DefaultTableModel dtm = db.Select(tableName, _formID + "=" + formId);//@ToDo فقط ستون هایی که لازم هست را بگیریم که در مصرف حاقظه رم سرفه جویی بشود
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(dtm);
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                html.append("<a style='color:#fff' class='btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white' onclick='hmisFormQuestions.m_add_new();' >افزودن سوال جدید</a>");
            }
            html.append("<div class='table-wrapper'>");
            html.append("<table id='refreshFormQuestions' class='table display responsive' class='tahoma10' style='direction: rtl;max-width:982px'><thead>");
            html.append("<th width='5%' class='r'>کد</th>");
            html.append("<th width='20%' class='r'>عنوان سوال</th>");
            html.append("<th width='20%' class='c'>ویرایش و اصلاح</th>");
            html.append("<th width='20%' class='c'>آنالیز و آمار</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  class='mousePointer'>");
                html.append("<td class='r'>").append(row.get(i).get(_id)).append("</td>");
                html.append("<td class='r'>").append(row.get(i).get(_title)).append("</td>");
                html.append("<td class='c p' onclick='").append(Js.jjFormQuestions.select(row.get(i).get(_id).toString())).append("'><i class='icon ion-ios-gear-outline' onclick='hmisFormQuestions.m_select(").append(row.get(i).get(_id)).append(");' style='color:#ffcd00!important'></i></td>");
                html.append("<td class='c p' onclick='").append(Js.jjFormQuestions.select(row.get(i).get(_id).toString())).append("'><i class='fa fa-bar-chart'></i></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            html.append("</div>");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "";
            }
            if (panel.equals("")) {
                panel = "swNewsTbl";
            }
            String script = Js.setHtml("#" + panel, html.toString());
            script += Js.table("#refreshFormQuestions", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "2" : "", "لیست اخبار");
            Server.outPrinter(request, response,script);
                    return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response,Server.ErrorHandler(ex));
                    return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db,boolean needString)  throws Exception {
        try {
            StringBuilder script = new StringBuilder();
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                script.append(Js.setHtml("#form_Question_buttons", "<div class='col-lg'><button onclick='" + Js.jjFormQuestions.insert() + "' value='" + lbl_insert + "' class='btn btn-outline-success btn-block mg-b-10'>" + lbl_insert + "</button>"));
            } else {
                script.append(Js.setHtml("#form_Question_buttons", ""));
            }
            script.append(Js.hide("#swFormQuestionOptionsForm"));
            script.append(Js.setHtml("#swFormQuestionOptionsTbl", ""));
            Server.outPrinter(request, response,script.toString());
                    return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response,Server.ErrorHandler(ex));
                    return "";
        }
    }

    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db,boolean needString)  throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response,Js.modal(hasAccess, "پیام سامانه"));
                    return "";
            }

            String id = jjTools.getParameter(request, _id);
            List<Map<String, Object>> formRow = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));
            if (formRow.isEmpty()) {
                String errorMessage = "فرم مورد نظر یافت نشد";
                Server.outPrinter(request, response,Js.modal(errorMessage, "پیام سامانه"));
                    return "";
            }
            StringBuilder script = new StringBuilder();
            Map<String, Object> map = new HashMap<String, Object>();
            script.append(Js.setVal("#" + tableName + "_id", formRow.get(0).get(_id).toString()));
            script.append(Js.setVal("#" + _title, formRow.get(0).get(_title).toString()));
            script.append(Js.setVal("#" + _icon, formRow.get(0).get(_icon).toString()));
            script.append(Js.setVal("#" + _placeHolder, formRow.get(0).get(_placeHolder).toString()));
            script.append(Js.setVal("#" + _answersType, formRow.get(0).get(_answersType).toString()));
            script.append(Js.removeClass(".formTypeSelector li.active", "active"));
            script.append(Js.addClass("#field_" + formRow.get(0).get(_answersType).toString(), "active"));
            if (formRow.get(0).get(_answersType).toString().equals("radio") || formRow.get(0).get(_answersType).toString().equals("select_option") || formRow.get(0).get(_answersType).toString().equals("checkbox")) {
                script.append(Js.show("#swFormQuestionOptionsTbl"));
                script.append(Js.jjFormQuestionOptions.refresh(id));
            } else {// اگر از نوع فیلد های بدون گزینه بود جدول و فرم گزینه ها مخفی بشود
                script.append(Js.hide("#swFormQuestionOptionsTbl"));
                script.append(Js.hide("#swFormQuestionOptionsForm"));
            }
            //کاربر بعد از ثبت مشخصات فرم یاد سوالات فرم را یکی یکی یا دسته ای اضافه کند
            script.append(Js.setVal("#" + _defaultValue, formRow.get(0).get(_defaultValue).toString()));
            if (!formRow.get(0).get(_icon).toString().isEmpty()) {//اگر عکس داشت نشان بدهد
                script.append(Js.setAttr("#formQuestions_icon_Preview", "src", "upload/" + formRow.get(0).get(_icon).toString()));
            } else {
                script.append(Js.setAttr("#formQuestions_icon_Preview", "src", "img/preview.jpg"));

            }
            script.append(Js.setValSummerNote("#" + _htmlDiscription, formRow.get(0).get(_htmlDiscription).toString()));
            script.append(Js.setVal("#" + _isRequierd, formRow.get(0).get(_isRequierd).toString()));
            script.append(Js.setVal("#" + _weight, formRow.get(0).get(_weight).toString()));
            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button onclick='" + Js.jjFormQuestions.edit(id) + "' id='edit_Forms_new'  value='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10'>" + lbl_edit + "</button></div>";
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button onclick='" + Js.jjFormQuestions.delete(id) + "' id='edit_Forms_new'  value='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10'>" + lbl_delete + "</button></div>";
            }
            script.append(Js.setHtml("#form_Question_buttons", htmlBottons));
            Server.outPrinter(request, response,script.toString());
                    return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response,Server.ErrorHandler(ex));
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
    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db,boolean needString)  throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response,Js.modal(hasAccess, "پیام سامانه"));
                    return "";
            }
            Map<String, Object> map = new HashMap<>();
            map.put(_isRequierd, jjTools.getParameter(request, _isRequierd));
            map.put(_icon, jjTools.getParameter(request, _icon));
            map.put(_weight, jjTools.getParameter(request, _weight));
            map.put(_placeHolder, jjTools.getParameter(request, _placeHolder));
            map.put(_defaultValue, jjTools.getParameter(request, _defaultValue));
            map.put(_answersType, jjTools.getParameter(request, _answersType));
            map.put(_htmlDiscription, jjTools.getParameter(request, _htmlDiscription));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_formID, jjTools.getParameter(request, _formID));
            List<Map<String, Object>> insertedFormRow = jjDatabaseWeb.separateRow(db.insert(tableName, map));
            StringBuilder script = new StringBuilder();
            if (insertedFormRow.isEmpty()) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                Server.outPrinter(request, response,Js.modal(errorMessage, "پیام سامانه"));
                    return "";
            }
            script.append(Js.jjFormQuestions.refresh(jjTools.getParameter(request, _formID)));
            script.append(Js.jjFormQuestions.showTbl());
            Server.outPrinter(request, response,script.toString());
                    return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response,Server.ErrorHandler(ex));
                    return "";
        }
    }

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db,boolean needString)  throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response,Js.modal(hasAccess, "پیام سامانه"));
                    return "";
            }

            String id = jjTools.getParameter(request, _id);
            if (id.isEmpty() || !jjNumber.isDigit(id)) {
                Server.outPrinter(request, response,Js.modal("کد صحیح نیست", "پیام سامانه"));
                    return "";
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_isRequierd, jjTools.getParameter(request, _isRequierd));
            map.put(_icon, jjTools.getParameter(request, _icon));
            map.put(_weight, jjTools.getParameter(request, _weight));
            map.put(_answersType, jjTools.getParameter(request, _answersType));
            map.put(_htmlDiscription, jjTools.getParameter(request, _htmlDiscription));
            map.put(_title, jjTools.getParameter(request, _title));
//            map.put(_formID, jjTools.getParameter(request, _formID));نباید تغییر کند قاعدتا ولی بگذاریم هم طوری نمی شود

            if (db.update(tableName, map, _id + "=" + id)) {
                Server.outPrinter(request, response,Js.modal("ویرایش بدرستی انجام شد", "پیام سامانه"));
                    return "";
            } else {
                Server.outPrinter(request, response,Js.modal("ویرایش انجام نشد", "پیام سامانه"));
                    return "";
            }
        } catch (Exception ex) {
            Server.outPrinter(request, response,Server.ErrorHandler(ex));
                    return "";
        }
    }

    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db,boolean needString)  throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response,Js.modal(hasAccess, "پیام سامانه"));
                    return "";
            } else {
                String id = jjTools.getParameter(request, _id);
                if (!jjNumber.isDigit(id)) {
                    Server.outPrinter(request, response,Js.modal("کد صحیح نیست", "پیام سامانه"));
                    return "";
                }
                List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));
//                db.Select(tableName)//در پاسخ ها اگر کسی پاسخ نداده است قابل حذف است@ToDo
                if (db.otherStatement("DELETE t1,t2 FROM " + tableName + " AS t1 LEFT JOIN " + FormQuestionOptions.tableName + " AS t2 ON formQuestionOptions_question_id = t1.id WHERE t1.id=" + id)) {
                    Server.outPrinter(request, response,Js.jjFormQuestions.refresh(row.get(0).get(_formID).toString()) + Js.modal("همه گزینه های این سوال هم حذف شدند", "پیام سامانه"));
                    return "";
                } else {
                    Server.outPrinter(request, response,Js.modal("عدم موفقیت عملیات حذف!!!", "پیام سامانه"));
                    return "";
                }
            }
        } catch (Exception ex) {
            Server.outPrinter(request, response,Server.ErrorHandler(ex));
                    return "";
        }
    }
}
