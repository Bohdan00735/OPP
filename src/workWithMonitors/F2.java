package workWithMonitors;

import java.util.Arrays;

public class F2 extends MyThread{
    public F2(SynchronisationMonitor synchronisationMonitor, VariablesMonitor variablesMonitor, int n, int H) {
        super(synchronisationMonitor, variablesMonitor, n, H);
    }

    @Override
    public void run() {
        System.out.println("T2 started");
        Main.MD = calculations.setMatrixByOnes(Main.MD);
        variablesMonitor.setd(1);

        synchronisationMonitor.signalIn();
        synchronisationMonitor.waitIn();

        int[] R2 = variablesMonitor.copyR();

        int[] V2 = calculations.multiplyMatrixOnVector(R2,Main.MC,H,2*H);
        if (H >= 0) System.arraycopy(V2, H, Main.V, H,2*H);
        synchronisationMonitor.signalReadyV();
        synchronisationMonitor.waitV();

        int a2 = calculations.multiplyTwoVectorsSector(Main.B, Main.Z,H,2*H);
        variablesMonitor.addToA(a2);

        synchronisationMonitor.signalReadyA();
        synchronisationMonitor.waitA();

        a2 = variablesMonitor.copyA();
        int d2 = variablesMonitor.copyd();
        V2 = variablesMonitor.copyV();

        int[] A2 = calculations.sumOfVectorsInSector(calculations.multiplyMatrixOnVector(V2,Main.MD,H,2*H),
                calculations.multiplyValOnVectorSector(a2*d2,Main.E,H,2*H),H,2*H);
        if (H >= 0) System.arraycopy(A2, H, Main.A, H,H);

        synchronisationMonitor.signalOut();
        System.out.println("T2 finished");
    }
}
