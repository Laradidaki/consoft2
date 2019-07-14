package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Film;
import util.DbUtil;

public class FilmDao {

	 private Connection connection;

	    public FilmDao() {
	        connection = DbUtil.getConnection();
	    }

	    public void addFilm(Film film) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("insert into film(nomeFilm,durataFilm,annoFilm,costoFilm) values (?, ?, ?, ?)");
	            // Parameters start with 1
	            preparedStatement.setString(1, film.getNomeFilm());
	            preparedStatement.setString(2, film.getDurataFilm());
	            preparedStatement.setInt(3, film.getAnnoFilm());
	            preparedStatement.setDouble(4, film.getCostoFilm());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteFilm(int idFilm) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("delete from film where idFilm=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, idFilm);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateFilm(Film film) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update film set nomeFilm=?, durataFilm=?, annoFilm=?, costoFilm=?" +
	                            "where idFilm=?");
	            // Parameters start with 1
	           
	            preparedStatement.setString(1,film.getNomeFilm());
	            preparedStatement.setString(2, film.getDurataFilm());
	            preparedStatement.setInt(3, film.getAnnoFilm());
	            preparedStatement.setDouble(4, film.getCostoFilm());
	            preparedStatement.setInt(5, film.getIdFilm());
	            
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Film> getAllFilm() {
	        List<Film> movies = new ArrayList<Film>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from film");
	            while (rs.next()) {
	                Film film= new Film();
	                film.setIdFilm(rs.getInt("idFilm"));
	                film.setNomeFilm(rs.getString("nomeFilm"));
	                film.setDurataFilm(rs.getString("durataFilm"));
	                film.setAnnoFilm(rs.getInt("annoFilm"));
	                film.setCostoFilm(rs.getDouble("costoFilm"));
	                movies.add(film);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return movies;
	    }

	    public Film getFilmById(int idFilm) {
	       Film film= new Film();
	        try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from film where idFilm=?");
	            preparedStatement.setInt(1, idFilm);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	    film.setIdFilm(rs.getInt("idFilm"));
		                film.setNomeFilm(rs.getString("nomeFilm"));
		                film.setDurataFilm(rs.getString("durataFilm"));
		                film.setAnnoFilm(rs.getInt("annoFilm"));
		                film.setCostoFilm(rs.getDouble("costoFilm"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return film;
	    }
}
