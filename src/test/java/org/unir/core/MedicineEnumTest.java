package org.unir.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedicineEnumTest {

    /**
     * This is a basic test that shows if the basic construction and values work well.
     */
    @Test
    public void getMedicineName () {
        MedicineEnum painkiller = MedicineEnum.PAINKILLER;
        MedicineEnum analeptic = MedicineEnum.ANALEPTIC;
        MedicineEnum anesthetic = MedicineEnum.ANESTHETIC;
        MedicineEnum antiacid = MedicineEnum.ANTACID;
        MedicineEnum antidepressant = MedicineEnum.ANTIDEPRESSANT;
        MedicineEnum antibiotic = MedicineEnum.ANTIBIOTIC;

        Assertions.assertEquals(0, painkiller.getMedicineID());
        Assertions.assertEquals(1, analeptic.getMedicineID());
        Assertions.assertEquals(2, anesthetic.getMedicineID());
        Assertions.assertEquals(3, antiacid.getMedicineID());
        Assertions.assertEquals(4, antidepressant.getMedicineID());
        Assertions.assertEquals(5, antibiotic.getMedicineID());

        Assertions.assertEquals(MedicineEnum.PAINKILLER.getMedicineName(), painkiller.getMedicineName());
        Assertions.assertEquals(MedicineEnum.ANALEPTIC.getMedicineName(), analeptic.getMedicineName());
        Assertions.assertEquals(MedicineEnum.ANESTHETIC.getMedicineName(), anesthetic.getMedicineName());
        Assertions.assertEquals(MedicineEnum.ANTACID.getMedicineName(), antiacid.getMedicineName());
        Assertions.assertEquals(MedicineEnum.ANTIDEPRESSANT.getMedicineName(), antidepressant.getMedicineName());
        Assertions.assertEquals(MedicineEnum.ANTIBIOTIC.getMedicineName(), antibiotic.getMedicineName());
    }

    /**
     * This test shows the proper way to 'build' a MedicineEnum taking a text as an input.
     * In order to build properly a MedicineEnum you can use "String".toUpperCase();
     */
    @Test
    public void buildByText() {
        Assertions.assertEquals(MedicineEnum.PAINKILLER, MedicineEnum.valueOf("PAINKILLER"));
        Assertions.assertEquals(MedicineEnum.ANTIBIOTIC, MedicineEnum.valueOf("ANTIBIOTIC"));
        Assertions.assertEquals(MedicineEnum.ANTACID, MedicineEnum.valueOf("antacid".toUpperCase()));
        Assertions.assertEquals(MedicineEnum.ANTIBIOTIC, MedicineEnum.valueOf("Antibiotic".toUpperCase()));

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> MedicineEnum.valueOf("Painkiller")
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> MedicineEnum.valueOf("PAINKILLER".toLowerCase())
        );Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> MedicineEnum.valueOf("painkiller")
        );
        Assertions.assertThrows(
            NullPointerException.class,
            () -> MedicineEnum.valueOf(null)
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> MedicineEnum.valueOf("")
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> MedicineEnum.valueOf("NoMedicine")
        );
    }

    /**
     * This tests shows how to check if a given String has a value in MedicineEnum.values(), avoiding NullPointerExcetion.
     */
    @Test
    public void checkIfMedicineEnumExistsWithoutNullPointerException () {
        Assertions.assertTrue(MedicineEnum.exists("painkiller"));
        Assertions.assertTrue(MedicineEnum.exists("Painkiller"));
        Assertions.assertTrue(MedicineEnum.exists("PAINKILLER"));
        Assertions.assertTrue(MedicineEnum.exists("paiNkiLLer"));
        Assertions.assertFalse(MedicineEnum.exists("other"));
    }
}
