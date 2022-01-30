package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/* Modulos de conexão */
	// parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/db_prod?useTimezone=true&serverTimezone=UTC";

	// metodo de conexão

	private String user = "root";
	private String password = "marcospaulo14";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	/* Crud Create */

	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produtos (nome,quantidade,tipo) values (?,?,?);";
		try {
			// abrindo a conexão com o banco
			Connection con = conectar();
			// preparando a query
			PreparedStatement pst = con.prepareStatement(create);
			// substituindo os parametros
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getQuantidade());
			pst.setString(3, produto.getTipo());
			// executando a query
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD READ */

	public ArrayList<JavaBeans> listagemProdutos() {
		// criando um objeto para acessar a classe javaBeans
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String read = "select * from produtos order by nome;";
		try {
			// abrindo a conexão com o banco
			Connection con = conectar();
			// preparando a query
			PreparedStatement pst = con.prepareStatement(read);
			// recebendo a resposta
			ResultSet rs = pst.executeQuery();
			// criando laço para exibir dados
			while (rs.next()) {
				// variaveis de apoio que recebem os valores do banco
				String idProd = rs.getString(1);
				String nome = rs.getString(2);
				String quantidade = rs.getString(3);
				String tipo = rs.getString(4);
				// populando o arraylist
				produtos.add(new JavaBeans(idProd, nome, quantidade, tipo));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Erro");
			return null;
		}
	}

	// Crud Update
	// selecionando os produtos
	public void selecionarProduto(JavaBeans produto) {
		String search = "select * from produtos where idprod=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(search);
			pst.setString(1, produto.getIdProd());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				produto.setIdProd(rs.getString(1));
				produto.setNome(rs.getString(2));
				produto.setQuantidade(rs.getString(3));
				produto.setTipo(rs.getString(4));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// alterando o produto
	public void updateProduto(JavaBeans produto) {
		String update = "update produtos set nome=?,quantidade=?,tipo=? where idprod=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getQuantidade());
			pst.setString(3, produto.getTipo());
			pst.setString(4, produto.getIdProd());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// excluindo o produto
	public void deleteProduto(JavaBeans produto) {
		String delete = "delete from produtos where produtos.idprod=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getIdProd());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
