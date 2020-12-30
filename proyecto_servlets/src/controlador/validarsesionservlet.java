package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class validarsesionservlet
 */
@WebServlet("/validarsesionservlet")
public class validarsesionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validarsesionservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession misesion = request.getSession();
		String sesion = (String) misesion.getAttribute("nombresesion");
		
		if (sesion == null) {
			
			response.sendRedirect("loginservlet");
			
		}
		
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
			
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String nombre = (String) request.getParameter("txtRut");
		String pass = (String) request.getParameter("login-pass");
		
		if (nombre.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("1234")) {
			
			HttpSession misesion = request.getSession();
			misesion.setAttribute("usuario", nombre);
			request.setAttribute("nousu", nombre);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			
		}else {
			
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
			
		}
		
		
		
	}

}
