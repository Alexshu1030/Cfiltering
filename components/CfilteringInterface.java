package components;

public interface CfilteringInterface<E> {
  
  /**
   * The purpose of this method is to populate the UserMovieMatrix. As input
   * parameters it takes in a rowNumber, columnNumber and a rating value. The
   * rating value is then inserted in the UserMovieMatrix at the specified
   * rowNumber and the columnNumber.
   * 
   * @param row The row number of the userMovieMatrix.
   * @param col The column number of the userMovieMatrix.
   * @param input The ratingValue to be inserted in the userMovieMatrix
   */
  public void populateUserMovieMatrix(int row, int col, E input);

  /**
   * Returns the string representation of the UserUserMatrix then the most
   * similar and dissimilar pair(s) of users.
   * 
   * @return output The string representation of the userUserMatrix and most 
   * dis/similar pairs of users
   */
  public String run();

}
