package com.ebucher.castles.test;

import com.ebucher.castles.main.CastleBuilder;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by buche on 11/10/2017.
 */
public class CastleBuilderTests {
    private final int[] land = new int[]{1, 1, 2, 3, 1, 2};
    private final int[] land2 = new int[]{1, 2};
    private final int[] land1 = new int[]{1};
    private final int[] land0 = new int[0];
    private final int[] landPlateaus = new int[]{1, 1, 2, 2, 1, 1};
    private final int[] landFlat = new int[]{1, 1, 1, 1};

    @Test
    public void stringToIntArray() throws Exception {
        assertArrayEquals("General case failed", CastleBuilder.stringToIntArray("1,1,2,3,1,2"), land);
        assertArrayEquals("Length one failed", CastleBuilder.stringToIntArray("1"), land1);
        assertArrayEquals("Empty case failed", CastleBuilder.stringToIntArray(""), land0);
    }

    @Test
    public void countLocals() throws Exception {
        assertEquals("General land case failed", CastleBuilder.countLocals(land), 4);
        assertEquals("Land of length two failed", CastleBuilder.countLocals(land2), 2);
        assertEquals("Land of length one failed", CastleBuilder.countLocals(land1), 1);
        assertEquals("Land of length zero failed", CastleBuilder.countLocals(land0), 0);
        assertEquals("Plateau test failed", CastleBuilder.countLocals(landPlateaus), 3);
        assertEquals("Flat test failed", CastleBuilder.countLocals(landFlat), 1);
    }

}