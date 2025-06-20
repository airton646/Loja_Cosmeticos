package com.lojacosmetico.repository;

import com.lojacosmetico.model.Venda;

public class VendaRepositoryImpl implements VendaRepository {
    private Venda[] vendas = new Venda[200]; // Assuming a maximum of 200 sales
    private int count = 0;

    @Override
    public void save(Venda venda) {
        if (findById(venda.getId()) != null) {
            System.out.println("Erro: ID da venda já existe.");
            return;
        }
        if (count < vendas.length) {
            vendas[count++] = venda;
            System.out.println("Venda registrada com sucesso.");
        } else {
            System.out.println("Erro: Limite de vendas atingido.");
        }
    }

    @Override
    public Venda findById(int id) {
        for (int i = 0; i < count; i++) {
            if (vendas[i].getId() == id) {
                return vendas[i];
            }
        }
        return null;
    }

    @Override
    public Venda[] findAll() {
        Venda[] result = new Venda[count];
        System.arraycopy(vendas, 0, result, 0, count);
        return result;
    }

    @Override
    public Venda[] findByMatriculaVendedor(int matriculaVendedor) {
        int tempCount = 0;
        for (int i = 0; i < count; i++) {
            if (vendas[i].getMatriculaVendedor() == matriculaVendedor) {
                tempCount++;
            }
        }

        Venda[] result = new Venda[tempCount];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (vendas[i].getMatriculaVendedor() == matriculaVendedor) {
                result[index++] = vendas[i];
            }
        }
        return result;
    }

    @Override
    public void update(Venda venda) {
        for (int i = 0; i < count; i++) {
            if (vendas[i].getId() == venda.getId()) {
                vendas[i] = venda;
                System.out.println("Venda atualizada com sucesso.");
                return;
            }
        }
        System.out.println("Venda não encontrada para atualização.");
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (vendas[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    vendas[j] = vendas[j + 1];
                }
                vendas[--count] = null;
                System.out.println("Venda removida com sucesso.");
                return;
            }
        }
        System.out.println("Venda não encontrada para remoção.");
    }
}