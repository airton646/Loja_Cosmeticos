package com.lojacosmetico.repository;

import com.lojacosmetico.model.Vendedor;

public class VendedorRepositoryImpl implements VendedorRepository {
    private Vendedor[] vendedores = new Vendedor[50]; // Assuming a maximum of 50 sellers
    private int count = 0;

    @Override
    public void save(Vendedor vendedor) {
        // Check for unique matricula before saving
        if (findByMatricula(vendedor.getMatricula()) != null) {
            System.out.println("Erro: Matrícula já existe.");
            return;
        }
        if (count < vendedores.length) {
            vendedores[count++] = vendedor;
            System.out.println("Vendedor cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Limite de vendedores atingido.");
        }
    }

    @Override
    public Vendedor findByMatricula(int matricula) {
        for (int i = 0; i < count; i++) {
            if (vendedores[i].getMatricula() == matricula) {
                return vendedores[i];
            }
        }
        return null;
    }

    @Override
    public Vendedor[] findAll() {
        Vendedor[] result = new Vendedor[count];
        System.arraycopy(vendedores, 0, result, 0, count);
        return result;
    }

    @Override
    public void update(Vendedor vendedor) {
        for (int i = 0; i < count; i++) {
            if (vendedores[i].getMatricula() == vendedor.getMatricula()) {
                vendedores[i] = vendedor;
                System.out.println("Vendedor atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Vendedor não encontrado para atualização.");
    }

    @Override
    public void delete(int matricula) {
        for (int i = 0; i < count; i++) {
            if (vendedores[i].getMatricula() == matricula) {
                for (int j = i; j < count - 1; j++) {
                    vendedores[j] = vendedores[j + 1];
                }
                vendedores[--count] = null;
                System.out.println("Vendedor removido com sucesso.");
                return;
            }
        }
        System.out.println("Vendedor não encontrado para remoção.");
    }
}