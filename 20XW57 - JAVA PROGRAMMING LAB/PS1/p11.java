import java.util.*;

public class p11 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] numStr = sc.nextLine().split(" ");
        LinkedList<Integer>li = new LinkedList<>();
        int prevPrime = 2;
        for(int i = Integer.parseInt(numStr[0]);i < Integer.parseInt(numStr[1]); i++ ){
            if(isPrime(i)){
                prevPrime = i;
                break;
            }
        }
        for(int i = prevPrime+1; i < Integer.parseInt(numStr[1]) - 1; i++) {
            if(isPrime(i)){
                li.push(i - prevPrime);
                prevPrime = i;
            }
        }
        System.out.println("The Jumping champion is: " + mostFrequent(li, li.size()));
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int mostFrequent(LinkedList<Integer> li, int n)
    {
        int maxcount = 0;
        int element_having_max_freq = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (li.get(i) == li.get(j)) {
                    count++;
                }
            }

            if (count > maxcount) {
                maxcount = count;
                element_having_max_freq = li.get(i);
            }
        }
        return element_having_max_freq;
    }
}