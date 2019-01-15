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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//==================>shiri
//@WebServlet(name="uploadServlet3", urlPatterns = {"/uploadServlet3"},
//initParams = {
//        @WebInitParam(name = "FILE_UPLOAD_PATH", value = "/sepanoShop/upload")
//    })
//<=================shiri

public class UploadServlet extends HttpServlet {

    private static long maxSize = 1000000;
    //====================>shiri
//     private String fileUploadPath;
//    public void init(ServletConfig config) {
//        fileUploadPath = config.getInitParameter("FILE_UPLOAD_PATH");
//    }
    //<================shiri
//    private static String Save_Folder_Name = "/upload";
    private static final String Save_Folder_Name = "upload"+File.separator;
    public static final String Save_Folder_Name2 = "upload"+File.separator;

    Map<String, String> data = new HashMap<String, String>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");
        if (jjNumber.isDigit(jjTools.getParameter(request, "maxSize"))) {
            maxSize = Long.parseLong(jjTools.getParameter(request, "maxSize"));
        }
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        name = name == null ? "" : name;
        response.setContentType("text/plain");
        super.init(getServletConfig());
//        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
//        out.println();
        String pattern = Pattern.quote(System.getProperty("file.separator"));
        String[] contxtPath = request.getServletContext().getRealPath("/").split(pattern);
                String safePath = "";
            for(int i=0;i<contxtPath.length-2;i++){//return 2 folder up(parent of parent)
                safePath+=contxtPath[i]+System.getProperty("file.separator");
            }
            String path = safePath + Save_Folder_Name;// upload\ in windows and upload/ in linux
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
                        out.print("big");
                    } else {
                        out.print(file.getName().replace(" ", "%20").replace("<pre style=\"word-wrap: break-word; white-space: pre-wrap;\">", ""));
                        ServerLog.Print("Write pic in: " + file + " size:" + file.length());
                        String name2 = file.getName().substring(0, file.getName().lastIndexOf("."));
                        String extension2 = file.getName().substring(file.getName().lastIndexOf(".") + 1, file.getName().length());
                        File file2 = new File(file.getParent() + "/" + name2 + "_small." + extension2);
                        if (extension2.toLowerCase().equals("jpg") || extension2.toLowerCase().equals("png") || extension2.toLowerCase().equals("gif")) {
                            jjPicture.doChangeSizeOfPic(file, file2, 250);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Server.ErrorHandler(ex);
        }
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
