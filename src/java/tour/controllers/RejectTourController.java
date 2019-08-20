/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tram.daos.BookingDAO;
import tram.daos.BookingDetailDAO;
import tram.daos.TourDAO;

/**
 *
 * @author Tammy Phan
 */
public class RejectTourController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String booking_id = request.getParameter("booking_id");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            BookingDAO bookingDAO = new  BookingDAO();
            String tour_id = bookingDAO.findTourId(booking_id);
            TourDAO tourDAO = new TourDAO();
            Date start_date = tourDAO.findStartDate(tour_id);
            int differentDays = (int)((start_date.getTime() - System.currentTimeMillis())/(1000*60*60*24));
            if(differentDays>7){
            tourDAO.updateBookedQuantityByReject(tour_id, quantity);
            BookingDetailDAO bookingDetailDAO = new BookingDetailDAO();
            bookingDetailDAO.setBookingRejected(booking_id);
            }else{
                request.setAttribute("ERROR", "Booking's ID: " +  booking_id + " cannot cancel "
                        + "because today is in the 7 day period before tour's start date" );
            }
        } catch (Exception e) {
            log("ERROR AT RejectTour: " + e.getMessage());
        }finally{
            request.getRequestDispatcher("SearchByUserIdController").forward(request, response);
        
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
