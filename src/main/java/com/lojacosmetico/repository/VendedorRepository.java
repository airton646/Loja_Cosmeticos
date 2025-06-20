package com.lojacosmetico.repository;

import com.lojacosmetico.model.Vendedor;

public interface VendedorRepository {
    void save(Vendedor vendedor);
    Vendedor findByMatricula(int matricula);
    Vendedor[] findAll();
    void update(Vendedor vendedor);
    void delete(int matricula);
}