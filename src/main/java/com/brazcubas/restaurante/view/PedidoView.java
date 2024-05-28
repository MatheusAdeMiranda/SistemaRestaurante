package com.brazcubas.restaurante.view;

import com.brazcubas.restaurante.model.entity.Pedido;

import java.util.List;

public class PedidoView {
    public void dadosPedido(Pedido Pedido) {
        System.out.println("Dados Pedidos");
        System.out.println("ID: " + Pedido.getId());
        System.out.println("Mesa: " + Pedido.getMesa());
        System.out.println(("ID do cliente: " + Pedido.getId_cliente()));
        System.out.println(("ID do funcionario: " + Pedido.getId_funcionario()));
    }

    public void listarPedido(List<Pedido> Pedidos) {
        System.out.println("Lista de Pedidos");
        for (Pedido Pedido : Pedidos) {
            System.out.println(" ID: " + Pedido.getId() + " Mesa: " + Pedido.getMesa() + " ID do cliente: " + Pedido.getId_cliente() + " ID do funcionario: " + Pedido.getId_funcionario());
        }
    }

    public static void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
