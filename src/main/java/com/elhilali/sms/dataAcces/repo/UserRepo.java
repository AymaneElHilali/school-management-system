package com.elhilali.sms.dataAcces.repo;

import com.elhilali.sms.dataAcces.entity.User;

public interface UserRepo {

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
