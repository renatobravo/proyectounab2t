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
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class IngresarPostulanteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField postulanteRunTxt;
	private JTextField postulanteApePaTxt;
	private JTextField postulanteNomTxt;
	private JTextField postulanteApMaTxt;
	private JTextField postulanteNacioTxt;

	public IngresarPostulanteFrame() {
		setTitle("Identificaci\u00F3n del Postulante");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00E9dula de Identidad");
		lblNewLabel.setBounds(23, 61, 102, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(472, 367, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(368, 367, 89, 23);
		contentPane.add(btnNewButton_1);
		
		postulanteRunTxt = new JTextField();
		postulanteRunTxt.setBounds(177, 62, 100, 20);
		contentPane.add(postulanteRunTxt);
		postulanteRunTxt.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(23, 95, 102, 23);
		contentPane.add(lblApellidoPaterno);
		
		postulanteApePaTxt = new JTextField();
		postulanteApePaTxt.setColumns(10);
		postulanteApePaTxt.setBounds(177, 96, 100, 20);
		contentPane.add(postulanteApePaTxt);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo");
		lblNombreCompleto.setBounds(23, 129, 102, 23);
		contentPane.add(lblNombreCompleto);
		
		postulanteNomTxt = new JTextField();
		postulanteNomTxt.setColumns(10);
		postulanteNomTxt.setBounds(137, 130, 140, 20);
		contentPane.add(postulanteNomTxt);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(316, 61, 102, 23);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(316, 95, 102, 23);
		contentPane.add(lblApellidoMaterno);
		
		postulanteApMaTxt = new JTextField();
		postulanteApMaTxt.setColumns(10);
		postulanteApMaTxt.setBounds(430, 96, 100, 20);
		contentPane.add(postulanteApMaTxt);
		
		JLabel lblNewLabel_4_1 = new JLabel("Estado Civ\u00EDl");
		lblNewLabel_4_1.setBounds(316, 133, 102, 23);
		contentPane.add(lblNewLabel_4_1);
		
		JComboBox postulanteEstadoTxt = new JComboBox();
		postulanteEstadoTxt.setModel(new DefaultComboBoxModel(new String[] {"", "Soltero", "Casado"}));
		postulanteEstadoTxt.setMaximumRowCount(2);
		postulanteEstadoTxt.setBounds(430, 130, 100, 20);
		contentPane.add(postulanteEstadoTxt);
		
		JDateChooser postulanteFnacTxt = new JDateChooser();
		postulanteFnacTxt.setBounds(428, 64, 102, 20);
		contentPane.add(postulanteFnacTxt);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(23, 198, 102, 23);
		contentPane.add(lblNacionalidad);
		
		postulanteNacioTxt = new JTextField();
		postulanteNacioTxt.setColumns(10);
		postulanteNacioTxt.setBounds(137, 199, 140, 20);
		contentPane.add(postulanteNacioTxt);
		
		JLabel lblseEncuentraSeparado = new JLabel("\u00BFSe encuentra separado de hecho y presenta acreditaci\u00F3n de inicio tr\u00E1mite de divorcio?");
		lblseEncuentraSeparado.setHorizontalAlignment(SwingConstants.LEFT);
		lblseEncuentraSeparado.setVerticalAlignment(SwingConstants.TOP);
		lblseEncuentraSeparado.setBounds(23, 167, 434, 20);
		contentPane.add(lblseEncuentraSeparado);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Si", "No"}));
		comboBox_1.setBounds(456, 164, 28, 20);
		contentPane.add(comboBox_1);
		
		JLabel lbltieneCertificadoDe = new JLabel("\u00BFTiene certificado de permanencia?");
		lbltieneCertificadoDe.setVerticalAlignment(SwingConstants.TOP);
		lbltieneCertificadoDe.setHorizontalAlignment(SwingConstants.LEFT);
		lbltieneCertificadoDe.setBounds(23, 232, 170, 20);
		contentPane.add(lbltieneCertificadoDe);
		
		JComboBox postulanteCertPerTxt = new JComboBox();
		postulanteCertPerTxt.setBounds(210, 230, 28, 20);
		contentPane.add(postulanteCertPerTxt);
		
		JLabel lblFe = new JLabel("Fecha de certificado de permanencia definitiva");
		lblFe.setBounds(278, 229, 140, 47);
		contentPane.add(lblFe);
		
		JDateChooser postulanteFechPerTxt = new JDateChooser();
		postulanteFechPerTxt.setBounds(428, 232, 102, 20);
		contentPane.add(postulanteFechPerTxt);
	}
}
