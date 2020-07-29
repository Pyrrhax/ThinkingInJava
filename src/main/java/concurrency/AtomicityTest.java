package concurrency;

public class AtomicityTest implements Runnable{
    private int i = 0;
    //getValue()方法需要加关键字synchronized来和evenIncrement()同步，保证方法evenIncrement的原子性。
    public int getValue(){return i;}
    public synchronized void evenIncrement(){i++;i++;}

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        AtomicityTest at = new AtomicityTest();
        new Thread(at).start();
        int val;
        while (true){
            val=at.getValue();
            if(val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
