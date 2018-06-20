package diego.Castillo.SecundariaJuarez.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import diego.Castillo.SecundariaJuarez.business.MaestrosBusiness;
import diego.Castillo.SecundariaJuarez.business.MateriasBusiness;
import diego.Castillo.SecundariaJuarez.model.Maestros;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarMaestrosView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtaPaterno;
	private JTextField txtaMaterno;
	JComboBox cbxMaterias = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarMaestrosView frame = new AgregarMaestrosView();
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
	public AgregarMaestrosView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(0, 11, 60, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(93, 8, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblerApellido = new JLabel("1ER APELLIDO");
		lblerApellido.setBounds(189, 11, 86, 14);
		contentPane.add(lblerApellido);
		
		txtaPaterno = new JTextField();
		txtaPaterno.setBounds(285, 8, 86, 20);
		contentPane.add(txtaPaterno);
		txtaPaterno.setColumns(10);
		
		JLabel lbldoApellido = new JLabel("2DO APELLIDO");
		lbldoApellido.setBounds(0, 45, 86, 14);
		contentPane.add(lbldoApellido);
		
		txtaMaterno = new JTextField();
		txtaMaterno.setBounds(93, 42, 86, 20);
		contentPane.add(txtaMaterno);
		txtaMaterno.setColumns(10);
		
		JLabel lblMateria = new JLabel("MATERIA");
		lblMateria.setBounds(189, 45, 67, 14);
		contentPane.add(lblMateria);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				agregarMaestros();
				
			}
		});
		btnGuardar.setBounds(43, 95, 107, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		btnCancelar.setBounds(223, 95, 107, 23);
		contentPane.add(btnCancelar);
		
		
		cbxMaterias.setBounds(285, 42, 125, 20);
		contentPane.add(cbxMaterias);
		
		llenarCBX();
		
	}
	
	private void agregarMaestros() {
		
		String nombre = txtNombre.getText();
		String aPaterno = txtaPaterno.getText();
		String aMaterno = txtaMaterno.getText();
		String [] idMateria = cbxMaterias.getSelectedItem().toString().split(":");
		int idMateria2 = Integer.parseInt(idMateria [0]);
		
		Maestros objMaestros = new Maestros(-1, nombre, aPaterno, aMaterno, idMateria2);
		
		MaestrosBusiness objMaestrosBusiness = new MaestrosBusiness(); 
		
		try {
			boolean exitoso = objMaestrosBusiness.agregarMaestro(objMaestros);
			
			if(exitoso) {
				JOptionPane.showMessageDialog(null, "Maestro agregado", "EXITOSO!!!", JOptionPane.INFORMATION_MESSAGE);		
			}else {
				JOptionPane.showMessageDialog(null, "Error al agregar maestro", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unused")
	private void llenarCBX() {
		
		MateriasBusiness obMateriasBusiness = new MateriasBusiness();
		
		ArrayList<String> listaMaterias;
		try {
			listaMaterias = obMateriasBusiness.llenarCBX();
			
			for (String string : listaMaterias) {
				
				cbxMaterias.addItem(string);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}











