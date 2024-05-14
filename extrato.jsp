<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="model.*" %>

<html>
	<head>
		<title>Biblioteca "Mundo M�gico da Leitura"</title>
	</head>
	
	<body>
	
	<h2>Sistema de Renova��o de Empr�stimos</h2>
	<%
		HttpSession sessao = request.getSession();
		Emprestimo emprestimo;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList colecao = (ArrayList)request.getAttribute("colecao");
	%>
	
	<h3>Extrato de Empr�stimos</h3>
	<p>Usu�rio: <%= sessao.getAttribute("nome") %></p>
	<%
		if (colecao.size() == 0){
			out.println("<p>N�o h� empr�stimos em aberto</p>");
		} else {
			out.println("<table border=\"1\">");
			out.println("<tr>");
			out.println("<th>Id Empr�stimo</th>");
			out.println("<th>Data Empr�stimo</th>");
			out.println("<th>Data Devolu��o</th>");
			out.println("<th>Dias com o livro</th>");
			out.println("<th>Id Livro</th>");
			out.println("<th>T�tulo Livro</th>");
			out.println("<th>Situa��o</th>");
			out.println("</tr>");
			
			//verifica se h� devolu��es em atraso
			boolean atraso = false;
			// for (int i=0; i < colecao.size(); i++) {
				// emprestimo = (Emprestimo)colecao.get(i);
				// if (emprestimo.getDias() > 7){
					// atraso = true;
				// }
			// }
			
			//exibe os registros de empr�stimo
			for (int i=0; i < colecao.size(); i++)
			{
				emprestimo = (Emprestimo)colecao.get(i);
				if (emprestimo.getDias() < 7){
					atraso = true;
				} else {
					atraso = false;
				}
				%>
				<tr>
				<td><%= emprestimo.getId() %></td>
				<td><%= sdf.format(emprestimo.getDataEmprestimo()) %></td>
				<td><%= sdf.format(emprestimo.getDataDevolucao()) %></td>
				<td><%= emprestimo.getDias() %></td>
				<td><%= emprestimo.getIdLivro() %></td>
				<td><%= emprestimo.getTitulo() %></td>
				<%
				if (atraso == false) {
					out.println("<td><a href=\"renovacao?" +
					"idEmprestimo=" +
					emprestimo.getId() + "&" +
					"idLivro=" +
					emprestimo.getIdLivro() + "&" +
					"idUsuario=" +
					sessao.getAttribute("id") +
					"\">Renovar</a></td>");
				} else {
					out.println("<td></td>");
				}
				%>
				</tr>
				<%
			} // fim for
			
		out.println("</table>");
	}
	%>
	<p><a href="logout.jsp">Sair do sistema</a></p>
	</body>
</html>