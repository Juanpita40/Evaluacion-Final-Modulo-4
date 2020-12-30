package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Administrativodaoimp;
import modelo.Administrativo;

/**
 * Servlet implementation class Eliminaradministrativoservlet
 */
@WebServlet("/Editaradministrativoservlet")
public class Editaradministrativoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editaradministrativoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rutadmi = request.getParameter("ad");
		
		Administrativodaoimp admidao = new Administrativodaoimp();
		Administrativo modificar = new Administrativo();
		modificar.setRun(rutadmi);
		Administrativo datosadmi = admidao.obteneradmiporut(modificar);
		request.setAttribute("admi", datosadmi);
		request.getRequestDispatcher("editaradministrativo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rut = request.getParameter("rut");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		String area = request.getParameter("area");

		
		Administrativo admi = new Administrativo();
		admi.setRun(rut);
		admi.setNombre(nombre);
		admi.setApellidos(apellidos);
		admi.setCorreo(correo);
		admi.setArea(area);
		
		Administrativodaoimp admidao = new Administrativodaoimp();
		boolean resultado = admidao.actualizar(admi);

		request.setAttribute("result", resultado);
		request.getRequestDispatcher("msgeditaradministrativo.jsp").forward(request, response);
	}

}
