package aula2;

import java.util.Scanner;

public class convert2 {

    public static double cmParaPolegada(double d){
        
        final double CM_PARA_POL = 2.54;
        final double POL_PARA_PES = 12.0;
        double cm;
        double polegadas;
        double pes;
        double metros;
        double km;
        int pol;


        double p;
        p = d / 2.54;
        System.out.printf("Valor digitado em cm: %.2f", d);
        //Faz a coinverção 
        //Imprimi o resultado com printf
    
        return p;
    }

    public static void main(String[] args) {


        double cm;
        Scanner in = new Scanner(System.in);
        System.out.println("digite os cm's");
        cm = in.nextDouble();
        cmParaPolegada(cm);

    }
}
