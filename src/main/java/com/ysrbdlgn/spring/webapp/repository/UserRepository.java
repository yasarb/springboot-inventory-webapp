package com.ysrbdlgn.spring.webapp.repository;

import com.ysrbdlgn.spring.webapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
