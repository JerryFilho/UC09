package atividades;

import java.util.Scanner;

public class atividade9 {
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double preço;
    int quantidade;

    System.out.println("Digite o preço do produto que deseja cadastrar: ");
    preço = in.nextDouble();
    System.out.println("Digite a quantidade de produtos em estoque: ");
    quantidade = in.nextInt();
    System.out.printf("Custo total dos produtos é: " + preço * quantidade);

    }

    
}
