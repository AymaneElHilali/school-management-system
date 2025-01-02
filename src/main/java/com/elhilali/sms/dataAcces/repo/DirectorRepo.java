package com.elhilali.sms.dataAcces.repo;

import com.elhilali.sms.dataAcces.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepo extends JpaRepository<Director,Long>,UserRepo{

}
