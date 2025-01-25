package akillisehir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Rapor extends javax.swing.JFrame {

    private String raporBasligi;
    private String raporIcerigi;
    private String tarih;

    public Rapor(String raporBasligi, String raporIcerigi, String tarih) {
        this.raporBasligi = raporBasligi;
        this.raporIcerigi = raporIcerigi;
        this.tarih = tarih;

        // JFrame ayarları
        setTitle("Rapor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

            // Rapor başlığını ve içeriğini JLabel ile gösterme
        JLabel baslikLabel = new JLabel("Rapor Başlığı: " + raporBasligi, JLabel.CENTER);
        baslikLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(baslikLabel, BorderLayout.NORTH);

        JTextArea icerikArea = new JTextArea(10, 30);
        icerikArea.setText("Rapor İçeriği: " + raporIcerigi);
        icerikArea.setEditable(false);
        add(new JScrollPane(icerikArea), BorderLayout.CENTER);

        JLabel tarihLabel = new JLabel("Tarih: " + tarih, JLabel.CENTER);
        add(tarihLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Rapor oluşturma metodu (Örnek bir içerik dönebilir)
   
    // Rapor oluşturma metodu
    public static void raporOlustur() {
    try {
        // Trafik durumu verisini al
        TrafikDurumuAlgila trafikSorgulama = new TrafikDurumuAlgila();
        String trafikDurumu = trafikSorgulama.trafikDurumunuAlgila("Üniversite");

        // Enerji durumu verisini al
        EnerjiAnaliziYap enerjiSorgulama = new EnerjiAnaliziYap();
        String enerjiDurumu = enerjiSorgulama.enerjiAnaliziYap();

        // Su durumu verisini al
        SuAnalizYap suSorgulama = new SuAnalizYap();
        String suDurumu = suSorgulama.suRezervAnalizi();

        // Rapor içerik oluşturuluyor
        String raporIcerigi = "Trafik Durumu: " + trafikDurumu + "\n\n" +
                              "Enerji Durumu: " + enerjiDurumu + "\n\n" +
                              "Su Durumu: " + suDurumu;

        // Dinamik tarih almak için
        String tarih = java.time.LocalDate.now().toString();  // YYYY-MM-DD formatında tarih

        // Raporu oluştur ve göster
        new Rapor("Şehir Durumu Raporu", raporIcerigi, tarih);

    } catch (LowEnergyException ex) {
        // Eğer enerji durumu düşükse, kullanıcıya bir mesaj gösterilir
        JOptionPane.showMessageDialog(null, 
                "Enerji durumu düşük! Kaynağınızı kontrol edin.", 
                "Proaktif Uyarı", 
                JOptionPane.WARNING_MESSAGE);
    } catch (Exception ex) {
        // Genel hata yönetimi
        JOptionPane.showMessageDialog(null, 
                "Bir hata oluştu: " + ex.getMessage(), 
                "Hata", 
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
            java.util.logging.Logger.getLogger(Rapor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rapor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rapor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rapor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      // Rapor butonu ve GUI
        JFrame frame = new JFrame("Admin Paneli");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton raporButonu = new JButton("Rapor Oluştur");
        raporButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Rapor oluşturma metodunu çağır
                raporOlustur();
            }
        });
        frame.add(raporButonu);

        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}