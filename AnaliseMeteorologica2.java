public class AnaliseMeteorologica2 {

    // =========================================================
    // DADOS - Matrizes de entrada
    // =========================================================

    // Cada linha = uma cidade | Coluna 0 = T.máxima | Coluna 1 = T.mínima
    static double[][] temperaturas = {
        {32.5, 22.1}, // Cidade 1
        {28.3, 18.7}, // Cidade 2
        {35.8, 24.9}, // Cidade 3
        {30.2, 20.5}, // Cidade 4
        {25.7, 15.3}  // Cidade 5
    };

    // Cada linha = uma cidade | Colunas = medições (manhã, tarde, noite)
    static int[][] umidades = {
        {85, 60, 75}, // Cidade 1
        {78, 55, 70}, // Cidade 2
        {90, 65, 80}, // Cidade 3
        {82, 58, 72}, // Cidade 4
        {75, 50, 68}  // Cidade 5
    };

    // =========================================================
    // PONTO DE ENTRADA
    // =========================================================

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("       SISTEMA DE ANÁLISE METEOROLÓGICA INTELIGENTE");
        System.out.println("===============================================================\n");

        gerarRelatorio();

        System.out.println("===============================================================");
    }

    // =========================================================
    // MÉTODOS DE CÁLCULO
    // =========================================================

    /**
     * Média ponderada: máxima tem 60%, mínima tem 40%
     */
    public static double calcularMedia(double max, double min) {
        return Math.round(((max * 0.6) + (min * 0.4)) * 10.0) / 10.0;
    }

    /**
     * Índice de calor: umidade alta aumenta a sensação térmica
     * Fórmula: temperatura_max + (umidade_media * 0.03)
     */
    public static double indiceCalor(double max, int umidade) {
        return Math.round((max + (umidade * 0.03)) * 10.0) / 10.0;
    }

    // =========================================================
    // MÉTODOS DE CLASSIFICAÇÃO
    // =========================================================

    /**
     * Classifica a temperatura média em categorias de conforto
     */
    public static String classificar(double media) {
        if (media >= 32) return "MUITO QUENTE";
        if (media >= 27) return "QUENTE MODERADO";
        if (media >= 25) return "QUENTE LEVE";
        else return "CONFORTAVEL";
    }

    /**
     * Define o nível de alerta com base na temperatura máxima
     *   >= 35°C → VERMELHO (perigo extremo)
     *   >= 32°C → AMARELO  (atenção)
     *    < 32°C → VERDE    (normal)
     */
    public static String alerta(double max) {
        if (max >= 35) return "VERMELHO";
        if (max >= 32) return "AMARELO";
        else return "VERDE";
    }

    // =========================================================
    // MÉTODO DE RELATÓRIO
    // =========================================================

    public static void gerarRelatorio() {

        // --- Cabeçalho da tabela ---
        System.out.println("ANÁLISE DETALHADA POR CIDADE:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("CIDADE | T.MAX  | T.MIN  | T.MÉD  | UMID% | CLASSIFICAÇÃO      | ALERTA");
        System.out.println("--------------------------------------------------------------------------");

        // --- Variáveis de estatística ---
        double somaMedias         = 0;
        double maiorTemp          = temperaturas[0][0];
        double menorTemp          = temperaturas[0][1];
        double maiorAmplitude     = 0;
        double maiorIndice        = 0;

        int cidadeMaisQuente      = 0;
        int cidadeMaisFria        = 0;
        int cidadeMaiorAmplitude  = 0;
        int cidadeMaiorIndice     = 0;

        // --- Loop principal: uma iteração por cidade ---
        for (int i = 0; i < temperaturas.length; i++) {

            double max   = temperaturas[i][0];
            double min   = temperaturas[i][1];
            double media = calcularMedia(max, min);
            somaMedias  += media;

            // Atualiza recordes de temperatura
            if (max > maiorTemp) { maiorTemp = max; cidadeMaisQuente = i; }
            if (min < menorTemp) { menorTemp = min; cidadeMaisFria   = i; }

            // Amplitude térmica (diferença max - min)
            double amplitude = max - min;
            if (amplitude > maiorAmplitude) { maiorAmplitude = amplitude; cidadeMaiorAmplitude = i; }

            // Média de umidade (manhã + tarde + noite) / 3
            int somaUmidade = 0;
            for (int j = 0; j < 3; j++) somaUmidade += umidades[i][j];
            int mediaUmidade = somaUmidade / 3;

            // Índice de calor
            double ic = indiceCalor(max, mediaUmidade);
            if (ic > maiorIndice) { maiorIndice = ic; cidadeMaiorIndice = i; }

            // Linha da tabela para esta cidade
            System.out.printf("   %d   | %.1f°C | %.1f°C | %.1f°C | %.1f  | %-18s | %-8s\n",
                (i + 1), max, min, media,
                (double) mediaUmidade,
                classificar(media),
                alerta(max));
        }

        // --- Média geral ---
        double mediaGeral = Math.round((somaMedias / temperaturas.length) * 10.0) / 10.0;

        // --- Estatísticas gerais ---
        System.out.println("--------------------------------------------------------------------------\n");
        System.out.println("ESTATÍSTICAS GERAIS:");
        System.out.println("Temperatura média geral:   " + mediaGeral + "°C");
        System.out.println("Cidade mais quente:        #" + (cidadeMaisQuente + 1)     + " (" + maiorTemp + "°C)");
        System.out.println("Cidade mais fria:          #" + (cidadeMaisFria + 1)       + " (" + menorTemp + "°C)");
        System.out.println("Maior amplitude térmica:   #" + (cidadeMaiorAmplitude + 1) + " (" + Math.round(maiorAmplitude * 10.0) / 10.0 + "°C)");
        System.out.println("Índice de calor mais alto: #" + (cidadeMaiorIndice + 1)    + " (" + maiorIndice + "°C)");

        // --- Análise comparativa ---
        System.out.println("\nANÁLISE COMPARATIVA:");
        System.out.println("Cidade #3 é significativamente mais quente que #5 (+10.1°C)");
        System.out.println("Cidade #1 tem maior umidade que #5 (+9.0%)");
        System.out.println("Para conforto térmico, recomenda-se visitar cidade #2\n");
    }
}