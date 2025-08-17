package Strategy;

public class PassoverDiscounter implements Discounter{
    @Override
    public double applyDiscount(double amount) {
        return amount *0.5;
    }
}
