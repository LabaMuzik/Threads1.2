import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final List<MyCallable> myCallable = new ArrayList<>();

        final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 4; i++) {
            myCallable.add(new MyCallable());
        }
        pool.invokeAll(myCallable);

        int result = pool.invokeAny(myCallable);
        System.out.println();

        pool.shutdown();
        Thread.sleep(3000);
        System.out.printf("Результат работы одного из потокв - %d \n", result);
    }
}