// **********************************************************
// Assignment3:
// UTORID: tanuanje
// UT Student #: 1003939982
// Author: Jeremy Tanuan
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
package components;

public class UserMovieMatrix<E> extends Matrix<E> {

  public UserMovieMatrix() {
    this.content = (E[][]) new Object[0][0];
  }

  public UserMovieMatrix(int row, int col) throws ArrayIndexOutOfBoundsException{
    if (row > 0 && col > 0) {
      this.content = (E[][]) new Object[row][col];
      this.numOfRows = row;
      this.numOfCols = col;
    } else throw new ArrayIndexOutOfBoundsException();
  }

}
