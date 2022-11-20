package New;

public class DrinkBowl {

    private int drinksInBowl;
    private boolean fillRequestSent;

    public DrinkBowl() {
        drinksInBowl = 0;
        fillRequestSent = false;
    }

    // host fills bowl
    public synchronized int fillBowl() {
        // fillRequestSent = COME BACK TO THIS
        return this.drinksInBowl = 3;
    }

    // guest takes a drink
    public synchronized boolean getDrink() {
        // does bowl need to be filled?
        if (drinksInBowl <= 1) {
            if (fillRequestSent == false) {
                fillRequestSent = true;
                fillBowl();
            }
        } else {
            return false;
        }
    }

}