/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_controler;

import Dao.MySQLConnect;
import Dao.PromotionDAO;
import Dao.RankDAO;
import Dao.VoucherDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Promotion;
import user_model.Customer;
import user_view.Home;
import user_view.ListMyVoucherView;
import user_view.Login;

/**
 *
 * @author nguye
 */
public class HomeController {

    private Customer customer;
    private Home hv;
    private VoucherDAO vdao;
    private PromotionDAO pdao;
    
    public HomeController(Home hv, Customer customer) {
        try {
            this.hv = hv;
            this.customer = customer;
            this.vdao = vdao;
            this.pdao = pdao;
            vdao = new VoucherDAO(MySQLConnect.getConnection());
            pdao = new PromotionDAO(MySQLConnect.getConnection());
            hv.getUser(customer.getUserName());
            hv.jbtn1Addlistener(new viewMyVoucher());
            hv.jbtn2Addlistener(new Logout());
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    class viewMyVoucher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           int rankid = customer.getRankid();
            List<Promotion> listp =new ArrayList<>();
            listp = pdao.getPromotionByidRank(rankid);
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date = myDateObj.format(myFormatObj);
            System.out.println("hom nay: "+ date);
              List<Promotion> listp2 =new ArrayList<>();
              
            for(int i=0;i<listp.size();i++){
                String ed = listp.get(i).getEndDay();
                System.out.println(ed);
                if(date.substring(6).compareToIgnoreCase(ed.substring(6))==0){
                    if(date.substring(3,5).compareToIgnoreCase(ed.substring(3,5))==0){
                        if(date.substring(0,2).compareToIgnoreCase(ed.substring(0,2))<=0){
                            listp2.add(listp.get(i));
                        }
                    }else if(date.substring(3,5).compareToIgnoreCase(ed.substring(3,5))<0){
                        listp2.add(listp.get(i));
                    }
                }else if(date.substring(6).compareToIgnoreCase(ed.substring(6))<0){
                    listp2.add(listp.get(i));
                }
                 
            }
            System.out.println(listp2.size());
            ListMyVoucherView lmv =new ListMyVoucherView();
            ListVoucherController lvc = new ListVoucherController(lmv, customer, listp2);
            lmv.setVisible(true);
            hv.setVisible(false);
          
        }
    
    }
     class Logout implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                 Login login = new Login();
                 LoginController lgc = new LoginController(login);
                 login.setVisible(true);
                 hv.setVisible(false);
             
        }
        
    }
    
}
