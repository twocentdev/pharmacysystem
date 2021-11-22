package org.unir.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedicineTypeTest {

    @Test
    public void getMedicineName () {
        MedicineEnum painkiller = MedicineEnum.PAINKILLER;
        MedicineEnum analeptic = MedicineEnum.ANALEPTIC;
        MedicineEnum anesthetic = MedicineEnum.ANESTHETIC;
        MedicineEnum antiacid = MedicineEnum.ANTIACID;
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
        Assertions.assertEquals(MedicineEnum.ANTIACID.getMedicineName(), antiacid.getMedicineName());
        Assertions.assertEquals(MedicineEnum.ANTIDEPRESSANT.getMedicineName(), antidepressant.getMedicineName());
        Assertions.assertEquals(MedicineEnum.ANTIBIOTIC.getMedicineName(), antibiotic.getMedicineName());
    }
}
