package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Regista;
import util.DbUtil;

public class RegistaDao {
	
	private Connection connection;

	public RegistaDao() {
		
		connection=DbUtil.getConnection();
	}
	
	  public void addRegista(Regista regista) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("insert into regista(nomeRegista,cognomeRegista,etaRegista) values (?, ?, ? )");
	            // Parameters start with 1
	            preparedStatement.setString(1, regista.getNomeRegista());
	            preparedStatement.setString(2, regista.getCognomeRegista());
	            preparedStatement.setInt(3, regista.getEtaRegista());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteRegista(int idRegista) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("delete from regista where idRegista=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, idRegista);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateRegista(Regista regista) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update regista set nomeRegista=?, cognomeRegista=?, etaRegista=? where idRegista=?");
	            // Parameters start with 1
	           
	            preparedStatement.setString(1,regista.getNomeRegista());
	            preparedStatement.setString(2, regista.getCognomeRegista());
	            preparedStatement.setInt(3, regista.getEtaRegista());
	            preparedStatement.setInt(4, regista.getIdRegista());
	            
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Regista> getAllRegisti() {
	        List<Regista> registi = new ArrayList<Regista>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from regista");
	            while (rs.next()) {
	                Regista regista = new Regista();
	                regista.setIdRegista(rs.getInt("idRegista"));
	                regista.setNomeRegista(rs.getString("nomeRegista"));
	                regista.setCognomeRegista(rs.getString("cognomeRegista"));
	                regista.setEtaRegista(rs.getInt("etaRegista"));
	                registi.add(regista);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return registi;
	    }

	    public Regista getRegistaById(int idRegista) {
	        Regista regista = new Regista();
	        try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from regista where idRegista=?");
	            preparedStatement.setInt(1, idRegista);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	
	              regista.setIdRegista(rs.getInt("idRegista"));
	              regista.setNomeRegista(rs.getString("nomeRegista"));
	              regista.setCognomeRegista(rs.getString("cognomeRegista"));
	              regista.setEtaRegista(rs.getInt("etaRegista"));
	              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return regista;
	    }

}
