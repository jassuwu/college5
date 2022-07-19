import java.util.*;

public class p11 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] numStr = sc.nextLine().split(" ");
        int[] arr = new int[numStr.length-1];
        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = Integer.parseInt(numStr[i+1]) - Integer.parseInt(numStr[i]);
        }
        System.out.println("The Jumping champion is: " + mostFrequent(arr, arr.length));
    }

    public static int mostFrequent(int[] arr, int n)
    {
        int maxcount = 0;
        int element_having_max_freq = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > maxcount) {
                maxcount = count;
                element_having_max_freq = arr[i];
            }
        }
        return element_having_max_freq;
    }
}