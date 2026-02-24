package tutorialDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Prueba04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(Prueba04::crearUI);
	}

	public static void crearUI() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("Mi Cuarta Ventana Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Formulario en panel superior
		JPanel formulario = new JPanel(new FlowLayout(FlowLayout.LEFT));
		formulario.add(new JLabel("Nombre:"));
		JTextField txtNombre = new JTextField(15);
		formulario.add(txtNombre);

		JButton btnSaludar = new JButton("Saludar");
		JButton btnLimpiar = new JButton("Limpiar");

		// Botones en panel inferior
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBotones.add(btnSaludar);
		panelBotones.add(btnLimpiar);

		// Area Central
		JTextArea areaTexto = new JTextArea(10, 30);
		areaTexto.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(areaTexto);

		// Layout/Disposicion Principal del Frame
		frame.setLayout(new BorderLayout(10, 10));
		frame.add(formulario, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(panelBotones, BorderLayout.SOUTH);

		// EVENTOS
		btnSaludar.addActionListener(e -> {
			String nombre = txtNombre.getText();
			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Introduzca un nombre", "AVISO", JOptionPane.WARNING_MESSAGE);
				return;
			}
			areaTexto.append("Hola " + nombre + ", gracias por usar nuestra Cuarta DesktopAPP\n");
			txtNombre.requestFocusInWindow();
		});

		btnLimpiar.addActionListener(e -> {
			txtNombre.setText("");
			areaTexto.setText("");
			txtNombre.requestFocusInWindow();
		});

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
