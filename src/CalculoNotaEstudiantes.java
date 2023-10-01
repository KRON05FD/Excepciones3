
import javax.swing.JOptionPane;

/**
 *
 * @author andresnitolamoreno
 * Corporacion Universitaria Remigton
 */

public class CalculoNotaEstudiantes {

    public static void main(String[] args) {
        String[] nombres = new String[5];
        double[] parcial1 = new double[5];
        double[] parcial2 = new double[5];
        double[] seguimiento = new double[5];
        double[] coevaluacion = new double[5];
        double[] notasFinales = new double[5];

        for (int i = 0; i < 5; i++) {
            JOptionPane.showMessageDialog(null, "Estudiante #" + (i + 1),
                    "Calcular Notas", JOptionPane.QUESTION_MESSAGE);

            // Leer nombre del estudiante
            nombres[i] = JOptionPane.showInputDialog(null, "Nombre del estudiante: ",
                    "Registro notas", JOptionPane.QUESTION_MESSAGE);

            // Leer nota del Parcial 1
            parcial1[i] = leerNota("Nota del Parcial 1:");

            // Leer nota del Parcial 2
            parcial2[i] = leerNota("Nota del Parcial 2:");

            // Leer nota del Seguimiento
            seguimiento[i] = leerNota("Nota del Seguimiento:");

            // Leer nota de la Coevaluación
            coevaluacion[i] = leerNota("Nota de la Coevaluación:");

            // Calcular la nota final
            notasFinales[i] = calcularNotaFinal(parcial1[i], parcial2[i], seguimiento[i], coevaluacion[i]);
        }

        // Calcular la nota requerida para aprobar y mostrar resultados
        StringBuilder resultados = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            double notaRequerida = 3.0 - notasFinales[i];
            boolean aprobado = notasFinales[i] >= 3.0;

            resultados.append("Estudiante #" + (i + 1) + ": " + nombres[i] + "\n");
            resultados.append("Nota Final: " + notasFinales[i] + "\n");
            if (!aprobado) {
                resultados.append("Necesita al menos " + notaRequerida + " para aprobar la materia.\n");
            } else {
                resultados.append("¡Ha aprobado la materia!\n");
            }
            resultados.append("\n");
        }

        JOptionPane.showMessageDialog(null, resultados.toString());
    }

    //Funcion que usamos para leer las notas y controlar el ingreso de los datos
    public static double leerNota(String mensaje) {
        double nota = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                nota = Double.parseDouble(input);

                if (nota < 0.0 || nota > 5.0) {
                    throw new IllegalArgumentException("La nota debe estar entre 0.0 y 5.0");
                }

                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese una nota válida entre 0.0 y 5.0.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese una nota válida entre 0.0 y 5.0.");
            }
        }

        return nota;
    }

    //Funcion que calcula cada nota por su porcentaje asignado en el ejercicio
    public static double calcularNotaFinal(double parcial1, double parcial2, double seguimiento, double coevaluacion) {
        // Los porcentajes dados son: 20%, 20%, 30%, 10%
        return (parcial1 * 0.2) + (parcial2 * 0.2) + (seguimiento * 0.3) + (coevaluacion * 0.1);
    }
}
