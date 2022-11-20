package New;

public class DrinkBowl {

    private int drinksInBowl;
    private boolean fillRequestSent;

    public DrinkBowl() {
        drinksInBowl = 0;
        fillRequestSent = false;
    }

    // host fills bowl
    public synchronized void fillBowl(int drinkFiller, Boolean isHost) {
        if (drinksInBowl > 0 && isHost == true) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace(); // IN TESTING
            }
            this.drinksInBowl = drinkFiller;
        } else {
            this.notify();
        }
    }

    // guest takes a drink
    public synchronized int getDrink() {
        // does bowl need to be filled?
        if (drinksInBowl <= 1 && fillRequestSent == false) {

            fillRequestSent = true;
            fillBowl(0, false);
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        drinksInBowl--;
        return 1;
    }

}