package akillisehir;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Problem {

    // Problemleri tutmak için bir liste
    private List<String> problemler;

    // Constructor - Örnek problemleri ekler
    public Problem() {
        problemleriHazirla();
    }

    // Problemleri listeye ekleyen yardımcı metot
    private void problemleriHazirla() {
        problemler = new ArrayList<>();
        problemler.add("Trafik: Şehir merkezinde yoğun trafik var.");
        problemler.add("Enerji: Elektrik kaynağı düşük seviyede.");
        problemler.add("Su: Şehir su rezervleri azalmış.");
    }

    // Problem ekranını gösteren metot
    public void problemEkraniniGoster() {
        // Problem ekranı için JFrame
        JFrame problemFrame = new JFrame("Problem Yönetimi");
        problemFrame.setSize(400, 300);
        problemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        problemFrame.setLocationRelativeTo(null);
        problemFrame.setLayout(new BorderLayout());

        // Problem listesini oluştur
        JList<String> problemListesi = new JList<>(problemler.toArray(new String[0]));
        problemListesi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        problemFrame.add(new JScrollPane(problemListesi), BorderLayout.CENTER);

        // Çözüm butonu
        JButton cozumButonu = new JButton("Çözüm Öner");
        cozumButonu.addActionListener(e -> {
            int secilenIndex = problemListesi.getSelectedIndex();
            if (secilenIndex != -1) {
                String secilenProblem = problemler.get(secilenIndex);
                problemiCozmeyeYonlendir(secilenProblem);
            } else {
                JOptionPane.showMessageDialog(problemFrame,
                        "Lütfen bir problem seçin!",
                        "Hata",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        problemFrame.add(cozumButonu, BorderLayout.SOUTH);
        problemFrame.setVisible(true);
    }

    // Seçilen problemi çözmek için ProblemDuzelt sınıfına yönlendirme
    private void problemiCozmeyeYonlendir(String problem) {
        ProblemDuzelt problemDuzelt = new ProblemDuzelt();
        problemDuzelt.problemiCoz(problem);
    }
}