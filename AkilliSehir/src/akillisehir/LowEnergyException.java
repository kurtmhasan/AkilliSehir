package akillisehir;

public class LowEnergyException extends Exception {
    public LowEnergyException(String message) {
        super(message); // Exception sınıfının constructor'ını çağırıyoruz
    }
}