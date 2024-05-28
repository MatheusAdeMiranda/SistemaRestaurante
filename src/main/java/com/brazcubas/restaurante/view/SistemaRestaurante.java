package com.brazcubas.restaurante.view;

import java.util.List;
import java.util.Scanner;

import com.brazcubas.restaurante.controller.*;
import com.brazcubas.restaurante.model.entity.*;

public class SistemaRestaurante {
    private ClienteController clienteController;
    private ClienteView clienteView;
    private FuncionarioController funcionarioController;
    private FuncionarioView funcionarioView;
    private PedidoController pedidoController;
    private PedidoView pedidoView;
    private PratoController pratoController;
    private PratoView pratoView;
    private ItemPedidoController itemPedidoController;
    private ItemPedidoView itemPedidoView;
    private Scanner scanner;

    public SistemaRestaurante(ClienteController clienteController, ClienteView clienteView, FuncionarioController funcionarioController, FuncionarioView funcionarioView,
                              PedidoController pedidoController, PedidoView pedidoView, PratoController pratoController, PratoView pratoView, ItemPedidoController itemPedidoController,
                              ItemPedidoView itemPedidoView, Scanner scanner) {
        this.clienteController = clienteController;
        this.clienteView = clienteView;
        this.funcionarioController = funcionarioController;
        this.funcionarioView = funcionarioView;
        this.pedidoController = pedidoController;
        this.pedidoView = pedidoView;
        this.pratoController = pratoController;
        this.pratoView = pratoView;
        this.itemPedidoController = itemPedidoController;
        this.itemPedidoView = itemPedidoView;
        this.scanner = scanner;
    }

    //    public void iniciar(){
//        int opcao;
//        do {
//            mostraMenu();
//            opcao = scanner.nextInt();
//            switch (opcao) {
//                case 1:
//                    GerenciarFuncionarios();
//                    break;
//                case 2:
//                    GerenciarFuncionarios();
//                    break;
//                case 3:
//                    GerenciarPedido();
//                    break;
//                case 4:
//                    GerenciarItemPedido();
//                    break;
//                case 5:
//                    GerenciarPrato();
//                    break;
//                case 0:
//                      FuncionarioView.mostrarMensagem("Saindo do sistema...");
//                    break;
//                default:
//                      FuncionarioView.mostrarMensagem("Opção inválida!");
//                    break;
//            }
//        } while (opcao !=0);
//    }
    public void iniciar() {
        int opcao;
        do {
            mostrarMenuPrincipal();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    GerenciarClientes();
                    break;
                case 2:
                    GerenciarFuncionarios();
                    break;
                case 3:
                    GerenciarPedido();
                    break;
                case 4:
                    GerenciarItemPedido();
                    break;
                case 5:
                    GerenciarPrato();
                    break;
                case 0:
                    ClienteView.mostrarMensagem("Saindo do sistemas...");
                    break;
                default:
                    ClienteView.mostrarMensagem("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void mostrarMenuPrincipal() {
        System.out.println("=== Menu ===");
        System.out.println("1. Gerenciar Clientes");
        System.out.println("2. Gerenciar Funcionários");
        System.out.println("3. Gerenciar Pedidos");
        System.out.println("4. Gerenciar Item Pedidos");
        System.out.println("5. Gerenciar Pratos");
        System.out.println("0. Sair");
        System.out.println("============");
        System.out.println("Escolha uma opção:");
    }

    public void GerenciarClientes() {
        int opcao;
        do {
            mostrarMenuCliente();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    excluirCliente();
                    break;
                case 5:
                    buscarCliente();
                    break;
                case 0:
                    ClienteView.mostrarMensagem("Saindo do sistema...");
                    break;
                default:
                    ClienteView.mostrarMensagem("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void mostrarMenuCliente() {
        System.out.println("=== Menu Clientes ===");
        System.out.println("1. Cadastrar Clientes");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Atualizar Clientes");
        System.out.println("4. Excluir Clientes");
        System.out.println("5. Buscar Clientes");
        System.out.println("0. Sair");
        System.out.println("============");
        System.out.println("Escolha uma opção:");
    }

    private void cadastrarCliente() {
        scanner.nextLine(); // Limpar o buffer do scanner
        clienteView.mostrarMensagem("Digite o nome do cliente:");
        String Nome = scanner.nextLine();
        clienteView.mostrarMensagem("Digite o CPF do cliente:");
        String CPF = scanner.nextLine();
        clienteView.mostrarMensagem("Digite o telefone do cliente:");
        String Telefone = scanner.nextLine();


        Cliente novoCliente = new Cliente(Nome, CPF, Telefone);
        String retorno = clienteController.cadastrarCliente(novoCliente);
        clienteView.mostrarMensagem(retorno);
    }

    private void listarCliente() {
        clienteView.mostrarMensagem("=== Clientes Cadastrados ===");
        List<Cliente> clientes = clienteController.listarClientes();
        clienteView.listarCliente(clientes);
        clienteView.mostrarMensagem("===========================");
    }

    private void atualizarCliente() {
        clienteView.mostrarMensagem("Digite o ID do cliente a ser atualizado:");
        int id = scanner.nextInt();
        Cliente cliente = clienteController.buscarCliente(id);
        if (cliente != null) {
            cliente.setId(id);
            scanner.nextLine(); // Limpar o buffer do scanner
            clienteView.mostrarMensagem("Digite o novo nome do cliente:");
            String nome = scanner.nextLine();
            cliente.setNome(nome);
            clienteView.mostrarMensagem("Digite o novo cpf do cliente:");
            String cpf = scanner.nextLine();
            cliente.setCpf(cpf);
            clienteView.mostrarMensagem("Digite o novo telefone do cliente:");
            String telefone = scanner.nextLine();
            cliente.setTelefone(telefone);

            String retorno = clienteController.atualizarCliente(cliente);
            clienteView.mostrarMensagem(retorno);
        } else {
            clienteView.mostrarMensagem("Cliente não encontrado!");
        }
    }

    private void excluirCliente() {
        clienteView.mostrarMensagem("Digite o ID do cliente a ser excluído:");
        int id = scanner.nextInt();
        String retorno = clienteController.excluirCliente(id);
        clienteView.mostrarMensagem(retorno);
    }

    private void buscarCliente() {
        clienteView.mostrarMensagem("Digite o ID do cliente a ser buscado:");
        int id = scanner.nextInt();
        Cliente cliente = clienteController.buscarCliente(id);
        if (cliente != null) {
            clienteView.dadosCliente(cliente);
        } else {
            clienteView.mostrarMensagem("Cliente não encontrado!");
        }
    }

    public void GerenciarFuncionarios() {
        int opcao;
        do {
            mostrarMenuFuncionario();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    atualizarFuncionario();
                    break;
                case 4:
                    excluirFuncionario();
                    break;
                case 5:
                    buscarFuncionario();
                    break;
                case 0:
                    FuncionarioView.mostrarMensagem("Saindo do sistema...");
                    break;
                default:
                    FuncionarioView.mostrarMensagem("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void mostrarMenuFuncionario() {
        System.out.println("=== Menu Funcionários ===");
        System.out.println("1. Cadastrar Funcionários");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Atualizar Funcionários");
        System.out.println("4. Excluir Funcionários");
        System.out.println("5. Buscar Funcionários");
        System.out.println("0. Sair");
        System.out.println("============");
        System.out.println("Escolha uma opção:");
    }

    private void cadastrarFuncionario() {
        scanner.nextLine(); // Limpar o buffer do scanner
        funcionarioView.mostrarMensagem("Digite o nome do funcionário:");
        String Nome = scanner.nextLine();
        funcionarioView.mostrarMensagem("Digite o Cargo do funcinário:");
        String Cargo = scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario(Nome, Cargo);
        String retorno = funcionarioController.cadastrarFuncionario(novoFuncionario);
        funcionarioView.mostrarMensagem(retorno);
    }

    private void listarFuncionarios() {
        funcionarioView.mostrarMensagem("=== Funcionários Cadastrados ===");
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        funcionarioView.listarFuncionario(funcionarios);
        funcionarioView.mostrarMensagem("===========================");
    }

    private void atualizarFuncionario() {
        funcionarioView.mostrarMensagem("Digite o ID do funcionário a ser atualizado:");
        int id = scanner.nextInt();
        Funcionario funcionario = funcionarioController.buscarFuncionario(id);
        if (funcionario != null) {
            funcionario.setId(id);
            scanner.nextLine(); // Limpar o buffer do scanner
            funcionarioView.mostrarMensagem("Digite o novo nome do funcionário:");
            String nome = scanner.nextLine();
            funcionario.setNome(nome);
            funcionarioView.mostrarMensagem("Digite o novo cargo do funcionário:");
            String cargo = scanner.nextLine();
            funcionario.setCargo(cargo);

            String retorno = funcionarioController.atualizarFuncionario(funcionario);
            funcionarioView.mostrarMensagem(retorno);
        } else {
            funcionarioView.mostrarMensagem("Cliente não encontrado!");
        }
    }

    private void excluirFuncionario() {
        funcionarioView.mostrarMensagem("Digite o ID do funcionário a ser excluído:");
        int id = scanner.nextInt();
        String retorno = funcionarioController.excluirFuncionario(id);
        funcionarioView.mostrarMensagem(retorno);
    }

    private void buscarFuncionario() {
        funcionarioView.mostrarMensagem("Digite o ID do funcionário a ser buscado:");
        int id = scanner.nextInt();
        Funcionario funcionario = funcionarioController.buscarFuncionario(id);
        if (funcionario != null) {
            funcionarioView.dadosFuncionario(funcionario);
        } else {
            funcionarioView.mostrarMensagem("Cliente não encontrado!");
        }
    }

    public void GerenciarPedido() {
        int opcao;
        do {
            mostrarMenuPedido();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarPedido();
                    break;
                case 2:
                    listarPedidos();
                    break;
                case 3:
                    atualizarPedido();
                    break;
                case 4:
                    excluirPedido();
                    break;
                case 5:
                    buscarPedido();
                    break;
                case 0:
                    PedidoView.mostrarMensagem("Saindo do sistema...");
                    break;
                default:
                    PedidoView.mostrarMensagem("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void mostrarMenuPedido() {
        System.out.println("=== Menu Pedidos ===");
        System.out.println("1. Cadastrar Pedidos");
        System.out.println("2. Listar Pedidos");
        System.out.println("3. Atualizar Pedidos");
        System.out.println("4. Excluir Pedidos");
        System.out.println("5. Buscar Pedidos");
        System.out.println("0. Sair");
        System.out.println("============");
        System.out.println("Escolha uma opção:");
    }

    private void cadastrarPedido() {
        scanner.nextLine(); // Limpar o buffer do scanner
        pedidoView.mostrarMensagem("Digite o ID do cliente:");
        int id_cliente = Integer.parseInt(scanner.nextLine());
        pedidoView.mostrarMensagem("Digite o ID do funcionário:");
        int id_funcionario = Integer.parseInt(scanner.nextLine());
        pedidoView.mostrarMensagem("Digite a Mesa do cliente:");
        String mesa = scanner.nextLine();


        Pedido novoPedido = new Pedido(mesa, id_funcionario, id_cliente);
        String retorno = pedidoController.cadastrarPedido(novoPedido);
        pedidoView.mostrarMensagem(retorno);
    }

    private void listarPedidos() {
        pedidoView.mostrarMensagem("=== Pedidos Cadastrados ===");
        List<Pedido> pedidos = pedidoController.listarPedidos();
        pedidoView.listarPedido(pedidos);
        pedidoView.mostrarMensagem("===========================");
    }

    private void atualizarPedido() {
        pedidoView.mostrarMensagem("Digite o ID do pedido a ser atualizado:");
        int id = scanner.nextInt();
        Pedido pedido = pedidoController.buscarPedido(id);
        if (pedido != null) {
            pedido.setId(id);
            scanner.nextLine(); // Limpar o buffer do scanner
            pedidoView.mostrarMensagem("Digite o novo número da mesa:");
            String mesa = scanner.nextLine();
            pedido.setMesa(mesa);
            pedidoView.mostrarMensagem("Digite o novo ID do cliente:");
            String id_cliente = scanner.nextLine();
            pedido.setId_cliente(Integer.parseInt(id_cliente));
            pedidoView.mostrarMensagem("Digite o novo ID do funcionário:");
            String id_funcionario = scanner.nextLine();
            pedido.setId_funcionario(Integer.parseInt(id_funcionario));

            String retorno = pedidoController.atualizarPedido(pedido);
            pedidoView.mostrarMensagem(retorno);
        } else {
            pedidoView.mostrarMensagem("Pedido não encontrado!");
        }
    }

    private void excluirPedido() {
        pedidoView.mostrarMensagem("Digite o ID do pedido a ser excluído:");
        int id = scanner.nextInt();
        String retorno = pedidoController.excluirPedido(id);
        pedidoView.mostrarMensagem(retorno);
    }

    private void buscarPedido() {
        pedidoView.mostrarMensagem("Digite o ID do pedido a ser buscado:");
        int id = scanner.nextInt();
        Pedido pedido = pedidoController.buscarPedido(id);
        if (pedido != null) {
            pedidoView.dadosPedido(pedido);
        } else {
            pedidoView.mostrarMensagem("Cliente não encontrado!");
        }
    }

    public void GerenciarPrato() {
        int opcao;
        do {
            mostrarMenuPrato();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarPrato();
                    break;
                case 2:
                    listarPratos();
                    break;
                case 3:
                    atualizarPrato();
                    break;
                case 4:
                    excluirPrato();
                    break;
                case 5:
                    buscarPrato();
                    break;
                case 0:
                    PratoView.mostrarMensagem("Saindo do sistema...");
                    break;
                default:
                    PratoView.mostrarMensagem("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void mostrarMenuPrato() {
        System.out.println("=== Menu Pratos ===");
        System.out.println("1. Cadastrar Pratos");
        System.out.println("2. Listar Pratos");
        System.out.println("3. Atualizar Pratos");
        System.out.println("4. Excluir Pratos");
        System.out.println("5. Buscar Pratos");
        System.out.println("0. Sair");
        System.out.println("============");
        System.out.println("Escolha uma opção:");
    }

    private void cadastrarPrato() {
        scanner.nextLine(); // Limpar o buffer do scanner
        pratoView.mostrarMensagem("Digite o nome do prato:");
        String Nome = scanner.nextLine();
        pratoView.mostrarMensagem("Digite o preço do prato:");
        float Preco = Float.parseFloat(scanner.nextLine());

        Prato novoPrato = new Prato(Nome, Preco);
        String retorno = pratoController.cadastrarPrato(novoPrato);
        pratoView.mostrarMensagem(retorno);
    }

    private void listarPratos() {
        pratoView.mostrarMensagem("=== Pratos Cadastrados ===");
        List<Prato> pratos = pratoController.listarPratos();
        pratoView.listarPrato(pratos);
        pratoView.mostrarMensagem("===========================");
    }

    private void atualizarPrato() {
        pratoView.mostrarMensagem("Digite o ID do prato a ser atualizado:");
        int id = scanner.nextInt();
        Prato prato = pratoController.buscarPrato(id);
        if (prato != null) {
            prato.setId(id);
            scanner.nextLine(); // Limpar o buffer do scanner
            pratoView.mostrarMensagem("Digite o novo nome do prato:");
            String nome = scanner.nextLine();
            prato.setNome(nome);
            clienteView.mostrarMensagem("Digite o novo preço do prato:");
            String Preco = scanner.nextLine();
            prato.setPreco(Float.parseFloat(Preco));

            String retorno = pratoController.atualizarPrato(prato);
            pratoView.mostrarMensagem(retorno);
        } else {
            pratoView.mostrarMensagem("Prato não encontrado!");
        }
    }

    private void excluirPrato() {
        pratoView.mostrarMensagem("Digite o ID do prato a ser excluído:");
        int id = scanner.nextInt();
        String retorno = pratoController.excluirPrato(id);
        pratoView.mostrarMensagem(retorno);
    }

    private void buscarPrato() {
        pratoView.mostrarMensagem("Digite o ID do prato a ser buscado:");
        int id = scanner.nextInt();
        Prato prato = pratoController.buscarPrato(id);
        if (prato != null) {
            pratoView.dadosPrato(prato);
        } else {
            pratoView.mostrarMensagem("Prato não encontrado!");
        }
    }

    public void GerenciarItemPedido() {
        int opcao;
        do {
            mostrarMenuItemPedido();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarItemPedido();
                    break;
                case 2:
                    listarItemPedido();
                    break;
                case 3:
                    atualizarItemPedido();
                    break;
                case 4:
                    excluirItemPedido();
                    break;
                case 5:
                    buscarItemPedido();
                    break;
                case 0:
                    ItemPedidoView.mostrarMensagem("Saindo do sistema...");
                    break;
                default:
                    ItemPedidoView.mostrarMensagem("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void mostrarMenuItemPedido() {
        System.out.println("=== Menu Item Pedido ===");
        System.out.println("1. Cadastrar Item Pedido");
        System.out.println("2. Listar Item Pedido");
        System.out.println("3. Atualizar Status Item Pedido");
        System.out.println("4. Excluir Item Pedido");
        System.out.println("5. Buscar Item Pedido");
        System.out.println("0. Sair");
        System.out.println("============");
        System.out.println("Escolha uma opção:");
    }

    private void mostrarMenu() {

    }

    private void cadastrarItemPedido() {
        scanner.nextLine(); // Limpar o buffer do scanner
        itemPedidoView.mostrarMensagem("Digite o status do pedido:");
        String status = scanner.nextLine();
        itemPedidoView.mostrarMensagem("Digite o ID do pedido:");
        int id_pedido = Integer.parseInt(scanner.nextLine());
        itemPedidoView.mostrarMensagem("Digite o ID do prato:");
        int id_prato = Integer.parseInt(scanner.nextLine());

        ItemPedido novoItemPedido = new ItemPedido(status, id_pedido ,id_prato);
        String retorno = itemPedidoController.cadastrarItemPedido(novoItemPedido);
        itemPedidoView.mostrarMensagem(retorno);
    }

    private void listarItemPedido() {
        itemPedidoView.mostrarMensagem("=== Itens pedidos Cadastrados ===");
        List<ItemPedido> itemPedidos = itemPedidoController.listarItemPedidos();
        itemPedidoView.listarItemPedido(itemPedidos);
        itemPedidoView.mostrarMensagem("===========================");
    }

    private void atualizarItemPedido() {
        itemPedidoView.mostrarMensagem("Digite o ID do item pedido a ser atualizado:");
        int id = scanner.nextInt();
        ItemPedido itemPedido = itemPedidoController.buscarItemPedido(id);
        if (itemPedido != null) {
            itemPedido.setId(id);
            scanner.nextLine(); // Limpar o buffer do scanner
            itemPedidoView.mostrarMensagem("Digite o novo status do pedido:");
            String status = scanner.nextLine();
            itemPedido.setStatus(status);
            itemPedidoView.mostrarMensagem("Digite o novo ID do pedido:");
            int id_pedido = Integer.parseInt(scanner.nextLine());
            itemPedido.setId_pedido(Integer.parseInt(String.valueOf(id_pedido)));
            itemPedidoView.mostrarMensagem("Digite o novo ID do prato:");
            int id_prato = Integer.parseInt(scanner.nextLine());
            itemPedido.setId_prato(id_prato);

            String retorno = itemPedidoController.atualizarItemPedido(itemPedido);
            itemPedidoView.mostrarMensagem(retorno);
        } else {
            itemPedidoView.mostrarMensagem("Item pedido não encontrado!");
        }
    }

    private void excluirItemPedido() {
        itemPedidoView.mostrarMensagem("Digite o ID do item pedido a ser excluído:");
        int id = scanner.nextInt();
        String retorno = itemPedidoController.excluirItemPedido(id);
        itemPedidoView.mostrarMensagem(retorno);
    }

    private void buscarItemPedido() {
        itemPedidoView.mostrarMensagem("Digite o ID do item pedido a ser buscado:");
        int id = scanner.nextInt();
        ItemPedido itemPedido = itemPedidoController.buscarItemPedido(id);
        if (itemPedido != null) {
            itemPedidoView.dadosItemPedido(itemPedido);
        } else {
            itemPedidoView.mostrarMensagem("Item pedido não encontrado!");
        }
    }

}