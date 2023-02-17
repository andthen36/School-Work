import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PointsAndSegments {

    private static class Pair{
        int x;
        char pos;
        public Pair(int x, char pos){
            this.x = x;
            this.pos = pos;
        }
    }
    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        int total = starts.length + ends.length + points.length;
        Pair[] pairs  = new Pair[total];
            Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        int i, k;
        for(i = 0, k = 0; i < starts.length; i++){
            pairs[k++] = new Pair(starts[i], 'l');
            pairs[k++] = new Pair(ends[i], 'r');
        }

        for(i = 0; i < points.length; i++){
            pairs[k++] = new Pair(points[i], 'p');
        }
        Array.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2){
                if(p1.x < p2.x) return -1;
                if (p1.x > p2.x) return +1;
                else{
                    if(p1.pos < p2.pos) return -1;
                    if (p1.pos > p2.pos) return +1;
                    else return 0;
                }
            }
        });
        int count = 0;
        for(Pair pair : pairs){
            if(pair.pos == 'l') count++;
            else if (pair.pos == 'r') count--;
            else frequency.put(pairs.x, count);
        }
        for ( i = 0; i< points.length; i++){
            cnt[i]+= frequency.get(points[i]);
        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

