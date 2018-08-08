// **********************************************************
// Assignment3:
// UTORID: tanuanje
// UT Student #: 1003939982
// Author: Jeremy Tanuanå
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences. In this semester
// we will select any three of your assignments from total of 5 and run it
// for plagiarism check.
// *********************************************************
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
    content[1][2] = (E)(Object) 2;
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
  public void populateMatrix(int row, int col, Object input) throws ArrayIndexOutOfBoundsException {
    if (row > 9 || row < 0 || col > 9 || col < 0)
      throw new ArrayIndexOutOfBoundsException();
    else
      content[row][col] = (E)input;
  }

  @Override
  public E get(int row, int col) throws ArrayIndexOutOfBoundsException {
    if (row >= 0 && row < 9 && col >= 0 && col < 9) {
      return content[row][col];
    } else throw new ArrayIndexOutOfBoundsException();
  }
  
}
