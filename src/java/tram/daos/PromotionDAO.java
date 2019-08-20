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
import java.util.ArrayList;
import java.util.List;
import tram.db.MyConnection;
import tram.dtos.PromotionDTO;

/**
 *
 * @author Tammy Phan
 */
public class PromotionDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    public PromotionDAO() {
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
    
    
    public boolean insert(PromotionDTO dto) throws Exception{
        boolean check = false;
        try{
            String sql = "insert into tbl_promotion (promotion_code, value, active, content) values(? ,?, 1,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPromotion_code());
            preStm.setFloat(2, dto.getValue());
            preStm.setString(3, dto.getContent());
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    
    public List<PromotionDTO> findAllPromotion() throws Exception{
        List<PromotionDTO> result = null;
        try{
            String sql = "select promotion_code , FORMAT(value,'N1') as value, content\n" +
                         "from tbl_promotion where active =1";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            String code = null;
            String valueStr = null;
            float value = 0;
            String content = null;
            PromotionDTO dto = null;
            result = new ArrayList<>();
            while(rs.next()){
                code = rs.getString("promotion_code");
                valueStr = rs.getString("value");
                value = Float.parseFloat(valueStr);
                content = rs.getString("content");
                dto = new PromotionDTO(code, content, value);
                result.add(dto);
            }
            
        }finally{
            closeConnection();
        }
        return  result;
    }
    
    public boolean delete(String id) throws Exception{
        boolean check  = false;
        try{
            String sql = "update tbl_promotion set active = 0 where promotion_code = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return  check;
    }
    
    public PromotionDTO findByPrimaryKey(String id) throws Exception{
        PromotionDTO dto = null;
        try{
            String sql = "select FORMAT(value,'N1') as value from tbl_promotion where promotion_code = ? and active = 1";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next()){
                String valueStr  = rs.getString("value");
                float value = Float.parseFloat(valueStr);
                dto = new PromotionDTO(id, value);
            }
        }finally{
            closeConnection();
        }
        return  dto;
    }
   
}
