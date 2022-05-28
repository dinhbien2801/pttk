/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Dao.MySQLConnect;
import Dao.PromotionDAO;
import Dao.RankDAO;
import Dao.VoucherDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Promotion;
import model.Voucher;
import view.FixPView;
import view.ListPView;
import view.SearchPView;

/**
 *
 * @author nguye
 */
public class FixPController {
    private FixPView fv ;
    private Promotion p;
    private PromotionDAO pdao;
    private RankDAO rdao ;
    private VoucherDAO vdao ;
    private List<Promotion> list;

    public FixPController(FixPView fv,Promotion p,List<Promotion> list) {
        try {
            this.fv = fv;
            this.p = p;
            this.list = list;
            pdao = new PromotionDAO(MySQLConnect.getConnection());
            rdao = new RankDAO(MySQLConnect.getConnection());
            vdao = new VoucherDAO(MySQLConnect.getConnection());
            fv.setRank((rdao.getRankById(p.getIdRank()).toString()));
            fv.setVoucher(vdao.getVoucehrById(p.getIdVoucher()).toString());
            fv.setIDP(p.getId());
            fv.setStday(p.getStartDay());
            fv.setEndDay(p.getEndDay());
            fv.jbtn1actionlistener(new Back());
            fv.jbtn2actionlistener(new Save());
        } catch (SQLException ex) {
            Logger.getLogger(FixPController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  
    class Back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
//            ListPView lpv = new ListPView();
//            ListPController lc =new ListPController(lpv, list);
//            lpv.setVisible(true);
//            fv.setVisible(false);
              SearchPView spv = new SearchPView();
              SearchPController spc = new SearchPController(spv);
              spv.setVisible(true);
              fv.setVisible(false );
        }
        
    }
    class Save implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            int id = p.getId();
            int idRank = p.getIdRank();
            int idVC =p.getIdVoucher();
            String dayST = fv.getSTDay();
            String dayEnd = fv.getEndDay();         
            Promotion p =new Promotion(id, idRank, idVC,dayST, dayEnd, formattedDate);
            int res = pdao.updateP(p);
            if(res==1){
                fv.Respond();
            }
            else{
                fv.Respond_fault();
            }
        }
        
    }
    
}
