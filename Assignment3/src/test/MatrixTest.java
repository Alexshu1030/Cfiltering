package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import components.Matrix;
import components.UserMovieMatrix;

public class MatrixTest<E> {
  
  private Matrix<E> matrix;
  
  @Before
  public void setUp() {
  matrix = new Matrix<E>(3, 4);  
  }
  
  @Test
  public void populateMatrixAndGetTest() {
    Object expected = 7;
    matrix.populateMatrix(0, 0, (E) expected);
    E actual = matrix.get(0, 0);
    assertEquals(expected, actual);
  }
  
  @Test
  public void populateMatrixOverrideAndGetTest() {
    Object expected = 7;
    matrix.populateMatrix(0, 0, (E) "power");
    matrix.populateMatrix(0, 0, (E) expected);
    E actual = matrix.get(0, 0);
    assertEquals(expected, actual);
  }

  @Test
  public void getNumRowsTest() {
    Object expected = 3;
    E actual = (E)(Object) matrix.getNumRows();
    assertEquals(expected, actual);
  }
  
  @Test
  public void getNumColsTest() {
    Object expected = 4;
    E actual = (E)(Object) matrix.getNumCols();
    assertEquals(expected, actual);
  }
  

}