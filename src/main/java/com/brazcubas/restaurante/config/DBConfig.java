package com.brazcubas.restaurante.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {

    private static final String DBNAME = "restaurante";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    //public static DBConfigPostgreSQL db = new DBConfigPostgreSQL();
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DBNAME, USER, PASSWORD);

    }

//    //public static void  testconexao() throws RuntimeException {
//        db.connect_to_db("restaurante","postgres","admin");
//    }

    public static void  dropTables() throws RuntimeException, SQLException {
        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();){
            stmt.executeUpdate("drop table if exists PEDIDO");
            stmt.executeUpdate("drop table if exists CLIENTE");
            stmt.executeUpdate("drop table if exists FUNCIONARIO");
            stmt.executeUpdate("drop table if exists PRATO");
            stmt.executeUpdate("drop table if exists ITEMPEDIDO");
        }
    }

    public static void createTables() throws RuntimeException {
        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();
        ) {
            // TABELA CLIENTE
            String sqlcliente = "CREATE TABLE CLIENTE " +
                    "(id SERIAL PRIMARY KEY, " +
                    " nome VARCHAR(255), " +
                    " cpf NUMERIC, " +
                    " telefone NUMERIC);";

            //stmt.executeUpdate("drop table if exists CLIENTE");
            System.out.println(stmt.executeUpdate(sqlcliente));
            System.out.println("Criando tabela no banco de dados");

            // TABELA FUNCIONARIO
            String sqlfuncionario = "CREATE TABLE FUNCIONARIO " +
                    "(id SERIAL PRIMARY KEY, " +
                    " nome VARCHAR(255), " +
                    " cargo VARCHAR(255));";

           // stmt.executeUpdate("drop table if exists FUNCIONARIO");
            System.out.println(stmt.executeUpdate(sqlfuncionario));
            System.out.println("Criando tabela no banco de dados");

            // TABELA PRATO
            String sqlprato = "CREATE TABLE PRATO " +
                    "(id SERIAL PRIMARY KEY, " +
                    " nome VARCHAR(255), " +
                    " preco DOUBLE PRECISION)";

            //stmt.executeUpdate("drop table if exists PRATO");
            System.out.println(stmt.executeUpdate(sqlprato));
            System.out.println("Criando tabela no banco de dados");

            // TABELA PEDIDO
            String sqlpedido = "CREATE TABLE PEDIDO (" +
                    "id SERIAL PRIMARY KEY, " +
                    "mesa NUMERIC, " +
                    "id_funcionario INT, " +
                    "id_cliente INT," +
                    "FOREIGN KEY (id_funcionario) REFERENCES FUNCIONARIO(id), " +
                    "FOREIGN KEY (id_cliente) REFERENCES CLIENTE(id))";

            //stmt.executeUpdate("drop table if exists PEDIDO");
            System.out.println(stmt.executeUpdate(sqlpedido));
            System.out.println("Criando tabela no banco de dados");

            // TABELA ITEM PEDIDO
            String sqlitempedido = "CREATE TABLE ITEMPEDIDO (" +
                    "id SERIAL PRIMARY KEY, " +
                    "status VARCHAR(255), " +
                    "id_pedido INT, " +
                    "id_prato INT, " +
                    "FOREIGN KEY (id_pedido) REFERENCES PEDIDO(id), " +
                    "FOREIGN KEY (id_prato) REFERENCES PRATO(id))";
            //stmt.executeUpdate("drop table if exists ITEMPEDIDO");
            System.out.println(stmt.executeUpdate(sqlitempedido));
            System.out.println("Criando tabela no banco de dados");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
