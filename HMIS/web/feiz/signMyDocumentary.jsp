<%-- 
    Document   : SignMyDocumentary
    Created on : May 7, 2019, 8:42:26 AM
    Author     : shiran
--%>


<%@page import="jj.jjDatabase"%>
<%@page import="cms.access.Access_User"%>
<%@page import="cms.tools.Server"%>
<%@page import="cms.tools.Js"%>
<%@page import="cms.tools.UploadServlet"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="HMIS.CreateDocumentary"%>
<%@page import="cms.tools.jjTools"%>
<%@page import="jj.jjDatabaseWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>مستندات من</title>

    <link href="./Manager/font-awesome.css" rel="stylesheet">
    <link href="./Manager/ionicons.css" rel="stylesheet">
    <link href="./Manager/perfect-scrollbar.css" rel="stylesheet">
    <!-- MedYar مدیار CSS -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="./Manager/shamcey.css">
    <link href="./Manager/css/HMIS.css" rel="stylesheet" type="text/css"/>

    <script src="js/jquery/jquery-1.10.2_1.js" type="text/javascript"></script>
    <script src="js/jquery/jquery-migrate-1.2.0.js" type="text/javascript"></script>
    <script src="./js/jquery/ui/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>
    <script src="./Manager/js/jj2.js" type="text/javascript"></script>

</head>
<title>مستندات من</title>

<body>
    <% jjDatabaseWeb db = (jjDatabaseWeb) request.getAttribute("db");
        String documentaryID = jjTools.getParameter(request, CreateDocumentary._id);
        jjTools.getSeassionUserId(request);
        List<Map<String, Object>> DocumentaryRow = jjDatabaseWeb.separateRow(db.Select(CreateDocumentary.tableName, CreateDocumentary._id + "='" + documentaryID + "'"));


    %>;

    <h1>مستندات من</h1>
    <div class="card bd-primary mg-t-20">
        <div class="card-header bg-primary tx-white">خلاصه اطلاع رسانی سازمانی </div>
        <div class="card-body pd-sm-30">

            <div class="row">
                <input type="hidden" id="createDocumentary_id" name="id" />
                <div class="col-lg">
                    عنوان :
                    <div class="form-control">
                        <%= DocumentaryRow.get(0).get(CreateDocumentary._title)%>
                    </div>
                </div>
                <div class="col-lg">
                    تاریخ :
                    <div class="form-control" >
                        <%= DocumentaryRow.get(0).get(CreateDocumentary._date)%>
                    </div>
                </div>
                <div class="col-lg">
                    دسته  :
                    <div class="form-control" >
                        <%= DocumentaryRow.get(0).get(CreateDocumentary._category)%>
                    </div>
                </div>
            </div><!-- row -->
            <div class="row">
                <div class="col-lg">
                    خلاصه مطلب را وارد کنید


                    <textarea class="form-control" disabled="disabled">
                        <%= DocumentaryRow.get(0).get(CreateDocumentary._summary)%>
                    </textarea> 
                </div> 
            </div> 

        </div><!-- card-body -->
    </div><!-- card -->
    <div class="card bd-primary mg-t-20">
        <div class="card-header bg-primary tx-white">شرح کامل</div>
        <div class="card-body pd-sm-30">
            <p class="mg-b-20 mg-sm-b-30">پیوست فایل</p>
            <div class="row" style="">

                <!--                        <div class="col-lg">
                                            عکس فایل 1
                
                                            <img style="width: 50%;height: 50%" src="upload/<%=DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile1)%>">
                
                                        </div>-->

                <div class="col-lg">
                    <%if (!DocumentaryRow.get(0).get("createDocumentary_attachmentfile1").equals("")) {
                            List<Map<String, Object>> TitleRow1 = jjDatabaseWeb.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile1) + "'"));
                            TitleRow1.get(0).get(UploadServlet._title);
                    %>

                    <div>
                        عکس فایل 1
                    </div>
                    <% String typefile = DocumentaryRow.get(0).get("createDocumentary_attachmentfile1").toString();
                        String extension = typefile.substring(typefile.lastIndexOf(".") + 1, typefile.length());
                        if ((extension.toLowerCase().equals("jpg")
                                || extension.toLowerCase().equals("png")
                                || extension.toLowerCase().equals("gif")
                                || extension.toLowerCase().equals("svg"))) {
                    %>
                    <img style="width: 50%;height: 50%" src="upload/<%=DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile1)%>">

                    <%
                    } else if (extension.toLowerCase().equals("doc")
                            || extension.toLowerCase().equals("docx")
                            || extension.toLowerCase().equals("pdf")
                            || extension.toLowerCase().equals("tiff")
                            || extension.toLowerCase().equals("xls")
                            || extension.toLowerCase().equals("xlsx")) {
                    %>

                    <img style="width: 50%;height: 50%"
                         src="imgfeyz/word.png">

                    <%
                        }
                    %>
                    <div>
                        فایل1
                    </div>
                    <div class="form-control" >
                        <%= DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile1)%> 
                    </div>
                    عنوان فایل1
                    <div class="form-control" >
                        <%= TitleRow1.get(0).get(UploadServlet._title)%>
                    </div>
                    <a  style=""
                        href="upload/<%=DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile1)%>" >
                        دانلود  

                    </a>

                    <%

                        }
                    %>



                    <%
                    %>

                </div>






                <br/>



                <div class="col-lg">
                    <%if (!DocumentaryRow.get(0).get("createDocumentary_attachmentfile2").equals("")) {
                            List<Map<String, Object>> TitleRow2 = jjDatabaseWeb.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile2) + "'"));
                            TitleRow2.get(0).get(UploadServlet._title);
                    %>

                    <div>
                        عکس فایل 2
                    </div>
                    <% String typefile = DocumentaryRow.get(0).get("createDocumentary_attachmentfile2").toString();
                        String extension = typefile.substring(typefile.lastIndexOf(".") + 1, typefile.length());
                        if ((extension.toLowerCase().equals("jpg")
                                || extension.toLowerCase().equals("png")
                                || extension.toLowerCase().equals("gif")
                                || extension.toLowerCase().equals("svg"))) {
                    %>
                    <img style="width: 50%;height: 50%" src="upload/<%=DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile2)%>">

                    <%
                    } else if (extension.toLowerCase().equals("doc")
                            || extension.toLowerCase().equals("docx")
                            || extension.toLowerCase().equals("pdf")
                            || extension.toLowerCase().equals("tiff")
                            || extension.toLowerCase().equals("xls")
                            || extension.toLowerCase().equals("xlsx")) {
                    %>

                    <img style="width: 50%;height: 50%"
                         src="imgfeyz/word.png">

                    <%
                        }
                    %>
                    <div>
                        فایل2
                    </div>
                    <div class="form-control" >
                        <%= DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile2)%> 
                    </div>
                    عنوان فایل2
                    <div class="form-control" >
                        <%= TitleRow2.get(0).get(UploadServlet._title)%>
                    </div>
                    <a  style=""
                        href="upload/<%=DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile2)%>" >
                        دانلود  

                    </a>

                    <%

                        }
                    %>



                    <%
                    %>

                </div>



                <br/>

                <div class="col-lg">


                    <%     String typefile = DocumentaryRow.get(0).get("createDocumentary_attachmentfile3").toString();
                        if (!DocumentaryRow.get(0).get("createDocumentary_attachmentfile3").equals("")) {
                            List<Map<String, Object>> TitleRow3 = jjDatabaseWeb.separateRow(db.Select(UploadServlet.tableName, UploadServlet._file_name + "='" + DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile3) + "'"));
                            TitleRow3.get(0).get(UploadServlet._title);
                    %>


                    <div>
                        عکس فایل 3
                    </div>
                    <% String extension = typefile.substring(typefile.lastIndexOf(".") + 1, typefile.length());
                        if ((extension.toLowerCase().equals("jpg")
                                || extension.toLowerCase().equals("png")
                                || extension.toLowerCase().equals("gif")
                                || extension.toLowerCase().equals("svg"))) {
                    %>
                    <img style="width: 50%;height: 50%" src="upload/<%=DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile3)%>">



                    <%
                    } else if (extension.toLowerCase().equals("doc")
                            || extension.toLowerCase().equals("docx")
                            || extension.toLowerCase().equals("pdf")
                            || extension.toLowerCase().equals("tiff")
                            || extension.toLowerCase().equals("xls")
                            || extension.toLowerCase().equals("xlsx")) {
                    %>

                    <img style="width: 50%;height: 50%" src="imgfeyz/word.png">
                    <%
                        }
                    %>
                    <div>
                        فایل3
                    </div>
                    <div class="form-control" >
                        <%= DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile3)%> 
                    </div>
                    عنوان فایل3
                    <div class="form-control" >
                        <%= TitleRow3.get(0).get(UploadServlet._title)%>
                    </div>
                    <a  
                        href="upload/<%=DocumentaryRow.get(0).get(CreateDocumentary._attachmentfile3)%>" >
                        دانلود  

                    </a>

                    <%

                        }

                    %>



                    <%
                    %>

                </div>


                <!--<input id="title3" disabled="disabled"/>-->
            </div>
                    
                    <br>       
                    <br>       
                    <br>       
                    
                    
            <div class="row">      
                <div class="col-lg">
                    شرح کامل
                    <textarea  style="margin-top: 10px;margin-bottom: 10px" class="form-control" disabled="disabled" >
                        <%=DocumentaryRow.get(0).get(CreateDocumentary._htmlContent)%> 
                    </textarea>

                </div>

            </div>
            <!--            <div class="row">-->
            <%
                String userId = jjTools.getSessionAttribute(request, "#ID");
                for (int i = 1; i <= 20; i++) {
                    if (!DocumentaryRow.get(0).get("createDocumentary_signatory_user_" + i).toString().isEmpty()) {
                        List<Map<String, Object>> row = jjDatabase.separateRow(db.Select(CreateDocumentary.tableName, "createDocumentary_signatory_user_" + i + "=" + userId));

                        List<Map<String, Object>> UserRow = jjDatabase.separateRow(db.Select(Access_User.tableName, Access_User._id + "=" + DocumentaryRow.get(0).get("createDocumentary_signatory_user_" + i).toString()));///برای در اوردن نام وفامیلی امضا کننده
                        System.out.println(">>>>>>>>>>>>>>>>>>>" + i);
                        if (!(DocumentaryRow.get(0).get("createDocumentary_signatory_signature_" + i).equals("0")
                                || DocumentaryRow.get(0).get("createDocumentary_signatory_signature_" + i).equals("1"))) {///اگر امضا کننده 0یا 1 باشد و همچنین یوزر امضا کننده خالی باشد این if میشود
//                                for (int j = 0; j < row.size(); j++) {
            %>
            <div class="card-header bg-primary tx-white" style="margin-top: 10px;margin-bottom: 10px"></div>
            <div class="row">
                <div class="col-lg">
                    <div>
                        عنوان امضا کننده
                    </div>
                    <div class="form-control col-lg" >
                        <%=row.get(0).get("createDocumentary_signatory_title_" + i)%> 
                    </div></div>
                <div class="col-lg">
                    <div>
                        فردامضا کننده
                    </div>
                    <div class="form-control col-lg" >
                        <%=UserRow.get(0).get(Access_User._name).toString() + " " + UserRow.get(0).get(Access_User._family).toString()%> 
                    </div>
                </div>
                <div class="col-lg">
                    <div>
                        سمت امضا کننده
                    </div>
                    <div class="form-control col-lg" >
                        <%=row.get(0).get("createDocumentary_signatory_role_" + i)%> 
                    </div>

                </div>
            </div>


            <div class="row"  id="formSign" >
                <div class="col-lg">
                    <span style="position: relative;top:30px">
                        رد امضا</span>
                    <input class="form-control" type="radio" value="0" id="RejectSignature"  style="margin-top: 7px" name="createDocumentary_signatory_signature_<%=i%>">
                </div>
                <div class="col-lg">
                    <span style="position: relative;top:30px">
                        تایید امضا</span>
                    <input class="form-control" type="radio"  value="1" id="SignatureVerification" style="margin-top: 7px"  name="createDocumentary_signatory_signature_<%=i%>" >
                </div>
                <div class="col-lg">
                    توضیحات
                    <textarea class="form-control"  id="createDocumentary_signatory_comment_<%=i%>"  name="createDocumentary_signatory_comment_<%=i%>" ></textarea>
                </div>

            </div>

            <div class="row">

                <div class="mg-t-20  col-lg-4">
                    <button class="btn btn-outline-success active btn-block mg-b-10  btn-block" onclick="SaveSign('<%=DocumentaryRow.get(0).get(CreateDocumentary._id)%>');">ثبت </button>                
                </div><!-- col -->
            </div>
            <!--<div class="card-header bg-primary tx-white" style="margin-top: 10px;margin-bottom: 10px"></div>-->

            <%

                        }
                    }
                }
            %>

        </div>



    </div>
</div><!-- card -->
</div><!-- sh-pagebody -->
<!--        <div class="row col-lg-12">
            <div class="mg-t-20  col-lg">
                <button class="btn btn-outline-secondary mg-b-10  btn-block" onclick="hmisCreateDocumentary.m_show_tbl();">بازگشت </button>                
            </div> col 
            <div id="CreateDocumentary_button" class="col-lg-9 mg-t-20 row">            
            </div>
        </div> card -->
<script>

    function SaveSign(id) {
        var param = "";
        param += "&id=" + id;
        param += "&do=CreateDocumentary.saveSign";

        param += "&" + new jj("#formSign").jjSerial();



        new jj(param).jjAjax2(false);

    }



</script>


</body>
</html>
