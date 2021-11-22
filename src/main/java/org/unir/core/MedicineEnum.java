package org.unir.core;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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
}
