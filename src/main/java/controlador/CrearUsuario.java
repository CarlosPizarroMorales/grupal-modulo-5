package controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuarioDAO;
import modelo.*;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet(name="CrearUsuario",urlPatterns = {"/crear-usuario"})
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
		//String id = request.getParameter("id");
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
		System.out.println("Testeando crear usuario en la base de datos");
		
		Cliente c = new Cliente("15456789-8", "Pablo", "Pablito", LocalDate.parse("1999-10-25"), "+56912345678", "Las Casas 1234", "Talcahuano", "Modelo", "FONASA", 23);
		Profesional p = new Profesional("15456789-8", "Pablo", "Pablito", LocalDate.parse("1999-10-25"), LocalDate.parse("2021-12-26"), "Arquitecto");
		Administrativo a = new Administrativo("15456789-8", "Pablo", "Pablito", LocalDate.parse("1999-10-25"), "Hotelería", "Muchos años trabajando en de todo un poco...");
		
		usuarioDAO.crearUsuario(c);
		usuarioDAO.crearUsuario(p);
		usuarioDAO.crearUsuario(a);

	 */
		RequestDispatcher view = request.getRequestDispatcher("views/crearUsuario.jsp");
		view.forward(request, response); 
	}

	/**
	 * Este servlet se utiliza para crear y modificar un usuario cualquiera. 
	 * Para ello, existe un input oculto a la vista del usuario que porta el ID de este
	 * en el caso de que la vista haya sido creada por petición de /ModificarUsuario
	 * y es vacía cuando la vista se crea desde /crear-usuario
	 * Esta condición se valida al comienzo del bloque del método.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO usuarioDao = UsuarioDAO.getInstancia();
		
		System.out.println("Entrando en POST de CrearUsuario");
		//General
		
		
		String id = request.getParameter("id").trim();
		String rut = request.getParameter("rut");
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		
		String tipoUsuario = request.getParameter("tipoUsuario");
		System.out.println(tipoUsuario);
		//Cliente
		switch (tipoUsuario) {
			case "administrativo":
				String area = request.getParameter("area");
				String expPrevia = request.getParameter("expPrevia");
				//newAdministrativo
				Usuario a = new Administrativo(rut,nombres, apellidos,LocalDate.parse(fechaNacimiento),area,expPrevia);
				if (id != null) {
					a.setId(Integer.parseInt(id));
					usuarioDao.actualizarUsuario(a);
				} else {
					usuarioDao.crearUsuario(a);
				}
				break;
			case "profesional":
				String titulo = request.getParameter("titulo");
				LocalDate fechaIngreso = LocalDate.parse(request.getParameter("fechaIngreso"));
				Usuario p = new Profesional(rut, nombres, apellidos, LocalDate.parse(fechaNacimiento), fechaIngreso, titulo);
				if (id != null) {
					p.setId(Integer.parseInt(id));
					usuarioDao.actualizarUsuario(p);
				} else {
					usuarioDao.crearUsuario(p);
				}
				break;

			case "cliente":
					String telefono = request.getParameter("telefono");
					String direccion = request.getParameter("direccion");
					String comuna = request.getParameter("comuna");
					String afp = request.getParameter("afp");
					String salud = request.getParameter("salud");
					String edad = request.getParameter("edad");
					// new Cliente
					Usuario u = new Cliente(rut,nombres,apellidos,LocalDate.parse(fechaNacimiento),telefono,direccion,comuna,afp,salud,Integer.parseInt(edad));
					if (id!= null) {
						u.setId(Integer.parseInt(id));
						usuarioDao.actualizarUsuario(u);
					} else {
						usuarioDao.crearUsuario(u);
					}
				break;
		default:
			break;
		}
	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
