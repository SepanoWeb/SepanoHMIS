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
 * @author shohreh.shiran Date 1397.11.1
 */
public class Commettes {

    public static String tableName = "hmis_commettes";
    public static String _id = "id";
    public static String _isActive = "commettes_isActive";//وضعیت فعال وغیر فعال
    public static String _creatorId = "commettes_creatorId";//عنوان کمیته
    public static String _title = "commettes_title";//عنوان کمیته
    public static String _superwizar = "commettes_superwizar";//رئیس کمیته
    public static String _secretary = "commettes_secretary";// دبیر کمیته
    public static String _period = "commettes_period";//برگزاری جلسات
    public static String _members = "commettes_members";//اعضای کمیته  همان نقش میشود از جدول نقش ها می اید 
    public static String _regulationFile = "commettes_regulationFile";//آئین نامه
    public static String _documnetsFile = "commettes_documentsFile";//داکیومنت
    public static String _description = "commettes_description";//توضیحات
    public static String _date = "commettes_date";//تاریخ 

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

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();

            DefaultTableModel dtm = db.Select(tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append("<div class=\"card-header bg-primary tx-white\">لیست کمیته ها و کارگروه ها</div>\n");
            html.append(" <div class=\"card-body pd-sm-30\">\n"
                    + "                                        <p class=\"mg-b-20 mg-sm-b-30\">\n"
                    + "                                            <a style='color:#fff' class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" onclick=\"hmisCommettes.m_add_new();\" >کمیته جدید</a>\n"
                    + "                                        </p>\n"
                    + "                                    </div>");
            html.append("        <div class=\"table-wrapper\">\n");
            html.append("<table id='refreshCommettes' class='table display responsive' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th class='r' width='5%'>کد</th>");
            html.append("<th class='r' width='20%'>وضعیت</th>");
            html.append("<th class='r' width='20%'>نام کمیته</th>");
            html.append("<th class='r' width='20%'>دبیر کمیته</th>");
            html.append("<th class='r' width='20%'>رئیس کمیته</th>");
            html.append("<th class='r' width='20%'>دعوتنامه</th>");
            html.append("<th class='r' width='20%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                List<Map<String, Object>> secretaryTitle = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + row.get(i).get(_secretary)));
                List<Map<String, Object>> superwizerTitle = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + row.get(i).get(_superwizar)));
                html.append("<tr  class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                String StatusActive = row.get(i).get(_isActive).equals("1") ? "فعال" : "غیرفعال";
                html.append("<td class='r'>" + StatusActive + "</td>");
                html.append("<td class='r'>" + row.get(i).get(_title) + "</td>");
                html.append("<td class='r'>" + secretaryTitle.get(0).get(Role._title) + "</td>");
                html.append("<td class='r'>" + superwizerTitle.get(0).get(Role._title) + "</td>");
                html.append("<td class='r'><i class='icon ion-email' onclick='hmisCommettes.showInvitationForm(" + row.get(i).get(_id) + ");' style='color:#ffcd00!important'></i></td>");
                html.append("<td class='r'><i class='icon ion-ios-gear-outline'  onclick='hmisCommettes.m_select(" + row.get(i).get(_id) + ")'></i></td>");
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
                panel = "swCommettesTbl";
            }
            String script = Js.setHtml("#" + panel, html.toString());

            script += Js.table("#refreshCommettes", "300", 0, "", "کمیته ها");
            //////////////////////////////برای سلکت های موجود در فرم کمیتهها/////////////
            List<Map<String, Object>> roleRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._condition + "='active'"));
            ///////////////////////////////////////////////نمایش جدول نقش ها
            html2.append("<div class=\"table-wrapper\">\n");
            html2.append("<table required id='refreshRoles' class='table display responsive' class='tahoma10' style='direction: rtl;'><thead>");
            html2.append("<th class='r' width='20%'>کد</th>");
            html2.append("<th class='r' width='20%'>سمت</th>");
            html2.append("<th class='r' width='40%'>نام و نام خانوادگی</th>");
            html2.append("<th class='r' width='20%'>عملیات</th>");
            html2.append("</thead><tbody>");
            for (int i = 0; i < roleRow.size(); i++) {
                List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + roleRow.get(i).get(Role._user_id)));
                html2.append("<tr  class='mousePointer'>");
                html2.append("<td class='r'>" + roleRow.get(i).get(Role._id) + "</td>");
                html2.append("<td class='r'>" + roleRow.get(i).get(Role._title) + "</td>");
                html2.append("<td class='r'>" + userRow.get(0).get(Access_User._name) + " " + userRow.get(0).get(Access_User._family) + "</td>");
                html2.append("<td class='r' id='td" + i + "' onclick='hmisCommettes.addMembers(" + i + ")'><i id='" + roleRow.get(i).get(Role._id) + "' class='icon ion-plus-circled'  style='' ></i></td>");
                html2.append("</tr>");
            }
            html2.append("</tbody></table>");
            script += Js.setHtml("#tableRolesDiv", html2);
            script += Js.table("#refreshRoles", "300", 0, "", "نقش ها");
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * creator shohre shiran 13971211
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
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            StringBuilder html = new StringBuilder();
            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
            System.out.println("commettes_creatorId=" + jjTools.getSessionAttribute(request, "#ID"));
            map.put(_creatorId, jjTools.getSeassionUserId(request));
            map.put(_period, jjTools.getParameter(request, _period));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_members, jjTools.getParameter(request, _members));
            map.put(_secretary, jjTools.getParameter(request, _secretary));
            map.put(_superwizar, jjTools.getParameter(request, _superwizar));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_regulationFile, jjTools.getParameter(request, _regulationFile));
            map.put(_documnetsFile, jjTools.getParameter(request, _documnetsFile));
            map.put(_isActive, jjTools.getParameter(request, _isActive));
            map.put(_date, jjTools.getParameter(request, _date).replaceAll("/", ""));

            DefaultTableModel dtm = db.insert(tableName, map);
            if (dtm.getRowCount() == 0) {

                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }

            Server.outPrinter(request, response, Js.jjCommettes.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * creator shohre shiran 13971211
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            StringBuilder html = new StringBuilder();

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Commette_button", "<button  id=\"insert_Commette_new\"  class=\"btn btn-outline-success active btn-block mg-b-10\" onclick='" + Js.jjCommettes.insert() + "'>" + lbl_insert + "</button>"));
            }
            String script = html.toString();

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * creator shohre shiran 13971211
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);//ای دی کمیته
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
            String commettesId = row.get(0).get(_id).toString();
            html.append("$('#" + _secretary + "').val([" + row.get(0).get(_secretary) + "]);$('#" + _secretary + "').select2({ minimumResultsForSearch: '', width: '100%'});");
            html.append("$('#" + _superwizar + "').val([" + row.get(0).get(_superwizar) + "]);$('#" + _superwizar + "').select2({ minimumResultsForSearch: '', width: '100%'});");
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            html.append(Js.setVal("#" + _documnetsFile, row.get(0).get(_documnetsFile)));
            html.append(Js.setVal("#" + _regulationFile, row.get(0).get(_regulationFile)));
            html.append(Js.setVal("#" + _period, row.get(0).get(_period)));
            html.append(Js.setVal("#" + _description, row.get(0).get(_description)));
            html.append(Js.setVal("#" + _members, row.get(0).get(_members)));
            html.append(Js.setValDate("#" + _date, row.get(0).get(_date)));
            html.append(Js.setVal("#" + _regulationFile, row.get(0).get(_regulationFile)));
            html.append(Js.setVal("#" + _isActive, row.get(0).get(_isActive)));
            if (!row.get(0).get(_documnetsFile).toString().equals("")) {
                String[] documentFile = (row.get(0).get(_documnetsFile).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                for (int i = 0; i < documentFile.length; i++) {
                    html3.append("<div class='col-lg-3'>");
                    List<Map<String, Object>> documentFileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + documentFile[i] + "'"));
                    html3.append("<span  class='col-xs-1' onclick='hmisCommettes.m_remove(" + documentFileRow.get(0).get(UploadServlet._id) + "," + commettesId + ",1);'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
                    html3.append("<a id='downloadFiledocument_commettes' title='دانلود فایل'  href='upload/" + documentFile[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + documentFile[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                    html3.append("</div>");
                }
            }
            if (!row.get(0).get(_regulationFile).toString().equals("")) {
                String[] regulationFile = (row.get(0).get(_regulationFile).toString().replaceAll("#A#", "%23A%23")).split("%23A%23");
                for (int i = 0; i < regulationFile.length; i++) {
                    html4.append("<div class='col-lg-3'>");
                    List<Map<String, Object>> regulationFileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + regulationFile[i] + "'"));
                    html4.append("<span  class='col-xs-1' onclick='hmisCommettes.m_remove(" + regulationFileRow.get(0).get(UploadServlet._id) + "," + commettesId + ",2);'>" + "<img  src='imgfeyz/delet.png' style='width:20px' /></span>");
                    html4.append("<a id='downloadRegulationFile_commettes' title='دانلود فایل'  href='upload/" + regulationFile[i] + "' class='btn btn-outline-success  btn-block mg-b-10'><input value='" + regulationFile[i] + "' class='form-control is-valid hasDatepicker' /></a>");
                    html4.append("</div>");
                }
            }
            html.append(Js.setAttr("#PicPreviewAttach", "src", "upload/" + row.get(0).get(_regulationFile) + ""));
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            html2.append("<div class='row'>");
            if (accEdt) {
                html2.append("<div class=\"mg-t-20  col-lg\">");
                html2.append("<button  id='edit_Commettes'  class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjCommettes.edit() + "'>" + lbl_edit + "</button>");
                html2.append("</div>");
            }
            if (accDel) {
                html2.append("<div class=\"mg-t-20  col-lg\">");
                html2.append("<button id='delete_Commettes' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjCommettes.delete(id) + "' >" + lbl_delete + " </button>");
                html2.append("</div>");
            }
            html2.append("</div>");
            String script = Js.setHtml("#Commette_button", html2);
            if (row.get(0).get(_members).toString().equals("")) {

            } else {
                String membersId = row.get(0).get(_members).toString();
                String[] memberId = (membersId.replaceAll("#A#", "%23A%23")).split("%23A%23");
                for (int i = 0; i < memberId.length; i++) {
                    script += ("$('#tableRolesDiv #refreshRoles #" + memberId[i] + "').attr('class','icon ion-checkmark-circled').css('color','green');");
                }
            }
            script += html.toString();
            script += Js.setHtml("#inputTextSelectorDiv1", html3);
            script += Js.setHtml("#inputTextSelectorDiv2", html4);
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * creator shohre shiran 13971211
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                Server.outPrinter(request, response, Js.modal(errorMessage,"پیام سامانه"));
//            }
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            List<Map<String, Object>> Row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_period, jjTools.getParameter(request, _period));
            map.put(_description, jjTools.getParameter(request, _description));
            map.put(_members, jjTools.getParameter(request, _members));
            map.put(_secretary, jjTools.getParameter(request, _secretary));
            map.put(_superwizar, jjTools.getParameter(request, _superwizar));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_regulationFile, jjTools.getParameter(request, _regulationFile));
            map.put(_isActive, jjTools.getParameter(request, _isActive));
            map.put(_date, jjTools.getParameter(request, _date).replaceAll("/", ""));
            map.put(_documnetsFile, jjTools.getParameter(request, _documnetsFile));
            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            Server.outPrinter(request, response, Js.jjCommettes.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ویژگی: زمانی حذف صورت میگیرید که کمیته مورد نظر جایی استفاده نشده باشد
     *
     * @param request
     * @param response
     * @param db
     * @param needString
     * @return
     * @throws Exception
     */
    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean needString) throws Exception {
        try {

            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, hasAccess);
                return "";
            }
            String id = jjTools.getParameter(request, _id);
            System.out.println("id=" + id);
            String script = "";
            List<Map<String, Object>> RowAll = jjDatabase.separateRow(db.otherSelect("SELECT hmis_commettes.id FROM hmis_commettes "
                    + " LEFT JOIN hmis_sessions ON hmis_commettes.id=hmis_sessions.sessions_commettesId WHERE hmis_commettes.id=" + id + ""));
            boolean flag = true;
            System.out.println("rowAll=" + RowAll.size());
            if (RowAll.size() > 0) {
                flag = false;

            }

            if (flag == false) {
                script += Js.modal("امکان حذف کمیته وجود ندارد", "پیام سامانه");
            } else {
                if (!db.delete(tableName, _id + "=" + id)) {
                    String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Delete Fail;";
                    }
                    script += Js.modal(errorMessage, "پیام سامانه");
                    return "";
                }
                script += Js.jjCommettes.refresh();
            }

            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * دعوتنامه نمایش داده می شود
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String showInvitationForm(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {

            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String commettesId = jjTools.getParameter(request, _id);
            System.out.println("commettesId=" + commettesId);
            List<Map<String, Object>> commettesRow = jjDatabase.separateRow(db.Select(Commettes.tableName, Commettes._id + "=" + commettesId));
            List<Map<String, Object>> sessionsRow = jjDatabase.separateRow(db.Select(Sessions.tableName, Sessions._id + "=" + commettesId));
            String memberId = commettesRow.get(0).get(Commettes._members).toString();
            String[] membersId = (memberId.replaceAll("#A#", "%23A%23")).split("%23A%23");
            for (int i = 0; i < membersId.length; i++) {
                List<Map<String, Object>> roleRow = jjDatabase.separateRow(db.Select(Role.tableName, Role._id + "=" + membersId[i]));
                List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + roleRow.get(0).get(Role._user_id)));
                html.append("<label class=\"ckbox\">");
                html.append("<input type = \"checkbox\" value ='" + roleRow.get(0).get(Role._id) + "' class=\"checkBoxInvitees\" name = \"sessions_Invitees\" id = \"sessions_Invitees" + roleRow.get(0).get(Role._user_id) + "\" > ");
                html.append("<span>" + userRow.get(0).get(Access_User._name) + " " + userRow.get(0).get(Access_User._family) + "-" + roleRow.get(0).get(Role._title) + "");
                html.append("</span>");
                html.append("</label>");
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
            List<Map<String, Object>> usersRow = jjDatabase.separateRow(db.Select(Access_User.tableName));

//            html2.append("<option value=''>انتخاب</option>");//مهمانان داخل سازمان را انتخاب می کنیم
            for (int i = 0; i < usersRow.size(); i++) {
                html2.append("<option value='" + usersRow.get(i).get(Access_User._id) + "'>" + usersRow.get(i).get(Access_User._name) + " " + usersRow.get(i).get(Access_User._family) + "</option> ");
            }
            String script = "";
            script += Js.setHtml("#sessions_InviteesInSide", html2);
            script += Js.setHtml("#invitessDiv", html);
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    /**
     * ارسال پیام برای مدعوین داخل و خارج از سازمان و کاربرانی که در سیستم ثبت
     * نام نکرده اند در اکسس یوزر ثبت می شوند
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String sendComment(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            String Email = "";
            String nameAndFamily = "";
            String phone = "";
            String role = "";

            String script = "";
            String textComment = jjTools.getParameter(request, "textComment");//متن پیام
            String inviteesIdComment = jjTools.getParameter(request, "inviteesIdComment");//ای دی مدعوین 
            String inviteesOutSideIdComment = jjTools.getParameter(request, "inviteesOutSideIdComment");//ای دی مدعوین مهمان
            String inviteesInSideIdComment = jjTools.getParameter(request, "inviteesInSideIdComment");//ای دی مدعوین داخل سازمان
            String[] inviteesOutSideId = (inviteesInSideIdComment.replaceAll("#A#", "%23A%23")).split("%23A%23");

            for (int i = 0; i < inviteesOutSideId.length; i++) {
                String[] userInformation = inviteesOutSideId[i].split(",");
                nameAndFamily = userInformation[0];
                phone = userInformation[1];
                Email = userInformation[2];
                role = userInformation[3];
                Server.sendEmail("", Email, "دعوتنامه" + textComment + "", "", isPost, request);
            }

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
            String script = "";
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
            String idUpload = jjTools.getParameter(request, "upload_id");///
            String id = jjTools.getParameter(request, "id");
            String nameFile = jjTools.getParameter(request, "nameFile");//نوع فایل را نمایش میدهد یا فایل مسئول اجرا حذف می شود یا فایا مسئول پیگیری

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            List<Map<String, Object>> rowupload = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._id + "=" + idUpload));////برای دراوردن اسم فایل
            String filename = rowupload.get(0).get(UploadServlet._file_name).toString() + "%23A%23";

            if (nameFile.equals("2")) {// درقسمت تابع حذف که صدا زده می شود چون ما دونوع حذف داریممجبوریم براش عدد بگذاریم عدد یک برای حذف فایل های مربوط به مسئول پیگیری 
                String attacheFiles = row.get(0).get(_regulationFile).toString();
                System.out.println(filename);
                System.out.println("____________________________________");
                System.out.println(attacheFiles);
                attacheFiles = attacheFiles.replace(filename, "");
                System.out.println(attacheFiles);
                //عدد 2 برای حذف فایل های مسئول احرا
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(_regulationFile, attacheFiles);
                System.out.println("____________________________________");
                db.update(tableName, map, _id + "=" + id);
                script += "$('#commettes_regulationFile').val('" + attacheFiles + "');";
            }
            if (nameFile.equals("1")) {
                String attacheFiles = row.get(0).get(_documnetsFile).toString();
                System.out.println(filename);
                System.out.println("____________________________________");
                System.out.println(attacheFiles);
                attacheFiles = attacheFiles.replace(filename, "");
                System.out.println(attacheFiles);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(_documnetsFile, attacheFiles);
                System.out.println("____________________________________");
                db.update(tableName, map, _id + "=" + id);
                script += "$('#commettes_documentFile').val('" + attacheFiles + "');";
            }
            Access_User.changeStatus(request, response, db, idUpload, UploadServlet.status_deleted + " " + jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY"));
            script += " hmisCommettes.m_select(" + id + ");";
            Server.outPrinter(request, response, script);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println("#################################################");
        System.out.println("######>>>>>RUN:taskCommettesReminder###########");
        Server.Connect();
        jjDatabaseWeb db = Server.db;
        List<Map<String, Object>> rows = jjDatabaseWeb.separateRow(db.Select(tableName, _isActive + "=1 AND " + _period + " !='' "));
        System.out.println("size=" + rows.size());
        for (int i = 0; i < rows.size(); i++) {
            System.out.println("rows.get(i).get(_date).toString()=" + rows.get(i).get(_date).toString());
            jjCalendar_IR date = new jjCalendar_IR(rows.get(i).get(_date).toString());
            int period = Integer.valueOf(rows.get(i).get(_period).toString());
            int today = jjCalendar_IR.getDatabaseFormat_8length(null, true);
            while (today > date.getDBFormat_8length()) {
                date.addDay(period);
            }
            if (date.getDBFormat_8length() == today) {
                System.out.println(">>>>>>>" + today);
                System.out.println("<<<<<<<ارسال پیام برای دبیر کمیته و رئیس کمیتهSend MESSAGE()");
//                DefaultTableModel rowMassanger= db.Select(Messenger.tableName, Messenger._id + "= " + rows.get(i).get(_id) + " AND " + Messenger._dateOfCreation + "=" + today);
//                if (rowDocument.getRowCount() == 0) {// اگر قبلا ایجاد نکرده بودیم
//                    Map<String, Object> map = new HashMap<>();
//                    map.put(Documentary._dateCreation, today);
//                    map.put(Documentary._gaugeId, rows.get(i).get(_id));
//                    map.put(Documentary._responsibleLoadingRole, rows.get(i).get(_responsibleLoadingRole));
//                    map.put(Documentary._title, "بارگذاری مستندات مربوط به  سنجه ی " + rows.get(i).get(_gauge));
//                    List<Map<String, Object>> insertedRow = jjDatabaseWeb.separateRow(db.insert(Documentary.tableName, map));
//                    if (insertedRow.size() > 0) {
//                        Documentary.changeStatus(db, insertedRow.get(0).get(Documentary._id).toString(), Documentary.status_noUploaded);
//                    }
//                }
            }
        }
        System.out.println("#################################################");
    }
}
