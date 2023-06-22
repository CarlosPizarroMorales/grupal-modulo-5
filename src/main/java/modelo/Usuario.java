package modelo;
import java.time.LocalDate;

public class Usuario {
	protected int id;
	protected String rut; 
	protected String nombres;
	protected String apellidos;
	protected LocalDate fechaNacimiento;
	
	public Usuario() {}
	
	public Usuario(String rut, String nombres, String apellidos, LocalDate fechaNacimiento) {
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", rut=" + rut + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}
