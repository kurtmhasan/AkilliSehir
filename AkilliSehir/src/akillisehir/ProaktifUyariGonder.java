package akillisehir;

import javax.swing.JOptionPane;
public class ProaktifUyariGonder implements UyariGonder {
    private String uyariMetni;

    // Constructor
    public ProaktifUyariGonder(String uyariMetni) {
        this.uyariMetni = uyariMetni;
    }

    // UyariGonder arayüzündeki metodu doğru şekilde override ediyoruz
    @Override
    public void gonder() {
        JOptionPane.showMessageDialog(null, uyariMetni, "Uyarı", JOptionPane.WARNING_MESSAGE);
    }

    // Getter ve Setter
    public String getUyariMetni() {
        return uyariMetni;
    }

    public void setUyariMetni(String uyariMetni) {
        this.uyariMetni = uyariMetni;
    }
}