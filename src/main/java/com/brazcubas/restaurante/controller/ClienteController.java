package com.brazcubas.restaurante.controller;

import java.util.List;

import com.brazcubas.restaurante.model.dao.ClienteDAO;
import com.brazcubas.restaurante.model.dao.IDAO;
import com.brazcubas.restaurante.model.entity.Cliente;

public class ClienteController {

    private IDAO<Cliente> clienteDAO = new ClienteDAO();

    public ClienteController() { this.clienteDAO = clienteDAO; }

    public String cadastrarCliente(Cliente Cliente) {
        clienteDAO.cadastrar(Cliente);
        return "Cliente cadastrado com sucesso!";
    }

    public String atualizarCliente(Cliente Cliente) {
        clienteDAO.atualizar(Cliente);
        return "Cliente atualizado com sucesso!";
    }

    public String excluirCliente(int id) {
        clienteDAO.excluir(id);
        return "Cliente excluído com sucesso!";
    }

    public Cliente buscarCliente(int id) {
        return (Cliente) clienteDAO.buscar(id);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }
}