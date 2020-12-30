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
@WebServlet("/Eliminaradministrativoservlet")
public class Eliminaradministrativoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminaradministrativoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rutadmi = request.getParameter("ad");
		
		Administrativo admi = new Administrativo();
		admi.setRun(rutadmi);
		
		Administrativodaoimp admidao = new Administrativodaoimp();
		boolean reselim = admidao.eliminar(admi);	
		request.setAttribute("resulteliminacion", reselim);
		request.getRequestDispatcher("msgeliminaradministrativo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
