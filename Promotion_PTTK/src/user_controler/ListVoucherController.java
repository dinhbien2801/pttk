/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_controler;

import Dao.MySQLConnect;
import Dao.PromotionDAO;
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
import model.Voucher;
import user_model.Customer;
import user_view.Home;
import user_view.ListMyVoucherView;

/**
 *
 * @author nguye
 */
public class ListVoucherController {
    private ListMyVoucherView lmv ;
    private Customer customer ;
    private VoucherDAO vdao;
    private PromotionDAO pdao;
    private List<Promotion> listp ;

//    public ListVoucherController(ListMyVoucherView lmv, Customer customer) {
//        try {
//            this.lmv = lmv;
//            this.customer = customer;
//            this.vdao = vdao;
//            this.pdao = pdao;
//            vdao = new VoucherDAO(MySQLConnect.getConnection());
//            pdao = new PromotionDAO(MySQLConnect.getConnection());
//            lmv.getUser(customer.getUserName());
//            lmv.jbtn1Addlistener(new listVC());
//        } catch (SQLException ex) {
//            Logger.getLogger(ListVoucherController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public ListVoucherController(ListMyVoucherView lmv, Customer customer, List<Promotion> listp) {
        try {
            this.lmv = lmv;
            this.customer = customer;
            this.listp = listp;
            this.vdao = vdao;
            this.pdao = pdao;
            System.out.println(listp.size());
            vdao = new VoucherDAO(MySQLConnect.getConnection());
            pdao = new PromotionDAO(MySQLConnect.getConnection());
            lmv.getUser(customer.getUserName());
            for(int i=0;i<listp.size();i++){
                Voucher vc =new Voucher();
                vc= vdao.getVoucehrById(listp.get(i).getIdVoucher());
                String ed = listp.get(i).getEndDay();
                String sd = listp.get(i).getStartDay();
                lmv.addTable(vc, sd, ed);
            }
            lmv.jbtn1Addlistener(new Back());
        } catch (SQLException ex) {
            Logger.getLogger(ListVoucherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    class Back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                 Home home = new Home();
                 HomeController hc = new HomeController(home, customer);
                 home.setVisible(true);
                 lmv.setVisible(false);
             
        }
        
    }
}
