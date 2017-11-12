package com.ebucher.transformers.main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by buche on 11/10/2017.
 * Takes an input of various transformers and then battles them head to head to determine a winning team
 */
public class TransformerBattle {

    private static ArrayList<Transformer> autobots, decepticons;
    private static ArrayList<Transformer> winners;

    public static void main(String[] args) throws Exception {
        init(args);

        printResults(battle());
    }

    public static void init(String[] args) throws Exception {
        autobots = new ArrayList<>();
        decepticons = new ArrayList<>();
        winners = new ArrayList<>();

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
    }

    // Fight and add winners to a list, returns number of battles
    public static int battle() {
        int battleCount = 0;

        // Fight all transformers
        while (autobots.size() > 0 && decepticons.size() > 0) {
            winners.add(fight(autobots.get(0), decepticons.get(0)));
            if (autobots.size() > 0)
                autobots.remove(0);
            if (decepticons.size() > 0)
                decepticons.remove(0);
            battleCount++;
        }

        // Add back survivors
        for (Transformer winner : winners)
            if (winner != null) {
                if (winner.getTeam().equals("Autobots"))
                    autobots.add(winner);
                else
                    decepticons.add(winner);
            }

        return battleCount;
    }

    // Returns the transformer that won the fight
    public static Transformer fight(Transformer t1, Transformer t2) {
        int result = t1.fight(t2);
        if (result == 1)
            return t1;
        if (result == -1)
            return t2;
        if (result == -2) {
            winners = new ArrayList<>();
            autobots = new ArrayList<>();
            decepticons = new ArrayList<>();
        }
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
    public static void printResults(int battleCount) {
        System.out.println(battleCount + " battle" + (battleCount != 1 ? "s" : ""));

        int autobotScore = getAutobotScore();
        if (autobotScore > 0) {
            System.out.println("Winning team (Autobots): " + arrayListToString(autobots));
            System.out.println("Survivors from losing team (Decipticons): " + arrayListToString(decepticons));
        } else if (autobotScore < 0) {
            System.out.println("Winning team (Decipticons): " + arrayListToString(decepticons));
            System.out.println("Survivors from losing team (Autobots): " + arrayListToString(autobots));
        } else {
            System.out.println("The game was a tie!");
            if (autobots.size() == 0)
                System.out.println("There were no surviving autobots");
            else
                System.out.println(arrayListToString(autobots) + " (Autobots) survived");
            if (decepticons.size() == 0)
                System.out.println("There were no surviving decepticons");
            else
                System.out.println(arrayListToString(autobots) + " (Decipticons) survived");
        }
    }

    private static String arrayListToString(ArrayList<Transformer> list) {
        if (list.isEmpty())
            return "";

        StringBuilder s = new StringBuilder();
        for (Transformer transformer : list)
            s.append(transformer.getName()).append(", ");

        return s.substring(0, s.length() - 2);
    }

}
