package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CapacitacionDAO;
import modelo.Capacitacion;

/**
 * Servlet implementation class ModificarAndEliminar
 */
@WebServlet("/modificar-capacitacion")
public class ModificarCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCapacitacion = request.getParameter("idCapacitacion");
		CapacitacionDAO capacitacionDao = CapacitacionDAO.getInstancia();
        Capacitacion capacitacion = capacitacionDao.obtenerCapacitacionPorId(idCapacitacion);

        request.setAttribute("capacitacion", capacitacion);
        System.out.println(capacitacion);
        request.getRequestDispatcher("views/modificarCapacitacion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCapacitacion = request.getParameter("idCapacitacion");
		String rut = request.getParameter("rut");
		String dia = request.getParameter("dia");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		LocalTime hora = LocalTime.parse(request.getParameter("hour"));
		String lugar = request.getParameter("lugar");
		float duracion = Float.parseFloat(request.getParameter("duracion"));
		int asistentes = Integer.parseInt(request.getParameter("asistentes"));
		
		Capacitacion capacitacion = new Capacitacion(rut,dia,date,hora,lugar,duracion,asistentes);
		CapacitacionDAO capacitacionDao = CapacitacionDAO.getInstancia();	
		capacitacionDao.actualizarCapacitacion(capacitacion,idCapacitacion);
		request.getRequestDispatcher("views/listarCapacitacion.jsp").forward(request, response);
	}
}
