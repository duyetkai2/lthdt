/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.chuong03.dohoa.frames;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import lthdt.chuong03.coffeelogic.CoffeeShop;
import lthdt.chuong03.coffeelogic.Manager;

/**
 *
 * @author Admin
 */
public class MyCoffee extends javax.swing.JInternalFrame {
         Manager[] managers;
    /**
     * Creates new form MyCoffee
     */
    public MyCoffee() throws ParseException {
        
        initComponents();
          SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        CoffeeShop[]a = new CoffeeShop[]{new CoffeeShop("Kha coffee ","2 Nguyen Hue"),
                                            new CoffeeShop("tset caphe","176 trna phu")};
        managers= new Manager[]{
                    new Manager(a,1000,"le thi A",0,df.parse("12-12-1999")),
                    new Manager(new CoffeeShop[]{
                                                  new CoffeeShop("haong ha ","12nguyen hue")},
                            2000,"nguyen van b",1,df.parse("12-12-2000"))
        };
        for(int i =0 ;i < managers.length ;i++){
            cbQuanLy.addItem(managers[i].getHoten());
        
        }
        DefaultTableModel model = (DefaultTableModel) tblCoffeeShop.getModel();
        model.setRowCount(0);
        CoffeeShop[]shops=managers[0].getShops();
        for(int i =0 ;i<shops.length;i++){
            model.insertRow(model.getRowCount(),
                    new Object[]{model.getRowCount()+1,
                                shops[i].getName(),
                                shops[i].getAddress()});
        
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
        cbQuanLy = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCoffeeShop = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Danh sách các quán cà phê");

        jLabel1.setText("Họ tên người quản lí");

        cbQuanLy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbQuanLyItemStateChanged(evt);
            }
        });

        tblCoffeeShop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên quán", "Địa chỉ"
            }
        ));
        jScrollPane1.setViewportView(tblCoffeeShop);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbQuanLy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbQuanLyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbQuanLyItemStateChanged
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblCoffeeShop.getModel();
        model.setRowCount(0);
        int index = cbQuanLy.getSelectedIndex();
        CoffeeShop[]shops=managers[index].getShops();
        for(int i =0 ;i<shops.length;i++){
            model.insertRow(model.getRowCount(),
                    new Object[]{model.getRowCount()+1,
                                shops[i].getName(),
                                shops[i].getAddress()});
        
        }
    }//GEN-LAST:event_cbQuanLyItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbQuanLy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCoffeeShop;
    // End of variables declaration//GEN-END:variables
}
