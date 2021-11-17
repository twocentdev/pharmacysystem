package org.unir.core;

/**
 * This class is responsible for validating new order requests, creating them and 'saving' to a collection.
 * It uses singleton pattern in order to ensure there is only one instance of it.
 */
public final class OrderFactory {

    /**
     * The instance of the factory. See singleton pattern for more information.
     */
    public static OrderFactory instance;

    /**
     * This method creates new instances of medicine orders, if all input parameters are valid, and save into the collection.
     *
     * @param name the medicine name.
     * @param type the medicine type (uses an enum).
     * @param amount the total amount of medicine units ordered.
     * @param delivery the company who is responsible for delivering the medicine.
     * @param branch where the medicine should be delivered.
     *
     * @return the new order.
     */
    public Order create (String name, String type, Integer amount, String delivery, String branch) {
        //TODO --> Validate input parameters before creating new Order();
        if (true
        ) {
            Order order = new Order(name, type, amount, delivery, branch);
            OrderCollection.getInstance().getCollection().add(order);
            return order;
        } else {
            //TODO --> raise exception if input parameters are not valid to create new Order();
            return null;
        }
    }

    /**
     * This method is used to get the instance of this OrderFactory.
     *
     * @return the OrderFactory instance.
     */
    public static OrderFactory getInstance () {
        if (instance == null) {
            instance = new OrderFactory();
        }
        return instance;
    }
}
