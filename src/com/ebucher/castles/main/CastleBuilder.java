package com.ebucher.castles.main;

import java.util.Scanner;

/**
 * Created by buche on 11/10/2017.
 * Takes in a String representation of an integer array and returns the number of local min and max
 */
public class CastleBuilder {

    final private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String input;

        // If input is given directly vs requested with scanner
        if (args.length == 0)
            input = sc.nextLine();
        else
            input = args[0];

        int[] land = stringToIntArray(input);
        int count = countLocals(land);

        System.out.println(count);
    }

    // Converts a String representation of an int array into an int array
    public static int[] stringToIntArray(String input) {
        return null;
    }

    // Returns the number of local min and max in an int array
    public static int countLocals(int[] array) {
        return -1;
    }

    // Returns if an index is a local min or max in an int array
    private static boolean isLocal(int[] array, int index) {
        return false;
    }

    // Returns true if index is the start of a plateau or inverted plateau
    private static boolean isPlateau(int[] array, int index, boolean min) {
        return true;
    }

}
