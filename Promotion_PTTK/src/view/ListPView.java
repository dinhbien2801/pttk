/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Promotion;
import model.Rank;

/**
 *
 * @author nguye
 */
public class ListPView extends javax.swing.JFrame {

    /**
     * Creates new form ListPView
     */
     private DefaultTableModel tm ;
    public ListPView() {
        initComponents();
         String[] c ={"ID","IDRank","IDVoucher", "Start_Day" , "End_Day","Creat_Time"};
        tm=new DefaultTableModel(c,0);
        jTable1.setModel(tm);
    }
    public void addTable(List<Promotion> listp){
         tm.setRowCount(0);
        for(int i = 0; i < listp.size(); i++){
            Promotion tmp = listp.get(i);
            Object[] modelRow = new Object[6];
            modelRow[0] = tmp.getId();
            modelRow[1] = tmp.getIdRank();
            modelRow[2] = tmp.getIdVoucher();
            modelRow[3] = tmp.getStartDay();      
            modelRow[4] = tmp.getEndDay();      
            modelRow[5] = tmp.getCreatedTime();   
            tm.addRow(modelRow);
        }
        jTable1.setModel(tm);
    }
    public void jbtn1actionlistener(ActionListener a){
        jButton1.addActionListener(a);
    }
    public void jbtn2actionlistener(ActionListener a){
        jButton2.addActionListener(a);
    }
    public void jbtn3actionlistener(ActionListener a){
        jButton3.addActionListener(a);
    }
    public void dialogFix(){
        JOptionPane.showMessageDialog(rootPane,"chọn duy nhất 1 Promotion để sửa");
    }
    public void dialogDelete(){
        JOptionPane.showMessageDialog(rootPane,"chọn ít nhất 1 Promotion để xóa");
    }
    public int ktr(){
        int[] a= jTable1.getSelectedRows();
        return a.length;
    }
    
    
    public Promotion getP(){
        int i =jTable1.getSelectedRow();
        int id =Integer.parseInt(tm.getValueAt(i, 0).toString());
        int idRank =Integer.parseInt(tm.getValueAt(i, 1).toString());
        int idVoucher =Integer.parseInt(tm.getValueAt(i, 2).toString());
        String stday =tm.getValueAt(i, 3).toString();
       String endDay =tm.getValueAt(i, 4).toString();
       String createTime =tm.getValueAt(i, 5).toString();
       Promotion p =new Promotion(id, idRank, idVoucher, stday, endDay, createTime);
       return p;
    }
    public List<Integer> getidDelete(){
        List<Integer> list = new ArrayList<>();
        int[] a= jTable1.getSelectedRows();
        for(int i=0;i<a.length;i++){
            int id = Integer.parseInt(tm.getValueAt(a[i],0).toString());
            list.add(id);
        }
        return list;
    }
   
    
    public void removeP(){
        int[] a= jTable1.getSelectedRows();
        for(int i=a.length-1;i>=0;i--){
            tm.removeRow(a[i]); 
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("List Promotion");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Back");

        jButton2.setText("Delete");

        jButton3.setText("Fix");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(322, 322, 322))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addGap(170, 170, 170)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
