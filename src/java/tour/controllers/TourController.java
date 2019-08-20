/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tammy Phan
 */
public class TourController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String DELETE = "DeleteTourController";
    private static final String EDIT = "EditTourController";
    private static final String SEARCH = "SearchTourController";
    private static final String CHECK_PASSED = "CheckPassedTourController";
    private static final String DELETE_PASSED = "DeletePassedTourController";
    private static final String SHOW = "ShowProductsController";
    private static final String REJECT = "RejectTourController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("subaction");
            if(action.equals("Delete")){
                url = DELETE;
            }else if(action.equals("Edit")){
                url = EDIT;
            }else if(action.equals("Search")){
                url = SEARCH;
            }else if(action.equals("CheckPassedTour")){
                url = CHECK_PASSED;
            }else if(action.equals("DeletePassedTour")){
                url = DELETE_PASSED;
            }else if(action.equals("ShowProducts")){
                url = SHOW;
            }else if(action.equals("RejectTour")){
                url =REJECT;
            }
            else{
                request.setAttribute("ERROR", "This action is not supported");
            }
        } catch (Exception e) {
            log("ERROR AT TourController: " +e.getMessage());
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
