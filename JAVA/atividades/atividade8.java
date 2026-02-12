package atividades;
 import java.util.Scanner;
public class atividade8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double tempFarenheit;

        System.out.println("Digite a temperatura que deseja converter");
        tempFarenheit = in.nextDouble();
        System.out.printf("A temperatura em Celsius é: " + (tempFarenheit - 32) * 5 / 9);
    }
    
}
