import java.util.Scanner;

public class SpeedOfSounds {



    int speed;



    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select an medium: [a]: Air, [w]: Water, [s]: Steel");
        String selection = scanner.nextLine();

        System.out.println("Please enter a distance:");
        int distance = scanner.nextInt();

        if(selection == "a"){
            int speedOfAir = distance/1100;
            System.out.println("Speed of Air: " + speedOfAir + " ft/s");
        }else
            if (selection == "w"){
                int speedOfWater = distance/4900;
                System.out.println("Speed of Water: " + speedOfWater + " ft/s");
        }else{
                int speedOfSteel = distance/16400;
                System.out.println("Speed of Steel: " + speedOfSteel + " ft/s");
            }


    }


}
