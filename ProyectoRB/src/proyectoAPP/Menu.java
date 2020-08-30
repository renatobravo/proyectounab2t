package proyectoAPP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import proyectoModel.entities.Postulante;
import proyectoModel.services.PostulantesService;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JDesktopPane;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTable tablaPostulantes;
	private JButton ingresarBtn;
	private JButton actualizarBtn;
	private JButton verBtn;
	private JButton eliminarBtn;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void cargarTabla() {
		PostulantesService service = new PostulantesService();
		List<Postulante> listPost = service.obtenerTodos();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Identificador");
		model.addColumn("Nombres");
		model.addColumn("Apellido Paterno");
		model.addColumn("Apellido Materno");
		model.addColumn("Fecha Nacimiento");
		model.addColumn("Nacionalidad");
		for(Postulante p: listPost) {
			Object[] fila = new Object[6];
			fila[0] = p.getIdPostulante();
			fila[1] = p.getNombres();
			fila[2] = p.getPrimerApellido();
			fila[3] = p.getSegundoApellido();
			fila[4] = p.getFechaNacimiento();
			fila[5] = p.getNacionalidad();
			model.addRow(fila);
		}
		tablaPostulantes.setModel(model);	
	}
	
	public Menu() {
		setTitle("Administraci\u00F3n de Recurso Humano");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 212, 682, 214);
		contentPane.add(scrollPane);
		
		tablaPostulantes = new JTable();
		scrollPane.setViewportView(tablaPostulantes);
		
		ingresarBtn = new JButton("Ingresar Postulante");
		ingresarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresarPostulanteFrame ingre = new IngresarPostulanteFrame();
				ingre.setVisible(true);
			}
		});
		ingresarBtn.setBounds(15, 40, 171, 29);
		contentPane.add(ingresarBtn);
		
		actualizarBtn = new JButton("Actualizar Postulante");
		actualizarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarPostulanteFrame actualizar = new ActualizarPostulanteFrame();
				actualizar.setVisible(true);
			}
		});
		actualizarBtn.setBounds(15, 72, 171, 29);
		contentPane.add(actualizarBtn);
		
		verBtn = new JButton("Mostrar Postulantes");
		verBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VerCargosFrame ver = new VerCargosFrame();
				//ver.setVisible(true);
			}
		});
		verBtn.setBounds(15, 139, 171, 29);
		contentPane.add(verBtn);
		
		eliminarBtn = new JButton("Eliminar Postulantes");
		eliminarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarPostulanteFrame eliminar = new EliminarPostulanteFrame();
				eliminar.setVisible(true);
			}
		});
		eliminarBtn.setBounds(15, 105, 171, 29);
		contentPane.add(eliminarBtn);
		
		lblNewLabel = new JLabel("Listado de Postulantes");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(153, 160, 461, 47);
		contentPane.add(lblNewLabel);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(78, 160, 1, 1);
		contentPane.add(desktopPane);
		
		/*lblCargos = new JLabel("Cargos");
		lblCargos.setFont(new Font("Arial", Font.BOLD, 18));
		lblCargos.setBounds(47, 0, 83, 47);
		contentPane.add(lblCargos);
		
		lblRegiones = new JLabel("Regiones");
		lblRegiones.setFont(new Font("Arial", Font.BOLD, 18));
		lblRegiones.setBounds(264, 0, 83, 47);
		contentPane.add(lblRegiones);*/
		cargarTabla();
	}
}
