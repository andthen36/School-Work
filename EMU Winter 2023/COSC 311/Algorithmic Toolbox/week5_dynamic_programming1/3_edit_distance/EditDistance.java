import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int m = s.length();
    int n = t.length();
    int [][] d = new int[m + 1][n+1];

    for(int i = 0; i<= m; i++){
      d[i][0] = i;
    }
    for(int j = 0; j <= n; j++){
      d[0][j] = j;
    }

    for(int i = 1; i <= m; i++){
      for(int j = 1; j <= n; j++){
        int insertion = d[i-1][j]+1;
        int deletion = d[i][j-1]+1;
        int match = d[i-1][j-1];
        int mismatch = d[i -1][j-1]+1;

        if(s.charAt(i-1) == t.charAt(j - 1)){
          d[i][j] = Math.min(insertion, Math.min(deletion, match));
        }else{
          d[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
        }
          
        

      }
    }
    return d[m][n];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
