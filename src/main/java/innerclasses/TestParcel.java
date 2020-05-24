package innerclasses;

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        //类加载器
        System.out.println(p.getClass().getClassLoader());
        System.out.println(c.getClass().getClassLoader() );
    }
}
