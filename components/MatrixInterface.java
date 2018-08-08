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

import java.util.Iterator;

public interface MatrixInterface<E> extends Iterable<E>{

  public void populateMatrix(int row, int col, E input);

  public E get(int row, int col);
  
  public int getNumRows();
  
  public int getNumCols();

  public String toString();
  
  public Iterator<E> iterator();

}
