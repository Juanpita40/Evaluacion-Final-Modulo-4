package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Clientedaoimp;
import modelo.Cliente;

/**
 * Servlet implementation class Crearclienteservlet
 */
@WebServlet("/Crearclienteservlet")
public class Crearclienteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crearclienteservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("crearcliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rut = request.getParameter("rut");
		String nombres = request.getParameter("nombre");
		String apellidos = request.getParameter("apellido");
		String telefono = request.getParameter("telefono");
		String afp = request.getParameter("afp");
		int sistemasalud = Integer.parseInt(request.getParameter("sistsalud"));
		String direccion = request.getParameter("direccion");
		String comuna = request.getParameter("comuna");
		int edad = Integer.parseInt(request.getParameter("edad"));

		
		Cliente clte = new Cliente();
		clte.setRun(rut);
		clte.setNombre(nombres);
		clte.setApellidos(apellidos);
		clte.setTelefono(telefono);
		clte.setAfp(afp);
		clte.setPrevision(sistemasalud);
		clte.setDireccion(direccion);
		clte.setComuna(comuna);
		clte.setEdad(edad);

		
		Clientedaoimp clidao = new Clientedaoimp();
		boolean resultado = clidao.registrar(clte);

		request.setAttribute("result", resultado);
		request.getRequestDispatcher("msgcrearcliente.jsp").forward(request, response);
	}

}
