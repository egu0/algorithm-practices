package im.engure.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

        try {
            if (i1 == null || i2 == null) {
                throwNullException();
            }

            if (i1.getClass() != i2.getClass()) {
                throwNotSameTypeException(i1.getClass(), i2.getClass());
            }

            if (!i1.equals(i2)) {
                throwNotEqualException(i1, i2);
            }

            System.out.println("Assertion passed, " + i1 + " == " + i2);

        } catch (Exception e) {
            log.error("斷言失敗", e);
        }
    }

    private static void throwNotSameTypeException(Class<?> c1, Class<?> c2) {
        throw new RuntimeException("inputs are not same type: " + c1 + " , " + c2);
    }

    private static void throwNullException() {
        throw new RuntimeException("null field found.");
    }

    private static void throwNotEqualException(Object o1, Object o2) {
        throw new RuntimeException("equal-assertion error: " + o1 + " != " + o2);
    }

}
