package com.brazcubas.restaurante.view;

import java.util.List;

import com.brazcubas.restaurante.model.entity.Cliente;

public class ClienteView {
    public void dadosCliente(Cliente cliente) {
        System.out.println("Dados clientes:");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF:" + cliente.getCpf());
        System.out.println("Telefone: " + cliente.getTelefone());
    }

    public void listarCliente(List<Cliente> clientes) {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + " Nome: " + cliente.getNome() + " CPF: " + cliente.getCpf() + " Telefone: " + cliente.getTelefone());
        }
    }

    public static void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
