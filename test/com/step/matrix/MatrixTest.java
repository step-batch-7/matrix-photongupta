package com.step.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {


    @Test
    public void shouldCreateMatrixInstance() {
        Matrix matrix1 = matrix2x2(1, 2, 4, 5);
        assertEquals(true, matrix1 instanceof Matrix);
    }

    @Test
    public void shouldNotCreateMatrixInstanceFromWrongArray() {
        Matrix matrix1 = Matrix.create(new int[][]{{1, 2}, {3, 4}, {5}});
        assertEquals(null, matrix1);
    }

    @Test
    public void shouldEquateTwoMatricesHavingSameElements() {
        Matrix matrix1 = matrix2x2(1, 2, 4, 5);

        Matrix matrix2 = matrix2x2(1, 2, 4, 5);
        assertEquals(matrix1, matrix2);
    }

    @Test
    public void shouldNotEquateTwoMatricesHavingDifferentElements() {
        Matrix matrix1 = matrix2x2(1, 2, 4, 5);
        Matrix matrix2 = matrix2x2(4, 2, 9, 5);
        assertNotEquals(matrix1, matrix2);
    }

    @Test
    public void shouldNotEquateTwoMatricesWithDifferentDimensions() {
        Matrix matrix1 = matrix3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix matrix2 = matrix2x2(4, 1, 9, 4);
        assertNotEquals(matrix1, matrix2);
    }

    @Test
    public void shouldNotEquateMatrixWithOtherObject() {
        Matrix matrix1 = matrix2x2(1, 2, 4, 5);
        assertNotEquals(matrix1, new Object());
    }

    @Test
    public void shouldGiveTextualRepresentation() {
        Matrix matrix1 = matrix2x2(1, 2, 4, 5);
        assertEquals("1 2 \n4 5 \n", matrix1.toString());
    }

    @Test
    public void shouldAddTwoMatricesOfSameDimensions() {
        Matrix matrix1 = matrix3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix matrix2 = matrix3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix expected = matrix3x3(2, 4, 6, 8, 10, 12, 14, 16, 18);
        assertEquals(expected, matrix1.add(matrix2));
    }

    @Test
    public void shouldNotAddTwoMatricesOfDifferentDimensions() {
        Matrix matrix1 = matrix3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix matrix2 = matrix2x2(1, 2, 4, 5);
        assertEquals(null, matrix1.add(matrix2));
    }

    @Test
    public void shouldSubtractTwoMatricesOfSameDimensions() {
        Matrix matrix1 = matrix3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix matrix2 = matrix3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix expected = matrix3x3(0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(expected, matrix1.subtract(matrix2));
    }

    @Test
    public void shouldNotSubtractTwoMatricesOfDifferentDimensions() {
        Matrix matrix1 = matrix3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix matrix2 = matrix2x2(1, 2, 4, 5);
        assertEquals(null, matrix1.subtract(matrix2));
    }

    @Test
    public void shouldMultiplyTwoMatrices() {
        Matrix matrix1 = matrix2x2(1, 2, 4, 5);
        Matrix matrix2 = matrix2x2(1, 2, 4, 5);
        Matrix expected = matrix2x2(9, 12, 24, 33);
        assertEquals(expected, matrix1.multiply(matrix2));
    }

    @Test
    public void shouldNotMultiplyTwoMatricesWithWrongDimensions() {
        Matrix matrix1 = matrix2x2(1, 2, 4, 5);
        Matrix matrix2 = matrix1x2(1, 2);
        assertEquals(null, matrix1.multiply(matrix2));
    }

    @Test
    public void shouldCalculateDeterminantOf2x2Matrix() {
        Matrix matrix = matrix2x2(1, 2, 4, 5);
        assertEquals(-3, matrix.determinant());
    }

    @Test
    public void shouldCalculateDeterminantOfNxNMatrix() {
        Matrix matrix = matrix3x3(4, 3, 2, 0, 1, -3, 0, -1, 3);
        assertEquals(0, matrix.determinant());
    }

    private Matrix matrix1x2(int a, int b) {
        return Matrix.create(new int[][]{{a, b}});
    }

    private Matrix matrix2x2(int a, int b, int c, int d) {
        return Matrix.create(new int[][]{{a, b}, {c, d}});
    }

    private Matrix matrix3x3(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        return Matrix.create(new int[][]{{a, b, c}, {d, e, f}, {g, h, i}});
    }

}
