package org.christinagorina;

import org.christinagorina.model.Role;
import org.christinagorina.model.User;
import static org.christinagorina.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final User USER = new User(USER_ID, "User1", "user1@gmail.com", "password", Role.USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admpassword", Role.ADMIN);
}



