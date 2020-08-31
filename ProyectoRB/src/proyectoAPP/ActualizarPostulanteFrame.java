package proyectoAPP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import proyectoModel.entities.Postulante;
import proyectoModel.services.PostulantesService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;

public class ActualizarPostulanteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField postulanteIdTxt;
	private JTextField postulanteRutTxt;
	private JTextField postulanteNombreTxt;
	private JComboBox<Postulante> postulantesCbx;
	private JTextField postulanteNacTxt;
	private JTextField postulanteApePatTxt;
	private JTextField postulanteApeMatTxt;
	private JComboBox<Postulante> postulanteInscripTxt;


	public ActualizarPostulanteFrame() {setTitle("Actualizar Postulantes");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 700, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	postulanteIdTxt = new JTextField();
	postulanteIdTxt.setEnabled(false);
	postulanteIdTxt.setColumns(10);
	postulanteIdTxt.setBounds(543, 28, 120, 20);
	contentPane.add(postulanteIdTxt);
	
	postulanteRutTxt = new JTextField();
	postulanteRutTxt.setColumns(10);
	postulanteRutTxt.setBounds(160, 78, 120, 20);
	contentPane.add(postulanteRutTxt);
	
	postulanteNombreTxt = new JTextField();
	postulanteNombreTxt.setColumns(10);
	postulanteNombreTxt.setBounds(133, 109, 147, 20);
	contentPane.add(postulanteNombreTxt);
	
	
	//Actualizar
	JButton actualizarBtn = new JButton("Actualizar");
	actualizarBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//TODO: Validar
			Postulante postulante = new Postulante();
			postulante.setIdPostulante(Integer.parseInt(postulanteIdTxt.getText().trim()));
			postulante.setNumCedulaIdentidad(postulanteRutTxt.getText().trim());
			postulante.setEstadoInscrito(postulanteInscripTxt.getSelectedItem().toString());
			postulante.setNombres(postulanteNombreTxt.getText().trim());
			PostulantesService postulanteService = new PostulantesService();
			JOptionPane.showMessageDialog(null, "ID: "+postulante.getIdPostulante()+" Rut: "+postulante.getNumCedulaIdentidad()+" Estado: "+postulante.getEstadoInscrito()+" Nom: "+postulante.getNombres());
			if(postulanteService.actualizarPorId(postulante)) {
				Postulante seleccionado = (Postulante)postulantesCbx.getSelectedItem();
				
				cargarCombo();
				//Esta es una solucion más fina
				/* for(int i=0; i < postulantesCbx.getItemCount(); ++i) {
					
					Postulante actual = postulantesCbx.getItemAt(i);
					
					if(seleccionado.getNumCedulaIdentidad().equals(actual.getNumCedulaIdentidad())) {
						postulantesCbx.setSelectedIndex(i);
						break;
					}
				} */
				
				
				JOptionPane.showMessageDialog(null, "Cargo actualizado");
			} else {
				JOptionPane.showMessageDialog(null, "Error al actualizar el cargo");
			}
		}
	});
	actualizarBtn.setBounds(546, 321, 117, 29);
	contentPane.add(actualizarBtn);
	
	postulantesCbx = new JComboBox<Postulante>();
	postulantesCbx.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Postulante postulante = (Postulante)postulantesCbx.getSelectedItem();
			if(postulante != null) {
				//Cargar el formulario
				postulanteIdTxt.setText((String.valueOf(postulante.getIdPostulante())));
				postulanteRutTxt.setText(postulante.getNumCedulaIdentidad());
				//Forma simple
				//postulanteInscripTxt.setText(postulante.getEstadoInscrito());
				//Forma descente
				postulanteNombreTxt.setText(postulante.getNombres());
				actualizarBtn.setEnabled(true);
				
			}else {
				actualizarBtn.setEnabled(false);
			}
		}
	});
	postulantesCbx.setBounds(163, 28, 230, 20);
	contentPane.add(postulantesCbx);
	
	JLabel lblNewLabel_4 = new JLabel("Seleccione un postulante:");
	lblNewLabel_4.setBounds(21, 28, 168, 20);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblEstadoInscripcin = new JLabel("Estado Inscripci\u00F3n");
	lblEstadoInscripcin.setBounds(337, 75, 102, 27);
	contentPane.add(lblEstadoInscripcin);
	
	JLabel lblNewLabel_1_1_1 = new JLabel("ID Postulante");
	lblNewLabel_1_1_1.setBounds(446, 28, 87, 20);
	contentPane.add(lblNewLabel_1_1_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("");
	lblNewLabel_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
	lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
	lblNewLabel_1_1.setBounds(10, 11, 664, 50);
	contentPane.add(lblNewLabel_1_1);
	
	postulanteNacTxt = new JTextField();
	postulanteNacTxt.setColumns(10);
	postulanteNacTxt.setBounds(160, 173, 120, 20);
	contentPane.add(postulanteNacTxt);
	
	postulanteApePatTxt = new JTextField();
	postulanteApePatTxt.setColumns(10);
	postulanteApePatTxt.setBounds(160, 141, 120, 20);
	contentPane.add(postulanteApePatTxt);
	
	postulanteApeMatTxt = new JTextField();
	postulanteApeMatTxt.setColumns(10);
	postulanteApeMatTxt.setBounds(495, 141, 120, 20);
	contentPane.add(postulanteApeMatTxt);
	
	JDateChooser postulanteFnacTxt = new JDateChooser();
	postulanteFnacTxt.setBounds(495, 109, 120, 20);
	contentPane.add(postulanteFnacTxt);
	
	JComboBox postulanteEstadoTxt = new JComboBox();
	postulanteEstadoTxt.setName("");
	postulanteEstadoTxt.setBounds(495, 173, 120, 20);
	contentPane.add(postulanteEstadoTxt);
	
	JDateChooser postulanteFechPerTxt = new JDateChooser();
	postulanteFechPerTxt.setBounds(495, 227, 120, 20);
	contentPane.add(postulanteFechPerTxt);
	
	JComboBox postulanteCertPerTxt = new JComboBox();
	postulanteCertPerTxt.setBounds(230, 204, 50, 20);
	contentPane.add(postulanteCertPerTxt);
	
	JComboBox postulanteSepaTxt = new JComboBox();
	postulanteSepaTxt.setBounds(337, 238, 50, 20);
	contentPane.add(postulanteSepaTxt);
	
	JLabel lblseEncuentraSeparado = new JLabel("\u00BFSe encuentra separado de hecho y presenta  acreditaci\u00F3n ");
	lblseEncuentraSeparado.setVerticalAlignment(SwingConstants.TOP);
	lblseEncuentraSeparado.setHorizontalAlignment(SwingConstants.LEFT);
	lblseEncuentraSeparado.setBounds(21, 238, 306, 20);
	contentPane.add(lblseEncuentraSeparado);
	
	JLabel lbltieneCertificadoDe = new JLabel("\u00BFTiene certificado de permanencia?");
	lbltieneCertificadoDe.setVerticalAlignment(SwingConstants.TOP);
	lbltieneCertificadoDe.setHorizontalAlignment(SwingConstants.LEFT);
	lbltieneCertificadoDe.setBounds(21, 204, 231, 20);
	contentPane.add(lbltieneCertificadoDe);
	
	JComboBox postulanteInscripTxt = new JComboBox();
	postulanteInscripTxt.setModel(new DefaultComboBoxModel(new String[] {"Incompleto", "Completo"}));
	postulanteInscripTxt.setBounds(495, 78, 168, 20);
	contentPane.add(postulanteInscripTxt);
	
	JLabel lblNewLabel = new JLabel("C\u00E9dula de Identidad:");
	lblNewLabel.setBounds(19, 78, 131, 20);
	contentPane.add(lblNewLabel);
	
	JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
	lblApellidoPaterno.setBounds(21, 140, 102, 20);
	contentPane.add(lblApellidoPaterno);
	
	JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
	lblNombreCompleto.setBounds(21, 109, 140, 20);
	contentPane.add(lblNombreCompleto);
	
	JLabel lblNacionalidad = new JLabel("Nacionalidad:");
	lblNacionalidad.setBounds(21, 172, 102, 20);
	contentPane.add(lblNacionalidad);
	
	JLabel lblFe = new JLabel("Fecha de certificado de \r\npermanencia definitiva:");
	lblFe.setHorizontalTextPosition(SwingConstants.CENTER);
	lblFe.setHorizontalAlignment(SwingConstants.LEFT);
	lblFe.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	lblFe.setBounds(337, 204, 306, 23);
	contentPane.add(lblFe);
	
	JLabel lblNewLabel_4_1 = new JLabel("Estado Civ\u00EDl:");
	lblNewLabel_4_1.setBounds(337, 172, 102, 23);
	contentPane.add(lblNewLabel_4_1);
	
	JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
	lblApellidoMaterno.setBounds(337, 140, 102, 23);
	contentPane.add(lblApellidoMaterno);
	
	JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
	lblFechaNacimiento.setBounds(337, 108, 131, 23);
	contentPane.add(lblFechaNacimiento);
	
	JLabel lblNewLabel_1 = new JLabel("de inicio tr\u00E1mite de divorcio?");
	lblNewLabel_1.setBounds(21, 252, 219, 14);
	contentPane.add(lblNewLabel_1);
	cargarCombo();
}

public void cargarCombo() {
	PostulantesService postulanteService = new PostulantesService();
	List<Postulante> postulantes = postulanteService.obtenerTodos();
	postulantesCbx.removeAllItems();
	for(Postulante p: postulantes) {
		postulantesCbx.addItem(p);
	}
}

}
