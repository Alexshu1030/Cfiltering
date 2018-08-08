// **********************************************************
// Assignment3:
// UTORID: tanuanje
// UT Student #: 1003939982
// Author: Jeremy Tanuanå
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences. In this semester
// we will select any three of your assignments from total of 5 and run it
// for plagiarism check.
// *********************************************************
package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import components.Matrix;
import components.UserUserMatrix;

public class UserUserMatrixTest<E> {
  
  private Matrix<E> matrix;
  
  @Before
  public void setUp() {
  matrix = new UserUserMatrix<E>(4);  
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
    Object expected = 4;
    E actual = (E)(Object) matrix.getNumRows();
    assertEquals(expected, actual);
  }
  
  @Test
  public void getNumColsTest() {
    Object expected = 4;
    E actual = (E)(Object) matrix.getNumCols();
    assertEquals(expected, actual);
  }
  
  @Test (expected = ArrayIndexOutOfBoundsException.class)
  public void IOOBConstructorTest() {
    Matrix<E> matrix1 = new Matrix<E>(-3, -1);
  }
  
  @Test (expected = ArrayIndexOutOfBoundsException.class)
  public void IOOBPopulateTest() {
    Matrix<E> matrix1 = new Matrix<E>(3, 3);
    matrix1.populateMatrix(-2, -1, (E)"power");
  }
  
  @Test (expected = ArrayIndexOutOfBoundsException.class)
  public void IOOBGetTest() {
    Matrix<E> matrix1 = new Matrix<E>(3, 3);
    matrix1.get(7, 99);
  }

}