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

public class ActualizarPostulanteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField postulanteIdTxt;
	private JTextField postulanteRutTxt;
	private JTextField estadoIncritoTxt;
	private JTextField postulanteNombreTxt;
	private JComboBox<Postulante> postulantesCbx;

	public ActualizarPostulanteFrame() {setTitle("Actualizar Postulantes");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 703, 550);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	postulanteIdTxt = new JTextField();
	postulanteIdTxt.setEnabled(false);
	postulanteIdTxt.setColumns(10);
	postulanteIdTxt.setBounds(543, 28, 120, 20);
	contentPane.add(postulanteIdTxt);
	
	JLabel lblNewLabel_1 = new JLabel("Rut");
	lblNewLabel_1.setBounds(21, 83, 61, 16);
	contentPane.add(lblNewLabel_1);
	
	postulanteRutTxt = new JTextField();
	postulanteRutTxt.setColumns(10);
	postulanteRutTxt.setBounds(160, 81, 120, 20);
	contentPane.add(postulanteRutTxt);
	
	estadoIncritoTxt = new JTextField();
	estadoIncritoTxt.setBackground(Color.LIGHT_GRAY);
	estadoIncritoTxt.setColumns(10);
	estadoIncritoTxt.setBounds(495, 81, 168, 20);
	contentPane.add(estadoIncritoTxt);
	
	JLabel lblNewLabel_2 = new JLabel("Estado Inscrito");
	lblNewLabel_2.setBounds(10, 484, 117, 16);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Nombres");
	lblNewLabel_3.setBounds(21, 110, 117, 16);
	contentPane.add(lblNewLabel_3);
	
	postulanteNombreTxt = new JTextField();
	postulanteNombreTxt.setColumns(10);
	postulanteNombreTxt.setBounds(112, 112, 168, 20);
	contentPane.add(postulanteNombreTxt);
	
	
	//Actualizar
	JButton actualizarBtn = new JButton("Actualizar");
	actualizarBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//TODO: Validar
			Postulante postulante = new Postulante();
			postulante.setIdPostulante(Integer.parseInt(postulanteIdTxt.getText().trim()));
			postulante.setNumCedulaIdentidad(postulanteRutTxt.getText().trim());
			postulante.setEstadoInscrito(estadoIncritoTxt.getText().trim());
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
	actualizarBtn.setEnabled(false);
	actualizarBtn.setBounds(413, 449, 117, 29);
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
				estadoIncritoTxt.setText(postulante.getEstadoInscrito());
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
	lblEstadoInscripcin.setBounds(346, 78, 102, 27);
	contentPane.add(lblEstadoInscripcin);
	
	JLabel lblNewLabel_1_1_1 = new JLabel("ID Postulante");
	lblNewLabel_1_1_1.setBounds(446, 28, 87, 20);
	contentPane.add(lblNewLabel_1_1_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("");
	lblNewLabel_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
	lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
	lblNewLabel_1_1.setBounds(10, 11, 664, 50);
	contentPane.add(lblNewLabel_1_1);
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
