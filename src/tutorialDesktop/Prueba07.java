package tutorialDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

// COSAS QUE PODRIA MEJORAR O AÑADIR:
// - Poder guardar las notas en un archivo y cargarlas al iniciar la aplicación.
// - Poder marcar las tareas como completadas sin borrarlas de la lista.
// - Poder guardar las tareas y tener persistencia de datos.
// NOTA: ES UNA ASIGNATURA DE FRONTEND, NO DE BACKEND, ASI QUE NO ME VOY A COMPLICAR 
// 			CON BASES DE DATOS O ARCHIVOS, PERO SI QUEREIS HACERLO COMO EJERCICIO EXTRA AHI LO TENÉIS.

public class Prueba07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(Prueba07::crearUI);
	}

	private static void crearUI() {
		JFrame frame = new JFrame("Ventana 07 - Menú + Tabs");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menú
		JMenuBar mb = new JMenuBar();
		JMenu mArchivo = new JMenu("Archivo");
		JMenuItem miSalir = new JMenuItem("Salir");
		miSalir.addActionListener(e -> frame.dispose());
		mArchivo.add(miSalir);

		JMenu mAyuda = new JMenu("Ayuda");
		JMenuItem miAcerca = new JMenuItem("Acerca de...");
		miAcerca.addActionListener(e -> JOptionPane.showMessageDialog(frame,
				"Esto es la sección en la que le contamos nuestra vida al cliente \n"
						+ "Y llegamos a enseñarle cosas potencialmente inútiles pero que nos \n"
						+ "hacen sentir bien con nosotros mismos o al menos un poco menos \n"
						+ "culpables por haberle cobrado por esta aplicación"));
		mAyuda.add(miAcerca);

		mb.add(mArchivo);
		mb.add(mAyuda);
		frame.setJMenuBar(mb);

		// Tabs
		JTabbedPane tabs = new JTabbedPane();

		// Tab 1: Notas
		JTextArea notas = new JTextArea(12, 40);
		JPanel tabNotas = new JPanel(new BorderLayout());
		tabNotas.setBorder(new EmptyBorder(10, 10, 10, 10));
		tabNotas.add(new JScrollPane(notas), BorderLayout.CENTER);

		// Tab 2: Lista de tareas
		DefaultListModel<String> model = new DefaultListModel<>();
		model.addElement("Comprar pan");
		model.addElement("Estudiar Swing");

		JList<String> lista = new JList<>(model);
		JTextField txtNueva = new JTextField(20);
		JButton btnAdd = new JButton("Añadir");
		JButton btnDel = new JButton("Borrar seleccionada");

		btnAdd.addActionListener(e -> {
			String t = txtNueva.getText().trim();
			if (!t.isEmpty()) {
				model.addElement(t);
				txtNueva.setText("");
				txtNueva.requestFocusInWindow();
			}
		});

		btnDel.addActionListener(e -> {
			int idx = lista.getSelectedIndex();
			if (idx >= 0)
				model.remove(idx);
		});

		JPanel arriba = new JPanel(new FlowLayout(FlowLayout.LEFT));
		arriba.add(new JLabel("Nueva:"));
		arriba.add(txtNueva);
		arriba.add(btnAdd);

		JPanel abajo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		abajo.add(btnDel);

		JPanel tabLista = new JPanel(new BorderLayout(10, 10));
		tabLista.setBorder(new EmptyBorder(10, 10, 10, 10));
		tabLista.add(arriba, BorderLayout.NORTH);
		tabLista.add(new JScrollPane(lista), BorderLayout.CENTER);
		tabLista.add(abajo, BorderLayout.SOUTH);

		tabs.addTab("Notas", tabNotas);
		tabs.addTab("Tareas", tabLista);

		frame.setContentPane(tabs);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}


