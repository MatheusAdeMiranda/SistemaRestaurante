package com.brazcubas.restaurante.controller;

import java.util.List;

import com.brazcubas.restaurante.model.dao.IDAO;
import com.brazcubas.restaurante.model.dao.PratoDAO;
import com.brazcubas.restaurante.model.entity.Prato;

public class PratoController {

    private IDAO<Prato> PratoDAO = new PratoDAO();

    public PratoController() { this.PratoDAO = new PratoDAO(); }

    public String cadastrarPrato(Prato Prato) {
        PratoDAO.cadastrar(Prato);
        return "Prato cadastrado com sucesso!";
    }

    public String atualizarPrato(Prato Prato) {
        PratoDAO.atualizar(Prato);
        return "Prato atualizado com sucesso!";
    }

    public String excluirPrato(int id) {
        PratoDAO.excluir(id);
        return "Prato excluído com sucesso!";
    }

    public Prato buscarPrato(int id) {
        return (Prato) PratoDAO.buscar(id);
    }

    public List<Prato> listarPratos() {
        return PratoDAO.listar();
    }
}
