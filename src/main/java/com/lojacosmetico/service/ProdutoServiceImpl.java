package com.lojacosmetico.service;

import com.lojacosmetico.model.Produto;
import com.lojacosmetico.repository.ProdutoRepository;
import com.lojacosmetico.repository.ProdutoRepositoryImpl;

public class ProdutoServiceImpl implements ProdutoService {
    private ProdutoRepository repository = new ProdutoRepositoryImpl();

    public void cadastrarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            System.out.println("Nome obrigatório.");
            return;
        }
        repository.save(produto);
    }

    public Produto buscarProduto(int id) {
        return repository.findById(id);
    }

    public Produto[] listarProdutos() {
        return repository.findAll();
    }

    public void atualizarProduto(Produto produto) {
        repository.update(produto);
    }

    public void removerProduto(int id) {
        repository.delete(id);
    }
}
