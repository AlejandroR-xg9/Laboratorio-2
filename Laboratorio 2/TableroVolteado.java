public class TableroVolteado {
    private String[][] tablero = {
        {"[ ]", "[ ]", "[ ]", "[ ]"},
        {"[ ]", "[ ]", "[ ]", "[ ]"},
        {"[ ]", "[ ]", "[ ]", "[ ]"},
        {"[ ]", "[ ]", "[ ]", "[ ]"}
    };
    private String Cursor = "[X]";
    private String Vacío = "[ ]";
        private int cursorX = 0;
        private int cursorY = 0;
        // Para guardar las dos selecciones
        private int sel1X = -1, sel1Y = -1;
        private int sel2X = -1, sel2Y = -1;
        private boolean esperandoComparacion = false;

    public TableroVolteado() {
        tablero[cursorX][cursorY] = Cursor;
    }

    public void mover(String direccion, Tablero tableroOriginal){
        tablero[cursorX][cursorY] = Vacío;
        String dir = direccion.toUpperCase();
            tablero[cursorX][cursorY] = Vacío;
            switch (dir) {
                case "W":
                    if (cursorX > 0) cursorX--;
                    break;
                case "S":
                    if (cursorX < tablero.length - 1) cursorX++;
                    break;
                case "A":
                    if (cursorY > 0) cursorY--;
                    break;
                case "D":
                    if (cursorY < tablero[0].length - 1) cursorY++;
                    break;
                case "E":
                    seleccionar(tableroOriginal);
                    return;
                default:
                    System.out.println("Dirección no válida");
            }
            tablero[cursorX][cursorY] = Cursor;
        }


        private void seleccionar(Tablero tableroOriginal) {
            if (sel1X == -1 && sel1Y == -1) {
                // Primera selección
                sel1X = cursorX;
                sel1Y = cursorY;
                tablero[cursorX][cursorY] = tableroOriginal.getTablero()[cursorX][cursorY];
            } else if ((sel1X != cursorX || sel1Y != cursorY) && sel2X == -1 && sel2Y == -1) {
                // Segunda selección
                sel2X = cursorX;
                sel2Y = cursorY;
                tablero[cursorX][cursorY] = tableroOriginal.getTablero()[cursorX][cursorY];
                esperandoComparacion = true;
            }
        }

    public void compararYResetear(Tablero tableroOriginal) {
        String v1 = tableroOriginal.getTablero()[sel1X][sel1Y];
        String v2 = tableroOriginal.getTablero()[sel2X][sel2Y];
        if (!v1.equals(v2)) {
            // Si no son iguales, ocultar ambos
            tablero[sel1X][sel1Y] = Vacío;
            tablero[sel2X][sel2Y] = Vacío;
        }
        // Resetear selección
        sel1X = sel1Y = sel2X = sel2Y = -1;
        esperandoComparacion = false;
    }

    public boolean estaEsperandoComparacion() {
        return esperandoComparacion;
    }

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
}
