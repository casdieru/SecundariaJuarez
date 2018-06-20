package diego.Castillo.SecundariaJuarez.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import diego.Castillo.SecundariaJuarez.business.MateriasBusiness;
import diego.Castillo.SecundariaJuarez.model.Materias;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GestorMateriasView extends JFrame {

	private JPanel contentPane;
	private JTable tlbMaterias;
	private JTextField txtidMateria;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorMateriasView frame = new GestorMateriasView();
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
	public GestorMateriasView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 414, 169);
		contentPane.add(scrollPane);
		
		tlbMaterias = new JTable();
		tlbMaterias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID MATERIA", "NOMBRE"
			}
		));
		scrollPane.setViewportView(tlbMaterias);
		
		JButton btnActualizar = new JButton("CAMBIAR NOMBRE");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizarMateria();
				
			}
		});
		btnActualizar.setBounds(148, 47, 162, 23);
		contentPane.add(btnActualizar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarMateriasView frame = new AgregarMateriasView();
				
				frame.setVisible(true);
				
			}
		});
		btnAgregar.setBounds(10, 47, 120, 23);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminarMateria();
				
			}
		});
		btnEliminar.setBounds(320, 47, 104, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		contentPane.add(lblId);
		
		txtidMateria = new JTextField();
		txtidMateria.setBounds(39, 8, 46, 20);
		contentPane.add(txtidMateria);
		txtidMateria.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(95, 11, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(145, 8, 67, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnActualizarTabla = new JButton("Actualizar Tabla");
		btnActualizarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consultarMaterias();
				
			}
		});
		btnActualizarTabla.setBounds(222, 6, 202, 25);
		contentPane.add(btnActualizarTabla);
		
		consultarMaterias();
		
	}
	
	private void consultarMaterias() {
		
	String idMateria = txtidMateria.getText();
	String nombre = txtNombre.getText();
	
	MateriasBusiness objMateriasBusiness = new MateriasBusiness();
	
	DefaultTableModel modeloMaterias = (DefaultTableModel) tlbMaterias.getModel();
	
	modeloMaterias.setRowCount(0);
	
	try {
		ArrayList<Materias> listaMaterias = objMateriasBusiness.mostrarMaterias(idMateria, nombre);
		
		for (Materias materias : listaMaterias) {
			
			String [] registroMaterias = {
					
				String.valueOf(materias.getIdMateria()),
				materias.getNombre()
					
			};
			
			modeloMaterias.addRow(registroMaterias);
			
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	private void actualizarMateria() {
		
		int renglonSeleccionado = tlbMaterias.getSelectedRow();
		
		if(renglonSeleccionado != -1) {
			
			int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Quieres cambiar el nombre de la materia?", "CUIDADO", JOptionPane.YES_NO_OPTION);
			
			if(opcionSeleccionada == JOptionPane.YES_OPTION) {
				
				Materias objMaterias = new Materias();
				
				objMaterias.setIdMateria(Integer.parseInt(tlbMaterias.getValueAt(renglonSeleccionado, 0).toString()));
				objMaterias.setNombre(tlbMaterias.getValueAt(renglonSeleccionado, 1).toString());
				
				MateriasBusiness objMateriasBusiness = new MateriasBusiness();
				
				try {
					boolean exitoso = objMateriasBusiness.actualizarMateria(objMaterias);
					
					if(exitoso) {
						String mensaje = "Nombre de materia cambiado correctamente";
						JOptionPane.showMessageDialog(null, mensaje, "EXITOSO", JOptionPane.INFORMATION_MESSAGE);
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al actualizar materia", "ERROR", JOptionPane.ERROR_MESSAGE);
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
	
	private void eliminarMateria() {
		
		int renglonSeleccionado = tlbMaterias.getSelectedRow();
		
		if(renglonSeleccionado != -1) {
			
			int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar la materia?", "CUIDADO", JOptionPane.YES_NO_OPTION);
			
			if(opcionSeleccionada == JOptionPane.YES_OPTION) {
				
				int idMateria;
				idMateria = Integer.parseInt(tlbMaterias.getValueAt(renglonSeleccionado, 0).toString());
				
				MateriasBusiness objMateriasBusiness = new MateriasBusiness();
				
				try {
					boolean exitoso = objMateriasBusiness.eliminarMateria(idMateria);
					
					if(exitoso) {
						String mensaje = "Materia eliminada correctamente";
						JOptionPane.showMessageDialog(null, mensaje, "EXITOSO", JOptionPane.INFORMATION_MESSAGE);
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar materia", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}else {
			String mess = "Primero selecciona un renglon";
			JOptionPane.showMessageDialog(null, mess, "CUIDADO", JOptionPane.ERROR_MESSAGE);	
		}
		
	}
	
	
}
