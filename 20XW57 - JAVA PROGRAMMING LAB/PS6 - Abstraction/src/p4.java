import java.lang.*;
import java.util.*;

public class p4 {
    public static void main(String[] args) {
        System.out.println("NO DATA BRO ?");
    }
}

interface HotelTariff {
    void showTariff(String city);
}

class MakeMyTrip implements HotelTariff {
    public static Map<String, Map<String, Long>> getHotels(){
        return null;
    }

    public void displayCities(){

    }

    @Override
    public void showTariff(String city) {

    }
}

class Trivago implements HotelTariff {
    public static Map<String, Map<String, Long>> getHotels(){
        return null;
    }

    public void displayCities(){

    }

    @Override
    public void showTariff(String city) {

    }
}

class ClearTrip implements HotelTariff {
    public static Map<String, Map<String, Long>> getHotels(){
        return null;
    }

    public void displayCities(){

    }

    @Override
    public void showTariff(String city) {

    }
}