// ENUNCIADO
// 1.- BORRADO MULTIPLE (varias filas a la vez, en una sola pulsacion de borrar).
// 2.- Ordenar la tabla segun X criterio. Por ejemplo pulsando en el encabezado de Nombre y que se ordene ASC o DESC.
// 3.- Validación de que no hay campos vacios en el formulario o edades inválidas.
package tutorialDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

// COSAS QUE PODRIA MEJORAR O AÑADIR:
// - Poder seleccionar varios alumnos y borrarlos a la vez
// - Cambiar tipo de selección de edad.
// - Poder modificar las ciudades disponibles pero con lock de si esta asignada no se puede borrar.

public class Prueba08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(Prueba08::crearUI);

	}

	// --- Modelo de datos ---
	static class Alumno {
		String nombre;
		int edad;
		String ciudad;

		Alumno(String nombre, int edad, String ciudad) {
			this.nombre = nombre;
			this.edad = edad;
			this.ciudad = ciudad;
		}
	}

	// --- TableModel ---
	static class AlumnoTableModel extends AbstractTableModel {
		private final String[] cols = { "Nombre", "Edad", "Ciudad" };
		private final List<Alumno> data = new ArrayList<>();

		public void add(Alumno a) {
			data.add(a);
			int row = data.size() - 1;
			fireTableRowsInserted(row, row);
		}

		public Alumno get(int row) {
			return data.get(row);
		}

		public void remove(int row) {
			data.remove(row);
			fireTableRowsDeleted(row, row);
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public int getColumnCount() {
			return cols.length;
		}

		@Override
		public String getColumnName(int c) {
			return cols[c];
		}

		@Override
		public Object getValueAt(int r, int c) {
			Alumno a = data.get(r);
			return switch (c) {
			case 0 -> a.nombre;
			case 1 -> a.edad;
			case 2 -> a.ciudad;
			default -> "";
			};
		}

		@Override
		public boolean isCellEditable(int r, int c) {
			return true; // editable en la tabla
		}

		@Override
		public void setValueAt(Object value, int r, int c) {
			Alumno a = data.get(r);
			switch (c) {
			case 0 -> a.nombre = String.valueOf(value).trim();
			case 1 -> {
				try {
					a.edad = Integer.parseInt(String.valueOf(value));
				} catch (NumberFormatException ignored) {
				}
			}
			case 2 -> a.ciudad = String.valueOf(value).trim();
			}
			fireTableCellUpdated(r, c);
		}
	}

	private static void crearUI() {
		JFrame frame = new JFrame("Venatana 08 - JTable CRUD");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel root = new JPanel(new BorderLayout(10, 10));
		root.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Formulario
		JTextField txtNombre = new JTextField(12);
		JSpinner spEdad = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1));
		JComboBox<String> cbCiudad = new JComboBox<>(new String[] { "Madrid", "Barcelona", "Valencia", "Sevilla" });
		JButton btnAdd = new JButton("Añadir");

		JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
		form.add(new JLabel("Nombre:"));
		form.add(txtNombre);
		form.add(new JLabel("Edad:"));
		form.add(spEdad);
		form.add(new JLabel("Ciudad:"));
		form.add(cbCiudad);
		form.add(btnAdd);

		// Tabla
		AlumnoTableModel model = new AlumnoTableModel();
		model.add(new Alumno("Ana", 21, "Madrid"));
		model.add(new Alumno("Luis", 19, "Valencia"));

		JTable table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Botones CRUD
		JButton btnBorrar = new JButton("Borrar");
		JButton btnEditarDialogo = new JButton("Editar (diálogo)");

		JPanel acciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		acciones.add(btnEditarDialogo);
		acciones.add(btnBorrar);

		// Add alumno
		btnAdd.addActionListener(e -> {
			String nombre = txtNombre.getText().trim();
			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Nombre obligatorio");
				return;
			}
			int edad = (int) spEdad.getValue();
			String ciudad = (String) cbCiudad.getSelectedItem();
			model.add(new Alumno(nombre, edad, ciudad));
			txtNombre.setText("");
			txtNombre.requestFocusInWindow();
		});

		// Borrar
		btnBorrar.addActionListener(e -> {
			int row = table.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(frame, "Selecciona una fila");
				return;
			}
			int ok = JOptionPane.showConfirmDialog(frame, "¿Borrar fila seleccionada?", "Confirmar",
					JOptionPane.YES_NO_OPTION);
			if (ok == JOptionPane.YES_OPTION)
				model.remove(row);
		});

		// Editar con diálogo (en vez de inline)
		btnEditarDialogo.addActionListener(e -> {
			int row = table.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(frame, "Selecciona una fila");
				return;
			}
			Alumno a = model.get(row);

			JTextField n = new JTextField(a.nombre, 12);
			JSpinner ed = new JSpinner(new SpinnerNumberModel(a.edad, 0, 120, 1));
			JComboBox<String> ciu = new JComboBox<>(new String[] { "Madrid", "Barcelona", "Valencia", "Sevilla" });
			ciu.setSelectedItem(a.ciudad);

			JPanel panel = new JPanel(new GridLayout(0, 2, 6, 6));
			panel.add(new JLabel("Nombre:"));
			panel.add(n);
			panel.add(new JLabel("Edad:"));
			panel.add(ed);
			panel.add(new JLabel("Ciudad:"));
			panel.add(ciu);

			int res = JOptionPane.showConfirmDialog(frame, panel, "Editar alumno", JOptionPane.OK_CANCEL_OPTION);
			if (res == JOptionPane.OK_OPTION) {
				a.nombre = n.getText().trim();
				a.edad = (int) ed.getValue();
				a.ciudad = (String) ciu.getSelectedItem();
				model.fireTableRowsUpdated(row, row);
			}
		});

		root.add(form, BorderLayout.NORTH);
		root.add(new JScrollPane(table), BorderLayout.CENTER);
		root.add(acciones, BorderLayout.SOUTH);

		frame.setContentPane(root);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
