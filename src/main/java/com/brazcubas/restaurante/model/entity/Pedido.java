package com.brazcubas.restaurante.model.entity;

public class Pedido {
    private int id;
    private int id_cliente;
    private int id_funcionario;
    private String mesa;

    public Pedido(String mesa, int id_funcionario, int id_cliente) {
        this.mesa = String.valueOf(mesa);
        this.id_funcionario = id_funcionario;
        this.id_cliente = id_cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }
}
