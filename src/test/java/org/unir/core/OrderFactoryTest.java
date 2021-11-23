package org.unir.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class OrderFactoryTest {

    private OrderFactory factory;

    @BeforeEach
    public void setUp () {
        factory = OrderFactory.getInstance();
    }

    /**
     * This test gets two (2) instances of OrderFactory in order to check that singleton works.
     */
    @Test
    public void getFactorySingleton () {
        OrderFactory factory = OrderFactory.getInstance();
        OrderFactory factory2 = OrderFactory.getInstance();
        Assertions.assertEquals(
            factory.hashCode(),
            factory2.hashCode()
        );
    }

    /**
     * This test checks all possible validations when trying to build an Order correctly.
     */
    @Test
    public void validateOrderCorrect () {
        Order correctOrder;
        try {
            Assertions.assertTrue(MedicineEnum.exists("PAINKILLER"));
            correctOrder = factory.create("sudorixina", "PAINKILLER", 1, "Cofarma", "branch");
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("SUDORIZINA", "Painkiller", 2, "COFARMA", "branch");
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("123", "Anesthetic", 51234, "cOFarma", "branch");
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("Sudorixina", "PAINKILLER", 16, "Empsephar", "branch");
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("Sudorixina123", "Antacid", 1, "EMPSEPHAR", "branch");
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("S", "ANTACID", 32, "empSEPHAR", "branch");
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("s", "ANtacID", 25, "Cemefar", "branch");
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("1", "PAINKILLER", 128, "CEMEFAR", "branch");
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("Sa1", "PAINKILLER", 1, "cEMEfar", "branch");
            Assertions.assertNotNull(correctOrder);
        } catch (IllegalArgumentException e) {
            Assertions.fail("No exception was expected.");
        }
    }

    /**
     * This test shows how medicine name validation works.
     */
    @Test
    public void validateOrderIncorrectMedicineName () {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create(null, "PAINKILLER", 1, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("", "PAINKILLER", 1, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("$", "PAINKILLER", 1, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
    }

    /**
     * This test shows how medicine type validation works.
     */
    @Test
    public void validateOrderIncorrectMedicineType () {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", null, 1, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "", 1, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "nonExistingTypeOfMedicine", 1, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
    }

    /**
     * This test shows how amount validation works.
     */
    @Test
    public void validateOrderIncorrectAmount () {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", null, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", -1, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 0, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
    }

    /**
     * This test shows how distributor validation works.
     */
    @Test
    public void validateOrderIncorrectDistributor () {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 1, null, "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 1, "", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 1, "nonExistingDistributor", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
    }

    /**
     * This test shows how branch validation works.
     */
    @Disabled("This test case is disabled until Order.branch is correctly coded.")
    @Test
    public void validateOrderIncorrectBranch () {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 1, "Cofarma", "branch"),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
    }

    /**
     * This tests shows how to work with regular expressions in Strings.
     */
    @Test
    public void regularExp() {
        Assertions.assertTrue("sudorixina".matches("[a-z]+"));
    }
}
