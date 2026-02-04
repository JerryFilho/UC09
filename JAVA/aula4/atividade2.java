package aula4;

import java.util.Scanner;

public class atividade2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite sua idade ");
        int idade = in.nextInt();
        
        if (idade < 18 ) {
            System.out.println("Menor de idade");
        
        } else {
        System.out.println("Maior de idade");
        }    
    
    }
}
