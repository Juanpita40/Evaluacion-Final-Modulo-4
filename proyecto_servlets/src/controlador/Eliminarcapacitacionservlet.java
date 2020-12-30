package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Capacitaciondaoimp;
import modelo.Capacitacion;

/**
 * Servlet implementation class Eliminarclienteservlet
 */
@WebServlet("/Eliminarcapacitacionservlet")
public class Eliminarcapacitacionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminarcapacitacionservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idcliente = Integer.parseInt(request.getParameter("id"));
		
		Capacitacion capa = new Capacitacion();
		capa.setIdcapa(idcliente);
		
		Capacitaciondaoimp capadao = new Capacitaciondaoimp();
		boolean reselim = capadao.eliminar(capa);	
		request.setAttribute("resulteliminacion", reselim);
		request.getRequestDispatcher("msgeliminarcapacitaciones.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
