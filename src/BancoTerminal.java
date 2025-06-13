import java.util.Scanner;
import java.util.Random;

public class BancoTerminal {
    private String nomeUsuario;
    private String agencia;
    private String numeroConta;
    private double saldo;

    public BancoTerminal(String agencia, String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.agencia = agencia;
        this.saldo = 25.0;
        this.numeroConta = gerarNumeroConta();
    }

    private String gerarNumeroConta() {
        Random random = new Random();
        int parteNumerica = random.nextInt(1_000_000);
        int digitoVerificador = random.nextInt(10);
        return String.format("%06d-%d", parteNumerica, digitoVerificador);
    }

    public void exibirConta() {
        System.out.println("\nOlá " + nomeUsuario + ", obrigado por criar uma conta em nosso banco.");
        System.out.println("Sua agência é: " + agencia);
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Saldo: R$ " + saldo);
    }

    public void deposita(Scanner scanner) {
        System.out.println("\nOlá " + nomeUsuario + ", informe o valor do depósito:");
        double deposito = scanner.nextDouble();
        if (deposito <= 0) {
            System.out.println("Valor inválido! O depósito deve ser maior que zero.");
            return;
        }
        this.saldo += deposito;
        System.out.println("Depósito realizado com sucesso!");
        System.out.println("Novo saldo: R$ " + this.saldo);
    }

    public void sacar(Scanner scanner) {
        System.out.println("\nOlá " + nomeUsuario + ", informe o valor do saque:");
        double saque = scanner.nextDouble();
        if (saque <= 0) {
            System.out.println("Valor inválido. O valor de saque deve ser maior que zero.");
            return;
        }
        if (saque > this.saldo) {
            System.out.println("Saldo insuficiente. Seu saldo atual é R$ " + this.saldo);
            return;
        }
        this.saldo -= saque;
        System.out.println("Saque realizado com sucesso");
        System.out.println("Saldo atual: R$ " + this.saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();

        String agencia = "0001";  

        BancoTerminal conta = new BancoTerminal(agencia, nomeUsuario);
        conta.exibirConta();

        int opcao;
        do {
            System.out.println("\nMENU BANCO");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.exibirConta();
                    break;
                case 2:
                    conta.deposita(scanner);
                    break;
                case 3:
                    conta.sacar(scanner);
                    break;
                case 4:
                    System.out.println("Obrigado por usar o Banco Terminal, " + nomeUsuario + "!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
