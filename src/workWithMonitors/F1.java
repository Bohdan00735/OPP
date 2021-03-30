package workWithMonitors;

public class F1 extends MyThread{
    public F1(SynchronisationMonitor synchronisationMonitor, VariablesMonitor variablesMonitor, int n, int H) {
        super(synchronisationMonitor, variablesMonitor, n, H);
    }

    @Override
    public void run() {
        System.out.println("T1 started");
        Main.MC = calculations.setMatrixByOnes(Main.MC);
        Main.E = calculations.setVectorByOne(Main.E);

        synchronisationMonitor.signalIn();
        synchronisationMonitor.waitIn();

        int[] R1 = variablesMonitor.copyR();

        int[] V1 = calculations.multiplyMatrixOnVector(R1,Main.MC,0,H);
        if (H >= 0) System.arraycopy(V1, 0, Main.V, 0, H);
        synchronisationMonitor.signalReadyV();
        synchronisationMonitor.waitV();
        variablesMonitor.setV(Main.V);

        int a1 = calculations.multiplyTwoVectorsSector(Main.B, Main.Z,0,H);
        variablesMonitor.addToA(a1);

        synchronisationMonitor.signalReadyA();
        synchronisationMonitor.waitA();

        a1 = variablesMonitor.copyA();
        int d1 = variablesMonitor.copyd();
        V1 = variablesMonitor.copyV();

        int A1[] = calculations.sumOfVectorsInSector(calculations.multiplyMatrixOnVector(V1,Main.MD,0,H),
                calculations.multiplyValOnVectorSector(a1*d1,Main.E,0,H),0,H);
        if (H >= 0) System.arraycopy(A1, 0, Main.A, 0, H);

        synchronisationMonitor.signalOut();
        System.out.println("T1 finished");
    }
}
