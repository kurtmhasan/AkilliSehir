package akillisehir;

import java.util.Random;

public class EnerjiAnaliziYap {

    // Enerji analizi yapma metodu
    public String enerjiAnaliziYap() throws LowEnergyException {
        Random random = new Random();
        
        // Enerji tüketimi ve üretimi için rastgele değerler
        int enerjiTuketimi = random.nextInt(500) + 100; // 100 ile 600 kWh arasında rastgele değer
        int enerjiUretimi = random.nextInt(600) + 200;  // 200 ile 800 kWh arasında rastgele değer
        
        // Durum analizi yapılıyor (enerji durumu düşük, orta, yüksek)
        String durum;
        
        // Enerji durumu analizi
        if (enerjiTuketimi > enerjiUretimi) {
            // Eğer enerji üretimi çok düşükse, proaktif uyarı göster
            if (enerjiUretimi < 300) {  // Enerji üretimi çok düşükse, proaktif uyarı
                durum = "Düşük Enerji Durumu - Enerji Üretimi Yetersiz!";
                // Proaktif uyarı gönder
                System.out.println("Proaktif Uyarı: Enerji seviyesi düşük! Kaynağınızı kontrol edin.");
            } else {
                // Enerji seviyesi düşükse, exception fırlat
                throw new LowEnergyException("Enerji seviyesi düşük! Kaynağınızı kontrol edin.");
            }
        } else if (enerjiTuketimi == enerjiUretimi) {
            durum = "Enerji Durumu Dengede";
        } else {
            durum = "Yüksek Enerji Durumu - Enerji Üretimi Yeterli";
        }
        
        // Durumu döndürüyoruz
        return String.format("Enerji Tüketimi: %d kWh, Enerji Üretimi: %d kWh, Durum: %s", 
                             enerjiTuketimi, enerjiUretimi, durum);
    }
}