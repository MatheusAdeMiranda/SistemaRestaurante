package com.brazcubas.restaurante.model.dao;

import java.util.List;

public interface IDAO<T> {

    void cadastrar(T entity);

    void atualizar(T entity);

    void excluir(int id);

    T buscar(int id);

    List<T> listar();

}