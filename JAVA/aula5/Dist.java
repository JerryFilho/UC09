/* package aula5;

public class Dist {
     //EXEMPLO DE DESENVOLVIMENTO INCCREMENTAL

    //calcular a distancia entre dois pontos

    //distancia dada por: dist = {(x2 - x1)^2 + (y2 - y1)^2}^1/2
    //ATIVIDADE 1: realizar o calculo dentro do metodo. 
    //static void calculaDistancia(doublex1, double y1, double x2, double y1,double y)
    
    //}
    public static void main(String[] args) {
        //declaração de variaveis
        double x1,x2,y1,y2,distX,distY,dx,dy,resultado;
        x1 = 0;
        x2 = 4; 
        y1 = 0;
        y2 = 4;
        dx = x2 - x1;
        dy = y2 - y1;
        distX = Math.pow(dx, 2.0);
        distY = Math.pow(dy, 2.0);
        System.out.println("Distancia do eixo x: " + distX);
        System.out.println("Distancia do eixo x: " + distY);
        resultado = Math.sqrt((distX+distY));
        System.out.println(resultado);
    }

}
 */