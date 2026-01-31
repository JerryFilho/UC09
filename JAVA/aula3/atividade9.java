package aula3;

import java.util.Scanner;
public class atividade9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double preço;
        int quantidade;

        System.out.println("Digite o preço do produto");
        preço = in.nextDouble();
        System.out.println("Digite a quantidade do produto");
        quantidade = in.nextInt();
        System.out.println("O custo total é: " + (preço * quantidade));
    }
}
