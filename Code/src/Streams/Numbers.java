package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    public static int evenFn(List<Integer> numbers){


        numbers.stream().map(x->x*2); // does nothing

        return numbers.stream()
                .filter(x->x%2==0) // only keep evens
                .reduce(0,(ans, i)-> ans+i); //sum them up
    }

    public static List<Integer> square(List<Integer> numbers){
        return numbers.stream().map(x->x*x).collect(Collectors.toList());
    }

    public static List<Integer> orderedAsc(List<Integer> numbers){
        return numbers.stream().sorted().collect(Collectors.toList());
        // with comparator:

    }
    public static List<Integer> orderedDesc(List<Integer> numbers){
        return numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    }



    public stati`c void main(String [] args){

        // q1
        System.out.println(evenFn(Arrays.asList(1,2,3,4))); // question is what does it print?

        //q2 fill in blanks of sqare and ordered functions in 1 line using streams
        List<Integer> numbers = Arrays.asList(2,4,3,5);
        System.out.println("Squares of numbers: ");
        System.out.println(square(numbers)); // should print [4, 16, 9, 25]
        System.out.println("Ordered Descending: ");
        System.out.println(orderedDesc(numbers)); // should print [5,4,3,2
        System.out.println("Ordered Ascending: ");
        System.out.println(orderedAsc(numbers)); // should print [2,3,4,5]
    }
}
