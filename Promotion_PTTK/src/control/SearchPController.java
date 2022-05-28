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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Promotion;
import model.Rank;
import model.Voucher;
import view.ListPView;
import view.PromotionView;
import view.SearchPView;

/**
 *
 * @author nguye
 */
public class SearchPController {
    private RankDAO rdao;
    private VoucherDAO vdao ;
    private PromotionDAO pdao;
    private SearchPView spv ;
    private List<Rank> lrank ;
    private List<Voucher> lvoucher ;
    private List<Promotion> listP;
    public SearchPController(SearchPView spv) {
        try {
            this.spv = spv;
            rdao =new RankDAO(MySQLConnect.getConnection());
            vdao =new VoucherDAO(MySQLConnect.getConnection());
            pdao =new PromotionDAO(MySQLConnect.getConnection());
            listP =new ArrayList<>();
            lrank=new ArrayList<>();
            lvoucher =new ArrayList<>();
            lrank=rdao.getAllRank();
            lvoucher = vdao.getAllVoucher();
            spv.loadIdVC(lvoucher);
            spv.loadIdRank(lrank);
            spv.jbtn1AddAction(new Searchp());
            spv.jbtn2AddAction(new Back());
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchPController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    class Searchp implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String tmp =spv.getElementCB1();
            String idvc = spv.getElementCB2();
            String month = spv.getMonth();
            String year = spv.getYear();
            if(tmp.equalsIgnoreCase("All")&& idvc.equals("All") && month.equalsIgnoreCase("All")&& year.equalsIgnoreCase("All")){
                listP = pdao.getAllPromotion();
            }else if(tmp.equalsIgnoreCase("All")==false && idvc.equals("All") && month.equalsIgnoreCase("All")&& year.equalsIgnoreCase("All")){
                int idrank=Integer.parseInt(tmp);
                listP=pdao.getPromotionByidRank(idrank);
            }else if(tmp.equalsIgnoreCase("All") && idvc.equals("All") && month.equalsIgnoreCase("All")==false&& year.equalsIgnoreCase("All")==false){
                listP=pdao.getPromotionByTime(month, year);
            }else if(tmp.equalsIgnoreCase("All")==false && idvc.equals("All") && month.equalsIgnoreCase("All")==false&& year.equalsIgnoreCase("All")==false){
                listP.clear();
                List<Promotion> pr =new ArrayList<>();
                List<Promotion> pt =new ArrayList<>();
                pr=pdao.getPromotionByidRank(Integer.parseInt(tmp));
                pt=pdao.getPromotionByTime(month, year);
                for(int i=0;i<pr.size();i++){
                    for(int j=0;j<pt.size();j++){
                        if(pr.get(i).getId()==pt.get(j).getId()){
                            listP.add(pr.get(i));
                        }
                    }
                }
                
            }else if(idvc.equals("All")==false && tmp.equalsIgnoreCase("All")){
                int idv = Integer.parseInt(idvc);
                listP = pdao.getPromotionByidVC(idv);
            }
            ListPView lv =new ListPView();
            ListPController lpc = new ListPController(lv, listP);
            lv.setVisible(true);
            spv.setVisible(false);
        }
        
    }
    class Back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PromotionView pv =new PromotionView();
            PromotionController pc = new PromotionController(pv);
            pv.setVisible(true);
            spv.setVisible(false);
        }
        
    }
    
}
 