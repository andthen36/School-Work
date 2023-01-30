import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops, int n) {
        int currentRefill = 0;
        int numRefill = 0;
        while(tank < dist){
            
            if(currentRefill >= n || stops[currentRefill] > tank)return -1;
            while(currentRefill < n-1 && stops[currentRefill +1] <= dist){
                currentRefill +=1;
            } 

            numRefill += 1;
            dist = stops[currentRefill] + tank;
            currentRefill += 1;
            
        }
        
        return numRefill;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n+2];
        stops[0] = 0;
        stops[n+1] = dist;
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops, n));
    }
}
