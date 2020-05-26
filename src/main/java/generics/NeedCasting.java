package generics;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {
    public void f(String[] args) throws Exception{
        ObjectInputStream in  =new ObjectInputStream(new FileInputStream(args[0]));
        List<String> shapes = (List<String>)in.readObject();
    }
}
