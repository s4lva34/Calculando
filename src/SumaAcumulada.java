// creo una clase SumaAcumulada donde se guardan las sumas de los hilos,
// la comparten los dos hilos y solo permite a uno entrar y cuando termine entra el otro
public class SumaAcumulada {
    // Atributo privado para que solo se cambie desde los metodos de esta clase
    private int total = 0;

    // creo metodo incrementar con synchronized para que los valores no se pisen a la hora de sumar,
    // incrementamos el total añadiendole valor (int)
    public synchronized void incrementar(int valor) {
        total = total + valor;
    }
    // creo metodo, esta vez si devuelve, devuelve el total ya incrementado
    public int getTotal() {
        return total;
    }

}
