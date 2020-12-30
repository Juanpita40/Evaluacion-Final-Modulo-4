package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class contactoservlet
 */
@WebServlet("/contactoservlet")
public class contactoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactoservlet() {
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
		String sesion = (String) misesion.getAttribute("usuario");
		
		if (sesion == null) {
			
			response.sendRedirect("loginservlet");
		
		}else {
		request.setAttribute("nombresesion", misesion.getAttribute("usuario"));
		request.getRequestDispatcher("contacto.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellidop = request.getParameter("apellidop");
		String apellidom = request.getParameter("apellidom");
		String correo = request.getParameter("email");
		String mensaje = request.getParameter("mensaje");
		String tipo = request.getParameter("tipo");
		
		System.out.println(nombre);
		System.out.println(apellidop);
		System.out.println(apellidom);
		System.out.println(correo);
		System.out.println(mensaje);
		System.out.println(tipo);
		
	}

}
