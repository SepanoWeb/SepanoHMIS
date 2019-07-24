/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

/**
 *
 * @author shiran
 */
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Shiran1 بخش ها
 */
public class ManagementGauges {

    public static String tableName = "hmis_managementGauges";
    public static String _id = "id";
    public static String _department = "managementGauges_department";
    public static String _axis = "managementGauges_axis";
    public static String _underTheAxis = "managementGauges_underTheAxis";
    public static String _standard = "managementGauges_standard";
    public static String _gauge = "managementGauges_gauge";
    public static String _step = "managementGauges_step";
    public static String _date = "managementGauges_date";
    public static String _responsibleLoading = "managementGauges_responsibleLoading";
    public static String _responsibleLoadingRole = "managementGauges_responsibleLoadingRole";
    public static String _uploadPeriod = "managementGauges_uploadPeriod";
    public static String _comment = "managementGauges_comment";
    public static String _isActive = "managementGauges_isActive";
    public static String _level = "managementGauges_level";
    public static String _responsibleGauge = "managementGauges_responsibleGauge";

    public static String lbl_add_new = "سنجه جدید";
    public static String lbl_insert = "دخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ثبت ویرایش";

    public static int rul_rfs_all = 0;
    public static int rul_rfs_own = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;

    /**
     *
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @throws java.lang.Exception
     * @return اسکریپتی برای ایجاد جدول
     */
    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            DefaultTableModel dtm;
            if (Access_User.hasAccess(request, db, rul_rfs_all)) {
                dtm = db.otherSelect("SELECT " + "group_concat(documentary_status order by hmis_documentary.id) as statuses," + tableName + ".* ," + Department._title + "," + Role._title + "," + Access_User._name + "," + Access_User._family + " FROM  " + tableName
                        + " LEFT JOIN " + Documentary.tableName + " ON " + Documentary._gaugeId + " = hmis_managementGauges.id "
                        + " LEFT JOIN " + Department.tableName + " ON " + _department + " = Department.id "
                        + " LEFT JOIN " + Role.tableName + " ON " + _responsibleLoadingRole + " = hmis_role.id " // برای استخراج نام مسئول بارگذاری و نقش او
                        + " LEFT JOIN " + Access_User.tableName + " ON " + Role._user_id + " = access_user.id "
                        + "group by hmis_managementGauges.id " // ّرای پرچم ها
                        + ";");

            } else if (Access_User.hasAccess(request, db, rul_rfs_own)) {
                String userRolesinSession[] = jjTools.getSeassionUserRole(request).split(",");
                String where = "";
                for (int i = 0; i < userRolesinSession.length; i++) {
                    if (i == userRolesinSession.length - 1) {// برای آخری  OR نمیخواهیم
                        where += _responsibleGauge + "=" + userRolesinSession[i];
                    } else {
                        where += _responsibleGauge + "=" + userRolesinSession[i] + " OR ";
                    }
                }
                dtm = db.otherSelect("SELECT " + tableName + ".* ," + Department._title + "," + Role._title + "," + Access_User._name + "," + Access_User._family + " FROM  " + tableName
                        + " LEFT JOIN " + Department.tableName + " ON " + _department + " = Department.id "
                        + " LEFT JOIN " + Role.tableName + " ON " + _responsibleGauge + " = hmis_role.id " // برای استخراج نام مسئول بارگذاری و نقش او
                        + " LEFT JOIN " + Access_User.tableName + " ON " + Role._user_id + " = access_user.id " + where + ";");
            } else {
                //اگر اجازه مشاهده ی هیچ کدام را نداشت
                Server.outPrinter(request, response, Access_User.getAccessDialog(request, db, rul_rfs_own));
                return "";
            }
            StringBuilder html = new StringBuilder();

//            DefaultTableModel dtm = db.Select(ManagementGauges.tableName);
//            DefaultTableModel dtm = db.Select(ManagementGauges.tableName, ManagementGauges._responsibleGauge + "=" + jjTools.getSeassionUserId(request),"AND ORDER BY managementgauges.managementgauges_level ");
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

            html.append("<div class='card bd-primary mg-t-20'><div class='card-header bg-primary tx-white'>مدیریت سنجه ها</div><div class='card-body pd-sm-30'>");
            if (Access_User.hasAccess(request, db, rul_ins)) {
                html.append("<p class='mg-b-20 mg-sm-b-30'>"
                        + "<a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='" + Js.jjManagementGauges.add_new() + "' >" + lbl_add_new + "</a>"
                        + "</p>");
            }

            html.append("<table class='table display responsive nowrap' id='refreshGauge' dir='rtl'><thead>");
            html.append("<th class='c' width='5%'>کد</th>");
            html.append("<th class='c' width='30%'>واحد/بخش</th>");
            html.append("<th class='c' width='30%'>سطح</th>");
            html.append("<th class='c' width='20%'>استاندارد</th>");
            html.append("<th class='c' width='20%'>سنجه</th>");
            html.append("<th class='c' width='20%'>گام</th>");
            html.append("<th class='c' width='20%'>مسئول بارگذاری</th>");
            html.append("<th class='c' width='20%'>آخرین بارگذاری</th>");

            html.append("<th class='c' width='5%'>ویرایش</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='hmisManagementGauges.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
                html.append("<td class='c' >" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(Department._title).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_level).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_standard).toString()) + "</td>");
                String FlagsHtml = "";
                if (!row.get(i).get("statuses").toString().isEmpty()) {
                    String statusFlags[] = row.get(i).get("statuses").toString().split(",");
                    for (int j = 0; j < statusFlags.length; j++) {
                        if (statusFlags[j].equals(Documentary.status_Uploaded)) {
                            FlagsHtml += "<i class='icon ion-flag' style='color:green;font-size: 1em;padding: 0 5px;'></i>";
                        } else if (statusFlags[j].equals(Documentary.status_noUploaded)) {
                            FlagsHtml += "<i class='icon ion-flag' style='color:red;font-size: 1em;padding: 0 5px;'></i>";
                        }
                    }
                }
                html.append("<td class='c' >" + (row.get(i).get(_gauge).toString())
                        + "<br/>" + FlagsHtml
                        + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_step).toString()) + "</td>");
                html.append("<td class='c' >" + row.get(i).get(Role._title).toString() + "<br/>(" + row.get(i).get(Access_User._name).toString() + " " + row.get(i).get(Access_User._family).toString() + ")</td>");
                html.append("<td class='c' >" + (row.get(i).get(_date).toString()) + "</td>");
                html.append("<td style='text-align: center;color:red;font-size: 26px;' class='icon ion-ios-gear-outline'><a src='img/l.png' style='cursor: pointer;height:30px' onclick='hmisManagementGauges.m_select(" + row.get(i).get(_id) + ");' ></a></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            html.append("</div></div>");

            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swManagementGaugesTbl";
            }
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            html2 += Js.table("#refreshGauge", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست  سنجه ها");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
//*
//   این تابع برای در اوردن بخش ها از جدول بخش ها نوشته شده
//*//

    public static String selectOptionDepartment(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            String html4 = "<option id='selectHospital0' style='color:black' value=''>موقعیت مورد نظر را انتخاب کنید</option>";
            Document doc = Jsoup.parse(html4);
            List<Map<String, Object>> rowLocation = jjDatabase.separateRow(db.Select(DepartmentPosition.tableName, "*", "id>=0", DepartmentPosition._parent));
            for (int i = 0; i < rowLocation.size(); i++) {
                String parentID = rowLocation.get(i).get(DepartmentPosition._parent).toString();
                String space = "-";
                for (int j = 0; j <= Integer.parseInt(rowLocation.get(i).get(DepartmentPosition._level).toString()); j++) {
                    space += "- ";
                }
                String optionHtml = "<option id='selectHospital" + rowLocation.get(i).get(_id) + "'  value='" + rowLocation.get(i).get(DepartmentPosition._subcategory) + "'>"
                        + space
                        + rowLocation.get(i).get(DepartmentPosition._subcategory)
                        + "</option>";
                doc.getElementById("selectHospital" + parentID).append(optionHtml);
                String level = rowLocation.get(i).get(DepartmentPosition._level).toString();
//                for (int j = 0; j <  ; j++) {
//                doc.select(parentID).append("<div id='" + rowLocation.get(i).get(_id) + "' level='" + level + "' class='parentTree closed level" + level + "' >" + rowLocation.get(i).get(Department._subcategory) + "</div>");
//                }
                String haspitalname = rowLocation.get(i).get(DepartmentPosition._subcategory).toString();
//                doc.select(parentSelector).append("<div  level='" + level + "' class='parentTree closed level" + level + "' > <span onclick=\"cmsLocation.showsubdiv(this);\" style='cursor: pointer;'>+</span><span onclick=\"cmsLocation.saveuniversity(this);\" id='" + row.get(i).get(_id) + "'>" + row.get(i).get(_universityname) + "</span></div>");
            }
            if (panel == "") {
                panel = "managementGauges_department";
            }
            script += Js.setHtml("#" + panel, doc.getElementsByTag("body").toString());

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    /*
     getoptionAxis
     برای در اوردن  محور با استفاده از سلکت دیستینگ
     که به ترتیب دخیره درمدیریت سنجه نشان داده میشود
     */
    public static String getoptionAxis(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option  style='color:black;' value=''>انتخاب  محور</option>");
            List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectDistinct(ManagementGauges.tableName, _axis));
            for (int i = row.size() - 1; i >= 0; i--) {
                html.append("<option value='" + row.get(i).get(_axis).toString() + "'"
                        + (row.get(i).get(_axis).toString().equals(_axis) ? " selected='selected'>" : ">")
                        + row.get(i).get(_axis).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            }
            if (panel == "") {
                panel = "managementGauges_axis";
            }
            script += Js.setHtml("#" + panel, html.toString());

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
    /*
     getoptionUnderAxis
     برای در اوردن زیر محور با استفاده از سلکت دیستینگ
     که به ترتیب دخیره درمدیریت سنجه نشان داده میشود
     */

    public static String getoptionUnderAxis(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option  style='color:black' value=''>انتخاب زیر  محور</option>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectDistinct(ManagementGauges.tableName, _underTheAxis));

            for (int i = row.size() - 1; i >= 0; i--) {

                html.append("<option value='" + row.get(i).get(_underTheAxis).toString() + "'"
                        + (row.get(i).get(_underTheAxis).toString().equals(_underTheAxis) ? " selected='selected'>" : ">")
                        + row.get(i).get(_underTheAxis).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            }
            if (panel == "") {
                panel = "managementGauges_underTheAxis";
            }
            script += Js.setHtml("#" + panel, html.toString());

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
    /*
     getoptionStandard
     برای در اوردن استاندارد با استفاده از سلکت دیستینگ
     که به ترتیب دخیره درمدیریت سنجه نشان داده میشود
     */

    public static String getoptionStandard(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option  style='color:black' value=''>انتخاب استاندارد</option>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectDistinct(ManagementGauges.tableName, _standard));

            for (int i = row.size() - 1; i >= 0; i--) {

                html.append("<option value='" + row.get(i).get(_standard).toString() + "'"
                        + (row.get(i).get(_standard).toString().equals(_standard) ? " selected='selected'>" : ">")
                        + row.get(i).get(_standard).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            }
            if (panel == "") {
                panel = "managementGauges_standard";
            }
            script += Js.setHtml("#" + panel, html.toString());

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
    /*
     getoptionGauge
     برای در اوردن سنجه با استفاده از سلکت دیستینگ
     که به ترتیب دخیره درمدیریت سنجه نشان داده میشود
     */

    public static String getoptionGauge(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option  style='color:black' value=''>انتخاب سنجه</option>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectDistinct(ManagementGauges.tableName, _gauge));

            for (int i = row.size() - 1; i >= 0; i--) {

                html.append("<option value='" + row.get(i).get(_gauge).toString() + "'"
                        + (row.get(i).get(_gauge).toString().equals(_gauge) ? " selected='selected'>" : ">")
                        + row.get(i).get(_gauge).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            }
            if (panel == "") {
                panel = "managementGauges_gauge";
            }
            script += Js.setHtml("#" + panel, html.toString());

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
    /*
     getoptionStep
     برای در اوردن گام ها با استفاده از سلکت دیستینگ
     که به ترتیب دخیره درمدیریت سنجه نشان داده میشود
     */

    public static String getoptionStep(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option  style='color:black' value=''>انتخاب گام</option>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectDistinct(ManagementGauges.tableName, _step));

            for (int i = row.size() - 1; i >= 0; i--) {

                html.append("<option value='" + row.get(i).get(_step).toString() + "'"
                        + (row.get(i).get(_step).toString().equals(_step) ? " selected='selected'>" : ">")
                        + row.get(i).get(_step).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            }
            if (panel == "") {
                panel = "managementGauges_step";
            }
            script += Js.setHtml("#" + panel, html.toString());

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        StringBuilder script = new StringBuilder();
        StringBuilder script1 = new StringBuilder();
        try {

            html.append(Js.setVal("#active", "1"));
            html.append(Js.setVal("#noActive", "0"));

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);

            if (accIns) {
                script.append(Js.setHtml("#ManagementGauges_button", "<div class='col-lg-6'><input type='button' id='insert_ManagementGauges_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success active btn-block mg-b-10'></div>"));
                script.append(Js.click("#insert_ManagementGauges_new", Js.jjManagementGauges.insert()));
            }
            Server.outPrinter(request, response, html.toString() + script + script1);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    /**
     * تابع درج date 1398/02/21
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
//            if (!hasAccess.equals("")) {
//                Server.outPrinter(request, response, hasAccess);
//                return "";
//            }

            Map<String, Object> map = new HashMap<String, Object>();

            map.put(_axis, jjTools.getParameter(request, _axis));
            map.put(_date, jjTools.getParameter(request, _date));
            map.put(_department, jjTools.getParameter(request, _department));
            map.put(_gauge, jjTools.getParameter(request, _gauge));
            map.put(_responsibleLoading, jjTools.getParameter(request, _responsibleLoading));
            map.put(_responsibleLoadingRole, jjTools.getParameter(request, _responsibleLoadingRole));
            map.put(_standard, jjTools.getParameter(request, _standard));
            map.put(_step, jjTools.getParameter(request, _step));
            map.put(_underTheAxis, jjTools.getParameter(request, _underTheAxis));
            map.put(_uploadPeriod, jjTools.getParameter(request, _uploadPeriod));
            map.put(_comment, jjTools.getParameter(request, _comment));
//            StringBuilder html=new StringBuilder();
//            html.append(Js.setVal("#active", "1"));
//            html.append(Js.setVal("#noActive","0"));
            map.put(_isActive, jjTools.getParameter(request, _isActive));
            map.put(_level, jjTools.getParameter(request, _level));
            map.put(_responsibleGauge, jjTools.getParameter(request, _responsibleGauge));

            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            Server.outPrinter(request, response, Js.jjManagementGauges.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     *
     * @param id
     */
    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.dialog(errorMessageId));
                return "";
            }
            StringBuilder script = new StringBuilder();
            StringBuilder script1 = new StringBuilder();

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            script.append(Js.setVal("#managementGauges_" + _id, row.get(0).get(_id)));

            script.append(Js.setVal("#" + _axis, row.get(0).get(_axis)));
            script.append("$('#managementGauges_axis').select2();\n");

            script.append(Js.setVal("#" + _underTheAxis, row.get(0).get(_underTheAxis)));
            script.append("$('#managementGauges_underTheAxis').select2();\n");
            script.append(Js.setVal("#" + _date, row.get(0).get(_date)));
            script.append(Js.setVal("#" + _department, row.get(0).get(_department)));
            script.append("$('#managementGauges_department').select2();\n");
            script.append(Js.setVal("#" + _gauge, row.get(0).get(_gauge)));
            script.append("$('#managementGauges_gauge').select2();\n");
            String responsibleLoading = row.get(0).get(_responsibleLoading).toString();

            String[] responsibleLoadingArray = responsibleLoading.split(",");//آی دی  ها با این رشته از هم جدا می شود
            String temp = "";
            for (int j = 0; j < responsibleLoadingArray.length; j++) {
                temp += "'" + responsibleLoadingArray[j] + "',";
                System.out.println("responsibleLoadingArray=" + temp);
            }

            script.append("$('#managementGauges_responsibleLoading').val([" + temp + "]);"
                    + "$('#managementGauges_responsibleLoading').select2({  minimumResultsForSearch: '',  width: '100%'});");

            script.append(Js.setVal("#" + _responsibleLoadingRole, row.get(0).get(_responsibleLoadingRole)));
            script.append(Js.select2("#" + _responsibleLoadingRole, ""));
            script.append(Js.setVal("#" + _standard, row.get(0).get(_standard)));
            script.append("$('#managementGauges_standard').select2();\n");
            script.append(Js.setVal("#" + _step, row.get(0).get(_step)));
            script.append("$('#managementGauges_step').select2();\n");
            script.append(Js.setVal("#" + _responsibleGauge, row.get(0).get(_responsibleGauge)));
            script.append("$('#managementGauges_responsibleGauge').select2();\n");
            script.append(Js.setVal("#" + _uploadPeriod, row.get(0).get(_uploadPeriod)));

            script.append(Js.setValSummerNote("#" + _comment, row.get(0).get(_comment)));

            html.append(Js.setVal("#active", "1"));
            html.append(Js.setVal("#noActive", "0"));
            if (row.get(0).get(_isActive).equals("1")) {
//           
                html.append(Js.setAttr("#active", "checked", "checked"));

            } else {
//           
                html.append(Js.setAttr("#noActive", "checked", "checked"));
            }
//            script.append(Js.setVal("#" + _status, row.get(0).get(_status)));
            script.append(Js.setVal("#" + _level, row.get(0).get(_level)));
            script.append(Js.setVal("#" + _responsibleGauge, row.get(0).get(_responsibleGauge)));

            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjManagementGauges.edit() + "' id='edit_ManagementGauges'>" + lbl_edit + "</button></div>";
//               
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjManagementGauges.delete(id) + "' id='delete_ManagementGauges'>" + lbl_delete + "</button></div>";
            }
            script1.append(Js.setHtml("#ManagementGauges_button", htmlBottons));

            Server.outPrinter(request, response, html.toString() + script + script1);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            String id = jjTools.getParameter(request, _id);
//           
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_axis, jjTools.getParameter(request, _axis));
            map.put(_date, jjTools.getParameter(request, _date));
            map.put(_department, jjTools.getParameter(request, _department));
            map.put(_gauge, jjTools.getParameter(request, _gauge));
            map.put(_responsibleLoading, jjTools.getParameter(request, _responsibleLoading));
            map.put(_responsibleLoadingRole, jjTools.getParameter(request, _responsibleLoadingRole));
            map.put(_standard, jjTools.getParameter(request, _standard));
            map.put(_step, jjTools.getParameter(request, _step));
            map.put(_underTheAxis, jjTools.getParameter(request, _underTheAxis));
            map.put(_uploadPeriod, jjTools.getParameter(request, _uploadPeriod));
            map.put(_comment, jjTools.getParameter(request, _comment));
            map.put(_level, jjTools.getParameter(request, _level));
            map.put(_responsibleGauge, jjTools.getParameter(request, _responsibleGauge));
            map.put(_isActive, jjTools.getParameter(request, _isActive));
            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }

            Server.outPrinter(request, response, Js.jjManagementGauges.refresh());
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {

            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.dialog(errorMessageId));
                return "";
            }

            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }

            Server.outPrinter(request, response, Js.jjManagementGauges.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static void taskDocumentaryReminder() throws Exception {
        System.out.println("#################################################");
        System.out.println("######>>>>>RUN:taskDocumentaryReminder###########");
        Server.Connect();
        jjDatabaseWeb db = Server.db;
        List<Map<String, Object>> rows = jjDatabaseWeb.separateRow(db.Select(tableName, _isActive + "=1 AND " + _uploadPeriod + " !='' "));
        for (int i = 0; i < rows.size(); i++) {
            jjCalendar_IR date = new jjCalendar_IR(rows.get(i).get(_date).toString());
            int period = Integer.valueOf(rows.get(i).get(_uploadPeriod).toString());
            int today = jjCalendar_IR.getDatabaseFormat_8length(null, true);
            while (today > date.getDBFormat_8length()) {
                date.addDay(period);
            }
            if (date.getDBFormat_8length() == today) {
                System.out.println(">>>>>>>" + today);
                DefaultTableModel rowDocument = db.Select(Documentary.tableName, Documentary._gaugeId + "= " + rows.get(i).get(_id) + " AND " + Documentary._dateCreation + "=" + today);
                if (rowDocument.getRowCount() == 0) {// اگر قبلا ایجاد نکرده بودیم
                    Map<String, Object> map = new HashMap<>();
                    map.put(Documentary._dateCreation, today);
                    map.put(Documentary._gaugeId, rows.get(i).get(_id));
                    map.put(Documentary._responsibleLoadingRole, rows.get(i).get(_responsibleLoadingRole));
                    map.put(Documentary._title,  rows.get(i).get(_step));
                    List<Map<String, Object>> insertedRow = jjDatabaseWeb.separateRow(db.insert(Documentary.tableName, map));
                    if (insertedRow.size() > 0) {
                        Documentary.changeStatus(db, insertedRow.get(0).get(Documentary._id).toString(), Documentary.status_noUploaded);
                    }
                }
            }
        }
        System.out.println("#################################################");
    }
    
}
