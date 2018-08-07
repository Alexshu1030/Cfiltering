package mockObjects;

public class MockUserUserMatrix<E> extends MockMatrix<E>{

  public MockUserUserMatrix(int row) {
    content = (E[][]) new Object[row][row];
  }
  
  @Override
  public E get(int row, int col) throws ArrayIndexOutOfBoundsException {
    if (row >= 0 && row < 9 && col >= 0 && col < 9) {
      return (E)(Object) "1.0000";
    } else throw new ArrayIndexOutOfBoundsException();
  }

}
