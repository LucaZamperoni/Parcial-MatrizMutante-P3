package org.example;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MutantDetectorTest {

    static MutantDetector detector;

    @BeforeClass
    public static void beforeClass() {
        detector = new MutantDetector();
    }

    @Test
    public void isMutant() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(detector.isMutant(dna));
    }

    @Test
    public void testIsMutantHorizontal() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAAA",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(detector.isMutant(dna));
    }

    @Test
    public void testIsMutantVertical() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(detector.isMutant(dna));
    }

    @Test
    public void testIsMutantDiagonal() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(detector.isMutant(dna));
    }

    @Test
    public void testIsMutantInverseDiagonal() {
        String[] dna = {
                "ATGCGA",
                "CGGTGC",
                "TTATCT",
                "AGACCG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(detector.isMutant(dna));
    }

    @Test
    public void testIsNotMutant() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGACGG",
                "GACCTA",
                "TCACTG"
        };
        assertFalse(detector.isMutant(dna));
    }

    @Test
    public void testEmptyDNA() {
        String[] dna = {};
        assertFalse(detector.isMutant(dna));
    }

    @Test
    public void testSmallDNA() {
        String[] dna = {
                "ATG",
                "CAG",
                "TTA"
        };
        assertFalse(detector.isMutant(dna));
    }

    @Test
    public void testNullDNA() {
        String[] dna = null;
        assertFalse(detector.isMutant(dna));
    }

    @Test
    public void checkVertical() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(detector.checkVertical(dna, 0, 4));
    }

    @Test
    public void checkHorizontal() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAAA",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(detector.checkHorizontal(dna, 3, 2));
    }

    @Test
    public void checkDiagonal() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(detector.checkDiagonal(dna, 0, 0));
    }

    @Test
    public void checkInverseDiagonal() {
        String[] dna = {
                "ATGCGA",
                "CGGTGC",
                "TTATCT",
                "AGACCG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(detector.checkInverseDiagonal(dna, 5, 1));
    }

    @Test
    public void testIsValidWithValidDNA() {
        MutantDetector detector = new MutantDetector();
        String[] validDNA = {
                "ATCG",
                "TAGC",
                "GCTA",
                "CGAT"
        };
        assertTrue(detector.isValid(validDNA));
    }

    @Test
    public void testIsValidWithInvalidCharacter() {
        String[] invalidDNA = {
                "ATCX",
                "TAGC",
                "GCTA",
                "CGAT"
        };
        assertFalse(detector.isValid(invalidDNA));
    }

    @Test
    public void testIsValidWithNullDNA() {
        String[] nullDNA = null;
        assertFalse(detector.isValid(nullDNA));
    }

    @Test
    public void testIsValidWithEmptyDNA() {
        String[] emptyDNA = {};
        assertFalse(detector.isValid(emptyDNA));
    }

    @Test
    public void testIsValidWithEmptyRows() {
        String[] emptyRowsDNA = {
                "",
                "",
                ""
        };
        assertFalse(detector.isValid(emptyRowsDNA));
    }
}