package containers;

import util.Countries;

import java.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;

    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    public V put(K key,V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null){
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        }
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<K,V>(key,value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while(it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);//ListIterator可以通过set()来修改该位置的对象。
                found = true;
                break;
            }
        }
        if(!found){
            bucket.add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode())%SIZE;

        return super.get(key);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<Entry<K, V>>();
        for(LinkedList<MapEntry<K,V>> bucket:buckets){
            if(bucket==null){
                continue;
            }
            for(MapEntry<K,V> mpair:bucket){
                set.add(mpair);
            }
        }
        return set;
    }

    public static void main(String[] args) {
         SimpleHashMap<String,String> m = new SimpleHashMap<>();
         m.putAll(Countries.capitals(3));
        System.out.println(m);
        HashMap forSourceCode = new HashMap();
    }

}
