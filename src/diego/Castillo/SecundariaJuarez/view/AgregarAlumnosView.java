package diego.Castillo.SecundariaJuarez.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import diego.Castillo.SecundariaJuarez.business.AlumnosBusiness;
import diego.Castillo.SecundariaJuarez.business.MaestrosBusiness;
import diego.Castillo.SecundariaJuarez.business.MateriasBusiness;
import diego.Castillo.SecundariaJuarez.model.Alumnos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarAlumnosView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtaPaterno;
	private JTextField txtaMaterno;
	JComboBox cbxMateria = new JComboBox();
	JComboBox cbxMaestro = new JComboBox();
	private JTextField txtidMaestro;
	private JTextField txtidMateria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarAlumnosView frame = new AgregarAlumnosView();
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
	public AgregarAlumnosView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 663, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 11, 61, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(85, 8, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblAPaterno = new JLabel("A PATERNO");
		lblAPaterno.setBounds(191, 11, 86, 14);
		contentPane.add(lblAPaterno);
		
		txtaPaterno = new JTextField();
		txtaPaterno.setBounds(297, 8, 86, 20);
		contentPane.add(txtaPaterno);
		txtaPaterno.setColumns(10);
		
		JLabel lblAMaterno = new JLabel("A MATERNO");
		lblAMaterno.setBounds(407, 11, 80, 14);
		contentPane.add(lblAMaterno);
		
		txtaMaterno = new JTextField();
		txtaMaterno.setBounds(521, 8, 86, 20);
		contentPane.add(txtaMaterno);
		txtaMaterno.setColumns(10);
		
		
		cbxMateria.setBounds(85, 49, 140, 20);
		contentPane.add(cbxMateria);
		
		JLabel lblMateria = new JLabel("MATERIA");
		lblMateria.setBounds(10, 52, 61, 14);
		contentPane.add(lblMateria);
		
		JLabel lblMaestro = new JLabel("MAESTRO");
		lblMaestro.setBounds(312, 52, 71, 14);
		contentPane.add(lblMaestro);
		
		
		cbxMaestro.setBounds(407, 49, 230, 20);
		contentPane.add(cbxMaestro);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				agregarAlumnos();
				
			}
		});
		btnGuardar.setBounds(120, 109, 105, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnCancelar.setBounds(327, 109, 105, 23);
		contentPane.add(btnCancelar);
		
		txtidMaestro = new JTextField();
		txtidMaestro.setBounds(483, 80, 86, 20);
		contentPane.add(txtidMaestro);
		txtidMaestro.setColumns(10);
		
		txtidMateria = new JTextField();
		txtidMateria.setBounds(139, 78, 86, 20);
		contentPane.add(txtidMateria);
		txtidMateria.setColumns(10);
		
		llenarCBX();
		
		llenarCBXMaestros();
		
	}
	
	private void agregarAlumnos() {
		
		String nombre = txtNombre.getText();
		String aPaterno = txtaPaterno.getText();
		String aMaterno = txtaMaterno.getText();
		String [] idMateria = cbxMateria.getSelectedItem().toString().split(":");
		int idMateria2 = Integer.parseInt(idMateria [0]);
		String [] idMaestro = cbxMaestro.getSelectedItem().toString().split(":");
		int idMaestro2 = Integer.parseInt(idMaestro [0]);
		//String idMateria = txtidMateria.getText();
		//String idMaestro = txtidMaestro.getText();
		
		Alumnos objAlumnos = new Alumnos(-1, nombre, aPaterno, aMaterno, idMateria2, idMaestro2);
		
		AlumnosBusiness objAlumnosBusiness = new AlumnosBusiness();
		
		try {
			boolean exitoso = objAlumnosBusiness.agregarAlumno(objAlumnos);
			
			if(exitoso) {
				JOptionPane.showMessageDialog(null, "Alumno agregado", "EXITOSO!!!", JOptionPane.INFORMATION_MESSAGE);		
			}else {
				JOptionPane.showMessageDialog(null, "Error al agregar alumno", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	private void llenarCBX() {
		
		MateriasBusiness objMateriasBusiness = new MateriasBusiness();
		
		ArrayList<String> listaMaterias;
		
		try {
			listaMaterias = objMateriasBusiness.llenarCBX();
			
			for (String string : listaMaterias) {
				
				cbxMateria.addItem(string);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unused")
	private void llenarCBXMaestros() {
		
		MaestrosBusiness objMaestrosBusiness = new MaestrosBusiness();
		
		ArrayList<String> listaMaestros;
		
		try {
			listaMaestros = objMaestrosBusiness.llenarCBXMaestros();
			
			for (String string : listaMaestros) {
				
				cbxMaestro.addItem(string);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}





