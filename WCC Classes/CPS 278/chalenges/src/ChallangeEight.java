import java.util.Scanner;

public class ChallangeEight {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        double countryTax = 1.02;
        double stateTax = 1.055;

        System.out.println("Please enter amount: ");

        double amount = scanner.nextDouble();

        System.out.println("Total after Country Tax: " + (amount * countryTax));
        System.out.println("Total after State Tax: " + (amount * stateTax));
        System.out.println("Total after both Taxes: " + (amount * countryTax * stateTax));




    }
}
