import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        carregarCSV(tree, "ranking-jogadores.csv");
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println();
            System.out.println("---Ranking de Jogadores---");
            System.out.println("1 - Inserir jogador");
            System.out.println("2 - Buscar jogador");
            System.out.println("3 - Remover jogador");
            System.out.println("4 - Visualizar em ordem");
            System.out.println("5 - Visualizar arvore");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nickname: ");
                    String nickname = sc.nextLine();

                    System.out.print("Ranking: ");
                    int ranking = sc.nextInt();
                    sc.nextLine();

                    tree.insert(new Player(nickname, ranking));
                    System.out.println("Jogador inserido.");
                    break;

                case 2:
                    System.out.print("Nickname: ");
                    String nickBusca = sc.nextLine();

                    if (tree.search(nickBusca)) {
                        System.out.println("Jogador encontrado.");
                    } else {
                        System.out.println("Jogador nao encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Nickname: ");
                    String nickRemove = sc.nextLine();

                    Player removido = tree.remove(nickRemove);

                    if (removido != null) {
                        System.out.println("Jogador removido: " + removido.getNickname());
                    } else {
                        System.out.println("Jogador nao encontrado.");
                    }
                    break;

                case 4:
                    tree.inOrder();
                    break;

                case 5:
                    TreeVisualizer.mostrar(tree);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void carregarCSV(BinarySearchTree tree, String caminho){
        String[] linhas = new String[1000];
        int total = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho));

            br.readLine();

            String linha = br.readLine();

            while (linha != null && total < linhas.length) {
                linhas[total] = linha;
                total++;
                linha = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Arquivo CSV nao encontrado.");
            return;
        }

        for (int i = 0; i < total; i++) {
            String[] partes = linhas[i].split(",");

            String nickname = partes[0].trim();
            int ranking = Integer.parseInt(partes[1].trim());

            tree.insert(new Player(nickname, ranking));
        }

        System.out.println("CSV carregado.");
    }
}