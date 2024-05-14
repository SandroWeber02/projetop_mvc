package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;
import java.util.*;

public class ServletRenovacao extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		//estabelece conexao com BD
		ConexaoBd conexao = new ConexaoBd();
		conexao.conectar();
		
		//instancia um objeto emprestimo
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setConexao(conexao.getConexao());
		
		//instancia um objeto reserva
		Reserva reserva = new Reserva();
		reserva.setConexao(conexao.getConexao());
		
		//objeto para redirecionamento de requisição
		RequestDispatcher view = null;
		int idEmprestimo = Integer.parseInt(req.getParameter("idEmprestimo"));
		int idLivro = Integer.parseInt(req.getParameter("idLivro"));
		int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
		
		//verifica se ha reserva para o livro
		if (reserva.verificarReserva(idLivro) >= 1) {
			view = req.getRequestDispatcher("reservado.html");
		} else {
			if (emprestimo.renovar(idEmprestimo, idLivro, idUsuario)){
				view = req.getRequestDispatcher("renovado.html");
			}
		}
		
		view.forward(req, resp);
	}
}
