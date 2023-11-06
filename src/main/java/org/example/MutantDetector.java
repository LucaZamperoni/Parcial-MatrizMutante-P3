package org.example;

public class MutantDetector {
    private static final int SEQUENCE_LENGTH = 4; // Longitud de la secuencia de ADN a buscar.

    public boolean isMutant(String[] dna) {
        // Verifico si la cadena de ADN es válida (si contiene ATCG y no es nula).
        if (isValid(dna)) {
            // Contador para la cantidad de secuencias mutante.
            int count = 0;
            // Recorre cada fila de la matriz de ADN.
            for (int i = 0; i < dna.length; i++) {
                // Verifica secuencias mutantes en las direcciones vertical, horizontal, diagonal e inversa diagonal.
                for (int j = 0; j < dna[i].length(); j++) {
                    if (i + SEQUENCE_LENGTH <= dna.length && checkVertical(dna, i, j)) {
                        count++;
                    }
                    if (j + SEQUENCE_LENGTH <= dna[i].length() && checkHorizontal(dna, i, j)) {
                        count++;
                    }
                    if (i + SEQUENCE_LENGTH <= dna.length && j + SEQUENCE_LENGTH <= dna[i].length() && checkDiagonal(dna, i, j)) {
                        count++;
                    }
                    if (i - SEQUENCE_LENGTH >= -1 && j + SEQUENCE_LENGTH <= dna[i].length() && checkInverseDiagonal(dna, i, j)) {
                        count++;
                    }
                    // Si se encuentran más de una secuencia mutante, retorna verdadero.
                    if (count > 1) {
                        return true;
                    }
                }
            }
            // Si no se encontraron secuencias mutantes, retorna falso.
            return false;
        }
        // Si la cadena de ADN no es válida, retorna falso.
        return false;
    }

    public boolean checkVertical(String[] dna, int row, int col) {
        // Verifica secuencias mutantes en dirección vertical.
        char base = dna[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (dna[row + i].charAt(col) != base) {
                return false;
            }
        }
        return true;
    }

    public boolean checkHorizontal(String[] dna, int row, int col) {
        // Verifica secuencias mutantes en dirección horizontal.
        char base = dna[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (dna[row].charAt(col + i) != base) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal(String[] dna, int row, int col) {
        // Verifica secuencias mutantes en dirección diagonal.
        char base = dna[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (dna[row + i].charAt(col + i) != base) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInverseDiagonal(String[] dna, int row, int col) {
        // Verifica secuencias mutantes en dirección inversa diagonal.
        char base = dna[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (dna[row - i].charAt(col + i) != base) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(String[] dna) {
        if (dna == null) {
            System.out.println("La cadena de ADN es nula.");
            return false;
        } else if (dna.length == 0) {
            System.out.println("La cadena de ADN está vacía.");
            return false;
        } else {
            for (String s : dna) {
                if (s.equals("")) {
                    // Verifica que los caracteres de la cadena de ADN no estén vacíos.
                    System.out.println("La cadena de ADN tiene una fila vacía.");
                    return false;
                }
                for (Character c : s.toCharArray()) {
                    if (!"ATCG".contains(c.toString())) {
                        // Verifica que los caracteres de la cadena de ADN sean A, T, C o G.
                        System.out.println("La cadena de ADN es inválida.");
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
