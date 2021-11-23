package org.unir.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderCollectionTest {

    OrderCollection collection;
    Order order;

    @BeforeEach
    public void setUp () {
        collection = OrderCollection.getInstance();
        order = new Order(null, null, null, null, null);
        OrderCollection.getCollection().removeAll(OrderCollection.getCollection());
    }

    /**
     * This test shows that OrderCollection singleton works.
     */
    @Test
    public void collectionSingleton () {
        OrderCollection collection2 = OrderCollection.getInstance();
        Assertions.assertEquals(
            collection.hashCode(),
            collection2.hashCode()
        );
        Assertions.assertEquals(
            OrderCollection.getCollection().hashCode(),
            OrderCollection.getCollection().hashCode()
        );
    }

    /**
     * This test shows that Orders can be added to OrderCollection.collection.
     */
    @Test
    public void addOrderToCollection () {
        Assertions.assertEquals( 0, (OrderCollection.getCollection().size()));
        OrderCollection.getCollection().add(order);
        Assertions.assertEquals( 1, (OrderCollection.getCollection().size()));
        OrderCollection.getCollection().add(order);
        OrderCollection.getCollection().add(order);
        Assertions.assertEquals( 3, (OrderCollection.getCollection().size()));
    }

    /**
     * This test shows that Orders can be removed from OrderCollection.colletion.
     */
    @Test
    public void removeOrderFromCollection () {
        Assertions.assertEquals( 0, (OrderCollection.getCollection().size()));
        OrderCollection.getCollection().add(order);
        Assertions.assertEquals(1, OrderCollection.getCollection().size());
        OrderCollection.getCollection().remove(order);
        Assertions.assertEquals( 0, OrderCollection.getCollection().size());
        OrderCollection.getCollection().add(order);
        OrderCollection.getCollection().add(order);
        Assertions.assertEquals( 2, OrderCollection.getCollection().size());
        OrderCollection.getCollection().remove(order);
        Assertions.assertEquals( 1, OrderCollection.getCollection().size());
    }

    /**
     * This test shows how to remove all Orders from OrderCollection.collection.
     */
    @Test
    public void removeAllOrdersFromCollection () {
        Assertions.assertEquals( 0, (OrderCollection.getCollection().size()));
        OrderCollection.getCollection().add(order);
        OrderCollection.getCollection().add(order);
        Assertions.assertEquals(2, OrderCollection.getCollection().size());
        OrderCollection.getCollection().removeAll(OrderCollection.getCollection());
        Assertions.assertEquals(0, OrderCollection.getCollection().size());
        OrderCollection.getCollection().add(order);
        OrderCollection.getCollection().add(order);
        OrderCollection.getCollection().add(order);
        OrderCollection.getCollection().add(order);
        Assertions.assertEquals(4, OrderCollection.getCollection().size());
        OrderCollection.getCollection().removeAll(OrderCollection.getCollection());
        Assertions.assertEquals(0, OrderCollection.getCollection().size());
    }
}
