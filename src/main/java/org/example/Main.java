package org.example;

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
        System.out.println(mutantDetector.isMutant(dna) ? "El sujeto es mutante." : "El sujeto no es mutante.");
    }
}