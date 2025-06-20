package com.lojacosmetico.model;

public class Vendedor {
    private int matricula;
    private String nome;

    public Vendedor(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Vendedor{matricula=" + matricula + ", nome='" + nome + "'}";
    }
}