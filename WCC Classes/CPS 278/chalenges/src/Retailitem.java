/******************************************************************************************

 * In class exercise 4, Programming Problem 5, Page 189

 * Author: Madison Stump

 * Project Purpose: Program to display Item 1, 2, and 3 in the console

 * Input:  This program does not accept inputs

 * Desired Output:  The message "Retail Item: ___ UnitsOnHand ___ Price___" is displayed in the console three times
 * for each item

 * Variables and Classes:  There is one class, with the main method.  It uses the System.out.println method.

 * Formulas:  description, unitsonhand, and price of items 1, 2 and 3

 * Testing:  When the program is run without inputs, the message "Retail Item: ___ UnitsOnHand ___ Price___"
 * appears in the console three different times for each item

 * February 1st,  2022

 ******************************************************************************************************************/

public class Retailitem {

    // declaring variables
    String description;
    int unitsOnHand;
    double price;

    class CostData {

    }
    // getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitsOnHand() {
        return unitsOnHand;
    }

    public void setUnitsOnHand(int unitsOnHand) {
        this.unitsOnHand = unitsOnHand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //results
    @Override
    public String toString() {
        return "Retail Item: " + description + ", UnitsOnHands: "
                + unitsOnHand + ", Price: $" + price;
    }
    }


