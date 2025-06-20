package com.lojacosmetico.service;

import com.lojacosmetico.model.Vendedor;
import com.lojacosmetico.repository.VendedorRepository;
import com.lojacosmetico.repository.VendedorRepositoryImpl;

public class VendedorServiceImpl implements VendedorService {
    private VendedorRepository repository = new VendedorRepositoryImpl();

    @Override
    public void cadastrarVendedor(Vendedor vendedor) {
        if (vendedor.getNome() == null || vendedor.getNome().isEmpty()) {
            System.out.println("Nome do vendedor obrigatório.");
            return;
        }
        repository.save(vendedor);
    }

    @Override
    public Vendedor buscarVendedor(int matricula) {
        return repository.findByMatricula(matricula);
    }

    @Override
    public Vendedor[] listarVendedores() {
        return repository.findAll();
    }

    @Override
    public void atualizarVendedor(Vendedor vendedor) {
        if (vendedor.getNome() == null || vendedor.getNome().isEmpty()) {
            System.out.println("Nome do vendedor obrigatório.");
            return;
        }
        repository.update(vendedor);
    }

    @Override
    public void removerVendedor(int matricula) {
        repository.delete(matricula);
    }
}