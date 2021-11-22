package org.unir.core;

public enum MedicineEnum {
    PAINKILLER(0, "Painkiller"),
    ANALEPTIC (1, "Analeptic"),
    ANESTHETIC(2, "Anesthetic"),
    ANTACID(3, "Antacid"),
    ANTIDEPRESSANT(4, "Antidepressant"),
    ANTIBIOTIC(5, "Antibiotic");

    private final String medicineName;
    private final Integer medicineID;

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
}
