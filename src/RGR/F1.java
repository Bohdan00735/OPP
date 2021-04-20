package RGR;

public class F1 extends MyThread{
    public F1(SynMon synchronisationMonitor, VarMon variablesMonitor, int n, int H) {
        super(synchronisationMonitor, variablesMonitor, n, H);
    }

    @Override
    public void run() {
        System.out.println("T1 started");
        Main.B = calculations.setVectorByOne(Main.B);

        synMon.signalIn();
        synMon.waitIn();

        int[] V1 = calculations.sumOfVectorsInSector(Main.D, Main.Z,0,H);
        if (H >= 0) System.arraycopy(V1, 0, Main.V, 0, H);
        synMon.signalReadyV();
        synMon.waitV();
        varMon.setV(Main.V);

        int a1 = calculations.multiplyTwoVectorsSector(Main.B, Main.C,0,H);
        varMon.addToA(a1);

        synMon.signalReadyA();
        synMon.waitA();

        a1 = varMon.copyA();
        int[][] MX1 = varMon.copyMX();
        V1 = varMon.copyV();

        int A1[] = calculations.diffOfVectorsInSector(calculations.multiplyValOnVectorSector(a1,Main.Z,0,H),
                calculations.multiplyMatrixOnVector(V1, calculations.multiplyMatrixesInSector(MX1, Main.MR,0,H),0,H),0,H);
        if (H >= 0) System.arraycopy(A1, 0, Main.A, 0, H);

        synMon.signalOut();
        System.out.println("T1 finished");
    }
}
