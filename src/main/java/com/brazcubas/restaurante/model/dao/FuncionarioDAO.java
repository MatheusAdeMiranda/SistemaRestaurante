package com.brazcubas.restaurante.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.brazcubas.restaurante.config.DBConfig;
import com.brazcubas.restaurante.model.entity.Funcionario;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncionarioDAO implements IDAO {
    @Override
    public void cadastrar(Object obj) {

        Funcionario Funcionario = Funcionario.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "INSERT INTO Funcionario (nome, cargo) VALUES ('" +
                    Funcionario.getNome() +
                    "','" +
                    Funcionario.getCargo() +
                    //Funcionario.getId() +
                    "');";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void atualizar(Object obj) {
        Funcionario Funcionario = Funcionario.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "UPDATE Funcionario SET nome = '" +
                    Funcionario.getNome() +
                    "', cargo ='" +
                    Funcionario.getCargo() +
                    "' WHERE id = " +
                    Funcionario.getId()
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

            String queryBuilder = "DELETE FROM Funcionario WHERE id =" + id + ";";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object buscar(int id) {
        Funcionario resultado;
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM Funcionario where id=" + id + ";";

            ResultSet rs = statement.executeQuery(queryBuilder);

            if (rs.next()) {
                resultado = new Funcionario(
                        rs.getString(2),
                        rs.getString(3));
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
        List<Funcionario> resultados = new ArrayList<>();
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM Funcionario;";

            ResultSet rs = statement.executeQuery(queryBuilder);

            while (rs.next()) {
                Funcionario temp =
                        new Funcionario(
                                rs.getString(2),
                                rs.getString(3));
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

