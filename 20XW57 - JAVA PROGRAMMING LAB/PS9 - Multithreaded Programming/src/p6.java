import java.lang.*;
import java.util.*;

public class p6 {
    public static Queue<String> batdirs;
    public static boolean trackFull = true;

    public static void main(String args[]) {
        args = new String[] { "N", "W", "S", "E" };
        batdirs = new LinkedList<>(Arrays.asList(args));

        for (String batdir : batdirs) {
            new Thread(new carCrossing(batdir), batdir).start();
        }
    }
}

class carCrossing implements Runnable {
    String cameFrom;

    public carCrossing(String cameFrom) {
        this.cameFrom = cameFrom;
    }

    public String getCameFrom() {
        return cameFrom;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                cross(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void cross(int no) throws InterruptedException {
        while (p6.trackFull) {
            synchronized (p6.batdirs) {
                System.out.println("The road is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + p6.batdirs.size());
                p6.batdirs.wait();
            }
        }

        synchronized (p6.batdirs) {
            System.out.println("Car " + no + " from " + this.getCameFrom() + " is crossing");
            p6.batdirs.remove();
            System.out.println("Car " + no + " from " + this.getCameFrom() + " has crossed");
            p6.trackFull = false;
            p6.batdirs.notifyAll();
        }
    }
}