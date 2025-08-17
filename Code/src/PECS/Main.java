package PECS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static PECS.Collections.copy;

// Works with Collections.java
public class Main {
    public static void main(String[] args) {
        // Different lists
        List<Object> objects = new ArrayList<>(Arrays.asList(new Object[3]));
        List<Number> numbers = new ArrayList<>(Arrays.asList(new Number[3]));
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Double> doubles = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3));

        List<Number> objs = new ArrayList<>(Arrays.asList(new Number[3]));
        // Example calls
        System.out.println("Before copy:");
        System.out.println("objects = " + objects);
        System.out.println("numbers = " + numbers);
        System.out.println("integers = " + integers);
        System.out.println("doubles = " + doubles);

        // Call 1: Number <- Integer
        copy(numbers, integers);

        // Call 2: Double <- Double
        Collections.<Double>copy(doubles, doubles);

        // Call 3: Object <- Integer
        Collections.<Integer>copy(objects, integers);

        System.out.println("\nAfter copy:");
        System.out.println("objects = " + objects);
        System.out.println("numbers = " + numbers);
        System.out.println("integers = " + integers);
        System.out.println("doubles = " + doubles);
    }
}
