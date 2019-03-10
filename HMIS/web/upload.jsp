<%-- 
    Document   : newjsp
    Created on : Feb 26, 2019, 11:16:27 AM
    Author     : PadidarNB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.sql.*" %>
        <%@ page import="javax.servlet.http.*" %>
        <%@ page import="org.apache.commons.fileupload.*" %>
        <%@ page import="org.apache.commons.fileupload.disk.*" %>
        <%@ page import="org.apache.commons.fileupload.servlet.*" %>
        <%@ page import="org.apache.commons.io.output.*" %>
    </head>
    <body>





        <%
            File file;
            int maxFileSize = 5000 * 2492013;
            int maxMemSize = 5000 * 2492013;
            
            ServletContext context = pageContext.getServletContext();
            String filePath = context.getInitParameter("file-upload");

            // Verify the content type
            String contentType = request.getContentType();
            if ((contentType.indexOf("application/json") >= 0)) {

                DiskFileItemFactory factory = new DiskFileItemFactory();
                // maximum size that will be stored in memory
                factory.setSizeThreshold(maxMemSize);
                // Location to save data that is larger than maxMemSize.
                factory.setRepository(new File("c:\\temp"));

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                // maximum file size to be uploaded.
                upload.setSizeMax(maxFileSize);
                new File("C:\\Diry1").mkdir();
                try {
                    // Parse the request to get file items.
                    List fileItems = upload.parseRequest(request);

                    // Process the uploaded file items
                    Iterator i = fileItems.iterator();

                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>JSP File upload</title>");
                    out.println("</head>");
                    out.println("<body>");
                    while (i.hasNext()) {
                        FileItem fi = (FileItem) i.next();
                        if (!fi.isFormField()) {
                            // Get the uploaded file parameters
                            String fieldName = fi.getFieldName();
                            String fileName = fi.getName();
                            boolean isInMemory = fi.isInMemory();
                            long sizeInBytes = fi.getSize();
                            // Write the file
                            if (fileName.lastIndexOf("\\") >= 0) {
                                file = new File(filePath
                                        + fileName.substring(fileName.lastIndexOf("\\")));
                            } else {
                                file = new File(filePath
                                        + fileName.substring(fileName.lastIndexOf("\\") + 1));
                            }
                            fi.write(file);
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db_hmis", "root", "root");
                            String INSERT_PICTURE = "insert into upload(id, upload_file_name, upload_date,upload_pic) values (?, ?,  CURDATE(),?)";

                            String file_name = file.getName();
                            FileInputStream fis = null;
                            PreparedStatement ps = null;
                            conn.setAutoCommit(false);
                            fis = new FileInputStream(file);
                            ps = conn.prepareStatement(INSERT_PICTURE);
                            ps.setString(1, "026");
                            ps.setString(2, "hai");
                            ps.setBinaryStream(3, fis, (int) file.length());
                            ps.setString(4, file_name);
                            ps.executeUpdate();
                            conn.commit();

                            //read back
                            String SELECT_UPLOAD = "select id, upload_file_name, upload_pic from upload";
                            ps = conn.prepareStatement(SELECT_UPLOAD);
                            ResultSet rs = ps.executeQuery();
                            out.println("Uploaded Filename: "
                                    + fileName + "<br>");
                            file.delete();

                            out.println("filename :" + file_name);

                        }
                    }
                    out.println("</body>");
                    out.println("</html>");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>No file uploaded</p>");
                out.println("</body>");
                out.println("</html>");
            }
        %>

    </body>
</html>
