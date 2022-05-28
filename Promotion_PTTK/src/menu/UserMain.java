/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.io.Serializable;
import user_controler.HomeController;
import user_controler.LoginController;
import user_model.Customer;
import user_view.Login;

/**
 *
 * @author nguye
 */
public class UserMain {
    public static void main(String[] args) {
        Login login =new Login();
        LoginController lgc = new LoginController(login);
        login.setVisible(true);
    }
  
}
