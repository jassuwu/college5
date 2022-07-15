import java.util.Scanner;

public class p8 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //THIS IS SO COOL.
        String[] arr = sc.nextLine().split(" ");

        String KEY = "";

        int min = 9;
        for(int i = 0; i < arr.length; i++){
            if ( min > Integer.parseInt(arr[i])/1000){
                min = Integer.parseInt(arr[i])/1000;
            }
        }
        KEY = KEY + String.valueOf(min);


        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if ( max < Integer.parseInt(arr[i])/100%10){
                max = Integer.parseInt(arr[i])/100%10;
            }
        }
        KEY = KEY + String.valueOf(max);
        min = 9;
        for(int i = 0; i < arr.length; i++){
            if ( min > Integer.parseInt(arr[i])/10%10){
                min = Integer.parseInt(arr[i])/10%10;
            }
        }
        KEY = KEY + String.valueOf(min);

        max = 0;
        for(int i = 0; i < arr.length; i++){
            if ( max < Integer.parseInt(arr[i])%10){
                max = Integer.parseInt(arr[i])%10;
            }
        }
        KEY = KEY + String.valueOf(max);
        System.out.println(KEY);
    }
}