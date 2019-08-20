/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tram.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import tram.db.MyConnection;
import tram.dtos.BookingDTO;

/**
 *
 * @author Tammy Phan
 */
public class BookingDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public BookingDAO() {
    }

    private void closeConnection() throws Exception {
        if(rs!=null){
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public void insert(List<BookingDTO> list) throws Exception {
        try {
            String sql = "insert into tbl_booking (booking_id, user_id, tour_id) values (?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            for (BookingDTO dto : list) {
                preStm.setString(1, dto.getBooking_id());
                preStm.setString(2, dto.getUser_id());
                preStm.setString(3, dto.getTour_id());
                preStm.executeUpdate();
            }
        } finally {
            closeConnection();
        }
    }
    
    public String findTourId(String booking_id) throws Exception{
        String tour_id = null;
        try{
            String sql = "select tour_id\n" +
                         "from tbl_booking where booking_id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, booking_id);
            rs = preStm.executeQuery();
            if(rs.next()){
                tour_id = rs.getString("tour_id");
            }
        }finally{
            closeConnection();
        }
        return tour_id;
    }
}
