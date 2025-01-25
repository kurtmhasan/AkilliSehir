package akillisehir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VatandasPaneli extends JFrame {
    
    public VatandasPaneli() {
        // Ana çerçeve ayarları
        setTitle("Vatandaş Paneli");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Admin panelini ekranın ortasında açma
         setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        // Trafik durumu butonu
        JButton trafikButton = new JButton("Trafik Durumu Sorgula");
        trafikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrafikDurumuAlgila trafik = new TrafikDurumuAlgila();
                String trafikDurumu = trafik.trafikDurumunuAlgila("Üniversite");
                JOptionPane.showMessageDialog(VatandasPaneli.this, "Trafik Durumu: " + trafikDurumu, "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Enerji Durumu Sorgulama Butonu
JButton enerjiSorgulaButon = new JButton("Enerji Durumunu Sorgula");
enerjiSorgulaButon.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            EnerjiAnaliziYap enerji = new EnerjiAnaliziYap();
            String enerjiDurumu = enerji.enerjiAnaliziYap(); // Burada exception fırlayabilir
            JOptionPane.showMessageDialog(VatandasPaneli.this, "Enerji Durumu: " + enerjiDurumu, "Bilgi", JOptionPane.INFORMATION_MESSAGE);
        } catch (LowEnergyException ex) {
            JOptionPane.showMessageDialog(VatandasPaneli.this, 
                "Uyarı: " + ex.getMessage(), 
                "Proaktif Uyarı", 
                JOptionPane.WARNING_MESSAGE); // Proaktif uyarı
        }
    }
});
 
// Su Durumu Sorgula Butonu
JButton suButton = new JButton("Su Durumu Sorgula");
suButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        SuAnalizYap su = new SuAnalizYap();
        try {
            // Bu metod exception fırlatabilir, bu yüzden try-catch ile sarmalanır
            String suDurumu = su.suRezervAnalizi();
            JOptionPane.showMessageDialog(VatandasPaneli.this, "Su Durumu: " + suDurumu, "Bilgi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SuKesintisiException ex) {
            // Proaktif uyarı mesajı
            JOptionPane.showMessageDialog(VatandasPaneli.this, 
                    "Uyarı: " + ex.getMessage(), 
                    "Proaktif Uyarı", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }
});
        // Çıkış butonu
        JButton cikisButton = new JButton("Çıkış");
        cikisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Vatandaş panelini kapat
               
            }
        });
        // Butonları çerçeveye ekle
        add(trafikButton);
        add(enerjiSorgulaButon);
        add(suButton);
        add(cikisButton);

        // Çerçeveyi görünür yap
        setVisible(true);
    }

    public static void main(String[] args) {
        // Vatandaş panelini başlat
        new VatandasPaneli();
    }
}