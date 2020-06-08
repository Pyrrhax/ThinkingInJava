package containers;

import java.util.*;

public class Unsupported {
    static void test(String msg, List<String>list){
        System.out.println("--------"+msg+"-----------");
        Collection<String> c  = list;
        Collection<String> sublist=list.subList(1,8);
        Collection<String> c2 = new ArrayList<String>(sublist);
        try{
            c.retainAll(c2);
        }catch (Exception e){
            System.out.println("reatinAll()"+e);
        }
        try{
            c.removeAll(c2);
        }catch (Exception e){
            System.out.println("removeAll()"+e);
        }
    }

    public static void main(String[] args) {
        List<String>list = Arrays.asList("A B C D E F G H I J K L M N".split(" "));
        test("Modifiable Copy",new ArrayList<String>(list));
        test("Arrays.asList()",list);
        test("unmodifiableList", Collections.unmodifiableList(new ArrayList<String>(list)));
    }
}
