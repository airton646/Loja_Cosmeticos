package com.lojacosmetico.service;

import com.lojacosmetico.model.Venda;
import com.lojacosmetico.model.Produto;
import com.lojacosmetico.model.Vendedor;

public interface VendaService {
    void registrarVenda(int idVenda, int produtoId, int quantidade, int matriculaVendedor, ProdutoService produtoService, VendedorService vendedorService);
    Venda buscarVenda(int id);
    Venda[] listarVendas();
    Venda[] listarVendasPorVendedor(int matriculaVendedor);
    void atualizarVenda(Venda venda, ProdutoService produtoService);
    void removerVenda(int id);
}