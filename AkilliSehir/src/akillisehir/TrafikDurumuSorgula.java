package akillisehir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafikDurumuSorgula extends JFrame implements Sorgulama {

    public TrafikDurumuSorgula() {
        // JFrame ayarları
        setTitle("Trafik Durumu Sorgula");
        setSize(700, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null); // Ekranı ortalayalım
        setLayout(new FlowLayout());

        // Bölge seçmek için JComboBox (açılır menü)
         String[] bolgeler = {"Sürekli", "Çaydaçıra", "Kapalıçarşı", "Yazıkonak", "Üniversite"};
        JComboBox<String> bolgeComboBox = new JComboBox<>(bolgeler);
        add(bolgeComboBox);

        // Trafik durumu gösterimi için label
        JLabel trafikLabel = new JLabel("Trafik durumu burada gösterilecek.");
        add(trafikLabel);

        // Sorgula butonu
        JButton sorgulaButon = new JButton("Trafik Durumunu Sorgula");
        sorgulaButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Seçilen bölgeyi al
                String secilenBolge = (String) bolgeComboBox.getSelectedItem();

                // Trafik durumu verisini al
                TrafikDurumuAlgila trafikDurumuAlgila = new TrafikDurumuAlgila();
                String trafikDurumu = trafikDurumuAlgila.trafikDurumunuAlgila(secilenBolge);

                // Trafik durumu etiketinde göster
                trafikLabel.setText(trafikDurumu);
            }
        });
        
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
        
         add(sorgulaButon);
        add(geriButon);
       

        // Görüntüleme
        setVisible(true);
    }

    // Sorgulama interface'ini implement et
    @Override
    public void sorgula() {
        // Sorgulama işlemi burada yapılabilir
        System.out.println("Sorgulama işlemi yapılıyor...");
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
       new TrafikDurumuSorgula();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
