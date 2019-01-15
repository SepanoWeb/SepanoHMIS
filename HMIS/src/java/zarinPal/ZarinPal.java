/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zarinPal;

import cms.access.Access_User;
import cms.tools.Js;
import cms.tools.Payment;
import static cms.tools.Payment._amount;
import static cms.tools.Payment._date;
import static cms.tools.Payment._factorId;
import static cms.tools.Payment._orderId;
import static cms.tools.Payment._refrenceId;
import static cms.tools.Payment._status;
import static cms.tools.Payment._userId;
import static cms.tools.Payment._userName;
import static cms.tools.Payment.tableName;
import cms.tools.PaymentSetting;
import cms.tools.Server;
import cms.tools.ServerLog;
import cms.tools.jjTools;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;
import jj.jjCalendar_IR;
import jj.jjDatabase;
import jj.jjDatabaseWeb;
//import zarinPall.PaymentGatewayImplementationService;
//import zarinPall.PaymentGatewayImplementationServicePortType;

/**
 *
 * @author Rashidi
 */
public class ZarinPal {

    public static String MerchantID;//کد پذيرنده ضروری
    public static Integer Amount = 0;//برحسب تومان ضروری
    public static String Description = "";//توضيحات مربوط تراكنش ضروری
    public static String Email;//ایمیل خریدار غیر ضروری
    public static String Mobile;//شماره تماس خریدار غیر ضروری
    public static String CallbackURL = Server.siteName + "/PaymentResultZarrinPal.jsp";//صفحه بازگشت مشتري پس از انجام عمل پرداخت ضروری

    ////// ------------- floritPaymentRequest() ------------->
    public static String floritPaymentRequest(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) {
        try {
            String userEmail = "";
            String userMobile = "";
            if(jjTools.getSeassionUserId(request)>0){
            List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + jjTools.getSessionAttribute(request, "#ID")));                
                if (userRow.size() != 1) {
                    return "لطفا دوباره وارد شوید";
                }
                userEmail = userRow.get(0).get(Access_User._email).toString();
                userMobile = userRow.get(0).get(Access_User._mobile).toString();
            }else{
                return "سشن شما منقضی شده است! لطفا مجدد وارد شوید";
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(PaymentSetting.tableName, PaymentSetting._webService + "='zarrinPal'"));
            if (row.isEmpty()) {
                return "تنظیمات درگاه در پایگاه داده را بررسی کنید";
            }
            MerchantID = row.get(0).get(PaymentSetting._terminalId).toString();

            StringBuilder script = new StringBuilder();
            String orderId = jjTools.getParameter(request, "orderId");
//            Amount = 100;
            Amount = Integer.parseInt(jjTools.getParameter(request, Payment._amount));
            Description = jjTools.getParameter(request, "description");
            Holder<Integer> status = new Holder<Integer>();
            Holder<String> authority = new Holder<String>();
//            PaymentGatewayImplementationServicePortType soap;
//            PaymentGatewayImplementationService ws = new PaymentGatewayImplementationService();
//            soap = ws.getPaymentGatewayImplementationServicePort();
//
//            soap.paymentRequest(MerchantID, Amount, "شناسه سفارش: " + orderId, userEmail, userMobile, CallbackURL, status, authority);
            ServerLog.Print(status.value == null ? "null" : status.value.toString());
            ServerLog.Print(authority.value == null ? "null" : authority.value.toString());
            ServerLog.Print(authority.value == null ? "null" : authority.value.toString());
            if (status.value == 100 && authority.value.length() == 36) {
                String gate = "https://www.zarinpal.com/pg/StartPay/" + authority.value + "/ZarinGate";
//                String gate = "https://www.zarinpal.com/pg/StartPay/" + authority.value;
                ServerLog.Print(gate);
                //قراردادن یک رکورد در جدول تراکنش ها
                String userId = jjTools.getSessionAttribute(request, "#" + Access_User._id.toUpperCase());
                String where = Access_User._id + "='" + userId + "'";
                List<Map<String, Object>> rowUser = jjDatabaseWeb.separateRow(db.Select(Access_User.tableName, where));

                Map<String, Object> map = new HashMap<String, Object>();
                jjCalendar_IR dateIR = new jjCalendar_IR();
                map.put(Payment._date, dateIR.getDBFormat_8length());
                map.put(Payment._orderId, jjTools.getSessionAttribute(request, "#FACTOR_ID"));
                map.put(Payment._factorId, jjTools.getSessionAttribute(request, "#FACTOR_ID").toLowerCase());
                map.put(Payment._userId, userId);
                map.put(Payment._userName, rowUser.size() == 0 ? "" : (rowUser.get(0).get(Access_User._name).toString() + " " + rowUser.get(0).get(Access_User._family).toString()));
                map.put(Payment._refrenceId, authority.value);// آثوریتی را در رفرنس آی دی می گذاریم
                map.put(Payment._amount, request.getParameter(Payment._amount));
//                map.put(_status, request.getAttribute(_status).toString());
                db.insert(Payment.tableName, map);
//                script.append();
                script.append("window.location.replace('" + gate + "');");
                ServerLog.Print(script);
                return script.toString();
            }
            String result = checkStatus(status.value);
            return Js.dialog(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Server.ErrorHandler(e);
        }
    }

    ////// <------------- floritPaymentRequest() -------------
    ////// ------------- checkStatus() ------------->
    public static String checkStatus(int statusCode) {
        String result = "";
        switch (statusCode) {
            case -1:
                result = "اطلاعات ارسال شده ناقص است.";
                break;
            case -2:
                result = "IP و یا مرچنت كد پذيرنده صحيح نیست.";
                break;
            case -3:
                result = "با توجه به محدوديت هاي شاپرك امكان پرداخت با رقم درخواست شده ميسر نمي باشد.";
                break;
            case -4:
                result = "سطح تاييد پذيرنده پايين تر از سطح نقره اي است.";
                break;
            case -11:
                result = "درخواست مورد نظر يافت نشد.";
                break;
            case -12:
                result = "امكان ويرايش درخواست ميسر نمي باشد.";
                break;
            case -21:
                result = "هيچ نوع عمليات مالي براي اين تراكنش يافت نشد.";
                break;
            case -22:
                result = "تراكنش نا موفق مي باشد.";
                break;
            case -33:
                result = "رقم تراكنش با رقم پرداخت شده مطابقت ندارد.";
                break;
            case -34:
                result = "سقف تقسيم تراكنش از لحاظ تعداد يا رقم عبور نموده است";
                break;
            case -40:
                result = "اجازه دسترسي به متد مربوطه وجود ندارد.";
                break;
            case -41:
                result = "اطلاعات ارسال شده مربوط به additional data غیر معتبر می باشد.";
                break;
            case -42:
                result = "مدت زمان معتبر طول عمر شناسه پرداخت بايد بين 30 دقيه تا 45 روز مي باشد.";
                break;
            case -54:
                result = "درخواست مورد نظر آرشيو شده است.";
                break;
            case 100:
                result = "عمليات با موفقيت انجام گرديده است.";
                break;
            case 101:
                result = "عمليات پرداخت موفق بوده و قبلا PaymentVerification تراکنش انجام شده است.";
                break;
        }
        return result;
    }
    ////// <------------- checkStatus() -------------
}
