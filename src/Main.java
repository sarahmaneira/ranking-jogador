public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Player("Ana", 50));
        tree.insert(new Player("Bia", 30));
        tree.insert(new Player("Caio", 70));
        tree.insert(new Player("Davi", 20));
        tree.insert(new Player("Elis", 40));

        tree.inOrder();

        tree.remove("Bia");
        tree.inOrder();
    }
}