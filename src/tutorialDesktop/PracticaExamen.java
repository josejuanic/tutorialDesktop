package tutorialDesktop;

import java.awt.BorderLayout;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PracticaExamen {

    public static void main(String[] args) {
        JFrame ventana1 = new JFrame("Ventana de aplicación");

        //Configuración de la ventana1
       
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setSize(400,300);
        ventana1.setLocation(500, 500);
        
        //Componentes 

        JLabel etiqueta = new JLabel("Título de etiqueta");
            ventana1.add(etiqueta, BorderLayout.NORTH);
        
        JTextField lineaTexto = new JTextField(20);
            ventana1.add(lineaTexto, BorderLayout.EAST);

        JButton boton = new JButton("Botón");
            ventana1.add(boton, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
            ventana1.add(panel, BorderLayout.WEST);

            // TABLA
                //1. Crear el modelo de tabla
                    DefaultTableModel modeloTabla = new DefaultTableModel(
                        new Object[][] {},
                        new String[] { "Columna 1", "Columna 2" }
                    );
                
                //2. Crear la tabla pasándole el modelo.
                    JTable tabla = new JTable(modeloTabla);
                
                //3. Añadir la tabla dentro de un JScrollPane
                    ventana1.add(new JScrollPane(tabla));
                //4. Añadir una fila
                    modeloTabla.addRow(new Object[] { "valor1", "valor2"});
                

        //Eventos con lambda

        boton.addActionListener(e -> {
            String texto = lineaTexto.getText();
            JOptionPane.showMessageDialog(ventana1, texto);
        });

        //Ejecución al final
        ventana1.pack(); // Ajustar al contenido
        ventana1.setVisible(true); //siempre al final
    }

}