package components;

public interface CfilteringInterface<E> {
	
  public void populateUserMovieMatrix(int row, int col, E input);
  
  public String run();

}
