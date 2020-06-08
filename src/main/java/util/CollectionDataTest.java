package util;

import java.util.LinkedHashSet;
import java.util.Set;

class Government implements Generator<String>{
    String[] foundation = ("a b c dd eee ff g").split(" ");
    private int index;
    public String next(){return foundation[index++];}
}
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(),6));
        System.out.println(set);
    }
}
