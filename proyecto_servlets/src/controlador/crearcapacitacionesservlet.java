package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Capacitaciondaoimp;
import modelo.Capacitacion;


/**
 * Servlet implementation class crearcapacitacionesservlet
 */
@WebServlet("/crearcapacitacionesservlet")
public class crearcapacitacionesservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public crearcapacitacionesservlet() {
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
		
		
		request.getRequestDispatcher("crearcapacitaciones.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int idcapa = Integer.parseInt(request.getParameter("idcapacitacion"));
		String fecha = request.getParameter("fechacapa");
		String hora = request.getParameter("horacapa");
		String lugar = request.getParameter("lugar");
		int duracion = Integer.parseInt(request.getParameter("duracion"));
		int cantasist = Integer.parseInt(request.getParameter("cantasist"));
		int rut = Integer.parseInt(request.getParameter("rut"));

		Capacitacion capa = new Capacitacion();
		capa.setIdcapa(idcapa);
		capa.setDia(fecha);
		capa.setHora(hora);
		capa.setLugar(lugar);
		capa.setDuracion(duracion);
		capa.setCantasist(cantasist);
		capa.setRutclte(rut);
	
		Capacitaciondaoimp capadao = new Capacitaciondaoimp();
		boolean resultado = capadao.registrar(capa);

		request.setAttribute("result", resultado);
		request.getRequestDispatcher("msgcrearcapacitacion.jsp").forward(request, response);
	}

}
