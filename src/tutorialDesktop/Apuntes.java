package tutorialDesktop;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Apuntes {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Título de la ventana");
        frame.setVisible(true); // Siempre al final

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


// ######## Comportamiento al cerrar
    // | Opción | Qué hace |
    // |---|---|
    // | `DO_NOTHING_ON_CLOSE` | No hace nada |
    // | `HIDE_ON_CLOSE` | Oculta el frame (sigue en memoria) |
    // | `DISPOSE_ON_CLOSE` | Destruye el frame (app sigue viva) |
    // | `EXIT_ON_CLOSE` | Destruye el frame **y cierra la app** ✅ |


// ######## BORDERLAYOUT Layout por defectO
    // El `ContentPane` del JFrame usa **BorderLayout** por defecto. Las zonas son:
    // ```
    //         NORTH
    // WEST   CENTER   EAST
    //         SOUTH

    frame.add(componente, BorderLayout.NORTH);  // arriba
    frame.add(componente, BorderLayout.SOUTH);  // abajo
    frame.add(componente, BorderLayout.CENTER); // centro (por defecto)
    frame.setLayout(new BorderLayout(10, 10)); // (hgap, vgap)
    //  hgap = espacio horizontal entre zonas
    //  vgap = espacio vertical entre zonas


//######## COMPONENTES BASICOS
    JLabel label = new JLabel("Texto");         // Etiqueta de texto
    JTextField campo = new JTextField(20);      // Campo de texto (20 cols)
    JButton boton = new JButton("Click");       // Botón
    JPanel panel = new JPanel();                // Contenedor auxiliar
    panel.add(label);                           // Añadir al panel
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));


//######## Tamaño y posición del frame
    frame.setSize(400, 300);                // Ancho x Alto fijo
    frame.setLocationRelativeTo(null);          // Centrar en pantalla
    frame.pack();                               // Ajustar al contenido(alternativa)
    frame.setBounds(x, y, ancho, alto);         // Posición + tamaño manual


//######## Eventos con lambda
    boton.addActionListener(e -> {
        String texto = campo.getText();  // Leer el campo
        // hacer algo...
    });


//######## Diálogos — JOptionPane
    JOptionPane.showMessageDialog(frame, "Mensaje a mostrar");


//######## COMPONENTE TABLA
    // 1. Crear el modelo (datos vacíos + nombres de columnas)
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][] {},                        // Filas iniciales (vacío)
            new String[] { "Columna 1", "Columna 2" } // Cabeceras
        );

    // 2. Crear la tabla pasándole el modelo
        JTable tabla = new JTable(modelo);

    // 3. Añadir la tabla dentro de un JScrollPane
        frame.add(new JScrollPane(tabla));  // JTable SIEMPRE va dentro de un JScrollPane

    // 4. Añadir filas al modelo 
        modelo.addRow(new Object[] { "valor col1", "valor col2" });


//######### CLASE QUE EXTIENDE JFRAME

    public class Clase extends JFrame {
        public Clase() { // ya no hace falta crear el frame. "Clase" sería el nombre de la ventana
            setTitle("título"); // ya no hace falta poner el frame.setTitle...
            setSize(400, 300);
        }
    }

    // luego hay que invocarla en el main

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Clase ventana = new Clase();    //Se crea por medio del constructor
            ventana.setVisible(true);       //Se hace visible
        });
    }


//######### FLOWLAYOUT

    //lo va metiendo como un libro normal de arriba a abajo y de izquierda a derecha
    //Salta de línea si no cabe.
    System.out.println(frame.getLayout()); //Esto me dice que layout está puesto

    setLayout(new FlowLayout()); // Lo seteo a flowlayout || CUIDAO QUE SOBRESCRIBE A BORDERLAYOUT.
    add(componente); //Se añade directamente sin tener que poner flowlayout.
    
    //FLOWLAYOUT CON ALINEACION
    new FlowLayout(FlowLayout.LEFT);   // Componentes pegados a la izquierda
    new FlowLayout(FlowLayout.RIGHT);  // Componentes pegados a la derecha
    new FlowLayout(FlowLayout.CENTER); // Centrado (por defecto)

    //ejemplo FLOWLAYOUT y en componentes y luego estructurado con BORDERLAYOUT
        JFrame frame = new JFrame("Mi Cuarta Ventana Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Formulario en panel superior
		JPanel formulario = new JPanel(new FlowLayout(FlowLayout.LEFT));
		formulario.add(new JLabel("Nombre:"));
		JTextField txtNombre = new JTextField(15);
		formulario.add(txtNombre);

        // Area Central
		JTextArea areaTexto = new JTextArea(10, 30);
		areaTexto.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(areaTexto);

		// Botones en panel inferior
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnSaludar = new JButton("Saludar");
		JButton btnLimpiar = new JButton("Limpiar");
		panelBotones.add(btnSaludar);
		panelBotones.add(btnLimpiar);

		// Layout/Disposicion Principal del Frame
		frame.setLayout(new BorderLayout(10, 10));
		frame.add(formulario, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(panelBotones, BorderLayout.SOUTH);


//######### CREARUI
    //alternativa a hacer una clase y extender JFRAME
    
    //Aquí en la clase no extiende nada y directamente
    //Primero el main en el que se hace la "función" y se invoca

    public class Clase {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            SwingUtilities.invokeLater(Clase::crearUI);
        }

        public static void crearUI() {
            JFrame frame = new JFrame("Mi Ventana Swing");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Aqui se pone toda la movida etc.
        }
    }       


//########## COMPONENTE JTEXT AREA

    JTextArea area = new JTextArea();           // Area de texto de varias lineas
    areaTexto.setEditable(false);                // Solo lectura
    JScrollPane scrollPane = new JScrollPane(areaTexto); // ⚠️ siempre con scroll

    //Metodos de JTEXT AREA
        areaTexto.append("texto\n");  // Añadir texto al final
        areaTexto.setText("");         // Borrar todo el contenido
        areaTexto.getText();           // Leer el contenido


//######### VALIDACIÓN DE CAMPOS

    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(
            frame,                        // Componente padre
            "Introduzca un nombre",       // Mensaje | La primera opción si está vacio
            "AVISO",                      // Título  | si no cumple el if
            JOptionPane.WARNING_MESSAGE   // Tipo de icono
        );
        return; // Corta la ejecución del listener
    }

    INFORMATION_MESSAGEℹ️    Info
    WARNING_MESSAGE⚠️       Aviso
    ERROR_MESSAGE❌         Error
    QUESTION_MESSAGE❓      Pregunta
    PLAIN_MESSAGE           Sin icono


// ######### REQUESTFOCUS

    txtNombre.requestFocusInWindow(); // Esto hace que en ese momento se focalice en txtnombre

    
//########## GRID REJILLAS
    
    //CREAMOS UN COMPONENTE 
        JPanel formulario = new JPanel(new GridBagLayout()); //dentro tendrá el layoutMANAGER GRIDBAG LAYOUT
    
    //CONFIGURAMOS EL GRID
        GridBagConstraints c = new GridBagConstraints();       //Se crea la rejilla
        c.insets = new Insets(4, 4, 4, 4); // Margen exterior: top,left,bottom,right
        c.anchor = GridBagConstraints.WEST; // Alineación dentro de la celda

        //CREAMOS LO QUE TENDRÁ EL COMPONENTE
        JLabel lblNombre = new JLabel("Nombre:");
		JTextField txtNombre = new JTextField(18);
		JLabel lblEdad = new JLabel("Edad:");
		JSpinner spEdad = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1));
		JLabel lblCiudad = new JLabel("Ciudad:");
		JComboBox<String> cbCiudad = new JComboBox<>(new String[] { "Madrid", "Barcelona", "Valencia", "Sevilla" });
		JCheckBox chkAcepto = new JCheckBox("Acepto condiciones");
        
    //VAMOS MODIFICANDO LAS COORDENADAS COMO SI FUERA UN CURSOR Y METEMOS LOS COMPONENTES
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
        
        // Y ASÍ SE HARÍA CON TODAS LAS FILAS
            // Si algo debe de ocupar más de una celda se especifica con:
            c.gridwidth = 2;    // Cuántas columnas ocupa (por defecto 1)
            c.gridheight = 1;   // Cuántas filas ocupa (por defecto 1)
            c.gridwidth = 1;    // ⚠️ Resetear siempre después

//########## COMPONENTE JPANEL CON BOTONES
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnAgregar = new JButton("Agregar");
		JButton btnLimpiar = new JButton("Limpiar");
		botones.add(btnLimpiar);
		botones.add(btnAgregar);


//########## ROOT
        //Es como un panel general
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(new EmptyBorder(10, 10, 10, 10)); // margen: top,left,bottom,right
        frame.setContentPane(root); // root ES el contenido del frame. SE PONE AL FINAL
    
        //de aqui en vez de hacer frame.add se hace root.add
        // ejemplo
   
            root.add(formulario, BorderLayout.NORTH);
            root.add(scroll, BorderLayout.CENTER);
            root.add(botones, BorderLayout.SOUTH);
            frame.setContentPane(root);
    

//########## COMPONENTE SPINNER
    
    // SpinnerNumberModel(valorInicial, min, max, paso)
        JSpinner spEdad = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1));

    // Leer valor (devuelve Object, hay que castear)
        int edad = (int) spEdad.getValue();

    // Resetear
        spEdad.setValue(18);


//########### COMPONENTE COMBOBOX

    JComboBox<String> cbCiudad = new JComboBox<>(
    new String[] { "Madrid", "Barcelona", "Valencia" }
    );

    // Leer selección
        String ciudad = (String) cbCiudad.getSelectedItem();

    // Resetear al primer elemento
        cbCiudad.setSelectedIndex(0);  


//########### COMPONENTE CHECKBOX

    JCheckBox chkAcepto = new JCheckBox("Acepto condiciones");

    // Leer estado
        boolean acepto = chkAcepto.isSelected();

    // Resetear
        chkAcepto.setSelected(false);


//########### FUNCIÓN VALIDAR QUE CORRE TODO EL RATO 
//########### BOTÓN QUE SE DESHABILITA

    Runnable validar = () -> {
        boolean okNombre = !txtNombre.getText().trim().isEmpty();
        boolean okAcepto = chkAcepto.isSelected();
        btnAgregar.setEnabled(okNombre && okAcepto); // Habilita/deshabilita el botón 
    };
    //💡 setEnabled(false) desactiva un componente visualmente y funcionalmente.

    // PARA QUE COMPRUEBE CONSTANTEMENTE EL RUNNABLE HAY QUE PONERLE UN DOCUMENTLISTENER EN TEXTO 

        txtNombre.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e)  { validar.run(); } // Al escribir
            public void removeUpdate(DocumentEvent e)  { validar.run(); } // Al borrar
            public void changedUpdate(DocumentEvent e) { validar.run(); } // Cambios de estilo
            //⚠️ Hay que implementar los 3 métodos obligatoriamente.
        });

    // PARA CHECKBOX O BOTONES VALE SOLO CON EL ACTIONLISTENER
        
		chkAcepto.addActionListener(e -> validar.run());
        validar.run();  // tambíen se ha de ejecutar en general en el documento 
                        // para iniciar el proceso de validación aunque no se haga nada   


//######### ATAJOS DE TECLADO

    JRootPane rp = frame.getRootPane(); // Contenedor raíz del frame

    // 1. Registrar el atajo en el InputMap
        rp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control L"), "limpiar"); // tecla → nombre

    // 2. Asociar el nombre a una acción en el ActionMap
        rp.getActionMap().put("limpiar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar.doClick(); // Simula un clic real
            }
        });
    // WHEN_FOCUSED                        Solo cuando ese componente tiene el foco
    // WHEN_IN_FOCUSED_WINDOW              En cualquier parte de la ventana ✅
    // WHEN_ANCESTOR_OF_FOCUSED_COMPONENT  Cuando un hijo tiene el foco

        KeyStroke.getKeyStroke("control L")     // Ctrl + L
        KeyStroke.getKeyStroke("control S")     // Ctrl + S
        KeyStroke.getKeyStroke("ENTER")         // Enter
        KeyStroke.getKeyStroke("F5")            // F5
        
    // ACCIÓN PARA HACER CLICK SIN DUPLICAR CODIGO
        btnLimpiar.doClick();                   // Ejecuta el ActionListener del botón

    //JTEXTFIELD TIENE UN ACTIONLISTENER POR DEFECTO QUE ES EL ENTER
        txtNombre.addActionListener(e -> {
            if (btnAgregar.isEnabled())
                btnAgregar.doClick();
        });


//########## MENUS

    // JMenuBar  →  JMenu  →  JMenuItem
    JMenuBar mb = new JMenuBar();                   // Se crea la barra
    JMenu mArchivo = new JMenu("Archivo");          // Menú desplegable
    JMenuItem miSalir = new JMenuItem("Salir");     // Opción dentro del menú
    miSalir.addActionListener(e -> frame.dispose());// Acción al clickar
    frame.setJMenuBar(mb);                          // Barra → Frame ⚠️ setJMenuBar, no add
    mb.add(mArchivo);                               // Menú → Barra
    mArchivo.add(miSalir);                          // Opción → Menú

//########## PESTAÑAS JTABBED PANE

    JTabbedPane tabs = new JTabbedPane();           // Esto es como crear la "barra de pestañas"
    
    // Cada tab es un panel normal
    JPanel tab1 = new JPanel(...);
    JPanel tab2 = new JPanel(...);

    tabs.addTab("Nombre pestaña", tab1);  // Añadir pestaña
    tabs.addTab("Otra pestaña",   tab2);

    frame.setContentPane(tabs); // El TabbedPane ES el contenido del frame

    //Ejemplo
    // Tabs
		JTabbedPane tabs = new JTabbedPane();

		// Tab 1: Notas
		JPanel tabNotas = new JPanel(new BorderLayout());
		tabNotas.setBorder(new EmptyBorder(10, 10, 10, 10));
		JTextArea notas = new JTextArea(12, 40);
		tabNotas.add(new JScrollPane(notas), BorderLayout.CENTER);

        tabs.addTab("Notas", tabNotas);     //Se añade la pesaña a la barra de pestañas


//##########LISTA JLIST

    // Igual que JTable usa DefaultTableModel, JList usa DefaultListModel.
    // 1. Crear el modelo
        DefaultListModel<String> model = new DefaultListModel<>();

    // 2. Añadir elementos iniciales
        model.addElement("Comprar pan");
        model.addElement("Estudiar Swing");

    // 3. Crear la lista con el modelo
        JList<String> lista = new JList<>(model);

    // ⚠️ Siempre dentro de JScrollPane
        new JScrollPane(lista);

    // OPERACIONES SOBRE EL MODELO
        model.addElement("Nueva tarea");    // Añadir elemento
        model.remove(idx);                  // Borrar por índice
        model.getSize();                    // Número de elementos
        model.getElementAt(idx);            // Obtener elemento por índice
    
    // OBTENER SELECCION DE LA LISTA
        int idx = lista.getSelectedIndex();  // Índice seleccionado (-1 si ninguno)
        if (idx >= 0) {                      // ⚠️ Comprobar siempre antes de borrar
            model.remove(idx);
        }


// ########## JTOOLBAR

    JToolBar toolBar = new JToolBar("Herramientas"); // El string es el título cuando flota

    // Añadir botones
    toolBar.add(btnNuevo);
    toolBar.addSeparator();       // Línea divisoria vertical
    toolBar.add(btnGuardar);

    // Añadir otros componentes (labels, combos, etc.)
    toolBar.add(new JLabel(" Zoom: "));
    toolBar.add(zoom);

    // Añadir al frame SIEMPRE en NORTH
    add(toolBar, BorderLayout.NORTH);

    //💡 Por defecto el JToolBar es flotante — el usuario puede arrastrarlo y soltarlo fuera de la ventana. Para desactivarlo:
    toolBar.setFloatable(false); // Fija la toolbar, no se puede arrastrar


    }
}
