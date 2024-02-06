import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    // Create a Scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    // Prompt the user to enter the number of students and retrieve the input
    int numStudents = getValidInput("Enter the number of students: ", scanner);

    // Create an ArrayList to store the grades of the students
    ArrayList<Integer> studentGrades = new ArrayList();

    // Loop through each student and prompt the user to enter their grade
    for (int i = 0; i < numStudents; i++) {
      int grade = getValidInput("Enter the grade for student " + (i + 1) + ": ", scanner);
      studentGrades.add(grade);
    }

    // Initialize variables to calculate the total, maximum, and minimum grades
    int total = 0;
    int maxGrade = Integer.MIN_VALUE;
    int minGrade = Integer.MAX_VALUE;

    // Loop through each grade to calculate the total and find the maximum and
    // minimum grades
    for (int grade : studentGrades) {
      total += grade;
      maxGrade = Math.max(maxGrade, grade);
      minGrade = Math.min(minGrade, grade);
    }

    // Calculate the average grade
    int averageGrade = total / numStudents;

    // Print the calculated average, maximum, and minimum grades
    System.out.println("Average grade: " + averageGrade);
    System.out.println("Maximum grade: " + maxGrade);
    System.out.println("Minimum grade: " + minGrade);

    // Close the Scanner object to release resources
    scanner.close();
  }

  // Method to validate and retrieve user input
  private static int getValidInput(String message, Scanner scanner) {
    while (true) {
      try {
        // Prompt the user to enter input and retrieve the input as an integer
        System.out.print(message);
        int input = Integer.parseInt(scanner.next());

        // Validate the input to ensure it is greater than 0
        if (input <= 0) {
          System.out.println("Invalid input. Number of students should be greater than 0.");
        } else {
          return input; // Return the valid input
        }
      } catch (NumberFormatException e) {
        // Catch any NumberFormatException if the input is not a valid integer
        System.out.println("Invalid input. Please enter a valid integer.");
      }
    }
  }
}
