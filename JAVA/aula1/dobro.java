package aula1;
public class dobro {
    public static void main(String[] args) {
        double pi, minuto, balanco;
        balanco = 123.45; //erro?

        pi = 3.14159; //atribuição de valor fracionada
        minuto = 56.0;
        System.out.println("Fração de hora contida na var minuto");
        System.out.println(minuto/60.0);//0.9333333333333333
        System.out.println("Porcentagem de hora na var minuto");
        System.out.println((minuto/60.0)*100.0);

        /*
            int x = 1.1; // erro de compilação
            double y = 1; //não da erro, mas não é uma boa pratica.
            double y = 1/3; //vai dar erro!
            double y 1.0/3.0; // modo correto de declararação/atribuição
        */

        //Erros de arredondamentos:
        System.out.println(0.1 * 10);
        System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0+1 + 0.1 + 0.1 + .01);
    }
}
