/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Dao.MySQLConnect;
import Dao.RankDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Rank;
import view.AddPromotionView;
import view.ChooseRankView;
import view.PromotionView;

/**
 *
 * @author nguye
 */
public class ChooseRankController {

    private ChooseRankView crv;
    private RankDAO rdao;
    private List<Rank> list;
    private Rank rank;

    public ChooseRankController() {
    }


    public ChooseRankController(ChooseRankView crv) {
        try {
            this.crv = crv;
            list = new ArrayList<>();
            rdao = new RankDAO(MySQLConnect.getConnection());
            list = rdao.getAllRank();
            crv.tableAddRow(list);
        } catch (SQLException ex) {
            Logger.getLogger(ChooseRankController.class.getName()).log(Level.SEVERE, null, ex);
        }

        crv.jbtn2AddListener(new addPromotion());
        crv.jbtn1AddListener(new back());
    }

    class addPromotion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int kt = crv.ktr();
            if (kt == 1) {
                rank = new Rank();
                rank = crv.getRank();
                AddPromotionView apv = new AddPromotionView();
                AddPromotionController apc = new AddPromotionController(rank, apv);
                apv.setVisible(true);
                crv.setVisible(false);
            }
            else{
                crv.dialog();
            }
        }
    }

    class back implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PromotionView pv = new PromotionView();
            PromotionController pc = new PromotionController(pv);
            pv.setVisible(true);
            crv.setVisible(false);
        }

    }
}
