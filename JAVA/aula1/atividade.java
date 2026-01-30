package aula1;
import java.util.Scanner;

public class atividade {
    public static void main(String[] args) {
        String line, line2, firstLetter;
        Scanner in = new Scanner(System.in);

        
        System.out.println("Qual o seu primeiro nome? ");
        line = in.nextLine();

        
        System.out.println("Qual o seu sobrenome: ");
        line2 = in.nextLine();


        System.out.println("Seu nome completo é "+ line + " " + line2);

    }
}
