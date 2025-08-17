package Strategy;
// clean implementation of store via strategy pattern
public class CleanStore {
    Discounter d;

    public void setDiscounter(Discounter discounter) {
        this.d = discounter;
    }
    public double applyDiscount(double amount) {
        if (d != null) {
            return d.applyDiscount(amount);
        }
        return amount; // No discount applied
    }

    public static void main(String[] args) {
        CleanStore store = new CleanStore();

        // Set initial strategy
        store.setDiscounter(new PassoverDiscounter()); // change strategy in runtime
        System.out.println("Passover discount: " + store.applyDiscount(100.0));

        // Replace strategy at runtime with a lambda (e.g., 20% off)
        store.setDiscounter(amount -> amount * 0.8);
        System.out.println("Lambda discount: " + store.applyDiscount(100.0));

        // Replace again with another strategy
        store.setDiscounter(amount -> amount - 15); // Flat $15 off
        System.out.println("Flat discount: " + store.applyDiscount(100.0));
    }

}
