/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import cms.access.Access_User;
import cms.tools.Js;
import cms.tools.Server;
import cms.tools.UploadServlet;
import cms.tools.jjTools;
import cms.tools.jjValidation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public static String _executorRoleId = "steps_executorRoleId";//مسئول اجرا
    public static String _executorUserId = "steps_executorUserId";//مسئول اجرا
    public static String _trackerId = "steps_trackerId";//مسئول پیگیری
    public static String _otherIndicators = "steps_otherIndicators";//سایر شاخص ها
    public static String _startDate = "steps_startDate";//مسئول اجرا
    public static String _endDate = "steps_endDate";//مسئول اجرا
    public static String _files = "steps_files";//مستندات
    public static String _filesTracker = "steps_trackerFiles";//مستندات مسئول پیگیری
    public static String _filesExecutor = "steps_executorFiles";//مستندات  مسئول اجرا
    public static String _percent = "steps_percent";//درصد
    public static String _cost = "steps_cost";//هزینه
    public static String _statusLog = "steps_statusLog";//روند وضعیت
    public static String _status = "steps_status";//وضعیت
    public static String _descriptionTracker = "steps_descriptionTracker";//توضیحات پیگیری کننده
    public static String _descriptionExecutor = "steps_descriptionExecutor";//توضیحات اجرا  کننده
    public static String _progressPercent = "steps_progressPercent";//درصد پیشرفت
    /////////////////////////////////////////////////
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
    public static String lbl_edit = "ثبت ویرایش";
    public static String status_inDoing = "در حال انجام";
    public static String status_unDone = "غیر قابل انجام";
    public static String status_done = "انجام شده";
    public static String status_initialRegistration = "ثبت اولیه";
//////////////////////////////////////////////////////////////////
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
            html.append("<th width='30%'>وضعیت</th>");
            html.append("<th width='20%'>تاریخ شروع</th>");
            html.append("<th width='20%'>تاریخ پایان</th>");
            html.append("<th width='20%'>هزینه</th>");
            html.append("<th width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  class='mousePointer'  onclick='hmisSteps.m_select(" + row.get(i).get(_id) + ")'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
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
            html2 += Js.table("#refreshSteps", "300", 0, "", "گام ها");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * این جدول گام هایی را نشان می دهد که ثبت اولیه نباشند گام مسئول پیگیری
     * باشد یا مسئول اجرا
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String refreshMySteps(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            DefaultTableModel dtm;
            StringBuilder html = new StringBuilder();
            String roles = jjTools.getSeassionUserRole(request);
            if (!roles.equals("")) {
                String[] role = roles.split(",");
                String condition1 = "";
                String condition2 = "";
                for (int i = 0; i < role.length; i++) {
                    System.out.println("role" + role[i]);
                    condition1 += " steps_executorRoleId =" + role[i] + " OR";
                    condition2 += " steps_trackerId =" + role[i] + " OR";
                }
                dtm = db.otherSelect("SELECT * FROM hmis_steps WHERE steps_status!='" + status_initialRegistration + "' AND (steps_executorUserId=" + jjTools.getSeassionUserId(request) + " OR " + condition1.substring(0, condition1.length() - 2) + " OR " + condition2.substring(0, condition2.length() - 2) + ")");
            } else {
                dtm = db.otherSelect("SELECT * FROM hmis_steps WHERE steps_status!='" + status_initialRegistration + "' AND  steps_executorUserId=" + jjTools.getSeassionUserId(request));
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append("<div class=\"card-header bg-primary tx-white\">گام های اجرایی</div>\n");
            html.append("<div class=\"table-wrapper\">");
            html.append("<table id='refreshMySteps' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='30%'>عنوان</th>");
            html.append("<th width='30%'>وضعیت</th>");
            html.append("<th width='20%'>تاریخ شروع</th>");
            html.append("<th width='20%'>تاریخ پایان</th>");
            html.append("<th width='20%'>هزینه</th>");
            html.append("<th width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  class='mousePointer'  onclick='hmisMySteps.m_select(" + row.get(i).get(_id) + ")'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
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
                panel = "swMyStepsTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshMySteps", "300", 0, "", "گام ها");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            Map<String, Object> map = new HashMap<String, Object>();
            String script = "";
            String plansId = jjTools.getParameter(request, "hmis_plans_id");
            List<Map<String, Object>> StepsRow = jjDatabase.separateRow(db.otherSelect("SELECT SUM(steps_precent) AS sum "
                    + "FROM hmis_steps"
                    + " WHERE " + _plansId + "=" + plansId + ""));
            System.out.println("sum=" + StepsRow.get(0).get("sum").toString());
            System.out.println("idPlans=" + jjTools.getParameter(request, "hmis_plans_id"));

            int precent = 0;
            if (StepsRow.get(0).get("sum") == null) {
                precent = 100;
                map.put(_percent, precent);
                map.put(_plansId, jjTools.getParameter(request, "hmis_plans_id"));
                map.put(_endDate, jjTools.getParameter(request, _endDate).replaceAll("/", ""));
                map.put(_startDate, jjTools.getParameter(request, _startDate).replaceAll("/", ""));
                map.put(_cost, (jjTools.getParameter(request, _cost)));
                map.put(_title, jjTools.getParameter(request, _title));
                map.put(_otherIndicators, jjTools.getParameter(request, _otherIndicators));
                if (jjTools.getParameter(request, _executorRoleId).equals("null")) {
                    map.put(_executorRoleId, "");
                } else {
                    map.put(_executorRoleId, jjTools.getParameter(request, _executorRoleId).replaceAll("#A#", ","));
                }
                if (jjTools.getParameter(request, _executorUserId).equals("null")) {
                    map.put(_executorUserId, "");
                } else {
                    map.put(_executorUserId, jjTools.getParameter(request, _executorUserId).replaceAll("#A#", ","));
                }
                map.put(_trackerId, jjTools.getParameter(request, _trackerId));
                map.put(_files, jjTools.getParameter(request, _files));
                map.put(_status, status_initialRegistration);
                map.put(_statusLog,
                        status_initialRegistration
                        + "-"
                        + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                        + "/ user_id="
                        + jjTools.getSeassionUserId(request) + " "
                        + "/ role_id="
                        + jjTools.getSeassionUserRole(request)
                        + " "
                        + new jjCalendar_IR().getTimeFormat_8length()
                        + "%23A%23"
                );

                if (db.insert(tableName, map).getRowCount() == 0) {
                    String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    return Js.dialog(errorMessage);
                }

            } else if (Integer.valueOf(StepsRow.get(0).get("sum").toString()) < 100) {
                precent = 100 - Integer.valueOf(StepsRow.get(0).get("sum").toString());//بدست آوزدن درصد
                map.put(_percent, precent);
                map.put(_plansId, jjTools.getParameter(request, "hmis_plans_id"));
                map.put(_endDate, jjTools.getParameter(request, _endDate).replaceAll("/", ""));
                map.put(_startDate, jjTools.getParameter(request, _startDate).replaceAll("/", ""));
                map.put(_cost, (jjTools.getParameter(request, _cost)));
                map.put(_title, jjTools.getParameter(request, _title));
                map.put(_otherIndicators, jjTools.getParameter(request, _otherIndicators));
                if (jjTools.getParameter(request, _executorRoleId).equals("null")) {
                    map.put(_executorRoleId, "");
                } else {
                    map.put(_executorRoleId, jjTools.getParameter(request, _executorRoleId).replaceAll("#A#", ","));
                }
                if (jjTools.getParameter(request, _executorUserId).equals("null")) {
                    map.put(_executorUserId, "");
                } else {
                    map.put(_executorUserId, jjTools.getParameter(request, _executorUserId).replaceAll("#A#", ","));
                }
                map.put(_trackerId, jjTools.getParameter(request, _trackerId));
                map.put(_files, jjTools.getParameter(request, _files));
                map.put(_status, status_initialRegistration);
                map.put(_statusLog,
                        status_initialRegistration
                        + "-"
                        + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                        + "/ user_id="
                        + jjTools.getSeassionUserId(request) + " "
                        + "/ role_id="
                        + jjTools.getSeassionUserRole(request)
                        + " "
                        + new jjCalendar_IR().getTimeFormat_8length()
                        + "%23A%23"
                );

                if (db.insert(tableName, map).getRowCount() == 0) {
                    String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    return Js.dialog(errorMessage);
                }

            }

            if (Integer.valueOf(StepsRow.get(0).get("sum").toString()) >= 100) {
                script += Js.modal("ثبت گام امکان نیست.", "پیام سامانه");
            }
            script += "hmisPlans.m_select(" + plansId + ");";
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
            StringBuilder html3 = new StringBuilder();
            html.append(Js.setVal("#" + Steps.tableName + "_" + _id, row.get(0).get(Steps._id)));
            html.append(Js.setValDate("#" + Steps._endDate, row.get(0).get(Steps._endDate)));
            html.append(Js.setValDate("#" + Steps._startDate, row.get(0).get(Steps._startDate)));
            html.append(Js.setVal("#" + Steps._title, row.get(0).get(Steps._title)));
            html.append(Js.setVal("#" + Steps._cost, row.get(0).get(Steps._cost)));
            html.append(Js.setVal("#" + Steps._otherIndicators, row.get(0).get(Steps._otherIndicators)));
            html.append(Js.setVal("#" + Steps._trackerId, row.get(0).get(Steps._trackerId)));
            html.append(Js.setVal("#stepsInPlans_descriptionTracker", row.get(0).get(Steps._descriptionTracker)));
            if (!row.get(0).get(Steps._status).toString().equals(status_initialRegistration)) {
                html.append("        $(\"#decriptionStepsDiv\").show();\n");
                html.append(Js.setVal("#stepsInPlans_descriptionExecutor", row.get(0).get(Steps._descriptionExecutor)));

            } else {
                html.append("        $(\"#decriptionStepsDiv\").hide();\n");
            }

            html.append(Js.setVal("#" + Steps._percent, row.get(0).get(Steps._percent)));
            if (!row.get(0).get(Steps._files).toString().equals("")) {
                String[] File = (row.get(0).get(_files).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html3.append("<div class='col-lg-12'> "
                        + "فایل ها"
                        + "</div>"
                        + "");
                for (int i = 0; i < File.length; i++) {
                    html3.append("<div class='col-lg-3'>");
                    if (row.get(0).get(_status).equals(status_initialRegistration)) {//اگر وضعیت ثبت اولیه باشد دکمه حذف فایل نمایش داده می شود
                        List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + File[i] + "'"));
                        html3.append("<span  class='col-xs-1' onclick='hmisSteps.m_remove(" + fileRow.get(0).get(UploadServlet._id) + "," + stepsId + ");'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
                    }
                    html3.append("<a id='downloadFile_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                    html3.append("</div>");
                }
            }
            if (!row.get(0).get(Steps._filesExecutor).toString().equals("")) {
                String[] File = (row.get(0).get(_filesExecutor).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html3.append("<div class='col-lg-12'> "
                        + "فایل های مسئول اجرا"
                        + "</div>"
                        + "");
                for (int i = 0; i < File.length; i++) {
                    html3.append("<div class='col-lg-3'>");
                    html3.append("<a id='downloadFileExecutor_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                    html3.append("</div>");
                }
            }
            if (!row.get(0).get(Steps._filesTracker).toString().equals("")) {
                String[] File = (row.get(0).get(_filesTracker).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html3.append("<div class='col-lg-12'> "
                        + "فایل های مسئول پیگیری"
                        + "</div>"
                        + "");
                for (int i = 0; i < File.length; i++) {
                    html3.append("<div class='col-lg-3'>");
                    html3.append("<a id='downloadFileTracker_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                    html3.append("</div>");
                }
            }
            html2.append("<div class='col-lg-6'> <button id='btn_editSteps' class=\"btn btn-outline-warning btn-block mg-b-10 tahoma10\" onclick=\"hmisPlans.editStepsInPlans(" + row.get(0).get(Steps._id) + ");\">ثبت تغییرات گام</button>\n</div>");
            html2.append("<div class='col-lg-6'><button id='btn_deleteSteps' class=\"tahoma10 btn btn-outline-danger btn-block mg-b-10\" onclick=\"hmisSteps.m_delete(" + row.get(0).get(Steps._id) + ");\">حذف گام</button>\n</div>");

            String script = "";
            if (row.get(0).get(_executorUserId).equals("")) {
                String executorRoleId = (row.get(0).get(_executorRoleId).toString());
                System.out.println("executorRoleId=" + executorRoleId);
                String[] exeRoleId = executorRoleId.split(",");
                String temp = "";
                System.out.println("exeRoleId" + exeRoleId.length);
                for (int i = 0; i < exeRoleId.length; i++) {
                    temp += "'" + exeRoleId[i] + "',";
                }
                System.out.println("temp=" + temp + "executorRoleId=" + executorRoleId);
                html.append("$('#steps_executorRoleId').val([" + temp + "]);"
                        + "$('#steps_executorRoleId').select2({ minimumResultsForSearch: '', width: '100%'});"
                        + "$('#steps_executorUserId').val('');"
                        + "hmisPlans.executorAction('سمت');"
                        + "$('input:radio[id=roleExecutor]').attr('checked','checked');"
                );
            } else if (row.get(0).get(_executorRoleId).equals("")) {
                String executorUserId = (row.get(0).get(_executorUserId).toString());
                System.out.println("executorUserId=" + executorUserId);
                String[] exeUserId = executorUserId.split(",");
                String temp2 = "";
                System.out.println("exeUserId" + exeUserId.length);
                for (int i = 0; i < exeUserId.length; i++) {
                    temp2 += "'" + exeUserId[i] + "',";
                }
                html.append("$('#steps_executorUserId').val([" + temp2 + "]);"
                        + "$('#steps_executorUserId').select2({minimumResultsForSearch: '', width: '100%'});"
                        + "$('#steps_executorRoleId').val('');"
                        + "hmisPlans.executorAction('کاربران');"
                        + "$('input:radio[id=userExecutor]').attr('checked','checked');"
                );

            }
            script += Js.setHtml("#steps_button", html2);
            script += Js.setHtml("#filesDownloadStepsDiv", html3);
            script += html.toString();

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * نمایش گام ها در قسمت برنامه عملیاتی من
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String selectStepsInMyPlans(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String stepsId = jjTools.getParameter(request, "hmis_steps_id");
            String plansId = jjTools.getParameter(request, "hmis_plans_id");
            String errorMessageId = jjValidation.isDigitMessageFa(stepsId, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(stepsId, "ID");
                }
                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Steps.tableName, Steps._id + "=" + stepsId));
            List<Map<String, Object>> PlansRow = jjDatabase.separateRow(db.Select(Plans.tableName, Plans._id + "=" + plansId));
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
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();

            html.append(Js.setVal("#" + Steps.tableName + "_" + _id, row.get(0).get(Steps._id)));
            html.append(Js.setVal("#MyPlansSteps_endDate", jjCalendar_IR.getViewFormat(row.get(0).get(Steps._endDate))));
            html.append(Js.setVal("#MyPlansSteps_startDate", jjCalendar_IR.getViewFormat(row.get(0).get(Steps._startDate))));
            html.append(Js.setVal("#MyPlansSteps_title", row.get(0).get(Steps._title)));
            html.append(Js.setVal("#MyPlansSteps_cost", row.get(0).get(Steps._cost)));
            html.append(Js.setVal("#MyPlansSteps_precent", row.get(0).get(Steps._percent)));
            html.append(Js.setVal("#MyPlansSteps_otherIndicators", row.get(0).get(Steps._otherIndicators)));
            html.append(Js.setVal("#MyPlansSteps_trackerId", row.get(0).get(Steps._trackerId)));
            html.append(Js.setVal("#MyPlansSteps_files", row.get(0).get(Steps._files)));
            if (!row.get(0).get(Steps._files).toString().equals("")) {
                String[] File = (row.get(0).get(_files).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html4.append("<div class='col-lg-12'> "
                        + "فایل ها"
                        + "</div>"
                        + "");
                for (int i = 0; i < File.length; i++) {
                    html4.append("<div class='col-lg-3'>");
                    if (row.get(0).get(_status).equals(status_initialRegistration)) {//اگر وضعیت ثبت اولیه باشد دکمه حذف فایل نمایش داده می شود
                        List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + File[i] + "'"));

                        html4.append("<span  class='col-xs-1' onclick='hmisSteps.m_remove(" + fileRow.get(0).get(UploadServlet._id) + "," + stepsId + ");'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
                    }
                    html4.append("<a id='downloadFile_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                    html4.append("</div>");
                }

            }
            if (PlansRow.get(0).get(Plans._status).equals(Plans.status_confirmationFinal)) {
                html2.append("<button id='btn_editMyPlansSteps' class=\"btn btn-outline-warning btn-block mg-b-10 tahoma10\" onclick=\"hmisPlans.editStepsInPlans(" + row.get(0).get(Steps._id) + ");\">ثبت تغییرات گام</button>\n");
            }

            String script = "";
            if (row.get(0).get(_executorUserId).equals("")) {
                String executorRoleId = (row.get(0).get(_executorRoleId).toString());
                System.out.println("executorRoleId=" + executorRoleId);
                String[] exeRoleId = executorRoleId.split(",");
                String temp = "";
                System.out.println("exeRoleId" + exeRoleId.length);
                for (int i = 0; i < exeRoleId.length; i++) {
                    temp += "'" + exeRoleId[i] + "',";
                }
                System.out.println("temp=" + temp + "executorRoleId=" + executorRoleId);
                html3.append(""
                        + "$('#MyPlansSteps_executorRoleId').val([" + temp + "]);"
                        + "$('#MyPlansSteps_executorRoleId').select2({ minimumResultsForSearch: '', width: '100%'});"
                        + "$('#MyPlansSteps_executorUserId').val('');"
                        + "hmisMyPlans.executorActionMyPlans('سمت');"
                        + "$('input:radio[id=ExecutorRole]').attr('checked','checked');"
                );
            } else if (row.get(0).get(_executorRoleId).equals("")) {
                String executorUserId = (row.get(0).get(_executorUserId).toString());
                System.out.println("executorUserId=" + executorUserId);
                String[] exeUserId = executorUserId.split(",");
                String temp2 = "";
                System.out.println("exeUserId" + exeUserId.length);
                for (int i = 0; i < exeUserId.length; i++) {
                    temp2 += "'" + exeUserId[i] + "',";
                }
                html3.append(""
                        + "$('#MyPlansSteps_executorUserId').val([" + temp2 + "]);"
                        + "$('#MyPlansSteps_executorUserId').select2({minimumResultsForSearch: '', width: '100%'});"
                        + "$('#MyPlansSteps_executorRoleId').val('');"
                        + "hmisMyPlans.executorActionMyPlans('کاربران');"
                        + "$('input:radio[id=ExecutorUser]').attr('checked','checked');"
                );
//
            }
            script += Js.setHtml("#MyPlansSteps_button", html2);
            script += Js.setHtml("#downloadFileMyPlansDiv", html4);
            script += html.toString();
            script += html3.toString();

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String selectStepsInManagerPlans(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String stepsId = jjTools.getParameter(request, "hmis_steps_id");
            String plansId = jjTools.getParameter(request, "hmis_plans_id");
            String errorMessageId = jjValidation.isDigitMessageFa(stepsId, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(stepsId, "ID");
                }
                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Steps.tableName, Steps._id + "=" + stepsId));
            List<Map<String, Object>> PlansRow = jjDatabase.separateRow(db.Select(Plans.tableName, Plans._id + "=" + plansId));
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
            StringBuilder html3 = new StringBuilder();

            html.append(Js.setVal("#" + Steps.tableName + "_" + _id, row.get(0).get(Steps._id)));
            html.append(Js.setVal("#MyPlansSteps_endDate", jjCalendar_IR.getViewFormat(row.get(0).get(Steps._endDate))));
            html.append(Js.setVal("#MyPlansSteps_startDate", jjCalendar_IR.getViewFormat(row.get(0).get(Steps._startDate))));
            html.append(Js.setVal("#MyPlansSteps_title", row.get(0).get(Steps._title)));
            html.append(Js.setVal("#MyPlansSteps_cost", row.get(0).get(Steps._cost)));
            html.append(Js.setVal("#MyPlansSteps_precent", row.get(0).get(Steps._percent)));
            html.append(Js.setVal("#MyPlansSteps_otherIndicators", row.get(0).get(Steps._otherIndicators)));
            html.append(Js.setVal("#MyPlansSteps_trackerId", row.get(0).get(Steps._trackerId)));
            html.append(Js.setVal("#MyPlansSteps_files", row.get(0).get(Steps._files)));
            if (PlansRow.get(0).get(Plans._status).equals(Plans.status_confirmByManager)) {
                html2.append("<button id='btn_editMyPlansSteps' class=\"btn btn-outline-warning btn-block mg-b-10 tahoma10\" onclick=\"hmisPlans.editStepsInPlans(" + row.get(0).get(Steps._id) + ");\">ثبت تغییرات گام</button>\n");
            }

            String script = "";
            if (row.get(0).get(_executorUserId).equals("")) {
                String executorRoleId = (row.get(0).get(_executorRoleId).toString());
                System.out.println("executorRoleId=" + executorRoleId);
                String[] exeRoleId = executorRoleId.split(",");
                String temp = "";
                System.out.println("exeRoleId" + exeRoleId.length);
                for (int i = 0; i < exeRoleId.length; i++) {
                    temp += "'" + exeRoleId[i] + "',";
                }
                System.out.println("temp=" + temp + "executorRoleId=" + executorRoleId);
                html3.append(""
                        + "$('#MyPlansSteps_executorRoleId').val([" + temp + "]);"
                        + "$('#MyPlansSteps_executorRoleId').select2({ minimumResultsForSearch: '', width: '100%'});"
                        + "$('#MyPlansSteps_executorUserId').val('');"
                        + "hmisMyPlans.executorActionMyPlans('سمت');"
                        + "$('input:radio[id=ExecutorRole]').attr('checked','checked');"
                );
            } else if (row.get(0).get(_executorRoleId).equals("")) {
                String executorUserId = (row.get(0).get(_executorUserId).toString());
                System.out.println("executorUserId=" + executorUserId);
                String[] exeUserId = executorUserId.split(",");
                String temp2 = "";
                System.out.println("exeUserId" + exeUserId.length);
                for (int i = 0; i < exeUserId.length; i++) {
                    temp2 += "'" + exeUserId[i] + "',";
                }
                html3.append(""
                        + "$('#MyPlansSteps_executorUserId').val([" + temp2 + "]);"
                        + "$('#MyPlansSteps_executorUserId').select2({minimumResultsForSearch: '', width: '100%'});"
                        + "$('#MyPlansSteps_executorRoleId').val('');"
                        + "hmisMyPlans.executorActionMyPlans('کاربران');"
                        + "$('input:radio[id=ExecutorUser]').attr('checked','checked');"
                );
//
            }
            script += Js.setHtml("#MyPlansSteps_button", html2);
            script += html.toString();
            script += html3.toString();

            Server.outPrinter(request, response, script);
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
                return hasAccess;
            }
            String script = "";
            System.out.println("steps_id=" + jjTools.getParameter(request, "hmis_steps_id"));
            Map<String, Object> map = new HashMap<String, Object>();

//            map.put(Steps._endDate, jjTools.getParameter(request, Steps._endDate).replaceAll("/", ""));
//            map.put(Steps._startDate, jjTools.getParameter(request, Steps._startDate).replaceAll("/", ""));
            map.put(Steps._status, (jjTools.getParameter(request, Steps._status)));
            map.put(Steps._title, jjTools.getParameter(request, Steps._title));
            map.put(Steps._files, jjTools.getParameter(request, Steps._files));
            map.put(Steps._percent, jjTools.getParameter(request, Steps._percent));

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
            } else {

                List<Map<String, Object>> StepsRow = jjDatabase.separateRow(db.Select(Steps.tableName, Steps._id + "=" + jjTools.getParameter(request, "hmis_steps_id")));
                script += "hmisSteps.m_select(" + jjTools.getParameter(request, "hmis_steps_id") + ");";
                script += "hmisSteps.m_refresh();";
                script += Js.modal("تغییرات انجام شد", "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ویرایش برنامه های گام های اجرایی من
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String editMySteps(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            String script = "";
            String steps_id = jjTools.getParameter(request, _id);

            System.out.println("steps_id=" + jjTools.getParameter(request, _id));
            Map<String, Object> map = new HashMap<String, Object>();
            System.out.println("jjTools.getParameter(request, Steps._progressPercent)=" + jjTools.getParameter(request, _progressPercent));

            map.put(Steps._filesExecutor, jjTools.getParameter(request, _filesExecutor));
            map.put(Steps._filesTracker, jjTools.getParameter(request, _filesTracker));
            map.put(Steps._progressPercent, jjTools.getParameter(request, _progressPercent));
            map.put(Steps._descriptionExecutor, (jjTools.getParameter(request, _descriptionExecutor)));
            map.put(Steps._descriptionTracker, (jjTools.getParameter(request, _descriptionTracker)));
            if (!db.update(tableName, map, _id + "=" + jjTools.getParameter(request, "hmis_steps_id"))) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Steps.changeStatus(request, db, steps_id, jjTools.getParameter(request, _status));
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
            } else {

                List<Map<String, Object>> StepsRow = jjDatabase.separateRow(db.Select(Steps.tableName, Steps._id + "=" + jjTools.getParameter(request, "hmis_steps_id")));
                script += "hmisMySteps.m_select(" + jjTools.getParameter(request, "hmis_steps_id") + ");";
                script += "hmisMySteps.m_refresh();";
                script += Js.modal("تغییرات انجام شد", "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ب ویرایش اطلاعات گام ها در قسمت برنامه های عملیاتی
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String editStepsInPlans(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            System.out.println("steps_id=" + jjTools.getParameter(request, "hmis_steps_id"));
            Map<String, Object> map = new HashMap<String, Object>();

            map.put(Steps._endDate, jjTools.getParameter(request, Steps._endDate).replaceAll("/", ""));
            map.put(Steps._startDate, jjTools.getParameter(request, Steps._startDate).replaceAll("/", ""));
            map.put(Steps._cost, (jjTools.getParameter(request, Steps._cost)));
            map.put(Steps._percent, (jjTools.getParameter(request, Steps._percent)));

            map.put(Steps._title, jjTools.getParameter(request, Steps._title));
            map.put(Steps._otherIndicators, jjTools.getParameter(request, Steps._otherIndicators));
            if (jjTools.getParameter(request, _executorUserId).equals("null")) {
                map.put(_executorUserId, "");
            } else {
                map.put(_executorRoleId, (jjTools.getParameter(request, _executorRoleId).replaceAll("#A#", ",")));
            }
            if (jjTools.getParameter(request, _executorRoleId).equals("null")) {

                map.put(_executorRoleId, "");
            } else {
                map.put(_executorUserId, (jjTools.getParameter(request, _executorUserId).replaceAll("#A#", ",")));
            }
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
            html.append(" <button id='btn_insertSteps' class='btn btn-outline-success active btn-block mg-b-10' onclick='hmisSteps.m_insert();'>ثبت گام</button>");
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

    /**
     * ابلاغ گام ها توسط مدیر
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String communicatedSteps(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
//            if (!hasAccess.equals("")) {
//                Server.outPrinter(request, response, hasAccess);
//                return "";
//            }
//            String sessionsId = jjTools.getParameter(request, "hmis_sessions_id");
            String ExeRId = "";
            String id = jjTools.getParameter(request, _id);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            String ExecutorRoleId = row.get(0).get(_executorRoleId).toString();
            String ExecutorUserId = row.get(0).get(_executorUserId).toString();
            Map<String, Object> map = new HashMap();
            if (!ExecutorRoleId.equals("")) {
                String[] ExeRoleId = ExecutorRoleId.split(",");
                if (ExeRoleId.length > 1) {
                    for (int i = 0; i < ExeRoleId.length; i++) {
                        map.put(_title, row.get(0).get(_title));
                        map.put(_endDate, row.get(0).get(_endDate).toString().replaceAll("/", ""));
                        map.put(_startDate, row.get(0).get(_startDate).toString().replaceAll("/", ""));
                        map.put(_executorRoleId, ExeRoleId[i]);
                        map.put(_trackerId, row.get(0).get(_trackerId));
                        map.put(_cost, row.get(0).get(_cost));
                        map.put(_plansId, row.get(0).get(_plansId));
                        map.put(_status, status_inDoing);
                        map.put(_statusLog,
                                status_initialRegistration
                                + "-"
                                + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                                + " "
                                + new jjCalendar_IR().getTimeFormat_8length()
                                + "%23A%23" + Sessions.status_communicated
                                + "-"
                                + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                                + " "
                                + new jjCalendar_IR().getTimeFormat_8length()
                                + "%23A%23"
                                + status_inDoing
                                + "-"
                                + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                                + " "
                                + new jjCalendar_IR().getTimeFormat_8length()
                                + "%23A%23"
                        );
                        db.insert(tableName, map);

                    }

                } else {
                    changeStatus(request, db, id, status_inDoing);
                }
            } else if (!ExecutorUserId.equals("")) {
                String[] ExeUserId = ExecutorUserId.split(",");
                if (ExeUserId.length > 1) {
                    for (int i = 0; i < ExeUserId.length; i++) {
                        map.put(_title, row.get(0).get(_title));
                        map.put(_endDate, row.get(0).get(_endDate).toString().replaceAll("/", ""));
                        map.put(_startDate, row.get(0).get(_startDate).toString().replaceAll("/", ""));
                        map.put(_executorUserId, ExeUserId[i]);
                        map.put(_trackerId, row.get(0).get(_trackerId));
                        map.put(_cost, row.get(0).get(_cost));
                        map.put(_percent, row.get(0).get(_percent));
                        map.put(_plansId, row.get(0).get(_plansId));
                        map.put(_status, status_inDoing);
                        map.put(_statusLog,
                                status_initialRegistration
                                + "-"
                                + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                                + " "
                                + new jjCalendar_IR().getTimeFormat_8length()
                                + "%23A%23" + Sessions.status_communicated
                                + "-"
                                + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                                + " "
                                + new jjCalendar_IR().getTimeFormat_8length()
                                + "%23A%23"
                                + status_inDoing
                                + "-"
                                + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                                + " "
                                + new jjCalendar_IR().getTimeFormat_8length()
                                + "%23A%23"
                        );
                        db.insert(tableName, map);
                    }

                } else {
                    changeStatus(request, db, id, status_inDoing);

                }

            }
            System.out.println("id=" + id);
            Server.outPrinter(request, response, "hmisManagerPlans.m_select(" + row.get(0).get(_plansId) + ");");
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String changeStatus(HttpServletRequest request, jjDatabaseWeb db, String id, String newSatus) {
        try {
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                return Js.dialog(errorMessageId);
            }
            String oldStatus = jjDatabaseWeb.separateRow(db.Select(tableName, _status, _id + "=" + id)).get(0).get(_status).toString();

            if (!oldStatus.equals(newSatus)) {
                db.otherStatement("UPDATE " + tableName + " SET " + _statusLog
                        + "=concat(ifnull(" + _statusLog + ",''),'"
                        + newSatus
                        + "-"
                        + jjCalendar_IR.getViewFormat(new jjCalendar_IR().getDBFormat_8length())
                        + " "
                        + new jjCalendar_IR().getTimeFormat_8length()
                        + "   user_id="
                        + jjTools.getSeassionUserId(request) + "   roleId="
                        + jjTools.getSessionAttribute(request, "#ROLE_ID")
                        + "%23A%23"
                        + "') ,"
                        + _status + "='" + newSatus + "'  WHERE id=" + id + ";");
            }
            return "";
        } catch (Exception ex) {
            Server.ErrorHandler(ex);
            return "عملیات تغییر وضعیت بدرستی صورت نگرفت. Err166";
        }
    }

    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            System.out.println("id=" + id);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";

            }
            List<Map<String, Object>> RolesTrackerIdRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + row.get(0).get(_trackerId)));
            List<Map<String, Object>> UserTrackerIdRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + RolesTrackerIdRow.get(0).get(Role._user_id)));
            String[] roleId = jjTools.getSessionAttribute(request, "#ROLE_ID").split(",");
            for (int i = 0; i < roleId.length; i++) {
                //جداکردن نقش ها و چک کردن هر کدام از نقش ها
                if (row.get(0).get(_trackerId).equals(roleId[i])) {

                    html.append(Js.removeAttr("#" + _descriptionTracker, "disabled"));
                } else {
                    html.append(Js.setAttr("#" + _descriptionTracker, "disabled", "disabled"));
                }
                if (row.get(0).get(_executorRoleId).equals(roleId[i]) || row.get(0).get(_executorUserId).equals(jjTools.getSeassionUserId(request))) {
                    html.append(Js.removeAttr("#" + _descriptionExecutor, "disabled"));
                } else {
                    html.append(Js.setAttr("#" + _descriptionExecutor, "disabled", "disabled"));
                }

            }
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
//            html.append(Js.setVal("#" + _file, row.get(0).get(_file)));
//            html.append(Js.setVal("#" + _fileOfResponsible, row.get(0).get(_fileOfResponsible)));
            html.append(Js.setVal("#" + _status, row.get(0).get(_status)));
            html.append(Js.setVal("#" + _percent, row.get(0).get(_percent)));
//            html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
            html.append(Js.setVal("#" + _descriptionExecutor, row.get(0).get(_descriptionExecutor)));
            html.append(Js.setVal("#" + _descriptionTracker, row.get(0).get(_descriptionTracker)));
            html.append(Js.setVal("#trackerId", RolesTrackerIdRow.get(0).get(Role._title) + "-" + UserTrackerIdRow.get(0).get(Access_User._name) + " " + UserTrackerIdRow.get(0).get(Access_User._family)));
            if (row.get(0).get(_executorRoleId).equals("")) {
                html.append(Js.setVal("#executorRoleId", row.get(0).get(_executorUserId)));
            } else if (row.get(0).get(_executorUserId).equals("")) {
                html.append(Js.setVal("#executorRoleId", row.get(0).get(_executorRoleId)));
            }
            html.append(Js.setVal("#endDate", jjCalendar_IR.getViewFormat(row.get(0).get(_endDate))));
            html.append(Js.setVal("#startDate", jjCalendar_IR.getViewFormat(row.get(0).get(_startDate))));
            //فایلهایی که مدیر کمیته آپلوود می کند
//            if (!row.get(0).get(_file).toString().equals("")) {
//                String[] File = (row.get(0).get(_file).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
//                html3.append(" <div  class='col-lg-12'>");
//                for (int i = 0; i < File.length; i++) {
//
//                    html3.append("فایل های دبیر کمیته ");
//                    html3.append("  <div class=\"col-lg-2\" >"
//                            + "<a id='downloadFile_Approved'   href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'>دانلود فایل<input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>"
//                            + "</div>");
//
//                }
//                html3.append("</div>");
            //فایل هایی که مسئول اجرا آپلود می کند
//                if (!row.get(0).get(_fileOfResponsible).toString().equals("")) {
//                    String[] fileOfResponsible = (row.get(0).get(_fileOfResponsible).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
//                    for (int i = 0; i < fileOfResponsible.length; i++) {
////                        if (!row.get(0).get(_status).equals(status_finished)) {//اگر وضعیت ایجاد شده باشد دکمه حذف فایل نمایش داده می شود
//                        List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + fileOfResponsible[i] + "'"));
//
//                        html3.append(" <div  class='col-lg-12'>");
//                        html3.append("<span  class='col-xs-1' onclick='hmisApproved.m_remove(" + fileRow.get(0).get(UploadServlet._id) + "," + id + ")'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
////                        }
//                        html3.append("فایل مسئولین ");
//                        html3.append("  <div class=\"col-lg-2\" ><a id='downloadFileOfResponsible_Approved'   href='upload/" + fileOfResponsible[i] + "' class='btn btn-outline-success  btn-block mg-b-10'>دانلود فایل<input value='" + fileOfResponsible[i] + "' class='form-control is-valid hasDatepicker' /></a></div>");
//                        html3.append(" </div>");
//                    }
//                }
//            }

            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            html2.append("<div class='row'>");
//            if (!row.get(0).get(_status).equals(status_finished)) {//اگر وضعیت مصوبه خاتمه یافته نبود می توان وضعیت را تغییر داد
            if (accEdt) {
                html2.append("<div class=\"col-lg-12\">");
                html2.append("<button  id='edit_Steps' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjSteps.edit() + "' >" + lbl_edit + "</button>");
                html2.append("</div>");
            }
//            }
//            if (accDel) {
//                html2.append("<div class=\"col-lg-6\">");
////                List<Map<String, Object>> sessionsRow = jjDatabase.separateRow(db.Select(Sessions.tableName, Sessions._id + "=" + row.get(0).get(_sessionsId)));
////                if (sessionsRow.get(0).get(Sessions._status).equals(Sessions.status_created)) {
//                html2.append("<button id='delete_Approved'  class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjApproved.delete(id) + "'>" + lbl_delete + "</button>");
////                }
////                html.append(Js.buttonMouseClick("#delete_Approved", ));
//                html2.append("</div>");
//            }
            html2.append("</div>");
            String script = Js.setHtml("#Steps_button", html2);
            script += html.toString();
            script += Js.setHtml("#inputTextSelectorDiv", html3);
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * سلکت برای کسانی که یا مسئول پیگیری هستن یا مسئول اجرا در گام ها
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String selectMySteps(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            System.out.println("id=" + id);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder html5 = new StringBuilder();
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
//            String trackerId = "*[1-3]";
            String trackerId = "" + row.get(0).get(_trackerId).toString() + ",";
            Pattern p1 = Pattern.compile(trackerId);
            String RolesId = jjTools.getSessionAttribute(request, "#ROLE_ID");
            String executorRoleId = "" + (row.get(0).get(_executorRoleId).toString() + ",");//این علائم نشانه این است که فقط همان  کاراکتر وجود داشته باشد
            List<Map<String, Object>> RolesTrackerIdRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + row.get(0).get(_trackerId)));
            List<Map<String, Object>> UserTrackerIdRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + RolesTrackerIdRow.get(0).get(Role._user_id)));
            Matcher m1 = p1.matcher(RolesId);   // get a matcher object

            if (m1.find()) {
                html.append(Js.removeAttr("#MySteps_descriptionTracker", "disabled"));
                html.append("$('#trackerFileDiv').show();");
                if (!row.get(0).get(Steps._filesTracker).toString().equals("")) {
                    String[] File = (row.get(0).get(_filesTracker).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    html5.append("<div class='col-lg-12'> "
                            + "فایل های مسئول پیگیری"
                            + "</div>"
                            + "");
                    for (int i = 0; i < File.length; i++) {
                        html5.append("<div class='col-lg-3'>");
                        List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + File[i] + "'"));
                        html5.append("<span  class='col-xs-1' onclick='hmisMySteps.m_remove(" + fileRow.get(0).get(UploadServlet._id) + "," + id + ",1);'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
                        html5.append("<a id='downloadFilesTracker_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                        html5.append("</div>");
                    }
                }
            } else {
                html.append(Js.setAttr("#MySteps_descriptionTracker", "disabled", "disabled"));
                html.append("$('#trackerFileDiv').hide();");
                if (!row.get(0).get(Steps._filesTracker).toString().equals("")) {
                    String[] File = (row.get(0).get(_filesTracker).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    html5.append("<div class='col-lg-12'> "
                            + "فایل های مسئول پیگیری"
                            + "</div>"
                            + "");
                    for (int i = 0; i < File.length; i++) {
                        html5.append("<div class='col-lg-3'>");
                        html5.append("<a id='downloadFilesTracker_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                        html5.append("</div>");
                    }
                }
            }
            Pattern p2 = Pattern.compile(executorRoleId);//برای رول ها ومچ کردن با regex
            Matcher m2 = p2.matcher(RolesId);   // get a matcher object
            if (row.get(0).get(_executorUserId).toString().equals("" + jjTools.getSeassionUserId(request) + "") || m2.find()) {
                html.append(Js.removeAttr("#MySteps_descriptionExecutor", "disabled"));//
                html.append("$('#executorFileDiv').show();");
                if (!row.get(0).get(Steps._filesExecutor).toString().equals("")) {
                    String[] File = (row.get(0).get(_filesExecutor).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    html4.append("<div class='col-lg-12'> "
                            + "فایل های مسئول اجرا"
                            + "</div>"
                            + "");
                    for (int i = 0; i < File.length; i++) {
                        html4.append("<div class='col-lg-3'>");
                        List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + File[i] + "'"));
                        html4.append("<span  class='col-xs-1' onclick='hmisMySteps.m_remove(" + fileRow.get(0).get(UploadServlet._id) + "," + id + ",2);'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
                        html4.append("<a id='downloadFilesExecutor_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                        html4.append("</div>");
                    }
                }

            } else {
                html.append(Js.setAttr("#MySteps_descriptionExecutor", "disabled", "disabled"));
                html.append("$('#executorFileDiv').hide();");
                if (!row.get(0).get(Steps._filesExecutor).toString().equals("")) {
                    String[] File = (row.get(0).get(_filesExecutor).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    html4.append("<div class='col-lg-12'> "
                            + "فایل های مسئول اجرا"
                            + "</div>"
                            + "");
                    for (int i = 0; i < File.length; i++) {
                        html4.append("<div class='col-lg-3'>");
                        html4.append("<a id='downloadFilesExecutor_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                        html4.append("</div>");
                    }
                }
            }

            html.append(Js.setVal("#MySteps_trackerFiles", row.get(0).get(_filesTracker)));
            html.append(Js.setVal("#MySteps_executorFiles", row.get(0).get(_filesExecutor)));
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#MySteps_title", row.get(0).get(_title)));
            html.append(Js.setVal("#MySteps_status", row.get(0).get(_status)));
            System.out.println("_statusLog=" + row.get(0).get(_statusLog));
            html.append(Js.setHtml("#statusLogMySteps", row.get(0).get(_statusLog)));
            html.append(Js.setVal("#MySteps_percent", row.get(0).get(_percent)));
            html.append(Js.setVal("#MySteps_descriptionExecutor", row.get(0).get(_descriptionExecutor)));
            html.append(Js.setVal("#MySteps_descriptionTracker", row.get(0).get(_descriptionTracker)));
            html.append(Js.setVal("#MySteps_trackerId", RolesTrackerIdRow.get(0).get(Role._title) + "-" + UserTrackerIdRow.get(0).get(Access_User._name) + " " + UserTrackerIdRow.get(0).get(Access_User._family)));
            if (row.get(0).get(_executorRoleId).equals("")) {
                html.append(Js.setVal("#MySteps_executorRoleId", row.get(0).get(_executorUserId)));
            } else if (row.get(0).get(_executorUserId).equals("")) {
                html.append(Js.setVal("#MySteps_executorRoleId", row.get(0).get(_executorRoleId)));
            }
            html.append(Js.setVal("#MySteps_endDate", jjCalendar_IR.getViewFormat(row.get(0).get(_endDate))));
            html.append(Js.setVal("#MySteps_startDate", jjCalendar_IR.getViewFormat(row.get(0).get(_startDate))));
            html.append(Js.setVal("#MySteps_progressPercent", row.get(0).get(_progressPercent)));
            html.append(Js.setVal("#" + _files, row.get(0).get(_files)));
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            html2.append("<div class='row'>");
            if (accEdt) {
                html2.append("<div class=\"col-lg-12\">");
                html2.append("<button  id='edit_MySteps' class='btn btn-outline-warning btn-block mg-b-10 tahoma10' onclick='hmisMySteps.m_edit();' >" + lbl_edit + "</button>");
                html2.append("</div>");
            }

            if (!row.get(0).get(Steps._files).toString().equals("")) {
                String[] File = (row.get(0).get(_files).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html3.append("<div class='col-lg-12'> "
                        + "فایل های گام"
                        + "</div>"
                        + "");
                for (int i = 0; i < File.length; i++) {
                    html3.append("<div class='col-lg-3'>");
//                    if (row.get(0).get(_status).equals(status_initialRegistration)) {//اگر وضعیت ثبت اولیه باشد دکمه حذف فایل نمایش داده می شود
//                        List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + File[i] + "'"));
//                        html3.append("<span  class='col-xs-1' onclick='hmisSteps.m_remove(" + fileRow.get(0).get(UploadServlet._id) + "," + id + ");'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
//                    }
                    html3.append("<a id='downloadFile_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                    html3.append("</div>");
                }
            }

            html2.append("</div>");
            String script = Js.setHtml("#MySteps_button", html2);
            script += html.toString();
            script += Js.setHtml("#FilesStepsDiv", html3);
            script += Js.setHtml("#filesDownloadMySteps1Div", html5);
            script += Js.setHtml("#filesDownloadMySteps2Div", html4);
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * حذف نام فایل وای دی فایل از اپلود سرولت و از فایل موجود
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String removeFile(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {

            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            String idUpload = jjTools.getParameter(request, "upload_id");
            String id = jjTools.getParameter(request, "hmis_steps_id");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            List<Map<String, Object>> rowupload = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._id + "=" + idUpload));////برای دراوردن اسم فایل
            String filename = rowupload.get(0).get(UploadServlet._file_name).toString() + "%23A%23";
            String attacheFiles = row.get(0).get(_files).toString();
            System.out.println(filename);
            System.out.println("____________________________________");
            System.out.println(attacheFiles);
            attacheFiles = attacheFiles.replace(filename, "");
            System.out.println(attacheFiles);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_files, attacheFiles);
            System.out.println("____________________________________");

            db.update(tableName, map, _id + "=" + id);
            Access_User.changeStatus(request, response, db, idUpload, UploadServlet.status_deleted + " " + jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY"));

            Server.outPrinter(request, response, "hmisPlans.selectStepsInPlans(" + id + " );");
            return "";
//

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }

    /**
     * حذف فایل از گام های اجرایی من
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String removeFileMySteps(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String script = "";
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            String idUpload = jjTools.getParameter(request, "upload_id");///
            String id = jjTools.getParameter(request, "hmis_steps_id");
            String nameFile = jjTools.getParameter(request, "nameFile");//نوع فایل را نمایش میدهد یا فایل مسئول اجرا حذف می شود یا فایا مسئول پیگیری

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            List<Map<String, Object>> rowupload = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._id + "=" + idUpload));////برای دراوردن اسم فایل
            String filename = rowupload.get(0).get(UploadServlet._file_name).toString() + "%23A%23";

            if (nameFile.equals("2")) {// درقسمت تابع حذف که صدا زده می شود چون ما دونوع حذف داریممجبوریم براش عدد بگذاریم عدد یک برای حذف فایل های مربوط به مسئول پیگیری 
                String attacheFiles = row.get(0).get(_filesExecutor).toString();
                System.out.println(filename);
                System.out.println("____________________________________");
                System.out.println(attacheFiles);
                attacheFiles = attacheFiles.replace(filename, "");
                System.out.println(attacheFiles);
                //عدد 2 برای حذف فایل های مسئول احرا
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(_filesExecutor, attacheFiles);
                System.out.println("____________________________________");
                db.update(tableName, map, _id + "=" + id);
                script += "$('#MySteps_executorFiles').val('" + attacheFiles + "');";
            }
            if (nameFile.equals("1")) {//اگر فایلی که خواستیم پاککنیم از فایل های مسئول پیگیری بود 
                String attacheFiles = row.get(0).get(_filesTracker).toString();
                System.out.println(filename);
                System.out.println("____________________________________");
                System.out.println(attacheFiles);
                attacheFiles = attacheFiles.replace(filename, "");
                System.out.println(attacheFiles);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(_filesTracker, attacheFiles);
                System.out.println("____________________________________");
                db.update(tableName, map, _id + "=" + id);
                script += "$('#MySteps_trackerFiles').val('" + attacheFiles + "');";
            }
            Access_User.changeStatus(request, response, db, idUpload, UploadServlet.status_deleted + " " + jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY"));
            script += " hmisMySteps.m_select(" + id + ");";
            Server.outPrinter(request, response, script);
            return "";
//

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }

    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            String plansId = jjTools.getParameter(request, "hmis_plans_id");

            String id = jjTools.getParameter(request, _id);
            System.out.println("id=" + id);
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }
            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            String script = Js.jjPlans.select(plansId);
//            script += "$('#insertApproved2').slideUp();";
//            script += "$('#approvedTbl').slideDown();";
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
}
