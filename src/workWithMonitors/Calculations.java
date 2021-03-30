package workWithMonitors;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Calculations {

    int[][] setMatrixByOnes(int[][] MM){
        for(int i = 0; i < MM.length; i++){
            MM[i] = setVectorByOne(MM[i]);
        }
        return MM;
    }

    int[][] setMatrixByRandom(int[][] MM){
        for(int i = 0; i < MM.length; i++){
            MM[i] = setVectorByRandom(MM[i]);
        }
        return MM;
    }

    int[] setVectorByOne(int[] A){
        for (int i = 0; i < A.length; i++) {
            A[i]=1;
        }return A;
    }

    int[] setVectorByRandom(int[] A){
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i]=random.nextInt(10);
        }return A;
    }

    int[] multiplyMatrixOnVector(int[] A, int[][] MA, int start, int end){
        int[] B = new int[MA.length];
        for (int i = start; i < end;i++){
            for (int j = 0; j < A.length; j++) {
                B[i]+=A[j]*MA[j][i];
            }
        }return B;
    }

    int[] sumOfVectorsInSector(int[] A, int[] B, int start, int end){
        int[] C = new int[A.length];
        for (int i = start; i < end; i++) {
            C[i] = A[i]+B[i];
        }return C;
    }

    int multiplyTwoVectorsSector(int[] A, int[] B, int start, int end){
        int c = 0;
        for (int i = start; i < end; i++) {
            c += A[i]*B[i];
        }return c;
    }

    int[] multiplyValOnVectorSector(int a, int[] A, int start, int end){
        int[] B = new int[A.length];
        for (int i = start; i < end; i++) {
            B[i] = A[i]*a;
        }return B;
    }


    public void printMatrix(int[][] MA) {
        System.out.println("---------------------------------");
        for (int[] row:MA
        ) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------------------");
    }

}
