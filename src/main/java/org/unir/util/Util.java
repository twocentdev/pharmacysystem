package org.unir.util;

/**
 * This class contains some methods that may be util in various situations.
 */
public class Util {

    /**
     * This function returns converts a String into an int, it catches the exception if occurs and returns 0.
     *
     * @param value the given String to parse into an int
     * @return if success the int converted, otherwise 0.
     */
    public static int parseInt (String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e ) {
            return 0;
        } catch (Exception e) {
            System.out.println("An unexpected exception occurred.");
            return 0;
        }
    }

    /**
     * This function returns converts a String into an int, it catches the exception if happens and returns a default value.
     * @param value the given String to parse into an int
     * @param _default the default value if an exception occurs
     * @return if success the int converted, otherwise the default value.
     */
    public static int parseInt (String value, int _default) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e ) {
            return _default;
        } catch (Exception e) {
            System.out.println("An unexpected exception occurred.");
            return _default;
        }
    }
}
