import java.util.*;

public class FibonacciSumSquares {

    private static long getFibonacciSumSquaresNaive(long n) {
        int previous = 0;
        int current = 1;
        n = n % 60;
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }else{
            for (int i = 2; i<=n; i++){
                int temp = (previous + current)%60;
                previous = current;
                current = temp;
            }
        }
        return current;

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long a = getFibonacciSumSquaresNaive(n);
        long b = getFibonacciSumSquaresNaive(n+1);
        System.out.println((a*b)%10);
    }
}

