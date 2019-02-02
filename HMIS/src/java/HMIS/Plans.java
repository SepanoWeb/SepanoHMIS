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
 * @author shohreh.shiran Date 1397.10.25
 */
public class Plans {

    public static String tableName = "hmis_plans";
    public static String _id = "id";
//    public static String _plansOfAssessId = "plans_plansOfAssessId";//ای دی پایش
    public static String _typeOfProgram = "plans_typeOfProgram";//نوع برنامه عملیاتی
    public static String _title = "plans_title";//عنوان برنامه عملیاتی
    public static String _minorGoal = "plans_minorGoal";//هدف جزئی
    public static String _hugeGoal = "plans_hugeGoal";//هدف کلان
    public static String _responsible = "plans_responsible";//مسئول
    public static String _strategic = "plans_strategic";//استراتژیک
    public static String _range = "plans_range";//حیطه
    public static String _causeProblem = "plans_causeProblem";//علت مشکل
    public static String _method = "plans_method";//شیوه شناسایی مشکل
    public static String _titleOfTheProblem = "plans_titleOfTheProblem";//عنوان مشکل
    public static String _thePeriodAssess = "plans_thePeriodAssess";//دوره پایش
    public static String _domain = "plans_domain";//دامنه
    public static String _department = "plans_department";//بخش
    public static String _vaziat = "plans_vaziat";//وضعیت
    public static String _ravandeVaziat = "plans_ravandeVaziat";//روند وضعیت
    public static String _description = "plans_description";//توضیحات
    public static String _date = "plans_date";//تاریخ

    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;
    public static int rul_lng2 = 0;
    public static int rul_lng3 = 0;
    public static int rul_lng4 = 0;
    public static int rul_lng5 = 0;
    public static String vaziat_sabteAvalie = "ثبت اولیه";
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

            html.append("        <div class=\"card-header bg-primary tx-white\">برنامه های عملیاتی/بهبود کیفیت تعریف شده</div>\n");
            html.append(" <div class=\"card-body pd-sm-30\">\n"
                    + "                                        <p class=\"mg-b-20 mg-sm-b-30\">\n"
                    + "                                            <a class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" onclick=\"hmisPlans.m_add_new();\" > برنامه عملیاتی/بهبود کیفیت جدید</a>\n"
                    + "                                        </p>\n"
                    + "                                    </div>");
            html.append("        <div class=\"table-wrapper\">\n");
            html.append("  <div align=\"right\">");
            html.append("<table id='refreshPlans' class='table display responsive' class='tahoma10'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='20%'>عنوان</th>");
            html.append("<th width='30%'>نوع برنامه عملیاتی </th>");
            html.append("<th width='20%'>تاریخ</th>");
//            html.append("<th width='20%'>حیطه</th>");
            html.append("<th width='20%'>وضعیت</th>");
            html.append("<th width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr onclick=hmisPlans.m_select(" + row.get(i).get(_id) + ") class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_typeOfProgram).toString()) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_date)) + "</td>");
//                html.append("<td class='r'>" + (row.get(i).get(_range).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_vaziat).toString()) + "</td>");
                html.append("<td class='c'><i class='icon ion-ios-gear-outline'></i></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            html.append("</div>");
            html.append("</div>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swPlansTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshPlans", "300", 0, "", "برنامه های عملیاتی");
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * تابع درج date 1397/11/2 tuesday
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
            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_causeProblem, jjTools.getParameter(request, _causeProblem));
            map.put(_date, jjCalendar_IR.getDatabaseFormat_8length("", true));
            map.put(_department, jjTools.getParameter(request, _department));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_domain, jjTools.getParameter(request, _domain));
            map.put(_hugeGoal, jjTools.getParameter(request, _hugeGoal));
            map.put(_minorGoal, jjTools.getParameter(request, _minorGoal));
            map.put(_method, jjTools.getParameter(request, _method));
//            map.put(_plansOfAssessId, jjTools.getParameter(request, _plansOfAssessId));
            map.put(_range, jjTools.getParameter(request, _range));
            map.put(_responsible, jjTools.getParameter(request, _responsible));
            map.put(_strategic, jjTools.getParameter(request, _strategic));
            map.put(_thePeriodAssess, jjTools.getParameter(request, _thePeriodAssess));
            map.put(_typeOfProgram, jjTools.getParameter(request, _typeOfProgram));
            map.put(_titleOfTheProblem, jjTools.getParameter(request, _titleOfTheProblem));
            map.put(_vaziat, jjTools.getParameter(request, _vaziat));
            map.put(_ravandeVaziat, vaziat_sabteAvalie
                    + ":"
                    + "-"
                    + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                    + " "
                    + new jjCalendar_IR().getTimeFormat_8length()
                    + "#A#");//            در زمان زدن دکمه ثبت وضعیت نمونه ثبت اولیه می شود ودر روند وضعیت ثبت اولیه با تاریخ وساعت ثبت می شود

            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjPlans.refresh();
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
            StringBuilder html2 = new StringBuilder();
            String script = "";
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setValDate("#" + _date, row.get(0).get(_date)));

            html.append(Js.setVal("#" + _typeOfProgram, row.get(0).get(_typeOfProgram)));
            if (row.get(0).get(_typeOfProgram).equals("برنامه بهبود کیفیت")) {
                html.append("$('#planBehboodDiv').show();");
            } else {
                html.append("$('#planBehboodDiv').hide();");
            }
            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#" + _department, row.get(0).get(_department)));
            html.append(Js.setVal("#" + _range, row.get(0).get(_range)));


            html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
            html.append(Js.setVal("#" + _causeProblem, row.get(0).get(_causeProblem)));
            html.append(Js.setVal("#" + _hugeGoal, row.get(0).get(_hugeGoal)));
            html.append(Js.setVal("#" + _minorGoal, row.get(0).get(_minorGoal)));
            html.append(Js.setVal("#" + _method, row.get(0).get(_method)));
            html.append(Js.setVal("#" + _domain, row.get(0).get(_domain)));
            html.append(Js.setVal("#" + _vaziat, row.get(0).get(_vaziat)));
            html.append(Js.setVal("#" + _titleOfTheProblem, row.get(0).get(_titleOfTheProblem)));
            html.append(Js.setVal("#" + _responsible, row.get(0).get(_responsible)));
            html.append(Js.setVal("#" + _strategic, row.get(0).get(_strategic)));
            html.append(Js.setVal("#" + _thePeriodAssess, row.get(0).get(_thePeriodAssess)));

            html.append(Js.setHtml("#thePeriodAssess", row.get(0).get(_thePeriodAssess)));//دوره پایش
            html.append(Js.setHtml("#strategic", row.get(0).get(_strategic)));
            html.append(Js.setHtml("#hugeGoal", row.get(0).get(_hugeGoal)));//هدف کلان
            html.append(Js.setHtml("#minorGoal", row.get(0).get(_minorGoal)));//هدف جزئی
            html.append(Js.setHtml("#responsible", row.get(0).get(_responsible)));//مسول پایش
            html.append(Js.setHtml("#range", row.get(0).get(_range)));//حیطه

//            boolean accDel = Access_User.hasAccess2(request, db, rul_dlt);
//            boolean accEdt = Access_User.hasAccess2(request, db, rul_edt);
//
//            if (accEdt) {
//                html2.append("<input type=\"button\" id=\"edit_Comment\" value=\"" + lbl_edit + "\" class=\"tahoma10\">");
//                html.append(Js.buttonMouseClick("#edit_Comment", Js.jjPlans.edit()));
//            }
//            if (accDel) {
//                html2.append("<input type=\"button\" id=\"delete_Comment\" value=\"" + lbl_delete + "\" class=\"tahoma10\"  />");
//                html.append(Js.buttonMouseClick("#delete_Comment", Js.jjPlans.delete(id)));
//            }
            script += "$('#recordPlans').hide();";
            ////////////////////////////نمایش جدول گامها//////////////////
            List<Map<String, Object>> StepsRow = jjDatabase.separateRow(db.Select(Steps.tableName, Steps._plansId + "=" + id));
            html2.append(" <div class=\"col-lg-12\">");

            html2.append("<table id='refreshTblSteps' class=\"table table-responsive table-wrapper \"  style='direction: rtl;width:982px'><thead>");
            html2.append("<th width='5%'>کد</th>");
            html2.append("<th width='20%'>گام اجرا</th>");
            html2.append("<th width='10%'>مسئول اجرا</th>");
            html2.append("<th width='10%'>مسئول پیگیری</th>");
            html2.append("<th width='10%'>تاریخ شروع</th>");
            html2.append("<th width='10%'>تاریخ پایان</th>");
            html2.append("<th width='10%'>هزینه</th>");
            html2.append("<th width='5%'>شاخص دستیابی</th>");
            html2.append("</thead><tbody>");
            for (int i = 0; i < StepsRow.size(); i++) {
                html2.append("<tr  class='mousePointer'>");
                html2.append("<td class='c'>" + StepsRow.get(i).get(Steps._id) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._title).toString()) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._responsibleForRunning).toString()) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._responsibleForTrack).toString()) + "</td>");
                html2.append("<td class='r'>" + jjCalendar_IR.getViewFormat(StepsRow.get(i).get(Steps._startDate).toString()) + "</td>");
                html2.append("<td class='r'>" + jjCalendar_IR.getViewFormat(StepsRow.get(i).get(Steps._endDate).toString()) + "</td>");
                html2.append("<td class='r'>" + jjNumber.getFormattedNumber(StepsRow.get(i).get(Steps._cost).toString()) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._otherIndicators).toString()) + "</td>");
                html2.append("</tr>");
            }
            html2.append("</tbody></table>");
            html2.append("</div>");
            script += html;
            String script2 = Js.setHtml("#tblSteps", html2.toString());
            script2 += Js.table("#refreshTblSteps", "300", 0, "", "گام های اجرایی");
            return script + html + script2;

          
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * تغییر وضعیت نمونه
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

    public static String edit(HttpServletRequest request, jjDatabaseWeb db, boolean isFromClient) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }

            Map<String, Object> map = new HashMap<String, Object>();

            map.put(_causeProblem, jjTools.getParameter(request, _causeProblem));
            map.put(_department, jjTools.getParameter(request, _department));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_domain, jjTools.getParameter(request, _domain));
            map.put(_hugeGoal, jjTools.getParameter(request, _hugeGoal));
            map.put(_minorGoal, jjTools.getParameter(request, _minorGoal));
            map.put(_method, jjTools.getParameter(request, _method));
            map.put(_range, jjTools.getParameter(request, _range));
            map.put(_responsible, jjTools.getParameter(request, _responsible));
            map.put(_strategic, jjTools.getParameter(request, _strategic));
            map.put(_thePeriodAssess, jjTools.getParameter(request, _thePeriodAssess));
            map.put(_typeOfProgram, jjTools.getParameter(request, _typeOfProgram));
            map.put(_titleOfTheProblem, jjTools.getParameter(request, _titleOfTheProblem));
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
            return Js.jjPlans.refresh();

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
}
