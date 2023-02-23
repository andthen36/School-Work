import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] coins = {1, 3, 4};
        int[] minCoins = new int [m  + 1];

        for(int i = 1; i <= m; i++){
            minCoins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                    int numCoins  = minCoins[i - coins[j]] + 1;
                    minCoins[i] = Math.min(minCoins[i], numCoins);
                }
            }
        }
        return minCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

