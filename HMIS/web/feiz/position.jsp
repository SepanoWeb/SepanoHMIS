<%--
    Document   : Position
    Created on : Jun 15, 2019, 8:54:38 AM
    Author     : shiran
--%>

<%@page import="org.jsoup.select.Elements"%>
<%@page import="cms.tools.Server"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="cms.access.Access_User"%>
<%@page import="HMIS.Positions"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jj.jjDatabaseWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>

        <title>حوادث وبلایا</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./Manager/font-awesome.css" rel="stylesheet">
        <link href="./Manager/ionicons.css" rel="stylesheet">
        <link href="./Manager/perfect-scrollbar.css" rel="stylesheet">
        <!-- MedYar مدیار CSS -->
        <link href="../Manager/css/newTree.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!--<link rel="stylesheet" href="./Manager/shamcey.css">-->
        <link href="./Manager/css/HMIS.css" rel="stylesheet" type="text/css"/>

        <script src="js/jquery/jquery-1.10.2_1.js" type="text/javascript"></script>

        <script src="./js/jquery/ui/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>
        <script src="./Manager/js/jj2.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            Document doc;

            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            String html = "<div id='wrapper'><div id='container'><div class='sh-mainpanel'><div class='sh-breadcrumb'><nav class='breadcrumb'><div class='col-lg-12' style='direction: rtl;'> <h2> عنوان پیام:</h2> <input id='warningInput' class='form-control' placeholder='محل وقوع حادثه و پیام هشدار را بنویسید' type='text'></div>"
                    + "</nav></div> <h1></h1><ol id='organizat' class='organizational-chart'><li id='li0'></li></ol></div></div></div>";
            doc = Jsoup.parse(html);
            System.out.println(doc);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            jjDatabaseWeb db = (jjDatabaseWeb) request.getAttribute("db");
            List<Map<String, Object>> row = jjDatabaseWeb.separateRow(db.Select(Positions.tableName, "*", Positions._id, Positions._parent));
            List<Map<String, Object>> rowUser = jjDatabaseWeb.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + row.get(0).get(Positions._user_id)));
            for (int i = 0; i < row.size(); i++) {
                String parentID = row.get(i).get(Positions._parent).toString();
                String id = row.get(i).get(Positions._id).toString();

                if (row.get(i).get(Positions._parent).equals("0")) {
                    doc.select("#li0").append("<div  style='background-color: #7e848f;'><h1>" + row.get(i).get(Positions._title) + "</h1></div><ol id='ol" + id + "'></ol>");
                } else {
                    doc.select("#ol" + parentID).append("<li><div style='background-color:green ;'><h1>" + row.get(i).get(Positions._title) + "</h1></div><ol class='a' id='ol" + id + "'></ol></li>");
                   
              
                    ;
//                    }
                }
                    
            }
                 Elements ol= doc.select("ol:empty").remove();
                     
                   
            
            System.out.println(doc);


        %>
        <%= doc.getElementsByTag("body").toString()%>
    <link href='./Manager/css/newTree.css' rel='stylesheet' type='text/css'/>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <script src="./js/jquery/jquery-migrate-1.2.0.js" type="text/javascript"></script>
</body>
</html>

