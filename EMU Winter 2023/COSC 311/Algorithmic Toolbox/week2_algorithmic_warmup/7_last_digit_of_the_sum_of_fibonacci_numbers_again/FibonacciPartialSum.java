import java.text.Normalizer.Form;
import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        int m = (int) (from % 60);
        int n = (int) (to % 60);

        if(n<m){
            n+=60;
        }
        long current = 0;
        long next  = 1;

        for (long i = 0; i <= n; ++i) {
            if (i >= m) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return (int) (sum % 10);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

