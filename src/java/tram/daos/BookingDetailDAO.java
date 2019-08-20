/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tram.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tram.db.MyConnection;
import tram.dtos.BookingDetailDTO;

/**
 *
 * @author Tammy Phan
 */
public class BookingDetailDAO implements Serializable {
    private static final String PAID = "paid";
    private static final String CANCELLED = "cancelled full refund";
    private static final String REJECT = "cancelled 50.0%";
    private static final String DONE = "done";

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public BookingDetailDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<BookingDetailDTO> findByBookingId(String search) throws Exception {
        List<BookingDetailDTO> result = null;
        try {
            String sql = "select booking_id, booked_date, quantity, price, status\n" +
                            "from tbl_booking_detail where booking_id LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            String booking_id = null;
            Date booked_date = null;
            int quantity = 0;
            String status = null;
            float price = 0;
            BookingDetailDTO dto = null;
            result = new ArrayList<>();
            while (rs.next()) {
                    booking_id = rs.getString("booking_id");
                    booked_date = rs.getDate("booked_date");
                    quantity = rs.getInt("quantity");
                    status = rs.getString("status");
                    price =rs.getFloat("price");
                    dto = new BookingDetailDTO(booking_id, status, booked_date, quantity, price);
                    result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<BookingDetailDTO> findByUserId(String user_id) throws Exception {
        List<BookingDetailDTO> result = null;
        try {
            String sql =    "select d.booking_id, d.booked_date, d.quantity, d.price, d.status\n" +
                            "from tbl_user u, tbl_booking b, tbl_booking_detail d\n" +
                            "where u.user_id = ? and u.user_id = b.user_id and b.booking_id  =d.booking_id";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user_id);
            rs = preStm.executeQuery();
            String booking_id = null;
            Date booked_date = null;
            int quantity = 0;
            String status = null;
            float price = 0;
            BookingDetailDTO dto = null;
            result = new ArrayList<>();
            while (rs.next()) {
                    booking_id = rs.getString("booking_id");
                    booked_date = rs.getDate("booked_date");
                    quantity = rs.getInt("quantity");
                    status = rs.getString("status");
                    price =rs.getFloat("price");
                    dto = new BookingDetailDTO(booking_id, status, booked_date, quantity, price);
                    result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    
    
    public void insert(List<BookingDetailDTO> list) throws Exception{
        try{
            String sql = "insert into tbl_booking_detail (booking_id, booked_date, quantity, price, status, promotion_code) "
                    + "values(?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            for(BookingDetailDTO dto : list){
            preStm.setString(1, dto.getBooking_id());
            preStm.setDate(2, dto.getBooked_date());
            preStm.setInt(3, dto.getQuantity());
            preStm.setFloat(4, dto.getPrice());
            preStm.setString(5, dto.getStatus());
            preStm.setString(6, dto.getPromotion_code());
            preStm.executeUpdate();
            }
        }finally{
            closeConnection();
        }
    }

  

    public void cancelBookings(String tour_id) throws Exception {
        try {
            String sql = "update tbl_booking_detail\n"
                    + "set status = '"+CANCELLED+"'\n"
                    + "where booking_id in (select b.booking_id\n"
                    + "			from tbl_tour t, tbl_booking b, tbl_booking_detail d\n"
                    + "                   where t.tour_id = ? and t.tour_id = b.tour_id and b.booking_id = d.booking_id and d.status LIKE ?\n"
                    + "			)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tour_id);
             preStm.setString(2, "%"+PAID+"%");
            preStm.executeUpdate();

        } finally {
            closeConnection();
        }
    }

    public void setBookingOverdue() throws Exception {
        try {
            String sql = "update tbl_booking_detail\n"
                    + "set status = '"+DONE+"' \n"
                    + "where booking_id in (\n"
                    + "select d.booking_id\n"
                    + "from tbl_tour t, tbl_booking b, tbl_booking_detail d\n"
                    + "where t.active =1 and t.start_date < cast(getdate() as date) and t.tour_id = b.tour_id and b.booking_id = d.booking_id and d.status LIKE ?\n"
                    + ")";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+PAID+"%");
            preStm.executeUpdate();
        } finally {
            closeConnection();
        }
    }
    
    public void setBookingRejected(String booking_id ) throws Exception{
        try{
            String sql = "update tbl_booking_detail\n" +
                        "set status = ? where booking_id = ? ";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, REJECT);
            preStm.setString(2, booking_id);
            preStm.executeUpdate();
        }finally{
            closeConnection();
        }
    }

}
