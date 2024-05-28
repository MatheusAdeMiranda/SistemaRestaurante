package com.brazcubas.restaurante;

import com.brazcubas.restaurante.config.DBConfig;
import com.brazcubas.restaurante.config.DBConfigPostgreSQL;
import com.brazcubas.restaurante.controller.*;
import com.brazcubas.restaurante.model.dao.*;
import com.brazcubas.restaurante.view.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// Inicialização do Banco de Dados
		//DBConfig.createTables();
		//DBConfig.dropTables();
		//DBConfig.testconexao();

		//Inicialização de dependências
		ClienteView clienteView = new ClienteView();
		ClienteDAO clienteDAO = new ClienteDAO();
		ClienteController clienteController = new ClienteController();

		FuncionarioView funcionarioView = new FuncionarioView();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioController funcionarioController = new FuncionarioController();

		PedidoView pedidoView = new PedidoView();
		PedidoDAO pedidoDAO = new PedidoDAO();
		PedidoController pedidoController = new PedidoController();

		PratoView pratoView = new PratoView();
		PratoDAO pratoDAO = new PratoDAO();
		PratoController pratoController = new PratoController();

		ItemPedidoView itemPedidoView = new ItemPedidoView();
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		ItemPedidoController itemPedidoController = new ItemPedidoController();

		// Inicialização da CLI
		Scanner scanner = new Scanner(System.in);
		ClienteController ClienteController = new ClienteController();
		FuncionarioController FuncionarioController = new FuncionarioController();
		PedidoController PedidoController = new PedidoController();
		PratoController PratoController = new PratoController();
		ItemPedidoController ItemPedidoController = new ItemPedidoController();
		FuncionarioView FuncionarioView = new FuncionarioView();
		ClienteView ClienteView = new ClienteView();
		PedidoView PedidoView = new PedidoView();
		PratoView PratoView = new PratoView();
		ItemPedidoView ItemPedidoView = new ItemPedidoView();
		SistemaRestaurante sistema = new SistemaRestaurante(ClienteController, ClienteView, FuncionarioController, FuncionarioView, PedidoController, PedidoView, PratoController, PratoView, ItemPedidoController, ItemPedidoView, scanner);

		//Inicialização do sistema
		sistema.iniciar();
	}
}