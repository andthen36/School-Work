public class ChallangeSix {

    public static void main (String[] args){
        double percent = 0.65;

        double salesYearAmount = 8.3;

        System.out.println("The East Coast sales earned: " + String.format("%.3f", salesYearAmount * percent)
                + " billion this year out of the 8.3 billion made total");
    }

}
