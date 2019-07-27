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
 * @author shohreh.shiran Date 1397.10.25
 */
public class Plans {

    public static String tableName = "hmis_plans";
    public static String _id = "id";
//    public static String _plansOfAssessId = "plans_plansOfAssessId";//ای دی پایش
    public static String _typeOfProgram = "plans_typeOfProgram";//نوع برنامه عملیاتی
    public static String _creatorId = "plans_creatorId";//ایجاد کننده برنامه عملیاتی
    public static String _improveQualityId = "plans_improveQualityId";//مسئول بهبود کیفیت
    public static String _supervisorRol = "plans_supervisorRolId";//سمت مافوق
    public static String _title = "plans_title";//عنوان برنامه عملیاتی
    public static String _minorGoal = "plans_minorGoal";//هدف جزئی
    public static String _hugeGoal = "plans_hugeGoal";//هدف کلان
    public static String _responsible = "plans_responsible";//مدیریتی یا بالینی یا پاراکلینیک یا پشتیبانی
    public static String _strategic = "plans_strategic";//استراتژیک
    public static String _range = "plans_range";//حیطه
    public static String _causeProblem = "plans_causeProblem";//علت مشکل
    public static String _method = "plans_method";//شیوه شناسایی مشکل
    public static String _titleOfTheProblem = "plans_titleOfTheProblem";//عنوان مشکل
    public static String _thePeriodAssess = "plans_thePeriodAssess";//دوره پایش
    public static String _domain = "plans_domain";//دامنه
    public static String _department = "plans_department";//بخش
    public static String _status = "plans_status";//وضعیت
    public static String _statusLog = "plans_statusLog";//روند وضعیت
    public static String _description = "plans_description";//توضیحات
    public static String _correction = "plans_correction";//اصلاحیه
    public static String _date = "plans_date";//تاریخ
    public static String _commettesId = "plans_commettesId";//ای دی کمیته

//    public static String _files = "plans_files";//فایل
    public static int rul_rfs = 0;
    public static int rul_rfsAll = 0;
    public static int rul_confirmBySupervisor = 0;//مافوق
    public static int rul_communicatingToSupervisor = 0;
//    public static int rul_correctionPlans = 0;//اصلاحیه

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
    public static String lbl_repair = "اصلاح";
    public static String lbl_communicatingToSupervisor = "ابلاغ به مافوق";
    public static String status_initialRegistration = "ثبت اولیه";
    public static String status_correctionPlans = "اصلاحیه";
    public static String status_confirmationFinal = "تایید نهایی";
    public static String status_confirmationSupervisor = "تایید مافوق";
    public static String status_ignoreBySupervisor = "رد برنامه توسط مافوق";
    public static String status_ignoreByImproveQuality = "رد برنامه توسط مسئول بهبود کیفیت";
    public static String status_confirmByImproveQuality = "تایید مسئول بهبود کیفیت";
    public static String status_confirmByManager = "تایید مدیر";
    public static String status_ignorByManager = "رد برنامه توسط مدیر";
    public static String vaziat = "";

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            boolean accRulRef = Access_User.hasAccess(request, db, rul_rfs);//
            boolean accRulRefAll = Access_User.hasAccess(request, db, rul_rfsAll);//

            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            DefaultTableModel dtm = db.Select(tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append("<div class=\"card-header bg-primary tx-white\">برنامه های عملیاتی/بهبود کیفیت تعریف شده</div>\n");
            html.append(" <div class=\"card-body pd-sm-30\">\n"
                    + " <p class=\"mg-b-20 mg-sm-b-30\">\n"
                    + " <a class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" style='color:#fff' onclick=\"hmisPlans.m_add_new();\" > برنامه عملیاتی/بهبود کیفیت جدید</a>\n"
                    + "  </p>\n"
                    + "  </div>");
            html.append("<div class=\"table-wrapper\">\n");
            html.append("<div align=\"right\">");
            html.append("<table id='refreshPlans' class='table display responsive' ><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='20%'>عنوان</th>");
            html.append("<th width='30%'>نوع برنامه عملیاتی </th>");
            html.append("<th width='20%'>تاریخ</th>");
            html.append("<th width='20%'>وضعیت</th>");
            html.append("<th width='20%'>درصد کل پیشرفت برنامه</th>");
            html.append("<th width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                float percent = 0;
                List<Map<String, Object>> StepsRow = jjDatabaseWeb.separateRow(db.Select(Steps.tableName, Steps._plansId + "=" + row.get(i).get(_id) + " AND steps_status!='" + Steps.status_initialRegistration + "'"));
                if (StepsRow.size() > 0) {

                    for (int j = 0; j < StepsRow.size(); j++) {//جمع درصد تکمیل گام
                        percent += Float.parseFloat(StepsRow.get(j).get(Steps._percent).toString()) * (Float.parseFloat(StepsRow.get(j).get(Steps._progressPercent).toString()) / 100);
                    }
                }
                System.out.println("percent" + percent);
                html.append("<tr  onclick=hmisPlans.m_select(" + row.get(i).get(_id) + ") class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_typeOfProgram).toString()) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_date)) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
                html.append("<td >"
                        + "<div class=\"progress\">\n"
                        + "<div class=\"progress-bar\" role=\"progressbar\" aria-valuenow="+percent+" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: "+percent+"%;\">\n"
                        + ""+percent+"%\n"
                        + "</div>\n"
                        + "</div>"
                        + "</td>");
                html.append("<td class='c'><i class='icon ion-ios-gear-outline'></i></td>");
                html.append("</tr>");
            }
            
            html.append("</tbody></table>");
            html.append("</div>");
            html.append("</div>");
//            List<Map<String, Object>> RolesRow = jjDatabase.separateRow(db.Select(Role.tableName));
//            html1.append("<option value=''>انتخاب کنید</option>");
//            for (int i = 0; i < RolesRow.size(); i++) {
//                html1.append("<option id='" + RolesRow.get(i).get(Role._user_id) + "' value='" + RolesRow.get(i).get(Role._id) + "'>" + RolesRow.get(i).get(Role._title) + "</option>");
//            }

//            List<Map<String, Object>> departementRow = jjDatabase.separateRow(db.Select(Department.tableName));
//            html3.append("<option value=''>انتخاب کنید</option>");
//            for (int i = 0; i < departementRow.size(); i++) {
//                html3.append("<option id='" + departementRow.get(i).get(Department._id) + "' value='" + departementRow.get(i).get(Department._id) + "'>" + departementRow.get(i).get(Department._title) + "</option>");
//            }

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
//            html2 += Js.setHtml("#plans_supervisorRolId", html1);
//            html2 += Js.setHtml("#plans_department", html3);
//            html2 += Js.setHtml("#plans_domain", html3);

            Server.outPrinter(request, response, html2);
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

            if (accIns) {
                html.append(Js.setHtml("#buttonRecord", "<button id='recordPlans'  class='btn btn-outline-success  btn-block mg-b-10' onclick='hmisPlans.m_insert();'>ثبت  برنامه</button>"));
            }
            html.append(Js.setVal("#plans_status", status_initialRegistration));
            html.append("$('#editPlansDiv').html('');");
            Server.outPrinter(request, response, html.toString());

            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
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
    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_creatorId, jjTools.getSessionAttribute(request, "#ID"));
            map.put(_supervisorRol, jjTools.getParameter(request, _supervisorRol));
            map.put(_causeProblem, jjTools.getParameter(request, _causeProblem));
            map.put(_date, jjCalendar_IR.getDatabaseFormat_8length("", true));
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
            map.put(_status, status_initialRegistration);
            map.put(_statusLog, status_initialRegistration
                    + ":"
                    + "-"
                    + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                    + ""
                    + "User_Id= "
                    + jjTools.getSeassionUserId(request)
                    + "Role_Id= "
                    + jjTools.getSeassionUserRole(request)
                    + new jjCalendar_IR().getTimeFormat_8length()
                    + "%23A%23");//            در زمان زدن دکمه ثبت وضعیت نمونه ثبت اولیه می شود ودر روند وضعیت ثبت اولیه با تاریخ وساعت ثبت می شود
            DefaultTableModel dtm = db.insert(tableName, map);
            if (dtm.getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            List<Map<String, Object>> PlansRow = jjDatabaseWeb.separateRow(dtm);
            html.append(Js.setHtml("#thePeriodAssess", PlansRow.get(0).get(_thePeriodAssess)));//دوره پایش
            html.append(Js.setHtml("#strategic", PlansRow.get(0).get(_strategic)));
            html.append(Js.setHtml("#hugeGoal", PlansRow.get(0).get(_hugeGoal)));//هدف کلان
            html.append(Js.setHtml("#minorGoal", PlansRow.get(0).get(_minorGoal)));//هدف جزئی
            html.append(Js.setHtml("#responsible", PlansRow.get(0).get(_responsible)));//مسول پایش
            html.append(Js.setHtml("#range", PlansRow.get(0).get(_range)));//حیطه

            String script = "";
            script += html;
            script += "hmisPlans.m_select( " + PlansRow.get(0).get(_id) + ");";
            script += Js.setVal("#hmis_plans_id", PlansRow.get(0).get(_id));//ایدی پلن
            script += " $('#btn_addNewSteps').slideDown();";//نمایش دکمه اد نیو برای جدول گام ها
            script += " hmisSteps.m_add_new();";//نمایش دکمه اد نیو برای جدول گام ها

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ای دی پلن
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
            }

            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder html5 = new StringBuilder();
            StringBuilder html6 = new StringBuilder();
            String script = "";
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setValDate("#" + _date, row.get(0).get(_date)));

            html.append(Js.setVal("#" + _typeOfProgram, row.get(0).get(_typeOfProgram)));
            if (row.get(0).get(_typeOfProgram).equals("برنامه بهبود کیفیت")) {
                html.append("$('#planImprovementDiv').slideDown();");
            } else {
                html.append("$('#planImprovementDiv').slideUp();");
            }
            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#" + _department, row.get(0).get(_department)));
            html.append(Js.setVal("#" + _range, row.get(0).get(_range)));

            html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
            html.append(Js.setVal("#" + _supervisorRol, row.get(0).get(_supervisorRol)));
            html.append(Js.setVal("#" + _causeProblem, row.get(0).get(_causeProblem)));
            html.append(Js.setVal("#" + _hugeGoal, row.get(0).get(_hugeGoal)));
            html.append(Js.setVal("#" + _minorGoal, row.get(0).get(_minorGoal)));
            html.append(Js.setVal("#" + _method, row.get(0).get(_method)));
            html.append(Js.setVal("#" + _domain, row.get(0).get(_domain)));
            html.append(Js.setVal("#" + _status, row.get(0).get(_status)));
            html.append(Js.setVal("#" + _titleOfTheProblem, row.get(0).get(_titleOfTheProblem)));
            html.append(Js.setVal("#" + _responsible, row.get(0).get(_responsible)));
            html.append(Js.setVal("#" + _strategic, row.get(0).get(_strategic)));
            html.append(Js.setVal("#" + _thePeriodAssess, row.get(0).get(_thePeriodAssess)));
            html.append(Js.setHtml("#statusLog", (row.get(0).get(_statusLog).toString()).replaceAll("%23A%23", "<br/>")));
            html.append(Js.setHtml("#thePeriodAssess", row.get(0).get(_thePeriodAssess)));//دوره پایش
            html.append(Js.setHtml("#strategic", row.get(0).get(_strategic)));
            html.append(Js.setHtml("#hugeGoal", row.get(0).get(_hugeGoal)));//هدف کلان
            html.append(Js.setHtml("#minorGoal", row.get(0).get(_minorGoal)));//هدف جزئی
            html.append(Js.setHtml("#responsible", row.get(0).get(_responsible)));//مسول پایش
            html.append(Js.setHtml("#range", row.get(0).get(_range)));//حیطه

            boolean accConfirmBySupervisor = Access_User.hasAccess(request, db, rul_confirmBySupervisor);//تایید توسط مافوق
            boolean accCommunicatingToSupervisor = Access_User.hasAccess(request, db, rul_communicatingToSupervisor);//ابلاغ به مافوق
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            if (row.get(0).get(_status).equals(status_initialRegistration)) {//ثبت اولیه
                if (accConfirmBySupervisor) {
                    html3.append("<div class='col-lg-2'>");
                    html3.append("<button onclick='hmisPlans.communicatingToSupervisor(" + id + ");' id=\"communicatingToSupervisor_Plans\"  class=\"btn btn-outline-success  btn-block mg-b-10\">" + lbl_communicatingToSupervisor + "</button>");
                    html3.append("</div>");
                }
                if (accEdt) {
                    html4.append("<div class='col-lg-2'>");
                    html4.append("<button onclick='hmisPlans.m_edit(" + id + ");' id=\"dedit_Plans\"  class=\"btn btn-outline-success  btn-block mg-b-10\">ثبت تغییرات</button>");
                    html4.append("</div>");
                }
            }

            script += "$('#recordPlans').slideUp();";//ثیت برنامه عملیاتی
            ////////////////////////////نمایش جدول گامها//////////////////
            List<Map<String, Object>> StepsRow = jjDatabase.separateRow(db.Select(Steps.tableName, Steps._plansId + "=" + id));
            if (row.get(0).get(_status).equals(status_initialRegistration)) {
                html2.append(" <div class=\"card-body pd-sm-30\">\n"
                        + " <p class=\"mg-b-20 mg-sm-b-30\">\n"
                        + " <a class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" style='color:#fff' onclick=\"hmisSteps.m_add_new();\" >گام جدید</a>\n"
                        + "  </p>\n"
                        + "  </div>");
            }
            html2.append("<div class=\"table-wrapper\">\n");
            html2.append("<div align=\"right\">");
            html2.append("<table id='refreshTblSteps' class=\"table table-responsive\"><thead>");
            html2.append("<th width='5%'>کد</th>");
            html2.append("<th width='20%'>عنوان گام </th>");
            html2.append("<th width='10%'>درصد تکمیل گام</th>");
            html2.append("<th width='10%'>درصد پیشرفت گام</th>");
            html2.append("<th width='10%'>شخص  مسئول اجرا</th>");
            html2.append("<th width='10%'>سمت مسئول اجرا</th>");
            html2.append("<th width='10%'>مسئول پیگیری</th>");
            html2.append("<th width='10%'>تاریخ شروع</th>");
            html2.append("<th width='10%'>تاریخ پایان</th>");
            html2.append("<th width='10%'>هزینه</th>");
            html2.append("<th width='5%'>شاخص دستیابی</th>");
            html2.append("<th width='5%'>وضعیت</th>");
            html2.append("<th width='5%'>عملیات</th>");
            html2.append("</thead><tbody>");
            for (int i = 0; i < StepsRow.size(); i++) {
                float percent = 0;
//                if (!StepsRow.get(i).get(Steps._status).equals(Steps.status_initialRegistration) && !StepsRow.get(i).get(Steps._percent).toString().equals("0") && !StepsRow.get(i).get(Steps._progressPercent).toString().equals("0")) {//بدست آوردن پیشرفت گام نسبت به درصد گام
                percent = Float.parseFloat(StepsRow.get(i).get(Steps._percent).toString()) * (Float.parseFloat(StepsRow.get(i).get(Steps._progressPercent).toString()) / 100);
//                }
                html2.append("<tr  onclick='hmisPlans.selectStepsInPlans(" + StepsRow.get(i).get(Steps._id) + ")' class='mousePointer " + Sessions.getClassCssForVaziat(StepsRow.get(i).get(Steps._status).toString()) + "'>");
                html2.append("<td class='c'>" + StepsRow.get(i).get(Steps._id) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._title).toString()) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._percent).toString()) + "%</td>");
                if (!StepsRow.get(i).get(Steps._status).toString().equals(Steps.status_initialRegistration)) {//زمانی که وضعیت گام ثبت اولیه نبود ستون پیشرفت گام را نمایش دهد 
                    html2.append("<td class='r'>" + percent + "%</td>");
                } else {
                    html2.append("<td class='r'><div></div></td>");
                }
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._executorUserId).toString()) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._executorRoleId).toString()) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._trackerId).toString()) + "</td>");
                html2.append("<td class='r'>" + jjCalendar_IR.getViewFormat(StepsRow.get(i).get(Steps._startDate).toString()) + "</td>");
                html2.append("<td class='r'>" + jjCalendar_IR.getViewFormat(StepsRow.get(i).get(Steps._endDate).toString()) + "</td>");
                html2.append("<td class='r'>" + jjNumber.getFormattedNumber(StepsRow.get(i).get(Steps._cost).toString()) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._otherIndicators).toString()) + "</td>");
                html2.append("<td class='r'>" + (StepsRow.get(i).get(Steps._status).toString()) + "</td>");
                html2.append("<td class='c'><i class='icon ion-ios-gear-outline'></i></td>");
                html2.append("</tr>");
            }
            html2.append("</tbody></table>");
            html2.append("</div>");
            html2.append("</div>");
//            html5.append("<option>انتخاب کنید</option>");
//            List<Map<String, Object>> RolesRow = jjDatabase.separateRow(db.Select(Role.tableName));
//            for (int i = 0; i < RolesRow.size(); i++) {
//                html5.append("<option id='" + RolesRow.get(i).get(Role._user_id) + "' value='" + RolesRow.get(i).get(Role._id) + "'>" + RolesRow.get(i).get(Role._title) + "</option>");
//            }
//            html6.append("<option>انتخاب کنید</option>");
//            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));
//            for (int i = 0; i < UserRow.size(); i++) {
//                html6.append("<option id='" + UserRow.get(i).get(Access_User._id) + "' value='" + UserRow.get(i).get(Access_User._id) + "'>" + UserRow.get(i).get(Access_User._name) + "-" + UserRow.get(i).get(Access_User._family) + "</option>");
//            }
            script += Js.setHtml("#tblSteps", html2.toString());
            script += Js.table("#refreshTblSteps", "300", 0, "", "گام های اجرایی");
            script += Js.setHtml("#editPlansDiv", html4.toString());
            script += Js.setHtml("#btns_plans", html3.toString());
//            script += Js.setHtml("#steps_executorRoleId", html5);
//            script += Js.setHtml("#steps_executorUserId", html6);
//            script += Js.setHtml("#steps_trackerId", html5);
            script += html;
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
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
                        + jjTools.getSeassionUserId(request) + " "
                        + "  roleId="
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

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }

            String id = jjTools.getParameter(request, _id).toString();
            String script = "";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_supervisorRol, jjTools.getParameter(request, _supervisorRol));
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
            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            } else {
                script += Js.jjPlans.refresh();
                script += "hmisPlans.m_select(" + id + ");";
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
     * تایید توسط مافوق
     *
     * @param request
     * @param db
     * @param isFromClient
     * @return
     * @throws Exception
     */
    public static String confirmBySupervisor(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }

            String id = jjTools.getParameter(request, _id);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            changeStatus(request, db, id, status_confirmationSupervisor);
            //تایید توسط ما فوق
            String script = "";
            script += "alert('برنامه عملیاتی توسط مافوق" + row.get(0).get(_supervisorRol) + "تایید شد.');";
            script += "hmisPlans.m_select(" + id + ");";
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    /**
     * تایع ارجاع اصلاحیه به ایجاد کننده برنامه عملیاتی date:13971117
     *
     * @param request
     * @param db
     * @param isFromClient
     * @return
     * @throws Exception
     */
//    public static String referral(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
//        try {
////            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
////            if (!hasAccess.equals("")) {
////                return hasAccess;
////            }
//            String id = jjTools.getParameter(request, "hmis_plans_id");
//            System.out.println("id=" + id);
//            Map<String, Object> map = new HashMap<>();
//            map.put(_correction, jjTools.getParameter(request, _correction));
//            db.update(tableName, map, _id + "=" + id);
//            changeStatus(request, db, id, status_correctionPlans);
//            Server.outPrinter(request, response, Js.modal("اصلاحیه انجام شد", "پیام سامانه"));
//            return "";
//        } catch (Exception ex) {
//            Server.outPrinter(request, response, Server.ErrorHandler(ex));
//            return "";
//        }
//    }
    /**
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String communicatingToSupervisor(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//ای دی برنامه عملیاتی
            String script = "";
//            System.out.println("proposedSulotion=" + jjTools.getParameter(request, _ProposedSolution));
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            List<Map<String, Object>> Row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put(_supervisorRol, jjTools.getParameter(request, _supervisorRol));
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

            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                script += Js.modal(errorMessage, "پیام سامانه");
            }
            String result = changeStatus(request, db, id, status_confirmationFinal);
            if (result.isEmpty()) {
                script += Js.modal("ابلاغ انجام شد", "پیام سامانه");
                script += Js.jjPlans.select(id);

            } else {
                script += Js.modal(".ابلاغ انجام نشد", "پیام سامانه");
            }

            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ابلاغ برنامه عملیاتی به مسئول بهبود کیفیت
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String communicatedBySupervisor(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//ای دی برنامه عملیاتی
            String script = "";
//            System.out.println("proposedSulotion=" + jjTools.getParameter(request, _ProposedSolution));
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            if (!jjTools.getParameter(request, _improveQualityId).equals("")) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(_improveQualityId, jjTools.getParameter(request, _improveQualityId));

                if (!db.update(tableName, map, _id + "=" + id)) {
                    String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");
                } else {
                    String result = changeStatus(request, db, id, status_confirmationSupervisor);//تایید توسط مافوق وابلاغ به مسئول بهبود کیفیت
                    if (result.isEmpty()) {
                        script += Js.modal("ابلاغ انجام شد", "پیام سامانه");
                        script += "hmisMyPlans.m_refresh();";
                        script += "hmisMyPlans.m_select(" + id + ");";

                    } else {
                        script += Js.modal(".ابلاغ انجام نشد", "پیام سامانه");
                    }
                }
            } else {
                script += Js.modal("مسئول بهبود کیفیت را انتخاب نمایید", "پیام سامانه");

            }
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ابلاغ برنامه به کمیته توسط مسئول بهبود کیفیت
     *
     */
    public static String communicatedByImproveQuality(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//ای دی برنامه عملیاتی
            String script = "";
//            System.out.println("proposedSulotion=" + jjTools.getParameter(request, _ProposedSolution));
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            List<Map<String, Object>> plansRow = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            if (!jjTools.getParameter(request, _commettesId).equals("")) {
                Map<String, Object> map = new HashMap<String, Object>();
                Map<String, Object> approvedMap = new HashMap<String, Object>();
                map.put(_commettesId, jjTools.getParameter(request, _commettesId));

                if (!db.update(tableName, map, _id + "=" + id)) {
                    String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");
                } else {
                    approvedMap.put(Approved._commettesId, jjTools.getParameter(request, _commettesId));
                    approvedMap.put(Approved._title, "برنامه عملیاتی:" + plansRow.get(0).get(_title));
                    approvedMap.put(Approved._offererId, plansRow.get(0).get(_creatorId));
                    approvedMap.put(Approved._status, Approved.status_offer);
//                    approvedMap.put(Approved._executorUserId, "0,");
                    approvedMap.put(Approved._statusLog, Approved.status_offer
                            + ":"
                            + "-"
                            + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                            + " user_id="
                            + jjTools.getSeassionUserId(request) + " "
                            + " role_id="
                            + jjTools.getSeassionUserRole(request)
                            + " "
                            + new jjCalendar_IR().getTimeFormat_8length()
                            + "%23A%23");

                    DefaultTableModel dtm = db.insert(Approved.tableName, approvedMap);
                    if (dtm.getRowCount() == 0) {
                        String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                        if (jjTools.isLangEn(request)) {
                            errorMessage = "Edit Fail;";
                        }
                        script += Js.modal(errorMessage, "پیام سامانه");
                    } else {
                        String result = changeStatus(request, db, id, status_confirmByImproveQuality);//تایید توسط بهبود کیفیت وابلاغ به  کمیته
                        if (result.isEmpty()) {
                            script += Js.modal("ابلاغ انجام شد", "پیام سامانه");
                            script += "hmisMyPlans.m_refresh();";
                            script += "hmisMyPlans.m_select(" + id + ");";

                        } else {
                            script += Js.modal(".ابلاغ انجام نشد", "پیام سامانه");
                        }
                    }
                }
            } else {
                script += Js.modal("دبیر کمیته را انتخاب نمایید", "پیام سامانه");

            }
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * زمانی که برنامه عملیاتی تایید نهایی می شود و برای مافوق ارسال می شود
     * مافوق در این قسمت جدول می آید و برای بهبود کیفت ارسال می کند
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String refreshMyPlans(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder html5 = new StringBuilder();
            int sessionUserId = jjTools.getSeassionUserId(request);// ای دی فرد وارد شونده
            html.append("<div class=\"card-header bg-primary tx-white\"> لیست برنامه های عملیاتی  من</div>\n");
            html.append("<div class=\"table-wrapper\">\n");
            html.append("<table id='refreshMyPlans' class='table display responsive' class='tahoma10' style='direction: rtl;'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>عنوان برنامه عملیاتی</th>");
            html.append("<th width='15%'> مافوق</th>");
            html.append("<th width='20%'>تاریخ شروع</th>");
            html.append("<th width='15%'>وضعیت</th>");
            html.append("<th width='40%'>انتقال به میز هوشمند</th>");
            html.append("</thead><tbody>");
            String roles = jjTools.getSeassionUserRole(request);
            String[] role = roles.split("%23A%23");
            String condition1 = "";
            String condition2 = "";
            for (int i = 0; i < role.length; i++) {
                System.out.println("role" + role[i]);
                condition1 += " p.plans_supervisorRolId =" + role[i] + " OR";
                condition2 += " p.plans_improveQualityId=" + role[i] + " OR";
            }

            List<Map<String, Object>> row = jjDatabase.separateRow(db.otherSelect("SELECT"
                    + " P.id,"
                    + "P.plans_title"
                    //                    + "P.plans_improveQualityId "
                    + ",A.user_name,A.user_family"
                    + ",P.plans_date"
                    + ",P.plans_status"
                    + ",P.plans_supervisorRolId"
                    + " FROM hmis_plans P"
                    + " LEFT JOIN  hmis_role      R      ON  P.plans_supervisorRolId=R.id"
                    + " LEFT JOIN  access_user    A      ON   R.role_user_id=A.id"
                    + " WHERE  P.plans_status='" + status_confirmationFinal + "'  AND " + condition1.substring(0, condition1.length() - 2) + " "
                    + "OR  P.plans_status='" + status_confirmationSupervisor + "'  AND  " + condition2.substring(0, condition2.length() - 2) + " "
            ));

            for (int i = 0; i < row.size(); i++) {
                html.append("<tr>");
                html.append("<td class='c'>" + row.get(i).get(Plans._id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Plans._title) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Access_User._name) + " " + row.get(i).get(Access_User._family) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(Plans._date)) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Plans._status) + "</td>");
                html.append("<td class='r' onclick='hmisMyPlans.m_select(" + row.get(i).get(Plans._id) + ")'>"
                        + "<i class='icon ion-coffee' style='color:#a02311'></i>"
                        + "</td>");
                html.append("</tr>");

            }
//            List<Map<String, Object>> RolesRow = jjDatabase.separateRow(db.Select(Role.tableName));
//            html1.append("<option value=''> انتخاب کنید</option>");
//            for (int i = 0; i < RolesRow.size(); i++) {
//                html1.append("<option id='" + RolesRow.get(i).get(Role._user_id) + "' value='" + RolesRow.get(i).get(Role._id) + "'>" + RolesRow.get(i).get(Role._title) + "</option>");
//            }
//            List<Map<String, Object>> departmentRow = jjDatabase.separateRow(db.Select(Department.tableName));
//            html3.append("<option value=''>انتخاب کنید</option>");
//            for (int i = 0; i < departmentRow.size(); i++) {
//                html3.append("<option id='" + departmentRow.get(i).get(Department._id) + "' value='" + departmentRow.get(i).get(Department._id) + "'>" + departmentRow.get(i).get(Department._title) + "</option>");
//            }
            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName));
            html4.append("<option value=''>انتخاب کنید</option>");
            for (int i = 0; i < commettesRow.size(); i++) {
                html4.append("<option id='" + commettesRow.get(i).get(Commettes._id) + "' value='" + commettesRow.get(i).get(Commettes._id) + "'>" + commettesRow.get(i).get(Commettes._title) + "</option>");
            }
            html.append("</tbody></table>");
            html.append("</div>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swMyPlansTbl";
            }

//            html5.append("<option>انتخاب کنید</option>");
//            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));
//            for (int i = 0; i < UserRow.size(); i++) {
//                html5.append("<option id='" + UserRow.get(i).get(Access_User._id) + "' value='" + UserRow.get(i).get(Access_User._id) + "'>" + UserRow.get(i).get(Access_User._name) + "-" + UserRow.get(i).get(Access_User._family) + "</option>");
//            }
            String html2 = Js.setHtml("#" + panel, html.toString());
//            html2 += Js.setHtml("#MyPlansSteps_executorRoleId", html1);
//            html2 += Js.setHtml("#MyPlansSteps_executorUserId", html5);
            html2 += Js.table("#refreshMyPlans", "300", 0, "", "جلسات");
//            html2 += Js.setHtml("#myPlans_supervisorRolId", html1);//انتخاب مافوق
//            html2 += Js.setHtml("#myPlans_department", html3);//انتخاب بخش
//            html2 += Js.setHtml("#myPlans_domain", html3);//انتخاب دامنه
//            html2 += Js.setHtml("#plans_improveQualityId", html1);//انتخاب بهبود کیفیت
            html2 += Js.setHtml("#plans_commettesId", html4);//انتخاب  کمیته
            Server.outPrinter(request, response, html2);

            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));

            return "";
        }
    }

    /**
     * انتخاب برنامه عملیاتی من
     *
     * خصوصیات سکت اگر در برنامه عملیاتی من برنامه توسط مافوق تایید شده باشد در
     * سلکت مافوق ابلاغ به کمیته نمایش داده نمی شود
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String selectMyPlans(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);// ای دی برنامه عملیاتی
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder html5 = new StringBuilder();
            StringBuilder html6 = new StringBuilder();
            StringBuilder html8 = new StringBuilder();

            String script = "";
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#myPlans_title", row.get(0).get(_title)));
            html.append(Js.setVal("#myPlans_department", row.get(0).get(_department)));
            html.append(Js.setVal("#myPlans_range", row.get(0).get(_range)));
            html.append(Js.setVal("#myPlans_description", row.get(0).get(_description)));
            html.append(Js.setVal("#myPlans_supervisorRolId", row.get(0).get(_supervisorRol)));
            html.append(Js.setVal("#myPlans_causeProblem", row.get(0).get(_causeProblem)));
            html.append(Js.setVal("#myPlans_hugeGoal", row.get(0).get(_hugeGoal)));
            html.append(Js.setVal("#myPlans_minorGoal", row.get(0).get(_minorGoal)));
            html.append(Js.setVal("#myPlans_method", row.get(0).get(_method)));
            html.append(Js.setVal("#myPlans_domain", row.get(0).get(_domain)));
            html.append(Js.setVal("#myPlans_status", row.get(0).get(_status)));
            html.append(Js.setVal("#myPlans_titleOfTheProblem", row.get(0).get(_titleOfTheProblem)));
            html.append(Js.setVal("#myPlans_responsible", row.get(0).get(_responsible)));
            html.append(Js.setVal("#myPlans_strategic", row.get(0).get(_strategic)));
            html.append(Js.setVal("#myPlans_thePeriodAssess", row.get(0).get(_thePeriodAssess)));
            html.append(Js.setHtml("#myPlansStatusLog", (row.get(0).get(_statusLog).toString()).replaceAll("%23A%23", "<br/>")));
            html.append(Js.setVal("#" + _improveQualityId, (row.get(0).get(_improveQualityId).toString())));
            String[] RolesId = jjTools.getSeassionUserRole(request).split("%23A%23");
            String condition = "";
            for (int i = 0; i < RolesId.length; i++) {
                condition += RolesId[i] + "||";
            }

            if (row.get(0).get(_status).equals(status_confirmationSupervisor) && row.get(0).get(_improveQualityId).equals(condition.substring(0, condition.length() - 2))) {

                script += Js.setAttr("#myPlans_supervisorRolId", "disabled", "disabled");
                script += Js.setAttr("#plans_improveQualityId", "disabled", "disabled");
                script += "$('#commettesSecretoryDiv').show();";
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button  id='communicatorToCommette_MyPlans' class='btn btn-outline-success  btn-block mg-b-10'  onclick='hmisMyPlans.communicatedByImproveQuality(" + id + ");' >تایید وابلاغ به کمیته</button>");
                html2.append("</div>");
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button id='ignoreImproveQuality_MyPlans' class='btn btn-outline-warning btn-block mg-b-10'  onclick='\"hmisMyPlans.ignoreByImproveQuality(" + id + ");' >رد برنامه عملیاتی</button>");
                html2.append("</div>");
            }
//            html.append(Js.setHtml("#thePeriodAssess", row.get(0).get(_thePeriodAssess)));//دوره پایش
//            html.append(Js.setHtml("#strategic", row.get(0).get(_strategic)));
//            html.append(Js.setHtml("#hugeGoal", row.get(0).get(_hugeGoal)));//هدف کلان
//            html.append(Js.setHtml("#minorGoal", row.get(0).get(_minorGoal)));//هدف جزئی
//            html.append(Js.setHtml("#responsible", row.get(0).get(_responsible)));//مسول پایش
//            html.append(Js.setHtml("#range", row.get(0).get(_range)));//حیطه
//            html.append(Js.setVal("#" + _, row.get(0).get(_file)));
//            if (!row.get(0).get(_file).toString().equals("")) {
//                String[] File = (row.get(0).get(_file).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
//                html8.append("<div class='col-lg-12'> "
//                        + "فایل های دبیر کمیته"
//                        + "</div>"
//                        + "");
//                for (int i = 0; i < File.length; i++) {
//                    html8.append(" <div class='col-lg-3'><a id='downloadFile_Sessions' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a><span  class='col-xs-1' onclick='hmisSessions.m_remove(" + File[i] + "," + id + ")'>" + "<img  src='imgfeyz/delet.png' style='width:56%' /></span></div>");
//                }
//            }

            //دکمه ابلاغ برای مسئول ابلاغ
            if (row.get(0).get(_status).equals(status_confirmationFinal)) {

                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button  id='communicatorTosupervisor_MyPlans' class='btn btn-outline-success  btn-block mg-b-10'  onclick='hmisMyPlans.communicatedBySupervisor(" + id + ");' >تایید وابلاغ توسط مافوق</button>");
                html2.append("</div>");
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button id='ignoreSupervisor_MyPlans' class='btn btn-outline-warning btn-block mg-b-10'  onclick='\"hmisMyPlans.ignoreBySupervisor(" + id + ");' >رد برنامه عملیاتی</button>");
                html2.append("</div>");
            }

            DefaultTableModel dtm = db.Select(Steps.tableName, Steps._plansId + "=" + id);
            List<Map<String, Object>> stepsRow = jjDatabase.separateRow(dtm);
            html3.append("<div class=\"table-wrapper\">\n");
            html3.append("<table id='refreshStepsInMyPlans' class='table display responsive' class='tahoma10' style='direction: rtl;'><thead>");
            html3.append("<th width='5%'>کد</th>");
            html3.append("<th width='10%'>عنوان گام</th>");
            html3.append("<th width='10%'>درصد تکمیل گام</th>");
            html3.append("<th width='10%'>درصد پیشرفت گام</th>");
            html3.append("<th width='10%'>مسئول اجرا</th>");
            html3.append("<th width='10%'>مسئولین اجرا</th>");
            html3.append("<th width='15%'>تاریخ شروع </th>");
            html3.append("<th width='15%'>تاریخ پایان </th>");
            html3.append("<th width='15%'>وضعیت</th>");
            html3.append("<th width='15%'>عملیات</th>");
            html3.append("</thead><tbody>");
            for (int i = 0; i < stepsRow.size(); i++) {
                html3.append("<tr class='mousePointer " + Sessions.getClassCssForVaziat(stepsRow.get(i).get(Steps._status).toString()) + "'>");
                html3.append("<td class='c'>" + stepsRow.get(i).get(Steps._id) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._title) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._percent) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._progressPercent) + "%</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._executorRoleId) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._executorUserId) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(stepsRow.get(i).get(Steps._startDate)) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(stepsRow.get(i).get(Steps._endDate)) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._status) + "</td>");
                html3.append("<td class='r' onclick='hmisMyPlans.selectStepsInMyPlans(" + stepsRow.get(i).get(Steps._id) + "," + id + ");' ><i class='icon ion-gear-a' style='color:#a02311'></i></td>");
                html3.append("</tr>");
            }

            html3.append("</tbody></table>");
            html5.append("<option>انتخاب کنید</option>");
            List<Map<String, Object>> RolesRow = jjDatabase.separateRow(db.Select(Role.tableName));
            for (int i = 0; i < RolesRow.size(); i++) {
                html5.append("<option id='" + RolesRow.get(i).get(Role._user_id) + "' value='" + RolesRow.get(i).get(Role._id) + "'>" + RolesRow.get(i).get(Role._title) + "</option>");
            }
            html6.append("<option>انتخاب کنید</option>");
            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));
            for (int i = 0; i < UserRow.size(); i++) {
                html6.append("<option id='" + UserRow.get(i).get(Access_User._id) + "' value='" + UserRow.get(i).get(Access_User._id) + "'>" + UserRow.get(i).get(Access_User._name) + "-" + UserRow.get(i).get(Access_User._family) + "</option>");
            }
            //////////////////////////////////////////////////////////////
            script += Js.setHtml("#myPlans_button", html2);
            script += Js.table("#refreshStepsInMyPlans", "300", 0, "", "جلسات");
            script += Js.setHtml("#tblStepsMyPlans", html3);
            script += html.toString();
            script += Js.setHtml("#MyPlansSteps_executorUserId", html6);
            script += Js.setHtml("#MyPlansSteps_executorRoleId", html5);
            script += Js.setHtml("#MyPlansSteps_trackerId", html5);
            script += Js.setHtml("#filesDownloadDiv", html8);
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * رد کردن برنامه توسط مافوق در قسمت برنامه های عملیاتی من
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String ignoreBySupervisor(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//  ای دی جلسات
            String script = "";
            String result = changeStatus(request, db, id, status_ignoreBySupervisor);//رد
            if (result.isEmpty()) {//اگر خطایی نبود
                String errorMessageing = "برنامه عملیاتی رد شد";
                script += Js.modal(errorMessageing, "پیام سامانه");
                script += "hmisMyPlans.m_select(" + id + ")";//انتخاب برنامه عملیاتی من
                script += "hmisMyPlans.m_refresh()";//رفرش برنامه های عملیاتی من
            } else {
                String errorMessageing = "برنامه عملیاتی رد نشد";
                script += Js.modal(errorMessageing, "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * رد برنامه توسط مسئول بهبوود کیفیت
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String ignoreByImproveQuality(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//  ای دی جلسات
            String script = "";
            String result = changeStatus(request, db, id, status_ignoreByImproveQuality);//رد
            if (result.isEmpty()) {//اگر خطایی نبود
                String errorMessageing = "برنامه عملیاتی رد شد";
                script += Js.modal(errorMessageing, "پیام سامانه");
                script += "hmisMyPlans.m_select(" + id + ")";//انتخاب برنامه عملیاتی من
                script += "hmisMyPlans.m_refresh()";//رفرش برنامه های عملیاتی من
            } else {
                String errorMessageing = "برنامه عملیاتی رد نشد";
                script += Js.modal(errorMessageing, "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    ///////////////////////////برنامه های عملیاتی مدیر///////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    /**
     * برنامه های عملیاتی مدیر
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String refreshManagerPlans(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            int sessionUserId = jjTools.getSeassionUserId(request);// ای دی فرد وارد شونده
            html.append("<div class=\"card-header bg-primary tx-white\"> لیست برنامه های عملیاتی  من</div>\n");
            html.append("<div class=\"table-wrapper\">\n");
            html.append("<table id='refreshManagerPlans' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>عنوان برنامه عملیاتی</th>");
//            html.append("<th width='15%'> مافوق</th>");
            html.append("<th width='20%'>تاریخ شروع</th>");
            html.append("<th width='15%'>وضعیت</th>");
            html.append("<th width='40%'>انتقال به میز هوشمند</th>");
            html.append("</thead><tbody>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.otherSelect("SELECT"
                    + " P.id,"
                    + "P.plans_title"
                    //                    + ",A.user_name,A.user_family"
                    + ",P.plans_date"
                    + ",P.plans_status"
                    + ",P.plans_supervisorRolId"
                    + " FROM hmis_plans P"
                    //                    + " LEFT JOIN  hmis_role      R      ON  P.plans_supervisorRolId=R.id"
                    //                    + " LEFT JOIN  access_user    A      ON   R.role_user_id=A.id"
                    + " WHERE  P.plans_status='" + status_confirmByImproveQuality + "' OR  P.plans_status='" + status_confirmByManager + "' "
            //                            + "  AND " + condition1.substring(0, condition1.length() - 2) + " "
            //                    + "OR  P.plans_status='" + status_confirmationSupervisor + "'  AND  " + condition2.substring(0, condition2.length() - 2) + " "
            ));

            for (int i = 0; i < row.size(); i++) {
                html.append("<tr>");
                html.append("<td class='c'>" + row.get(i).get(Plans._id) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Plans._title) + "</td>");
//                html.append("<td class='r'>" + row.get(i).get(Access_User._name) + " " + row.get(i).get(Access_User._family) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(Plans._date)) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Plans._status) + "</td>");
                html.append("<td class='r' onclick='hmisManagerPlans.m_select(" + row.get(i).get(Plans._id) + ")'>"
                        + "<i class='icon ion-coffee' style='color:#a02311'></i>"
                        + "</td>");
                html.append("</tr>");

            }
            html.append("</tbody></table>");
            html.append("</div>");
            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName));
            html4.append("<option value=''>انتخاب کنید</option>");
            for (int i = 0; i < commettesRow.size(); i++) {
                html4.append("<option id='" + commettesRow.get(i).get(Commettes._id) + "' value='" + commettesRow.get(i).get(Commettes._id) + "'>" + commettesRow.get(i).get(Commettes._title) + "</option>");
            }
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swManagerPlansTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshManagerPlans", "300", 0, "", "جلسات");
            html2 += Js.setHtml("#plans_commettesId", html4);//انتخاب  کمیته
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));

            return "";
        }
    }

    public static String selectManagerPlans(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);// ای دی برنامه عملیاتی
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder html5 = new StringBuilder();
            StringBuilder html6 = new StringBuilder();
            StringBuilder html8 = new StringBuilder();

            String script = "";
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#myPlans_title", row.get(0).get(_title)));
            html.append(Js.setVal("#myPlans_department", row.get(0).get(_department)));
            html.append(Js.setVal("#myPlans_range", row.get(0).get(_range)));
            html.append(Js.setVal("#myPlans_description", row.get(0).get(_description)));
            html.append(Js.setVal("#myPlans_supervisorRolId", row.get(0).get(_supervisorRol)));
            html.append(Js.setVal("#myPlans_causeProblem", row.get(0).get(_causeProblem)));
            html.append(Js.setVal("#myPlans_hugeGoal", row.get(0).get(_hugeGoal)));
            html.append(Js.setVal("#myPlans_minorGoal", row.get(0).get(_minorGoal)));
            html.append(Js.setVal("#myPlans_method", row.get(0).get(_method)));
            html.append(Js.setVal("#myPlans_domain", row.get(0).get(_domain)));
            html.append(Js.setVal("#myPlans_status", row.get(0).get(_status)));
            html.append(Js.setVal("#myPlans_titleOfTheProblem", row.get(0).get(_titleOfTheProblem)));
            html.append(Js.setVal("#myPlans_responsible", row.get(0).get(_responsible)));
            html.append(Js.setVal("#myPlans_strategic", row.get(0).get(_strategic)));
            html.append(Js.setVal("#myPlans_thePeriodAssess", row.get(0).get(_thePeriodAssess)));
            html.append(Js.setHtml("#myPlansStatusLog", (row.get(0).get(_statusLog).toString()).replaceAll("%23A%23", "<br/>")));
            html.append(Js.setVal("#" + _improveQualityId, (row.get(0).get(_improveQualityId).toString())));
//            String[] RolesId = jjTools.getSeassionUserRole(request).split("%23A%23");
//            String condition = "";
//            for (int i = 0; i < RolesId.length; i++) {
//                condition += RolesId[i] + "||";
//            }

//            if (row.get(0).get(_status).equals(status_confirmationSupervisor) && row.get(0).get(_improveQualityId).equals(condition.substring(0, condition.length() - 2))) {
//
//                script += Js.setAttr("#myPlans_supervisorRolId", "disabled", "disabled");
//                script += Js.setAttr("#plans_improveQualityId", "disabled", "disabled");
//                script += "$('#commettesSecretoryDiv').show();";
//                html2.append("<div class=\"col-lg-6\">");
//                html2.append("<button  id='communicatorToCommette_MyPlans' class='btn btn-outline-success  btn-block mg-b-10'  onclick='hmisMyPlans.communicatedByImproveQuality(" + id + ");' >تایید وابلاغ به کمیته</button>");
//                html2.append("</div>");
//                html2.append("<div class=\"col-lg-6\">");
//                html2.append("<button id='ignoreImproveQuality_MyPlans' class='btn btn-outline-warning btn-block mg-b-10'  onclick='\"hmisMyPlans.ignoreByImproveQuality(" + id + ");' >رد برنامه عملیاتی</button>");
//                html2.append("</div>");
//            }
            //تایید توسط مدیر
            if (row.get(0).get(_status).equals(status_confirmByImproveQuality)) {

                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button  id='confirm_ManagerPlans' class='btn btn-outline-success  btn-block mg-b-10'  onclick='hmisManagerPlans.confirmByManager(" + id + ");' >تایید برنامه عملیاتی</button>");
                html2.append("</div>");
                html2.append("<div class=\"col-lg-6\">");
                html2.append("<button id='ignore_ManagerPlans' class='btn btn-outline-warning btn-block mg-b-10'  onclick='hmisManagerPlans.ignoreByManager(" + id + ");' >رد برنامه عملیاتی</button>");
                html2.append("</div>");
            }

            DefaultTableModel dtm = db.Select(Steps.tableName, Steps._plansId + "=" + id);
            List<Map<String, Object>> stepsRow = jjDatabase.separateRow(dtm);
            html3.append("<div class=\"table-wrapper\">\n");
            html3.append("<table id='refreshStepsInManagerPlans' class='table display responsive' class='tahoma10' style='direction: rtl;'><thead>");
            html3.append("<th width='5%'>کد</th>");
            html3.append("<th width='10%'>عنوان گام</th>");
            html3.append("<th width='10%'>درصد پیشرفت گام</th>");
            html3.append("<th width='10%'>مسئول اجرا</th>");
            html3.append("<th width='10%'>مسئولین اجرا</th>");
            html3.append("<th width='15%'>تاریخ شروع </th>");
            html3.append("<th width='15%'>تاریخ پایان </th>");
            html3.append("<th width='15%'>وضعیت</th>");
            html3.append("<th width='15%'>عملیات</th>");
            html3.append("<th width='40%'>ویرایش</th>");
            html3.append("</thead><tbody>");
            for (int i = 0; i < stepsRow.size(); i++) {
                html3.append("<tr class='mousePointer " + Sessions.getClassCssForVaziat(stepsRow.get(i).get(Steps._status).toString()) + "'>");
                html3.append("<td class='c'>" + stepsRow.get(i).get(Steps._id) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._title) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._progressPercent) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._executorUserId) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._executorRoleId) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(stepsRow.get(i).get(Steps._startDate)) + "</td>");
                html3.append("<td class='r'>" + jjCalendar_IR.getViewFormat(stepsRow.get(i).get(Steps._endDate)) + "</td>");
                html3.append("<td class='r'>" + stepsRow.get(i).get(Steps._status) + "</td>");
                if (row.get(0).get(_status).equals(status_confirmByManager) && stepsRow.get(i).get(Steps._status).equals(Steps.status_initialRegistration)) {//دکمه ابلاغ زمانی فعال می شود که مدیر برنامه عملیاتی را تایید کرده باشد
                    html3.append("<td class='r'><button class='btn btn-outline-success  btn-block mg-b-10' onclick='hmisSteps.communicatedSteps(" + stepsRow.get(i).get(Steps._id) + ");'>ابلاغ گام ها</button></td>");
                } else {
                    html3.append("<td class='r'><div></div></td>");
                }
                html3.append("<td class='r' onclick='hmisManagerPlans.selectStepsInManagerPlans(" + stepsRow.get(i).get(Steps._id) + "," + id + ");' ><i class='icon ion-gear-a' style='color:#a02311'></i></td>");
                html3.append("</tr>");
            }
            html3.append("</tbody></table>");
//            html5.append("<option>انتخاب کنید</option>");
//            List<Map<String, Object>> RolesRow = jjDatabase.separateRow(db.Select(Role.tableName));
//            for (int i = 0; i < RolesRow.size(); i++) {
//                html5.append("<option id='" + RolesRow.get(i).get(Role._user_id) + "' value='" + RolesRow.get(i).get(Role._id) + "'>" + RolesRow.get(i).get(Role._title) + "</option>");
//            }
//            html6.append("<option>انتخاب کنید</option>");
//            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));
//            for (int i = 0; i < UserRow.size(); i++) {
//                html6.append("<option id='" + UserRow.get(i).get(Access_User._id) + "' value='" + UserRow.get(i).get(Access_User._id) + "'>" + UserRow.get(i).get(Access_User._name) + "-" + UserRow.get(i).get(Access_User._family) + "</option>");
//            }
            //////////////////////////////////////////////////////////////
            script += Js.setHtml("#myPlans_button", html2);
            script += Js.table("#refreshStepsInManagerPlans", "300", 0, "", "جلسات");
            script += Js.setHtml("#tblStepsMyPlans", html3);
            script += html.toString();
//            script += Js.setHtml("#MyPlansSteps_executorUserId", html6);
//            script += Js.setHtml("#MyPlansSteps_executorRoleId", html5);
//            script += Js.setHtml("#MyPlansSteps_trackerId", html5);
            script += Js.setHtml("#filesDownloadDiv", html8);
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * رد توسط مدیر
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String ignoreByManager(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//  ای دی برنامه عملیاتی
            String script = "";
            String result = changeStatus(request, db, id, status_ignorByManager);//رد
            if (result.isEmpty()) {//اگر خطایی نبود
                String errorMessageing = "برنامه عملیاتی رد شد";
                script += Js.modal(errorMessageing, "پیام سامانه");
                script += "hmisManagerPlans.m_select(" + id + ")";//انتخاب برنامه عملیاتی مدیر
                script += "hmisManagerPlans.m_refresh()";//رفرش برنامه های عملیاتی مدیر
            } else {
                String errorMessageing = "برنامه عملیاتی رد نشد";
                script += Js.modal(errorMessageing, "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * تایید توسط مدیر
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String confirmByManager(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//  ای دی جلسات
            String script = "";
            String result = changeStatus(request, db, id, status_confirmByManager);//ابلاغ
            if (result.isEmpty()) {//اگر خطایی نبود
                String errorMessageing = "تایید انجام شد";
                script += Js.modal(errorMessageing, "پیام سامانه");
                script += "hmisManagerPlans.m_select(" + id + ");";
            } else {
                String errorMessageing = "تایید انجام نشد";
                script += Js.modal(errorMessageing, "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * پایش برنامه ها
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String refreshPlansForAssess(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
//            boolean accRulRef = Access_User.hasAccess(request, db, rul_rfs);//
//            boolean accRulRefAll = Access_User.hasAccess(request, db, rul_rfsAll);//

            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            DefaultTableModel dtm = db.Select(tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

            html.append("<div class=\"card-header bg-primary tx-white\">برنامه های عملیاتی/بهبود کیفیت تعریف شده</div>\n");
            html.append(" <div class=\"card-body pd-sm-30\">\n"
                    + " <p class=\"mg-b-20 mg-sm-b-30\">\n"
                    + " <a class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" style='color:#fff' onclick=\"hmisPlans.m_add_new();\" > برنامه عملیاتی/بهبود کیفیت جدید</a>\n"
                    + "  </p>\n"
                    + "  </div>");
            html.append("<div class=\"table-wrapper\">\n");
            html.append("<div align=\"right\">");
            html.append("<table id='refreshPlansForAssess' class='table display responsive' ><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='20%'>عنوان</th>");
            html.append("<th width='20%'>مسئول ایجاد برنامه</th>");
            html.append("<th width='20%'>هدف کلان</th>");
            html.append("<th width='20%'>هدف اختصاصی</th>");
            html.append("<th width='20%'>استراتژی</th>");
            html.append("<th width='30%'>نوع برنامه عملیاتی </th>");
            html.append("<th width='20%'>تاریخ</th>");
            html.append("<th width='20%'>وضعیت</th>");
            html.append("<th width='20%'>درصد کل پیشرفت برنامه</th>");
            html.append("<th width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                float percent = 0;
                List<Map<String, Object>> StepsRow = jjDatabaseWeb.separateRow(db.Select(Steps.tableName, Steps._plansId + "=" + row.get(i).get(_id) + " AND steps_status!='" + Steps.status_initialRegistration + "'"));
                if (StepsRow.size() > 0) {

                    for (int j = 0; j < StepsRow.size(); j++) {//جمع درصد تکمیل گام
                        percent += Float.parseFloat(StepsRow.get(j).get(Steps._percent).toString()) * (Float.parseFloat(StepsRow.get(j).get(Steps._progressPercent).toString()) / 100);
                    }
                }
                System.out.println("percent" + percent);
                html.append("<tr onclick=hmisPlans.m_select(" + row.get(i).get(_id) + ") class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_creatorId).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_hugeGoal).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_minorGoal).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_strategic).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_typeOfProgram).toString()) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_date)) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
                html.append("<td class='r'>" + percent + "%</td>");
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
                panel = "swPlansForAssessTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshPlansForAssess", "300", 0, "", "پایش برنامه های عملیاتی");

            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }
}
