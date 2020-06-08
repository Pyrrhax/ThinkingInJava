package containers;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String>  linkedMap = new LinkedHashMap<Integer, String>();
        linkedMap.put(1,"a");
        linkedMap.put(2,"b");
        linkedMap.put(3,"c");
        linkedMap.put(4,"d");
        linkedMap.put(5,"e");
        linkedMap.put(6,"f");
        System.out.println(linkedMap);

        //Least-Recent-Use Order
        linkedMap = new LinkedHashMap<Integer, String>(16,0.75f,true);
        linkedMap.put(1,"a");
        linkedMap.put(2,"b");
        linkedMap.put(3,"c");
        linkedMap.put(4,"d");
        linkedMap.put(5,"e");
        linkedMap.put(6,"f");
        for(int i=3;i<5;i++){
            linkedMap.get(i);
        }
        System.out.println(linkedMap);
    }
}
