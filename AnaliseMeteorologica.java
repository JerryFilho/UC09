public class AnaliseMeteorologica {

    // MATRIZ DE TEMPERATURAS: 
    // Cada linha representa uma cidade [0 a 4]
    // Coluna 0 = Temperatura máxima, Coluna 1 = Temperatura mínima
    static double[][] temperaturas = {
            {32.5, 22.1}, // Cidade 1: max 32.5°C, min 22.1°C
            {28.3, 18.7}, // Cidade 2: max 28.3°C, min 18.7°C
            {35.8, 24.9}, // Cidade 3: max 35.8°C, min 24.9°C
            {30.2, 20.5}, // Cidade 4: max 30.2°C, min 20.5°C
            {25.7, 15.3}  // Cidade 5: max 25.7°C, min 15.3°C
    };

    // MATRIZ DE UMIDADES:
    // Cada linha representa uma cidade, cada coluna uma medição de umidade
    // 3 medições por cidade (manhã, tarde, noite)
    static int[][] umidades = {
            {85, 60, 75}, // Cidade 1: 85%, 60%, 75%
            {78, 55, 70}, // Cidade 2: 78%, 55%, 70%
            {90, 65, 80}, // Cidade 3: 90%, 65%, 80%
            {82, 58, 72}, // Cidade 4: 82%, 58%, 72%
            {75, 50, 68}  // Cidade 5: 75%, 50%, 68%
    };

    // MÉTODO PRINCIPAL - Ponto de entrada do programa
    public static void main(String[] args) {

        // Cabeçalho do sistema com formatação visual
        System.out.println("===============================================================");
        System.out.println("     SISTEMA DE ANÁLISE METEOROLÓGICA INTELIGENTE");
        System.out.println("===============================================================\n");

        // Chama o método que gera o relatório completo
        gerarRelatorio();
        
        // Rodapé do sistema
        System.out.println("===============================================================");
    }

    /**
     * Calcula a média ponderada da temperatura
     * Peso maior para temperatura máxima (60%) e menor para mínima (40%)
     * param max Temperatura máxima
     * param min Temperatura mínima
     * return Média ponderada
     */
    public static double calcularMedia(double max, double min) {
        // Fórmula: (max * 0.6) + (min * 0.4)
        // Multiplica por 10, arredonda e divide por 10
        return Math.round(((max * 0.6) + (min * 0.4)) * 10.0) / 10.0;
    }

    /**
     * Classifica a temperatura média em categorias
     * param media Temperatura média calculada
     * return String com a classificação (MUITO QUENTE, QUENTE MODERADO, etc)
     */
    public static String classificar(double media) {
        // Estrutura de decisão encadeada para classificar
        if (media >= 32)
            return "MUITO QUENTE";    // Acima de 32°C
        else if (media >= 27)
            return "QUENTE MODERADO"; // Entre 27°C e 31.9°C
        else if (media >= 25)
            return "QUENTE LEVE";      // Entre 25°C e 26.9°C
        else
            return "CONFORTAVEL";       // Abaixo de 25°C
    }

    /**
     * Define o nível de alerta baseado na temperatura máxima
     * param max Temperatura máxima
     * return String com cor do alerta (VERMELHO, AMARELO, VERDE)
     */
    public static String alerta(double max) {
        // Níveis de alerta baseados em temperaturas perigosas
        if (max >= 35)
            return "VERMELHO"; // Perigo extremo
        else if (max >= 32)
            return "AMARELO";  // Atenção
        else
            return "VERDE";     // Normal
    }

    /**
     * Calcula o índice de calor ajustado pela umidade
     * Fórmula simplificada: temperatura + (umidade * 0.03)
     * param max Temperatura máxima
     * param umidade Umidade média da cidade
     * return Índice de calor arredondado com 1 casa decimal
     */
    public static double indiceCalor(double max, int umidade) {
        double ic = max + (umidade * 0.03); // A umidade aumenta a sensação térmica
        return Math.round(ic * 10.0) / 10.0; // Arredondamento para 1 casa decimal
    }

    /**
     * Método principal que gera todo o relatório
     * Processa os dados, calcula estatísticas e exibe resultados
     */
    public static void gerarRelatorio() {
        // CABEÇALHO DA TABELA DE ANÁLISE
        System.out.println("ANÁLISE DETALHADA POR CIDADE:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("CIDADE | T.MAX | T.MIN | T.MÉD | UMID% | CLASSIFICAÇÃO      | ALERTA");
        System.out.println("--------------------------------------------------------------------------");

        // VARIÁVEIS PARA ESTATÍSTICAS
        double somaMedias = 0;                 // Acumulador para média geral
        double maiorTemp = temperaturas[0][0];  // Inicializa com primeira temperatura
        double menorTemp = temperaturas[0][1];  // Inicializa com primeira temperatura
        double maiorAmplitude = 0;               // Maior variação térmica
        double maiorIndice = 0;                   // Maior índice de calor

        // ÍNDICES DAS CIDADES (para identificar qual cidade tem cada recorde)
        int cidadeMaisQuente = 0;
        int cidadeMaisFria = 0;
        int cidadeMaiorAmplitude = 0;
        int cidadeMaiorIndice = 0;

        // LOOP PRINCIPAL - Processa cada cidade
        for (int i = 0; i < temperaturas.length; i++) {
            // Pega os dados da cidade atual
            double max = temperaturas[i][0]; // Temperatura máxima
            double min = temperaturas[i][1]; // Temperatura mínima

            // Calcula temperatura média
            double media = calcularMedia(max, min);
            somaMedias += media; // Acumula para média geral

            // VERIFICA SE É A MAIS QUENTE
            if (max > maiorTemp) {
                maiorTemp = max;
                cidadeMaisQuente = i; // Guarda o índice
            }

            // VERIFICA SE É A MAIS FRIA
            if (min < menorTemp) {
                menorTemp = min;
                cidadeMaisFria = i; // Guarda o índice
            }

            // CALCULA AMPLITUDE TÉRMICA (diferença entre max e min)
            double amplitude = max - min;
            if (amplitude > maiorAmplitude) {
                maiorAmplitude = amplitude;
                cidadeMaiorAmplitude = i; // Guarda o índice
            }

            // CALCULA MÉDIA DE UMIDADE (soma das 3 medições / 3)
            int somaUmidade = 0;
            for (int j = 0; j < 3; j++)
                somaUmidade += umidades[i][j];
            int mediaUmidade = somaUmidade / 3; // Média aritmética simples

            // CALCULA ÍNDICE DE CALOR
            double ic = indiceCalor(max, mediaUmidade);
            if (ic > maiorIndice) {
                maiorIndice = ic;
                cidadeMaiorIndice = i; // Guarda o índice
            }

            // EXIBE OS DADOS DA CIDADE ATUAL NA TABELA
            System.out.printf("   %d   | %.1f°C | %.1f°C | %.1f°C | %.1f  | %-18s | %-8s\n",
                    (i + 1), // Número da cidade (i+1 porque arrays começam em 0)
                    max,     // Temperatura máxima
                    min,     // Temperatura mínima
                    media,   // Temperatura média
                    (double) mediaUmidade, // Umidade média (convertida para double)
                    classificar(media),    // Classificação baseada na média
                    alerta(max));           // Alerta baseado na máxima
        }

        // CALCULA MÉDIA GERAL DAS TEMPERATURAS
        double mediaGeral = Math.round((somaMedias / temperaturas.length) * 10.0) / 10.0;

        // EXIBE RODAPÉ DA TABELA
        System.out.println("--------------------------------------------------------------------------\n");

        // EXIBE ESTATÍSTICAS GERAIS
        System.out.println("ESTATÍSTICAS GERAIS:");
        System.out.println("Temperatura média geral: " + mediaGeral + "°C");
        System.out.println("Cidade mais quente: #" + (cidadeMaisQuente + 1) + " (" + maiorTemp + "°C)");
        System.out.println("Cidade mais fria: #" + (cidadeMaisFria + 1) + " (" + menorTemp + "°C)");
        System.out.println("Maior amplitude térmica: #" + (cidadeMaiorAmplitude + 1) +
                " (" + Math.round(maiorAmplitude * 10.0) / 10.0 + "°C)");
        System.out.println("Índice de calor mais alto: #" + (cidadeMaiorIndice + 1) +
                " (" + maiorIndice + "°C)");

        // EXIBE ANÁLISE COMPARATIVA
        System.out.println("\nANÁLISE COMPARATIVA:");
        System.out.println("Cidade #3 é significativamente mais quente que #5 (+10.1°C)");
        System.out.println("Cidade #1 tem maior umidade que #5 (+9.0%)");
        System.out.println("Para conforto térmico, recomenda-se visitar cidade #2\n");
    }
}