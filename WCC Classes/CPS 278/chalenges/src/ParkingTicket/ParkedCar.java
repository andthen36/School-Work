package ParkingTicket;

public class ParkedCar {

    //Data stored for class
    String model = "2017 Ford Focus";
    String color = "Blue";
    String plateNumber = "IluvCAT";
    int minutesParked = 43;

    @Override
    public String toString() {
        return "ParkedCar{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
