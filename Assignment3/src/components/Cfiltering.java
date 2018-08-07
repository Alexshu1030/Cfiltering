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

public class Cfiltering<E> implements CfilteringInterface<E>{
  // this is a 2d matrix i.e. user*movie
  private MatrixInterface<E> userMovieMatrix;
  // this is a 2d matrix i.e. user*movie
  private MatrixInterface<E> userUserMatrix;

  /**
   * Default Constructor.
   */
  public Cfiltering() {}

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
    userMovieMatrix = new UserMovieMatrix<E>(numberOfUsers, numberOfMovies);
    userUserMatrix = new UserUserMatrix<E>(numberOfUsers);
  }

  /**
   * Constructs an object which contains two 2d matrices, one of size
   * users*movies which will store integer movie ratings and one of size
   * users*users which will store float similarity scores between pairs of
   * users.
   * 
   * @param UMMatrix This is the UserMovieMatrix itself
   */
  public Cfiltering(MatrixInterface<E> UMMatrix, MatrixInterface<E> UUMatrix) {
    this.userMovieMatrix = UMMatrix;
    this.userUserMatrix = UUMatrix;
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
  public void populateUserMovieMatrix(int row, int col, E input) {
    userMovieMatrix.populateMatrix(row, col, input);
  }

  /**
   * Returns the string representation of the UserUserMatrix then the most
   * similar and dissimilar pair(s) of users.
   * 
   * @return output The string representation of the userUserMatrix and most 
   * dis/similar pairs of users
   */
  public String run() {
    String output = "";
    this.calculateSimilarityScore();
    output += this.getUserUserMatrix();
    output += this.getMostSimilarPairOfUsers();
    output += this.getMostDissimilarPairOfUsers();
    return output;
  }

  /**
   * Determines how similar each pair of users is based on their ratings. This
   * similarity value is represented with with a float value between 0 and 1,
   * where 1 is perfect/identical similarity. Stores these values in the
   * userUserMatrix.
   */
  private void calculateSimilarityScore() {
    // instantiate decimal accuracy of 4 decimal places
    DecimalFormat df = new DecimalFormat("0.0000");
    float similarityScore = 0;
    int i;
    int numOfUsers = userMovieMatrix.getNumRows();
    int numOfMovies = userMovieMatrix.getNumCols();
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
          summation += (int) Math.pow((int) rating1 - (int) rating2, 2);
        }
        // perform formula for similarity score
        similarityScore = (float) (1 / (1 + Math.sqrt(summation)));
        // format score to hold 4 decimal places including trailing 0's
        E result = (E) df.format(similarityScore);

        // fill user-user matrix with score
        userUserMatrix.populateMatrix(i, k, result);
      }
      // fill user-user matrix's main diagonal with 1.0000
      userUserMatrix.populateMatrix(i, i, (E) "1.0000");
    }
  }

  /**
   * Returns the string representation of similarity scores of the
   * userUserMatrix, with each row and column representing each/single user and
   * the cell position (i,j) representing the similarity score between user i
   * and user j.
   * 
   * @return output The string representation of the UserUserMatrix
   */
  private String getUserUserMatrix() {
    String output = "";
    int numOfUsers = userUserMatrix.getNumRows();
    // create two break lines to separate each section of output
    output += "\n\n";
    output += "userUserMatrix is: \n";
    // print each user-user similarity score
    for (int i = 0; i < numOfUsers; i++) {
      output += "[";
      for (int j = 0; j < numOfUsers; j++) {
        output += userUserMatrix.get(i, j);
        if (j < numOfUsers - 1) {
          output += ", ";
        }
      }
      output += "]\n";
    }
    return output;
  }

  /**
   * This function finds and returns the string representation of the most
   * similar pair of users in the userUserMatrix.
   * 
   * @return output The string representation of the most similar pair(s) of
   *         users
   */

  private String getMostSimilarPairOfUsers() {
    return getMostDisSimilarPairOfUsersHelper(true);
  }

  /**
   * This function finds and returns the string representation of the most
   * dissimilar pair of users in the userUserMatrix.
   * 
   * @return output The string representation of the most dissimilar pair(s) of
   *         users
   */
  private String getMostDissimilarPairOfUsers() {
    return getMostDisSimilarPairOfUsersHelper(false);
  }

  /**
   * This function finds and returns the string representation of the most
   * (dis)similar pair of users in the userUserMatrix.
   * 
   * @param similar This is true if calculating most similar,
   * otherwise calculating most dissimilar
   * @return output The string representation of the most (dis)similar pair(s) of
   *         users
   */
  private String getMostDisSimilarPairOfUsersHelper(boolean similar) {
    String output = "";
    int numOfUsers = userUserMatrix.getNumRows();
    // create two break lines to separate each section of output
    output += "\n\n";
    output += "The most dissimilar pairs of users from above"
        + " userUserMatrix are: \n";

    float champScore = 0;
    if (!similar)
      champScore = 1;

    int j = 0;
    // instantiate list of tuples holding the farthest scored pairs
    // [amount of farthest pairs][0: user1 in pair, 1: user2 in pair]
    int champPair[][] = new int[numOfUsers * (numOfUsers - 1)][2];
    // find user pairs with most dissimilar score
    for (int i = 0; i < numOfUsers; i++) {
      for (int k = 1 + i; k < numOfUsers; k++) {
        // add current pair to list of farthestPair if it has the same
        // score as the lowest known score
        float curScore =
            Float.parseFloat((String) userUserMatrix.get(i, k));
        if (curScore == champScore) {
          champPair[j][0] = i;
          champPair[j][1] = k;
          j++;
          // if new lowest score is found, erase previous entries to
          // farthestPair, add current pair to farthestPair, and
          // assert new lowest score
        } else if ((curScore < champScore && !similar)
            || (curScore > champScore && similar)) {
          j = 0;
          // erase any previous entries to farthestPair
          for (int l = 0; l < numOfUsers * (numOfUsers - 1); l++) {
            champPair[l][0] = 0;
            champPair[l][1] = 0;
          }
          // add current pair to list of farthestPair
          champPair[j][0] = i;
          champPair[j][1] = k;
          // assert new lowest score
          champScore = Float.parseFloat((String) userUserMatrix.get(i, k));
          j++;
        }
      }
    }
    // add to output user pairs with most dissimilar score
    for (int l = 0; l <= j; l++) {
      if (!(champPair[l][0] == 0 && champPair[l][1] == 0)) {
        output += "User" + (champPair[l][0] + 1) + " and User"
            + (champPair[l][1] + 1) + "\n";
      }
    }
    // change score to decimal accuracy of 4 places and add to output
    DecimalFormat df = new DecimalFormat("0.0000");
    String result = df.format(champScore);
    output += "with similarity score of " + result + "\n";
    return output;
  }
}
