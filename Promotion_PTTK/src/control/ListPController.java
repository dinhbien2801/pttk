/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Dao.MySQLConnect;
import Dao.PromotionDAO;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Promotion;
import view.FixPView;
import view.ListPView;
import view.SearchPView;

/**
 *
 * @author nguye
 */
public class ListPController {

    private ListPView lv;
    private List<Promotion> listp;
    private PromotionDAO pdao;
    private Promotion p;

    public ListPController(ListPView lv, List<Promotion> listp) {
        try {
            this.lv = lv;
            this.listp = listp;

            pdao = new PromotionDAO(MySQLConnect.getConnection());
            lv.addTable(listp);
            lv.jbtn1actionlistener(new Back());
            lv.jbtn2actionlistener(new DeleteP());
            lv.jbtn3actionlistener(new Edit());
        } catch (SQLException ex) {
            Logger.getLogger(ListPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class Edit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int kt = lv.ktr();
            if (kt == 1) {
                p = new Promotion();
                p = lv.getP();
                FixPView fv = new FixPView();
                FixPController fpc = new FixPController(fv, p, listp);
                fv.setVisible(true);
                lv.setVisible(false);
            } else {
                lv.dialogFix();
            }
        }

    }

    class DeleteP implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int kt = lv.ktr();
            if (kt == 0) {
                lv.dialogDelete();
            } else {
                int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete", "Delete", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    int dem=0;
                    List<Integer> listID = new ArrayList<>();
                    listID = lv.getidDelete();
                    for (int i = 0; i < listID.size(); i++) {
                         int res= pdao.deleteP(listID.get(i));
                        System.out.println("Xoa ban ghi id = " + listID.get(i));
                        dem+=res;
                    } 
                    if(dem==listID.size()){
                        JOptionPane.showMessageDialog(null,"Delete successfully!");
                         lv.removeP();
                    }
                   
                }
            }
        }
    }

    class Back implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SearchPView spv = new SearchPView();
            SearchPController spc = new SearchPController(spv);
            spv.setVisible(true);
            lv.setVisible(false);
        }
    }
}
