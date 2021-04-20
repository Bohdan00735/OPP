package RGR;

public class F3 extends MyThread{
    public F3(SynMon synchronisationMonitor, VarMon variablesMonitor, int n, int H) {
        super(synchronisationMonitor, variablesMonitor, n, H);
    }

    @Override
    public void run() {
        System.out.println("T3 started");
        Main.Z = calculations.setVectorByOne(Main.Z);
        Main.D = calculations.setVectorByOne(Main.D);

        synMon.signalIn();
        synMon.waitIn();

        int[] V3 = calculations.sumOfVectorsInSector(Main.D, Main.Z,2*H,3*H);
        if (H >= 0) System.arraycopy(V3, 2*H, Main.V, 2*H,H);
        synMon.signalReadyV();
        synMon.waitV();
        varMon.setV(Main.V);

        int a3 = calculations.multiplyTwoVectorsSector(Main.B, Main.C,2*H,3*H);
        varMon.addToA(a3);

        synMon.signalReadyA();
        synMon.waitA();

        a3 = varMon.copyA();
        int[][] MX3 = varMon.copyMX();
        V3 = varMon.copyV();

        int A3[] = calculations.diffOfVectorsInSector(calculations.multiplyValOnVectorSector(a3,Main.Z,2*H,3*H),
                calculations.multiplyMatrixOnVector(V3, calculations.multiplyMatrixesInSector(MX3, Main.MR,2*H,3*H),2*H,3*H),2*H,3*H);
        if (H >= 0) System.arraycopy(A3, 2*H, Main.A, 2*H,H);

        synMon.signalOut();
        System.out.println("T3 finished");
    }
}
