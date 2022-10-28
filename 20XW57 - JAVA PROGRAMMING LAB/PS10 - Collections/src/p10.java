import java.util.*;

public class p10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. of rows in the hall: ");
        Integer n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the No. of seats in each row in the hall: ");
        Integer m = Integer.parseInt(sc.nextLine());

        // generate the hall
        Map<String, List<Seat>> hall = Seat.generateHall(n, m);

        // Before booking
        System.out.println("The hall seating arrangement is: ");
        Seat.printHall(hall);

        // Book the seats
        System.out.println("Enter the seats to be booked in CSV format: ");
        String[] seats = sc.nextLine().split(",");
        List<Seat> seatsToBook = new ArrayList<>();
        for (String seat : seats) {
            seatsToBook.add(new Seat(seat));
        }
        hall = Seat.book(hall, seatsToBook);

        // After booking
        System.out.println("The hall seating arrangement is: ");
        Seat.printHall(hall);

        sc.close();
        System.exit(0);
    }
}

class Seat {
    private String seatNumber;
    private Boolean booked;

    // Constructors
    public Seat() {
    }

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.booked = false;
    }

    // Getters and Setters
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }

    // toString
    @Override
    public String toString() {
        return "Seat [booked=" + booked + ", seatNumber=" + seatNumber + "]";
    }

    // Custom Methods
    public static Map<String, List<Seat>> generateHall(int rows, int seats) {
        Map<String, List<Seat>> hall = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            List<Seat> row = new ArrayList<>();
            for (int j = 0; j < seats; j++) {
                row.add(new Seat((char) (65 + i) + "" + (j + 1)));
            }
            hall.put((char) (65 + i) + "", row);
        }
        return hall;
    }

    public static Map<String, List<Seat>> book(Map<String, List<Seat>> hall, List<Seat> seats) {
        for (Seat seat : seats) {
            for (String row : hall.keySet()) {
                for (Seat s : hall.get(row)) {
                    if (s.getSeatNumber().equals(seat.getSeatNumber())) {
                        s.setBooked(true);
                    }
                }
            }
        }
        return hall;
    }

    public static void printHall(Map<String, List<Seat>> hall) {
        for (String row : hall.keySet()) {
            System.out.print(row + " ");
            for (Seat seat : hall.get(row)) {
                if (seat.getBooked()) {
                    System.out.print("* ");
                } else {
                    System.out.print(seat.getSeatNumber() + " ");
                }
            }
            System.out.println();
        }
    }
}
