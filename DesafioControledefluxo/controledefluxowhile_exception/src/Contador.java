import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        executar();
    }

    public static void executar() {
        Scanner terminal = new Scanner(System.in);

        while (true) {
            int parametroUm = lerParametro("Digite o primeiro parâmetro:", terminal);
            int parametroDois = lerParametro("Digite o segundo parâmetro:", terminal);

            try {
                contar(parametroUm, parametroDois);
                break;
            } catch (ParametrosInvalidosException exception) {
                System.out.println("Erro: " + exception.getMessage());
                System.out.println("Tente novamente.\n");
            }
        }

        terminal.close();
    }

    public static int lerParametro(String mensagem, Scanner scanner) {
        System.out.println(mensagem);
        return scanner.nextInt();
    }

    public static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        int contagem = parametroDois - parametroUm;

        for (int i = 1; i <= contagem; i++) {
            System.out.printf("Ocorrência %d de %d:\n", i, contagem);
        }
    }


    static class ParametrosInvalidosException extends Exception {
        public ParametrosInvalidosException(String mensagem) {
            super(mensagem);
        }
    }
}