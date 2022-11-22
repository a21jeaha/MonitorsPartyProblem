package New;

public class Go {

    public synchronized int host(int drinkFiller) {

        int bowlFiller = drinkFiller;
        this.notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return bowlFiller;
    }

    public synchronized void guest() {
        notify();
    }
}
