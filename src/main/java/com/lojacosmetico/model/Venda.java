package com.lojacosmetico.model;

public class Venda {
    private int id;
    private int produtoId;
    private int quantidade;
    private int matriculaVendedor;
    private double valorTotal;

    public Venda(int id, int produtoId, int quantidade, int matriculaVendedor, double valorTotal) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.matriculaVendedor = matriculaVendedor;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getMatriculaVendedor() {
        return matriculaVendedor;
    }

    public void setMatriculaVendedor(int matriculaVendedor) {
        this.matriculaVendedor = matriculaVendedor;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", produtoId=" + produtoId +
                ", quantidade=" + quantidade +
                ", matriculaVendedor=" + matriculaVendedor +
                ", valorTotal=" + String.format("%.2f", valorTotal) +
                '}';
    }
}