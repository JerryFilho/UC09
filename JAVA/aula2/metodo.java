package aula2;

public class metodo {
    public static void newline(){
        System.out.println("Entrei no metodo newLine");
    }

    public static void tresLinhas(){
        newline();
        newline();
        newline();

    }
    public static void main(String[] args) {
        System.out.println("Primeira linha");
        tresLinhas();
        System.out.println("Segunda linha");
    }
}
