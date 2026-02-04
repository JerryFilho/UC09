package aula4;

public class ParImpar {
    //Escreva um programa para determinar se um numero é PAR ou IMPAR
    //NUM % 2= 0 ==> PAR

    public static void main(String[] args) {
        
        int num = 10;
        if ( num % 2 == 0 ){

	        System.out.println("Numero é PAR");
        } else {
            System.out.println("Numero é IMPAR");
        }
    }
}
