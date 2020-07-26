import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult"+id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        ArrayList<Future<String>> results=new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for(Future<String> str:results){
            try {
                System.out.println(str.get());
            }catch (InterruptedException e){
                System.out.println(e);
            }catch (ExecutionException e) {
                System.out.println(e);
            }
            finally{
                executorService.shutdown();
            }
        }
    }
}
