package tutorialDesktop;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Prueba02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("My First Desktop App");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Podriais pensar que las tablas se usan tal que así, pero no es así, ya que el JTable no tiene un 
//	 	layout manager, por lo que no se pueden añadir componentes al JTable, sino
// 		que se deben añadir al JScrollPane que contiene al JTable.
		// JTable tabla = new JTable();
		// frame.add(tabla);
		// tabla.add(new JLabel("Tabla etiqueta 1"));

// 		Esto es para crear un modelo de tabla, que es el encargado de gestionar los datos de la tabla. 
//		El modelo de tabla se crea a partir de una matriz de objetos, donde cada fila es un array de objetos 
//		que representa una fila de la tabla, y cada columna es un array de objetos que representa una columna de la tabla. 
//		En este caso, se crea un modelo de tabla con dos columnas, "Columna 1" y "Columna 2", y sin filas.
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "Columna 1", "Columna 2" }, 0);

		JTable tabla = new JTable(modelo);
		frame.add(new JScrollPane(tabla));

		// -. Añadir una fila:
		modelo.addRow(new Object[] { "Entrada 1", "Entrada 2" });
		// -. Probad a quitar el BorderLayout.NORTH y veréis que el JLabel se añade al
		// centro del frame,
		// -. ocupando todo el espacio disponible, y el botón se añade al sur del frame,
		// ocupando todo el ancho del frame.
		frame.getContentPane().add(new JLabel("Mi etiqueta JLabel"), BorderLayout.NORTH);

		JButton button = new JButton("Saludar");
		button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Hola Mundo"));
		frame.add(button, BorderLayout.SOUTH);

		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}

}
