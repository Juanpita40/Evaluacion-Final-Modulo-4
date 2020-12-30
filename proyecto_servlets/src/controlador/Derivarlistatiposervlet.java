package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Derivarlistatiposervlet
 */
@WebServlet("/Derivarlistatiposervlet")
public class Derivarlistatiposervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Derivarlistatiposervlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipousuario = request.getParameter("tipo");
		
		if (tipousuario.equalsIgnoreCase("cliente")) {
			request.getRequestDispatcher("Clienteservlet").forward(request, response);
		}else {
			if (tipousuario.equalsIgnoreCase("profesional")) {
				request.getRequestDispatcher("Profesionalservlet").forward(request, response);
			}
			request.getRequestDispatcher("Administrativoservlet").forward(request, response);
		}
		
	}

}
