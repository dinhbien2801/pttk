 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nguye
 */
public class MySQLConnect {
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/" + "pttk_km" +"?zeroDateTimeBehavior=convertToNull";
        Connection con = DriverManager.getConnection(url, "root", "1234");
        return con;
    }
}
