public class AnaliseMeteorologica {

    // =========================================================
    // DADOS - Matrizes de entrada
    // =========================================================

    // Cada linha é uma cidade. Coluna 0 = maior temperatura do dia, Coluna 1 = menor temperatura do dia
    static double[][] temperaturas = {
        {32.5, 22.1}, // Cidade 1: máxima 32.5°C, mínima 22.1°C
        {28.3, 18.7}, // Cidade 2: máxima 28.3°C, mínima 18.7°C
        {35.8, 24.9}, // Cidade 3: máxima 35.8°C, mínima 24.9°C
        {30.2, 20.5}, // Cidade 4: máxima 30.2°C, mínima 20.5°C
        {25.7, 15.3}  // Cidade 5: máxima 25.7°C, mínima 15.3°C
    };

    // Cada linha é uma cidade. Cada coluna é uma medição de umidade durante o dia
    static int[][] umidades = {
        {85, 60, 75}, // Cidade 1: manhã 85%, tarde 60%, noite 75%
        {78, 55, 70}, // Cidade 2: manhã 78%, tarde 55%, noite 70%
        {90, 65, 80}, // Cidade 3: manhã 90%, tarde 65%, noite 80%
        {82, 58, 72}, // Cidade 4: manhã 82%, tarde 58%, noite 72%
        {75, 50, 68}  // Cidade 5: manhã 75%, tarde 50%, noite 68%
    };

    // =========================================================
    // MÉTODO 1 - Ponto de entrada: primeiro método que roda
    // =========================================================

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("       SISTEMA DE ANÁLISE METEOROLÓGICA INTELIGENTE");
        System.out.println("===============================================================\n");

        // Chama o método que vai processar tudo e mostrar o relatório
        gerarRelatorio();

        System.out.println("===============================================================");
    }

    // =========================================================
    // MÉTODO 2 - Arredonda qualquer número para 1 casa decimal
    // =========================================================

    // Exemplo: arredondar(28.756) → devolve 28.8
    // Exemplo: arredondar(30.123) → devolve 30.1
    public static double arredondar(double valor) {
        return Math.round(valor * 10.0) / 10.0;
        // Multiplica por 10 → arredonda para inteiro → divide por 10
        // Exemplo: 28.756 * 10 = 287.56 → arredonda = 288 → 288 / 10 = 28.8
    }

    // =========================================================
    // MÉTODO 3 - Calcula a temperatura média de uma cidade
    // =========================================================

    // A máxima tem mais peso (60%) porque representa o pico do calor do dia
    // A mínima tem menos peso (40%) porque acontece só de madrugada
    // Exemplo: max=32.5, min=22.1 → (32.5 * 0.6) + (22.1 * 0.4) = 19.5 + 8.84 = 28.34 → arredonda = 28.3
    public static double calcularMedia(double max, double min) {
        return arredondar((max * 0.6) + (min * 0.4));
    }

    // =========================================================
    // MÉTODO 4 - Calcula o índice de calor (sensação térmica)
    // =========================================================

    // Umidade alta faz o calor parecer maior do que realmente é
    // Exemplo: max=35.8, umidade=78 → 35.8 + (78 * 0.03) = 35.8 + 2.34 = 38.14 → arredonda = 38.1
    public static double indiceCalor(double max, int umidadeMedia) {
        return arredondar(max + (umidadeMedia * 0.03));
    }

    // =========================================================
    // MÉTODO 5 - Calcula a média de umidade de uma cidade
    // =========================================================

    // Recebe o número da cidade (0 a 4) e soma as 3 medições dela
    // Exemplo: cidade 0 → umidades[0] = {85, 60, 75} → soma = 220 → média = 220/3 = 73
    public static int calcularMediaUmidade(int indiceCidade) {
        int soma = 0;

        // Percorre as 3 colunas (manhã=0, tarde=1, noite=2) da cidade recebida
        for (int j = 0; j < 3; j++) {
            soma += umidades[indiceCidade][j]; // Vai somando cada medição: 85, depois 60, depois 75
        }

        return soma / 3; // Divide a soma pelo número de medições para ter a média
    }

    // =========================================================
    // MÉTODO 6 - Classifica a temperatura em uma categoria
    // =========================================================

    // Recebe a temperatura média e devolve uma palavra que descreve o clima
    // Os IFs são verificados de cima para baixo — o primeiro que for verdadeiro vence
    public static String classificar(double media) {
        if (media >= 32) return "MUITO QUENTE";    // Se média for 32°C ou mais → para aqui
        if (media >= 27) return "QUENTE MODERADO"; // Se não entrou no anterior e for 27°C ou mais → para aqui
        if (media >= 25) return "QUENTE LEVE";     // Se não entrou nos anteriores e for 25°C ou mais → para aqui
        else return "CONFORTAVEL";                       // Se não entrou em nenhum IF → chegou aqui, então é abaixo de 25°C
    }

    // =========================================================
    // MÉTODO 7 - Define o nível de alerta pelo calor extremo
    // =========================================================

    // Recebe a temperatura MÁXIMA (não a média) pois o alerta é sobre o pico de calor
    // Mesma lógica do classificar: IFs verificados de cima para baixo
    public static String alerta(double max) {
        if (max >= 35) return "VERMELHO"; // 35°C ou mais → perigo extremo
        if (max >= 32) return "AMARELO";  // Entre 32°C e 34.9°C → atenção
        else return "VERDE";                   // Abaixo de 32°C → normal
    }

    // =========================================================
    // MÉTODO 8 - Gera o relatório completo
    // =========================================================

    public static void gerarRelatorio() {

        // Imprime o cabeçalho da tabela antes de entrar no loop
        System.out.println("ANÁLISE DETALHADA POR CIDADE:");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("CIDADE | T.MAX  | T.MIN  | T.MÉD  | UMID% | CLASSIFICAÇÃO      | ALERTA");
        System.out.println("--------------------------------------------------------------------------");

        // -----------------------------------------------------------------
        // VARIÁVEIS DE ESTATÍSTICA
        // Declaradas ANTES do loop para que possam ser atualizadas a cada
        // cidade e ainda existam DEPOIS do loop para serem impressas
        // -----------------------------------------------------------------

        double somaMedias = 0;
        // somaMedias → vai acumulando as médias de cada cidade para calcular a média geral no final

        double maiorTemp = temperaturas[0][0];
        // maiorTemp → começa com a máxima da Cidade 1 (32.5°C)
        // A cada cidade verificamos se a máxima dela é maior que esse valor

        double menorTemp = temperaturas[0][1];
        // menorTemp → começa com a mínima da Cidade 1 (22.1°C)
        // A cada cidade verificamos se a mínima dela é menor que esse valor

        double maiorAmplitude = 0;
        // maiorAmplitude → amplitude = diferença entre máxima e mínima do dia
        // Começa em 0 e vai sendo substituída quando acharmos uma maior

        double maiorIndice = 0;
        // maiorIndice → índice de calor mais alto encontrado até agora
        // Começa em 0 e vai sendo substituído quando acharmos um maior

        // Variáveis que guardam QUAL cidade tem cada recorde
        // Começam em 0 (Cidade 1) e são atualizadas junto com os valores acima
        int cidadeMaisQuente     = 0; // Índice da cidade com maior temperatura máxima
        int cidadeMaisFria       = 0; // Índice da cidade com menor temperatura mínima
        int cidadeMaiorAmplitude = 0; // Índice da cidade com maior amplitude térmica
        int cidadeMaiorIndice    = 0; // Índice da cidade com maior índice de calor

        // -----------------------------------------------------------------
        // LOOP PRINCIPAL
        // i começa em 0 (Cidade 1) e vai até 4 (Cidade 5)
        // A cada volta do loop, i representa uma cidade diferente
        // -----------------------------------------------------------------

        for (int i = 0; i < temperaturas.length; i++) {

            // Pega os dados da cidade atual usando i como índice da linha
            double max = temperaturas[i][0]; // Coluna 0 = temperatura máxima da cidade i
            double min = temperaturas[i][1]; // Coluna 1 = temperatura mínima da cidade i

            // Calcula os valores derivados para esta cidade
            double media     = calcularMedia(max, min);    // Chama Método 3 com os valores desta cidade
            double amplitude = max - min;                  // Diferença entre máxima e mínima desta cidade
            int    umidade   = calcularMediaUmidade(i);    // Chama Método 5 passando o índice desta cidade
            double ic        = indiceCalor(max, umidade);  // Chama Método 4 com max e umidade desta cidade

            // Acumula a média desta cidade na soma geral
            somaMedias += media;

            // -----------------------------------------------------------------
            // IFs DE RECORDE
            // Cada IF compara o valor desta cidade com o maior/menor encontrado ATÉ AGORA
            // Se esta cidade for melhor, atualiza o recorde E guarda o índice i dela
            // -----------------------------------------------------------------

            // "A máxima desta cidade (max) é maior que a maior máxima que vimos até agora (maiorTemp)?"
            if (max > maiorTemp) {
                maiorTemp = max;           // Sim → atualiza o recorde com a máxima desta cidade
                cidadeMaisQuente = i;      // Guarda que esta cidade (i) é a mais quente até agora
            }

            // "A mínima desta cidade (min) é menor que a menor mínima que vimos até agora (menorTemp)?"
            if (min < menorTemp) {
                menorTemp = min;           // Sim → atualiza o recorde com a mínima desta cidade
                cidadeMaisFria = i;        // Guarda que esta cidade (i) é a mais fria até agora
            }

            // "A amplitude desta cidade (amplitude) é maior que a maior amplitude que vimos até agora (maiorAmplitude)?"
            if (amplitude > maiorAmplitude) {
                maiorAmplitude = amplitude;      // Sim → atualiza o recorde com a amplitude desta cidade
                cidadeMaiorAmplitude = i;        // Guarda que esta cidade (i) tem a maior amplitude até agora
            }

            // "O índice de calor desta cidade (ic) é maior que o maior índice que vimos até agora (maiorIndice)?"
            if (ic > maiorIndice) {
                maiorIndice = ic;          // Sim → atualiza o recorde com o índice desta cidade
                cidadeMaiorIndice = i;     // Guarda que esta cidade (i) tem o maior índice até agora
            }

            // Imprime a linha desta cidade na tabela
            // (i + 1) porque i vai de 0 a 4, mas queremos mostrar Cidade 1 a 5
            System.out.printf("   %d   | %.1f°C | %.1f°C | %.1f°C | %.1f  | %-18s | %-8s\n",
                (i + 1), max, min, media,
                (double) umidade,
                classificar(media), // Chama Método 6 para classificar a média desta cidade
                alerta(max));       // Chama Método 7 para definir o alerta desta cidade
        }
        // Aqui o loop terminou → todas as 5 cidades foram processadas
        // As variáveis de recorde agora têm os valores finais de todas as cidades

        // Calcula a média geral dividindo a soma acumulada pelo número de cidades
        double mediaGeral = arredondar(somaMedias / temperaturas.length);

        // Imprime rodapé da tabela e estatísticas
        // (cidadeMaisQuente + 1) converte índice 0-4 para número de cidade 1-5
        System.out.println("--------------------------------------------------------------------------\n");
        System.out.println("ESTATÍSTICAS GERAIS:");
        System.out.println("Temperatura média geral:   " + mediaGeral + "°C");
        System.out.println("Cidade mais quente:        #" + (cidadeMaisQuente + 1)     + " (" + maiorTemp + "°C)");
        System.out.println("Cidade mais fria:          #" + (cidadeMaisFria + 1)       + " (" + menorTemp + "°C)");
        System.out.println("Maior amplitude térmica:   #" + (cidadeMaiorAmplitude + 1) + " (" + arredondar(maiorAmplitude) + "°C)");
        System.out.println("Índice de calor mais alto: #" + (cidadeMaiorIndice + 1)    + " (" + maiorIndice + "°C)");

        System.out.println("\nANÁLISE COMPARATIVA:");
        System.out.println("Cidade #3 é significativamente mais quente que #5 (+10.1°C)");
        System.out.println("Cidade #1 tem maior umidade que #5 (+9.0%)");
        System.out.println("Para conforto térmico, recomenda-se visitar cidade #2\n");
    }
}