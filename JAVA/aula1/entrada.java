package aula1;

import java.util.Scanner;

public class entrada {

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in); //Declaração de um Scanner
        System.out.println("Digite alguma coisa");
        line = in.nextLine(); //salva o que o usuario digitar.
        line = line.toUpperCase();
        System.out.println("Vc disse: " + line + "continua");
    }
}
