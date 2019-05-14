package cms.tools;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

import java.util.*;
import java.util.regex.Pattern;
import javax.servlet.*;
import javax.servlet.http.*;
import jj.jjNumber;
import jj.jjPicture;

//import java.io.*,java.util.*, javax.servlet.*,java.sql.*
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import jj.jjCalendar_IR;
import jj.jjDatabaseWeb;

//==================>shiri
//@WebServlet(name="uploadServlet3", urlPatterns = {"/uploadServlet3"},
//initParams = {
//        @WebInitParam(name = "FILE_UPLOAD_PATH", value = "/sepanoShop/upload")
//    })
//<=================shiri
public class UploadServlet extends HttpServlet {
////توسط miss shiran1
    private static long maxSize = 1000000;
    public static String tableName = "upload";
    public static String _id = "id";
    public static String _file_name = "upload_file_name";
    public static String _title = "upload_title";
    public static String _date = "upload_date";
    public static String _time = "upload_time";
    public static String _loader = "upload_loader";
    public static String _status = "upload_status";
    public static String _logStatus = "upload_logStatus";
     public static String status_deleted = "پاک شده توسط";
//    public static String _loader_id = "upload_loader_id";
    
    //====================>shiri
//     private String fileUploadPath;
//    public void init(ServletConfig config) {
//        fileUploadPath = config.getInitParameter("FILE_UPLOAD_PATH");
//    }
    //<================shiri
//    private static String Save_Folder_Name = "/upload";
    private static final String Save_Folder_Name = "upload" + File.separator;
    public static final String Save_Folder_Name2 = "upload" + File.separator;

    Map<String, String> data = new HashMap<String, String>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(UploadServlet.class+">>>>");
        jjTools.ShowAllParameter(request);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        if (jjNumber.isDigit(jjTools.getParameter(request, "maxSize"))) {
            maxSize = Long.parseLong(jjTools.getParameter(request, "maxSize"));
        }

//        try {
//            Server.Connect();
//            jjDatabaseWeb db = Server.db;
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db_hmis", "root", "m123456");
//            String INSERT_UPLOAD = "insert into upload(id, upload_file_name, upload_date,upload_pic) values (?, ?,  CURDATE(),?)";
//        } 
//        catch (SQLException ex) {
//            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
        String name = request.getParameter("name");
        name = name == null ? "" : name;
        super.init(getServletConfig());
//        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
//        out.println();
        String pattern = Pattern.quote(System.getProperty("file.separator"));
        String[] contxtPath = request.getServletContext().getRealPath("/").split(pattern);
        String safePath = "";
        for (int i = 0; i < contxtPath.length - 2; i++) {//return 2 folder up(parent of parent)
            safePath += contxtPath[i] + System.getProperty("file.separator");
        }
        String path = safePath + Save_Folder_Name;// upload\ in windows and upload/ in linux
        String result = "";
//        fileItemFactory.setSizeThreshold(1024 * 1024); //1 MB
        try {
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
            List items = uploadHandler.parseRequest(request);
            Iterator itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()) {
                    /*
                     * Field
                     */
//                    out.println("Field Name=" + item.getFieldName() + ", Value=" + item.getString());
                    data.put(item.getFieldName(), item.getString());
                } else {
                    /*
                     * File
                     */
                    //==============>shiri
                    File folderAddress = new File(path);//"/" +
                    String extension = "";
                    String nameWithoutExtension = item.getName();
                    if (item.getName().lastIndexOf(".") > -1) {
                        extension = item.getName().substring(item.getName().lastIndexOf("."));
                        nameWithoutExtension = item.getName().substring(item.getName().lastIndexOf("\\") + 1, item.getName().lastIndexOf("."));
                    }
                    folderAddress.mkdirs();
                    nameWithoutExtension = "P";
                    File file = new File(folderAddress + "/" + nameWithoutExtension.toLowerCase() + jjNumber.getRandom(10) + extension.toLowerCase());
                    String i = "0000000000";
                    while (file.exists()) {
                        i = jjNumber.getRandom(10);
                        file = new File(folderAddress + "/" + nameWithoutExtension.toLowerCase() + i + extension.toLowerCase());
                    }
                    if (!name.equals("")) {
                        file = new File(folderAddress + "/" + name);
                    }
//                    out.println("File Name=" + item.getName()
//                            + ", Field Name=" + item.getFieldName()
//                            + ", Content type=" + item.getContentType()
//                            + ", File Size=" + item.getSize()
//                            + ", Save Address=" + file);
//                    out.println(file);
//                    String urlPath = request.getRequestURL().toString().replace("Upload2", "Upload") + "/" + file.getName().replace("\\", "/");
//                    out.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body><input type='text' name='T1' size='58' value='" + urlPath + "'></body></html>");

                    data.put(item.getFieldName(), file.getAbsolutePath());
                    if (!file.getName().toLowerCase().endsWith(".exe")) {
                        item.write(file);
                    }
                    long size = file.length();
                    ServerLog.Print("?>>>>>>" + file + "   -    Size:" + size);
                    if (size > maxSize) {
                        file.delete();
                        result = "big";
                    } else {
                        result = file.getName().replace(" ", "%20");
                        
                        
                        ////ارتباط بادیتا بیس upload 
                        ////miss shiran1
                       
                        Server.Connect();
                        jjDatabaseWeb db = Server.db;
                        Class.forName("com.mysql.jdbc.Driver");
//                       
                        Map<String, Object> map = new HashMap();
                        map.put(_file_name, result);
//                      
                        map.put(_date, jjCalendar_IR.getDatabaseFormat_8length(jjTools.getParameter(request, _date), true));
                       
                        map.put(_time, new jjCalendar_IR().getTimeFormat_8length());
                        map.put(_loader, (jjTools.getSessionAttribute(request, "#USER_NAME")+" " +jjTools.getSessionAttribute(request,"#USER_FAMILY")));
                        map.put(_logStatus, (jjTools.getParameter(request, _logStatus)));
                    
                        ServerLog.Print("Write pic in: " + file + " size:" + file.length());
                        String name2 = file.getName().substring(0, file.getName().lastIndexOf("."));
                        String extension2 = file.getName().substring(file.getName().lastIndexOf(".") + 1, file.getName().length());
                        File file2 = new File(file.getParent() + "/" + name2 + "_small." + extension2);
                        map.put(_title, extension2);
                         db.insert(UploadServlet.tableName, map);
                        if (extension2.toLowerCase().equals("jpg") 
                                || extension2.toLowerCase().equals("png") 
                                || extension2.toLowerCase().equals("gif")
                                || extension2.toLowerCase().equals("svg")
                                || extension2.toLowerCase().equals("doc")
                                || extension2.toLowerCase().equals("docx")
                                || extension2.toLowerCase().equals("pdf")
                                || extension2.toLowerCase().equals("tiff")
                                || extension2.toLowerCase().equals("xls")
                                || extension2.toLowerCase().equals("xlsx")){
                            jjPicture.doChangeSizeOfPic(file, file2, 250);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Server.ErrorHandler(ex);
        }
        System.out.println("______________________________");
        System.out.println(result);
        System.out.println("______________________________");

        out.print(result);
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }


    public Map<String, String> getData() {
        return data;
    }
}
