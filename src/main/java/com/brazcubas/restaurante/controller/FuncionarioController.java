package com.brazcubas.restaurante.controller;

import java.util.List;

import com.brazcubas.restaurante.model.dao.FuncionarioDAO;
import com.brazcubas.restaurante.model.dao.IDAO;
import com.brazcubas.restaurante.model.entity.Funcionario;

public class FuncionarioController {

    private IDAO<Funcionario> funcionarioDAO = new FuncionarioDAO();

    public FuncionarioController() { this.funcionarioDAO = funcionarioDAO; }

    public String cadastrarFuncionario(Funcionario Funcionario) {
        funcionarioDAO.cadastrar(Funcionario);
        return "Funcionario cadastrado com sucesso!";
    }

    public String atualizarFuncionario(Funcionario Funcionario) {
        funcionarioDAO.atualizar(Funcionario);
        return "Funcionario atualizado com sucesso!";
    }

    public String excluirFuncionario(int id) {
        funcionarioDAO.excluir(id);
        return "Funcionario excluído com sucesso!";
    }

    public Funcionario buscarFuncionario(int id) {
        return (Funcionario) funcionarioDAO.buscar(id);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioDAO.listar();
    }
}