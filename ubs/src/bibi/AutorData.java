package bibi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import db.DbConnection;

public class AutorData {
	public int insert(Author a) {
		int rowAffected = 0;
		try {

			String sql = "INSERT into autor (vorname, name, geburtsdatum) values (?,?,?)";
			Connection con = DbConnection.getInstance().getConnection();
			PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prstmt.setString(1, a.getVorname());
			prstmt.setString(2, a.getName());
			// umwandeln von localDate to sql Date
			prstmt.setDate(3, Date.valueOf(a.getGeburtsdatum()));
			rowAffected = prstmt.executeUpdate();
			ResultSet rs = prstmt.getGeneratedKeys();
			if (rs.next()) {
				int primaryKey = rs.getInt(1);
				a.setId(primaryKey);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return rowAffected;

	}

	public int update(Author a) {
		int rowAffected = 0;
		try {
			String sql = "UPDATE autor SET name = ?, vorname = ?, geburtsdatum = ? WHERE idAutor=?";
			Connection con = DbConnection.getInstance().getConnection();
			PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql);
			prstmt.setString(1, a.getVorname());
			prstmt.setString(2, a.getName());
			prstmt.setDate(3, Date.valueOf(a.getGeburtsdatum()));
			prstmt.setInt(4, a.getId());
			rowAffected = prstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			return 0;
		}
		
		return rowAffected;
	}

	public int delete(int pk) {
		int rowAffected = 0;
		try {
			String sql = "DELETE FROM autor WHERE idAutor =?";
			Connection con = DbConnection.getInstance().getConnection();
			PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql);
			prstmt.setInt(1, pk);
			rowAffected = prstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			return 0;
		}
		
		return rowAffected;
	}

	public ArrayList<Author> selectAll() {
		ArrayList<Author> list = null;
		try {
			String sql = "SELECT * FROM autor";
			Connection con = DbConnection.getInstance().getConnection();
			PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = prstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String vorname = rs.getString(2);
				String name = rs.getString(3);
				LocalDate gDate = rs.getDate(3).toLocalDate();
				list.add(new Author(id,vorname,name,gDate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return list;
	}
	
	
	public Author selectId(int pk) {
		Author a = null;
		try {
			String sql = "SELECT * FROM autor WHERE idAutor = ?";
			Connection con = DbConnection.getInstance().getConnection();
			PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql);
			prstmt.setInt(1, pk);
			ResultSet rs = prstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String vorname = rs.getString(2);
				String name = rs.getString(3);
				LocalDate gDate = rs.getDate(4).toLocalDate();
				a = new Author(id,vorname,name,gDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return a;
		}
		return a;
	}
}
