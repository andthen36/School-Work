package Retail;

public class RetailUI {


    public static void main(String[] args)
    {
        //storing retail items 1, 2, and 3 data
        Retail item1 = new Retail();
        item1.setDescription("Jacket");
        item1.setUnitsOnHand(12);
        item1.setPrice(59.95);
        System.out.println(item1.toString()); // making results in a string

        Retail item2 = new Retail();
        item2.setDescription("Designer Jeans");
        item2.setUnitsOnHand(40);
        item2.setPrice(34.95);
        System.out.println(item2.toString()); // making results in a string

        Retail item3 = new Retail();
        item3.setDescription("Shirt");
        item3.setUnitsOnHand(20);
        item3.setPrice(24.95);
        System.out.println(item3.toString()); // making results in a string

        new CashRegister();

    }
}