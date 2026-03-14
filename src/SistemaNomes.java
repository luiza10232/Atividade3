import java.io.*; // Biblioteca para leitura e escrita de arquivos
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaNomes {

    public static void main(String[] args) {

        // Lista que vai armazenar os nomes
        ArrayList<String> listaNome = new ArrayList<>();

        // Scanner para ler dados do teclado
        Scanner teclado = new Scanner(System.in);

        // Nome do arquivo
        String arquivo = "nomes.txt";

        try {

            // Cria um objeto File representando o arquivo
            File file = new File(arquivo);

            // Verifica se o arquivo existe antes de tentar ler
            if (file.exists()) {

                // Scanner para ler o arquivo
                Scanner leitorArquivo = new Scanner(file);

                // Enquanto existir linha no arquivo
                while (leitorArquivo.hasNextLine()) {

                    // Lê a linha e adiciona na lista
                    listaNome.add(leitorArquivo.nextLine());
                }

                // Fecha o leitor
                leitorArquivo.close();
            }

        } catch (Exception e) {

            // Caso ocorra algum erro na leitura
            System.out.println("Erro ao ler arquivo.");
        }

        int opcao = 0;

        while (opcao != 6) {

            System.out.println("\nMENU");
            System.out.println("1 - Adicionar nome");
            System.out.println("2 - Consultar nome");
            System.out.println("3 - Alterar nome");
            System.out.println("4 - Remover nome");
            System.out.println("5 - Mostrar lista");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            // ADICIONAR NOME
            if (opcao == 1) {

                System.out.print("Digite o nome para adicionar: ");
                String novoNome = teclado.nextLine();

                listaNome.add(novoNome);

                salvarArquivo(listaNome, arquivo);

                System.out.println("Nome adicionado com sucesso!");
            }

            // CONSULTAR NOME
            else if (opcao == 2) {

                System.out.print("Digite o nome para buscar: ");
                String nomeBusca = teclado.nextLine();

                if (listaNome.contains(nomeBusca)) {
                    System.out.println("Nome encontrado!");
                } else {
                    System.out.println("Nome nao encontrado.");
                }

            }

    
            // ALTERAR NOME
            else if (opcao == 3) {

                System.out.print("Digite o nome que deseja alterar: ");
                String nomeAntigo = teclado.nextLine();

                int indice = listaNome.indexOf(nomeAntigo);

                if (indice != -1) {

                    System.out.print("Digite o novo nome: ");
                    String novoNome = teclado.nextLine();

                    listaNome.set(indice, novoNome);

                    salvarArquivo(listaNome, arquivo);

                    System.out.println("Nome alterado com sucesso!");

                } else {

                    System.out.println("Nome nao encontrado.");
                }

            }
            // REMOVER NOME
            else if (opcao == 4) {

                System.out.print("Digite o nome para remover: ");
                String nomeRemover = teclado.nextLine();

                if (listaNome.remove(nomeRemover)) {

                    salvarArquivo(listaNome, arquivo);

                    System.out.println("Nome removido!");

                } else {

                    System.out.println("Nome nao encontrado.");
                }

            }

            // MOSTRAR LISTA
            else if (opcao == 5) {

                System.out.println("\nLista de nomes:");

                for (String nome : listaNome) {
                    System.out.println(nome);
                }

            }
        }

        teclado.close();
    }

    // MÉTODO PARA SALVAR NO ARQUIVO
    public static void salvarArquivo(ArrayList<String> lista, String arquivo) {

        try {

            PrintWriter escritor = new PrintWriter(new FileWriter(arquivo));

            for (String nome : lista) {
                escritor.println(nome);
            }

            escritor.close();

        } catch (Exception e) {

            System.out.println("Erro ao salvar arquivo.");
        }
    }
}