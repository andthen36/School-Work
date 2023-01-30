package ParkingTicket;

import java.util.Scanner;

public class MainUi {

    public static void main (String[] args){

        // Initialize policeOffice class and scanner
        PoliceOfficer policeOfficer = new PoliceOfficer();
        Scanner scanner = new Scanner(System.in);
        int selection = 0;

        // Ask user what they would like to do
        System.out.println("You are standing on the street looking at a strange car" +
                "\n[1] Who am I" +
                "\n[2]Go to Car");
        selection = scanner.nextInt();

        // In case selection is not 1 or 2
        if(selection != 1 && selection != 2){
            System.out.println("Please enter a valid input:" +
                    "\n[1] Who am I" +
                    "\n[2]Go to Car");
            selection = scanner.nextInt();
        }
        // Initialize policeOffice who am i method
        if(selection == 1){
            policeOfficer.whoAmI();
        }
        selection = 0;

        // Asking user to proceed with more options
        System.out.println("You stand in front of the car... it looks like its been sitting here a while:" +
                "\n[1]Examine");
        selection = scanner.nextInt();

        // In case selection is not 1 or 2
        if(selection != 1 && selection != 2){
            System.out.println("Please enter a valid input:" +
                    "\n[1]Examine");
            selection = scanner.nextInt();
        }
        // Initialize policeOffice examine car method
        if(selection == 1){
            policeOfficer.examineCar();

        }
        selection = 0;

        // More options for user
        System.out.println("Looks like its been here for a while. Should we report it?:" +
                "\n[1]Yes" +
                "\n[2]No");
        selection = scanner.nextInt();
        if(selection != 1 && selection != 2){
            System.out.println("Please enter a valid input:" +
                    "\n[1]Yes" +
                    "\n[2]No");
            selection = scanner.nextInt();
        }
        // Initialize policeOffice issue ticket method
        if(selection == 1){
            policeOfficer.issueTicket();

        }else{
            System.out.println("YOu decided to not report the car");
        }
    }
}
