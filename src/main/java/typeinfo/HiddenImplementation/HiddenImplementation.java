package typeinfo.HiddenImplementation;

import typeinfo.interfacea.A;
import typeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception{
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        callHidenMethod(a,"g");
        callHidenMethod(a,"u");
        callHidenMethod(a,"v");
        callHidenMethod(a,"w");
    }
    static void callHidenMethod(Object a,String methodName) throws Exception{
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
