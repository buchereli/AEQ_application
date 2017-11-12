package com.ebucher.transformers.main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by buche on 11/10/2017.
 * Takes an input of various transformers and then battles them head to head to determine a winning team
 */
public class TransformerBattle {

    private static final ArrayList<Transformer> autobots = new ArrayList<>(), decepticons = new ArrayList<>();
    private static final ArrayList<Transformer> winners = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // Create and add transformers to a list
        final ArrayList<Transformer> transformers = new ArrayList<>();
        for (String arg : args)
            transformers.add(new Transformer(arg));

        // Sort by rank
        Collections.sort(transformers);

        // Add to team lists
        for (Transformer transformer : transformers)
            if (transformer.getTeam().equals("Autobots"))
                autobots.add(transformer);
            else
                decepticons.add(transformer);

        int battleCount = battle();
    }

    // Fight and add winners to a list, returns number of battles
    public static int battle() {
        int battleCount = 0;
        while (autobots.size() > 0 && decepticons.size() > 0) {
            winners.add(fight(autobots.get(0), decepticons.get(0)));
            autobots.remove(0);
            decepticons.remove(0);
            battleCount++;
        }
        return battleCount;
    }

    // Returns the transformer that won the fight
    public static Transformer fight(Transformer t1, Transformer t2) {
        return null;
    }

    // Find who won more, returns the wins - loses for autobots
    public static int getAutobotScore() {
        int autobotScore = 0;
        for (Transformer transformer : winners) {
            if (transformer != null) {
                if (transformer.getTeam().equals("Autobots"))
                    autobotScore++;
                else
                    autobotScore--;
            }
        }
        return autobotScore;
    }

    // Prints the results of the battle
    public static void printResults() {

    }

}
