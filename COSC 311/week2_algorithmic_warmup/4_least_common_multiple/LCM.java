import java.util.*;

public class LCM {
  private static long gcd(int a, int b){
    if (a == 0)
      return b;

    return gcd(b % a, a);
  }

  private static long lcm(int a, int b) {
    return (a / gcd(a, b)) * b;

  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
