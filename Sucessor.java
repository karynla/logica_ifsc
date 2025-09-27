// pacote que le dados digitador pelo usuario
// import - comando que traz uma classe externa para o uso no programa
// java.util.Scanner - localizacao da clase Scnanner na biblioteca da linguagem Java
// Scanner - classe que permite ler dados do teclado/entrada 
import java.util.Scanner;

// classe publica criada, o nome da clase precisa ser o mesmo do arquivo .java e sempre a primeira letra em maiuscula
// public - ele e um modificador de acesso, com ele a classe pode ser usada em qualquer lugar, externamente 
// class - define uma classe
public class Sucessor {

// static - metodo pertence a classe, nao a uma instancia especifica
// void - metodo nao retorna nenhum valor 
// main - nome do metodo principal, ponto de entrada do programa 
// String[] args - parametro que recebe argumentos da linha de comando
public static void main(String[] args){
        // Scanner - tipo da variavel, vem da biblioteca exportada
        // leia - nome da variavel do tipo Scanner, referencia ao objeto
        // new - cria um novo objeto na memoria
        // Scnanner(System.in) - construtor(molde) que configura o tipo Scanner para ler a entrada padra(teclado)
        Scanner leia = new Scanner(System.in);

        // System.out - objeto que representa a saida padrao (tela)
        // print - metodo que exibe texto sem quebra de linha
        System.out.print("Digite um numero: ");

        // int - tipo primitivo de variavel, usada para armazenar numeros inteiros
        // .nextInt() - metodo que le um numero decimal do teclado/entrada
        int numero = leia.nextInt();
        int sucessor = numero + 1;

        // System.out.println() - metodo que exibe texto(print) e quebra linha (ln)
        System.out.println("O sucessor de " + numero + "é " + sucessor);

        // scanner.close() - metodo que fecha o 
        leia.close();
    }
}
