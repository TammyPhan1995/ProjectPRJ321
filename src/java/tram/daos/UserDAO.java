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
import tram.dtos.UserDTO;

/**
 *
 * @author Tammy Phan
 */
public class UserDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public UserDAO() {
    }

    private void closeConnetion() throws Exception {

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

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        try {
            String sql = "select role from tbl_user where user_id = ? and password = ? and active = 1";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
            }
        } finally {
            closeConnetion();
        }

        return role;
    }

    public List<UserDTO> findByLineName(String search) throws Exception {
        List<UserDTO> result = null;
        try {
            String sql = "select user_id, fullname, email, phone, dob from tbl_user where fullname LIKE ? and active = 1 and role='user'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            String id = null;
            String fullname = null;
            String email = null;
            String phone = null;
            Date dob = null;
            UserDTO dto = null;
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("user_id");
                fullname = rs.getString("fullname");
                email = rs.getString("email");
                phone = rs.getString("phone");
                dob = rs.getDate("dob");
                dto = new UserDTO(id, fullname, email, phone, dob);
                result.add(dto);
            }
        } finally {
            closeConnetion();
        }
        return result;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_user set active = 0 where user_id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnetion();
        }
        return check;
    }

    public boolean insert(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_user (user_id, password,fullname,email,phone,dob,role,active) "
                    + "values(?,?,?,?,?,?,'user',1)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getEmail());
            preStm.setString(5, dto.getPhone());
            preStm.setDate(6, dto.getDob());
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnetion();
        }
        return check;
    }

    public UserDTO findByPrimaryKey(String id) throws Exception {
        UserDTO dto = null;
        try {
            String sql = "select fullname, email, phone, dob from tbl_user where user_id = ? ";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Date dob = rs.getDate("dob");
                dto = new UserDTO(id, fullname, email, phone, dob);
            }
        } finally {
            closeConnetion();
        }
        return dto;
    }

    public boolean update(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_user set fullname = ?, email = ?, phone = ?, dob = ? where user_id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getFullname());
            preStm.setString(2, dto.getEmail());
            preStm.setString(3, dto.getPhone());
            preStm.setDate(4, dto.getDob());
            preStm.setString(5, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnetion();
        }
        return check;
    }

    public boolean checkUserPaidForAnyTour(String user_id) throws Exception {
        boolean check = false;
        try {
            String sql = "select u.user_id "
                    + "from tbl_user u, tbl_booking b, tbl_booking_detail d "
                    + "where u.user_id = b.user_id and u.user_id = ? and b.booking_id = d.booking_id  and d.status LIKE '%paid%'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user_id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnetion();
        }
        return check;
    }
}
