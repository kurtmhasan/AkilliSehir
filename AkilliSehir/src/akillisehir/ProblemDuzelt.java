package akillisehir;

import javax.swing.*;

public class ProblemDuzelt {

    // Problem çözümünü yöneten ana metod
    public void problemiCoz(String problem) {
        String[] cozumler = {
            "Trafiği yeniden yönlendir.",
            "Enerji kaynağını artır.",
            "Su tasarruf planını etkinleştir."
        };

        String cozum = getCozumSecenekleri(problem, cozumler);
        if (cozum != null) {
            mesajGoster("Problem Çözüldü", "Problem: " + problem + "\nSeçilen Çözüm: " + cozum);
        }
    }

    // Çözüm seçeneklerini kullanıcının seçmesi için dialog
    private String getCozumSecenekleri(String problem, String[] cozumler) {
        return (String) JOptionPane.showInputDialog(null,
                "Problem: " + problem + "\nÇözüm Seçin:",
                "Problem Çözümü",
                JOptionPane.QUESTION_MESSAGE,
                null,
                cozumler,
                cozumler[0]);
    }

    // Bilgilendirme mesajlarını gösteren metod
    private void mesajGoster(String baslik, String mesaj) {
        JOptionPane.showMessageDialog(null, mesaj, baslik, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        ProblemDuzelt problemDuzelt = new ProblemDuzelt();
        problemDuzelt.problemiCoz("Trafik sıkışıklığı");
    }
}
