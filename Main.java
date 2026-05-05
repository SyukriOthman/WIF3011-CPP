public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread incrementThread = new Thread(new IncrementTask(sharedData));
        Thread checkThread = new Thread(new CheckCounter(sharedData));

        checkThread.start(); //Check starts first
        incrementThread.start();
        

        try {
            incrementThread.join();
            checkThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
