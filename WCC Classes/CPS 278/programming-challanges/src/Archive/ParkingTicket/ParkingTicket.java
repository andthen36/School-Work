package ParkingTicket;

import java.util.Scanner;

public class ParkingTicket {
    ParkedCar parkedCar = new ParkedCar();
    ParkingMeter parkingMeter = new ParkingMeter();
    Scanner scanner = new Scanner(System.in);
    int fine;


    public void reportCar(){
        System.out.println("Reported: " + parkedCar.toString());
    }

    public void reportFine(){
        int time = parkedCar.minutesParked - parkingMeter.purchasedTime;
        if(time > parkingMeter.purchasedTime && (time / 60) < 1){
            fine = 25;
            System.out.println("Total Fine: " + fine);
        }else
            if(time > parkingMeter.purchasedTime && (time / 60) > 60){
            fine = 25;
            System.out.println("Total Fine: " + fine);
        }else
            if(time < parkingMeter.purchasedTime) {
                System.out.println("No Fine needed. Time: " + time);
            }
    }


}
