package conversor;
public class ConversorMoneda implements Conversor {
    private String opcionSeleccionada;

    // Constructor que recibe la opción seleccionada
    public ConversorMoneda(String opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    public double convertir(double valor) {
        // Implementa la conversión según la opción seleccionada
        double conversionRate = 1.0; // Tasa de conversión inicial (no se realiza ninguna conversión)

        // Verificar la opción seleccionada y establecer la tasa de conversión correspondiente
        if (opcionSeleccionada.equals("Convertir de MXN a Dólar")) {
            conversionRate = 0.057; // 1 peso mexicano equivale a 0.057 dólares
        } else if (opcionSeleccionada.equals("Convertir de MXN a Euros")) {
            conversionRate = 0.054; // 1 peso mexicano equivale a 0.054 euros
        } else if (opcionSeleccionada.equals("Convertir de MXN a Libras Esterlinas")) {
            conversionRate = 0.047; // 1 peso mexicano equivale a 0.047 libras esterlinas
        } else if (opcionSeleccionada.equals("Convertir de MXN a Yen Japonés")) {
            conversionRate = 8.54; // 1 peso mexicano equivale a 8.54 yen japonés
        } else if (opcionSeleccionada.equals("Convertir de MXN a Won surcoreano")) {
            conversionRate = 76.97; // 1 peso mexicano equivale a 76.97 won surcoreano
        } else if (opcionSeleccionada.equals("Convertir de Dólar a MXN")) {
            conversionRate = 17.43; // 1 dólar equivale a 17.43 pesos mexicanos
        } else if (opcionSeleccionada.equals("Convertir de Euros a MXN")) {
            conversionRate = 18.46; // 1 euro equivale a 18.46 pesos mexicanos
        } else if (opcionSeleccionada.equals("Convertir de Libras Esterlinas a MXN")) {
            conversionRate = 21.28; // 1 libra esterlina equivale a 21.20.0138 pesos mexicanos
        } else if (opcionSeleccionada.equals("Convertir de Yen Japonés a MXN")) {
            conversionRate = 0.12; // 1 yen japonés equivale a 0.12 pesos mexicanos
        } else if (opcionSeleccionada.equals("Convertir de Won surcoreano a MXN")) {
            conversionRate = 0.013; // 1 won surcoreano equivale a 0.013 pesos mexicanos
        }

        // Realizar la conversión
        double valorConvertido = valor * conversionRate;
        return valorConvertido;

    }
    public String obtenerUnidadDeMedida() {
        // Retorna la unidad de medida correspondiente según la opción seleccionada
        if (opcionSeleccionada.contains("Convertir de MXN a Dólar")) {
            return "dólares";
        } else if (opcionSeleccionada.contains("Convertir de MXN a Euros")) {
            return "euros";
        } else if (opcionSeleccionada.contains("Convertir de MXN a Libras Esterlinas")) {
            return "libras esterlinas";
        } else if (opcionSeleccionada.contains("Convertir de MXN a Yen Japonés")) {
            return "yen japonés";
        } else if (opcionSeleccionada.contains("Convertir de MXN a Won surcoreano")) {
            return "won surcoreano"; 
        } else if (opcionSeleccionada.contains("Convertir de Dólar a MXN")) {
            return "pesos mexicanos";
        } else if (opcionSeleccionada.contains("Convertir de Euros a MXN")) {
            return "pesos mexicanos";
        }else if (opcionSeleccionada.contains("Convertir de Libras Esterlinas a MXN")) {
            return "pesos mexicanos";
        }else if (opcionSeleccionada.contains("Convertir de Yen Japonés a MXN")) {
            return "pesos mexicanos";
        }else if (opcionSeleccionada.contains("Convertir de Won surcoreano a MXN")) {
            return "pesos mexicanos";
        } else {
            return "";
        }
    }
}