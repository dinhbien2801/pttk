/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Dao.MySQLConnect;
import Dao.VoucherDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Rank;
import model.Voucher;
import view.AddPromotionView;
import view.ChooseVoucherView;

/**
 *
 * @author nguye
 */
public class ChooseVoucherController {
     private Rank rank;
    private ChooseVoucherView cvv ;
    private VoucherDAO vdao;
    private  List<Voucher> AllVc;
    private  List<Voucher> listVc;

    public ChooseVoucherController(ChooseVoucherView cvv) {
        try {
            this.cvv = cvv;
            vdao = new VoucherDAO(MySQLConnect.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(ChooseVoucherController.class.getName()).log(Level.SEVERE, null, ex);
        }
           AllVc = new ArrayList<>();
           AllVc=vdao.getAllVoucher();
           cvv.tableAddrows(AllVc);
           cvv.jbtn1AddListen(new back());
           cvv.jbtn2AddListen(new reset());
           cvv.jbtn3AddListen(new next());
    }

    public ChooseVoucherController(Rank rank, ChooseVoucherView cvv) {
        this.rank = rank;
        this.cvv = cvv;
        try {
            vdao = new VoucherDAO(MySQLConnect.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(ChooseVoucherController.class.getName()).log(Level.SEVERE, null, ex);
        }
           AllVc = new ArrayList<>();
           AllVc=vdao.getAllVoucher();
           cvv.tableAddrows(AllVc);
           cvv.jbtn1AddListen(new back());
           cvv.jbtn2AddListen(new reset());
           cvv.jbtn3AddListen(new next());
    }
    
    class  back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
        
    }
    class  reset implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           cvv.clearSelectTable();
        }
        
    }
    class  next implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           listVc = new ArrayList<>();
           listVc = cvv.getListVC();
            AddPromotionView apv =new AddPromotionView();
            AddPromotionController apc = new AddPromotionController(rank, apv, listVc);
            apv.setVisible(true);
            cvv.setVisible(false);
        }
        
    }
    
}
