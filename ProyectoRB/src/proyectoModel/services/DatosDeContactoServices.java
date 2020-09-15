package proyectoModel.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proyectoModel.entities.DatosDeContacto;
import proyectoModel.utils.Conexion;

public class DatosDeContactoServices {
	
	private Conexion conexion = new Conexion();
	
	public boolean crear(DatosDeContacto d) {
		this.conexion.conectar();
		try {
			String sql = "INSERT INTO DATOS_DE_CONTACTOS (TELEFONO_TRABAJO,TELEFONO_MOVIL,EMAIL,"
					+ "TELEFONO_DOMICILIO,CODIGO_POSTAL,"
					+ "ID_POSTULANTE)"
					+" VALUES(?,?,?,?,?,?)";
			
			PreparedStatement st = this.conexion.getCon().prepareStatement(sql);		
			
			st.setInt(1, d.getTelefonoTrabajo());
			st.setInt(2, d.getTelefonoMovil());
			st.setString(3, d.getEmail());
			st.setInt(4, d.getTelefonoDomicilio());
			st.setInt(5, d.getCodigoPostal());	
			st.setInt(6, d.getIdPostulante());	
			
			st.executeUpdate();
			
			return true;
			
		}catch(SQLException ex) {
			return false;
		}finally {
			this.conexion.desconectar();
		}
	}
}
