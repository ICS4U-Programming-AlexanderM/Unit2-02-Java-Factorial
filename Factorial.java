import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* This program calculates the factorial of numbers taken from a file.
*
* @author  Alexander Matheson
* @version 1.0
* @since   2023-04-14
*/

public final class Factorial {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        // Declare lists.
        final ArrayList<String> inputList = new ArrayList<String>();

        try {
            // Choose a file to get input from.
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);

            // Choose (or create) a file to print output to.
            final FileWriter output = new FileWriter("output.txt");

            // Loop to read each line of input file.
            while (scanInput.hasNextLine()) {
                // Add the next line.
                inputList.add(scanInput.nextLine());
            }

            // Create an array with all elements in the input list.
            final String[] inputArr = new String[inputList.size()];
            for (int location = 0; location < inputArr.length; location++) {
                inputArr[location] = inputList.get(location);
            }

            // Loop to send each line to function.
            for (String numStr : inputArr) {
                // Check for errors.
                try {
                    // Call function.
                    final double factored =
                        factorial(Double.parseDouble(numStr));

                    // Print to console and file.
                    System.out.println(factored);
                    output.write(factored + "\n");
                } catch (NumberFormatException err) {
                    System.out.println("Error, not a viable input.");
                }
            }

            // Close writer.
            output.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function generates marks for each assignment.
    *
    * @param number from file
    * @return factored number
    */
    public static double factorial(double number) {
        // Detect if the number is less than one.
        if (number <= 1) {
            return number;
        } else {
            // Re-call the function.
            return factorial(number - 1) * number;
        }
    }
}
