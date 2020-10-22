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
}
