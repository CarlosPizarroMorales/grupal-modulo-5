package modelo;

import java.time.LocalDate;

public class Profesional extends Usuario{
	private LocalDate fechaIngreso;
	private String titulo;
	
	public Profesional() {}

	public Profesional(String rut, String nombres, String apellidos, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			String titulo) {
		super(rut, nombres, apellidos, fechaNacimiento);
		this.fechaIngreso = fechaIngreso;
		this.titulo = titulo;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Profesional [fechaIngreso=" + fechaIngreso + ", titulo=" + titulo + ", id=" + id + ", rut=" + rut
				+ ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ "]";
	}
}
