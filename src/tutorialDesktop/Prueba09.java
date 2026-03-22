//Clase JAVA Swing con un JTextField que reciba un entero y
//muestre en un JLABEL la suma del entero que el usuario a
//introducido más 5.  Validando antes que la entrada del usuario
//es un entero.
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
import javax.swing.border.EmptyBorder;
 
public class Prueba09 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(Prueba09::crearUI);
	}
 
	private static void crearUI() {
		JFrame frame = new JFrame("Ventana 09 - Suma, JLabel y Validacion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		JPanel root = new JPanel(new BorderLayout(10, 10));
		root.setBorder(new EmptyBorder(10, 10, 10, 10));
 
		JTextField campoNumero = new JTextField(18);
		JLabel suma = new JLabel(" + ");
		int numero2 = 5;
 
		JPanel arriba = new JPanel(new FlowLayout(FlowLayout.CENTER));
		arriba.add(campoNumero);
 
		JButton btnSumar = new JButton("Sumar");
 
		JPanel abajo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		abajo.add(btnSumar);
 
		// Acciones del boton
		btnSumar.addActionListener(e -> {
			try {
				int numero = Integer.parseInt(campoNumero.getText());
				suma.setText(" = " + (numero + numero2));
 
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Introduzca un número entero", null, JOptionPane.ERROR_MESSAGE);
			}
		});
 
		JPanel centro = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		centro.add(suma);
 
		root.add(arriba, BorderLayout.NORTH);
		root.add(abajo, BorderLayout.SOUTH);
		root.add(centro);
 
		frame.setContentPane(root);
 
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
 
}
 