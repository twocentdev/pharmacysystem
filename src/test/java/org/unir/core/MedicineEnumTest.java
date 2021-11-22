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

        Assertions.assertEquals(new Integer(0), painkiller.getMedicineID());
        Assertions.assertEquals(new Integer(1), analeptic.getMedicineID());
        Assertions.assertEquals(new Integer(2), anesthetic.getMedicineID());
        Assertions.assertEquals(new Integer(3), antiacid.getMedicineID());
        Assertions.assertEquals(new Integer(4), antidepressant.getMedicineID());
        Assertions.assertEquals(new Integer(5), antibiotic.getMedicineID());

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
        MedicineEnum medicine = MedicineEnum.valueOf("PAINKILLER");
        Assertions.assertEquals(MedicineEnum.PAINKILLER, medicine);
        medicine = MedicineEnum.valueOf("ANTIBIOTIC");
        Assertions.assertEquals(MedicineEnum.ANTIBIOTIC, medicine);
        medicine = MedicineEnum.valueOf("antacid".toUpperCase());
        Assertions.assertEquals(MedicineEnum.ANTACID, medicine);
        medicine = MedicineEnum.valueOf("Antibiotic".toUpperCase());
        Assertions.assertEquals(MedicineEnum.ANTIBIOTIC, medicine);

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
