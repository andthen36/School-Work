import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

    private static int radix = 263;
    private static long prime = 1000000007;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static long hash(String key, int m) {
        long h = 0;
        for (int i = 0; i < m; i++)
            h = (radix * h + key.charAt(i)) % prime;
        return h;
    }


    private static boolean check(String txt, String pat, int i){
        int m = pat.length();
        for (int j = 0; j< m; j++){
            if(pat.charAt(j) != txt.charAt(i + j)) return false;
        }
        return true;
    }

    private static List<Integer> getOccurrences(Data input) {
        String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();
        List<Integer> occurrences = new ArrayList<Integer>();
        long pHash = hash(s, m);
        long tHash = hash(t, m);

        if((pHash == tHash) && check(t, s, 0)) occurrences.add(0);

        long rm =1;
        for (int i = 1; i<= m-1; i++) rm = (radix * rm) % prime;

        for(int i = m; i < n; i++){
            tHash = (tHash + prime - rm*t.charAt(i-m) % prime) % prime;
            tHash = (tHash*radix + t.charAt(i)) % prime;

            int offset = i - m + 1;
            if ((pHash == tHash) && check(t, s, offset)) occurrences.add(offset);
        }
        return occurrences;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

