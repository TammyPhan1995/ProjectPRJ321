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
import javax.servlet.http.HttpSession;
import tram.daos.UserDAO;

/**
 *
 * @author Tammy Phan
 */
public class LoginController extends HttpServlet {

    private static final String HOME = "login.jsp";
    private static final String ADMIN = "admin/admin.jsp";
    private static final String USER = "user/showProducts.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME;
        try {
            boolean valid = true;
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.length() == 0 || password.length() == 0) {
                valid = false;
            }
            if (valid) {
                UserDAO dao = new UserDAO();
                String role = dao.checkLogin(username, password);
                if (role.equals("failed")) {
                    request.setAttribute("ERROR", "Invalid username or password");
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("USER", username);
                    if (role.equals("admin")) {
                        url = ADMIN;
                    } else if (role.equals("user")) {
                        url = USER;
                    } else {
                        request.setAttribute("ERROR", "Your role is not supported");
                    }
                }
            }else{
                 request.setAttribute("ERROR", "Username and Password are required");
            }
        } catch (Exception e) {
            log("ERROR AT LoginController: " + e.getMessage());
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
