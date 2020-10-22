package com.step.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void testEquals() {
    System.out.println("\nTesting equals");

    int[][] sample1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
    Matrix matrix2 = Matrix.create(sample2);

    int[][] sample3 = { { 4, 2 }, { 9, 5 }, { 7, 8 } };
    Matrix matrix3 = Matrix.create(sample3);

    assertTrue(
      "should validate for matrices having same element",
      matrix1.equals(matrix2)
    );
    assertFalse(
      "should not validate for matrices having different element",
      matrix1.equals(matrix3)
    );
  }

  @Test
  public void testToString() {
    System.out.println("\nTesting toString");

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
  public void testAdd() {
    System.out.println("\nTesting add");
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix sum = matrix1.add(matrix2);

    int[][] expectedData = { { 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals("should add two matrix of same dimension", sum, expected);

    int[][] sample3 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix3 = Matrix.create(sample3);

    sum = matrix1.add(matrix3);
    assertNull("should not add if two matrix have different dimension", sum);
  }

  @Test
  public void testSubtract() {
    System.out.println("\nTesting subtract");
    int[][] sample1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix difference = matrix1.subtract(matrix2);

    int[][] expectedData = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals(
      "should subtract second matrix from the first matrix if both have same dimension",
      difference,
      expected
    );

    int[][] sample3 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix3 = Matrix.create(sample3);

    difference = matrix1.subtract(matrix3);
    assertNull(
      "should not perform subtraction if two matrix have different dimension",
      difference
    );
  }

  @Test
  public void testMultiply() {
    System.out.println("\nTesting multiply");
    int[][] sample1 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix1 = Matrix.create(sample1);

    int[][] sample2 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix2 = Matrix.create(sample2);

    Matrix product = matrix1.multiply(matrix2);

    int[][] expectedData = { { 9, 12 }, { 24, 33 } };
    Matrix expected = Matrix.create(expectedData);

    assertEquals("should multiply two matrices", product, expected);

    int[][] sample3 = { { 1, 2 } };
    Matrix matrix3 = Matrix.create(sample3);

    product = matrix1.multiply(matrix3);
    assertNull(
      "should not multiply if numbers of rows of first is not equal to the number of columns of the second matrix",
      product
    );
  }

  @Test
  public void testDeterminant() {
    System.out.println("\nTesting determinant");

    int[][] sample1 = { { 1, 2 }, { 4, 5 } };
    Matrix matrix1 = Matrix.create(sample1);
    assertEquals(
      "should give the determinant of given 2X2  matrix",
      -3,
      matrix1.determinant()
    );

    int[][] sample2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    Matrix matrix2 = Matrix.create(sample2);
    assertEquals(
      "should give the determinant of given 3X3 matrix",
      0,
      matrix2.determinant()
    );
    int[][] sample3 = {
      { 4, 3, 2, 2 },
      { 0, 1, -3, 3 },
      { 0, -1, 3, 3 },
      { 0, 3, 1, 1 },
    };
    Matrix matrix3 = Matrix.create(sample3);
    assertEquals(
      "should give the determinant of given nXn matrix",
      -240,
      matrix3.determinant()
    );
  }
}
