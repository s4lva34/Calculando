// Esta clase es el proceso hijo y recibe los numeros a calcular
public class Calculador {
    public static void main(String[] args) throws InterruptedException {
        // Si no me han llegado 2 números, aviso y salgo con error
        if (args.length != 2) {
            System.out.println("Uso: Calculador <inicio> <fin>");
            System.exit(1);

        }
        // Convierto el primer y segundo argumento que son un texto en un numero
        int inicio = Integer.parseInt(args[0]);
        int fin = Integer.parseInt(args[1]);
        // Creo la libreta donde los dos hilos van a ir sumando sus números, la comparten
        SumaAcumulada sumaCompartida = new SumaAcumulada();
        // preparo la tarea de cada hilo, pares e impares
        HiloCalculador tareasPares = new HiloCalculador(sumaCompartida, inicio, fin, true);
        HiloCalculador tareasImpares = new HiloCalculador(sumaCompartida, inicio, fin, false);
        // asigno cada tarea a su hilo
        Thread hiloPares = new Thread(tareasPares);
        Thread hiloImpares = new Thread(tareasImpares);
        // hago que los hilos empiecen su trabajo y el main espera a que terminen los dos hilos para leer la libreta ya completa
        hiloPares.start();
        hiloImpares.start();
        hiloPares.join();
        hiloImpares.join();
        System.out.println("La suma de " + inicio + " a " + fin + " es " + sumaCompartida.getTotal());
        System.exit(0);

    }
}
