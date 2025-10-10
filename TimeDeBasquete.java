import java.util.Scanner;


/*
Sistema de classificacao de Jogadores de Basquete
 */
public class TimeDeBasquete {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("===================== BEM VINDO =======================");
        System.out.print("\n== SISTEMA DE CLASSIFICAÇÃO DE JOGADORES DE BASQUETE ==");
        System.out.print("\nDigite o número de jogadores do time: ");
        int N = leia.nextInt();
        leia.nextLine();
        
        // cria arrays de nome e altura da quantidade de jogadores indicada
        String[] nomes = new String[N];
        double[] alturas = new double[N];
        
        // Declara e inicializa as variaveis 
        double somaAlturas = 0;
        double maiorAltura = 0;
        String jogadorMaisAlto = "";
        int categoriaA = 0;
        int categoriaB = 0;
        int categoriaC = 0;
        
        // Le dos dados dos jogadores N vezes (uma para cada jogador)
        for (int i = 0; i < N; i++) {
            System.out.println("\n--- Jogador " + (i + 1) + " ---");
            
            System.out.print("Nome: ");
            nomes[i] = leia.nextLine();
            
            System.out.print("Altura (em metros): ");
            alturas[i] = leia.nextDouble();
            leia.nextLine(); // Limpa o buffer
            
            // Determina a categoria do jogador
            String categoria;
            if (alturas[i] >= 2.10) {
                categoria = "A";
                categoriaA++;
            } else if (alturas[i] >= 1.90) {
                categoria = "B";
                categoriaB++;
            } else {
                categoria = "C";
                categoriaC++;
            }
            
            System.out.println("Categoria: " + categoria);
            
            // Acumula a soma das alturas para cálculos posteriores
            somaAlturas += alturas[i];
            
            // Verifica se é o jogador mais alto
            if (alturas[i] > maiorAltura) {
                maiorAltura = alturas[i];
                jogadorMaisAlto = nomes[i];
            }
        }
        
        // Calcula a altura media e percentuais
        double mediaAltura = somaAlturas / N;
        double percentualA = (categoriaA * 100.0) / N;
        double percentualB = (categoriaB * 100.0) / N;
        double percentualC = (categoriaC * 100.0) / N;
        
        // Apresenta os resultados
        System.out.println("\n========== ESTATÍSTICAS DO TIME ==========");
        System.out.printf("Média de altura do time: %.2f metros%n", mediaAltura);
        System.out.printf("Jogador mais alto: %s com %.2f metros%n", jogadorMaisAlto, maiorAltura);
        System.out.printf("Percentual de jogadores na Categoria A: %.1f%%%n", percentualA);
        System.out.printf("Percentual de jogadores na Categoria B: %.1f%%%n", percentualB);
        System.out.printf("Percentual de jogadores na Categoria C: %.1f%%%n", percentualC);
        System.out.println("===========================================");
        
        leia.close();
    }
}