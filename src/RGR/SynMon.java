package RGR;

public class SynMon {
    private int F1 = 0;
    private int F2 = 0;
    private int F3 = 0;
    private int F4 = 0;
    private int F5 = 0;

    public synchronized void signalIn(){
        F1++;
        if (F1 >=4) notifyAll();
    }

    public synchronized void waitIn(){
        try{
            if (F1<4) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void signalReadyV(){
        F2++;
        if (F2 >= 4) notifyAll();
    }

    public synchronized void waitV(){
        try{
            if (F2 < 4) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void signalReadyA(){
        F3++;
        if (F3 >= 4) notifyAll();
    }

    public synchronized void waitA(){
        try{
            if (F3 < 4) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void signalReadyB(){
        F4++;
        if (F4 >= 4) notifyAll();
    }

    public synchronized void waitB(){
        try{
            if (F4 < 4) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void signalOut(){
        F5++;
        if (F5 >=3) notifyAll();
    }

    public synchronized void waitOut(){
        try{
            if (F5<3) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
