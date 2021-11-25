package org.unir.core;

import java.util.List;

public class Order {

    private final String name;
    private final MedicineEnum type;
    private final Integer amount;
    private final DistributorEnum distributor;
    private final List<String> directions;

    protected Order(String name, MedicineEnum type, Integer amount, DistributorEnum distributor, List<String> directions) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.distributor = distributor;
        this.directions = directions;
    }

    public String getName() {
        return name;
    }

    public MedicineEnum getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    public DistributorEnum getDelivery() {
        return distributor;
    }

    public List<String> getDirections() {
        return directions;
    }

    public String toString() {
        return String.format(
            "{name: %s, type: %s, amount: %d, distributor: %s, direction(s): %s}",
            this.name,
            this.type.getMedicineName(),
            this.amount,
            this.distributor.getDistributorName(),
            this.directions.toString()
        );
    }
}
