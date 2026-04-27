import javax.swing.*;
import java.awt.*;

public class TreeVisualizer extends JPanel {
    private BinarySearchTree tree;
    private static final int RAIO = 25;
    private static final int ESPACO_VERTICAL = 70;

    public TreeVisualizer(BinarySearchTree tree) {
        this.tree = tree;
        setBackground(Color.WHITE);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        Node root = tree.getRoot();

        if (root != null) {
            desenhar(g2, root, getWidth() / 2, 40, getWidth() / 4);
        }
    }

    private void desenhar(Graphics2D g, Node node, int x, int y, int deslocamento) {
        if (node.getLeft() != null) {
            int xEsq = x - deslocamento;
            int yEsq = y + ESPACO_VERTICAL;
            g.drawLine(x, y, xEsq, yEsq);
            desenhar(g, node.getLeft(), xEsq, yEsq, deslocamento / 2);
        }

        if (node.getRight() != null) {
            int xDir = x + deslocamento;
            int yDir = y + ESPACO_VERTICAL;
            g.drawLine(x, y, xDir, yDir);
            desenhar(g, node.getRight(), xDir, yDir, deslocamento / 2);
        }

        g.setColor(new Color(100, 150, 255));
        g.fillOval(x - RAIO, y - RAIO, RAIO * 2, RAIO * 2);

        g.setColor(Color.BLACK);
        g.drawOval(x - RAIO, y - RAIO, RAIO * 2, RAIO * 2);

        String texto = node.getPlayer().getNickname() + " (" + node.getPlayer().getRanking() + ")";
        FontMetrics fm = g.getFontMetrics();
        int largura = fm.stringWidth(texto);

        g.drawString(texto, x - largura / 2, y + 4);
    }

    public static void mostrar(BinarySearchTree tree) {
        JFrame frame = new JFrame("Arvore de Ranking");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.add(new TreeVisualizer(tree));
        frame.setVisible(true);
    }
}