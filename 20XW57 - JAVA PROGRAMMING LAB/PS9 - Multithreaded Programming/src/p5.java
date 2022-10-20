import java.lang.*;
import java.util.*;

// INCOMPLETE
public class p5 {
    public static int[] buffer = new int[10];

    public static void main(String[] args) {

    }
}

class Producer implements Runnable {
    private List<Integer> list;

    public Producer(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (list) {
                list.add(i);
            }
        }
    }
}