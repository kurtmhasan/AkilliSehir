package akillisehir;

import javax.swing.*;
import java.awt.*;

class AdminPaneli extends JFrame {
    public AdminPaneli() {
        setTitle("Admin Paneli");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ana panel (Dikey BoxLayout)
        JPanel anaPanel = new JPanel();
        anaPanel.setLayout(new BoxLayout(anaPanel, BoxLayout.Y_AXIS));
        anaPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Kenarlık boşluğu

        JLabel adminLabel = new JLabel("Admin İşlemleri");
        adminLabel.setFont(new Font("Arial", Font.BOLD, 24));
        adminLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Düğme paneli (Dikey düzen)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 10, 10)); // Tek sütun, 10px boşluk

        // Düğmelerin oluşturulması
        JButton varlikEkleButon = new JButton("Varlık Ekle");
        JButton varlikGuncelleButon = new JButton("Varlık Güncelle");
        JButton trafikSorgulaButon = new JButton("Trafik Durumu Sorgula");
        JButton suRezervSorgulaButon = new JButton("Su Rezerv Durumu Sorgula");
        JButton enerjiSorgulaButon = new JButton("Enerji Durumunu Sorgula");
        JButton raporButonu = new JButton("Rapor Oluştur");
        JButton problemButonu = new JButton("Problemleri Yönet");
        JButton cikisButton = new JButton("Çıkış");

        // Düğmelere aksiyon ekleme
        varlikEkleButon.addActionListener(e -> {
            new VarlikEkleEkrani();
            dispose();
        });

        varlikGuncelleButon.addActionListener(e -> {
            new VarlikGuncelleEkrani();
            dispose();
        });

        trafikSorgulaButon.addActionListener(e -> {
            new TrafikDurumuSorgula();
            dispose();
        });

        suRezervSorgulaButon.addActionListener(e -> {
            new SuRezervDurumuSorgula();
            dispose();
        });

        enerjiSorgulaButon.addActionListener(e -> {
            new EnerjiDurumuSorgula();
            dispose();
        });

        raporButonu.addActionListener(e -> {
            Rapor.raporOlustur();
        });

        problemButonu.addActionListener(e -> {
            Problem problem = new Problem();
            problem.problemEkraniniGoster();
        });

        cikisButton.addActionListener(e -> dispose());

        // Düğmelerin panele eklenmesi
        buttonPanel.add(varlikEkleButon);
        buttonPanel.add(varlikGuncelleButon);
        buttonPanel.add(trafikSorgulaButon);
        buttonPanel.add(suRezervSorgulaButon);
        buttonPanel.add(enerjiSorgulaButon);
        buttonPanel.add(raporButonu);
        buttonPanel.add(problemButonu);
        buttonPanel.add(cikisButton);

        // Ana panele bileşenlerin eklenmesi
        anaPanel.add(adminLabel);
        anaPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Boşluk
        anaPanel.add(buttonPanel);

        // Frame'e ana panelin eklenmesi
        add(anaPanel);

        // Ekranın ortasında açılma
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
