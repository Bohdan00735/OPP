package workWithMonitors;

public class Main {
    final static int N = 4;
    final static int P = 4;
    final static int H = N/P;

    public static int[] V = new int[N];
    public static int[] B = new int[N];
    public static int[] Z = new int[N];
    public static int[] A = new int[N];
    public static int[] E = new int[N];

    public static int[][] MC = new int[N][N];
    public static int[][] MD = new int[N][N];

    public static void main(String[] args) {
        SynchronisationMonitor synchronisationMonitor = new SynchronisationMonitor();
        VariablesMonitor variablesMonitor = new VariablesMonitor();

        F1 T1 = new F1(synchronisationMonitor,variablesMonitor,N,H);
        F2 T2 = new F2(synchronisationMonitor,variablesMonitor,N,H);
        F3 T3 = new F3(synchronisationMonitor,variablesMonitor,N,H);
        F4 T4 = new F4(synchronisationMonitor,variablesMonitor,N,H);

        T1.start();
        T2.start();
        T3.start();
        T4.start();
    }

}
