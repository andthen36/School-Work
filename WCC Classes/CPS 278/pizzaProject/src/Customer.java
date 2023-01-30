import java.util.Scanner;

public class Customer{

    private String name;
    private Address address;
    public static Scanner scanner = new Scanner(System.in);

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Customer(){
        System.out.println("Please enter your name: ");
        setName(scanner.nextLine());
        setAddress(new Address());
    }

    @Override
    public String toString() {
        return "Customer {Name= " + name + ", Address= " + address + "}";
    }
}