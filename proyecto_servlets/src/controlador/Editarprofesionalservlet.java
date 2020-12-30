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
 * Servlet implementation class Editarprofesionalservlet
 */
@WebServlet("/Editarprofesionalservlet")
public class Editarprofesionalservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editarprofesionalservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rutprof = request.getParameter("pro");
		
		Profesionaldaoimp profdao = new Profesionaldaoimp();
		Profesional modificar = new Profesional();
		modificar.setRun(rutprof);
		Profesional datosprof = profdao.obtenerprofporrut(modificar);
		request.setAttribute("prof", datosprof);
		request.getRequestDispatcher("editarprofesional.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rut = request.getParameter("rut");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String telefono = request.getParameter("fono");
		String titulo = request.getParameter("titulo");
		String proyecto = request.getParameter("proyecto");

		
		Profesional prof = new Profesional();
		prof.setRun(rut);
		prof.setNombre(nombre);
		prof.setApellido(apellido);
		prof.setTelefono(telefono);
		prof.setTitulo(titulo);
		prof.setProyecto(proyecto);
		
		Profesionaldaoimp profdao = new Profesionaldaoimp();
		boolean resultado = profdao.actualizar(prof);

		request.setAttribute("result", resultado);
		request.getRequestDispatcher("msgeditarprofesional.jsp").forward(request, response);
	}

}
