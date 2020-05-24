package innerclasses;

import sun.security.krb5.internal.crypto.Des;

public class Parcel2 {
    private class Contents{
        private int i =11;
        public int value(){return i;}
    }
    private class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
        //返回外部类的对象
        Parcel2 outer(){
            return Parcel2.this;
        }

    }
    public Destination to(String s){
        return new Destination(s);
    }
    public Contents contents(){
        return new Contents();
    }
    public void ship(String dest){
        Contents c =contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        //下面这两行代码如果出现在别的类的main中，则应是Parcel2.Contents和Parcel2.Destination
        Contents c= q.contents();
        Destination d = q.to("Borneo");
        //直接用new
        Contents c1 = q.new Contents();
        Destination d1 =q.new Destination("xx");
    }
}
