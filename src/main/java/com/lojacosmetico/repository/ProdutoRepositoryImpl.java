package com.lojacosmetico.repository;

import com.lojacosmetico.model.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository {
    private Produto[] produtos = new Produto[100];
    private int count = 0;

    public void save(Produto produto) {
        produtos[count++] = produto;
    }

    public Produto findById(int id) {
        for (int i = 0; i < count; i++) {
            if (produtos[i].getId() == id) return produtos[i];
        }
        return null;
    }

    public Produto[] findAll() {
        Produto[] result = new Produto[count];
        System.arraycopy(produtos, 0, result, 0, count);
        return result;
    }

    public void update(Produto produto) {
        for (int i = 0; i < count; i++) {
            if (produtos[i].getId() == produto.getId()) {
                produtos[i] = produto;
                return;
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (produtos[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    produtos[j] = produtos[j + 1];
                }
                produtos[--count] = null;
                return;
            }
        }
    }
}
