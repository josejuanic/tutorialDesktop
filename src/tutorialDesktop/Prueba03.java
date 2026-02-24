package tutorialDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Prueba03 extends JFrame {

	public Prueba03() {
		// TODO Auto-generated constructor stub
		setTitle("Mi tercera ventana Swing");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panelArriba = new JPanel(); // FlowLayout por defecto
		panelArriba.add(new JLabel("Nombre:"));
		JTextField txtNombre = new JTextField(15);
		panelArriba.add(txtNombre);

		JButton button = new JButton("Saludar");
		button.addActionListener(e -> {
			String nombre = txtNombre.getText();
			JOptionPane.showMessageDialog(this, "Hola " + nombre + ", gracias por \n usar nuestra Tercera DesktopAPP");
		});
		setLayout(new FlowLayout());
		add(panelArriba, BorderLayout.NORTH);
		add(button, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			Prueba03 ventana = new Prueba03();
			ventana.setVisible(true);
		});
	}
}