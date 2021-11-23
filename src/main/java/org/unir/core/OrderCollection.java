package org.unir.core;

import java.util.ArrayList;
import java.util.List;

public final class OrderCollection {

    public static OrderCollection instance;
    private final List<Order> collection;

    private OrderCollection (List<Order> collection) {
        this.collection = collection;
    }

    public static OrderCollection getInstance() {
        if (instance == null) {
            instance = new OrderCollection(new ArrayList<Order>());
        }
        return instance;
    }

    public static List<Order> getCollection () {
        return getInstance().collection;
    }
}
