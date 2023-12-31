package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuarioDAO;

/**
 * Servlet implementation class EliminarUsuario
 */
@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get id
		String idGetted = request.getParameter("id");
		System.out.println(idGetted);
		//not null
		
		if (idGetted != null && !idGetted.isEmpty()){
		//inst
			System.out.println(idGetted + " testing in GET EliminarUsuario");
			UsuarioDAO usuarioDAO =  UsuarioDAO.getInstancia();
			usuarioDAO.eliminarUsuario(Integer.parseInt(idGetted));

		//say its ok
			response.getWriter().println("Usuario eliminado correctamente");
		} else {
		// say its not ok
			response.getWriter().println("ID erronea");
		}
		
		request.getRequestDispatcher("/usuarios").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
