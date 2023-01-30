public class Population {
    //declaring variables
    int days;
    double organisms;
    double increaseRate;
    double result;

    // getters and setters
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getOrganisms() {
        return organisms;
    }

    public void setOrganisms(double organisms) {
        this.organisms = organisms;
    }

    public double getIncreaseRate() {
        return increaseRate;
    }

    public void setIncreaseRate(double increaseRate) {
        this.increaseRate = increaseRate;
    }

    public void multiplyPopulation(){
        int i = 1;
        while(i < days){
            System.out.println("*** Day " + i + ": " + String.format("%.2f",(organisms * (1+increaseRate))  * i)+" ***");
            i++;
        }
        result = (organisms * (1+increaseRate)  * days);
        System.out.println("+++ The organisms starting at: " + String.format("%.2f",organisms) +"would multiply to be: " + String.format("%.2f",result) + " after " + days + " days +++");
    }
}