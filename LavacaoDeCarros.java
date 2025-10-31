import java.util.Scanner;

// Sistema de Gerenciamento de Lavacao de Carros
public class LavacaoDeCarros {
    
    public static void main(String[] args) {

        // Solicita a quantidade de atendimentos
        Scanner entrada = new Scanner(System.in);
int quantidade = 0;
boolean entradaValida = false;

while (!entradaValida) {
    try {
        System.out.print("Informe a quantidade de atendimentos: ");
        quantidade = entrada.nextInt();
        entrada.nextLine(); // Limpa o buffer
        
        if (quantidade > 0) {
            entradaValida = true;
        } else {
            System.out.println("A quantidade deve ser maior que zero!");
        }
        
    } catch (Exception erro) {
        System.out.println("Digite apenas números inteiros!");
        entrada.nextLine();
    }
}
        
        // arrays para armazenar os dados de cada atendimento
        String[] nomes = new String[quantidade];
        int[] veiculos = new int[quantidade];
        int[] servicos = new int[quantidade];
        int[] valoresPagos = new int[quantidade];
        
        // Variáveis para contar os tipos de veículos
        int contadorVeiculo1 = 0;
        int contadorVeiculo2 = 0;
        int contadorVeiculo3 = 0;
        
        // Variáveis para contar os tipos de serviços
        int contadorServico1 = 0;
        int contadorServico2 = 0;
        int contadorServico3 = 0;
        
        // Variável para somar o valor total
        int valorTotal = 0;
        
        // Loop for para processar cada atendimento
        System.out.println("\n========== ENTRADA DE DADOS ==========\n");
        
        for (int i = 0; i < quantidade; i++) {
            System.out.println("--- Atendimento " + (i + 1) + " ---");
            
            // Solicita o nome do cliente
            System.out.print("Nome do cliente: ");
            nomes[i] = entrada.nextLine();
            
            // loop While valida o tipo do veículo
            int tipoVeiculo = 0;
            while (tipoVeiculo < 1 || tipoVeiculo > 3) {
                System.out.print("Tipo do veículo (1-Pequeno, 2-Médio, 3-Grande): ");
                tipoVeiculo = entrada.nextInt();
                
                if (tipoVeiculo < 1 || tipoVeiculo > 3) {
                    System.out.println("ERRO! Digite apenas 1, 2 ou 3!");
                }
            }
            veiculos[i] = tipoVeiculo;
            
            // Conta o tipo de veículo
            if (tipoVeiculo == 1) {
                contadorVeiculo1++;
            } else if (tipoVeiculo == 2) {
                contadorVeiculo2++;
            } else {
                contadorVeiculo3++;
            }
            
            // loop While valida o tipo do servico
            int tipoServico = 0;
            while (tipoServico < 1 || tipoServico > 3) {
                System.out.print("Tipo do serviço (1-Externa, 2-Externa+Interna, 3-Completa+Cera): ");
                tipoServico = entrada.nextInt();
                
                if (tipoServico < 1 || tipoServico > 3) {
                    System.out.println("ERRO! Digite apenas 1, 2 ou 3!");
                }
            }
            servicos[i] = tipoServico;
            
            // Conta o tipo de serviço
            if (tipoServico == 1) {
                contadorServico1++;
            } else if (tipoServico == 2) {
                contadorServico2++;
            } else {
                contadorServico3++;
            }
            
            entrada.nextLine();
            
            // Calcula o valor a ser pago baseado na tabela
            int valor = 0;
            
            // Se veículo é tipo 1 (Pequeno)
            if (tipoVeiculo == 1) {
                if (tipoServico == 1) {
                    valor = 50;
                } else if (tipoServico == 2) {
                    valor = 70;
                } else {
                    valor = 90;
                }
            }
            // Se veículo é tipo 2 (Médio)
            else if (tipoVeiculo == 2) {
                if (tipoServico == 1) {
                    valor = 70;
                } else if (tipoServico == 2) {
                    valor = 90;
                } else {
                    valor = 110;
                }
            }
            // Se veículo é tipo 3 (Grande)
            else {
                if (tipoServico == 1) {
                    valor = 90;
                } else if (tipoServico == 2) {
                    valor = 110;
                } else {
                    valor = 130;
                }
            }
            
            valoresPagos[i] = valor;
            valorTotal = valorTotal + valor;
            
            System.out.println();
        }
        
        // Mostra o resumo de cada atendimento
        System.out.println("\n========== RESUMO DOS ATENDIMENTOS ==========\n");
        
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Cliente: " + nomes[i]);
            
            // Mostra o tipo do veículo por extenso
            if (veiculos[i] == 1) {
                System.out.println("Tipo do veículo: Pequeno (popular)");
            } else if (veiculos[i] == 2) {
                System.out.println("Tipo do veículo: Médio (SUV e picape)");
            } else {
                System.out.println("Tipo do veículo: Grande (van e micro-ônibus)");
            }
            
            // Descreve o serviço
            if (servicos[i] == 1) {
                System.out.println("Serviço: Lavação externa");
            } else if (servicos[i] == 2) {
                System.out.println("Serviço: Lavação externa + interna");
            } else {
                System.out.println("Serviço: Lavação externa + interna + cera");
            }
            
            System.out.println("Valor: R$" + valoresPagos[i]);
            System.out.println("---");
        }
        
        // Mostra as estatísticas gerais
        System.out.println("\n========== ESTATÍSTICAS GERAIS ==========\n");
        
        // Calcula e mostra os percentuais dos veículos
        System.out.println("PERCENTUAIS DE ATENDIMENTO POR TIPO DE VEÍCULO:");
        
        double percentualVeiculo1 = (contadorVeiculo1 * 100.0) / quantidade;
        System.out.println("Pequeno (populares): " + percentualVeiculo1 + "% (" + contadorVeiculo1 + " atendimentos)");
        
        double percentualVeiculo2 = (contadorVeiculo2 * 100.0) / quantidade;
        System.out.println("Médio (SUV e picape): " + percentualVeiculo2 + "% (" + contadorVeiculo2 + " atendimentos)");
        
        double percentualVeiculo3 = (contadorVeiculo3 * 100.0) / quantidade;
        System.out.println("Grande (van e micro-ônibus): " + percentualVeiculo3 + "% (" + contadorVeiculo3 + " atendimentos)");
        
        System.out.println();
        
        // Calcula e mostra os percentuais dos serviços
        System.out.println("PERCENTUAIS DE ATENDIMENTO POR TIPO DE SERVIÇO:");
        
        double percentualServico1 = (contadorServico1 * 100.0) / quantidade;
        System.out.println("Lavação externa: " + percentualServico1 + "% (" + contadorServico1 + " atendimentos)");
        
        double percentualServico2 = (contadorServico2 * 100.0) / quantidade;
        System.out.println("Lavação externa + interna: " + percentualServico2 + "% (" + contadorServico2 + " atendimentos)");
        
        double percentualServico3 = (contadorServico3 * 100.0) / quantidade;
        System.out.println("Lavação externa + interna + cera: " + percentualServico3 + "% (" + contadorServico3 + " atendimentos)");
        
        System.out.println();
        
        // Mostra o valor total arrecadado
        System.out.println("VALOR TOTAL ARRECADADO: R$" + valorTotal);
        
        System.out.println();
        
        // Descobre veículos mais atendidos
        System.out.println("TIPO(S) DE VEÍCULO MAIS ATENDIDO(S):");
        
        // Descobre qual é o maior valor
        int maiorVeiculo = contadorVeiculo1;
        if (contadorVeiculo2 > maiorVeiculo) {
            maiorVeiculo = contadorVeiculo2;
        }
        if (contadorVeiculo3 > maiorVeiculo) {
            maiorVeiculo = contadorVeiculo3;
        }
        
        // Mostra todos os veículos que têm o maior valor (ou empate)
        if (contadorVeiculo1 == maiorVeiculo) {
            System.out.println("- Pequeno (populares) com " + maiorVeiculo + " atendimentos");
        }
        if (contadorVeiculo2 == maiorVeiculo) {
            System.out.println("- Médio (SUV e picape) com " + maiorVeiculo + " atendimentos");
        }
        if (contadorVeiculo3 == maiorVeiculo) {
            System.out.println("- Grande (van e micro-ônibus) com " + maiorVeiculo + " atendimentos");
        }
        
        System.out.println();
        
        // Descobre servicos mais atendidos
        System.out.println("TIPO(S) DE SERVIÇO MAIS ATENDIDO(S):");
        
        // Descobre qual é o maior valor
        int maiorServico = contadorServico1;
        if (contadorServico2 > maiorServico) {
            maiorServico = contadorServico2;
        }
        if (contadorServico3 > maiorServico) {
            maiorServico = contadorServico3;
        }
        
        // Mostra todos os serviços que têm o maior valor (ou empate)
        if (contadorServico1 == maiorServico) {
            System.out.println("- Lavação externa com " + maiorServico + " atendimentos");
        }
        if (contadorServico2 == maiorServico) {
            System.out.println("- Lavação externa + interna com " + maiorServico + " atendimentos");
        }
        if (contadorServico3 == maiorServico) {
            System.out.println("- Lavação externa + interna + cera com " + maiorServico + " atendimentos");
        }
        
        entrada.close();
    }
}


