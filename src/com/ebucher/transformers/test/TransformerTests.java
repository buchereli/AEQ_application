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

    private Transformer soundwave, bluestreak, hubcap, optimus, predaking;

    @Before
    public void setUp() throws Exception {
        TransformerBattle.init(new String[]{"Soundwave,D,8,9,2,6,7,5,6,10",
                "Bluestreak,A,6,6,7,9,5,2,9,7",
                "Hubcap:A,4,4,4,4,4,4,4,4"});
        soundwave = new Transformer("Soundwave,D,8,9,2,6,7,5,6,10");
        bluestreak = new Transformer("Bluestreak,A,6,6,7,9,5,2,9,7");
        hubcap = new Transformer("Hubcap:A,4,4,4,4,4,4,4,4");
        optimus = new Transformer("Optimus Prime,A,1,1,1,1,1,1,1,1");
        predaking = new Transformer("Predaking,D,10,10,10,10,10,10,10,10");
    }

    @Test
    public void fight() throws Exception {
        Assert.assertEquals("General fight test failed", soundwave, TransformerBattle.fight(soundwave, bluestreak));
        Assert.assertEquals("Optimus Prime fight test failed", optimus, TransformerBattle.fight(soundwave, optimus));
        Assert.assertEquals("Optimus Prime vs Predaking fight test failed", null, TransformerBattle.fight(predaking, optimus));
    }

    @Test
    public void battle() throws Exception {
        Assert.assertEquals("Wrong number of battles", 1, TransformerBattle.battle());
    }

    @Test
    public void compareTo() throws Exception {
        Assert.assertTrue("Error with using rank for compareTo method", 0 < hubcap.compareTo(bluestreak));
        Assert.assertTrue("Error with using rank for compareTo method", 0 > predaking.compareTo(bluestreak));
        Assert.assertEquals("Error with using rank for compareTo method", 0, hubcap.compareTo(hubcap));
    }

    @Test
    public void transformerFight() throws Exception {
        Assert.assertEquals("Wrong transformer won the fight", 1, soundwave.fight(bluestreak));
        Assert.assertEquals("Optimus Prime vs Predaking fight test failed", -2, predaking.fight(optimus));
    }

    @Test
    public void print() throws Exception {
        TransformerBattle.main(new String[]{"Soundwave,D,8,9,2,6,7,5,6,10",
                "Bluestreak,A,6,6,7,9,5,2,9,7",
                "Hubcap:A,4,4,4,4,4,4,4,4"});
    }

    @Test
    public void print2() throws Exception {
        TransformerBattle.main(new String[]{"Optimus Prime,A,1,1,1,1,1,1,1,1",
                "Predaking,D,10,10,10,10,1,10,10,10",
                "Soundwave,D,8,9,2,6,7,5,6,10",
                "Cook,D,10,10,10,10,10,10,10,10",
                "Bluestreak,A,6,6,7,9,5,2,9,7",
                "Hubcap:A,4,4,4,4,4,4,4,4"});
    }
}