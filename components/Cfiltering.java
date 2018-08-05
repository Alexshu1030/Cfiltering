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
package components;

import java.text.DecimalFormat;

public class Cfiltering<E> {
  // this is a 2d matrix i.e. user*movie
  private Matrix<E> userMovieMatrix;
  // this is a 2d matrix i.e. user*movie
  private Matrix<E> userUserMatrix;

  /**
   * Default Constructor.
   */
  public Cfiltering() {
  }

  /*
   * TODO:COMPLETE THIS I.E. APPROPRIATELY CREATE THE userMovieMatrix AND
   * userUserMatrix WITH CORRECT DIMENSIONS.
   */
  /**
   * Constructs an object which contains two 2d matrices, one of size
   * users*movies which will store integer movie ratings and one of size
   * users*users which will store float similarity scores between pairs of
   * users.
   * 
   * @param numberOfUsers Determines size of matrix variables.
   * @param numberOfMovies Determines size of matrix variables.
   */
  public Cfiltering(int numberOfUsers, int numberOfMovies) {
	  userMovieMatrix = new Matrix<E>(numberOfUsers, numberOfMovies);
	  userUserMatrix = new Matrix<E>(numberOfUsers, numberOfMovies);
  }

  /**
   * The purpose of this method is to populate the UserMovieMatrix. As input
   * parameters it takes in a rowNumber, columnNumber and a rating value. The
   * rating value is then inserted in the UserMovieMatrix at the specified
   * rowNumber and the columnNumber.
   * 
   * @param rowNumber The row number of the userMovieMatrix.
   * @param columnNumber The column number of the userMovieMatrix.
   * @param ratingValue The ratingValue to be inserted in the userMovieMatrix
   */
  public void populateUserMovieMatrix(int row, int col,
      E input) {
    userMovieMatrix.populateMatrix(row, col, input);
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC. Add/remove
   * 
   * @param AND
   * 
   * @return as required below.
   */
  /**
   * Determines how similar each pair of users is based on their ratings. This
   * similarity value is represented with with a float value between 0 and 1,
   * where 1 is perfect/identical similarity. Stores these values in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void calculateSimilarityScore() {
	// instantiate decimal accuracy of 4 decimal places
	    DecimalFormat df = new DecimalFormat("0.0000");
	    float similarityScore = 0;
	    int i;
	    int numOfUsers = userMovieMatrix.numOfRows;
	    int numOfMovies = userMovieMatrix.numOfCols;
	    // compares each user against one another to generate similarity
	    // score
	    for (i = 0; i < numOfUsers; i++) {
	      for (int k = 1 + i; k < numOfUsers; k++) {
	        // this is the total of all ratings given by 
	        // (user1's rating of movie1-user2's rating of movie1)^2 + 
	        // (user1's rating of movie2-user2's rating of movie2)^2 +
	        // and so on...
	        int summation = 0;
	        // get rating of each movie of user1 and user2 and add
	        // to summation
	        for (int j = 0; j <= numOfMovies - 1; j++) {
	          E rating1 = userMovieMatrix.get(i, j);
	          E rating2 = userMovieMatrix.get(k, j);
	          try {
	        	  summation += (int) Math.pow((int)rating1 - (int)rating2, 2);
	          } catch (InvalidRatingEntry e) {
	        	  
	          }
	        }
	        // perform formula for similarity score
	        similarityScore = (float) (1 / (1 + Math.sqrt(summation)));
	        // format score to hold 4 decimal places including trailing 0's
	        E result = (E) df.format(similarityScore);
	        // fill user-user matrix with score
	        userUserMatrix.populateMatrix(i, k, result);
	        userUserMatrix.populateMatrix(k, i, result);
	      }
	      // fill user-user matrix's main diagonal with 1.0000
	      userUserMatrix.populateMatrix(i, i, (E) "1.0000");
	    }
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * Prints out the similarity scores of the userUserMatrix, with each row and
   * column representing each/single user and the cell position (i,j)
   * representing the similarity score between user i and user j.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */

  public void printUserUserMatrix() {

  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * This function finds and prints the most similar pair of users in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */

  public void findAndprintMostSimilarPairOfUsers() {

  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * This function finds and prints the most dissimilar pair of users in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void findAndprintMostDissimilarPairOfUsers() {

  }
}
