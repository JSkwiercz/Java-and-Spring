package com.company.io.repositories;

import com.company.io.User;

public interface UserRepository {
    User findByName (String name);
    User save (User user);
    User update (User user);
}
