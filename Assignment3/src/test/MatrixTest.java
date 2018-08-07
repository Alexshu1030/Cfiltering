package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import components.Matrix;

public class MatrixTest<E> {
  
  private Matrix<E> matrix;
  
  @Before
  public void setUp() {
  matrix = new Matrix<E>(3, 3);  
  }
  
  @Test
  public void populateMatrixTest() {
    Object expected = 7;
    matrix.populateMatrix(0, 0, (E) expected);
    E actual = matrix.get(0, 0);
    assertEquals(expected, actual);
  }

}
