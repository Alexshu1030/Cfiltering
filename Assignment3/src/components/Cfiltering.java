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
  private UserMovieMatrix<E> userMovieMatrix;
  // this is a 2d matrix i.e. user*movie
  private UserUserMatrix<E> userUserMatrix;

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
    userUserMatrix = new UserUserMatrix<E>(numberOfUsers, numberOfMovies);
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
   * @param rowNumber The row number of the userMovieMatrix.
   * @param columnNumber The column number of the userMovieMatrix.
   * @param ratingValue The ratingValue to be inserted in the userMovieMatrix
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
            summation += (int) Math.pow((int) rating1 - (int) rating2, 2);
          } catch (NumberFormatException e) {
            System.err.println("Invalid rating entry");
            System.err.print(e.getMessage());
          } 
        }
        // perform formula for similarity score
        similarityScore = (float) (1 / (1 + Math.sqrt(summation)));
        // format score to hold 4 decimal places including trailing 0's
        E result = null;
        try {
          result = (E) df.format(similarityScore);
        } catch (NumberFormatException e) {
          System.err.println("Invalid rating entry");
          System.err.print(e.getMessage());
        }
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
  public String getUserUserMatrix() {
    String output = "";
    int numOfUsers = userUserMatrix.numOfRows;
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

  public String getMostSimilarPairOfUsers() {
    String output = "";
    int numOfUsers = userUserMatrix.numOfRows;
    // create two break lines to separate each section of output
    output += "\n\n";
    output += "The most similar pairs of users from above"
        + " userUserMatrix are: \n";
    float highestScore = 0;
    int j = 0;
    // instantiate list of tuples holding the closest scored pairs
    // [amount of closest pairs][0: user1 in pair, 1: user2 in pair]
    int closestPair[][] = new int[numOfUsers * (numOfUsers - 1)][2];
    // find user pairs with most similar score
    for (int i = 0; i < numOfUsers; i++) {
      for (int k = 1 + i; k < numOfUsers; k++) {
        // add current pair to list of closestPair if it has the same
        // score as the highest known score
        try {
          float curScore = Float.parseFloat((String) userUserMatrix.get(i, k));
          if (curScore == highestScore) {
            closestPair[j][0] = i;
            closestPair[j][1] = k;
            j++;
            // if new highest score is found, erase previous entries to
            // closestPair, add current pair to closestPair, and
            // assert new highest score
          } else if (curScore > highestScore) {
            j = 0;
            // erase any previous entries to closestPair
            for (int l = 0; l < numOfUsers * (numOfUsers - 1); l++) {
              closestPair[l][0] = 0;
              closestPair[l][1] = 0;
            }
            // add current pair to list of closestPair
            closestPair[j][0] = i;
            closestPair[j][1] = k;
            // assert new highest score
            highestScore = Float.parseFloat((String) userUserMatrix.get(i, k));
            j++;
          }
        } catch (NumberFormatException e) {
          System.err.println("Invalid correlation entry");
          System.err.print(e.getMessage());
        }
      }
    }
    // add to output user pairs with most similar score
    for (int l = 0; l <= j; l++) {
      if (!(closestPair[l][0] == 0 && closestPair[l][1] == 0)) {
        output += "User" + (closestPair[l][0] + 1) + " and User"
            + (closestPair[l][1] + 1) + "\n";
      }
    }
    // change score to decimal accuracy of 4 places and add to output
    DecimalFormat df = new DecimalFormat("0.0000");
    String result = df.format(highestScore);
    output += "with similarity score of " + result + "\n";
    return output;
  }

  /**
   * This function finds and returns the string representation of the most
   * dissimilar pair of users in the userUserMatrix.
   * 
   * @return output The string representation of the most dissimilar pair(s) of
   *         users
   */
  public String getMostDissimilarPairOfUsers() {
    String output = "";
    int numOfUsers = userUserMatrix.numOfRows;
    // create two break lines to separate each section of output
    output += "\n\n";
    output += "The most dissimilar pairs of users from above"
        + " userUserMatrix are: \n";
    float lowestScore = 1;
    int j = 0;
    // instantiate list of tuples holding the farthest scored pairs
    // [amount of farthest pairs][0: user1 in pair, 1: user2 in pair]
    int farthestPair[][] = new int[numOfUsers * (numOfUsers - 1)][2];
    // find user pairs with most dissimilar score
    for (int i = 0; i < numOfUsers; i++) {
      for (int k = 1 + i; k < numOfUsers; k++) {
        // add current pair to list of farthestPair if it has the same
        // score as the lowest known score
        try {
          float curScore = Float.parseFloat((String) userUserMatrix.get(i, k));
          if (curScore == lowestScore) {
            farthestPair[j][0] = i;
            farthestPair[j][1] = k;
            j++;
            // if new lowest score is found, erase previous entries to
            // farthestPair, add current pair to farthestPair, and
            // assert new lowest score
          } else if (curScore < lowestScore) {
            j = 0;
            // erase any previous entries to farthestPair
            for (int l = 0; l < numOfUsers * (numOfUsers - 1); l++) {
              farthestPair[l][0] = 0;
              farthestPair[l][1] = 0;
            }
            // add current pair to list of farthestPair
            farthestPair[j][0] = i;
            farthestPair[j][1] = k;
            // assert new lowest score
            lowestScore = Float.parseFloat((String) userUserMatrix.get(i, k));
            j++;
          }
        } catch (NumberFormatException e) {
          System.err.println("Invalid correlation entry");
          System.err.print(e.getMessage());
        }
      }
    }
    // add to output user pairs with most dissimilar score
    for (int l = 0; l <= j; l++) {
      if (!(farthestPair[l][0] == 0 && farthestPair[l][1] == 0)) {
        output += "User" + (farthestPair[l][0] + 1) + " and User"
            + (farthestPair[l][1] + 1) + "\n";
      }
    }
    // change score to decimal accuracy of 4 places and add to output
    DecimalFormat df = new DecimalFormat("0.0000");
    String result = df.format(lowestScore);
    output += "with similarity score of " + result + "\n";
    return output;
  }
}
