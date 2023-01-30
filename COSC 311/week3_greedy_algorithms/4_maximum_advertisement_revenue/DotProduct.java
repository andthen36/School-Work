import java.util.*;

public class DotProduct {
    private static long maxDotProduct(Integer[] a, Integer[] b) {
        long revenue = 0;
        int slots = a.length;

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b, Collections.reverseOrder());

        for (int slot = 0; slot < slots; slot++){
            revenue += ((long)a[slot] * b[slot]);
        }
        return revenue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

