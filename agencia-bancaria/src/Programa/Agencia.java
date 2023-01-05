package Programa;

    import jdk.nashorn.internal.scripts.JO;

    import javax.swing.*;
    import java.util.Scanner;
    import java.io.PrintStream;
    import java.util.ArrayList;

public class Agencia {
    static Scanner input = new Scanner(System.in);
    static PrintStream show = System.out;
    static ArrayList<Conta> contasCadastradas;

    public static void main(String[] args) {
        contasCadastradas = new ArrayList<>();
        menu();
    }
    public static void menu() {
        int opcao =
           Integer.parseInt(JOptionPane.showInputDialog(
        "\nBem vindo(a)! Selecione uma operação: " +
        "\n| OPÇÃO 1 - ABRIR CONTA " +
        "\n| OPÇÃO 2 - SAIR        " +
        "\n| OPÇÃO 3 - SAQUE       " +
        "\n| OPÇÃO 4 - DEPOSITAR   " +
        "\n| OPÇÃO 5 - TRANSFERIR  " +
        "\n| OPÇÃO 6 - LISTAR      "));

        switch(opcao) {
            case 1:
                abrirConta();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Obrigado pela preferência!");
                System.exit(0);
            case 3:
                sacar();
                break;
            case 4:
                depositar();
                break;
            case 5:
                transferir();
                break;
            case 6:
                listar();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                menu();
                break;
        }
    }

    private static Conta finder(int cadastro) {
        Conta conta = null;
        if (contasCadastradas.size() > 0) {
            for (Conta c: contasCadastradas) {
                if (c.getCadastro() == cadastro) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void abrirConta() {
        Cliente usuario = new Cliente(null, null, null);
        usuario.setNome(JOptionPane.showInputDialog("Nome do titular: "));
        usuario.setCPF(JOptionPane.showInputDialog("CPF do titular"));
        usuario.setEmail(JOptionPane.showInputDialog("Email: "));

        Conta conta = new Conta(usuario);
        contasCadastradas.add(conta);
        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
        menu();
    }

    public static void depositar() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
        Conta conta = finder(n);
            if (conta != null) {
                double valorDep =
                        Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do depósito: "));
                conta.deposito(valorDep);
            }
        menu();
    }

    public static void sacar() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
        Conta conta = finder(n);
            if (conta != null) {
                double valorSaq =
                        Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do saque: "));
                conta.saque(valorSaq);
            }
        menu();
    }

    public static void transferir() {
        int remetente = Integer.parseInt(JOptionPane.showInputDialog("Conta remetente: "));
        Conta contaRemetente = finder(remetente);
            if (contaRemetente != null) {
                int destino = Integer.parseInt(JOptionPane.showInputDialog("Conta destinatário: "));
                Conta contaDestino = finder(destino);
                    if (contaDestino != null) {
                        Double valor =
                                Double.parseDouble(JOptionPane.showInputDialog("Valor da tranferência: "));
                        contaRemetente.transferencia(valor, contaDestino);
                    }
            }
            menu();
    }

    public static void listar() {
        if (contasCadastradas.size() > 0) {
            for (Conta conta: contasCadastradas) {
                JOptionPane.showMessageDialog(null, conta);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não existem contas cadastradas.");
        }
        menu();
    }
}
