// Hilo que suma los números que le corresponden (pares o impares) en la SumaAcumulada
// compartida. SumaAcumulada se encarga de que no se pierdan sumas
public class HiloCalculador implements Runnable {

    // Datos del hilo, la SumaAcumulada compartida, donde empieza, donde acaba y si suma pares o impares
    private SumaAcumulada acumulador;
    private int inicio;
    private int fin;
    private boolean procesarPares;

    // Constructor de la clase HiloCalculador, rellena los datos del hilo con lo que le pasa el Calculador al crearlo
    public HiloCalculador(SumaAcumulada acumulador, int inicio, int fin, boolean procesarPares) {
        this.acumulador = acumulador;
        this.inicio = inicio;
        this.fin = fin;
        this.procesarPares = procesarPares;
    }


    @Override
    public void run() {
        // Recorre todos los números de la horquilla (de inicio a fin)
        for (int numero = inicio; numero <= fin; numero ++) {
            // Si el número es de los que le tocan a este hilo (par o impar según procesarPares), lo suma en la SumaAcumulada
            if ((numero % 2 == 0) == procesarPares) {
                acumulador.incrementar(numero);
            }
        }

    }
}
