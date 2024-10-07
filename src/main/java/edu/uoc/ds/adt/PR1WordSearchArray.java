package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.SetLinkedListImpl;
import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;
import edu.uoc.ds.traversal.Iterator;

public class PR1WordSearchArray {

    private final String sequence;  // La secuencia de caracteres con las filas concatenadas
    private final int rows;         // Número de filas en la sopa de letras
    private final int cols;         // Número de columnas en cada fila

    // Constructor que recibe la secuencia de caracteres y calcula el tamaño de la sopa
    public PR1WordSearchArray(String sequence, int rows, int cols) {
        this.sequence = sequence;
        this.rows = rows;
        this.cols = cols;
    }

    // Metodo de búsqueda de palabras
    public Stack<Result> search(SetLinkedListImpl<String> words) {
        Stack<Result> results = new StackArrayImpl<>(words.size()); // Almacena los resultados
        Iterator<String> it = words.values();

        while (it.hasNext()) {
            String word = it.next();
            // Si la palabra se encuentra en alguna dirección, no seguimos buscando más
            if (searchWord(word, results, Direction.HORIZONTAL) || searchWord(word, results, Direction.VERTICAL)) {
                // Al encontrar la palabra, pasamos a la siguiente iteración automáticamente
                continue;
            }
        }
        return results;
    }

    // Búsqueda general para una dirección dada (horizontal o vertical)
    private boolean searchWord(String word, Stack<Result> results, Direction direction) {
        if (direction == Direction.HORIZONTAL) {
            // Direccion HORIZONTAL
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c <= cols - word.length(); c++) {
                    if (matchesWord(word, r, c, Direction.HORIZONTAL)) {
                        results.push(new Result(word, r, c, Direction.HORIZONTAL));
                        return true;
                    }
                }
            }
        } else {
            // Direccion VERTICAL
            for (int c = 0; c < cols; c++) {
                for (int r = 0; r <= rows - word.length(); r++) {
                    if (matchesWord(word, r, c, Direction.VERTICAL)) {
                        results.push(new Result(word, r, c, Direction.VERTICAL));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Verifica si la palabra coincide en una dirección específica
    private boolean matchesWord(String word, int row, int col, Direction direction) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            char charAtPos = (direction == Direction.HORIZONTAL)
                    ? sequence.charAt(row * cols + (col + i))  // Horizontal
                    : sequence.charAt((row + i) * cols + col); // Vertical

            if (letter != charAtPos) {
                return false;
            }
        }
        return true;
    }

    // Clase para almacenar los resultados (palabra, fila, columna, dirección)
    public static class Result {
        public final String word;
        public final int row;
        public final int col;
        public final Direction direction;

        public Result(String word, int row, int col, Direction direction) {
            this.word = word;
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }

    // Enum para las direcciones posibles
    public enum Direction {
        HORIZONTAL,
        VERTICAL
    }
}
