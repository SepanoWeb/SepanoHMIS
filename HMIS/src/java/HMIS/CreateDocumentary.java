/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;


//import static HMIS.Location._haspitalname;
//import static HMIS.Location._id;
//import static HMIS.Location._level;
//import static HMIS.Location._parent;
//import static HMIS.Location.tableName;
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
 * @author PadidarNB
 */
public class CreateDocumentary {

    public static String tableName = "hmis_createDocumentary";
    public static String _id = "id";
    public static String _title = "createDocumentary_title";
    public static String _date = "createDocumentary_date";
    public static String _summary = "createDocumentary_summary";

    public static String _file1 = "createDocumentary_file1";//فایل پیوست
    public static String _file2 = "createDocumentary_file2";// فایل پیوست
    public static String _file3 = "createDocumentary_file3";//فایل پیوست
    public static String _attachmentfile1 = "createDocumentary_attachmentfile1";//فایل پیوست
    public static String _attachmentfile2 = "createDocumentary_attachmentfile2";//فایل پیوست
    public static String _attachmentfile3 = "createDocumentary_attachmentfile3";//فایل پیوست
    public static String _titleFile3 = "createDocumentary_titleFile3";//عنوان فایل3
    public static String _titleFile2 = "createDocumentary_titleFile2";//
    public static String _titleFile1 = "createDocumentary_titleFile1";//
    public static String _category = "createDocumentary_category";//
    public static String _status = "createDocumentary_status";//وضعیت امضا
    public static String _logStatus = "createDocumentary_logStatus";//جزییات امضا

    public static String _htmlContent = "createDocumentary_htmlContent";//SUMMERNOTE
    public static String _signatory_user_1 = "createDocumentary_signatory_user_1";//فرد امضا کننده
    public static String _signatory_user_2 = "createDocumentary_signatory_user_2";//امضا کننده
    public static String _signatory_user_3 = "createDocumentary_signatory_user_3";//امضا کننده
    public static String _signatory_user_4 = "createDocumentary_signatory_user_4";//امضا کننده
    public static String _signatory_user_5 = "createDocumentary_signatory_user_5";//امضا کننده
    public static String _signatory_user_6 = "createDocumentary_signatory_user_6";//امضا کننده
    public static String _signatory_user_7 = "createDocumentary_signatory_user_7";//امضا کننده
    public static String _signatory_user_8 = "createDocumentary_signatory_user_8";//امضا کننده
    public static String _signatory_user_9 = "createDocumentary_signatory_user_9";//امضا کننده
    public static String _signatory_user_10 = "createDocumentary_signatory_user_10";//امضا کننده
    public static String _signatory_user_11 = "createDocumentary_signatory_user_11";//امضا کننده
    public static String _signatory_user_12 = "createDocumentary_signatory_user_12";//امضا کننده
    public static String _signatory_user_13 = "createDocumentary_signatory_user_13";//امضا کننده
    public static String _signatory_user_14 = "createDocumentary_signatory_user_14";//امضا کننده
    public static String _signatory_user_15 = "createDocumentary_signatory_user_15";//امضا کننده
    public static String _signatory_user_16 = "createDocumentary_signatory_user_16";//امضا کننده
    public static String _signatory_user_17 = "createDocumentary_signatory_user_17";//امضا کننده
    public static String _signatory_user_18 = "createDocumentary_signatory_user_18";//امضا کننده
    public static String _signatory_user_19 = "createDocumentary_signatory_user_19";//امضا کننده
    public static String _signatory_user_20 = "createDocumentary_signatory_user_20";//امضا کننده

    public static String _signatory_title_1 = "createDocumentary_signatory_title_1";//امضا کننده عنوان
    public static String _signatory_title_2 = "createDocumentary_signatory_title_2";//امضا کننده عنوان
    public static String _signatory_title_3 = "createDocumentary_signatory_title_3";//امضا کننده عنوان
    public static String _signatory_title_4 = "createDocumentary_signatory_title_4";//امضا کننده عنوان
    public static String _signatory_title_5 = "createDocumentary_signatory_title_5";//امضا کننده عنوان
    public static String _signatory_title_6 = "createDocumentary_signatory_title_6";//امضا کننده عنوان
    public static String _signatory_title_7 = "createDocumentary_signatory_title_7";//امضا کننده عنوان
    public static String _signatory_title_8 = "createDocumentary_signatory_title_8";//امضا کننده عنوان
    public static String _signatory_title_9 = "createDocumentary_signatory_title_9";//امضا کننده عنوان
    public static String _signatory_title_10 = "createDocumentary_signatory_title_10";//امضا کننده عنوان
    public static String _signatory_title_11 = "createDocumentary_signatory_title_11";//امضا کننده عنوان
    public static String _signatory_title_12 = "createDocumentary_signatory_title_12";//امضا کننده عنوان
    public static String _signatory_title_13 = "createDocumentary_signatory_title_13";//امضا کننده عنوان
    public static String _signatory_title_14 = "createDocumentary_signatory_title_14";//امضا کننده عنوان
    public static String _signatory_title_15 = "createDocumentary_signatory_title_15";//امضا کننده عنوان
    public static String _signatory_title_16 = "createDocumentary_signatory_title_16";//امضا کننده عنوان
    public static String _signatory_title_17 = "createDocumentary_signatory_title_17";//امضا کننده عنوان
    public static String _signatory_title_18 = "createDocumentary_signatory_title_18";//امضا کننده عنوان
    public static String _signatory_title_19 = "createDocumentary_signatory_title_19";//امضا کننده عنوان
    public static String _signatory_title_20 = "createDocumentary_signatory_title_20";//امضا کننده عنوان

    public static String _signatory_signature_1 = "createDocumentary_signatory_signature_1";//امضا کننده امضا
    public static String _signatory_signature_2 = "createDocumentary_signatory_signature_2";//امضا کننده امضا
    public static String _signatory_signature_3 = "createDocumentary_signatory_signature_3";//امضا کننده امضا
    public static String _signatory_signature_4 = "createDocumentary_signatory_signature_4";//امضا کننده امضا
    public static String _signatory_signature_5 = "createDocumentary_signatory_signature_5";//امضا کننده امضا
    public static String _signatory_signature_6 = "createDocumentary_signatory_signature_6";//امضا کننده امضا
    public static String _signatory_signature_7 = "createDocumentary_signatory_signature_7";//امضا کننده امضا
    public static String _signatory_signature_8 = "createDocumentary_signatory_signature_8";//امضا کننده امضا
    public static String _signatory_signature_9 = "createDocumentary_signatory_signature_9";//امضا کننده امضا
    public static String _signatory_signature_10 = "createDocumentary_signatory_signature_10";//امضا کننده امضا
    public static String _signatory_signature_11 = "createDocumentary_signatory_signature_11";//امضا کننده امضا
    public static String _signatory_signature_12 = "createDocumentary_signatory_signature_12";//امضا کننده امضا
    public static String _signatory_signature_13 = "createDocumentary_signatory_signature_13";//امضا کننده امضا
    public static String _signatory_signature_14 = "createDocumentary_signatory_signature_14";//امضا کننده امضا
    public static String _signatory_signature_15 = "createDocumentary_signatory_signature_15";//امضا کننده امضا
    public static String _signatory_signature_16 = "createDocumentary_signatory_signature_16";//امضا کننده امضا
    public static String _signatory_signature_17 = "createDocumentary_signatory_signature_17";//امضا کننده امضا
    public static String _signatory_signature_18 = "createDocumentary_signatory_signature_18";//امضا کننده امضا
    public static String _signatory_signature_19 = "createDocumentary_signatory_signature_19";//امضا کننده امضا
    public static String _signatory_signature_20 = "createDocumentary_signatory_signature_20";//امضا کننده امضا
    public static String _signatory_comment_1 = "createDocumentary_signatory_comment_1";//امضا کننده توضیح
    public static String _signatory_comment_2 = "createDocumentary_signatory_comment_2";//امضا کننده توضیح
    public static String _signatory_comment_3 = "createDocumentary_signatory_comment_3";//امضا کننده توضیح
    public static String _signatory_comment_4 = "createDocumentary_signatory_comment_4";//امضا کننده توضیح
    public static String _signatory_comment_5 = "createDocumentary_signatory_comment_5";//امضا کننده توضیح
    public static String _signatory_comment_6 = "createDocumentary_signatory_comment_6";//امضا کننده توضیح
    public static String _signatory_comment_7 = "createDocumentary_signatory_comment_7";//امضا کننده توضیح
    public static String _signatory_comment_8 = "createDocumentary_signatory_comment_8";//امضا کننده توضیح
    public static String _signatory_comment_9 = "createDocumentary_signatory_comment_9";//امضا کننده توضیح
    public static String _signatory_comment_10 = "createDocumentary_signatory_comment_10";//امضا کننده توضیح
    public static String _signatory_comment_11 = "createDocumentary_signatory_comment_11";//امضا کننده توضیح
    public static String _signatory_comment_12 = "createDocumentary_signatory_comment_12";//امضا کننده توضیح
    public static String _signatory_comment_13 = "createDocumentary_signatory_comment_13";//امضا کننده توضیح
    public static String _signatory_comment_14 = "createDocumentary_signatory_comment_14";//امضا کننده توضیح
    public static String _signatory_comment_15 = "createDocumentary_signatory_comment_15";//امضا کننده توضیح
    public static String _signatory_comment_16 = "createDocumentary_signatory_comment_16";//امضا کننده توضیح
    public static String _signatory_comment_17 = "createDocumentary_signatory_comment_17";//امضا کننده توضیح
    public static String _signatory_comment_18 = "createDocumentary_signatory_comment_18";//امضا کننده توضیح
    public static String _signatory_comment_19 = "createDocumentary_signatory_comment_19";//امضا کننده توضیح
    public static String _signatory_comment_20 = "createDocumentary_signatory_comment_20";//امضا کننده توضیح

    public static String _signatory_role_1 = "createDocumentary_signatory_role_1";//نقش امضا کننده
    public static String _signatory_role_2 = "createDocumentary_signatory_role_2";
    public static String _signatory_role_3 = "createDocumentary_signatory_role_3";
    public static String _signatory_role_4 = "createDocumentary_signatory_role_4";
    public static String _signatory_role_5 = "createDocumentary_signatory_role_5";
    public static String _signatory_role_6 = "createDocumentary_signatory_role_6";
    public static String _signatory_role_7 = "createDocumentary_signatory_role_7";
    public static String _signatory_role_8 = "createDocumentary_signatory_role_8";
    public static String _signatory_role_9 = "createDocumentary_signatory_role_9";
    public static String _signatory_role_10 = "createDocumentary_signatory_role_10";
    public static String _signatory_role_11 = "createDocumentary_signatory_role_11";
    public static String _signatory_role_12 = "createDocumentary_signatory_role_12";
    public static String _signatory_role_13 = "createDocumentary_signatory_role_13";
    public static String _signatory_role_14 = "createDocumentary_signatory_role_14";
    public static String _signatory_role_15 = "createDocumentary_signatory_role_15";
    public static String _signatory_role_16 = "createDocumentary_signatory_role_16";
    public static String _signatory_role_17 = "createDocumentary_signatory_role_17";
    public static String _signatory_role_18 = "createDocumentary_signatory_role_18";
    public static String _signatory_role_19 = "createDocumentary_signatory_role_19";
    public static String _signatory_role_20 = "createDocumentary_signatory_role_20";
    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ثبت ویرایش";
    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Department.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
//            StringBuilder script = new StringBuilder();

            DefaultTableModel dtm = db.Select(CreateDocumentary.tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "<div class='card-header bg-primary tx-white'>مستند</div>"
                    + "<div class='card-body pd-sm-30'>"
                    + "<p class='mg-b-20 mg-sm-b-30'>"
                    + "    <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisCreateDocumentary.m_add_new();' > مستند جدید</a>"
                    + "</p>");

            html.append("<table class='table display responsive nowrap' id='refreshCreateDocumentary' dir='rtl'><thead>");
            html.append("<th style='text-align: center;' width='5%'>کد</th>");
            html.append("<th style='text-align: center;' width='30%'>عنوان مستند</th>");
            html.append("<th style='text-align: center;' width='30%'>تاییدامضا </th>");

            html.append("<th style='text-align: center;' width='5%'>عملیات</th>");
            html.append("</thead><tbody>");

            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='hmisCreateDocumentary.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
                html.append("<td class='tahoma10' style='text-align: center;'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td class='c'>");
                ///این forبرای این است که کسانی که امضا کردند تیک سبز میخورد
                for (int j = 1; j <= 20; j++) {
                    if (!row.get(i).get("createDocumentary_signatory_user_" + j).equals("")) {
                        if (row.get(i).get("createDocumentary_signatory_signature_" + j).equals("1")) {
                            html.append("<img src='imgfeyz/tick.png' style='height:15px;'/>");
//                    }
                        } else if (row.get(i).get("createDocumentary_signatory_signature_" + j).equals("0")) {

                            html.append("<img src='imgfeyz/remove.png' style='height:19px;'/>");
                        } else if (row.get(i).get("createDocumentary_signatory_signature_" + j).equals("-1")) {

                            html.append("<img src='imgfeyz/icons8-help-48.png' style='height:20px;'/>");
                        }
                    }
                }
                html.append("</td >");
                html.append("<td style='text-align: center;color:red;font-size: 26px;'  class='c icon ion-ios-gear-outline'><a src='img/l.png' style='cursor: pointer;height:30px' onclick='hmisCreateDocumentary.m_select(" + row.get(i).get(_id) + ");' ></a></td>");
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
                panel = "swCreateDocumentaryTbl";
            }
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            html2 += Js.table("#refreshCreateDocumentary", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست مستندات");
            String script = "hmisSignDocumentary.m_refresh();";
            Server.outPrinter(request, response, html2 + script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    ////////    این تابع برای تغییر وضعیت پیام ونشان دادن روند وضعیت ایجاد شده توسظ شیران1
////////تاریخ ایجاد 1398/01/20
    public static String changeStatus(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, String id, String newSatus) throws Exception {
        try {
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                return Js.dialog(errorMessageId);
            }
            db.otherStatement("UPDATE " + tableName + " SET " + _logStatus
                    + "=concat(ifnull(" + _logStatus + ",''),'"
                    + newSatus
                    + "-"
                    + jjCalendar_IR.getViewFormat(new jjCalendar_IR().getDBFormat_8length())
                    + " "
                    + new jjCalendar_IR().getTimeFormat_8length()
                    + "%23A%23"
                    + "') ,"
                    + _status + "='" + newSatus + "'  WHERE id=" + id + ";");

            return "";
        } catch (Exception ex) {
            Server.ErrorHandler(ex);
            String errorMessage = "عملیات تغییر وضعیت به درستی صورت نگرفت.Err114";
            Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
            return "";

        }
    }
    /*
     این تابع برای نمایش جدول امضا وتایید مستندات من نوشته شده توسط شیران1
     */

    public static String refreshSignatureMyDocumentation(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Department.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "<div class='card-header bg-primary tx-white'>تایید وامضا مستندات من</div>"
                    + "<div class='card-body pd-sm-30'>"
            );

            html.append("<table class='table display responsive nowrap' id='refreshSignatureMyDocumentation' dir='rtl'><thead>");
            html.append("<th style='text-align: center;' width='5%'>کد</th>");

            html.append("<th style='text-align: center;' width='30%'>عنوان مستند </th>");
            html.append("<th style='text-align: center;' width='30%'>تایید امضا </th>");

            html.append("<th style='text-align: center;' width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
//            DefaultTableModel dtm = db.Select(CreateDocumentary.tableName);///////////////برای کسانی که در setlectoption هستند والان لاگین شدن
            for (int j = 1; j <= 20; j++) {
                String userid = String.valueOf(jjTools.getSeassionUserId(request));
                DefaultTableModel dtm = db.Select(CreateDocumentary.tableName, "createDocumentary_signatory_user_" + j + "='" + jjTools.getSessionAttribute(request, "#ID") + "'");///////////////برای کسانی که در setlectoption هستند والان لاگین شدن
                List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
                for (int i = 0; i < row.size(); i++) {
                    if (userid.equals(row.get(i).get("createDocumentary_signatory_user_" + j))) {

                        html.append("<tr   class='mousePointer'>");
                        html.append("<td class='tahoma10' style='text-align: center;'>" + (row.get(i).get(_id).toString()) + "</td>");

                        html.append("<td class='tahoma10' style='text-align: left;'>" + row.get(i).get(CreateDocumentary._title).toString() + "</td>");
                        html.append("<td class='tahoma10' style='text-align: left;'>");
                        ///این forبرای این است که کسانی که امضا کردند تیک سبز میخورد

////                 
                        if (!row.get(i).get("createDocumentary_signatory_user_" + j).equals("")) {
                            if (row.get(i).get("createDocumentary_signatory_signature_" + j).equals("1")) {
                                html.append("<img src='imgfeyz/tick.png' style='height:15px;'/>");
//                    }
                            } else if (row.get(i).get("createDocumentary_signatory_signature_" + j).equals("0")) {

                                html.append("<img src='imgfeyz/remove.png' style='height:19px;'/>");
                            } else if (row.get(i).get("createDocumentary_signatory_signature_" + j).equals("-1")) {

                                html.append("<img src='imgfeyz/icons8-help-48.png' style='height:20px;'/>");
                            }
                        }

                        html.append("</td >");

                        html.append("<td style='text-align: center;color:red' ><a  class='icon ion-ios-gear-outline' style='cursor: pointer;height:30px'  href='Server?do=CreateDocumentary.selectOneDocuementToSign&id=" + row.get(i).get(_id) + "' target='_blank'></a>" + "</td>");
                        html.append("</tr>");

                    }
                }
            }

            html.append("</tbody></table>");
            html.append("</div></div>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swSignDocumentaryTbl";
            }
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            html2 += Js.table("#refreshSignatureMyDocumentation", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست مستندات");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
    ////این تابع برای نمایش اسم کاربران درمستند 
    //    selectoption 

    public static String selectOptionUserSignture(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            String panel = jjTools.getParameter(request, "panel");

            String html4 = "<option id='selectUserSignture' style='color:black' value=''>امضا کننده مورد نظر را انتخاب کنید</option>";
            Document doc = Jsoup.parse(html4);

            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));

            for (int i = 0; i < UserRow.size(); i++) {

                String optionHtml = "<option id='selectUserSignture" + UserRow.get(i).get(_id) + "'  value='" + UserRow.get(i).get(_id) + "'>"
                        + UserRow.get(i).get(Access_User._name)
                        + " "
                        + UserRow.get(i).get(Access_User._family)
                        + "</option>";
                doc.getElementById("selectUserSignture").append(optionHtml);

            }

            if (panel == "") {

                panel = ".form-group";
            }

            String script = Js.setHtml("#" + panel, doc.getElementsByTag("body").toString());

            Server.outPrinter(request, response, script.replaceAll("#", ""));
            return "";

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }

    }

    public static String selectOneDocuementToSign(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {

        try {
            String id = jjTools.getParameter(request, "id");
            int userID = jjTools.getSeassionUserId(request);
            String where = _id + "=" + id + " AND (";
            for (int i = 1; i < 20; i++) {
                where += " createDocumentary_signatory_user_" + i + "=" + userID + " OR ";
            }
            where += " createDocumentary_signatory_user_20" + "=" + userID + ")";

//        where += " AND " + ;
            if (db.Select(tableName, where).getRowCount() != 1) {
                String errorMessage = "شما اجازه ی دسترسی ندارید.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }

            request.setAttribute("db", db);
            request.getRequestDispatcher("feiz/signMyDocumentary.jsp").forward(request, response);

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
        return "";
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        StringBuilder script = new StringBuilder();
        try {
           
//            script.append("$('.form-group').select2({ width: '100%'});\n");

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);

            if (accIns) {
                script.append(Js.setHtml("#CreateDocumentary_button", "<div class='col-lg-6'><input type='button' id='insert_CreateDocumentary_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success active btn-block mg-b-10'></div>"));
                script.append(Js.click("#insert_CreateDocumentary_new", Js.jjCreateDocumentary.insert()));
            }
            Server.outPrinter(request, response, html.toString() + script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }

            Map<String, Object> map = new HashMap<String, Object>();

            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_summary, jjTools.getParameter(request, _summary));
            map.put(_category, jjTools.getParameter(request, _category));
            map.put(_date, jjTools.getParameter(request, _date));
            map.put(_titleFile1, jjTools.getParameter(request, _titleFile1));
            map.put(_titleFile2, jjTools.getParameter(request, _titleFile2));
            map.put(_titleFile3, jjTools.getParameter(request, _titleFile3));
            map.put(_attachmentfile1, jjTools.getParameter(request, _attachmentfile1));
            map.put(_attachmentfile2, jjTools.getParameter(request, _attachmentfile2));
            map.put(_attachmentfile3, jjTools.getParameter(request, _attachmentfile3));
            map.put(_file1, jjTools.getParameter(request, _file1));
            map.put(_file2, jjTools.getParameter(request, _file2));
            map.put(_file3, jjTools.getParameter(request, _file3));
            map.put(_htmlContent, jjTools.getParameter(request, _htmlContent));
            map.put(_signatory_user_1, jjTools.getParameter(request, _signatory_user_1));
            map.put(_signatory_user_2, jjTools.getParameter(request, _signatory_user_2));
            map.put(_signatory_user_3, jjTools.getParameter(request, _signatory_user_3));
            map.put(_signatory_user_4, jjTools.getParameter(request, _signatory_user_4));
            map.put(_signatory_user_5, jjTools.getParameter(request, _signatory_user_5));
            map.put(_signatory_user_6, jjTools.getParameter(request, _signatory_user_6));
            map.put(_signatory_user_7, jjTools.getParameter(request, _signatory_user_7));
            map.put(_signatory_user_8, jjTools.getParameter(request, _signatory_user_8));
            map.put(_signatory_user_9, jjTools.getParameter(request, _signatory_user_9));
            map.put(_signatory_user_10, jjTools.getParameter(request, _signatory_user_10));
            map.put(_signatory_user_11, jjTools.getParameter(request, _signatory_user_11));
            map.put(_signatory_user_12, jjTools.getParameter(request, _signatory_user_12));
            map.put(_signatory_user_13, jjTools.getParameter(request, _signatory_user_13));
            map.put(_signatory_user_14, jjTools.getParameter(request, _signatory_user_14));
            map.put(_signatory_user_15, jjTools.getParameter(request, _signatory_user_15));
            map.put(_signatory_user_16, jjTools.getParameter(request, _signatory_user_16));
            map.put(_signatory_user_17, jjTools.getParameter(request, _signatory_user_17));
            map.put(_signatory_user_18, jjTools.getParameter(request, _signatory_user_18));
            map.put(_signatory_user_19, jjTools.getParameter(request, _signatory_user_19));
            map.put(_signatory_user_20, jjTools.getParameter(request, _signatory_user_20));
            map.put(_signatory_title_1, jjTools.getParameter(request, _signatory_title_1));
            map.put(_signatory_title_2, jjTools.getParameter(request, _signatory_title_2));
            map.put(_signatory_title_3, jjTools.getParameter(request, _signatory_title_3));
            map.put(_signatory_title_4, jjTools.getParameter(request, _signatory_title_4));
            map.put(_signatory_title_5, jjTools.getParameter(request, _signatory_title_5));
            map.put(_signatory_title_6, jjTools.getParameter(request, _signatory_title_6));
            map.put(_signatory_title_7, jjTools.getParameter(request, _signatory_title_7));
            map.put(_signatory_title_8, jjTools.getParameter(request, _signatory_title_8));
            map.put(_signatory_title_9, jjTools.getParameter(request, _signatory_title_9));
            map.put(_signatory_title_10, jjTools.getParameter(request, _signatory_title_10));
            map.put(_signatory_title_11, jjTools.getParameter(request, _signatory_title_11));
            map.put(_signatory_title_12, jjTools.getParameter(request, _signatory_title_12));
            map.put(_signatory_title_13, jjTools.getParameter(request, _signatory_title_13));
            map.put(_signatory_title_14, jjTools.getParameter(request, _signatory_title_14));
            map.put(_signatory_title_15, jjTools.getParameter(request, _signatory_title_15));
            map.put(_signatory_title_16, jjTools.getParameter(request, _signatory_title_16));
            map.put(_signatory_title_17, jjTools.getParameter(request, _signatory_title_17));
            map.put(_signatory_title_18, jjTools.getParameter(request, _signatory_title_18));
            map.put(_signatory_title_19, jjTools.getParameter(request, _signatory_title_19));
            map.put(_signatory_title_20, jjTools.getParameter(request, _signatory_title_20));
            map.put(_signatory_comment_1, jjTools.getParameter(request, _signatory_comment_1));
            map.put(_signatory_comment_2, jjTools.getParameter(request, _signatory_comment_2));
            map.put(_signatory_comment_3, jjTools.getParameter(request, _signatory_comment_3));
            map.put(_signatory_comment_4, jjTools.getParameter(request, _signatory_comment_4));
            map.put(_signatory_comment_5, jjTools.getParameter(request, _signatory_comment_5));
            map.put(_signatory_comment_6, jjTools.getParameter(request, _signatory_comment_6));
            map.put(_signatory_comment_7, jjTools.getParameter(request, _signatory_comment_7));
            map.put(_signatory_comment_8, jjTools.getParameter(request, _signatory_comment_8));
            map.put(_signatory_comment_9, jjTools.getParameter(request, _signatory_comment_9));
            map.put(_signatory_comment_10, jjTools.getParameter(request, _signatory_comment_10));
            map.put(_signatory_comment_11, jjTools.getParameter(request, _signatory_comment_11));
            map.put(_signatory_comment_12, jjTools.getParameter(request, _signatory_comment_12));
            map.put(_signatory_comment_13, jjTools.getParameter(request, _signatory_comment_13));
            map.put(_signatory_comment_14, jjTools.getParameter(request, _signatory_comment_14));
            map.put(_signatory_comment_15, jjTools.getParameter(request, _signatory_comment_15));
            map.put(_signatory_comment_16, jjTools.getParameter(request, _signatory_comment_16));
            map.put(_signatory_comment_17, jjTools.getParameter(request, _signatory_comment_17));
            map.put(_signatory_comment_18, jjTools.getParameter(request, _signatory_comment_18));
            map.put(_signatory_comment_19, jjTools.getParameter(request, _signatory_comment_19));
            map.put(_signatory_comment_20, jjTools.getParameter(request, _signatory_comment_20));
            map.put(_signatory_role_1, jjTools.getParameter(request, _signatory_role_1));
            map.put(_signatory_role_2, jjTools.getParameter(request, _signatory_role_2));
            map.put(_signatory_role_3, jjTools.getParameter(request, _signatory_role_3));
            map.put(_signatory_role_4, jjTools.getParameter(request, _signatory_role_4));
            map.put(_signatory_role_5, jjTools.getParameter(request, _signatory_role_5));
            map.put(_signatory_role_6, jjTools.getParameter(request, _signatory_role_6));
            map.put(_signatory_role_7, jjTools.getParameter(request, _signatory_role_7));
            map.put(_signatory_role_8, jjTools.getParameter(request, _signatory_role_8));
            map.put(_signatory_role_9, jjTools.getParameter(request, _signatory_role_9));
            map.put(_signatory_role_10, jjTools.getParameter(request, _signatory_role_10));
            map.put(_signatory_role_11, jjTools.getParameter(request, _signatory_role_11));
            map.put(_signatory_role_12, jjTools.getParameter(request, _signatory_role_12));
            map.put(_signatory_role_13, jjTools.getParameter(request, _signatory_role_13));
            map.put(_signatory_role_14, jjTools.getParameter(request, _signatory_role_14));
            map.put(_signatory_role_15, jjTools.getParameter(request, _signatory_role_15));
            map.put(_signatory_role_16, jjTools.getParameter(request, _signatory_role_16));
            map.put(_signatory_role_17, jjTools.getParameter(request, _signatory_role_17));
            map.put(_signatory_role_18, jjTools.getParameter(request, _signatory_role_18));
            map.put(_signatory_role_19, jjTools.getParameter(request, _signatory_role_19));
            map.put(_signatory_role_20, jjTools.getParameter(request, _signatory_role_20));

            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }

            Server.outPrinter(request, response, Js.jjCreateDocumentary.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

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

            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            script.append(Js.setVal("#createDocumentary_" + _id, row.get(0).get(_id)));

            script.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            script.append(Js.setVal("#" + _titleFile1, row.get(0).get(_titleFile1)));
            script.append(Js.setVal("#" + _titleFile2, row.get(0).get(_titleFile2)));
            script.append(Js.setVal("#" + _titleFile3, row.get(0).get(_titleFile3)));
            script.append(Js.setAttr("#Downloadfile3", "href", "upload/" + row.get(0).get(_attachmentfile3)));
            script.append(Js.setAttr("#Downloadfile2", "href", "upload/" + row.get(0).get(_attachmentfile2)));
            script.append(Js.setAttr("#Downloadfile1", "href", "upload/" + row.get(0).get(_attachmentfile1)));

            script.append(Js.setVal("#createDocumentary_attachmentfile3", row.get(0).get(_attachmentfile3)));
            script.append(Js.setVal("#createDocumentary_attachmentfile2", row.get(0).get(_attachmentfile2)));
            script.append(Js.setVal("#createDocumentary_attachmentfile1", row.get(0).get(_attachmentfile1)));
//            script.append(Js.setVal("#createDocumentary_attachmentfile1", row.get(0).get(_attachmentfileTitle1)));
//            script.append(Js.setVal("#title1", row.get(0).get(_attachmentfileTitle1)));

            if (row.get(0).get(_attachmentfile1).equals("")) {
                script.append(Js.setAttr("#PicPreviewFile1", "src", "img/preview.jpg"));
//                
            } else {
                script.append(Js.setAttr("#PicPreviewFile1", "src", "upload/" + row.get(0).get(_attachmentfile1).toString() + ""));
                script.append(Js.show("#Downloadfile1"));
            }
            if (row.get(0).get(_attachmentfile2).equals("")) {
                script.append(Js.setAttr("#PicPreviewFile2", "src", "img/preview.jpg"));
                script.append(Js.hide("#Downloadfile2"));
            } else {
                script.append(Js.setAttr("#PicPreviewFile1", "src", "upload/" + row.get(0).get(_attachmentfile2).toString() + ""));
                script.append(Js.show("#Downloadfile2"));
            }
            if (row.get(0).get(_attachmentfile3).equals("")) {
                script.append(Js.setAttr("#PicPreviewFile3", "src", "img/preview.jpg"));
                script.append(Js.hide("#Downloadfile3"));
            } else {
                script.append(Js.setAttr("#PicPreviewFile3", "src", "upload/" + row.get(0).get(_attachmentfile3).toString() + ""));
                script.append(Js.show("#Downloadfile3"));
            }
            StringBuilder script2 = new StringBuilder();
            StringBuilder script3 = new StringBuilder();
            StringBuilder script4 = new StringBuilder();
            String html3 = "";
            String html4 = "";
            String temp = "";

///این قسمت برای نمایش امضا کنندگان نوشته شده
/////توسط شیران1
            for (int i = 1; i <= 20; i++) {
//             
                if (!row.get(0).get("createDocumentary_signatory_user_" + i).toString().isEmpty()) {//این ifاگر امضا کرده باشدو داخل امضا کننده خالی بود
                    List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName, _id + "=" + row.get(0).get("createDocumentary_signatory_user_" + i).toString()));///برای در اوردن نام وفامیلی امضا کننده
                    System.out.println(">>>>>>>>>>>>>>>>>>>" + i);
                    if ((row.get(0).get("createDocumentary_signatory_signature_" + i).equals("0") || row.get(0).get("createDocumentary_signatory_signature_" + i).equals("1"))) {///اگر امضا کننده 0یا 1 باشد و همچنین یوزر امضا کننده خالی باشد این if میشود
                        html3 += "<div class='row col-lg-12 ' id='row'>\n"
                                + "<div class=\"col-lg-3\">\n"
                                + "عنوان امضا کننده\n"
                                + "<input class='form-control'  id='signatory_title_" + i + "' name='createDocumentary_signatory_title_" + i + "' disabled='disabled' value='" + row.get(0).get("createDocumentary_signatory_title_" + i).toString() + "' />"
                                + "</div>\n"
                                + "<div class=\"col-lg-3\">\n"
                                + "فرد امضا کننده\n"
                                + "<input id='createDocumentary_signatory_user_" + (i) + "' name=id='createDocumentary_signatory_user_" + (i) + "'  disabled='disabled'  class='signerDiv form-control' value='" + UserRow.get(0).get(Access_User._name).toString() + " " + UserRow.get(0).get(Access_User._family).toString() + "' />"
                                + "</div>\n"
                                + "<div class=\"col-lg-3\">\n"
                                + "سمت امضا کننده\n"
                                + "<input id='signatory_role_" + i + "' name='createDocumentary_signatory_role_" + i + "' class='form-control' disabled='disabled' value='" + row.get(0).get("createDocumentary_signatory_role_" + i).toString() + "'  />"
                                + "</div>";

                        if (row.get(0).get("createDocumentary_signatory_signature_" + i).equals("0")) {
                            html3 += "<div class='col-lg-3'><img src='imgfeyz/remove.png' style='height:34px;margin-top: 21px; '/></div>";
                        }
                        if (row.get(0).get("createDocumentary_signatory_signature_" + i).equals("1")) {
                            html3 += "<div class='col-lg-3'><img src='imgfeyz/tick.png' style='height:30px;margin-top: 22px;'/></div>";
                        }
                        html3 += "</div>";
//                       
                    } else {
                        html3 += "<div class='row col-lg-12 ' id='row'>\n"
                                + "<div class=\"col-lg-3\">\n"
                                + "عنوان امضا کننده\n"
                                + "<input class='form-control c'  id='signatory_title_" + i + "' "
                                + "name='createDocumentary_signatory_title_" + i + "' "
                                + "value='" + row.get(0).get("createDocumentary_signatory_title_" + i).toString() + "' />"
                                + "</div>\n"
                                + "<div class=\"col-lg-3\">\n"
                                + "فرد امضا کننده\n"
                                + "<select id='createDocumentary_signatory_user_" + (i) + "' "
                                + "name='createDocumentary_signatory_user_" + (i) + "' class='signerDiv form-control' > "
                                + "<option value='" + UserRow.get(0).get(_id) + "' >"
                                + UserRow.get(0).get(Access_User._name).toString() + " " + UserRow.get(0).get(Access_User._family).toString()
                                + "</option>"
                                + "</select>"
                                + "</div>\n"
                                + "<div class=\"col-lg-3\">\n"
                                + "سمت امضا کننده\n"
                                + "<input id='signatory_role_" + i + "' name='createDocumentary_signatory_role_" + i + "' class='form-control'  value='" + row.get(0).get("createDocumentary_signatory_role_" + i).toString() + "'  />"
                                + "</div>"
                                + "<div class=\"col-lg-3\">"
                                + "<button class=\"btn btn-outline-danger btn-block mg-t-20 mg-b-20  buttonRemove\">حذف</button>\n"
                                + "<button class=\"btn btn-outline btn-block mg-t-20 mg-b-20 \" id='payam' onclick='hmisMessenger.sendMesseageToSignatory(" + UserRow.get(0).get(Access_User._id) + "," + row.get(0).get(_id) +")'>ارسال پیام</button>\n"
                                + "</div>"
                                + "</div>";

                    }

//                   
                }
            }
            script4.append(Js.setHtml("#signatorys", html3));
            script.append(Js.setVal("#" + _date, row.get(0).get(_date).toString()));
            script.append(Js.setVal("#" + _summary, row.get(0).get(_summary).toString()));
            script.append(Js.setVal("#" + _category, row.get(0).get(_category).toString()));

            script.append(Js.setValSummerNote("#createDocumentary_htmlContent", row.get(0).get(_htmlContent)));

            boolean flag = true;
            //ویژگی : اگر یکی از امضا کنندگان مستند را رد بکند دیگر امکان یرایش مستند وجود ندارد ولی امکان حذف وجود دارد
            for (int j = 1; j <= 20; j++) {
                if (row.get(0).get("createDocumentary_signatory_signature_" + j).equals("0")||row.get(0).get("createDocumentary_signatory_signature_" + j).equals("1")) {
                    flag = false;
                }

            }
            String htmlBottons = "";
            if (flag == false) {
                script1.append(Js.setHtml("#CreateDocumentary_button", ""));
            } else {
                boolean accEdit = Access_User.hasAccess(request, db, rul_edt);

                if (accEdit) {
                    htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjCreateDocumentary.edit() + "' id='edit_CreateDocumentary'>" + lbl_edit + "</button></div>";

                }

                script1.append(Js.setHtml("#CreateDocumentary_button", htmlBottons));
            }

            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjCreateDocumentary.delete(id) + "' id='delete_CreateDocumentary'>" + lbl_delete + "</button></div>";
            }
            script1.append(Js.setHtml("#CreateDocumentary_button", htmlBottons));

            Server.outPrinter(request, response, html.toString() + script + script2 + script3 + script4 + script1);
            return "";
//
//           
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

//    *
//    این تابع برای کپی کردن فایل یعنی اگر بخواهیم صفحه ای که داخلش هستیم را کپی کنیم ازاین تابع استفاده می کنیم
//*/

    public static String copyDocumentary(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        StringBuilder html = new StringBuilder();
        StringBuilder script = new StringBuilder();
        try {

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);

            if (accIns) {
                script.append(Js.setHtml("#CreateDocumentary_button", "<div class='col-lg-6'><input type='button' id='insert_CreateDocumentary_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success active btn-block mg-b-10'></div>"));
                script.append(Js.click("#insert_CreateDocumentary_new", Js.jjCreateDocumentary.insert()));
            }
            Server.outPrinter(request, response, html.toString() + script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
//            if (!hasAccess.equals("")) {
//                Server.outPrinter(request, response, hasAccess);
//                return "";
//            }
            String id = jjTools.getParameter(request, _id);
//           
            Map<String, Object> map = new HashMap();
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_date, jjTools.getParameter(request, _date));
            map.put(_category, jjTools.getParameter(request, _category));
            map.put(_summary, jjTools.getParameter(request, _summary));
            map.put(_titleFile1, jjTools.getParameter(request, _titleFile1));
            map.put(_titleFile2, jjTools.getParameter(request, _titleFile2));
            map.put(_titleFile3, jjTools.getParameter(request, _titleFile3));
            map.put(_attachmentfile1, jjTools.getParameter(request, _attachmentfile1));
            map.put(_attachmentfile2, jjTools.getParameter(request, _attachmentfile2));
            map.put(_attachmentfile3, jjTools.getParameter(request, _attachmentfile3));
            map.put(_htmlContent, jjTools.getParameter(request, _htmlContent));
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
////////////////////اگرuserخالی بود
///////////////هیچ کاری نکند یعنی هرچی داخل دیتا بیس هست را نشان بدهد در غیر این صورت 
/////////////داخلش map می شود
            for (int i = 1; i <= 20; i++) {

                if (row.get(0).get("createDocumentary_signatory_signature_" + i).equals("0") || row.get(0).get("createDocumentary_signatory_signature_" + i).equals("1")) {
                    ;//نام امضا کننده با وضعیت امضا غیر قابل ویرایش
                } else {
                    //مشخصاتی که قبلا در محل امضا کننده هست را برای ویرایش می گذاریم
                    map.put("createDocumentary_signatory_user_" + i, jjTools.getParameter(request, "createDocumentary_signatory_user_" + i));
                    map.put("createDocumentary_signatory_title_" + i, jjTools.getParameter(request, "createDocumentary_signatory_title_" + i));
                    map.put("createDocumentary_signatory_role_" + i, jjTools.getParameter(request, "createDocumentary_signatory_role_" + i));
                }
            }

//            if ((!row.get(0).get(_signatory_user_2).equals(""))) {
//
//            } else {
//                if((row.get(0).get(_signatory_signature_2).equals("0")||row.get(0).get(_signatory_signature_2).equals("1"))){
//                    //نام تمضا کننده با وضعیت امضا غیر قابل ویرایش
//                }else{
//                map.put(_signatory_user_2, jjTools.getParameter(request, _signatory_user_2));
//                map.put(_signatory_title_2, jjTools.getParameter(request, _signatory_title_2));
//                map.put(_signatory_role_2, jjTools.getParameter(request, _signatory_role_2));
//            }
//            }
//            if ((!row.get(0).get(_signatory_user_3).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_3, jjTools.getParameter(request, _signatory_user_3));
//                map.put(_signatory_title_3, jjTools.getParameter(request, _signatory_title_3));
//                map.put(_signatory_role_3, jjTools.getParameter(request, _signatory_role_3));
//            }
//            if ((!row.get(0).get(_signatory_user_4).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_4, jjTools.getParameter(request, _signatory_user_4));
//                map.put(_signatory_title_4, jjTools.getParameter(request, _signatory_title_4));
//                map.put(_signatory_role_4, jjTools.getParameter(request, _signatory_role_4));
//            }
//            if ((!row.get(0).get(_signatory_user_5).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_5, jjTools.getParameter(request, _signatory_user_5));
//                map.put(_signatory_title_5, jjTools.getParameter(request, _signatory_title_5));
//                map.put(_signatory_role_5, jjTools.getParameter(request, _signatory_role_5));
//            }
//            if ((!row.get(0).get(_signatory_user_6).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_6, jjTools.getParameter(request, _signatory_user_6));
//                map.put(_signatory_title_6, jjTools.getParameter(request, _signatory_title_6));
//                map.put(_signatory_role_6, jjTools.getParameter(request, _signatory_role_6));
//            }
//            if ((!row.get(0).get(_signatory_user_7).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_7, jjTools.getParameter(request, _signatory_user_7));
//                map.put(_signatory_title_7, jjTools.getParameter(request, _signatory_title_7));
//                map.put(_signatory_role_7, jjTools.getParameter(request, _signatory_role_7));
//            }
//            if ((!row.get(0).get(_signatory_user_8).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_8, jjTools.getParameter(request, _signatory_user_8));
//                map.put(_signatory_title_8, jjTools.getParameter(request, _signatory_title_8));
//                map.put(_signatory_role_8, jjTools.getParameter(request, _signatory_role_8));
//            }
//            if ((!row.get(0).get(_signatory_user_9).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_9, jjTools.getParameter(request, _signatory_user_9));
//                map.put(_signatory_title_9, jjTools.getParameter(request, _signatory_title_9));
//                map.put(_signatory_role_9, jjTools.getParameter(request, _signatory_role_9));
//            }
//            if ((!row.get(0).get(_signatory_user_10).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_10, jjTools.getParameter(request, _signatory_user_10));
//                map.put(_signatory_title_10, jjTools.getParameter(request, _signatory_title_10));
//                map.put(_signatory_role_10, jjTools.getParameter(request, _signatory_role_10));
//            }
//            if ((!row.get(0).get(_signatory_user_11).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_11, jjTools.getParameter(request, _signatory_user_11));
//                map.put(_signatory_title_11, jjTools.getParameter(request, _signatory_title_11));
//                map.put(_signatory_role_11, jjTools.getParameter(request, _signatory_role_11));
//            }
//            if ((!row.get(0).get(_signatory_user_12).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_12, jjTools.getParameter(request, _signatory_user_12));
//                map.put(_signatory_title_12, jjTools.getParameter(request, _signatory_title_12));
//                map.put(_signatory_role_12, jjTools.getParameter(request, _signatory_role_12));
//            }
//            if ((!row.get(0).get(_signatory_user_13).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_13, jjTools.getParameter(request, _signatory_user_13));
//                map.put(_signatory_title_13, jjTools.getParameter(request, _signatory_title_13));
//                map.put(_signatory_role_13, jjTools.getParameter(request, _signatory_role_13));
//            }
//            if ((!row.get(0).get(_signatory_user_14).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_14, jjTools.getParameter(request, _signatory_user_14));
//                map.put(_signatory_title_14, jjTools.getParameter(request, _signatory_title_14));
//                map.put(_signatory_role_14, jjTools.getParameter(request, _signatory_role_14));
//            }
//            if ((!row.get(0).get(_signatory_user_15).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_15, jjTools.getParameter(request, _signatory_user_15));
//                map.put(_signatory_title_15, jjTools.getParameter(request, _signatory_title_15));
//                map.put(_signatory_role_15, jjTools.getParameter(request, _signatory_role_15));
//            }
//            if ((!row.get(0).get(_signatory_user_16).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_16, jjTools.getParameter(request, _signatory_user_16));
//                map.put(_signatory_title_16, jjTools.getParameter(request, _signatory_title_16));
//                map.put(_signatory_role_16, jjTools.getParameter(request, _signatory_role_16));
//            }
//            if ((!row.get(0).get(_signatory_user_17).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_17, jjTools.getParameter(request, _signatory_user_17));
//                map.put(_signatory_title_17, jjTools.getParameter(request, _signatory_title_17));
//                map.put(_signatory_role_17, jjTools.getParameter(request, _signatory_role_17));
//            }
//            if ((!row.get(0).get(_signatory_user_18).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_18, jjTools.getParameter(request, _signatory_user_18));
//                map.put(_signatory_title_18, jjTools.getParameter(request, _signatory_title_18));
//                map.put(_signatory_role_18, jjTools.getParameter(request, _signatory_role_18));
//            }
//            if ((!row.get(0).get(_signatory_user_19).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_19, jjTools.getParameter(request, _signatory_user_19));
//                map.put(_signatory_title_19, jjTools.getParameter(request, _signatory_title_19));
//                map.put(_signatory_role_19, jjTools.getParameter(request, _signatory_role_19));
//            }
//            if ((!row.get(0).get(_signatory_user_20).equals(""))) {
//
//            } else {
//                map.put(_signatory_user_20, jjTools.getParameter(request, _signatory_user_20));
//                map.put(_signatory_title_20, jjTools.getParameter(request, _signatory_title_20));
//                map.put(_signatory_role_20, jjTools.getParameter(request, _signatory_role_20));
//            }
//          
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.dialog(errorMessageId));
                return "";
            }
            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            Server.outPrinter(request, response, Js.jjDepartment.refresh());
            return "";
//            Server.outPrinter(request, response,"";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String saveSign(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {

            String id = jjTools.getParameter(request, "id");
//           

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(CreateDocumentary.tableName, _id + "=" + id));
            if (row.isEmpty()) {
                return "چنین رکوردی یافت نشد";
            }
            Map<String, Object> map = new HashMap();
            String errorMessage = "";
            boolean flag = true;
            for (int i = 1; i <= 20; i++) {

                if (!row.get(0).get("createDocumentary_signatory_user_" + i).toString().isEmpty()) {
                    if(row.get(0).get("createDocumentary_signatory_signature_" + i).toString().equals("0")){
                        flag=false;
                    }
                    String userid = String.valueOf(jjTools.getSeassionUserId(request));
                    if (userid.equals(row.get(0).get("createDocumentary_signatory_user_" + i))) {
                        errorMessage = "";
                        if ("0".equals(row.get(0).get("createDocumentary_signatory_signature_" + i)) || "1".equals(row.get(0).get("createDocumentary_signatory_signature_" + i))) {

                            errorMessage = "شما قبلا این مستند را ثبت کرده اید و اکنون مجاز به تغییر رای خود نیستید.";
                        } else {
                            map.put("createDocumentary_signatory_comment_" + i, jjTools.getParameter(request, "createDocumentary_signatory_comment_" + i));
                            map.put("createDocumentary_signatory_signature_" + i, jjTools.getParameter(request, "createDocumentary_signatory_signature_" + i));
                            errorMessage = "";
                            i = 21;//برای خروج از حلقه
                        }
                    } else {
                        errorMessage = "شما کاربر مجاز برای تایید یا رد این مستند نیستید.";
                    }
                }
            }
            if(!flag){
                 errorMessage = "این سند توسط یکی از امضا کنندگان رد و باطل شده است";
            }
            if (!errorMessage.isEmpty()) {
                Server.outPrinter(request, response, Js.modal(errorMessage,"شما اجازه این عملیات را ندارید"));
                return "";
            }
            System.out.println("id=" + id);
            if (!db.update(tableName, map, _id + "=" + id)) {
                errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }
            StringBuilder script = new StringBuilder();
            StringBuilder script1 = new StringBuilder();

            for (int j = 1; j < 20; j++) {

                if (!row.get(0).get("createDocumentary_signatory_user_" + j).toString().equals("")) {
                    String userid = String.valueOf(jjTools.getSeassionUserId(request));
                    if (userid.equals(row.get(0).get("createDocumentary_signatory_user_" + j))) {
                        if (jjTools.getParameter(request, "createDocumentary_signatory_signature_" + j).equals("0")) {
                            script.append("alert('مستند مورد نظر  رد  و باطل شد')");
                            Server.outPrinter(request, response, script);
                        } else if (jjTools.getParameter(request, "createDocumentary_signatory_signature_" + j).equals("1")) {

                            script1.append("alert('مستند مورد نظر شما تایید شد')");
                            Server.outPrinter(request, response, script1);

                        }
                    }
                }
            }
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

            Server.outPrinter(request, response, Js.jjCreateDocumentary.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

}
