/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.tools;

/**
 *
 * @author hoda
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@WebServlet(name = "ImageViewer", urlPatterns = {"/imageViewer"},
//        initParams = {
//            @WebInitParam(name = "FILE_UPLOAD_PATH", value = "/SepanoShop/upload")
//        })
public class ImageViewer extends HttpServlet {

    private String fileDownloadPath;
    private ServletFileUpload uploader = null;
    int width = 150;
    int height = 50;
    private static final String Save_Folder_Name = "upload" + File.separator;//seperator is / in linux and is \ in windows

//    static final long serialVersionUID = 1L;
//        private static final int BUFSIZE = 4096;
//    public void init(ServletConfig config) {
//        fileDownloadPath = config.getInitParameter("FILE_UPLOAD_PATH");
//    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pattern = Pattern.quote(System.getProperty("file.separator"));//seperator is / in linux and is \ in windows
        String[] contxtPath = request.getServletContext().getRealPath("/").split(pattern);
        String safaPat = "";
        for (int i = 0; i < contxtPath.length - 2; i++) {//return 2 folder up(parent of parent)
            safaPat += contxtPath[i] + System.getProperty("file.separator");
        }
        String path = safaPat + Save_Folder_Name;// upload\ in windows and upload/ in linux
        File filesDir = new File(path);
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
        String fileName = request.getRequestURI();
        int index1 = fileName.indexOf("upload/");// request is like upload/p2624792842.jpg
        fileName = fileName.substring(index1 + 7);
        if (fileName.contains("%20")) {
            fileName = fileName.replace("%20", " ");
        }
        ServerLog.Print("fileName is " + fileName);
        if (fileName == null || fileName.equals("")) {
//            throw new ServletException("File Name can't be null or empty");
        }
        File file = new File(filesDir + File.separator + fileName);
//        ServerLog.Print("*********************!!!!>>>" + filesDir + File.separator + fileName);
        if (!file.exists()) {
//            throw new ServletException("File doesn't exists on server:"+filesDir + File.separator + fileName);
        }
        ServerLog.Print("File location on server:" + file.getAbsolutePath());
        String mimetype = new MimetypesFileTypeMap().getContentType(file);
        String type = mimetype.split("/")[0];
//        if (type.equals("image")) {
//            BufferedImage img = ImageIO.read(file);
//            ImageIcon icon = new ImageIcon(img);
//            JFrame frame = new JFrame();
//            frame.setLayout(new FlowLayout());
//            frame.setSize(200, 300);
//            JLabel lbl = new JLabel();
//            lbl.setIcon(icon);
//            frame.add(lbl);
//            frame.setVisible(true);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        }

        ServletContext ctx = request.getServletContext();
        InputStream fis;
        try {
            fis = new FileInputStream(file);
            String mimeType = ctx.getMimeType(file.getAbsolutePath());
            response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

            ServletOutputStream os = response.getOutputStream();
            byte[] bufferData = new byte[1024];
            int read = 0;
            while ((read = fis.read(bufferData)) != -1) {
                os.write(bufferData, 0, read);
            }
            os.flush();
            os.close();
            fis.close();
            ServerLog.Print("File downloaded at client successfully");

        } catch (Exception ex) {
            ServerLog.Print("File Exeption ...>>>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        ServerLog.Print("********");
        processRequest(request, response);
//        ServerLog.Print("********");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        ServerLog.Print("********");
        processRequest(request, response);
//        ServerLog.Print("********");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
