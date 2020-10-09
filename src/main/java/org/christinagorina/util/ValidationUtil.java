package org.christinagorina.util;

import javassist.NotFoundException;
import org.christinagorina.model.AbstractBaseEntity;
import org.christinagorina.to.BaseTo;
import org.christinagorina.util.exeption.IllegalRequestDataException;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

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

    public static void checkNew(AbstractBaseEntity bean) {
        if (!bean.isNew()) {
            throw new IllegalRequestDataException(bean + " must be new (id=null)");
        }
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

    public static void assureIdConsistent(AbstractBaseEntity entity, int id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.id() != id) {
            throw new IllegalArgumentException(entity + " must be with id=" + id);
        }
    }

    public static void assureIdConsistent(BaseTo beanTo, int id) {
        if (beanTo.isNew()) {
            beanTo.setId(id);
        } else if (beanTo.id() != id) {
            throw new IllegalArgumentException(beanTo + " must be with id=" + id);
        }
    }

    public static Throwable getRootCause(Throwable t) {
        Throwable result = t;
        Throwable cause;

        while (null != (cause = result.getCause()) && (result != cause)) {
            result = cause;
        }
        return result;
    }

    public static String getErrorResponse(BindingResult result) {
        return result.getFieldErrors().stream()
                .map(fe -> String.format("[%s] %s", fe.getField(), fe.getDefaultMessage()))
                .collect(Collectors.joining("<br>"));
    }
}
