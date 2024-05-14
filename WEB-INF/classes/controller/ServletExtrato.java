package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;
import java.util.*;

public class ServletExtrato extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		//acessa a sessao ativa
		HttpSession sessao = req.getSession();
		
		//estabelece conexao com BD
		ConexaoBd conexao = new ConexaoBd();
		conexao.conectar();
		
		//instancia um objeto emprestimos
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setConexao(conexao.getConexao());
		
		ArrayList <Emprestimo> colecao;
		
		//acessa os emprestimos abertos do usuario
		colecao = emprestimo.getEmprestimosAtivos(
			Integer.parseInt((String)sessao.getAttribute("id")));
		
		req.setAttribute("colecao", colecao);
		
		RequestDispatcher view = req.getRequestDispatcher("extrato.jsp");
		view.forward(req, resp);
	}
}
