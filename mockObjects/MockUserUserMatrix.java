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
