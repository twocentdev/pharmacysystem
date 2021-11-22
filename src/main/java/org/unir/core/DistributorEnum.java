package org.unir.core;

public enum DistributorEnum {

    COFARMA(0, "Cofarma"),
    EMPSEPHAR (1, "Empsephar"),
    CEMEFAR(2, "Cemefar");

    private final Integer distributorID;
    private final String distributorName;

    private DistributorEnum(Integer id, String name ) {
        this.distributorID = id;
        this.distributorName = name;
    }

    public Integer getDistributorID() {
        return this.distributorID;
    }

    public String getDistributorName() {
        return this.distributorName;
    }

    /**
     * This method checks if a DistributorEnum exits with the same given name. It ignores case.
     *
     * @param name the given name
     * @return true if there is a MedicineEnum with the same given name, false otherwise.
     */
    public static boolean exists(String name) {
        for (DistributorEnum distributor: DistributorEnum.values()) {
            if (distributor.name().equals(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
