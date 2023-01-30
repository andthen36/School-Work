import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayDemo {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new FileReader("8_ball_responses.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();

        Scanner keyboard = new Scanner(System.in);
        String question;
        int answer;
        String answerString;
        char result = 0;
        int i = 0;

        while (i <= 1) {
            System.out.println("Please enter a yes or no question");
            question = keyboard.nextLine();
            answer = (int) (Math.random() * 12);
            System.out.println(list.get(answer));
            System.out.println("Would you like to play again?");
            question = keyboard.nextLine();
            if (question == "yes") {
                i++;
            } else {
                System.out.println("Goodbye");
            }
        }
    }

}
