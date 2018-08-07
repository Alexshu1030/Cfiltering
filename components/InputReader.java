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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputReader {

  /**
   * Prompts input file then reads and returns collaborative filtering of the
   * UserMovieMatrix within the input file
   * 
   * @return output The string representation of the collaborative filtering
   *         results
   */
  public static <E> String read() {
    String output = "";
    try {

      // open file to read
      String fileName;
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of input file? ");
      fileName = in.nextLine();
      FileInputStream fStream = new FileInputStream(fileName);
      BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

      // Read dimensions: number of users and number of movies
      int numberOfUsers = Integer.parseInt(br.readLine());
      int numberOfMovies = Integer.parseInt(br.readLine());

      /*
       * create a new Cfiltering object that contains: a) 2d matrix
       * i.e.userMovieMatrix (#users*#movies) b) 2d matrix i.e. userUserMatrix
       * (#users*#users)
       */
      Cfiltering cfObject = new Cfiltering(numberOfUsers, numberOfMovies);

      // this is a blank line being read
      br.readLine();

      // read each line of movie ratings and populate the
      // userMovieMatrix
      String row;
      int rowNumber = 0;

      while ((row = br.readLine()) != null) {
        // allRatings is a list of all String numbers on one row
        String allRatings[] = row.split(" ");
        int columnNumber = 0;
        for (String singleRating : allRatings) {
          // make the String number into an integer
          int currentRating = Integer.parseInt(singleRating);
          // populate userMovieMatrix
          cfObject.populateUserMovieMatrix(rowNumber, columnNumber,
              currentRating);
          columnNumber++;
        }
        rowNumber++;
      }
      // close the file
      fStream.close();
      // run collaborative filtering on read input
      output = cfObject.run();

    } catch (FileNotFoundException e) {
      System.err.println("Do you have the input file in the root"
          + " folder of your project?");
      System.err.print(e.getMessage());
    } catch (IOException e) {
      System.err.print(e.getMessage());
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println("Number of users/movies incompatible"
          + " with given UserMovieMatrix");
      System.err.print(e.getMessage());
    } catch (NullPointerException e) {
      System.err.println("Number of rows/columns incompatible"
          + " with given number of users/movies");
    } catch (NumberFormatException e) {
      System.err.println("Invalid matrix entry");
      System.err.print(e.getMessage());
    }
    return output;
  }
}
