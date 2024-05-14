package model;
import java.sql.*;

public class Usuario {
		
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private int id;
	private String nome;
	private char sexo;
	
	public void setConexao(Connection con) {
		this.con = con;
	}
	
	public int autenticar(String nomeUsuario, String senha) {
		int qtde;
		try {
			ps = con.prepareStatement("SELECT usuId, usuNome, usuSexo, " +
				"COUNT(*) as qtde FROM usuario " +
				"WHERE usuNomeUsuario = ? and usuSenha = ?");
			
			ps.setString(1, nomeUsuario);
			ps.setString(2, senha);
			
			rs = ps.executeQuery();
			
			rs.next();
			qtde = rs.getInt("qtde");
			
			if (qtde == 1) {
				this.id = rs.getInt("usuId");
				this.nome = rs.getString("usuNome");
				this.sexo = rs.getString("usuSexo").charAt(0);
			}
			
			// 0 - usuario n�o encontrado
			// 1 - usuario encontrado e autenticado
			return qtde;
			
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("------------------------------------------------");
			System.out.println("-  --  --  --  --  --  --  --  --  --  --  --  -");
			System.out.println("------------------------------------------------");
			System.out.println("Erro: " + e);
			System.out.println("------------------------------------------------");
			System.out.println("-  --  --  --  --  --  --  --  --  --  --  --  -");
			System.out.println("------------------------------------------------");
			return -1;
		}
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
}
