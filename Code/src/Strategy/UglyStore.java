package Strategy;
// implementation of store, but not so clean
public class UglyStore {
    Discounter d;
    public void setDiscounter(Discounter discounter) {
        // This method can be used to set a discounter if needed
        this.d = discounter;
    }

    public static void main(String[] args) {

//        call discounter
        Discounter discounter = new PassoverDiscounter();
        double amount = 100.0;
        double discountedAmount = discounter.applyDiscount(amount);
        System.out.println("Using PassoverDiscounter:");
        System.out.println("Original amount: " + amount);
        System.out.println("Discounted amount: " + discountedAmount);
        // Example of using a different discounter using lambda as we only have 1 method in interface

        System.out.println("Using lambda expression for discounter:");
        Discounter lambdaDiscounter = (double amt) -> amt * 0.8;
        double lambdaDiscountedAmount = lambdaDiscounter.applyDiscount(amount);
        System.out.println("Original amount: " + amount);
        System.out.println("Discounted amount with lambda: " + lambdaDiscountedAmount);

        // use set discounter and apply discount
        UglyStore store = new UglyStore();
        store.setDiscounter(discounter);
        double storeDiscountedAmount = store.d.applyDiscount(amount);
        System.out.println("UglyStore discounted amount using setDiscounter: " + storeDiscountedAmount);
    }
}

