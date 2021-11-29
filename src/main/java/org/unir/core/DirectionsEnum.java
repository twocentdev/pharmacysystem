package org.unir.core;

public enum DirectionsEnum {

    ROSA(0, "Calle de la Rosa 28"),
    ALCAZABILLA (1, "Calle Alcazabilla 3");

    private final Integer directionID;
    private final String directionName;

    private DirectionsEnum(Integer id, String name ) {
        this.directionID = id;
        this.directionName = name;
    }

    public Integer getDistributorID() {
        return this.directionID;
    }

    public String getDistributorName() {
        return this.directionName;
    }

    /**
     * This method checks if a DistributorEnum exits with the same given name. It ignores case.
     *
     * @param name the given name
     * @return true if there is a MedicineEnum with the same given name, false otherwise.
     */
    public static boolean exists(String name) {
        for (DirectionsEnum direction: DirectionsEnum.values()) {
            if (direction.name().equals(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method returns a printable String that contains DistributorEnum.values.
     *
     * @return the printable String.
     */
    public static String valuesToString() {
        return String.format(
            "[%s, %s]",
            DirectionsEnum.ROSA.getDistributorName(),
            DirectionsEnum.ALCAZABILLA.getDistributorName()
        );
    }
}
