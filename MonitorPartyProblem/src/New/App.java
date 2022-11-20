package New;

import javax.management.monitor.Monitor;

public class App {

    public App() {
    }

    public static void main(String[] args) throws Exception {

        DrinkBowl drinkBowl = new DrinkBowl();
        Host host = new Host(drinkBowl);
        Guest guest1 = new Guest(drinkBowl);
        Guest guest2 = new Guest(drinkBowl);
        Guest guest3 = new Guest(drinkBowl);
        Guest guest4 = new Guest(drinkBowl);
        Guest guest5 = new Guest(drinkBowl);

        Thread thread1 = new Thread(guest1);
    }
}
