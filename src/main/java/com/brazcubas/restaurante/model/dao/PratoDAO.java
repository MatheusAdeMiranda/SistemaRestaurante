package com.brazcubas.restaurante.model.dao;

import com.brazcubas.restaurante.config.DBConfig;
import com.brazcubas.restaurante.model.entity.Prato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PratoDAO implements IDAO {
    @Override
    public void cadastrar(Object obj) {

        Prato Prato = Prato.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "INSERT INTO Prato (nome, preco) VALUES ('" +
                    Prato.getNome() +
                    "','" +
                    Prato.getPreco() +
                    "');";
//                    Prato.getId() +
//                    "'');";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void atualizar(Object obj) {
        Prato Prato = Prato.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "UPDATE Prato SET nome = '" +
                    Prato.getNome() +
                    "', preco ='" +
                    Prato.getPreco() +
                    "' WHERE id = " +
                    Prato.getId()
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

            String queryBuilder = "DELETE FROM Prato WHERE id =" + id + ";";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object buscar(int id) {
        Prato resultado;
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM Prato where id=" + id + ";";

            ResultSet rs = statement.executeQuery(queryBuilder);

            if (rs.next()) {
                resultado = new Prato(
                        rs.getString(2),
                        rs.getFloat(3));
                resultado.setId(rs.getInt(1));
                statement.close();
                return resultado;
            } else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List listar() {
        List<Prato> resultados = new ArrayList<>();
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM Prato;";

            ResultSet rs = statement.executeQuery(queryBuilder);

            while (rs.next()) {
                Prato temp =
                        new Prato(
                                rs.getString(2),
                                rs.getFloat(3));
                temp.setId(rs.getInt(1));
                resultados.add(temp);
            }
            statement.close();
            return resultados;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
