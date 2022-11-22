package New;

public class Go {

    public synchronized void host(int drinkFiller) {

        this.notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void guest() {
        notify();
    }
}
