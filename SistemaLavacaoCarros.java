import java.util.Scanner;

public class SistemaLavacaoCarros {
    /* Utilização de MATRIZ/VERTOR
     * A tabela de preços tem 2 dimensões (veículo x serviço)
     * Nesse caso, usar a matriz permite acesso direto ao preço: TABELA_PRECOS[veiculo][servico]
     */
    private static final double[][] TABELA_PRECOS = {
        {50.0, 70.0, 90.0},   // Veículo Pequeno (índice 0)
        {70.0, 90.0, 110.0},  // Veículo Médio (índice 1)
        {90.0, 110.0, 130.0}  // Veículo Grande (índice 2)
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("SISTEMA DE GERENCIAMENTO - LAVAÇÃO DE CARROS\n");
        
        // Solicita a quantidade de atendimentos
        int qtdAtendimentos = solicitarQuantidadeAtendimentos(sc);
        
        // Matrizes para armazenar os dados dos clientes
        String[] nomes = new String[qtdAtendimentos];
        int[] tiposVeiculo = new int[qtdAtendimentos];
        int[] tiposServico = new int[qtdAtendimentos];
        double[] valores = new double[qtdAtendimentos];
        

        realizarAtendimentos(sc, nomes, tiposVeiculo, tiposServico, valores);
        exibirRelacaoGeral(nomes, tiposVeiculo, tiposServico, valores);
        exibirEstatisticas(tiposVeiculo, tiposServico, valores);
        gerarRelatorioFiltrado(sc, nomes, tiposVeiculo, tiposServico, valores); 
        sc.close();
    }
    
    // Solicita e valida a quantidade de atendimentos
    private static int solicitarQuantidadeAtendimentos(Scanner sc) {
        int qtd;
        do {
            System.out.print("Informe a quantidade de atendimentos: ");
            qtd = sc.nextInt();
            sc.nextLine();
            if (qtd <= 0) {
                System.out.println("Quantidade deve ser maior que zero!");
            }
        } while (qtd <= 0);
        return qtd;
    }
    
    // Realiza os atendimentos e armazena os dados
    private static void realizarAtendimentos(Scanner sc, String[] nomes, 
                                            int[] tiposVeiculo, int[] tiposServico, 
                                            double[] valores) {
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("\n--- ATENDIMENTO " + (i + 1) + " ---");

            System.out.print("Nome do cliente: ");
            nomes[i] = sc.nextLine();
            tiposVeiculo[i] = solicitarTipoVeiculo(sc);
            tiposServico[i] = solicitarTipoServico(sc);
            valores[i] = calcularValor(tiposVeiculo[i], tiposServico[i]);
            exibirResumoAtendimento(tiposVeiculo[i], tiposServico[i], valores[i]);
        }
    }
    
    // Solicita e valida o tipo do veículo
    // Usa estrutura de repeticao if dentro de um loop do while
    private static int solicitarTipoVeiculo(Scanner sc) {
        int tipo;
        do {
            System.out.println("Tipo do veículo:");
            System.out.println("1 - Pequeno (populares)");
            System.out.println("2 - Médio (SUV e picape)");
            System.out.println("3 - Grande (van e micro-ônibus)");
            System.out.print("Escolha: ");
            tipo = sc.nextInt();
            sc.nextLine();
            
            if (tipo < 1 || tipo > 3) {
                System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
            }
        } while (tipo < 1 || tipo > 3);
        return tipo;
    }
    
    // Solicita e valida o tipo do serviço
    private static int solicitarTipoServico(Scanner sc) {
        int tipo;
        do {
            System.out.println("Tipo do serviço:");
            System.out.println("1 - Lavação externa");
            System.out.println("2 - Lavação externa + interna");
            System.out.println("3 - Lavação externa + interna + cera");
            System.out.print("Escolha: ");
            tipo = sc.nextInt();
            sc.nextLine(); 
            
            if (tipo < 1 || tipo > 3) {
                System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
            }
        } while (tipo < 1 || tipo > 3);
        return tipo;
    }
    
    // Calcula o valor do serviço como retorno de uma funcao
    private static double calcularValor(int tipoVeiculo, int tipoServico) {
        return TABELA_PRECOS[tipoVeiculo - 1][tipoServico - 1];
    }
    
    // Exibe resumo do atendimento
    private static void exibirResumoAtendimento(int tipoVeiculo, int tipoServico, double valor) {
        System.out.println("\n*** RESUMO DO ATENDIMENTO ***");
        System.out.println("Veículo: " + obterDescricaoVeiculo(tipoVeiculo));
        System.out.println("Serviço: " + obterDescricaoServico(tipoServico));
        System.out.printf("Valor a pagar: R$ %.2f\n", valor);
    }
    
    // Retorna a descrição do tipo de veículo
    private static String obterDescricaoVeiculo(int tipo) {
        switch (tipo) {
            case 1: return "Pequeno (populares)";
            case 2: return "Médio (SUV e picape)";
            case 3: return "Grande (van e micro-ônibus)";
            default: return "Desconhecido";
        }
    }
    
    // Retorna a descrição do tipo de serviço
    private static String obterDescricaoServico(int tipo) {
        switch (tipo) {
            case 1: return "Lavação externa";
            case 2: return "Lavação externa + interna";
            case 3: return "Lavação externa + interna + cera";
            default: return "Desconhecido";
        }
    }
    
    // Exibe a relação geral de todos os clientes
    private static void exibirRelacaoGeral(String[] nomes, int[] tiposVeiculo, 
                                          int[] tiposServico, double[] valores) {
        System.out.println("\n\n========================================");
        System.out.println("     RELAÇÃO GERAL DE CLIENTES");
        System.out.println("========================================");
        
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("\nCliente: " + nomes[i]);
            System.out.println("Tipo: " + obterDescricaoVeiculo(tiposVeiculo[i]));
            System.out.println("Serviço: " + obterDescricaoServico(tiposServico[i]));
            System.out.printf("Valor pago: R$ %.2f\n", valores[i]);
        }
    }
    
    // Exibe todas as estatísticas
    private static void exibirEstatisticas(int[] tiposVeiculo, int[] tiposServico, 
                                          double[] valores) {
        System.out.println("\n\n========================================");
        System.out.println("          ESTATÍSTICAS");
        System.out.println("========================================");
        
        
        int[] contVeiculos = contarPorTipo(tiposVeiculo, 3);
        int[] contServicos = contarPorTipo(tiposServico, 3);
        
    
        exibirPercentuais("TIPO DE VEÍCULO", contVeiculos, tiposVeiculo.length);
        exibirPercentuais("TIPO DE SERVIÇO", contServicos, tiposServico.length);
        
        // Valor total arrecadado
        double total = calcularTotal(valores);
        System.out.printf("\nValor total arrecadado: R$ %.2f\n", total);
        
        exibirMaisAtendidos("Veículo", contVeiculos);
    
        exibirMaisAtendidos("Serviço", contServicos);
    }
    
    // Conta ocorrências por tipo
    private static int[] contarPorTipo(int[] tipos, int qtdTipos) {
        int[] cont = new int[qtdTipos];
        for (int tipo : tipos) {
            cont[tipo - 1]++;
        }
        return cont;
    }
    
    private static void exibirPercentuais(String titulo, int[] contadores, int total) {
        System.out.println("\n--- Percentuais por " + titulo + " ---");
        for (int i = 0; i < contadores.length; i++) {
            double percentual = (contadores[i] * 100.0) / total;
            String descricao = titulo.contains("VEÍCULO") ? 
                              obterDescricaoVeiculo(i + 1) : 
                              obterDescricaoServico(i + 1);
            System.out.printf("%s: %.2f%% (%d atendimentos)\n", 
                            descricao, percentual, contadores[i]);
        }
    }
    
    // Calcula o total arrecadado
    private static double calcularTotal(double[] valores) {
        double total = 0;
        for (double v : valores) {
            total += v;
        }
        return total;
    }
    
    private static void exibirMaisAtendidos(String categoria, int[] contadores) {
        int max = encontrarMaximo(contadores);
        
        System.out.print("\n" + categoria + "(s) mais atendido(s): ");
        boolean primeiro = true;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] == max) {
                if (!primeiro) System.out.print(", ");
                String descricao = categoria.equals("Veículo") ? 
                                  obterDescricaoVeiculo(i + 1) : 
                                  obterDescricaoServico(i + 1);
                System.out.print(descricao);
                primeiro = false;
            }
        }
        System.out.println(" (" + max + " atendimentos)");
    }
    
    // Encontra o valor máximo em um array
    private static int encontrarMaximo(int[] array) {
        int max = array[0];
        for (int val : array) {
            if (val > max) max = val;
        }
        return max;
    }
    
    // Gera relatório filtrado por tipo de veículo
    private static void gerarRelatorioFiltrado(Scanner sc, String[] nomes, 
                                              int[] tiposVeiculo, int[] tiposServico, 
                                              double[] valores) {
        System.out.println("\n\n========================================");
        System.out.println("    RELATÓRIO FILTRADO POR VEÍCULO");
        System.out.println("========================================");
        
        int tipoFiltro = solicitarTipoVeiculo(sc);
        
        System.out.println("\n--- Clientes com veículo: " + 
                         obterDescricaoVeiculo(tipoFiltro) + " ---");
        
        boolean encontrou = false;
        for (int i = 0; i < nomes.length; i++) {
            if (tiposVeiculo[i] == tipoFiltro) {
                System.out.println("\nCliente: " + nomes[i]);
                System.out.println("Serviço: " + obterDescricaoServico(tiposServico[i]));
                System.out.printf("Valor pago: R$ %.2f\n", valores[i]);
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("\nNenhum cliente encontrado para este tipo de veículo.");
        }
    }
}