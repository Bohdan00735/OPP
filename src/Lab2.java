import java.util.Scanner;
import java.util.concurrent.Semaphore;

/*----------------Header------------------------
        --Lab1
        --Melniichuk Bohdan
        --IO-81
        --Func1: 1.22 d:= (B*C)+(A*B)+(C*(B*(MA*ME)))
        --Func2: 2.04 MG:= MAX(MH)*(MK*ML)
        --Func3: 3.13 T:= S*(MO*MP)+SORT(S)*MR */

public class Lab2 {
    public static void main(String[] args) {
        int N = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N");
        N = scanner.nextInt();
        Semaphore semaphore = new Semaphore(1);
        F1 t1 = new F1("F1",Thread.MAX_PRIORITY,  N, scanner,semaphore);
        F2 t2 = new F2("F2", Thread.MIN_PRIORITY, N, scanner, semaphore);
        F3 t3 = new F3("F3", Thread.NORM_PRIORITY, N, scanner, semaphore);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
