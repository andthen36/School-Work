import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    static class Item{
        int value;
        int weight;

        Double perunit;

        public Item(int v, int w){
            value = v;
            weight = w;
            perunit = (v*1.0)/w;
        }
    }
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
       double value = 0.0;
       int n = values.length;

       Item[] items = new Item[n];
       for (int i = 0; i < n; i++){
        items[i] = new Item(values[i], weights[i]);
       }

       Arrays.sort(items, new Comparator<Item>(){
        public int compare(Item o1, Item o2){
            return o2.perunit.compareTo(o1.perunit);
        }
       });

       for(int i = 0; i < n; i++){
        if(capacity <= 0) 
         return value;

        int taken = Math.min(capacity, items[i].weight);
        value += (taken * (items[i].value * 1.0) / items[i].weight);
        capacity -= taken;
       }
       return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
