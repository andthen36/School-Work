public class ChallangeFourteen {

    public static void main (String[] args){

        int shares = 1000;

        double amount = 25.50;

        double commission = 1.02;

        System.out.println("The amount paid for the stocks alone is: " + String.format("%.2f", shares * amount));
        System.out.println("The amount commission is: " + String.format("%.2f", (shares * amount)*.02));
        System.out.println("The total amount with commission is: " + String.format("%.2f", (shares * amount)*commission));

    }
}
