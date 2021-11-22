package org.unir.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This test class shows how DistributorEnum works. It is similar to MedicineEnumTest.
 */
public class DistributorEnumTest {

    /**
     * This is a basic test that shows if the basic construction and values work well.
     */
    @Test
    public void getMedicineName () {
        DistributorEnum cofarma = DistributorEnum.COFARMA;
        DistributorEnum empsephar = DistributorEnum.EMPSEPHAR;
        DistributorEnum cemefar = DistributorEnum.CEMEFAR;

        Assertions.assertEquals(new Integer(0), cofarma.getDistributorID());
        Assertions.assertEquals(new Integer(1), empsephar.getDistributorID());
        Assertions.assertEquals(new Integer(2), cemefar.getDistributorID());

        Assertions.assertEquals(DistributorEnum.COFARMA.getDistributorName(), cofarma.getDistributorName());
        Assertions.assertEquals(DistributorEnum.EMPSEPHAR.getDistributorName(), empsephar.getDistributorName());
        Assertions.assertEquals(DistributorEnum.CEMEFAR.getDistributorName(), cemefar.getDistributorName());
    }

    /**
     * This test shows the proper way to 'build' a MedicineEnum taking a text as an input.
     * In order to build properly a MedicineEnum you can use "String".toUpperCase();
     */
    @Test
    public void buildByText() {
        DistributorEnum distributor = DistributorEnum.valueOf("COFARMA");
        Assertions.assertEquals(DistributorEnum.COFARMA, distributor);
        distributor = DistributorEnum.valueOf("EMPSEPHAR");
        Assertions.assertEquals(DistributorEnum.EMPSEPHAR, distributor);
        distributor = DistributorEnum.valueOf("cofarma".toUpperCase());
        Assertions.assertEquals(DistributorEnum.COFARMA, distributor);
        distributor = DistributorEnum.valueOf("Cofarma".toUpperCase());
        Assertions.assertEquals(DistributorEnum.COFARMA, distributor);

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> DistributorEnum.valueOf("Cofarma")
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> DistributorEnum.valueOf("COFARMA".toLowerCase())
        );Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> DistributorEnum.valueOf("cofarma")
        );
        Assertions.assertThrows(
            NullPointerException.class,
            () -> DistributorEnum.valueOf(null)
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> DistributorEnum.valueOf("")
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> DistributorEnum.valueOf("NoDistributor")
        );
    }

    /**
     * This tests shows how to check if a given String has a value in MedicineEnum.values(), avoiding NullPointerExcetion.
     */
    @Test
    public void checkIfMedicineEnumExistsWithoutNullPointerException () {
        Assertions.assertTrue(DistributorEnum.exists("cofarma"));
        Assertions.assertTrue(DistributorEnum.exists("Cofarma"));
        Assertions.assertTrue(DistributorEnum.exists("COFARMA"));
        Assertions.assertTrue(DistributorEnum.exists("coFaRma"));
        Assertions.assertFalse(DistributorEnum.exists("other"));
    }
}
