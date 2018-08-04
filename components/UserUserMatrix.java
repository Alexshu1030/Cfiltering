package components;

public class UserUserMatrix<E> extends Matrix<E> implements MatrixInterface<E> {

  @Override
  public void populateMatrix(int row, int col, E input) {
    content[row][col] = input;
    content[col][row] = input;
  }
}
