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
 * Servlet implementation class Crearadministrativoservlet
 */
@WebServlet("/Crearadministrativoservlet")
public class Crearadministrativoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crearadministrativoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("crearadministrativo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rut = request.getParameter("rut");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String area = request.getParameter("area");

	
		
		Administrativo admi = new Administrativo();
		admi.setRun(rut);
		admi.setNombre(nombre);
		admi.setApellidos(apellidos);
		admi.setCorreo(correo);
		admi.setArea(area);
	
		Administrativodaoimp admidao = new Administrativodaoimp();
		boolean resultado = admidao.registrar(admi);

		request.setAttribute("result", resultado);
		request.getRequestDispatcher("msgcrearadministrativo.jsp").forward(request, response);
	}

}
