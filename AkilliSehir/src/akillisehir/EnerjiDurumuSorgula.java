package akillisehir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnerjiDurumuSorgula extends javax.swing.JFrame implements Sorgulama {

    private EnerjiAnaliziYap enerjiAnaliziYap; // Enerji analizi yapan sınıfın bir nesnesi

    // Constructor: Enerji Durumu Sorgulama ekranını oluşturuyor
 public EnerjiDurumuSorgula() {

    setTitle("Enerji Durumu Sorgula");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    // Üst başlık paneli
    JPanel baslikPaneli = new JPanel();
    JLabel baslik = new JLabel("Enerji Durumu Sorgulama");
    baslik.setFont(new Font("Arial", Font.BOLD, 18));
    baslik.setHorizontalAlignment(SwingConstants.CENTER);
    baslikPaneli.add(baslik);
    add(baslikPaneli, BorderLayout.NORTH);

    // Orta içerik paneli
    JPanel icerikPaneli = new JPanel();
    icerikPaneli.setLayout(new GridLayout(2, 1, 10, 10));

    JLabel mesajLabel = new JLabel("Enerji durumunu sorgulamak için aşağıdaki butona tıklayın.");
    mesajLabel.setHorizontalAlignment(SwingConstants.CENTER);
    icerikPaneli.add(mesajLabel);

    // Buton paneli
    JPanel butonPaneli = new JPanel();
    butonPaneli.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

    JButton sorgulaButon = new JButton("Enerji Durumunu Sorgula");
    sorgulaButon.setFont(new Font("Arial", Font.PLAIN, 14));
    sorgulaButon.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sorgula();
        }
    });

    JButton geriButon = new JButton("Geri");
    geriButon.setFont(new Font("Arial", Font.PLAIN, 14));
    geriButon.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AdminPaneli();
        }
    });

    butonPaneli.add(sorgulaButon);
    butonPaneli.add(geriButon);
    icerikPaneli.add(butonPaneli);

    add(icerikPaneli, BorderLayout.CENTER);

    // Enerji analizi nesnesi
    enerjiAnaliziYap = new EnerjiAnaliziYap();

    setVisible(true);
}

    @Override
public void sorgula() {
        try {
            // Enerji durumu verisini alıyoruz
            String enerjiDurumu = enerjiAnaliziYap.enerjiAnaliziYap();

            // Eğer enerji durumu düşükse, proaktif bir uyarı gösteriyoruz
            if (enerjiDurumu.contains("Düşük")) {
                JOptionPane.showMessageDialog(this, 
                        "Uyarı: Enerji seviyesi düşük! Kaynağınızı kontrol edin.", 
                        "Proaktif Uyarı", 
                        JOptionPane.WARNING_MESSAGE);
            }
            // Durumu ekranda gösteriyoruz
            JOptionPane.showMessageDialog(this, "Enerji durumu: " + enerjiDurumu, "Enerji Durumu", JOptionPane.INFORMATION_MESSAGE);
        } catch (LowEnergyException ex) {
            // Eğer düşük enerji exception'ı fırlatılırsa, kullanıcıya uyarı mesajı veriyoruz
            JOptionPane.showMessageDialog(this, 
                    "Uyarı: " + ex.getMessage(), 
                    "Proaktif Uyarı", 
                    JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnerjiDurumuSorgula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new EnerjiDurumuSorgula();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
