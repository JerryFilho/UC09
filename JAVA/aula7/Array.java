package aula7;

public class Array {
    // public static void printaArray(int[] array) {

    //     //enhanced for
    //     for (int valor : array) {
    //         System.out.println(valor);
    //     }
    
    //escrever um metodo que passado um array print unidimencional
    //um metodo imprime os valores de cada endereço do array
        // for (int z= 0; z < array.length; z++){
        // System.out.println(array[z]);
        // }     
    
    //}
    public static void main(String[] args) {

        //como imprimir um vetor bidimensional?
        int[][] bidimensional = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int i = 0; i < bidimensional.length; i++) {
            for (int j = 0; j < bidimensional[i].length; j++) {
                System.out.print(bidimensional[i][j] + " ");
            }
            System.out.println();
        }
        //inicialização dos vetores:
        int[] counts; //um array ou vetor de inteiros
        double[] values; //aray ou vetor de doubles
        int size = 10; //tamanho do vetor de doubles

        //criação dos vetores:
        // counts = new int[4]; //cria um vetor de inteiros com 5 elementos(array de tamanho fixo)
        // values = new double[size]; //array com tamanho variável.
    
        // //inicialização dos vetores e atribuição de valores:
        // int[] a = {1, 2, 3, 4};
        // int[] b = {1, 2, 3, 4, 5};
    
        // counts [0] = 7;
        // counts [1] = counts[0] * 2; //incrementa o valor do elemento 0 do vetor counts e atribui ao elemento 1
        // counts [2] ++; //incrementa o valor do elemento 2 do vetor counts em 1
        // counts [3] -= 60; //decrementa o valor do elemento 3 do vetor counts em 60

        // printaArray(a);
        // printaArray(b);

        // int i = 0;
        // while (i<4) {
        //     System.out.println(counts[i]);
        //     i++;
        // }
        
        //FAZER WHILE USANDO UM FOR:
        // for (int c = 0; c < 4; c++) {
        //     System.out.println(counts[c]);
        // }



    }
    
}
