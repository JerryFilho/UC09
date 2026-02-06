import java.util.Scanner;

public class Gerenciador {

    public static void main(String[] args) {
    System.out.printf("Maratona Filmes");
    System.out.println(" ");
    System.out.println("Bem-vindo ao organizador de maratona!");
    System.out.println("Aqui você poderá planejar uma sessão de vários filmes.");


    System.out.println("nInstruções rápidas:\n\t1. Digite seu nome.\n\t2. Escolha a quantidade de filmes.\n\t3. Duração dos filmes");
    
    String nome;
    int quantidadeFilmes;
    double horasTotais;
    Scanner entrada = new Scanner(System.in);
    double duracaoMedia;
    System.out.println("Qual seu nome?");
    nome = entrada.nextLine();
    System.out.println("Quantos filmes deseja assistir?");
    quantidadeFilmes= entrada.nextInt();
    System.out.println("Qual a duração do filme?");
    duracaoMedia= entrada.nextDouble();

     horasTotais = (double) quantidadeFilmes * duracaoMedia;

    System.out.println("\nResumo da Maratona:");
        System.out.println("Usuário: " + nome);
        System.out.println("Quantidade de filmes: " + quantidadeFilmes);
        System.out.printf("Tempo total da maratona: %.2f horas%n", horasTotais);

    }
}