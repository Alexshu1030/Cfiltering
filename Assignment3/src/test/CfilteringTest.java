package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import components.Cfiltering;
import mockObjects.*;

public class CfilteringTest<E> {

  private MockUserMovieMatrix<E> UMmatrix;
  private MockUserUserMatrix<E> UUmatrix;

  @Before
  public void setUp() {
    UMmatrix = new MockUserMovieMatrix<E>(4, 5);  
    UUmatrix = new MockUserUserMatrix<E>(4);
  }

  @Test
  public void runTest() {
    String expected =  "\n" + 
        "\n" + 
        "userUserMatrix is: \n" + 
        "[1.0000, 0.1380, 0.2171, 0.1285]\n" + 
        "[0.1380, 1.0000, 0.1827, 0.1614]\n" + 
        "[0.2171, 0.1827, 1.0000, 0.1250]\n" + 
        "[0.1285, 0.1614, 0.1250, 1.0000]\n" + 
        "\n" + 
        "\n" + 
        "The most dissimilar pairs of users from above userUserMatrix are: \n" + 
        "User1 and User3\n" + 
        "with similarity score of 0.2171\n" + 
        "\n" + 
        "\n" + 
        "The most dissimilar pairs of users from above userUserMatrix are: \n" + 
        "User3 and User4\n" + 
        "with similarity score of 0.1250\n" + 
        "";
    Cfiltering cfObject = new Cfiltering(UMmatrix, UUmatrix);
    String actual = cfObject.run();
    assertEquals(expected, actual);
  }
  
  @Test
  public void populateTest() {
    String expected =  "\n" + 
        "\n" + 
        "userUserMatrix is: \n" + 
        "[1.0000, 1.0000, 1.0000, 1.0000]\n" + 
        "[1.0000, 1.0000, 1.0000, 1.0000]\n" + 
        "[1.0000, 1.0000, 1.0000, 1.0000]\n" + 
        "[1.0000, 1.0000, 1.0000, 1.0000]\n" + 
        "\n" + 
        "\n" + 
        "The most dissimilar pairs of users from above userUserMatrix are: \n" + 
        "User1 and User2\n" +
        "User1 and User3\n" +
        "User1 and User4\n" +
        "User2 and User3\n" +
        "User2 and User4\n" +
        "User3 and User4\n" +
        "with similarity score of 1.0000\n" + 
        "\n" + 
        "\n" + 
        "The most dissimilar pairs of users from above userUserMatrix are: \n" + 
        "User1 and User2\n" +
        "User1 and User3\n" +
        "User1 and User4\n" +
        "User2 and User3\n" +
        "User2 and User4\n" +
        "User3 and User4\n" + 
        "with similarity score of 1.0000\n" + 
        "";
    Cfiltering cfObject = new Cfiltering(UMmatrix, UUmatrix);
    cfObject.populateUserMovieMatrix(0, 0, 1);
    cfObject.populateUserMovieMatrix(0, 1, 1);
    cfObject.populateUserMovieMatrix(0, 2, 1);
    cfObject.populateUserMovieMatrix(0, 3, 1);
    cfObject.populateUserMovieMatrix(0, 4, 1);
    cfObject.populateUserMovieMatrix(1, 0, 1);
    cfObject.populateUserMovieMatrix(1, 1, 1);
    cfObject.populateUserMovieMatrix(1, 2, 1);
    cfObject.populateUserMovieMatrix(1, 3, 1);
    cfObject.populateUserMovieMatrix(1, 4, 1);
    cfObject.populateUserMovieMatrix(2, 0, 1);
    cfObject.populateUserMovieMatrix(2, 1, 1);
    cfObject.populateUserMovieMatrix(2, 2, 1);
    cfObject.populateUserMovieMatrix(2, 3, 1);
    cfObject.populateUserMovieMatrix(2, 4, 1);
    cfObject.populateUserMovieMatrix(3, 0, 1);
    cfObject.populateUserMovieMatrix(3, 1, 1);
    cfObject.populateUserMovieMatrix(3, 2, 1);
    cfObject.populateUserMovieMatrix(3, 3, 1);
    cfObject.populateUserMovieMatrix(3, 4, 1);

    String actual = cfObject.run();
    assertEquals(expected, actual);
  }
  /*
   *
   */

}