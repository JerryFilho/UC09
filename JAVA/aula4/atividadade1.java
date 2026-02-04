package aula4;

import java.util.Scanner;

public class atividadade1 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um numero");
        int num = in.nextInt();
        if (num % 2 == 0 ){

	        System.out.println("Numero é PAR");
        } else {
            System.out.println("Numero é IMPAR");
        }
    }
}
