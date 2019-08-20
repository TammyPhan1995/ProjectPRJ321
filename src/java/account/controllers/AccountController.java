/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tammy Phan
 */
public class AccountController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String INSERT = "InsertAccountController";
    private static final String DELETE = "DeleteAccountController";
    private static final String EDIT = "EditAccountController";
    private static final String UPDATE = "UpdateAccountController";
    private static final String SEARCH = "SearchAccountController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("subaction");
            if(action.equals("Register")){
                url = INSERT;
            }else if(action.equals("Delete")){
                url = DELETE;
            }else if(action.equals("Edit")){
                url = EDIT;
            }else if(action.equals("Update")){
                url = UPDATE;
            }else if(action.equals("Search")){
                url = SEARCH;
            }else{
                request.setAttribute("ERROR", "This action is not supported");
            } 
        } catch (Exception e) {
            log("ERROR AT AccountController: " + e.getMessage());
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
