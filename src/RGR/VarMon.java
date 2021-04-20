package RGR;

public class VarMon {
    private int[][] MX ;
    private int a = 0;
    private int[] V;
    private int[] R;

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

    public synchronized void setMX(int[][] MX){
        this.MX = MX;
    }

    public synchronized int[][] copyMX(){
        return MX;
    }

}
