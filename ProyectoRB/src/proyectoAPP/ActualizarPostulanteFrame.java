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

public class ActualizarPostulanteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField postulanteIdTxt;
	private JTextField postulanteRutTxt;
	private JTextField estadoIncritoTxt;
	private JTextField postulanteNombreTxt;
	private JComboBox<Postulante> postulantesCbx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarPostulanteFrame frame = new ActualizarPostulanteFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ActualizarPostulanteFrame() {setTitle("Actualizar Postulantes");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 567, 431);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	postulanteIdTxt = new JTextField();
	postulanteIdTxt.setEnabled(false);
	postulanteIdTxt.setColumns(10);
	postulanteIdTxt.setBounds(217, 148, 117, 31);
	contentPane.add(postulanteIdTxt);
	
	JLabel lblNewLabel = new JLabel("Identificador");
	lblNewLabel.setBounds(113, 155, 89, 16);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Rut");
	lblNewLabel_1.setBounds(134, 202, 61, 16);
	contentPane.add(lblNewLabel_1);
	
	postulanteRutTxt = new JTextField();
	postulanteRutTxt.setColumns(10);
	postulanteRutTxt.setBounds(215, 195, 189, 31);
	contentPane.add(postulanteRutTxt);
	
	estadoIncritoTxt = new JTextField();
	estadoIncritoTxt.setColumns(10);
	estadoIncritoTxt.setBounds(212, 285, 189, 31);
	contentPane.add(estadoIncritoTxt);
	
	JLabel lblNewLabel_2 = new JLabel("Estado Inscrito");
	lblNewLabel_2.setBounds(82, 292, 117, 16);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Nombres");
	lblNewLabel_3.setBounds(82, 249, 117, 16);
	contentPane.add(lblNewLabel_3);
	
	postulanteNombreTxt = new JTextField();
	postulanteNombreTxt.setColumns(10);
	postulanteNombreTxt.setBounds(212, 242, 189, 31);
	contentPane.add(postulanteNombreTxt);
	
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
				//Esta es una solucion m�s fina
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
	actualizarBtn.setBounds(413, 330, 117, 29);
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
	postulantesCbx.setBounds(215, 35, 189, 27);
	contentPane.add(postulantesCbx);
	
	JLabel lblNewLabel_4 = new JLabel("Seleccione un postulante:");
	lblNewLabel_4.setBounds(34, 35, 168, 20);
	contentPane.add(lblNewLabel_4);
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