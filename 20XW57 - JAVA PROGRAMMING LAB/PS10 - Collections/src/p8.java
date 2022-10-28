import java.util.*;

public class p8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        Integer n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the number of seats per row: ");
        Integer m = Integer.parseInt(sc.nextLine());
        List<List<Seat>> seats = Seat.generateSeats(n, m);
        System.out.println("The seatings look like this: ");

        // Print the seating arrangement before booking
        Seat.printSeats(seats);

        // Getting the bookings
        System.out.println("Enter the seats to book in csv format: ");
        String booking = sc.nextLine();

        // Booking the seats
        Seat.book(seats, booking);

        // Printing the seats after the booking
        System.out.println("The seatings look like this: ");
        Seat.printSeats(seats);

        sc.close();
        System.exit(0);
    }
}

class Seat {
    private Character section;
    private Integer number;
    private Boolean booked;

    // Constructors
    public Seat() {
    }

    public Seat(Character section, Integer number) {
        this.section = section;
        this.number = number;
        this.booked = false;
    }

    // Getters and Setters
    public Character getSection() {
        return section;
    }

    public void setSection(Character section) {
        this.section = section;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
        return "Seat [booked=" + booked + ", number=" + number + ", section=" + section + "]";
    }

    // Custom Methods
    public static List<List<Seat>> generateSeats(int rows, int seat) {
        List<List<Seat>> seats = new ArrayList<List<Seat>>();
        for (int i = 0; i < rows; i++) {
            List<Seat> row = new ArrayList<Seat>();
            for (int j = 0; j < seat; j++) {
                row.add(new Seat((char) (65 + i), j + 1));
            }
            seats.add(row);
        }
        return seats;
    }

    public static void book(List<List<Seat>> seatList, String seats) {
        String[] seatArray = seats.split(",");
        for (String seat : seatArray) {
            Character section = seat.charAt(0);
            Integer number = Integer.parseInt(seat.substring(1));
            seatList.get(section - 65).get(number - 1).setBooked(true);
        }
    }

    public static void printSeats(List<List<Seat>> seatList) {
        for (List<Seat> row : seatList) {
            for (Seat seat : row) {
                if (seat.getBooked()) {
                    System.out.print("-- ");
                } else {
                    System.out.print(seat.getSection() + "" + seat.getNumber() + " ");
                }
            }
            System.out.println();
        }
    }
}
