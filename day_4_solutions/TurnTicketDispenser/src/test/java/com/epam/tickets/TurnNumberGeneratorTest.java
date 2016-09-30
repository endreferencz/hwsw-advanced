package com.epam.tickets;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TurnNumberGeneratorTest {

    @Test(timeout = 1000)
    public void testGenerateRandomTickets() {
        Random random = Mockito.spy(new Random());
        Mockito.when(random.nextInt()).thenReturn(1, 1, 1, 3);
        TurnNumberGenerator generator = new TurnNumberGenerator(random, 2);
        List<Integer> list = generator.generateRandomTickets();
        Assert.assertEquals(Arrays.asList(1, 3), list);
    }

    @Test(timeout = 1000)
    public void testGenerateALotOfRandomTickets() {
        Random random = Mockito.spy(new Random());
        Mockito.when(random.nextInt())
            .thenReturn(1, 1, 1, 3)
            .thenCallRealMethod();
        TurnNumberGenerator generator = new TurnNumberGenerator(random, 1000);
        List<Integer> list = generator.generateRandomTickets();
        Assert.assertEquals(1000, list.size());
    }

}
