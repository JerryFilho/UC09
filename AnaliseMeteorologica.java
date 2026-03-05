public class AnaliseMeteorologica {

    // ============================================================
    // MATRIZ DE TEMPERATURAS
    // Estrutura: [cidade][0 = temperatura máxima, 1 = temperatura mínima]
    // São 5 cidades (5 linhas) e 2 informações por cidade (2 colunas)
    // ============================================================
    static double[][] temperaturas = {
            {32.5, 22.1},  // Cidade 1 → máx 32.5°C | mín 22.1°C
            {28.3, 18.7},  // Cidade 2
            {35.8, 24.9},  // Cidade 3
            {30.2, 20.5},  // Cidade 4
            {25.7, 15.3}   // Cidade 5
    };

    // ============================================================
    // MATRIZ DE UMIDADES
    // Estrutura: [cidade][0=manhã, 1=tarde, 2=noite]
    // São 5 cidades e 3 medições diárias
    // ============================================================
    static int[][] umidades = {
            {85, 60, 75},
            {78, 55, 70},
            {90, 65, 80},
            {82, 58, 72},
            {75, 50, 68}
    };

    // ============================================================
    // MÉTODO MAIN
    // É o ponto inicial do programa.
    // Ele apenas coordena o fluxo chamando os métodos necessários.
    // ============================================================
    public static void main(String[] args) {

        // Impressão do cabeçalho do sistema
        System.out.println("===============================================================");
        System.out.println("     SISTEMA DE ANÁLISE METEOROLÓGICA INTELIGENTE");
        System.out.println("===============================================================");

        // Chamada do método principal responsável por gerar o relatório
        gerarRelatorioDetalhado();

        System.out.println("===============================================================");
    }

    // ============================================================
    // 1) MÉDIA PONDERADA DA TEMPERATURA
    // Fórmula: (70% da máxima) + (30% da mínima)
    // ============================================================
    public static double calcularMediaPonderadaTemperatura(double max, double min) {

        // Validação de segurança: temperaturas devem estar entre -50°C e 60°C
        if (max < -50 || max > 60 || min < -50 || min > 60) {

            // Caso algum valor esteja fora do intervalo, alerta no console
            System.out.println("Temperatura inválida detectada!");

            // Retorna 0 para evitar erro no cálculo
            return 0;
        }

        // Cálculo da média ponderada conforme exigido
        return (max * 0.7) + (min * 0.3);
    }

    // ============================================================
    // 2) CLASSIFICAÇÃO DO CLIMA
    // Usa múltiplas condições lógicas (&&)
    // ============================================================
    public static String classificarClima(double tempMedia, int umidadeMedia) {

        // Muito quente e úmido → duas condições ao mesmo tempo
        if (tempMedia > 30 && umidadeMedia > 75) {
            return "MUITO QUENTE E ÚMIDO";
        }

        // Confortável → faixa de temperatura + faixa de umidade
        else if (tempMedia >= 20 && tempMedia <= 25 &&
                 umidadeMedia >= 50 && umidadeMedia <= 70) {
            return "CONFORTAVEL";
        }

        // Frio e seco → duas condições simultâneas
        else if (tempMedia < 15 && umidadeMedia < 50) {
            return "FRIO E SECO";
        }

        // Caso nenhuma das condições anteriores seja verdadeira
        else {
            return "NORMAL";
        }
    }

    // ============================================================
    // 3) IDENTIFICAR CIDADE COM MAIOR AMPLITUDE TÉRMICA
    // Amplitude = temperatura máxima - temperatura mínima
    // ============================================================
    public static int identificarCidadeComMaiorAmplitudeTermica() {

        double maiorAmplitude = 0; // guarda o maior valor encontrado
        int indiceCidade = 0;      // guarda o índice da cidade correspondente

        // Percorre todas as cidades
        for (int i = 0; i < temperaturas.length; i++) {

            // Calcula amplitude da cidade atual
            double amplitude = temperaturas[i][0] - temperaturas[i][1];

            // Se a amplitude atual for maior que a registrada
            if (amplitude > maiorAmplitude) {

                maiorAmplitude = amplitude; // atualiza valor
                indiceCidade = i;           // salva índice
            }
        }

        // Retorna o índice da cidade com maior amplitude
        return indiceCidade;
    }

    // ============================================================
    // 4) CÁLCULO DO ÍNDICE DE CALOR
    // Fórmula fornecida no enunciado
    // ============================================================
    public static double calcularIndiceCalor(double temp, int umidade) {

        // Conversão da umidade para decimal dividindo por 100.0
        double indice = temp + 0.5 * (umidade / 100.0) * (temp - 20);

        // Arredonda para 1 casa decimal
        return Math.round(indice * 10.0) / 10.0;
    }

    // ============================================================
    // 5) SISTEMA DE ALERTAS
    // 0 = VERDE | 1 = AMARELO | 2 = VERMELHO
    // ============================================================
    public static int gerarAlertas(int cidadeIndex) {

        double max = temperaturas[cidadeIndex][0];
        double min = temperaturas[cidadeIndex][1];

        // Cálculo da amplitude térmica
        double amplitude = max - min;

        // Cálculo da média de umidade
        int soma = 0;
        for (int j = 0; j < 3; j++) {
            soma += umidades[cidadeIndex][j];
        }
        int mediaUmidade = soma / 3;

        // Alerta vermelho → prioridade máxima
        if (max > 35 || mediaUmidade > 90) {
            return 2;
        }

        // Alerta amarelo → condição intermediária
        else if ((max >= 30 && max <= 35 && mediaUmidade > 80)
                || amplitude > 15) {
            return 1;
        }

        // Caso nenhuma condição crítica ocorra
        else {
            return 0;
        }
    }

    // ============================================================
    // 6) ESTATÍSTICAS AVANÇADAS
    // Retorna array com:
    // [0] média geral
    // [1] maior temperatura
    // [2] menor temperatura
    // [3] desvio padrão
    // ============================================================
    public static double[] calcularEstatisticasAvancadas() {

        double soma = 0;
        double maior = temperaturas[0][0];
        double menor = temperaturas[0][1];

        int total = temperaturas.length;
        double[] medias = new double[total];

        // Primeiro loop → calcula médias individuais
        for (int i = 0; i < total; i++) {

            double media = calcularMediaPonderadaTemperatura(
                    temperaturas[i][0],
                    temperaturas[i][1]);

            medias[i] = media; // armazena no vetor auxiliar
            soma += media;     // acumula soma total

            // Atualiza maior temperatura
            if (temperaturas[i][0] > maior)
                maior = temperaturas[i][0];

            // Atualiza menor temperatura
            if (temperaturas[i][1] < menor)
                menor = temperaturas[i][1];
        }

        double mediaGeral = soma / total;

        // Segundo loop → cálculo do desvio padrão
        double somaQuadrados = 0;
        for (int i = 0; i < total; i++) {
            somaQuadrados += Math.pow(medias[i] - mediaGeral, 2);
        }

        double desvioPadrao = Math.sqrt(somaQuadrados / total);

        return new double[]{mediaGeral, maior, menor, desvioPadrao};
    }

    // ============================================================
    // 7) COMPARAÇÃO ENTRE DUAS CIDADES
    // ============================================================
    public static String compararCidades(int c1, int c2) {

        double temp1 = temperaturas[c1][0];
        double temp2 = temperaturas[c2][0];

        if (temp1 > temp2)
            return "Cidade #" + (c1 + 1) + " é mais quente.";
        else if (temp2 > temp1)
            return "Cidade #" + (c2 + 1) + " é mais quente.";
        else
            return "Temperaturas iguais.";
    }

    // ============================================================
    // 8) RELATÓRIO COMPLETO FORMATADO
    // ============================================================
    public static void gerarRelatorioDetalhado() {

        System.out.println("\nANÁLISE DETALHADA POR CIDADE:");
        System.out.println("--------------------------------------------------------------------------");

        // Cabeçalho da tabela formatado
        System.out.printf("%-6s | %-6s | %-6s | %-6s | %-6s | %-22s | %-8s\n",
                "CID", "T.MAX", "T.MIN", "T.MED", "UMID%", "CLASSIFICAÇÃO", "ALERTA");

        System.out.println("--------------------------------------------------------------------------");

        // Loop principal que percorre as 5 cidades
        for (int i = 0; i < temperaturas.length; i++) {

            double max = temperaturas[i][0];
            double min = temperaturas[i][1];

            double mediaTemp = calcularMediaPonderadaTemperatura(max, min);

            // cálculo da média de umidade
            int soma = 0;
            for (int j = 0; j < 3; j++) {
                soma += umidades[i][j];
            }
            int mediaUmidade = soma / 3;

            String classificacao = classificarClima(mediaTemp, mediaUmidade);

            int codigoAlerta = gerarAlertas(i);

            String alertaTexto = (codigoAlerta == 2) ? "VERMELHO"
                    : (codigoAlerta == 1) ? "AMARELO"
                    : "VERDE";

            // Impressão da linha formatada
            System.out.printf("%-6d | %-6.1f | %-6.1f | %-6.1f | %-6d | %-22s | %-8s\n",
                    (i + 1), max, min, mediaTemp,
                    mediaUmidade, classificacao, alertaTexto);
        }

        System.out.println("--------------------------------------------------------------------------");

        double[] estat = calcularEstatisticasAvancadas();

        System.out.println("\nESTATÍSTICAS GERAIS:");
        System.out.printf(" Média geral: %.1f°C\n", estat[0]);
        System.out.printf(" Maior temperatura: %.1f°C\n", estat[1]);
        System.out.printf(" Menor temperatura: %.1f°C\n", estat[2]);
        System.out.printf(" Desvio padrão: %.2f\n", estat[3]);

        System.out.println("\nANÁLISE COMPARATIVA:");
        System.out.println(compararCidades(3, 2)); // Comparação entre Cidade 3 e Cidade 2
    }
}