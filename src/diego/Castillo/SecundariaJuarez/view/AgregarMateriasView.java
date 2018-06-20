package diego.Castillo.SecundariaJuarez.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import diego.Castillo.SecundariaJuarez.business.MateriasBusiness;
import diego.Castillo.SecundariaJuarez.model.Materias;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AgregarMateriasView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarMateriasView frame = new AgregarMateriasView();
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
	public AgregarMateriasView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 268, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Materia");
		lblNombreDeLa.setBounds(65, 24, 139, 14);
		contentPane.add(lblNombreDeLa);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(37, 49, 167, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				agregarMaterias();
				
			}
		});
		btnGuardar.setBounds(10, 94, 103, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		btnCancelar.setBounds(129, 94, 102, 23);
		contentPane.add(btnCancelar);
	}
	
	private void agregarMaterias() {
		
		String nombre = txtNombre.getText();
		
		Materias objMaterias = new Materias(-1, nombre);
		
		MateriasBusiness objMateriasBusiness = new MateriasBusiness();
			
		try {
			boolean exitoso = objMateriasBusiness.agregarMateria(objMaterias);
			
			if(exitoso) {
				
				JOptionPane.showMessageDialog(null, "Materia agregada", "EXITOSO", JOptionPane.INFORMATION_MESSAGE);
				
			}else {
				
				JOptionPane.showMessageDialog(null, "Error al agregar materia", "ERROR", JOptionPane.ERROR_MESSAGE);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
}
