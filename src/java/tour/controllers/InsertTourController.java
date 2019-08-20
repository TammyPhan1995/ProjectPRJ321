/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import tram.daos.TourDAO;
import tram.dtos.TourDTO;
import tram.dtos.TourErrorObject;

/**
 *
 * @author Tammy Phan
 */
public class InsertTourController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "admin/admin.jsp";
    private static final String INVALID = "admin/insertTour.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            if(ServletFileUpload.isMultipartContent(request)){
                boolean valid = true;
                TourErrorObject errorObj = new TourErrorObject();
                HashMap params = new HashMap();
                FileItem fileItem = null;
                List items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                Iterator iter = items.iterator();
                while(iter.hasNext()){
                    FileItem item = (FileItem) iter.next();
                    if(item.isFormField()){
                        params.put(item.getFieldName(), item.getString());
                    }else{
                        String itemName = item.getName();
                        fileItem = item;
                        params.put("FILE", itemName);
                    }
                }
                
                String id = ((String) params.get("id")).trim();
                String title = ((String) params.get("title")).trim();
                String capacityStr = ((String) params.get("capacity")).trim();
                String description = ((String) params.get("description")).trim();
                String priceStr = ((String) params.get("price")).trim();
                String start_dateStr = ((String) params.get("start_date")).trim();
                String end_dateStr = ((String) params.get("end_date")).trim();
                String fileItemName = ((String) params.get("FILE")).trim();
                int capacity = 0;
                float price= 0;
                Date start_date = new Date(0, 0, 0);
                Date end_date = new Date(0,0,0);
                
                //Validate 
                TourDAO dao = new TourDAO();
                if(!id.matches("[T][0-9]{3,19}")){
                    valid = false;
                    errorObj.setIdError("Tour's id is required, starts with a T followed by more than 3 digits, example T777...");
                }else if(dao.findByPrimaryKey(id)!=null){
                    valid = false;
                    errorObj.setIdError("This tour is already in the system");
                }
                if(title.length()<3){
                    valid = false;
                    errorObj.setTitleError("Title is required, minimum 3 chars");
                }
                if(description.length()==0){
                    valid = false;
                    errorObj.setDescriptionError("Description is required");
                }
                if(!capacityStr.matches("^[0-9]+$")){
                    valid =false;
                    errorObj.setCapacityError("Capicity is required, must be number");
                }else{
                    capacity = Integer.parseInt(capacityStr);
                    if(capacity<10){
                        valid = false;
                        errorObj.setCapacityError("Capicity must more than 10");
                    }
                }
                if(!priceStr.matches("^[0-9]+([.][0-9]+)?$")){
                    valid = false;
                    errorObj.setPriceError("Price is required, must be number");
                }else{
                    price = Float.parseFloat(priceStr);
                }
                boolean validDate = true;
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                fmt.setLenient(false);
                String tmpDate = fmt.format(Calendar.getInstance().getTime());
                Date curDate = new Date(fmt.parse(tmpDate).getTime());
                try{
                    start_date = new Date(fmt.parse(start_dateStr).getTime());
                }catch(ParseException p1){
                    valid = false;
                    validDate = false;
                    errorObj.setStart_dateError("Start date is invalid (yyyy-mm-dd)");
                }
                try{
                    end_date = new Date(fmt.parse(end_dateStr).getTime());
                }catch(ParseException p1){
                    valid = false;
                    validDate = false;
                    errorObj.setEnd_dateError("End date is invalid (yyyy-mm-dd)");
                }
                if(validDate){
                    if(end_date.before(start_date) || start_date.before(curDate)){
                        valid = false;
                        errorObj.setEnd_dateError("End date must after start date, both must after current date: " + curDate);
                    }
                }
                if(!fileItemName.equals("")){
                    String extension = fileItemName.substring(fileItemName.lastIndexOf(".")+1);
                    if(!extension.matches("png|jpg")){
                        valid = false;
                        errorObj.setImg_urlError("Accept: .png or .jpg only");
                    }
                }else{
                    valid = false;
                    errorObj.setImg_urlError("Image is required");
                }
                if(valid){
                    String fileName = fileItemName.substring(fileItemName.lastIndexOf("\\") + 1);
                    fileName = System.currentTimeMillis() + fileName;
                    String realPath = getServletContext().getRealPath("/") + "img\\" + fileName;
                    File file = new File(realPath);
                    fileItem.write(file);
                    TourDTO dto = new TourDTO(id, title, description, fileName, capacity, price, start_date, end_date);
                    if(dao.insert(dto)){
                        url = SUCCESS;
                    }else{
                        request.setAttribute("ERROR", "Insert Tour Failed");
                    }
                }else{
                    request.setAttribute("INVALID", errorObj);
                    request.setAttribute("PARAMS", params);
                    url = INVALID;
                } 
            }
        } catch (Exception e) {
            log("ERROR AT InsertTourController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
