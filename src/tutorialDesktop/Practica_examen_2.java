package tutorialDesktop;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Practica_examen_2 extends JFrame{

    public Practica_examen_2() {
        setTitle("Ventana_Practica");
        setSize(400,300);
        setLocation(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JLabel etiqueta = new JLabel("Titulo etiqueta");
            add(etiqueta);
        JTextField campo = new JTextField(20);
            add(campo);
        JButton boton = new JButton("botón");
            add(boton);
        JPanel panel = new JPanel();
            add(panel);
        
        // TABLA

            DefaultTableModel modeloTabla = new DefaultTableModel(
                    new Object[][] {},
                    new String[] { "Columna 1", "Columna 2" }
                );
            
            JTable tabla = new JTable(modeloTabla);

            add(new JScrollPane(tabla));

            modeloTabla.addRow(new Object[] { "valor1", "valor2"});




    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Practica_examen_2 ventana2 = new Practica_examen_2();
            ventana2.setVisible(true);
        });
    }

}
