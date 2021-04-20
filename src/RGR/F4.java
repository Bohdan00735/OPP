package RGR;

public class F4 extends MyThread{
    public F4(SynMon synchronisationMonitor, VarMon variablesMonitor, int n, int H) {
        super(synchronisationMonitor, variablesMonitor, n, H);
    }

    @Override
    public void run() {
        System.out.println("T4 started");
        Main.C = calculations.setVectorByOne(Main.C);
        Main.MR = calculations.setMatrixByOnes(Main.MR);

        synMon.signalIn();
        synMon.waitIn();

        int[] V4 = calculations.sumOfVectorsInSector(Main.D, Main.Z,3*H,4*H);
        if (H >= 0) System.arraycopy(V4, 3*H, Main.V, 3*H,H);
        synMon.signalReadyV();
        synMon.waitV();
        varMon.setV(Main.V);

        int a4 = calculations.multiplyTwoVectorsSector(Main.B, Main.C,3*H,4*H);
        varMon.addToA(a4);

        synMon.signalReadyA();
        synMon.waitA();

        a4 = varMon.copyA();
        int[][] MX4 = varMon.copyMX();
        V4 = varMon.copyV();

        int A4[] = calculations.diffOfVectorsInSector(calculations.multiplyValOnVectorSector(a4,Main.Z,3*H,4*H),
                calculations.multiplyMatrixOnVector(V4, calculations.multiplyMatrixesInSector(MX4, Main.MR,3*H,4*H),3*H,4*H),3*H,4*H);
        if (H >= 0) System.arraycopy(A4, 3*H, Main.A, 3*H,H);

        synMon.signalOut();
        System.out.println("T1 finished");
    }
}
