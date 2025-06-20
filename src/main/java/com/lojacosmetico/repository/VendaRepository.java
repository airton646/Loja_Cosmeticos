package com.lojacosmetico.repository;

import com.lojacosmetico.model.Venda;

public interface VendaRepository {
    void save(Venda venda);
    Venda findById(int id);
    Venda[] findAll();
    Venda[] findByMatriculaVendedor(int matriculaVendedor);
    void update(Venda venda);
    void delete(int id);
}