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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import diego.Castillo.SecundariaJuarez.business.MaestrosBusiness;
import diego.Castillo.SecundariaJuarez.model.Maestros;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestorMaestrosView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtaMaterno;
	private JTextField txtaPaterno;
	private JComboBox cbxMaterias;
	private JLabel lblId;
	private JTextField txtidMaestro;
	private JTextField txtidMateria;
	private JTable tlbMaestros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorMaestrosView frame = new GestorMaestrosView();
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
	public GestorMaestrosView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 11, 75, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(111, 8, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lbldoApellido = new JLabel("2DO APELLIDO");
		lbldoApellido.setBounds(10, 41, 92, 14);
		contentPane.add(lbldoApellido);
		
		txtaMaterno = new JTextField();
		txtaMaterno.setBounds(111, 39, 86, 20);
		contentPane.add(txtaMaterno);
		txtaMaterno.setColumns(10);
		
		JLabel lblerApellido = new JLabel("1ER APELLIDO");
		lblerApellido.setBounds(207, 11, 86, 14);
		contentPane.add(lblerApellido);
		
		txtaPaterno = new JTextField();
		txtaPaterno.setBounds(326, 8, 86, 20);
		contentPane.add(txtaPaterno);
		txtaPaterno.setColumns(10);
		
		JLabel lblMateria = new JLabel("MATERIA");
		lblMateria.setBounds(207, 41, 60, 14);
		contentPane.add(lblMateria);
		
		cbxMaterias = new JComboBox();
		cbxMaterias.setBounds(298, 38, 114, 20);
		contentPane.add(cbxMaterias);
		
		lblId = new JLabel("ID ");
		lblId.setBounds(10, 66, 46, 14);
		contentPane.add(lblId);
		
		txtidMaestro = new JTextField();
		txtidMaestro.setBounds(111, 70, 86, 20);
		contentPane.add(txtidMaestro);
		txtidMaestro.setColumns(10);
		
		txtidMateria = new JTextField();
		txtidMateria.setBounds(326, 69, 86, 20);
		contentPane.add(txtidMateria);
		txtidMateria.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 414, 283);
		contentPane.add(scrollPane);
		
		tlbMaestros = new JTable();
		tlbMaestros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOMBRE", "A PATERNO", "A MATERNO", "MATERIA"
			}
		));
		scrollPane.setViewportView(tlbMaestros);
		
		JButton btnListarYConsultar = new JButton("LISTAR Y CONSULTAR");
		btnListarYConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				consultarMaestros();
				
			}
		});
		btnListarYConsultar.setBounds(13, 100, 243, 14);
		contentPane.add(btnListarYConsultar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarMaestrosView frame = new AgregarMaestrosView();
				
				frame.setVisible(true);
				
			}
		});
		btnAgregar.setBounds(13, 125, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				actualizarMaestro();
				
			}
		});
		btnModificar.setBounds(122, 125, 100, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminarMaestro();
				
			}
		});
		btnEliminar.setBounds(252, 125, 89, 23);
		contentPane.add(btnEliminar);
		
		consultarMaestros();
		
	}
	
	private void consultarMaestros() {
		
		String idMaestro = txtidMaestro.getText();
		String nombre = txtNombre.getText();
		String aPaterno = txtaPaterno.getText();
		String aMaterno = txtaMaterno.getText();
		//String [] idMateria = cbxMaterias.getSelectedItem().toString().split(":");
		//int idMateria2 = Integer.parseInt(idMateria [0]);
		String idMateria = txtidMateria.getText();
		
		MaestrosBusiness objMaestrosBusiness = new MaestrosBusiness();
		
		DefaultTableModel modeloMaestros = (DefaultTableModel) tlbMaestros.getModel();
		
		modeloMaestros.setRowCount(0);
		
		ArrayList<Maestros> listaMaestros;
		try {
			listaMaestros = objMaestrosBusiness.mostrarMaestros(idMaestro, nombre, aPaterno, aMaterno, idMateria);
			
			for (Maestros maestros : listaMaestros) {
				
				String [] registroMaestros = {
					
					String.valueOf(maestros.getIdMaestro()),
					maestros.getNombre(),
					maestros.getaPaterno(),
					maestros.getaMaterno(),
					String.valueOf(maestros.getIdMateria())
					
				};
				modeloMaestros.addRow(registroMaestros);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void actualizarMaestro() {
		
		int renglonSeleccionado = tlbMaestros.getSelectedRow();
		
		if(renglonSeleccionado != -1) {
			
			int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Quieres actualizar el maestro?", "CUIDADO", JOptionPane.YES_NO_OPTION);
			
			if(opcionSeleccionada == JOptionPane.YES_OPTION) {
				
				Maestros objMaestros = new Maestros();
				
				objMaestros.setIdMaestro(Integer.parseInt(tlbMaestros.getValueAt(renglonSeleccionado, 0).toString()));
				objMaestros.setNombre(tlbMaestros.getValueAt(renglonSeleccionado, 1).toString());
				objMaestros.setaPaterno(tlbMaestros.getValueAt(renglonSeleccionado, 2).toString());
				objMaestros.setaMaterno(tlbMaestros.getValueAt(renglonSeleccionado, 3).toString());
				objMaestros.setIdMateria(Integer.parseInt(tlbMaestros.getValueAt(renglonSeleccionado, 4).toString()));
				
				MaestrosBusiness objMaestrosBusiness = new MaestrosBusiness();
				
				try {
					boolean exitoso = objMaestrosBusiness.actualizarMaestro(objMaestros);
					
					if(exitoso) {
						String mensaje = "Maestro actualizado correctamente";
						JOptionPane.showMessageDialog(null, mensaje, "EXITOSO", JOptionPane.INFORMATION_MESSAGE);
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al actualizar maestro", "ERROR", JOptionPane.ERROR_MESSAGE);
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
	
	private void eliminarMaestro() {
		
		int renglonSeleccionado = tlbMaestros.getSelectedRow();
		
		if(renglonSeleccionado != -1) {
			
			int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el maestro?", "CUIDADO", JOptionPane.YES_NO_OPTION);
			
			if(opcionSeleccionada == JOptionPane.YES_OPTION) {
				
				int idMaestro;
				idMaestro = Integer.parseInt(tlbMaestros.getValueAt(renglonSeleccionado, 0).toString());
				
				MaestrosBusiness objMaestrosBusiness = new MaestrosBusiness();
				
				try {
					boolean exitoso = objMaestrosBusiness.eliminarMaestro(idMaestro);
					
					if(exitoso) {
						String mensaje = "Maestro eliminado correctamente";
						JOptionPane.showMessageDialog(null, mensaje, "EXITOSO", JOptionPane.INFORMATION_MESSAGE);
						//consultarCursos();
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar maestro", "ERROR", JOptionPane.ERROR_MESSAGE);
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










