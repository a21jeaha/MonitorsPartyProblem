package New;

public class Host {

    DrinkBowl drinkBowl;

    public Host(DrinkBowl drinkBowl) {
        this.drinkBowl = drinkBowl;
    }

    public void needFill() {
        try {
            drinkBowl.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
