package org.unir.core;

public enum MedicineEnum {

    PAINKILLER(0, "Painkiller"),
    ANALEPTIC (1, "Analeptic"),
    ANESTHETIC(2, "Anesthetic"),
    ANTACID(3, "Antacid"),
    ANTIDEPRESSANT(4, "Antidepressant"),
    ANTIBIOTIC(5, "Antibiotic");

    private final Integer medicineID;
    private final String medicineName;

    private MedicineEnum(Integer id, String name ) {
        this.medicineID = id;
        this.medicineName = name;
    }

    public Integer getMedicineID() {
        return this.medicineID;
    }

    public String getMedicineName() {
        return this.medicineName;
    }

    /**
     * This method checks if a MedicineEnum exits with the same given name. It ignores case.
     *
     * @param name the given name
     * @return true if there is a MedicineEnum with the same given name, false otherwise.
     */
    public static boolean exists(String name) {
        for (MedicineEnum medicine: MedicineEnum.values()) {
            if (medicine.name().equals(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method returns a printable String that contains MedicineEnum.values.
     *
     * @return the printable String.
     */
    public static String valuesToString() {
        return String.format(
            "[%s, %s, %s]",
            MedicineEnum.PAINKILLER.getMedicineName(),
            MedicineEnum.ANALEPTIC.getMedicineName(),
            MedicineEnum.ANESTHETIC.getMedicineName(),
            MedicineEnum.ANTACID.getMedicineName(),
            MedicineEnum.ANTIDEPRESSANT.getMedicineName(),
            MedicineEnum.ANTIBIOTIC.getMedicineName()
        );
    }
}
