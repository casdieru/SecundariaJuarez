package diego.Castillo.SecundariaJuarez.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import diego.Castillo.SecundariaJuarez.business.AlumnosBusiness;
import diego.Castillo.SecundariaJuarez.model.Alumnos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestorAlumnosView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtaPaterno;
	private JTextField txtaMaterno;
	private JTextField txtidMateria;
	private JTextField txtidMaestro;
	private JTable tlbAlumnos;
	private JTextField txtidAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorAlumnosView frame = new GestorAlumnosView();
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
	public GestorAlumnosView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 24, 67, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(84, 21, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblAPaterno = new JLabel("A PATERNO");
		lblAPaterno.setBounds(189, 24, 67, 14);
		contentPane.add(lblAPaterno);
		
		txtaPaterno = new JTextField();
		txtaPaterno.setBounds(268, 21, 86, 20);
		contentPane.add(txtaPaterno);
		txtaPaterno.setColumns(10);
		
		JLabel lblAMaterno = new JLabel("A MATERNO");
		lblAMaterno.setBounds(366, 24, 67, 14);
		contentPane.add(lblAMaterno);
		
		txtaMaterno = new JTextField();
		txtaMaterno.setBounds(451, 21, 86, 20);
		contentPane.add(txtaMaterno);
		txtaMaterno.setColumns(10);
		
		JLabel lblMateria = new JLabel("MATERIA");
		lblMateria.setBounds(10, 60, 67, 14);
		contentPane.add(lblMateria);
		
		txtidMateria = new JTextField();
		txtidMateria.setBounds(84, 57, 86, 20);
		contentPane.add(txtidMateria);
		txtidMateria.setColumns(10);
		
		JLabel lblMaestro = new JLabel("MAESTRO");
		lblMaestro.setBounds(189, 60, 67, 14);
		contentPane.add(lblMaestro);
		
		txtidMaestro = new JTextField();
		txtidMaestro.setBounds(268, 57, 86, 20);
		contentPane.add(txtidMaestro);
		txtidMaestro.setColumns(10);
		
		JButton btnNewButton = new JButton("LISTAR Y CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consultarAlumnos();
				
			}
		});
		btnNewButton.setBounds(366, 56, 171, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarAlumnosView frame = new AgregarAlumnosView();
				
				frame.setVisible(true);
				
			}
		});
		btnAgregar.setBounds(30, 95, 103, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				actualizarAlumno();
				
			}
		});
		btnModificar.setBounds(219, 95, 103, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminarAlumno();
				
			}
		});
		btnEliminar.setBounds(416, 95, 103, 23);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 539, 199);
		contentPane.add(scrollPane);
		
		tlbAlumnos = new JTable();
		tlbAlumnos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID ALUMNO", "NOMBRE", "A PATERNO", "A MATERNO", "ID MATERIA", "ID MAESTRO"
			}
		));
		scrollPane.setViewportView(tlbAlumnos);
		
		txtidAlumno = new JTextField();
		txtidAlumno.setBounds(373, 3, 33, 10);
		contentPane.add(txtidAlumno);
		txtidAlumno.setColumns(10);
		
		consultarAlumnos();
		
	}

	private void consultarAlumnos() {
		
		String idAlumno = txtidAlumno.getText();
		String nombre = txtNombre.getText();
		String aPaterno = txtaPaterno.getText();
		String aMaterno = txtaMaterno.getText();
		String idMateria = txtidMateria.getText();
		String idMaestro = txtidMaestro.getText();
		
		AlumnosBusiness objAlumnosBusiness = new AlumnosBusiness();
		
		DefaultTableModel modeloAlumnos = (DefaultTableModel) tlbAlumnos.getModel();
		
		modeloAlumnos.setRowCount(0);
		
		try {
			ArrayList<Alumnos> listaAlumnos = objAlumnosBusiness.mostrarAlumnos(idAlumno, nombre, aPaterno, aMaterno, idMateria, idMaestro);
			
			for (Alumnos alumnos : listaAlumnos) {
				
				String [] registroAlumnos = {
					
					String.valueOf(alumnos.getIdAlumno()),
					alumnos.getNombre(),
					alumnos.getaPaterno(),
					alumnos.getaMaterno(),
					String.valueOf(alumnos.getIdMateria()),
					String.valueOf(alumnos.getIdMaestro())
					
				};
				modeloAlumnos.addRow(registroAlumnos);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	private void actualizarAlumno() {
		
		int renglonSeleccionado = tlbAlumnos.getSelectedRow();
		
		if(renglonSeleccionado != -1) {
			
			Alumnos objAlumnos = new Alumnos();
			
			objAlumnos.setIdAlumno(Integer.parseInt((String) tlbAlumnos.getValueAt(renglonSeleccionado, 0)));
			objAlumnos.setNombre(tlbAlumnos.getValueAt(renglonSeleccionado, 1).toString());
			objAlumnos.setaPaterno(tlbAlumnos.getValueAt(renglonSeleccionado, 2).toString());
			objAlumnos.setaMaterno(tlbAlumnos.getValueAt(renglonSeleccionado, 3).toString());
			objAlumnos.setIdMateria(Integer.parseInt((String) tlbAlumnos.getValueAt(renglonSeleccionado, 4)));
			objAlumnos.setIdMaestro(Integer.parseInt((String) tlbAlumnos.getValueAt(renglonSeleccionado, 5)));
			
			AlumnosBusiness objAlumnosBusiness = new AlumnosBusiness();
			
			try {
				boolean exitoso = objAlumnosBusiness.actualizarAlumno(objAlumnos);
				
				if(exitoso) {
					String mensaje = "Alumno actualizado correctamente";
					JOptionPane.showMessageDialog(null, mensaje, "EXITOSO", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "Error al actualizar alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}else {
			
			String mess = "Primero selecciona un renglon";
			JOptionPane.showMessageDialog(null, mess, "CUIDADO", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	private void eliminarAlumno() {
		
		int renglonSeleccionado = tlbAlumnos.getSelectedRow();
		
		if(renglonSeleccionado != -1) {
			
			int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el Alumno?", "CUIDADO", JOptionPane.YES_NO_OPTION);
			
			if(opcionSeleccionada == JOptionPane.YES_OPTION) {
				
				int idAlumno;
				idAlumno = Integer.parseInt(tlbAlumnos.getValueAt(renglonSeleccionado, 0).toString());
				
				AlumnosBusiness objAlumnosBusiness = new AlumnosBusiness();
				
				try {
					boolean exitoso = objAlumnosBusiness.eliminarAlumno(idAlumno);
					
					if(exitoso) {
						String mensaje = "Alumno eliminado correctamente";
						JOptionPane.showMessageDialog(null, mensaje, "EXITOSO", JOptionPane.INFORMATION_MESSAGE);
						//consultarCursos();
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar Alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}else {
			
			String mess = "Primero selecciona un renglon";
			JOptionPane.showMessageDialog(null, mess, "CUIDADO", JOptionPane.ERROR_MESSAGE);
			
		}
	
	
	}

}










