
package tutorialDesktop;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Prueba01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 		1. Crear un frame
		JFrame frame = new JFrame("My First Desktop App");

// -.2. Que pasa cuando se cierra el frame. HAY VARIAS OPCIONES
		// -.DO_NOTHING_ON_CLOSE: No hace nada, el frame no se cierra
		// -.HIDE_ON_CLOSE: Oculta el frame, pero no lo destruye. El frame sigue
		// existiendo en memoria, pero no se muestra en pantalla
		// -.DISPOSE_ON_CLOSE: Destruye el frame, liberando los recursos que utiliza. El
		// frame deja de existir en memoria, pero la aplicación sigue ejecutándose
		// -.EXIT_ON_CLOSE: Destruye el frame y termina la aplicación. El frame deja de
		// existir en memoria y la aplicación termina su ejecución
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// -.Esto es para ver el layout que tiene el frame por defecto, que es
		// BorderLayout.
		// -.El layout es el encargado de organizar los componentes dentro del frame
		System.out.println(frame.getLayout());

		// -.3. Añadir componentes al frame

		// -. Esto es para añadir una etiqqueta de texto (JLabel) al contenedor
		// principal de la ventana (frame).
		// -. Si el ContentPane del frame tiene un layout manager, el JLabel se añadirá
		// según las reglas de ese layout.
		// -. por defecto suele se el BordeLayout, por lo que el JLabel se añadirá al
		// centro del frame.
		frame.getContentPane().add(new JLabel("Mi etiqueta Simple"));
		// -. Si queremos darle una posicion especifica.
		// frame.getContentPane().add(new JLabel("Mi etiqueta"), BorderLayout.SOUTH);

		JPanel panelArriba = new JPanel();
		panelArriba.add(new JLabel("Inroduzca su Nombre:"));
		JTextField tuNombre = new JTextField(20);
		panelArriba.add(tuNombre);

		JButton btnSaludar = new JButton("Saludar");
		btnSaludar.addActionListener(e -> {
			String nombre = tuNombre.getText();
			JOptionPane.showMessageDialog(frame, "Hola, " + nombre + ", gracias por usar nuestra DesktopAPP");
		});

		frame.add(panelArriba, BorderLayout.NORTH);
		frame.add(btnSaludar, BorderLayout.SOUTH);

		// -.4. Tamaño del frame y posicionarlo en el centro de la pantalla

		// -.Metodo que ajusta el tamaño del frame al contenido que tiene, pero como el
		// layout es null, no se ajusta
		// frame.pack();

		// -.Alternativamente, se puede establecer un tamaño fijo para el frame
		frame.setSize(400, 300);
		// -.Posicionar el frame en la pantalla
		frame.setLocationRelativeTo(null);

		// -.Establecer el tamaño del frame y posicionarlo en el centro de la pantalla
		// -.x, y, ancho, alto. Siendo x e y la posición del frame en la pantalla, y
		// ancho y alto el tamaño del frame
		// frame.setBounds(100, 100, 400, 300);

		// -.5. Mostrar el frame
		frame.setVisible(true);

		// -. Antiguamente se usaba el metodo show, pero esta deprecated.
		// frame.show();
	}

}
