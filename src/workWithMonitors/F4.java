package workWithMonitors;

import java.util.Arrays;

public class F4 extends MyThread{
    public F4(SynchronisationMonitor synchronisationMonitor, VariablesMonitor variablesMonitor, int n, int H) {
        super(synchronisationMonitor, variablesMonitor, n, H);
    }

    @Override
    public void run() {

        System.out.println("T4 started");
        variablesMonitor.setR(calculations.setVectorByOne(new int[N]));
        Main.Z = calculations.setVectorByOne(Main.Z);

        synchronisationMonitor.signalIn();
        synchronisationMonitor.waitIn();

        int[] R4 = variablesMonitor.copyR();

        int[] V4 = calculations.multiplyMatrixOnVector(R4,Main.MC,3*H,4*H);
        if (H >= 0) System.arraycopy(V4, 3*H, Main.V, 3*H,H);
        synchronisationMonitor.signalReadyV();
        synchronisationMonitor.waitV();

        int a4 = calculations.multiplyTwoVectorsSector(Main.B, Main.Z,3*H,4*H);
        variablesMonitor.addToA(a4);

        synchronisationMonitor.signalReadyA();
        synchronisationMonitor.waitA();

        a4 = variablesMonitor.copyA();
        int d4 = variablesMonitor.copyd();
        V4 = variablesMonitor.copyV();

        int[] A4 = calculations.sumOfVectorsInSector(calculations.multiplyMatrixOnVector(V4,Main.MD,3*H,4*H),
                calculations.multiplyValOnVectorSector(a4*d4,Main.E,3*H,4*H),3*H,4*H);
        if (H >= 0) System.arraycopy(A4, 3*H, Main.A, 3*H,H);

        synchronisationMonitor.waitOut();
        System.out.println(Arrays.toString(Main.A));
        System.out.println("T4 finished");
    }
}
