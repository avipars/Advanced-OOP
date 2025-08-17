package PECS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//AOOPD5784BA_ESP_1.pdf
// q7
public class Collections {
    public static <T> void copy(List<? super T> dest, List<? extends T> src){
        for (int i=0; i<src.size(); i++)
            dest.set(i,src.get(i));
    }

//    public static void main(String [] args){
//        List<Number> objects = new ArrayList<Object>();
//        List<Integer> integers = new ArrayList<Integer>();
//        List<Double> doubles = new ArrayList<Double>();
//    }
}



