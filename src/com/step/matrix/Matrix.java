package com.step.matrix;

import com.step.exception.UnequalMatricesDimensionException;

public class Matrix {
  private int[][] matrix;
  private int rows;
  private int columns;

  public Matrix(int numOfRows, int numOfCols) {
    this.rows = numOfRows;
    this.columns = numOfCols;
    this.matrix = new int[numOfRows][numOfCols];
  }

  public static Matrix create(int[][] array) {
    int numOfRows = array.length;
    int numOfCols = array[0].length;
    Matrix m = new Matrix(numOfRows, numOfCols);
    for (int rowIndex = 0; rowIndex < numOfRows; rowIndex++) {
      if (array[rowIndex].length != numOfCols) return null;
      System.arraycopy(array[rowIndex], 0, m.matrix[rowIndex], 0, numOfCols);
    }
    return m;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        sb.append(this.getElement(row, col)).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  private boolean haveSameDimensions(Matrix other) {
    return this.rows == other.rows && this.columns == other.columns;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (!(other instanceof Matrix)) return false;

    Matrix m = (Matrix) other;
    if (!haveSameDimensions(m)) return false;
    for (int row = 0; row < this.rows; row++) {
      for (int col = 0; col < this.columns; col++) {
        if (this.getElement(row, col) != m.getElement(row, col)) return false;
      }
    }
    return true;
  }

  private int getElement(int row, int col) {
    return this.matrix[row][col];
  }

  private int setElement(int row, int col, int num) {
    return this.matrix[row][col] = num;
  }

  public Matrix add(Matrix other) throws UnequalMatricesDimensionException {
    if (!this.haveSameDimensions(other)) {
      throw new UnequalMatricesDimensionException(
        "Matrices of different dimensions"
      );
    }
    Matrix result = new Matrix(rows, columns);
    for (int rowId = 0; rowId < this.rows; rowId++) {
      for (int colId = 0; colId < this.columns; colId++) {
        int sum =
          this.getElement(rowId, colId) + other.getElement(rowId, colId);
        result.setElement(rowId, colId, sum);
      }
    }
    return result;
  }

  public Matrix subtract(Matrix other) {
    if (!this.haveSameDimensions(other)) return null;
    Matrix result = new Matrix(rows, columns);
    for (int rowId = 0; rowId < this.rows; rowId++) {
      for (int colId = 0; colId < this.columns; colId++) {
        int diff =
          this.getElement(rowId, colId) - other.getElement(rowId, colId);
        result.setElement(rowId, colId, diff);
      }
    }
    return result;
  }

  public Matrix multiply(Matrix other) {
    if (this.columns != other.rows) return null;

    Matrix result = new Matrix(rows, other.columns);

    for (int rowId1 = 0; rowId1 < this.rows; rowId1++) {
      for (int colId2 = 0; colId2 < other.columns; colId2++) {
        int sum = 0;
        for (int rowId2 = 0; rowId2 < other.rows; rowId2++) {
          sum +=
            this.getElement(rowId1, rowId2) * other.getElement(rowId2, colId2);
        }
        result.setElement(rowId1, colId2, sum);
      }
    }
    return result;
  }

  private Matrix createSubMatrix(int columnNumber) {
    Matrix subMatrix = new Matrix(rows - 1, columns - 1);
    for (int i = 1; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++) {
        int row = i - 1;
        int col = j > columnNumber ? j - 1 : j;
        if (j != columnNumber) {
          subMatrix.setElement(row, col, this.getElement(i, j));
        }
      }
    }
    return subMatrix;
  }

  public int determinant() {
    if (this.rows == 1) {
      return this.getElement(0, 0);
    }

    if (this.rows == 2) {
      return (
        (this.getElement(0, 0) * this.getElement(1, 1)) -
        (this.getElement(0, 1) * this.getElement(1, 0))
      );
    }

    int determinant = 0;
    int sign = 1;

    for (int col = 0; col < columns; col++) {
      Matrix subMatrix = createSubMatrix(col);
      int coefficient = sign * this.getElement(0, col);
      determinant += coefficient * subMatrix.determinant();
      sign = -sign;
    }

    return determinant;
  }
}
