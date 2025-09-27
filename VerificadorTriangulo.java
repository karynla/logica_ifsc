import java.util.Scanner;

/* Programa para ler as medidas dos três lados de um possível triângulo
e verificar se os lados formam, ou não, um triângulo. */
public class VerificadorTriangulo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        System.out.println("==== VERIFICADOR DE TRIÂNGULO ====");
        System.out.println("Digite as medidas dos três lados: ");

        // Le os três lados
        System.out.print("Lado 1: ");
        double lado1 = ler.nextDouble();

        System.out.print("Lado 2: ");
        double lado2 = ler.nextDouble();

        System.out.print("Lado 3: ");
        double lado3 = ler.nextDouble();

        // Valida os valores positivos
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            System.out.println("\nERRO: Todos os lados devem ser valores positivos!");
            ler.close();
        }

        // Verifica a condição do triângulo (cada lado deve ser menor que a soma dos outros dois)
        if (verificaTriangulo(lado1, lado2, lado3)) {
            System.out.println("/n ✓ Os lados formam um triângulo!");

            // Classifica o tipo do triângulo (equilátero, isósceles e escaleno)
            String tipo = classificaTriangulo(lado1, lado2, lado3);
            System.out.println("Classificação: " + tipo);
        } else {
            System.out.println("/n ✗ Os lados NÃO formam um triângulo!");
            System.out.println("/n Lembre-se: para que seja um triângulo, cada lado deve ser menor que a soma dos outros dois.");
        }

        ler.close();
    }

    // Verifica se os três lados podem formar um triângulo
    // Regra 1: para que seja um triângulo, cada lado deve ser menor que a soma dos outros dois.
    public static boolean verificaTriangulo(double a, double b, double c) {
        return (a < b + c) && (b < a + c) && (c < a + b);
    }

    // Classifica o triângulo quanto aos lados
    /*Regra 2:
    Equilátero: quando todos os lados são iguais.
    Isósceles: quando apenas dois lados são iguais.
    Escaleno: quando todos os lados são diferentes.*/
    public static String classificaTriangulo(double a, double b, double c) {
        if (a == b && b == c) {
            return "Equilátero: todos os lados são iguais.";
        } else if (a == b || b == c || a == c) {
            return "Isósceles: apenas dois lados são iguais.";
        } else {
            return "Escaleno: todos os lados são diferentes";
        }
    }
}
