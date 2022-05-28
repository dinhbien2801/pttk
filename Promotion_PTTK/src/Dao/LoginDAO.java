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
import java.util.logging.Level;
import java.util.logging.Logger;
import user_model.Customer;

/**
 *
 * @author nguye
 */
public class LoginDAO {
    private Connection conn ;
    Statement statement;

    public LoginDAO(Connection conn) {
        try {
            this.conn = conn;
            statement = this.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Customer getCustomer(String email , String pw){
        try {
            String sql="Select * From tbl_user ";
           ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString(4).equalsIgnoreCase(email) && rs.getString(3).equalsIgnoreCase(pw)){
                    Customer customer =new Customer(rs.getInt(1), rs.getString(2)
                            , pw, email, rs.getString(5), rs.getInt(6), rs.getInt(7));
                    return customer;
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
          return null;
    }
    public int checkCustomer(String email , String pw){
        int dem=0;
        try {
            String sql="Select * From tbl_user ";
           ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString(4).equalsIgnoreCase(email) && rs.getString(3).equalsIgnoreCase(pw)){
                    Customer customer =new Customer(rs.getInt(1), rs.getString(2)
                            , pw, email, rs.getString(5), rs.getInt(6), rs.getInt(7));
                    dem++;
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
          return dem;
    }
   
}
