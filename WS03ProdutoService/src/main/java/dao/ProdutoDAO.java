package dao;

import model.Slav;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO extends DAO {	
	public ProdutoDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Slav produto) {
		boolean status = false;
		try {
			String sql = "INSERT INTO slav (codigo,nome, idade, curso) "
		               + "VALUES ((Select MAX(codigo) AS MaiorId from slav) + 1 ,'" + produto.getNome() + "', "
		               + produto.getIdade() + ",'" + produto.getCurso() + "');";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Slav get(int id) {
		Slav produto = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM slav WHERE codigo="+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 produto = new Slav(rs.getInt("codigo"), rs.getString("nome"), rs.getInt("idade"), rs.getString("Curso")); 

	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produto;
	}
	
	
	public List<Slav> get() {
		return get("");
	}

	
	public List<Slav> getOrderByID() {
		return get("codigo");		
	}
	
	
	public List<Slav> getOrderByNome() {
		return get("nome");		
	}
	
	
	public List<Slav> getOrderByCurso() {
		return get("curso");		
	}
	
	
	private List<Slav> get(String orderBy) {
		List<Slav> produtos = new ArrayList<Slav>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM slav" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Slav p = new Slav(rs.getInt("codigo"), rs.getString("nome"), 
	        			                rs.getInt("idade"), rs.getString("curso"));
	            produtos.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	
	public boolean update(Slav produto) {
		boolean status = false;
		try {  
			String sql = "UPDATE slav SET nome = '" + produto.getNome() + "', "
					   + "curso = '" + produto.getCurso() + "', " 
					   + "idade = " + produto.getIdade() + " "
					   + "WHERE codigo = " + produto.getCodigo();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM slav WHERE codigo = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}