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
package mockObjects;

import java.util.Iterator;
import components.MatrixInterface;

public class MockMatrix<E> implements MatrixInterface<E> {

  protected E content[][];
  protected int numOfRows;
  protected int numOfCols;
  
  public MockMatrix() {
  }

  public MockMatrix(int row, int col) throws ArrayIndexOutOfBoundsException{
    if (row > 0 && col > 0)
      content = (E[][]) new Object[row][col];
    else throw new ArrayIndexOutOfBoundsException();
  }

  @Override
  public void populateMatrix(int row, int col, E input) throws ArrayIndexOutOfBoundsException {
    if (row > 9 || row < 0 || col > 9 || col < 0)
      throw new ArrayIndexOutOfBoundsException();
  }

  public E get(int row, int col) throws ArrayIndexOutOfBoundsException {
    if (row >= 0 && row < 9 && col >= 0 && col < 9) {
      return content[row][col];
    } else throw new ArrayIndexOutOfBoundsException();
  }

  @Override
  public int getNumRows() {
    return 4;
  }

  @Override
  public int getNumCols() {
    return 5;
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

}
