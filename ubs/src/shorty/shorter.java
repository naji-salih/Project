package shorty;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class shorter
 */
@WebServlet("/shorter")
public class shorter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<DataShort> list = new ArrayList<DataShort>();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shorter() {
        super();
        // TODO Auto-generated constructor stub
        
        list.add(new DataShort("naji", "salih",new Street("niemandstrasse", 10)));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("EineZahl", 15);
		request.setAttribute("EinString", "Heyy");
		
		HttpSession session = request.getSession();
		session.setAttribute("Counter", 74);
		session.setAttribute("EineZahl", 18);
		
		//DataShort p = new DataShort("Muster", "Hans", new Street ("Bahnhofstrasse", 18));
		request.setAttribute("DataShortList", list);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("short.jsp");
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
