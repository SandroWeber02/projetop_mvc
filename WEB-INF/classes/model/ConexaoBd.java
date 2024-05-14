package model;
import java.sql.*;

public class ConexaoBd {
	
	Connection con;
	
	public boolean conectar() {
		String url;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
			String password = "123";
			url = "jdbc:mysql://localhost/biblioteca?user=" + user 
			+ "&password=" + password;
			con = DriverManager.getConnection(url);
			return true;
		} catch (Exception e) {
			//e.printStackTrace();
			
			System.out.println("------------------------------------------------");
			System.out.println("-  --  --  --  --  --  --  --  --  --  --  --  -");
			System.out.println("------------------------------------------------");
			System.out.println("Erro: " + e);
			System.out.println("------------------------------------------------");
			System.out.println("-  --  --  --  --  --  --  --  --  --  --  --  -");
			System.out.println("------------------------------------------------");
			
			return false;
		}
	}
	
	public void fechar() {
		try {
			con.close();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("------------------------------------------------");
			System.out.println("-  --  --  --  --  --  --  --  --  --  --  --  -");
			System.out.println("------------------------------------------------");
			System.out.println("Erro: " + e);
			System.out.println("------------------------------------------------");
			System.out.println("-  --  --  --  --  --  --  --  --  --  --  --  -");
			System.out.println("------------------------------------------------");
		}
	}
	
	public Connection getConexao() {
		return con;
	}
	
}
