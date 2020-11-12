package tampilan;

import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import java.text.*;
import javax.swing.table.DefaultTableModel;

public class penjual extends javax.swing.JFrame {
    private Connection conn=new koneksi().GetConnection();
    private DefaultTableModel tableModel;

    public penjual() {
        initComponents();
        datatable();
        tampilpilih();
        kode();
        t_id.setEnabled(false);
    }
    
    protected void aktif(){
        b_simpan.setEnabled(true);
        t_id.setEnabled(true);;
        }
    
    protected void kosong(){
         t_id.setText("");
         t_namapenjual.setText("");
         t_namabarang.setText("");
         cb_barang.setSelectedIndex(0);
         t_alamat.setText("");
         t_telp.setText("");

     }
     
     protected void datatable(){
         Object[] Baris ={"ID","Penjual","ID Barang","Nama Barang","Tanggal","Alamat","No Telp"};
         tableModel = new DefaultTableModel (null, Baris);
         tbl_user.setModel(tableModel);
         String sql = "select * from penjual";
         try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
             String a = hasil.getString("id");
             String b = hasil.getString("nama");
             String c = hasil.getString("id_barang");
             String d = hasil.getString("nama_barang");
             String e = hasil.getString("tanggal");
             String f = hasil.getString("alamat");
             String g = hasil.getString("no_telp");
             
             String[] data={a,b,c,d,e,f,g};
             tableModel.addRow(data);
            }   
         }catch(Exception e){
         
         }
     }
     
     private void tampilpilih() {
        try {
            Connection c = koneksi.GetConnection();
            Statement s = c.createStatement();

            String sql = "SELECT id FROM barang WHERE jumlah !='0'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                cb_barang.addItem(r.getString("id"));
            }

            r.last();
            int jumlahdata = r.getRow();
            r.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     
     private void kode() {
        try {
            Connection c = koneksi.GetConnection();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM penjual ORDER by id desc";
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("id").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                t_id.setText("P" + Nol + AN);
            } else {
                t_id.setText("P0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
     
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        t_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t_namabarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t_telp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_namapenjual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_alamat = new javax.swing.JTextArea();
        b_simpan = new javax.swing.JButton();
        b_ubah = new javax.swing.JButton();
        b_hapus = new javax.swing.JButton();
        b_kembali = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_user = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        b_tgl = new com.toedter.calendar.JDateChooser();
        cb_barang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DATA PENJUAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Barang");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Penjual");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alamat Asal");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No Telp");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID Barang");

        t_alamat.setColumns(20);
        t_alamat.setRows(5);
        jScrollPane1.setViewportView(t_alamat);

        b_simpan.setText("SIMPAN");
        b_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_simpanActionPerformed(evt);
            }
        });

        b_ubah.setText("UBAH");
        b_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ubahActionPerformed(evt);
            }
        });

        b_hapus.setText("HAPUS");
        b_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_hapusActionPerformed(evt);
            }
        });

        b_kembali.setText("KEMBALI");
        b_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_kembaliActionPerformed(evt);
            }
        });

        tbl_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        tbl_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_userMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_user);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tanggal");

        b_tgl.setDateFormatString("dd-mm-yyyy");

        cb_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih ID Barang" }));
        cb_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_barangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(111, 111, 111)
                                .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t_namapenjual)
                                    .addComponent(t_namabarang)
                                    .addComponent(b_tgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(128, 128, 128)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_telp, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(b_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b_kembali))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_namapenjual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(t_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(b_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_simpan)
                    .addComponent(b_ubah)
                    .addComponent(b_hapus)
                    .addComponent(b_kembali))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_simpanActionPerformed
        String tgl = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tgl);
        String tanggal = String.valueOf(fm.format(b_tgl.getDate()));
        try{
            String id = t_id.getText();
            String nama = t_namapenjual.getText();
            String id_barang = cb_barang.getSelectedItem().toString();
            String nama_barang = t_namabarang.getText();
            
            String alamat = t_alamat.getText();
            String telp = t_telp.getText();        
            

            String sql="insert into penjual (id,nama,id_barang,nama_barang,tanggal,alamat,no_telp)"
            +"values"+"('"+id+"','"+nama+"','"+id_barang+"',"
            + "'"+nama_barang+"','"+tanggal+"','"+alamat+"','"+telp+"'  )";

            PreparedStatement stat=conn.prepareStatement(sql);
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data TERSIMPAN silahkan masukan data PENERIMA");

            kosong();
            datatable();
            kode();
            
            this.dispose();
            new penerima().setVisible(true);

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data GAGAL disimpan"+e);
        }
    }//GEN-LAST:event_b_simpanActionPerformed

    private void b_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ubahActionPerformed
        String tgl = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tgl);
        String tanggal = String.valueOf(fm.format(b_tgl.getDate()));
        try{
            String id = t_id.getText();
            String nama = t_namapenjual.getText();
            String id_barang = cb_barang.getSelectedItem().toString();
            String nama_barang = t_namabarang.getText();
            
            String alamat = t_alamat.getText();
            String telp = t_telp.getText();

            String sql="UPDATE penjual set nama='"+nama+"',id_barang='"+id_barang+"',"
            + "nama_barang='"+nama_barang+"',tanggal='"+tanggal+"',alamat='"+alamat+"',"
            + "no_telp='"+telp+"'  where id='"+id+"'";
            PreparedStatement stat=conn.prepareStatement(sql);
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data BERHASIL diubah");

            kosong();
            datatable();
            aktif();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data GAGAL diubah");
        }
    }//GEN-LAST:event_b_ubahActionPerformed

    private void b_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_hapusActionPerformed
        try{
            String sql="delete from penjual where id ='"+t_id.getText()+"' ";

            PreparedStatement stat=conn.prepareStatement(sql);
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data BERHASIL dihapus");

            kosong();
            datatable();
            aktif();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data GAGAL dihapus");
        }
    }//GEN-LAST:event_b_hapusActionPerformed

    private void b_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_kembaliActionPerformed
        this.dispose();
        new menu().setVisible(true);
    }//GEN-LAST:event_b_kembaliActionPerformed

    private void tbl_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_userMouseClicked
        b_simpan.setEnabled(false);
        b_ubah.setEnabled(true);
        b_hapus.setEnabled(true);
        t_id.setEnabled(false);
        int i = tbl_user.getSelectedRow();
        if (i == -1) {
            return;
        }
        String id = (String) tableModel.getValueAt(i, 0);
        t_id.setText(id);

        String nama = (String) tableModel.getValueAt(i, 1);
        t_namapenjual.setText(nama);

        String id_barang = (String) tableModel.getValueAt(i, 2);
        cb_barang.setSelectedItem(id_barang);

        String nama_barang = (String) tableModel.getValueAt(i, 3);
        t_namabarang.setText(nama_barang);
        
        //String tanggal = (String) model.getValueAt(i, 4);
        //ttanggal.setDate(tanggal);

        String alamat = (String) tableModel.getValueAt(i, 5);
        t_alamat.setText(alamat);

        String telp = (String) tableModel.getValueAt(i, 6);
        t_telp.setText(telp);

    }//GEN-LAST:event_tbl_userMouseClicked

    private void cb_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_barangActionPerformed
        if (cb_barang.getSelectedItem().equals("Pilih ID Barang")){
            t_namabarang.setText("");
        }else{
            try {
                Connection c = koneksi.GetConnection();
                Statement s = c.createStatement();

                String sql = "SELECT nama FROM barang WHERE id ='" + cb_barang.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                    t_namabarang.setText(r.getString("nama"));
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_cb_barangActionPerformed

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
            java.util.logging.Logger.getLogger(penjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penjual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_hapus;
    private javax.swing.JButton b_kembali;
    private javax.swing.JButton b_simpan;
    private com.toedter.calendar.JDateChooser b_tgl;
    private javax.swing.JButton b_ubah;
    private javax.swing.JComboBox<String> cb_barang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea t_alamat;
    private javax.swing.JTextField t_id;
    private javax.swing.JTextField t_namabarang;
    private javax.swing.JTextField t_namapenjual;
    private javax.swing.JTextField t_telp;
    private javax.swing.JTable tbl_user;
    // End of variables declaration//GEN-END:variables
}
