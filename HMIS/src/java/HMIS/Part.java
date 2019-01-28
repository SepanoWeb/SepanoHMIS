/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import cms.access.Access_User;
import static cms.cms.Product.rul_ins;
import cms.tools.Js;
import cms.tools.Server;
import cms.tools.jjTools;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.swing.table.DefaultTableModel;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;

/**
 *
 * @author Shiran1
 */
public class Part {

    public static String tableName = "Part";
    public static String _id = "id";
    public static String _parent = "part_parent";
    public static String _title = "part_title";
    public static String _location = "part_location";
    public static String _publicContent = "part_publicContent";
    public static String _praivateContent = "part_praivateContent";
    public static String _organizationalCode = "part_organizationalCode";
    public static String _description = "part_description";
   
   
    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";
    

    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;
 /**
     *این جدول  مخصوص بخش ها ست
     * @param height is int height of table
     * @param sort is number of default sort column number
     * @param panel is container id
     */
    public static String refresh(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Part.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            DefaultTableModel dtm = db.Select(Part.tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>بخش ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisPart.m_add_new();' > بخش جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshParts' dir='rtl'><thead>");
            html.append("<th style='text-align: center;' width='5%'>کد</th>");
            html.append("<th style='text-align: center;' width='30%'>نام بخش</th>");
            html.append("<th style='text-align: center;' width='20%'>موقعیت</th>");
//            html.append("<th style='text-align: center;' width='10%'></th>");
//            html.append("<th style='text-align: center;' width='30%'></th>");
            html.append("<th style='text-align: center;' width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='hmisPart.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
                html.append("<td class='tahoma10' style='text-align: center;'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td class='tahoma10' style='text-align: left;'>" + (row.get(i).get(_title).toString()) + "</td>");
//              
                html.append("<td class='tahoma10' style='text-align: right;'>" + (row.get(i).get(_location).toString()) + "</td>");

                html.append("<td style='text-align: center;color:red;font-size: 26px;' class='icon ion-ios-gear-outline'><a src='img/l.png' style='cursor: pointer;height:30px' onclick='cmsUser.m_select(" + row.get(i).get(_id) + ");' ></a></td>");
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
                panel = "swPartTbl";
            }
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            html2 += Js.table("#refreshParts", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("")? "14" :"", "لیست بخش ها");
            return html2;
        } catch (Exception e) {
            return Server.ErrorHandler(e);
        }
    }
 public static String add_new(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        StringBuilder html = new StringBuilder();
        try {
            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Part_button", "<div class='row'><div class='col-lg-6'><input type=\"button\" id=\"insert_Part_new\" style='    padding-top: 6px;\n" +
"    padding-bottom: 12px;' value=\"" + lbl_insert + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"></div></div>"));
                html.append(Js.buttonMouseClick("#insert_Part_new", Js.jjPart.insert()));
            }
            return html.toString();
        } catch (Exception e) {
            return Server.ErrorHandler(e);
        }
    }
    /**
     * تابع درج date 1397/11/7 
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
//            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_location, jjTools.getParameter(request, _location));

            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_organizationalCode, jjTools.getParameter(request, _organizationalCode));
            map.put(_praivateContent, jjTools.getParameter(request, _praivateContent));
            map.put(_publicContent, jjTools.getParameter(request, _publicContent));
//            map.put(_parent, jjTools.getParameter(request, _parent));
//            map.put(_plansOfAssessId, jjTools.getParameter(request, _plansOfAssessId));
//            map.put(_range, jjTools.getParameter(request, _range));
//            map.put(_responsible, jjTools.getParameter(request, _responsible));
//            map.put(_strategic, jjTools.getParameter(request, _strategic));
//            map.put(_thePeriodAssess, jjTools.getParameter(request, _thePeriodAssess));
//            map.put(_typeOfProgram, jjTools.getParameter(request, _typeOfProgram));
//            map.put(_titleOfTheProblem, jjTools.getParameter(request, _titleOfTheProblem));
//            map.put(_vaziat, jjTools.getParameter(request, _vaziat));
//            map.put(_ravandeVaziat, vaziat_sabteAvalie
//                    + ":"
//                    + "-"
//                    + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
//                    + " "
//                    + new jjCalendar_IR().getTimeFormat_8length()
//                    + "#A#");//            در زمان زدن دکمه ثبت وضعیت نمونه ثبت اولیه می شود ودر روند وضعیت ثبت اولیه با تاریخ وساعت ثبت می شود

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
  /**
     *
     * @param id
     */
    public static String select(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }

//            if (id.equals("1")) {
//                String errorMessage = "شما اجازه مشاهده اطلاعات این شخص را ندارید";
//                return Js.dialog(errorMessage) + Js.jjUser.showTbl();
//            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

//            html.append(Js.setVal("#user_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#" + _location, row.get(0).get(_location)));
            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setValEditor("#" + _publicContent, row.get(0).get(_publicContent)));
            html.append(Js.setValEditor("#" + _praivateContent, row.get(0).get(_praivateContent)));
            html.append(Js.setVal("#" + _organizationalCode, row.get(0).get(_organizationalCode)));
            html.append(Js.setVal("#" + _parent, row.get(0).get(_parent)));
////            html.append(Js.setVal("#" + _isActive, row.get(0).get(_isActive)));
//            html.append(Js.setVal("#" + _name, row.get(0).get(_name)));
//            html.append(Js.setVal("#" + _AccountInformation, row.get(0).get(_AccountInformation)));
//            html.append(Js.setVal("#" + _birthdate, row.get(0).get(_birthdate)));
//            html.append(Js.setVal("#" + _grade, row.get(0).get(_grade)));
//            html.append(Js.setVal("#" + _jensiat, row.get(0).get(_jensiat)));
//            html.append(Js.setVal("#" + _codeMeli, row.get(0).get(_codeMeli)));
//            html.append(Js.setVal("#" + _shomareShenasname, row.get(0).get(_shomareShenasname)));
//            html.append(Js.setVal("#" + _pass, row.get(0).get(_pass)));
//            html.append(Js.setVal("#" + _passwordReminder, row.get(0).get(_passwordReminder)));
//            html.append(Js.setValDate("#" + _address, row.get(0).get(_address)));
//            html.append(Js.setValDate("#" + _birthdate, row.get(0).get(_birthdate)));

            boolean accDel = Access_User.hasAccess2(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess2(request, db, rul_edt);

            if (accEdt) {
                if (!id.equals("1")) {
                    html2.append("<div class=\"row\"><div class=\"col-lg-6\"><input type=\"button\" id=\"edit_User\" value=\"" + lbl_edit + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"></div>");
                    html.append(Js.buttonMouseClick("#edit_User", Js.jjUser.edit()));
                }
            }
            if (accDel) {
                if (!id.equals("1")) {
                    html2.append("<div class=\"col-lg-6\"><input type=\"button\" id=\"delete_User\" value=\"" + lbl_delete + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"  /></div></div>");
                    html.append(Js.buttonMouseClick("#delete_User", Js.jjUser.delete(id)));
                }
            }
            return (Js.setHtml("#User_button", html2.toString())) + html.toString();
        } catch (Exception e) {
            return Server.ErrorHandler(e);
        }
    }
   
}
