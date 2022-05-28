/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_controler;

import Dao.LoginDAO;
import Dao.MySQLConnect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import user_model.Customer;
import user_view.Home;
import user_view.Login;

/**
 *
 * @author nguye
 */
public class LoginController {
    private Login login ;
    private Customer  customer;
    private LoginDAO ldao;

    public LoginController(Login login) {
        try {
            this.login = login;
            customer = new Customer();
            this.ldao = ldao;
            ldao= new LoginDAO(MySQLConnect.getConnection());
            login.jbtn1Addlistener(new lg());
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    class lg implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             String email = login.getEmail();
             String pwd = login.getPw();
             int kt =ldao.checkCustomer(email, pwd);
             if(kt==1){
                 customer = ldao.getCustomer(email, pwd);
                 Home home = new Home();
                 HomeController hc = new HomeController(home, customer);
                 home.setVisible(true);
                 login.setVisible(false);
             }else{
                 login.faultLogin();
             }
        }
        
    }
}
