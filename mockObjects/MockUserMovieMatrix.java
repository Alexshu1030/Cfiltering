package mockObjects;

public class MockUserMovieMatrix<E> extends MockMatrix<E>{

  public MockUserMovieMatrix(int row, int col) {
    content = (E[][]) new Object[row][col];
    content[0][0] = (E)(Object) 2;
    content[0][1] = (E)(Object) 3;
    content[0][2] = (E)(Object) 4;
    content[0][3] = (E)(Object) 1;
    content[0][4] = (E)(Object) 1;
    content[1][0] = (E)(Object) 5;
    content[1][1] = (E)(Object) 4;
    content[1][2] = (E)(Object) 3;
    content[1][3] = (E)(Object) 5;
    content[1][4] = (E)(Object) 4;
    content[2][0] = (E)(Object) 4;
    content[2][1] = (E)(Object) 5;
    content[2][2] = (E)(Object) 3;
    content[2][3] = (E)(Object) 1;
    content[2][4] = (E)(Object) 3;
    content[3][0] = (E)(Object) 1;
    content[3][1] = (E)(Object) 1;
    content[3][2] = (E)(Object) 1;
    content[3][3] = (E)(Object) 5;
    content[3][4] = (E)(Object) 5;
  }

  @Override
  public E get(int row, int col) throws ArrayIndexOutOfBoundsException {
    if (row >= 0 && row < 9 && col >= 0 && col < 9) {
      return content[row][col];
    } else throw new ArrayIndexOutOfBoundsException();
  }
  
}
