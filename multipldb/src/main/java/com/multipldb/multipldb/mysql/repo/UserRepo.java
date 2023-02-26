package com.multipldb.multipldb.mysql.repo;

import com.multipldb.multipldb.mysql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>
{

}
