package com.ebucher.transformers.main;

/**
 * Created by buche on 11/10/2017.
 * Object representation of a transformer
 */
public class Transformer implements Comparable<Transformer> {

    // Input keys
    private final int NAME = 0, TEAM = 1;
    private String name, team;

    // Important specs
    private int strength, rank, courage, skill, overall;

    // Takes an input String and builds a transformer representation
    public Transformer(String input) throws Exception {
        // Remove spaces
        String inputReplaced = input.replace(", ", ",");
        inputReplaced = inputReplaced.replace(" ,", ",");
        while (inputReplaced.length() != input.length()) {
            input = inputReplaced;
            inputReplaced = input.replace(", ", ",");
            inputReplaced = inputReplaced.replace(" ,", ",");
        }
        input = input.replace(":", ",");

        // Make sure the input uses the correct format
        if (!input.matches("^([a-z]|[A-Z]|[ ])+,.*$"))
            throw new Exception("Bad formatting! Transformer " + input + " does not start with a valid name");
        if (!input.matches("^.*,([aAdD]|([aA]utobots)|([dD]ecepticons)),.*$"))
            throw new Exception("Bad formatting! Transformer " + input + " does not have a valid team");
        if (!input.matches("^.*(,(10|[1-9])){8}$"))
            throw new Exception("Bad formatting! Transformer " + input + " does not have valid specs");

        // Build the transformer
        String[] inputArray = input.split(",");
        name = inputArray[NAME];
        team = inputArray[TEAM].matches("([aA]|[aA]utobots)") ? "Autobots" : "Decepticons";

        int[] specs = new int[8];
        for (int i = 0; i < specs.length; i++)
            specs[i] = Integer.parseInt(inputArray[i + 2]);

        strength = specs[0];
        rank = specs[4];
        courage = specs[5];
        skill = specs[7];
        overall = specs[1] + specs[2] + specs[3] + specs[6];
    }

    // Allows transformers to be easily sorted by rank
    @Override
    public int compareTo(Transformer transformer) {
        return transformer.rank - rank;
    }

    String getTeam() {
        return team;
    }

    String getName() {
        return name;
    }

    // Returns 1 if this transformer beats the input transformer, 0 for tie and -1 for lose
    // Special case if OP and Predaking fight then returns -2
    public int fight(Transformer transformer) {
        // If this is a special transformer
        if (name.equals("Optimus Prime") || name.equals("Predaking")) {
            // And other is a special transformer
            if (transformer.getName().equals("Optimus Prime") || transformer.getName().equals("Predaking"))
                return -2;
            return 1;
        }

        // If other is a special transformer
        if (transformer.getName().equals("Optimus Prime") || transformer.getName().equals("Predaking"))
            return -1;

        // Check courage and strength
        if (courage > transformer.courage + 3 && strength > transformer.strength + 2)
            return 1;
        if (courage < transformer.courage - 3 && strength < transformer.strength - 2)
            return 1;

        // Check skill
        if (skill > transformer.skill + 2)
            return 1;
        if (skill < transformer.skill - 2)
            return -1;

        // Check overall
        if (overall > transformer.overall)
            return 1;
        if (overall < transformer.overall)
            return -1;

        return 0;
    }
}
