/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Promotion;
import model.Rank;

/**
 *
 * @author nguye
 */
public class PromotionDAO {

    private Connection conn;
    private Statement statement;
    private PreparedStatement ps;

    public PromotionDAO(Connection conn) {
        try {
            this.conn = conn;
           statement= this.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Save(Promotion p) {
        String sql = "INSERT INTO tbl_km(idRank , idVoucher , startDay , endDay , CreatedTime ) values (? , ? , ? , ? , ? )";
        int res = 0;
        try {
            this.ps = this.conn.prepareStatement(sql);
            ps.setInt(1, p.getIdRank());
            ps.setInt(2, p.getIdVoucher());
            ps.setString(3, p.getStartDay());
            ps.setString(4, p.getEndDay());
            ps.setString(5, p.getCreatedTime());
            res = ps.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Promotion> getAllPromotion() {
        String sql = "SELECT * FROM tbl_km";
        Promotion p = new Promotion();
        List<Promotion> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                p = new Promotion(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Promotion> getPromotionByidRank(int idrank) {
        String sql = "SELECT * FROM tbl_km";
        Promotion p = new Promotion();
        List<Promotion> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int idr = rs.getInt(2);
                if (idr == idrank) {
                    p = new Promotion(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Promotion> getPromotionByidVC(int idVC) {
        String sql = "SELECT * FROM tbl_km";
        Promotion p = new Promotion();
        List<Promotion> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int idv = rs.getInt(3);
                if (idv == idVC) {
                    p = new Promotion(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
   
    public List<Promotion> getPromotionByTime(String month, String year) {
        String sql = "SELECT * FROM tbl_km";
        Promotion p = new Promotion();
        List<Promotion> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String stday= rs.getString(4);
                String endday = rs.getString(5);
                String thag = stday.substring(3,5);
                String nam = stday.substring(6);
                String thag2 = endday.substring(3,5);
                String nam2 = endday.substring(6);
//                System.out.println(thag+"  "+ nam);
                if ((thag.equals(month) && nam.equals(year))||(thag2.equals(month) && nam2.equals(year))) {
                    p = new Promotion(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
     public int deleteP(int id){
         String sql="Delete From tbl_km where id= ?";
            int res=0;
        try {
            this.ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            res=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
     
     public int updateP(Promotion promotion){
           String sql = "UPDATE tbl_km SET "
                    + "idRank = ?, "
                    + "idVoucher = ?, "
                    + "startDay = ?, "
                    + "endDay = ?, "
                    + "CreatedTime = ? "                  
                    + "WHERE id = ?";
            int res=0;
        try {
            this.ps = this.conn.prepareStatement(sql);
            ps.setInt(1, promotion.getIdRank());
            ps.setInt(2, promotion.getIdVoucher());
            ps.setString(3, promotion.getStartDay());
            ps.setString(4, promotion.getEndDay());
            ps.setString(5, promotion.getCreatedTime());
            ps.setInt(6, promotion.getId());
            
            res= ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PromotionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res ;
     }

}
