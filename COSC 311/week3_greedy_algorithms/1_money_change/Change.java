import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int change = 0;
        int count = 0;
        int[] denominations = {1, 5, 10};
        int max = denominations.length -1;
        
        while(change < m){
            while(change <= m && (m - change) >= denominations[max]){
                change += denominations[max];
                count++;
            }
            max = max - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

