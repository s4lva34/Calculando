import java.io.IOException;

// Esta clase es el proceso padre y lanza al proceso hijo para realizar el calculo (Calculador)
public class Lanzador {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Preparo orden para arrancar el calculador con el rango 1-1000
        ProcessBuilder configuracionHijo = new ProcessBuilder("java", "-cp", "out/production/Calculando", "Calculador", "1", "1000");
        // El hijo hereda la entrada y salida del padre, así su println (la suma) sale en esta misma consola
        configuracionHijo.inheritIO();
        // Entrego la orden, arranca el proceso hijo
        Process procesoHijo = configuracionHijo.start();

        // Esperamos a que el hijo acabe, haciendo que el padre se detenga
        procesoHijo.waitFor();

        // Pregunto al sistema con qué código terminó el hijo
        int codigoSalida = procesoHijo.exitValue();
        // Si salió con 0 fue bien; si no, aviso del fallo y del código
        if (codigoSalida == 0) {
            System.out.println("Proceso " + procesoHijo.pid() + " terminó correctamente");
        } else {
            System.out.println("Falló " + codigoSalida);
        }
    }


}

