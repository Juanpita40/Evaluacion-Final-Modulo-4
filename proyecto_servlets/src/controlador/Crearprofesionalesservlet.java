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
 * Servlet implementation class Crearprofesionalesservlet
 */
@WebServlet("/Crearprofesionalesservlet")
public class Crearprofesionalesservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crearprofesionalesservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("crearprofesionales.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rutprof = request.getParameter("rutprof");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellido");
		String telefono = request.getParameter("fono");
		String titulo = request.getParameter("titulo");
		String proyecto = request.getParameter("proyecto");
	
		
		Profesional prof = new Profesional();
		prof.setRun(rutprof);
		prof.setNombre(nombre);
		prof.setApellido(apellidos);
		prof.setTelefono(telefono);
		prof.setTitulo(titulo);
		prof.setProyecto(proyecto);
	
		Profesionaldaoimp profdao = new Profesionaldaoimp();
		boolean resultado = profdao.registrar(prof);

		request.setAttribute("result", resultado);
		request.getRequestDispatcher("msgecrearprofesional.jsp").forward(request, response);
	}

}
