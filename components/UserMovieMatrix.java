package components;

public class UserMovieMatrix<E> extends Matrix<E> implements MatrixInterface<E>{

  @Override
  public void populateMatrix(int row, int col, E input) {
    content[row][col] = input;
  }
  
}
