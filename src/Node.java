public class Node {
    private Player player;
    private Node left;
    private Node right;

    public Node(Player player) {
        this.player = player;
        this.left = null;
        this.right = null;
    }

    public Player getPlayer() {
        return player;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
