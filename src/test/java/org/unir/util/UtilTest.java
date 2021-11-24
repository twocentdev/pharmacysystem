package org.unir.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    public void correctParse () {
        Assertions.assertEquals(-1, Util.parseInt("-1"));
        Assertions.assertEquals(-1, Util.parseInt("-1", 0));
        Assertions.assertEquals(0, Util.parseInt("0"));
        Assertions.assertEquals(0, Util.parseInt("0", 0));
        Assertions.assertEquals(1, Util.parseInt("1"));
        Assertions.assertEquals(1, Util.parseInt("1", 0));
    }

    @Test
    public void incorrectParse () {
        Assertions.assertEquals(0, Util.parseInt("a"));
        Assertions.assertEquals(-1, Util.parseInt("a", -1));
        Assertions.assertEquals(0, Util.parseInt("a", 0));
        Assertions.assertEquals(1, Util.parseInt("a", 1));

    }
}
