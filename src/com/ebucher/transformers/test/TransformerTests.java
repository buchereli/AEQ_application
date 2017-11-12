package com.ebucher.transformers.test;

import com.ebucher.transformers.main.Transformer;
import com.ebucher.transformers.main.TransformerBattle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by buche on 11/11/2017.
 */
public class TransformerTests {

    private Transformer soundwave, bluestreak, hubcap;

    @Before
    public void setUp() throws Exception {
        TransformerBattle.main(new String[]{"Soundwave, ​D, ​8,9,2,6,7,5,6,10",
                "Bluestreak, ​A, ​6,6,7,9,5,2,9,7",
                "Hubcap: ​A, ​4,4,4,4,4,4,4,4"});
        soundwave = new Transformer("Soundwave, ​D, ​8,9,2,6,7,5,6,10");
        bluestreak = new Transformer("Bluestreak, A, 6,6,7,9,5,2,9,7");
        hubcap = new Transformer("Hubcap: ​A, ​4,4,4,4,4,4,4,4");
    }

    @Test
    public void fight() throws Exception {
        Assert.assertEquals("Wrong transformer won the fight", soundwave, TransformerBattle.fight(soundwave, bluestreak));
    }

    @Test
    public void battle() throws Exception {
        Assert.assertEquals("Wrong number of battles", 1, TransformerBattle.battle());
    }

    @Test
    public void compareTo() throws Exception {
        Assert.assertEquals("Error with using rank for compareTo method", -1, hubcap.compareTo(bluestreak));
    }

    @Test
    public void getTeam() throws Exception {
        Assert.assertEquals("Error with getTeam", "Autobots", bluestreak.getTeam());
    }

    @Test
    public void getName() throws Exception {
        Assert.assertEquals("Error with getName", "Bluestreak", bluestreak.getName());
    }

    @Test
    public void transformerFight() throws Exception {
        Assert.assertEquals("Wrong transformer won the fight", 1, soundwave.fight(bluestreak));
    }
}