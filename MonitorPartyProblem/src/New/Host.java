package New;

public class Host implements Runnable {

    String name;
    DrinkBowl drinkBowl;
    int drinkFiller;

    public Host(DrinkBowl drinkBowl) {
        this.drinkBowl = drinkBowl;
        name = "Host";
        drinkFiller = 3;
    }

    // fills bowl
    public void needFill() {
        drinkBowl.fillBowl(drinkFiller, true);
        System.out.println(name + " filled the drink bowl");
    }

    // Host is in a loop to fill bowl
    @Override
    public void run() {
        while (true) {
            needFill();
        }
    }
}
