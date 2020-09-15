package proyectoModel.entities;

public class DatosDeContacto {

	private int idPostulante;
	private String email;
	private int telefonoTrabajo;
	private int telefonoMovil;
	private int telefonoDomicilio;
	private int codigoPostal;

	public DatosDeContacto() {
		
	}
	
	public DatosDeContacto(int idPostulante, String email, int telefonoTrabajo, int telefonoMovil,
			int telefonoDomicilio, int codigoPostal) {
		this.idPostulante = idPostulante;
		this.email = email;
		this.telefonoTrabajo = telefonoTrabajo;
		this.telefonoMovil = telefonoMovil;
		this.telefonoDomicilio = telefonoDomicilio;
		this.codigoPostal = codigoPostal;
	}

	public int getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(int idPostulante) {
		this.idPostulante = idPostulante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefonoTrabajo() {
		return telefonoTrabajo;
	}

	public void setTelefonoTrabajo(int telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}

	public int getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(int telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public int getTelefonoDomicilio() {
		return telefonoDomicilio;
	}

	public void setTelefonoDomicilio(int telefonoDomicilio) {
		this.telefonoDomicilio = telefonoDomicilio;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "DatosDeContacto [idPostulante=" + idPostulante + ", email=" + email + ", telefonoTrabajo="
				+ telefonoTrabajo + ", telefonoMovil=" + telefonoMovil + ", telefonoDomicilio=" + telefonoDomicilio
				+ ", codigoPostal=" + codigoPostal + "]";
	}

	

	

}
