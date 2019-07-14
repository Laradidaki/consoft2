package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Attore;
import util.DbUtil;

public class AttoreDao {
	
	 private Connection connection;

	    public AttoreDao() {
	        connection = DbUtil.getConnection();
	    }

	    public void addAttore(Attore attore) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("insert into attore(nomeAttore,cognomeAttore,etaAttore) values (?, ?, ? )");
	            // Parameters start with 1
	            preparedStatement.setString(1, attore.getNomeAttore());
	            preparedStatement.setString(2, attore.getCognomeAttore());
	            preparedStatement.setInt(3, attore.getEtaAttore());
	            preparedStatement.executeUpdate();

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public void deleteAttore(int idAttore) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("delete from attore where idAttore=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, idAttore);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateAttore(Attore attore) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update attore set nomeAttore=?, cognomeAttore=?, etaAttore=? where idAttore=?");
	            // Parameters start with 1
	           
	            preparedStatement.setString(1,attore.getNomeAttore());
	            preparedStatement.setString(2, attore.getCognomeAttore());
	            preparedStatement.setInt(3, attore.getEtaAttore());
	            preparedStatement.setInt(4, attore.getIdAttore());
	            
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Attore> getAllAttori() {
	        List<Attore> attori = new ArrayList<Attore>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from attore");
	            while (rs.next()) {
	                Attore attore = new Attore();
	                attore.setIdAttore(rs.getInt("idAttore"));
	                attore.setNomeAttore(rs.getString("nomeAttore"));
	                attore.setCognomeAttore(rs.getString("cognomeAttore"));
	                attore.setEtaAttore(rs.getInt("etaAttore"));
	                attori.add(attore);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return attori;
	    }

	    public Attore getAttoreById(int idAttore) {
	        Attore attore = new Attore();
	        try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from attore where idAttore=?");
	            preparedStatement.setInt(1, idAttore);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                attore.setIdAttore(rs.getInt("idAttore"));
	                attore.setNomeAttore(rs.getString("nomeAttore"));
	                attore.setCognomeAttore(rs.getString("cognomeAttore"));
	                attore.setEtaAttore(rs.getInt("etaAttore"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return attore;
	    }

}
