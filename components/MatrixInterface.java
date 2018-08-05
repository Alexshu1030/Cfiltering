package components;

public interface MatrixInterface<E> {
  
  public void populateMatrix(int row, int col, E input);
  public E get(int row, int col);
  public String toString();

}