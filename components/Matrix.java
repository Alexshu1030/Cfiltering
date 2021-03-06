// **********************************************************
// Assignment3:
// UTORID: tanuanje
// UT Student #: 1003939982
// Author: Jeremy Tanuan
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
package components;

import java.util.Iterator;
import java.util.Stack;

public class Matrix<E> implements MatrixInterface<E>, Iterable<E> {

  protected E[][] content;
  protected int numOfRows;
  protected int numOfCols;

  public Matrix() {
    this.content = (E[][]) new Object[0][0];
    this.numOfRows = 0;
    this.numOfCols = 0;
  }

  public Matrix(int row, int col) throws ArrayIndexOutOfBoundsException{
    if (row > 0 && col > 0) {
      this.content = (E[][]) new Object[row][col];
      this.numOfRows = row;
      this.numOfCols = col;
    } else throw new ArrayIndexOutOfBoundsException();
  }

  public void populateMatrix(int row, int col, E input) throws ArrayIndexOutOfBoundsException{
    if (row < numOfRows && col < numOfCols &&
        row >= 0 && col >= 0)
      content[row][col] = input;
    else throw new ArrayIndexOutOfBoundsException();
  }

  public E get(int row, int col) throws ArrayIndexOutOfBoundsException{
    if (row < numOfRows && col < numOfCols &&
        row >= 0 && col >= 0)
      return content[row][col];
    else throw new ArrayIndexOutOfBoundsException();
  }

  public int getNumRows() {
    return numOfRows;
  }

  public int getNumCols() {
    return numOfCols;
  }

  @Override
  public String toString() {
    return "";
  }

  private static class MatrixIterator<E> implements Iterator<E> {
    Stack<E> data;

    public MatrixIterator(Matrix<E> matrix) {
      data = new Stack<>();
      for (int i = 0; i < matrix.getNumRows(); i++) {
        data.push(null);
        for (int j = 0; j < matrix.getNumCols(); j++) {
          data.push(matrix.get(i, j));
        }
      }
    }

    @Override
    public boolean hasNext() {
      return !(data.isEmpty());
    }

    @Override
    public E next() {
      if (hasNext()) {
        E ret = data.pop();
        return ret;
      }
      return null;
    }
  }

  @Override
  public Iterator<E> iterator() {
    return new MatrixIterator<E>(this);
  }

}
