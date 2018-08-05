package components;

public class Matrix<E> implements MatrixInterface<E>{

  protected E[][] content;
  protected int numOfRows;
  protected int numOfCols;
  
  public Matrix() {
	  this.content = (E[][]) new Object[0][0];
  }

  public Matrix(int row, int col) {
    this.content = (E[][]) new Object[row][col];
    this.numOfRows = row;
    this.numOfCols = col;
  }

  public void populateMatrix(int row, int col, E input) {
    content[row][col] = input;
  }

  public E get(int row, int col) { 
    return content[row][col];
  }
  
  @Override
  public String toString() {
    return "";
  }

}