package com.ebucher.transformers.main;

/**
 * Created by buche on 11/10/2017.
 * Object representation of a transformer
 */
public class Transformer implements Comparable<Transformer> {

    // Input keys
    private final int NAME = 0, TEAM = 1;
    private String name, team;

    // Transformer specs
    private final int[] specs = new int[7];
    // Spec keys
    private final int STRENGTH = 0, RANK = 4, COURAGE = 5;

    // Takes an input String and builds a transformer representation
    public Transformer(String input) throws Exception {
        // Remove spaces
        input = input.replace(" ", "");

        // Make sure the input uses the correct format
        if (!input.matches("^([a-z]|[A-Z])+,.*$"))
            throw new Exception("Bad formatting! Transformer " + input + " does not start with a valid name");
        if (!input.matches("^.*,([aAdD]|([aA]utobots)|([dD]ecepticons)),.*$"))
            throw new Exception("Bad formatting! Transformer " + input + " does not have a valid team");
        if (!input.matches("^.*(,(10|[1-9])){7}$"))
            throw new Exception("Bad formatting! Transformer " + input + " does not have valid specs");

        // Build the transformer
        String[] inputArray = input.split("[,:]");
        name = inputArray[NAME];
        team = inputArray[TEAM].matches("([aA]|[aA]utobots)") ? "Autobots" : "Decepticons";

        for (int i = 0; i < specs.length; i++)
            specs[i] = Integer.parseInt(inputArray[i + 2]);
    }

    // Allows transformers to be easily sorted by rank
    @Override
    public int compareTo(Transformer transformer) {
        return 0;
    }

    public String getTeam() {
        return team;
    }

    // Returns 1 if this transformer beats the input transformer, 0 for tie and -1 for lose
    public int fight(Transformer transformer) {
        return 0;
    }
}
