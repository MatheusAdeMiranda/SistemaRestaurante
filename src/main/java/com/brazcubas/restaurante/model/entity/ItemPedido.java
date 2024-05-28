package com.brazcubas.restaurante.model.entity;

public class ItemPedido {
    private int id;
    private String status;
    private int id_pedido;
    private int id_prato;


    public ItemPedido(String status, int id_pedido, int id_prato) {
        this.status = status;
        this.id_pedido = id_pedido;
        this.id_prato = id_prato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_prato() {
        return id_prato;
    }

    public void setId_prato(int id_prato) {
        this.id_prato = id_prato;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
