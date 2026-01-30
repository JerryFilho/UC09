package aula2;

import java.util.Scanner;

public class scanbug {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String nome;
        int idade;

        System.out.print("Digite seu nome ");
        nome = in.nextLine();
        in.nextLine();
        System.out.print("Digite sua idade ");
        idade = in.nextInt();

        System.out.printf("Olá %s, sua idade é: %d\n",nome,idade);

    }
}
