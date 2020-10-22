package com.step.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldValidateTwoMatrixHavingSameElements() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertTrue(
      "should validate for matrices having same element",
      matrix1.equals(matrix2)
    );
  }

  @Test
  public void shouldNotValidateTwoMatrixHavingDifferentElements() {
    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 4, 2 }, { 9, 5 }, { 7, 8 } };
    Matrix matrix2 = Matrix.create(sample2);

    assertFalse(
      "should not validate for matrices having different element",
      matrix1.equals(matrix2)
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
  public void shouldAddTwoMatrixOfSameDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix sum = matrix1.add(matrix2);

    int[][] expectedData = { { 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals("should add two matrix of same dimension", sum, expected);
  }

  @Test
  public void shouldNodAddTwoMatrixOfDifferentDimensions() {
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix sum = matrix1.add(matrix2);
    assertNull("should not add if two matrix have different dimension", sum);
  }
}
