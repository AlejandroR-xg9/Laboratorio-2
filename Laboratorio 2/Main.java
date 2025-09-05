import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        TableroVolteado tableroVolteado = new TableroVolteado();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Juego de Memoria");
        tablero.sortearTablero();

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
            // Si se seleccionaron dos celdas, pausar para mostrar el resultado
            if (input.equalsIgnoreCase("E") && tableroVolteado.estaEsperandoComparacion()) {
                System.out.println("Presiona Enter para continuar...");
                scanner.nextLine();
                tableroVolteado.compararYResetear(tablero);
                System.out.println(tableroVolteado.toString());
            }
        }

        scanner.close();
    }

}