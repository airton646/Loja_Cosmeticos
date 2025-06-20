package com.lojacosmetico.repository;

import com.lojacosmetico.model.Produto;

public interface ProdutoRepository {
    void save(Produto produto);
    Produto findById(int id);
    Produto[] findAll();
    void update(Produto produto);
    void delete(int id);
}
