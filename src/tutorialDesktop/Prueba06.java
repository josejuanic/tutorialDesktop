package tutorialDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Prueba06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(Prueba06::crearUI);
	}

	private static void crearUI() {
		JFrame frame = new JFrame("Ventana 06 - Validación y Atajos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel root = new JPanel(new BorderLayout(10, 10));
		root.setBorder(new EmptyBorder(10, 10, 10, 10));

		JTextField txtNombre = new JTextField(18);
		JCheckBox chkAcepto = new JCheckBox("Acepto condiciones");

		JTextArea area = new JTextArea(10, 40);
		area.setEditable(false);

		JButton btnAgregar = new JButton("Agregar");
		JButton btnLimpiar = new JButton("Limpiar");

		JPanel formulario = new JPanel(new FlowLayout(FlowLayout.LEFT));
		formulario.add(new JLabel("Nombre:"));
		formulario.add(txtNombre);
		formulario.add(chkAcepto);

		JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botones.add(btnLimpiar);
		botones.add(btnAgregar);

		root.add(formulario, BorderLayout.NORTH);
		root.add(new JScrollPane(area), BorderLayout.CENTER);
		root.add(botones, BorderLayout.SOUTH);
		frame.setContentPane(root);

		// --- Validación ---
		Runnable validar = () -> {
			boolean okNombre = !txtNombre.getText().trim().isEmpty();
			boolean okAcepto = chkAcepto.isSelected();
			btnAgregar.setEnabled(okNombre && okAcepto);
		};

		txtNombre.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				validar.run();
			}

			public void removeUpdate(DocumentEvent e) {
				validar.run();
			}

			public void changedUpdate(DocumentEvent e) {
				validar.run();
			}
		});
		chkAcepto.addActionListener(e -> validar.run());
		validar.run();
		// --- Acciones ---
		btnAgregar.addActionListener(e -> {
			area.append("Hola, " + txtNombre.getText().trim() + "!\n");
		});

		btnLimpiar.addActionListener(e -> {
			txtNombre.setText("");
			chkAcepto.setSelected(false);
			area.setText("");
			txtNombre.requestFocusInWindow();
			validar.run();
		});

		// --- Atajos ---
		JRootPane rp = frame.getRootPane();
		rp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control L"), "limpiar");
		rp.getActionMap().put("limpiar", new AbstractAction() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				btnLimpiar.doClick();
			}
		});

		// Enter en el campo = agregar
		txtNombre.addActionListener(e -> {
			if (btnAgregar.isEnabled())
				btnAgregar.doClick();
		});

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
