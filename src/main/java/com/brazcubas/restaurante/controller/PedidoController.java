package com.brazcubas.restaurante.controller;

import com.brazcubas.restaurante.model.dao.IDAO;
import com.brazcubas.restaurante.model.dao.PedidoDAO;
import com.brazcubas.restaurante.model.entity.Pedido;

import java.util.List;

public class PedidoController {

    private IDAO<Pedido> pedidoDAO = new PedidoDAO();

    public PedidoController() { this.pedidoDAO = pedidoDAO; }

    public String cadastrarPedido(Pedido Pedido) {
        pedidoDAO.cadastrar(Pedido);
        return "Pedido cadastrado com sucesso!";
    }

    public String atualizarPedido(Pedido Pedido) {
        pedidoDAO.atualizar(Pedido);
        return "Pedido atualizado com sucesso!";
    }

    public String excluirPedido(int id) {
        pedidoDAO.excluir(id);
        return "Pedido excluído com sucesso!";
    }

    public Pedido buscarPedido(int id) {
        return (Pedido) pedidoDAO.buscar(id);
    }

    public List<Pedido> listarPedidos() {
        return pedidoDAO.listar();
    }
}