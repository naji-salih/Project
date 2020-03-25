package bibi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import db.DbConnection;

public class Bookdata {

	public int insert(Book b) {
		int rowAffected = 0;
		try {
			if(b.getAuthor().get(0).getId() > 0) {
				//titel, int seiten, String kategorie, ArrayList<Author> author
				String sql = "INSERT into buecher (titel, genre, seiten, autor_id) values (?,?,?,?)";
				Connection con = DbConnection.getInstance().getConnection();
				PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				prstmt.setString(1, b.getTitel());
				prstmt.setString(2, b.getKategorie());
				prstmt.setInt(3, b.getSeiten());
				prstmt.setInt(4, b.getAuthor().get(0).getId());
				
				rowAffected = prstmt.executeUpdate();
				ResultSet rs = prstmt.getGeneratedKeys();
				if (rs.next()) {
					int primaryKey = rs.getInt(1);
					b.setId(primaryKey);
				}
			} else {
				//error Handeling for autor with no id
				rowAffected = -1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return rowAffected;
		}
		return rowAffected;

	}

	public int update(Book b) {
		int rowAffected = 0;
		try {
			String sql = "UPDATE buecher SET titel = ?, genre = ?, seiten = ? autor_id= ? WHERE idBuecher =?";
			Connection con = DbConnection.getInstance().getConnection();
			PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql);
			prstmt.setString(1, b.getTitel());
			prstmt.setString(2, b.getKategorie());
			prstmt.setInt(3, b.getSeiten());
			prstmt.setInt(4, b.getAuthor().get(0).getId());
			prstmt.setInt(5, b.getId());
			rowAffected = prstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return 0;
		}

		return rowAffected;
	}

	public int delete(int pk) {
		int rowAffected = 0;
		try {
			String sql = "DELETE FROM buecher WHERE id=?";
			Connection con = DbConnection.getInstance().getConnection();
			PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql);
			prstmt.setInt(1, pk);
			rowAffected = prstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return rowAffected;
		}

		return rowAffected;
	}

	public ArrayList<Book> selectAll() {
		ArrayList<Book> list = new ArrayList<Book>();
		AutorData dao = new AutorData();
		//momentan nur eine author möglich
		try {
			String sql = "SELECT * FROM buecher";
			Connection con = DbConnection.getInstance().getConnection();
			PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = prstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String titel = rs.getString(2);
				String kategorie = rs.getString(3);
				int seiten = rs.getInt(4);
				int autor_id = rs.getInt(5);
				Author autor = dao.selectId(autor_id);
				ArrayList<Author> aList = new ArrayList<Author>();
				aList.add(autor);
				list.add(new Book(id, titel, seiten, kategorie,aList));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return list;
	}
	
	public Book selectId(int pk) {
		Book b = null;
		ArrayList<Author> aList = null;
		Author autor = null;
		try {
			String sql = "SELECT * FROM buecher WHERE idBuecher = ?";
			Connection con = DbConnection.getInstance().getConnection();
			PreparedStatement prstmt = (PreparedStatement) con.prepareStatement(sql);
			prstmt.setInt(1, pk);
			ResultSet rs = prstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String titel = rs.getString(2);
				String kategorie = rs.getString(3);
				int seiten = rs.getInt(4);
				int autor_id = rs.getInt(5);
				autor = new AutorData().selectId(autor_id);
				aList.add(autor);
				b = new Book(id, titel, seiten, kategorie,aList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return b;
		}

		return b;
	}

}
