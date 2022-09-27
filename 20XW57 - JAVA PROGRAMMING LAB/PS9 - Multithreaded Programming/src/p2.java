import java.lang.*;
import java.util.*;

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of counters: ");
        Integer noOfCounters = Integer.parseInt(sc.nextLine());
        ArrayList<String> theList = new ArrayList<>();
        for(int i = 0; i < noOfCounters; i++) {
            System.out.print("Enter a string to freqCount: ");
            theList.add(sc.nextLine());
        }
        System.out.println("Displaying the counts: ");
        for(String s : theList) {
            new Thread(new FrequencyCounter(s)).start();
        }
    }
}

class FrequencyCounter implements Runnable {
    public String theString;
    FrequencyCounter(String s) {
        this.theString = s;
    }
    public void run() {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (Character c : theString.toCharArray()) {
            synchronized (this) {
                if (freqMap.containsKey(c)) {
                    freqMap.put(c, freqMap.get(c) + 1);
                }
                else {
                    freqMap.put(c, 1);
                }
            }
        }
        synchronized (this) {
            String result = "The freqCount of " + this.theString + " is: ";
            for(Map.Entry entry : freqMap.entrySet()) {
                result += entry.getKey() + ":" + entry.getValue() + " ";
            }
            System.out.println(result);
        }
    }
}