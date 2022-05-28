/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Manager_View;
import view.PromotionView;

/**
 *
 * @author nguye
 */
public class ManageController {
    private Manager_View mv;

    public ManageController(Manager_View mv) {
        this.mv = mv;
        mv.jbtn1AddListener(new qlkm());
    }
    class qlkm implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PromotionView pv =new PromotionView();
            PromotionController pc = new PromotionController(pv);
            pv.setVisible(true);
            mv.setVisible(false);
        }
        
    }
}
