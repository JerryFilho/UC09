package aula1;

public class variavel {

    public static void main(String[] args) {
        //Declaração de variaveis
        //let nome_var;
        //var nome_var
    
        String nome;
        int x,y;
        String sobrenome;
        int hora, minuto;
        String mensagem;
        
        mensagem = "Jonas, macaco prego"; //atribuindo a String a variavel mensagem
        hora = 11; //atribuindo o valor 11 a variavel 11
        minuto = 56; //atribuindo 56 a variavel minuto
        x=3;
        y=x; //qual o valor de y aqui?
        System.out.println(y); //tem o mesmo valor de x, ou seja, 3
        //imprimam na tela o conteudo da variavel mensagem

        System.out.println(mensagem);

        System.out.print("A hora atual é: ");
        System.out.print(hora);
        System.out.print(":");
        System.out.print(minuto);
        System.out.print(".");   //o print junta tudo

        //Quanto minutos tem na variavel hora, somado a variavel minutos. (hora * 60) + minutos
        System.out.println("Numero total de minutos toral: ");
        System.out.println((hora * 60) + minuto); //operadores aritimeticos: + e *
        //calcular a fração da hora que  a var minuto representa
        System.out.println("Fração da hora que a variavel minuto representa");
        //System.out.println(minuto/60); da zero, um erro matematico
        System.out.println("A porcentagem de hora que a var minuto representa");
        System.out.println((minuto *100)/60);// = 93%

    }
    
    
}

   
