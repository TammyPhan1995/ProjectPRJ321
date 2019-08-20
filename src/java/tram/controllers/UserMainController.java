/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tram.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tammy Phan
 */
public class UserMainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String USER_MANAGE = "AccountController";
    private static final String BOOKING_MANAGE = "BookingController";
    private static final String CART_MANAGE = "CartController";
    private static final String TOUR_MANAGE = "TourController";
    private static final String PROMOTION_MANAGE = "PromotionController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if(action.equals("UserManagement")){
                url = USER_MANAGE;
            }else if(action.equals("BookingManagement")){
                url = BOOKING_MANAGE;
            }else if(action.equals("CartManagement")){
                url = CART_MANAGE;
            }else if(action.equals("TourManagement")){
                url = TOUR_MANAGE;
            }else if(action.equals("PromotionManagement")){
                url =PROMOTION_MANAGE;
            }
            else{
                request.setAttribute("ERROR", "This action is not supported");
            }
        } catch (Exception e) {
            log("ERROR AT UserMainController: " + e.getMessage());
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
