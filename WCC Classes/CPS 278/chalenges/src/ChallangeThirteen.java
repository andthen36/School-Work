import java.util.Scanner;

public class ChallangeThirteen {

    public static void main (String[] args){

        double tax = 1.075;

        double tip = 0.18;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the amount for the bill: ");

        double amount = scanner.nextDouble();

        System.out.println("With at 18% tip the tip should be: " + String.format("%.2f", amount*tip));
        System.out.println("With tax, the total amount will be: " + String.format("%.2f"
                , amount*tax));
        System.out.println("With tax and tip, the total amount will be: " + String.format("%.2f", (amount*tax)+(amount*tip)));
    }
}
