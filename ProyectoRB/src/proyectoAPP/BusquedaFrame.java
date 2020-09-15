package proyectoAPP;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;


import proyectoModel.entities.Postulante;
import proyectoModel.services.PostulantesService;
import java.awt.Font;

public class BusquedaFrame extends JFrame {

	private JPanel contentPane;
	private JTable tablaPostulantes;

	/**
	 * Create the frame.
	 */
	public BusquedaFrame() {
		setResizable(false);
		setTitle("Buscar Por Fecha de Nacimiento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 847, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 171, 821, 402);
		contentPane.add(scrollPane);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNacimiento.setBounds(318, 49, 131, 23);
		contentPane.add(lblFechaNacimiento);

		JDateChooser postulanteFnacTxt = new JDateChooser();
		postulanteFnacTxt.setBounds(318, 83, 120, 23);
		contentPane.add(postulanteFnacTxt);
		
		tablaPostulantes = new JTable();
		scrollPane.setViewportView(tablaPostulantes);
		
		JButton buscarBtn = new JButton("Buscar");
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> errores = new ArrayList<String>();
				
				LocalDateTime fechaActual = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
				Date fechaTope = Date.from(fechaActual.atZone(ZoneId.systemDefault()).toInstant());

				if(postulanteFnacTxt.getDate() == null || postulanteFnacTxt.getDate().after(fechaTope)) {
					errores.add("Debe ingresar una Fecha de Nacimiento valida, recuerde que no puede estar en blanco ni mayor a la fecha de hoy");
				}
				if (errores.isEmpty()) {
					cargarTabla(postulanteFnacTxt.getDate());
				}
				else
				{
					 String mensaje = String.join("\n", errores);
					 JOptionPane.showMessageDialog(null, mensaje);

				}
				
			}
		});
		buscarBtn.setBounds(111, 135, 593, 23);
		contentPane.add(buscarBtn);
		
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Desplegar informaci\u00F3n de  postulantes por fecha de nacimiento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(111, 11, 593, 27);
		contentPane.add(lblNewLabel);
	}
	
	
	
	public void cargarTabla(Date d) {
		PostulantesService service = new PostulantesService();
		List<Postulante> listPost = service.obtenerPorFecha(d);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Identificador");
		model.addColumn("Nombres");
		model.addColumn("Apellido Paterno");
		model.addColumn("Apellido Materno");
		model.addColumn("Fecha Nacimiento");
		model.addColumn("RUT");
		for(Postulante p: listPost) {
			Object[] fila = new Object[6];
			fila[0] = p.getIdPostulante();
			fila[1] = p.getNombres();
			fila[2] = p.getPrimerApellido();
			fila[3] = p.getSegundoApellido();
			fila[4] = p.getFechaNacimiento();
			fila[5] = p.getNumCedulaIdentidad();
			model.addRow(fila);
		}
		tablaPostulantes.setModel(model);	
	}
}
