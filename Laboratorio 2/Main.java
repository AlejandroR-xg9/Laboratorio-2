import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        TableroVolteado tableroVolteado = new TableroVolteado();
        Jugadores jugador1 = new Jugadores("Jugador 1");
        Jugadores jugador2 = new Jugadores("Jugador 2");
        Scanner scanner = new Scanner(System.in);


        System.out.println("Juego de Memoria");
        tablero.sortearTablero();

        jugador1.setPuntaje(0);
        jugador2.setPuntaje(0);

        System.out.println("Escribe tu nombre jugador 1:");
        String nombre1 = scanner.nextLine();
        jugador1 = new Jugadores(nombre1);
        System.out.println("Escribe tu nombre jugador 2:");
        String nombre2 = scanner.nextLine();
        jugador2 = new Jugadores(nombre2);

        System.out.println("Tablero:");
        System.out.println(tableroVolteado.toString());
        System.out.print("Ingrese dirección (WASD), 'E' para seleccionar o 'salir' para terminar: ");

        int menu = 0;
        while (menu == 0) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("salir")) {
                break;
            }
            tableroVolteado.mover(input, tablero);
            System.out.println(tableroVolteado.toString());
            // Solo comparar y resetear si ya hay dos seleccionadas
            if (input.equalsIgnoreCase("E")) {
                System.out.println(tableroVolteado.toString());
            }
        }
        scanner.close();
    }

}