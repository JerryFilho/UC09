package aula3;

import java.util.Scanner;

public class matematica {
    
public static void main(String[] args) {
    // area circulo: PI r^2
    Scanner inUser = new Scanner(System.in);
    //double x;
    double diam;
    //double raio;
    double resultado;
                                                        //double quad = Math.pow(2 , 3);
                                                        //System.out.println(quad);
    //x = Math.PI;
    System.out.println("Digite o diametro: ");
    diam = inUser.nextDouble();
    //raio= diam/2;
    resultado = (Math.pow((diam/2), 2.0) * Math.PI);

    System.out.println("A area do circulo é: " + resultado);


}


}
