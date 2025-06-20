package com.lojacosmetico.service;

import com.lojacosmetico.model.Produto;

public interface ProdutoService {
    void cadastrarProduto(Produto produto);
    Produto buscarProduto(int id);
    Produto[] listarProdutos();
    void atualizarProduto(Produto produto);
    void removerProduto(int id);
}
