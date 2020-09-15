package proyectoModel.entities;

public class Direccion {

	private int idPostulante;
	private String calle;
	private int numero;
	private String bloc;
	private int departamento;
	private String manzana;
	private String sitio;
	private String region;
	private String comuna;
	private String localidad;
	private String poblacion;
	
	public Direccion() {
		
	}

	public Direccion(int idPostulante, String calle, int numero, String bloc, int departamento, String manzana,
			String sitio, String region, String comuna, String localidad, String poblacion) {
		this.idPostulante = idPostulante;
		this.calle = calle;
		this.numero = numero;
		this.bloc = bloc;
		this.departamento = departamento;
		this.manzana = manzana;
		this.sitio = sitio;
		this.region = region;
		this.comuna = comuna;
		this.localidad = localidad;
		this.poblacion = poblacion;
	}

	public int getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(int idPostulante) {
		this.idPostulante = idPostulante;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBloc() {
		return bloc;
	}

	public void setBloc(String bloc) {
		this.bloc = bloc;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public String getManzana() {
		return manzana;
	}

	public void setManzana(String manzana) {
		this.manzana = manzana;
	}

	public String getSitio() {
		return sitio;
	}

	public void setSitio(String sitio) {
		this.sitio = sitio;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return "Direccion [idPostulante=" + idPostulante + ", calle=" + calle + ", numero=" + numero + ", bloc=" + bloc
				+ ", departamento=" + departamento + ", manzana=" + manzana + ", sitio=" + sitio + ", region=" + region
				+ ", comuna=" + comuna + ", localidad=" + localidad + ", poblacion=" + poblacion + "]";
	}
	
	

	

}
