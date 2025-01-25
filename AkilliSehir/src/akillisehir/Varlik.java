package akillisehir;

abstract class Varlik {
    protected int id;        // Varlığın benzersiz kimliği
    protected String isim;   // Varlığın adı

    public Varlik(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    // Varlık ekleme işlemi (alt sınıflarda özelleştirilebilir)
    public abstract void ekle();

    // Varlık güncelleme işlemi (alt sınıflarda özelleştirilebilir)
    public abstract void guncelle();
}
