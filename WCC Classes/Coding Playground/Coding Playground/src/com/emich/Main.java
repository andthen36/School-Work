package com.emich;

import java.util.*;
import java.io.*;

public class Main {
    static long naiveGetMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        (long)numbers[first] * (long)numbers[second]);
            }
        }

        return max_product;
    }
    static long getMaxPairwiseProduct(int[] numbers){
        int n = numbers.length;

        /** find the maximum numbber in the array */
        long max1 = numbers[0];
        for(int first = 1; first < n; ++first){
            if(max1 < numbers[first]){
                max1 = numbers[first];
            }
        }

        long max2 = 0;
        for (int second = 0; second < n; ++second){

            if(numbers[second] != max1 && numbers[second] > max2){
                max2 = numbers[second];
            }
        }
        return max1 * max2;
    }

    public static void main(String[] args) {
        boolean testing = false;

        if (testing){
            test();
        }else{
            FastScanner scanner = new FastScanner(System.in);
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt() ;
        }
            System.out.println(getMaxPairwiseProduct(numbers));
        }

    }

    static void test(){
        Random random = new Random();
        int testId = 0;
        while(true){
            int n = random.nextInt(5)+1;
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++){
                numbers[i] = random.nextInt(9);
            }
            System.out.println("testId:" + testId + "\tnumbers[" + n + "]");
            for(int i = 0; i < n; i++){
                System.out.print(numbers[i] + ", ");
            }
            System.out.println();

            long result = getMaxPairwiseProduct(numbers);
            long expected = naiveGetMaxPairwiseProduct(numbers);

            if (result != expected){
                System.out.println("Wrong output.");
                System.out.println("Input: ");
                for(int i = 0; i< n; i++){
                    System.out.print(numbers[i] + ", ");
                }

                System.out.println("Output: " + result);
                System.out.println("Expected: " + expected);

                break;
            }
            testId++;
        }
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


