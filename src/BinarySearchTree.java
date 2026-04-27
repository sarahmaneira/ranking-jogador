public class BinarySearchTree {
    private Node root;

    public void insert(Player p){
        root = insert(root, p);
    }

    private Node insert(Node current, Player p){
        if (current == null) {
            return new Node(p);
        }

        if (p.getRanking() < current.getPlayer().getRanking()) {
            current.setLeft(insert(current.getLeft(), p));
        } else {
            current.setRight(insert(current.getRight(), p));
        }

        return current;
    }

    public boolean search(String nickname) {
        return search(root, nickname) != null;
    }

    private Node search(Node current, String nickname) {
        if (current == null) {
            return null;
        }

        if (current.getPlayer().getNickname().equals(nickname)) {
            return current;
        }

        Node leftSearch = search(current.getLeft(), nickname);
        if (leftSearch != null) {
            return leftSearch;
        }
        return search(current.getRight(), nickname);
    }

    public Player remove(String nickname) {
        Node found = search(root, nickname);
        if (found == null) {
           return null;
        }

        Player removedPlayer = found.getPlayer();
        root = remove(root, removedPlayer.getRanking());
        return removedPlayer;
    }

    private Node remove(Node current, int ranking) {
        if (current == null) {
            return null;
        }

        if (ranking < current.getPlayer().getRanking()) {
            current.setLeft(remove(current.getLeft(), ranking));
        } else if (ranking > current.getPlayer().getRanking()) {
            current.setRight(remove(current.getRight(), ranking));
        } else {
            if (current.getLeft() == null) {
                return current.getRight();
            } else if (current.getRight() == null) {
                return current.getLeft();
            }

            Node successor = findMin(current.getRight());
            current.setPlayer(successor.getPlayer());
            current.setRight(remove(current.getRight(), successor.getPlayer().getRanking()));
        }
        return current;
    }

    private Node findMin(Node current) {
        if (current.getLeft() == null) return current;
        return findMin(current.getLeft());
    }

    public Node getRoot() {
        return root;
    }



    public void inOrder() {
    inOrder(root);
}

private void inOrder(Node current) {
    if (current == null) return;
    inOrder(current.getLeft());
    System.out.println(current.getPlayer().getNickname() + " - " + current.getPlayer().getRanking());
    inOrder(current.getRight());
}

}
