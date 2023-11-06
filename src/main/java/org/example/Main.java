package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MutantDetector mutantDetector = new MutantDetector();
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        // Me asuguro de transformar toda la secuencia a mayúsculas.
        for (int i = 0; i < dna.length; i++) {
            dna[i] = dna[i].toUpperCase();
        }
        System.out.println(Arrays.toString(dna));
        System.out.println(mutantDetector.isMutant(dna) ? "El sujeto es mutante." : "El sujeto no es mutante.");
    }
}