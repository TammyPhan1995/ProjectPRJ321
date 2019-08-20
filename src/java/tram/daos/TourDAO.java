package tram.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tram.db.MyConnection;
import tram.dtos.TourDTO;
import tram.dtos.TourUpdatingObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tammy Phan
 */
public class TourDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public TourDAO() {
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

    public List<TourDTO> findByLineName(String name) throws Exception {
        List<TourDTO> result = null;
        try {
            String sql = "select tour_id, title, capacity, price, start_date, end_date, booked_quantity "
                    + " from tbl_tour where title LIKE ? and active = 1";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            String id = null;
            String title = null;
            int capacity = 0;
            float price = 0;
            Date start_date = null, end_date = null;
            int booked_quantity = 0;
            TourDTO dto = null;
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("tour_id");
                title = rs.getString("title");
                capacity = rs.getInt("capacity");
                price = rs.getFloat("price");
                start_date = rs.getDate("start_date");
                end_date = rs.getDate("end_date");
                booked_quantity = rs.getInt("booked_quantity");
                dto = new TourDTO(id, title, capacity, booked_quantity, price, start_date, end_date);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_tour set active = 0  where tour_id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(TourDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_tour (tour_id, title, capacity, description, price, start_date, end_date, img_url, active, booked_quantity)  "
                    + " values(?,?,?,?,?,?,?,?,1,0)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getTitle());
            preStm.setInt(3, dto.getCapacity());
            preStm.setString(4, dto.getDescription());
            preStm.setFloat(5, dto.getPrice());
            preStm.setDate(6, dto.getStart_date());
            preStm.setDate(7, dto.getEnd_date());
            preStm.setString(8, dto.getImg_url());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public TourDTO findByPrimaryKey(String id) throws Exception {
        TourDTO dto = null;
        try {
            String sql = "select title, capacity,description,  price, start_date, end_date, img_url "
                    + " from tbl_tour where tour_id = ? ";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                int capacity = rs.getInt("capacity");
                String desc = rs.getString("description");
                float price = rs.getFloat("price");
                Date start_date = rs.getDate("start_date");
                Date end_date = rs.getDate("end_date");
                String img_url = rs.getString("img_url");
                dto = new TourDTO(id, title, desc, img_url, capacity, price, start_date, end_date);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean update(TourDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_tour\n"
                    + "set title = ?, capacity = ?, description = ?, price = ?, start_date = ?, end_date = ?, img_url = ?\n"
                    + "where tour_id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getTitle());
            preStm.setInt(2, dto.getCapacity());
            preStm.setString(3, dto.getDescription());
            preStm.setFloat(4, dto.getPrice());
            preStm.setDate(5, dto.getStart_date());
            preStm.setDate(6, dto.getEnd_date());
            preStm.setString(7, dto.getImg_url());
            preStm.setString(8, dto.getId());
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return check;
    }

    public List<TourDTO> findAllTour() throws Exception {
        List<TourDTO> result = null;
        try {
            String sql = "select tour_id, title, capacity, description, price, start_date, end_date, img_url, booked_quantity\n"
                    + "from tbl_tour\n"
                    + "where active = 1 and start_date > CAST(getdate() as date)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            String id = null;
            String title = null;
            int capacity = 0;
            String desc = null;
            float price = 0;
            Date start_date = null, end_date = null;
            int booked_quantity = 0;
            String img_url = null;
            TourDTO dto = null;
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("tour_id");
                title = rs.getString("title");
                capacity = rs.getInt("capacity");
                desc = rs.getString("description");
                price = rs.getFloat("price");
                start_date = rs.getDate("start_date");
                end_date = rs.getDate("end_date");
                booked_quantity = rs.getInt("booked_quantity");
                img_url = rs.getString("img_url");
                dto = new TourDTO(id, title, desc, img_url, capacity, booked_quantity, price, start_date, end_date);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<TourDTO> findPassedTour() throws Exception {
        List<TourDTO> result = null;
        try {
            String sql = "select tour_id, title, start_date, end_date, booked_quantity\n"
                    + "from tbl_tour\n"
                    + "where active = 1 and start_date < CAST(getdate() as date)";

            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            String id = null;
            String title = null;
            Date start_date = null;
            Date end_date = null;
            int booked_quantity = 0;
            TourDTO dto = null;
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("tour_id");
                title = rs.getString("title");
                start_date = rs.getDate("start_date");
                end_date = rs.getDate("end_date");
                booked_quantity = rs.getInt("booked_quantity");
                dto = new TourDTO(id, title, booked_quantity, start_date, end_date);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }


    public void deletePassedTour() throws Exception {
        try {
            String sql = "update tbl_tour set active = 0 \n"
                    + "where tour_id in (select tour_id\n"
                    + "                  from tbl_tour\n"
                    + "                  where active = 1 and start_date < CAST(getdate() as date)\n"
                    + "                     )";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.executeUpdate();
        } finally {
            if(preStm!=null){
                preStm.close();
            }
        }
    }

    public void updateBookedQuantity(List<TourUpdatingObject> list, Connection c) throws Exception{
        try {
            //co trigger nen phai set luon tour_id
            String sql = "update tbl_tour set booked_quantity = ?+(select booked_quantity from tbl_tour where tour_id = ?)\n" +
                         " , tour_id = ? where tour_id = ?";
            conn = c;
            conn.setAutoCommit(false);
            preStm = conn.prepareStatement(sql);
            for (TourUpdatingObject dto : list) {
                preStm.setInt(1, dto.getQuantity());
                preStm.setString(2, dto.getTour_id());
                preStm.setString(3, dto.getTour_id());
                preStm.setString(4, dto.getTour_id());
                preStm.executeUpdate();
            }
            conn.commit();
        }
        finally {
           if(preStm!=null){
               preStm.close();
           }
        }
    }
    
    public void updateBookedQuantityByReject(String tour_id, int quantity) throws Exception{
        try{
            String sql = "update tbl_tour\n" +
                         "set booked_quantity = (select booked_quantity from tbl_tour where tour_id = ?) - ?\n" +
                         "where tour_id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tour_id);
            preStm.setInt(2, quantity);
            preStm.setString(3, tour_id);
            preStm.executeUpdate();
        }finally{
            closeConnection();
        }
    }
    
    public Date findStartDate(String tour_id) throws Exception{
        Date start_date = null;
        try{
            String sql = "select start_date from tbl_tour where tour_id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tour_id);
            rs = preStm.executeQuery();
            if(rs.next()){
                start_date = rs.getDate("start_date");
            }
        }finally{
            closeConnection();
        }
        return start_date;
    }
}
