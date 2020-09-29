import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class F2 extends MyThread{
    int[][] MH;
    int[][] MK;
    int[][] ML;

    public F2(String name, int priority, int N, Scanner scanner, Semaphore inputSemaphore) {
        super(name, priority, N, scanner, inputSemaphore);
    }

    @Override
    public void run() {
        System.out.println("F1 started");
        try{
            inputSemaphore.acquire();
            MH = data.getMatrixInput("MH", N,scanner);
            MK = data.getMatrixInput("MK", N,scanner);
            ML = data.getMatrixInput("ML", N,scanner);
            inputSemaphore.release();
        }catch(InterruptedException e){System.out.println(e.getMessage());}
        System.out.println("MG is ");
        data.printMatrix(data.calculateFunction2(MH,MK,ML));
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("F2 ended");
    }
}
