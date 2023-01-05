package Programa;

import javax.swing.*;
import java.io.PrintStream;
public class Conta {
    PrintStream show = System.out;

    private static int contador = 1;

    private Cliente usuario;
    private double saldo = 0;
    private int cadastro;

    public Conta (Cliente usuario) {
        this.usuario = usuario;
        this.cadastro = contador;
        contador += 1;
    }

    public int getCadastro() {
        return this.cadastro;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }

    public Cliente getUser() {
        return this.usuario;
    }

    public void setUser(Cliente usuario) {
        this.usuario = usuario;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNúmero da conta: " + this.getCadastro() +
               "\nTitular: " +  this.usuario.getNome() +
               "\nCPF do titular: " + this.usuario.getCPF() +
               "\nEmail: " + this.usuario.getEmail() +
               "\nSaldo disponível: " + Format.doubleToString(this.getSaldo());
    }

    public void deposito(Double valor) {
        if (valor > 0) {
            this.setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível concluir a operação.");
        }
    }

    public void saque(Double valor) {
        if (this.getSaldo() >= valor && valor > 0) {
            this.setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Operação não concluída! Valor inválido.");
        }
    }

    public void transferencia(Double valor, Conta destino) {
        if (this.getSaldo() >= valor && valor > 0) {
            this.setSaldo(getSaldo() - valor);
            destino.saldo = destino.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível concluir a operação.");
        }
    }
}
