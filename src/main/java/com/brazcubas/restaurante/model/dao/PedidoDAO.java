package com.brazcubas.restaurante.model.dao;

import com.brazcubas.restaurante.config.DBConfig;
import com.brazcubas.restaurante.model.entity.Cliente;
import com.brazcubas.restaurante.model.entity.Funcionario;
import com.brazcubas.restaurante.model.entity.Pedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements IDAO {
    @Override
    public void cadastrar(Object obj) {

        Pedido Pedido = Pedido.class.cast(obj);
        //Funcionario Funcionario = Funcionario.class.cast(obj);
        //Cliente Cliente = Cliente.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "INSERT INTO Pedido (mesa, id_funcionario, id_cliente) VALUES ('" +
                    Pedido.getMesa() +
                    "','" +
                    Pedido.getId_funcionario() +
                    "','" +
                    Pedido.getId_cliente() +
                    "');";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void atualizar(Object obj) {
        Pedido Pedido = Pedido.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "UPDATE Pedido SET mesa = '" +
                    Pedido.getMesa() +
                    "' WHERE id =" +
                    Pedido.getId()
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

            String queryBuilder = "DELETE FROM Pedido WHERE id =" + id + ";";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object buscar(int id) {
        Pedido resultado;
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM Pedido where id=" + id + ";";

            ResultSet rs = statement.executeQuery(queryBuilder);

            if (rs.next()) {
                resultado = new Pedido(
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4));
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
        List<Pedido> resultados = new ArrayList<>();
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM Pedido;";

            ResultSet rs = statement.executeQuery(queryBuilder);

            while (rs.next()) {
                Pedido temp =
                        new Pedido(
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getInt(4));
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
