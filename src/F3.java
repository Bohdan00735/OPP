import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class F3 extends MyThread{
    int[] S;
    int[][] MO;
    int[][] MP;
    int[][] MR;

    public F3(String name, int priority, int N, Scanner scanner, Semaphore inputSemaphore) {
        super(name, priority, N, scanner, inputSemaphore);
    }

    @Override
    public void run() {
        System.out.println("F1 started");
        try{
            inputSemaphore.acquire();
            S = data.getVectorInput("S", N, scanner);
            MO = data.getMatrixInput("MO", N, scanner);
            MP = data.getMatrixInput("MP", N, scanner);
            MR = data.getMatrixInput("MR", N, scanner);
            inputSemaphore.release();
        }catch(InterruptedException e){System.out.println(e.getMessage());}
        System.out.println("T is " + Arrays.toString(data.calclateFunc3(S,MO,MP,MR)));
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("F2 ended");
    }
}
