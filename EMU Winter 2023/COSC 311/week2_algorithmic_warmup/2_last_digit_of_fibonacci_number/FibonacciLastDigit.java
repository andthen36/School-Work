import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(long n) {
        

        int previous = 0;
        int current  = 1;
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            res = (previous + current) % 10;
            previous = current;
            current = res;
        }

        return res;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

