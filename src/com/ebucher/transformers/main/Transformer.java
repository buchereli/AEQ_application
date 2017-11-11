package com.ebucher.transformers.main;

/**
 * Created by buche on 11/10/2017.
 * Object representation of a transformer
 */
public class Transformer {

    // Input keys
    private final int NAME = 0, TEAM = 1;
    private String name, team;

    // Transformer specs
    private final int[] specs = new int[7];
    // Spec keys
    private final int STRENGTH = 0, RANK = 4, COURAGE = 5;

    // Takes an input String and builds a transformer representation
    public Transformer(String input) {
        String[] inputArray = input.split(",");
        name = inputArray[NAME];
        team = inputArray[TEAM];

        for (int i = 0; i < specs.length; i++)
            specs[i] = Integer.parseInt(inputArray[i + 2]);
    }




}
