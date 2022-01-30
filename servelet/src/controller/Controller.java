package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update","/delete", "/excluir" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans produto = new JavaBeans();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			produtos(request, response);
		} else if (action.equals("/insert")) {
			novoProduto(request, response);
		} else if (action.equals("/select")) {
			listarProduto(request, response);
		} else if (action.equals("/update")) {
			updateProduto(request, response);
		} else if (action.equals("/excluir")) {
			deleteProduto(request, response);
		} else if (action.equals("/delete")) {
			confirmarDeleteProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// listar produtos
	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando um objeto que ira receber a listagem da classe JavaBeans
		ArrayList<JavaBeans> lista = dao.listagemProdutos();
		/**/
		// encaminhando a lista para a pagina
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getIdProd());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getQuantidade());
		 * System.out.println(lista.get(i).getTipo()); }
		 */
	}

	// novo produto
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setNome(request.getParameter("nome"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setTipo(request.getParameter("tipo"));
		// invocar o metodo inserir contato passando o Contato
		dao.inserirProduto(produto);
		// redireciona a pagina
		response.sendRedirect("main");
	}

	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do contato que será editado
		System.out.println(request.getParameter("idprod"));
		String idProd = request.getParameter("idprod");
		produto.setIdProd(idProd);
		dao.selecionarProduto(produto);

		request.setAttribute("idprod", produto.getIdProd());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("quantidade", produto.getQuantidade());
		request.setAttribute("tipo", produto.getTipo());
		RequestDispatcher rd = request.getRequestDispatcher("editando.jsp");
		rd.forward(request, response);

	}

	protected void updateProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebendo os dados
		produto.setIdProd(request.getParameter("idprod"));
		produto.setNome(request.getParameter("nome"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setTipo(request.getParameter("tipo"));

		dao.updateProduto(produto);
		response.sendRedirect("main");

	}

	protected void confirmarDeleteProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebendo os dados
		System.out.println(request.getParameter("idprod"));
		String idprod = request.getParameter("idprod");
		produto.setIdProd(idprod);
		request.setAttribute("idprod", produto.getIdProd());
		RequestDispatcher rd = request.getRequestDispatcher("excluir.jsp");
		rd.forward(request, response);
	}

	protected void deleteProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebendo os dados
		produto.setIdProd(request.getParameter("idprod"));
		dao.deleteProduto(produto);
		response.sendRedirect("main");
	}
}
