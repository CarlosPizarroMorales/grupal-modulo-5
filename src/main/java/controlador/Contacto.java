package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contacto
 */
@WebServlet(name = "Contacto",urlPatterns = {"/Contacto"})
public class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("views/contacto.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("username");
		String mail = request.getParameter("usermail");
		String mensaje = request.getParameter("usermessage");
		mostrarDatosFormulario(nombre, mail, mensaje);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	public static void mostrarDatosFormulario(String nombre,String mail,String mensaje) {
		System.out.println("****************************************************"
				+ "\nEsto está de testimonio para el 3er punto del Sprint"
				+ "\nSe ha recibido el formulario de contacto:"
				+ "\nNombre: " + nombre
				+ "\nEmail: " + mail
				+ "\nMensaje: " + mensaje);
	}
}
