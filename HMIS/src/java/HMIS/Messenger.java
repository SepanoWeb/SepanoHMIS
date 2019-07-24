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
import java.io.IOException;
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
 * @author شیران1 تابع نوشته شده برای پیام ها
 */
public class Messenger {

    public static String tableName = "hmis_Messenger";
    public static String _id = "id";
    public static String _title = "messenger_title";///عنوان پیام
    public static String _textMessage = "messenger_textMessage";///متن پیام
    public static String _receiver = "messenger_receiver";//گیرنده پیام
    public static String _sender = "messenger_sender";//فرستنده پیام
    public static String _postageDate = "messenger_postageDate";///تاریخ ارسال
    public static String _dateOfCreation = "messenger_dateOfCreation";///تاریخ ایجاد
    public static String _displayed = "messenger_displayed";///دیده شده
    public static String _status = "messenger_status";///وضعیت پیام
    public static String _logStatus = "messenger_logStatus";///روند وضعیت پیام
    public static String _email = "messenger_email";///ایمیل
    public static String _sendingMethod = "messenger_sendingMethod";///روش ارسال
    public static String _attachFile = "messenger_attachFile";///روش ارسال
    public static String _attachFileTitle = "messenger_attachFileTitle";///روش ارسال
    public static String _titleFile = "messenger_titleFile";///روش ارسال
    public static String _sendToSms = "messenger_sendToSms";///روش ارسال
    public static String _sendToEmail = "messenger_sendToEmail";///روش ارسال
//    public static String _statusTrend = "messenger_statusTrend";///وضعیت پیام روند

    public static String status_created = "ایجاد شده";///برای  وضعیت پیام نوشته شده است 
    public static String status_displayed = " دیده شده";
    public static String status_posted = " ارسال شده";
    public static String status_postQueue = " درصف ارسال";

    public static String lbl_insert = "ارسال پیام";
//    public static String lbl_send = "ارسال";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ثبت ویرایش";

    public static int rul_rfs_karshenas = 0;//برای اینکه تشخیص دهیم کاربر مجوز دیدن پیامهای کارشناس را دارد یا نه
    public static int rul_rfs = 0;
    public static int rul_dlt = 0;
    public static int rul_edt = 0;
    public static int rul_senEmail = 0;
    public static int rul_print = 0;
    public static int rul_ins = 0;

    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        String id = jjTools.getParameter(request, _id);
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName));

            StringBuilder html3 = new StringBuilder();

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>پیام ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisMessenger.m_add_new();' > پیام جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshMessenger' dir='rtl'><thead>");

            html.append("<th width='5%' style='text-align:center'>کد</th>");
            html.append("<th width='10%' style='text-align:center'>ارسال در</th>");

            html.append("<th width='15%' style='text-align:center'>متن پیام</th>");
            html.append("<th width='10%' style='text-align:center'>وضعیت پیام</th>");

            html.append("<th width='5%' style='text-align:center'>عملیات</th>");
//       
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            if (accDel) {
                html.append("<th style='text-align:center' width='5%'>حذف</th>");
            }
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
//                String dideshode = row.get(i).get(_displayed).toString().equals("10000000") ? "dideNashode" : "";
                //اگر دیده شده خالی بود سطر بلد شودکلاس دیده نشده صدا زده شود در پابلیک استایل سی اس اس در غیر این صورت نال شود

                html.append("<tr class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>");
                html.append("<td style='text-align:center' class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "' >" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td style='text-align:center' class='c'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_postageDate)) + "</td>");

                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_textMessage).toString()) + "</td>");
                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
//                html.append("<td style='text-align:center' class='r'>" + (GirandeRow.get(0).get(Access_User._name).toString()) + " " + (GirandeRow.get(0).get(Access_User._family).toString()) + "</td>");

                html.append("<td class='' style='text-align: center;' onclick='hmisMessenger.m_select(" + row.get(i).get(_id) + ");'><img src='imgfeyz/contract.png' style='height:30px;margin:auto'/></td>");
                if (accDel) {
                    if (row.get(i).get(_status).toString().equals(status_displayed)) {
                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMessenger.alert()' ><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
//                    return Js.modal("امکان حذف برای شما وجود ندارد", "پیام سامانه");

                    } else {

                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMessenger.m_delete(" + row.get(i).get(_id) + ");'><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
                    }
                }
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swMessengerTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshMessenger", height, 0, "", "لیست پیام ها");
            Server.outPrinter(request, response, html2);
            return "";
//       

        } catch (Exception e) {

            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String refreshMyMessages(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
//        String id = jjTools.getParameter(request, _id);
        try {
            int id = jjTools.getSeassionUserId(request);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Messenger.tableName, _receiver + "=" + id));

            StringBuilder html3 = new StringBuilder();

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>پیام های من</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    //                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisMessenger.m_add_new();' > پیام جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshMyMessages' dir='rtl'><thead>");

            html.append("<th width='5%' style='text-align:center'>کد</th>");
            html.append("<th width='10%' style='text-align:center'>ارسال در</th>");

            html.append("<th width='15%' style='text-align:center'>متن پیام</th>");
            html.append("<th width='15%' style='text-align:center'>وضعیت پیام</th>");

            html.append("<th width='5%' style='text-align:center'>عملیات</th>");
//       
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            if (accDel) {
                html.append("<th style='text-align:center' width='5%'>حذف</th>");
            }
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
//                String dideshode = row.get(i).get(_displayed).toString().equals("10000000") ? "dideNashode" : "";
                //اگر دیده شده خالی بود سطر بلد شودکلاس دیده نشده صدا زده شود در پابلیک استایل سی اس اس در غیر این صورت نال شود

                html.append("<tr class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>");
                html.append("<td style='text-align:center' class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td style='text-align:center' class='c'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_postageDate)) + "</td>");

                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_textMessage).toString()) + "</td>");
                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
//                html.append("<td style='text-align:center' class='r'>" + (GirandeRow.get(0).get(Access_User._name).toString()) + " " + (GirandeRow.get(0).get(Access_User._family).toString()) + "</td>");

                html.append("<td class='' style='text-align: center;' onclick='hmisMyMessages.m_select(" + row.get(i).get(_id) + ");'><img src='imgfeyz/contract.png' style='height:30px;margin:auto'/></td>");
                if (accDel) {
                    if (row.get(i).get(_status).toString().equals(status_displayed)) {
                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMessenger.alert()' ><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
//                    return Js.modal("امکان حذف برای شما وجود ندارد", "پیام سامانه");

                    } else {
                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMyMessages.m_delete(" + row.get(i).get(_id) + ");'><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
                    }
                }
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swMyMessagesTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshMyMessages", height, 0, "", "لیست پیام های من");
            Server.outPrinter(request, response, html2);
            return "";
//       

        } catch (Exception e) {

            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String refreshMessages(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
//        String id = jjTools.getParameter(request, _id);
        try {
            int id = jjTools.getSeassionUserId(request);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();

            List<Map<String, Object>> row = jjDatabase.separateRow(db.otherSelect("SELECT * FROM messenger ORDER BY messenger.id DESC  LIMIT 500"));

            StringBuilder html3 = new StringBuilder();

            html.append(" <div id='AllMessenger' ></div><div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>500 پیام اخیر</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisMessages.m_refreshMessagesAll();' > کل پیام ها</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshMessages' dir='rtl'><thead>");

            html.append("<th width='5%' style='text-align:center'>کد</th>");
            html.append("<th width='10%' style='text-align:center'>ارسال در</th>");

            html.append("<th width='15%' style='text-align:center'>متن پیام</th>");
            html.append("<th width='15%' style='text-align:center'>وضعیت پیام</th>");

            html.append("<th width='5%' style='text-align:center'>عملیات</th>");
//       
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            if (accDel) {
                html.append("<th style='text-align:center' width='5%'>حذف</th>");
            }
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
//                String dideshode = row.get(i).get(_displayed).toString().equals("10000000") ? "dideNashode" : "";
                //اگر دیده شده خالی بود سطر بلد شودکلاس دیده نشده صدا زده شود در پابلیک استایل سی اس اس در غیر این صورت نال شود

                html.append("<tr class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>");
                html.append("<td style='text-align:center' class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td style='text-align:center' class='c'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_postageDate)) + "</td>");

                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_textMessage).toString()) + "</td>");
                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
//                html.append("<td style='text-align:center' class='r'>" + (GirandeRow.get(0).get(Access_User._name).toString()) + " " + (GirandeRow.get(0).get(Access_User._family).toString()) + "</td>");

                html.append("<td class='' style='text-align: center;' onclick='hmisMessages.m_select(" + row.get(i).get(_id) + ");'><img src='imgfeyz/contract.png' style='height:30px;margin:auto'/></td>");
                if (accDel) {
                    if (row.get(i).get(_status).toString().equals(status_displayed)) {
                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMessenger.alert()' ><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
//                    return Js.modal("امکان حذف برای شما وجود ندارد", "پیام سامانه");

                    } else {
                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMessages.m_delete(" + row.get(i).get(_id) + ");'><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
                    }
                }
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swMessagesTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshMessages", height, 0, "", "لیست پیام های اخیر");
            Server.outPrinter(request, response, html2);
            return "";
//       

        } catch (Exception e) {

            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String refreshMessagesAll(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
//        String id = jjTools.getParameter(request, _id);
        try {
            int id = jjTools.getSeassionUserId(request);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Messenger.tableName));

            StringBuilder html3 = new StringBuilder();

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>کل پیام ها</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    //                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisMessages.m_refreshMessagesAll();' > کل پیام ها</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshMessagesAll' dir='rtl'><thead>");

            html.append("<th width='5%' style='text-align:center'>کد</th>");
            html.append("<th width='10%' style='text-align:center'>ارسال در</th>");

            html.append("<th width='15%' style='text-align:center'>متن پیام</th>");
            html.append("<th width='15%' style='text-align:center'>وضعیت پیام</th>");

            html.append("<th width='5%' style='text-align:center'>عملیات</th>");
//       
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            if (accDel) {
                html.append("<th style='text-align:center' width='5%'>حذف</th>");
            }
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
//                String dideshode = row.get(i).get(_displayed).toString().equals("10000000") ? "dideNashode" : "";
                //اگر دیده شده خالی بود سطر بلد شودکلاس دیده نشده صدا زده شود در پابلیک استایل سی اس اس در غیر این صورت نال شود

                html.append("<tr class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>");
                html.append("<td style='text-align:center' class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td style='text-align:center' class='c'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_postageDate)) + "</td>");

                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_textMessage).toString()) + "</td>");
                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
//                html.append("<td style='text-align:center' class='r'>" + (GirandeRow.get(0).get(Access_User._name).toString()) + " " + (GirandeRow.get(0).get(Access_User._family).toString()) + "</td>");

                html.append("<td class='' style='text-align: center;' onclick='hmisMessages.m_select(" + row.get(i).get(_id) + ");'><img src='imgfeyz/contract.png' style='height:30px;margin:auto'/></td>");
                if (accDel) {
                    if (row.get(i).get(_status).toString().equals(status_displayed)) {
                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMessenger.alert()' ><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
//                    return Js.modal("امکان حذف برای شما وجود ندارد", "پیام سامانه");

                    } else {
                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMessages.m_delete(" + row.get(i).get(_id) + ");'><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
                    }
                }
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swMessagesTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshMessages", height, 0, "", "لیست پیام های اخیر");
            Server.outPrinter(request, response, html2);
//            StringBuilder html2=new StringBuilder();
//             html2.append(Js.setHtml("#AllMessenger", html.toString()));
//               
//            html2.append( Js.table("#refreshMessagesAll", "200", 0, "", "لیست کل پیام ها"));
//            Server.outPrinter(request, response, html2);
            return "";
//       

        } catch (Exception e) {

            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String refreshMessagesSeen(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
//        String id = jjTools.getParameter(request, _id);
        try {
            int id = jjTools.getSeassionUserId(request);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Messenger.tableName, _status + "='" + status_displayed + "'"));

            StringBuilder html3 = new StringBuilder();

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>پیام های دیده شده</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    //                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisMessenger.m_add_new();' > پیام جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshMessagesSeen' dir='rtl'><thead>");

            html.append("<th width='5%' style='text-align:center'>کد</th>");
            html.append("<th width='10%' style='text-align:center'>ارسال در</th>");

            html.append("<th width='15%' style='text-align:center'>متن پیام</th>");
            html.append("<th width='15%' style='text-align:center'>وضعیت پیام</th>");

            html.append("<th width='5%' style='text-align:center'>عملیات</th>");
//       
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            if (accDel) {
                html.append("<th style='text-align:center' width='5%'>حذف</th>");
            }
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
//                String dideshode = row.get(i).get(_displayed).toString().equals("10000000") ? "dideNashode" : "";
                //اگر دیده شده خالی بود سطر بلد شودکلاس دیده نشده صدا زده شود در پابلیک استایل سی اس اس در غیر این صورت نال شود

                html.append("<tr class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>");
                html.append("<td style='text-align:center' class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td style='text-align:center' class='c'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_postageDate)) + "</td>");

                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_textMessage).toString()) + "</td>");
                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
//                html.append("<td style='text-align:center' class='r'>" + (GirandeRow.get(0).get(Access_User._name).toString()) + " " + (GirandeRow.get(0).get(Access_User._family).toString()) + "</td>");

                html.append("<td class='' style='text-align: center;' onclick='hmisMessagesSeen.m_select(" + row.get(i).get(_id) + ");'><img src='imgfeyz/contract.png' style='height:30px;margin:auto'/></td>");
                if (accDel) {
                    if (row.get(i).get(_status).toString().equals(status_displayed)) {
                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMessenger.alert()' ><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
//                    return Js.modal("امکان حذف برای شما وجود ندارد", "پیام سامانه");

                    } else {
                        html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisMessagesSeen.m_delete(" + row.get(i).get(_id) + ");'><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
                    }
                }

                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swMessagesSeenTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshMessagesSeen", height, 0, "", "لیست پیام های دیده شده");
            Server.outPrinter(request, response, html2);
            return "";
//       

        } catch (Exception e) {

            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }

    public static String refreshUnreadMessages(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
//        String id = jjTools.getParameter(request, _id);
        try {
            int id = jjTools.getSeassionUserId(request);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
            StringBuilder html = new StringBuilder();

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(Messenger.tableName, _status + "='" + status_created + "'"));

            StringBuilder html3 = new StringBuilder();

            html.append(" <div class='card bd-primary mg-t-20'>"
                    + "    <div class='card-header bg-primary tx-white'>پیام های خوانده نشده</div>"
                    + "    <div class='card-body pd-sm-30'>"
                    + "        <p class='mg-b-20 mg-sm-b-30'>"
                    //                    + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='hmisMessenger.m_add_new();' > پیام جدید</a>"
                    + "        </p>");

            html.append("<table class='table display responsive nowrap' id='refreshUnreadMessages' dir='rtl'><thead>");

            html.append("<th width='5%' style='text-align:center'>کد</th>");
            html.append("<th width='10%' style='text-align:center'>ارسال در</th>");

            html.append("<th width='15%' style='text-align:center'>متن پیام</th>");
            html.append("<th width='15%' style='text-align:center'>وضعیت پیام</th>");

            html.append("<th width='5%' style='text-align:center'>عملیات</th>");
//       
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            if (accDel) {
                html.append("<th style='text-align:center' width='5%'>حذف</th>");
            }
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
//                String dideshode = row.get(i).get(_displayed).toString().equals("10000000") ? "dideNashode" : "";
                //اگر دیده شده خالی بود سطر بلد شودکلاس دیده نشده صدا زده شود در پابلیک استایل سی اس اس در غیر این صورت نال شود

                html.append("<tr class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>");
                html.append("<td style='text-align:center' class='mousePointer" + " " + getClassCssForStatus((row.get(i).get(_status).toString())) + "'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td style='text-align:center' class='c'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_postageDate)) + "</td>");

                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_textMessage).toString()) + "</td>");
                html.append("<td style='text-align:center' class='r'>" + (row.get(i).get(_status).toString()) + "</td>");
//                html.append("<td style='text-align:center' class='r'>" + (GirandeRow.get(0).get(Access_User._name).toString()) + " " + (GirandeRow.get(0).get(Access_User._family).toString()) + "</td>");

                html.append("<td class='' style='text-align: center;' onclick='hmisUnreadMessages.m_select(" + row.get(i).get(_id) + ");'><img src='imgfeyz/contract.png' style='height:30px;margin:auto'/></td>");
//               
                if (accDel) {
                    html.append("<td class='c mousePointer' style='text-align: center;' onclick='hmisUnreadMessages.m_delete(" + row.get(i).get(_id) + ");'><img src='imgfeyz/delet.png' style='height:30px;margin:auto'/></td>");
                }
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swUnreadMessagesTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshUnreadMessages", height, 0, "", "لیست پیام های خوانده نشده");
            Server.outPrinter(request, response, html2);
            return "";
//       

        } catch (Exception e) {

            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";
        }
    }
    /*
     این تابع برای اضافه کردن روش ارسال نوشته شده
     */

    public static String sendMetod1(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            String script6 = "<div >روش ارسال<input  type='checkbox' id='messenger_sendToEmail' name='messenger_sendToEmail'  value='1'  class='form-control'/>ایمیل"
                    + "<input type='checkbox' id='messenger_sendToSms' name='messenger_sendToSms'  value='1'   class='form-control'  />sms</div>";
            html.append(Js.setHtml("#sendingMetod1", script6));

            Server.outPrinter(request, response, html);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }
    /*
     این تابع برای اضافه کردن روش2 ارسال نوشته شده
     */
//    public static String sendMetod2(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
//           try {
//               StringBuilder html=new StringBuilder();
//                String script6 = "<div   >روش ارسال<input  type='checkbox' id='messenger_sendToEmail' name='messenger_sendToEmail'  value='1'  class='form-control'/>ایمیل"
//                    + "<input type='checkbox' id='messenger_sendToSms' name='messenger_sendToSms'  value='1'   class='form-control'  />sms</div>";
//            html.append(Js.setHtml("#sendingMetod2", script6));
//               
//           Server.outPrinter(request, response,html);
//            return "";}
//           catch (Exception e) {
//            Server.outPrinter(request, response, Server.ErrorHandler(e));
//            return "";
//
//        }
//    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        StringBuilder html = new StringBuilder();
        StringBuilder html2 = new StringBuilder();
        StringBuilder script = new StringBuilder();
        StringBuilder script2 = new StringBuilder();
//        String id = jjTools.getSessionAttribute(request, "#ID");

        try {
            script.append(Js.setVal("#" + _sender, jjTools.getSeassionUserNameAndFamily(request)));
            script.append("$('#messenger_receiver').select2();\n");
//            script.append("hmisMessenger.send();");

            boolean accIns = Access_User.hasAccess(request, db, rul_ins);

            if (accIns) {//@ToDo 
                script.append(Js.setHtml("#Messenger_button", "<div class='col-lg-6'><input type='button' id='insert_Messenger_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success active btn-block mg-b-10'></div>"));
                script.append(Js.click("#insert_Messenger_new", Js.jjMessenger.insert()));
            } else {
                script.append(Js.setHtml("#Messenger_button", ""));
            }
            boolean accEmail = Access_User.hasAccess(request, db, rul_ins);
            boolean accSms = Access_User.hasAccess(request, db, rul_ins);
            String html3 = "<div >روش ارسال";
            if (accEmail) {//@ToDo 
                html3 += "<input  type='checkbox' id='messenger_sendToEmail' name='messenger_sendToEmail'  value='1'  class='form-control'/>ایمیل";

//                script.append(Js.click("#insert_Messenger_new", Js.jjMessenger.insert()));
            }

            if (accSms) {//@ToDo 
                html3 += "<input type='checkbox' id='messenger_sendToSms' name='messenger_sendToSms'  value='1'   class='form-control'  />sms";
            }
            html3 += "</div>";
            script2.append(Js.setHtml("#sendingMetod", html3));
//                html.append(Js.setHtml("#Messenger_button", "<div class='row'><div class='col-lg-6'><input type='button' id='insert_Messenger_new'  value=\"" + lbl_insert + "\" class='tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget'></div></div>"));
//                html.append(Js.buttonMouseClick("#insert_Messenger_new", Js.jjMessenger.insert()));
//            }
//            changeStatus(request, response, db, id, status_created);
            Server.outPrinter(request, response, html.toString() + script + html2 + script2);
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

    ////این تابع برای نمایش اسم کاربران در پیام ها 
//    selectoption گیرنده
    public static String selectOptionUser(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            String html4 = "<option id='selectUser' style='color:black' value=''>گیرنده مورد نظر را انتخاب کنید</option>";
            Document doc = Jsoup.parse(html4);

            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));

            for (int i = 0; i < UserRow.size(); i++) {
//              

                String optionHtml = "<option id='selectUser" + UserRow.get(i).get(_id) + "'  value='" + UserRow.get(i).get(_id) + "'>"
                        + UserRow.get(i).get(Access_User._name)
                        + " "
                        + UserRow.get(i).get(Access_User._family)
                        + "</option>";
                doc.getElementById("selectUser").append(optionHtml);
            }

            if (panel == "") {
                panel = "messenger_receiver";
            }
            script += Js.setHtml("#" + panel, doc.getElementsByTag("body").toString());
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }

    }
    /*
     selectOptionUserUnreadMessages
     این تابع برای دراوردن گیرنده ها وانتخاب انها به صورت سلکت آپشن برای پیام های خوانده نشده نوشته شده
     */

    public static String selectOptionUserUnreadMessages(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            String html4 = "<option id='selectUser' style='color:black' value=''>گیرنده مورد نظر را انتخاب کنید</option>";
            Document doc = Jsoup.parse(html4);

            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));

            for (int i = 0; i < UserRow.size(); i++) {
//              

                String optionHtml = "<option id='selectUser" + UserRow.get(i).get(_id) + "'  value='" + UserRow.get(i).get(_id) + "'>"
                        + UserRow.get(i).get(Access_User._name)
                        + " "
                        + UserRow.get(i).get(Access_User._family)
                        + "</option>";
                doc.getElementById("selectUser").append(optionHtml);
            }

            if (panel == "") {
                panel = "unreadMessages_receiver";
            }
            script += Js.setHtml("#" + panel, doc.getElementsByTag("body").toString());
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }

    }
    /*
     selectOptionUserMyMessages
     این تابع برای دراوردن گیرنده ها وانتخاب انها به صورت سلکت آپشن برای پیام های من نوشته شده
     */

    public static String selectOptionUserMyMessages(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            String html4 = "<option id='selectUser' style='color:black' value=''>گیرنده مورد نظر را انتخاب کنید</option>";
            Document doc = Jsoup.parse(html4);

            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));

            for (int i = 0; i < UserRow.size(); i++) {
//              

                String optionHtml = "<option id='selectUser" + UserRow.get(i).get(_id) + "'  value='" + UserRow.get(i).get(_id) + "'>"
                        + UserRow.get(i).get(Access_User._name)
                        + " "
                        + UserRow.get(i).get(Access_User._family)
                        + "</option>";
                doc.getElementById("selectUser").append(optionHtml);
            }

            if (panel == "") {
                panel = "myMessages_receiver";
            }
            script += Js.setHtml("#" + panel, doc.getElementsByTag("body").toString());
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }

    }
    /*
     selectOptionUserMyMessages
     این تابع برای دراوردن گیرنده ها وانتخاب انها به صورت سلکت آپشن برای پیام های دیده شده نوشته شده
     */

    public static String selectOptionUserMessagesSeen(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            String html4 = "<option id='selectUser' style='color:black' value=''>گیرنده مورد نظر را انتخاب کنید</option>";
            Document doc = Jsoup.parse(html4);

            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));

            for (int i = 0; i < UserRow.size(); i++) {
//              

                String optionHtml = "<option id='selectUser" + UserRow.get(i).get(_id) + "'  value='" + UserRow.get(i).get(_id) + "'>"
                        + UserRow.get(i).get(Access_User._name)
                        + " "
                        + UserRow.get(i).get(Access_User._family)
                        + "</option>";
                doc.getElementById("selectUser").append(optionHtml);
            }

            if (panel == "") {
                panel = "messagesSeen_receiver";
            }
            script += Js.setHtml("#" + panel, doc.getElementsByTag("body").toString());
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }

    }
    /*
     selectOptionUserMyMessages
     این تابع برای دراوردن گیرنده ها وانتخاب انها به صورت سلکت آپشن برای پیام ها نوشته شده
     */

    public static String selectOptionUserMessages(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }

            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String script = "";
            String panel = jjTools.getParameter(request, "panel");
            String html4 = "<option id='selectUser' style='color:black' value=''>گیرنده مورد نظر را انتخاب کنید</option>";
            Document doc = Jsoup.parse(html4);

            List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName));

            for (int i = 0; i < UserRow.size(); i++) {
//              

                String optionHtml = "<option id='selectUser" + UserRow.get(i).get(_id) + "'  value='" + UserRow.get(i).get(_id) + "'>"
                        + UserRow.get(i).get(Access_User._name)
                        + " "
                        + UserRow.get(i).get(Access_User._family)
                        + "</option>";
                doc.getElementById("selectUser").append(optionHtml);
            }

            if (panel == "") {
                panel = "messages_receiver";
            }
            script += Js.setHtml("#" + panel, doc.getElementsByTag("body").toString());
            Server.outPrinter(request, response, script);
            return "";

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }

    }

    /**
     * تابع درج date 1397/12/19 shiran1
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
                Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
                return "";
            }
//            String id = jjTools.getParameter(request, _id);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_sender, jjTools.getSessionAttribute(request, "#ID"));
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_textMessage, jjTools.getParameter(request, _textMessage));
            map.put(_dateOfCreation, jjTools.getParameter(request, _dateOfCreation));
            map.put(_attachFileTitle, jjTools.getParameter(request, _attachFileTitle));
            map.put(_attachFile, jjTools.getParameter(request, _attachFile));
            map.put(_titleFile, jjTools.getParameter(request, _titleFile));
            map.put(_sendingMethod, jjTools.getParameter(request, _sendingMethod));
            map.put(_sendToSms, jjTools.getParameter(request, _sendToSms));
            map.put(_sendToEmail, jjTools.getParameter(request, _sendToEmail));

            map.put(_displayed, jjTools.getParameter(request, _displayed));

            map.put(_receiver, jjTools.getParameter(request, _receiver));

            if ((jjTools.getParameter(request, _postageDate)).equals("")) {

                map.put(_postageDate, jjCalendar_IR.getDatabaseFormat_8length("", true));
                List<Map<String, Object>> insertedRow = jjDatabase.separateRow(db.insert(tableName, map));
                changeStatus(request, response, db, insertedRow.get(0).get(_id).toString(), status_created);
            } else {
                int date = Integer.valueOf(jjTools.getParameter(request, _postageDate).replace("/", ""));

                if (date == jjCalendar_IR.getDatabaseFormat_8length("", true)) {
                    map.put(_postageDate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _postageDate), false));
                    List<Map<String, Object>> insertedRow = jjDatabase.separateRow(db.insert(tableName, map));
                    changeStatus(request, response, db, insertedRow.get(0).get(_id).toString(), status_created);
                    changeStatus(request, response, db, insertedRow.get(0).get(_id).toString(), status_posted);
                    if (insertedRow.isEmpty()) {
                        String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                        if (jjTools.isLangEn(request)) {
                            errorMessage = "Edit Fail;";
                        }

                        Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                        return "";
                    }
                }
                if (date > jjCalendar_IR.getDatabaseFormat_8length("", true)) {
                    map.put(_postageDate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _postageDate), false));
                    List<Map<String, Object>> insertedRow = jjDatabase.separateRow(db.insert(tableName, map));
                    changeStatus(request, response, db, insertedRow.get(0).get(_id).toString(), status_created);
                    changeStatus(request, response, db, insertedRow.get(0).get(_id).toString(), status_postQueue);
                    if (insertedRow.isEmpty()) {
                        String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                        if (jjTools.isLangEn(request)) {
                            errorMessage = "Edit Fail;";
                        }

                        Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                        return "";
                    }
                }
                if (date < jjCalendar_IR.getDatabaseFormat_8length("", true)) {
                    map.put(_postageDate, jjTools.getParameter(request, _postageDate));
                    String errorMessage = "عملیات درج صورت نگرفته است  تاریخ وارد شده صحیح نمی باشد";
                    Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                    return "";

                }
            }

            Server.outPrinter(request, response, Js.jjMessenger.refresh());
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
            int iduser = jjTools.getSeassionUserId(request);
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
                return "";

            }
            StringBuilder script = new StringBuilder();
            StringBuilder script1 = new StringBuilder();
            String script2 = "";

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder html4 = new StringBuilder();
            StringBuilder script6 = new StringBuilder();
            String script3 = "";
            String html5 = "";
            script.append(Js.setVal("#messenger_" + _id, row.get(0).get(_id)));

            script.append(Js.setVal("#" + _title, row.get(0).get(_title)));
            script.append(Js.setVal("#" + _textMessage, row.get(0).get(_textMessage)));

//        
            String receiver = row.get(0).get(_receiver).toString();

            String[] receiverArray = receiver.split(",");//آی دی  ها با این رشته از هم جدا می شود
            String temp = "";
            for (int j = 0; j < receiverArray.length; j++) {
                temp += "'" + receiverArray[j] + "',";
                System.out.println("receiverArray=" + temp);
            }

            script.append("$('#messenger_receiver').val([" + temp + "]);"
                    + "$('#messenger_receiver').select2({  minimumResultsForSearch: '',  width: '100%'});");

//            
            script.append(Js.setVal("#" + _status, row.get(0).get(_status)));
            String ravand = row.get(0).get(_logStatus).toString();
            ravand = ravand.replace("%23A%23", "\\n");
            System.out.println(ravand.replace("%23A%23", "\\n"));
            script.append(Js.setVal("#" + _logStatus, ravand));

            script.append(Js.setVal("#" + _sender, jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY")));
            script.append(Js.setVal("#" + _dateOfCreation, row.get(0).get(_dateOfCreation)));
            script.append(Js.setVal("#" + _postageDate, jjCalendar_IR.getViewFormat(row.get(0).get(_postageDate))));
            script.append(Js.setVal("#messenger_attachFile", row.get(0).get(_attachFile)));
            script.append(Js.setVal("#messenger_attachFileTitle", row.get(0).get(_attachFileTitle)));
            String attachFiles = row.get(0).get(_attachFile).toString();
//            script.append("hmisMessenger.send();");
            String attachFileTitles = row.get(0).get(_attachFileTitle).toString();

            String[] attachFilesArray = attachFiles.split("%23A%23");
            String[] attachFileTitlesArray = attachFileTitles.split("%23A%23");

            for (int l = 0; l < attachFilesArray.length && l < attachFileTitlesArray.length; l++) {
                List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + attachFilesArray[l] + "'"));
                List<Map<String, Object>> titleRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._title + "='" + attachFileTitlesArray[l] + "'"));
                if (!fileRow.isEmpty()) {
                    String idUpload = fileRow.get(0).get(UploadServlet._id).toString();
                    String titleUpload = fileRow.get(0).get(UploadServlet._title).toString();
                    String extension2 = attachFilesArray[l].substring(attachFilesArray[l].lastIndexOf(".") + 1, attachFilesArray[l].length());
                    if (extension2.toLowerCase().equals("jpg")
                            || extension2.toLowerCase().equals("png")
                            || extension2.toLowerCase().equals("gif")
                            || extension2.toLowerCase().equals("svg")) {
                        if (titleUpload.equals("")) {
                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button class='col-lg-1 form-control'  style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>" + "حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        } else {

                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        }
                    } else {
                        html2.append("<input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                    }
                }
            }

            script2 += Js.setHtml(".inputAfterSelectManager", html2);

//            String script6 = "<div   id='MetodSend'>روش ارسال<input  type='checkbox' id='messenger_sendingMethod1' name='messenger_sendingMethod'  value='1'  class='form-control'/>ایمیل"
//                    + "<input type='checkbox' id='messenger_sendingMethod2' name='messenger_sendingMethod'  value='0'   class='form-control'  />sms</div>";
//            html4.append(Js.setHtml("#sendingMetod", script6));
//             html.append(Js.setVal("#messenger_sendingMethod1", "1"));
//            html.append(Js.setVal("#messenger_sendingMethod2", "0"));
//            html.append(Js.setVal("#role_condition"  , ));
//            String metod = row.get(0).get(_sendingMethod).toString();
//
//            String[] metodArray = metod.split(",");//آی دی  ها با این رشته از هم جدا می شود
//            String tempMetod = "";
//            for (int n = 0; n < metodArray.length; n++) {
//                tempMetod += "'" + metodArray[n] + "',";
//                System.out.println("metodArray=" + tempMetod);
////            script.append(Js.setVal("#" + _sendingMethod, metodArray[n]));
//            }
            if ((row.get(0).get(_receiver).equals(jjTools.getSessionAttribute(request, "#ID")) && (!row.get(0).get(_status).equals(status_displayed)))) {

                changeStatus(request, response, db, id, status_displayed);

            }
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);

            String htmlBottons = "";
            String receivr = row.get(0).get(Messenger._receiver).toString();

            String[] receivrArray = receivr.split(",");
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);

//             for (int h = 0; h < receivrArray.length ;h++){
            if (row.get(0).get(Messenger._sender).equals(jjTools.getSessionAttribute(request, "#ID"))) {
                if (accEdit) {
                    htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjMessenger.edit() + "' id='edit_Messenger'>" + lbl_edit + "</button></div>";
//               
                }
                boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
                if (accDelete) {
                    htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjMessenger.delete(id) + "' id='delete_Messenger'>" + lbl_delete + "</button></div>";
                }
                script1.append(Js.setHtml("#Messenger_button", htmlBottons));
            } else {
                if (accEdit) {
//                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjMessenger.edit() + "' id='edit_Messenger'>" + lbl_edit + "</button></div>";
//               
                }
                boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
                if (accDelete) {
//                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjMessenger.delete(id) + "' id='delete_Messenger'>" + lbl_delete + "</button></div>";
                }
                script1.append(Js.setHtml("#Messenger_button", htmlBottons));
            }
            boolean accEmail = Access_User.hasAccess(request, db, rul_ins);
            String metod = row.get(0).get(_sendingMethod).toString();
//
            String[] metodArray = metod.split(",");//آی دی  ها با این رشته از هم جدا می شود
            String tempMetod = "";

            if (row.get(0).get(_status).equals(status_posted)) {
                    for (int n = 0; n < metodArray.length; n++) {
                if (metodArray[n].equals("email")) {
                        tempMetod += "'" + metodArray[n] + "',";
                        System.out.println("metodArray=" + tempMetod);
                        html.append(Js.setVal("#", metodArray[n]));

//              
                    
                    if (metodArray[n].equals("sms")) {
                        html.append(Js.setVal("#" + _sendingMethod, metodArray[n]));
//                html.append(Js.setAttr("#sendToSms", "checked", "checked"));
                    }
                    }
                }
            } else {

                boolean accSms = Access_User.hasAccess(request, db, rul_ins);
                html5 += "<div >روش ارسال";
                if (accEmail) {//@ToDo 

                    html5 += "<input  type='checkbox' id='messenger_sendToEmail' name='messenger_sendingMethod'  value='email'  class='form-control'/>ایمیل";

//                script.append(Js.click("#insert_Messenger_new", Js.jjMessenger.insert()));
                }

                if (accSms) {//@ToDo 

                    html5 += "<input type='checkbox' id='messenger_sendToSms' name='messenger_sendingMethod'  value='sms'   class='form-control'  />sms";
                }
                html5 += "</div>";
                script6.append(Js.setHtml("#sendingMetod", html5));
            }

            Server.outPrinter(request, response, html.toString() + script + script1 + script3 + script2 + html4 + script6);
            return "";
        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }
    /*
     selectپیام های من
     این تابع برای select پیام های خوانده نشده نوشته شده است
     */

    public static String selectUnreadMessages(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
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
            StringBuilder script1 = new StringBuilder();
            StringBuilder script6 = new StringBuilder();
            String script2 = "";

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String script3 = "";
            script.append(Js.setVal("#unreadMessages_" + _id, row.get(0).get(_id)));

            script.append(Js.setVal("#unreadMessages_title", row.get(0).get(_title)));
            script.append(Js.setVal("#unreadMessages_textMessage", row.get(0).get(_textMessage)));
//        
            String receiver = row.get(0).get(_receiver).toString();

            String[] receiverArray = receiver.split(",");//آی دی  ها با این رشته از هم جدا می شود
            String temp = "";
            for (int j = 0; j < receiverArray.length; j++) {
                temp += "'" + receiverArray[j] + "',";
                System.out.println("receiverArray=" + temp);
            }

            script.append("$('#unreadMessages_receiver').val([" + temp + "]);"
                    + "$('#unreadMessages_receiver').select2({  minimumResultsForSearch: '',  width: '100%'});");

//            
            script.append(Js.setVal("#unreadMessages_status", row.get(0).get(_status)));
            String ravand = row.get(0).get(_logStatus).toString();
            ravand = ravand.replace("%23A%23", "\\n");
            System.out.println(ravand.replace("%23A%23", "\\n"));
            script.append(Js.setVal("#unreadMessages_logStatus", ravand));

            script.append(Js.setVal("#unreadMessages_sender", jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY")));
            script.append(Js.setVal("#unreadMessages_dateOfCreation", row.get(0).get(_dateOfCreation)));
            script.append(Js.setVal("#unreadMessages_postageDate", jjCalendar_IR.getViewFormat(row.get(0).get(_postageDate))));
            script.append(Js.setVal("#unreadMessages_attachFile", row.get(0).get(_attachFile)));
            script.append(Js.setVal("#unreadMessages_attachFileTitle", row.get(0).get(_attachFileTitle)));
            String attachFiles = row.get(0).get(_attachFile).toString();

            String attachFileTitles = row.get(0).get(_attachFileTitle).toString();

            String[] attachFilesArray = attachFiles.split("%23A%23");
            String[] attachFileTitlesArray = attachFileTitles.split("%23A%23");

            for (int l = 0; l < attachFilesArray.length && l < attachFileTitlesArray.length; l++) {
                List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + attachFilesArray[l] + "'"));
                List<Map<String, Object>> titleRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._title + "='" + attachFileTitlesArray[l] + "'"));
                if (!fileRow.isEmpty()) {
                    String idUpload = fileRow.get(0).get(UploadServlet._id).toString();
                    String titleUpload = fileRow.get(0).get(UploadServlet._title).toString();
                    String extension2 = attachFilesArray[l].substring(attachFilesArray[l].lastIndexOf(".") + 1, attachFilesArray[l].length());
                    if (extension2.toLowerCase().equals("jpg")
                            || extension2.toLowerCase().equals("png")
                            || extension2.toLowerCase().equals("gif")
                            || extension2.toLowerCase().equals("svg")) {
                        if (titleUpload.equals("")) {
                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button class='col-lg-1 form-control'  style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>" + "حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        } else {

                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        }
                    } else {
                        html2.append("<input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                    }
                }
            }

            script2 += Js.setHtml(".inputAfterSelectManager", html2);

            if ((row.get(0).get(_receiver).equals(jjTools.getSessionAttribute(request, "#ID")) && (!row.get(0).get(_status).equals(status_displayed)))) {

                changeStatus(request, response, db, id, status_displayed);

            }
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);

            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjMessenger.editUnread() + "' id='edit_Messenger'>" + lbl_edit + "</button></div>";
//               
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjMessenger.deleteUnread(id) + "' id='delete_Messenger'>" + lbl_delete + "</button></div>";
            }
            script1.append(Js.setHtml("#UnreadMessages_button", htmlBottons));
            boolean accEmail = Access_User.hasAccess(request, db, rul_ins);
            if (row.get(0).get(_status).equals(status_posted)) {
                if (row.get(0).get(_sendToSms).equals("1")) {
                    html.append("$('#SmsAndEmail').show();");
//              
                    html.append(Js.setAttr("#sendToEmail", "checked", "checked"));
                }
                if (row.get(0).get(_sendToEmail).equals("1")) {
                    html.append("$('#SmsAndEmail').show();");
                    html.append(Js.setAttr("#sendToSms", "checked", "checked"));
                }
            } else {

                boolean accSms = Access_User.hasAccess(request, db, rul_ins);
                String html5 = "<div >روش ارسال";
                if (accEmail) {//@ToDo 
                    html5 += "<input  type='checkbox' id='messenger_sendToEmail' name='messenger_sendToEmail'  value='1'  class='form-control'/>ایمیل";

//                script.append(Js.click("#insert_Messenger_new", Js.jjMessenger.insert()));
                }

                if (accSms) {//@ToDo 
                    html5 += "<input type='checkbox' id='messenger_sendToSms' name='messenger_sendToSms'  value='1'   class='form-control'  />sms";
                }
                html5 += "</div>";
                script6.append(Js.setHtml("#sendingMetod", html5));
            }

            Server.outPrinter(request, response, html.toString() + script + script1 + script3 + script2 + script6);
            return "";

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }
    /*
     selectپیام های من
     این تابع برای select پیام های من نوشته شده است
     */

    public static String selectMyMessages(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
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
            StringBuilder script1 = new StringBuilder();
            StringBuilder script6 = new StringBuilder();
            String script2 = "";
            String html5 = "";

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String script3 = "";
            script.append(Js.setVal("#myMessages_" + _id, row.get(0).get(_id)));

            script.append(Js.setVal("#myMessages_title", row.get(0).get(_title)));
            script.append(Js.setVal("#myMessages_textMessage", row.get(0).get(_textMessage)));
//        
            String receiver = row.get(0).get(_receiver).toString();

            String[] receiverArray = receiver.split(",");//آی دی  ها با این رشته از هم جدا می شود
            String temp = "";
            for (int j = 0; j < receiverArray.length; j++) {
                temp += "'" + receiverArray[j] + "',";
                System.out.println("receiverArray=" + temp);
            }

            script.append("$('#myMessages_receiver').val([" + temp + "]);"
                    + "$('#myMessages_receiver').select2({  minimumResultsForSearch: '',  width: '100%'});");

//            
            script.append(Js.setVal("#myMessages_status", row.get(0).get(_status)));
            String ravand = row.get(0).get(_logStatus).toString();
            ravand = ravand.replace("%23A%23", "\\n");
            System.out.println(ravand.replace("%23A%23", "\\n"));
            script.append(Js.setVal("#myMessages_logStatus", ravand));

            script.append(Js.setVal("#myMessages_sender", jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY")));
            script.append(Js.setVal("#myMessages_dateOfCreation", row.get(0).get(_dateOfCreation)));
            script.append(Js.setVal("#myMessages_postageDate", jjCalendar_IR.getViewFormat(row.get(0).get(_postageDate))));
            script.append(Js.setVal("#myMessages_attachFile", row.get(0).get(_attachFile)));
            script.append(Js.setVal("#myMessages_attachFileTitle", row.get(0).get(_attachFileTitle)));
            String attachFiles = row.get(0).get(_attachFile).toString();

            String attachFileTitles = row.get(0).get(_attachFileTitle).toString();

            String[] attachFilesArray = attachFiles.split("%23A%23");
            String[] attachFileTitlesArray = attachFileTitles.split("%23A%23");

            for (int l = 0; l < attachFilesArray.length && l < attachFileTitlesArray.length; l++) {
                List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + attachFilesArray[l] + "'"));
                List<Map<String, Object>> titleRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._title + "='" + attachFileTitlesArray[l] + "'"));
                if (!fileRow.isEmpty()) {
                    String idUpload = fileRow.get(0).get(UploadServlet._id).toString();
                    String titleUpload = fileRow.get(0).get(UploadServlet._title).toString();
                    String extension2 = attachFilesArray[l].substring(attachFilesArray[l].lastIndexOf(".") + 1, attachFilesArray[l].length());
                    if (extension2.toLowerCase().equals("jpg")
                            || extension2.toLowerCase().equals("png")
                            || extension2.toLowerCase().equals("gif")
                            || extension2.toLowerCase().equals("svg")) {
                        if (titleUpload.equals("")) {
                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button class='col-lg-1 form-control'  style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>" + "حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        } else {

                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        }
                    } else {
                        html2.append("<input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                    }
                }
            }

            script2 += Js.setHtml(".inputAfterSelectManager", html2);

            if ((row.get(0).get(_receiver).equals(jjTools.getSessionAttribute(request, "#ID")) && (!row.get(0).get(_status).equals(status_displayed)))) {

                changeStatus(request, response, db, id, status_displayed);

            }
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);

            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjMessenger.editMyMessages() + "' id='edit_Messenger'>" + lbl_edit + "</button></div>";
//               
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjMessenger.deleteMyMessages(id) + "' id='delete_Messenger'>" + lbl_delete + "</button></div>";
            }
            script1.append(Js.setHtml("#myMessages_button", htmlBottons));
            boolean accEmail = Access_User.hasAccess(request, db, rul_ins);
            if (row.get(0).get(_status).equals(status_posted)) {
                if (row.get(0).get(_sendToSms).equals("1")) {
//              
                    html.append(Js.setAttr("#messenger_sendToSmsMyMessages", "checked", "checked"));
                }
//               
                if (row.get(0).get(_sendToEmail).equals("1")) {
                    html.append(Js.setAttr("#messenger_sendToEmailMyMessages", "checked", "checked"));
                }
            } else {

                boolean accSms = Access_User.hasAccess(request, db, rul_ins);
                html5 += "<div >روش ارسال";
                if (accEmail) {//@ToDo 
                    html5 += "<input  type='checkbox' id='messenger_sendToEmailMyMessages' name='messenger_sendToEmail'  value='1'  class='form-control'/>ایمیل";

//                script.append(Js.click("#insert_Messenger_new", Js.jjMessenger.insert()));
                }

                if (accSms) {//@ToDo 
                    html5 += "<input type='checkbox' id='messenger_sendToSmsMyMessages' name='messenger_sendToSms'  value='1'   class='form-control'  />sms";
                }
                html5 += "</div>";
            }
            script6.append(Js.setHtml("#sendingMetodMymessages", html5));
            Server.outPrinter(request, response, html.toString() + script + script1 + script3 + script2 + script6);
            return "";

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }
    /*
     selectپیام های من
     این تابع برای select پیام های دیده شده نوشته شده است
     */

    public static String selectMessagesSeen(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
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
            StringBuilder script1 = new StringBuilder();
            StringBuilder script6 = new StringBuilder();
            String script2 = "";

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            String script3 = "";
            script.append(Js.setVal("#messagesSeen_" + _id, row.get(0).get(_id)));

            script.append(Js.setVal("#messagesSeen_title", row.get(0).get(_title)));
            script.append(Js.setVal("#messagesSeen_textMessage", row.get(0).get(_textMessage)));
//        
            String receiver = row.get(0).get(_receiver).toString();

            String[] receiverArray = receiver.split(",");//آی دی  ها با این رشته از هم جدا می شود
            String temp = "";
            for (int j = 0; j < receiverArray.length; j++) {
                temp += "'" + receiverArray[j] + "',";
                System.out.println("receiverArray=" + temp);
            }

            script.append("$('#messagesSeen_receiver').val([" + temp + "]);"
                    + "$('#messagesSeen_receiver').select2({  minimumResultsForSearch: '',  width: '100%'});");

//            
            script.append(Js.setVal("#messagesSeen_status", row.get(0).get(_status)));
            String ravand = row.get(0).get(_logStatus).toString();
            ravand = ravand.replace("%23A%23", "\\n");
            System.out.println(ravand.replace("%23A%23", "\\n"));
            script.append(Js.setVal("#messagesSeen_logStatus", ravand));

            script.append(Js.setVal("#messagesSeen_sender", jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY")));
            script.append(Js.setVal("#messagesSeen_dateOfCreation", row.get(0).get(_dateOfCreation)));
            script.append(Js.setVal("#messagesSeen_postageDate", jjCalendar_IR.getViewFormat(row.get(0).get(_postageDate))));
            script.append(Js.setVal("#messagesSeen_attachFile", row.get(0).get(_attachFile)));
            script.append(Js.setVal("#messagesSeen_attachFileTitle", row.get(0).get(_attachFileTitle)));
            String attachFiles = row.get(0).get(_attachFile).toString();

            String attachFileTitles = row.get(0).get(_attachFileTitle).toString();

            String[] attachFilesArray = attachFiles.split("%23A%23");
            String[] attachFileTitlesArray = attachFileTitles.split("%23A%23");

            for (int l = 0; l < attachFilesArray.length && l < attachFileTitlesArray.length; l++) {
                List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + attachFilesArray[l] + "'"));
                List<Map<String, Object>> titleRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._title + "='" + attachFileTitlesArray[l] + "'"));
                if (!fileRow.isEmpty()) {
                    String idUpload = fileRow.get(0).get(UploadServlet._id).toString();
                    String titleUpload = fileRow.get(0).get(UploadServlet._title).toString();
                    String extension2 = attachFilesArray[l].substring(attachFilesArray[l].lastIndexOf(".") + 1, attachFilesArray[l].length());
                    if (extension2.toLowerCase().equals("jpg")
                            || extension2.toLowerCase().equals("png")
                            || extension2.toLowerCase().equals("gif")
                            || extension2.toLowerCase().equals("svg")) {
                        if (titleUpload.equals("")) {
                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button class='col-lg-1 form-control'  style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>" + "حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        } else {

                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        }
                    } else {
                        html2.append("<input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                    }
                }
            }

            script2 += Js.setHtml(".inputAfterSelectManager", html2);

            if ((row.get(0).get(_receiver).equals(jjTools.getSessionAttribute(request, "#ID")) && (!row.get(0).get(_status).equals(status_displayed)))) {

                changeStatus(request, response, db, id, status_displayed);

            }
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);

            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjMessenger.editMessagesSeen() + "' id='edit_Messenger'>" + lbl_edit + "</button></div>";
//               
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjMessenger.deleteMessagesSeen(id) + "' id='delete_Messenger'>" + lbl_delete + "</button></div>";
            }
            script1.append(Js.setHtml("#MessagesSeen_button", htmlBottons));
            boolean accEmail = Access_User.hasAccess(request, db, rul_ins);
            if (row.get(0).get(_status).equals(status_posted)) {
                if (row.get(0).get(_sendToSms).equals("1")) {
//              
                    html.append(Js.setAttr("#messenger_sendToSms", "checked", "checked"));
                }
//               
//               
                html.append(Js.setAttr("#messenger_sendToEmail", "checked", "checked"));
            } else {

                boolean accSms = Access_User.hasAccess(request, db, rul_ins);
                String html5 = "<div >روش ارسال";
                if (accEmail) {//@ToDo 
                    html5 += "<input  type='checkbox' id='messenger_sendToEmail' name='messenger_sendToEmail'  value='1'  class='form-control'/>ایمیل";

//                script.append(Js.click("#insert_Messenger_new", Js.jjMessenger.insert()));
                }

                if (accSms) {//@ToDo 
                    html5 += "<input type='checkbox' id='messenger_sendToSms' name='messenger_sendToSms'  value='1'   class='form-control'  />sms";
                }
                html5 += "</div>";
                script6.append(Js.setHtml("#sendingMetod", html5));
            }

            Server.outPrinter(request, response, html.toString() + script + script1 + script3 + script2 + script6);
            return "";

        } catch (Exception e) {
            Server.outPrinter(request, response, Server.ErrorHandler(e));
            return "";

        }
    }
    /*
     selectپیام های من
     این تابع برای select پیام های دیده شده نوشته شده است
     */

    public static String selectMessages(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
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
            StringBuilder script1 = new StringBuilder();
            String script2 = "";

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));

            StringBuilder html = new StringBuilder();
            StringBuilder html2 = new StringBuilder();
            StringBuilder html3 = new StringBuilder();
            StringBuilder script6 = new StringBuilder();
            String script3 = "";
            script.append(Js.setVal("#messages_" + _id, row.get(0).get(_id)));

            script.append(Js.setVal("#messages_title", row.get(0).get(_title)));
            script.append(Js.setVal("#messages_textMessage", row.get(0).get(_textMessage)));
//        
            String receiver = row.get(0).get(_receiver).toString();

            String[] receiverArray = receiver.split(",");//آی دی  ها با این رشته از هم جدا می شود
            String temp = "";
            for (int j = 0; j < receiverArray.length; j++) {
                temp += "'" + receiverArray[j] + "',";
                System.out.println("receiverArray=" + temp);
            }

            script.append("$('#messages_receiver').val([" + temp + "]);"
                    + "$('#messages_receiver').select2({  minimumResultsForSearch: '',  width: '100%'});");

//            
            script.append(Js.setVal("#messages_status", row.get(0).get(_status)));
            String ravand = row.get(0).get(_logStatus).toString();
            ravand = ravand.replace("%23A%23", "\\n");
            System.out.println(ravand.replace("%23A%23", "\\n"));
            script.append(Js.setVal("#messages_logStatus", ravand));

            script.append(Js.setVal("#messages_sender", jjTools.getSessionAttribute(request, "#USER_NAME") + " " + jjTools.getSessionAttribute(request, "#USER_FAMILY")));
            script.append(Js.setVal("#messages_dateOfCreation", row.get(0).get(_dateOfCreation)));
            script.append(Js.setVal("#messages_postageDate", jjCalendar_IR.getViewFormat(row.get(0).get(_postageDate))));
            script.append(Js.setVal("#messages_attachFile", row.get(0).get(_attachFile)));
            script.append(Js.setVal("#messages_attachFileTitle", row.get(0).get(_attachFileTitle)));
            String attachFiles = row.get(0).get(_attachFile).toString();

            String attachFileTitles = row.get(0).get(_attachFileTitle).toString();

            String[] attachFilesArray = attachFiles.split("%23A%23");
            String[] attachFileTitlesArray = attachFileTitles.split("%23A%23");

            for (int l = 0; l < attachFilesArray.length && l < attachFileTitlesArray.length; l++) {
                List<Map<String, Object>> fileRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + attachFilesArray[l] + "'"));
                List<Map<String, Object>> titleRow = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._title + "='" + attachFileTitlesArray[l] + "'"));
                if (!fileRow.isEmpty()) {
                    String idUpload = fileRow.get(0).get(UploadServlet._id).toString();
                    String titleUpload = fileRow.get(0).get(UploadServlet._title).toString();
                    String extension2 = attachFilesArray[l].substring(attachFilesArray[l].lastIndexOf(".") + 1, attachFilesArray[l].length());
                    if (extension2.toLowerCase().equals("jpg")
                            || extension2.toLowerCase().equals("png")
                            || extension2.toLowerCase().equals("gif")
                            || extension2.toLowerCase().equals("svg")) {
                        if (titleUpload.equals("")) {
                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button class='col-lg-1 form-control'  style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>" + "حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        } else {

                            html2.append("<img class='col-xs-12' style='width:10%;float:right' src='upload/" + attachFilesArray[l] + "'/><input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                        }
                    } else {
                        html2.append("<input class='col-lg-12 form-control'  style='text-align: center' disabled='disabled'  value='" + attachFileTitlesArray[l] + "'/>" + "<input  style='text-align: center;' class='col-lg-12'  disabled='disabled'  value='" + attachFilesArray[l] + "'/>" + "<button  class='col-lg-1' style='background-color: #e16262;color: white;float:left' onclick='hmisMessenger.m_remove(" + idUpload + "," + id + ")'>حذف" + "</button><a  class='col-lg-1' style='background-color: green;color: white;float:left;text-align: center;padding-top: 2px;padding-bottom: 1px;margin-top: 1px;' href='upload/" + attachFilesArray[l] + "' >دانلود</a>");
                    }
                }
            }

            script2 += Js.setHtml(".inputAfterSelectManager", html2);

            if ((row.get(0).get(_receiver).equals(jjTools.getSessionAttribute(request, "#ID")) && (!row.get(0).get(_status).equals(status_displayed)))) {

                changeStatus(request, response, db, id, status_displayed);

            }
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);

            String htmlBottons = "";
            boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
            if (accEdit) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjMessenger.editMessages() + "' id='edit_Messenger'>" + lbl_edit + "</button></div>";
//               
            }
            boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
            if (accDelete) {
                htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjMessenger.deleteMessages(id) + "' id='delete_Messenger'>" + lbl_delete + "</button></div>";
            }
            script1.append(Js.setHtml("#Messages_button", htmlBottons));
            boolean accEmail = Access_User.hasAccess(request, db, rul_ins);
            if (row.get(0).get(_status).equals(status_posted)) {
                if (row.get(0).get(_sendToSms).equals("1")) {
//              
                    html.append(Js.setAttr("#messenger_sendToSms", "checked", "checked"));
                }
//               
//               
                html.append(Js.setAttr("#messenger_sendToEmail", "checked", "checked"));
            } else {

                boolean accSms = Access_User.hasAccess(request, db, rul_ins);
                String html5 = "<div >روش ارسال";
                if (accEmail) {//@ToDo 
                    html5 += "<input  type='checkbox' id='messenger_sendToEmail' name='messenger_sendToEmail'  value='1'  class='form-control'/>ایمیل";

//                script.append(Js.click("#insert_Messenger_new", Js.jjMessenger.insert()));
                }

                if (accSms) {//@ToDo 
                    html5 += "<input type='checkbox' id='messenger_sendToSms' name='messenger_sendToSms'  value='1'   class='form-control'  />sms";
                }
                html5 += "</div>";
                script6.append(Js.setHtml("#sendingMetod", html5));
            }

            Server.outPrinter(request, response, html.toString() + script + script1 + script3 + script2 + script6);
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
            String idMesenger = jjTools.getParameter(request, "messenger_id");

            List<Map<String, Object>> rowMesesnger = jjDatabase.separateRow(db.Select(Messenger.tableName, _id + "=" + idMesenger));///برای در اوردن attachfile
            List<Map<String, Object>> rowupload = jjDatabase.separateRow(db.Select(UploadServlet.tableName, UploadServlet._id + "=" + idUpload));////برای دراوردن اسم فایل
            String filename = rowupload.get(0).get(UploadServlet._file_name).toString() + "%23A%23";
            String title = rowupload.get(0).get(UploadServlet._title).toString() + "%23A%23";
            String attacheFiles = rowMesesnger.get(0).get(Messenger._attachFile).toString();
            String attacheFilesTitle = rowMesesnger.get(0).get(Messenger._attachFileTitle).toString();
            System.out.println(filename);
            System.out.println("____________________________________");
            System.out.println(attacheFiles);
            attacheFiles = attacheFiles.replace(filename, "");
            attacheFilesTitle = attacheFilesTitle.replace(title, "");
            System.out.println(attacheFiles);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_attachFile, attacheFiles);
            map.put(_attachFileTitle, attacheFilesTitle);
            System.out.println("____________________________________");

            db.update(tableName, map, _id + "=" + idMesenger);

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
            map.put(_title, jjTools.getParameter(request, _title));
            map.put(_textMessage, jjTools.getParameter(request, _textMessage));
            map.put(_receiver, jjTools.getParameter(request, _receiver));
            map.put(_sendToSms, jjTools.getParameter(request, _sendToSms));
            map.put(_sendToEmail, jjTools.getParameter(request, _sendToEmail));
            map.put(_sender, jjTools.getSeassionUserNameAndFamily(request));
//            map.put(_sender, jjTools.getParameter(request, _sender));
            map.put(_dateOfCreation, jjTools.getParameter(request, _dateOfCreation));
            map.put(_postageDate, jjTools.getParameter(request, _postageDate));
            map.put(_attachFileTitle, jjTools.getParameter(request, _attachFileTitle));
            map.put(_attachFile, jjTools.getParameter(request, _attachFile));
            map.put(_titleFile, jjTools.getParameter(request, _titleFile));
            map.put(_sendingMethod, jjTools.getParameter(request, _sendingMethod));
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }
            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";

            }
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

    //     * 
    /**
     * ارسال پیام
     *
     * @param db
     * @param receiver//گیرنده
     * @param sender //فرستنده که ای دی0 است
     * @param sendingMethod//روش ارسال پیام
     * @param postageDate//تاریخ ارسال
     * @param textMessage//متن پیام
     * @return
     */
    public static String sendMesseage(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, String receiver, String sender, String sendingMethod, String postageDate, String textMessage) throws IOException {
        Map<String, Object> map = new HashMap<>();

        String receiverMessage = receiver;
        //این تابع برای دریافت گیرنده ها نوشته شده 
        ///شیران1
        String[] receiverMessageArray = receiverMessage.split("%23A%23");//آی دی نویسنده ها با این رشته از هم جدا می شود
        for (int j = 0; j < receiverMessageArray.length; j++) {

            List<Map<String, Object>> userRow = jjDatabaseWeb.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + receiverMessageArray[j]));//در ستون نویسندگان آی دی نویسنده ها قرار دارد                  
            for (int i = 0; i < userRow.size(); i++) {
                map.put(_receiver, receiverMessageArray[j]);
                map.put(_sender, sender);
                map.put(_sendingMethod, sendingMethod);
                map.put(_postageDate, postageDate);

                map.put(_textMessage, textMessage);
//        map.put(_postageDate, jjCalendar_IR.getDatabaseFormat_8length(null, true));
//                    html7.append(" " + userRow.get(0).get(_nam) + " " + userRow.get(0).get(_family) + "/");
            }
//                script7 = Js.setVal("#darkhastha_pishnahadkargroh", html7);
        }

        if (db.insert(tableName, map).getRowCount() > 0) {
            return "";
        }
        String errorMessage = "ارسال پیام با خطایی مواجه شده است";
        Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
        return "";

    }

    /**
     *
     * @param request
     * @param response
     * @param db
     * @param isPost
     * @returnاین تابع برای ارسال پیام به کسانی هست که امضا نکرده اند
     * @throws IOException
     */
    public static String sendMesseageToSignatory(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws IOException {
        try {
            Map<String, Object> map = new HashMap<String, Object>();

            String userId = request.getParameter("userId");///ای دی یوزر
            String IdDocumentary = request.getParameter("IdDocumentary");//عنوان مستند
            String titleSign = request.getParameter("titleSign");//عنوان امضا کننده را به صورت جی اس دریافت میکنیم

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(CreateDocumentary.tableName, _id + "='" + IdDocumentary + "'"));
//            for(int i=0;i<row.size();i++){
            String title = row.get(0).get(CreateDocumentary._title).toString();

            map.put(_textMessage, "مستند" + " " + title + "برای امضا به شمابه عنوان " + " " + titleSign + " " + "ارسال شده است" + " " + "لطفا مستند را امضا نمایید");
            map.put(_title, "درخواست امضابرای" + " " + "مستند" + " " + title);
//            }
            map.put(_receiver, userId);

            map.put(_postageDate, jjCalendar_IR.getDatabaseFormat_8length("", true));

//    
            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.dialog(errorMessage));
                return "";
            }

            List<Map<String, Object>> insertedRow = jjDatabase.separateRow(db.insert(tableName, map));
            changeStatus(request, response, db, insertedRow.get(0).get(_id).toString(), status_created);

            String errorMessage1 = "ارسال پیام به کاربر مورد نظر انجام گردید";
            Server.outPrinter(request, response, Js.modal(errorMessage1, "پیام سامانه"));
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

    public static String getClassCssForStatus(String satus) {
        if (satus.equals(status_created)) {
            return "status_created";
        } else if (satus.equals(status_displayed)) {
            return "status_displayed";
        } else if (satus.equals(status_postQueue)) {
            return "status_postQueue";// این کلاس در فایل های سی اس اس تعریف میشود و در قسمت های مختلف جدول نشان داده می شود

        } else if (satus.equals(status_posted)) {
            return "status_posted";// این کلاس در فایل های سی اس اس تعریف میشود و در قسمت های مختلف جدول نشان داده می شود
        }
        return "";
    }

    public static String ersalPayamBaEmail(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {

            String email = jjTools.getParameter(request, _email);
//           Js.dialog(a)

            String Email = jjTools.getParameter(request, "email");

            List<Map<String, Object>> emailRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._email + "='" + Email + "'"));

            StringBuilder html = new StringBuilder();
            StringBuilder script = new StringBuilder();

            if (Server.sendEmail("sepanoweb@gmail.com", Email, "پیام های ارسال شده", "", true, request)) {
                String errorMessage = "ایمیل ارسال شد";
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";

            }
            String errorMessage = "ایمیل ارسال نشد";
            Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
            return "";

        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";

        }
    }

}
