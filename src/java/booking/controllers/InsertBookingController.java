/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tram.daos.BookingDAO;
import tram.daos.BookingDetailDAO;
import tram.daos.PromotionDAO;
import tram.daos.TourDAO;
import tram.db.MyConnection;
import tram.dtos.BookingDTO;
import tram.dtos.BookingDetailDTO;
import tram.dtos.CartObj;
import tram.dtos.ProductDTO;
import tram.dtos.PromotionDTO;
import tram.dtos.TourUpdatingObject;

/**
 *
 * @author Tammy Phan
 */
public class InsertBookingController extends HttpServlet {

    public static final String SUCCESS = "user/showBill.jsp";
    public static final String INVALID = "user/showCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SUCCESS;
        Connection conn = null;
        try {
            boolean valid = true;
            String promotion_code = request.getParameter("promotion_code").trim();
            String status = "paid";
            float discount_value = 0;
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");
            
            if (!promotion_code.equals("")) {
                PromotionDAO proDAO = new PromotionDAO();
                PromotionDTO proDTO = proDAO.findByPrimaryKey(promotion_code);
                if (proDTO != null) {
                    discount_value = proDTO.getValue();
                    cart.setPromotion_value(discount_value);
                    status = "paid promotion " + discount_value * 100 + "%";
                } else {
                    url = INVALID;
                    valid = false;
                    request.setAttribute("INVALID", "Invalid Promotion Code");
                }
            } else {
                promotion_code = "no";
            }
            if (valid) {
                List<TourUpdatingObject> updating_tour_list = new ArrayList<>();
                List<BookingDTO> booking_list = new ArrayList<>();
                List<BookingDetailDTO> booking_detail_list = new ArrayList<>();
                TourUpdatingObject updatingTourDTO = null;
                BookingDTO bookingDTO = null;
                BookingDetailDTO bookingDetailDTO = null;
                String tour_id = null;
                int quantity = 0;
                String username = (String) session.getAttribute("USER");
                String booking_id = null;
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                String tmpDate = fmt.format(Calendar.getInstance().getTime());
                Date curDate = new Date(fmt.parse(tmpDate).getTime());
                float price = 0;
                for (ProductDTO product : cart.getCart().values()) {
                    tour_id = product.getTour_id();
                    quantity = product.getQuantity();
                    price = (product.getPrice() * product.getQuantity()) - ((product.getPrice() * product.getQuantity()) * discount_value);
                    booking_id = username + tour_id + System.currentTimeMillis();
                    updatingTourDTO = new TourUpdatingObject(tour_id, quantity);
                    bookingDTO = new BookingDTO(booking_id, username, tour_id);
                    bookingDetailDTO = new BookingDetailDTO(booking_id, status, promotion_code, curDate, quantity, price);
                    updating_tour_list.add(updatingTourDTO);
                    booking_list.add(bookingDTO);
                    booking_detail_list.add(bookingDetailDTO);
                }

                conn = MyConnection.getMyConnection();
                TourDAO tourDAO = new TourDAO();
                tourDAO.updateBookedQuantity(updating_tour_list, conn);

                BookingDAO bookDAO = new BookingDAO();
                bookDAO.insert(booking_list);
                BookingDetailDAO bookDetailDAO = new BookingDetailDAO();
                bookDetailDAO.insert(booking_detail_list);

                request.setAttribute("CART", cart);
                request.setAttribute("DATE", curDate);
                session.removeAttribute("CART");
            }
        } catch (Exception e) {
            log("ERRROR AT InsertBookingController: " + e.getMessage());
            if (e.getMessage() != null) {
                if (e.getMessage().contains("Only")) {
                    try {
                        if (conn != null) {
                            conn.rollback();
                        }
                    } catch (SQLException s) {
                        log("ERRROR AT InsertBookingController: " + s.getMessage());
                    }
                    url = INVALID;
                    request.setAttribute("INVALID", e.getMessage());
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                log("ERRROR AT InsertBookingController: " + e.getMessage());
            }
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
