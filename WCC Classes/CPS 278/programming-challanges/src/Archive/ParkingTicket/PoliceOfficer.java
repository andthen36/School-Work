package ParkingTicket;

public class PoliceOfficer {

    String name = "Johnny McGouber";

    int badgeNumber = 381579813;

    ParkedCar parkedCar = new ParkedCar();
    ParkingMeter parkingMeter = new ParkingMeter();
    ParkingTicket parkingTicket = new ParkingTicket();

    public void whoAmI(){
        System.out.println("My name is " + name + " and my badge number is " + badgeNumber);
    }

    public void examineCar(){
        System.out.println("You examine the parked car.\n" +
                "It has been here for " + parkedCar.minutesParked+" minutes\n" +
                "Time on the meter says it purchased " + parkingMeter.purchasedTime + " minutes");
    }
    public void issueTicket(){
        System.out.println("You pull out your note pad.\n");
        parkingTicket.reportCar();
        parkingTicket.reportFine();
    }
}
