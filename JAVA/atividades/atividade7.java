package atividades;
 import java.util.Scanner;
public class atividade7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double primeiroNumero;
        double segundoNumero;


        System.out.println("Insira um numero inteiro: ");
        primeiroNumero = in.nextDouble();
        System.out.println("insira outro numero inteiro");
        segundoNumero = in.nextDouble();

        System.out.printf("Os numeros digitados foram " + primeiroNumero +" "+ segundoNumero);
    }
    
}
