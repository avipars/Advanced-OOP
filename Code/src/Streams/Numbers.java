package Streams;

import java.util.Arrays;
import java.util.List;

public class Numbers {

    public static int evenFn(){

        List<Integer> numbers = Arrays.asList(1,2,3,4);

        numbers.stream().map(x->x*2); // does nothing

        return numbers.stream()
                .filter(x->x%2==0) // only keep evens
                .reduce(0,(ans, i)-> ans+i); //sum them up
    }

    public static void main(String [] args){

        System.out.println(evenFn()); // question is what does it print?

    }
}
