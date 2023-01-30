package Retail;

import java.util.Scanner;

public class CashRegister {
    Retail item1 = new Retail();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Retail item1 = new Retail();

        item1.setDescription("Jacket");
        item1.setUnitsOnHand(12);
        item1.setPrice(59.95);


        Retail item2 = new Retail();
        item2.setDescription("Designer Jeans");
        item2.setUnitsOnHand(40);
        item2.setPrice(34.95);


        Retail item3 = new Retail();
        item3.setDescription("Shirt");
        item3.setUnitsOnHand(20);
        item3.setPrice(24.95);
        int jacketAmount = 0;
        int jeansAmount = 0;
        int shirtAmount = 0;



        int i = 0;
        while (i < 1) {
            i++;
            System.out.println("***************\nWelcome! Please select an item you would like to buy:\n[1]Jacket\n[2]Designer Jeans\n[3]Shirt");
            int selection = scanner.nextInt();
            if (selection == 1) {
                System.out.println("Please enter the amount you would like to buy:");
                jacketAmount = scanner.nextInt();
            }
            if (selection == 2) {
                System.out.println("Please enter the amount you would like to buy:");
                jeansAmount = scanner.nextInt();
            }
            if (selection == 3) {
                System.out.println("Please enter the amount you would like to buy:");
                shirtAmount = scanner.nextInt();
            }
            System.out.println("Would you like to pick anything else?\n[1]Yes\n[2]No");
            selection = scanner.nextInt();
            if (selection == 1) {
                i = 0;
            } else {
                i = 2;
            }

            double Subtotal = (jacketAmount * item1.price) + (jeansAmount * item2.price) + (shirtAmount * item3.price);
            double Tax = Subtotal * 0.06;
            double Total = Subtotal + Tax;
            System.out.println("***************\nCart:" +
                    "\n["+ jacketAmount+"]Jacket(s): $"+ (jacketAmount * item1.price) + "" +
                    "\n["+jeansAmount+"]Designer Jeans: $"+(jeansAmount * item2.price)+"" +
                    "\n["+shirtAmount+"]Shirt(s): $" + (shirtAmount * item3.price)+"" +
                    "\nSubtotal: $" + Subtotal+"\nTax: $"+Tax+"" +
                    "\nTotal: $" + Total);

        }




    }



}
