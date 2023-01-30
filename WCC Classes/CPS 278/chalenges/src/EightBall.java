import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class EightBall {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new FileReader("8_ball_responses.txt"));
        ArrayList<String> list = new ArrayList<>();
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }

        Scanner keyboard = new Scanner(System.in);
        String question = "";
        int answer;

        String tryAgain = "";


        while(true){
            System.out.println("Please enter a yes or no question");
            question = keyboard.nextLine();
            answer = (int) (Math.random() * 12);
            System.out.println(list.get(answer));
            System.out.println("Would you like to play again?");
            tryAgain = keyboard.nextLine();
            if(tryAgain.equals("no") || tryAgain.equals("No")) break;
        }
        System.out.println("Goodbye");

    }

}
