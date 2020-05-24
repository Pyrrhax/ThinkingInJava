import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("测试合集")
public class JunitTest {

    @BeforeEach
    void start(){

    }
    @Test
    @DisplayName("Integer-128到127是否是单例的")
    void integerTest() {
        Integer[] integers = {1, 1, 128, 128};
        if (integers[0] == integers[1]) {
            System.out.println("1 is SingleTone");
        }
        if (integers[2] == integers[3]) {
            System.out.println("128 is SingleTone");
        } else{
            System.out.println("128 is not SingleTone");
        }
    }
    public enum Spiciness {
        NOT,MILD,MEDIUM,HOT,FLAMING
    }
    @Test
    @DisplayName("枚举类型的ordinal测试")
    void enmuTest(){
        System.out.println(Spiciness.FLAMING.toString()+Spiciness.MEDIUM.ordinal());
    }

    class Game{
        Game(int i){}
    }
    class BoardGame extends Game{
        //派生类必须调用基类的构造器
        BoardGame(){super(1);}
    }

    @Test
    @DisplayName("Arrays.toString()的用法")
    void arrays2String(){

    }

}
