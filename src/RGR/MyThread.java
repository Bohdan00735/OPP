package RGR;

import workWithMonitors.Calculations;

public class MyThread extends Thread{
    SynMon synMon;
    VarMon varMon;
    int N;
    int H;
    Calculations calculations = new Calculations();

    public MyThread(SynMon synchronisationMonitor, VarMon variablesMonitor, int n, int H) {
        this.synMon = synchronisationMonitor;
        this.varMon = variablesMonitor;
        N = n;
        this.H = H;
    }
}
