package proyectoModel.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import proyectoModel.entities.Postulante;
import proyectoModel.utils.Conexion;


public class PostulantesService {

private Conexion conexion = new Conexion();
	

	public Postulante buscarPorRut(String rut) {
		this.conexion.conectar();
		Postulante postulante = null;
		try {
			String sql = "SELECT ID_POSTULANTE, ESTADO_INSCRITO, NUM_CEDULA_IDENTIDAD, FECHA_DE_NACIMIENTO, PRIMER_APELLIDO, SEGUNDO_APELLIDO, NOMBRES, NACIONALIDAD"
					+ "ESTADO_CIVIL, CERTIFICADO_PERMANENCIA, FECHA_CERTIFICADO_PERMANENCIA, ES_SEPARADO_DE_HECHO, TITULO, NUM_CUENTA FROM POSTULANTES"
					+" WHERE NUM_CEDULA_IDENTIDAD=? ";
			PreparedStatement st = this.conexion.getCon().prepareStatement(sql);
			st.setString(3, rut);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				
				postulante = new Postulante();
				postulante.setIdPostulante(rs.getInt(1));
				postulante.setEstadoInscrito(rs.getString(2));
				postulante.setFechaNacimiento(rs.getDate(4));
				postulante.setPrimerApellido(rs.getString(5));
				postulante.setSegundoApellido(rs.getString(6));
				postulante.setNombres(rs.getString(7));
				postulante.setNacionalidad(rs.getString(8));
				postulante.setEstadoCivil(rs.getString(9).charAt(0));
				postulante.setCertificadoPermanencia(rs.getString(10).charAt(0));
				postulante.setFechaCertificadoPermanencia(rs.getDate(11));
				postulante.setEsSeparadoDeHecho(rs.getString(12).charAt(0));
				postulante.setTitulo(rs.getString(13));
				postulante.setNumCuenta(rs.getInt(14));
				
			}
			rs.close();
			return postulante;
		}catch(Exception ex) {
			return null;
		}finally {
			this.conexion.desconectar();
		}
	}
	
	public boolean crear(Postulante p) {
		this.conexion.conectar();
		try {
			String sql = "INSERT INTO POSTULANTE (ID_POSTULANTE,ESTADO_INSCRITO,NUM_CEDULA_IDENTIDAD,FECHA_DE_NACIMIENTO,"
					+ "PRIMER_APELLIDO,SEGUNDO_APELLIDO,NOMBRES,NACIONALIDAD,ESTADO_CIVIL,CERTIFICADO_PERMANENCIA,FECHA_CERTIFICADO_PERMANENCIA,"
					+ "ES_SEPARADO_DE_HECHO,TITULO,NUM_CUENTA)"
					+" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement st = this.conexion.getCon().prepareStatement(sql);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			
			st.setInt(1, p.getIdPostulante());
			st.setString(2, p.getEstadoInscrito());
			st.setString(3, p.getNumCedulaIdentidad());
			st.setDate(4, java.sql.Date.valueOf(dateFormat.format(p.getFechaNacimiento())));
			st.setString(5, p.getPrimerApellido());
			st.setString(6, p.getSegundoApellido());
			st.setString(7, p.getNombres());
			st.setString(8, p.getNacionalidad());
			st.setString(9, String.valueOf(p.getEstadoCivil()));
			st.setString(10, String.valueOf(p.getCertificadoPermanencia()));
			st.setDate(11, java.sql.Date.valueOf(dateFormat.format(p.getFechaCertificadoPermanencia())));
			st.setString(12, String.valueOf(p.getEsSeparadoDeHecho()));
			st.setString(13, p.getTitulo());
			st.setInt(14, p.getNumCuenta());
			
			
			st.executeUpdate();
			
			return true;
			
		}catch(SQLException ex) {
			return false;
		}finally {
			this.conexion.desconectar();
		}
	}
	
	public List<Postulante> obtenerTodos(){
		this.conexion.conectar();
		List<Postulante> postulantes = new ArrayList<Postulante>();
		try {		
			
			String sql = "SELECT ID_POSTULANTE, ESTADO_INSCRITO, NUM_CEDULA_IDENTIDAD, FECHA_DE_NACIMIENTO, PRIMER_APELLIDO, SEGUNDO_APELLIDO, NOMBRES, NACIONALIDAD,"
					+ " ESTADO_CIVIL, CERTIFICADO_PERMANENCIA, FECHA_CERTIFICADO_PERMANENCIA, ES_SEPARADO_DE_HECHO, TITULO, NUM_CUENTA FROM POSTULANTES ORDER BY NOMBRES";
			PreparedStatement st = this.conexion.getCon().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				
				Postulante postulante = new Postulante();
				postulante.setIdPostulante(rs.getInt(1));
				postulante.setEstadoInscrito(rs.getString(2));
				postulante.setNumCedulaIdentidad(rs.getString(3));
				postulante.setFechaNacimiento(rs.getDate(4));
				postulante.setPrimerApellido(rs.getString(5));
				postulante.setSegundoApellido(rs.getString(6));
				postulante.setNombres(rs.getString(7));
				postulante.setNacionalidad(rs.getString(8));
				postulante.setEstadoCivil(rs.getString(9).charAt(0));
				postulante.setCertificadoPermanencia(rs.getString(10).charAt(0));
				postulante.setFechaCertificadoPermanencia(rs.getDate(11));
				postulante.setEsSeparadoDeHecho(rs.getString(12).charAt(0));
				postulante.setTitulo(rs.getString(13));
				postulante.setNumCuenta(rs.getInt(14));
				postulantes.add(postulante);
			}
			rs.close();
			return postulantes;
		}catch(Exception ex) {
			return null;
		}finally {
			this.conexion.desconectar();
		}
	}
	
	public boolean actualizarPorId(Postulante postulante) {
		
		this.conexion.conectar();
		try {
			String sql = "UPDATE POSTULANTES SET ESTADO_INSCRITO=?,"
					+ "NUM_CEDULA_IDENTIDAD=?,"
					//+ "FECHA_DE_NACIMIENTO=?,"
					//+ "PRIMER_APELLIDO=?,"
					//+ "SEGUNDO_APELLIDO=?,"
					+ "NOMBRES=?,"
					//+ "NACIONALIDAD=?,"
					//+ "ESTADO_CIVIL=?,"
					//+ "CERTIFICADO_PERMANENCIA=?,"
					//+ "FECHA_CERTIFICADO_PERMANENCIA=?,"
					//+ "ES_SEPARADO_DE_HECHO=?,"
					//+ "TITULO=?,"
					//+ "NUM_CUENTA=?,"
					+ " WHERE ID_POSTULANTE=?";

			PreparedStatement st = this.conexion.getCon().prepareStatement(sql);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			
			
			st.setString(1, postulante.getEstadoInscrito());
			st.setString(2, postulante.getNumCedulaIdentidad());
			st.setString(3, postulante.getNombres());
			st.setInt(4, postulante.getIdPostulante());
			/*
			st.setString(1, postulante.getEstadoInscrito());
			st.setString(2, postulante.getNumCedulaIdentidad());
			st.setDate(3, java.sql.Date.valueOf(dateFormat.format(postulante.getFechaNacimiento())));
			st.setString(4, postulante.getPrimerApellido());
			st.setString(5, postulante.getSegundoApellido());
			st.setString(6, postulante.getNombres());
			st.setString(7, postulante.getNacionalidad());
			st.setString(8, String.valueOf(postulante.getEstadoCivil()));
			st.setString(9, String.valueOf(postulante.getCertificadoPermanencia()));
			st.setDate(10, java.sql.Date.valueOf(dateFormat.format(postulante.getFechaCertificadoPermanencia())));
			st.setString(11, String.valueOf(postulante.getEsSeparadoDeHecho()));
			st.setString(12, postulante.getTitulo());
			st.setInt(13, postulante.getNumCuenta());
			st.setInt(14, postulante.getIdPostulante());*/
			
			st.executeUpdate();
			
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			this.conexion.desconectar();
		}
	}
	
	public boolean eliminarPorRut(Postulante p) {
		this.conexion.conectar();
		try {
			
			String sql = "DELETE FROM POSTULANTES WHERE NUM_CEDULA_IDENTIDAD=?";
			PreparedStatement st = this.conexion.getCon().prepareStatement(sql);
			st.setString(1, p.getNumCedulaIdentidad());
			
			st.executeUpdate();
			
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			this.conexion.desconectar();
		}
	
	}

}
