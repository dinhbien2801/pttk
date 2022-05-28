/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Dao.MySQLConnect;
import Dao.PromotionDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Promotion;
import model.Rank;
import model.Voucher;
import view.AddPromotionView;
import view.ChooseRankView;
import view.ChooseVoucherView;

/**
 *
 * @author nguye
 */
public class AddPromotionController {

    private Rank rank;
    private AddPromotionView apv;
    private PromotionDAO pdao;
    private List<Voucher> listvc ;

    public AddPromotionController(Rank rank, AddPromotionView apv, PromotionDAO pdao) {
        this.rank = rank;
        this.apv = apv;
        this.pdao = pdao;
    }

    public AddPromotionController(Rank rank, AddPromotionView apv) {
        this.rank = rank;
        this.apv = apv;
        apv.setRank(rank);
        apv.jbtn1Addlistener(new ChooseVoucher());
        apv.jbtn2Addlistener(new back());
        apv.jbtn3Addlistener(new save());
    }
    
    public AddPromotionController(Rank rank, AddPromotionView apv, List<Voucher> listvc) {
        try {
            this.rank = rank;
            this.apv = apv;
            this.listvc = listvc;
            pdao = new PromotionDAO(MySQLConnect.getConnection());
            apv.setRank(rank);
            apv.jbtn1Addlistener(new ChooseVoucher());
            apv.jbtn2Addlistener(new back());
            apv.jbtn3Addlistener(new save());
            apv.jbtn4Addlistener(new deleteVC());
            apv.jListAddVoucher(listvc);
        } catch (SQLException ex) {
            Logger.getLogger(AddPromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     class back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ChooseRankView crv = new ChooseRankView();
            ChooseRankController crc = new ChooseRankController(crv);
            crv.setVisible(true);
            apv.setVisible(false);
        }    
     }
     class deleteVC implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            apv.jListDeleteVoucher(listvc);
        }    
     }
    
    class ChooseVoucher implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ChooseVoucherView cvv = new ChooseVoucherView();
            ChooseVoucherController cvc = new ChooseVoucherController(rank, cvv);
            cvv.setVisible(true);
            apv.setVisible(false);
        }

    }

    class save implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             LocalDateTime myDateObj = LocalDateTime.now();
             DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
             String formattedDate = myDateObj.format(myFormatObj);
              int dem=0;
             for(int i=0;i<listvc.size();i++){
                 int idRank = rank.getId();
                 int idVoucher = listvc.get(i).getId();
                 String stday = apv.getStday();
                 String EndDay = apv.getEndDay();
                 Promotion ptmp =new Promotion(idRank, idVoucher, stday, EndDay, formattedDate);
                 int res = pdao.Save(ptmp);
                 if(res==1){
                     System.out.println("Lưu thành công!!");
                     dem++;
                 }else{
                    apv. Respond_fault(listvc.get(i).getId());
                     System.out.println("Lưu thất bại!!");
                 }
                 if(dem==listvc.size())apv.Respond();
             }
        }

    }
}
