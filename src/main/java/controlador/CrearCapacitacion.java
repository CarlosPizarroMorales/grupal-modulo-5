package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CapacitacionDAO;
import modelo.Capacitacion;

/**
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet(name = "CrearCapacitacion",urlPatterns = {"/crear-capacitacion"})
public class CrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("views/crearCapacitacion.jsp");
		view.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("Hola en Crear capacitacion con POST");
		
		System.out.println(request.getParameter("rut"));
		System.out.println(request.getParameter("dia"));
		System.out.println(request.getParameter("date"));
		System.out.println(request.getParameter("hour"));
		System.out.println(request.getParameter("lugar"));
		System.out.println(request.getParameter("duracion"));
		System.out.println(request.getParameter("asistentes"));
		
		String rut = request.getParameter("rut");
		String dia = request.getParameter("dia");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		LocalTime hora = LocalTime.parse(request.getParameter("hour"));
		String lugar = request.getParameter("lugar");
		float duracion = Float.parseFloat(request.getParameter("duracion"));
		int asistentes = Integer.parseInt(request.getParameter("asistentes"));
		
		Capacitacion capacitacion = new Capacitacion(rut,dia,date,hora,lugar,duracion,asistentes);
		CapacitacionDAO capacitacionDao = CapacitacionDAO.getInstancia();	
		capacitacionDao.agregarCapacitacion(capacitacion);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
