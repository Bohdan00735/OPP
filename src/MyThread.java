import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread{
    public int N;
    Scanner scanner;
    Semaphore inputSemaphore;
    Data data;

    public MyThread(String name, int priority, int N, Scanner scanner, Semaphore inputSemaphore) {
        this.setName(name);
        this.setPriority(priority);
        this.N = N;
        this.scanner = scanner;
        this.inputSemaphore = inputSemaphore;
        data = new Data();
    }
}
