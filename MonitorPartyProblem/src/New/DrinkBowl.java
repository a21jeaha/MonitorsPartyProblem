package New;

public class DrinkBowl {

    private int drinksInBowl;
    private boolean fillRequestSent;
    private boolean isHostReady;
    private Go go;

    public DrinkBowl(Go go) {
        drinksInBowl = 1;
        fillRequestSent = false;
        isHostReady = false;
        this.go = go;
    }

    public void fillBowl(int drinkFiller, Boolean isHost) {
        // host fills bowl
        if (isHost == true) {
            isHostReady = true;
            go.host(drinkFiller);
            fillRequestSent = false;
            synchronized (this) {
                this.notifyAll();
                drinksInBowl = drinkFiller;
                isHostReady = false;
            }

        } else {
            // guest wakes host
            go.guest();
        }
    }

    // guest takes a drink
    public int getDrink() {

        // does bowl need to be filled?
        if (drinksInBowl == 0 && fillRequestSent == false) {
            fillRequestSent = true;
            if (isHostReady == false) {
                synchronized (go) {
                    try {
                        go.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            // sends guest to host notifying method
            fillBowl(0, false);
        }
        // force guest to wait for the bowl to be refilled
        if (drinksInBowl == 0) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        drinksInBowl--;
        return 1;
    }

}