package akillisehir;

import java.util.ArrayList;
import java.util.List;

public class VarlikEkle extends Varlik {
    private static List<Varlik> varlikListesi = new ArrayList<>();

    public VarlikEkle(int id, String isim) {
        super(id, isim);
    }

    // Varlık ekleme işlemi
    @Override
    public void ekle() {
        varlikListesi.add(this);
    }

    // Varlık güncelleme işlemi
    @Override
    public void guncelle() {
        for (Varlik varlik : varlikListesi) {
            if (varlik.id == this.id) {
                varlik.isim = this.isim;
                break;
            }
        }
    }

    public static List<Varlik> getVarlikListesi() {
        return varlikListesi;
    }

    public static Varlik findById(int id) {
        for (Varlik varlik : varlikListesi) {
            if (varlik.id == id) {
                return varlik;
            }
        }
        return null; // Bulunamazsa null döner
    }

    @Override
    public String toString() {
        return "ID: " + id + ", İsim: " + isim;
    }

    // setId metodunu ekledik
    public void setId(int id) {
        this.id = id;
    }

    // setIsim metodunu ekledik
    public void setIsim(String isim) {
        this.isim = isim;
    }
}
