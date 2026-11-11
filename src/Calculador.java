// Esta clase es el proceso hijo y recibe los numeros a calcular
public class Calculador {
    public static void main(String[] args) {
        // Si no me han llegado 2 números, aviso y salgo con error
        if (args.length != 2) {
            System.out.println("Uso: Calculador <inicio> <fin>");
            System.exit(1);

        }
        // Convierto el primer y segundo argumento que son un texto en un numero
        int inicio = Integer.parseInt(args[0]);
        int fin = Integer.parseInt(args[1]);
        // Prueba para mostrar el inicio y el fin
        System.out.println("De " + inicio + " a " + fin);
        System.exit(0);

    }
}
