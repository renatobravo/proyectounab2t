package proyectoModel.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proyectoModel.entities.Direccion;
import proyectoModel.utils.Conexion;

public class DireccionServices {
	
	private Conexion conexion = new Conexion();
	
	public boolean crear(Direccion d) {
		this.conexion.conectar();
		try {
			String sql = "INSERT INTO DIRECCIONES (CALLE,NUMERO,BLOC,"
					+ "DEPARTAMENTO,MANZANA,SITIO,REGION,COMUNA,LOCALIDAD,POBLACION,"
					+ "ID_POSTULANTE)"
					+" VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement st = this.conexion.getCon().prepareStatement(sql);		
			
			st.setString(1, d.getCalle());
			st.setInt(2, d.getNumero());
			st.setString(3, d.getBloc());
			st.setInt(4, d.getDepartamento());
			st.setString(5, d.getManzana());
			st.setString(6, d.getSitio());
			st.setString(7, d.getRegion());
			st.setString(8, d.getComuna());
			st.setString(9, d.getLocalidad());
			st.setString(10, d.getPoblacion());		
			st.setInt(11, d.getIdPostulante());	
			
			st.executeUpdate();
			
			return true;
			
		}catch(SQLException ex) {
			return false;
		}finally {
			this.conexion.desconectar();
		}
	}	
}
