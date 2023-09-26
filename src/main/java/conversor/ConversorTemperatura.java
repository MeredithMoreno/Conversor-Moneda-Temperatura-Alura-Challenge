package conversor;

public class ConversorTemperatura implements Conversor {
    private String opcionSeleccionada;

    // Constructor que recibe la opción seleccionada
    public ConversorTemperatura(String opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    public double convertir(double valor) {
        // Implementa la conversión según la opción seleccionada
        double valorConvertido = 0.0; // Valor inicial

        // Realiza la conversión basada en la opción seleccionada
        if (opcionSeleccionada.equals("Convertir de Celsius a Fahrenheit")) {
            valorConvertido = (valor * 9/5) + 32;
        } else if (opcionSeleccionada.equals("Convertir de Celsius a Kelvin")) {
            valorConvertido = valor + 273.15;
        } else if (opcionSeleccionada.equals("Convertir de Fahrenheit a Celsius")) {
            valorConvertido = (valor - 32) * 5/9;
        } else if (opcionSeleccionada.equals("Convertir de Fahrenheit a Kelvin")) {
            valorConvertido = ((valor - 32) * 5/9) + 273.15;
        } else if (opcionSeleccionada.equals("Convertir de Kelvin a Celsius")) {
            valorConvertido = valor - 273.15;
        } else if (opcionSeleccionada.equals("Convertir de Kelvin a  Fahrenheit")) {
            valorConvertido = ((valor - 273.15) * 9/5) + 32;
        }

        return valorConvertido;
    }
     public String obtenerUnidadDeMedida() {
        // Retorna la unidad de medida correspondiente según la opción seleccionada
        if (opcionSeleccionada.contains("Convertir de Celsius a Fahrenheit")) {
            return "Fahrenheit";
        } else if (opcionSeleccionada.contains("Convertir de Celsius a Kelvin")) {
            return "Kelvin";
        } else if (opcionSeleccionada.contains("Convertir de Fahrenheit a Celsius")) {
            return "Celsius";
        }else if (opcionSeleccionada.contains("Convertir de Fahrenheit a Kelvin")){
             return "Kelvin";
        }else if (opcionSeleccionada.contains("Convertir de Kelvin a Celsius")){
             return "Celsius";
        }else if (opcionSeleccionada.contains("Convertir de Kelvin a  Fahrenheit")){
             return "Fahrenheit";
        } else {
            return "";
        }
    }
}