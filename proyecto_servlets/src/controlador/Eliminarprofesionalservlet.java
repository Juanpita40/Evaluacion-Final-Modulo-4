package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Profesionaldaoimp;
import modelo.Profesional;

/**
 * Servlet implementation class Eliminarprofesionalservlet
 */
@WebServlet("/Eliminarprofesionalservlet")
public class Eliminarprofesionalservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminarprofesionalservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rutprof = request.getParameter("pro");
		
		Profesional prof = new Profesional();
		prof.setRun(rutprof);
		
		Profesionaldaoimp profdao = new Profesionaldaoimp();
		boolean reselim = profdao.eliminar(prof);	
		request.setAttribute("resulteliminacion", reselim);
		request.getRequestDispatcher("msgeliminarprofesional.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
