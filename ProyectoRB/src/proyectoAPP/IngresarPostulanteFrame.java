package proyectoAPP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;


import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import proyectoModel.entities.Postulante;
import proyectoModel.services.PostulantesService;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;

public class IngresarPostulanteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField postulanteRunTxt;
	private JTextField postulanteApePaTxt;
	private JTextField postulanteNomTxt;
	private JTextField postulanteApMaTxt;
	private JTextField postulanteNacioTxt;
	private JTextField postulanteTeleTrabTxt;
	private JTextField postulanteTeleMovTxt;
	private JTextField postulanteEmailTxt;
	private JTextField postulanteCodPosTxt;
	private JTextField postulanteTeleDomTxt;

	public IngresarPostulanteFrame() {
		setTitle("Identificaci\u00F3n del Postulante");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00E9dula de Identidad:");
		lblNewLabel.setBounds(23, 61, 131, 20);
		contentPane.add(lblNewLabel);
		
		postulanteRunTxt = new JTextField();
		postulanteRunTxt.setBounds(184, 61, 120, 20);
		contentPane.add(postulanteRunTxt);
		postulanteRunTxt.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(23, 92, 102, 20);
		contentPane.add(lblApellidoPaterno);
		
		postulanteApePaTxt = new JTextField();
		postulanteApePaTxt.setColumns(10);
		postulanteApePaTxt.setBounds(184, 90, 120, 20);
		contentPane.add(postulanteApePaTxt);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
		lblNombreCompleto.setBounds(23, 120, 140, 20);
		contentPane.add(lblNombreCompleto);
		
		postulanteNomTxt = new JTextField();
		postulanteNomTxt.setColumns(10);
		postulanteNomTxt.setBounds(164, 120, 140, 20);
		contentPane.add(postulanteNomTxt);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setBounds(368, 60, 131, 23);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(368, 91, 102, 23);
		contentPane.add(lblApellidoMaterno);
		
		postulanteApMaTxt = new JTextField();
		postulanteApMaTxt.setColumns(10);
		postulanteApMaTxt.setBounds(503, 90, 120, 20);
		contentPane.add(postulanteApMaTxt);
		
		JLabel lblNewLabel_4_1 = new JLabel("Estado Civ\u00EDl:");
		lblNewLabel_4_1.setBounds(368, 119, 102, 23);
		contentPane.add(lblNewLabel_4_1);
		
		JComboBox postulanteEstadoTxt = new JComboBox();
		postulanteEstadoTxt.setModel(new DefaultComboBoxModel(new String[] {"", "Casado", "Conviviente Civ\u00EDl", "Soltero", "Divorciado", "Viudo"}));
		postulanteEstadoTxt.setBounds(503, 120, 120, 20);
		contentPane.add(postulanteEstadoTxt);
		
		JDateChooser postulanteFnacTxt = new JDateChooser();
		postulanteFnacTxt.setBounds(503, 61, 120, 20);
		contentPane.add(postulanteFnacTxt);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(23, 152, 102, 20);
		contentPane.add(lblNacionalidad);
		
		postulanteNacioTxt = new JTextField();
		postulanteNacioTxt.setColumns(10);
		postulanteNacioTxt.setBounds(184, 152, 120, 20);
		contentPane.add(postulanteNacioTxt);
		
		JLabel lblseEncuentraSeparado = new JLabel("\u00BFSe encuentra separado de hecho y presenta acreditaci\u00F3n de inicio tr\u00E1mite de divorcio?");
		lblseEncuentraSeparado.setHorizontalAlignment(SwingConstants.LEFT);
		lblseEncuentraSeparado.setVerticalAlignment(SwingConstants.TOP);
		lblseEncuentraSeparado.setBounds(23, 217, 510, 20);
		contentPane.add(lblseEncuentraSeparado);
		
		JComboBox postulanteSepaTxt = new JComboBox();
		postulanteSepaTxt.setModel(new DefaultComboBoxModel(new String[] {"", "Si", "No"}));
		postulanteSepaTxt.setBounds(573, 214, 50, 20);
		contentPane.add(postulanteSepaTxt);
		
		JLabel lbltieneCertificadoDe = new JLabel("\u00BFTiene certificado de permanencia?");
		lbltieneCertificadoDe.setVerticalAlignment(SwingConstants.TOP);
		lbltieneCertificadoDe.setHorizontalAlignment(SwingConstants.LEFT);
		lbltieneCertificadoDe.setBounds(23, 186, 231, 20);
		contentPane.add(lbltieneCertificadoDe);
		
		JComboBox postulanteCertPerTxt = new JComboBox();
		postulanteCertPerTxt.setModel(new DefaultComboBoxModel(new String[] {"", "Si", "No"}));
		postulanteCertPerTxt.setBounds(254, 183, 50, 20);
		contentPane.add(postulanteCertPerTxt);
		
		JLabel lblFe = new JLabel("Fecha de certificado de \r\npermanencia definitiva:");
		lblFe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFe.setHorizontalAlignment(SwingConstants.LEFT);
		lblFe.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblFe.setBounds(368, 151, 306, 23);
		contentPane.add(lblFe);
		
		JDateChooser postulanteFechPerTxt = new JDateChooser();
		postulanteFechPerTxt.setBounds(503, 183, 120, 20);
		contentPane.add(postulanteFechPerTxt);
		
		JLabel lblcuandoLaNacionalidad = new JLabel("(cuando la nacionalidad no sea Chilena)");
		lblcuandoLaNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcuandoLaNacionalidad.setVerticalAlignment(SwingConstants.TOP);
		lblcuandoLaNacionalidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblcuandoLaNacionalidad.setBounds(23, 200, 162, 11);
		contentPane.add(lblcuandoLaNacionalidad);
		
		
		JLabel lblEstadoInscripcin = new JLabel("Estado Inscripci\u00F3n");
		lblEstadoInscripcin.setBounds(420, 13, 131, 35);
		contentPane.add(lblEstadoInscripcin);
		
		JLabel lblNewLabel_1_1 = new JLabel("Folio N\u00B0 FFP");
		lblNewLabel_1_1.setBounds(23, 11, 131, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox postulanteInscripTxt = new JComboBox();
		postulanteInscripTxt.setModel(new DefaultComboBoxModel(new String[] {"", "Incompleto", "Completo"}));
		postulanteInscripTxt.setBounds(536, 21, 120, 20);
		contentPane.add(postulanteInscripTxt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID Postulante");
		lblNewLabel_1_1_1.setBounds(200, 20, 102, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		
		//Ingresar
		JButton ingresarBtn = new JButton("Ingresar");
		ingresarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			Postulante postulante = new Postulante();
			//postulante.setIdPostulante(Integer.parseInt(postulanteIdTxt.getText().trim()));
			//postulante.setIdPostulante(rs.getInt(1));
			//postulante.setEstadoInscrito(postulanteInscripTxt.getSelectedItem().toString());
			postulante.setNumCedulaIdentidad(postulanteRunTxt.getText().trim());
			postulante.setFechaNacimiento(postulanteFnacTxt.getDate());
			

	
					
				
			}
		});
		ingresarBtn.setBounds(516, 655, 140, 29);
		contentPane.add(ingresarBtn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(10, 11, 664, 39);
		contentPane.add(lblNewLabel_1);
		
		
		//Limpiar
		JButton limpiarBtn = new JButton("Limpiar");
		limpiarBtn.setBounds(352, 655, 140, 29);
		contentPane.add(limpiarBtn);
		
		JButton viviendaBtn = new JButton("Vivienda");
		viviendaBtn.setBounds(23, 588, 140, 29);
		contentPane.add(viviendaBtn);
		
		JButton acreditacionesBtn = new JButton("Acreditaciones");
		acreditacionesBtn.setBounds(184, 588, 140, 29);
		contentPane.add(acreditacionesBtn);
		
		JButton ahorroBtn = new JButton("Ahorros");
		ahorroBtn.setBounds(352, 588, 140, 29);
		contentPane.add(ahorroBtn);
		
		JButton conyugeBtn = new JButton("C\u00F3nyuge");
		conyugeBtn.setBounds(516, 588, 140, 29);
		contentPane.add(conyugeBtn);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setBounds(10, 571, 664, 65);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Datos de Contacto");
		lblNewLabel_1_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(23, 232, 651, 39);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono Trabajo:");
		lblNewLabel_3.setBounds(30, 282, 131, 20);
		contentPane.add(lblNewLabel_3);
		
		postulanteTeleTrabTxt = new JTextField();
		postulanteTeleTrabTxt.setColumns(10);
		postulanteTeleTrabTxt.setBounds(191, 282, 120, 20);
		contentPane.add(postulanteTeleTrabTxt);
		
		JLabel lblApellidoPaterno_1 = new JLabel("Tel\u00E9fono M\u00F3vil:");
		lblApellidoPaterno_1.setBounds(30, 313, 102, 20);
		contentPane.add(lblApellidoPaterno_1);
		
		postulanteTeleMovTxt = new JTextField();
		postulanteTeleMovTxt.setColumns(10);
		postulanteTeleMovTxt.setBounds(191, 313, 120, 20);
		contentPane.add(postulanteTeleMovTxt);
		
		JLabel lblNombreCompleto_1 = new JLabel("E-mail:");
		lblNombreCompleto_1.setBounds(30, 344, 102, 20);
		contentPane.add(lblNombreCompleto_1);
		
		postulanteEmailTxt = new JTextField();
		postulanteEmailTxt.setColumns(10);
		postulanteEmailTxt.setBounds(164, 344, 147, 20);
		contentPane.add(postulanteEmailTxt);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tel\u00E9fono Domicilio:");
		lblNewLabel_3_1.setBounds(375, 282, 131, 20);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblApellidoPaterno_1_1 = new JLabel("C\u00F3digo Postal:");
		lblApellidoPaterno_1_1.setBounds(368, 345, 102, 20);
		contentPane.add(lblApellidoPaterno_1_1);
		
		postulanteCodPosTxt = new JTextField();
		postulanteCodPosTxt.setColumns(10);
		postulanteCodPosTxt.setBounds(529, 350, 120, 20);
		contentPane.add(postulanteCodPosTxt);
		
		postulanteTeleDomTxt = new JTextField();
		postulanteTeleDomTxt.setColumns(10);
		postulanteTeleDomTxt.setBounds(536, 282, 120, 20);
		contentPane.add(postulanteTeleDomTxt);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(10, 271, 664, 114);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblNewLabel_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setBounds(10, 431, 664, 129);
		contentPane.add(lblNewLabel_2_1);
		
		
	}
}
