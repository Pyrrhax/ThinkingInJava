package innerclasses;

import java.util.LinkedList;
import java.util.Queue;

class WithInner{
    class Inner{}
}

public class InheritInner extends  WithInner.Inner{
    InheritInner(WithInner wi){
        wi.super();
    }

    public static void main(String[] args) {
        InheritInner i = new InheritInner(new WithInner());
        System.out.println(i);
        System.out.println(i.hashCode());

        Queue<Integer> q= new LinkedList<Integer>();
    }
}

