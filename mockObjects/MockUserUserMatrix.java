package mockObjects;

public class MockUserUserMatrix<E> extends MockMatrix<E>{

  public MockUserUserMatrix() {
    this.content = (E[][]) new Object[0][0];
  }

  public MockUserUserMatrix(int row) throws ArrayIndexOutOfBoundsException{
    if (row > 0) {
      this.content = (E[][]) new Object[row][row];
      this.numOfRows = row;
      this.numOfCols = row;
    } else throw new ArrayIndexOutOfBoundsException();
  }

  @Override
  public void populateMatrix(int row, int col, E input) throws ArrayIndexOutOfBoundsException{
    if (row < this.numOfRows && col < this.numOfCols &&
        row >= 0 && col >= 0) {
      content[row][col] = input;
      content[col][row] = input;
    } else throw new ArrayIndexOutOfBoundsException();
  }
}
