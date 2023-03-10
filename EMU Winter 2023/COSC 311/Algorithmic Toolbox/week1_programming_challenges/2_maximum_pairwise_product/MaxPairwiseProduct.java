import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static long getMaxPairwiseProduct(int[] numbers){
        int n = numbers.length;

        /** find the maximum number in the array */
        long max1 = 0;

        int index1 = 0;
        int index2 = 0;

        for(int first = 0; first < n; ++first){
            if(max1 < numbers[first]){
                index1 = first;
                max1 = numbers[first];
            }
        }

        long max2 = 0;
        for (int second = 0; second < n; ++second){
            if(numbers[second] > max2 && second != index1){
                index2 = second;
                max2 = numbers[second];
            }
        }


        max1 = numbers[index1];
        max2 = numbers[index2];
        return max1 * max2 ;
    }

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt() ;
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}


