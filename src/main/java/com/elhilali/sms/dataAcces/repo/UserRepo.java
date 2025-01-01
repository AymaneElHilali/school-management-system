package com.elhilali.sms.dataAcces.repo;

public interface UserRepo {

    boolean existsByEmail(String email);
}
