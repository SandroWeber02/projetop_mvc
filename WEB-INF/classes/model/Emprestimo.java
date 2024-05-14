package model;

import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Emprestimo {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private int id;
	private java.util.Date dataEmprestimo;
	private java.util.Date dataDevolucao;
	private int dias;
	private int idLivro;
	private String titulo;
	
	
	public boolean renovar (int idEmprestimo, int idLivro, int idUsuario)
	{
		Calendar hoje = Calendar.getInstance();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd");
		if (registrarDevolucao(idEmprestimo)) {
			try {
				ps = con.prepareStatement(
					"INSERT INTO emprestimo " +
					"(empDataEmprestimo, empDataDevolucao, livId, usuId) " +
					"VALUES (?, ?, ?, ?)"
				);
				
				ps.setString(1, dataFormatada.format(hoje.getTime()));
				
				hoje.add(Calendar.DAY_OF_MONTH, 7);
				ps.setString(2, dataFormatada.format(hoje.getTime()));
				
				ps.setInt(3, idLivro);
				ps.setInt(4, idUsuario);
				
				ps.executeUpdate();
				
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean registrarDevolucao(int idEmprestimo)
	{
		java.util.Date hoje = new java.util.Date();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			ps = con.prepareStatement("UPDATE emprestimo " +
				"SET empDataDevolvido = ? " +
				"WHERE empId = ?"
			);
			
			ps.setString(1, dataFormatada.format(hoje));
			ps.setInt(2, idEmprestimo);
			
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public void setConexao(Connection con) {
		this.con = con;
	}

	public ArrayList <Emprestimo> getEmprestimosAtivos(int idUsuario) {
		ArrayList <Emprestimo> colecao = new ArrayList<Emprestimo>();
		try {
			ps = con.prepareStatement(
					"SELECT empId, empDataEmprestimo, empDataDevolucao, " +
					"(CURDATE() - empDataEmprestimo) as dias, " +
					"e.livId, livTitulo " +
					"FROM emprestimo e, livro l " +
					"WHERE e.livId = l.livId " +
					"AND empDataDevolvido IS NULL " +
					"AND usuId = ?"
			);
			
			ps.setInt(1, idUsuario);
			rs = ps.executeQuery();
			
			if (rs == null){
				return null;
			} else {
				
				Emprestimo e;
				
				while (rs.next())
				{
					e = new Emprestimo();
					e.id = rs.getInt("empId");
					e.dataEmprestimo = rs.getDate("empDataEmprestimo");
					e.dataDevolucao = rs.getDate("empDataDevolucao");
					e.dias = rs.getInt("dias");
					e.idLivro = rs.getInt("livId");
					e.titulo = rs.getString("livTitulo");
					colecao.add(e);
				}
				
				return colecao;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getId() {
		return id;
	}
	
	public java.util.Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public java.util.Date getDataDevolucao() {
		return dataDevolucao;
	}
	
	public int getDias() {
		return dias;
	}
	
	public int getIdLivro() {
		return idLivro;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
}
