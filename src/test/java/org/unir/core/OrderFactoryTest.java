package org.unir.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderFactoryTest {

    /**
     * This test gets two (2) instances of OrderFactory in order to check that singleton works.
     */
    @Test
    public void getFactoryInstance () {
        OrderFactory factory = OrderFactory.getInstance();
        OrderFactory factory2 = OrderFactory.getInstance();
        Assertions.assertEquals(factory, factory2);
    }
}
