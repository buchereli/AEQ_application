package com.ebucher.castles.main;

import java.util.Scanner;

/**
 * Created by buche on 11/10/2017.
 * Takes in a String representation of an integer array and returns the number of local min and max
 */
public class CastleBuilder {

    final private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String input;

        // If input is given directly vs requested with scanner
        if (args.length == 0)
            input = sc.nextLine();
        else
            input = args[0];

        int[] land = stringToIntArray(input);
        int count = countLocals(land);

        System.out.println("You can build " + count + " castles!");
    }

    // Converts a String representation of an int array into an int array
    public static int[] stringToIntArray(String input) throws Exception {
        // Empty input edge case
        if (input.isEmpty())
            return new int[0];

        // Remove spaces
        input = input.replace(" ", "");

        // Make sure the input uses csv without letters
        if(!input.matches("([0-9],)*[0-9]+"))
            throw new Exception("Bad formatting! Make sure you are using csv format");

        String[] stringArray = input.split(",");
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++)
            intArray[i] = Integer.parseInt(stringArray[i]);

        return intArray;
    }

    // Returns the number of local min and max in an int array
    public static int countLocals(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++)
            if (isLocal(array, i))
                count++;

        return count;
    }

    // Returns if an index is a local min or max in an int array
    private static boolean isLocal(int[] array, int index) {
        // Start index then return true
        if (index == 0)
            return true;

        // If end index and not part of flat then return true
        if (index == array.length - 1)
            return array[index] != array[index - 1];

        // If min, return true
        if (array[index - 1] > array[index] && array[index] <= array[index + 1]) {
            if (array[index] == array[index + 1])
                return isPlateau(array, index, true);

            return true;
        }

        // If max, return true
        if (array[index - 1] < array[index] && array[index] >= array[index + 1]) {
            if (array[index] == array[index + 1])
                return isPlateau(array, index, false);

            return true;
        }

        return false;
    }

    // Returns true if index is the start of a plateau or inverted plateau
    private static boolean isPlateau(int[] array, int index, boolean min) {
        for (int i = index + 2; i < array.length; i++) {
            if (array[index] < array[i])
                return min;
            if (array[index] > array[i])
                return !min;
        }
        return true;
    }

}
