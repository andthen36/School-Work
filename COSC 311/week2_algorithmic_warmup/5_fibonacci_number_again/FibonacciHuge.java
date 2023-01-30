import java.util.*;

public class FibonacciHuge {
    public static long pisano(long m){
        long prev = 0;
        long current = 1;
        long result = 0;
        for(int i = 0; i< m * m; i++){
            long temp = 0;
            temp = current;
            current = (prev + current) % m;
            prev = temp;

            if(prev == 0 && current ==1){
                result = i+1;
            }

        }
        return result;
    }
    private static long getFibonacciHugeNaive(long n, long m) {
       
        long p = pisano(m);
        n = n % p;
    
        long previous = 0;
        long current  = 1;

        if (n==0){
            return 0;
        }else if (n==1){
            return 1;
        }

        for (long i = 0; i < n - 1; ++i) {
            long temp = 0;
            temp = current;
            current = (previous + current) % m;
            previous = temp;
            
        }

        return current % m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

