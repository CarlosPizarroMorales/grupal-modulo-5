package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "Login", urlPatterns = {"/iniciar-sesion"})
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //public static String textLogInOutButton = "Iniciar Sesión";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				/*
		 * boton por GET se utilizará para hacer Logout
		 * Cuando se inicia la sesión se cambiará el texto de 
		 * "Iniciar Sesión" a "Cerrar Sesión"
		 * Si el atributo buscado existe, cerrar sesión.
		 * Si el atributo buscado no existe, quedarse en index.jsp
		 */
		if (request.getSession().getAttribute("usuario") == null) {
			System.out.println("No se ha iniciado sesión, no quedan acciones...");
		} else {
			System.out.println("La sesión está iniciada, se cerrará ahora...");
			//textLogInOutButton = "Cerrar Sesión";
			request.getSession().invalidate();
		}
		
		//request.setAttribute("textoBotonIngresarSalir", textLogInOutButton);
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//verificar que el usuario ingresado sea igual a “admin” y que la clave sea igual a “1234”.
				HttpSession session = request.getSession();
				String usuario = request.getParameter("rut");
				String password = request.getParameter("password");
				// si valida correctamente, a Inicio
				if(usuario.equals("admin") && password.equals("1234")) {
					session.setAttribute("usuario", usuario);
					session.setAttribute("password", password);
					String mensajeSaludo = "Bienvenido " + usuario;
					request.setAttribute("saludo", mensajeSaludo);
					RequestDispatcher view = request.getRequestDispatcher("index.jsp");
					view.forward(request, response);	
				} else {
					System.out.println("usuario incorrecto");
					doGet(request, response);	
				}

	}

}
