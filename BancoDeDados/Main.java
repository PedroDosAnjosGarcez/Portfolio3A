package acesso_bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Main {

	public static void main(String[] args) {
		
		Banco.criarTabela("carro", "id serial primary key", "modelo varchar(50)", "marca varchar(30)");
		Banco.criarTabela("pessoa", "cpf varchar(11) primary key", "id_carro integer REFERENCES carro(id)", "nome varchar(50)", "endereco varchar(50)", "telefone varchar(9)");

		Carro corolla = new Carro("Volkswagen", "Corolla Cross 2021");
		Carro argo = new Carro("Fiat", "Argo 1.3 2021");

		Pessoa tel = new Pessoa("11122233344", "1", "Tel Newcanvas Dueart Siruva", "Rua da Lâmpada, Tijucas", "123456789");
		Pessoa gue = new Pessoa("44433322211", "2", "Guelhirmi Smilva de Sog", "Rua da Campainha, Barra do Aririú", "987654321");
		
		Banco.salvar(corolla);
		Banco.salvar(argo);
		Banco.salvar(tel);
		Banco.salvar(gue);

		Banco.visualiza_tabela("carro", "marca", "modelo");
		Banco.visualiza_tabela("pessoa", "cpf", "id_carro", "nome", "endereco", "telefone");

	}

}