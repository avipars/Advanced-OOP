public class Box<T> {

    private T item;

    public void add(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    /**
     * The required output
     * Integer Value :10
     * String Value :lev
     */
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("lev"));

        System.out.printf("Integer Value :%d\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());
    }
}

