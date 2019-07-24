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
public class FormQuestionOptions {

    public static final String tableName = "hmis_formquestionOptions";
    public static final String _id = "id";
    public static final String _lable = "formQuestionOptions_lable";
    public static final String _value = "formQuestionOptions_value";
    public static final String _question_id = "formQuestionOptions_question_id";
    public static final String _icon = "formQuestionOptions_icon";

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

    public static final String lbl_insert = "ثبت و گزینه به سوال";
    public static final String lbl_delete = "حذف گزینه";
    public static final String lbl_edit = "ثبت ویرایش";
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
    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();

            String question_id = jjTools.getParameter(request, _question_id);
            if (question_id.isEmpty()) {
                Server.outPrinter(request, response, "اطلاعات فرم صحیح نیست");
                return ""; //ToDo بعدا به صورت آلرت مناسب در بیاید 
            }
            DefaultTableModel dtm = db.Select(tableName, _question_id + "=" + question_id);//@ToDo فقط ستون هایی که لازم هست را بگیریم که در مصرف حاقظه رم سرفه جویی بشود
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(dtm);
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                html.append("<a style='color:#fff' class='btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white' onclick='hmisFormQuestionOptions.m_add_new();' >افزودن گزینه ی جدید</a>");
            }
            html.append("<div class='table-wrapper'>");
            html.append("<div class='card-header bg-info tx-white'>افزودن و ویرایش گزینه های سوال</div>");
            html.append("<table id='refreshFormQuestionOptions' class='table display responsive' class='tahoma10' style='direction: rtl;max-width:982px'><thead>");
            html.append("<th width='5%' class='r'>کد</th>");
            html.append("<th width='5%' class='r'>تصویر</th>");
            html.append("<th width='20%' class='r'>برچسب</th>");
            html.append("<th width='20%' class='c'>ارزش</th>");
            html.append("<th width='20%' class='c'>ویرایش</th>");
            html.append("<th width='20%' class='c'>آنالیز و آمار</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr >");
                html.append("<td class='r'>").append(row.get(i).get(_id)).append("</td>");
                if (row.get(i).get(_icon).toString().isEmpty()) {
                    html.append("<td class='c'></td>");
                } else {
                    html.append("<td class='c'><img src='upload/").append(row.get(i).get(_icon)).append("' /></td>");
                }
                html.append("<td class='c'>").append(row.get(i).get(_lable)).append("</td>");
                html.append("<td class='c'>").append(row.get(i).get(_value)).append("</td>");
                html.append("<td class='c p' onclick='hmisFormQuestionOptions.m_select(").append(row.get(i).get(_id)).append(");'><i class='icon ion-ios-gear-outline' style='color:#ffcd00!important'></i></td>");
                html.append("<td class='c p' onclick='hmisFormQuestionOptions.m_select(").append(row.get(i).get(_id)).append(");'><i class='icon ion-ios-gear-outline' style='color:#ffcd00!important'></i></td>");
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
//            script += Js.table("#refreshFormQuestionOptions", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "2" : "", "لیست اخبار");
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            StringBuilder script = new StringBuilder();
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                script.append(Js.setHtml("#formQuestionOption_buttons", "<button class='btn btn-outline-success btn-block mg-b-10' onclick='" + Js.jjFormQuestionOptions.insert() + "'   title='" + lbl_insert + "' '>ذخیره</button>"));
            } else {
                script.append(Js.setHtml("#form_Question_buttons", ""));
            }
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
            script.append(Js.setVal("#" + _lable, formRow.get(0).get(_lable).toString()));
            script.append(Js.setVal("#" + _value, formRow.get(0).get(_value).toString()));
            script.append(Js.setVal("#" + _icon, formRow.get(0).get(_icon).toString()));
            if (!formRow.get(0).get(_icon).toString().isEmpty()) {//اگر عکس داشت نشان بدهد
                script.append(Js.setAttr("#formQuestionOptions_Preview", "src", "upload/" + formRow.get(0).get(_icon).toString()));
            } else {
                script.append(Js.setAttr("#formQuestionOptions_Preview", "src", "img/preview.jpg"));
            }
            String buttonsHtml = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                buttonsHtml += "<button class='btn btn-outline-warning btn-block mg-b-10 text-center' onclick='" + Js.jjFormQuestionOptions.edit(id) + "'   title='" + lbl_edit + "' '>" + lbl_edit + "</button>";
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                buttonsHtml += "<button class='btn btn-outline-danger btn-block mg-b-10 text-center' onclick='" + Js.jjFormQuestionOptions.delete(id) + "'   title='" + lbl_delete + "' '>" + lbl_delete + "</button>";
            }
            script.append(Js.setHtml("#formQuestionOption_buttons", buttonsHtml));
            //کاربر بعد از ثبت مشخصات فرم یاد سوالات فرم را یکی یکی یا دسته ای اضافه کند
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
            Map<String, Object> map = new HashMap<>();
            map.put(_lable, jjTools.getParameter(request, _lable));
            map.put(_icon, jjTools.getParameter(request, _icon));
            map.put(_value, jjTools.getParameter(request, _value));
            map.put(_question_id, jjTools.getParameter(request, _question_id));
            List<Map<String, Object>> insertedFormRow = jjDatabaseWeb.separateRow(db.insert(tableName, map));
            StringBuilder script = new StringBuilder();
            if (insertedFormRow.isEmpty()) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            script.append(Js.jjFormQuestionOptions.refresh(jjTools.getParameter(request, _question_id)));
            script.append(Js.jjFormQuestionOptions.showTbl());
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
            if (id.isEmpty() || !jjNumber.isDigit(id)) {
                Server.outPrinter(request, response, Js.modal("کد صحیح نیست", "پیام سامانه"));
                return "";
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_lable, jjTools.getParameter(request, _lable));
            map.put(_value, jjTools.getParameter(request, _value));
            map.put(_icon, jjTools.getParameter(request, _icon));
//            map.put(_question_id, jjTools.getParameter(request, _question_id));//نباید تغییر کند قاعدتا ولی بگذاریم هم طوری نمی شود

            if (db.update(tableName, map, _id + "=" + id)) {
                List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));
                Server.outPrinter(request, response, Js.jjFormQuestionOptions.refresh(row.get(0).get(_question_id).toString()) + Js.jjFormQuestionOptions.showTbl());
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
            }
            String id = jjTools.getParameter(request, _id);
            if (id.isEmpty() || !jjNumber.isDigit(id)) {
                Server.outPrinter(request, response, Js.modal("کد صحیح نیست", "پیام سامانه"));
                return "";
            }
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));
            if (!row.isEmpty()) {
                if (db.delete(tableName, _id + "=" + id)) {
                    Server.outPrinter(request, response, Js.jjFormQuestionOptions.refresh(row.get(0).get(_question_id).toString()) + Js.jjFormQuestionOptions.showTbl());
                    return "";
                } else {
                    Server.outPrinter(request, response, Js.modal("ویرایش انجام نشد", "پیام سامانه"));
                    return "";
                }
            } else {
                Server.outPrinter(request, response, Js.modal("کد صحیح نیست", "پیام سامانه"));
                return "";
            }
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String getOptionForFilter(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String question_id = jjTools.getParameter(request, _question_id);
            if (!jjNumber.isDigit(question_id)) {
                Server.outPrinter(request, response, Js.modal("کد صحیح نیست", "پیام سامانه"));
                return "";
            }
            StringBuilder html = new StringBuilder();
            List<Map<String, Object>> optionRows = jjDatabaseWeb.separateRow(db.Select(tableName, _question_id + "=" + question_id));
            for (int i = 0; i < optionRows.size(); i++) {//فقط چند گزینه ای ها را نشان میدهیم
                html.append("<option value='" + optionRows.get(i).get(_id) + "'>" 
                        + optionRows.get(i).get(_lable) + (optionRows.get(i).get(_value).toString().isEmpty() ? "" : ("(" + optionRows.get(i).get(_value)+")")) 
                        + "</option>");
            }
            String panel = jjTools.getParameter(request, "panel");
            Server.outPrinter(request, response, Js.setHtml(panel, html));
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
}
