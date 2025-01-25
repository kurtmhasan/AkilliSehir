package akillisehir;

import java.util.Random;

public class SuAnalizYap {

    public String suRezervAnalizi() throws SuKesintisiException {
        // Su rezerv durumu için rastgele veri oluşturma
        Random random = new Random();
        int suRezervDurumu = random.nextInt(100); // 0 ile 100 arasında rastgele bir değer

        // Su seviyesi %10'un altına düşerse, SuKesintisiException fırlatılır
        if (suRezervDurumu < 10) {
            throw new SuKesintisiException("Su seviyesi %10'un altına düştü! Su kesintisi olabilir.");
        } 
        else if (suRezervDurumu < 30) {
            // Su seviyesi %10 ile %30 arasında ise proaktif uyarı verilir
            ProaktifUyariGonder uyari = new ProaktifUyariGonder("Su seviyesi düşük, dikkat et!");
            uyari.gonder();
            return "Su rezerv durumu: Kritik seviyede. %30 kapasite.";
        } 
        else if (suRezervDurumu < 60) {
            return "Su rezerv durumu: Orta seviyede. %60 kapasite.";
        } 
        else {
            return "Su rezerv durumu: Yüksek seviyede. %90 kapasite.";
        }
    }
}
