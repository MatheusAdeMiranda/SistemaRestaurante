package com.brazcubas.restaurante.view;

import java.util.List;

import com.brazcubas.restaurante.model.entity.Prato;

public class PratoView {
    public void dadosPrato(Prato Prato) {
        System.out.println("Dados Pratos");
        System.out.println("ID: " + Prato.getId());
        System.out.println("Nome: " + Prato.getNome());
        System.out.println("Preço: " + Prato.getPreco());
    }

    public void listarPrato(List<Prato> Pratos) {
        System.out.println("Lista de Pratos");
        for (Prato Prato : Pratos) {
            System.out.println(" ID: " + Prato.getId() + " Nome: " + Prato.getNome() + " Preço: " + Prato.getPreco());
        }
    }

    public static void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
