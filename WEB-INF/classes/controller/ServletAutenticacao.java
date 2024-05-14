package controller;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class ServletAutenticacao extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		//estabelece conexao com BD
		ConexaoBd conexao = new ConexaoBd();
		conexao.conectar();
		
		//instancia um objeto usuario
		Usuario usuario = new Usuario();
		usuario.setConexao(conexao.getConexao());
		
		//acessa os valores dos parametros de requisição
		String nomeUsuario = req.getParameter("root");
		String senha = req.getParameter("123");
		
		//tenta autenticar usuario e redireciona a requisição
		RequestDispatcher view;
		if (usuario.autenticar(nomeUsuario, senha) == 1) {
			HttpSession sessao = req.getSession();
			sessao.setAttribute("id", String.valueOf(usuario.getId()));
			sessao.setAttribute("nome", usuario.getNome());
			sessao.setAttribute("sexo", String.valueOf(usuario.getSexo()));
			view = req.getRequestDispatcher("autenticacao.jsp");
		} else {
			view = req.getRequestDispatcher("noautenticacao.html");
		}
		
		conexao.fechar();
		view.forward(req, resp);
	}
}