import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
     long f[] = new long [n+2];

     int i;
     f[0] = 0;
     f[1] = 1;
     for (i = 2; i<= n; i++){
        f[i] = f[i-1] + f[i-2];
     }
      return f[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
    
  }
}
