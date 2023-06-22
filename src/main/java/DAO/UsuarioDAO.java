package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import modelo.Usuario;
import modelo.Cliente;
import modelo.Profesional;
import modelo.Administrativo;
import modelo.Capacitacion;

public class UsuarioDAO {
	

	 private static UsuarioDAO instancia;
	    private Connection conexion;
	    private UsuarioDAO() {
	        conexion = obtenerConexion();
	    }

	    public static UsuarioDAO getInstancia() {
	        if (instancia == null) {
	            instancia = new UsuarioDAO();
	        }
	        return instancia;
	    }

	    // Métodos CRUD

		// [Create]RUD
		public void crearUsuario(Usuario u){
			// 1. defino tipo de usuario con getSimpleName (en base a constructor)
			// 2. defino los 3 tipo de query INSERT...
			// 3. en bloque try/catch:
			// 3.1. switch sobre tipoUsuario y para cada caso:
			// 3.1.1. abre conexion
			// 3.1.2. setea campos correctos segun schema
			// 3.1.3. ejecuta query
			String tipoUsuario = u.getClass().getSimpleName();
			String insertCliente = "INSERT INTO usuario (rut, nombres, apellidos, fechaNacimiento, tipoUsuario, telefono, direccion, comuna, afp, sistemaSalud,	edad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			String insertProfesional = "INSERT INTO usuario (rut, nombres, apellidos, fechaNacimiento, tipoUsuario, titulo, fechaIngreso) VALUES (?, ?, ?, ?, ?, ?, ?);";
			String insertAdministrativo = "INSERT INTO usuario (rut, nombres, apellidos, fechaNacimiento, tipoUsuario, area, expPrevia) VALUES (?, ?, ?, ?, ?, ?, ?);";
			try {
				
				if (tipoUsuario.equals("Cliente")) {
					Cliente c = (Cliente) u;	
					PreparedStatement statement = conexion.prepareStatement(insertCliente);
					statement.setString(1, c.getRut());
					statement.setString(2, c.getNombres());
					statement.setString(3, c.getApellidos());
					statement.setDate(4, Date.valueOf(c.getFechaNacimiento()));
					statement.setString(5, "cliente");
					statement.setString(6, c.getTelefono());
					statement.setString(7, c.getDireccion());
					statement.setString(8, c.getComuna());
					statement.setString(9, c.getAfp());
					statement.setString(10, c.getSistemaSalud());
					statement.setInt(11, c.getEdad());
					statement.executeUpdate();
					System.out.println("Registro insertado correctamente");
				
				} else if (tipoUsuario.equals("Profesional")) {
					Profesional p = (Profesional) u;
					PreparedStatement statement = conexion.prepareStatement(insertProfesional);
					statement.setString(1, p.getRut());
					statement.setString(2, p.getNombres());
					statement.setString(3, p.getApellidos());
					statement.setDate(4, Date.valueOf(p.getFechaNacimiento()));
					statement.setString(5, "profesional");
					statement.setString(6, p.getTitulo());
					statement.setDate(7, Date.valueOf(p.getFechaIngreso()));
					statement.executeUpdate();
					System.out.println("Registro insertado correctamente");

				} else if (tipoUsuario.equals("Administrativo")) {
					Administrativo a = (Administrativo) u;
					PreparedStatement statement = conexion.prepareStatement(insertAdministrativo);
					statement.setString(1, a.getRut());
					statement.setString(2, a.getNombres());
					statement.setString(3, a.getApellidos());
					statement.setDate(4, Date.valueOf(a.getFechaNacimiento()));
					statement.setString(5, "administrativo");
					statement.setString(6, a.getArea());
					statement.setString(7, a.getExpPrevia());
					statement.executeUpdate();
					System.out.println("Registro insertado correctamente");
				}
				
			} catch (SQLException e){
				System.out.println("Ups, hubo un problemita con nuestra BD. Vuelva otro día, gracias :P");
				e.printStackTrace();
			}
		}

		
		// C[Read]UD
	    public List<Usuario> obtenerUsuarios() {
	    	
	        List<Usuario> usuarios = new ArrayList<>();
	        String consulta = "SELECT * FROM usuario";

	        try (
	        	 PreparedStatement statement = conexion.prepareStatement(consulta);
	        		
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
					// 1. resultSet.getString("tipoUsuario") asigno a variable
					// 2. switch case: cliente, profesional, administrativo
					// 2.1 caso cliente Cliente u = new Cliente(rut, nombres, apellidos, fechaNacimiento, telefono, direccion, comuna, afp, sistemaSalud, edad)
					// 2.2 caso profesional Profesional u = new Profesional(rut, nombres, apellidos, fechaNacimiento, fechaIngreso, titulo)
					// 2.3 caso admin Administrativo u = new Administrativo(rut, nombres, apellidos, fechaNacimiento, area, expPrevia)
					// 3. usuarios.add(u)
					// 4. retornar usuarios
					String tipoUsuario = resultSet.getString("tipoUsuario");

					switch (tipoUsuario){
						case "cliente":
							Cliente u = new Cliente();
							u.setId(resultSet.getInt("id"));
							u.setRut(resultSet.getString("rut"));
							u.setNombres(resultSet.getString("nombres"));
							u.setApellidos(resultSet.getString("apellidos"));
							u.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento")));
							u.setTelefono(resultSet.getString("telefono"));
							u.setDireccion(resultSet.getString("direccion"));
							u.setComuna(resultSet.getString("comuna"));
							u.setAfp(resultSet.getString("afp"));
							u.setSistemaSalud(resultSet.getString("sistemaSalud"));
							u.setEdad(resultSet.getInt("edad"));
							usuarios.add(u);
							break;
						case "profesional":
							Profesional p = new Profesional();
							p.setId(resultSet.getInt("id"));
							p.setRut(resultSet.getString("rut"));
							p.setNombres(resultSet.getString("nombres"));
							p.setApellidos(resultSet.getString("apellidos"));
							p.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento")));
							p.setTitulo(resultSet.getString("titulo"));
							p.setFechaIngreso(LocalDate.parse(resultSet.getString("fechaIngreso")));
							usuarios.add(p);
							break;
						case "administrativo":
							Administrativo a = new Administrativo();
							a.setId(resultSet.getInt("id"));
							a.setRut(resultSet.getString("rut"));
							a.setNombres(resultSet.getString("nombres"));
							a.setApellidos(resultSet.getString("apellidos"));
							a.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento")));
							a.setArea(resultSet.getString("area"));
							a.setExpPrevia(resultSet.getString("expPrevia"));
							usuarios.add(a);
							break;
						default:
							break;
					}
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return usuarios;
	    }
	    
	    
		// C[Read]UD un solo usuario por ID
	    public Usuario obtenerUsuarioPorId(int id) {
	    	
	        Usuario usuario = new Usuario();
	        String consulta = "SELECT * FROM usuario WHERE id = " + id + ";";

	        try (
	        	 PreparedStatement statement = conexion.prepareStatement(consulta);
	        		
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
					// 1. resultSet.getString("tipoUsuario") asigno a variable
					// 2. switch case: cliente, profesional, administrativo
					// 2.1 caso cliente Cliente u = new Cliente(rut, nombres, apellidos, fechaNacimiento, telefono, direccion, comuna, afp, sistemaSalud, edad)
					// 2.2 caso profesional Profesional u = new Profesional(rut, nombres, apellidos, fechaNacimiento, fechaIngreso, titulo)
					// 2.3 caso admin Administrativo u = new Administrativo(rut, nombres, apellidos, fechaNacimiento, area, expPrevia)
					// 3. usuarios.add(u)
					// 4. retornar usuarios
					String tipoUsuario = resultSet.getString("tipoUsuario");

					switch (tipoUsuario){
						case "cliente":
							Cliente u = new Cliente();
							u.setId(resultSet.getInt("id"));
							u.setRut(resultSet.getString("rut"));
							u.setNombres(resultSet.getString("nombres"));
							u.setApellidos(resultSet.getString("apellidos"));
							u.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento")));
							u.setTelefono(resultSet.getString("telefono"));
							u.setDireccion(resultSet.getString("direccion"));
							u.setComuna(resultSet.getString("comuna"));
							u.setAfp(resultSet.getString("afp"));
							u.setSistemaSalud(resultSet.getString("sistemaSalud"));
							u.setEdad(resultSet.getInt("edad"));
							usuario = (Usuario) u;
						case "profesional":
							Profesional p = new Profesional();
							p.setId(resultSet.getInt("id"));
							p.setRut(resultSet.getString("rut"));
							p.setNombres(resultSet.getString("nombres"));
							p.setApellidos(resultSet.getString("apellidos"));
							p.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento")));
							p.setTitulo(resultSet.getString("titulo"));
							p.setFechaIngreso(LocalDate.parse(resultSet.getString("fechaIngreso")));
							usuario = (Usuario) p;
						case "administrativo":
							Administrativo a = new Administrativo();
							a.setId(resultSet.getInt("id"));
							a.setRut(resultSet.getString("rut"));
							a.setNombres(resultSet.getString("nombres"));
							a.setApellidos(resultSet.getString("apellidos"));
							a.setFechaNacimiento(LocalDate.parse(resultSet.getString("fechaNacimiento")));
							a.setArea(resultSet.getString("area"));
							a.setExpPrevia(resultSet.getString("expPrevia"));
							usuario = (Usuario) a;
						default:
							break;
					}
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return usuario;
	    }

	
		// CR[Update]D
 	    public void actualizarUsuario(Usuario u) {
 	    	// 1. Obtengo constructor de usuario indeterminado para determinar tipoUsuario 
 	    	// 2. Creo sentencias SQL
 	    	// 3. Evalúo tipoUsuario y:
 	    	// 3.1 Según ella: 
 	    	// 3.2. Asigno los campos.
 	    	// 3.3. Ejecuto la consulta
 	    	String tipoUsuario = u.getClass().getSimpleName();
 	    	String updateUsuario = "UPDATE usuario SET rut = ?, nombres = ?, apellidos = ?, fechaNacimiento = ?, tipoUsuario = ?, telefono = ?, direccion = ?, comuna = ?, afp = ?, sistemaSalud = ?, edad = ?, area = ?, expPrevia = ?, titulo = ?, fechaIngreso = ? WHERE id = " + u.getId() + ";";
 	    	
	        try {
	        	PreparedStatement statement = conexion.prepareStatement(updateUsuario);

	        	if (tipoUsuario.equals("Cliente")) {
					Cliente c = (Cliente) u;	
					statement.setString(1, c.getRut());
					statement.setString(2, c.getNombres());
					statement.setString(3, c.getApellidos());
					statement.setDate(4, Date.valueOf(c.getFechaNacimiento()));
					statement.setString(5, "cliente");
					statement.setString(6, c.getTelefono());
					statement.setString(7, c.getDireccion());
					statement.setString(8, c.getComuna());
					statement.setString(9, c.getAfp());
					statement.setString(10, c.getSistemaSalud());
					statement.setString(12, null);
					statement.setString(13, null);
					statement.setString(14, null);
					statement.setDate(15, null);
					statement.executeUpdate();
					System.out.println("Registro modificado exitosamente");
				} else if (tipoUsuario.equals("Administrativo")) {
					Administrativo a = (Administrativo) u;	
					statement.setString(1, a.getRut());
					statement.setString(2, a.getNombres());
					statement.setString(3, a.getApellidos());
					statement.setDate(4, Date.valueOf(a.getFechaNacimiento()));
					statement.setString(5, "profesional");
					statement.setString(6, null);
					statement.setString(7, null);
					statement.setString(8, null);
					statement.setString(9, null);
					statement.setString(10, null);
					statement.setString(12, a.getArea());
					statement.setString(13, a.getExpPrevia());
					statement.setString(14, null);
					statement.setDate(15, null);
					statement.executeUpdate();
					System.out.println("Registro modificado exitosamente");
				} else if (tipoUsuario.equals("Profesional")) {
					Profesional p = (Profesional) u;	
					statement.setString(1, p.getRut());
					statement.setString(2, p.getNombres());
					statement.setString(3, p.getApellidos());
					statement.setDate(4, Date.valueOf(p.getFechaNacimiento()));
					statement.setString(5, "profesional");
					statement.setString(6, null);
					statement.setString(7, null);
					statement.setString(8, null);
					statement.setString(9, null);
					statement.setString(10, null);
					statement.setString(12, null);
					statement.setString(13, null);
					statement.setString(14, p.getTitulo());
					statement.setDate(15, Date.valueOf(p.getFechaIngreso()));
					statement.executeUpdate();
				}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	     
	    
		// CRU[Delete]
		public void eliminarUsuario(int id) {
    		String consulta = "DELETE FROM usuario WHERE id = ?;";

   			try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
        		statement.setInt(1, id);
        		int filasEliminadas = statement.executeUpdate();
        
        		if (filasEliminadas > 0) {
            		System.out.println("Usuario eliminado correctamente.");
        		} else {
            		System.out.println("No se encontró un usuario con el ID especificado.");
        		}
    		} catch (SQLException e) {
        		e.printStackTrace();
    		}
		}

		
		
		// Crear conexión: uso privado para devolver instancia/conexión
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
	            System.out.println(e.getErrorCode());
	            System.out.println(e.getMessage());
	        }

	        return conexion;
	    }
}
