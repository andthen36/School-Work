public class reverseString {
    public static void main(String[] args){

        String r = reverse("dog");
        System.out.println(r);

    }

    public static String reverse(String s){
        char[] letters = new char[s.length()];

        int letterIndex = 0;
        for (int i = s.length() - 1; i >= s.length(); i--){
            letters[letterIndex] = s.charAt(i);
            System.out.println(s.charAt(i));
        }
        String reverse = "";
        for(int i = 0; i <s.length(); i++){
            reverse = reverse + letters[i];
        }
        return reverse;
    }
}
