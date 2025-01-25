package akillisehir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TrafikDurumuAlgila {

    // Trafik durumu verisini almak için metod
    public String trafikDurumunuAlgila(String bolge) {
        Random random = new Random();
        String trafikDurumu = "";
        
        // Trafik yoğunlukları
        String[] durumlar = {"Yoğun", "Ortalama Yoğunlukta", "Serbest"};

        // Bölgeye göre trafik durumu verisi oluşturuluyor
       switch (bolge.toLowerCase()) {
    case "sürekli":
        trafikDurumu = "Sürekli - Trafik durumu: " + durumlar[random.nextInt(durumlar.length)];
        break;

    case "çaydaçıra":
        trafikDurumu = "Çaydaçıra - Trafik durumu: " + durumlar[random.nextInt(durumlar.length)];
        break;

    case "kapalıçarşı":
        trafikDurumu = "Kapalıçarşı - Trafik durumu: " + durumlar[random.nextInt(durumlar.length)];
        break;

    case "yazıkonak":
        trafikDurumu = "Yazıkonak - Trafik durumu: " + durumlar[random.nextInt(durumlar.length)];
        break;

    case "üniversite":
        trafikDurumu = "Üniversite - Trafik durumu: " + durumlar[random.nextInt(durumlar.length)];
        break;

    default:
        trafikDurumu = "Bölge bilgisi bulunamadı.";
        break;
}
 if (trafikDurumu.contains("Yoğun")) {
            JOptionPane.showMessageDialog(null, "Dikkat! Trafik durumu Yoğun. Lütfen alternatif güzergahları kullanın.");
        }
        return trafikDurumu;
    }

    // Trafik durumu sorgulama ekranı
    public static void main(String[] args) {
        // Trafik durumu sorgulama ekranını başlat
        JFrame frame = new JFrame("Trafik Durumu Sorgula");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Bölge seçmek için JComboBox (açılır menü)
        String[] bolgeler = {"Sürekli", "Çaydaçıra", "Kapalıçarşı", "Yazıkonak", "Üniversite"};
        JComboBox<String> bolgeComboBox = new JComboBox<>(bolgeler);
        frame.add(bolgeComboBox);

        // Trafik durumu gösterimi için label
        JLabel trafikLabel = new JLabel("Trafik durumu burada gösterilecek.");
        frame.add(trafikLabel);

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
        frame.add(sorgulaButon);

        // Görüntüleme
        frame.setVisible(true);
    }
}
