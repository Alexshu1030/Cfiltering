package components;

public class Matrix<E> implements MatrixInterface<E>{

  protected E[][] content;

  public void construct(int row, int col) {
    // TODO Auto-generated method stub
    
  }

  public void populateMatrix(int row, int col, E input) {
    content[row][col] = input;
  }

  public int get(int row, int col) {
    // TODO Auto-generated method stub
    return 0;
  }
  
  @Override
  public String toString() {
    return "";
  }

}