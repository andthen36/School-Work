package Carpet;

public class RoomCarpet {
    double size;
    double carpetCost;
    RoomDimension roomDimension = new RoomDimension();

    public void roomCarpet(){
        roomDimension.returnArea();
        size = roomDimension.getArea();
        System.out.println("Total Area is: " + size + " Sqf");
        costCalculator();
        System.out.println("Total cost is: $" + carpetCost);

    }

    public void costCalculator(){
        carpetCost = size * 8;
    }
}
