package workWithMonitors;

public class VariablesMonitor {
    private int a = 0;
    private int[] V;
    private int[] R;
    private int d;

    public synchronized void addToA(int ai){
        a+=ai;
    }

    public synchronized int copyA(){
        return a;
    }

    public synchronized void setV(int[] V){
        this.V = V;
    }

    public synchronized int[] copyV(){
        return V;
    }

    public synchronized void setR(int[] R){
        this.R = R;
    }

    public synchronized int[] copyR(){
        return R;
    }

    public synchronized void setd(int d){
        this.d = d;
    }

    public synchronized int copyd(){
        return d;
    }

}
