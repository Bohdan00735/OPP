package workWithMonitors;

public class SynchronisationMonitor {
    private int F1 = 0;
    private int F2 = 0;
    private int F3 = 0;
    private int F4 = 0;

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


    public synchronized void signalOut(){
        F4++;
        if (F4 >=3) notifyAll();
    }

    public synchronized void waitOut(){
        try{
            if (F4<3) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
