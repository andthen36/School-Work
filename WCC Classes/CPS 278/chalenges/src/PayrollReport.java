import java.util.Scanner;

public class PayrollReport {

    public static void main(String[] args){
        String name;
        int id;
        double grossPay;
        double stateTax;
        double federalTax;
        double withholding;
        double netPay;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name:");
        name = scanner.nextLine();

        System.out.println("Please enter your ID number:");
        id = scanner.nextInt();

        System.out.println("Please enter your gross pay:");
        grossPay = scanner.nextDouble();
        if(grossPay < 0){
            System.out.println("*** Error: Cannot be negative ***");
            System.out.println("Please enter your gross pay:");
            grossPay = scanner.nextDouble();
        }

        System.out.println("Please enter your State tax: ");
        stateTax = scanner.nextDouble();
        if(stateTax > grossPay){
            System.out.println("*** Error: Cannot be greater then Gross Pay ***");
            System.out.println("Please enter your State tax: ");
            stateTax = scanner.nextDouble();
        }else
        if(stateTax < 0){
            System.out.println("*** Error: Cannot be negative ***");
            System.out.println("Please enter your State tax: ");
            stateTax = scanner.nextDouble();
        }

        System.out.println("Please enter your Federal tax:");
        federalTax = scanner.nextDouble();
        if(federalTax > grossPay){
            System.out.println("*** Error: Cannot be greater then Gross Pay ***");
            System.out.println("Please enter your Federal tax:");
            federalTax = scanner.nextDouble();
        }else
        if(federalTax < 0){
            System.out.println("*** Error: Cannot be negative ***");
            System.out.println("Please enter your Federal tax:");
            federalTax = scanner.nextDouble();
        }

        System.out.println("Please enter your FICA withholding:");
        withholding = scanner.nextDouble();
        if(withholding > grossPay){
            System.out.println("*** Error: Cannot be greater then Gross Pay ***");
            System.out.println("Please enter your FICA withholding:");
            withholding = scanner.nextDouble();
        }
        if(withholding < 0){
            System.out.println("*** Error: Cannot be negative ***");
            System.out.println("Please enter your FICA withholding:");
            withholding = scanner.nextDouble();
        }

        netPay = grossPay - stateTax - federalTax - withholding;
        System.out.println("**********\n" +
                "Name: " + name +
                "\n Id: " + id +
                "\n Gross Pay: $" + grossPay +
                "\n State Tax: $" + stateTax +
                "\n Federal Tax : $: " + federalTax +
                "\n FICA Withholding: $" + withholding +
                "\n *** Your total Net Pay is: $" +netPay + " ***" +
                "\n **********");

    }
}
