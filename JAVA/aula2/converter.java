package aula2;

/*
esse programa converte centimetro para pés e polegadas
*/

import java.util.Scanner;

public class converter {
    
    public static void main(String[] args) {
        final double CM_PARA_POL = 2.54;
        final double POL_PARA_PES = 12.0;
        double cm;
        double polegadas;
        double pes;
        double metros;
        double km;
        int pol;
        

        Scanner in = new Scanner(System.in);
        //Fim das Declarações;

        System.out.println("Digite um valor EXATO em CM");
        cm = in.nextDouble();
        polegadas = (cm / CM_PARA_POL);
        System.out.println("Valor em polegadas é " + polegadas);

        System.out.println("Digite um valor em Polegadas");
        polegadas = in.nextDouble();
        pes = (polegadas / POL_PARA_PES);
        System.out.println("Valor em Pés é " + pes);

        System.out.println("Digite um valor em CM para converter em metros");
        cm = in.nextDouble();
        metros = cm/100;
        System.out.println("Valor em metros é " + metros); 

    }

}
