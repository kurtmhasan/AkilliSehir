package akillisehir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuRezervDurumuSorgula extends javax.swing.JFrame implements Sorgulama {

    private SuAnalizYap suAnaliziYap; // Su analizi yapan sınıfın bir nesnesi

    // Constructor: Su Rezerv Durumu Sorgulama ekranını oluşturuyor
    public SuRezervDurumuSorgula() {
        // Ekran başlığı ve boyutlandırma
        setTitle("Su Rezerv Durumu Sorgula");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Admin panelini ekranın ortasında açma
         setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Su analizi nesnesini oluşturuyoruz
        suAnaliziYap = new SuAnalizYap();

        // Mesaj için JLabel oluşturma
        JLabel mesajLabel = new JLabel("Su rezerv durumu sorgulama ekranı!");
        add(mesajLabel);

        // Su rezerv durumu verilerini sorgulamak için buton
        JButton sorgulaButon = new JButton("Su Rezerv Durumunu Sorgula");
        sorgulaButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Su rezerv durumu verisini suAnaliziYap sınıfından alıyoruz
                sorgula(); // Bu metodu çağırıyoruz
            }
        });
        add(sorgulaButon);

        // Geri butonu, admin paneline dönmeyi sağlar
        JButton geriButon = new JButton("Geri");
        geriButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Bu ekranı kapatır ve AdminPaneli ekranını açar
                dispose(); // Bu ekranı kapat
                new AdminPaneli(); // Admin paneline geri dön
            }
        });
        add(geriButon);

        // Ekranı görünür hale getirme
        setVisible(true);
    }

    // Sorgulama işlemi için metod (Sorgulama interface'inden override edilmiş metod)
    @Override
       public void sorgula() {
        try {
            String suDurumu = suAnaliziYap.suRezervAnalizi(); // Bu metod su rezerv durumu verisini alır
            // Veri sorgulandıktan sonra kullanıcıya göstermek için mesaj
            JOptionPane.showMessageDialog(null, "Su rezerv durumu: " + suDurumu);
        } catch (SuKesintisiException e) {
            // Su seviyesi %10'un altına düştü, kullanıcıya hata mesajı göster
            JOptionPane.showMessageDialog(null, e.getMessage(), "Su Kesintisi Uyarısı", JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(SuRezervDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuRezervDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuRezervDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuRezervDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

      /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SuRezervDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuRezervDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuRezervDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuRezervDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new SuRezervDurumuSorgula();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
