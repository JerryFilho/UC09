package aula3;

import java.util.Scanner;
public class atividade8 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        
       double fahrenheit;
        System.out.println("digite a temperatura em Fahrenheit");
        fahrenheit = in.nextInt();
        System.out.println("Temperatura em celsius" + (fahrenheit - 32) * 5.0 / 9.0);
    }
}
