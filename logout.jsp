<%@ page import="javax.servlet.http.*" %>

<html>
	<head>
		<title>Biblioteca "Mundo M�gico da Leitura"</title>
	</head>
	
	<body>
		<h2>Sistema de Renova��o de Empr�stimos</h2>
		
		<p>
		<%
			HttpSession sessao = request.getSession();
			sessao.invalidate();
			response.sendRedirect("index.html");
		%>
		</p>
	</body>
	
</html>
