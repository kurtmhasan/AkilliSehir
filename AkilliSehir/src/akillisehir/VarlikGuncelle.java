package akillisehir;


class VarlikGuncelle extends Varlik {

    public VarlikGuncelle(int id, String isim) {
        super(id, isim);
    }

    @Override
    public void ekle() {
        // Ekleme yapılmıyor
    }

    @Override
    public void guncelle() {
        // Varlık güncelleme işlemi
        System.out.println("Varlık güncellendi: " + isim);
    }
}
