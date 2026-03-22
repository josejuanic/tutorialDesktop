// ********************************************************************************************************************
// Test01

package tutorialDesktop;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class Test01 extends JFrame {

	public Test01() {
		setTitle("Test01 - Ejemplo ToolBar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);

		JToolBar toolBar = new JToolBar("Herramientas");

		JButton btnNuevo = new JButton();
		btnNuevo.setText("Nuevo");

		JButton btnGuardar = new JButton("Guardar");

		btnNuevo.addActionListener(e -> miLog("Nuevo Archivo"));
		btnGuardar.addActionListener(e -> miLog("Archivo Guardado"));

		toolBar.add(btnNuevo);
		toolBar.addSeparator();
		toolBar.add(btnGuardar);

		toolBar.addSeparator();
		toolBar.add(new JLabel(" Zoom: "));

		JComboBox<String> zoom = new JComboBox<>(new String[] { "50%", "75%", "100%", "125%", "150%" });
		zoom.setSelectedItem(2);
		zoom.setMaximumSize(zoom.getPreferredSize());

		toolBar.add(zoom);

		// toolBAr por defecto es flotante.
		// toolBar.setFloatable(false); // descomentar eesto si queremos que no sea
		// flotable.

		JTextArea area = new JTextArea("Arrastre la barra de tareas o use los botones.\n");
		area.setMargin(new Insets(10, 10, 10, 10));

		setLayout(new BorderLayout());

		add(toolBar, BorderLayout.NORTH);
		add(new JScrollPane(area), BorderLayout.CENTER);

		this.txtArea = area;
	}

	private JTextArea txtArea;

	private void miLog(String mensaje) {
		txtArea.append("-> " + mensaje + "\n");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Test01().setVisible(true));
	}

}
