package com.lojacosmetico.service;

import com.lojacosmetico.model.Vendedor;

public interface VendedorService {
    void cadastrarVendedor(Vendedor vendedor);
    Vendedor buscarVendedor(int matricula);
    Vendedor[] listarVendedores();
    void atualizarVendedor(Vendedor vendedor);
    void removerVendedor(int matricula);
}