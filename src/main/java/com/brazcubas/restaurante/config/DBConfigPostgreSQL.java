package com.brazcubas.restaurante.config;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConfigPostgreSQL {
    public Connection connect_to_db(String dbname, String user, String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, pass);
            if (conn!=null){
                System.out.println("Conexão estabelecida com sucesso!");
            }
            else {
                System.out.println("Conexão falhou");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }
}
