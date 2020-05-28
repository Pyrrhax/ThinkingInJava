package arrays;

public class ArrayOfGenericType <T>{
    T[] array;
    public ArrayOfGenericType(int size){
        //不能直接创建泛型数组
        //array = new T[size];
        array =(T[]) new Object[size];
    }
}
