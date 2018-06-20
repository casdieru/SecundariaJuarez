package diego.Castillo.SecundariaJuarez.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView();
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
	public PrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMaestros = new JButton("MAESTROS");
		btnMaestros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GestorMaestrosView frame = new GestorMaestrosView();
				frame.setVisible(true);
				
			}
		});
		btnMaestros.setBounds(10, 11, 114, 101);
		contentPane.add(btnMaestros);
		
		JButton btnMaterias = new JButton("MATERIAS");
		btnMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestorMateriasView frame = new GestorMateriasView();
				frame.setVisible(true);
				
			}
		});
		btnMaterias.setBounds(158, 11, 114, 101);
		contentPane.add(btnMaterias);
		
		JButton btnAlumnos = new JButton("ALUMNOS");
		btnAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestorAlumnosView frame = new GestorAlumnosView();
				frame.setVisible(true);
				
			}
		});
		btnAlumnos.setBounds(298, 11, 109, 101);
		contentPane.add(btnAlumnos);
	}
}
