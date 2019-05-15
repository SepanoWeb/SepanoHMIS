package cms.access;

import cms.tools.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import jj.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shiran1 ایجاد تغییرات در Return ها 1398/01/18
 */
public class Access_Group {

    public static String tableName = "access_group";
    public static String _id = "id";
    public static String _title = "group_title";
    public static String _creator = "group_creator";
    public static String _des = "group_des";
    public static String _chk = "group_c";
    public static int chkNumber = 500;// end of access_group table in database access_group_groupe_c110
    public static String lbl_insert = "ذخیره";
    public static String lbl_delete = "حذف";
    public static String lbl_edit = "ویرایش";
    public static String lbl_add_en = "افزودن زبان انگلیسی";
    public static String lbl_edit_en = "ویرایش بخش انگلیسی";
//    public static int rul_rfs = 33;
//    public static int rul_ins = 34;
//    public static int rul_edt = 35;
//    public static int rul_dlt = 36;

    public static int rul_rfs = 0;
    public static int rul_ins = 0;
    public static int rul_edt = 0;
    public static int rul_dlt = 0;
////    public static int rul_reserved = 325 --- 340;// RESERVED : 325 -- 340

    /**
     *
     * @param height is int height of table
     * @param sort is number of default sort column number
     * @param panel is container id
     */
    public static String refresh(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        String hasAccess = Access_User.getAccessDialog(request, db, rul_rfs);
        if (!hasAccess.equals("")) {
            Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
            return "";
        }
        StringBuffer html = new StringBuffer();
        String where = "";
        String creator = jjTools.getSessionAttribute(request, "#ID");
        if (jjNumber.isDigit(creator)) {
            where = _creator + "=" + creator;
        }
        List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, where));
        html.append(" <div class='card bd-primary mg-t-20'>"
                + "    <div class='card-header bg-primary tx-white'>جدول گروه های کاربری</div>"
                + "    <div class='card-body pd-sm-30'>"
                + "        <p class='mg-b-20 mg-sm-b-30'>"
                + "            <a  class='btn btn-success pd-sm-x-20 mg-sm-r-5' style='color: white;' onclick='cmsGroup.m_add_new();' > گروه جدید</a>"
                + "        </p>");
        html.append("<table class='table display responsive nowrap' id='refreshAccessGroup' dir='rtl'><thead>");
        html.append("<th width='5%'>کد</th>");
        html.append("<th width='90%'>عنوان</th>");
        html.append("<th width='5%'>عملیات</th>");
        html.append("</thead><tbody>");
        for (int i = 0; i < row.size(); i++) {
            html.append("<tr  onclick='cmsGroup.m_select(" + row.get(i).get(_id) + ");' class='mousePointer' >");
            html.append("<td class='tahoma10' style='text-align: center;'>" + (row.get(i).get(_id).toString()) + "</td>");
            html.append("<td class='tahoma10' style='text-align: right;'>" + (row.get(i).get(_title).toString()) + "</td>");
            html.append("<td style='text-align: center;color:red;font-size: 26px;'class='icon ion-ios-gear-outline'><a  style='cursor: pointer;height:30px' onclick='cmsGroup.m_select(" + row.get(i).get(_id) + ");' /></a></td>");
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
            panel = "swGroupTbl";
        }
        String html2 = "$('#" + panel + "').html(\"" + html.toString() + "\");\n";
        html2 += Js.table("#refreshAccessGroup", height, 0, Access_User.getAccessDialog(request, db, rul_ins).equals("") ? "10" : "", "لیست گروه ها");

        Server.outPrinter(request, response, html2);
        return "";
    }

    public static String add_new(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        StringBuffer html = new StringBuffer();
        boolean accIns = Access_User.hasAccess(request, db, rul_ins);
         if (accIns) {
                html.append(Js.setHtml("#Group_button", "<div class='col-lg-6'><input type='button' id='insert_Group_new'  value=\"" + lbl_insert + "\" class='btn btn-outline-success active btn-block mg-b-10'></div>"));
                html.append(Js.click("#insert_Group_new", Js.jjUser.insert()));
            } else {
                html.append(Js.setHtml("#Group_button", ""));
            }
//        if (accIns) {
//            html.append(Js.setHtml("#Group_button", "<input type=\"button\" id=\"insert_Group_new\" value=\"" + lbl_insert + "\" class=\"tahoma10\">"));
//            html.append(Js.buttonMouseClick("#insert_Group_new", Js.jjGroup.insert()));
//        }
        Server.outPrinter(request, response, html.toString());
        return "";

    }

    /**
     *
     * @param content_parent
     * @param content_content
     * @param content_title
     * @param content_lang
     * @param content_parent
     */
    public static String insert(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        String hasAccess = Access_User.getAccessDialog(request, db, rul_ins);
        if (!hasAccess.equals("")) {
            Server.outPrinter(request, response, Js.modal(hasAccess, "پیام سامانه"));
            return "";
        }
        Map<String, Object> map = new HashMap<String, Object>();

        map.put(_des, jjTools.getParameter(request, _des));
        String creator = jjTools.getSessionAttribute(request, "#ID");
        map.put(_creator, jjNumber.isDigit(creator) ? Integer.parseInt(creator) : 0);
        map.put(_title, jjTools.getParameter(request, _title));
        for (int i = 1; i < chkNumber; i++) {
            String thisRow = _chk + (i < 10 ? "0" + i : i);
            map.put(thisRow, jjTools.getSessionAttribute(request, "#NOACCESS").contains("$" + i + "$") ? 0
                    : Integer.parseInt(jjNumber.isDigit(jjTools.getParameter(request, thisRow)) ? jjTools.getParameter(request, thisRow) : "0"));
        }

        if (db.insert(tableName, map).getRowCount() == 0) {
            String errorMessage = "عملیات درج به درستی صورت نگرفت.";
            if (jjTools.getParameter(request, "myLang").equals("2")) {
                errorMessage = "Edit Fail;";
            }
            Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
            return "";

        }
        Server.outPrinter(request, response, Js.jjGroup.refresh());
        return "";

    }

    /**
     *
     * @param id
     * @param group_title
     * @param group_des
     */
    public static String edit(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        String hasAccess = Access_User.getAccessDialog(request, db, rul_edt);
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

        String creator = jjTools.getSessionAttribute(request, "#ID");
        if (jjNumber.isDigit(creator)) {
            if (db.Select(tableName, _id + "=" + id + " AND " + _creator + "=" + creator).getRowCount() == 0) {
                String errorMessage1 = "شما اجازه ویرایش این گروه را ندارید.";
                Server.outPrinter(request, response, Js.modal(errorMessage1, "پیام سامانه"));
                return "";
            }
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(_des, jjTools.getParameter(request, _des));
        map.put(_title, jjTools.getParameter(request, _title));
        for (int i = 1; i < chkNumber; i++) {
            String thisRow = _chk + (i < 10 ? "0" + i : i);
            map.put(thisRow, jjTools.getSessionAttribute(request, "#NOACCESS").contains("$" + i + "$") ? 0
                    : Integer.parseInt(jjNumber.isDigit(jjTools.getParameter(request, thisRow))
                            ? jjTools.getParameter(request, thisRow) : "0"));
        }
        ServerLog.Print(map);
        if (creator.equals("1") && id.equals("1")) {
            map.put(_chk + 15, 1);
            map.put(_chk + 16, 1);
            map.put(_chk + 17, 1);
            map.put(_chk + 18, 1);
            map.put(_chk + 33, 1);
            map.put(_chk + 34, 1);
            map.put(_chk + 35, 1);
            map.put(_chk + 36, 1);
        }
        if (creator.equals("1") && jjTools.getParameter(request, _des).toString().equals("$")) {
            map.put(_chk + 15, 1);
            map.put(_chk + 16, 1);
            map.put(_chk + 17, 1);
            map.put(_chk + 18, 1);
            map.put(_chk + 33, 1);
            map.put(_chk + 34, 1);
            map.put(_chk + 35, 1);
            map.put(_chk + 36, 1);
        }
        if (!db.update(tableName, map, _id + "=" + id)) {
            String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
            if (jjTools.isLangEn(request)) {
                errorMessage = "Edit Fail;";
            }
            Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
            return "";

        }
        Server.outPrinter(request, response, Js.jjGroup.refresh());
        return "";

    }

    /**
     *
     * @param id
     */
    public static String delete(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
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

        String creator = jjTools.getSessionAttribute(request, "#ID");
        if (jjNumber.isDigit(creator)) {
            if (db.Select(tableName, _id + "=" + id + " AND " + _creator + "=" + creator).getRowCount() == 0) {
                String errorMessage2 = "شما اجازه حذف این گروه را ندارید.";
                Server.outPrinter(request, response, Js.modal(errorMessage2, "پیام سامانه"));
                return "";
            }
        }

        if (!db.delete(tableName, _id + "=" + id)) {
            String errorMessage = "عملیات حذف به درستی صورت نگرفت";
            if (jjTools.isLangEn(request)) {
                errorMessage = "Delete Fail;";
            }
            Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
            return "";
        }
        db.delete(Access_Group_User.tableName, Access_Group_User._group_id + "=" + id);

        Server.outPrinter(request, response, Js.jjGroup.refresh());
        return "";
    }

    /**
     *
     * @param id
     */
    public static String select(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        String id = jjTools.getParameter(request, _id);
        String errorMessageId = jjValidation.isDigitMessageFa(id, "کد");
        if (!errorMessageId.equals("")) {
            if (jjTools.isLangEn(request)) {
                errorMessageId = jjValidation.isDigitMessageEn(id, "ID");
            }
            Server.outPrinter(request, response, Js.modal(errorMessageId, "پیام سامانه"));
            return "";

        }
        List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName, _id + "=" + id));
        if (row.size() == 0) {
            String errorMessage = "رکوردی با این کد وجود ندارد.";
            if (jjTools.isLangEn(request)) {
                errorMessage = "Select Fail;";
            }
            Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
            return "";
        }
        StringBuffer html = new StringBuffer();
        StringBuffer html2 = new StringBuffer();
        StringBuilder script2 = new StringBuilder();
        html.append(Js.setVal("#" + _title, row.get(0).get(_title)));
        html.append(Js.setVal("#" + _des, row.get(0).get(_des)));
        for (int i = 1; i < chkNumber; i++) {
            String thisRow = _chk + (i < 10 ? "0" + i : i);
            html.append(Js.setVal("#C" + (i < 10 ? "0" + i : i), row.get(0).get(thisRow)));
        }

        boolean accDel = Access_User.hasAccess(request, db, rul_dlt);
        boolean accEdt = Access_User.hasAccess(request, db, rul_edt);
        String htmlBottons = "";
        boolean accEdit = Access_User.hasAccess(request, db, rul_edt);
        if (accEdit) {
            htmlBottons += "<div class='col-lg'><button title='" + lbl_edit + "' class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjGroup.edit() + "' id='edit_Group'>" + lbl_edit + "</button></div>";
//               
        }
        boolean accDelete = Access_User.hasAccess(request, db, rul_dlt);
        if (accDelete) {
            htmlBottons += "<div class='col-lg'><button title='" + lbl_delete + "' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjGroup.delete(id) + "' id='delete_Group'>" + lbl_delete + "</button></div>";
        }
        script2.append(Js.setHtml("#Group_button", htmlBottons));
//        if (accEdt) {
//            html2.append("<div class=\"row\"><div class=\"col-lg-6\"><input type=\"button\" id=\"edit_Group\" value=\"" + lbl_edit + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"></div>");
//            html.append(Js.buttonMouseClick("#edit_Group", Js.jjGroup.edit()));
//        }
//        if (accDel) {
//            html2.append("<div class=\"col-lg-6\"><input type=\"button\" id=\"delete_Group\" value=\"" + lbl_delete + "\" class=\"tahoma10 btn btn-success btn-block mg-b-10 ui-button ui-corner-all ui-widget\"  /></div>");
//            html.append(Js.buttonMouseClick("#delete_Group", Js.jjGroup.delete(id)));
//        }
        Server.outPrinter(request, response, script2 + html.toString());
        return "";

    }

    public static String getMenu(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        StringBuffer html = new StringBuffer();
        List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectAll(tableName));
        html.append("&nbsp;&nbsp;<ul>");
        for (int i = 0; i < row.size(); i++) {
            html.append("<li onclick='swNewsCategory(" + row.get(i).get(_id) + ");'>&nbsp;" + row.get(i).get(_title) + " </li>");
        }
        html.append("</ul>");
        Server.outPrinter(request, response, html.toString());
        return "";

    }

    /**
     * called from loadForm of product.js دسته بندی کاربران را در یک تگ سلکت
     * میسازد و برمیگرداند.
     *
     * @param request
     * @param db
     * @param isPost
     * @return
     * @throws Exception
     */
    public static String getOptions(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        StringBuffer html = new StringBuffer();
        String panel = jjTools.getParameter(request, "panel");//====== BY RASHIDI ======
//        if (panel.equals("")) {
//                panel = "news_category_id_select";
//            }
        List<Map<String, Object>> row = jjDatabase.separateRow(db.SelectAll(tableName));
        for (int i = 0; i < row.size(); i++) {
            html.append("<option value='" + row.get(i).get(_id) + "'>" + row.get(i).get(_title).toString() + "</option>");
        }

        Server.outPrinter(request, response, Js.setHtml("#" + panel, html.toString()));
        return "";
    }

    public static String getCheckboxList(HttpServletRequest request, HttpServletResponse response, jjDatabaseWeb db, boolean isPost) throws Exception {
        StringBuffer html = new StringBuffer();
        List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(tableName));

        String accessGroup = "";
        String groups = "";
        String creator = jjTools.getSessionAttribute(request, "#ID");
        if (jjNumber.isDigit(creator)) {
            List<Map<String, Object>> row2 = jjDatabase.separateRow(db.Select(tableName, _creator + "=" + creator));
            for (int i = 0; i < row2.size(); i++) {
                accessGroup += "$" + row2.get(i).get(_id) + "$";
            }
            List<Map<String, Object>> gr = jjDatabase.separateRow(db.Select(Access_Group_User.tableName, Access_Group_User._user_id + "=" + creator));
            for (int i = 0; i < gr.size(); i++) {
                groups += "$" + gr.get(i).get(Access_Group_User._group_id) + "$";

            }
        }
        String panel = jjTools.getParameter(request, "panel");
        panel = panel.equals("") ? "group_checkbox_list" : panel;

        String userId = jjTools.getParameter(request, "user_id");
        if (row.size() > 0) {
            html.append("<div align='center'><table border='1' style='width: 100%;height: 100' cellpadding='1'><tr>");
            html.append("<td height='100' align='center' width='100%' bgcolor='white' valign='top'>");
            html.append("<div style='padding: 0px;background-color: white;color: black ;border:0px solid black;width:100%;height:100px;overflow:auto;text-align: right'>");
            String selected = "";
            for (int i = 0; i < row.size(); i++) {
                String disable = "disabled=\"disabled\"";
                if (accessGroup.contains("$" + row.get(i).get(_id) + "$")) {
                    disable = "";
                }
                if (jjNumber.isDigit(userId)) {
//                    int rowCount = db.Select(Access_Group_User.tableName, Access_Group_User._user_id + "=" + userId
//                            + " AND " + Access_Group_User._group_id + "=" + row.get(i).get(_id)).getRowCount();//+ " AND " + Access_Group_User._group_id + "<>2001"
//                    selected = groups.contains("$"+row.get(i).get(_id).toString()+"$") ? "checked" : "";
                    int rowCount = db.Select(Access_Group_User.tableName, Access_Group_User._user_id + "=" + userId
                            + " AND " + Access_Group_User._group_id + "=" + row.get(i).get(_id)).getRowCount();//+ " AND " + Access_Group_User._group_id + "<>2001"
                    selected = rowCount > 0 ? "checked" : "";
                }
                html.append("<li style='width: 250px;font-size: 10pt;cursor: pointer;text-align: right;padding: 0px;'>");
                html.append("<input  type='checkbox' style='width: 30px;' "
                        + "id='chk" + row.get(i).get(_id) + "' name='chk" + row.get(i).get(_id) + "' " + selected + " " + disable + "/>");
                html.append(row.get(i).get(_title));
                html.append("</li>");
            }
            html.append("</div></td></table></div>");
        }
        Server.outPrinter(request, response, Js.setHtml("#" + panel, html.toString()));
        return "";

    }

//============ BY RASHIDI ========>
//این قسمت برای افزودن ستون به جدول دسترسی ها نوشته شده
//    public static void main(String[] args) throws SQLException {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sepanoshop?characterEncoding=UTF-8", "root", "m123456");
//            Statement stmt = con.createStatement();
//            String sql = "";
//            for (int i = 121; i <= 500; i++) {//واسه اینکه ستون اضافه کنم به جدول دسترسی ها
//                String strIn = "group_c" + i;
//                String strPre = "group_c" + (i - 1);
//                sql = " ALTER TABLE `db_sepanoshop`.`access_group` ADD COLUMN `" + strIn + "` TINYINT(3) UNSIGNED NOT NULL DEFAULT 0 AFTER `" + strPre + "`;";//تعدادی ستون اضافه شود
////                sql = "UPDATE `db_sepanoshop`.`access_group` SET " + strIn + " = 1 WHERE id = 1";//مقدار دسترسی ها ست شود
//                ServerLog.Print("^^^^ SQL " + i + " : " + sql);
////            boolean execute = stmt.execute(sql);
////            boolean flag = otherStatement(sql);
////            ServerLog.Print("RESULT : " + execute);
//
//                stmt.executeUpdate(sql);
//
//            }
//            stmt.close();
//            con.close();
//        } catch (SQLException ex) {
//            System.err.println("SQLException: " + ex.getMessage());
//        }
//    }
//<============ BY RASHIDI ========
}
