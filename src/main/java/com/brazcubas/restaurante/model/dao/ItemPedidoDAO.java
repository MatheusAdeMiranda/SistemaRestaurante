package com.brazcubas.restaurante.model.dao;

import com.brazcubas.restaurante.config.DBConfig;
import com.brazcubas.restaurante.model.entity.ItemPedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAO implements IDAO {
    @Override
    public void cadastrar(Object obj) {

        ItemPedido ItemPedido = ItemPedido.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "INSERT INTO ItemPedido (status,id_pedido, id_prato) VALUES ('" +
                    ItemPedido.getStatus() +
                    "','" +
                    ItemPedido.getId_pedido() +
                    "','" +
                    ItemPedido.getId_prato() +
                    "')";
//                    ItemPedido.getId() +
//                    "'');";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void atualizar(Object obj) {
        ItemPedido ItemPedido = ItemPedido.class.cast(obj);
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "UPDATE ItemPedido SET status = '" +
                    ItemPedido.getStatus() +
                    "' WHERE id = " +
                    ItemPedido.getId()
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

            String queryBuilder = "DELETE FROM ItemPedido WHERE id =" + id + ";";

            statement.executeUpdate(queryBuilder);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object buscar(int id) {
        ItemPedido resultado;
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM ItemPedido where id=" + id + ";";

            ResultSet rs = statement.executeQuery(queryBuilder);

            if (rs.next()) {
                resultado = new ItemPedido(
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
        List<ItemPedido> resultados = new ArrayList<>();
        try {
            Connection conn = DBConfig.getConnection();
            Statement statement = conn.createStatement();

            String queryBuilder = "SELECT * FROM ItemPedido;";

            ResultSet rs = statement.executeQuery(queryBuilder);

            while (rs.next()) {
                ItemPedido temp =
                        new ItemPedido(
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
