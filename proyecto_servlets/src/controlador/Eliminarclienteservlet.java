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
 * Servlet implementation class Eliminarclienteservlet
 */
@WebServlet("/Eliminarclienteservlet")
public class Eliminarclienteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminarclienteservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rut = request.getParameter("cl");
		
		Cliente cli = new Cliente();
		cli.setRun(rut);
		
		Clientedaoimp clidao = new Clientedaoimp();
		boolean reselim = clidao.eliminar(cli);	
		request.setAttribute("resulteliminacion", reselim);
		request.getRequestDispatcher("msgeliminarcliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
