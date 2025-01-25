package akillisehir;

public abstract class Hizmet implements Sorgulama {
    protected int id;
    protected String isim;

    public Hizmet(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    public abstract void sorgula();
}
