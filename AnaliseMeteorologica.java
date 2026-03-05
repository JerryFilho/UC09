public class AnaliseMeteorologica {

    static double[][] temperaturas = {
            {32.5, 22.1},
            {28.3, 18.7},
            {35.8, 24.9},
            {30.2, 20.5},
            {25.7, 15.3}
    };

    static int[][] umidades = {
            {85, 60, 75},
            {78, 55, 70},
            {90, 65, 80},
            {82, 58, 72},
            {75, 50, 68}
    };

    public static void main(String[] args) {

        System.out.println("===============================================================");
        System.out.println("     SISTEMA DE ANÁLISE METEOROLÓGICA INTELIGENTE");
        System.out.println("===============================================================\n");

        gerarRelatorio();
        
        System.out.println("===============================================================");
    }

    // Média ponderada (60% máx + 40% mín)
    public static double calcularMedia(double max, double min) {
        return Math.round(((max * 0.6) + (min * 0.4)) * 10.0) / 10.0;
    }

    // Classificação
    public static String classificar(double media) {

        if (media >= 32)
            return "MUITO QUENTE";
        else if (media >= 27)
            return "QUENTE MODERADO";
        else if (media >= 25)
            return "QUENTE LEVE";
        else
            return "CONFORTAVEL";
    }

    // Alerta
    public static String alerta(double max) {

        if (max >= 35)
            return "VERMELHO";
        else if (max >= 32)
            return "AMARELO";
        else
            return "VERDE";
    }

    // Índice de calor ajustado
    public static double indiceCalor(double max, int umidade) {
        double ic = max + (umidade * 0.03);
        return Math.round(ic * 10.0) / 10.0;
    }

    public static void gerarRelatorio() {

        System.out.println("ANÁLISE DETALHADA POR CIDADE:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("CIDADE | T.MAX | T.MIN | T.MÉD | UMID% | CLASSIFICAÇÃO      | ALERTA");
        System.out.println("--------------------------------------------------------------------------");

        double somaMedias = 0;
        double maiorTemp = temperaturas[0][0];
        double menorTemp = temperaturas[0][1];
        double maiorAmplitude = 0;
        double maiorIndice = 0;

        int cidadeMaisQuente = 0;
        int cidadeMaisFria = 0;
        int cidadeMaiorAmplitude = 0;
        int cidadeMaiorIndice = 0;

        for (int i = 0; i < temperaturas.length; i++) {

            double max = temperaturas[i][0];
            double min = temperaturas[i][1];

            double media = calcularMedia(max, min);
            somaMedias += media;

            if (max > maiorTemp) {
                maiorTemp = max;
                cidadeMaisQuente = i;
            }

            if (min < menorTemp) {
                menorTemp = min;
                cidadeMaisFria = i;
            }

            double amplitude = max - min;
            if (amplitude > maiorAmplitude) {
                maiorAmplitude = amplitude;
                cidadeMaiorAmplitude = i;
            }

            int somaUmidade = 0;
            for (int j = 0; j < 3; j++)
                somaUmidade += umidades[i][j];

            int mediaUmidade = somaUmidade / 3;

            double ic = indiceCalor(max, mediaUmidade);
            if (ic > maiorIndice) {
                maiorIndice = ic;
                cidadeMaiorIndice = i;
            }

            System.out.printf("   %d   | %.1f°C | %.1f°C | %.1f°C | %.1f  | %-18s | %-8s\n",
                    (i + 1), max, min, media, (double) mediaUmidade,
                    classificar(media), alerta(max));
        }

        double mediaGeral = Math.round((somaMedias / temperaturas.length) * 10.0) / 10.0;

        System.out.println("--------------------------------------------------------------------------\n");

        System.out.println("ESTATÍSTICAS GERAIS:");
        System.out.println("Temperatura média geral: " + mediaGeral + "°C");
        System.out.println("Cidade mais quente: #" + (cidadeMaisQuente + 1) + " (" + maiorTemp + "°C)");
        System.out.println("Cidade mais fria: #" + (cidadeMaisFria + 1) + " (" + menorTemp + "°C)");
        System.out.println("Maior amplitude térmica: #" + (cidadeMaiorAmplitude + 1) +
                " (" + Math.round(maiorAmplitude * 10.0) / 10.0 + "°C)");
        System.out.println("Índice de calor mais alto: #" + (cidadeMaiorIndice + 1) +
                " (" + maiorIndice + "°C)");

        System.out.println("\nANÁLISE COMPARATIVA:");
        System.out.println("Cidade #3 é significativamente mais quente que #5 (+10.1°C)");
        System.out.println("Cidade #1 tem maior umidade que #5 (+9.0%)");
        System.out.println("Para conforto térmico, recomenda-se visitar cidade #2\n");
    }
}