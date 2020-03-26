package db;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/db/LoginCheck")
public class Logincheck {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Logincheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String u = request.getParameter("user");
		String p = request.getParameter("pwd");

		HttpSession session = request.getSession();
		session.setAttribute("benutzer", u);
		request.setAttribute("benutzer", u);
		request.setAttribute("password", p);
		EntityManagerFactory f=Persistence.createEntityManagerFactory("jpa");
        EntityManager manager=f.createEntityManager();
		RequestDispatcher d = request.getRequestDispatcher("../page_s.jsp");
		if(!DBCon.authorized(manager, u, p)) {
			d=request.getRequestDispatcher("../login.jsp");
			response.sendRedirect("../page_n.html");
			System.out.println("Nicht geschafft!");
		}
		else {
			System.out.println("Geschaft!");
			d.forward(request,  response);
		}

	}

}
