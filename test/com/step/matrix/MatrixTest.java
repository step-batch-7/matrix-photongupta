package com.step.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldCreateMatrixInstance() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    assertEquals(true, matrix1 instanceof Matrix);
  }

  @Test
  public void shouldNotCreateMatrixInstanceFromWrongArray() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8, 7 } };
    Matrix matrix1 = Matrix.create(sample1);

    assertEquals(null, matrix1);
  }

  @Test
  public void shouldEquateTwoMatricesHavingSameElements() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertEquals(matrix1, matrix2);
  }

  @Test
  public void shouldNotEquateTwoMatricesHavingDifferentElements() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 4, 2 }, { 9, 5 }, { 7, 8 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertNotEquals(matrix1, matrix2);
  }

  @Test
  public void shouldNotEquateTwoMatricesWithDifferentDimensions() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 4 }, { 9 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertNotEquals(matrix1, matrix2);
  }

  @Test
  public void shouldNotEquateMatrixWithOtherObject() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    assertNotEquals(matrix1, new Object());
  }

  @Test
  public void shouldGiveTextualRepresentation() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix1 = Matrix.create(sample1);

    assertEquals("1 2 \n4 5 \n", matrix1.toString());
  }

  @Test
  public void shouldAddTwoMatricesOfSameDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix2 = Matrix.create(sample2);

    int[][] expectedData = { { 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals(expected, matrix1.add(matrix2));
  }

  @Test
  public void shouldNodAddTwoMatricesOfDifferentDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertEquals(null, matrix1.add(matrix2));
  }

  @Test
  public void shouldSubtractTwoMatricesOfSameDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix2 = Matrix.create(sample2);

    int[][] expectedData = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals(expected, matrix1.subtract(matrix2));
  }

  @Test
  public void shouldNotSubtractTwoMatricesOfDifferentDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertEquals(null, matrix1.subtract(matrix2));
  }

  @Test
  public void shouldMultiplyTwoMatrices() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix2 = Matrix.create(sample2);

    int[][] expectedData = { { 9, 12 }, { 24, 33 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals(expected, matrix1.multiply(matrix2));
  }

  @Test
  public void shouldNotMultiplyTwoMatricesWithWrongDimensions() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertEquals(null, matrix1.multiply(matrix2));
  }

  @Test
  public void shouldCalculateDeterminantOf2x2Matrix() {
    int[][] sample = { { 1, 2 }, { 4, 5 } };
    Matrix matrix = Matrix.create(sample);
    assertEquals(-3, matrix.determinant());
  }

  @Test
  public void shouldCalculateDeterminantOfNxNMatrix() {
    int[][] sample = {
      { 4, 3, 2, 2 },
      { 0, 1, -3, 3 },
      { 0, -1, 3, 3 },
      { 0, 3, 1, 1 },
    };
    Matrix matrix = Matrix.create(sample);
    assertEquals(-240, matrix.determinant());
  }
}
