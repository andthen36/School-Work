package Carpet;

import java.util.Scanner;

public class RoomDimension {

    double length;

    double width;

    double area;

    Scanner scanner = new Scanner(System.in);

    public double getArea() {
        return area;
    }

    public void returnArea(){
        System.out.println("Please enter a length:");
        length = scanner.nextDouble();
        System.out.println("Please enter a width:");
        width = scanner.nextDouble();
        area = length * width;

    }

    public String toString() {
        return "RoomDimension{" +
                "length=" + length +
                ", width=" + width +
                ", area=" + area +
                '}';
    }
}
