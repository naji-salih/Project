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
import javax.servlet.http.HttpSession;

import db.DbConnection;

/**
 * Servlet implementation class BuchServlet
 */
@WebServlet("/edit.html")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Bibi bibliothek = (Bibi) getServletContext().getAttribute("Bibliothek");
	private ArrayList<Book> buecherList = new ArrayList<Book>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getParameter("id") != null) {
			int id = Integer.parseInt(BookstoreController.check("id",request));
			
			//Get the book from global arrayList and set in session till after editing
			session.setAttribute("EditBuch", buecherList.get(id));
			RequestDispatcher rd = request.getRequestDispatcher("Bibliothek/edit.jsp");
			rd.forward(request, response);
		}else if(session.getAttribute("EditBuch")!= null) {
			Book b = (Book) session.getAttribute("EditBuch");
			int id = b.getId();
			session.removeAttribute("EditBuch");
			
			String titel = BookstoreController.check("titel",request);
			int seiten = BookstoreController.check("seiten",request) == "" ? 0 : Integer.parseInt(BookstoreController.check("seiten",request));
			String kategorie = BookstoreController.check("kate",request);
			String authorName = BookstoreController.check("name",request);
			String authorVname = BookstoreController.check("vname",request);
			LocalDate geburtsdatum = BookstoreController.check("gDatum",request)== "" ? null : LocalDate.parse(BookstoreController.check("gDatum",request));
			ArrayList<Author> authorList = new ArrayList<Author>();
			authorList.add(new Author(authorName,authorVname,geburtsdatum));
			buecherList.get(id).setTitel(titel);
			buecherList.get(id).setSeiten(seiten);
			buecherList.get(id).setKategorie(kategorie);
			buecherList.get(id).setAuthor(authorList);
			DbConnection.getInstance().open();
			new Bookdata().update(buecherList.get(id));
			try {
				DbConnection.getInstance().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bibliothek.setBuecherList(buecherList);
			request.setAttribute("Bibliothek", bibliothek);
			
			RequestDispatcher rd = request.getRequestDispatcher("Bibliothek/Uebersicht.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Something horrible went wrong");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
