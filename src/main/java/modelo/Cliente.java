package modelo;
import java.time.LocalDate;

public class Cliente extends Usuario{
	private String telefono;
	private String direccion;
	private String comuna;
	private String afp;
	private String sistemaSalud;
	private int edad;
	
	public Cliente() {}
	
	public Cliente(String rut, String nombres, String apellidos, LocalDate fechaNacimiento, String telefono,
			String direccion, String comuna, String afp, String sistemaSalud, int edad) {
		super(rut, nombres, apellidos, fechaNacimiento);
		this.telefono = telefono;
		this.direccion = direccion;
		this.comuna = comuna;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public String getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(String sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Cliente [telefono=" + telefono + ", direccion=" + direccion + ", comuna=" + comuna + ", afp=" + afp
				+ ", sistemaSalud=" + sistemaSalud + ", edad=" + edad + ", id=" + id + ", rut=" + rut + ", nombres="
				+ nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}
