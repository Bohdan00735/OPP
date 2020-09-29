import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Data {

    int[] getVectorInput(String name, int size, Scanner scanner){
        System.out.println("Input value by value vector " + name);
        int[] A = new int[size];
        for (int i = 0; i < size; i++) {
            if (scanner.hasNextInt()){
                A[i] = scanner.nextInt();
            }else {
                System.out.println("Enter only num");
                i--;
            }
        }return A;
    }

    int[][] getMatrixInput(String name, int size, Scanner scanner){
        System.out.println("Fill row by row matrix " + name);
        int[][] MA = new int[size][size];
        for (int i = 0; i < size; i++) {
            MA[i] = getVectorInput(String.format("Row %d",i+1),size,scanner);
        }return MA;
    }

    int[][] multiplyMatrix(int[][] MA, int[][] MB, int size){
        int[][] MC = new int[size][size];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    MC[i][j] += MA[i][k] * MB[k][j];
                }
            }
        }

        return MC;
    }


    int[] multiplyMatrixOnVector(int[] A, int[][] MA){
        return Arrays.stream(MA)
                .mapToInt(row ->
                        (int) IntStream.range(0, row.length)
                                .mapToDouble(col -> row[col] * A[col])
                                .sum()
                ).toArray();
    }

    int[][] multiplyMatrixOnNum(int a, int[][] MA){
        for (int i = 0; i < MA.length; i++) {
            for (int j = 0; j < MA.length; j++) {
                MA[i][j]*=a;
            }
        }
        return MA;
    }

    int[] sumOfVectors(int[] A, int[] B){
        int[] C = new int[A.length];
        for (int i = 0; i < C.length; i++) {
            C[i] = A[i]+B[i];
        }return C;
    }

    int multiplyTwoVectors(int[] A, int[] B){
        int c = 0;
        for (int i = 0; i < A.length; i++) {
            c += A[i]*B[i];
        }return c;
    }

    int searchMaxInMatrix(int[][] MA){
        int a = MA[0][0];
        for (int [] row:MA
             ) {
            for (int value:row
                 ) {
                if (value > a){a = value;}
            }
        }return a;
    }



    public int calculateFunction1(int[] A, int[] B, int[] C, int[][] MA, int[][] ME) {
        //(B*C)+(A*B)+(C*(B*(MA*ME)))
        return multiplyTwoVectors(B,C)+multiplyTwoVectors(A,B)+
                multiplyTwoVectors(C,multiplyMatrixOnVector(B,multiplyMatrix(MA,ME,MA.length)));
    }


    public int[][] calculateFunction2(int[][] MH, int[][] MK, int[][] ML) {
        return multiplyMatrixOnNum(searchMaxInMatrix(MH),multiplyMatrix(MK,ML, ML.length));
    }

    public void printMatrix(int[][] MA) {
        System.out.println("---------------------------------");
        for (int[] row:MA
             ) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------------------");
    }

    public int[] calclateFunc3(int[] S, int[][] MO, int[][] MP, int[][] MR) {
        //S*(MO*MP)+SORT(S)*MR
        int [] U = multiplyMatrixOnVector(S,multiplyMatrix(MO,MP, MP.length));
        Arrays.sort(S);
        return sumOfVectors(U, multiplyMatrixOnVector(S,MR));
    }
}
