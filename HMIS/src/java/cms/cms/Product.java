package cms.cms;

import cms.tools.*;
import cms.access.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import jj.*;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.swing.table.DefaultTableModel;

public class Product {
//
//    public static String picturePath = "C:/Users/kps/Desktop/checkout2/build/web/upload";//request.getcontext.getrealpath("/upload")
    //

    public static String tableName = "account_product";
    public static String _id = "id";
    public static String _page = "account_product_page";
    public static String _date = "account_product_date";
    public static String _name = "account_product_name";
    public static String _quantity = "account_product_quantity";//====== BY RASHIDI ======
    public static String _sameProducts = "account_product_sameProducts";//====== BY Modalaliyan ======
    public static String _lang = "account_product_lang";//by mohammad
    public static String _parent = "account_product_parent";//by mohammad
    public static String _priority = "account_product_priority";//by mohammad
    public static String _visit = "account_product_visit";//by mohammad
    public static String _order = "account_product_order";//by mohammad
    public static String _rating = "account_product_rating";//by mohammad
    public static String _like = "account_product_like";//by mohammad
    public static String _dislike = "account_product_dislike";//by mohammad
    public static String _category_id = "account_product_category_id";//by mohammad
    public static String _pic1 = "account_product_pic1";
    public static String _pic2 = "account_product_pic2";
    public static String _pic3 = "account_product_pic3";
    public static String _pic4 = "account_product_pic4";
    public static String _pic5 = "account_product_pic5";
    public static String _pic6 = "account_product_pic6";
    public static String _pic_ext = "account_product_pic_ext";
    public static String _price1 = "account_product_price1";
    public static String _price2 = "account_product_price2";
    public static String _currency = "account_product_currency";//====== BY RASHIDI ======
    public static String _code = "account_product_code";
    public static String _prop1 = "account_product_prop1";
    public static String _val1 = "account_product_val1";
    public static String _prop2 = "account_product_prop2";
    public static String _val2 = "account_product_val2";
    public static String _prop3 = "account_product_prop3";
    public static String _val3 = "account_product_val3";
    public static String _prop4 = "account_product_prop4";
    public static String _val4 = "account_product_val4";
    public static String _prop5 = "account_product_prop5";
    public static String _val5 = "account_product_val5";
    public static String _prop6 = "account_product_prop6";
    public static String _val6 = "account_product_val6";
    public static String _prop7 = "account_product_prop7";
    public static String _val7 = "account_product_val7";
    public static String _prop8 = "account_product_prop8";
    public static String _val8 = "account_product_val8";
    public static String _prop9 = "account_product_prop9";
    public static String _val9 = "account_product_val9";
    public static String _prop10 = "account_product_prop10";
    public static String _val10 = "account_product_val10";
    public static String _prop11 = "account_product_prop11";
    public static String _val11 = "account_product_val11";
    public static String _prop12 = "account_product_prop12";
    public static String _val12 = "account_product_val12";
    public static String _prop13 = "account_product_prop13";
    public static String _val13 = "account_product_val13";
    public static String _prop14 = "account_product_prop14";
    public static String _val14 = "account_product_val14";
    public static String _prop15 = "account_product_prop15";
    public static String _val15 = "account_product_val15";
    public static String _prop16 = "account_product_prop16";
    public static String _val16 = "account_product_val16";
    public static String _prop17 = "account_product_prop17";
    public static String _val17 = "account_product_val17";
    public static String _prop18 = "account_product_prop18";
    public static String _val18 = "account_product_val18";
    public static String _prop19 = "account_product_prop19";
    public static String _val19 = "account_product_val19";
    public static String _prop20 = "account_product_prop20";
    public static String _val20 = "account_product_val20";
    public static String _groupPrice1 = "account_product_groupPrice1";//====== BY RASHIDI ======
    public static String _userGroup1 = "account_product_userGroup1";//====== BY RASHIDI ======
    public static String _groupPrice2 = "account_product_groupPrice2";//====== BY RASHIDI ======
    public static String _userGroup2 = "account_product_userGroup2";//====== BY RASHIDI ======
    public static String _groupPrice3 = "account_product_groupPrice3";//====== BY RASHIDI ======
    public static String _userGroup3 = "account_product_userGroup3";//====== BY RASHIDI ======
    public static String _groupPrice4 = "account_product_groupPrice4";//====== BY RASHIDI ======
    public static String _userGroup4 = "account_product_userGroup4";//====== BY RASHIDI ======
    public static String _groupPrice5 = "account_product_groupPrice5";//====== BY RASHIDI ======
    public static String _userGroup5 = "account_product_userGroup5";//====== BY RASHIDI ======
    public static String _taxPercent = "account_product_taxPercent";//====== BY RASHIDI ======
    public static String _discount = "account_product_discount";//====== BY RASHIDI ======
    public static String _discountDate = "account_product_discount_Date";//====== BY RASHIDI ======
    public static String _discountTime = "account_product_discount_Time";//====== BY RASHIDI ======
    public static String _hasLink = "account_product_has_link";//====== BY RASHIDI ======برای این محصول لینک در محتوا ساخته شود یا خیر
    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";
    public static String lbl_add_en = "افزودن زبان انگلیسی";
    public static String lbl_edit_en = "ویرایش بخش انگلیسی";
    public static String lbl_add_ar = "افزودن زبان عربی";
    public static String lbl_edit_ar = "ویرایش بخش عربی";
    public static String _tag1 = "account_products_tag1";
    public static String _relatedProducts = "account_products_relatedProducts";
    public static String _active = "account_products_active";
    public static String _block = "account_products_block";
    public static String _abstract = "account_products_abstract";
    public static String _content = "account_products_content";
    public static String s;
//    public static int rul_rfs = 56;
//    public static int rul_ins = 57;
//    public static int rul_dlt = 59;
//    public static int rul_edt = 58;

    public static int rul_rfs = 221;
    public static int rul_ins = 222;
    public static int rul_edt = 223;
    public static int rul_dlt = 224;
    public static int rul_lng2 = 225;//====== BY RASHIDI ======
    public static int rul_lng3 = 226;//====== BY RASHIDI ======
    public static int rul_lng4 = 227;//====== BY RASHIDI ======
    public static int rul_lng5 = 228;//====== BY RASHIDI ======
////    public static int rul_reserved = 229 --- 240;  /// RESERVED : 229 -- 240
    ///**************LANGUAAGE ADDED*******>
//    public static int rul_lng = 60;//====== COMMENTED BY RASHIDI ======
//    public static int rul_lng2 = 15;//====== BY RASHIDI ======
//    public static int rul_lng3 = 16;//====== BY RASHIDI ======
//    public static int rul_lng4 = 17;//====== BY RASHIDI ======
//    public static int rul_lng5 = 18;//====== BY RASHIDI ======
    public static String lbl_add_ln2 = "افزودن زبان انگلیسی";//====== BY RASHIDI ======
    public static String lbl_edit_ln2 = "ویرایش بخش انگلیسی";//====== BY RASHIDI ======
    public static String lbl_add_ln3 = "افزودن زبان عربی";//====== BY RASHIDI ======
    public static String lbl_edit_ln3 = "ویرایش بخش عربی";//====== BY RASHIDI ======
    public static String lbl_add_ln4 = "افزودن زبان آلمانی";//====== BY RASHIDI ======
    public static String lbl_edit_ln4 = "ویرایش بخش آلمانی";//====== BY RASHIDI ======
    public static String lbl_add_ln5 = "افزودن زبان چینی";//====== BY RASHIDI ======
    public static String lbl_edit_ln5 = "ویرایش بخش چینی";//====== BY RASHIDI ======
    ///<**************LANGUAAGE ADDED*******
    static int pageCounter = 4;
    //By Md

    public static String refresh(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            StringBuilder html = new StringBuilder();
            DefaultTableModel dtm = db.Select(tableName, _lang + "=1");
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);
            html.append("<table id='refreshProduct' class='tahoma10' style='direction: rtl;width:982px'><thead>");
            html.append("<th width='5%'>کد</th>");
            html.append("<th width='20%'>کد محصول</th>");
            html.append("<th width='60%'>عنوان</th>");
            html.append("<th width='10%'>قیمت</th>");
            html.append("<th width='10%'>دسته</th>");
            html.append("<th width='5%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  onclick='cmsProduct.m_select(" + row.get(i).get(_id) + ");' class='mousePointer'>");
                html.append("<td class='c'>" + (row.get(i).get(_id).toString()) + "</td>");
                html.append("<td class='c'>" + (row.get(i).get(_code).toString()) + "</td>");
                html.append("<td class='r'>" + (row.get(i).get(_name).toString()) + "</td>");
                html.append("<td class='l'>" + (row.get(i).get(_price2).toString()) + "</td>");//By Md             
                html.append("<td class='r'>/" + row.get(i).get(_category_id).toString() + "/</td>");
                html.append("<td class='c'><img src='upload/p3285757001.jpg' style='height:30px' /></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
            String height = jjTools.getParameter(request, "height");
            String panel = jjTools.getParameter(request, "panel");
            if (!jjNumber.isDigit(height)) {
                height = "400";
            }
            if (panel.equals("")) {
                panel = "swProductTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += Js.table("#refreshProduct", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "14" : "", "لیست محصولات");
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String add_new(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            StringBuilder options = new StringBuilder();

            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Product_button", "<input type=\"button\" id=\"insert_Product_new\" value=\"" + lbl_insert + "\" class=\"tahoma10\">"));
                html.append(Js.buttonMouseClick("#insert_Product_new", Js.jjProduct.insert()));
            }

            return html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String insert(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            Map<String, Object> map = new HashMap<String, Object>();

            map.put(_code, jjTools.getParameter(request, _code));
            map.put(_name, jjTools.getParameter(request, _name));
            map.put(_quantity, jjTools.getParameter(request, _quantity));//====== BY RASHIDI ======
            map.put(_page, jjTools.getParameter(request, _page));
            map.put(_pic1, jjTools.getParameter(request, _pic1));
            map.put(_pic2, jjTools.getParameter(request, _pic2));
            map.put(_pic3, jjTools.getParameter(request, _pic3));
            map.put(_pic4, jjTools.getParameter(request, _pic4));
            map.put(_pic5, jjTools.getParameter(request, _pic5));
            map.put(_pic6, jjTools.getParameter(request, _pic6));
            map.put(_pic_ext, jjTools.getParameter(request, _pic_ext));
            map.put(_prop1, jjTools.getParameter(request, _prop1));
            map.put(_val1, jjTools.getParameter(request, _val1));
            map.put(_prop2, jjTools.getParameter(request, _prop2));
            map.put(_val2, jjTools.getParameter(request, _val2));
            map.put(_prop3, jjTools.getParameter(request, _prop3));
            map.put(_val3, jjTools.getParameter(request, _val3));
            map.put(_prop4, jjTools.getParameter(request, _prop4));
            map.put(_val4, jjTools.getParameter(request, _val4));
            map.put(_prop5, jjTools.getParameter(request, _prop5));
            map.put(_val5, jjTools.getParameter(request, _val5));
            map.put(_prop6, jjTools.getParameter(request, _prop6));
            map.put(_val6, jjTools.getParameter(request, _val6));
            map.put(_prop7, jjTools.getParameter(request, _prop7));
            map.put(_val7, jjTools.getParameter(request, _val7));
            map.put(_prop8, jjTools.getParameter(request, _prop8));
            map.put(_val8, jjTools.getParameter(request, _val8));
            map.put(_prop9, jjTools.getParameter(request, _prop9));
            map.put(_val9, jjTools.getParameter(request, _val9));
            map.put(_prop10, jjTools.getParameter(request, _prop10));
            map.put(_val10, jjTools.getParameter(request, _val10));
            map.put(_prop11, jjTools.getParameter(request, _prop11));
            map.put(_val11, jjTools.getParameter(request, _val11));
            map.put(_prop12, jjTools.getParameter(request, _prop12));
            map.put(_val12, jjTools.getParameter(request, _val12));
            map.put(_prop13, jjTools.getParameter(request, _prop13));
            map.put(_val13, jjTools.getParameter(request, _val13));
            map.put(_prop14, jjTools.getParameter(request, _prop14));
            map.put(_val14, jjTools.getParameter(request, _val14));
            map.put(_prop15, jjTools.getParameter(request, _prop15));
            map.put(_val15, jjTools.getParameter(request, _val15));
            map.put(_prop16, jjTools.getParameter(request, _prop16));
            map.put(_val16, jjNumber.isDigit(jjTools.getParameter(request, _val16)) ? Integer.parseInt(jjTools.getParameter(request, _val16)) : 0);
            map.put(_prop17, jjTools.getParameter(request, _prop17));
            map.put(_val17, jjNumber.isDigit(jjTools.getParameter(request, _val17)) ? Integer.parseInt(jjTools.getParameter(request, _val17)) : 0);
            map.put(_prop18, jjTools.getParameter(request, _prop18));
            map.put(_val18, jjNumber.isDigit(jjTools.getParameter(request, _val18)) ? Integer.parseInt(jjTools.getParameter(request, _val18)) : 0);
            map.put(_prop19, jjTools.getParameter(request, _prop19));
            map.put(_val19, jjNumber.isDigit(jjTools.getParameter(request, _val19)) ? Integer.parseInt(jjTools.getParameter(request, _val19)) : 0);
            map.put(_prop20, jjTools.getParameter(request, _prop20));
            map.put(_val20, jjNumber.isDigit(jjTools.getParameter(request, _val20)) ? Integer.parseInt(jjTools.getParameter(request, _val20)) : 0);

            map.put(_price1, jjNumber.isDigit(jjTools.getParameter(request, _price1)) ? Integer.parseInt(jjTools.getParameter(request, _price1)) : 0);
            map.put(_price2, jjNumber.isDigit(jjTools.getParameter(request, _price2)) ? Integer.parseInt(jjTools.getParameter(request, _price2)) : 0);
            map.put(_currency, jjTools.getParameter(request, _currency));//====== BY RASHIDI ======
            //By Md
            map.put(_abstract, jjTools.getParameter(request, _abstract));
            map.put(_content, jjTools.getParameter(request, _content));

            String category = jjTools.getParameter(request, _category_id);
            map.put(_category_id, jjNumber.isDigit(category) ? Integer.parseInt(category) : 1);

            String priority = jjTools.getParameter(request, _priority);
            map.put(_priority, jjNumber.isDigit(priority) ? Integer.parseInt(priority) : 0);

            String active = jjTools.getParameter(request, _priority);
            map.put(_active, jjNumber.isDigit(active) ? Integer.parseInt(active) : 0);
            String block = jjTools.getParameter(request, _block);
            map.put(_block, jjNumber.isDigit(block) ? Integer.parseInt(block) : 0);
            String like = jjTools.getParameter(request, _like);
            map.put(_like, jjNumber.isDigit(like) ? Integer.parseInt(like) : 0);
            String dislike = jjTools.getParameter(request, _dislike);
            map.put(_dislike, jjNumber.isDigit(dislike) ? Integer.parseInt(dislike) : 0);
            String order = jjTools.getParameter(request, _order);
            map.put(_order, jjNumber.isDigit(order) ? Integer.parseInt(order) : 0);
            String visit = jjTools.getParameter(request, _visit);
            map.put(_visit, jjNumber.isDigit(visit) ? Integer.parseInt(visit) : 0);

            map.put(_date, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _date), true));

            String parent = jjTools.getParameter(request, _parent);
            map.put(_parent, jjNumber.isDigit(parent) ? Integer.parseInt(parent) : 0);

            String lang = jjTools.getParameter(request, _lang);
            map.put(_lang, jjNumber.isDigit(lang) ? Integer.parseInt(lang) : 1);

            map.put(_tag1, jjTools.getParameter(request, _tag1));
            map.put(_relatedProducts, jjTools.getParameter(request, _relatedProducts));

            map.put(_groupPrice1, jjTools.getParameter(request, _groupPrice1));//====== BY RASHIDI ======
            map.put(_userGroup1, jjTools.getParameter(request, _userGroup1));//====== BY RASHIDI ======
            map.put(_groupPrice2, jjTools.getParameter(request, _groupPrice2));//====== BY RASHIDI ======
            map.put(_userGroup2, jjTools.getParameter(request, _userGroup2));//====== BY RASHIDI ======
            map.put(_groupPrice3, jjTools.getParameter(request, _groupPrice3));//====== BY RASHIDI ======
            map.put(_userGroup3, jjTools.getParameter(request, _userGroup3));//====== BY RASHIDI ======
            map.put(_groupPrice4, jjTools.getParameter(request, _groupPrice4));//====== BY RASHIDI ======
            map.put(_userGroup4, jjTools.getParameter(request, _userGroup4));//====== BY RASHIDI ======
            map.put(_groupPrice5, jjTools.getParameter(request, _groupPrice5));//====== BY RASHIDI ======
            map.put(_userGroup5, jjTools.getParameter(request, _userGroup5));//====== BY RASHIDI ======
            map.put(_taxPercent, jjTools.getParameter(request, _taxPercent));//====== BY RASHIDI ======
            map.put(_discount, jjTools.getParameter(request, _discount));//====== BY RASHIDI ======
//            map.put(_sameProducts, jjTools.getParameter(request, _sameProducts));//====== BY modalaliyan ======

            map.put(_discountDate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _discountDate), true));//====== BY RASHIDI ======
            jjCalendar_IR dateIR = new jjCalendar_IR();//====== BY RASHIDI ======
            map.put(_discountTime, dateIR.getTimeFormat_5length());//====== BY RASHIDI ======

            if (db.insert(tableName, map).getRowCount() == 0) {
                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.getParameter(request, "myLang").equals("en")) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjProduct.refresh();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String edit(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
//            System.out.println("EDIT");
            String id = jjTools.getParameter(request, _id);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_code, jjTools.getParameter(request, _code));
            map.put(_name, jjTools.getParameter(request, _name));
            map.put(_page, jjTools.getParameter(request, _page));
            map.put(_quantity, jjTools.getParameter(request, _quantity));//====== BY RASHIDI ======
            map.put(_hasLink, jjTools.getParameter(request, _hasLink));//============ BY RASHIDI ========
//            map.put(_sameProducts, jjTools.getParameter(request, _sameProducts));//============ BY modalaliyan ========
//            map.put(_pic1, jjTools.getParameter(request, _pic1));
//            map.put(_pic2, jjTools.getParameter(request, _pic2));
//            map.put(_pic3, jjTools.getParameter(request, _pic3));
//            map.put(_pic4, jjTools.getParameter(request, _pic4));
//            map.put(_pic5, jjTools.getParameter(request, _pic5));
//            map.put(_pic6, jjTools.getParameter(request, _pic6));
            //=========================SHAHSANAEI=======================>
            //============ EDITED BY RASHIDI ========>
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));
            Path path;
            String pic = row.get(0).get(_pic1).toString();
//            if ((!pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic1).toString().equalsIgnoreCase("")) || (pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic1).toString().equalsIgnoreCase(""))) {
            if (!jjTools.getParameter(request, _pic1).equalsIgnoreCase(pic)) {
                map.put(_pic1, jjTools.getParameter(request, _pic1));
                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                System.out.println("PATH >>>");
                if (Files.exists(path)) {
                    try {
//                        Files.delete(path);
                        request.setAttribute("fileName", pic);
                        jjFile.deletefile(request, db, isPost);
                    } catch (IOException | SecurityException e) {
                        System.err.println(e);
                    }
                }
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                if (Files.exists(path)) {
//                    try {
//                        Files.delete(path);
//                        ServerLog.Print("Product.edit : file " + pic + " deleted!");
//                    } catch (IOException | SecurityException e) {
//                        System.err.println(e);
//                    }
//                }
            }

            pic = row.get(0).get(_pic2).toString();
//            if ((!pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic2).toString().equalsIgnoreCase("")) || (pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic2).toString().equalsIgnoreCase(""))) {
            if (!jjTools.getParameter(request, _pic2).equalsIgnoreCase(pic)) {
                map.put(_pic2, jjTools.getParameter(request, _pic2));
                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
                if (Files.exists(path)) {
                    try {
//                        Files.delete(path);
                        request.setAttribute("fileName", pic);
                        jjFile.deletefile(request, db, isPost);
                        ServerLog.Print("Product.edit : file " + pic + " deleted!");
                    } catch (IOException | SecurityException e) {
                        System.err.println(e);
                    }
                }
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                if (Files.exists(path)) {
//                    try {
////                        Files.delete(path);
//                        request.setAttribute("fileName", pic);
//                        jjFile.deletefile(request, db, isPost);
//                        ServerLog.Print("Product.edit : file " + pic + " deleted!");
//                    } catch (IOException | SecurityException e) {
//                        System.err.println(e);
//                    }
//                }
            }

            pic = row.get(0).get(_pic3).toString();
//            if ((!pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic3).toString().equalsIgnoreCase("")) || (pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic3).toString().equalsIgnoreCase(""))) {
            if (!jjTools.getParameter(request, _pic3).equalsIgnoreCase(pic)) {
                map.put(_pic3, jjTools.getParameter(request, _pic3));
                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
                if (Files.exists(path)) {
                    try {
//                        Files.delete(path);
                        request.setAttribute("fileName", pic);
                        jjFile.deletefile(request, db, isPost);
                        ServerLog.Print("Product.edit : file " + pic + " deleted!");
                    } catch (IOException | SecurityException e) {
                        System.err.println(e);
                    }
                }
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                if (Files.exists(path)) {
//                    try {
//                        Files.delete(path);
//                        ServerLog.Print("Product.edit : file " + pic + " deleted!");
//                    } catch (IOException | SecurityException e) {
//                        System.err.println(e);
//                    }
//                }
            }

            pic = row.get(0).get(_pic4).toString();
//            if ((!pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic4).toString().equalsIgnoreCase("")) || (pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic4).toString().equalsIgnoreCase(""))) {
            if (!jjTools.getParameter(request, _pic4).equalsIgnoreCase(pic)) {
                map.put(_pic4, jjTools.getParameter(request, _pic4));
                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
                if (Files.exists(path)) {
                    try {
//                        Files.delete(path);
                        request.setAttribute("fileName", pic);
                        jjFile.deletefile(request, db, isPost);
                        ServerLog.Print("Product.edit : file " + pic + " deleted!");
                    } catch (IOException | SecurityException e) {
                        System.err.println(e);
                    }
                }
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                if (Files.exists(path)) {
//                    try {
//                        Files.delete(path);
//                        ServerLog.Print("Product.edit : file " + pic + " deleted!");
//                    } catch (IOException | SecurityException e) {
//                        System.err.println(e);
//                    }
//                }
            }

            pic = row.get(0).get(_pic5).toString();
//            if ((!pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic5).toString().equalsIgnoreCase("")) || (pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic5).toString().equalsIgnoreCase(""))) {
            if (!jjTools.getParameter(request, _pic5).equalsIgnoreCase(pic)) {
                map.put(_pic5, jjTools.getParameter(request, _pic5));
                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
                if (Files.exists(path)) {
                    try {
//                        Files.delete(path);
                        request.setAttribute("fileName", pic);
                        jjFile.deletefile(request, db, isPost);
                        ServerLog.Print("Product.edit : file " + pic + " deleted!");
                    } catch (IOException | SecurityException e) {
                        System.err.println(e);
                    }
                }
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                if (Files.exists(path)) {
//                    try {
//                        Files.delete(path);
//                        ServerLog.Print("Product.edit : file " + pic + " deleted!");
//                    } catch (IOException | SecurityException e) {
//                        System.err.println(e);
//                    }
//                }
            }

            pic = row.get(0).get(_pic6).toString();
//            if ((!pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic6).toString().equalsIgnoreCase("")) || (pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic6).toString().equalsIgnoreCase(""))) {
            if (!jjTools.getParameter(request, _pic6).equalsIgnoreCase(pic)) {
                map.put(_pic6, jjTools.getParameter(request, _pic6));
                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
                if (Files.exists(path)) {
                    try {
//                        Files.delete(path);
                        request.setAttribute("fileName", pic);
                        jjFile.deletefile(request, db, isPost);
                    } catch (IOException | SecurityException e) {
                        System.err.println(e);
                    }
                }
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                if (Files.exists(path)) {
//                    try {
//                        Files.delete(path);
//                    } catch (IOException | SecurityException e) {
//                        System.err.println(e);
//                    }
//                }
            }

            pic = row.get(0).get(_pic_ext).toString();
//            if ((!pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic_ext).toString().equalsIgnoreCase("")) || (pic.equalsIgnoreCase("") && !jjTools.getParameter(request, _pic_ext).toString().equalsIgnoreCase(""))) {
            if (!jjTools.getParameter(request, _pic_ext).equalsIgnoreCase(pic)) {
                map.put(_pic_ext, jjTools.getParameter(request, _pic_ext));
                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
                if (Files.exists(path)) {
                    try {
//                        Files.delete(path);
                        request.setAttribute("fileName", pic);
                        jjFile.deletefile(request, db, isPost);
                    } catch (IOException | SecurityException e) {
                        System.err.println(e);
                    }
                }
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                if (Files.exists(path)) {
//                    try {
//                        Files.delete(path);
//                    } catch (IOException | SecurityException e) {
//                        System.err.println(e);
//                    }
//                }
            }
            //<============ EDITED BY RASHIDI ========
            //<=========================SHAHSANAEI=======================

            map.put(_pic_ext, jjTools.getParameter(request, _pic_ext));
            map.put(_prop1, jjTools.getParameter(request, _prop1));
            map.put(_val1, jjTools.getParameter(request, _val1));
            map.put(_prop2, jjTools.getParameter(request, _prop2));
            map.put(_val2, jjTools.getParameter(request, _val2));
            map.put(_prop3, jjTools.getParameter(request, _prop3));
            map.put(_val3, jjTools.getParameter(request, _val3));
            map.put(_prop4, jjTools.getParameter(request, _prop4));
            map.put(_val4, jjTools.getParameter(request, _val4));
            map.put(_prop5, jjTools.getParameter(request, _prop5));
            map.put(_val5, jjTools.getParameter(request, _val5));
            map.put(_prop6, jjTools.getParameter(request, _prop6));
            map.put(_val6, jjTools.getParameter(request, _val6));
            map.put(_prop7, jjTools.getParameter(request, _prop7));
            map.put(_val7, jjTools.getParameter(request, _val7));
            map.put(_prop8, jjTools.getParameter(request, _prop8));
            map.put(_val8, jjTools.getParameter(request, _val8));
            map.put(_prop9, jjTools.getParameter(request, _prop9));
            map.put(_val9, jjTools.getParameter(request, _val9));
            map.put(_prop10, jjTools.getParameter(request, _prop10));
            map.put(_val10, jjTools.getParameter(request, _val10));
            map.put(_prop11, jjTools.getParameter(request, _prop11));
            map.put(_val11, jjTools.getParameter(request, _val11));
            map.put(_prop12, jjTools.getParameter(request, _prop12));
            map.put(_val12, jjTools.getParameter(request, _val12));
            map.put(_prop13, jjTools.getParameter(request, _prop13));
            map.put(_val13, jjTools.getParameter(request, _val13));
            map.put(_prop14, jjTools.getParameter(request, _prop14));
            map.put(_val14, jjTools.getParameter(request, _val14));
            map.put(_prop15, jjTools.getParameter(request, _prop15));
            map.put(_val15, jjTools.getParameter(request, _val15));
            map.put(_prop16, jjTools.getParameter(request, _prop16));
            map.put(_val16, jjNumber.isDigit(jjTools.getParameter(request, _val16)) ? Integer.parseInt(jjTools.getParameter(request, _val16)) : 0);
            map.put(_prop17, jjTools.getParameter(request, _prop17));
            map.put(_val17, jjNumber.isDigit(jjTools.getParameter(request, _val17)) ? Integer.parseInt(jjTools.getParameter(request, _val17)) : 0);
            map.put(_prop18, jjTools.getParameter(request, _prop18));
            map.put(_val18, jjNumber.isDigit(jjTools.getParameter(request, _val18)) ? Integer.parseInt(jjTools.getParameter(request, _val18)) : 0);
            map.put(_prop19, jjTools.getParameter(request, _prop19));
            map.put(_val19, jjNumber.isDigit(jjTools.getParameter(request, _val19)) ? Integer.parseInt(jjTools.getParameter(request, _val19)) : 0);
            map.put(_prop20, jjTools.getParameter(request, _prop20));
            map.put(_val20, jjNumber.isDigit(jjTools.getParameter(request, _val20)) ? Integer.parseInt(jjTools.getParameter(request, _val20)) : 0);

            map.put(_price1, jjNumber.isDigit(jjTools.getParameter(request, _price1)) ? Integer.parseInt(jjTools.getParameter(request, _price1)) : 0);
            map.put(_price2, jjNumber.isDigit(jjTools.getParameter(request, _price2)) ? Integer.parseInt(jjTools.getParameter(request, _price2)) : 0);
            map.put(_currency, jjTools.getParameter(request, _currency));//============ BY RASHIDI ========
            //By Md
            map.put(_abstract, jjTools.getParameter(request, _abstract));
            map.put(_content, jjTools.getParameter(request, _content));

            String category = jjTools.getParameter(request, _category_id);
            map.put(_category_id, jjNumber.isDigit(category) ? Integer.parseInt(category) : 1);

            String priority = jjTools.getParameter(request, _priority);
            map.put(_priority, jjNumber.isDigit(priority) ? Integer.parseInt(priority) : 0);

            map.put(_date, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _date), true));

            String active = jjTools.getParameter(request, _active);
            map.put(_active, jjNumber.isDigit(active) ? Integer.parseInt(active) : 1);
            String block = jjTools.getParameter(request, _block);
            map.put(_block, jjNumber.isDigit(block) ? Integer.parseInt(block) : 0);
            String like = jjTools.getParameter(request, _like);
            map.put(_like, jjNumber.isDigit(like) ? Integer.parseInt(like) : 0);
            String dislike = jjTools.getParameter(request, _dislike);
            map.put(_dislike, jjNumber.isDigit(dislike) ? Integer.parseInt(dislike) : 0);
            String order = jjTools.getParameter(request, _order);
            map.put(_order, jjNumber.isDigit(order) ? Integer.parseInt(order) : 0);
            String visit = jjTools.getParameter(request, _visit);
            map.put(_visit, jjNumber.isDigit(visit) ? Integer.parseInt(visit) : 0);
            String rating = jjTools.getParameter(request, _rating);
            map.put(_rating, jjNumber.isDigit(rating) ? Integer.parseInt(rating) : 0);

            map.put(_tag1, jjTools.getParameter(request, _tag1));
            map.put(_relatedProducts, jjTools.getParameter(request, _relatedProducts));

            map.put(_groupPrice1, jjTools.getParameter(request, _groupPrice1));//====== BY RASHIDI ======
            map.put(_userGroup1, jjTools.getParameter(request, _userGroup1));//====== BY RASHIDI ======
            map.put(_groupPrice2, jjTools.getParameter(request, _groupPrice2));//====== BY RASHIDI ======
            map.put(_userGroup2, jjTools.getParameter(request, _userGroup2));//====== BY RASHIDI ======
            map.put(_groupPrice3, jjTools.getParameter(request, _groupPrice3));//====== BY RASHIDI ======
            map.put(_userGroup3, jjTools.getParameter(request, _userGroup3));//====== BY RASHIDI ======
            map.put(_groupPrice4, jjTools.getParameter(request, _groupPrice4));//====== BY RASHIDI ======
            map.put(_userGroup4, jjTools.getParameter(request, _userGroup4));//====== BY RASHIDI ======
            map.put(_groupPrice5, jjTools.getParameter(request, _groupPrice5));//====== BY RASHIDI ======
            map.put(_userGroup5, jjTools.getParameter(request, _userGroup5));//====== BY RASHIDI ======
            map.put(_taxPercent, jjTools.getParameter(request, _taxPercent));//====== BY RASHIDI ======

            map.put(_discount, jjTools.getParameter(request, _discount));//====== BY RASHIDI ======
            map.put(_discountDate, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _discountDate), true));//====== BY RASHIDI ======

            jjCalendar_IR dateIR = new jjCalendar_IR();//====== BY RASHIDI ======
            map.put(_discountTime, dateIR.getTimeFormat_5length());//====== BY RASHIDI ======

//            map.put(_active, jjTools.getParameter(request, _active));
//            map.put(_block, jjTools.getParameter(request, _block));
            String parent = jjTools.getParameter(request, _parent);
            map.put(_parent, jjNumber.isDigit(parent) ? Integer.parseInt(parent) : 0);

            String lang = jjTools.getParameter(request, _lang);
            map.put(_lang, jjNumber.isDigit(lang) ? Integer.parseInt(lang) : 1);

//            String id = jjTools.getParameter(request, _id);
//            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
//            if (!errorMessageId.equals("")) {
//                if (jjTools.isLangEn(request)) {
//                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
//                }
//                return Js.dialog(errorMessageId);
//            }
            if (!db.update(tableName, map, _id + "=" + jjTools.getParameter(request, _id))) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjProduct.refresh();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String delete(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            //delete pictures of a product when it removed------------------>
            //=================================SHAHSANAEI==============================>
            //============ EDITED BY RASHIDI ========>
            String id = jjTools.getParameter(request, "id");
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(tableName, _id + "=" + id));
            Path path;
            try {
//                String pic = row.get(0).get(_pic1).toString();
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
                request.setAttribute("fileName", row.get(0).get(_pic1).toString());
                jjFile.deletefile(request, db, isPost);
//                pic = row.get(0).get(_pic2).toString();
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
                request.setAttribute("fileName", row.get(0).get(_pic2).toString());
                jjFile.deletefile(request, db, isPost);
//                pic = row.get(0).get(_pic3).toString();
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
                request.setAttribute("fileName", row.get(0).get(_pic3).toString());
                jjFile.deletefile(request, db, isPost);
//                pic = row.get(0).get(_pic4).toString();
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);//
//                Files.delete(path);
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
                request.setAttribute("fileName", row.get(0).get(_pic4).toString());
                jjFile.deletefile(request, db, isPost);
//                pic = row.get(0).get(_pic5).toString();
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
                request.setAttribute("fileName", row.get(0).get(_pic5).toString());
                jjFile.deletefile(request, db, isPost);
//                pic = row.get(0).get(_pic6).toString();
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
                request.setAttribute("fileName", row.get(0).get(_pic6).toString());
                jjFile.deletefile(request, db, isPost);
//                pic = row.get(0).get(_pic_ext).toString();
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
//                pic = pic.replace(".", "_small.");
//                path = FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/upload"), pic);
//                Files.delete(path);
                request.setAttribute("fileName", row.get(0).get(_pic_ext).toString());
                jjFile.deletefile(request, db, isPost);
            } catch (IOException | SecurityException e) {
                System.err.println(e);
            }
            //<============ EDITED BY RASHIDI ========
            //<===============================SHAHSANAEI==============================
//            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }
            if (!db.delete(tableName, _id + "=" + id + " OR " + _parent + " = " + id)) {//============ EDITED BY RASHIDI ========
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                return Js.dialog(errorMessage);
            }
            return Js.jjProduct.refresh();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String select(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }
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
            StringBuilder html3 = new StringBuilder();

            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setVal(_id, row.get(0).get(_id)));
            html.append(Js.setVal(_code, row.get(0).get(_code)));
            html.append(Js.setVal(_name, row.get(0).get(_name)));
            html.append(Js.setVal(_quantity, row.get(0).get(_quantity)));//====== BY RASHIDI ======
//            html.append(Js.setVal(_sameProducts, row.get(0).get(_sameProducts)));//====== BY  modalaliyan ======
            html.append(Js.setVal(_page, row.get(0).get(_page)));
            html.append(Js.setVal(_pic1, row.get(0).get(_pic1)));
            html.append(Js.setVal(_pic2, row.get(0).get(_pic2)));
            html.append(Js.setVal(_pic3, row.get(0).get(_pic3)));
            html.append(Js.setVal(_pic4, row.get(0).get(_pic4)));
            html.append(Js.setVal(_pic5, row.get(0).get(_pic5)));
            html.append(Js.setVal(_pic6, row.get(0).get(_pic6)));
            html.append(Js.setVal(_pic_ext, row.get(0).get(_pic_ext)));
            html.append(Js.setVal(_price1, row.get(0).get(_price1)));
            html.append(Js.setVal(_price2, row.get(0).get(_price2)));
            html.append(Js.setVal(_currency, row.get(0).get(_currency)));//====== BY RASHIDI ======
            html.append(Js.setVal(_prop1, row.get(0).get(_prop1)));
            html.append(Js.setVal(_prop2, row.get(0).get(_prop2)));
            html.append(Js.setVal(_prop3, row.get(0).get(_prop3)));
            html.append(Js.setVal(_prop4, row.get(0).get(_prop4)));
            html.append(Js.setVal(_prop5, row.get(0).get(_prop5)));
            html.append(Js.setVal(_prop6, row.get(0).get(_prop6)));
            html.append(Js.setVal(_prop7, row.get(0).get(_prop7)));
            html.append(Js.setVal(_prop8, row.get(0).get(_prop8)));
            html.append(Js.setVal(_prop9, row.get(0).get(_prop9)));
            html.append(Js.setVal(_prop10, row.get(0).get(_prop10)));
            html.append(Js.setVal(_prop11, row.get(0).get(_prop11)));
            html.append(Js.setVal(_prop12, row.get(0).get(_prop12)));
            html.append(Js.setVal(_prop13, row.get(0).get(_prop13)));
            html.append(Js.setVal(_prop14, row.get(0).get(_prop14)));
            html.append(Js.setVal(_prop15, row.get(0).get(_prop15)));
            html.append(Js.setVal(_prop16, row.get(0).get(_prop16)));
            html.append(Js.setVal(_prop17, row.get(0).get(_prop17)));
            html.append(Js.setVal(_prop18, row.get(0).get(_prop18)));
            html.append(Js.setVal(_prop19, row.get(0).get(_prop19)));
            html.append(Js.setVal(_prop20, row.get(0).get(_prop20)));
            html.append(Js.setVal(_val1, row.get(0).get(_val1)));
            html.append(Js.setVal(_val2, row.get(0).get(_val2)));
            html.append(Js.setVal(_val3, row.get(0).get(_val3)));
            html.append(Js.setVal(_val4, row.get(0).get(_val4)));
            html.append(Js.setVal(_val5, row.get(0).get(_val5)));
            html.append(Js.setVal(_val6, row.get(0).get(_val6)));
            html.append(Js.setVal(_val7, row.get(0).get(_val7)));
            html.append(Js.setVal(_val8, row.get(0).get(_val8)));
            html.append(Js.setVal(_val9, row.get(0).get(_val9)));
            html.append(Js.setVal(_val10, row.get(0).get(_val10)));
            html.append(Js.setVal(_val11, row.get(0).get(_val11)));
            html.append(Js.setVal(_val12, row.get(0).get(_val12)));
            html.append(Js.setVal(_val13, row.get(0).get(_val13)));
            html.append(Js.setVal(_val14, row.get(0).get(_val14)));
            html.append(Js.setVal(_val15, row.get(0).get(_val15)));
            html.append(Js.setVal(_val16, row.get(0).get(_val16)));
            html.append(Js.setVal(_val17, row.get(0).get(_val17)));
            html.append(Js.setVal(_val18, row.get(0).get(_val18)));
            html.append(Js.setVal(_val19, row.get(0).get(_val19)));
            html.append(Js.setVal(_val20, row.get(0).get(_val20)));
//            html.append(Js.setVal(_sameProducts, row.get(0).get(_sameProducts)));

            html.append(Js.setVal(_groupPrice1, row.get(0).get(_groupPrice1) == "" ? row.get(0).get(_price2) : row.get(0).get(_groupPrice1)));//====== BY RASHIDI ======
            html.append(Js.setVal(_groupPrice2, row.get(0).get(_groupPrice2) == "" ? row.get(0).get(_price2) : row.get(0).get(_groupPrice2)));//====== BY RASHIDI ======
            html.append(Js.setVal(_groupPrice3, row.get(0).get(_groupPrice3) == "" ? row.get(0).get(_price2) : row.get(0).get(_groupPrice3)));//====== BY RASHIDI ======
            html.append(Js.setVal(_groupPrice4, row.get(0).get(_groupPrice4) == "" ? row.get(0).get(_price2) : row.get(0).get(_groupPrice4)));//====== BY RASHIDI ======
            html.append(Js.setVal(_groupPrice5, row.get(0).get(_groupPrice5) == "" ? row.get(0).get(_price2) : row.get(0).get(_groupPrice5)));//====== BY RASHIDI ======
            html.append(Js.setVal(_userGroup1, row.get(0).get(_userGroup1)));//====== BY RASHIDI ======
            html.append(Js.setVal(_userGroup2, row.get(0).get(_userGroup2)));//====== BY RASHIDI ======
            html.append(Js.setVal(_userGroup3, row.get(0).get(_userGroup3)));//====== BY RASHIDI ======
            html.append(Js.setVal(_userGroup4, row.get(0).get(_userGroup4)));//====== BY RASHIDI ======
            html.append(Js.setVal(_userGroup5, row.get(0).get(_userGroup5)));//====== BY RASHIDI ======
            html.append(Js.setVal(_taxPercent, row.get(0).get(_taxPercent)));//====== BY RASHIDI ======

            html.append(Js.setVal(_discount, row.get(0).get(_discount)));//====== BY RASHIDI ======
            html.append(Js.setVal(_discountDate, jjCalendar_IR.getViewFormat(row.get(0).get(_discountDate).toString())));//====== BY RASHIDI ======

            boolean accDel = Access_User.hasAccess2(request, db, rul_dlt);
            boolean accEdt = Access_User.hasAccess2(request, db, rul_edt);
            //By Md 
            ///**************LANGUAAGE ADDED*******>
//            boolean acclng = Access_User.hasAccess2(request, db, rul_lng);//====== COMMENTED BY RASHIDI ======
            boolean acclng2 = Access_User.hasAccess2(request, db, rul_lng2);//====== BY RASHIDI ======
            boolean acclng3 = Access_User.hasAccess2(request, db, rul_lng3);//====== BY RASHIDI ======
            boolean acclng4 = Access_User.hasAccess2(request, db, rul_lng4);//====== BY RASHIDI ======
            boolean acclng5 = Access_User.hasAccess2(request, db, rul_lng5);//====== BY RASHIDI ======
            ///<**************LANGUAAGE ADDED*******
            html.append(Js.setVal(_abstract, row.get(0).get(_abstract)));
            html.append(Js.setValEditor(_content, row.get(0).get(_content)));
            /*اگر محصول عکس داشت*/
            if (!row.get(0).get(_pic1).toString().isEmpty()) {
                html.append(Js.setAttr("#productPicPreview1", "src", "upload/" + row.get(0).get(_pic1).toString()));
            }
            /*اگر محصول عکس داشت*/
            if (!row.get(0).get(_pic2).toString().isEmpty()) {
                html.append(Js.setAttr("#productPicPreview2", "src", "upload/" + row.get(0).get(_pic2).toString()));
            }
            /*اگر محصول عکس داشت*/
            if (!row.get(0).get(_pic3).toString().isEmpty()) {
                html.append(Js.setAttr("#productPicPreview3", "src", "upload/" + row.get(0).get(_pic3).toString()));
            }
            /*اگر محصول عکس داشت*/
            if (!row.get(0).get(_pic4).toString().isEmpty()) {
                html.append(Js.setAttr("#productPicPreview4", "src", "upload/" + row.get(0).get(_pic4).toString()));
            }
            /*اگر محصول عکس داشت*/
            if (!row.get(0).get(_pic5).toString().isEmpty()) {
                html.append(Js.setAttr("#productPicPreview5", "src", "upload/" + row.get(0).get(_pic5).toString()));
            }
            /*اگر محصول عکس داشت*/
            if (!row.get(0).get(_pic6).toString().isEmpty()) {
                html.append(Js.setAttr("#productPicPreview6", "src", "upload/" + row.get(0).get(_pic6).toString()));
            }
            /*اگر محصول عکس داشت*/
            if (!row.get(0).get(_pic_ext).toString().isEmpty()) {
                html.append(Js.setAttr("#productPicPreviewExt", "src", "upload/" + row.get(0).get(_pic_ext).toString()));
            }

            html.append(Js.setVal(_priority, row.get(0).get(_priority)));
            html.append(Js.setVal("#" + _date, jjCalendar_IR.getViewFormat(row.get(0).get(_date).toString())));

            html.append(Js.setVal(_lang, row.get(0).get(_lang)));
            html.append(Js.setVal(_parent, row.get(0).get(_parent)));

            Integer likes = Integer.valueOf(row.get(0).get(_like).toString());
            html.append(Js.setVal(_like, likes));
            if (likes < 0) {//That means it is disabled now and it has been enabled
                html.append(Js.setVal(_like + "_checkbox", 0));
                html.append(Js.setAttr(_like, "disabled", "true"));
            } else {
                html.append(Js.setVal(_like + "_checkbox", 1));
                html.append(Js.removeAttr(_like, "disabled"));
            }

            Integer dislikes = Integer.valueOf(row.get(0).get(_dislike).toString());
            html.append(Js.setVal(_dislike, dislikes));
            if (dislikes < 0) {//That means it is disabled now and it has been enabled
                html.append(Js.setVal(_dislike + "_checkbox", 0));
                html.append(Js.setAttr("#" + _dislike, "disabled", "true"));
            } else {
                html.append(Js.setVal(_dislike + "_checkbox", 1));
                html.append(Js.removeAttr(_dislike, "disabled"));
            }

            Integer visit = Integer.valueOf(row.get(0).get(_visit).toString());
            html.append(Js.setVal(_visit, visit));
            if (visit < 0) {//That means it is disabled now and it has been enabled
                html.append(Js.setVal(_visit + "_checkbox", 0));
                html.append(Js.setAttr(_visit, "disabled", "true"));
            } else {
                html.append(Js.setVal(_visit + "_checkbox", 1));
                html.append(Js.removeAttr(_visit, "disabled"));
            }
            html.append(Js.setVal("#" + _hasLink, row.get(0).get(_hasLink))); //============ BY RASHIDI ========
            //-------------------------------------------------------------------------------------چرا به نوع داده امتیاز ایراد میگیره؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟؟/
//            Integer rating = Integer.valueOf(row.get(0).get(_rating).toString());
//            html.append(Js.setVal(_rating, rating));
//            if (rating < 0) {//That means it is disabled now and it has been enabled
//                html.append(Js.setVal(_rating + "_checkbox", 0));
//                html.append(Js.setAttr(_rating, "disabled", "true"));
//            } else {
//                html.append(Js.setVal(_rating + "_checkbox", 1));
//                html.append(Js.removeAttr(_rating, "disabled"));
//            }

            Integer order = Integer.valueOf(row.get(0).get(_order).toString());
            html.append(Js.setVal(_order, order));
            if (visit < 0) {//That means it is disabled now and it has been enabled
                html.append(Js.setVal(_order + "_checkbox", 0));
                html.append(Js.setAttr(_order, "disabled", "true"));
            } else {
                html.append(Js.setVal(_order + "_checkbox", 1));
                html.append(Js.removeAttr(_order, "disabled"));
            }

            //html.append(Js.setValEditor(_content, row.get(0).get(_content)));
            if (accEdt) {
                html2.append("<input type=\"button\" id=\"edit_Product\" value=\"" + lbl_edit + "\" class=\"tahoma10\">");
                html.append(Js.buttonMouseClick("#edit_Product", Js.jjProduct.edit()));
            }
            if (accDel) {
                html2.append("<input type=\"button\" id=\"delete_Product\" value=\"" + lbl_delete + "\" class=\"tahoma10\"  />");
                html.append(Js.buttonMouseClick("#delete_Product", Js.jjProduct.delete(id)));
            }

            //By Md
            //============ BY RASHIDI ========>
            ///**************LANGUAAGE ADDED*******>
//            if (acclng) {
//                List<Map<String, Object>> rowEn = jjDatabase.separateRow(db.Select(tableName, _parent + "=" + id + " AND " + _lang + "=2"));
//                if (rowEn.size() > 0) {
//                    script.append("<input type='button' id='edit_en_product' value='" + lbl_edit_en + "' class='tahoma10'  />");
//                    html.append(Js.buttonMouseClick("#edit_en_product", Js.jjProduct.select(rowEn.get(0).get(_id).toString())));
//                } else {
//                    if (row.get(0).get(_parent).equals("0")) {
//                        script.append("<input type='button' id='add_en_product' value='" + lbl_add_en + "' class='tahoma10' />");
//                        html.append(Js.buttonMouseClick("#add_en_product", Js.jjProduct.addEN(id)));
//                    }
//                }
//                List<Map<String, Object>> rowAr = jjDatabase.separateRow(db.Select(tableName, _parent + "=" + id + " AND " + _lang + "=3"));
//                if (rowAr.size() > 0) {
//                    script.append("<input type='button' id='edit_ar_product' value='" + lbl_edit_ar + "' class='tahoma10'  />");
//                    html.append(Js.buttonMouseClick("#edit_ar_product", Js.jjProduct.select(rowAr.get(0).get(_id).toString())));
//                } else {
//                    if (row.get(0).get(_parent).equals("0")) {
//                        script.append("<input type='button' id='add_ar_product' value='" + lbl_add_ar + "' class='tahoma10' />");
//                        html.append(Js.buttonMouseClick("#add_ar_product", Js.jjProduct.addAr(id)));
//                    }
//                }
//            }
            if (acclng2) {
                List<Map<String, Object>> row2 = jjDatabase.separateRow(db.Select(tableName, _parent + "=" + id + " AND " + _lang + "=2"));
                if (row2.size() > 0) {
                    html3.append("<input type='button' id='edit_ln2_product' value='" + lbl_edit_ln2 + "' class='tahoma10'  />");
                    html.append(Js.buttonMouseClick("#edit_ln2_product", Js.jjProduct.select(row2.get(0).get(_id).toString())));
                } else {
                    if (row.get(0).get(_parent).equals("0")) {
                        html3.append("<input type='button' id='add_ln2_product' value='" + lbl_add_ln2 + "' class='tahoma10' />");
                        html.append(Js.buttonMouseClick("#add_ln2_product", Js.jjProduct.addLang(Integer.parseInt(id), 2)));
                    }
                }
            }
            if (acclng3) {
                List<Map<String, Object>> row3 = jjDatabase.separateRow(db.Select(tableName, _parent + "=" + id + " AND " + _lang + "=3"));
                if (row3.size() > 0) {
                    html3.append("<input type='button' id='edit_ln3_product' value='" + lbl_edit_ln3 + "' class='tahoma10'  />");
                    html.append(Js.buttonMouseClick("#edit_ln3_product", Js.jjProduct.select(row3.get(0).get(_id).toString())));
                } else {
                    if (row.get(0).get(_parent).equals("0")) {
                        html3.append("<input type='button' id='add_ln3_product' value='" + lbl_add_ln3 + "' class='tahoma10' />");
                        html.append(Js.buttonMouseClick("#add_ln3_product", Js.jjProduct.addLang(Integer.parseInt(id), 3)));
                    }
                }
            }
            if (acclng4) {
                List<Map<String, Object>> row4 = jjDatabase.separateRow(db.Select(tableName, _parent + "=" + id + " AND " + _lang + "=4"));
                if (row4.size() > 0) {
                    html3.append("<input type='button' id='edit_ln4_product' value='" + lbl_edit_ln4 + "' class='tahoma10'  />");
                    html.append(Js.buttonMouseClick("#edit_ln4_product", Js.jjProduct.select(row4.get(0).get(_id).toString())));
                } else {
                    if (row.get(0).get(_parent).equals("0")) {
                        html3.append("<input type='button' id='add_ln4_product' value='" + lbl_add_ln4 + "' class='tahoma10' />");
                        html.append(Js.buttonMouseClick("#add_ln4_product", Js.jjProduct.addLang(Integer.parseInt(id), 4)));
                    }
                }
            }
            if (acclng5) {
                List<Map<String, Object>> row5 = jjDatabase.separateRow(db.Select(tableName, _parent + "=" + id + " AND " + _lang + "=5"));
                if (row5.size() > 0) {
                    html3.append("<input type='button' id='edit_ln5_product' value='" + lbl_edit_ln5 + "' class='tahoma10'  />");
                    html.append(Js.buttonMouseClick("#edit_ln5_product", Js.jjProduct.select(row5.get(0).get(_id).toString())));
                } else {
                    if (row.get(0).get(_parent).equals("0")) {
                        html3.append("<input type='button' id='add_ln5_product' value='" + lbl_add_ln5 + "' class='tahoma10' />");
                        html.append(Js.buttonMouseClick("#add_ln5_product", Js.jjProduct.addLang(Integer.parseInt(id), 5)));
                    }
                }
            }
            html.append(Js.show("#Product_Language_button"));
            return (Js.setHtml("#Product_button", html2.toString())) + Js.setHtml("#Product_Language_button", html3) + html.toString();

            ///<**************LANGUAAGE ADDED*******
            //<============ BY RASHIDI ========
//            return (Js.setHtml("#Product_button", script.toString())) + html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String buyOneProduct(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, "id");
            String panel = jjTools.getParameter(request, "panel");
            String pr = panel.replace("pr", "");
            if (!id.equals("")) {
                List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _name + " LIKE '%" + id + "%' OR " + _code + " LIKE '%" + id + "%' " + (jjNumber.isDigit(id) ? "OR id=" + id : "")));
                if (row.size() > 0) {
                    String find = "";
                    for (int i = 0; i < row.size(); i++) {
                        find += "<a style='color:blue' onclick='setProductToFactor(" + row.get(i).get(_id) + "," + pr + ");'>"
                                + row.get(i).get(_id) + ". " + row.get(i).get(_name) + "</a><br/>";
                    }
                    return Js.setHtml("#" + panel, find) + (row.size() > 0 ? Js.setVal("#account_factor_pr_id_" + pr, row.get(0).get(_id)) : "");
                } else {
                    return Js.setHtml("#" + panel, "موردی یافت نشد.") + Js.setVal("#" + panel, "") + Js.setVal("#account_factor_pr_id_" + pr, "");
                }
            } else {
                return Js.setHtml("#" + panel, "");
            }
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String searchProduct(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String text = jjTools.getParameter(request, "text");
            String panel = jjTools.getParameter(request, "panel");
            String pr = panel.replace("pr", "");
            if (!text.equals("")) {
                List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _name + " LIKE '%" + text + "%' OR " + _code + " LIKE '%" + text + "%' " + (jjNumber.isDigit(text) ? "OR id=" + text : "")));
                if (row.size() > 0) {
                    String find = "";
                    for (int i = 0; i < row.size(); i++) {
                        find += "<a style='color:blue' onclick='setProductToFactor(" + row.get(i).get(_id) + "," + pr + ");'>"
                                + row.get(i).get(_id) + ". " + row.get(i).get(_name) + "</a><br/>";
                    }
                    return Js.setHtml("#" + panel, find) + (row.size() > 0 ? Js.setVal("#account_factor_pr_id_" + pr, row.get(0).get(_id)) : "");
                } else {
                    return Js.setHtml("#" + panel, "موردی یافت نشد.") + Js.setVal("#" + panel, "") + Js.setVal("#account_factor_pr_id_" + pr, "");
                }
            } else {
                return Js.setHtml("#" + panel, "");
            }
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String setProductToFactor(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String panel = jjTools.getParameter(request, "panel");
            String pr = panel.replace("pr", "");
            String hasAccess = Access_User.getAccessDialog(request, db, rul_dlt);
            if (!hasAccess.equals("")) {
                return hasAccess;
            }
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "مشتری با این کد وجود ندارد";
                return Js.dialog(errorMessage);
            }

            StringBuilder html = new StringBuilder();

            html.append(Js.setVal("#account_factor_pr_name_" + pr, row.get(0).get(_name)));
            html.append(Js.setVal("#account_factor_pr_unit_" + pr, row.get(0).get(_val1)));
            html.append(Js.setVal("#account_factor_pr_fee_" + pr, row.get(0).get(_price2)));
            html.append(Js.setVal("#" + _id + "_" + pr, row.get(0).get(_id)));
            html.append("calculateSum").append(pr).append("();\n");
            return html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
    /*
     *return a list of product by catrgory_id /n if catrgory_id==0 then return top product(cat 1,2) *
     */

    public static String getList2(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {//new in v1.5.0         
        try {
            //============ BY RASHIDI ========>
            String userId = jjTools.getSessionAttribute(request, "#" + Access_User._id.toUpperCase());
            String price = "";
            String discountPrice = "";
            //<============BY RASHIDI ========
            if (jjTools.isLangEn(request)) {
                return getList_En(request, db, isPost);
            }
            if (jjTools.isLangAr(request)) {
                return getList_Ar(request, db, isPost);
            }
            StringBuilder html = new StringBuilder();//for Div,Span and other Html elements
            StringBuffer html3 = new StringBuffer();//for JQuery statements
            String panel = jjTools.getParameter(request, "panel");
            panel = panel == null ? "sw" : panel;
            /*طبقه بندی محصولات را برمیگرداند*/
//            html3.append(Category_Product.getHierarchyDiv(re, db));
            Integer category_id = new Integer(jjTools.getParameter(request, "id"));
//          category_id = jjNumber.isDigit(jjTools.getParameter(request, "id").toString()) ? id : 1;
            List<Map<String, Object>> topProductRow;
            if (category_id == 0) {
                topProductRow = jjDatabase.separateRow(
                        db.Select(Product.tableName, Product._lang + "=1 AND " + Product._priority + "<=2"));
            } else {
                topProductRow = jjDatabase.separateRow(
                        db.Select(Product.tableName, Product._lang + "=1 AND " + Product._category_id + "=" + category_id));
            }

            //---------------one product post creation
            /*لیست محصولات را بر میگرداند*/
            StringBuilder temphtml = new StringBuilder();//for Div,Span and other Html elements
            html.append("<div id='swTopproductDiv' class='topproductDiv'></div>");
            if (topProductRow.isEmpty()) {
                temphtml.append("<div class='noAnyThing'><span>!!! در این بخش موردی برای نمایش وجود ندارد</span></div>");
            } else {
                for (int i = 0; i < topProductRow.size(); i++) {
                    String id = topProductRow.get(i).get(_id).toString();
                    temphtml.append("<div class='productmainDiv'>");
//                    temphtml.append("<span class='productDatespan'>" + jjCalendar_IR.getViewFormat(topProductRow.get(i).get(_date).toString()) + "</span>");
                    int visit = new Integer(topProductRow.get(i).get(_visit).toString());
                    if (visit >= 0) {
                        temphtml.append("<div class='prVDiv'> <span>" + visit + " بار مشاهده </span></div>");//==> prVDiv : productvisitDiv
                    }
                    int disLikes = new Integer(topProductRow.get(i).get(_dislike).toString());
                    if (disLikes >= 0) {
                        temphtml.append("<div class='prDLDiv' onclick='productDisLike(" + id + ");' > <span>" + disLikes + " مخالف </span></div>");//==> prDLDiv : productDisLikeDiv
                    }
                    int likes = new Integer(topProductRow.get(i).get(_like).toString());
                    if (likes >= 0) {
                        temphtml.append("<div class='prLDiv' onclick='productLike(" + id + ");'>  <span>" + likes + " موافق </span></div>");//==> prLDiv : productlikeDiv
                    }
                    //============ EDITED BY RASHIDI ========>
                    String src1 = topProductRow.get(i).get(_pic1).toString();
//                    String src2 = topProductRow.get(i).get(_pic2).toString();
//                    String src3 = topProductRow.get(i).get(_pic3).toString();
//                    String src4 = topProductRow.get(i).get(_pic4).toString();
//                    String src5 = topProductRow.get(i).get(_pic5).toString();
//                    String src6 = topProductRow.get(i).get(_pic6).toString();
//                    String src_ext = topProductRow.get(i).get(_pic_ext).toString();

                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src1.matches("upload/p[0-9]{10}.{4}")) {
                    String smalPicSrc = src1.replace(".", "_small.");//select small pic
                    temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'  onclick='getOneproduct(" + id + ")';/>");//======EDITED BY RASHIDI ======
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src1 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src2.matches("upload/p[0-9]{10}.{4}")) {
//                      smalPicSrc = src2.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src2 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src3.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src3.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src3 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src4.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src4.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src4 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src5.matches("upload/p[0-9]{10}.{4}")) {
//                        smalPicSrc = src5.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src5 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src6.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src6.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src6 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src_ext.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src_ext.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src_ext + "'/>");
//                    }

                    //<============ EDITED BY RASHIDI ========
                    temphtml.append("<span class='productTitlespan'><h3>" + topProductRow.get(i).get(_name).toString() + "</h3></span>");
                    //============ BY RASHIDI ========>
                    int quantity = new Integer(topProductRow.get(i).get(_quantity).toString());
                    if (quantity <= 0) {
                        temphtml.append("<div class='prQDiv'>  <span> نا موجود</span></div>");//==> prQDiv : productlQuantityDiv
                    } else {
                        temphtml.append("<div class='prQDiv'>  <span> تعداد موجود  " + quantity + " </span></div>");//==> prQDiv : productlQuantityDiv
                    }
                    //======>PRICE
                    if (userId.equals("")) {//اگر کاربر لاگین نکرده باشد و آی دی اش در سشن نباشد
                        price = topProductRow.get(i).get(_price2).toString();//قیمت اصلی را به کاربر نمایش می دهد
                        discountPrice = topProductRow.get(i).get(_discount).toString() == "" ? "" : topProductRow.get(i).get(_discount).toString();//اگر تخفیف برایش در نظر گرفته شود تخفیف هم نمایش داده می شود.
                    } else {//اگر کاربر لاگین کرده باشد
                        List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_Group_User.tableName, Access_Group_User._user_id + " = " + userId));//گروه کاربر را واکشی می کند
                        if (!userRow.isEmpty()) {//اگر کاربر عضو گروهی باشد که قیمت ویژه برای آن ست شده است قیمت مربوط به آن گروه نمایش داده می شود
                            String userGroup = userRow.get(0).get(Access_Group_User._group_id).toString();
//                            ServerLog.Print("userGroup " + userGroup);
                            if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup1).toString())) {
                                price = topProductRow.get(i).get(_groupPrice1).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup2).toString())) {
                                price = topProductRow.get(i).get(_groupPrice2).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup3).toString())) {
                                price = topProductRow.get(i).get(_groupPrice3).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup4).toString())) {
                                price = topProductRow.get(i).get(_groupPrice4).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup5).toString())) {
                                price = topProductRow.get(i).get(_groupPrice5).toString();
                            } else {
                                price = topProductRow.get(i).get(_price2).toString();
                            }
                        } else {//اگر کاربر عادی باشد قیمت اصلی نمایش داده میشود
                            price = topProductRow.get(i).get(_price2).toString();
                            discountPrice = topProductRow.get(i).get(_discount).toString() == "" ? "" : topProductRow.get(i).get(_discount).toString();
                        }
                    }
                    ServerLog.Print("PRICE : " + price);
                    ServerLog.Print("DISCOUNTPRICE : " + discountPrice);

                    if (discountPrice.equalsIgnoreCase("")) {//اگر کالا تخفیف نداشت یا کاربر عضو گروهی بود فقط قیمت اصلی نمایش داده می شود
                        temphtml.append("<span class='productTitlespan'><h3>" + price + "</h3></span>");
                    } else {//اگر کالا تخفیف داشت  قیمت اصلی و  قیمت تخفیف و زمان باقی مانده تا اتمام تخفیف نمایش داده می شود

                        //=======> Time of Discount
                        //محاسبه زمان باقی مانده تا پایان تخفیف
                        jjCalendar_IR dateIR = new jjCalendar_IR();
//                        System.out.println("DATE : " + dateIR.getDBFormat_8length());

                        int remainTime = Integer.parseInt(topProductRow.get(i).get(_discountDate).toString()) - dateIR.getDBFormat_8length();//تعداد روزهای باقی مانده
                        ServerLog.Print("remain day : " + remainTime);

                        if (remainTime > 0) {//اگر بیشتر از یک روز تا پایان تخفیف مانده باشد.
                            temphtml.append("<span class='productTitlespan'><h3 style='text-decoration: line-through;' >" + price + "</h3></span>");
                            temphtml.append("<span class='productTitlespan'><h3>" + discountPrice + "</h3></span>");
                            temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainTime + " روز</h3></span>");
                        } else if (remainTime == 0) {//اگر کمتر از یک روز تا پایان تخفیف مانده باشد بر حسب ساعت و دقیقه زمان باقی مانده را نمایش می دهد
                            int remainHours = 0, remainMinutes = 0;
                            String timeArr[] = topProductRow.get(i).get(_discountTime).toString().split(":");
                            ServerLog.Print("currentHour : " + dateIR.getHours() + " & currentMinutes : " + dateIR.getMinutes());
                            remainMinutes = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (60 + Integer.parseInt(timeArr[1]) - dateIR.getMinutes()) : Integer.parseInt(timeArr[1]) - dateIR.getMinutes();
                            remainHours = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (Integer.parseInt(timeArr[0]) - dateIR.getHours() - 1) : Integer.parseInt(timeArr[0]) - dateIR.getHours();
                            if (remainHours >= 0) {//اگر هنوز ساعاتی تا پایان تخفیف مانده بود
                                temphtml.append("<span class='productTitlespan'><h3 style='text-decoration: line-through;' >" + price + "</h3></span>");
                                temphtml.append("<span class='productTitlespan'><h3>" + discountPrice + "</h3></span>");
                                ServerLog.Print("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                                temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                                temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + "دقیقه : " + remainHours + " ساعت</h3></span>");
//                        temphtml.append("<span class='productTitlespan'><h3>" + "دقیقه"+ " : " + "ساعت" + " </h3></span>");

                            } else {//اگر ساعت منفی شد یعنی زمان تخفیف به اتمام رسیده است و دوباره کالا با حالت نرمال و بدون تخفیف نمایش داده می شود
                                temphtml.append("<span class='productTitlespan'><h3>" + price + "</h3></span>");
                            }
//                            System.out.println("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                            temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                        } else {
                            temphtml.append("<span class='productTitlespan'><h3>" + price + "</h3></span>");
                        }

                        //<======= Time of Discount
                    }
                    //<======PRICE

                    //<============ BY RASHIDI ========
                    //By Md----------------------
                            /*نمایش جزئیات محصول*/
                    temphtml.append("<div class='productabstarctDiv'><h4>" + topProductRow.get(i).get(_page).toString());
                    for (int j = 1; j <= 5; j++) {
                        String Key = "account_product_val" + String.valueOf(j);
                        if ((topProductRow.get(i).get(Key) != null) && (!topProductRow.get(i).get(Key).toString().equals("0"))) {
//                        if (j == 1) {
//                            temphtml.append("<span class='productTitlespan'><h5>" + topProductRow.get(i).get(Key).toString() + "</h5></span>");
//                        } else {
                            temphtml.append("<span class='productTitlespan'><h5>" + topProductRow.get(i).get(Key).toString() + "</h5></span>");
//                        }
                        }
                    }

                    temphtml.append("</h4></div>");
                    //----------------------------
                    temphtml.append("<span class='moreDatale'>"
                            + "<a onclick='getOneproduct(" + id + ");'>" + "ادامه مطلب" + "</a>"
                            + "</span><br/>");
                    temphtml.append("<span class='coGruopproduct'>"
                            + "<a onclick='swGetProducts(" + topProductRow.get(i).get(_category_id).toString() + ");'>" + "مطالب مرتبط" + "</a>"
                            + "</span>");
                    temphtml.append("<img src='iconImages/cart.png' title='افزودن به سبد خرید' onclick='addToShoppingCart(" + topProductRow.get(i).get(_id).toString() + ")'>");//====== BY RASHIDI ======
                    temphtml.append("</div>");
                }
            }
            html3.append(Js.setHtml("#swTopproductDiv", temphtml.toString()));
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            return html2 + html3;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String getList(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {//new in v1.5.0 لیست تمام محصولات را با توجه به زبان انتخاب شده برمیگرداند
        try {
            //============ BY RASHIDI ========>
            String userId = jjTools.getSessionAttribute(request, "#" + Access_User._id.toUpperCase());
            String price = "";
            String discountPrice = "";
            //<============BY RASHIDI ========
//            if (jjTools.isLangEn(request)) {
//                return getList_En(request, db, isPost);
//            }
//            if (jjTools.isLangAr(request)) {
//                return getList_Ar(request, db, isPost);
//            }
            String lang = jjTools.getSessionAttribute(request, "myLang");
            lang = lang.equals("") ? "1" : lang;
            List<Map<String, Object>> langSetting = jjDatabaseWeb.separateRow(db.Select(Language.tableName, Language._id + " = " + lang));

            StringBuilder html = new StringBuilder();//for Div,Span and other Html elements
            StringBuffer html3 = new StringBuffer();//for JQuery statements
            String panel = jjTools.getParameter(request, "panel");
            panel = panel.equals("") ? "sw" : panel;
            String titlePanel = jjTools.getParameter(request, "title");
            String title = titlePanel.equals("") ? "" : Js.setHtml("#" + titlePanel, langSetting.get(0).get(Language._product));
//            String title = titlePanel.equals("") ? "" : Js.setHtml("#" + titlePanel, langSetting.get(0).get(Language._keyWord));
            /*طبقه بندی محصولات را برمیگرداند*/
//            html3.append(Category_Product.getHierarchyDiv(re, db));
            Integer category_id = new Integer(jjTools.getParameter(request, "id").equals("") ? "0" : jjTools.getParameter(request, "id").toString()); //============ EDITED BY RASHIDI ======== اگر آی دی در پارامترها نبود از اتریبیوت ها میخاند.
//          category_id = jjNumber.isDigit(jjTools.getParameter(request, "id").toString()) ? id : 1;
            List<Map<String, Object>> topProductRow;
            if (category_id == 0) {
                topProductRow = jjDatabase.separateRow(
                        db.SelectAllDESCOrder(Product.tableName, Product._lang + "=" + lang + " AND " + Product._priority + "<=2", _date));//بر اساس جدیدترین زمان ثبت کالا انتخاب میشوند.
//                        db.Select(Product.tableName, Product._lang + "=" + lang + " AND " + Product._priority + "<=2"));
            } else {
                //============ BY RASHIDI ========>
                //***************توجه*********************
                //به جای این چند خط کد باید یک کوئری اسکیوال جایگزین شود که کتگوری های مد نظر را بگیرد.---->
                String where = "";

//                List<Map<String, Object>> categoryLang = jjDatabase.separateRow(db.Select(tableName, where));
                List<Map<String, Object>> allCategoryProduct = jjDatabase.separateRow(db.Select(Category_Product.tableName));
//                List<Map<String, Object>> allCategoryProduct = jjDatabase.separateRow(db.Select(Category_Product.tableName, Category_Product._lang +" = "+lang));
//                System.out.println("allCategoryProduct : " + allCategoryProduct);
                List<String> categoryList = new ArrayList<String>();

                categoryList.add(category_id.toString());
                for (int i = 0; i < categoryList.size(); i++) {
                    for (int j = 0; j < allCategoryProduct.size(); j++) {
//                        if (allCategoryProduct.get(j).get(Category_Product._upperNode).toString().equals(categoryList.get(i)) && allCategoryProduct.get(j).get(Category_Product._lang).toString().equals(lang)) {
                        if (allCategoryProduct.get(j).get(Category_Product._upperNode).toString().equals(categoryList.get(i))) {
                            categoryList.add(allCategoryProduct.get(j).get(Category_Product._id).toString());
                        }
                    }
                }
                System.out.println("categoryList : " + categoryList);
                where = "";
                for (int i = 0; i < categoryList.size() - 1; i++) {
                    where += _category_id + " = " + categoryList.get(i) + " OR ";
                }
                where += _category_id + " = " + categoryList.get(categoryList.size() - 1);

                topProductRow = jjDatabase.separateRow(
                        db.SelectAllDESCOrder(Product.tableName, Product._lang + "=" + lang + " AND " + where, _date));//بر اساس جدیدترین زمان ثبت کالا انتخاب میشوند.
//                topProductRow = jjDatabase.separateRow(
//                        db.Select(Product.tableName, Product._lang + "=" + lang + " AND " + where));
                //به جای این چند خط کد باید یک کوئری اسکیوال جایگزین شود که کتگوری های مد نظر را بگیرد.<----
                //<============ BY RASHIDI ========
            }

            //---------------one product post creation
            /*لیست محصولات را بر میگرداند*/
            StringBuilder temphtml = new StringBuilder();//for Div,Span and other Html elements
            html.append("<div id='swTopproductDiv' class='topproductDiv'></div>");
            if (topProductRow.isEmpty()) {
                temphtml.append("<div class='noAnyThing'> " + langSetting.get(0).get(Language._noItem) + " </div>");
            } else {
                for (int i = 0; i < topProductRow.size(); i++) {
                    String id = topProductRow.get(i).get(_id).toString();
                    temphtml.append("<div class='productmainDiv'>");
//                    temphtml.append("<span class='productDatespan'>" + jjCalendar_IR.getViewFormat(topProductRow.get(i).get(_date).toString()) + "</span>");

                    //============ EDITED BY RASHIDI ========>
                    String src1 = topProductRow.get(i).get(_pic1).toString();
//                    String src2 = topProductRow.get(i).get(_pic2).toString();
//                    String src3 = topProductRow.get(i).get(_pic3).toString();
//                    String src4 = topProductRow.get(i).get(_pic4).toString();
//                    String src5 = topProductRow.get(i).get(_pic5).toString();
//                    String src6 = topProductRow.get(i).get(_pic6).toString();
//                    String src_ext = topProductRow.get(i).get(_pic_ext).toString();

                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src1.matches("upload/p[0-9]{10}.{4}")) {
//                    String smalPicSrc = src1.replace(".", "_small.");//select small pic
                    String smalPicSrc = src1.replace(".", ".");//select small pic
//                    temphtml.append("<div class='pro-img'><img class='prPicDiv' src='upload/" + smalPicSrc + "' onclick='getOneproduct(" + id + ");return false;' alt='" + topProductRow.get(i).get(_name).toString().replace("'", "").replace("\"", "") + "' /></div>");//======EDITED BY RASHIDI ======
                    temphtml.append("<div class='pro-img'><a href='" + Server.productJSP + "?id=" + id + "' ><img class='prPicDiv' src='upload/" + smalPicSrc + "' alt='" + topProductRow.get(i).get(_name).toString().replace("'", "").replace("\"", "") + "' /></a></div>");//======No Ajax By Mohammad ======
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src1 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src2.matches("upload/p[0-9]{10}.{4}")) {
//                      smalPicSrc = src2.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src2 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src3.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src3.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src3 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src4.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src4.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src4 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src5.matches("upload/p[0-9]{10}.{4}")) {
//                        smalPicSrc = src5.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src5 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src6.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src6.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src6 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src_ext.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src_ext.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src_ext + "'/>");
//                    }

                    //<============ EDITED BY RASHIDI ========
//                    temphtml.append("<div class='prTitleSpan'><h4 onclick='getOneproduct(" + id + ");'>" + topProductRow.get(i).get(_name).toString() + "</h4></div>");
//                    temphtml.append("<div class='prTitleSpan'><h4 onclick='getOneproduct(" + id + ");return false;'><a href='Server?do=Product.getOneProduct&id=" + id + "&panel=" + panel + "' >" + topProductRow.get(i).get(_name).toString() + "</a></h4></div>");
                    temphtml.append("<div class='prTitleSpan'><h4><a href='" + Server.productJSP + "?id=" + id + "' >" + topProductRow.get(i).get(_name).toString() + "</a></h4></div>");
                    //============ BY RASHIDI ========>
                    //======>PRICE
                    if (userId.equals("")) {//اگر کاربر لاگین نکرده باشد و آی دی اش در سشن نباشد
                        price = topProductRow.get(i).get(_price2).toString();//قیمت اصلی را به کاربر نمایش می دهد
                        discountPrice = "".equals(topProductRow.get(i).get(_discount).toString()) ? "" : topProductRow.get(i).get(_discount).toString();//اگر تخفیف برایش در نظر گرفته شود تخفیف هم نمایش داده می شود.
                    } else {//اگر کاربر لاگین کرده باشد
                        List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_Group_User.tableName, Access_Group_User._user_id + " = " + userId));//گروه کاربر را واکشی می کند
                        if (!userRow.isEmpty()) {//اگر کاربر عضو گروهی باشد که قیمت ویژه برای آن ست شده است قیمت مربوط به آن گروه نمایش داده می شود
                            String userGroup = userRow.get(0).get(Access_Group_User._group_id).toString();
//                            System.out.println("userGroup " + userGroup);
                            if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup1).toString())) {
                                price = "".equals(topProductRow.get(i).get(_groupPrice1).toString()) ? topProductRow.get(i).get(_price2).toString() : topProductRow.get(i).get(_groupPrice1).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup2).toString())) {
                                price = "".equals(topProductRow.get(i).get(_groupPrice2).toString()) ? topProductRow.get(i).get(_price2).toString() : topProductRow.get(i).get(_groupPrice2).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup3).toString())) {
                                price = "".equals(topProductRow.get(i).get(_groupPrice3).toString()) ? topProductRow.get(i).get(_price2).toString() : topProductRow.get(i).get(_groupPrice3).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup4).toString())) {
                                price = topProductRow.get(i).get(_groupPrice4).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup5).toString())) {
                                price = "".equals(topProductRow.get(i).get(_groupPrice5).toString()) ? topProductRow.get(i).get(_price2).toString() : topProductRow.get(i).get(_groupPrice5).toString();
                            } else {
                                price = topProductRow.get(i).get(_price2).toString();
                            }
                        } else {//اگر کاربر عادی باشد قیمت اصلی نمایش داده میشود
                            price = topProductRow.get(i).get(_price2).toString();
                            discountPrice = topProductRow.get(i).get(_discount).toString() == "" ? "" : topProductRow.get(i).get(_discount).toString();
                        }
                    }
                    ServerLog.Print("PRICE : " + price);
                    ServerLog.Print("DISCOUNTPRICE : " + discountPrice);

                    if (discountPrice.equalsIgnoreCase("")) {//اگر کالا تخفیف نداشت یا کاربر عضو گروهی بود فقط قیمت اصلی نمایش داده می شود
                        temphtml.append("<div class='prPriceDiv'><span>" + price + "</span> <span>" + topProductRow.get(i).get(_currency) + "</span></div>");
                    } else {//اگر کالا تخفیف داشت  قیمت اصلی و  قیمت تخفیف و زمان باقی مانده تا اتمام تخفیف نمایش داده می شود

                        //=======> Time of Discount
                        //محاسبه زمان باقی مانده تا پایان تخفیف
                        jjCalendar_IR dateIR = new jjCalendar_IR();
//                        System.out.println("DATE : " + dateIR.getDBFormat_8length());

                        int remainTime = Integer.parseInt(topProductRow.get(i).get(_discountDate).toString()) - dateIR.getDBFormat_8length();//تعداد روزهای باقی مانده
                        ServerLog.Print("remain day : " + remainTime);

                        if (remainTime > 0) {//اگر بیشتر از یک روز تا پایان تخفیف مانده باشد.
                            temphtml.append("<div class='prPrePrice'><span style='text-decoration: line-through;' >" + price + "</span> <span style='text-decoration: line-through;'>" + topProductRow.get(i).get(_currency) + "</span></div>");
                            temphtml.append("<div class='prDisCountDiv'><span>" + discountPrice + "</span> <span>" + topProductRow.get(i).get(_currency) + "</span></div>");
                            temphtml.append("<div class='prRemTimeSpan'><span>" + langSetting.get(0).get(Language._remainTime) + "</span> : <span>" + remainTime + "</span> <span>" + langSetting.get(0).get(Language._day) + "</span></div>");//==> prRemTimeSpan : productRemainTime
                        } else if (remainTime == 0) {//اگر کمتر از یک روز تا پایان تخفیف مانده باشد بر حسب ساعت و دقیقه زمان باقی مانده را نمایش می دهد
                            int remainHours = 0, remainMinutes = 0;
                            String timeArr[] = topProductRow.get(i).get(_discountTime).toString().split(":");
                            ServerLog.Print("currentHour : " + dateIR.getHours() + " & currentMinutes : " + dateIR.getMinutes());
                            remainMinutes = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (60 + Integer.parseInt(timeArr[1]) - dateIR.getMinutes()) : Integer.parseInt(timeArr[1]) - dateIR.getMinutes();
                            remainHours = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (Integer.parseInt(timeArr[0]) - dateIR.getHours() - 1) : Integer.parseInt(timeArr[0]) - dateIR.getHours();
                            if (remainHours >= 0) {//اگر هنوز ساعاتی تا پایان تخفیف مانده بود
                                temphtml.append("<div class='prPrePrice'><span style='text-decoration: line-through;' >" + price + "</span> <span style='text-decoration: line-through;'>" + topProductRow.get(i).get(_currency) + "</span></div>");
                                temphtml.append("<div class='prDisCountDiv'><span>" + discountPrice + "</span><span> " + topProductRow.get(i).get(_currency) + "</span></div>");
                                ServerLog.Print("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
                                temphtml.append("<div class='prRemTimeSpan'><span>" + langSetting.get(0).get(Language._remainTime) + "</span> : <span>" + remainHours + "</span> <span>" + langSetting.get(0).get(Language._hour) + "</span> <span>" + remainMinutes + "</span> <span>" + langSetting.get(0).get(Language._minute) + "</span></div>");

                            } else {//اگر ساعت منفی شد یعنی زمان تخفیف به اتمام رسیده است و دوباره کالا با حالت نرمال و بدون تخفیف نمایش داده می شود
                                temphtml.append("<div class='prPriceDiv'><span>" + price + "</span> <span>" + topProductRow.get(i).get(_currency) + "</span></div>");
                            }
                        } else {
                            temphtml.append("<div class='prPriceDiv'><span>" + price + "</span> <span>" + topProductRow.get(i).get(_currency) + "</span></div>");
                        }

                        //<======= Time of Discount
                    }
                    //<======PRICE

                    //<============ BY RASHIDI ========
                    //By Md----------------------
                            /*نمایش جزئیات محصول*/
                    temphtml.append("<div class='prabstarctDiv'><h4>" + topProductRow.get(i).get(_page).toString());
//                    temphtml.append("<div class=''>");
                    for (int j = 1; j <= 5; j++) {
                        String prop = "account_product_prop" + String.valueOf(j);
                        String val = "account_product_val" + String.valueOf(j);
                        if ((topProductRow.get(i).get(val) != null) && (!topProductRow.get(i).get(val).toString().equals("")) && (topProductRow.get(i).get(prop) != null) && (!topProductRow.get(i).get(prop).toString().equals(""))) {
//                        if (j == 1) {
//                            temphtml.append("<span class='productTitlespan'><h5>" + topProductRow.get(i).get(Key).toString() + "</h5></span>");
//                        } else {
                            temphtml.append("<div class='prPropVal'><span class='prProp'>" + topProductRow.get(i).get(prop).toString() + "</span> : <span class='prVal'>" + topProductRow.get(i).get(val).toString() + "</span></div>");
//                        }
                        }
                    }
//                    temphtml.append("</div>");
                    temphtml.append("</h4></div>");
                    //============ BY RASHIDI ========>
                    int quantity = new Integer(topProductRow.get(i).get(_quantity).toString());
                    if (quantity <= 0) {
                        temphtml.append("<div class='prQtyDiv'><h5> " + langSetting.get(0).get(Language._notAvailable) + "</div>");//==> prQtyDivLn : productQuantityDiv
                    } else {
                        temphtml.append("<div class='prQtyDiv'><h5>" + langSetting.get(0).get(Language._available) + "</h5></div>");//==> prQtyDivLn : productQuantityDiv
                    }
                    //<============ BY RASHIDI ========
                    //----------------------------

//                    temphtml.append("<span class='moreDatale" + lang + "'>"
//                            + "<a onclick='getOneproduct(" + id + ");'>" + "ادامه مطلب" + "</a>"
//                            + "</span><br/>");
//                    temphtml.append("<span class='coGruopproduct" + lang + "'>"
//                            + "<a onclick='swGetProducts(" + topProductRow.get(i).get(_category_id).toString() + ");'>" + "مطالب مرتبط" + "</a>"
//                            + "</span>");
//                    temphtml.append("<img src='iconImages/cart.png' onclick='addToShoppingCart(" + topProductRow.get(i).get(_id).toString() + ")'>");//====== BY RASHIDI ======
                    temphtml.append("<div class='detailBtn'>");
                    temphtml.append("<a class='coGruopproduct' onclick='addToShoppingCart(" + topProductRow.get(i).get(_id).toString() + ");'><span>" + langSetting.get(0).get(Language._addCart) + "</span></a>");
//                    temphtml.append("<a href=\"Server?do=Product.getOneProduct&id=" + id + "&panel=" + panel + "\" class='moreDetaile' onclick='getOneproduct(" + id + ");return false;'><span>" + langSetting.get(0).get(Language._detail) + "</span></a>");
                    temphtml.append("<a href='" + Server.productJSP + "?id=" + id + "'><span>" + langSetting.get(0).get(Language._detail) + "</span></a>");//برای چند زبانه مشکل پیش میاید چون فایل جی اس پی چند زبانه نیست
                    temphtml.append("</div>");

//                    int visit = new Integer(topProductRow.get(i).get(_visit).toString());
//                    if (visit >= 0) {
//                        temphtml.append("<div class='prVDivLn" + lang + "'> <span>" + visit + "بار مشاهده</span></div>");//==> prVDiv : productvisitDiv
//                    }
                    int disLikes = new Integer(topProductRow.get(i).get(_dislike).toString());
                    if (disLikes >= 0) {
                        temphtml.append("<div class='prDLDiv' onclick='productDisLike(" + id + ");' > <span>" + disLikes + langSetting.get(0).get(Language._disLike) + "</span></div>");//==> prDLDiv : productDisLikeDiv
                    }
                    int likes = new Integer(topProductRow.get(i).get(_like).toString());
                    if (likes >= 0) {
                        temphtml.append("<div class='prLDiv' onclick='productLike(" + id + ");'>  <span>" + likes + langSetting.get(0).get(Language._like) + "</span></div>");//==> prLDiv : productlikeDiv
                    }
                    temphtml.append("</div>");
                }
            }
            html3.append(Js.hide("#commentForm"));
            html3.append(Js.setHtml("#swTopproductDiv", temphtml.toString()));
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            //============ BY RASHIDI ========>
            //is not by Ajax
            boolean senderIsMyJs = jjTools.getParameter(request, "jj").equals("1");
            if (!senderIsMyJs) {
                return temphtml.toString();
            }
            //is not by Ajax
            //<============ BY RASHIDI ========
            return html2 + html3 + title;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
//============ BY RASHIDI ========>

    public static String getList_En(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {//new in v1.5.0لیست کالاهای انگلیسی را برمیگرداند
        try {
            String userId = jjTools.getSessionAttribute(request, "#" + Access_User._id.toUpperCase());
            String price = "";
            String discountPrice = "";
            StringBuilder html = new StringBuilder();//for Div,Span and other Html elements
            StringBuffer html3 = new StringBuffer();//for JQuery statements
            String panel = jjTools.getParameter(request, "panel");
            panel = panel == null ? "sw" : panel;
            /*طبقه بندی محصولات را برمیگرداند*/
//            html3.append(Category_Product.getHierarchyDiv(re, db));
            Integer category_id = new Integer(jjTools.getParameter(request, "id"));
//          category_id = jjNumber.isDigit(jjTools.getParameter(request, "id").toString()) ? id : 1;
            List<Map<String, Object>> topProductRow;
            if (category_id == 0) {
                topProductRow = jjDatabase.separateRow(
                        db.Select(Product.tableName, Product._lang + "=2 AND " + Product._priority + "<=2"));
            } else {
                topProductRow = jjDatabase.separateRow(
                        db.Select(Product.tableName, Product._lang + "=2 AND " + Product._category_id + "=" + category_id));
            }

            //---------------one product post creation
            /*لیست محصولات را بر میگرداند*/
            StringBuilder temphtml = new StringBuilder();//for Div,Span and other Html elements
            html.append("<div id='swTopproductDiv' class='topproductDiv'></div>");
            if (topProductRow.isEmpty()) {
                temphtml.append("<div class='noAnyThing'><span>NO ITEM!!!</span></div>");
            } else {
                for (int i = 0; i < topProductRow.size(); i++) {
                    String id = topProductRow.get(i).get(_id).toString();
                    temphtml.append("<div class='productmainDiv'>");
//                    temphtml.append("<span class='productDatespan'>" + jjCalendar_IR.getViewFormat(topProductRow.get(i).get(_date).toString()) + "</span>");
                    int visit = new Integer(topProductRow.get(i).get(_visit).toString());
                    if (visit >= 0) {
                        temphtml.append("<div class='prVDiv'> <span>" + visit + " visited</span></div>");//==> prVDiv : productvisitDiv
                    }
                    int disLikes = new Integer(topProductRow.get(i).get(_dislike).toString());
                    if (disLikes >= 0) {
                        temphtml.append("<div class='prDLDiv' onclick='productDisLike(" + id + ");' > <span>" + disLikes + " dislike </span></div>");//==> prDLDiv : productDisLikeDiv
                    }
                    int likes = new Integer(topProductRow.get(i).get(_like).toString());
                    if (likes >= 0) {
                        temphtml.append("<div class='prLDiv' onclick='productLike(" + id + ");'>  <span>" + likes + " like </span></div>");//==> prLDiv : productlikeDiv
                    }
                    //============ EDITED BY RASHIDI ========>
                    String src1 = topProductRow.get(i).get(_pic1).toString();
//                    String src2 = topProductRow.get(i).get(_pic2).toString();
//                    String src3 = topProductRow.get(i).get(_pic3).toString();
//                    String src4 = topProductRow.get(i).get(_pic4).toString();
//                    String src5 = topProductRow.get(i).get(_pic5).toString();
//                    String src6 = topProductRow.get(i).get(_pic6).toString();
//                    String src_ext = topProductRow.get(i).get(_pic_ext).toString();

                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src1.matches("upload/p[0-9]{10}.{4}")) {
                    String smalPicSrc = src1.replace(".", "_small.");//select small pic
                    temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'  onclick='getOneproduct(" + id + ")';/>");//======EDITED BY RASHIDI ======
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src1 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src2.matches("upload/p[0-9]{10}.{4}")) {
//                      smalPicSrc = src2.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src2 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src3.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src3.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src3 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src4.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src4.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src4 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src5.matches("upload/p[0-9]{10}.{4}")) {
//                        smalPicSrc = src5.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src5 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src6.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src6.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src6 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src_ext.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src_ext.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src_ext + "'/>");
//                    }

                    //<============ EDITED BY RASHIDI ========
                    temphtml.append("<span class='productTitlespan'><h3>" + topProductRow.get(i).get(_name).toString() + "</h3></span>");
                    //============ BY RASHIDI ========>
                    int quantity = new Integer(topProductRow.get(i).get(_quantity).toString());
                    if (quantity <= 0) {
                        temphtml.append("<div class='prQDiv_En'>  <span> not exist!!</span></div>");//==> prQDiv : productlQuantityDiv
                    } else {
                        temphtml.append("<div class='prQDiv_En'> <span> quantity  " + quantity + " </span></div>");//==> prQDiv : productlQuantityDiv
                    }
                    //======>PRICE
                    if (userId.equals("")) {//اگر کاربر لاگین نکرده باشد و آی دی اش در سشن نباشد
                        price = topProductRow.get(i).get(_price2).toString();//قیمت اصلی را به کاربر نمایش می دهد
                        discountPrice = topProductRow.get(i).get(_discount).toString() == "" ? "" : topProductRow.get(i).get(_discount).toString();//اگر تخفیف برایش در نظر گرفته شود تخفیف هم نمایش داده می شود.
                    } else {//اگر کاربر لاگین کرده باشد
                        List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_Group_User.tableName, Access_Group_User._user_id + " = " + userId));//گروه کاربر را واکشی می کند
                        if (!userRow.isEmpty()) {//اگر کاربر عضو گروهی باشد که قیمت ویژه برای آن ست شده است قیمت مربوط به آن گروه نمایش داده می شود
                            String userGroup = userRow.get(0).get(Access_Group_User._group_id).toString();
//                            System.out.println("userGroup " + userGroup);
                            if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup1).toString())) {
                                price = topProductRow.get(i).get(_groupPrice1).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup2).toString())) {
                                price = topProductRow.get(i).get(_groupPrice2).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup3).toString())) {
                                price = topProductRow.get(i).get(_groupPrice3).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup4).toString())) {
                                price = topProductRow.get(i).get(_groupPrice4).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup5).toString())) {
                                price = topProductRow.get(i).get(_groupPrice5).toString();
                            } else {
                                price = topProductRow.get(i).get(_price2).toString();
                            }
                        } else {//اگر کاربر عادی باشد قیمت اصلی نمایش داده میشود
                            price = topProductRow.get(i).get(_price2).toString();
                            discountPrice = topProductRow.get(i).get(_discount).toString() == "" ? "" : topProductRow.get(i).get(_discount).toString();
                        }
                    }
                    ServerLog.Print("PRICE : " + price);
                    ServerLog.Print("DISCOUNTPRICE : " + discountPrice);

                    if (discountPrice.equalsIgnoreCase("")) {//اگر کالا تخفیف نداشت یا کاربر عضو گروهی بود فقط قیمت اصلی نمایش داده می شود
                        temphtml.append("<span class='productTitlespan'><h3>" + price + "</h3></span>");
                    } else {//اگر کالا تخفیف داشت  قیمت اصلی و  قیمت تخفیف و زمان باقی مانده تا اتمام تخفیف نمایش داده می شود

                        //=======> Time of Discount
                        //محاسبه زمان باقی مانده تا پایان تخفیف
                        jjCalendar_IR dateIR = new jjCalendar_IR();
//                        System.out.println("DATE : " + dateIR.getDBFormat_8length());

                        int remainTime = Integer.parseInt(topProductRow.get(i).get(_discountDate).toString()) - dateIR.getDBFormat_8length();//تعداد روزهای باقی مانده
                        ServerLog.Print("remain day : " + remainTime);

                        if (remainTime > 0) {//اگر بیشتر از یک روز تا پایان تخفیف مانده باشد.
                            temphtml.append("<span class='productTitlespan'><h3 style='text-decoration: line-through;' >" + price + "</h3></span>");
                            temphtml.append("<span class='productTitlespan'><h3>" + discountPrice + "</h3></span>");
                            temphtml.append("<span class='productTitlespan'><h3>remain time: " + remainTime + " روز</h3></span>");
                        } else if (remainTime == 0) {//اگر کمتر از یک روز تا پایان تخفیف مانده باشد بر حسب ساعت و دقیقه زمان باقی مانده را نمایش می دهد
                            int remainHours = 0, remainMinutes = 0;
                            String timeArr[] = topProductRow.get(i).get(_discountTime).toString().split(":");
                            ServerLog.Print("currentHour : " + dateIR.getHours() + " & currentMinutes : " + dateIR.getMinutes());
                            remainMinutes = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (60 + Integer.parseInt(timeArr[1]) - dateIR.getMinutes()) : Integer.parseInt(timeArr[1]) - dateIR.getMinutes();
                            remainHours = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (Integer.parseInt(timeArr[0]) - dateIR.getHours() - 1) : Integer.parseInt(timeArr[0]) - dateIR.getHours();
                            if (remainHours >= 0) {//اگر هنوز ساعاتی تا پایان تخفیف مانده بود
                                temphtml.append("<span class='productTitlespan'><h3 style='text-decoration: line-through;' >" + price + "</h3></span>");
                                temphtml.append("<span class='productTitlespan'><h3>" + discountPrice + "</h3></span>");
                                ServerLog.Print("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                                temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                                temphtml.append("<span class='productTitlespan'><h3>remain time: " + remainMinutes + "Minutes : " + remainHours + " Hours</h3></span>");
//                        temphtml.append("<span class='productTitlespan'><h3>" + "دقیقه"+ " : " + "ساعت" + " </h3></span>");

                            } else {//اگر ساعت منفی شد یعنی زمان تخفیف به اتمام رسیده است و دوباره کالا با حالت نرمال و بدون تخفیف نمایش داده می شود
                                temphtml.append("<span class='productTitlespan'><h3>" + price + "</h3></span>");
                            }
//                            System.out.println("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                            temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                        } else {
                            temphtml.append("<span class='productTitlespan'><h3>" + price + "</h3></span>");
                        }

                        //<======= Time of Discount
                    }
                    //<======PRICE

                    //<============ BY RASHIDI ========
                    //By Md----------------------
                            /*نمایش جزئیات محصول*/
                    temphtml.append("<div class='productabstarctDiv'><h4>" + topProductRow.get(i).get(_page).toString());
                    for (int j = 1; j <= 5; j++) {
                        String Key = "account_product_val" + String.valueOf(j);
                        if ((topProductRow.get(i).get(Key) != null) && (!topProductRow.get(i).get(Key).toString().equals("0"))) {
//                        if (j == 1) {
//                            temphtml.append("<span class='productTitlespan'><h5>" + topProductRow.get(i).get(Key).toString() + "</h5></span>");
//                        } else {
                            temphtml.append("<span class='productTitlespan'><h5>" + topProductRow.get(i).get(Key).toString() + "</h5></span>");
//                        }
                        }
                    }

                    temphtml.append("</h4></div>");
                    //----------------------------
                    temphtml.append("<span class='moreDatale'>"
                            + "<a onclick='getOneproduct(" + id + ");'>" + "cont." + "</a>"
                            + "</span><br/>");
                    temphtml.append("<span class='coGruopproduct'>"
                            + "<a onclick='swGetProducts(" + topProductRow.get(i).get(_category_id).toString() + ");'>" + "related" + "</a>"
                            + "</span>");
                    temphtml.append("<img src='iconImages/cart.png' title='add to shopping cart' onclick='addToShoppingCart(" + topProductRow.get(i).get(_id).toString() + ")'>");//====== BY RASHIDI ======
                    temphtml.append("</div>");
                }
            }
            html3.append(Js.setHtml("#swTopproductDiv", temphtml.toString()));
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            return html2 + html3;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String getList_Ar(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {//new in v1.5.0لیست کالاهای عربی را برمیگرداند
        try {
            String userId = jjTools.getSessionAttribute(request, "#" + Access_User._id.toUpperCase());
            String price = "";
            String discountPrice = "";
            StringBuilder html = new StringBuilder();//for Div,Span and other Html elements
            StringBuffer html3 = new StringBuffer();//for JQuery statements
            String panel = jjTools.getParameter(request, "panel");
            panel = panel == null ? "sw" : panel;
            /*طبقه بندی محصولات را برمیگرداند*/
//            html3.append(Category_Product.getHierarchyDiv(re, db));
            Integer category_id = new Integer(jjTools.getParameter(request, "id"));
//          category_id = jjNumber.isDigit(jjTools.getParameter(request, "id").toString()) ? id : 1;
            List<Map<String, Object>> topProductRow;
            if (category_id == 0) {
                topProductRow = jjDatabase.separateRow(
                        db.Select(Product.tableName, Product._lang + "=3 AND " + Product._priority + "<=2"));
            } else {
                topProductRow = jjDatabase.separateRow(
                        db.Select(Product.tableName, Product._lang + "=3 AND " + Product._category_id + "=" + category_id));
            }

            //---------------one product post creation
            /*لیست محصولات را بر میگرداند*/
            StringBuilder temphtml = new StringBuilder();//for Div,Span and other Html elements
            html.append("<div id='swTopproductDiv' class='topproductDiv'></div>");
            if (topProductRow.isEmpty()) {
                temphtml.append("<div class='noAnyThing'><span>لاموجود!!!</span></div>");
            } else {
                for (int i = 0; i < topProductRow.size(); i++) {
                    String id = topProductRow.get(i).get(_id).toString();
                    temphtml.append("<div class='productmainDiv'>");
//                    temphtml.append("<span class='productDatespan'>" + jjCalendar_IR.getViewFormat(topProductRow.get(i).get(_date).toString()) + "</span>");
                    int visit = new Integer(topProductRow.get(i).get(_visit).toString());
                    if (visit >= 0) {
                        temphtml.append("<div class='prVDiv'> <span>" + visit + " الدیده الشده</span></div>");//==> prVDiv : productvisitDiv
                    }
                    int disLikes = new Integer(topProductRow.get(i).get(_dislike).toString());
                    if (disLikes >= 0) {
                        temphtml.append("<div class='prDLDiv' onclick='productDisLike(" + id + ");' > <span>" + disLikes + " المخالف </span></div>");//==> prDLDiv : productDisLikeDiv
                    }
                    int likes = new Integer(topProductRow.get(i).get(_like).toString());
                    if (likes >= 0) {
                        temphtml.append("<div class='prLDiv' onclick='productLike(" + id + ");'>  <span>" + likes + " الموافق </span></div>");//==> prLDiv : productlikeDiv
                    }
                    //============ EDITED BY RASHIDI ========>
                    String src1 = topProductRow.get(i).get(_pic1).toString();
//                    String src2 = topProductRow.get(i).get(_pic2).toString();
//                    String src3 = topProductRow.get(i).get(_pic3).toString();
//                    String src4 = topProductRow.get(i).get(_pic4).toString();
//                    String src5 = topProductRow.get(i).get(_pic5).toString();
//                    String src6 = topProductRow.get(i).get(_pic6).toString();
//                    String src_ext = topProductRow.get(i).get(_pic_ext).toString();

                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src1.matches("upload/p[0-9]{10}.{4}")) {
                    String smalPicSrc = src1.replace(".", "_small.");//select small pic
                    temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'  onclick='getOneproduct(" + id + ")';/>");//======EDITED BY RASHIDI ======
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src1 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src2.matches("upload/p[0-9]{10}.{4}")) {
//                      smalPicSrc = src2.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src2 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src3.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src3.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src3 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src4.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src4.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src4 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src5.matches("upload/p[0-9]{10}.{4}")) {
//                        smalPicSrc = src5.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src5 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src6.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src6.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src6 + "'/>");
//                    }
                    //اگر تصویراز میان تصاویر سایت بود، تصویر کوچک را برگرداند
//                    if (src_ext.matches("upload/p[0-9]{10}.{4}")) {
//                         smalPicSrc = src_ext.replace(".", "_small.");//select small pic
//                        temphtml.append("<img class='productPicDiv' src='upload/" + smalPicSrc + "'/>");
//                    } else {
//                        temphtml.append("<img class='productPicDiv' src='upload/" + src_ext + "'/>");
//                    }

                    //<============ EDITED BY RASHIDI ========
                    temphtml.append("<span class='productTitlespan'><h3>" + topProductRow.get(i).get(_name).toString() + "</h3></span>");
                    //============ BY RASHIDI ========>
                    int quantity = new Integer(topProductRow.get(i).get(_quantity).toString());
                    if (quantity <= 0) {
                        temphtml.append("<div class='prQDiv_En'>  <span> not exist!!</span></div>");//==> prQDiv : productlQuantityDiv
                    } else {
                        temphtml.append("<div class='prQDiv_En'> <span> الموجود  " + quantity + " </span></div>");//==> prQDiv : productlQuantityDiv
                    }
                    //======>PRICE
                    if (userId.equals("")) {//اگر کاربر لاگین نکرده باشد و آی دی اش در سشن نباشد
                        price = topProductRow.get(i).get(_price2).toString();//قیمت اصلی را به کاربر نمایش می دهد
                        discountPrice = topProductRow.get(i).get(_discount).toString() == "" ? "" : topProductRow.get(i).get(_discount).toString();//اگر تخفیف برایش در نظر گرفته شود تخفیف هم نمایش داده می شود.
                    } else {//اگر کاربر لاگین کرده باشد
                        List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_Group_User.tableName, Access_Group_User._user_id + " = " + userId));//گروه کاربر را واکشی می کند
                        if (!userRow.isEmpty()) {//اگر کاربر عضو گروهی باشد که قیمت ویژه برای آن ست شده است قیمت مربوط به آن گروه نمایش داده می شود
                            String userGroup = userRow.get(0).get(Access_Group_User._group_id).toString();
//                            System.out.println("userGroup " + userGroup);
                            if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup1).toString())) {
                                price = topProductRow.get(i).get(_groupPrice1).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup2).toString())) {
                                price = topProductRow.get(i).get(_groupPrice2).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup3).toString())) {
                                price = topProductRow.get(i).get(_groupPrice3).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup4).toString())) {
                                price = topProductRow.get(i).get(_groupPrice4).toString();
                            } else if (userGroup.equalsIgnoreCase(topProductRow.get(i).get(_userGroup5).toString())) {
                                price = topProductRow.get(i).get(_groupPrice5).toString();
                            } else {
                                price = topProductRow.get(i).get(_price2).toString();
                            }
                        } else {//اگر کاربر عادی باشد قیمت اصلی نمایش داده میشود
                            price = topProductRow.get(i).get(_price2).toString();
                            discountPrice = topProductRow.get(i).get(_discount).toString() == "" ? "" : topProductRow.get(i).get(_discount).toString();
                        }
                    }
                    ServerLog.Print("PRICE : " + price);
                    ServerLog.Print("DISCOUNTPRICE : " + discountPrice);

                    if (discountPrice.equalsIgnoreCase("")) {//اگر کالا تخفیف نداشت یا کاربر عضو گروهی بود فقط قیمت اصلی نمایش داده می شود
                        temphtml.append("<span class='productTitlespan'><h3>" + price + "</h3></span>");
                    } else {//اگر کالا تخفیف داشت  قیمت اصلی و  قیمت تخفیف و زمان باقی مانده تا اتمام تخفیف نمایش داده می شود

                        //=======> Time of Discount
                        //محاسبه زمان باقی مانده تا پایان تخفیف
                        jjCalendar_IR dateIR = new jjCalendar_IR();
//                        System.out.println("DATE : " + dateIR.getDBFormat_8length());

                        int remainTime = Integer.parseInt(topProductRow.get(i).get(_discountDate).toString()) - dateIR.getDBFormat_8length();//تعداد روزهای باقی مانده
                        ServerLog.Print("remain day : " + remainTime);

                        if (remainTime > 0) {//اگر بیشتر از یک روز تا پایان تخفیف مانده باشد.
                            temphtml.append("<span class='productTitlespan'><h3 style='text-decoration: line-through;' >" + price + "</h3></span>");
                            temphtml.append("<span class='productTitlespan'><h3>" + discountPrice + "</h3></span>");
                            temphtml.append("<span class='productTitlespan'><h3>remain time: " + remainTime + " الیوم</h3></span>");
                        } else if (remainTime == 0) {//اگر کمتر از یک روز تا پایان تخفیف مانده باشد بر حسب ساعت و دقیقه زمان باقی مانده را نمایش می دهد
                            int remainHours = 0, remainMinutes = 0;
                            String timeArr[] = topProductRow.get(i).get(_discountTime).toString().split(":");
                            ServerLog.Print("currentHour : " + dateIR.getHours() + " & currentMinutes : " + dateIR.getMinutes());
                            remainMinutes = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (60 + Integer.parseInt(timeArr[1]) - dateIR.getMinutes()) : Integer.parseInt(timeArr[1]) - dateIR.getMinutes();
                            remainHours = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (Integer.parseInt(timeArr[0]) - dateIR.getHours() - 1) : Integer.parseInt(timeArr[0]) - dateIR.getHours();
                            if (remainHours >= 0) {//اگر هنوز ساعاتی تا پایان تخفیف مانده بود
                                temphtml.append("<span class='productTitlespan'><h3 style='text-decoration: line-through;' >" + price + "</h3></span>");
                                temphtml.append("<span class='productTitlespan'><h3>" + discountPrice + "</h3></span>");
                                ServerLog.Print("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                                temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                                temphtml.append("<span class='productTitlespan'><h3>remain time: " + remainMinutes + "الدقیقه : " + remainHours + " الساعه</h3></span>");
//                        temphtml.append("<span class='productTitlespan'><h3>" + "دقیقه"+ " : " + "ساعت" + " </h3></span>");

                            } else {//اگر ساعت منفی شد یعنی زمان تخفیف به اتمام رسیده است و دوباره کالا با حالت نرمال و بدون تخفیف نمایش داده می شود
                                temphtml.append("<span class='productTitlespan'><h3>" + price + "</h3></span>");
                            }
//                            System.out.println("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                            temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                        } else {
                            temphtml.append("<span class='productTitlespan'><h3>" + price + "</h3></span>");
                        }

                        //<======= Time of Discount
                    }
                    //<======PRICE

                    //<============ BY RASHIDI ========
                    //By Md----------------------
                            /*نمایش جزئیات محصول*/
                    temphtml.append("<div class='productabstarctDiv'><h4>" + topProductRow.get(i).get(_page).toString());
                    for (int j = 1; j <= 5; j++) {
                        String Key = "account_product_val" + String.valueOf(j);
                        if ((topProductRow.get(i).get(Key) != null) && (!topProductRow.get(i).get(Key).toString().equals("0"))) {
//                        if (j == 1) {
//                            temphtml.append("<span class='productTitlespan'><h5>" + topProductRow.get(i).get(Key).toString() + "</h5></span>");
//                        } else {
                            temphtml.append("<span class='productTitlespan'><h5>" + topProductRow.get(i).get(Key).toString() + "</h5></span>");
//                        }
                        }
                    }

                    temphtml.append("</h4></div>");
                    //----------------------------
                    temphtml.append("<span class='moreDatale'>"
                            + "<a onclick='getOneproduct(" + id + ");'>" + "الادامه" + "</a>"
                            + "</span><br/>");
                    temphtml.append("<span class='coGruopproduct'>"
                            + "<a onclick='swGetProducts(" + topProductRow.get(i).get(_category_id).toString() + ");'>" + "المرتبط" + "</a>"
                            + "</span>");
                    temphtml.append("<img src='iconImages/cart.png' title='add to shopping cart' onclick='addToShoppingCart(" + topProductRow.get(i).get(_id).toString() + ")'>");//====== BY RASHIDI ======
                    temphtml.append("</div>");
                }
            }
            html3.append(Js.setHtml("#swTopproductDiv", temphtml.toString()));
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
            return html2 + html3;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
//<============ BY RASHIDI ========

    public static String getOneProduct2(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            //============ BY RASHIDI ========>
            String userId = jjTools.getSessionAttribute(request, "#" + Access_User._id.toUpperCase());
            String price = "";
            String discountPrice = "";
            String lang = jjTools.getSessionAttribute(request, "myLang");
            List<Map<String, Object>> langSetting = jjDatabaseWeb.separateRow(db.Select(Language.tableName, Language._id + " = " + lang));
            //<============BY RASHIDI ========
            StringBuilder html = new StringBuilder();//for Div,Span and other Html elements
            String panel = jjTools.getParameter(request, "panel");
            String id = jjTools.getParameter(request, _id);
            panel = panel == null ? "sw" : panel;
            //to incriment visited time
            boolean flag = db.otherStatement("UPDATE " + tableName + " SET " + _visit + " = " + _visit + "+1 WHERE " + _id + "=" + id);
            List<Map<String, Object>> row;
            row = jjDatabase.separateRow(db.Select(tableName, _id + " = " + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            html.append("<div>");
            if (lang.equals("1")) {
                html.append("<span class='productDatespan'>" + jjCalendar_IR.getViewFormat(row.get(0).get(_date).toString()) + "</span>");
            } else {
                jjCalendar_IR irDate = new jjCalendar_IR(row.get(0).get(_date).toString());
                jjCalendar_EN enDate = new jjCalendar_EN();
                enDate = irDate.convertPersianToGregorian();
                html.append("<span class='productDatespan'>" + enDate.getViewFormat_10length() + "</span>");
            }
            //============ BY RASHIDI ========>
            html.append("<div class='productPicDiv" + lang + "'>");
            String src1 = row.get(0).get(_pic1).toString();
            String src2 = row.get(0).get(_pic2).toString();
            String src3 = row.get(0).get(_pic3).toString();
            String src4 = row.get(0).get(_pic4).toString();
            String src5 = row.get(0).get(_pic5).toString();
            String src6 = row.get(0).get(_pic6).toString();
            String src_ext = row.get(0).get(_pic_ext).toString();
            String smalPicSrc = "";
            smalPicSrc = src1.replace(".", "_small.");//select small pic
            html.append("<img class='mainPic productPic' src='upload/" + smalPicSrc + "'/>");
            html.append("<div class='productExtraDiv'>");

            smalPicSrc = src2.replace(".", "_small.");
            html.append("<img class='productPic' src='upload/" + smalPicSrc + "'/>");

            smalPicSrc = src3.replace(".", "_small.");
            html.append("<img class='productPic' src='upload/" + smalPicSrc + "'/>");

            smalPicSrc = src4.replace(".", "_small.");
            html.append("<img class='productPic' src='upload/" + smalPicSrc + "'/>");

            smalPicSrc = src5.replace(".", "_small.");
            html.append("<img class='productPic' src='upload/" + smalPicSrc + "'/>");

            smalPicSrc = src6.replace(".", "_small.");
            html.append("<img class='productPic' src='upload/" + smalPicSrc + "'/>");

            smalPicSrc = src_ext.replace(".", "_small.");
            html.append("<img class='productPic' src='upload/" + smalPicSrc + "'/>");

            html.append("</div></div>");

            html.append("<span class='productTitlespan'><h3>" + row.get(0).get(_name).toString() + "</h3></span>");

            //======>PRICE
            if (userId.equals("")) {//اگر کاربر لاگین نکرده باشد و آی دی اش در سشن نباشد
                price = row.get(0).get(_price2).toString();//قیمت اصلی را به کاربر نمایش می دهد
                discountPrice = row.get(0).get(_discount).toString() == "" ? "" : row.get(0).get(_discount).toString();//اگر تخفیف برایش در نظر گرفته شود تخفیف هم نمایش داده می شود.
            } else {//اگر کاربر لاگین کرده باشد
                List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_Group_User.tableName, Access_Group_User._user_id + " = " + userId));//گروه کاربر را واکشی می کند
                if (!userRow.isEmpty()) {//اگر کاربر عضو گروهی باشد که قیمت ویژه برای آن ست شده است قیمت مربوط به آن گروه نمایش داده می شود
                    String userGroup = userRow.get(0).get(Access_Group_User._group_id).toString();
//                    System.out.println("userGroup " + userGroup);
                    if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup1).toString())) {
                        price = row.get(0).get(_groupPrice1).toString();
                    } else if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup2).toString())) {
                        price = row.get(0).get(_groupPrice2).toString();
                    } else if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup3).toString())) {
                        price = row.get(0).get(_groupPrice3).toString();
                    } else if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup4).toString())) {
                        price = row.get(0).get(_groupPrice4).toString();
                    } else if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup5).toString())) {
                        price = row.get(0).get(_groupPrice5).toString();
                    } else {
                        price = row.get(0).get(_price2).toString();
                    }
                } else {//اگر کاربر عادی باشد قیمت اصلی نمایش داده میشود
                    price = row.get(0).get(_price2).toString();
                    discountPrice = row.get(0).get(_discount).toString() == "" ? "" : row.get(0).get(_discount).toString();
                }
            }

            //<======PRICE
            html.append("<div class='productabstarctDiv'><h4>" + row.get(0).get(_page).toString());
            html.append("<div class='productPropVal'>");
            for (int j = 1; j <= 5; j++) {
                String prop = "account_product_prop" + String.valueOf(j);
                String val = "account_product_val" + String.valueOf(j);
                if ((row.get(0).get(val) != null) && (!row.get(0).get(val).toString().equals("")) && (row.get(0).get(prop) != null) && (!row.get(0).get(prop).toString().equals(""))) {
//                        if (j == 1) {
//                            temphtml.append("<span class='productTitlespan'><h5>" + topProductRow.get(i).get(Key).toString() + "</h5></span>");
//                        } else {
                    html.append("<span><h5>" + row.get(0).get(val).toString() + " : " + row.get(0).get(prop).toString() + "</h5></span>");
//                        }
                }
            }
            html.append("</div>");
            html.append("</h4></div>");
            ServerLog.Print("PRICE : " + price);
            ServerLog.Print("DISCOUNTPRICE : " + discountPrice);

            if (discountPrice.equalsIgnoreCase("")) {//اگر کالا تخفیف نداشت یا کاربر عضو گروهی بود فقط قیمت اصلی نمایش داده می شود
                html.append("<div class='productPrice'><h4>" + price + "</h4></div>");
            } else {//اگر کالا تخفیف داشت  قیمت اصلی و  قیمت تخفیف و زمان باقی مانده تا اتمام تخفیف نمایش داده می شود

                //=======> Time of Discount
                //محاسبه زمان باقی مانده تا پایان تخفیف
                jjCalendar_IR dateIR = new jjCalendar_IR();
//                System.out.println("DATE : " + dateIR.getDBFormat_8length());

                int remainTime = Integer.parseInt(row.get(0).get(_discountDate).toString()) - dateIR.getDBFormat_8length();//تعداد روزهای باقی مانده
                ServerLog.Print("remain day : " + remainTime);

                if (remainTime > 0) {//اگر بیشتر از یک روز تا پایان تخفیف مانده باشد.
                    html.append("<div class='productPrice'><h5 style='text-decoration: line-through;' >" + price + "</h5></div>");
                    html.append("<div class='productDisCount'><h4>" + discountPrice + "</h4></span>");
                    html.append("<div class='productRemTime'><h3>" + langSetting.get(0).get(Language._remainTime) + " : " + remainTime + langSetting.get(0).get(Language._day) + "</h3></div>");
                } else if (remainTime == 0) {//اگر کمتر از یک روز تا پایان تخفیف مانده باشد بر حسب ساعت و دقیقه زمان باقی مانده را نمایش می دهد
                    int remainHours = 0, remainMinutes = 0;
                    String timeArr[] = row.get(0).get(_discountTime).toString().split(":");
                    ServerLog.Print("currentHour : " + dateIR.getHours() + " & currentMinutes : " + dateIR.getMinutes());
                    remainMinutes = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (60 + Integer.parseInt(timeArr[1]) - dateIR.getMinutes()) : Integer.parseInt(timeArr[1]) - dateIR.getMinutes();
                    remainHours = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (Integer.parseInt(timeArr[0]) - dateIR.getHours() - 1) : Integer.parseInt(timeArr[0]) - dateIR.getHours();
                    if (remainHours >= 0) {//اگر هنوز ساعاتی تا پایان تخفیف مانده بود
                        html.append("<div class='productPrice'><h5 style='text-decoration: line-through;' >" + price + "</h5></div>");
                        html.append("<div class='productDisCount'><h4>" + discountPrice + "</h4></div>");
                        ServerLog.Print("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                                temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                        html.append("<div class='productRemTime'><h3>" + langSetting.get(0).get(Language._remainTime) + " : " + remainMinutes + langSetting.get(0).get(Language._minute) + remainHours + langSetting.get(0).get(Language._hour) + "</h3></div >");
//                        temphtml.append("<span class='productTitlespan'><h3>" + "دقیقه"+ " : " + "ساعت" + " </h3></span>");

                    } else {//اگر ساعت منفی شد یعنی زمان تخفیف به اتمام رسیده است و دوباره کالا با حالت نرمال و بدون تخفیف نمایش داده می شود
                        html.append("<div class='productPrice'><h4>" + price + "</h4></div>");
                    }
//                            System.out.println("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                            temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                } else {
                    html.append("<div class='productPrice'><h4>" + price + "</h4></div>");
                }

                //<======= Time of Discount
            }
            int quantity = new Integer(row.get(0).get(_quantity).toString());
            if (quantity <= 0) {
                html.append("<div class='productQtyDiv'>  <span>" + langSetting.get(0).get(Language._notAvailable) + "</span></div>");//==> productQtyDivLn : productlQuantityDiv
            } else {
                html.append("<div class='prductQtyDiv'>  <span>" + langSetting.get(0).get(Language._available) + "</span></div>");//==> productQtyDivLn : productlQuantityDiv
            }
            int disLikes = new Integer(row.get(0).get(_dislike).toString());
            if (disLikes >= 0) {
                html.append("<div class='productDLDiv' onclick='productDisLike(" + id + ");' ><span>" + disLikes + " " + langSetting.get(0).get(Language._disLike) + "</span></div>");
            }
            int likes = new Integer(row.get(0).get(_like).toString());
            if (likes >= 0) {
                html.append("<div class='productLDiv' onclick='productLike(" + id + ");' ><span>" + likes + " " + langSetting.get(0).get(Language._like) + "</span></div>");
            }
            int visit = new Integer(row.get(0).get(_visit).toString());
            if (visit >= 0) {
                html.append("<div class='productVDiv' ><span>" + visit + " " + langSetting.get(0).get(Language._visited) + "</span></div>");
            }
//            html.append("<img src='iconImages/cart.png' onclick='addToShoppingCart(" + row.get(0).get(_id).toString() + ")'>");//====== BY RASHIDI ======
            //<============ BY RASHIDI ========

//            html.append("<span class='moreDataleLn" + lang + "'>"
//                    + "<a onclick='swGetProducts(" + row.get(0).get(_category_id).toString() + ");'>" + " مطالب مرتبط" + "</a>"
//                    + "</span>");
            html.append("</div>");
            html.append("<div class='ProductdetailBtn'>");
            html.append("<a class='coGruopproduct' onclick='addToShoppingCart(" + row.get(0).get(_id).toString() + ");'>" + langSetting.get(0).get(Language._addCart) + "</a>");
            html.append("<a class='moreDetaile' onclick='swGetProducts(" + row.get(0).get(_category_id).toString() + ");'>" + langSetting.get(0).get(Language._related) + "</a>");
            html.append("</div>");
            //1-->
//            html.append("<div id='commentForm' name='commentForm'></div>");//====== BY RASHIDI ======
////            html.append("$(\"#commentForm\").load(\"formCms/comment.html\")");
//            String script = "$('#" + panel + "').html(\"" + html.toString() + "\");";
//            script += ("$('#commentForm').load('formCms/public_comment_fa.html', null, function () {$('#comment_refrenceId').val('tblName=" + tableName + "&id=" + id + "');});");//====== BY RASHIDI ======
//            script += Js.setVal("#comment_refId", "Product_" + id);
            //1<--
            //2-->
            String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");";
            html2 += Js.setHtml("#newContentDiv", row.get(0).get(_content).toString());
            html2 += Js.show("#commentForm");
            html2 += Js.setVal("#comment_refrenceId", "tblName=" + tableName + "&id=" + id);
            //2<--
//            row.get(0).get(_content).toString()
//        script += Js.table("#sss", height, sort, "");
//            script += (Js.append("#commentForm", "<input type='text' id='comment_refId' name='comment_refId' value='Product_" + id + "'/>"));
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

//By Md
    public static String productDisLike(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            boolean flag = db.otherStatement("UPDATE " + tableName + " SET " + _dislike + " = " + _dislike + "+1 WHERE " + _id + "=" + id);
            return String.valueOf(flag);
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String productLike(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            boolean flag = db.otherStatement("UPDATE " + tableName + " SET " + _like + " = " + _like + "+1 WHERE " + _id + "=" + id);
            return String.valueOf(flag);
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String add_EN(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            Object title = row.get(0).get(_name);
            if (title != null) {
                html.append(Js.setVal("#" + _name, title));
            }
            Object priority = row.get(0).get(_priority);
            if (priority != null) {
                html.append(Js.setVal("#" + _priority, priority));
            }
            Object date = row.get(0).get(_date);
            if (date != null) {
                html.append(Js.setValDate("#" + _date, date));
            }
            Object category_id = row.get(0).get(_category_id);
            if (category_id != null) {
                html.append(Js.setVal("#" + _category_id, category_id));
            }
            html.append(Js.setVal("#" + _lang, 2));
            Object content = row.get(0).get(_content);
            if (content != null) {
                html.append(Js.setValEditor(_content, content));
            }
            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Product_button", "<input type=\"button\" id=\"insert_product_new\" value=\"" + lbl_insert + "\" class=\"tahoma10\">"));
                html.append(Js.buttonMouseClick("#insert_product_new", Js.jjProduct.insert()));
            }
            return html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String add_ar(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            Object title = row.get(0).get(_name);
            if (title != null) {
                html.append(Js.setVal("#" + _name, title));
            }
            Object priority = row.get(0).get(_priority);
            if (priority != null) {
                html.append(Js.setVal("#" + _priority, priority));
            }
            Object date = row.get(0).get(_date);
            if (date != null) {
                html.append(Js.setValDate("#" + _date, date));
            }
            Object category_id = row.get(0).get(_category_id);
            if (category_id != null) {
                html.append(Js.setVal("#" + _category_id, category_id));
            }
            html.append(Js.setVal("#" + _lang, 3));
            Object content = row.get(0).get(_content);
            if (content != null) {
                html.append(Js.setValEditor(_content, content));
            }
            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Product_button", "<input type='button' id='insert_product_new_ar' value='" + lbl_insert + "' class='tahoma10'>"));
                html.append(Js.buttonMouseClick("#insert_product_new_ar", Js.jjProduct.insert()));
            }
            return html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
//============ BY RASHIDI ========>
////// ------------- add_lang() ------------->    

    public static String add_lang(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String id = jjTools.getParameter(request, _id);
            String lang = jjTools.getParameter(request, "myLang");
            String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
            if (!errorMessageId.equals("")) {
                if (jjTools.isLangEn(request)) {
                    errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
                }
                return Js.dialog(errorMessageId);
            }
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
            StringBuilder html = new StringBuilder();
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            Object title = row.get(0).get(_name);
            if (title != null) {
                html.append(Js.setVal("#" + _name, title));
            }
            Object priority = row.get(0).get(_priority);
            if (priority != null) {
                html.append(Js.setVal("#" + _priority, priority));
            }
            Object date = row.get(0).get(_date);
            if (date != null) {
                html.append(Js.setValDate("#" + _date, date));
            }
            Object category_id = row.get(0).get(_category_id);
            if (category_id != null) {
                html.append(Js.setVal("#" + _category_id, category_id));
            }
            html.append(Js.setVal("#" + _lang, lang));
            Object content = row.get(0).get(_content);
            if (content != null) {
                html.append(Js.setValEditor(_content, content));
            }
            boolean accIns = Access_User.hasAccess2(request, db, rul_ins);
            if (accIns) {
                html.append(Js.setHtml("#Product_button", "<input type='button' id='insert_product_new_lang' value='" + lbl_insert + "' class='tahoma10'>"));
                html.append(Js.buttonMouseClick("#insert_product_new_lang", Js.jjProduct.insert()));
                html.append(Js.hide("#Product_Language_button"));
            }
            return html.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
////// <------------- add_lang() -------------
//<============ BY RASHIDI ========
//============ BY RASHIDI ========>
////// ------------- buildShoppingCart() ------------->

    /**
     * این تایع آیتم های موجوددر سبد خرید را از دیتابیس واکشی می کند و در قالب
     * یک جدول برمیگرداند تا به کاربر نمایش داده شود.
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String buildShoppingCart(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            String userId = jjTools.getSessionAttribute(request, "#" + Access_User._id.toUpperCase());
            String panel = jjTools.getParameter(request, "panel");
            panel = panel == null ? "sw" : panel;
            String[] productsId = null;
            String comment ="";
            String comment2 ="";
            String comment3 ="";
            String comment4 ="";
            String comment5 ="";
            String lang = jjTools.getSessionAttribute(request, "myLang");

            List<Map<String, Object>> langSetting = jjDatabaseWeb.separateRow(db.Select(Language.tableName, Language._id + " = " + lang));

            String price = "";
            int sumPrice = 0;
//            String productsIdstr = "";
            String where = "";
            Cookie[] cookies = request.getCookies();//آی دی کالاهای موجود در دیتابیس داخل کوکی دخیره شده است پس آنها را از کوکی میخانیم
            Cookie cookie = null;
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equalsIgnoreCase("productsId")) {
                        ServerLog.Print("Product.buildShoppingCart : COOKIE " + cookie.getValue().replace("%2C", ","));
                        productsId = cookie.getValue().replace("%2C", ",").split(",");
//                        productsId = cookie.getValue().split(",");
                    }else
                    //خواندن توضیحات همراه فاکتور
                    if (cookie.getName().equalsIgnoreCase(Factor._comment)) {
                        ServerLog.Print("Product.buildShoppingCart : COOKIE " + cookie.getValue());
                        comment = java.net.URLDecoder.decode(cookie.getValue(),"UTF-8").replaceAll("[\"']", "");;
                        System.out.println(comment);
                    }else if (cookie.getName().equalsIgnoreCase(Factor._comment2)) {
                        comment2 = java.net.URLDecoder.decode(cookie.getValue(),"UTF-8").replaceAll("[\"']", "");;
                        ServerLog.Print("Product.buildShoppingCart : COOKIE " + cookie.getValue());
                        System.out.println(comment2);
                    }else if (cookie.getName().equalsIgnoreCase(Factor._comment3)) {
                        comment3 = java.net.URLDecoder.decode(cookie.getValue(),"UTF-8").replaceAll("[\"']", "");;
                        ServerLog.Print("Product.buildShoppingCart : COOKIE " + cookie.getValue());
                        System.out.println(comment3);
                    }else if (cookie.getName().equalsIgnoreCase(Factor._comment4)) {
                        comment4 = java.net.URLDecoder.decode(cookie.getValue(),"UTF-8").replaceAll("[\"']", "");;
                        ServerLog.Print("Product.buildShoppingCart : COOKIE " + cookie.getValue());
                        System.out.println(comment4);
                    }else if (cookie.getName().equalsIgnoreCase(Factor._comment5)) {

                        comment5 = java.net.URLDecoder.decode(cookie.getValue(),"UTF-8").replaceAll("[\"']", "");
                        ServerLog.Print("Product.buildShoppingCart : COOKIE " + cookie.getValue());
                        System.out.println(comment5);
                    }
                }
            } else {
                return Js.dialog("خطا");
            }
            for (int i = 0; i < productsId.length; i++) {
                if (!productsId[i].equals("")) {////////؟؟؟؟
                    where += _id + " = " + productsId[i] + " OR ";
                }
            }
//            where += _id + " = " + productsId[productsId.length-1];
            where = where.substring(0, where.length() - 4);
//            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _lang + " = " + lang + " AND " + where));
            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, where));
            if (row.isEmpty()) {
                String errorMessage = "رکوردی با این کد وجود ندارد.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Select Fail;";
                }
                return Js.dialog(errorMessage);
            }
//            System.out.println(row);
            StringBuilder html = new StringBuilder();
            
            
            html.append("<table class='shoppingCart' class='tahoma10' style='text-align:center;'><thead>");
            html.append("<th>" + langSetting.get(0).get(Language._productName) + "</th>");
            html.append("<th style='width:10%;'>" + langSetting.get(0).get(Language._number) + "</th>");
            html.append("<th>" + langSetting.get(0).get(Language._price) + "</th>");
            html.append("<th>" + langSetting.get(0).get(Language._sumPrice) + "</th>");
            html.append("<th>" + langSetting.get(0).get(Language._delete) + "</th>");
            html.append("</thead><tbody>");
//            html.append("<table class='shoppingCart' class='tahoma10' style='text-align:center;'><thead>");
//            html.append("<th>نام محصول</th>");
//            html.append("<th style='width:10%;'>تعداد</th>");
//            html.append("<th>قیمت واحد</th>");
//            html.append("<th>قیمت کل</th>");
//            html.append("<th>حذف</th>");
//            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                ///=========Price======>
                if (userId.equals("")) {//اگر کاربر لاگین نکرده باشد و آی دی اش در سشن نباشد
                    price = !"".equals(row.get(i).get(_discount).toString()) ? row.get(i).get(_discount).toString() : row.get(i).get(_price2).toString();//اگر تخفیف برایش در نظر گرفته شود تخفیف نمایش داده می شود.
                } else {//اگر کاربر لاگین کرده باشد
                    List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_Group_User.tableName, Access_Group_User._user_id + " = " + userId));//گروه کاربر را واکشی می کند
                    if (!userRow.isEmpty()) {//اگر کاربر عضو گروهی باشد که قیمت ویژه برای آن ست شده است قیمت مربوط به آن گروه نمایش داده می شود
                        String userGroup = userRow.get(0).get(Access_Group_User._group_id).toString();
//                            System.out.println("userGroup " + userGroup);
                        if (userGroup.equalsIgnoreCase(row.get(i).get(_userGroup1).toString())) {
                            price = "".equals(row.get(i).get(_groupPrice1).toString()) ? row.get(i).get(_price2).toString() : row.get(i).get(_groupPrice1).toString();
                        } else if (userGroup.equalsIgnoreCase(row.get(i).get(_userGroup2).toString())) {
                            price = "".equals(row.get(i).get(_groupPrice2).toString()) ? row.get(i).get(_price2).toString() : row.get(i).get(_groupPrice2).toString();
                        } else if (userGroup.equalsIgnoreCase(row.get(i).get(_userGroup3).toString())) {
                            price = "".equals(row.get(i).get(_groupPrice3).toString()) ? row.get(i).get(_price2).toString() : row.get(i).get(_groupPrice3).toString();
                        } else if (userGroup.equalsIgnoreCase(row.get(i).get(_userGroup4).toString())) {
                            price = row.get(i).get(_groupPrice4).toString();
                        } else if (userGroup.equalsIgnoreCase(row.get(i).get(_userGroup5).toString())) {
                            price = "".equals(row.get(i).get(_groupPrice5).toString()) ? row.get(i).get(_price2).toString() : row.get(i).get(_groupPrice5).toString();
                        } else {
                            price = row.get(i).get(_price2).toString();
                        }
                    } else {//اگر کاربر عادی باشد قیمت اصلی نمایش داده میشود
                        price = !"".equals(row.get(i).get(_discount).toString()) ? row.get(i).get(_discount).toString() : row.get(i).get(_price2).toString();
                    }
                }
                sumPrice += Integer.parseInt(price);
                ///<=========Price======
                Integer number = i + 1;
                html.append("<tr id='prRowTr" + row.get(i).get(_id).toString() + "'>");
                html.append("<td><input type='hidden' value=\"" + row.get(i).get(_id).toString() + "\">" + row.get(i).get(_name).toString() + "</td>");
                html.append("<td><input class='inputNum' type='number' id='account_factor_pr_count_" + number + "' name='account_factor_pr_count_" + number + "' value='1' onchange='calculatePrice(" + row.get(i).get(_id).toString() + ");'></td>");
                html.append("<td><span class='unitPrice'>" + price + "</span> <span>" + row.get(i).get(_currency) + "</span></td>");
                html.append("<td><span class='sumPrice'>" + price + "</span> <span>" + row.get(i).get(_currency) + "</span></td>");
                html.append("<td  class='deleteRow'><img src='img/delete.png' onclick='deletePrFromCart(" + row.get(i).get(_id).toString() + ");'></td>");
                html.append("</tr>");
            }
            html.append("</tbody></table>");
//            html.append("<input type='hidden' value='"+productsIdstr+"'>");
//            String script = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
//            html.append("<div class='ProductdetailBtnLn" + lang + "'>");
//            html.append("<a class='coGruopproduct" + lang + "' onclick=\"payment();\"/>پرداخت</a>");
//            html.append("<a class='moreDetaile" + lang + "' class='moreDatale" + lang + "' onclick=\"alert(123);\">ادامه خرید</a>");
//            html.append("</div>");
            html.append("<div class='finalPriceDiv'>");
            html.append("<span>" + langSetting.get(0).get(Language._sumPayment) + "</span>");
            html.append("<span id='finalPrice'>" + sumPrice + "</span>");
//            html.append("<input type='hidden' id='" + Factor._sum + "' name='" + Factor._sum + "' value='" + sumPrice + "'>");
            html.append("</div>");
            html.append("<div class='factorComments'>");
            html.append("<span>توضیحات</span>");
            html.append("<input class='inputComment' name='" + Factor._comment + "' id='" + Factor._comment + "' placeholder='توضیحات ' value='"+comment+"' />");
            html.append("<input class='inputComment' name='" + Factor._comment2 + "' id='" + Factor._comment2 + "' placeholder='توضیحات ' value='"+comment2+"' />");
            html.append("<input class='inputComment' name='" + Factor._comment3 + "' id='" + Factor._comment3 + "' placeholder='توضیحات ' value='"+comment3+"' />");
            html.append("<input class='inputComment' name='" + Factor._comment4 + "' id='" + Factor._comment4 + "' placeholder='توضیحات ' value='"+comment4+"' />");
            html.append("<input class='inputComment' name='" + Factor._comment5 + "' id='" + Factor._comment5 + "' placeholder='توضیحات ' value='"+comment5+"' />");
            html.append("</div>");          
            html.append("</div>");
            //نمایش درگاه های پرداخت
            List<Map<String, Object>> bankRow = jjDatabaseWeb.separateRow(db.Select(PaymentSetting.tableName));
            if (!bankRow.isEmpty()) {
                html.append("<div class='bankDiv'>");
                for (int i = 0; i < bankRow.size(); i++) {
                    html.append("<label> <input name='" + PaymentSetting._webService + "' id='" + bankRow.get(i).get(PaymentSetting._webService) + "' type='radio' value='" + bankRow.get(i).get(PaymentSetting._webService) + "'>");
                    html.append(" " + bankRow.get(i).get(PaymentSetting._bankName) + "</label>");
                }
                html.append("</div>");
            } else {
                html.append("<div class='bankDiv' style='display:none;'><label><input type='radio' checked></label></div>");
            }

            html.append("<div class='btnDiv'>");
            html.append("<a href='' class='paymentBtn' id=\"paymentBtn\" onclick=\"prePayment();return false;\">" + langSetting.get(0).get(Language._payment) + "</a>");
//            html.append("<a class='paymentBtn' id=\"paymentBtn\" onclick='payment();'>" + langSetting.get(0).get(Language._payment) + "</a>");
            html.append("<a class='contBuyBtn' id='contBuyBtn' onclick=\"swGetProducts();\">" + langSetting.get(0).get(Language._contBuy) + "</a>");
            html.append("</div>");
            html.append("<div>");
            StringBuilder script = new StringBuilder();
            script.append("$('html, body').animate({scrollTop: $('#"+panel+"').offset().top}, 500);");
            script.append(Js.setHtml(panel, html.toString()));
//            script.append(Js.show("#paymentBtn"));
            return script.toString();
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    ////// <------------- buildShoppingCart() -------------
//<============ BY RASHIDI ========
//    public static String getList_En(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
//        try {
//            ServerLog.Print("Run: product.getList_En");
//            StringBuffer html = new StringBuffer();
//            StringBuffer html3 = new StringBuffer();
//            String id = jjTools.getParameter(request, "id");
//            id = jjNumber.isDigit(id) ? id : "1";
//            String panel = jjTools.getParameter(request, "panel");
//            panel = panel == null ? "sw" : panel;
//            List<Map<String, Object>> rowCategory = jjDatabase.separateRow(db.Select(Category_product.tableName, Category_product._parent + "=" + id + " AND " + Category_product._lang + "=2"));
//            html3.append("<span class='productLink'>product</span><span class='productLinkFlash'>&nbsp;>&nbsp;</span>");
//            if (rowCategory.size() > 0) {
//                html3.append("<a class='productLink' onclick='swGetProducts("
//                        + rowCategory.get(0).get(Category_product._parent) + ");'>" + rowCategory.get(0).get(Category_product._title) + "</a>");
//
//                List<Map<String, Object>> categoryRow = jjDatabase.separateRow(db.Select(Category_product.tableName, Category_product._lang + "=2"));
//                html3.append("<span class='productLinkFlash'>&nbsp;&nbsp;(</span>");
//                int counter2 = 0;
//                for (int i = 0; i < categoryRow.size(); i++) {
//                    if (db.Select(tableName, _category_id + "=" + categoryRow.get(i).get(Category_product._parent)).getRowCount() > 0) {
//                        if (!rowCategory.get(0).get(Category_product._id).toString().equals(categoryRow.get(i).get(Category_product._id).toString())) {
//                            counter2 += 1;
//                            html3.append((counter2 == 1 ? "<span class='productLinkFlash'> or </span>" : "<span class='productLinkFlash'>, </span>") + "<a  class='productLink' onclick='swGetProducts("
//                                    + categoryRow.get(i).get(Category_product._parent) + ");' >"
//                                    + categoryRow.get(i).get(Category_product._title) + "</a>");
//                        }
//                    }
//                }
//
//                html3.append("<span class='productLinkFlash'>)</span><br/><br/>");
//                if (counter2 > 0) {
//                    html.append(html3.toString());
//                }
//                List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _category_id + "=" + rowCategory.get(0).get(Category_product._parent) + " AND " + _lang + "=2"));
//                int counter = 0;
//                for (int i = 0; i < row.size(); i++) {
//                    counter += 1;
//                    html.append("<a dir='ltr' onclick='swproduct(" + row.get(i).get(_id) + ");' class='mousePointer'>");
//                    html.append("<span class='productListDate'>" + counter + ". ");
////                    html.append(jjCalendar_IR.getViewFormat(row.get(i).get(_date).toString()));
//                    jjCalendar_IR ir = new jjCalendar_IR(row.get(i).get(_date).toString());
//                    jjCalendar_EN en = ir.convertPersianToGregorian();
//                    html.append(en.getYear_4length() + "/" + en.getMonth_2length() + "/" + en.getDay_2length());
//                    html.append(" </span><span class='productList'>");
//                    html.append(row.get(i).get(_title).toString() + "</span></a><br/>");
//                }
//
//
//            }
//            String script = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
////        script += Js.table("#sss", height, sort, "");
//            return script;
//        } catch (Exception ex) {
//            return Server.ErrorHandler(ex);
//        }
//    }
//
//    public static String getList_Ar(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
//        try {
//            ServerLog.Print("Run: product.getList_Ar");
//            StringBuffer html = new StringBuffer();
//            StringBuffer html3 = new StringBuffer();
//            String id = jjTools.getParameter(request, "id");
//            id = jjNumber.isDigit(id) ? id : "1";
//            String panel = jjTools.getParameter(request, "panel");
//            panel = panel == null ? "sw" : panel;
//            List<Map<String, Object>> rowCategory = jjDatabase.separateRow(db.Select(Category_product.tableName,
//                    Category_product._parent + "=" + id + " AND " + Category_product._lang + "=3"));
//
//            html3.append("<span class='productLink'>");
//            html3.append("أخبار");
//            html3.append("</span><span class='productLinkFlash'>&nbsp;>&nbsp;</span>");
//            if (rowCategory.size() > 0) {
//                html3.append("<a class='productLink' onclick='swGetProducts("
//                        + rowCategory.get(0).get(Category_product._parent) + ");'>" + rowCategory.get(0).get(Category_product._title) + "</a>");
//
//                List<Map<String, Object>> categoryRow = jjDatabase.separateRow(db.Select(Category_product.tableName, Category_product._lang + "=3"));
//                html3.append("<span class='productLinkFlash'>&nbsp;&nbsp;(</span>");
//                int counter2 = 0;
//                for (int i = 0; i < categoryRow.size(); i++) {
//                    if (db.Select(tableName, _category_id + "=" + categoryRow.get(i).get(Category_product._parent)).getRowCount() > 0) {
//                        if (!rowCategory.get(0).get(Category_product._id).toString().equals(categoryRow.get(i).get(Category_product._id).toString())) {
//                            counter2 += 1;
//                            html3.append((counter2 == 1 ? "<span class='productLinkFlash'> أو </span>" : "<span class='productLinkFlash'>, </span>")
//                                    + "<a  class='productLink' onclick='swGetProducts("
//                                    + categoryRow.get(i).get(Category_product._parent) + ");' >"
//                                    + categoryRow.get(i).get(Category_product._title) + "</a>");
//                        }
//                    }
//                }
//
//                html3.append("<span class='productLinkFlash'>)</span><br/><br/>");
//                if (counter2 > 0) {
//                    html.append(html3.toString());
//                }
//                List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _category_id + "=" + rowCategory.get(0).get(Category_product._parent) + " AND " + _lang + "=3"));
//                int counter = 0;
//                for (int i = 0; i < row.size(); i++) {
//                    counter += 1;
//                    html.append("<a dir='rtl' onclick='swproduct(" + row.get(i).get(_id) + ");' class='mousePointer'>");
//                    html.append("<span class='productListDate'>" + counter + ". ");
//                    html.append(jjCalendar_IR.getViewFormat(row.get(i).get(_date).toString()) + " </span><span class='productList'>");
//                    html.append("</span></a><br/>");
//                }
//
//
//            }
//            String script = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
////        script += Js.table("#sss", height, sort, "");
//            return script;
//        } catch (Exception ex) {
//            return Server.ErrorHandler(ex);
//        }
//    }  
    //===============================SHAHSANAEI==============================>
    public static String getTopProducts(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            String panel = jjTools.getParameter(request, "panel");
            String maxNo = (jjTools.getParameter(request, "maxNo").equals("")) ? "10" : jjTools.getParameter(request, "maxNo");//تعداد محصولاتی که کاربر خواستار دیدن آن هاست
            String split = jjTools.getParameter(request, "split");//کاربر میخواهد محصولات را چندتا چندتا ببیند

//            double countOfDivs = (double) Integer.parseInt(maxNo) / (double) Integer.parseInt(split);//تعداد دایوهای مورد نیاز
//            System.out.println(".................................double : " + countOfDivs);
//            int floorOfDivs = Math.floorDiv(Integer.parseInt(maxNo), Integer.parseInt(split)); //جزء صحیح تعداد دایوهای مورد نیاز
//            System.out.println(".................................int : " + floorOfDivs);
//
//            if (countOfDivs != floorOfDivs) {//اگر تعداد دایوها جزء اعشاری داشته باشد و عدد صحیح نباشد یکی به تعداد دایوهای مورد نیاز می افزاید
//                countOfDivs++;
//            }
            List<Map<String, Object>> topProducts = jjDatabase.separateRow(db.SelectDescLimit(tableName, _active + " = 1 ", _date, maxNo));
            for (int i = 0; i < 50 && i < topProducts.size(); i++) {//maximum 50 top product return
                if ((double) i / (double) Integer.parseInt(split) == i / Integer.parseInt(split)) {//برای هرگروه از کالاها که با توجه به متغیر اسپلیت تعریف میشوند یک دایو جداگانه میسازد
                    html.append("<div style='border:1px solid gray; padding:2px;' id='productGroup(" + (i / Integer.parseInt(split)) + ")' class=\"col-md-2 col-sm-4 col-xs-6 col-p5\">");
                }
                if (Boolean.valueOf(topProducts.get(i).get(_active).toString())) {
                    html.append("<div class=\"col-md-2 col-sm-4 col-xs-6 col-p5\">"
                            + "<div class=\"thumbnail\">"
                            + "<a title = \"" + topProducts.get(i).get(_name) + "\" class=\"fancy fancybox\" href=\"upload/" + topProducts.get(i).get(_pic1).toString() + "\" data-fancybox-group=\"gallery\">"
                            //                            + "<img src=\"upload/" + topProducts.get(i).get(_pic1).toString().replace(".", "_small.") + "\" onclick='cmsProduct.m_select(" + topProducts.get(i).get(_id).toString() + ") alt=\"" + topProducts.get(i).get(_name) + "\">"
                            + "<img src=\"upload/" + topProducts.get(i).get(_pic1).toString().replace(".", ".") + "\" onclick='cmsProduct.m_select(" + topProducts.get(i).get(_id).toString() + ") alt=\"" + topProducts.get(i).get(_name) + "\">"
                            + "<div><span class=\"span\"><span class=\"glyphicon glyphicon-search\"></span></span></div>"
                            + "</a>"
                            + "<div class=\"caption\">"
                            + "<a href=\"#\" onclick='cmsProduct.m_select(" + topProducts.get(i).get(_id).toString() + ")'>" + topProducts.get(i).get(_name) + "</a>"
                            + "<p><a class=\"btn btn-default button\" href=\"#\" onclick=\"cmsProduct.m_select(" + topProducts.get(i).get(_id).toString() + ");return false;\">"
                            + "بیشتر بخوانید "
                            + "</a></p>"
                            + "</div>"
                            + "</div>"
                            + "</div>");
                }
                if ((double) (i + 1) / (double) Integer.parseInt(split) == (i + 1) / Integer.parseInt(split)) {//اگر دایو جدیدی برای یک گروه کالا ساخته شده باشد اینجا بسته میشود
                    html.append("</div>");
                }
            }
            if (panel.equals("")) {
                panel = "showTopProductsDiv";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String showDevidedProducts(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            String panel = jjTools.getParameter(request, "panel");
            String split = jjTools.getParameter(request, "split");//کاربر میخواهد محصولات را چندتا چندتا ببیند
            String page = jjTools.getParameter(request, "page");//کاربر میخواهد محصولات کدام صفحه را ببیند

            List<Map<String, Object>> allProducts = jjDatabase.separateRow(db.Select(tableName));

            int start = Integer.parseInt(split) * Integer.parseInt(page) - Integer.parseInt(split);//در این دو خط معلوم میشود از چه محصولی تا چه محصولی به کاربر نمایش داده شود
            int end = start + Integer.parseInt(split);

            for (int i = start; i < end && i < allProducts.size(); i++) {
//                html.append("<div style='border:1px solid gray; padding:2px;' class=\"col-md-2 col-sm-4 col-xs-6 col-p5\">");
                if (Boolean.valueOf(allProducts.get(i).get(_active).toString())) {
                    html.append("<div class=\"col-md-2 col-sm-4 col-xs-6 col-p5\">"
                            + "<div class=\"thumbnail\">"
                            + "<a title = \"" + allProducts.get(i).get(_name) + "\" class=\"fancy fancybox\" href=\"upload/" + allProducts.get(i).get(_pic1).toString() + "\" data-fancybox-group=\"gallery\">"
                            + "<img src=\"upload/" + allProducts.get(i).get(_pic1).toString().replace(".", "_small.") + "\" onclick='cmsProduct.m_select(" + allProducts.get(i).get(_id).toString() + ") alt=\"" + allProducts.get(i).get(_name) + "\">"
                            + "<div><span class=\"span\"><span class=\"glyphicon glyphicon-search\"></span></span></div>"
                            + "</a>"
                            + "<div class=\"caption\">"
                            + "<a href=\"#\" onclick='cmsProduct.m_select(" + allProducts.get(i).get(_id).toString() + ")'>" + allProducts.get(i).get(_name) + "</a>"
                            + "<p><a class=\"btn btn-default button\" href=\"#\" onclick=\"cmsProduct.m_select(" + allProducts.get(i).get(_id).toString() + ");return false;\">"
                            + "بیشتر بخوانید "
                            + "</a></p>"
                            + "</div>"
                            + "</div>"
                            + "</div>");
                }
            }

            if (panel.equals("")) {
                panel = "showDividedProductsDiv";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String calculateNumOfPages(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            String panel = jjTools.getParameter(request, "panel");
            String split = jjTools.getParameter(request, "split");//کاربر میخواهد محصولات را چندتا چندتا ببیند

            List<Map<String, Object>> allProducts = jjDatabase.separateRow(db.Select(tableName));

            int numOfPages = Math.floorDiv(allProducts.size(), Integer.parseInt(split));
            System.out.println(".................................int : " + numOfPages);
            if (numOfPages != (double) allProducts.size() / (double) Integer.parseInt(split)) {//اگر تعداد کل کالاها بر متغیر اسپلیت بخش پذیر نباشد یعنی تعدادی کالا اضافه داریم و باید برای آن ها یک صفحه دیگر اضافه شود
                numOfPages++;
            }
            ;
            html.append("<tr>");
            int temp;
            for (int j = 0; j < numOfPages; j++) {
                temp = j + 1;
                html.append("<td onclick=\"cmsProduct.showdevidedProducts(" + split + ", " + temp + ");\">" + temp + "</td>");//?????????????????????????????????????????????????????????????????????
            }
            html.append("</tr>");
            html.append(Js.show("pagingDiv"));
            String html2 = Js.setHtml("#pagingDiv", html.toString());
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String loadProduct(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            String panel = jjTools.getParameter(request, "panel");
            String start = jjTools.getParameter(request, "start");
            String end = jjTools.getParameter(request, "end");

            List<Map<String, Object>> allProducts = jjDatabase.separateRow(db.Select(tableName));

            for (int i = Integer.parseInt(start); i < Integer.parseInt(end) && i < allProducts.size(); i++) {
                html.append("<div class=\"col-md-2 col-sm-4 col-xs-6 col-p5\">"
                        + "<div class=\"thumbnail\">"
                        + "<a title = \"" + allProducts.get(i).get(_name) + "\" class=\"fancy fancybox\" href=\"upload/" + allProducts.get(i).get(_pic1).toString() + "\" data-fancybox-group=\"gallery\">"
                        + "<img src=\"upload/" + allProducts.get(i).get(_pic1).toString().replace(".", "_small.") + "\" onclick='cmsProduct.m_select(" + allProducts.get(i).get(_id).toString() + ") alt=\"" + allProducts.get(i).get(_name) + "\">"
                        + "<div><span class=\"span\"><span class=\"glyphicon glyphicon-search\"></span></span></div>"
                        + "</a>"
                        + "<div class=\"caption\">"
                        + "<a href=\"#\" onclick='cmsProduct.m_select(" + allProducts.get(i).get(_id).toString() + ")'>" + allProducts.get(i).get(_name) + "</a>"
                        + "<p><a class=\"btn btn-default button\" href=\"#\" onclick=\"cmsProduct.m_select(" + allProducts.get(i).get(_id).toString() + ");return false;\">"
                        + "بیشتر بخوانید "
                        + "</a></p>"
                        + "</div>"
                        + "</div>"
                        + "</div>");
            }

            if (panel.equals("")) {
                panel = "products";
            }
            String html2 = Js.append("#" + panel, html.toString());
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static int numOfProducts(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        List<Map<String, Object>> allProducts = jjDatabase.separateRow(db.Select(tableName));
        return allProducts.size();
    }
//<===============================SHAHSANAEI==============================
//public static void main(String[] args) {
//        long timeNow = System.currentTimeMillis();
//        System.out.println(timeNow);
//    }

    public static String getAllTags(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            String panel = jjTools.getParameter(request, "panel");

            List<Map<String, Object>> allTags = jjDatabase.separateRow(db.Select("tags"));

            for (int j = 0; j < allTags.size(); j++) {
                html.append("<input type='checkbox' name='tagsCheckBox' value='" + allTags.get(j).get("tags_name") + "'> " + allTags.get(j).get("name") + " </input>");//?????????????????????????????????????????????????????????????????????
            }
            String html2 = Js.setHtml(_tag1, html.toString());
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
//============ BY RASHIDI ========>

    public static String getSlider2(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            StringBuilder html = new StringBuilder();
            String lang = jjTools.getLangNum(request);
            List<Map<String, Object>> langSetting = jjDatabaseWeb.separateRow(db.Select(Language.tableName, Language._id + " = " + lang));
            String width = jjTools.getParameter(request, "width").replace("px", "");
            String height = jjTools.getParameter(request, "height").replace("px", "");
            width = jjNumber.isDigit(width) ? width : "800";
            height = jjNumber.isDigit(height) ? height : "300";
            html.append("<ul>");

            List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _priority + "=1 AND " + _lang + "=" + jjTools.getLangNum(request)));
            for (int i = 0; i < row.size(); i++) {
                html.append("<li><div dir='" + jjTools.getLangNumDir(request)//برای یکسری زبان ها چپ چین باید بشه یک سری ها راست چین
                        + "' style='overflow: hidden;height:" + height + "px;width:" + width + "px;text-align: "
                        + jjTools.getLangAlign(request)//برای یکسری زبان ها چپ چین باید بشه یک سری ها راست چین
                        + ";'>");
                html.append("<div class='productTitle'>" + row.get(i).get(_name).toString() + "</div>");
                html.append("<div class='productPIC'><img src='upload/" + row.get(i).get(_pic1).toString() + "'/></div>");
                html.append("<div class='productAbstract' >");
                String content = Content.ConvertToWiki(request, row.get(i).get(_abstract).toString().replace("<li>", "").replace("<li dir='rtl'>", "").replace("</li>", ""), db, isPost);
//                html.append(row.get(i).get(_abstract).toString().replace("<li>", "").replace("<li dir='rtl'>", "").replace("</li>", ""));
                html.append(content);
                html.append("</div>");
                html.append("</div><div valign='top' class='productMore' dir='" + jjTools.getLangDir(request)
                        + "' style='text-align: left;vertical-align: top;'>");
//                        + "' style='text-align: left;height:17px;padding:1px;vertical-align: top;'>");
                html.append("<a class='productMoreInSlider' onclick=getOneproduct(" + row.get(i).get(_id) + ");return false>");
                html.append(langSetting.get(0).get(Language._detail));
                html.append("</a></div></li>");
            }
            html.append("</ul>");
            String panel = jjTools.getParameter(request, "panel");
            if (panel.equals("")) {
                panel = "jjSliderProduct";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());
            html2 += getSliderRunScript2(panel);
            return html2;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String getSliderRunScript2(String divId) {
        try {
//        return ";\n";
            return "$('#" + divId + "').easySlider({controlsBefore:'<p id=\"controls\">',controlsAfter:'</p>',auto: true,continuous: true});\n";
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String sw(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
//            if (jjTools.isLangEn(request)) {
//                return sw_En(request, db, isPost);
//            }
//            if (jjTools.isLangAr(request)) {
//                return sw_Ar(request, db, isPost);
//            }

            String lang = jjTools.getLangNum(request);
            List<Map<String, Object>> langSetting = jjDatabaseWeb.separateRow(db.Select(Language.tableName, Language._id + " = " + lang));

            String id = jjTools.getParameter(request, "id").trim();
            String panel = jjTools.getParameter(request, "panel");
            panel = (panel.equals("") ? "swTitle" : panel);
            if (jjNumber.isDigit(id)) {
                List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
                if (row.size() > 0) {
                    StringBuilder html = new StringBuilder();

                    List<Map<String, Object>> rowParent = jjDatabase.separateRow(db.Select(Category_Product.tableName, Category_Product._id + "=" + row.get(0).get(_category_id)));
                    String persianTitle = "Unknown";
                    if (rowParent.size() > 0) {
                        persianTitle = rowParent.get(0).get(Category_Product._title).toString();
//                        if (!jjTools.isLangFa(request)) {
//                            productCategory1 = jjDatabase.separateRow(db.Select(Category_Product.tableName, Category_Product._parent + "=" + row.get(0).get(_category_id)));
//                        }
                        html.append("<a onclick='swGetProducts();' class='productLink'>");
                        html.append(langSetting.get(0).get(Language._product));
                        if (rowParent.size() > 0) {
                            html.append("</a><span class='productLinkFlash'>&nbsp;>&nbsp;</span><a onclick='swGetProducts("
                                    + row.get(0).get(_category_id) + ");' class='productLink'>");
                            html.append(rowParent.get(0).get(Category_Product._title));
                        } else {
                            html.append("</a><span class='productLinkFlash'>&nbsp;>&nbsp;</span><a onclick='swGetProducts("
                                    + row.get(0).get(_category_id)
                                    + ");' class='productLink'>");
                            html.append(persianTitle);
                        }
                    }
                    html.append("</a><span class='productLinkFlash'>&nbsp;>&nbsp;</span><span class='productLink'>");
                    html.append(row.get(0).get(_name).toString() + "</span><br/>");
//                    html.append(row.get(0).get(_name).toString() + "</span><br/><br/><span class='productContent'>" + row.get(0).get(_content).toString() + "</span>");
                    return Js.setHtml("#" + panel, html.toString());
                }
            }
            String errorMessage = "رکوردی با این محتوا وجود ندارد.";
            if (jjTools.isLangEn(request)) {
                errorMessage = "wiki Text Product Fail;";
            }
            return Js.setHtml("#" + panel, errorMessage);
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }

    public static String getOneProduct(HttpServletRequest request, jjDatabaseWeb db, boolean isPost) throws Exception {
        try {
            //============ BY RASHIDI ========>
            String userId = jjTools.getSessionAttribute(request, "#" + Access_User._id.toUpperCase());
            String price = "";
            String discountPrice = "";
            String lang = jjTools.getSessionAttribute(request, "myLang")==""?"1":jjTools.getSessionAttribute(request, "myLang");
            List<Map<String, Object>> langSetting = jjDatabaseWeb.separateRow(db.Select(Language.tableName, Language._id + " = " + lang));
            //<============BY RASHIDI ========
            StringBuilder html = new StringBuilder();//for Div,Span and other Html elements
            StringBuilder html2 = new StringBuilder();//for Div,Span and other Html elements
            String panel = jjTools.getParameter(request, "panel");
            String id = jjTools.getParameter(request, _id);
            panel = panel == null ? "sw" : panel;
            String titlePanel = jjTools.getParameter(request, "title");
            String title = "";
            //============ BY RASHIDI ========>
            if (jjNumber.isDigit(id)) {
                List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
                if (row.isEmpty()) {
                    String errorMessage = "رکوردی با این کد وجود ندارد.";
                    if (jjTools.isLangEn(request)) {
                        errorMessage = "Select Fail;";
                    }
                    return Js.dialog(errorMessage);
                }
                if (row.size() > 0) {
                    /////***********توجه*************
                    //به جای این چند خط کد باید یک کوئری اسکیوال جایگزین شود که کتگوری های مد نظر را بگیرد.---->
                    List<Map<String, Object>> allCategoryProduct = jjDatabase.separateRow(db.Select(Category_Product.tableName));
                    String currentCategory = row.get(0).get(_category_id).toString();
                    List<String> categoryNames = new ArrayList<String>();
                    List<String> categoryIds = new ArrayList<String>();
                    int i = 0;
                    while (!currentCategory.equals("0") && i < 1000) {//&& i < 1000 age too loop oftad!!!!!!!!!!!!!!!!!!!!!!!!!!
                        for (i = 0; i < allCategoryProduct.size(); i++) {
                            if (allCategoryProduct.get(i).get(Category_Product._id).toString().equals(currentCategory)) {
                                categoryNames.add(allCategoryProduct.get(i).get(Category_Product._title).toString());
                                categoryIds.add(allCategoryProduct.get(i).get(Category_Product._id).toString());
                                currentCategory = allCategoryProduct.get(i).get(Category_Product._upperNode).toString();
                            }
                        }
                    }

                    html.append("<div class='oneProductDiv'><div class='titleDiv'><a onclick='swGetProducts();' class='productLink'>");
                    html.append(langSetting.get(0).get(Language._product));
                    for (i = categoryNames.size() - 1; i >= 0; i--) {
                        html.append("</a><span class='productLinkFlash'>&nbsp;>&nbsp;</span><a onclick='swGetProducts("
                                + categoryIds.get(i) + ");' class='productLink'>");
                        html.append(categoryNames.get(i));
                    }
                    html.append("</a><span class='productLinkFlash'>&nbsp;>&nbsp;</span><span class='productLink'>");
                    html.append(row.get(0).get(_name).toString() + "</span><br/></div>");
                    //به جای این چند خط کد باید یک کوئری اسکیوال جایگزین شود که کتگوری های مد نظر را بگیرد.<----

//                    String persianTitle = "Unknown";
//                    if (productCategory1.size() > 0) {
//                        persianTitle = productCategory1.get(0).get(Category_Product._title).toString();
////                        if (!jjTools.isLangFa(request)) {
////                            productCategory1 = jjDatabase.separateRow(db.Select(Category_Product.tableName, Category_Product._parent + "=" + row.get(0).get(_category_id)));
////                        }
//                        html.append("<div class='titleDiv'><a onclick='swGetProducts();' class='productLink'>");
//                        html.append(langSetting.get(0).get(Language._product));
//                        for (int i = 0; i < categoryListId.size(); i++) {
//                            html.append("</a><span class='productLinkFlash'>&nbsp;>&nbsp;</span><a onclick='swGetProducts("
//                                    + categoryListId.get(i) + ");' class='productLink'>");
//                            html.append(productCategory1.get(0).get(Category_Product._title));
//                        }
//                        if (!allCategoryProduct.isEmpty()) {
//
//                        } else {
//                        }
//                        if (productCategory1.size() > 0) {
//                            html.append("</a><span class='productLinkFlash'>&nbsp;>&nbsp;</span><a onclick='swGetProducts("
//                                    + row.get(0).get(_category_id) + ");' class='productLink'>");
//                            html.append(productCategory1.get(0).get(Category_Product._title));
//                        } else {
//                            html.append("</a><span class='productLinkFlash'>&nbsp;>&nbsp;</span><a onclick='swGetProducts("
//                                    + row.get(0).get(_category_id)
//                                    + ");' class='productLink'>");
//                            html.append(persianTitle);
//                        }
//                    }
//                    html.append("</a><span class='productLinkFlash'>&nbsp;>&nbsp;</span><span class='productLink'>");
//                    html.append(row.get(0).get(_name).toString() + "</span><br/></div>");
////                    html.append(row.get(0).get(_name).toString() + "</span><br/><br/><span class='productContent'>" + row.get(0).get(_content).toString() + "</span>");
//                }
//            }
                    //<============BY RASHIDI ========
                    //to incriment visited time
                    boolean flag = db.otherStatement("UPDATE " + tableName + " SET " + _visit + " = " + _visit + "+1 WHERE " + _id + "=" + id);
//                    List<Map<String, Object>> row;
//                    row = jjDatabase.separateRow(db.Select(tableName, _id + " = " + id));
//                    if (row.isEmpty()) {
//                        String errorMessage = "رکوردی با این کد وجود ندارد.";
//                        if (jjTools.isLangEn(request)) {
//                            errorMessage = "Select Fail;";
//                        }
//                        return Js.dialog(errorMessage);
//                    }
                    html.append("<div>");
                    //============ BY RASHIDI ========>
                    if (lang.equals("1")) {
                        html.append("<span class='productDatespan'>" + jjCalendar_IR.getViewFormat(row.get(0).get(_date).toString()) + "</span>");
                    } else {
                        jjCalendar_IR irDate = new jjCalendar_IR(row.get(0).get(_date).toString());
                        jjCalendar_EN enDate = new jjCalendar_EN();
                        enDate = irDate.convertPersianToGregorian();
                        html.append("<span class='productDatespan'>" + enDate.getViewFormat_10length() + "</span>");
                    }
                    html.append("<div class='productPicDiv'>");
                    String src1 = row.get(0).get(_pic1).toString();
                    String src2 = row.get(0).get(_pic2).toString();
                    String src3 = row.get(0).get(_pic3).toString();
                    String src4 = row.get(0).get(_pic4).toString();
                    String src5 = row.get(0).get(_pic5).toString();
                    String src6 = row.get(0).get(_pic6).toString();
                    String src_ext = row.get(0).get(_pic_ext).toString();
                    String smalPicSrc = "";
//                    smalPicSrc = src1.replace(".", "_small.");//select small pic
                    html.append("<a class='productExtraLink' href='upload/" + src1 + "'><img class='mainPic productPic' src='upload/" + src1 + "' alt='" + row.get(0).get(_name).toString().replace("'", "").replace("\"", "") + "'/></a>");
                    html.append("<div class='productExtraDiv'>");

                    if (!src1.equalsIgnoreCase("")) {
                        smalPicSrc = src1.replace(".", "_small.");
                        html.append("<a onclick='changeProductPic(this);return false;' class='productPicLink' href='upload/" + src1 + "'> <img class='productPic' src='upload/" + smalPicSrc + "' alt='" + row.get(0).get(_name).toString().replace("'", "").replace("\"", "") + "'/></a>");
                    }
                    if (!src2.equalsIgnoreCase("")) {
                        smalPicSrc = src2.replace(".", "_small.");
                        html.append("<a onclick='changeProductPic(this);return false;' class='productPicLink' href='upload/" + src2 + "'><img class='productPic' src='upload/" + smalPicSrc + "' alt='" + row.get(0).get(_name).toString().replace("'", "").replace("\"", "") + "' /></a>");
                    }
                    if (!src3.equalsIgnoreCase("")) {
                        smalPicSrc = src3.replace(".", "_small.");
                        html.append("<a onclick='changeProductPic(this);return false;' class='productPicLink' href='upload/" + src3 + "'><img class='productPic' src='upload/" + smalPicSrc + "' alt='" + row.get(0).get(_name).toString().replace("'", "").replace("\"", "") + "' /></a>");
                    }
                    if (!src4.equalsIgnoreCase("")) {
                        smalPicSrc = src4.replace(".", "_small.");
                        html.append("<a onclick='changeProductPic(this);return false;' class='productPicLink' href='upload/" + src4 + "'><img class='productPic' src='upload/" + smalPicSrc + "' alt='" + row.get(0).get(_name).toString().replace("'", "").replace("\"", "") + "' /></a>");
                    }
                    if (!src5.equalsIgnoreCase("")) {
                        smalPicSrc = src5.replace(".", "_small.");
                        html.append("<a onclick='changeProductPic(this);return false;' class='productPicLink' href='upload/" + src5 + "'><img class='productPic' src='upload/" + smalPicSrc + "' alt='" + row.get(0).get(_name).toString().replace("'", "").replace("\"", "") + "' /></a>");
                    }
                    if (!src6.equalsIgnoreCase("")) {
                        smalPicSrc = src6.replace(".", "_small.");
                        html.append("<a onclick='changeProductPic(this);return false;' class='productPicLink' href='upload/" + src6 + "'><img class='productPic' src='upload/" + smalPicSrc + "' alt='" + row.get(0).get(_name).toString().replace("'", "").replace("\"", "") + "' /></a>");
                    }
                    if (!src_ext.equalsIgnoreCase("")) {
                        smalPicSrc = src_ext.replace(".", "_small.");
                        html.append("<img class='productPic' src='upload/" + smalPicSrc + "' alt='" + row.get(0).get(_name).toString().replace("'", "").replace("\"", "") + "' />");
                    }
                    html.append("</div></div>");

                    html.append("<span class='productTitlespan'><h3>" + row.get(0).get(_name).toString() + "</h3></span>");

             
                    html.append("<div class='productabstarctDiv'><h4>" + row.get(0).get(_page).toString());
                    html.append("<div>");
                    for (int j = 1; j <= 20; j++) {
                        String prop = "account_product_prop" + String.valueOf(j);
                        String val = "account_product_val" + String.valueOf(j);
                        if ((row.get(0).get(val) != null) && (!row.get(0).get(val).toString().equals("")) && (row.get(0).get(prop) != null) && (!row.get(0).get(prop).toString().equals(""))) {
                            html.append("<div class='productPropVal'><span class='productProp'>" + row.get(0).get(prop).toString() + "</span> : <span class='productVal'>" + row.get(0).get(val).toString() + "</span></div>");
                        }
                    }
                    html.append("</div>");
                    html.append("</h4></div>");
                           //======>PRICE
                    if (userId.equals("")) {//اگر کاربر لاگین نکرده باشد و آی دی اش در سشن نباشد
                        price = row.get(0).get(_price2).toString();//قیمت اصلی را به کاربر نمایش می دهد
                        discountPrice = "".equals(row.get(0).get(_discount).toString()) ? "" : row.get(0).get(_discount).toString();//اگر تخفیف برایش در نظر گرفته شود تخفیف هم نمایش داده می شود.
                    } else {//اگر کاربر لاگین کرده باشد
                        List<Map<String, Object>> userRow = jjDatabase.separateRow(db.Select(Access_Group_User.tableName, Access_Group_User._user_id + " = " + userId));//گروه کاربر را واکشی می کند
                        if (!userRow.isEmpty()) {//اگر کاربر عضو گروهی باشد که قیمت ویژه برای آن ست شده است قیمت مربوط به آن گروه نمایش داده می شود
                            String userGroup = userRow.get(0).get(Access_Group_User._group_id).toString();
//                    System.out.println("userGroup " + userGroup);
                            if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup1).toString())) {
                                price = "".equals(row.get(0).get(_groupPrice1).toString()) ? row.get(0).get(_price2).toString() : row.get(0).get(_groupPrice1).toString();
                            } else if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup2).toString())) {
                                price = "".equals(row.get(0).get(_groupPrice2).toString()) ? row.get(0).get(_price2).toString() : row.get(0).get(_groupPrice2).toString();
                            } else if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup3).toString())) {
                                price = "".equals(row.get(0).get(_groupPrice3).toString()) ? row.get(0).get(_price2).toString() : row.get(0).get(_groupPrice3).toString();
                            } else if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup4).toString())) {
                                price = "".equals(row.get(0).get(_groupPrice4).toString()) ? row.get(0).get(_price2).toString() : row.get(0).get(_groupPrice4).toString();
                            } else if (userGroup.equalsIgnoreCase(row.get(0).get(_userGroup5).toString())) {
                                price = "".equals(row.get(0).get(_groupPrice5).toString()) ? row.get(0).get(_price2).toString() : row.get(0).get(_groupPrice5).toString();
                            } else {
                                price = row.get(0).get(_price2).toString();
                            }
                        } else {//اگر کاربر عادی باشد قیمت اصلی نمایش داده میشود
                            price = row.get(0).get(_price2).toString();
                            discountPrice = "".equals(row.get(0).get(_discount).toString()) ? "" : row.get(0).get(_discount).toString();
                        }
                    }
                    ServerLog.Print("PRICE : " + price);
                    ServerLog.Print("DISCOUNTPRICE : " + discountPrice);

                    if (discountPrice.equalsIgnoreCase("")) {//اگر کالا تخفیف نداشت یا کاربر عضو گروهی بود فقط قیمت اصلی نمایش داده می شود
                        html.append("<div class='productPrice'><span>" + price + "</span> <span>" + row.get(0).get(_currency) + "</span></div>");
                    } else {//اگر کالا تخفیف داشت  قیمت اصلی و  قیمت تخفیف و زمان باقی مانده تا اتمام تخفیف نمایش داده می شود

                        //=======> Time of Discount
                        //محاسبه زمان باقی مانده تا پایان تخفیف
                        jjCalendar_IR dateIR = new jjCalendar_IR();
//                System.out.println("DATE : " + dateIR.getDBFormat_8length());

                        int remainTime = Integer.parseInt(row.get(0).get(_discountDate).toString()) - dateIR.getDBFormat_8length();//تعداد روزهای باقی مانده
                        ServerLog.Print("remain day : " + remainTime);

                        if (remainTime > 0) {//اگر بیشتر از یک روز تا پایان تخفیف مانده باشد.
                            html.append("<div class='productPrePrice'><span style='text-decoration: line-through;' >" + price + "</span> <span style='text-decoration: line-through;'>" + row.get(0).get(_currency) + "</span></div>");
                            html.append("<div class='productDisCount'><span>" + discountPrice + "</span> <span>" + row.get(0).get(_currency) + "</span></div>");
                            html.append("<div class='productRemTime'><span>" + langSetting.get(0).get(Language._remainTime) + "</span> : <span>" + remainTime + "</span> <span>" + langSetting.get(0).get(Language._day) + "</span></div>");
                        } else if (remainTime == 0) {//اگر کمتر از یک روز تا پایان تخفیف مانده باشد بر حسب ساعت و دقیقه زمان باقی مانده را نمایش می دهد
                            int remainHours = 0, remainMinutes = 0;
                            String timeArr[] = row.get(0).get(_discountTime).toString().split(":");
//                    ServerLog.Print("currentHour : " + dateIR.getHours() + " & currentMinutes : " + dateIR.getMinutes());
                            remainMinutes = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (60 + Integer.parseInt(timeArr[1]) - dateIR.getMinutes()) : Integer.parseInt(timeArr[1]) - dateIR.getMinutes();
                            remainHours = Integer.parseInt(timeArr[1]) - dateIR.getMinutes() < 0 ? (Integer.parseInt(timeArr[0]) - dateIR.getHours() - 1) : Integer.parseInt(timeArr[0]) - dateIR.getHours();
                            if (remainHours >= 0) {//اگر هنوز ساعاتی تا پایان تخفیف مانده بود
                                html.append("<div class='productPrePrice'><span style='text-decoration: line-through;' >" + price + "</span> <span style='text-decoration: line-through;'>" + row.get(0).get(_currency) + "</span></div>");
                                html.append("<div class='productDisCount'><span>" + discountPrice + "</span> <span>" + row.get(0).get(_currency) + "</span></div>");
                                ServerLog.Print("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                                temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                                html.append("<div class='productRemTime'><span>" + langSetting.get(0).get(Language._remainTime) + "</span> : <span>" + remainHours + "</span> <span>" + langSetting.get(0).get(Language._hour) + "</span> <span>" + remainMinutes + "</span> <span>" + langSetting.get(0).get(Language._minute) + "</span></div>");
//                        temphtml.append("<span class='productTitlespan'><h3>" + "دقیقه"+ " : " + "ساعت" + " </h3></span>");

                            } else {//اگر ساعت منفی شد یعنی زمان تخفیف به اتمام رسیده است و دوباره کالا با حالت نرمال و بدون تخفیف نمایش داده می شود
                                html.append("<div class='productPrice'><span>" + price + "</span> <span>" + row.get(0).get(_currency) + "</span></div>");
                            }
//                            System.out.println("remainHours : " + remainHours + " & remainMinutes : " + remainMinutes);
//                            temphtml.append("<span class='productTitlespan'><h3>زمان باقی مانده : " + remainMinutes + " : " + remainHours + "</h3></span>");
                        } else {
                            html.append("<div class='productPrice'><span>" + price + "</span> <span>" + row.get(0).get(_currency) + "</span></div>");
                        }

                        //<======= Time of Discount
                    }
                    //<======PRICE
                    html.append("<div class='productExDetail'>");
                    
                    int quantity = new Integer(row.get(0).get(_quantity).toString());
                    if (quantity <= 0) {
                        html.append("<div class='productQtyDiv'>  <span style='color:red;'>" + langSetting.get(0).get(Language._notAvailable) + "</span></div>");//==> productQtyDivLn : productlQuantityDiv
                    } else {
                        html.append("<div class='productQtyDiv'>  <span>" + langSetting.get(0).get(Language._available) + "</span></div>");//==> productQtyDivLn : productlQuantityDiv
                    }
                    int disLikes = new Integer(row.get(0).get(_dislike).toString());
                    if (disLikes >= 0) {
                        html.append("<div class='productDLDiv' onclick='productDisLike(" + id + ");' ><span>" + disLikes + " " + langSetting.get(0).get(Language._disLike) + "</span></div>");
                    }
                    int likes = new Integer(row.get(0).get(_like).toString());
                    if (likes >= 0) {
                        html.append("<div class='productLDiv' onclick='productLike(" + id + ");' ><span>" + likes + " " + langSetting.get(0).get(Language._like) + "</span></div>");
                    }
                    int visit = new Integer(row.get(0).get(_visit).toString());
                    if (visit >= 0) {
                        html.append("<div class='productVDiv' ><span>" + visit + " " + langSetting.get(0).get(Language._visited) + "</span></div>");
                    }
                    html.append("</div>");
                    //                    String content = Content.ConvertToWiki(request, row.get(0).get(_content).toString().replace('"', '\''), db, isPost);
                    html.append("<div class='productContentDiv'>" + Content.ConvertToWiki(request, row.get(0).get(_content).toString().replace('"', '\''), db, isPost) + "</div>");//====== BY RASHIDI ======

//            html.append("<img src='iconImages/cart.png' onclick='addToShoppingCart(" + row.get(0).get(_id).toString() + ")'>");//====== BY RASHIDI ======
                    //<============ BY RASHIDI ========
//            html.append("<span class='moreDataleLn" + lang + "'>"
//                    + "<a onclick='swGetProducts(" + row.get(0).get(_category_id).toString() + ");'>" + " مطالب مرتبط" + "</a>"
//                    + "</span>");
                    html.append("</div>");
                    html.append("<div class='ProductdetailBtn'>");
                    html.append("<a class='coGruopproduct' onclick='addToShoppingCart(" + row.get(0).get(_id).toString() + ");'><span>" + langSetting.get(0).get(Language._addCart) + "</span></a>");
                    html.append("<a class='moreDetaile' href='Server?do=Product.getList&panel=sw&id=" + row.get(0).get(_category_id).toString() + "' onclick='swGetProducts(" + row.get(0).get(_category_id).toString() + ");return false;'><span>" + langSetting.get(0).get(Language._related) + "</span></a>");
                    html.append("</div></div>");

//            html.append("<div id='commentForm' name='commentForm'></div>");//====== BY RASHIDI ======
////            html.append("$(\"#commentForm\").load(\"formCms/comment.html\")");
//            String script = "$('#" + panel + "').html(\"" + html.toString() + "\");";
//            script += ("$('#commentForm').load('formCms/public_comment_fa.html', null, function () {$('#comment_refrenceId').val('tblName=" + tableName + "&id=" + id + "');});");//====== BY RASHIDI ======
//            script += Js.setVal("#comment_refId", "Product_" + id);
                    //1<--
                    //2-->
                    html2.append("$('#" + panel + "').html(\"" + html.toString() + "\");");
//                    script.append(Js.setHtml("#newContentDiv", row.get(0).get(_content).toString()));
//                    script.append(Js.show("#commentForm"));
//                    script.append(Js.setVal("#comment_refrenceId", "tblName=" + tableName + "&id=" + id));
                    //2<--
//            row.get(0).get(_content).toString()
//        script += Js.table("#sss", height, sort, "");
//            script += (Js.append("#commentForm", "<input type='text' id='comment_refId' name='comment_refId' value='Product_" + id + "'/>"));
                }

                //============ BY RASHIDI ========>   
                title = titlePanel.equals("") ? "" : Js.setHtml("#" + titlePanel, row.get(0).get(_name).toString());
                //is not by Ajax
                boolean senderIsMyJs = jjTools.getParameter(request, "jj").equals("1");
                if (!senderIsMyJs) {
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ : " + html.toString());
                    return html.toString();
                }
                //is not by Ajax
                //<============ BY RASHIDI ========
            }

            return html2.toString() + title;
        } catch (Exception ex) {
            return Server.ErrorHandler(ex);
        }
    }
//<============ BY RASHIDI ========
}
