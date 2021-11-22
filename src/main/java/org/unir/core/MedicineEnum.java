package org.unir.core;

public enum MedicineEnum {
    PAINKILLER(0, "Painkiller"),
    ANALEPTIC (1, "Analeptic"),
    ANESTHETIC(2, "Anesthetic"),
    ANTIACID(3, "Antiacid"),
    ANTIDEPRESSANT(4, "Antidepressant"),
    ANTIBIOTIC(5, "Antibiotic");

    private String medicineName;
    private Integer medicineID;

    private MedicineEnum(Integer medicineID, String medicineName ) {
        this.medicineName = medicineName;
        this.medicineID = medicineID;
    }

    public Integer getMedicineID() {
        return this.medicineID;
    }

    public String getMedicineName() {
        return this.medicineName;
    }
}
