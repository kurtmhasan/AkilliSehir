package akillisehir;

public class SuKesintisiException extends Exception {
    // Constructor: Mesaj ile istisnayı oluştur
    public SuKesintisiException(String message) {
        super(message);  // Super class'ı çağırarak mesajı veriyoruz
    }
}

