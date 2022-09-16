import java.lang.*;
import java.util.*;
public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seats = new int[9];
        System.out.println("Enter the number of seats to be booked :");
        int total = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < total; i++) {
            try {
                System.out.println("Enter seat no. " + (i + 1) + ": ");
                bookSeat(seats, Integer.parseInt(sc.nextLine()));
                System.out.println("The seat was booked.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println(e);
            } catch (SeatNotAvailableException e) {
                System.err.println(e);
            }
        }
    }

    public static void bookSeat(int[] seats, int seatNo) throws SeatNotAvailableException
    {
        if (seats[seatNo] == 1) {
            throw new SeatNotAvailableException("Already Booked");
        }
        else{
            seats[seatNo] = 1;
        }
    }
}

class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException(String errorMessage) {
        super(errorMessage);
    }
}