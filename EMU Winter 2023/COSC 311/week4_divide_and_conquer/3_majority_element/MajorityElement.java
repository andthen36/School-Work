import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
       if (right < left) return a[left];
       int mid = left + (right - left) / 2;
       int lElement = getMajorityElement(a, left, mid);
       int rElement = getMajorityElement(a, mid + 1, right);

       if (lElement == rElement) return lElement;

       int lCount = frequency(a, lElement, left, right);
       int rCount = frequency(a, rElement, left, right);

       if(lCount > Math.ceil((right - left + 1) / 2)) return lElement;
       if(rCount > Math.ceil((right - left + 1) / 2)) return rElement;

       return -1;
    }
    private static int getMajorityElement(int[] a){
        int ans  = -1;
        ans = getMajorityElement(a, 0, a.length - 1);
        return ans;
    }
    private static int frequency(int[] a, int element, int left, int right){
        int cnt = 0;
        for (int i = left; i <= right; i++){
            if (a[i] == element)cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

