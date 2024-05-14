<%
Boolean status = "false";
HttpSession sessao = request.getSession();
Object nomeSessao = sessao.getAttribute("nome");
 if (nomeSessao == null) {
  // Nao realizou Login
  status = "false";
 } else {
  // Esta logado
  status = "true" + nomeSessao;
 }



%>
<html>
  <head>
    <title>Biblioteca "Mundo Magico da Leitura"</title>
  </head>
  
  <body>
 <% //validar redirect  %>
  <img src="./imagens/R.png" alt="Logo">
    <h2>Sistema de Renovação de Emprestimos</h2>
    
    <form action="autenticacao" method="post">
      
      Nome de Usuario:
      <input type="text" name="nomeUsuario"> <br>
      
      Senha:
      <input type="password" name="senha"> <br>
      
      <input type="submit" value="Entrar">
    </form>
    
  </body>
  
</html>
