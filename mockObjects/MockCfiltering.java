package mockObjects;

import components.CfilteringInterface;

public class MockCfiltering<E> implements CfilteringInterface<E>{

  @Override
  public void populateUserMovieMatrix(int row, int col, Object input) {
  }

  @Override
  public String run() {
    return "\n" + 
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
  }

}
