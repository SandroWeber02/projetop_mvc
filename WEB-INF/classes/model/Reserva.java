package model;

import java.sql.*;

public class Reserva {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void setConexao(Connection con) {
		this.con = con;
	}
	
	public int verificarReserva(int idLivro){
		
		int qtde;
		
		try {
			ps = con.prepareStatement(
				"SELECT COUNT(*) as qtde " +
				"FROM reserva " +
				"WHERE livId = ? and resStatus = 0"
			);
			
			ps.setInt(1, idLivro);
			rs = ps.executeQuery();
			
			rs.next();
			qtde = rs.getInt("qtde");
			
			// 0 - nao existe reserva
			// >= 1 - existe reserva
			return qtde;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
}
