package conversor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static JFrame frame;
    private static JComboBox<String> menuDesplegable;
    private static JTextField valorTextField;
    private static JButton seleccionarButton;

    public static void main(String[] args) {
        frame = new JFrame("Programa de Conversión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        // Usamos GridLayout para organizar los componentes verticalmente
        frame.setLayout(new GridLayout(3, 1));

        JLabel tituloLabel = new JLabel("   Bienvenido al Programa de Conversión");
        frame.add(tituloLabel);

        // Agrega un JPanel para contener la etiqueta y el menú desplegable
        JPanel panelOpcion = new JPanel();
        panelOpcion.setLayout(new FlowLayout()); // Puedes ajustar el layout según tus preferencias

        JLabel opcionLabel = new JLabel("Selecciona una opción:");
        panelOpcion.add(opcionLabel);

        String[] opciones = {"Conversor de Moneda", "Conversor de Temperatura"};
        menuDesplegable = new JComboBox<>(opciones);
        panelOpcion.add(menuDesplegable);

        frame.add(panelOpcion);

        seleccionarButton = new JButton("Seleccionar");
        seleccionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarConversor();
            }
        });
        frame.add(seleccionarButton);

        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
    }

    private static void seleccionarConversor() {
        String opcionSeleccionada = (String) menuDesplegable.getSelectedItem();

        if (opcionSeleccionada.equals("Conversor de Moneda")) {
            mostrarVentanaSolicitarDatoMoneda();
        } else if (opcionSeleccionada.equals("Conversor de Temperatura")) {
            mostrarVentanaSolicitarDatoTemperatura();
        } else {
            JOptionPane.showMessageDialog(frame, "Seleccione una opción válida.");
        }
    }

    private static void mostrarVentanaSolicitarDatoMoneda() {
        double valor;

        try {
            valor = Double.parseDouble(JOptionPane.showInputDialog(frame, "Ingresa un valor de moneda:"));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese un valor numérico válido.");
            return;
        }

        String[] opcionesConversion = {
            "Convertir de MXN a Dólar",
            "Convertir de MXN a Euros",
            "Convertir de MXN a Libras Esterlinas",
            "Convertir de MXN a Yen Japonés",
            "Convertir de MXN a Won surcoreano",
            "Convertir de Dólar a MXN",
            "Convertir de Euros a MXN",
            "Convertir de Libras Esterlinas a MXN",
            "Convertir de Yen Japonés a MXN",
            "Convertir de Won surcoreano a MXN"
        };

        String opcionConversion = (String) JOptionPane.showInputDialog(frame,
                "Selecciona una opción de conversión",
                "Conversor de Moneda",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionesConversion,
                opcionesConversion[0]);

        if (opcionConversion != null) {
            Conversor conversor = new ConversorMoneda(opcionConversion);
            double resultado = conversor.convertir(valor);
            mostrarResultado(resultado, conversor.obtenerUnidadDeMedida());
        }
    }

    private static void mostrarVentanaSolicitarDatoTemperatura() {
        double valor;

        try {
            valor = Double.parseDouble(JOptionPane.showInputDialog(frame, "Ingresa un valor de temperatura:"));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese un valor numérico válido.");
            return;
        }

        String[] opcionesConversion = {
            "Convertir de Celsius a Fahrenheit",
            "Convertir de Celsius a Kelvin",
            "Convertir de Fahrenheit a Celsius",
            "Convertir de Fahrenheit a Kelvin",
            "Convertir de Kelvin a Celsius",
            "Convertir de Kelvin a Fahrenheit"
        };

        String opcionConversion = (String) JOptionPane.showInputDialog(frame,
                "Selecciona una opción de conversión",
                "Conversor de Temperatura",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionesConversion,
                opcionesConversion[0]);

        if (opcionConversion != null) {
            Conversor conversor = new ConversorTemperatura(opcionConversion);
            double resultado = conversor.convertir(valor);
            mostrarResultado(resultado, conversor.obtenerUnidadDeMedida());
        }
    }

   private static void mostrarResultado(double resultado, String unidadDeMedida) {
    JOptionPane.showMessageDialog(frame, "Resultado: " + resultado + " " + unidadDeMedida);

    int respuesta = JOptionPane.showConfirmDialog(frame, "¿Desea continuar?", "Continuar", JOptionPane.YES_NO_OPTION);

    if (respuesta == JOptionPane.YES_OPTION) {
        valorTextField.setText("");
        seleccionarConversor(); // Volver a seleccionar el conversor
    } else {
        // Muestra el mensaje de despedida
        JOptionPane.showMessageDialog(frame, "Cerrando el converidor, vuelva pronto");
        System.exit(0);
    }
  }
}
