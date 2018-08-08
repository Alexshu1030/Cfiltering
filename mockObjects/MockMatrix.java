package mockObjects;

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

}
