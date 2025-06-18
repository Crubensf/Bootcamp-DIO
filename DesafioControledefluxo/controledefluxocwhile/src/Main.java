import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parametro1 = lerParametro("Informe o primeiro parâmetro:", scanner);
        int parametro2 = lerParametro("Informe o segundo parâmetro:", scanner);

        while (!validarParametros(parametro1, parametro2)) {
            System.out.println("Erro: o segundo parâmetro deve ser maior que o primeiro.\n");
            parametro1 = lerParametro("Informe o primeiro parâmetro:", scanner);
            parametro2 = lerParametro("Informe o segundo parâmetro:", scanner);
        }

        executarContagem(parametro1, parametro2);

        scanner.close();
    }


    public static int lerParametro(String mensagem, Scanner scanner) {
        System.out.println(mensagem);
        return scanner.nextInt();
    }


    public static boolean validarParametros(int p1, int p2) {
        return p2 >= p1;
    }


    public static void executarContagem(int p1, int p2) {
        int contador = p2 - p1;

        for (int i = 0; i < contador; i++) {
            System.out.printf("Ocorrência %d de %d\n", i + 1, contador);
        }
    }
}
