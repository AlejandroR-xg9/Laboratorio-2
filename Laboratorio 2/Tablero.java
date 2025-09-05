import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Tablero {
    private String[] Tamaños = {"Pequeño", "Mediano", "Grande"};

    private String[][] tablero = {
        {"[A]", "[A]", "[B]", "[B]"},
        {"[C]", "[C]", "[D]", "[D]"},
        {"[E]", "[E]", "[F]", "[F]"},
        {"[G]", "[G]", "[H]", "[H]"}
    };

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(int fila, int columna, String valor) {
        this.tablero[fila][columna] = valor;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                sb.append(tablero[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortearTablero() {
        List<String> listaPlana = new ArrayList<>();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                listaPlana.add(tablero[i][j]);
            }
        }
        Collections.shuffle(listaPlana);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = listaPlana.remove(0);
            }
        }
    }

    public String[] getTamaños() {
        return Tamaños;
    }

    public void setTamaños(String[] tamaños) {
        Tamaños = tamaños;
    }

    }
