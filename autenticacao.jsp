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
			String nome = (String)sessao.getAttribute("nome");
			String sexo = (String)sessao.getAttribute("sexo");
			if (sexo.charAt(0) == 'F') {
				out.println("Seja bem-vinda, ");
			} else {
				out.println("Seja bem-vindo, ");
			}
			out.println(nome + "!");
		%>
		</p>
		
		<p><a href="extrato">Visualizar extrato</a></p>
	</body>
</html>