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
import static HMIS.DepartmentPosition._level;
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
    public static String _uploadDate = "managementGauges_uploadDate";
    public static String _comment = "managementGauges_comment";
    public static String _status = "managementGauges_status";
    public static String _level = "managementGauges_level";
    public static String _responsibleGauge = "managementGauges_responsibleGauge";

    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";

    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;

    /**
     * این جدول مخصوص بخش ها ست
     *
     * @param height is int height of table
     * @param sort is number of default sort column number
     * @param panel is container id
     */
    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
//            String hasAccess = Department.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                Server.outPrinter(request, response,hasAccess;
//            }
            StringBuilder html = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

//            DefaultTableModel dtm = db.Select(ManagementGauges.tableName);
//            DefaultTableModel dtm = db.Select(ManagementGauges.tableName, ManagementGauges._responsibleGauge + "=" + jjTools.getSeassionUserId(request),"AND ORDER BY managementgauges.managementgauges_level ");
            DefaultTableModel dtm = db.otherSelect("SELECT * FROM hmis_managementgauges ORDER BY hmis_managementgauges.managementgauges_level  AND  hmis_managementgauges.managementgauges_responsibleGauge="+ jjTools.getSeassionUserId(request)+"");
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>مدیریت سنجه ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisManagementGauges.m_add_new();' > سنجه جدید</a>"
                    + "        </p>");

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
                html.append("<td class='c' >" + (row.get(i).get(_department).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_level).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_standard).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_gauge).toString()) + "</td>");
                String responsible = row.get(i).get(ManagementGauges._responsibleLoading).toString();
                String[] responsibleArray = responsible.split(",");
                html.append("<td class='c' >");
                for (int j = 0; j < responsibleArray.length; j++) {
                List<Map<String, Object>> rowTitleRole = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "='"+responsibleArray[j]+"'"));
                
                
                html.append(" " + (rowTitleRole.get(0).get(Access_User._name).toString() + " " + rowTitleRole.get(0).get(Access_User._family).toString()) + " ");
                }
                 html.append("</td >");
                html.append("<td class='c' >" + (row.get(i).get(_step).toString()) + "</td>");
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
    /*
     getoptionResponsibleLoading
     برای در اوردن مسیول بار گذاری با استفاده از جدول نقشها
     که به ترتیب دخیره درمدیریت سنجه نشان داده میشود
     */

    public static String selectOptionRoleResponsibleLoading(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option  style='color:black' value=''>انتخاب مسئول بارگذاری</option>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Role.tableName));

            for (int i = 0; i < row.size(); i++) {

                html.append("<option value='" + row.get(i).get(Role._user_id).toString() + "'"
                        + (row.get(i).get(Role._user_id).toString().equals(Role._user_id) ? " selected='selected'>" : ">")
                        + row.get(i).get(Role._title).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            }
            if (panel == "") {
                panel = "managementGauges_responsibleLoading";
            }
            script += Js.setHtml("#" + panel, html.toString());

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String selectOptionRoleResponsibleGauge(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {

        StringBuilder html = new StringBuilder();
        try {
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option  style='color:black' value=''>انتخاب مسئول سنجه</option>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Role.tableName));

            for (int i = 0; i < row.size(); i++) {

                html.append("<option value='" + row.get(i).get(Role._user_id).toString() + "'"
                        + (row.get(i).get(Role._user_id).toString().equals(Role._user_id) ? " selected='selected'>" : ">")
                        + row.get(i).get(Role._title).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            }
            if (panel == "") {
                panel = "managementGauges_responsibleGauge";
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
     getoptionUploadDate
     برای در اوردن دوره بار گذاری با استفاده از سلکت دیستینگ
     */

    public static String getoptionUploadDate(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option  style='color:black' value=''>انتخاب دوره بارگذاری</option>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectDistinct(ManagementGauges.tableName, _uploadDate));

            for (int i = row.size() - 1; i >= 0; i--) {

                html.append("<option value='" + row.get(i).get(_uploadDate).toString() + "'"
                        + (row.get(i).get(_uploadDate).toString().equals(_uploadDate) ? " selected='selected'>" : ">")
                        + row.get(i).get(_uploadDate).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            }
            if (panel == "") {
                panel = "managementGauges_uploadDate";
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
     getoptionUploadDate
     برای در اوردن دوره بار گذاری با استفاده از سلکت دیستینگ
     */

    public static String getoptionLevel(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            html.append("<option  style='color:black' value=''>انتخاب سطح</option>");

//            List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectDistinct(ManagementGauges.tableName, _level));
            List<Map<String, Object>> row = jjDatabase.separateRow(db.otherSelect("SELECT DISTINCT * FROM  hmis_managementgauges ORDER By hmis_managementgauges.managementgauges_level"));


//            for (int i = row.size() - 1; i >= 0; i--) {
            for (int i =0;i< row.size() ; i++) {
//                html.append("<option style='color:black' value='" + row.get(i).get(_level).toString() + "'"
//                        + (row.get(i).get(_level).toString().equals(_level) ? " selected='selected'>" : ">")
//                        + row.get(i).get(_level).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)
                html.append("<option style='color:black' value='" + i + "'"
                        + (row.get(i).get(_level).toString().equals(_level) ? " selected='selected'>" : ">")
                        + row.get(i).get(_level).toString() + "</option>");//'option' and 'value' for this fild is same('value' is not necessary)

            
            }
            if (panel == "") {
                panel = "managementGauges_level";
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
            map.put(_standard, jjTools.getParameter(request, _standard));
            map.put(_step, jjTools.getParameter(request, _step));
            map.put(_underTheAxis, jjTools.getParameter(request, _underTheAxis));
            map.put(_uploadDate, jjTools.getParameter(request, _uploadDate));
            map.put(_comment, jjTools.getParameter(request, _comment));
//            StringBuilder html=new StringBuilder();
//            html.append(Js.setVal("#active", "1"));
//            html.append(Js.setVal("#noActive","0"));
            map.put(_status, jjTools.getParameter(request, _status));
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

            script.append(Js.setVal("#" + _standard, row.get(0).get(_standard)));
            script.append("$('#managementGauges_standard').select2();\n");
            script.append(Js.setVal("#" + _step, row.get(0).get(_step)));
            script.append("$('#managementGauges_step').select2();\n");
            script.append(Js.setVal("#" + _responsibleGauge, row.get(0).get(_responsibleGauge)));
            script.append("$('#managementGauges_responsibleGauge').select2();\n");
            script.append(Js.setVal("#" + _uploadDate, row.get(0).get(_uploadDate)));
            script.append("$('#managementGauges_uploadDate').select2();\n");

            script.append(Js.setValSummerNote("#" + _comment, row.get(0).get(_comment)));

            html.append(Js.setVal("#active", "1"));
            html.append(Js.setVal("#noActive", "0"));
            if (row.get(0).get(_status).equals("1")) {
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
            map.put(_standard, jjTools.getParameter(request, _standard));
            map.put(_step, jjTools.getParameter(request, _step));
            map.put(_underTheAxis, jjTools.getParameter(request, _underTheAxis));
            map.put(_uploadDate, jjTools.getParameter(request, _uploadDate));
            map.put(_comment, jjTools.getParameter(request, _comment));
            map.put(_level, jjTools.getParameter(request, _level));
            map.put(_responsibleGauge, jjTools.getParameter(request, _responsibleGauge));
            map.put(_status, jjTools.getParameter(request, _status));
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
}
