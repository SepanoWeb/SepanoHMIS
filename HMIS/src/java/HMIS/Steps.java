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
import cms.tools.jjValidation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;
import jj.jjCalendar_IR;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;

/**
 *
 * @author shohreh.shiran Date 1397.10.04
 */
public class Steps {

    public static String tableName = "hmis_steps";
    public static String _id = "id";
    public static String _plansId = "steps_plansId";//ای دی برنامه ها
    public static String _title = "steps_title";//عنوان
    public static String _executorId = "steps_executorId";//مسئول اجرا
    public static String _trackerId = "steps_trackerId";//مسئول پیگیری
    public static String _otherIndicators = "steps_otherIndicators";//سایر شاخص ها
    public static String _startDate = "steps_startDate";//مسئول اجرا
    public static String _endDate = "steps_endDate";//مسئول اجرا
    public static String _files = "steps_files";//مستندات
    public static String _cost = "steps_cost";//هزینه
    public static String _statusLog = "steps_statusLog";//روند وضعیت
    public static String _status = "steps_status";//وضعیت
    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;
    public static int rul_lng2 = 0;
    public static int rul_lng3 = 0;
    public static int rul_lng4 = 0;
    public static int rul_lng5 = 0;
    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            StringBuilder html = new StringBuilder();
            DefaultTableModel dtm = db.Select(tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

            html.append("<div class=\"card-header bg-primary tx-white\">گام های اجرایی</div>\n");
            html.append("        <div class=\"table-wrapper\">\n");
            html.append("<table id='refreshSteps' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='30%'>عنوان</th>");
            html.append("<th width='20%'>تاریخ شروع</th>");
            html.append("<th width='20%'>تاریخ پایان</th>");
            html.append("<th width='20%'>هزینه</th>");
            html.append("<th width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_startDate).toString()) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_endDate).toString()) + "</td>");
                html.append("<td class='r'>" + jjNumber.getFormattedNumber(row.get(i).get(_cost).toString()) + "</td>");
                html.append("<td class='c'><i class='icon ion-ios-gear-outline'></i></td>");

                html.append("</tr>");
            }
            html.append("</tbody></table>");
            html.append("</div>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swStepsTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshSteps", "300", 0, "", "برنامه های عملیاتی");
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            Map<String, Object> map = new HashMap<String, Object>();

            String plansId = jjTools.getParameter(request, "hmis_plans_id");
            System.out.println("idPlans=" + jjTools.getParameter(request, "hmis_plans_id"));
            map.put(_plansId, jjTools.getParameter(request, "hmis_plans_id"));
            map.put(_endDate, jjTools.getParameter(request, _endDate));
            map.put(_startDate, jjTools.getParameter(request, _startDate));
            map.put(_cost, (jjTools.getParameter(request, _cost)));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_otherIndicators, jjTools.getParameter(request, _otherIndicators));
            map.put(_executorId, jjTools.getParameter(request, _executorId));
            map.put(_trackerId, jjTools.getParameter(request, _trackerId));
            map.put(_files, jjTools.getParameter(request, _files));

            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            String script = "hmisPlans.m_select(" + plansId + ");";
            script += Js.jjPlans.refresh();
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * با زدن دکمه عملیات در جدول گامها اطلاعات سلکت می شوند .
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String selectStepsInPlans(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String stepsId = jjTools.getParameter(request, Steps._id);
            String errorMessageId = jjValidation.isDigitMessageFa(stepsId, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(stepsId, "ID");
                }
                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Steps.tableName, Steps._id + "=" + stepsId));
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            html.append(Js.setVal("#" + Steps.tableName + "_" + _id, row.get(0).get(Steps._id)));
            html.append(Js.setVal("#" + Steps._endDate, row.get(0).get(Steps._endDate)));
            html.append(Js.setVal("#" + Steps._startDate, row.get(0).get(Steps._startDate)));
            html.append(Js.setVal("#" + Steps._title, row.get(0).get(Steps._title)));
            html.append(Js.setVal("#" + Steps._cost, row.get(0).get(Steps._cost)));
            html.append(Js.setVal("#" + Steps._otherIndicators, row.get(0).get(Steps._otherIndicators)));
            html.append(Js.setVal("#" + Steps._executorId, row.get(0).get(Steps._executorId)));
            html.append(Js.setVal("#" + Steps._trackerId, row.get(0).get(Steps._trackerId)));
            html.append(Js.setVal("#" + Steps._files, row.get(0).get(Steps._files)));

            html2.append(" <button id='btn_editSteps' class=\"btn btn-success btn-block mg-b-10\" onclick=\"hmisPlans.editStepsInPlans(" + row.get(0).get(Steps._id) + ");\">ثبت تغییرات گام</button>\n");

            String script = "";

//            script += "$('#btn_addNewSteps').slideDown();";//دکمه جدید گام   
//            script += "$('#btn_insertSteps').slideUp();";//دکمه ثبت گام
//            script += "$('#btnEditDiv').slideDown();";//دیو ثبت تغییرات گام
            script += Js.setHtml("#steps_button", html2);
            script += html.toString();

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String editStepsInPlans(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            System.out.println("steps_id=" + jjTools.getParameter(request, "hmis_steps_id"));
            Map<String, Object> map = new HashMap<String, Object>();

            map.put(Steps._endDate, jjTools.getParameter(request, Steps._endDate));
            map.put(Steps._startDate, jjTools.getParameter(request, Steps._startDate));
            map.put(Steps._cost, (jjTools.getParameter(request, Steps._cost)));

            map.put(Steps._title, jjTools.getParameter(request, Steps._title));
            map.put(Steps._otherIndicators, jjTools.getParameter(request, Steps._otherIndicators));
            map.put(Steps._executorId, jjTools.getParameter(request, Steps._executorId));
            map.put(Steps._trackerId, jjTools.getParameter(request, Steps._trackerId));
            map.put(Steps._files, jjTools.getParameter(request, Steps._files));

//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);     
//            }
            if (!db.update(Steps.tableName, map, Steps._id + "=" + jjTools.getParameter(request, "hmis_steps_id"))) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
            }
            List<Map<String, Object>> StepsRow = jjDatabase.separateRow(db.Select(Steps.tableName, Steps._id + "=" + jjTools.getParameter(request, "hmis_steps_id")));
            Server.outPrinter(request, response, "hmisPlans.m_select(" + StepsRow.get(0).get(Steps._plansId) + ")");
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
//            if (accIns) {
//                html.append("<button onclick='hmisSteps.m_insert();' id=\"insert_Plans_new\" value=\"" + lbl_insert + "\" class=\"tahoma10\">ثبت گام</button>");
            html.append("  <div class='col-lg-12'>");
            html.append(" <button id='btn_insertSteps' class='btn btn-outline-success  btn-block mg-b-10' onclick='hmisSteps.m_insert();'>ثبت گام</button>");
            html.append("  </div>");
//            }
            String script = Js.setHtml("#steps_button", html);

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
}
