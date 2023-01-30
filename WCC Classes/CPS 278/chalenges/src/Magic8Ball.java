import java.util.Scanner;

public class Magic8Ball {

    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String question;
        int answer;
        char result = 0;
        int i = 0;
        while (i < 1) {
            System.out.println("Please enter a yes or no question");
            question = keyboard.nextLine();
            answer = (int) (Math.random() * 12) + 1;
            if (answer == 1) {
                System.out.println("Yes, of course!");
            } else if (answer == 2) {
                System.out.println("Without a doubt, yes.");
            } else if (answer == 3) {
                System.out.println("You can count on it.");
            }
            if (answer == 4) {
                System.out.println("For sure!");
            } else if (answer == 5) {
                System.out.println("Ask me later.");
            } else if (answer == 6) {
                System.out.println("I'm not sure");
            }
            if (answer == 7) {
                System.out.println("I can't tell you right now.");
            } else if (answer == 8) {
                System.out.println("I'll tell you after my nap");
            }
            if (answer == 9) {
                System.out.println("No way!");
            } else if (answer == 10) {
                System.out.println("I don't think so");
            }
            if (answer == 11) {
                System.out.println("Without a doubt, no.");
            } else if (answer == 12) {
                System.out.println("The answer is clearly NO.");
            }
            System.out.println("Would you like to play again?");
            question = keyboard.nextLine();
            if (question == "yes") {
                i++;
            } else if (question == "no") {
                System.out.println("Goodbye");
            }
        }



    }
}




