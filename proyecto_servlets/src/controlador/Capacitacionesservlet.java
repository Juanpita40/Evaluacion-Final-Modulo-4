package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Capacitaciondaoimp;
import modelo.Capacitacion;

/**
 * Servlet implementation class ControladorCliente
 */
@WebServlet("/Capacitacionesservlet")
public class Capacitacionesservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Capacitacionesservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Capacitaciondaoimp capadao = new Capacitaciondaoimp();
		List<Capacitacion> listacapac = new ArrayList<Capacitacion>();
		listacapac = capadao.obtener();
		request.setAttribute("listacapa", listacapac);
		request.getRequestDispatcher("listarcapacitaciones.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
