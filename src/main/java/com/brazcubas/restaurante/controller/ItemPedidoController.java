package com.brazcubas.restaurante.controller;

import com.brazcubas.restaurante.model.dao.IDAO;
import com.brazcubas.restaurante.model.dao.ItemPedidoDAO;
import com.brazcubas.restaurante.model.entity.ItemPedido;

import java.util.List;

public class ItemPedidoController {

    private IDAO<ItemPedido> ItemPedidoDAO = new ItemPedidoDAO();

    public ItemPedidoController() { this.ItemPedidoDAO = new ItemPedidoDAO(); }

    public String cadastrarItemPedido(ItemPedido ItemPedido) {
        ItemPedidoDAO.cadastrar(ItemPedido);
        return "ItemPedido cadastrado com sucesso!";
    }

    public String atualizarItemPedido(ItemPedido ItemPedido) {
        ItemPedidoDAO.atualizar(ItemPedido);
        return "ItemPedido atualizado com sucesso!";
    }

    public String excluirItemPedido(int id) {
        ItemPedidoDAO.excluir(id);
        return "ItemPedido excluído com sucesso!";
    }

    public ItemPedido buscarItemPedido(int id) {
        return (ItemPedido) ItemPedidoDAO.buscar(id);
    }

    public List<ItemPedido> listarItemPedidos() {
        return ItemPedidoDAO.listar();
    }
}
