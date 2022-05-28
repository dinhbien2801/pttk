/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import view.ChooseRankView;
import view.Manager_View;
import view.PromotionView;
import view.SearchPView;

/**
 *
 * @author nguye
 */
public class PromotionController {
    private PromotionView pv ;

    public PromotionController() {
    }

    public PromotionController(PromotionView pv) {
        this.pv = pv;
        pv.jbtn1AddListener(new addPromotion());
        pv.jbtn2AddListener(new ViewPromotion());
      
        pv.jbtn4AddListener(new back());
    }
     class addPromotion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ChooseRankView crv = new ChooseRankView();
            ChooseRankController crc = new ChooseRankController(crv);
            crv.setVisible(true);
            pv.setVisible(false);
        }
         
     }
     class ViewPromotion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SearchPView spv =new SearchPView();
            SearchPController  spc = new SearchPController(spv);
            spv.setVisible(true);
            pv.setVisible(false);
        }
         
     }
 
     class back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Manager_View mv = new Manager_View();
            ManageController mc =new ManageController(mv);
            mv.setVisible(true);
            pv.setVisible(false);
        }
         
     }
     
}
