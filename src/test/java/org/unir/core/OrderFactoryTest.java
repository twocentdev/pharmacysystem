package org.unir.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
            correctOrder = factory.create("sudorixina", "PAINKILLER", 1, "Cofarma", Arrays.asList(new String[]{"dir1", "dir2"}));
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("SUDORIZINA", "Painkiller", 2, "COFARMA", Arrays.asList(new String[] {"dir1"}));
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("123", "Anesthetic", 51234, "cOFarma", Arrays.asList(new String[] {"dir2"}));
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("Sudorixina", "PAINKILLER", 16, "Empsephar", Arrays.asList(new String[] {"dir1"}));
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("Sudorixina123", "Antacid", 1, "EMPSEPHAR", Arrays.asList(new String[] {"dir1", "dir2"}));
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("S", "ANTACID", 32, "empSEPHAR", Arrays.asList(new String[] {"dir2"}));
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("s", "ANtacID", 25, "Cemefar", Arrays.asList(new String[] {"dir1", "dir2"}));
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("1", "PAINKILLER", 128, "CEMEFAR", Arrays.asList(new String[] {"dir2"}));
            Assertions.assertNotNull(correctOrder);
            correctOrder = factory.create("Sa1", "PAINKILLER", 1, "cEMEfar", Arrays.asList(new String[] {"dir2"}));
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
            () -> factory.create(null, "PAINKILLER", 1, "Cofarma", Arrays.asList(new String[] {"dir1", "dir2"})),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("", "PAINKILLER", 1, "Cofarma", Arrays.asList(new String[] {"dir1", "dir2"})),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("$", "PAINKILLER", 1, "Cofarma", Arrays.asList(new String[] {"dir1", "dir2"})),
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
            () -> factory.create("sudorixina", null, 1, "Cofarma", Arrays.asList(new String[] {"dir1", "dir2"})),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "", 1, "Cofarma", Arrays.asList(new String[] {"dir1", "dir2"})),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "nonExistingTypeOfMedicine", 1, "Cofarma", Arrays.asList(new String[] {"dir1", "dir2"})),
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
            () -> factory.create("sudorixina", "PAINKILLER", null, "Cofarma", Arrays.asList(new String[] {"dir1", "dir2"})),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", -1, "Cofarma", Arrays.asList(new String[] {"dir1", "dir2"})),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 0, "Cofarma", Arrays.asList(new String[] {"dir1", "dir2"})),
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
            () -> factory.create("sudorixina", "PAINKILLER", 1, null, Arrays.asList(new String[] {"dir1", "dir2"})),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 1, "", Arrays.asList(new String[] {"dir1", "dir2"})),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 1, "nonExistingDistributor", Arrays.asList(new String[] {"dir1", "dir2"})),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
    }

    /**
     * This test shows how branch validation works.
     */
    @Test
    public void validateOrderIncorrectDirections () {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 1, "Cofarma", null),
            "Expected factory.create() to throw an IllegalArgumentException."
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> factory.create("sudorixina", "PAINKILLER", 1, "Cofarma", Arrays.asList(new String[] {})),
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
