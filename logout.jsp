<%@ page import="javax.servlet.http.*" %>

<html>
	<head>
		<title>Biblioteca "Mundo Mágico da Leitura"</title>
	</head>
	
	<body>
		<h2>Sistema de Renovação de Empréstimos</h2>
		
		<p>
		<%
			HttpSession sessao = request.getSession();
			sessao.invalidate();
			response.sendRedirect("index.html");
		%>
		</p>
	</body>
	
</html>
