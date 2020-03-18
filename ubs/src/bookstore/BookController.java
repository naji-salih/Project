package bookstore;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DataBibi bibi = new DataBibi("Zurich Bibi", null);
    
    ArrayList <DataBuch> buecher = new ArrayList<DataBuch>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String buchName = request.getParameter("name");
		String buchGenre =request.getParameter("genre");
		int buchSeite =Integer.parseInt(request.getParameter("seiten"));
		
		String autorVname = request.getParameter("vname");
		String autorNname =request.getParameter("nname");
		LocalDate autorDatum =LocalDate.parse(request.getParameter("datum"));
		DataAutor autor = new DataAutor(autorVname, autorNname, autorDatum);
		DataBuch buch = new DataBuch(buchName,autor,buchSeite, buchGenre);
		buecher.add(buch);
		bibi.setBuch(buecher);
		
		request.setAttribute("Bibi", bibi);
		RequestDispatcher rd = request.getRequestDispatcher("liste.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
