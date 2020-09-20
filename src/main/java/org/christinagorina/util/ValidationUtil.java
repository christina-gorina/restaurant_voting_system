package org.christinagorina.util;

import javassist.NotFoundException;
import org.christinagorina.model.AbstractBaseEntity;

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

    public static void checkNew(AbstractBaseEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalArgumentException(entity + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(AbstractBaseEntity entity, int id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.id() != id) {
            throw new IllegalArgumentException(entity + " must be with id=" + id);
        }
    }
}
