package bibi;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbConnection;

/**
 * Servlet implementation class BibliothekServlet
 */
@WebServlet("/overview.html")
public class BibiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Bibi bibliothek = Bibi.getInstance();
	private ArrayList<Book> buecherList = new ArrayList<Book>();
	private int id = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BibiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() {
		try {
			DbConnection db = DbConnection.getInstance();
			if (db != null && !db.getConnection().isClosed()) {
				buecherList = new Bookdata().selectAll();
				System.out.println(buecherList);
				db.getConnection().close();
			} else {
				System.out.println("Something horrible went wrong 2 view");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ArrayList<Buch> buecherList = new ArrayList<Buch>();
		if (request.getParameter("send") != null) {
			String titel = BookstoreController.check("titel", request);
			int seiten = BookstoreController.check("seiten", request) == "" ? 0
					: Integer.parseInt(BookstoreController.check("seiten", request));
			String kategorie = BookstoreController.check("kate", request);
			String authorName = BookstoreController.check("name", request);
			String authorVname = BookstoreController.check("vname", request);
			LocalDate geburtsdatum = BookstoreController.check("gDatum", request) == "" ? null
					: LocalDate.parse(BookstoreController.check("gDatum", request));
			ArrayList<Author> authorList = new ArrayList<Author>();
			Author autor = new Author(authorName, authorVname, geburtsdatum);
			// Get arrrayList from Data class buch
			Book buch = new Book(titel, seiten, kategorie, authorList);
			
			try {
				DbConnection db = DbConnection.getInstance();
				db.open();
				if (db != null && !db.getConnection().isClosed()) {
					int a = new AutorData().insert(autor);
					authorList.add(autor);
					int b = new Bookdata().insert(buch);
					if(request.getServletContext().getAttribute("Bibliothek") != null) {
						bibliothek = (Bibi) request.getServletContext().getAttribute("Bibliothek"); 
					}
						buecherList.add(buch);
					if(a != 1)
						System.out.println("Autor insert fehler "+ a);
					if(b != 1)
						System.out.println("Buch insert fehler "+ b);
					db.getConnection().close();
				} else {
					System.out.println("Something horrible went wrong 1 insert");
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		bibliothek.setBuecherList(buecherList);
		getServletContext().setAttribute("Bibliothek", bibliothek);
		RequestDispatcher rd = request.getRequestDispatcher("Bibliothek/Uebersicht.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
