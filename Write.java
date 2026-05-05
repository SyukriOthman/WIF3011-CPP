import java.util.Random;

public class Write implements Runnable {

    private Node<Integer> node;
    private Random rand = new Random();

    //constructor
    public Write (Node<Integer> node){
        this.node = node;
    }

    @Override
    public void run() {
        try {
            while(true){
                int value = rand.nextInt(5);
                node.setValue(value);
                Thread.sleep(500); // Sleep for 500 milliseconds
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
