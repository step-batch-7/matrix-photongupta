package com.step.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldEquateTwoMatricesHavingSameElements() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertTrue(
      "Should equate two matrices having same elements",
      matrix1.equals(matrix2)
    );
  }

  @Test
  public void shouldNotEquateTwoMatricesHavingDifferentElements() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 4, 2 }, { 9, 5 }, { 7, 8 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertFalse(
      "Should not equate two matrices having different elements",
      matrix1.equals(matrix2)
    );
  }

  @Test
  public void shouldNotEquateTwoMatricesWithDifferentDimensions() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 4 }, { 9 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertFalse(
      "Should not equate two matrices having different dimensions",
      matrix1.equals(matrix2)
    );
  }

  @Test
  public void shouldNotEquateMatrixWithOtherObject() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    Object obj = new Object();

    assertFalse(
      "Should not equate matrix with other object",
      matrix1.equals(obj)
    );
  }

  @Test
  public void shouldGiveTextualRepresentation() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix1 = Matrix.create(sample1);

    String actual = matrix1.toString();
    String expected = "1 2 \n4 5 \n";
    assertEquals(
      "Should give textual representation of matrix",
      actual,
      expected
    );
  }

  @Test
  public void shouldAddTwoMatricesOfSameDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix sum = matrix1.add(matrix2);

    int[][] expectedData = { { 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals("Should add two matrix of same dimension", sum, expected);
  }

  @Test
  public void shouldNodAddTwoMatricesOfDifferentDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix sum = matrix1.add(matrix2);
    assertNull("Should not add if two matrix have different dimension", sum);
  }

  @Test
  public void shouldSubtractTwoMatricesOfSameDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix difference = matrix1.subtract(matrix2);

    int[][] expectedData = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals(
      "Should subtract second matrix from the first matrix if both have same dimension",
      difference,
      expected
    );
  }

  @Test
  public void shouldNotSubtractTwoMatricesOfDifferentDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix difference = matrix1.subtract(matrix2);
    assertNull(
      "Should not perform subtraction if two matrix have different dimension",
      difference
    );
  }

  @Test
  public void shouldMultiplyTwoMatrices() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix product = matrix1.multiply(matrix2);

    int[][] expectedData = { { 9, 12 }, { 24, 33 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals("Should multiply two matrices", product, expected);
  }

  @Test
  public void shouldNotMultiplyTwoMatricesWithWrongDimensions() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix product = matrix1.multiply(matrix2);
    assertNull(
      "Should not multiply, if numbers of columns of first is not equal to the number of rows of the second matrix",
      product
    );
  }

  @Test
  public void shouldCalculateDeterminantOf2x2Matrix() {
    int[][] sample = { { 1, 2 }, { 4, 5 } };
    Matrix matrix = Matrix.create(sample);
    assertEquals(
      "Should give the determinant of given 2X2  matrix",
      -3,
      matrix.determinant()
    );
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
    assertEquals(
      "Should give the determinant of given nXn matrix",
      -240,
      matrix.determinant()
    );
  }
}
