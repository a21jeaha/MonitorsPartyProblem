package New;

public class DrinkBowl {

    private int drinksInBowl;
    private boolean fillRequestSent;
    private boolean isHostReady;
    private Go go;
    private MonitorObject monitorObject;

    public DrinkBowl(Go go, MonitorObject monitorObject) {
        drinksInBowl = 1;
        fillRequestSent = false;
        isHostReady = false;
        this.go = go;
        this.monitorObject = monitorObject;
    }

    // host fills bowl
    public void fillBowl(int drinkFiller, Boolean isHost) {
        if (isHost == true) {
            isHostReady = true;
            go.host(drinkFiller);
            fillRequestSent = false;
            this.notifyAll();
        } else {
            // go.notify();
            go.guest();
        }
    }

    // guest takes a drink
    public int getDrink() {
        // does bowl need to be filled?
        if (drinksInBowl <= 1 && fillRequestSent == false) {
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