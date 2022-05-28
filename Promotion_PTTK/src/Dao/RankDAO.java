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
import model.Rank;

/**
 *
 * @author nguye
 */
public class RankDAO {
    private Connection con ;
    Statement statement;
    private PreparedStatement ps ;
    public RankDAO() {
    }

    public RankDAO(Connection con) {
        try {
            this.con = con;
            statement = this.con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public List<Rank> getAllRank(){
        String sql = "SELECT * FROM tbl_rank";
        Rank rank = new Rank();
        List<Rank> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                rank = new Rank(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                list.add(rank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     
     public Rank getRankById(int id){
         Rank rank =new Rank();
        try {
            String sql="Select * From tbl_rank ";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {
                if(rs.getInt(1)== id){
                     rank = new Rank(id, rs.getString(2) ,rs.getInt(3),rs.getInt(4));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rank;
     }
}
