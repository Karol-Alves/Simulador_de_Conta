import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******************************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Para iniciar, digite seu nome completo: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite o tipo de conta: ");
        String tipoConta = scanner.nextLine();
        BigDecimal saldoDisponivel = new BigDecimal("1000.00");
        System.out.printf("********************************************\n" +
                " Bem-vindo!\n" +
                " %s\n" +
                " Tipo de conta: %s\n" +
                " Saldo disponível: %.2f\n" +
                " *******************************************\n", nomeUsuario, tipoConta, saldoDisponivel);

        // Menu com While
        int opcaoCliente = 0;
        BigDecimal saldoAtualizado = saldoDisponivel;
        BigDecimal valorDeposito = BigDecimal.ZERO;
        BigDecimal valorTransferencia = BigDecimal.ZERO;

        while (true) {
            exibirMenu();
            opcaoCliente = scanner.nextInt();
            switch (opcaoCliente) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    valorDeposito = new BigDecimal(scanner.next());
                    saldoAtualizado = saldoAtualizado.add(valorDeposito);
                    System.out.printf("Saldo atualizado: %.2f\n", saldoAtualizado);
                    break;
                case 2:
                    System.out.print("Digite o valor da transferência: ");
                    valorTransferencia = new BigDecimal(scanner.next());
                    if (valorTransferencia.compareTo(saldoAtualizado) <= 0) {
                        saldoAtualizado = saldoAtualizado.subtract(valorTransferencia);
                        System.out.printf("Saldo atualizado: %.2f\n", saldoAtualizado);
                    } else {
                        System.out.println("Saldo insuficiente para a transferência.");
                    }
                    break;
                case 3:
                    System.out.printf("Saldo disponível: %.2f\n", saldoAtualizado);
                    break;
                case 4:
                    System.out.println("Obrigado por usar nosso sistema.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Digite uma opção válida");
            }
        }
    }

    // Função para abrir menu
    public static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Depósito");
        System.out.println("2. Transferência");
        System.out.println("3. Saldo");
        System.out.println("4. Sair");
    }
}
