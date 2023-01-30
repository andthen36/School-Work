import java.util.Scanner;

public class PopulationUI {

    public static void main(String[] args) {
        Population population = new Population();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter starting number of organism:");
        population.organisms = scanner.nextDouble();
        if (population.organisms < 2){
            System.out.println("*** Please enter a number higher then 2 ***");
            population.organisms = scanner.nextDouble();
        }
        System.out.println("Please enter growth rate as percent:");
        population.increaseRate = scanner.nextDouble();
        if (population.increaseRate <=0){
            System.out.println("*** Please enter a positive number ***");
            population.increaseRate = scanner.nextDouble();
        }
        population.increaseRate = population.increaseRate / 100;
        System.out.println("Please enter amount of days:");
        population.days = scanner.nextInt();
        if (population.days <= 1){
            System.out.println("*** Please enter a  number higher then 1 ***");
            population.increaseRate = scanner.nextDouble();
        }
        population.multiplyPopulation();

    }
}