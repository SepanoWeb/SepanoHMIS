/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMIS;

import cms.access.Access_User;
import cms.tools.Js;
import cms.tools.Server;
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
public class Strategic {

    public static String tableName = "hmis_strategic";
    public static String _id = "id";
    public static String _introduction = "strategic_introduction";//مقدمه
    public static String _prophecy = "strategic_prophecy";//رسالت
    public static String _prospect = "strategic_prospect";//چشم انداز /دور نما
    public static String _IFEinternal = "strategic_IFEInternal";//ارزیابی داخلی 
    public static String _EFEOuter = "strategic_EFEOuter";//ارزیابی خارجی
    public static String _IFEandEFE = "strategic_IFEandEFE";//جدول ارزیابی داخلی وخارجی
    public static String _beneficiaries = "strategic_beneficiaries";//ذی نفعان
    public static String _matrixSWOT = "strategic_matrixSWOT";//ماتریس 
    public static String _matrixQSPM = "strategic_matrixQSPM";//ماتریس 
    public static String _strategicSWOT = "strategic_strategicSWOT";//استراتژیک swot 
    public static String _IssuesStrategic = "strategic_issuesStrategic";//مسائل استراتژیک 
    public static String _targetG_1 = "strategic_targetG_1";//هدف کلی 
    public static String _targetGO1_1 = "strategic_targetGO1_1";//هدف اختصاصی
    public static String _targetGO2_1 = "strategic_targetGO2_1";// هدف اختصاصی 
    public static String _targetG_2 = "strategic_targetG_2";//هدف کلی
    public static String _targetGO1_2 = "strategic_targetGO1_2";// هدف اختصاصی
    public static String _targetGO2_2 = "strategic_targetGO2_2";// هدف اختصاصی
    public static String _targetG_3 = "strategic_targetG_3";//هدف کلی
    public static String _targetGO1_3 = "strategic_targetGO1_3";//هدف هدف اختصاصی
    public static String _targetGO2_3 = "strategic_targetGO2_3";//هدف اختصاصی o2
    public static String _targetG_4 = "strategic_targetG_4";//هدف کلی
    public static String _targetGO1_4 = "strategic_targetGO1_4";//هدف هدف اختصاصی
    public static String _targetGO2_4 = "strategic_targetGO2_4";//هدف اختصاصی o2
    public static String _targetG_5 = "strategic_targetG_5";//هدف کلی
    public static String _targetGO1_5 = "strategic_targetGO1_5";//هدف هدف اختصاصی
    public static String _targetGO2_5 = "strategic_targetGO2_5";//هدف اختصاصی o2
    public static String _prioritized = "strategic_prioritized";//اولویت بندی شده

    public static int rul_rfsAll = 21;
    public static int rul_rfs = 22;
    public static int rul_ins = 23;
    public static int rul_edt = 24;
    public static int rul_dlt = 25;

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
//               boolean accRefAll = Access_User.hasAccess(request, db, rul_rfsAll);
//               boolean accRef= Access_User.hasAccess(request, db, rul_rfs);
            StringBuilder html = new StringBuilder();

            DefaultTableModel dtm = db.Select(tableName);
            List<Map<String, Object>> row = jjDatabase.separateRow(dtm);

            html.append("        <div class=\"card-header bg-primary tx-white\">لیست استراتژیک ها</div>\n");
            html.append(" <div class=\"card-body pd-sm-30\">\n"
                    + "                                        <p class=\"mg-b-20 mg-sm-b-30\">\n"
                    + "                                            <a style='color:#fff' class=\"btn btn-success pd-sm-x-20 mg-sm-r-5 tx-white\" onclick=\"hmisStrategic.m_add_new();\" >استراتژی جدید</a>\n"
                    + "                                        </p>\n"
                    + "                                    </div>");
            html.append("        <div class=\"table-wrapper\">\n");
            html.append("<table id='refreshStrategic' class='table display responsive' class='tahoma10' style='direction: rtl;'><thead>");
            html.append("<th class='r' width='5%'>کد</th>");
            html.append("<th class='r' width='20%'>عملیات</th>");
            html.append("</thead><tbody>");
            for (int i = 0; i < row.size(); i++) {
                html.append("<tr  class='mousePointer'>");
                html.append("<td class='c'>" + row.get(i).get(_id) + "</td>");
                html.append("<td class='r'><i class='icon ion-ios-gear-outline'  onclick='hmisStrategic.m_select(" + row.get(i).get(_id) + ")'></i></td>");
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
                panel = "swStrategicTbl";
            }
            String html2 = Js.setHtml("#" + panel, html.toString());

            html2 += Js.table("#refreshStrategic", "300", 0, "", "کمیته ها");

            Server.outPrinter(request, response, html2);
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
            jjTools.ShowAllParameter(request);
            StringBuilder html = new StringBuilder();
            jjCalendar_IR ir = new jjCalendar_IR();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(_EFEOuter, jjTools.getParameter(request, _EFEOuter));
            map.put(_IFEandEFE, jjTools.getParameter(request, _IFEandEFE));
            map.put(_IFEinternal, jjTools.getParameter(request, _IFEinternal));
            map.put(_strategicSWOT, jjTools.getParameter(request, _strategicSWOT));
            map.put(_targetG_1, jjTools.getParameter(request, _targetG_1));
            map.put(_targetG_2, jjTools.getParameter(request, _targetG_2));
            map.put(_targetG_3, jjTools.getParameter(request, _targetG_3));
            map.put(_targetG_4, jjTools.getParameter(request, _targetG_4));
            map.put(_targetG_5, jjTools.getParameter(request, _targetG_5));
            map.put(_targetGO1_1, jjTools.getParameter(request, _targetGO1_1));
            map.put(_targetGO2_1, jjTools.getParameter(request, _targetGO2_1));
            map.put(_targetGO1_2, jjTools.getParameter(request, _targetGO1_2));
            map.put(_targetGO2_2, jjTools.getParameter(request, _targetGO2_2));
            map.put(_targetGO1_3, jjTools.getParameter(request, _targetGO1_3));
            map.put(_targetGO2_3, jjTools.getParameter(request, _targetGO2_3));
            map.put(_targetGO1_4, jjTools.getParameter(request, _targetGO1_4));
            map.put(_targetGO2_4, jjTools.getParameter(request, _targetGO2_4));
            map.put(_targetGO1_5, jjTools.getParameter(request, _targetGO1_5));
            map.put(_targetGO2_5, jjTools.getParameter(request, _targetGO2_5));
            map.put(_introduction, jjTools.getParameter(request, _introduction));
            map.put(_IssuesStrategic, jjTools.getParameter(request, _IssuesStrategic));
            map.put(_matrixQSPM, jjTools.getParameter(request, _matrixQSPM));
            map.put(_matrixSWOT, jjTools.getParameter(request, _matrixSWOT));
            map.put(_prophecy, jjTools.getParameter(request, _prophecy));
            map.put(_prospect, jjTools.getParameter(request, _prospect));
            map.put(_prioritized, jjTools.getParameter(request, _prioritized));
            map.put(_beneficiaries, jjTools.getParameter(request, "strategic_beneficiaries"));

            DefaultTableModel dtm = db.insert(tableName, map);
            if (dtm.getRowCount() == 0) {

                String errorMessage = "عملیات درج به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }

            Server.outPrinter(request, response, Js.jjStrategic.refresh());
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
                html.append(Js.setHtml("#Strategic_button", "<button  id=\"insert_Strategic_new\"  class=\"btn btn-outline-success  btn-block mg-t-20\" onclick='" + Js.jjStrategic.insert() + "'>" + lbl_insert + "</button>"));
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
            String id = jjTools.getParameter(request, _id);

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
            html.append(Js.setVal("#" + tableName + "_" + _id, row.get(0).get(_id)));
            html.append(Js.setHtml("#beneficiaries", row.get(0).get(_beneficiaries).toString()));
            html.append(Js.setHtml("#tableIFE", row.get(0).get(_IFEinternal).toString()));
            html.append(Js.setHtml("#tableEFE", row.get(0).get(_EFEOuter).toString()));
            html.append(Js.setHtml("#IFEandEFE", row.get(0).get(_IFEandEFE).toString()));

            html.append(Js.setHtml("#SWOTMatrixTable", row.get(0).get(_matrixSWOT).toString()));
            html.append(Js.setHtml("#StartegiesTableOnSWOT", row.get(0).get(_strategicSWOT)));
            html.append(Js.setHtml("#tableQSPM", row.get(0).get(_matrixQSPM).toString()));
            html.append(Js.setHtml("#tablePrioritized", row.get(0).get(_prioritized).toString()));
            html.append(Js.setVal("#" + _prophecy, row.get(0).get(_prophecy)));
            html.append(Js.setVal("#" + _prospect, row.get(0).get(_prospect)));
            html.append(Js.setVal("#" + _IssuesStrategic, row.get(0).get(_IssuesStrategic)));
            html.append(Js.setVal("#" + _introduction, row.get(0).get(_introduction)));
//            for (int i = 0; i <= 5; i++) {
//                html.append(Js.setVal("#strategic_targetG_" + i , row.get(0).get("strategic_targetG_" + i)));
//                html.append(Js.setVal("#strategic_targetGO1_" + i , row.get(0).get("#strategic_targetGO1_" + i )));
//                html.append(Js.setVal("#strategic_targetGO2_" + i , row.get(0).get("#strategic_targetGO2_" + i)));
//            }

            html.append(Js.setVal("#" + _targetGO2_1, row.get(0).get(_targetGO2_1)));
            html.append(Js.setVal("#" + _targetG_2, row.get(0).get(_targetG_2)));
            html.append(Js.setVal("#" + _targetGO1_2, row.get(0).get(_targetGO1_2)));
            html.append(Js.setVal("#" + _targetGO2_2, row.get(0).get(_targetGO2_2)));
            html.append(Js.setVal("#" + _targetG_3, row.get(0).get(_targetG_3)));
            html.append(Js.setVal("#" + _targetGO1_3, row.get(0).get(_targetGO1_3)));
            html.append(Js.setVal("#" + _targetGO2_3, row.get(0).get(_targetGO2_3)));
            html.append(Js.setVal("#" + _targetG_4, row.get(0).get(_targetG_4)));
            html.append(Js.setVal("#" + _targetGO1_4, row.get(0).get(_targetGO1_4)));
            html.append(Js.setVal("#" + _targetGO2_4, row.get(0).get(_targetGO2_4)));
            html.append(Js.setVal("#" + _targetG_5, row.get(0).get(_targetG_5)));
            html.append(Js.setVal("#" + _targetGO1_5, row.get(0).get(_targetGO1_5)));
            html.append(Js.setVal("#" + _targetGO2_5, row.get(0).get(_targetGO2_5)));

            boolean accEdt = Access_User.hasAccess(request, db, rul_edt);//
            boolean accDel = Access_User.hasAccess(request, db, rul_dlt);//
            html2.append("<div class='row'>");
            if (accEdt) {
                html2.append("<div class=\"mg-t-20  col-lg\">");
                html2.append("<button  id='edit_Strategic'  class='btn btn-outline-warning btn-block mg-b-10' onclick='" + Js.jjStrategic.edit() + "'>" + lbl_edit + "</button>");
                html2.append("</div>");
            }
            if (accDel) {
                html2.append("<div class=\"mg-t-20  col-lg\">");
                html2.append("<button id='delete_Strategic' class='btn btn-outline-danger btn-block mg-b-10' onclick='" + Js.jjStrategic.delete(id) + "' >" + lbl_delete + " </button>");
                html2.append("</div>");
            }

            html2.append("</div>");
            String script = Js.setHtml("#Strategic_button", html2);

            script += html.toString();
            script += "        $('div#pointer').css({'transform': 'translate(' + $('#tableIFE td .sumFinalVal').val() * 50 + 'px' + ',' + $('#tableEFE td .sumFinalVal').val() * -57 + 'px' + ')'});\n";
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
            System.out.println("id=" + id);
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
            map.put(_EFEOuter, jjTools.getParameter(request, _EFEOuter));
            map.put(_IFEandEFE, jjTools.getParameter(request, _IFEandEFE));
            map.put(_IFEinternal, jjTools.getParameter(request, _IFEinternal));
            map.put(_strategicSWOT, jjTools.getParameter(request, _strategicSWOT));
            map.put(_targetG_1, jjTools.getParameter(request, _targetG_1));
            map.put(_targetG_2, jjTools.getParameter(request, _targetG_2));
            map.put(_targetG_3, jjTools.getParameter(request, _targetG_3));
            map.put(_targetG_4, jjTools.getParameter(request, _targetG_4));
            map.put(_targetG_5, jjTools.getParameter(request, _targetG_5));
            map.put(_targetGO1_1, jjTools.getParameter(request, _targetGO1_1));
            map.put(_targetGO2_1, jjTools.getParameter(request, _targetGO2_1));
            map.put(_targetGO1_2, jjTools.getParameter(request, _targetGO1_2));
            map.put(_targetGO2_2, jjTools.getParameter(request, _targetGO2_2));
            map.put(_targetGO1_3, jjTools.getParameter(request, _targetGO1_3));
            map.put(_targetGO2_3, jjTools.getParameter(request, _targetGO2_3));
            map.put(_targetGO1_4, jjTools.getParameter(request, _targetGO1_4));
            map.put(_targetGO2_4, jjTools.getParameter(request, _targetGO2_4));
            map.put(_targetGO1_5, jjTools.getParameter(request, _targetGO1_5));
            map.put(_targetGO2_5, jjTools.getParameter(request, _targetGO2_5));
            map.put(_introduction, jjTools.getParameter(request, _introduction));
            map.put(_IssuesStrategic, jjTools.getParameter(request, _IssuesStrategic));
            map.put(_matrixQSPM, jjTools.getParameter(request, _matrixQSPM));
            map.put(_matrixSWOT, jjTools.getParameter(request, _matrixSWOT));
            map.put(_prophecy, jjTools.getParameter(request, _prophecy));
            map.put(_prospect, jjTools.getParameter(request, _prospect));
            map.put(_beneficiaries, jjTools.getParameter(request, _beneficiaries));
            map.put(_prioritized, jjTools.getParameter(request, _prioritized));
            if (!db.update(tableName, map, _id + "=" + id)) {
                String errorMessage = "عملیات ویرایش به درستی صورت نگرفت.";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Edit Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            Server.outPrinter(request, response, Js.jjStrategic.refresh());
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
            System.out.println("id=" + id);

            if (!db.delete(tableName, _id + "=" + id)) {
                String errorMessage = "عملیات حذف به درستی صورت نگرفت";
                if (jjTools.isLangEn(request)) {
                    errorMessage = "Delete Fail;";
                }
                Server.outPrinter(request, response, Js.modal(errorMessage, "پیام سامانه"));
                return "";
            }
            Server.outPrinter(request, response, Js.jjStrategic.refresh());
            return "";
        } catch (Exception ex) {
            Server.outPrinter(request, response, Server.ErrorHandler(ex));
            return "";
        }
    }

}
