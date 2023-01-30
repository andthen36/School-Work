import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public static Scanner scanner = new Scanner(System.in);
    private Customer customer;
    private int PizzaAmount;
    private Pizza[] pizza;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPizzaAmount() {
        return PizzaAmount;
    }

    public void setPizzaAmount(int pizzaAmount) {
        PizzaAmount = pizzaAmount;
    }

    public void enterCustomer(){
        setCustomer(new Customer());
    }

    public Order(){
        enterCustomer();
        orderPizza();
    }
    public Order (Customer customer){
        this.customer = customer;
        orderPizza();
    }
    public void orderPizza(){
        System.out.println("How many pizzas would you like: ");
        setPizzaAmount(scanner.nextInt());
        scanner.nextLine();
        pizza = new Pizza[PizzaAmount];
        for(int i = 0; i< PizzaAmount; i++){
            System.out.println("Info for pizza " + (i+1));
            pizza[i] = new Pizza();
        }
    }

    public String toString(){
        String pizzaStr= "";
        for(Pizza eachPizza : pizza){
            pizzaStr = pizzaStr + eachPizza + "\n";
        }
        return "Your info:\n" + customer.toString() + "\n" + getPizzaAmount() + " Pizza(s): \n" + pizzaStr ;
    }
    public static void main(String[] args){
        Order pizzaOrder= new Order();
        System.out.println(pizzaOrder);
    }

}
