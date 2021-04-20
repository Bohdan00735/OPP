package workWithMonitors;

public class F3 extends MyThread{
    public F3(SynchronisationMonitor synchronisationMonitor, VariablesMonitor variablesMonitor, int n, int H) {
        super(synchronisationMonitor, variablesMonitor, n, H);
    }

    @Override
    public void run() {

        System.out.println("T3 started");
        Main.B = calculations.setVectorByOne(Main.B);

        synchronisationMonitor.signalIn();
        synchronisationMonitor.waitIn();

        int[] R3 = variablesMonitor.copyR();

        int[] V3 = calculations.multiplyMatrixOnVector(R3,Main.MC,2*H,3*H);
        if (H >= 0) System.arraycopy(V3, 2*H, Main.V, 2*H,H);
        synchronisationMonitor.signalReadyV();
        synchronisationMonitor.waitV();

        int a3 = calculations.multiplyTwoVectorsSector(Main.B, Main.Z,2*H,3*H);
        variablesMonitor.addToA(a3);

        synchronisationMonitor.signalReadyA();
        synchronisationMonitor.waitA();


        a3 = variablesMonitor.copyA();
        int d3 = variablesMonitor.copyd();
        V3 = variablesMonitor.copyV();

        int[] A3 = calculations.sumOfVectorsInSector(calculations.multiplyMatrixOnVector(V3,Main.MD,2*H,3*H),
                calculations.multiplyValOnVectorSector(a3*d3,Main.E,2*H,3*H),2*H,3*H);
        if (H >= 0) System.arraycopy(A3, 2*H, Main.A, 2*H,H);

        synchronisationMonitor.signalOut();
        System.out.println("T3 finished");
    }
}
