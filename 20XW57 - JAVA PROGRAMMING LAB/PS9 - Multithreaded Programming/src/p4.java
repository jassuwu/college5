import java.lang.*;
import java.util.*;

public class p4 {
    public static int counter1 = 0;
    public static int counter2 = 0;
    public static int counter3 = 0;

    public static void main(String[] args) {
        Integer[] votes = new Integer[240];

        for (int i = 0; i < 240; i++)
            votes[i] = (int) Math.floor(Math.random() * 3 + 1);
        List<Integer> voteList = Arrays.asList(votes);

        // Four threads to do the counting
        try {
            for (int i = 0; i < 4; i++) {
                Thread t = new Thread(new Counter(voteList.subList(i * 60, (i + 1) * 60)));
                t.start();
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the results
        System.out.println("Candidate 1: " + counter1);
        System.out.println("Candidate 2: " + counter2);
        System.out.println("Candidate 3: " + counter3);

    }
}

class Counter implements Runnable {
    private List<Integer> voteList;

    public Counter(List<Integer> voteList) {
        this.voteList = voteList;
    }

    public synchronized void run() {
        for (Integer i : voteList) {
            if (i == 1)
                p4.counter1++;
            else if (i == 2)
                p4.counter2++;
            else
                p4.counter3++;
        }
    }
}