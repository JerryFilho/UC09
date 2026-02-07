public class MaratonaFilmes {

    public static void main(String[] args) {

        // Dados da maratona (fixos para gerar a saída esperada)
        String nomeUsuario = "João";
        int quantidadeFilmes = 3;
        double duracaoMedia = 2.5;
        double horasTotais;
        String classificacao;
        boolean valido;

        exibirCabecalho();

       /*   Parte 1 – Cabeçalho
        System.out.println("====================================================");
        System.out.println("\tGERENCIADOR DE MARATONA DE FILMES");
        System.out.println("===================================================="); */

        // Parte 2 – Cálculo
        horasTotais = calcularTempoTotal(quantidadeFilmes, duracaoMedia);

        // Parte 3 e 4 – Classificação e validação
        classificacao = classificarMaratona(horasTotais);
        valido = isValida(quantidadeFilmes);

        // Parte 5 – Saída formatada exatamente como o exemplo
        System.out.println("Informações da Maratona:");
        System.out.println("Usuário: " + nomeUsuario);
        System.out.println("Filmes planejados: " + quantidadeFilmes);
        System.out.println("Duração média por filme: " + duracaoMedia + " horas");

        System.out.println("Cálculos:");
        System.out.println("Tempo total: " + horasTotais + " horas");
        System.out.println("Classificação: " + classificacao);
        System.out.println("Validação: Planejamento válido? " + valido);

        System.out.println("====================================================");
    }

    // Método 1 – sem parâmetros e sem retorno
    public static void exibirCabecalho() {
        System.out.println("=====================================================");
        System.out.println("\tGERENCIADOR DE MARATONA DE FILMES");
        System.out.println("=====================================================");
    }

    // Método 2 – com parâmetros e retorno
    public static double calcularTempoTotal(int filmes, double duracaoMedia) {
        return (double) filmes * duracaoMedia;
    }

    // Método 3 – classificação usando if-else
    public static String classificarMaratona(double horas) {
        if (horas <= 4) {
            return "Maratona Leve";
        } else if (horas <= 8) {
            return "Maratona Moderada";
        } else {
            return "Maratona Épica!";
        }
    }

    // Método booleano de validação
    public static boolean isValida(int filmes) {
        return filmes > 0;
    }
}
