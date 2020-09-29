import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class F1 extends MyThread{

    int[] A ;
    int[] B ;
    int[] C ;

    int[][] MA;
    int[][] ME;

    public F1(String name, int priority, int N, Scanner scanner, Semaphore inputSemaphore) {
        super(name, priority, N, scanner, inputSemaphore);
    }

    @Override
    public void run() {
        System.out.println("F1 started");
        try{
            inputSemaphore.acquire();
            A = data.getVectorInput("A", N, scanner);
            B = data.getVectorInput("B", N, scanner);
            C = data.getVectorInput("C", N, scanner);

            MA = data.getMatrixInput("MA",N, scanner);
            ME = data.getMatrixInput("MA",N, scanner);

            inputSemaphore.release();
        }catch(InterruptedException e){System.out.println(e.getMessage());}
        System.out.println("d is " + data.calculateFunction1(A,B,C,MA,ME));
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("F2 ended");
    }

}
