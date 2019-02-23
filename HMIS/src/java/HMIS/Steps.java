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
    public static String _responsibleForRunning = "steps_responsibleForRunning";//مسئول اجرا
    public static String _responsibleForTrack = "steps_responsibleForTrack";//مسئول پیگیری
    public static String _otherIndicators = "steps_otherIndicators";//سایر شاخص ها
    public static String _startDate = "steps_startDate";//مسئول اجرا
    public static String _endDate = "steps_endDate";//مسئول اجرا
    public static String _file1 = "steps_file1";//مستندات
    public static String _file2 = "steps_file2";//مستندات
    public static String _file3 = "steps_file3";//مستندات
    public static String _cost = "steps_cost";//هزینه
    public static String _vaziat = "steps_vaziat";//وضعیت
    public static String _ravandeVaziat = "steps_ravandeVaziat";//روند وضعیت
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

    public static String refresh(HttpServletRequest request, jjDatabaseWeb db, boolean isFromClient) throws Exception {
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
                html.append("<tr  onclick='hmisSteps.m_select(" + row.get(i).get(_id) + ");' class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_startDate).toString() + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_endDate).toString() + "</td>");
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

    public static String insert(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
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
            map.put(_responsibleForRunning, jjTools.getParameter(request, _responsibleForRunning));
            map.put(_responsibleForTrack, jjTools.getParameter(request, _responsibleForTrack));
            map.put(_file1, jjTools.getParameter(request, _file1));
            map.put(_file2, jjTools.getParameter(request, _file2));
            map.put(_file3, jjTools.getParameter(request, _file3));
            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            String script = "hmisPlans.m_select(" + plansId + ");";
            script += Js.jjPlans.refresh();
            return script;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

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
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();

            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#" + _cost, row.get(0).get(_cost)));
            html.append(Js.setVal("#" + _endDate, jjCalendar_IR.getViewFormat(row.get(0).get(_endDate))));
            html.append(Js.setVal("#" + _startDate, jjCalendar_IR.getViewFormat(row.get(0).get(_startDate))));
            html.append(Js.setVal("#" + _otherIndicators, row.get(0).get(_otherIndicators)));
            html.append(Js.setVal("#" + _responsibleForTrack, row.get(0).get(_responsibleForTrack)));
            html.append(Js.setVal("#" + _responsibleForRunning, row.get(0).get(_responsibleForRunning)));
            html.append(Js.setVal("#" + _file1, row.get(0).get(_file1)));
            html.append(Js.setVal("#" + _file2, row.get(0).get(_file2)));
            html.append(Js.setVal("#" + _file3, row.get(0).get(_file3)));
            return "";
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String edit(HttpServletRequest request, jjDatabaseWeb db, boolean isFromClient) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }

            Map<String, Object> map = new HashMap<String, Object>();

//            map.put(_plansId, jjTools.getParameter(request, "hmis_plans_id"));
            map.put(_endDate, jjTools.getParameter(request, _endDate));
            map.put(_startDate, jjTools.getParameter(request, _startDate));
            map.put(_cost, (jjTools.getParameter(request, _cost)));

            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_otherIndicators, jjTools.getParameter(request, _otherIndicators));
            map.put(_responsibleForRunning, jjTools.getParameter(request, _responsibleForRunning));
            map.put(_responsibleForTrack, jjTools.getParameter(request, _responsibleForTrack));
            map.put(_file1, jjTools.getParameter(request, _file1));
            map.put(_file2, jjTools.getParameter(request, _file2));
            map.put(_file3, jjTools.getParameter(request, _file3));
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }
            if (!db.update(tableName, map, _id + "=" + jjTools.getParameter(request, _id))) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjSteps.refresh();

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * تغییر وضعیت برنامه عملیاتی
     *
     * @param db
     * @param id
     * @param newSatus
     * @return
     */
    public static String changeStatus(jjDatabaseWeb db, String id, String newSatus) {
        try {
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                return Js.dialog(errorMessageId);
            }
            String oldStatus = jjDatabaseWeb.separateRow(db.Select(tableName, _vaziat, _id + "=" + id)).get(0).get(_vaziat).toString();

            if (!oldStatus.equals(newSatus)) {
                db.otherStatement("UPDATE " + tableName + " SET " + _ravandeVaziat
                        + "=concat(ifnull(" + _ravandeVaziat + ",''),'"
                        + newSatus
                        + "-"
                        + jjCalendar_IR.getViewFormat(new jjCalendar_IR().getDBFormat_8length())
                        + " "
                        + new jjCalendar_IR().getTimeFormat_8length()
                        + "#A#"
                        + "') ,"
                        + _vaziat + "='" + newSatus + "'  WHERE id=" + id + ";");
            }
            return "";
        } catch (Exception ex) {
            Server.ErrorHandler(ex);
            return "عملیات تغییر وضعیت بدرستی صورت نگرفت. Err166";
        }
    }

}
