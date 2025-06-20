package com.lojacosmetico.service;

import com.lojacosmetico.model.Produto;
import com.lojacosmetico.model.Venda;
import com.lojacosmetico.model.Vendedor;
import com.lojacosmetico.repository.VendaRepository;
import com.lojacosmetico.repository.VendaRepositoryImpl;

public class VendaServiceImpl implements VendaService {
    private VendaRepository repository = new VendaRepositoryImpl();

    @Override
    public void registrarVenda(int idVenda, int produtoId, int quantidade, int matriculaVendedor, ProdutoService produtoService, VendedorService vendedorService) {
        if (quantidade <= 0) {
            System.out.println("Quantidade deve ser maior que zero.");
            return;
        }

        Produto produto = produtoService.buscarProduto(produtoId);
        if (produto == null) {
            System.out.println("Produto com ID " + produtoId + " não encontrado.");
            return;
        }

        Vendedor vendedor = vendedorService.buscarVendedor(matriculaVendedor);
        if (vendedor == null) {
            System.out.println("Vendedor com Matrícula " + matriculaVendedor + " não encontrado.");
            return;
        }

        double valorTotal = produto.getPreco() * quantidade;
        Venda novaVenda = new Venda(idVenda, produtoId, quantidade, matriculaVendedor, valorTotal);
        repository.save(novaVenda);
    }

    @Override
    public Venda buscarVenda(int id) {
        return repository.findById(id);
    }

    @Override
    public Venda[] listarVendas() {
        return repository.findAll();
    }

    @Override
    public Venda[] listarVendasPorVendedor(int matriculaVendedor) {
        return repository.findByMatriculaVendedor(matriculaVendedor);
    }

    @Override
    public void atualizarVenda(Venda venda, ProdutoService produtoService) {
        if (venda.getQuantidade() <= 0) {
            System.out.println("Quantidade deve ser maior que zero.");
            return;
        }

        Produto produto = produtoService.buscarProduto(venda.getProdutoId());
        if (produto == null) {
            System.out.println("Produto com ID " + venda.getProdutoId() + " não encontrado.");
            return;
        }
        venda.setValorTotal(produto.getPreco() * venda.getQuantidade());
        repository.update(venda);
    }

    @Override
    public void removerVenda(int id) {
        repository.delete(id);
    }
}