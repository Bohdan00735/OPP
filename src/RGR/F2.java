package RGR;

import java.util.Arrays;

public class F2 extends MyThread{
    public F2(SynMon synchronisationMonitor, VarMon variablesMonitor, int n, int H) {
        super(synchronisationMonitor, variablesMonitor, n, H);
    }

    @Override
    public void run() {
        System.out.println("T2 started");
        varMon.setMX(calculations.setMatrixByOnes(new int[N][N]));

        synMon.signalIn();
        synMon.waitIn();

        int[] V2 = calculations.sumOfVectorsInSector(Main.D, Main.Z,H,2*H);
        if (H >= 0) System.arraycopy(V2, H, Main.V, H,H);
        synMon.signalReadyV();
        synMon.waitV();
        varMon.setV(Main.V);

        int a2 = calculations.multiplyTwoVectorsSector(Main.B, Main.C,H,2*H);
        varMon.addToA(a2);

        synMon.signalReadyA();
        synMon.waitA();

        a2 = varMon.copyA();
        int[][] MX2 = varMon.copyMX();
        V2 = varMon.copyV();

        int A2[] = calculations.diffOfVectorsInSector(calculations.multiplyValOnVectorSector(a2,Main.Z,H,2*H),
                calculations.multiplyMatrixOnVector(V2, calculations.multiplyMatrixesInSector(MX2, Main.MR,H,2*H),H,2*H),H,2*H);
        if (H >= 0) System.arraycopy(A2, H, Main.A, H,H);

        synMon.waitOut();
        System.out.println(Arrays.toString(Main.A));
        System.out.println("T2 finished");
    }

}
