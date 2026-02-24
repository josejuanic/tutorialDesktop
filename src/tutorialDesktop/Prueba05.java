// PRUEBA05
package tutorialDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

// COSAS QUE PODRIA MEJORAR O AÑADIR:

public class Prueba05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(Prueba05::crearUI);

	}

	public static void crearUI() {
		JFrame frame = new JFrame("Ventana 05 - Formulario");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// 		Algo nuevo, BOrderLayout con espacios entre componentes de 10px
//      ROOT va a ser nuestro contenedor principal.
		JPanel root = new JPanel(new BorderLayout(10, 10));
// 		Ahora al panel raiz (root) le añadimos un borde vacio de 10px por cada lado, 
//		para que no se pegue a los bordes de la ventana
		root.setBorder(new EmptyBorder(10, 10, 10, 10));

		// --- Panel Formulario (arriba) ---
		JPanel formulario = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(4, 4, 4, 4);
		c.anchor = GridBagConstraints.WEST;

		JLabel lblNombre = new JLabel("Nombre:");
		JTextField txtNombre = new JTextField(18);

		JLabel lblEdad = new JLabel("Edad:");
		JSpinner spEdad = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1));

		JLabel lblCiudad = new JLabel("Ciudad:");
		JComboBox<String> cbCiudad = new JComboBox<>(new String[] { "Madrid", "Barcelona", "Valencia", "Sevilla" });

		JCheckBox chkAcepto = new JCheckBox("Acepto condiciones");

		// fila 0
		c.gridx = 0;
		c.gridy = 0;
		formulario.add(lblNombre, c);
		c.gridx = 1;
		c.gridy = 0;
		formulario.add(txtNombre, c);

		// fila 1
		c.gridx = 0;
		c.gridy = 1;
		formulario.add(lblEdad, c);
		c.gridx = 1;
		c.gridy = 1;
		formulario.add(spEdad, c);

		// fila 2
		c.gridx = 0;
		c.gridy = 2;
		formulario.add(lblCiudad, c);
		c.gridx = 1;
		c.gridy = 2;
		formulario.add(cbCiudad, c);

		// fila 3 (checkbox ocupa 2 columnas)
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		formulario.add(chkAcepto, c);
		c.gridwidth = 1;

		// --- Centro: salida ---
		JTextArea area = new JTextArea(10, 40);
		area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area);

		// --- Abajo: botones ---
		JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnAgregar = new JButton("Agregar");
		JButton btnLimpiar = new JButton("Limpiar");
		botones.add(btnLimpiar);
		botones.add(btnAgregar);

		// montar
		root.add(formulario, BorderLayout.NORTH);
		root.add(scroll, BorderLayout.CENTER);
		root.add(botones, BorderLayout.SOUTH);
		frame.setContentPane(root);

		// acciones mínimas (aqui lo que deberiamos hacer es mejorarlas/ampliarlas)
		btnAgregar.addActionListener(e -> {
			String nombre = txtNombre.getText().trim();
			int edad = (int) spEdad.getValue();
			String ciudad = (String) cbCiudad.getSelectedItem();
			boolean acepto = chkAcepto.isSelected();

			area.append("Nombre=" + nombre + ", Edad=" + edad + ", Ciudad=" + ciudad + ", Acepto=" + acepto + "\n");
		});

		btnLimpiar.addActionListener(e -> {
			txtNombre.setText("");
			spEdad.setValue(18);
			cbCiudad.setSelectedIndex(0);
			chkAcepto.setSelected(false);
			area.setText("");
			txtNombre.requestFocusInWindow();
		});

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

