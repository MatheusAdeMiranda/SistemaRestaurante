package com.brazcubas.restaurante.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.brazcubas.restaurante.config.DBConfig;
import com.brazcubas.restaurante.model.entity.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO implements IDAO {
    @Override
    public List listar() {
        List<Cliente> resultados = new ArrayList<>();
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM Cliente;";

            ResultSet rs = statement.executeQuery(queryBuilder);

            while (rs.next()) {
                Cliente temp =
                        new Cliente(
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4));
                temp.setId(rs.getInt(1));
                resultados.add(temp);
            }
            statement.close();
            return resultados;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cadastrar(Object obj) {

        Cliente Cliente = Cliente.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "INSERT INTO Cliente (nome, cpf, telefone) VALUES ('" +
                    Cliente.getNome() +
                    "','" +
                    Cliente.getCpf() +
                    "','" +
                    Cliente.getTelefone() +
                   // ",'" +
                   // Cliente.getId() +
                    "');";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void atualizar(Object obj) {
        Cliente Cliente = Cliente.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "UPDATE Cliente SET nome = '" +
                    Cliente.getNome() +
                    "', cpf ='" +
                    Cliente.getCpf() +
                    "', telefone =" +
                    Cliente.getTelefone() +
                    " WHERE id = " +
                    Cliente.getId()
                    + ";";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) {
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "DELETE FROM Cliente WHERE id =" + id + ";";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object buscar(int id) {
        Cliente resultado;
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM Cliente where id=" + id + ";";

            ResultSet rs = statement.executeQuery(queryBuilder);

            if (rs.next()) {
                resultado = new Cliente(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                resultado.setId(rs.getInt(1));
                statement.close();
                return resultado;
            } else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
