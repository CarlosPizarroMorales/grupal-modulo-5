package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import modelo.Capacitacion;

public class CapacitacionDAO {
	
	 private static CapacitacionDAO instancia;
	    private Connection conexion;
	    private CapacitacionDAO() {
	        // Establecer la conexión a la base de datos en el constructor privado
	        // Usar Singleton para asegurar que solo haya una instancia de CapacitacionDAO
	        // y una única conexión a la base de datos en todo el proyecto
	        conexion = obtenerConexion(); // Implementar este método
	    }

	    public static CapacitacionDAO getInstancia() {
	        if (instancia == null) {
	            instancia = new CapacitacionDAO();
	        }
	        return instancia;
	    }

	    // Métodos CRUD

	    // C[Read]UD
	    /**
		 * Metodo para obtener una lista con Capacitaciones
		 *@return una lista de Capacitaciones
		 */
	    public List<Capacitacion> obtenerCapacitaciones() {
	    	
	        List<Capacitacion> capacitaciones = new ArrayList<>();
	        String consulta = "SELECT * FROM capacitaciones";

	        try (
	        	 PreparedStatement statement = conexion.prepareStatement(consulta);
	        		
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
	                Capacitacion capacitacion = new Capacitacion();
	                capacitacion.setIdCapacitacion(resultSet.getInt("idCapacitacion"));
	                capacitacion.setRutCliente(resultSet.getString("rutCliente"));
	                capacitacion.setDia(resultSet.getString("dia"));
	                capacitacion.setFecha(resultSet.getDate("fecha").toLocalDate());
	                capacitacion.setHora(resultSet.getTime("hora").toLocalTime());
	                capacitacion.setLugar(resultSet.getString("lugar"));
	                capacitacion.setDuracion(resultSet.getFloat("duracion"));
	                capacitacion.setAsistentes(resultSet.getInt("asistentes"));
	                capacitaciones.add(capacitacion);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return capacitaciones;
	    }

	    /**
		 *Metodo para obtener una capacitacion por Id
		 *@return  retorna Capacitacion desde base de datos
		 */
	    public Capacitacion obtenerCapacitacionPorId(String idCapacitacion) {
	        Capacitacion capacitacion = null;
	        String consulta = "SELECT * FROM capacitaciones WHERE idCapacitacion = ?";
	        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
	        	statement.setString(1, idCapacitacion);

	            try (ResultSet result = statement.executeQuery()) {
	                if (result.next()) {
	                	capacitacion = new Capacitacion();
	                	capacitacion.setIdCapacitacion(result.getInt("idCapacitacion"));
	                    capacitacion.setRutCliente(result.getString("rutCliente"));
	                    capacitacion.setDia(result.getString("dia"));
	                    capacitacion.setFecha(result.getDate("fecha").toLocalDate());
	                    capacitacion.setHora(result.getTime("hora").toLocalTime());
	                    capacitacion.setLugar(result.getString("lugar"));
	                    capacitacion.setDuracion(result.getFloat("duracion"));
	                    capacitacion.setAsistentes(result.getInt("asistentes"));
	           
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return capacitacion;
	    }

	     
	 	//[Create]RUD
	    public void agregarCapacitacion(Capacitacion capacitacion) {
	        String consulta ="INSERT INTO capacitaciones ( rutCliente, dia, fecha, hora, lugar,duracion, asistentes) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

	        try (
	        		
	        	PreparedStatement statement = conexion.prepareStatement(consulta)) {
	             statement.setString(1, capacitacion.getRutCliente());
	             statement.setString(2, capacitacion.getDia());
	             statement.setDate(3, Date.valueOf(capacitacion.getFecha()));
	             statement.setTime(4, Time.valueOf(capacitacion.getHora()));
	             statement.setString(5, capacitacion.getLugar());
	             statement.setFloat(6, capacitacion.getDuracion());
	             statement.setInt(7, capacitacion.getAsistentes());
	    
	            statement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    // CR[Update]D
	    public void actualizarCapacitacion(Capacitacion capacitacion) {
	    	 String consulta = "UPDATE capacitaciones SET rutCliente = ?, dia = ?, fecha = ?, hora = ?, lugar = ?, duracion = ?, asistentes = ? "+ "WHERE idCapacitacion = ?";

	        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
	        	 statement.setString(1, capacitacion.getRutCliente());
	             statement.setString(2, capacitacion.getDia());
	             statement.setDate(3, Date.valueOf(capacitacion.getFecha()));
	             statement.setTime(4, Time.valueOf(capacitacion.getHora()));
	             statement.setString(5, capacitacion.getLugar());
	             statement.setFloat(6, capacitacion.getDuracion());
	             statement.setInt(7, capacitacion.getAsistentes());
	             statement.setInt(8, capacitacion.getIdCapacitacion());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    // CRU[Delete]
	    public void eliminarCapacitacion(int idCapacitacion) {
	    	String consulta = "DELETE FROM capacitaciones WHERE idCapacitacion = ?";

	        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
	        	statement.setInt(1, idCapacitacion);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	   

	    // Obtener conexión
	    private Connection obtenerConexion() {
	        Connection conexion = null;

	        try {
	        	 // Establecer la conexión
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establecer los detalles de la conexión
//	            String url = "jdbc:mysql://localhost:3306/grupal5";
//	            String usuario = "root";
//	            String password = "admin";
	            String url = "jdbc:mysql://localhost:3306/m5_ejercicio_extra";
	            String usuario = "admin_modulo5";
	            String password = "abcd1234";

	           
	            conexion = DriverManager.getConnection(url, usuario, password);
	            System.out.println("Conexión exitosa...");
	        } catch (ClassNotFoundException e) {
	        	System.out.println("La clase para el driver no existe");
	            e.printStackTrace();
	        } catch (SQLException e) {
	        	System.out.println("Errores en la conexión con la base de datos:");
	            e.printStackTrace();
	            e.getErrorCode();
	            e.getMessage();
	        }

	        return conexion;
	    }
}
