import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Integer counter = 0;
        while (counter < 2) {
            Thread.sleep(2500);
            System.out.println("Я поток - " + Thread.currentThread().getName() + " - Работаю.");
            counter++;
        }
        Thread.sleep(2500);
        System.out.printf("Количество сообщений от потока %s - %d \n", Thread.currentThread().getName(), counter);
        return counter;
    }
}