import java.util.Scanner;

public class p7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int noChangeCount = 0;
        for(int i=0; i < str.length(); i++){
            if (str.charAt(str.length()-i-1) == str.charAt(i)){
                noChangeCount++;
            }
        }
        System.out.print(noChangeCount);
    }
}