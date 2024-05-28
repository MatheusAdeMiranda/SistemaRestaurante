package com.brazcubas.restaurante.view;

import java.util.List;

import com.brazcubas.restaurante.model.entity.ItemPedido;
import com.brazcubas.restaurante.model.entity.Pedido;
import com.brazcubas.restaurante.model.entity.Prato;

public class ItemPedidoView {
    public void dadosItemPedido(ItemPedido ItemPedido) {
        System.out.println("Dados Item Pedido");
        System.out.println("ID: " + ItemPedido.getId());
        System.out.println("ID Pedido: " + ItemPedido.getId_pedido());
        System.out.println("ID Prato: " + ItemPedido.getId_prato());
        System.out.println("Status: " + ItemPedido.getStatus());
    }

    public void listarItemPedido(List<ItemPedido> ItemPedidos) {
        System.out.println("Lista de Itens Pedidos");
        for (ItemPedido ItemPedido : ItemPedidos){
            System.out.println(" ID: " + ItemPedido.getId() + " ID Pedido: " + ItemPedido.getId_pedido() + " ID Prato: " + ItemPedido.getId_prato() + " Status: " + ItemPedido.getStatus());
        }
    }

    public static void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    //public void dadosItemPedido(ItemPedido itemPedido) {

    }


