import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Pizza {

    private enum Size {L, M, S}

    ;
    private Size size;
    public static Scanner scanner = new Scanner(System.in);
    private ArrayList<String> toppings = new ArrayList<String>();

    private int toppingAmount;

    public Pizza() {
        System.out.println("Please enter a size (L)arge, (M)edium, (S)mall: ");
        size = Size.valueOf(scanner.nextLine());

        System.out.println("How many toppings would you like?");
        toppingAmount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Topping choices are: Mushroom" + "\n" +"Pineapple" + "\n" + "Pepperoni" + "\n" +
                "BlackOlives" + "\n" + "Bacon" + "\n" + "Spinach");

        for (int i = 0; i < toppingAmount; i++) {
            System.out.println("Enter topping " + (i + 1));
            toppings.add(scanner.nextLine());
        }

    }

    @Override
    public String toString() {
        String toppingStr = "";

        toppingStr = toppingStr + toppings + ", ";

        return size + " " + toppingStr;
    }
}

