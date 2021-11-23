package org.unir.core;

import java.util.Arrays;

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
     * @param distributor the company who is responsible for delivering the medicine.
     * @param branch where the medicine should be delivered.
     *
     * @return the new order.
     */
    public Order create (String name, String type, Integer amount, String distributor, String branch)
        throws IllegalArgumentException {
        if (name == null || name.isEmpty() || !name.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException(String.format(
                    "Expected a medicine name using the regular expression [a-zA-Z0-9]+, but got %s.",
                    name
            ));
        }
        if (type == null || type.isEmpty() || !MedicineEnum.exists(type)) {
            throw new IllegalArgumentException(String.format(
                "Expected type of medicine [%s], but got %s.",
                MedicineEnum.valuesToString(),
                type
            ));
        }
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException(String.format(
                "Expected medicine amount <0, but got %d.",
                amount
            ));
        }
        if (distributor == null || distributor.isEmpty() || !DistributorEnum.exists(distributor)) {
            throw new IllegalArgumentException(String.format(
                "Expected medicine distributor [%s], but got %s.",
                DistributorEnum.valuesToString(),
                distributor
            ));
        }
        if (branch == null) {
            throw new IllegalArgumentException("Expected branch, got null.");
        }
        Order order = new Order(
            name,
            MedicineEnum.valueOf(type.toUpperCase()),
            amount,
            DistributorEnum.valueOf(distributor.toUpperCase()),
            branch
        );
        OrderCollection.getInstance();
        OrderCollection.getCollection().add(order);
        return order;
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
