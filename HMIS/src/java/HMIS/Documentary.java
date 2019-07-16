/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import javax.swing.table.DefaultTableModel;
import cms.access.Access_User;
import static cms.access.Access_User._attachFile;
import cms.tools.Js;
import cms.tools.Server;
import cms.tools.UploadServlet;
import static cms.tools.UploadServlet.status_deleted;
import cms.tools.jjTools;
import cms.tools.jjValidation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jj.jjCalendar_IR;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
import jj.jjNumber;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author shiran1
 */
public class Documentary {

    public static String tableName = "hmis_documentary";
    public static String _id = "id";
    public static String _title = "documentary_title";//عنوان فایل
    public static String _attachFileTitle = "documentary_attachFileTitle";//
    public static String _titleFile = "documentary_titleFile";//
    public static String _gaugeId = "documentary_gaugeId";//عنوان فایل
    public static String _responsibleLoading = "documentary_responsibleLoading";//بار گداری
    public static String _nameResponsibleLoading = "documentary_nameResponsibleLoading";//نام بارگداری کننده
    public static String _LoadingPeriod = "documentary_LoadingPeriod";///دوره بارگذاری
    public static String _dateCreation = "documentary_dateCreation";///تاریخ ایجاد بهصورت سیستمی
    public static String _status = "documentary_status";///وضعیت بارگذاری
    public static String _logStatus = "documentary_logStatus";///وضعیت بارگذاری
    public static String _getUploaded = "documentary_getUploaded";///دریافت بارگذاری
    public static String _attachFileDocumentary = "documentary_attachFileDocumentary";///دریافت بارگذاری
    public static String status_Uploaded = "بارگذاری شده";
    public static String status_noUploaded = "بارگذاری نشده";
    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";

    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {

            StringBuilder html = new StringBuilder();
            StringBuilder html3 = new StringBuilder();

            DefaultTableModel dtm = db.Select(Documentary.tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>بار گذاری سنجه ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
            );

            html.append("<table class='table display responsive nowrap' id='refreshDocumentary' dir='rtl'><thead>");
            html.append("<th class='c' width='5%'>کد</th>");
            html.append("<th class='c' width='30%'>عنوان فایل</th>");
            html.append("<th class='c' width='20%'>مسئول بارگذاری</th>");
            html.append("<th class='c' width='20%'>نام بارگذاری کننده</th>");
            html.append("<th class='c' width='20%'>دوره بارگذاری </th>");
            html.append("<th class='c' width='20%'>تاریخ ایجاد(سیستمی)</th>");
            html.append("<th class='c' width='20%'>وضعیت بارگذاری</th>");
            html.append("<th class='c' width='20%'>دریافت بارگذاری</th>");

            html.append("<th class='c' width='5%'>ویرایش</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {

                html.append("<tr  onclick='hmisDocumentary.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
                html.append("<td class='c' >" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_title).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_responsibleLoading).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_nameResponsibleLoading).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_LoadingPeriod).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_dateCreation).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_status).toString()) + "</td>");
                html.append("<td class='c' >" + (row.get(i).get(_getUploaded).toString()) + "</td>");
//          

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
                panel = "swDocumentaryTbl";
            }
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            html2 += Js.table("#refreshDocumentary", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست  سنجه ها");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        StringBuilder html = new StringBuilder();
        StringBuilder script = new StringBuilder();

        try {

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                script.append(Js.setHtml("#Documentary_button", "<div class='col-lg-6'><input type='button' id='insert_Documentary_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success active btn-block mg-b-10'></div>"));
                script.append(Js.click("#insert_Documentary_new", Js.jjDocumentary.insert()));
            } else {
                script.append(Js.setHtml("#Documentary_button", ""));
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

            map.put(_LoadingPeriod, jjTools.getParameter(request, _LoadingPeriod));
            map.put(_dateCreation, jjTools.getParameter(request, _dateCreation));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_attachFileTitle, jjTools.getParameter(request, _attachFileTitle));
            map.put(_getUploaded, jjTools.getParameter(request, _getUploaded));
            map.put(_nameResponsibleLoading, jjTools.getParameter(request, _nameResponsibleLoading));
            map.put(_responsibleLoading, jjTools.getParameter(request, _responsibleLoading));
            map.put(_status, jjTools.getParameter(request, _status));
            map.put(_titleFile, jjTools.getParameter(request, _titleFile));

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
     * shiran1
     *
     * @param id
     */
    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
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
            StringBuilder script = new StringBuilder();
            String script1 = "";
            StringBuilder html = new StringBuilder();
            StringBuilder html1 = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            ////////////////////////////////
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Documentary.tableName, _id + "=" + id));

            script.append(Js.setVal("#documentary_LoadingPeriod", row.get(0).get(_LoadingPeriod)));
            script.append(Js.setVal("#documentary_" + _id, row.get(0).get(_id)));
            script.append(Js.setVal("#documentary_getUploaded", row.get(0).get(_getUploaded)));
            html.append(Js.setVal("#documentary_attachFileDocumentary", row.get(0).get(_attachFileDocumentary)));
            html.append(Js.setVal("#documentary_attachFileTitle", row.get(0).get(_attachFileTitle)));
            String attachFiles = row.get(0).get(_attachFileDocumentary).toString();

            String attachFileTitles = row.get(0).get(_attachFileTitle).toString();
          

            String[] attachFilesArray = attachFiles.split("%23A%23");
            String[] attachFileTitlesArray = attachFileTitles .split("%23A%23");

           for (int l = 0; l < attachFilesArray.length&&l < attachFileTitlesArray.length; l++ ) {
                List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + attachFilesArray[l] + "'"));
                List<Map<String, Object>> titleRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._title + "='" + attachFileTitlesArray[l] + "'"));
                
                if (!fileRow.isEmpty()) {
                    String idUpload = fileRow.get(0).get(UploadServlet._id).toString();
                    String titleUpload = fileRow.get(0).get(UploadServlet._title).toString();
                     String extension2 = attachFilesArray[l].substring(attachFilesArray[l].lastIndexOf(".") + 1, attachFilesArray[l].length());
                     if (extension2.toLowerCase().equals("jpg") 
                                || extension2.toLowerCase().equals("png") 
                                || extension2.toLowerCase().equals("gif")
                                || extension2.toLowerCase().equals("svg")){
                    if (titleUpload.equals("")) {
                        html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button class='col-lg-1 form-control'  style='background-color: #e16262;color: white;float:left' onclick='hmisDocumentary.m_remove(" + idUpload + "," + id + ")'>" + "حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                    } else {
                        html2.append(  "<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" +"<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" +"<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisDocumentary.m_remove(" + idUpload + "," + id + ")'>حذف"+ "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                     }
                    
                }else{
                      html2.append("<input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" +"<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" +"<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisDocumentary.m_remove(" + idUpload + "," + id + ")'>حذف"+ "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");   
                     }
                }
            }

            script1 += Js.setHtml("#inputAfterSelectGauge", html2);
            if (row.get(0).get(_attachFileDocumentary).toString().equals("")) {
                changeStatus(request, response, db, id, status_noUploaded);

            }
            List<Map<String, Object>> rowGauge = jjDatabase.separateRow(db.Select(ManagementGauges.tableName, _id + "=" + row.get(0).get(Documentary._gaugeId)));
            /////در اوردن مشخصات سنجه

            script.append(Js.setHtml("#standard", rowGauge.get(0).get(ManagementGauges._standard)));
            script.append(Js.setHtml("#gauges", rowGauge.get(0).get(ManagementGauges._gauge)));
            script.append(Js.setHtml("#step", rowGauge.get(0).get(ManagementGauges._step)));
            script.append(Js.setHtml("#axis", rowGauge.get(0).get(ManagementGauges._axis)));
            script.append(Js.setHtml("#underAxis", rowGauge.get(0).get(ManagementGauges._underTheAxis)));
            script.append(Js.setValSummerNote("#comment", rowGauge.get(0).get(ManagementGauges._comment)));
            ////////////////////////
            DefaultTableModel dtm = db.Select(Documentary.tableName);
            List<Map<String, Object>> rowDocumentary = jjDatabase.separateRow(dtm);
//////////////سنجه هایی که قبلا ایجاد شده به صورت جدول نمایش داده می شود

            html1.append("<table class='table display responsive nowrap' id='refreshDocumentaryloading' dir='rtl'><thead>");
            html1.append("<th class='c' width='5%'>کد</th>");
            html1.append("<th class='c' width='30%'>عنوان فایل</th>");
            html1.append("<th class='c' width='20%'>مسئول بارگذاری</th>");
            html1.append("<th class='c' width='20%'>نام بارگذاری کننده</th>");
            html1.append("<th class='c' width='20%'>دوره بارگذاری </th>");
            html1.append("<th class='c' width='20%'>تاریخ ایجاد(سیستمی)</th>");
            html1.append("<th class='c' width='20%'>وضعیت بارگذاری</th>");
            html1.append("<th class='c' width='20%'>دریافت مستند</th>");

            html1.append("</thead><tbody>");
//            for (int i = 0; i < row.size(); i++) {

            html1.append("<tr   class='mousePointer' >");
            html1.append("<td class='c' >" + (rowDocumentary.get(0).get(_id).toString()) + "</td>");
            html1.append("<td class='c' >" + (rowDocumentary.get(0).get(_title).toString()) + "</td>");
            html1.append("<td class='c' >" + (rowDocumentary.get(0).get(_responsibleLoading).toString()) + "</td>");
            html1.append("<td class='c' >" + (rowDocumentary.get(0).get(_nameResponsibleLoading).toString()) + "</td>");
            html1.append("<td class='c' >" + (rowDocumentary.get(0).get(_LoadingPeriod).toString()) + "</td>");
            html1.append("<td class='c' >" + (rowDocumentary.get(0).get(_dateCreation).toString()) + "</td>");

            html1.append("<td class='c' >" + (rowDocumentary.get(0).get(_status).toString()) + "</td>");
            String attachFilesDocumentary = rowDocumentary.get(0).get(_attachFileDocumentary).toString();

            String[] attachFileDocumentarysArray = attachFilesDocumentary.split("%23A%23");
            html1.append("<td class='c' >");
            for (int l = 0; l < attachFileDocumentarysArray.length; l++) {
                List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + attachFilesArray[l] + "'"));
                if (!fileRow.isEmpty()) {
                    String idUpload = fileRow.get(0).get(UploadServlet._id).toString();

                    html1.append("<a href=upload/" + attachFileDocumentarysArray[l] + ">a</a>");

                }
            }
            html1.append("</td >");

//          
//                html1.append("<td style='text-align: center;color:red;font-size: 26px;' class='icon ion-ios-gear-outline'><a src='img/l.png' style='cursor: pointer;height:30px'  onclick='hmisManagementGauges.m_select(" + rowDocumentary.get(0).get(_id) + ");' ></a></td>");
            html1.append("</tr>");
//            }
            html1.append("</tbody></table>");
            html1.append("</div></div>");

            String script3 = "$('#savabeghDocumentary').html(\"" + html1.toString() + "\");\n";
            script3 += Js.table("#refreshDocumentaryloading", "400", 0, "", "سوابق سنجه ها");

            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);

            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjDocumentary.edit() + "' id='edit_Documentary'>" + lbl_edit + "</button></div>";
//               
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjDocumentary.delete(id) + "' id='delete_Documentary'>" + lbl_delete + "</button></div>";
            }
            script.append(Js.setHtml("#Documentary_button", htmlBottons));

            Server.outPrinter(request, response, html.toString() + script + script1 + script3);
            return "";

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }
    ///////////////////این تابع برای پاک کردن فایل های پیوست
    ////////////////////توسط شیران1
    //////////بدون پاک کردن از دیتا بیس

    public static String removeFile(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {

            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            String idUpload = jjTools.getParameter(request, "upload_id");///
            String idDocumentary = jjTools.getParameter(request, "documentary_id");

            List<Map<String, Object>> rowDocumentary = jjDatabase.separateRow(db.Select(Documentary.tableName, _id + "=" + idDocumentary));///برای در اوردن attachfile
            List<Map<String, Object>> rowupload = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._id + "=" + idUpload));////برای دراوردن اسم فایل
            String filename = rowupload.get(0).get(UploadServlet._file_name).toString() + "%23A%23";
            String title = rowupload.get(0).get(UploadServlet._title).toString() + "%23A%23";
            String attacheFiles = rowDocumentary.get(0).get(Documentary._attachFileDocumentary).toString();
            String attacheFilesTitle = rowDocumentary.get(0).get(Documentary._attachFileTitle).toString();
            System.out.println(filename);
            System.out.println("____________________________________");
            System.out.println(attacheFiles);
            attacheFiles = attacheFiles.replace(filename, "");
            attacheFilesTitle = attacheFilesTitle.replace(title, "");
            System.out.println(attacheFiles);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_attachFileDocumentary, attacheFiles);
            map.put(_attachFileTitle, attacheFilesTitle);
            System.out.println("____________________________________");

            db.update(tableName, map, _id + "=" + idDocumentary);
            changeStatus(request, response, db, idUpload, status_deleted + " " + jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY"));
//            if (!db.delete(UploadServlet.tableName, UploadServlet._id + "=" + idUpload)) {
//                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
//                if (jjTools.isLangEn(request)) {
//                    errorMessage = "Delete Fail;";
//                }
//                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
//                return "";
//
//            }
//            String error = "فایل مورد نظر حذف شد";
//            Server.outPrinter(request, response, Js.modal(error, "پیام سامانه"));
            return "";
//           

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }

    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";

            }
            String id = jjTools.getParameter(request, _id);
//           
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_LoadingPeriod, jjTools.getParameter(request, _LoadingPeriod));
            map.put(_titleFile, jjTools.getParameter(request, _titleFile));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_attachFileTitle, jjTools.getParameter(request, _attachFileTitle));
            map.put(_getUploaded, jjTools.getParameter(request, _getUploaded));
            map.put(_attachFileDocumentary, jjTools.getParameter(request, _attachFileDocumentary));
            if (!jjTools.getParameter(request, _attachFileDocumentary).equals("")) {
                changeStatus(request, response, db, id, status_Uploaded);
                if (!db.update(tableName, map, _id + "=" + id)) {
                    String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                    return "";

                }
            } else {
                String errorMessage1 = "لطفا فایلی را باگذاری کنید تا عملیات ویرایش انجام گیرد.";
                Server.outPrinter(request, response, Js.modal(errorMessage1, "پیام سامانه"));

            }
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }
//            return Js.jjDepartment.refresh();
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";

        }
    }

    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            Content.catchProductTitle = null;
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";

            }
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";

            }

            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";

            }
            Server.outPrinter(request, response, Js.jjMessenger.refresh());
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";

        }

    }

    public static String changeStatus(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, String id, String newSatus) throws Exception {
        try {
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                 Server.outPrinter(request, response, Js.dialog(errorMessageId));
            return "";
           
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
}
