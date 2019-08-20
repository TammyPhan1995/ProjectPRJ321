/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotion.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tram.daos.PromotionDAO;
import tram.dtos.PromotionDTO;
import tram.dtos.PromotionErrorObject;

/**
 *
 * @author Tammy Phan
 */
public class InsertPromotionController extends HttpServlet {
    private static final String    ERROR = "error.jsp";
    private static final String SUCCESS = "admin/admin.jsp";
    private static final String INVALID = "admin/insertPromotion.jsp";
    
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url  =ERROR;
        try {
            boolean valid = true;
            PromotionErrorObject errObj = new PromotionErrorObject();
            String promotion_code = request.getParameter("promotion_code").trim();
            float value = Float.parseFloat(request.getParameter("value").trim());
            String content = request.getParameter("content").trim();
            if(promotion_code.length()<10){
                valid = false;
                errObj.setCodeError("Promotion code is required, minimum 10 chars");
            }
            if(content.length() == 0){
                valid = false;
                errObj.setContentError("Content is required");
            }
            
            if(valid){
                PromotionDAO dao = new PromotionDAO();
                PromotionDTO dto = new PromotionDTO(promotion_code, content, value);
                if(dao.insert(dto)){
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR", "Insert Promotion Failed");
                }
            }else{
                url = INVALID;
                request.setAttribute("INVALID", errObj);
            }
            
        } catch (Exception e) {
            log("ERROR AT InsertPromotionController: " + e.getMessage());
            if(e.getMessage().contains("duplicate")){
                PromotionErrorObject errorObj = new PromotionErrorObject();
                errorObj.setCodeError("This promotion code is already in the system");
                url =INVALID;
                request.setAttribute("INVALID",errorObj);
            }
        }finally{
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
