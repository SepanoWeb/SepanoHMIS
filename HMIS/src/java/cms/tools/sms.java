/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.tools;

//import webServiceSms.SepahanGostar.SmsSepahanGostar;
import cms.access.Access_User;
//import ArrayOfInt;
//import ArrayOfLong;
//import ArrayOfString;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import jj.jjCalendar_IR;
import jj.jjDatabaseWeb;
import jj.jjNumber;
import webServiceSms.KaveNegar.ArrayOfLong;
import webServiceSms.KaveNegar.ArrayOfString;
import webServiceSms.KaveNegar.SmsKaveNegar;
import static webServiceSms.KaveNegar.SmsKaveNegar.checkNum;
//import static jj.jjNumber.isOdd;

//import org.tempuri.ArrayOfInt;
//import org.tempuri.ArrayOfLong;

/**
 *
 * @author Rashidi
 */
public class sms {

//    public static String apiKey = "526D2B4E316652564E754B686E354A746A67374C53513D3D";
    public static String apiKey = "526D2B4E316652564E754B686E354A746A67374C53513D3D";
    public static String webService = "kavenegar.com";
//    public static String userName = "mrsalesi";
//    public static String pass = "1234";
    public static String userName = "atefeh.rashidi@outlook.com";
    public static String pass = "12345";
    public static String sender = "300002525";

    public static String tableName = "sms";
    public static String _id = "id";
    public static String _text = "sms_text";
    public static String _sender = "sms_sender";
    public static String _receiver = "sms_receiver";
    public static String _characters = "sms_characters";
    public static String _status = "sms_status";
    public static String _date = "sms_date";
    public static String _sendTime = "sms_send_time";
    public static String _messageID = "sms_messageID";
    public static String _webService = "sms_webService";
    public static String _receiverId = "sms_receiver_id";
    public static String _receiverName = "sms_receiver_name";
    public static String _receiverFamily = "sms_receiver_family";
    public static String _comment = "sms_comment";
    public static String _subject = "sms_subject";
    public static String emptyField = "فیلدهای خالی را پر کنید.";
    public static String lbl_send = "ارسال پیامک";
//    public static int rul_rfs = 51;
//    public static int rul_ins = 52;
//    public static int rul_edt = 53;
//    public static int rul_dlt = 54;
//    public static int reserved=55;

    //   public static int rul_show_pics = 401;//نمایش تب پیامک//====== BY RASHIDI ======
//    public static int rul_show_SMS _reserved= 402 --- 420;// RESERVED : 402 -- 420//نمایش تب پیامک//====== BY RASHIDI ======
    public static int rul_rfs = 421;
    public static int rul_ins = 422;
    public static int rul_edt;
    public static int rul_dlt = 423;
//    public static int rul_reserved = 424 --- 440;// RESERVED : 424 -- 440
////// ---------------- insert() ------------------->
    public static String insert(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws SQLException {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            String result = "";
            ArrayOfLong messageId = new ArrayOfLong();
            ArrayOfString receptor = new ArrayOfString();
            receptor = checkNum(jjTools.getParameter(request, sms._receiver));
            String text = jjTools.getParameter(request, sms._text);
            String sender = jjTools.getParameter(request, sms._sender);
            messageId = SmsKaveNegar.sendSMSByApiKeyWithRequest(request, db, isPost);//ارسال اس ام اس
            if (!messageId.getLong().get(0).toString().startsWith("&")) {
                ///////-------------DATE------->
                jjCalendar_IR dateIR = new jjCalendar_IR();
//                int dot = dateIR.toString().indexOf("-");
//                String date = "";
//                String time = "";
//                if (dot > -1) {
//                    date = dateIR.toString().substring(0, dot - 1);
//                    time = dateIR.toString().substring(dot + 2, dateIR.toString().length());
//                }
//                ServerLog.Print("DATE : " + date + " TIME : " + time);
//                int dateInt = jjCalendar_IR.getDatabaseFormat_8length(date, true);//تبدیل تاریخ به فرمت عددی برای ذخیره در دیتابیس
                ///////<-------------DATE-------
                ///--------------- INSERT----- >
                ServerLog.Print(">>  INSERT SMS INFO TO DB : ");
                for (int i = 0; i < receptor.getString().size(); i++) {
                    Map<String, Object> smsMap = new HashMap<String, Object>();
                    smsMap.put(sms._text, text);
                    smsMap.put(sms._sender, sender);
                    ServerLog.Print("SMS : RECEPTOR : " + receptor.getString().get(i));
                    if (receptor.getString().get(i).startsWith("00") || receptor.getString().get(i).startsWith("+")) {//شماره هایی که با  00 یا + شروع میشوند
                        smsMap.put(sms._receiver, receptor.getString().get(i));
                    } else if (receptor.getString().get(i).matches("[(+989)(+98)(00989)(0098)(09)(9)]+[0-9]{9},{0,1}")) {// شماره موبایل های ایران
                        smsMap.put(sms._receiver, "+98" + receptor.getString().get(i).substring(receptor.getString().get(i).length() - 10, receptor.getString().get(i).length()));//به فرمت روبرو ذخیره می شوند : +989123456789
                    }
//                        else {
//                            smsMap.put(_receiver, "+98" + receptor.getString().get(i));
//                        }
//                        smsMap.put(_receiver, receptor.getString().get(i));
//                    smsMap.put(sms._characters, text.length());
                    smsMap.put(sms._status, "ارسال به مخابرات");
                    smsMap.put(sms._date, dateIR.getDBFormat_8length());
                    smsMap.put(sms._sendTime, dateIR.getTimeFormat_5length());
                    smsMap.put(sms._messageID, messageId.getLong().get(i));
                    smsMap.put(sms._webService, sms.webService);
                    smsMap.put(sms._receiverName, jjTools.getParameter(request, sms._receiverName));
                    smsMap.put(sms._receiverFamily, jjTools.getParameter(request, sms._receiverFamily));
                    smsMap.put(sms._comment, jjTools.getParameter(request, sms._comment));
                    smsMap.put(sms._subject, jjTools.getParameter(request, sms._subject));
//                        smsMap.put(sms._receiverId, jjTools.getParameter(request, sms._receiverId));
                    ServerLog.Print("SMS INFO : " + smsMap);
                    if (db.insert(tableName, smsMap).getRowCount() != 0) {
                        ServerLog.Print("پیامک با موفقیت ارسال شد و اطلاعات آن ثبت شد.");
                        result = "پیامک با موفقیت ارسال شد و اطلاعات آن ثبت شد.";
                    } else {
                        ServerLog.Print("پیامک با موفقیت ارسال شد اما اطلاعات آن ثبت نشد.");
                        result = "پیامک با موفقیت ارسال شد اما اطلاعات آن ثبت نشد.";
                    }
                }
                ///<------------- INSERT --------
            } else {
                result = messageId.getLong().get(0).toString().replace("&", "");
            }
            refresh(request, db, isPost);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    ////// <---------------- insert() -------------------
////// ---------------- sendSMSWithRequest() ------------------->
//    public static String sendSMSWithRequest(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws SQLException {
//        try {
//            String result = "";
//            if (webService.equalsIgnoreCase("kavenegar.com")) {//اگر وب سرویس پیامک کاوه نگار باشه کلاس مربوط به کاوه نگار فراخوانده میشه
//                result = SmsKaveNegar.sendSMSByApiKeyWithRequest(request, db, isPost);
//            } else if (webService.equalsIgnoreCase("sepahangostar.com")) {//اگر وب سرویس پیامک سپاهان گستر باشه کلاس مربوط به سپاهان گستر فراخوانده میشه
//                result = SmsSepahanGostar.sendSMSWithRequest(request, db, isPost);
//            }
//            return result;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return "";
//        }
//    }
    ////// <---------------- sendSMSWithRequest -------------------
    ////// ---------------- sendSMS() ------------------->
    public static String sendSMS(HttpServletRequest request, jjDatabaseWeb db, String text, String receptorStr) throws SQLException {
        try {
            String result = "";
            result = SmsKaveNegar.sendSMSByApiKey(request, db, text, receptorStr);

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    ////// <---------------- sendSMS -------------------
////// ---------------- refresh() ------------------->
    public static String refresh(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }

            StringBuilder script = new StringBuilder();
//            StringBuilder html = new StringBuilder();
            Map<String, Object> map = new HashMap<String, Object>();
            //انتخاب پیامک هایی که وضعیت ان ها مشخص نیست هنوز در مخابرات هستند یا در صف ارسال هستند
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(tableName, _status + " != 'رسیده به گیرنده' AND " + _status + " != 'نرسیده به گیرنده' AND " + _status + " != 'فیلتر شده' "));
//            ArrayOfInt smsStausKvNg = new ArrayOfInt();
            ArrayOfLong smsMessageIdKvNg = new ArrayOfLong();
            ArrayOfString smsStausSpKvNg = new ArrayOfString();

            if (!row.isEmpty()) {
                for (int i = 0; i < row.size(); i++) {
                    smsMessageIdKvNg.getLong().add(i, Long.valueOf((String) row.get(i).get(_messageID)));//لیست کردن شناسه های پیامک ها که قبلن از کاوه نگار دریافت و ذخیره شدند
                }
                smsStausSpKvNg = SmsKaveNegar.getStatusByApiKey(smsMessageIdKvNg);//دریافت وضعیت پیامک ها از وب سرویس

                for (int i = 0; i < row.size(); i++) { //آپدیت کردن وضعیت های دریافتی برای هر کدام از پیامک های انتخاب شده
                    map.put(_status, smsStausSpKvNg.getString().get(i));
                    if (!db.update(tableName, map, _id + " = " + row.get(i).get(_id))) {
                        String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                        if (jjTools.isLangEn(request)) {
                            errorMessage = "Edit Failed;";
                        }
                        return Js.dialog(errorMessage);
                    }
                }
            }
            row = jjDatabaseWeb.separateRow(db.JoinLeft(tableName, Access_User.tableName, "*", _receiverId, Access_User._id));//انتخاب تمام پیامک ها و یوزر مربوط به آن پیامک ها
            StringBuilder tableBody = new StringBuilder();
            String text = "";
//            String classRowType = "";
//            String smsStatus = "";
            tableBody.append("<table id='smsTbl' class='tahoma10' style='direction: rtl;width:982px'><thead>");
//            tableBody.append("<tr class=\"tableHeader\">\n"
            tableBody.append("<tr>\n"
                    + "<th>کد</th>\n"
                    + "<th>نام گیرنده</th>\n"
                    + "<th>شماره گیرنده</th>\n"
                    + "<th> فرستنده</th>\n"
                    + "<th>متن پیامک</th>\n"
                    + "<th>وضعیت</th>\n"
                    + "<th> زمان ارسال پیامک</th>\n"
                    + "<th>حذف </th>\n"
                    + "<th>ارسال مجدد </th>\n"
                    + "</tr>\n");
            tableBody.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                //اگر متن پیامک بیشتر از ده کاراکتر بود
                text = (row.get(i).get(_text).toString().length() > 10) ? row.get(i).get(_text).toString().substring(0, 10) + " ..." : row.get(i).get(_text).toString();
//                classRowType = isOdd(i) ? "oddRow" : "evenRow";
                tableBody.append("<tr id=\"smsRowTr" + row.get(i).get(_messageID).toString() + "\" class='mousePointer'>\n"
                        + "<td class='c'>" + row.get(i).get(_messageID).toString() + "</td>\n"
                        + "<td class='c'>" + row.get(i).get(_receiverName).toString() + " " + row.get(i).get(_receiverFamily).toString() + "</td>\n"
                        + "<td class='c'>" + row.get(i).get(_receiver).toString() + "</td>\n"
                        + "<td class='c'>" + row.get(i).get(_sender).toString() + "</td>\n"
                        + "<td class='c' onmouseout=\"cmsSMS.hideFloatDiv(" + i + ");\" onmousemove=\"cmsSMS.showFloatDiv(" + i + ");\" >" + text.toString()
                        + "<div class=\"floatBox\" id=\"floatBox" + i + "\">\n"
                        + row.get(i).get(_text).toString()
                        + "</div>\n"
                        + "</td>\n"
                        + "<td class='c'>" + row.get(i).get(_status).toString() + "</td>\n"
                        + "<td class='c'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_date).toString()) + " - " + row.get(i).get(_sendTime).toString() + "</td>\n"
                        //                        + "<td id=\"smsWebServiceTd_" + row.get(i).get(_id).toString() + "\"> " + row.get(i).get(_webService).toString() + " </td>\n"
                        + "<td class='c'><img class=\"iconImages\" src=\"iconImages/Bin-512.png\" onclick='cmsSMS.m_delete(" + row.get(i).get(_messageID) + ");'></td>\n"
                        + "<td class='c'><img class=\"iconImages\" src=\"iconImages/forward.png\" onclick='cmsSMS.m_select(" + row.get(i).get(_messageID) + ");'></td> "
                        + " </tr>");
            }
            tableBody.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swSMSTbl";
            }
            script.append(Js.setHtml(panel, tableBody));
            script.append(Js.table("#smsTbl", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "18" : "", "لیست پیامک ها"));

//            script.append(Js.hide("#formDiv"));
//            script.append(Js.show("#tableDiv"));
//            script.append(Js.show("#showSendFormBtn"));
//            script.append(Js.hide("#smsTableShowBtn"));
            return script.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
////// <---------------- refresh() -------------------
    ////// ---------------- refresh2() ------------------->

//    public static String refresh2(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
//        try {
////            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
////            if (!hasAccess.equals("")) {
////                return hasAccess;
////            }
//
//            StringBuilder script = new StringBuilder();
////            StringBuilder html = new StringBuilder();
//            Map<String, Object> map = new HashMap<String, Object>();
//            //انتخاب پیامک هایی که وضعیت ان ها مشخص نیست هنوز در مخابرات هستند یا در صف ارسال هستند
//            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(tableName, _status + " != 'رسیده به گیرنده' AND " + _status + " != 'نرسیده به گیرنده' AND " + _status + " != 'فیلتر شده' "));
////            ArrayOfInt smsStausKvNg = new ArrayOfInt();
//            ArrayOfLong smsMessageIdKvNg = new ArrayOfLong();
//            ArrayOfString smsStausSpKvNg = new ArrayOfString();
////            org.tempuri.ArrayOfInt smsStausSpGs = new org.tempuri.ArrayOfInt();
//            org.tempuri.ArrayOfLong smsMessageIdSpGs = new org.tempuri.ArrayOfLong();
//            org.tempuri.ArrayOfString smsStausSpGs = new org.tempuri.ArrayOfString();
//            if (!row.isEmpty()) {
//                if (webService.equalsIgnoreCase("kavenegar.com")) {//اگر وب سرویس پیامک کاوه نگار بود
//                    for (int i = 0; i < row.size(); i++) {
//                        smsMessageIdKvNg.getLong().add(i, Long.valueOf((String) row.get(i).get(_messageID)));//لیست کردن شناسه های پیامک ها که قبلن از کاوه نگار دریافت و ذخیره شدند
//                    }
//                    smsStausSpKvNg = SmsKaveNegar.getStatusByApiKey(smsMessageIdKvNg);//دریافت وضعیت پیامک ها از وب سرویس
//                } else if (webService.equalsIgnoreCase("sepahangostar.com")) {//اگر وب سرویس پیامک سپاهان گستر بود
//                    for (int i = 0; i < row.size(); i++) {
//                        smsMessageIdSpGs.getLong().add(i, Long.valueOf((String) row.get(i).get(_messageID)));//لیست کردن شناسه های پیامک ها که قبلن از سپاهان گستر دریافت و ذخیره شدند
//                    }
//                    smsStausSpGs = SmsSepahanGostar.getStatus(smsMessageIdSpGs);//دریافت وضعیت پیامک ها از وب سرویس
//
//                }
//
//                for (int i = 0; i < row.size(); i++) { //آپدیت کردن وضعیت های دریافتی برای هر کدام از پیامک های انتخاب شده
//
//                    if (webService.equalsIgnoreCase("kavenegar.com")) {//اگر وب سرویس پیامک کاوه نگار بود
//                        ServerLog.Print("STATUS : " + smsStausSpKvNg.getString().get(i));
//                        map.put(_status, smsStausSpKvNg.getString().get(i));
//                    } else if (webService.equalsIgnoreCase("sepahangostar.com")) {//اگر وب سرویس پیامک سپاهان گستر بود
//                        ServerLog.Print("STATUS : " + smsStausSpGs.getString().get(i));
//                        map.put(_status, smsStausSpGs.getString().get(i));
//                    }
//                    if (!db.update(tableName, map, _id + " = " + row.get(i).get(_id))) {
//                        String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
//                        if (jjTools.isLangEn(request)) {
//                            errorMessage = "Edit Failed;";
//                        }
//                        return Js.dialog(errorMessage);
//                    }
//                }
//            }
//            row = jjDatabaseWeb.separateRow(db.JoinLeft(tableName, Access_User.tableName, "*", _receiverId, Access_User._id));//انتخاب تمام پیامک ها و یوزر مربوط به آن پیامک ها
//            StringBuilder tableBody = new StringBuilder();
//            String text = "";
//            String classRowType = "";
////            String smsStatus = "";
//            tableBody.append("<table id='smsTbl' class='tahoma10' style='direction: rtl;width:982px'><thead>");
////            tableBody.append("<tr class=\"tableHeader\">\n"
//            tableBody.append("<tr class=\"tableHeader\">\n"
//                    + "<th>کد</th>\n"
//                    + "<th>نام گیرنده</th>\n"
//                    + "<th>شماره گیرنده</th>\n"
//                    + "<th> فرستنده</th>\n"
//                    + "<th>متن پیامک</th>\n"
//                    + "<th>وضعیت</th>\n"
//                    + "<th> زمان ارسال پیامک</th>\n"
//                    + "<th>حذف </th>\n"
//                    + "<th>ارسال مجدد </th>\n"
//                    + "</tr>\n");
//            tableBody.append("</thead><tbody>");
//            for (int i = 0; i < row.size(); i++) {
//                //اگر متن پیامک بیشتر از ده کاراکتر بود
//                text = (row.get(i).get(_text).toString().length() > 10) ? row.get(i).get(_text).toString().substring(0, 10) + " ..." : row.get(i).get(_text).toString();
//                classRowType = isOdd(i) ? "oddRow" : "evenRow";
//                tableBody.append("<tr id=\"smsRowTr" + row.get(i).get(_messageID).toString() + "\" class=\"" + classRowType + "\" class='mousePointer'>\n"
//                        + "<td class='c'>" + row.get(i).get(_messageID).toString() + "</td>\n"
//                        + "<td class='c'>" + row.get(i).get(_receiverName).toString() + " " + row.get(i).get(_receiverFamily).toString() + "</td>\n"
//                        + "<td class='c'>" + row.get(i).get(_receiver).toString() + "</td>\n"
//                        + "<td class='c'>" + row.get(i).get(_sender).toString() + "</td>\n"
//                        + "<td class='c' onmouseout=\"hideBox(0," + i + ");\" onmousemove=\"showBox(0," + i + ");\" >" + text.toString()
//                        + "<div class=\"floatBox\" id=\"floatBox_0" + i + "\">\n"
//                        + row.get(i).get(_text).toString()
//                        + "</div>\n"
//                        + "</td>\n"
//                        + "<td class='c'>" + row.get(i).get(_status).toString() + "</td>\n"
//                        + "<td class='c'>" + jjCalendar_IR.getViewFormat(row.get(i).get(_date).toString()) + " - " + row.get(i).get(_sendTime).toString() + "</td>\n"
//                        //                        + "<td id=\"smsWebServiceTd_" + row.get(i).get(_id).toString() + "\"> " + row.get(i).get(_webService).toString() + " </td>\n"
//                        + "<td class='c'><img class=\"iconImages\" src=\"iconImages/Bin-512.png\" onclick='cmsSMS.m_delete(" + row.get(i).get(_messageID) + ");'></td>\n"
//                        + "<td class='c'><img class=\"iconImages\" src=\"iconImages/forward.png\" onclick='cmsSMS.m_select(" + row.get(i).get(_messageID) + ");'></td> "
//                        + " </tr>");
//            }
//            tableBody.append("</tbody></table>");
//            String height = jjTools.getParameter(request, "height");
//            String panel = jjTools.getParameter(request, "panel");
//            if (!jjNumber.isDigit(height)) {
//                height = "400";
//            }
//            if (panel.equals("")) {
//                panel = "swSMSTbl";
//            }
//            script.append(Js.setHtml(panel, tableBody));
//            script.append(Js.table("#smsTbl", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "18" : "", "لیست پیامک ها"));
//
////            script.append(Js.hide("#formDiv"));
////            script.append(Js.show("#tableDiv"));
////            script.append(Js.show("#showSendFormBtn"));
////            script.append(Js.hide("#smsTableShowBtn"));
//            return script.toString();
//        } catch (Exception ex) {
//            return Server.ErrorHandler(ex);
//        }
//    }
////// <---------------- refresh2() -------------------
    ////// ---------------- delete() ------------------->
    public static String delete(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            StringBuilder script = new StringBuilder();
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }
            if (!db.delete(tableName, _messageID + " = " + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                return Js.dialog(errorMessage);
            }
//            script.append(Js.hide("#smsRowTr" + id));
            script.append("$('#smsRowTr" + id + "').remove();");
            return script.toString();
//            return refresh(request, db, isPost);

        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
////// <---------------- delete() -------------------
    ////// ---------------- select() ------------------->

    public static String select(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
//            if (!hasAccess.equals("")) {
//                return hasAccess;
//            }
//            ServerLog.Print(">>> select");
            StringBuilder script = new StringBuilder();
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(tableName, _messageID + " = " + jjTools.getParameter(request, _id)));
            if (row.isEmpty()) {
                ServerLog.Print("این رکورد وجود ندارد.");
                return Js.dialog("این رکورد وجود ندارد.");
            }
            script.append(smsSetting.selectWebService(request, db, isPost));
            script.append(Js.setVal(_receiverName, row.get(0).get(_receiverName)));
            script.append(Js.setVal(_receiverFamily, row.get(0).get(_receiverFamily)));
            String date = jjCalendar_IR.getViewFormat(row.get(0).get(_date)) + " - " + row.get(0).get(_sendTime);
//            script.append(Js.setVal(_date, date));
            script.append(Js.setVal(_receiver, row.get(0).get(_receiver)));
            script.append(Js.setVal(_text, row.get(0).get(_text)));
            script.append(Js.setVal(_comment, row.get(0).get(_comment)));
            script.append(Js.setVal(_subject, row.get(0).get(_subject)));
//            script.append(Js.setHtml(_characters, row.get(0).get(_characters)));
//            script.append(Js.setHtml("#SMS_button", "<input type=\"button\" id=\"insert_SMS_new\" value=\"" + lbl_send + "\" class=\"tahoma10\">"));
            script.append(add_new(request, db, isPost));
//            ServerLog.Print(script.toString());
//            request.setAttribute("panel_webServices",_webService);
//            request.setAttribute("panel_numbers",_sender);
//            script.append(smsSetting.selectWebService(request, db, isPost));
            ServerLog.Print(script.toString());
            return script.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    ////// <---------------- select() -------------------
    ////// ---------------- add_new() ------------------->
    public static String add_new(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(smsSetting.selectWebService(request, db, isPost));
                html.append(Js.setHtml("#SMS_button", "<input type=\"button\" id=\"insert_SMS_new\" value=\"" + lbl_send + "\" class=\"tahoma10\">"));
                html.append(Js.buttonMouseClick("#insert_SMS_new", Js.jjSMS.insert()));//send sms
                html.append(Js.setVal("#" + _date, jjCalendar_IR.getViewFormat(new jjCalendar_IR().getDBFormat_8length())));//send sms
                html.append(Js.setVal("#" + _status, "ارسال نشده، در حال ایجاد توسط کاربر..."));//send sms
            }
            return html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
    ////// <---------------- add_new() -------------------

}
