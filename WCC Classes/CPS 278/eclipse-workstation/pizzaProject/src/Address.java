import java.util.Scanner;

public class Address {

    private String street;
    private String zip;
    private String city;
    private String state;

    public static Scanner scanner = new Scanner(System.in);

    public String getStreet(){
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address(){
        System.out.println("Please enter your street address: ");
        setStreet(scanner.nextLine());

        System.out.println("Please enter your city: ");
        setCity(scanner.nextLine());

        System.out.println("Please enter your state: ");
        setState(scanner.nextLine());

        System.out.println("Please enter your zip code: ");
        setZip(scanner.nextLine());

    }
    public Address(String street, String city, String state, String zip){

        this.street = street;
        this.state = state;
        this.zip = zip;
        this.city = city;

    }
    public String toString(){
        return "[" +street + ", " + city + " " + state + ", " + zip + "]";
    }
}
