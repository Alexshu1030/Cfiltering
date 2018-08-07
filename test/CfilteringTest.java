package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import components.Cfiltering;
import components.Matrix;
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
    String expected = "\n" + 
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
    String actual = cfObject.run();
    assertEquals(expected, actual);
  }
  /*
   * "\n" + 
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
   */

}