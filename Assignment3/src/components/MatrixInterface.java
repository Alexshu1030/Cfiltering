package components;

public interface MatrixInterface<E> {
  
  public void construct(int row, int col);
  public void populateMatrix(int row, int col, E input);
  public int get(int row, int col);
  public String toString();

}