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
 * @author shohreh.shiran Date 1397.12.18 Session:صورت جلسه و دعوتنامه
 */
public class Approved {

    public static String tableName = "hmis_approved";
    public static String _id = "id";
    public static String _commettesId = "approved_commettesId";//ای دی کمیته
    public static String _sessionsId = "approved_sessionsId";//ایدی جلسه
    public static String _offererId = "approved_offererId";//ایدی شخص پیشنهاد کننده
    public static String _title = "approved_title";//عنوان مصوبه
    public static String _startDate = "approved_startDate";//تاریخ شروع 
    public static String _endDate = "approved_endDate";//تاریخ پایان
    public static String _trackerId = "approved_trackerId";//مسئول پیگیری
    public static String _executorRoleId = "approved_executorRoleId";//مسئول اجراسمت
    public static String _executorUserId = "approved_executorUserId";//مسئول اجرا
    public static String _status = "approved_status";//وضعیت
    public static String _statusLog = "approved_statusLog";//روند وضعیت
    public static String _description = "approved_description";//توضیحات دبیر کمیته
    public static String _descriptionExecutor = "approved_descriptionExecutor";//توضیحات مسئولین اجرا
    public static String _descriptionTracker = "approved_descriptionTracker";//توضیحات مسئول پیگیری
    public static String _file = "approved_file";//مستندات از طرف دبیر کمیته
    public static String _filesTracker = "approved_filesTracker";//مستندات مسئول اجرا یا مسئول پیگیری
    public static String _filesExecutor = "approved_filesExecutor";//مستندات مسئول اجرا یا مسئول پیگیری
//    public static String _fileOfResponsible = "approved_fileOfResponsible";//مستندات مسئول اجرا یا مسئول پیگیری

    public static int rul_rfsAll = 0;
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
    public static String status_offer = "پیشنهاد";
    public static String status_reject = "رد پیشنهاد";
    public static String status_done = "انجام شده";
    public static String status_initialRegistration = "ثبت اولیه";
//    public static String status_finished = "خاتمه یافته";

    /**
     * نمایش مصوبه های که با مربوط به مسئول پیگیری است یا مربوط به مسئولین اجرا
     * است
     *
     * @param request
     * @param response
     * @param db
     * @param isFromClient
     * @return
     * @throws Exception
     */
    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isFromClient) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
//            boolean accRefAll = Access_User.hasAccess(request, db, rul_rfsAll);
//            boolean accRef = Access_User.hasAccess(request, db, rul_rfs);
//////////////////////////////////////////////////////////////////
            DefaultTableModel dtm;
            StringBuilder html = new StringBuilder();
            String roles = jjTools.getSeassionUserRole(request);
            if (!roles.equals("")) {
                String[] role = roles.split(",");
                String condition1 = "";
                String condition2 = "";
                for (int i = 0; i < role.length; i++) {
                    System.out.println("role" + role[i]);
                    condition1 += " approved_executorRoleId =" + role[i] + " OR";
                    condition2 += " approved_trackerId =" + role[i] + " OR";
                }

                
                dtm = db.otherSelect("SELECT hmis_approved.id,sessions_status\n"
                        + ",approved_title,r1.role_title As t1,r2.role_title t2"
                        + ",u1.user_name,u1.user_family,u2.user_name,u2.user_family,\n"
                        + "approved_status,approved_endDate,approved_startDate,approved_executorRoleId,approved_executorUserId"
                        + " FROM hmis_approved\n"
                        + " LEFT JOIN hmis_sessions ON approved_sessionsId=hmis_sessions.id\n"
                        + " LEFT JOIN hmis_role r1 ON approved_executorRoleId=r1.id\n"
                        + " LEFT JOIN hmis_role r2 ON approved_trackerId=r2.id\n"
                        + "  LEFT JOIN access_user u1 ON r1.role_user_id=u1.id "
                        + " LEFT JOIN access_user u2 ON r2.role_user_id=u2.id"
                        + " WHERE sessions_status='" + Sessions.status_communicated + "' "
                        + " AND"
                        + " approved_status != '" + status_initialRegistration + "'"
                        + " AND"
                        + " approved_status != '" + status_offer + "'"
                        + " AND "
                        + "approved_status != '" + status_reject + "'"
                        + " AND (approved_executorUserId=" + jjTools.getSeassionUserId(request) + " OR " + condition1.substring(0, condition1.length() - 2) + " OR " + condition2.substring(0, condition2.length() - 2) + ")");
            } else {

                dtm = db.otherSelect("SELECT hmis_approved.id,sessions_status\n"
                        + ",approved_title,r1.role_title As t1,r2.role_title t2"
                        + ",u1.user_name,u1.user_family,u2.user_name,u2.user_family,\n"
                        + "approved_status,approved_endDate,approved_startDate,approved_executorRoleId,approved_executorUserId"
                        + " FROM hmis_approved\n"
                        + " LEFT JOIN hmis_sessions ON approved_sessionsId=hmis_sessions.id\n"
                        + " LEFT JOIN hmis_role r1 ON approved_executorRoleId=r1.id\n"
                        + " LEFT JOIN hmis_role r2 ON approved_trackerId=r2.id\n"
                        + "  LEFT JOIN access_user u1 ON r1.role_user_id=u1.id "
                        + " LEFT JOIN access_user u2 ON r2.role_user_id=u2.id"
                        + " WHERE sessions_status='" + Sessions.status_communicated + "' AND approved_status!='" + status_offer + "' AND approved_status!='" + status_reject + "' "
                        + " AND approved_executorUserId=" + jjTools.getSeassionUserId(request));
            }
//////////////////////////////////////////////////////////////////
            html.append("<div class=\"table-wrapper\">\n");
            html.append("<table id='refreshApproved' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='10%'>عنوان مصوبه</th>");
            html.append("<th width='15%'>مسئولین اجرا</th>");
            html.append("<th width='15%'>مسئول اجرا</th>");
            html.append("<th width='20%'>مسئول پیگیری</th>");
            html.append("<th width='15%'>تاریخ شروع </th>");
            html.append("<th width='15%'>تاریخ پایان </th>");
            html.append("<th width='15%'>وضعیت</th>");
            html.append("<th width='40%'>ویرایش</th>");
            html.append("</thead><tbody>");

            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
//            List<Map<String, Object>> row = jjDatabase.separateRow(db.otherSelect("SELECT hmis_approved.id,sessions_status\n"
//                    + ",approved_title,r1.role_title As t1,r2.role_title t2"
//                    + ",u1.user_name,u1.user_family,u2.user_name,u2.user_family,\n"
//                    + "approved_status,approved_endDate,approved_startDate,approved_executorRoleId,approved_executorUserId"
//                    + " FROM hmis_approved\n"
//                    + " LEFT JOIN hmis_sessions ON approved_sessionsId=hmis_sessions.id\n"
//                    + " LEFT JOIN hmis_role r1 ON approved_executorRoleId=r1.id\n"
//                    + " LEFT JOIN hmis_role r2 ON approved_trackerId=r2.id\n"
//                    + "  LEFT JOIN access_user u1 ON r1.role_user_id=u1.id "
//                    + " LEFT JOIN access_user u2 ON r2.role_user_id=u2.id"
//                    + " WHERE sessions_status='" + Sessions.status_communicated + "' AND approved_status!='" + status_offer + "' AND approved_status!='" + status_reject + "' "
//
//            ));

            for (int i = 0; i < row.size(); i++) {
                html.append("<tr onclick='hmisApproved.m_select(" + row.get(i).get(_id) + ")' class='mousePointer " + Sessions.getClassCssForVaziat(row.get(i).get(_status).toString()) + "'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                System.out.println("" + row.get(i).get(_id));
                html.append("<td class='r'>" + row.get(i).get(_title) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_executorRoleId) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_executorUserId) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(Role._title) + "-" + row.get(i).get(Access_User._name) + " " + row.get(i).get(Access_User._family) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_startDate)) + "</td>");
                html.append("<td class='r'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_endDate)) + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_status) + "</td>");
                html.append("<td class='r'><i class='icon ion-gear-a' style='color:#a02311'></i></td>");
                html.append("</tr>");
            }
//            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swApprovedTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshApproved", "300", 0, "", "جلسات");
            Server.outPrinter(request, response, html2);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * creator shohre shiran 13971218
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            System.out.println("_executorId=" + jjTools.getParameter(request, _executorRoleId));
            String sessionsId = jjTools.getParameter(request, "hmis_sessions_id");
            List<Map<String, Object>> sessionsRow = jjDatabase.separateRow(db.Select(Sessions.tableName, Sessions._id + "=" + sessionsId));
            StringBuilder html = new StringBuilder();
            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_commettesId, sessionsRow.get(0).get(Sessions._commetteId));
            map.put(_endDate, jjTools.getParameter(request, _endDate).replaceAll("/", ""));
            map.put(_startDate, jjTools.getParameter(request, _startDate).replaceAll("/", ""));
            map.put(_file, jjTools.getParameter(request, _file));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_executorRoleId, (jjTools.getParameter(request, _executorRoleId).replaceAll("#A#", ",")));
            map.put(_executorUserId, (jjTools.getParameter(request, _executorUserId).replaceAll("#A#", ",")));
            map.put(_trackerId, jjTools.getParameter(request, _trackerId));
            map.put(_status, status_initialRegistration);
            map.put(_sessionsId, sessionsId);
            map.put(_statusLog,
                    status_initialRegistration
                    + ":"
                    + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                    + " user_id="
                    + jjTools.getSeassionUserId(request) + " "
                    + " role_id="
                    + jjTools.getSeassionUserRole(request)
                    + " "
                    + new jjCalendar_IR().getTimeFormat_8length()
                    + "%23A%23"
            );

            DefaultTableModel dtm = db.insert(tableName, map);
            if (dtm.getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            String script = "$('#approvedTbl').slideDown();$('#insertApproved2').slideUp();";
            script += Js.jjSessions.select(sessionsId);
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * creator shohre shiran 13971218
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            StringBuffer html = new StringBuffer();
            String sessionsId = jjTools.getParameter(request, "hmis_sessions_id");
            List<Map<String, Object>> SessionsRow = jjDatabase.separateRow(db.Select(Sessions.tableName, Sessions._id + "=" + sessionsId));//اگر وضعیت جلسه ابلاغ شده است دیگر وصوبه ثبت نشود
            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                if (SessionsRow.get(0).get(Sessions._status).equals(Sessions.status_created)) {
//                    if (!SessionsRow.get(0).get(Sessions._status).equals(Sessions.status_communicated)) {
                    html.append(Js.setHtml("#ApprovedInSessions_button", "<button  class=\"btn btn-outline-success  btn-block mg-b-10\" id=\"insert_Approved_new\" onclick='" + Js.jjApproved.insert() + "'>" + lbl_insert + "</button>"));
//                    }
                }
            }

            Server.outPrinter(request, response, html.toString());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * creator shohre shiran 13971218
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
            System.out.println("id=" + id);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder html5 = new StringBuilder();
            String script = "";
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";

            }
            List<Map<String, Object>> RolesTrackerIdRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + row.get(0).get(Approved._trackerId)));
            List<Map<String, Object>> UserTrackerIdRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + RolesTrackerIdRow.get(0).get(Role._user_id)));
//            String[] roleId = jjTools.getSessionAttribute(request, "#ROLE_ID").split("%23A%23");
//            for (int i = 0; i < roleId.length; i++) {
//                //جداکردن نقش ها و چک کردن هر کدام از نقش ها
//                if (row.get(0).get(_trackerId).equals(roleId[i])) {
//
//                    html.append(Js.removeAttr("#" + _descriptionTracker, "disabled"));
//                } else {
//                    html.append(Js.setAttr("#" + _descriptionTracker, "disabled", "disabled"));
//                }
//                if (row.get(0).get(_executorRoleId).equals(roleId[i]) || row.get(0).get(_executorUserId).equals(jjTools.getSeassionUserId(request))) {
//                    html.append(Js.removeAttr("#" + _descriptionExecutor, "disabled"));
//                } else {
//                    html.append(Js.setAttr("#" + _descriptionExecutor, "disabled", "disabled"));
//                }
//
//            }

            /////////////////////////////////////////////////////
            String trackerId = "" + row.get(0).get(_trackerId).toString() + ",";//با داشتن الگوی regex
            Pattern p1 = Pattern.compile(trackerId);
            String RolesId = jjTools.getSessionAttribute(request, "#ROLE_ID");
            String executorRoleId = "" + (row.get(0).get(_executorRoleId).toString() + ",");//این علائم نشانه این است که فقط همان  کاراکتر وجود داشته باشد
            Matcher m1 = p1.matcher(RolesId);   // get a matcher object

            if (m1.find()) {
                html.append(Js.removeAttr("#approved_descriptionTracker", "disabled"));
                html.append("$('#trackerFileApprovedDiv').show();");
                if (!row.get(0).get(Approved._filesTracker).toString().equals("")) {
                    String[] File = (row.get(0).get(_filesTracker).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    html5.append("<div class='col-lg-12'> "
                            + "فایل های مسئول پیگیری"
                            + "</div>"
                            + "");
                    for (int i = 0; i < File.length; i++) {
                        html5.append("<div class='col-lg-3'>");
                        List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + File[i] + "'"));
                        html5.append("<span  class='col-xs-1' onclick='hmisApproved.m_remove(" + fileRow.get(0).get(UploadServlet._id) + "," + id + ",1);'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
                        html5.append("<a id='downloadFilesTracker_Steps' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                        html5.append("</div>");
                    }
                }
            } else {
                html.append(Js.setAttr("#approved_descriptionTracker", "disabled", "disabled"));
                html.append("$('#trackerFileApprovedDiv').hide();");
                if (!row.get(0).get(Approved._filesTracker).toString().equals("")) {
                    String[] File = (row.get(0).get(_filesTracker).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    html5.append("<div class='col-lg-12'> "
                            + "فایل های مسئول پیگیری"
                            + "</div>"
                            + "");
                    for (int i = 0; i < File.length; i++) {
                        html5.append("<div class='col-lg-3'>");
                        html5.append("<a id='downloadFilesTracker_Approved' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                        html5.append("</div>");
                    }
                }
            }
            Pattern p2 = Pattern.compile(executorRoleId);//برای رول ها ومچ کردن با regex
            Matcher m2 = p2.matcher(RolesId);   // get a matcher object
            if (row.get(0).get(_executorUserId).toString().equals("" + jjTools.getSeassionUserId(request) + "") || m2.find()) {
                html.append(Js.removeAttr("#approved_descriptionExecutor", "disabled"));//
                html.append("$('#executorFileApprovedDiv').show();");
                if (!row.get(0).get(Approved._filesExecutor).toString().equals("")) {
                    String[] File = (row.get(0).get(_filesExecutor).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    html4.append("<div class='col-lg-12'> "
                            + "فایل های مسئول اجرا"
                            + "</div>"
                            + "");
                    for (int i = 0; i < File.length; i++) {
                        html4.append("<div class='col-lg-3'>");
                        List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + File[i] + "'"));
                        html4.append("<span  class='col-xs-1' onclick='hmisApproved.m_remove(" + fileRow.get(0).get(UploadServlet._id) + "," + id + ",2);'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
                        html4.append("<a id='downloadFilesExecutor_Approved' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                        html4.append("</div>");
                    }
                }
            } else {
                html.append(Js.setAttr("#approved_descriptionExecutor", "disabled", "disabled"));
                html.append("$('#executorFileApprovedDiv').hide();");
                if (!row.get(0).get(Approved._filesExecutor).toString().equals("")) {
                    String[] File = (row.get(0).get(_filesExecutor).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    html4.append("<div class='col-lg-12'> "
                            + "فایل های مسئول اجرا"
                            + "</div>"
                            + "");
                    for (int i = 0; i < File.length; i++) {
                        html4.append("<div class='col-lg-3'>");
                        html4.append("<a id='downloadFilesExecutor_Approved' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                        html4.append("</div>");
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#" + _file, row.get(0).get(_file)));
            html.append(Js.setVal("#" + _filesTracker, row.get(0).get(_filesTracker)));
            html.append(Js.setVal("#" + _filesExecutor, row.get(0).get(_filesExecutor)));
            html.append(Js.setVal("#" + _status, row.get(0).get(_status)));
            html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
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
            if (!row.get(0).get(_file).toString().equals("")) {
                String[] File = (row.get(0).get(_file).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html3.append(" <div  class='col-lg-12'>");
                for (int i = 0; i < File.length; i++) {

                    html3.append("فایل های دبیر کمیته ");
                    html3.append("  <div class=\"col-lg-2\" >"
                            + "<a id='downloadFile_Approved'   href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'>دانلود فایل<input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a>"
                            + "</div>");

                }
                html3.append("</div>");
            }
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            html2.append("<div class='row'>");
            if (accEdt) {
                html2.append("<div class=\"col-lg-12\">");
                html2.append("<button  id='edit_Approved' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjApproved.edit() + "' >" + lbl_edit + "</button>");
                html2.append("</div>");
            }

            html2.append("</div>");
            script += Js.setHtml("#Approved_button", html2);
            script += html.toString();
            script += Js.setHtml("#inputTextSelectorDiv", html3);
            script += Js.setHtml("#filesApprovedExecutorDiv", html4);
            script += Js.setHtml("#filesApprovedTrackerDiv", html5);
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * انتخاب مصوبات و سلکت آن ها در جلسات
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String selectInSessions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String script = "";
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String id = jjTools.getParameter(request, _id);
            System.out.println("id=" + id);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.get(0).get(_status).equals(status_reject)) {
                script += "$('#insertApproved2').hide();";
            } else {
                script += "$('#insertApproved2').slideDown();";
                script += "$('#approvedTbl').slideUp();";
                if (row.size() == 0) {
                    String errorMessage = "رکوردی با این کد وجود ندارد.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Select Fail;";
                    }
                    Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                    return "";
                }
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
                    html.append("$('#approved_executorRoleId').val([" + temp + "]);"
                            + "$('#approved_executorRoleId').select2({ minimumResultsForSearch: '', width: '100%'});"
                            + "$('#approved_executorUserId').val('');"
                            + "hmisSessions.executorAction('سمت');"
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
                    html.append("$('#approved_executorUserId').val([" + temp2 + "]);"
                            + "$('#approved_executorUserId').select2({minimumResultsForSearch: '', width: '100%'});"
                            + "$('#approved_executorRoleId').val('');"
                            + "hmisSessions.executorAction('کاربران');"
                            + "$('input:radio[id=userExecutor]').attr('checked','checked');"
                    );

                }
                html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
                html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
                html.append(Js.setVal("#" + _file, row.get(0).get(_file)));
                html.append(Js.setVal("#" + _descriptionExecutor, row.get(0).get(_descriptionExecutor)));
                html.append(Js.setVal("#" + _descriptionTracker, row.get(0).get(_descriptionTracker)));
                html.append(Js.setVal("#" + _status, row.get(0).get(_status)));
                System.out.println("********************" + row.get(0).get(_statusLog));
                html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
                html.append(Js.setVal("#" + _trackerId, row.get(0).get(_trackerId)));
                html.append(Js.setVal("#" + _endDate, jjCalendar_IR.getViewFormat(row.get(0).get(_endDate))));
                html.append(Js.setVal("#" + _startDate, jjCalendar_IR.getViewFormat(row.get(0).get(_startDate))));
                if (!row.get(0).get(_file).toString().equals("")) {
                    String[] File = (row.get(0).get(_file).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    for (int i = 0; i < File.length; i++) {

                        html3.append("<div class='col-lg-12'>");
                        html3.append("<div>فایل های دبیر کمیته</div>");
                        html3.append("<div class='col-lg-3'><a id='downloadFile_ApprovedInSessions' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a></div>");
                        html3.append("</div>");

                    }
                }
                if (!row.get(0).get(_filesTracker).toString().equals("")) {
                    String[] File = (row.get(0).get(_file).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    for (int i = 0; i < File.length; i++) {
                        html3.append("<div class='col-lg-12'>");
                        html3.append("<div>فایل های مسئول پیگیری</div>");
                        html3.append("<div class='col-lg-3'><a id='downloadFile_TrackerApproved' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a></div>");
                        html3.append("</div>");
                    }
                }
                if (!row.get(0).get(_filesExecutor).toString().equals("")) {
                    String[] File = (row.get(0).get(_filesExecutor).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                    for (int i = 0; i < File.length; i++) {
                        html3.append("<div class='col-lg-12'>");
                        html3.append("<div>فایل های مسئول اجرا</div>");
                        html3.append("<div class='col-lg-3'><a id='downloadFile_executorApproved' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a></div>");
                        html3.append("</div>");

                    }
                }

                boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
                boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
                html2.append("<div class='row'>");
                List<Map<String, Object>> SessionsRow = jjDatabase.separateRow(db.Select(Sessions.tableName, Sessions._id + "=" + row.get(0).get(_sessionsId)));
                if (SessionsRow.get(0).get(Sessions._status).equals(Sessions.status_created)) {
                    if (accEdt) {
                        html2.append("<div class=\"col-lg-6\">");
                        html2.append("<button  id='edit_ApprovedInSessions' class='btn btn-outline-warning btn-block mg-b-10' onclick='hmisApproved.editInSessions();' >" + lbl_edit + "</button>");
                        html2.append("</div>");
                    }
                    if (accDel) {
                        html2.append("<div class=\"col-lg-6\">");
                        html2.append("<button id='delete_ApprovedInSessions'  class='btn btn-outline-danger btn-block mg-b-10' onclick='hmisApproved.m_delete(" + id + ");'>" + lbl_delete + "</button>");
                        html2.append("</div>");
                    }
                } else {
                }
                html2.append("</div>");
                script += Js.setHtml("#ApprovedInSessions_button", html2);
                script += html.toString();
                script += Js.setHtml("#inputDownloadDiv", html3);
            }
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String selectInCommunicatedSessions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String script = "";
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String id = jjTools.getParameter(request, _id);
            System.out.println("id=" + id);
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            script += "$('#insertApprovedCommunicated').slideDown();";
            script += "$('#communicatedApprovedTbl').slideUp();";
            if (row.size() == 0) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }

            if (row.get(0).get(_executorUserId).equals("")) {

                String executorRoleId = (row.get(0).get(_executorRoleId).toString());
                System.out.println("executorRoleId=" + executorRoleId);
                String[] exeRoleId = executorRoleId.split(",");
                String temp = "";
                System.out.println("exeRoleId" + exeRoleId.length);
                for (int i = 0; i < exeRoleId.length; i++) {
                    temp += "'" + exeRoleId[i] + "',";
                }
//                System.out.println("temp=" + temp + "executorRoleId=" + executorRoleId);
                html.append("$('#communicatedApproved_executorRoleId').val([" + temp + "]);"
                        + "$('#communicatedApproved_executorRoleId').select2({ minimumResultsForSearch: '', width: '100%'});"
                        + "$('#communicatedApproved_executorUserId').val('');"
                        + "hmisSessions.executorAction('سمت');"
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

                html.append("$('#communicatedApproved_executorUserId').val([" + temp2 + "]);"
                        + "$('#communicatedApproved_executorUserId').select2({minimumResultsForSearch: '', width: '100%'});"
                        + "$('#communicatedApproved_executorRoleId').val('');"
                        + "hmisSessions.executorAction('کاربران');"
                        + "$('input:radio[id=userExecutor]').attr('checked','checked');"
                );

            }
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#communicatedApproved_title", row.get(0).get(_title)));
            html.append(Js.setVal("#communicatedApproved_file", row.get(0).get(_file)));
            html.append(Js.setVal("#communicatedApproved_status", row.get(0).get(_status)));
//            System.out.println("********************" + row.get(0).get(_statusLog));
            html.append(Js.setVal("#communicatedApproved_description", row.get(0).get(_description)));
            html.append(Js.setVal("#communicatedApproved_trackerId", row.get(0).get(_trackerId)));
            html.append(Js.setVal("#communicatedApproved_endDate", jjCalendar_IR.getViewFormat(row.get(0).get(_endDate))));
            html.append(Js.setVal("#communicatedApproved_startDate", jjCalendar_IR.getViewFormat(row.get(0).get(_startDate))));
            if (!row.get(0).get(_file).toString().equals("")) {
                String[] File = (row.get(0).get(_file).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                for (int i = 0; i < File.length; i++) {
                    html3.append(" <div class='col-lg-6'><a id='downloadFile_ApprovedInSessions' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a></div>");

                }
            }

            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            html2.append("<div class='row'>");
            List<Map<String, Object>> SessionsRow = jjDatabase.separateRow(db.Select(Sessions.tableName, Sessions._id + "=" + row.get(0).get(_sessionsId)));
            if (SessionsRow.get(0).get(Sessions._status).equals(Sessions.status_created)) {
                if (accEdt) {
                    html2.append("<div class=\"col-lg-6\">");
                    html2.append("<button  id='edit_communicatedApprovedInSessions' class='btn btn-outline-warning btn-block mg-b-10' onclick='hmisApproved.editInSessions();' >" + lbl_edit + "</button>");
                    html2.append("</div>");
                }
                if (accDel) {
                    html2.append("<div class=\"col-lg-6\">");
                    html2.append("<button id='delete_communicatedApprovedInSessions'  class='btn btn-outline-danger btn-block mg-b-10' onclick='hmisApproved.m_delete(" + id + ");'>" + lbl_delete + "</button>");
                    html2.append("</div>");
                }
            } else {
            }

            html2.append("</div>");
            script += Js.setHtml("#communicatedApprovedInSessions_button", html2);
            script += html.toString();
            script += Js.setHtml("#inputDownloadDiv", html3);
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * انتخاب مصوبات در قسمت جلسات برای بررسی مصوبات قبلی این کمیته
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String selectApprovedPrevious(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            System.out.println("id=" + id);
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
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            List<Map<String, Object>> RolesTrackerIdRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._user_id + "," + Role._id + "," + Role._title, Role._id + "=" + row.get(0).get(Approved._trackerId)));
            List<Map<String, Object>> UserTrackerIdRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._name + "," + Access_User._family, Access_User._id + "=" + RolesTrackerIdRow.get(0).get(Role._user_id)));

            html.append(Js.setVal("#approvedPrevious_id", row.get(0).get(_id)));
            html.append(Js.setVal("#approvedPrevious_title", row.get(0).get(_title)));
            html.append(Js.setVal("#approved_fileCheckOut", row.get(0).get(_file)));
            html.append(Js.setVal("#approvedPrevious_status", row.get(0).get(_status)));
            html.append(Js.setVal("#approvedPrevious_descriptionExecutor", row.get(0).get(_descriptionExecutor)));
            html.append(Js.setVal("#approvedPrevious_descriptionTracer", row.get(0).get(_descriptionTracker)));
            html.append(Js.setVal("#approvedPrevious_trackerId", RolesTrackerIdRow.get(0).get(Role._title) + "-" + UserTrackerIdRow.get(0).get(Access_User._name) + " " + UserTrackerIdRow.get(0).get(Access_User._family)));
            if (row.get(0).get(_executorRoleId).equals("")) {
                html.append(Js.setVal("#approvedPrevious_executorRoleId", row.get(0).get(_executorUserId)));
            } else if (row.get(0).get(_executorUserId).equals("")) {
                html.append(Js.setVal("#approvedPrevious_executorRoleId", row.get(0).get(_executorRoleId)));
            }
            html.append(Js.setVal("#approvedPrevious_endDate", jjCalendar_IR.getViewFormat(row.get(0).get(_endDate))));
            html.append(Js.setVal("#approvedPrevious_startDate", jjCalendar_IR.getViewFormat(row.get(0).get(_startDate))));
            html.append(Js.setVal("#approvedPrevious_statusLog", (row.get(0).get(_statusLog).toString()).replaceAll("#A#", "<br/>")));
            if (!row.get(0).get(_file).toString().equals("")) {
                String[] File = (row.get(0).get(_file).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html3.append("<div class='row col-lg-12'> "
                        + "فایل های دبیر کمیته"
                        + "</div>"
                        + "");
                for (int i = 0; i < File.length; i++) {
                    html3.append(" <div class='col-lg-2'><a id='downloadFile_ApprovedInSessions' title='دانلود فایل'  href='upload/" + File[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + File[i] + "' class='form-control is-valid hasDatepicker' /></a></div>");
                }
            }
            if (!row.get(0).get(_filesExecutor).toString().equals("")) {
                String[] filesExecutor = (row.get(0).get(_filesExecutor).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html4.append("<div class='row col-lg-12'>"
                        + "فایل های مسئولین اجرا"
                        + "</div>");
                for (int i = 0; i < filesExecutor.length; i++) {
                    html4.append(" <div class='col-lg-2'><a id='downloadExecutorFile_ApprovedInSessions' title='دانلود فایل'  href='upload/" + filesExecutor[i] + "' target='_blank' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + filesExecutor[i] + "' class='form-control is-valid hasDatepicker' /></a></div>");
                }
            }
            if (!row.get(0).get(_filesTracker).toString().equals("")) {
                String[] filesTracker = (row.get(0).get(_filesTracker).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                html4.append("<div class='row col-lg-12'>"
                        + "فایل های مسئول پیگیری"
                        + "</div>");
                for (int i = 0; i < filesTracker.length; i++) {
                    html4.append(" <div class='col-lg-2'><a id='downloadTrackerFile_ApprovedInSessions' title='دانلود فایل'  href='upload/" + filesTracker[i] + "' target='_blank' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + filesTracker[i] + "' class='form-control is-valid hasDatepicker' /></a></div>");
                }
            }

            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//

            if (accEdt) {
                html2.append("<div class=\"col-lg-12\">");
                html2.append("<button  id='edit_ApprovedPrevious' class='btn btn-outline-warning btn-block mg-b-10' onclick='hmisApproved.editApprovedPrevious();' >" + lbl_edit + "</button>");
                html2.append("</div>");
            }

            String script = "";
            script += Js.setHtml("#ApprovedPrevious_button", html2);//دکمه های مربوط به مصوبات قبلی 
            script += Js.setHtml("#ApprovedPrevious_FileApprovedInsessions", html3);//فایل های دبیر کمیته 
            script += Js.setHtml("#ApprovedPrevious_FileInsessions", html4);//فایل های مسئولین
            script += html.toString();
            Server.outPrinter(request, response, script);
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

    /**
     * creator shohre shiran 13971218
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            System.out.println("id=" + id);
            String script = "";
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";

            }
            Map<String, Object> map = new HashMap<>();
            map.put(_filesExecutor, jjTools.getParameter(request, _filesExecutor));
            map.put(_filesTracker, jjTools.getParameter(request, _filesTracker));
            map.put(_descriptionExecutor, jjTools.getParameter(request, _descriptionExecutor));
            map.put(_descriptionTracker, jjTools.getParameter(request, _descriptionTracker));
            map.put(_status, jjTools.getParameter(request, _status));

            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            } else {
//                if (result.isEmpty()) {
                script += "hmisApproved.m_refresh();";
                script += "hmisApproved.m_select(" + id + ");";
                script += Js.modal("تغییرات انجام شد", "پیام سامانه");
//                }
            }
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ویرایش اطلاعات مصوبه در جلسات
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String editInSessions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, "hmis_approved_id");
            String sessionsId = jjTools.getParameter(request, "hmis_sessions_id");

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            System.out.println("/////////////////////////////////////");
            jjTools.ShowAllParameter(request);
            System.out.println("/////////////////////////////////////");
            Map<String, Object> map = new HashMap<>();
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_endDate, jjTools.getParameter(request, _endDate).replaceAll("/", ""));
            map.put(_startDate, jjTools.getParameter(request, _startDate).replaceAll("/", ""));
            map.put(_file, jjTools.getParameter(request, _file));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_trackerId, jjTools.getParameter(request, _trackerId));
            if (jjTools.getParameter(request, _executorUserId).equals("null")) {
                map.put(_executorRoleId, (jjTools.getParameter(request, _executorRoleId)));
                map.put(_executorUserId, "");
            } else if (jjTools.getParameter(request, _executorRoleId).equals("null")) {

                map.put(_executorUserId, (jjTools.getParameter(request, _executorUserId)));
                map.put(_executorRoleId, "");
            }

            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            String script = Js.jjSessions.select(sessionsId);
            script += "$('#insertApproved2').slideUp();";
            script += "$('#approvedTbl').slideDown();";
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ویرایش مصوبات مربوط به جلسات قبلی
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String editApprovedPrevious(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, "approvedId");
            String sessionsId = jjTools.getParameter(request, "hmis_sessions_id");

            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            List<Map<String, Object>> approvedRow = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));
            Map<String, Object> map = new HashMap<>();
            map.put(_endDate, jjTools.getParameter(request, _endDate).replaceAll("/", ""));
            map.put(_startDate, jjTools.getParameter(request, _startDate).replaceAll("/", ""));
            map.put(_file, jjTools.getParameter(request, _file));
            map.put(_status, jjTools.getParameter(request, _status));

            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            System.out.println("sessionsId=" + sessionsId);
            String script = Js.jjSessions.select(sessionsId);
            script += "$('#approvedPreviousDiv').slideUp();";
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ای دی مصوبات
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            String sessionsId = jjTools.getParameter(request, "hmis_sessions_id");

            String id = jjTools.getParameter(request, _id);
            System.out.println("id=" + id);

            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            String script = Js.jjSessions.select(sessionsId);
            script += "$('#insertApproved2').slideUp();";
            script += "$('#approvedTbl').slideDown();";
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * به تعداد مسئولین رکورد ساخته می شود اگر مسئول یکی بود رکوردی ایجاد نمی
     * شود وفقط وضعیت مصوبه به ابلاغ شده تغییر می کند
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String communicatedApproved(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
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
                        map.put(_file, row.get(0).get(_file));
                        map.put(_description, row.get(0).get(_description));
                        map.put(_executorRoleId, ExeRoleId[i]);
                        map.put(_trackerId, row.get(0).get(_trackerId));
                        map.put(_sessionsId, row.get(0).get(_sessionsId));
                        map.put(_commettesId, row.get(0).get(_commettesId));
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
                                + status_inDoing
                                + "-"
                                + jjCalendar_IR.getViewFormat(jjCalendar_IR.getDatabaseFormat_8length("", true))
                                + " "
                                + new jjCalendar_IR().getTimeFormat_8length()
                                + "user_id="
                                + jjTools.getSeassionUserId(request) + " "
                                + "roleId="
                                + jjTools.getSessionAttribute(request, "#ROLE_ID")
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
                        map.put(_file, row.get(0).get(_file));
                        map.put(_description, row.get(0).get(_description));
                        map.put(_executorUserId, ExeUserId[i]);
                        map.put(_trackerId, row.get(0).get(_trackerId));
                        map.put(_sessionsId, row.get(0).get(_sessionsId));
                        map.put(_commettesId, row.get(0).get(_commettesId));
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
                                + "user_id="
                                + jjTools.getSeassionUserId(request) + " "
                                + "  roleId="
                                + jjTools.getSessionAttribute(request, "#ROLE_ID")
                                + "%23A%23"
                        );
                        db.insert(tableName, map);
                    }

                } else {
                    changeStatus(request, db, id, status_inDoing);
                }

            }
            System.out.println("id=" + id);
//            changeStatus(request, db, id, status_inDoing);

            String script = "hmisCommunicatedSessions.m_refresh();";
            script += "hmisCommunicatedSessions.m_select(" + row.get(0).get(_sessionsId) + ");";
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * حذف نام فایل وآی دی فایل از سرولت ای دی مصوبات و ای دی اپلود سرولت
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
            String script = "";
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            String idUpload = jjTools.getParameter(request, "upload_id");///
            String id = jjTools.getParameter(request, "hmis_approved_id");
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
                script += "$('#approved_filesExecutor').val('" + attacheFiles + "');";
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
                script += "$('#approved_filesTracker').val('" + attacheFiles + "');";
            }
            Access_User.changeStatus(request, response, db, idUpload, UploadServlet.status_deleted + " " + jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY"));
            script += " hmisApproved.m_select(" + id + ");";
            Server.outPrinter(request, response, script);
            return "";
//

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }

    /**
     * زمان اضافه کردن یک پیشنهاد به مصوبات مان این تایع استفاده می کنیم
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String addApproved(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            String id = jjTools.getParameter(request, "hmis_approved_id");
            String sessionsId = jjTools.getParameter(request, "sessionsId");
            List<Map<String, Object>> SessionsRow = jjDatabase.separateRow(db.Select(Sessions.tableName, Sessions._id + "=" + sessionsId));

            String script = "";
            if (SessionsRow.get(0).get(Sessions._status).equals(Sessions.status_created)) {
                Map<String, Object> map = new HashMap<>();
                changeStatus(request, db, id, status_initialRegistration);
                map.put(_sessionsId, sessionsId);

                if (!db.update(tableName, map, _id + "=" + id)) {
                    String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");
                } else {
                    script += Js.jjApproved.refresh();
                    script += "hmisSessions.m_select(" + sessionsId + ");";
                }
            } else {
                script += Js.modal("این پیشنهاد به دلیل تایید شدن جلسه قابل ثبت یا رد نمی باشد ", "پیام سامانه");
            }
            Server.outPrinter(request, response, script);
            return "";
//           

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }

    /**
     * رد پیشنهاد عملیاتی
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String rejectApproved(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {

            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            String id = jjTools.getParameter(request, "hmis_approved_id");
            String sessionsId = jjTools.getParameter(request, "sessionsId");
            String script = "";
            List<Map<String, Object>> SessionsRow = jjDatabase.separateRow(db.Select(Sessions.tableName, Sessions._id + "=" + sessionsId));

            Map<String, Object> map = new HashMap<>();
            if (SessionsRow.get(0).get(Sessions._status).equals(Sessions.status_created)) {

                changeStatus(request, db, id, status_reject);
                map.put(_status, status_reject);
                map.put(_sessionsId, sessionsId);

                if (!db.update(tableName, map, _id + "=" + id)) {
                    String errorMessage = "عملیات  به درستی صورت نگرفت.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Edit Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");
                } else {
                    script += Js.jjApproved.refresh();
                    script += "hmisSessions.m_select(" + sessionsId + ");";
                }
            } else {
                script += Js.modal("این پیشنهاد به دلیل تایید شدن جلسه قابل ثبت یا رد نمی باشد ", "پیام سامانه");

            }
            Server.outPrinter(request, response, script);
            return "";
//           

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }

//    public static String getClassCssForStatus(String satus) {
//        if (satus.equals(status_inDoing)) {
//            return "vaziat_sabteAvalie";
//        } else if (satus.equals(status_done)) {
//            return "vaziat_taeedeNahaie";
//        } else if (satus.equals(status_unDone)) {
//            return "vaziat_ersalShodeBeModireFani";// این کلاس در فایل های سی اس اس تعریف میشود و در قسمت های مختلف جدول نشان داده می شود
//        }
//        return "";
//    }
}
