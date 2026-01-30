import java.util.Scanner;

public class atividade4 {
    public static void main(String[] args){

        Scanner in = new Scanner (System.in);
        String nome;  

        System.out.println("Qual o seu nome?");
        nome = in.nextLine();
        System.out.printf("Olá " + nome);

    }
}
