import java.util.Scanner;

public class ChallangeFive {

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        int calories = 300;

        double serving = 4;

        double amount;

        System.out.println("Please enter the number of cookies you have had or plan to have: ");

        amount = scanner.nextDouble();

        System.out.println("With that amount the total calories would be: " + ((amount / serving) * calories));
    }
}
