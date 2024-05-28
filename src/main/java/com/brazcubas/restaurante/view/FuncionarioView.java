package com.brazcubas.restaurante.view;

import java.util.List;

import com.brazcubas.restaurante.model.entity.Funcionario;

public class FuncionarioView {
    public void dadosFuncionario(Funcionario funcionario) {
        System.out.println("Dados Funcionários");
        System.out.println("ID: " + funcionario.getId());
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Cargo: " + funcionario.getCargo());
    }

    public void listarFuncionario(List<Funcionario> funcionarios) {
        System.out.println("Lista de Funcionários");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getId() + " Nome: " + funcionario.getNome() + " Cargo: " + funcionario.getCargo());
        }
    }

    public static void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
