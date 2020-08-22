package org.christinagorina.util;

import javassist.NotFoundException;

public class ValidationUtil {
    private ValidationUtil() {
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        checkException(object != null, "id=" + id);
        return object;
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkException(object != null, msg);
        return object;
    }

    public static void checkException(boolean found, String msg) {
        if (!found) {
            try {
                throw new NotFoundException("Not found entity with " + msg);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
