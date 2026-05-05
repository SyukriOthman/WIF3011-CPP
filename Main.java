public class Main {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>();

        new Thread(new Write(node)).start();
        new Thread(new Operate(node, 3, new Dummy())).start();

    }
}
