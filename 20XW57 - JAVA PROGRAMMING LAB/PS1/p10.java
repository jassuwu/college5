import java.util.*;

public class p10 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        Set<String> uniq = new LinkedHashSet<String>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i].equals(arr[j]))
                    uniq.add(arr[j]);
            }
        }
        for (String i : uniq) {
            System.out.println(i);
        }
    }
}