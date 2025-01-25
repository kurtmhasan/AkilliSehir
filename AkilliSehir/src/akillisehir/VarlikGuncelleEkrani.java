package akillisehir;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VarlikGuncelleEkrani extends JFrame {
    public VarlikGuncelleEkrani() {
        setTitle("Varlık Güncelle");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout()); // GridBagLayout kullanarak daha esnek bir düzen sağladık

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Bileşenler arasında boşluk

        // Varlık seçimi için ComboBox
        JLabel varlikSecLabel = new JLabel("Güncellenecek Varlık:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(varlikSecLabel, gbc);

       JComboBox<VarlikEkle> varlikSecimi = new JComboBox<>();
    for (Varlik varlik : VarlikEkle.getVarlikListesi()) {
    varlikSecimi.addItem((VarlikEkle) varlik); // Varlik türünü VarlikEkle türüne cast ediyoruz
    }   
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(varlikSecimi, gbc);

        // Yeni ID için etiket ve alan
        JLabel yeniIdLabel = new JLabel("Yeni ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(yeniIdLabel, gbc);

        JTextField yeniIdField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(yeniIdField, gbc);

        // Yeni İsim için etiket ve alan
        JLabel yeniIsimLabel = new JLabel("Yeni İsim:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(yeniIsimLabel, gbc);

        JTextField yeniIsimField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(yeniIsimField, gbc);

        // Güncelle butonu
        JButton guncelleButon = new JButton("Güncelle");
        guncelleButon.setBackground(new Color(0, 153, 0)); // Yeşil renk buton
        guncelleButon.setForeground(Color.WHITE); // Yazı rengini beyaz yap
        guncelleButon.setFocusPainted(false); // Butonun odaklandığında etrafında oluşan çerçeveyi kaldır

        guncelleButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VarlikEkle seciliVarlik = (VarlikEkle) varlikSecimi.getSelectedItem();

                if (seciliVarlik != null) {
                    try {
                        int yeniId = Integer.parseInt(yeniIdField.getText());
                        String yeniIsim = yeniIsimField.getText();

                        // Güncelleme işlemi
                        seciliVarlik.setId(yeniId);
                        seciliVarlik.setIsim(yeniIsim);

                        JOptionPane.showMessageDialog(null, "Varlık başarıyla güncellendi!");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Geçersiz ID! Lütfen sayısal bir değer girin.");
                    }
                }
            }
        });

        // Geri butonu
        JButton geriButon = new JButton("Geri");
        geriButon.setBackground(new Color(255, 69, 0)); // Kırmızı renk buton
        geriButon.setForeground(Color.WHITE);
        geriButon.setFocusPainted(false);

        geriButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Bu ekranı kapat
                // AdminPaneli'nin yeni bir örneğini oluşturun ve görünür hale getirin
                new AdminPaneli().setVisible(true); 
            }
        });

        // Ekrana butonları ekleyelim
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(guncelleButon, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(geriButon, gbc);

        // Ekranı görünür yapalım
        setVisible(true);
    }
}