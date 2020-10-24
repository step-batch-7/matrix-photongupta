package com.step.matrix;

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

  public Matrix add(Matrix other) {
    if (!this.haveSameDimensions(other)) return null;

    Matrix result = new Matrix(rows, columns);
    for (int row = 0; row < this.rows; row++) {
      for (int col = 0; col < this.columns; col++) {
        int sum = this.getElement(row, col) + other.getElement(row, col);
        result.setElement(row, col, sum);
      }
    }
    return result;
  }

  public Matrix subtract(Matrix other) {
    if (!this.haveSameDimensions(other)) return null;

    Matrix result = new Matrix(rows, columns);
    for (int row = 0; row < this.rows; row++) {
      for (int col = 0; col < this.columns; col++) {
        int diff = this.getElement(row, col) - other.getElement(row, col);
        result.setElement(row, col, diff);
      }
    }
    return result;
  }

  public Matrix multiply(Matrix other) {
    if (this.columns != other.rows) return null;

    Matrix result = new Matrix(rows, other.columns);
    for (int row1 = 0; row1 < this.rows; row1++) {
      for (int col2 = 0; col2 < other.columns; col2++) {
        int sum = 0;
        for (int row2 = 0; row2 < other.rows; row2++) {
          sum += this.getElement(row1, row2) * other.getElement(row2, col2);
        }
        result.setElement(row1, col2, sum);
      }
    }
    return result;
  }

  public int determinant() {
    if (this.rows == 1) {
      return this.getElement(0, 0);
    }

    if (this.rows == 2) {
      return this.determinantOf2x2Matrix();
    }

    int determinant = 0;
    int sign = 1;

    for (int col = 0; col < this.columns; col++) {
      Matrix subMatrix = createSubMatrix(col);
      int coefficient = sign * this.getElement(0, col);
      determinant += coefficient * subMatrix.determinant();
      sign = -sign;
    }

    return determinant;
  }

  private int getElement(int row, int col) {
    return this.matrix[row][col];
  }

  private int setElement(int row, int col, int num) {
    return this.matrix[row][col] = num;
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

  private int determinantOf2x2Matrix() {
    return (
      (this.getElement(0, 0) * this.getElement(1, 1)) -
      (this.getElement(0, 1) * this.getElement(1, 0))
    );
  }

  private boolean haveSameDimensions(Matrix other) {
    return this.rows == other.rows && this.columns == other.columns;
  }

  private boolean isDeepStrictlyEqual(Matrix other) {
    for (int row = 0; row < this.rows; row++) {
      for (int col = 0; col < this.columns; col++) {
        if (this.getElement(row, col) != m.getElement(row, col)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (!(other instanceof Matrix)) return false;

    Matrix m = (Matrix) other;
    if (!this.haveSameDimensions(m)) return false;

    return this.isDeepStrictlyEqual(other);
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
}
