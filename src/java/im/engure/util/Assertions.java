package im.engure.util;

public class Assertions {

    public static void assertTruth(Boolean bool) {
        if (bool == null) {
            throwNullException();
        }

        if (!bool) {
            throw new RuntimeException("Non-true.");
        }
    }

    public static void assertSame(Object i1, Object i2) {
        if (i1 == i2) {
            return;
        }

        try {

            if (i1 == null || i2 == null) {
                throwNullException();
            }

            if (i1.equals(i2)) {
                throwNotEqualException(i1, i2);
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private static void throwNullException() {
        throw new RuntimeException("null field found.");
    }

    private static void throwNotEqualException(Object o1, Object o2) {
        throw new RuntimeException("Equal-assertion Error: " + o1 + " != " + o2);
    }

}
