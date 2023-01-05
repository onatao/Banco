package Programa;

import java.util.Locale;

public class Cliente {

    private static int contador = 1;

    private int id;
    private String nome;
    private String cpf;
    private String email;

    public Cliente() {

    }
    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.id = contador;
        contador+=1;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String c) {
        this.cpf = c;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public String toString() {
        return "\nNome: " + getNome() +
               "\nCPF: " + getCPF() +
               "\nEmail: " + getEmail();
    }
}


