package generics;

class MyBasic{
    void function1(){

    }
}
    //如果只是T,而不是T extends MyBasic,则不能调用 a.function1()方法。
   //擦除要求制定可u能会用到的泛型类型的边界，以安全地调用代码中的泛型对象上的方法。《Thinking in Java》P417。
public class MyGenericTest <T extends MyBasic>{

    public void test(T a){
       a.function1();
    }
}
