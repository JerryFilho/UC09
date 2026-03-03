public class AnaliseMeteorologica {

    public static void main(String[] args) {

        double[][] temperaturas = {
            {32.5, 22.1},
            {28.3, 18.7},
            {35.8, 24.9},
            {30.2, 20.5},
            {25.7, 15.3}
        };

        int[][] umidades = {
            {85,60,75},
            {78,55,70},
            {90,65,80},
            {82,58,72},
            {75,50,68}
        };

        System.out.println("===============================================================");
        System.out.println("        SISTEMA DE ANÁLISE METEOROLÓGICA INTELIGENTE");
        System.out.println("===============================================================");

        System.out.println("\nANÁLISE DETALHADA POR CIDADE:");
        System.out.println("--------------------------------------------------------------------------");

        System.out.printf("%-6s | %-6s | %-6s | %-6s | %-6s | %-18s | %-8s\n",
                "CID", "T.MAX", "T.MIN", "T.MED", "UMID%", "CLASSIFICAÇÃO", "ALERTA");

        System.out.println("--------------------------------------------------------------------------");

        double somaMedia = 0;

        double maiorTemp = temperaturas[0][0];
        int cidadeMaisQuente = 0;

        double menorTemp = temperaturas[0][1];
        int cidadeMaisFria = 0;

        double maiorAmplitude = 0;
        int cidadeMaiorAmplitude = 0;

        double maiorIndiceCalor = 0;
        int cidadeMaiorIndice = 0;

        for(int i=0; i<temperaturas.length; i++){

            double max = temperaturas[i][0];
            double min = temperaturas[i][1];

            double mediaTemp = (max*0.7)+(min*0.3);
            somaMedia += mediaTemp;

            int soma = 0;
            for(int j=0; j<3; j++){
                soma += umidades[i][j];
            }
            int mediaUmidade = soma/3;

            String classificacao;
            if(mediaTemp > 30 && mediaUmidade > 75){
                classificacao = "MUITO QUENTE";
            }
            else if(mediaTemp >= 20 && mediaTemp <= 25){
                classificacao = "CONFORTAVEL";
            }
            else if(mediaTemp > 25 && mediaTemp <= 30){
                classificacao = "QUENTE MODERADO";
            }
            else{
                classificacao = "NORMAL";
            }

            String alertaTexto;
            if(max > 35){
                alertaTexto = "VERMELHO";
            }
            else if(max >= 30){
                alertaTexto = "AMARELO";
            }
            else{
                alertaTexto = "VERDE";
            }

            double amplitude = max - min;
            if(amplitude > maiorAmplitude){
                maiorAmplitude = amplitude;
                cidadeMaiorAmplitude = i;
            }

            if(max > maiorTemp){
                maiorTemp = max;
                cidadeMaisQuente = i;
            }

            if(min < menorTemp){
                menorTemp = min;
                cidadeMaisFria = i;
            }

            double indiceCalor = mediaTemp + 0.5 * (mediaUmidade/100.0) * (mediaTemp - 20);
            if(indiceCalor > maiorIndiceCalor){
                maiorIndiceCalor = indiceCalor;
                cidadeMaiorIndice = i;
            }

            System.out.printf("%-6d | %-6.1f | %-6.1f | %-6.1f | %-6d | %-18s | %-8s\n",
                    (i+1), max, min, mediaTemp, mediaUmidade, classificacao, alertaTexto);
        }

        System.out.println("--------------------------------------------------------------------------");

        double mediaGeral = somaMedia / temperaturas.length;

        System.out.println("\nESTATÍSTICAS GERAIS:");
        System.out.printf(" Temperatura média geral: %.1f°C\n", mediaGeral);
        System.out.printf(" Cidade mais quente: #%d (%.1f°C)\n", cidadeMaisQuente+1, maiorTemp);
        System.out.printf(" Cidade mais fria: #%d (%.1f°C)\n", cidadeMaisFria+1, menorTemp);
        System.out.printf(" Maior amplitude térmica: #%d (%.1f°C)\n", cidadeMaiorAmplitude+1, maiorAmplitude);
        System.out.printf(" Índice de calor mais alto: #%d (%.1f°C)\n", cidadeMaiorIndice+1, maiorIndiceCalor);

        System.out.println("\nANÁLISE COMPARATIVA:");

        double diferencaTemp = temperaturas[2][0] - temperaturas[4][0];
        System.out.printf(" Cidade #3 é %.1f°C mais quente que #5\n", diferencaTemp);

        double mediaU1 = (umidades[0][0]+umidades[0][1]+umidades[0][2])/3.0;
        double mediaU5 = (umidades[4][0]+umidades[4][1]+umidades[4][2])/3.0;

        System.out.printf(" Cidade #1 tem %.1f%% mais umidade que #5\n", (mediaU1 - mediaU5));

        System.out.println(" Para conforto térmico, recomenda-se visitar cidade #2");

        System.out.println("\n===============================================================");
    }
}