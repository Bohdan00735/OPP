package workWithMonitors;

public class MyThread extends Thread{

    SynchronisationMonitor synchronisationMonitor;
    VariablesMonitor variablesMonitor;
    int N;
    int H;
    Calculations calculations = new Calculations();

    public MyThread(SynchronisationMonitor synchronisationMonitor, VariablesMonitor variablesMonitor, int n, int H) {
        this.synchronisationMonitor = synchronisationMonitor;
        this.variablesMonitor = variablesMonitor;
        N = n;
        this.H = H;
    }
}
