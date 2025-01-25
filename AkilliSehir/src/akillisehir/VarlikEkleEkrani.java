package akillisehir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VarlikEkleEkrani extends javax.swing.JFrame {
   public VarlikEkleEkrani() {
 setTitle("Varlık Ekle");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Ekranı ortalayalım
        setLayout(new GridBagLayout()); // Daha esnek ve düzenli bir layout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Bileşenler arasına boşluk

        // ID etiket ve alan
        JLabel idLabel = new JLabel("ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Bir sütun boyunca yayılmasın
        gbc.anchor = GridBagConstraints.WEST; // Etiketi sola hizala
        add(idLabel, gbc);

        JTextField idField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Alanı 2 sütun boyunca yaydır
        gbc.fill = GridBagConstraints.HORIZONTAL; // Alanı yatayda genişlet
        add(idField, gbc);

        // İsim etiket ve alan
        JLabel isimLabel = new JLabel("İsim:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Bir sütun boyunca yayılmasın
        gbc.fill = GridBagConstraints.NONE; // Etiketin sadece gerektiği kadar yer kaplamasını sağla
        gbc.anchor = GridBagConstraints.WEST; // Etiketi sola hizala
        add(isimLabel, gbc);

        JTextField isimField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Alanı 2 sütun boyunca yaydır
        gbc.fill = GridBagConstraints.HORIZONTAL; // Alanı yatayda genişlet
        add(isimField, gbc);

        // Ekleme butonu
        JButton ekleButon = new JButton("Ekle");
        ekleButon.setBackground(new Color(0, 153, 0)); // Yeşil renk
        ekleButon.setForeground(Color.WHITE); // Yazı rengini beyaz yap
        ekleButon.setFocusPainted(false); // Butonun odak çerçevesini kaldır
        ekleButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String isim = isimField.getText();

                    // Yeni varlık ekle
                    VarlikEkle varlik = new VarlikEkle(id, isim);
                    varlik.ekle();

                    // Başarı mesajı
                    JOptionPane.showMessageDialog(null, "Varlık başarıyla eklendi!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Geçersiz ID! Lütfen sayısal bir değer girin.");
                }
            }
        });

        // Geri butonu
        JButton geriButon = new JButton("Geri");
        geriButon.setBackground(new Color(255, 69, 0)); // Kırmızı renk
        geriButon.setForeground(Color.WHITE); // Yazı rengini beyaz yap
        geriButon.setFocusPainted(false); // Butonun odak çerçevesini kaldır
        geriButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Bu ekranı kapat
                new AdminPaneli(); // Admin paneline yönlendir
            }
        });

        // Geri butonunu ekleyelim
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3; // Butonun tüm genişliği kaplamasını sağladık
        add(geriButon, gbc);

        // Ekle butonunu ekleyelim
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3; // Butonun tüm genişliği kaplamasını sağladık
        add(ekleButon, gbc);

        setVisible(true); // Ekranı göster
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VarlikEkleEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VarlikEkleEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VarlikEkleEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VarlikEkleEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
           new VarlikEkleEkrani(); // Varlık Ekle ekranını başlat
            }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
