/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Voucher;

/**
 *
 * @author nguye
 */
public class VoucherDAO {
    private Connection conn ;
    Statement statement;

    public VoucherDAO(Connection conn) {
        try {
            this.conn = conn;
            statement = this.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public List<Voucher> getAllVoucher(){
        String sql = "SELECT * FROM tbl_voucher";
        Voucher vc = new Voucher();
        List<Voucher> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                vc = new Voucher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(vc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public Voucher getVoucehrById(int id){
          Voucher vc =new Voucher();
        try {     
            String sql="Select * From tbl_voucher ";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {
                if(rs.getInt(1)== id){
                    vc = new Voucher(id, rs.getString(2) ,rs.getString(3),rs.getString(4));
                }
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          return vc;
     }
}
