import java.lang.*;
import java.util.*;

public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the aircraft :");
        String name = sc.nextLine();
        System.out.print("Enter the source :");
        String source = sc.nextLine();
        System.out.print("Enter the destination :");
        String destination = sc.nextLine();
        System.out.println("Enter the type of Flight");
        System.out.println("1.Public Aircraft");
        System.out.println("2.Private Aircraft");
        String type = sc.nextLine();
        System.out.println("Is the flight check in before two hours");
        String checkIn = sc.nextLine();
        Boolean cI = false;
        if (checkIn=="Yes") {
            cI = true;
        }
        Aircraft a = new Aircraft(name, source, destination);
        switch (type) {
            case "1":
                System.out.println("Enter the kgs allowed per person");
                String kgsAllowed = sc.nextLine();
                System.out.println("Enter the additional fee charged for extra baggage per KG");
                String addFee = sc.nextLine();
                a = new PublicAircraft(name, source, destination, cI, Integer.parseInt(kgsAllowed), Double.valueOf(addFee));
                break;
            case "2":
                System.out.println("Enter the pilot you choose:");
                String pilotPref = sc.nextLine();
                System.out.println("Enter the purpose of the visit: ");
                String purpose = sc.nextLine();
                a = new PrivateAircraft(name, source, destination, cI, pilotPref, purpose);
                break;
            default:
                System.out.println("Enter a valid choice, bro.");
        }
        a.displayDetails();
    }
}

class Aircraft {
    protected String aircraftName;
    protected String source;
    protected String destination;

    public Aircraft(String aircraftName, String source, String destination) {
        this.aircraftName = aircraftName;
        this.source = source;
        this.destination = destination;
    }

    public void displayDetails() {
        System.out.println("Aircraft{" +
                "aircraftName='" + aircraftName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}');
    }
}

class PublicAircraft extends Aircraft {
    boolean checkInBeforeTwoHours;
    int noOfKGSAllowed;
    double additionalFeePerKG;

    public PublicAircraft(String aircraftName, String source, String destination, boolean checkInBeforeTwoHours, int noOfKGSAllowed, double additionalFeePerKG) {
        super(aircraftName, source, destination);
        this.checkInBeforeTwoHours = checkInBeforeTwoHours;
        this.noOfKGSAllowed = noOfKGSAllowed;
        this.additionalFeePerKG = additionalFeePerKG;
    }

    public boolean isCheckInBeforeTwoHours() {
        return checkInBeforeTwoHours;
    }

    public void setCheckInBeforeTwoHours(boolean checkInBeforeTwoHours) {
        this.checkInBeforeTwoHours = checkInBeforeTwoHours;
    }

    public int getNoOfKGSAllowed() {
        return noOfKGSAllowed;
    }

    public void setNoOfKGSAllowed(int noOfKGSAllowed) {
        this.noOfKGSAllowed = noOfKGSAllowed;
    }

    public double getAdditionalFeePerKG() {
        return additionalFeePerKG;
    }

    public void setAdditionalFeePerKG(float additionalFeePerKG) {
        this.additionalFeePerKG = additionalFeePerKG;
    }
    @Override
    public void displayDetails() {
        System.out.println("PublicAircraft{" +
                "checkInBeforeTwoHours=" + checkInBeforeTwoHours +
                ", noOfKGSAllowed=" + noOfKGSAllowed +
                ", additionalFeePerKG=" + additionalFeePerKG +
                ", aircraftName='" + aircraftName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}');
    }
}

class PrivateAircraft extends Aircraft {
    boolean checkInBeforeTwoHours;
    String pilotPreference;
    String purpose;

    public PrivateAircraft(String aircraftName, String source, String destination, boolean checkInBeforeTwoHours, String pilotPreference, String purpose) {
        super(aircraftName, source, destination);
        this.checkInBeforeTwoHours = checkInBeforeTwoHours;
        this.pilotPreference = pilotPreference;
        this.purpose = purpose;
    }

    public boolean isCheckInBeforeTwoHours() {
        return checkInBeforeTwoHours;
    }

    public void setCheckInBeforeTwoHours(boolean checkInBeforeTwoHours) {
        this.checkInBeforeTwoHours = checkInBeforeTwoHours;
    }

    public String getPilotPreference() {
        return pilotPreference;
    }

    public void setPilotPreference(String pilotPreference) {
        this.pilotPreference = pilotPreference;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public void displayDetails() {
        System.out.println("PrivateAircraft{" +
                "checkInBeforeTwoHours=" + checkInBeforeTwoHours +
                ", pilotPreference='" + pilotPreference + '\'' +
                ", purpose='" + purpose + '\'' +
                ", aircraftName='" + aircraftName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}');
    }
}