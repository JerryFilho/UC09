package aula1;
public class variavel2 {
    public static void main(String[] args) {
        String teste;
        teste = "Hello";
        String teste1;
        teste1 = "world";

         
        /*
        NÂO PODE:
        "hello" - 1
        "mundo" / 123
        "hello" * "Mundo"
        */
       System.out.println(1 + 2 + " hello"); //3 hello
       System.out.println("Hello "+ 1 + 2); // hello 12  lê da esquerda pra direita;
       System.out.println(teste + " " + teste1);
        
    }
}
