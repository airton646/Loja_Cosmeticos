package com.lojacosmetico;

import com.lojacosmetico.model.Produto;
import com.lojacosmetico.model.Venda;
import com.lojacosmetico.model.Vendedor;
import com.lojacosmetico.service.ProdutoService;
import com.lojacosmetico.service.ProdutoServiceImpl;
import com.lojacosmetico.service.VendaService;
import com.lojacosmetico.service.VendaServiceImpl;
import com.lojacosmetico.service.VendedorService;
import com.lojacosmetico.service.VendedorServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoServiceImpl();
        VendedorService vendedorService = new VendedorServiceImpl();
        VendaService vendaService = new VendaServiceImpl(); // New
        Scanner scanner = new Scanner(System.in);
        int mainOption;

        do {
            System.out.println("\n=== Sistema Loja de Cosméticos ===");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Vendedores");
            System.out.println("3. Gerenciar Vendas"); // New
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção principal: ");
            try {
                mainOption = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Consume the invalid input
                mainOption = -1; // Set to an invalid option to repeat the loop
                continue;
            }

            switch (mainOption) {
                case 1:
                    manageProducts(scanner, produtoService);
                    break;
                case 2:
                    manageVendedores(scanner, vendedorService);
                    break;
                case 3: // New case for managing sales
                    manageVendas(scanner, vendaService, produtoService, vendedorService);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (mainOption != 0);

        scanner.close();
    }

    private static void manageProducts(Scanner scanner, ProdutoService service) {
        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Produtos ===");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Buscar produto por ID");
            System.out.println("4. Atualizar produto");
            System.out.println("5. Remover produto");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Consume the invalid input
                opcao = -1; // Set to an invalid option to repeat the loop
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    service.cadastrarProduto(new Produto(id, nome, preco));
                    break;
                case 2:
                    Produto[] produtos = service.listarProdutos();
                    if (produtos.length == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto p : produtos) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 3:
                    System.out.print("ID do produto a buscar: ");
                    int buscarId = scanner.nextInt();
                    Produto encontrado = service.buscarProduto(buscarId);
                    System.out.println(encontrado != null ? encontrado : "Produto não encontrado.");
                    break;
                case 4:
                    System.out.print("ID do produto a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    service.atualizarProduto(new Produto(idAtualizar, novoNome, novoPreco));
                    break;
                case 5:
                    System.out.print("ID do produto a remover: ");
                    int idRemover = scanner.nextInt();
                    service.removerProduto(idRemover);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void manageVendedores(Scanner scanner, VendedorService service) {
        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Vendedores ===");
            System.out.println("1. Cadastrar vendedor");
            System.out.println("2. Listar vendedores");
            System.out.println("3. Buscar vendedor por Matrícula");
            System.out.println("4. Atualizar vendedor");
            System.out.println("5. Remover vendedor");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Consume the invalid input
                opcao = -1; // Set to an invalid option to repeat the loop
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Matrícula: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    service.cadastrarVendedor(new Vendedor(matricula, nome));
                    break;
                case 2:
                    Vendedor[] vendedores = service.listarVendedores();
                    if (vendedores.length == 0) {
                        System.out.println("Nenhum vendedor cadastrado.");
                    } else {
                        for (Vendedor v : vendedores) {
                            System.out.println(v);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Matrícula do vendedor a buscar: ");
                    int buscarMatricula = scanner.nextInt();
                    Vendedor encontrado = service.buscarVendedor(buscarMatricula);
                    System.out.println(encontrado != null ? encontrado : "Vendedor não encontrado.");
                    break;
                case 4:
                    System.out.print("Matrícula do vendedor a atualizar: ");
                    int matriculaAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    service.atualizarVendedor(new Vendedor(matriculaAtualizar, novoNome));
                    break;
                case 5:
                    System.out.print("Matrícula do vendedor a remover: ");
                    int matriculaRemover = scanner.nextInt();
                    service.removerVendedor(matriculaRemover);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // New method for managing sales
    private static void manageVendas(Scanner scanner, VendaService vendaService, ProdutoService produtoService, VendedorService vendedorService) {
        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Vendas ===");
            System.out.println("1. Registrar nova venda");
            System.out.println("2. Listar todas as vendas");
            System.out.println("3. Buscar venda por ID");
            System.out.println("4. Listar vendas por Matrícula do Vendedor");
            System.out.println("5. Atualizar venda");
            System.out.println("6. Remover venda");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Consume the invalid input
                opcao = -1; // Set to an invalid option to repeat the loop
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("ID da Venda: ");
                    int idVenda = scanner.nextInt();
                    System.out.print("ID do Produto: ");
                    int produtoId = scanner.nextInt();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Matrícula do Vendedor: ");
                    int matriculaVendedor = scanner.nextInt();
                    vendaService.registrarVenda(idVenda, produtoId, quantidade, matriculaVendedor, produtoService, vendedorService);
                    break;
                case 2:
                    Venda[] vendas = vendaService.listarVendas();
                    if (vendas.length == 0) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (Venda v : vendas) {
                            System.out.println(v);
                        }
                    }
                    break;
                case 3:
                    System.out.print("ID da venda a buscar: ");
                    int buscarIdVenda = scanner.nextInt();
                    Venda vendaEncontrada = vendaService.buscarVenda(buscarIdVenda);
                    System.out.println(vendaEncontrada != null ? vendaEncontrada : "Venda não encontrada.");
                    break;
                case 4:
                    System.out.print("Matrícula do vendedor para listar vendas: ");
                    int matriculaVendedorListar = scanner.nextInt();
                    Venda[] vendasPorVendedor = vendaService.listarVendasPorVendedor(matriculaVendedorListar);
                    if (vendasPorVendedor.length == 0) {
                        System.out.println("Nenhuma venda encontrada para o vendedor com matrícula " + matriculaVendedorListar + ".");
                    } else {
                        for (Venda v : vendasPorVendedor) {
                            System.out.println(v);
                        }
                    }
                    break;
                case 5:
                    System.out.print("ID da venda a atualizar: ");
                    int idVendaAtualizar = scanner.nextInt();
                    Venda vendaParaAtualizar = vendaService.buscarVenda(idVendaAtualizar);
                    if (vendaParaAtualizar != null) {
                        System.out.print("Novo ID do Produto (atual: " + vendaParaAtualizar.getProdutoId() + "): ");
                        int novoProdutoId = scanner.nextInt();
                        System.out.print("Nova Quantidade (atual: " + vendaParaAtualizar.getQuantidade() + "): ");
                        int novaQuantidade = scanner.nextInt();
                        // Matrícula do vendedor não será atualizada para manter o histórico de quem fez a venda.
                        // Se fosse necessário, seria outro campo e validação.

                        vendaParaAtualizar.setProdutoId(novoProdutoId);
                        vendaParaAtualizar.setQuantidade(novaQuantidade);
                        vendaService.atualizarVenda(vendaParaAtualizar, produtoService);
                    } else {
                        System.out.println("Venda não encontrada para atualização.");
                    }
                    break;
                case 6:
                    System.out.print("ID da venda a remover: ");
                    int idVendaRemover = scanner.nextInt();
                    vendaService.removerVenda(idVendaRemover);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}