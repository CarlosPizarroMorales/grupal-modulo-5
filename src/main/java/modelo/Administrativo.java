package modelo;

import java.time.LocalDate;

public class Administrativo extends Usuario {
	private String area;
	private String expPrevia;
	
	public Administrativo() {}
	
	public Administrativo(String rut, String nombres, String apellidos, LocalDate fechaNacimiento, String area,
			String expPrevia) {
		super(rut, nombres, apellidos, fechaNacimiento);
		this.area = area;
		this.expPrevia = expPrevia;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExpPrevia() {
		return expPrevia;
	}

	public void setExpPrevia(String expPrevia) {
		this.expPrevia = expPrevia;
	}

	@Override
	public String toString() {
		return "Administrativo [area=" + area + ", expPrevia=" + expPrevia + ", id=" + id + ", rut=" + rut
				+ ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ "]";
	}
}
