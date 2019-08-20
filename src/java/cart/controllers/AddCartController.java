/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tram.dtos.CartObj;
import tram.dtos.ProductDTO;

/**
 *
 * @author Tammy Phan
 */
public class AddCartController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");
            String username = (String) session.getAttribute("USER");
            if(cart==null){
                cart = new CartObj(username);
            }
            String tour_id = request.getParameter("tour_id");
            String title = request.getParameter("title");
            float price = Float.parseFloat(request.getParameter("price"));
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date start_date = new Date(fmt.parse(request.getParameter("start_date")).getTime());
            Date end_date = new Date(fmt.parse(request.getParameter("end_date")).getTime());
            int available = Integer.parseInt(request.getParameter("available"));
            ProductDTO dto = new ProductDTO(tour_id, title, price, available, start_date, end_date);
            cart.addToCart(dto);
            session.setAttribute("CART", cart);
        } catch (Exception e) {
            log("ERROR AT AddCartController: " +e.getMessage());
        }finally{
            response.sendRedirect("/ProjectPRJ321/ShowProductsController");
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
